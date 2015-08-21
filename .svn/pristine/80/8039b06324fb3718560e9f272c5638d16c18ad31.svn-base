package com.job5156.url;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;


public class HtmlLoader extends Url {
	
	private boolean isLogin;
	private String loginUrl;
	private String url;
	private String loginType = "GET";
	private NameValuePair[] paramVal;
	
	public HtmlLoader(){

	}
	
	public HtmlLoader(String url){
		this.url = url;
	}
	
	public HtmlLoader(boolean isLogin, String loginUrl){
		this.isLogin = isLogin;
		this.loginUrl = loginUrl;
	}
	
	public HtmlLoader(boolean isLogin, String loginUrl, String loginType, NameValuePair[] param){
		this.isLogin = isLogin;
		this.loginUrl = loginUrl;
		this.loginType = loginType;
		this.paramVal = param;
	}
	
	@Override
	public void init() {
		if(client == null){
			try {
				client = new HttpClient();
				if(this.isLogin){
					if("GET".equalsIgnoreCase(this.loginType)){
						method = new GetMethod(this.loginUrl);
						method.setRequestHeader("User-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)"); //浏览器伪造
						client.executeMethod(method);
					}else if("POST".equalsIgnoreCase(this.loginType)){
						posMethod = new PostMethod(loginUrl);
						posMethod.setRequestBody(paramVal);
						posMethod.setRequestHeader("User-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)"); //浏览器伪造
						posMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,new DefaultHttpMethodRetryHandler(3,false));
						client.executeMethod(posMethod);
						posMethod.releaseConnection();
					}
				}
			} catch (Exception e) {
				System.out.println("----系统初始化失败!----");
				e.printStackTrace();
			}
		}
	}

	@Override
	public void release() {
		if(method != null)method.releaseConnection();
		if(posMethod != null)posMethod.releaseConnection();
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

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
}
