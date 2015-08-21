/**
 * 
 */
package com.job5156.jiansu91job;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lyh
 * @Description
 * @date 2015年7月16日
 */
public class MainTestCrawel {
    private static final String searchDocURL = "http://www.91job.gov.cn/manage/USC/USC001.aspx?a1=USC&a2=USC001&xb=0&zy=&xldm=110001&xx=";
	private static final String searchColleage = "http://www.91job.gov.cn/manage/USC/USC001.aspx?a1=USC&a2=USC001&xb=0&zy=&xldm=110030&xx=";
	private static final String searchSpec = "http://www.91job.gov.cn/manage/USC/USC001.aspx?a1=USC&a2=USC001&xb=0&zy=&xldm=110001&xx=";
	public static String searchURL = "http://www.91job.gov.cn/manage/USC/USC001.aspx?a1=USC&a2=USC001&xb=0&zy=&xldm=110011&xx=";
	private static String messUrl = "http://www.91job.gov.cn/manage/USC/USC001.aspx?a1=USC&a2=USC001&xb=0&zy=&xldm=&xx=%E6%99%AE";
	private static String newUrl = "http://www.91job.gov.cn/manage/USC/USC001.aspx?a1=USC&a2=USC001&xb=0&zy=&xldm=&xx=%E5%A4%A7";
	private static String techUrl = "http://www.91job.gov.cn/manage/USC/USC001.aspx?a1=USC&a2=USC001&xb=0&zy=&xldm=&xx=%E5%B8%88";
	private static String englishUrl = "http://www.91job.gov.cn/manage/USC/USC001.aspx?a1=USC&a2=USC001&xb=0&zy=&xldm=&xx=%E5%B7%A5";
	private static String weixueUrl = "http://www.91job.gov.cn/manage/USC/USC001.aspx?a1=USC&a2=USC001&xb=0&zy=&xldm=&xx=%E8%BE%BE";

	private static String BrandUrl = "http://www.91job.gov.cn/manage/USC/USC001.aspx?a1=USC&a2=USC001&xb=0&zy=&xldm=&xx=";
	private static String sexNan = "http://www.91job.gov.cn/manage/USC/USC001.aspx?a1=USC&a2=USC001&xb=1&zy=&xldm=&xx=";
	private static String sexNu = "http://www.91job.gov.cn/manage/USC/USC001.aspx?a1=USC&a2=USC001&xb=2&zy=&xldm=&xx=";
	private static String nanJin = "http://www.91job.gov.cn/manage/USC/USC001.aspx?a1=USC&a2=USC001&xb=0&zy=%E5%95%86&xldm=&xx=";
	private static String managerUrl = "http://www.91job.gov.cn/manage/USC/USC001.aspx?a1=USC&a2=USC001&xb=0&zy=&xldm=&xx=%E5%A4%A7";
	private static String kuaijiUrl = "http://www.91job.gov.cn/manage/USC/USC001.aspx?a1=USC&a2=USC001&xb=0&zy=%E7%BB%8F&xldm=&xx=";
	private static String sysUrl = "http://www.91job.gov.cn/manage/USC/USC001.aspx?a1=USC&a2=USC001&xb=0&zy=%E5%AD%A6&xldm=&xx=";
	private static String gongyiUrl = "http://www.91job.gov.cn/manage/USC/USC001.aspx?a1=USC&a2=USC001&xb=0&zy=%E8%82%B2&xldm=&xx=";
	private static String sejiUrl = "http://www.91job.gov.cn/manage/USC/USC001.aspx?a1=USC&a2=USC001&xb=0&zy=%E5%8F%B2&xldm=&xx=";
	// http://www.91job.gov.cn/manage/USC/USC001.aspx?a1=USC&a2=USC001&xb=0&zy=&xldm=&xx=邮电
	private static String extraUrl = "http://www.91job.gov.cn/manage/USC/USC001.aspx?a1=USC&a2=USC001&xb=0&zy=%E7%A4%BE&xldm=&xx=";
	private static String zhiYeUrl = "http://www.91job.gov.cn/manage/USC/USC001.aspx?a1=USC&a2=USC001&xb=0&zy=%E6%94%BF&xldm=&xx=";
	private static String schoolUrl = "http://www.91job.gov.cn/manage/USC/USC001.aspx?a1=USC&a2=USC001&xb=0&zy=%E5%AE%89&xldm=&xx=";
	private static String zhengjiangUrl = "http://www.91job.gov.cn/manage/USC/USC001.aspx?a1=USC&a2=USC001&xb=0&zy=%E6%B1%89&xldm=&xx=";
	private static String specScholl = "http://www.91job.gov.cn/manage/USC/USC001.aspx?a1=USC&a2=USC001&xb=0&zy=%E6%96%87&xldm=&xx=";
	private static String sifanUrl = "http://www.91job.gov.cn/manage/USC/USC001.aspx?a1=USC&a2=USC001&xb=0&zy=%E5%B9%BF&xldm=&xx=";
	private static String godengUrl = "http://www.91job.gov.cn/manage/USC/USC001.aspx?a1=USC&a2=USC001&xb=0&zy=%E7%AE%A1&xldm=&xx=";
	private static String lianyunUrl = "http://www.91job.gov.cn/manage/USC/USC001.aspx?a1=USC&a2=USC001&xb=0&zy=%E5%B8%82&xldm=&xx=";
	private static String youerUrl = "http://www.91job.gov.cn/manage/USC/USC001.aspx?a1=USC&a2=USC001&xb=0&zy=%E4%BC%9A&xldm=&xx=";
	private static String jianyuUrl = "http://www.91job.gov.cn/manage/USC/USC001.aspx?a1=USC&a2=USC001&xb=0&zy=%E6%95%B0&xldm=&xx=";
	/**
	 * @Description: TODO
	 * @param @param args
	 * @return void
	 * @throws
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String urlString = "http://www.91job.gov.cn/manage/USC/USC001.aspx?a1=USC&a2=USC001&xb=0&zy=&xldm=&xx=";
		// 20个线程跑
		MainCrawel(urlString);

	}

	/**
	 * @Description: TODO
	 * @param @param urlString
	 * @param @param testlogin
	 * @param @param executer
	 * @return void
	 * @throws
	 */
	public static void MainCrawel(String urlString) {
		test91Login testlogin = new test91Login();
		testlogin.login();
		ExecutorService executer = Executors.newFixedThreadPool(30);
		executer.execute(testlogin.new jiansuRunner(searchDocURL, testlogin));
		executer.execute(testlogin.new jiansuRunner(searchColleage, testlogin));
		executer.execute(testlogin.new jiansuRunner(searchSpec, testlogin));
		executer.execute(testlogin.new jiansuRunner(searchURL, testlogin));
		executer.execute(testlogin.new jiansuRunner(messUrl, testlogin));
		executer.execute(testlogin.new jiansuRunner(newUrl, testlogin));
		executer.execute(testlogin.new jiansuRunner(techUrl, testlogin));
		executer.execute(testlogin.new jiansuRunner(englishUrl, testlogin));
		executer.execute(testlogin.new jiansuRunner(weixueUrl, testlogin));
		executer.execute(testlogin.new jiansuRunner(BrandUrl, testlogin));
		executer.execute(testlogin.new jiansuRunner(sexNan, testlogin));
		executer.execute(testlogin.new jiansuRunner(sexNu, testlogin));
		executer.execute(testlogin.new jiansuRunner(nanJin, testlogin)); // 南京学校
		executer.execute(testlogin.new jiansuRunner(urlString + "%E6%B1%9F%E8%8B%8F", testlogin)); // 江苏
		executer.execute(testlogin.new jiansuRunner(urlString + "%E6%B1%9F%E8%8B%8F%E5%A4%A7%E5%AD%A6%E4%BA%AC%E6%B1%9F%E5%AD%A6%E9%99%A2", testlogin)); // 江苏京大
		executer.execute(testlogin.new jiansuRunner(managerUrl, testlogin));
		executer.execute(testlogin.new jiansuRunner(kuaijiUrl, testlogin));
		executer.execute(testlogin.new jiansuRunner(sysUrl, testlogin));
		executer.execute(testlogin.new jiansuRunner(gongyiUrl, testlogin));
		executer.execute(testlogin.new jiansuRunner(sejiUrl, testlogin));

		executer.execute(testlogin.new jiansuRunner(extraUrl, testlogin));
		executer.execute(testlogin.new jiansuRunner(zhengjiangUrl, testlogin));
		executer.execute(testlogin.new jiansuRunner(zhiYeUrl, testlogin));
		executer.execute(testlogin.new jiansuRunner(schoolUrl, testlogin));
		executer.execute(testlogin.new jiansuRunner(specScholl, testlogin));
		executer.execute(testlogin.new jiansuRunner(sifanUrl, testlogin));
		executer.execute(testlogin.new jiansuRunner(godengUrl, testlogin));
		executer.execute(testlogin.new jiansuRunner(lianyunUrl, testlogin));
		executer.execute(testlogin.new jiansuRunner(youerUrl, testlogin));
		executer.execute(testlogin.new jiansuRunner(jianyuUrl, testlogin));
		if (executer.isShutdown()) {
			MainCrawel(urlString);
		}
	}

}
