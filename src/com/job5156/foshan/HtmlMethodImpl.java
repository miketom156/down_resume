package com.job5156.foshan;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import com.job5156.url.HtmlLoader;
import com.job5156.url.IHtmlMethod;

public class HtmlMethodImpl extends HtmlLoader implements IHtmlMethod {
	
	public HtmlMethodImpl(){
		super();
	}
	
	public HtmlMethodImpl(String url){
		super(url);
	}
	
	public HtmlMethodImpl(boolean isLogin, String loginUrl){
		super(isLogin, loginUrl);
	}

	public String getHtmlByCode(String code) {
		StringBuffer content = new StringBuffer();
		HttpMethod getMethod = null;
		init();
		try{
			getMethod = new GetMethod(this.getUrl());
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

	public String getHtmlByParam(String[][] param) {
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

	public String getHtmlByParam(NameValuePair[] param) {
		String contentStr = "";
		init();
		PostMethod postMethod = null;
		try{
			postMethod = new PostMethod(this.getUrl());
			postMethod.setRequestBody(param);
			postMethod.setRequestHeader("User-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)"); //ä¯ÀÀÆ÷Î±Ôì
			postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                    new DefaultHttpMethodRetryHandler(3,false));
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
	
	public String getHtmlByParamAndCode(String[][] param, String code){
		String contentStr = "";
		if(param != null && param.length > 0){
			NameValuePair[] paramVal = new NameValuePair[param.length];
			for(int i=0; i<param.length; i++){
				paramVal[i] = new NameValuePair(param[i][0], param[i][1]);
			}
			contentStr = getHtmlByParamAndCode(paramVal, code);
		}
		return contentStr;
	}
	
	public String getHtmlByParamAndCode(NameValuePair[] param, String code) {
		StringBuffer contentStr = new StringBuffer();
		init();
		PostMethod postMethod = null;
		try{
			postMethod = new PostMethod(this.getUrl());
			postMethod.setRequestBody(param);
			postMethod.setRequestHeader("User-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)"); //ä¯ÀÀÆ÷Î±Ôì
			client.executeMethod(postMethod);
			InputStream in = postMethod.getResponseBodyAsStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in, code), 1024);
			String line = "";
			while((line = br.readLine()) != null){
				contentStr.append(line);
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
			postMethod.releaseConnection();
		}
		return contentStr.toString();
	}

}
