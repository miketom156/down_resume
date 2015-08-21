package com.job5156.foshan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.Session;

import com.job5156.server.FileLog;
import com.job5156.server.SessionManager;

public class DownResume1 {
	
	private static final String FILE_PATH = "com.job5156.foshan.DownResume";
	private static final String url = "http://www.0757rc.com/ent/showresume.aspx?jwsn=";
	//private static final String loginUrl = "http://www.0757rc.com/index.aspx?__EVENTTARGET=login&__EVENTARGUMENT=&__VIEWSTATE=/wEPDwULLTEwMzE3OTA3OTdkGAEFHl9fQ29udHJvbHNSZXF1aXJlUG9zdEJhY2tLZXlfXxYBBQVsb2dpbjFRYqsVsiMhsPFinbBSc63PQ2pN&LoginID=zhengying&LoginPwd=6406015&lx=2";

	public static void main(String[] args)
	{
		Session session = null;
		Connection con = null;
		HtmlMethodImpl loadHtml = null;
		try{
			String loginUrl = getLoginUrl("zhengying", "6406015");
			loadHtml = new HtmlMethodImpl(true, loginUrl);
			session = SessionManager.currentSession();
			con = session.connection();
			int j = 8400;
			int count = 0;
			for(int userid = 908901; userid < 1000000; userid++)
			{
				if(!hasData(con, userid)){
					loadHtml.setUrl(url+userid);
					String content = loadHtml.getHtml();
					if(checkExist(content) == 1){
						if(content.indexOf("点击按钮查看该求职者联系方式") != -1){
							System.out.println("==============正在下载第 "+(++j)+" 条数据 用户ID:"+userid+"============");
							String viewState = HtmlMethodImpl.getValue(content, "<input type=\"hidden\" name=\"__VIEWSTATE\" id=\"__VIEWSTATE\" value=\"", "\" />");
							content = loadHtml.getHtmlByParamAndCode(new String[][]{{"__VIEWSTATE",viewState},{"Button2","查看联系方式"}}, "GBK");
						}else if(content.indexOf("对不起，您每天最多只能查看<font color=\"#FF0000\"><span id=\"MaxViewResumetxt\">99</span>") != -1){
							System.out.println("==================每天下载 99 份简历结束=============");
							break;
						}else if(content.indexOf("对不起，您每天最多只能查看<font color=\"#FF0000\"><span id=\"MaxViewResumetxt\">60</span>") != -1){
							System.out.println("==================每天下载 60 份简历结束=============");
							break;
						}
						if(checkEmail(content) == 1){
							count ++;
							content = HtmlMethodImpl.getValue(content, "基本资料", "<div id=\"sendyq\">");
							System.out.println("--------------正在保存第 "+j+" 条数据--------------");
							insertData(con, content, userid);
							System.out.println("--------------数据保存成功--------------");
						}else{
							System.out.println("--------------第 "+j+" 条数据邮箱不存在,取消下载--------------");
						}
					}else{
						System.out.println("==============第 "+(++j)+" 条用户数据不存在,取消下载============");
					}
				}
			}
			FileLog.logSystem(FILE_PATH+"佛山简历每天下载结束 下载简历"+count+"份");
		}catch(Exception e){
			loadHtml.release();
			FileLog.logDebug(FILE_PATH+".main()=="+e);
			e.printStackTrace();
		}finally{
			try {
				if(con != null){
					con.close();
					con = null;
				}
				loadHtml.release();
			} catch (SQLException e) {
				FileLog.logDebug(FILE_PATH+".main()=="+e);
				e.printStackTrace();
			}
		}
	}
	
	public static int checkEmail(String content){
		int flag = 1; //email存在
		String email = HtmlMethodImpl.getValue(content, "<span id=\"email\">", "</span>");
		if("".equals(email)){
			flag = 2; //email不存在
		}
		return flag;
	}
	
	public static int checkExist(String content){
		int flag = 1; //简历存在
		if(content.indexOf("该简历不存在，或已被管理员删除") != -1){
			flag = 2;
		}
		return flag;
	}
	
	public static void insertData(Connection con, String content, int userId){
		String sql = "insert into FoShan(resumeContent, userId) values(?,?)";
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
		String sql = "select count(*) from FoShan where userId = "+userId;
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
	
	public static String getLoginUrl(String userName, String password){
		String visitUrl = "http://www.0757rc.com";
		String loginUrl = "";
		loginUrl = visitUrl+"/index.aspx?__EVENTTARGET=login&__EVENTARGUMENT=&LoginID="+userName+"&LoginPwd="+password+"&lx=2";
/*		String content = URLUtil.getHtml(visitUrl);
		if(content != null && !"".equals(content)){
			//content = HtmlLoader.getValue(content, "<input type=\"hidden\" name=\"__VIEWSTATE\"", "</div>");
			//String viewState = HtmlLoader.getValue(content, "id=\"__VIEWSTATE\" value=\"", "\" />");
			//if(!"".equals(viewState)){
			//	loginUrl = visitUrl+"/index.aspx?__EVENTTARGET=login&__EVENTARGUMENT=&__VIEWSTATE="+viewState+"&LoginID="+userName+"&LoginPwd="+password+"&lx=2";
			//}
			loginUrl = visitUrl+"/index.aspx?__EVENTTARGET=login&__EVENTARGUMENT=&LoginID="+userName+"&LoginPwd="+password+"&lx=2";
		}*/
		return loginUrl;
	}
}
