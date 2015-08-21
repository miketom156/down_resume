/*
 * Created on 2007-1-20
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.job5156.down.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;


/**
 * @author yanf
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class URLUtil{
	private static HttpClient client = null;
	private static GetMethod method = null;
	
	private boolean isLogin = false;    //是否需要登陆
	private String loginUrl = null;     //登陆的URL
	private String url = null;          //查看简历的URL
	
	private static final String CHARSET_UTF = "UTF-8";
	private static final String CHARSET_GBK = "GBK"; 
	
	public URLUtil(){
		
	}
	
	public URLUtil(boolean isLogin, String loginUrl, String url){
		this.isLogin = isLogin;
		this.loginUrl = loginUrl;
		this.url = url;
	}
		
	public void setIsLogin(boolean isLogin){
		this.isLogin = isLogin;
	}
	
	public void setLoginUrl(String loginUrl){
		this.loginUrl = loginUrl;
	}
	
	public void setUrl(String url){
		this.url = url;
	}
	
	public void init(){
		if(client == null){
			try {
				client = new HttpClient();
				if(this.isLogin){
					method = new GetMethod(this.loginUrl);
					method.setRequestHeader("User-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)"); //浏览器伪造
					client.executeMethod(method);
				}
			} catch (Exception e) {
				System.out.println("----系统初始化失败!----");
				e.printStackTrace();
			}
		}
	}
	
	public void release(){
		if(method != null)method.releaseConnection();
		if(client != null)client = null;
	}
	
	public String getHtml(){
		String contentStr = "";
		HttpMethod getMethod = null;
		init();
		try{
			getMethod = new GetMethod(this.url);
	        client.executeMethod(getMethod);
	        contentStr = getMethod.getResponseBodyAsString();
		}catch(Exception e){
			e.printStackTrace();
			release();
		}finally{
	        getMethod.releaseConnection();
		}
		return contentStr;
	}
	
	public String getHtmlByCode(String code){
		StringBuffer content = new StringBuffer();
		HttpMethod getMethod = null;
		init();
		try{
			getMethod = new GetMethod(this.url);
			client.executeMethod(getMethod);
			InputStream in = getMethod.getResponseBodyAsStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in, code), 1024);
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
		}catch(Exception e){
			e.printStackTrace();
			release();
		}finally{
			getMethod.releaseConnection();
		}
		return content.toString();
	}
	
	public String getHtmlByParam(String[][] param){
		String contentStr = "";
		if(param != null && param.length > 0){
			NameValuePair[] paramVal = new NameValuePair[param.length];
			for(int i=0; i<param.length; i++){
				paramVal[i] = new NameValuePair(param[i][0], param[i][1]);
			}
			contentStr = getHtmlByParam(paramVal);
		}
		return contentStr;
	}
	
	public String getHtmlByParam(NameValuePair[] param){
		String contentStr = "";
		PostMethod postMethod = null;
		init();
		try{
			postMethod = new PostMethod(this.url);
			postMethod.setRequestBody(param);
			postMethod.setRequestHeader("User-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)"); //浏览器伪造
			client.executeMethod(postMethod);
			contentStr = postMethod.getResponseBodyAsString();
		}catch(Exception e){
			e.printStackTrace();
			release();
		}finally{
			postMethod.releaseConnection();
		}
		return contentStr;
	}
	
	public static void main(String[] args){
		try{
			String url = "http://www.0757rc.com/ent/showresume.aspx?jwsn=950182";
			URLUtil urlUtil = new URLUtil();
			urlUtil.setUrl(url);
			String urlContent = urlUtil.getHtml();
			if(urlContent.indexOf("<input type=\"submit\" name=\"Button2\" value=\"查看联系方式\" id=\"Button2\" />") != -1){
				String viewState = LoadHtml.getValue(urlContent, "<input type=\"hidden\" name=\"__VIEWSTATE\" id=\"__VIEWSTATE\" value=\"", "\" />");
				PostMethod postMethod = new PostMethod(url);
				NameValuePair keyword = new NameValuePair("__VIEWSTATE", viewState);
				NameValuePair keyword1 = new NameValuePair("Button2", "查看联系方式");
				postMethod.setRequestBody(new NameValuePair[]{keyword,keyword1});
				postMethod.setRequestHeader("User-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)"); //浏览器伪造
				client.executeMethod(postMethod);
				System.out.println(postMethod.getResponseBodyAsString());
				postMethod.releaseConnection();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
