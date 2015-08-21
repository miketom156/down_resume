/**
 * 
 */
package com.job5156.jsDateJoin.xian;

import java.sql.Connection;

import org.hibernate.Session;

import com.job5156.server.SessionManager;

/**
 * @author lyh
 * @Description
 * @date 2015Äê8ÔÂ19ÈÕ
 */
public class TestRunner {

	/**
	 * @Description: TODO
	 * @param @param args
	 * @return void
	 * @throws
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	CopyOfTestDb ctd = new CopyOfTestDb();
		Thread t1 = new Thread(ctd.new ExcelRunner(), "t1");
		t1.start();*/
		Session session = null;
		Connection con = null;
		session = SessionManager.currentSession();
		con = session.connection();
		Integer page=0;
		page=AnalyDB.getPerIntentPage(con);
		new Thread(new TestRunner.IntentRunner(con, page)).start();
		new Thread(new TestRunner.WorkInfoRunner(con, page)).start();
		new Thread(new TestRunner.EducationRunner(con, page)).start();
		new Thread(new TestRunner.TraninfoRunner(con, page)).start();
		
	}

	public static class PerRunner implements Runnable {

		private Connection con;
		private Integer index;
		private String f;

		public String getF() {
			return f;
		}

		public void setF(String f) {
			this.f = f;
		}

		public Integer getIndex() {
			return index;
		}

		public void setIndex(Integer index) {
			this.index = index;
		}

		public Connection getCon() {
			return con;
		}

		public void setCon(Connection con) {
			this.con = con;
		}

		public PerRunner(Connection con,Integer index,String f) {
			this.con = con;
			this.index=index;
			this.f=f;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			CopyOfTestDb.getPerExcel2(con,index,f);
		}

	}

	public static class IntentRunner implements Runnable {

		private Connection con;
		private Integer page;

		public Integer getPage() {
			return page;
		}

		public void setPage(Integer page) {
			this.page = page;
		}

		public Connection getCon() {
			return con;
		}

		public void setCon(Connection con) {
			this.con = con;
		}

		public IntentRunner(Connection con, Integer page) {
			this.con = con;
			this.page = page;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			CopyOfTestDb.getPerIntentInfosExcel(con, page);
		}

	}

	public static class WorkInfoRunner implements Runnable {

		private Connection con;
		private Integer page;

		public Integer getPage() {
			return page;
		}

		public void setPage(Integer page) {
			this.page = page;
		}

		public Connection getCon() {
			return con;
		}

		public void setCon(Connection con) {
			this.con = con;
		}

		public WorkInfoRunner(Connection con, Integer page) {
			this.con = con;
			this.page = page;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			CopyOfTestDb.getPerWorkinfoExcel(con, page);
		}

	}

	public static class EducationRunner implements Runnable {

		private Connection con;
		private Integer page;

		public Integer getPage() {
			return page;
		}

		public void setPage(Integer page) {
			this.page = page;
		}

		public Connection getCon() {
			return con;
		}

		public void setCon(Connection con) {
			this.con = con;
		}

		public EducationRunner(Connection con, Integer page) {
			this.con = con;
			this.page = page;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			CopyOfTestDb.getPerEducationExcel(con, page);
		}

	}

	public static class TraninfoRunner implements Runnable {

		private Connection con;
		private Integer page;

		public Integer getPage() {
			return page;
		}

		public void setPage(Integer page) {
			this.page = page;
		}

		public Connection getCon() {
			return con;
		}

		public void setCon(Connection con) {
			this.con = con;
		}

		public TraninfoRunner(Connection con, Integer page) {
			this.con = con;
			this.page = page;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			CopyOfTestDb.getPerTraninfoExcel(con, page);
		}

	}
}
