package com.job5156.jiansu91job;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import org.apache.commons.httpclient.NameValuePair;
import org.hibernate.Session;

import com.job5156.foshan.HtmlMethodImpl;
import com.job5156.server.FileLog;
import com.job5156.server.SessionManager;
import com.job5156.url.HtmlLoader;
import com.job5156.util.StringUtil;

public class DownResume {
	
	private static final String FILE_PATH = "com.job5156.jiansu91job.DownResume";
	private static final String resumeUrl = "http://www.91job.gov.cn/manage/USC/upm/upm003a.ASPX?type=U&personid=";
	private static final String searchUrl = "http://www.91job.gov.cn/manage/USC/USC001.aspx?a1=USC&a2=USC001&xb=0&zy=&xldm=&xx=";
	private static final String loginUrl = "http://www.91job.gov.cn/manage/login.aspx";
	String resumerUr1="http://www.91job.gov.cn/manage/upm/upm003a.ASPX?type=U&amp;personid=";

	private static int count = 0;
	private static boolean downFlag = true;
	
	public static void main(String[] args)
	{
		Session session = null;
		Connection con = null;
		HtmlMethodImpl loadHtml = null;
		try{
			String loginUrl = getLoginUrl("zhitongren", "duzhilei123","6vtx");
			loadHtml = new HtmlMethodImpl(true, loginUrl);
			session = SessionManager.currentSession();
			con = session.connection();
			loadHtml.setUrl(searchUrl);
			String content = loadHtml.getHtmlByParam(new String[][]{{"drpUpo9", "110030"}});//本科生的解析
			//int totalPage = getTotalPageCount(content);
			String viewState = HtmlMethodImpl.getValue(content, "<input type=\"hidden\" name=\"__VIEWSTATE\" id=\"__VIEWSTATE\" value=\"", "\" />");
			//if(totalPage > 0){
				downResumeData(content, loadHtml, con);
			//	for(int i=2; i<=totalPage; i++){
					//if(!downFlag)break;
					//System.out.println("------------------当前第 "+i+" 页-----------------");
					//loadHtml.setUrl(searchUrl);
					//content = loadHtml.getHtmlByParam(new String[][]{{"datescale", "90"},{"jcity2Hidden","101400"},{"__EVENTTARGET","AspNetPager1"},/*{"__EVENTARGUMENT",String.valueOf(i)}*/{"__VIEWSTATE", viewState}});
					//downResumeData(content, loadHtml, con);
			//	}
			//}
			FileLog.logSystem(FILE_PATH+"江苏高校简历每天下载结束 下载简历"+count+"份");
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
	
	/**
	 * 下载保存搜索列表中的简历数据
	 * @param searchList
	 */
	public static void downResumeData(String searchList, HtmlMethodImpl loadHtml, Connection con){
		String listData = getListData(searchList);
		Vector vector = getUserIdArray(listData);
		if (vector.size() > 0) {
			for (int i = 0; i < vector.size(); i++) {
				int userId = StringUtil.parseInt(vector.get(i));
				if (!checkData(con, userId)) {
					loadHtml.setUrl(resumeUrl + userId);
					String content = loadHtml.getHtml();
				}
			}
		}
	}
	
	/**
	 * 根据搜索结果列表 获取总页数
	 * @param searchListContent
	 * @return
	 */
	public static int getTotalPageCount(String searchListContent){
		int page = 0;
		String pageStr = HtmlMethodImpl.getValue(searchListContent, "后页</a>", "尾页");
		if(pageStr != "" && !"".equals(pageStr)){
			pageStr = HtmlMethodImpl.getValue(pageStr, "<a href=\"javascript:__doPostBack('AspNetPager1','", "')\" style=\"margin-right:5px;\">");
			page = StringUtil.parseInt(pageStr);
		}
		return page;
	}
	
	/**
	 * 获取搜索结果列表中的循环数据
	 * @param searchListContent
	 * @return
	 */
	
	
	public static String getListData(String searchListContent){
		String start="<input type=\"submit\" name=\"ctl00$ContentPlaceHolder4$Button1\" value=\"确定\" id=\"ctl00_ContentPlaceHolder4_Button1\" class=\"Button\">";
		String end="批量选择";
		return HtmlMethodImpl.getValue(searchListContent, start,end);
	}
	
	/**
	 * 根据循环数据，取出用户ID
	 * @param dataContent
	 * @return
	 */
	/*<a class='style4'  href=javascript:OpenWindow('../upm/upm003a.ASPX?type=U&personid=B813BF30AB53728A1D0DFF47DC821139&id=1',750,600)>*/
	public static Vector getUserIdArray(String dataContent){
		Vector vector = new Vector();
		while(true){
			String perId = HtmlMethodImpl.getValue(dataContent, "href=\"javascript:OpenWindow('../upm/upm003a.ASPX?type=U&amp;personid=", "&amp;id=1',750,600)\">");
			if(!"".equals(perId)){
				vector.add(perId);
				String inputStr = "href=\"javascript:OpenWindow('../upm/upm003a.ASPX?type=U&amp;personid="+perId+"&amp;id=1',750,600)\">";
				int pos = dataContent.indexOf(inputStr);
				if(pos == -1)break;
				dataContent = dataContent.substring(pos+inputStr.length());
			}else{
				break;
			}
		}
		return vector;
	}
	
	private static int checkPhone(String content){
		int flag = 0;  //手机号码不存在
		String phone = HtmlMethodImpl.getValue(content, "<span id=\"mobile\">", "</span>");
		if(!"".equals(phone) && phone.startsWith("1")){
			flag = 1;
		}
		return flag;
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
		String sql = "insert into jiansu(resume_content, user_id) values(?,?)";
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

	private static boolean checkData(Connection con, int userId){
		boolean check = false;
		String sql = "select count(*) from jiansu where userId = "+userId;
		check = hasData(con, sql);
		if(!check)
		{
			sql = "select count(*) from jiansu_1 where userId = "+userId;
			check = hasData(con, sql);
		}
		return check;
	}
	
	public static boolean hasData(Connection con, String sql){
		boolean isCheck = false;
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
	
	
	
	public static String getLoginUrl(String userName, String password,String checkCode){
		String loginUrl2 = "";
		loginUrl2 =loginUrl+"?txtLogin="+userName+"&txtPassworddB"+password+"&checkCode="+checkCode;
		return loginUrl2;
	}
}
