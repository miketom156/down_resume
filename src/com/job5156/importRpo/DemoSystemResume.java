package com.job5156.importRpo;

import java.io.IOException;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpHost;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang.StringUtils;
import org.apache.http.conn.params.ConnRouteParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.job5156.server.FileLog;
import com.job5156.server.SessionManager;

/**
 * 
 */
/**
 * @author lyh
 * @Description 抓取数据主要的方法和路口 (砚生)
 * @date 2015年7月15日
 */
public class DemoSystemResume {

	private HttpClient httpClient;
	private final static String userName = "admin";
	private final static String password = "123456789";
	private static String [] loginPageURL = {"http://121.41.112.72:18777/login","http://121.41.112.72:18666/login"};
	private static Logger logger = Logger.getLogger(DemoSystemResume.class);

	private static  String [] resumeUrl = {"http://121.41.112.72:18777/resume/detail/","http://121.41.112.72:18666/resume/detail/"};

	/**
	 * 初始化httpclient 请求头伪装为火狐
	 * 
	 * @return
	 */
	public HttpClient getHttpClient() {
		// httpclietn并发的设置
		MultiThreadedHttpConnectionManager connManager = new MultiThreadedHttpConnectionManager();
		connManager.setConnectionStaleCheckingEnabled(false);
		connManager.setMaxConnectionsPerHost(70);
		connManager.setMaxTotalConnections(70);
		httpClient = new HttpClient(connManager);
        //httpClient.getHostConfiguration().setProxy("192.168.8.125", 1156);
		httpClient.getParams().setParameter("http.protocol.content-charset", "UTF-8");
		httpClient.getParams().setParameter(HTTP.CONTENT_ENCODING, HTTP.UTF_8);
		httpClient.getParams().setParameter(HTTP.CHARSET_PARAM, HTTP.UTF_8);
		httpClient.getParams().setParameter(HTTP.DEFAULT_PROTOCOL_CHARSET, HTTP.UTF_8);
		List<Header> headers = new ArrayList<Header>();
		headers.add(new Header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:32.0) Gecko/20100101 Firefox/32.0"));
		headers.add(new Header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"));
		headers.add(new Header("Accept-Language", "zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3"));
		headers.add(new Header("Host", "121.41.112.72"));
		headers.add(new Header("Connection", "Keep-Alive"));
		headers.add(new Header("Cache-Control", "no-cache"));
		// headers.add(new Header("Accept-Encoding","gzip, deflate"));
		headers.add(new Header("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8"));
		headers.add(new Header("Referer", "http://121.41.112.72:18777/welcome"));
		httpClient.getHostConfiguration().getParams().setParameter("http.default-headers", headers);
		httpClient.getHostConfiguration().getParams().setParameter( // 据说这可以保证兼容某些只适应cookie在请求头的浏览器
				"http.protocol.single-cookie-header", true);
		return httpClient;
	}
	/**
	 * 获得post方法实例
	 * 
	 * @param url
	 * @param paramsMap
	 * @return
	 */
	public PostMethod postRequest(String url, Map<String, String> paramsMap) {
		if (httpClient == null) {
			getHttpClient();
		}
		PostMethod postMethod = new PostMethod(url);
		postMethod.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
		if (paramsMap != null) {
			Iterator<Map.Entry<String, String>> its = paramsMap.entrySet().iterator();
			NameValuePair[] params = new NameValuePair[paramsMap.size()];
			int i = 0;
			while (its.hasNext()) {
				Map.Entry<String, String> e = its.next();
				params[i++] = (new NameValuePair(e.getKey(), e.getValue()));
			}
			postMethod.setRequestBody(params);
		}
		return postMethod;
	}

	/**
	 * 获得get方法实例
	 * 
	 * @param url
	 * @param paramsMap
	 * @return
	 */
	public GetMethod getRequest(String url, Map<String, String> paramsMap) {
		if (httpClient == null) {
			getHttpClient();
		}
		String params = "";
		if (paramsMap != null && paramsMap.size() > 0) {
			for (Map.Entry param : paramsMap.entrySet()) {
				params += "&" + param.getKey() + "=" + param.getValue();
			}
			params = params.substring(1);
			params = "?" + params;
		}
		GetMethod getMethod = new GetMethod(url + params);
		getMethod.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
		return getMethod;
	}

	// 查看简历内容
	public String getResumeContent(String urlStr) {
		Map<String, String> map = new HashMap<String, String>();
		GetMethod getMethod = getRequest(urlStr, map);
		try {
			httpClient.executeMethod(getMethod);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			return getMethod.getResponseBodyAsString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getMethod.releaseConnection();
		}
		return null;
	}

	/**
	 * 用于登录
	 */
	public boolean login(int index) {
		Map<String, String> params = new HashMap();
		params.put("username", userName);
		params.put("password", password);
		params.put("submit", "");
		PostMethod postMethod = postRequest(loginPageURL[index], params);
		int statusCode = 0;
		boolean hasCookie = false;
		try {
			statusCode = httpClient.executeMethod(postMethod);
			System.out.println("login===--" + statusCode);
			if (statusCode >= HttpStatus.SC_OK && statusCode <= HttpStatus.SC_PARTIAL_CONTENT) {// 成功状态的返回码
			} else if (statusCode >= HttpStatus.SC_MULTIPLE_CHOICES && statusCode <= HttpStatus.SC_TEMPORARY_REDIRECT) {// 重定向
				int i = 1;
				while (i <= 5 && (statusCode >= HttpStatus.SC_MULTIPLE_CHOICES && statusCode <= HttpStatus.SC_TEMPORARY_REDIRECT)) { // 最多重定向5次
					postMethod = postRequest(postMethod.getResponseHeader("location").getValue(), null);
					statusCode = httpClient.executeMethod(postMethod);
					i++;
				}
			} else {
				throw new RuntimeException("未出理返回码：" + statusCode + "\n" + postMethod.getResponseBodyAsString());
			}
			Cookie[] cookies = httpClient.getState().getCookies();
			if (cookies.length == 0) {
			} else {
				for (int i = 0; i < cookies.length; i++) {
					if (cookies[i].getName().equals("comkey")) { // 登录成功后会加入这一cookie
						hasCookie = true;
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			postMethod.releaseConnection();
		}
		return hasCookie;
	}

	public void downResumeData(Connection con, int n, int end,int index){
		int resultInt = n;
		resultInt = getMaxId(con, n, end);
		for (int i = resultInt; i < end; i++) {
			String content = getResumeContent(resumeUrl[index] + i);
			if (checkData(con, i)) {
				continue;
			} else if (StringUtils.isNotEmpty(content) && !checkData(con, i)) {
				System.out.println("抓取简历编号："+i+"-----"+index);
				insertData(con, content, i);
			}else{
				try {
					Thread.currentThread().yield();
					int rtx = index == 0 ? 1 : 0;
					FileLog.logDebug("切换端口！成功" + resumeUrl[rtx]);
					getResumerData(100000, end, rtx);
					throw new java.net.ConnectException();
				} catch (ConnectException e) {
					// TODO Auto-generated catch block
					int rtx = index == 0 ? 1 : 0;
					FileLog.logDebug("切换端口！成功" + resumeUrl[rtx]);
					getResumerData(10000, end, rtx);
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
		
	}

	public static void insertData(Connection con, String content, Integer resumeNo) {
		String sql = "insert into demosys(resume_content, resume_no) values(?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, content);
			pstmt.setInt(2, resumeNo);
			int n = pstmt.executeUpdate();
			con.commit();
			// System.out.println(n + ":" + resumeNo);
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public boolean checkData(Connection con, Integer resumeNo) {
		boolean check = false;
		String sql = "select count(*) from demosys where resume_no = " + resumeNo;
		check = hasData(con, sql);
		/* if (!check) { //sql = "select count(*) from jiansu_1 where user_id = " + userId; check = hasData(con, sql); } */
		return check;
	}

	public boolean hasData(Connection con, String sql) {
		boolean isCheck = false;
		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs != null) {
				while (rs.next()) {
					if (rs.getInt(1) > 0)
						isCheck = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (st != null) {
					st.close();
					st = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return isCheck;
	}

	public int getMaxId(Connection con, int n, int end) {
		ResultSet rs = null;
		String sql = "select max(resume_no) from demosys where resume_no BETWEEN " + n + " AND " + end;
		System.out.println(sql);
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					if (rs.getInt(1) > 0)
						return rs.getInt(1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return n;
	}

	/* @param n 开始位置
	 * index 连接索引
	 * @param end 结束位置 */
	private static void getResumerData(int n, int end,int index) {
		Session session = null;
		Connection con = null;
		session = SessionManager.currentSession();
		con = session.connection();
		DemoSystemResume demoSystemResume = new DemoSystemResume();
		demoSystemResume.login(index);
		synchronized (con) {
			session.flush();
			session.clear();
			demoSystemResume.downResumeData( con, n, end,index);

			try {
				con.close();
				session.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
class ResumeRunner implements Runnable{

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	
	private int index;
	private int end;
	private int id;
	public ResumeRunner(int index,int end,int id){
		this.index=index;
		this.end=end;
		this.id=id;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		DemoSystemResume demoSystemResume=new DemoSystemResume();
		demoSystemResume.getResumerData(index, end, id);
	}
	
}
	
	// 主程序的路口
	public static void main(String args[]) throws HttpException, IOException {
		getResumerData(100000, 999999,1);
	}

}
