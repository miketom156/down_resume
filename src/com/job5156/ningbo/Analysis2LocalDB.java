package com.job5156.ningbo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.job5156.server.EntityManager;
import com.job5156.server.FileLog;
import com.job5156.server.SessionManager;
import com.job5156.util.StringUtil;

public class Analysis2LocalDB {

	private static final String FILE_PATH = "com.job5156.ningbo.Analysis2LocalDB";
	
	public static void main(String[] args){
		Session session = null;
		try{
			session = SessionManager.currentSession();
			Connection con = session.connection();
			PageAnalyzeTools analysis = new PageAnalyzeTools();
			NingBoResume NB = null;
			String targetUrl = "jdbc:mysql://192.168.2.187/changsha?user=root&password=123&zeroDateTimeBehavior=convertToNull";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con2 = DriverManager.getConnection(targetUrl);
			int dataLoadNumber =1000;
			int recordCount = getRecordCount(con2);
			int allPage = recordCount > 0 ? 1 : 0;
			if(recordCount > dataLoadNumber){
				allPage = recordCount / dataLoadNumber + ((recordCount % dataLoadNumber == 0) ? 0 : 1);	
			}
			System.out.println("----------------一共需要处理 ("+recordCount+") 条数据,分 ("+allPage+") 批处理-----------------");
			System.out.println("开始处理数据=======");
			int m=0;
//			allPage=1;//测试前1000条记录。测试专用
			for(int n=0; n<allPage; n++){
				List list = getResumeData(con2, n*dataLoadNumber, dataLoadNumber);
				if(list != null && list.size() > 0){
					System.out.println("-----------正在保存第 "+(n)+" 批数据-----------");
					Object[] data = null;
					for(int i=0; i<list.size(); i++){
						data = (Object[])list.get(i);
						if(data != null){
							System.out.println("-----------正在保存第 "+(++m)+" 条数据-----------");
							NB = new NingBoResume();
							analysis.setPageHtml(StringUtil.getNotNullStr(data[0]));
							NB.setUserId(StringUtil.getNotNullStr(data[1]));
							for(int j=0; j<analysis.splitFormValue.length; j++){
								String value = "";
								analysis.reSetPageHtml(analysis.splitFormValue[j][0]);
								if(j == 8 || j == 9 || j==12){
									value = analysis.getValue(analysis.splitFormValue[j][1], analysis.splitFormValue[j][2], true);
								}else{
									value = analysis.getValue(analysis.splitFormValue[j][1], analysis.splitFormValue[j][2]);
								}
								if(j != 0){
									value = value.replaceAll(" ", "");
									value = value.replaceAll("--", "");
									value = StringUtil.getGBKStr(value);
								}
								analysis.setValue(j, NB, value);
							}
							EntityManager.saveEntity(NB, session);
							System.out.println("-----------第 "+(m)+" 条数据保存成功-----------");
						}
					}
					list=null;
					session.flush();
					session.clear();
				}
			}
			System.out.println("数据处理结束=========");
		}catch(Exception e){
			FileLog.logDebug(FILE_PATH+".main()"+e);
		}finally{
			if(session != null){
				session.close();
				session = null;
			}
		}
	}
	
	public static int getRecordCount(Connection con){
		int count = 0;
		Statement st = null;
		ResultSet rs = null;
		try{
//			String sql = "select count(*) from NingBo where id>332000";
			String sql = "select count(*) from NingBo";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs != null){
				while(rs.next()){
					count = rs.getInt(1);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs != null){
					rs.close();
					rs = null;
				}
				if(st != null){
					st.close();
					st = null;
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return count;
	}
	
	public static List getResumeData(Connection con, int start, int end){
		List list = new ArrayList();
		Statement st = null;
		ResultSet rs = null;
		try{
			String sql = "select resumeContent, userCode from NingBo order by id asc limit "+start+","+end;
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs != null){
				while(rs.next()){
					Object[] data = new Object[2];
					data[0] = rs.getString(1);
					data[1] = StringUtil.getNotNullStr(rs.getString(2));
					list.add(data);
					data = null;
				}
			}
		}catch(Exception e){
			FileLog.logDebug(FILE_PATH+".getResumeData()"+e);
		}finally{
			try{
				if(rs != null){
					rs.close();
					rs = null;
				}
				if(st != null){
					st.close();
					st = null;
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return list;
	}
}
