package com.job5156.job51;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import com.job5156.url.Url;


public class HtmlLoader51 extends Url {
	
	private boolean isLogin;
	private String loginUrl;
	private String url;
	private String[][] data;
	
	public HtmlLoader51(){

	}
	
	public HtmlLoader51(String url){
		this.url = url;
	}
	
	public HtmlLoader51(boolean isLogin, String loginUrl, String[][] data){
		this.isLogin = isLogin;
		this.loginUrl = loginUrl;
		this.data = data;
	}
	
	@Override
	public void init() {
		if(client == null){
			try {
				client = new HttpClient();
				if(this.isLogin){
					posMethod = new PostMethod(this.loginUrl);
					posMethod.setRequestHeader("Content-Type", "text/html; charset=utf-8");
					NameValuePair[] paramVal = null;
					if(data != null){
						paramVal = new NameValuePair[data.length];
						for(int i=0; i<data.length; i++){
							paramVal[i] = new NameValuePair(data[i][0], data[i][1]);
						}
					}
					if(paramVal != null)posMethod.setRequestBody(paramVal);
					posMethod.setRequestHeader("User-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
					client.executeMethod(posMethod);
					Cookie[] cookies = client.getState().getCookies();
					System.out.println(cookies.length);
					Header locationHeader = posMethod.getResponseHeader("location");
					if(locationHeader != null)System.out.println(locationHeader.getValue());
				}
			} catch (Exception e) {
				System.out.println("----系统初始化失败!----");
				e.printStackTrace();
			}
		}
	}

	@Override
	public void release() {
		if(method != null)posMethod.releaseConnection();
		if(client != null)client = null;
	}

	@Override
	public String getHtml() {
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
	
	public static String getValue(String content, String beginStr, String endStr) {
	    String value = ""; 
	    int start = -1;
	    start = content.indexOf(beginStr);
	    if(start!=-1)
	    {   
	        try
	        {
	            content = content.substring(start+beginStr.length());
	            start = content.indexOf(endStr);
	            if(start==-1)   //当匹配不到时，返回""
	                return "";
	            value = content.substring(0,start);
	        }
	        catch(StringIndexOutOfBoundsException ex)
	        {
	            return content;
	        }
	    }
	    return  value;  
	}

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

	public String getLoginUrl() {
		return loginUrl;
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
