/**
 * 
 */
package com.job5156.jiansu91job;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;

import com.job5156.server.SessionManager;

/**
 * @author lyh
 * @Description
 * @date 2015年7月15日
 */
public class testMainDoctor {

	/**
	 * @Description: 博士数据的抓取
	 * @param @param args
	 * @return void
	 * @throws
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainTestCrawel minMainTestCrawel=new MainTestCrawel();
		String urlString = "http://www.91job.gov.cn/manage/USC/USC001.aspx?a1=USC&a2=USC001&xb=0&zy=&xldm=&xx=";
		// 20个线程跑
		minMainTestCrawel.MainCrawel(urlString);

	}

	class testLoopRunner implements Runnable {

		/* (non-Javadoc)
		 * 
		 * @see java.lang.Runnable#run() */
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (int i = 0; i < 10; i++) {
				System.out.println(i + "------" + Thread.currentThread().getName());
			}
		}

	}

}
