package com.job5156.job51;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.hibernate.Session;

import com.job5156.server.FileLog;
import com.job5156.down.util.LoadHtml;
import com.job5156.foshan.HtmlMethodImpl;
import com.job5156.server.SessionManager;
import com.sun.jndi.toolkit.url.UrlUtil;

/**
 * @author yanf
 * create on 2008-9-9
 */
public class DownResume
{
	private static final String FILE_PATH = "com.job5156.job51.DownResume";
	
	private static final String url = "http://my.51job.com/AjaxAction/my/MyCenter_GetProfile.php";
	//private static final String url = "http://my.51job.com/sc/applyjob/preview_resume.php?ReSumeID=20783921";
	//private static final String loginUrl = "http://my.51job.com/my/My_Pmc.php?username=yutong1984&userpwd=vane135";
	private static final String loginUrl = "http://my.51job.com/my/My_Pmc.php";
	
	public static void main(String[] args)
	{
		try{
			HttpClient client = new HttpClient();
			PostMethod posMethod = new PostMethod(loginUrl);
			NameValuePair[] paramVal = new NameValuePair[2];
			paramVal[0] = new NameValuePair("username", "yutong1984");
			paramVal[1] = new NameValuePair("userpwd", "vane135");
			posMethod.setRequestBody(paramVal);
			posMethod.setRequestHeader("User-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)"); //ä¯ÀÀÆ÷Î±Ôì
			posMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                    new DefaultHttpMethodRetryHandler(3,false));
			int statusCode = client.executeMethod(posMethod);
			
			System.out.println(posMethod.getResponseBodyAsString());
			posMethod.releaseConnection();
			
			GetMethod getMethod = new GetMethod(url);
			client.executeMethod(getMethod);
			
			StringBuffer content = new StringBuffer();
			InputStream in = getMethod.getResponseBodyAsStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in, "gb2312"), 1024);
			String line = "";
			while((line = br.readLine()) != null){
				content.append(line);
			}
			if(br != null){
				br.close();
				br = null;
			}
			if(in != null){
				in.close();
				in = null;
			}
			System.out.println(content.toString());
			getMethod.releaseConnection();
			
		}catch(Exception e){
			FileLog.logDebug(FILE_PATH+".main()=="+e);
			e.printStackTrace();
		}
	}
}
