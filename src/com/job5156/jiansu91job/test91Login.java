package com.job5156.jiansu91job;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
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
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.lang.StringUtils;
import org.apache.http.protocol.HTTP;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.job5156.foshan.HtmlMethodImpl;
import com.job5156.server.SessionManager;
import com.job5156.util.StringUtil;

/**
 * 
 */
/**
 * @author lyh
 * @Description 抓取数据主要的方法和路口 (砚生)
 * @date 2015年7月15日
 */
public class test91Login {

	private HttpClient httpClient;
	private final static String userName = "zhitongren";
	private final static String password = "duzhilei123";
	private final static String md5passWord = "18d096dddf0dcc25dd9b46980f208e8b";
	// private static String loginURL = "http://hire.jobcn.com/company/login.xhtml";
	private static String loginPageURL = "http://www.91job.gov.cn/manage/login.aspx";
	private static Logger logger = Logger.getLogger(test91Login.class);
	private static String searchURL = "http://www.91job.gov.cn/manage/USC/USC001.aspx?a1=USC&a2=USC001&xb=0&zy=&xldm=110011&xx=";
	private static String checkCodeURL = "http://www.91job.gov.cn/code.aspx"; // 验证码
	private static long timeInterval = 1500l;// 每次调用卓博搜索接口的时间间隔
	private static final String resumeUrl = "http://www.91job.gov.cn/manage/upm/upm003a.ASPX?type=U&personid=";
	private static final String searchDocURL = "http://www.91job.gov.cn/manage/USC/USC001.aspx?a1=USC&a2=USC001&xb=0&zy=&xldm=110001&xx=";
	private static final String searchColleage = "http://www.91job.gov.cn/manage/USC/USC001.aspx?a1=USC&a2=USC001&xb=0&zy=&xldm=110030&xx=";
	private static final String searchSpec = "http://www.91job.gov.cn/manage/USC/USC001.aspx?a1=USC&a2=USC001&xb=0&zy=&xldm=110040&xx=";

	/**
	 * 初始化httpclient 请求头伪装为火狐
	 * 
	 * @return
	 */
	public HttpClient getHttpClient() {
		//httpclietn并发的设置
		MultiThreadedHttpConnectionManager  connManager=new MultiThreadedHttpConnectionManager();
		connManager.setConnectionStaleCheckingEnabled(false);
		connManager.setMaxConnectionsPerHost(70);
		connManager.setMaxTotalConnections(70);
		httpClient = new HttpClient(connManager);
		
		httpClient.getParams().setParameter("http.protocol.content-charset", "UTF-8");
		httpClient.getParams().setParameter(HTTP.CONTENT_ENCODING, HTTP.UTF_8);
		httpClient.getParams().setParameter(HTTP.CHARSET_PARAM, HTTP.UTF_8);
		httpClient.getParams().setParameter(HTTP.DEFAULT_PROTOCOL_CHARSET, HTTP.UTF_8);
		List<Header> headers = new ArrayList<Header>();
		headers.add(new Header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:32.0) Gecko/20100101 Firefox/32.0"));
		headers.add(new Header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"));
		headers.add(new Header("Accept-Language", "zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3"));
		headers.add(new Header("Host", ".91job.gov.cn"));
		headers.add(new Header("Connection", "Keep-Alive"));
		headers.add(new Header("Cache-Control", "no-cache"));
		// headers.add(new Header("Accept-Encoding","gzip, deflate"));
		headers.add(new Header("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8"));
		headers.add(new Header("Referer", "http://www.91job.gov.cn/manage/login.aspx"));
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

	/**
	 * 获取简历搜索结果json串
	 * 
	 * @param params
	 * @return
	 */
	public String getResumeStatistics(Map<String, String> params) {
		getCheckPerRes();
		GetMethod getMethod = getRequest(searchURL, params);
		int statusCode = 0;
		try {
			getMethod.setRequestHeader(new Header("Referer", "http://hire.jobcn.com/search/result.xhtml"));
			// application/json, text/javascript, */*; q=0.01
			getMethod.setRequestHeader(new Header("Accept", "application/json, text/javascript, */*; q=0.01"));
			statusCode = httpClient.executeMethod(getMethod);
			if (statusCode >= HttpStatus.SC_OK && statusCode <= HttpStatus.SC_PARTIAL_CONTENT) {// 成功状态的返回码
				return getMethod.getResponseBodyAsString();
			} else {
				throw new RuntimeException("未出理返回码：" + statusCode + "\n" + getMethod.getResponseBodyAsString());
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			getMethod.releaseConnection();
		}
		return null;
	}

	// 获取数据页面
	public String getPage(Map<String, String> params, String url) {

		PostMethod postMehtod = postRequest(url, params);
		try {
			httpClient.executeMethod(postMehtod);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			return postMehtod.getResponseBodyAsString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			postMehtod.releaseConnection();
		}
		return null;
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

	public int redirect(PostMethod postMethod, int time) {
		int statusCode = 0;
		if (time <= 5) {
			postMethod = postRequest(postMethod.getResponseHeader("location").getValue(), null);
			try {
				statusCode = httpClient.executeMethod(postMethod);
				if (statusCode >= HttpStatus.SC_MULTIPLE_CHOICES && statusCode <= HttpStatus.SC_TEMPORARY_REDIRECT) {// 重定向
					redirect(postMethod, time);
				}
				return statusCode;
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
		}
		return -1;
	}

	/**
	 * 获取一次搜索页后再搜索，不然结果会为空
	 */
	public void getCheckPerRes() {
		GetMethod getMethod = getRequest(searchURL, null);
		try {
			int statusCode = httpClient.executeMethod(getMethod);
			if (statusCode >= HttpStatus.SC_OK && statusCode <= HttpStatus.SC_PARTIAL_CONTENT) {// 成功状态的返回码
			} else if (statusCode >= HttpStatus.SC_MULTIPLE_CHOICES && statusCode <= HttpStatus.SC_TEMPORARY_REDIRECT) {// 重定向
				int i = 1;
				while (i <= 5 && (statusCode >= HttpStatus.SC_MULTIPLE_CHOICES && statusCode <= HttpStatus.SC_TEMPORARY_REDIRECT)) { // 最多重定向5次
					getMethod = getRequest(getMethod.getResponseHeader("location").getValue(), null);
					statusCode = httpClient.executeMethod(getMethod);
					i++;
				}
			} else {
				throw new RuntimeException("未出理返回码：" + statusCode + "\n" + getMethod.getResponseBodyAsString());
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			getMethod.releaseConnection();
		}
	}

	/**
	 * 获取一次登录页以获得加密密码用的随机数cookie
	 */
	public void getLoginPage() {
		GetMethod getMethod = getRequest(loginPageURL, null);
		try {
			int statusCode = httpClient.executeMethod(getMethod);
			if (statusCode >= HttpStatus.SC_OK && statusCode <= HttpStatus.SC_PARTIAL_CONTENT) {// 成功状态的返回码
			} else if (statusCode >= HttpStatus.SC_MULTIPLE_CHOICES && statusCode <= HttpStatus.SC_TEMPORARY_REDIRECT) {// 重定向
				int i = 1;
				while (i <= 5 && (statusCode >= HttpStatus.SC_MULTIPLE_CHOICES && statusCode <= HttpStatus.SC_TEMPORARY_REDIRECT)) { // 最多重定向5次
					getMethod = getRequest(getMethod.getResponseHeader("location").getValue(), null);
					statusCode = httpClient.executeMethod(getMethod);
					i++;
				}
			} else {
				throw new RuntimeException("未出理返回码：" + statusCode + "\n" + getMethod.getResponseBodyAsString());
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			getMethod.releaseConnection();
		}
	}

	/**
	 * 将图片拉到本地
	 * 
	 * @return
	 * @throws IOException
	 */

	public static String savegif(GetMethod getMethod) throws IOException {
		File storeFile = new File("D:\\chitone\\down_resume\\resource\\pic\\code.jpg");
		FileOutputStream output = new FileOutputStream(storeFile); // 得到网络资源的字节数组,并写入文件
		output.write(getMethod.getResponseBody());
		output.close();
		System.out.println("请输入验证码：");
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		String ValidCode = "";
		try {
			ValidCode = br.readLine();
			br.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ValidCode;
	}

	/**
	 * 获取验证码图片，并放在当前类打包后的class文件目录下
	 * 
	 * @return
	 * @throws IOException
	 * @throws HttpException
	 */
	public String getChkCode() {
		GetMethod getMethod = getRequest(checkCodeURL, null);
		try {
			int statusCode = httpClient.executeMethod(getMethod);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			return savegif(getMethod);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getMethod.releaseConnection();
		}
		return "";
	}

	/**
	 * 用于登录，需要先访问卓博的登陆页获取jobcnid这一cookie， 带有这一cookie去获取的验证码，并且使用该cookie再次加密密码才能通过验证
	 */
	public boolean login() {
		Map<String, String> params = new HashMap();
		getLoginPage(); // 访问登录页以获得cookie
		String jcnid = "";
		Cookie[] tempCookies = httpClient.getState().getCookies();
		String chkCode = getChkCode();// 验证码 （以访问登录页后获得的cookie去获取验证码，后面同样以该cookie加密密码）
		System.out.println(chkCode + "===code=====");
		if (StringUtils.isEmpty(chkCode)) {
			System.out.println("获取验证码失败！");
			return false;
		}
		params.put("txtLoginNo", userName);
		params.put("txtPasswordB", password);
		params.put("checkCode", chkCode);
		params.put("__VIEWSTATE", "/wEPDwUJNjQyNDE5MzY1D2QWAgIDD2QWAgIHDw8WAh4EVGV4dGVkZGQSDM0b7ql9u3FN+YY/PKZlKCjrGw==");
		params.put("__VIEWSTATEGENERATOR", "200C32EE");
		params.put("Button1", "登录");
		params.put("txtPassword", md5passWord);
		PostMethod postMethod = postRequest(loginPageURL, params);
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

	public void downResumeData(String searchList, Connection con) {
		String listData = getListData(searchList);
		Vector vector = getUserIdArray(listData);
		if (vector.size() > 0) {
			for (int i = 0; i < vector.size(); i++) {
				String userId = StringUtils.defaultString((String) vector.get(i));
				// System.out.println(userId+"----");
				if (!checkData(con, userId)) {
					// System.out.println(resumeUrl+userId+" this is content");
					Map<String, String> map = new HashMap<String, String>();
					String content = getResumeContent(resumeUrl + userId);
					System.out.println(userId + "=====");
					if (!checkData(con, userId)) {
						insertData(con, content, userId);
					}
				}
			}
		}
	}

	// 得到 list循环数据
	public String getListData(String searchListContent) {
		String start = "<div align='center'> <font color='#196796'>查看简历</font></div>";
		String end = "批量选择";
		return getValue(searchListContent, start, end);
	}

	// 获取简历主要数据
	public String getResumeHtml(String searchListContent) {
		String start = "<input type=\"hidden\" name=\"__VIEWSTATEGENERATOR\" id=\"__VIEWSTATEGENERATOR\" value=\"6EF0EC4A\" />";
		String end = "</form>";
		return getValue(searchListContent, start, end);
	}

	/**
	 * 根据循环数据，取出用户ID
	 * 
	 * @param dataContent
	 * @return
	 */
	public Vector getUserIdArray(String dataContent) {
		Vector vector = new Vector();
		// System.out.println(dataContent+"this is dataContent");
		while (true) {
			String perId = getValue(dataContent, "href=javascript:OpenWindow('../upm/upm003a.ASPX?type=U&personid=", "&id=1',750,600)");
			if (!"".equals(perId)) {
				vector.add(perId);
				// System.out.println(perId);
				String inputStr = "href=javascript:OpenWindow('../upm/upm003a.ASPX?type=U&personid=" + perId + "&id=1',750,600)";
				int pos = dataContent.indexOf(inputStr);
				if (pos == -1)
					break;
				dataContent = dataContent.substring(pos + inputStr.length());
			} else {
				break;
			}
		}
		return vector;
	}

	public static void insertData(Connection con, String content, String userId) {
		String sql = "insert into jiansu(resume_content, user_id) values(?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, content);
			pstmt.setString(2, userId);
			pstmt.executeUpdate();
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

	public boolean checkData(Connection con, String userId) {
		boolean check = false;
		String sql = "select count(*) from jiansu where user_id = '" + userId + "'";
		check = hasData(con, sql);
		/*
		 * if (!check) { //sql = "select count(*) from jiansu_1 where user_id = " + userId; check = hasData(con, sql); } */
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

	// 截取字符串
	public String getValue(String content, String beginStr, String endStr) {
		String value = "";
		int start = -1;
		start = content.indexOf(beginStr);
		if (start != -1) {
			try {
				content = content.substring(start + beginStr.length());
				start = content.indexOf(endStr);
				if (start == -1) // 当匹配不到时，返回""
					return "";
				value = content.substring(0, start);
			} catch (StringIndexOutOfBoundsException ex) {
				return content;
			}
		}
		return value;
	}

	public void CrawelResume(String searchUri, test91Login testg) {
		// test91Login testg = new test91Login();
		// testg.login(); //页面的登录

		Map<String, String> map = new HashMap<String, String>();
		// map.put("xldm", "110030"); //drpUpo9 110030 本科 110040专科 110011博士 110001
		Session session = null;
		Connection con = null;
		session = SessionManager.currentSession();
		con = session.connection();
		System.out.println("江苏高校网抓取数据现在 开始：");
		for (int i = 0; i < 999999999; i++) {
			String returnHtml = testg.getPage(map, searchUri); // 页面简历数据的查找 （查找perid进行简历的查找）
			testg.downResumeData(returnHtml, con);
		}
		try {
			con.close();
			session.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("江苏高校网抓取数据 结束：");
	}

	class jiansuTask extends TimerTask {

		/* (non-Javadoc)
		 * 
		 * @see java.util.TimerTask#run() */
		@Override
		public void run() {
			// TODO Auto-generated method stub
			CrawelResume(searchURL, new test91Login());
		}
	}

	class jiansuRunner implements Runnable {

		private String searchUrl;
		private test91Login testLogin;

		public test91Login getTestLogin() {
			return testLogin;
		}

		public void setTestLogin(test91Login testLogin) {
			this.testLogin = testLogin;
		}

		public String getSearchUrl() {
			return searchUrl;
		}

		public void setSearchUrl(String searchUrl) {
			this.searchUrl = searchUrl;
		}

		public jiansuRunner(String seachUrl,test91Login login) {
			this.searchUrl = seachUrl;
			this.testLogin=login;
		}

		public void run() {
			testLogin.CrawelResume(searchUrl, testLogin);
		}
	}

	// 主程序的路口
	public static void main(String args[]) throws HttpException, IOException {
		/*test91Login testg = new test91Login();
		// testg.login(); //页面的登录
		// new Thread(testg.new jiansuRunner(searchURL)).start(); //硕生爬行
		// new Thread(testg.new jiansuRunner(searchURL)).start(); //硕生爬行
		 new Thread(testg.new jiansuRunner(searchDocURL)).start(); //博士生爬行 new Thread(testg.new jiansuRunner(searchColleage)).start();//本科爬行 new Thread(testg.new
		 * jiansuRunner(searchSpec)).start();//专科生爬行 

		// test91Login testg = new test91Login();
		// 程序启动一分钟后开始统计
		long timerDelay = 0;
		// 间隔时间,每2小时插一次
		long timerPeriod = 1000 * 60 * 60 * 24L;
		new Timer().schedule(testg.new jiansuTask(), timerDelay, timerPeriod);*/
		MainTestCrawel mainTestCrawel=new MainTestCrawel();
		String urlString = "http://www.91job.gov.cn/manage/USC/USC001.aspx?a1=USC&a2=USC001&xb=0&zy=&xldm=&xx=";
		// 20个线程跑
		mainTestCrawel.MainCrawel(urlString);
		
		
	}

}
