package com.job5156.url;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

public abstract class Url {
	
	protected HttpClient client;
	protected GetMethod method;
	protected PostMethod posMethod;
	
	public abstract void init();
	
	public abstract void release();
	
	public abstract String getHtml();
}
