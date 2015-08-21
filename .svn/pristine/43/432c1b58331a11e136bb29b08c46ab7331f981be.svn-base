package com.job5156.jiangmen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.Session;

import com.job5156.server.FileLog;
import com.job5156.down.util.LoadHtml;
import com.job5156.server.SessionManager;

/**
 * @author yanf
 * create on 2008-9-9
 */
public class DownResume
{
	private static final String FILE_PATH = "com.job5156.jiangmen.DownResume";
	
	private static final String url = "http://www.xhrc.com.cn/person/pdisplay.asp?id=";
	private static final String loginUrl = "http://www.xhrc.com.cn/login.asp?uname=jmzhitong&pwd=654321&lb=com&act=login";

	public static void main(String[] args)
	{
		Session session = null;
		Connection con = null;
		try{
			LoadHtml loadHtml = new LoadHtml();
			loadHtml.setUrl(url);
			loadHtml.setIsLogin(true);
			loadHtml.setLoginUrl(loginUrl);
			session = SessionManager.currentSession();
			con = session.connection();
			int j = 21539;
			for(int userid = 35866; userid < 10000000; userid++)
			{
				if(!hasData(con, userid)){
					String content = loadHtml.getBigHtmlByCode(userid);
					if(checkExist(content) == 1){
						if(checkEmail(content) == 1){
							System.out.println("==============正在下载第 "+(++j)+" 条数据 用户ID:"+userid+"============");
							content = LoadHtml.getValue(content, "<body bgcolor=\"#FFFFFF\">", "<table width=\"650\" border=\"0\" id=\"table30\">");
							System.out.println("--------------正在保存第 "+j+" 条数据--------------");
							insertData(con, content, userid);
							System.out.println("--------------数据保存成功--------------");
						}
					}else{
						System.out.println("==============第 "+(++j)+" 条用户数据不存在,取消下载============");
					}
				}
			}
		}catch(Exception e){
			FileLog.logDebug(FILE_PATH+".main()=="+e);
			e.printStackTrace();
		}finally{
			try {
				if(con != null){
					con.close();
					con = null;
				}
			} catch (SQLException e) {
				FileLog.logDebug(FILE_PATH+".main()=="+e);
				e.printStackTrace();
			}
		}
	}
	
	public static int checkEmail(String content){
		int flag = 1; //email存在
		String email = LoadHtml.getValue(content, "<SPAN id=lbl_email0 style=\"COLOR: navy\"><font face=\"宋体\">", "</font></SPAN>");
		if("".equals(email)){
			flag = 2; //email不存在
		}
		return flag;
	}
	
	 public static String getSplitPageHtml(String contentHtml, String str){
		String content = "";
	    int start = -1;
	    start = contentHtml.indexOf(str);
	    if(start!=-1){
	        content = contentHtml.substring(start);
	    }
	    return content;
	 }
	
	public static int checkExist(String content){
		int flag = 1; //简历存在
		if(content.indexOf("无此人才资料！") != -1){
			flag = 2;
		}
		return flag;
	}
	
	public static void insertData(Connection con, String content, int userId){
		String sql = "insert into JiangMen(resumeContent, userId) values(?,?)";
		PreparedStatement pstmt = null;
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, content);
			pstmt.setInt(2, userId);
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
            try{
                if(pstmt != null) {
                    pstmt.close();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
	}
	
	public static boolean hasData(Connection con, int userId){
		boolean isCheck = false;
		String sql = "select count(*) from JiangMen where userId = "+userId;
		Statement st = null;
		ResultSet rs = null;
		try{
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs != null){
				while(rs.next()){
					if(rs.getInt(1) > 0)isCheck = true;
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
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return isCheck;
	}
}
