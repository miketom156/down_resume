package com.job5156.job51;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.Session;

import com.job5156.server.FileLog;
import com.job5156.url.HtmlLoader;

public class DownResume1 {
	
	private static final String FILE_PATH = "com.job5156.foshan.DownResume";
	private static final String url = "http://ehire.51job.com/Candidate/ResumeViewFolder.aspx?hidSeqID=2320460770&hidFolder=EMP";
	//private static final String url = "http://ehire.51job.com/Inbox/InboxRecent.aspx?Style=1";
	private static String loginUrl = "http://ehire.51job.com/MainLogin.aspx";

	public static void main(String[] args)
	{
		Session session = null;
		Connection con = null;
		HtmlLoader51 loadHtml = null;
		try{
			HtmlLoader loader = new HtmlLoader();
			loader.setUrl(loginUrl);
			String pageContent = loader.getHtml();
			String viewState = loader.getValue(pageContent, "<input type=\"hidden\" name=\"__VIEWSTATE\" id=\"__VIEWSTATE\" value=\"", "\" />");
			loader = null;
			String[][] data = {{"user","新鸿泰"},{"login", "admin"},{"password","xht2009"},{"__VIEWSTATE",viewState},{"Login_ibtnLogin",""}};
			loadHtml = new HtmlLoader51(true, loginUrl, data);
			loadHtml.setUrl(url);
			System.out.println(loadHtml.getHtml());
			
/*			loginUrl += "?user=新鸿泰&login=admin&password=xht2009";
			HtmlMethodImpl htmlLoad = new HtmlMethodImpl(true, loginUrl);
			htmlLoad.setUrl(url);
			System.out.println(htmlLoad.getHtml());*/
			
/*			String content = getHtmlCode(loginUrl);
			System.out.println(content);*/
			
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
	
	public static String getHtmlCode(String urlstring) 
    {
        String strContent="";
        String viewState = "<input type=\"hidden\" name=\"__VIEWSTATE\" id=\"__VIEWSTATE\" value=\"/wEPDwUKMTg4OTczMzUxMg9kFgICAQ9kFgYCAQ8PFgIeCEltYWdlVXJsBT9odHRwOi8vaW1hZ2UuNTFqb2IuY29tL2ltZWhpcmUvZWhpcmUyMDA3L2RlZmF1bHQvaW1hZ2UvbGFuZy5naWYWAh4HT25DbGljawUTcmV0dXJuIFNldExhbmcoJycpO2QCBg8PFgIfAAVKaHR0cDovL2ltYWdlLjUxam9iLmNvbS9pbWVoaXJlL2VoaXJlMjAwNy9kZWZhdWx0L2ltYWdlL3NpZ25fYmcyMDA5MDYwMy5naWYWAh4Hb25jbGljawUWcmV0dXJuIFNlbmRMb2dpbih0aGlzKWQCBw8PFgIfAAVMaHR0cDovL2ltYWdlLjUxam9iLmNvbS9pbWVoaXJlL2VoaXJlMjAwNy9kZWZhdWx0L2ltYWdlL21vZGlmeV9iZzIwMDkwNjAzLmdpZmRkGAEFHl9fQ29udHJvbHNSZXF1aXJlUG9zdEJhY2tLZXlfXxYCBQ1jaGtTZXREZWZhdWx0BQ9Mb2dpbl9pYnRuTG9naW4=\" />";
        HttpURLConnection connection = null;
        BufferedReader buffRead = null;
        try
        {
            URL url = new URL(urlstring);
            connection = (HttpURLConnection) url.openConnection();
            connection.addRequestProperty("User-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)"); //浏览器伪造 xurun
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "text/html;charset=utf-8");
            connection.setRequestProperty("X-UA-Compatible", "IE=7");
            connection.connect();
            
            InputStreamReader inputStream = null;
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
            out.write(viewState);
            out.write("<input name=\"user\" type=\"text\" id=\"user\" value=\"新鸿泰\"  />");
            out.write("<input name=\"login\" type=\"text\" id=\"login\" value=\"admin\" />");
            out.write("<input name=\"password\" type=\"password\" id=\"password\" value=\"xht2009\" />");
            out.write("<input type=\"image\" name=\"Login_ibtnLogin\" src=\"ssfs.gif\" />");
            out.flush();
            out.close();
            int code = connection.getResponseCode();
            System.out.println("code " + code);
            System.out.println(connection.getResponseMessage());
            
           	inputStream=new InputStreamReader(connection.getInputStream(),"utf-8");
            buffRead=new BufferedReader(inputStream);
            StringBuffer sbStr=new StringBuffer("");
            String str="";
            while((str=buffRead.readLine())!=null)
            {
                sbStr.append(str+"\n");
            }
            strContent=sbStr.toString();
            buffRead.close();
        }
        catch(ConnectException ex)
        {
            System.out.println(ex);
        }
        catch(SocketException ex)
        {
            System.out.println(ex);
        }
        catch(MalformedURLException ex)
        {
            System.out.println(ex);
        }
        catch(IOException ex)
        {
            System.out.println(ex);
        }
        finally
        {
            try
            {                
                if(buffRead!=null)
                    buffRead.close();
                
            }
            catch(IOException ioEx)
            {
                ioEx.printStackTrace();
            }
        }
     //   System.out.println(strContent);
        return strContent;
        
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
}
