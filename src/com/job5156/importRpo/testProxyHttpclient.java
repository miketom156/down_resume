/**
 * 
 */
package com.job5156.importRpo;

import org.apache.commons.httpclient.params.HttpParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.CoreProtocolPNames;

/**
 * @author lyh
 * @Description
 * @date 2015年8月3日
 */
public class testProxyHttpclient {
	static final int TIMEOUT = 20000;// 连接超时时间
	static final int SO_TIMEOUT = 20000;// 数据传输超时
	static String UA = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.1" + " (KHTML, like Gecko) Chrome/21.0.1180.89 Safari/537.1";

	/**
	 * @Description: TODO
	 * @param @param args
	 * @
	 * @throws
	 */

	public static void main(String args[]) throws Exception {
		/* // 创建HttpClientBuilder HttpClientBuilder httpClientBuilder = HttpClientBuilder.create(); // HttpClient CloseableHttpClient closeableHttpClient = httpClientBuilder.build(); //
		 * 依次是目标请求地址，端口号,协议类型 HttpHost target = new HttpHost("10.10.100.102:8080/mytest", 8080, "http");
		 * 
		 * // 依次是代理地址，代理端口号，协议类型 HttpHost proxy = new HttpHost("yourproxy", 8080, "http"); RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
		 * 
		 * // 请求地址 HttpPost httpPost = new HttpPost("http://10.10.100.102:8080/mytest"); httpPost.setConfig(config); // 创建参数队列 List<NameValuePair> formparams = new ArrayList<NameValuePair>(); //
		 * 参数名为pid，值是2 formparams.add(new BasicNameValuePair("pid", "2"));
		 * 
		 * UrlEncodedFormEntity entity; try { entity = new UrlEncodedFormEntity(formparams, "UTF-8"); httpPost.setEntity(entity); CloseableHttpResponse response = closeableHttpClient.execute( target,
		 * httpPost); // getEntity() HttpEntity httpEntity = response.getEntity(); if (httpEntity != null) { // 打印响应内容 System.out.println("response:" + EntityUtils.toString(httpEntity, "UTF-8")); } //
		 * 释放资源 closeableHttpClient.close(); } catch (Exception e) { e.printStackTrace(); } */
	}

	public static DefaultHttpClient getHttpClient() {
		SchemeRegistry schemeRegistry = new SchemeRegistry();
		schemeRegistry.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
		schemeRegistry.register(new Scheme("https", 443, SSLSocketFactory.getSocketFactory()));

		PoolingClientConnectionManager cm = new PoolingClientConnectionManager(schemeRegistry);
		cm.setMaxTotal(500);
		cm.setDefaultMaxPerRoute(200);

		HttpParams params = (HttpParams) new BasicHttpParams();
		params.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, TIMEOUT);
		params.setParameter(CoreConnectionPNames.SO_TIMEOUT, SO_TIMEOUT);
		params.setParameter(CoreProtocolPNames.USER_AGENT, UA);

		DefaultHttpClient client = new DefaultHttpClient(cm);
		return client;

	}

}
