package com.job5156.foshan;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.job5156.server.FileLog;
import com.job5156.server.SessionManager;
import com.job5156.server.EntityManager;
import com.job5156.util.StringUtil;

public class Analysis2LocalDB1 {

	private static final String FILE_PATH = "com.job5156.foshan.Analysis2LocalDB";
	
	public static void main(String[] args){
		Session session = null;
		try{
			session = SessionManager.currentSession();
			Connection con = session.connection();
			PageAnalyzeTools analysis = new PageAnalyzeTools();
			PageAnalyzeToolsNew analysisNew = new PageAnalyzeToolsNew();
			FoShanResume foshan = null;
			int lastLoadId = 15827;
			
			int dataLoadNumber = 300;
			int recordCount = getRecordCount(con, lastLoadId);
			int allPage = recordCount > 0 ? 1 : 0;
			if(recordCount > dataLoadNumber){
				allPage = recordCount / dataLoadNumber + ((recordCount % dataLoadNumber == 0) ? 0 : 1);	
			}
			System.out.println("----------------一共需要处理 ("+recordCount+") 条数据,分 ("+allPage+") 批处理-----------------");
			System.out.println("开始处理数据=======");
			int m=0;
			for(int n=0; n<allPage; n++){
				List list = getResumeData(con, lastLoadId, n*dataLoadNumber, dataLoadNumber);
				if(list != null && list.size() > 0){
					Object[] data = null;
					for(int i=0; i<list.size(); i++){
						data = (Object[])list.get(i);
						if(data != null){
							if(checkExist(con, StringUtil.parseInt(data[1])))continue;
							System.out.println("-----------正在保存第 "+(++m)+" 条数据-----------");
							foshan = new FoShanResume();
							if(StringUtil.parseInt(data[2]) > 8655){
								analysisNew.setPageHtml(StringUtil.getNotNullStr(data[0]));
								foshan.setUserId(StringUtil.parseInt(data[1]));
								for(int j=0; j<analysisNew.splitFormValue.length; j++){
									analysisNew.reSetPageHtml(analysisNew.splitFormValue[j][0]);
									String value = analysisNew.getValue(analysisNew.splitFormValue[j][1], analysisNew.splitFormValue[j][2]);
									analysisNew.saveEntity(j, foshan, value);
								}
							}else{
								analysis.setPageHtml(StringUtil.getNotNullStr(data[0]));
								foshan.setUserId(StringUtil.parseInt(data[1]));
								for(int j=0; j<analysis.splitFormValue.length; j++){
									analysis.reSetPageHtml(analysis.splitFormValue[j][0]);
									String value = analysis.getValue(analysis.splitFormValue[j][1], analysis.splitFormValue[j][2]);
									analysis.saveEntity(j, foshan, value);
								}
							}
							EntityManager.saveEntity(foshan, session);
							System.out.println("-----------第 "+(m)+" 条数据保存成功-----------");
							foshan = null;
						}
					}
					session.flush();
					session.clear();
				}
			}
			analysis = null;
			System.out.println("数据处理完毕=======");
		}catch(Exception e){
			FileLog.logDebug(FILE_PATH+".main()"+e);
		}finally{
			if(session != null){
				session.close();
				session = null;
			}
		}
	}
	
	public static boolean checkExist(Connection con, int userId){
		boolean check = false;
		int count = 0;
		Statement st = null;
		ResultSet rs = null;
		try{
			String sql = "select count(*) from FoShan_Resume where userId = "+userId;
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
		if(count > 0)check = true;
		return check;
	}
	
	
	public static int getRecordCount(Connection con, int id){
		int count = 0;
		Statement st = null;
		ResultSet rs = null;
		try{
			String sql = "select count(*) from FoShan where id > "+id;
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
	
	public static List getResumeData(Connection con, int id, int start, int end){
		List list = new ArrayList();
		Statement st = null;
		ResultSet rs = null;
		try{
			String sql = "select resumeContent, userId, id from FoShan where id > "+id+" limit "+start+","+end;
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs != null){
				while(rs.next()){
					Object[] data = new Object[3];
					data[0] = rs.getString(1);
					data[1] = StringUtil.getNotNullStr(rs.getInt(2));
					data[2] = StringUtil.getNotNullStr(rs.getInt(3));
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
