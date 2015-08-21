package com.job5156.foshan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import org.hibernate.Session;

import com.job5156.server.FileLog;
import com.job5156.server.SessionManager;
import com.job5156.util.StringUtil;

public class DownResume2 {
	
	private static final String FILE_PATH = "com.job5156.foshan.DownResume";
	private static final String url = "http://www.0757rc.com/ent/showresume.aspx?jwsn=";
	private static final String search = "http://www.0757rc.com/search/resume_search_result.aspx";

	private static int count = 0;
	private static boolean downFlag = true;
	
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
			loadHtml.setUrl(search);
			String content = loadHtml.getHtmlByParam(new String[][]{{"datescale", "90"},{"jcity2Hidden","101400"}});
			int totalPage = getTotalPageCount(content);
			String viewState = HtmlMethodImpl.getValue(content, "<input type=\"hidden\" name=\"__VIEWSTATE\" id=\"__VIEWSTATE\" value=\"", "\" />");
			if(totalPage > 0){
				downResumeData(content, loadHtml, con);
				for(int i=2; i<=totalPage; i++){
					if(!downFlag)break;
					System.out.println("------------------当前第 "+i+" 页-----------------");
					loadHtml.setUrl(search);
					content = loadHtml.getHtmlByParam(new String[][]{{"datescale", "90"},{"jcity2Hidden","101400"},{"__EVENTTARGET","AspNetPager1"},{"__EVENTARGUMENT",String.valueOf(i)},{"__VIEWSTATE", viewState}});
					downResumeData(content, loadHtml, con);
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
	
	/**
	 * 下载保存搜索列表中的简历数据
	 * @param searchList
	 */
	public static void downResumeData(String searchList, HtmlMethodImpl loadHtml, Connection con){
		String listData = getListData(searchList);
		Vector vector = getUserIdArray(listData);
		if(vector.size() > 0){
			for(int i=0; i<vector.size(); i++){
				int userId = StringUtil.parseInt(vector.get(i));
				if(!checkData(con, userId)){
					loadHtml.setUrl(url+userId);
					String content = loadHtml.getHtml();
					if(content.indexOf("点击按钮查看该求职者联系方式") != -1){
						System.out.println("==========正在下载数据 用户ID:"+userId+"========");
						String viewState = HtmlMethodImpl.getValue(content, "<input type=\"hidden\" name=\"__VIEWSTATE\" id=\"__VIEWSTATE\" value=\"", "\" />");
						content = loadHtml.getHtmlByParamAndCode(new String[][]{{"__VIEWSTATE",viewState},{"Button2","查看联系方式"}}, "GBK");
					}else if(content.indexOf("对不起，您每天最多只能查看<font color=\"#FF0000\"><span id=\"MaxViewResumetxt\">99</span>") != -1){
						System.out.println("==================每天下载 99 份简历结束=============");
						downFlag = false;
						break;
					}else if(content.indexOf("对不起，您每天最多只能查看<font color=\"#FF0000\"><span id=\"MaxViewResumetxt\">60</span>") != -1){
						System.out.println("==================每天下载 60 份简历结束=============");
						downFlag = false;
						break;
					}
					if(checkPhone(content) == 1){
						count ++;
						content = HtmlMethodImpl.getValue(content, "基本资料", "<div id=\"sendyq\">");
						System.out.println("--------------正在保存数据--------------");
						insertData(con, content, userId);
						System.out.println("--------------数据保存成功--------------");
					}else{
						System.out.println("--------------邮箱不存在,取消下载--------------");
					}
				}else{
					System.out.println("数据已存在!取消下载!");
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
		return HtmlMethodImpl.getValue(searchListContent, "操作", "<input type=\"submit\" value=\"go\"");
	}
	
	/**
	 * 根据循环数据，取出用户ID
	 * @param dataContent
	 * @return
	 */
	public static Vector getUserIdArray(String dataContent){
		Vector vector = new Vector();
		while(true){
			String userId = HtmlMethodImpl.getValue(dataContent, "class=\"a01\" href=\"/ent/showresume.aspx?jwsn=", "&amp;keyword=\" target=\"_blank\">");
			if(!"".equals(userId)){
				vector.add(userId);
				String inputStr = "class=\"a01\" href=\"/ent/showresume.aspx?jwsn="+userId+"&amp;keyword=\" target=\"_blank\">";
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
		String sql = "insert into FoShan_1(resumeContent, userId) values(?,?)";
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
		String sql = "select count(*) from FoShan where userId = "+userId;
		check = hasData(con, sql);
		if(!check)
		{
			sql = "select count(*) from FoShan_1 where userId = "+userId;
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
	
	
	
	public static String getLoginUrl(String userName, String password){
		String visitUrl = "http://www.0757rc.com";
		String loginUrl = "";
		loginUrl = visitUrl+"/index.aspx?__EVENTTARGET=login&__EVENTARGUMENT=&LoginID="+userName+"&LoginPwd="+password+"&lx=2";
		return loginUrl;
	}
}
