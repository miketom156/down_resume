package com.job5156.ninghai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.httpclient.NameValuePair;

import com.job5156.server.FileLog;
import com.job5156.url.HtmlLoader;
import com.job5156.util.StringUtil;

public class DownResume {
	
	private static final String FILE_PATH = "com.job5156.ninghai.DownResume";
	private static final String resumeUrl = "http://www.nbnhrc.com/hero_detail.php?hero_name=";
	private static final String searchUrl = "http://www.nbnhrc.com/hero.php?page=";
	private static final String loginUrl = "http://www.nbnhrc.com/company/login_page.php";
	
	private static int count = 0;
	private static boolean isOver = false;
	
	public static void main(String[] args)
	{
		Connection con = null;
		HtmlMethodImpl loadHtml = null;
		
		try{
			String targetUrl = "jdbc:mysql://192.168.2.187/changsha?user=root&password=123&zeroDateTimeBehavior=convertToNull";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(targetUrl);
			
			NameValuePair[] paramVal = new NameValuePair[3];
			paramVal[0] = new NameValuePair("c_login_name", "zhitong");
			paramVal[1] = new NameValuePair("c_login_pass", "2652213");
			paramVal[2] = new NameValuePair("post", "post");
			
			loadHtml = new HtmlMethodImpl(true, loginUrl, "POST", paramVal);
			loadHtml.setUrl(searchUrl+"1");
			
			String content = loadHtml.getHtmlByCode("gb2312");
			int allPage = getAllPage(content);
			
			if(allPage > 0)
			{
				downResumeData(content, loadHtml, con);
				for(int i=2; i<allPage; i++){
					if(isOver)break;
					System.out.println("------------------当前第 "+i+" 页-----------------");
					loadHtml.setUrl(searchUrl+i);
					content = loadHtml.getHtmlByCode("gb2312");
					downResumeData(content, loadHtml, con);
				}
			}
			FileLog.logSystem(FILE_PATH+"宁海简历下载结束  共下载简历:"+count+"份");
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
	 * 下载当前内容附带的简历数据
	 * @param content
	 * @param loadHtml
	 * @param con
	 */
	private static void downResumeData(String content, HtmlMethodImpl loadHtml, Connection con){
		Set idSet = getUserIdSet(content);
		if(idSet.size() > 0)
		{
			Iterator iterator = idSet.iterator();
			while(iterator.hasNext()){
				String linkName = StringUtil.getNotNullStr(iterator.next());
				if(!checkData(con, linkName)){
					loadHtml.setUrl(resumeUrl+linkName);
					String resumeContent = loadHtml.getHtmlByCode("gb2312");
					int c = 0;
					while(true)
					{
						if(c > 20)
						{
							isOver = true;
							FileLog.logSystem(FILE_PATH+"宁海简历模拟登陆异常");
							break;
						}
						if("".equals(resumeContent) || 
								resumeContent.indexOf("提示：仅限正式会员查看联系方式，会员申请电话：65585200 监督电话：65558686") != -1)
						{
							loadHtml.release();
							resumeContent = loadHtml.getHtmlByCode("gb2312");
							
							c ++;
						}else
						{
							break;
						}

					}
					if(isOver)break;
					if(isDownload(resumeContent, linkName))
					{
						resumeContent = HtmlLoader.getValue(resumeContent, "<!--end search job-->", "<img src=\"/images/blue_bottom.gif\" />");
						if(!"".equals(resumeContent))
						{
							System.out.println("=======正在保存数据----用户名:"+linkName+"....请等待=======");
							try{
								insertData(con, resumeContent, linkName);
								count ++;
								Thread.sleep(1000);
							}catch(Exception e){
								e.printStackTrace();
							}
							System.out.println("=======正在保存数据----用户ID:"+linkName+"....数据保存完毕=======");
						}
					}
				}else{
					System.out.println("数据已存在!取消下载!");
				}
			}
		}
	}
	
	private boolean checkLogin(String resumeContent, HtmlMethodImpl loadHtml){
		boolean check = false;
		int c = 0;
		try{
			while(true)
			{
				if(c > 20){isOver = true; break;}
				if(!"".equals(resumeContent) && resumeContent.indexOf("提示：仅限正式会员查看联系方式，会员申请电话：65585200 监督电话：65558686") != -1)
				{
					loadHtml.release();
					resumeContent = loadHtml.getHtmlByCode("gb2312");
					
					c ++;
				}else{
					check = true;
					break;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return check;
	}
	
	/**
	 * 判断是否简历内容
	 * @param content
	 * @return
	 */
	private static boolean isDownload(String content, String linkName){
		boolean isDown = false;
		if(!"".equals(StringUtil.getNotNullStr(content)) 
				&& content.indexOf("<a href=\"/company/msg_new.php?hero_name="+linkName+"\" target=\"_blank\"><img src=\"images/send_msg.gif\" width=\"140\" height=\"36\" border=\"0\" /></a>") != -1
				)isDown = true;
		return isDown;
	}
	
	private static void insertData(Connection con, String content, String linkName){
		String sql = "insert into NingHai(resumeContent, linkName) values(?,?)";
		PreparedStatement pstmt = null;
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, content);
			pstmt.setString(2, linkName);
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
	
	/**
	 * 判断当前用户是否已经下载
	 * @param con
	 * @param userId
	 * @return
	 */
	private static boolean checkData(Connection con, String linkName){
		boolean check = false;
		String sql = "select count(1) from NingHai where linkName = '"+linkName+"'";
		check = hasData(con, sql);
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
	/**
	 * 返回所有页数
	 * @param content
	 * @return
	 */
	private static int getAllPage(String content){
		int page = 1;
		try{
			if(!"".equals(StringUtil.getNotNullStr(content)) && content.indexOf("条 分为") != -1){
				page = StringUtil.parseInt(HtmlLoader.getValue(content, "条 分为", "页"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return page;
	}
	
	/**
	 * 返回每页的用户IDSET
	 * @param content
	 * @return
	 */
	private static Set getUserIdSet(String content){
		Set idSet = new HashSet();
		if(!"".equals(StringUtil.getNotNullStr(content)) && 
				content.indexOf("<table width=\"100%\" class=\"rep\">") != -1){
			content = HtmlLoader.getValue(content, "<table width=\"100%\" class=\"rep\">", "</table>	<div align=\"right\">");
			while(true)
			{
				String name = HtmlLoader.getValue(content, "<a href=\"hero_detail.php?hero_name=", "\" target=\"_blank\">");
				if(!"".equals(name))
				{
					idSet.add(name);
					String inputStr = "<a href=\"hero_detail.php?hero_name="+name+"\" target=\"_blank\">";
					int pos = content.indexOf(inputStr);
					if(pos == -1)break;
					content = content.substring(pos+inputStr.length());
				}else{
					break;
				}
			}
		}
		return idSet;
	}
}
