package com.job5156.down.util;
public class LoadHtml {

	private String url;               //查看简历URL
	private boolean isParam = false;  //是否需要提交参数
	private boolean isLogin = false;  //是否需要登陆
	private String loginUrl;          //登陆URL
	private String[][] param;         //提交参数
	
	public LoadHtml(){
		
	}
	
	public LoadHtml(String url, boolean isParam, String[][] param){
		this.url = url;
		this.isParam = isParam;
		this.param = param;
	}
	
	public void setUrl(String url){
		this.url = url;
	}
	
	public void setIsParam(boolean isParam){
		this.isParam = isParam;
	}
	
	public void setParam(String[][] param){
		this.param = param;
	}
	
	public void setIsLogin(boolean isLogin){
		this.isLogin = isLogin;
	}
	
	public void setLoginUrl(String loginUrl){
		this.loginUrl = loginUrl;
	}
	
	public String getBigHtml(int id){
		String content = "";
		URLUtil urlUtil = new URLUtil();
		urlUtil.setUrl(this.url+id);
		if(this.isLogin){
			urlUtil.setIsLogin(this.isLogin);
			urlUtil.setLoginUrl(this.loginUrl);
		}
		if(this.isParam){
			content = urlUtil.getHtmlByParam(this.param);
		}else{
			content = urlUtil.getHtml();
		}
		return content;
	}
	
	public String getBigHtmlByCode(int id){
		return getBigHtmlByCode("GBK", id);
	}
	
	public String getBigHtmlByCode(String code, int id){
		String content = "";
		URLUtil urlUtil = new URLUtil();
		urlUtil.setUrl(this.url+id);
		if(this.isLogin){
			urlUtil.setIsLogin(this.isLogin);
			urlUtil.setLoginUrl(this.loginUrl);
		}
		content = urlUtil.getHtmlByCode(code);
		urlUtil = null;
		return content;
	}
	
	public static String getValue(String content, String begStr, String endStr){
	    String value = ""; 
	    int start = -1;
	    start = content.indexOf(begStr);
	    if(start!=-1)
	    {   
	        try
	        {
	            content = content.substring(start+begStr.length());
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
}
