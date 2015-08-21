package com.job5156.jiansu91job;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
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

//分析数据库生成html文件 
public class CopyOfAnalysis2LocalDB {

	private static final String FILE_PATH = "com.job5156.jiansu91job.Analysis2LocalDB";

	/**
	 * @Description: TODO
	 * @param @param args
	 * @return void
	 * @throws
	 */
	public static void main(String[] args) {
		Session session = null;
		try {
			session = SessionManager.currentSession();
			Connection con = session.connection();
            test91Login test=new test91Login();
			int dataLoadNumber = 1000;
			int recordCount = getRecordCount(con);
			// int recordCount=300; 499
			int allPage = recordCount > 0 ? 1 : 0;
			if (recordCount > dataLoadNumber) {
				allPage = recordCount / dataLoadNumber + ((recordCount % dataLoadNumber == 0) ? 0 : 1);
			}
			System.out.println("----------------一共需要处理 ("+recordCount+") 条数据,分 ("+allPage+") 批处理-----------------");
			System.out.println("开始处理数据=======");
			int m = 0;
			for (int n = 499; n < allPage; n++) {
				System.out.println("---处理第" + n + "页数据－－－－－－－－－－－－－");
				List list = getResumeData(con, n * dataLoadNumber, dataLoadNumber);
				if (list != null && list.size() > 0) {
					Object[] data = null;
					for (int i = 0; i < list.size(); i++) {
						data = (Object[]) list.get(i);
						Object content = data[0];
						Object filaName = data[2];
						String spec=test.getValue(content.toString(), "<span id=\"Pe17\">", "</span>");
						int flag=InsertProfession(con,spec,Integer.valueOf(filaName.toString()));
						System.out.println(flag>0?"插入成功":"插入失败");

					}
				}
				session.flush();
				session.clear();
			}
			System.out.println("数据处理完毕=======");
		} catch (Exception e) {
			FileLog.logDebug(FILE_PATH + ".main()" + e);
		} finally {
			if (session != null) {
				session.close();
				session = null;
			}
		}
	}

	public static int getRecordCount(Connection con) {
		int count = 0;
		Statement st = null;
		ResultSet rs = null;
		try {
			String sql = "select count(*) from jiansu where resume_content is not null ";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs != null) {
				while (rs.next()) {
					count = rs.getInt(1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (st != null) {
					st.close();
					st = null;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return count;
	}

	public static List getResumeData(Connection con, int start, int end) {
		List list = new ArrayList();
		Statement st = null;
		ResultSet rs = null;
		try {
			String sql = "select resume_content, user_id, id from jiansu where  id >"+start+" and resume_content is not null order by id asc  limit "  + end;
			// System.out.println(sql);
			// String sql="SELECT resume_content,user_id,id from jiansu limit 300";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs != null) {
				while (rs.next()) {
					Object[] data = new Object[3];
					data[0] = rs.getString(1);
					data[1] = StringUtil.getNotNullStr(rs.getString(2));
					data[2] = StringUtil.getNotNullStr(rs.getString(3));
					list.add(data);
					data = null;
				}
			}
			System.out.println("现在 开始处理数据" + list.size() + "条－－－－－－－－－－－－－－－－－－");
		} catch (Exception e) {
			FileLog.logDebug(FILE_PATH + ".getResumeData()" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (st != null) {
					st.close();
					st = null;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return list;
	}
	
	public static int InsertProfession(Connection con, String profession,Integer id) {
		int count = 0;
		Statement st = null;
		try {
			String sql = "UPDATE jiansu SET  profession='"+profession+"' WHERE id="+id;
			st = con.createStatement();
			count = st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null) {
					st.close();
					st = null;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return count;
	}
}
