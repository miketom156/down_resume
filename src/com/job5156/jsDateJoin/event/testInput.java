package com.job5156.jsDateJoin.event;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.job5156.jsDateJoin.entity.test2;
import com.job5156.server.EntityManager;
import com.job5156.server.LocalSessionManager;
import com.job5156.util.StringUtil;

public class testInput {
	private static Logger log = Logger.getLogger(testInput.class);
	private static String[][] OPT_Company={
		{"1", "e:/test1.xls",""},
		{"2", "e:/test2.xls",""}		
	};
	public static void main(String[] args) {
		System.out.println("----------开始！");
		long begintime = System.currentTimeMillis();
		
		run();
		
		long endtime = System.currentTimeMillis();
		System.out.println("----------结束！用时："+(endtime - begintime)/1000/60+" 分钟");
		log.error("江苏人才网 jxl 导入数据库 用时："+(endtime - begintime)/1000/60+" 分钟");
	}
	
	public static void run(){
		Session session  = LocalSessionManager.currentSession();
		for(int i=0;i<OPT_Company.length;i++){			
			loadingFile(session,OPT_Company[i][1]);
		}
		session.close();
	}
	
	public static void loadingFile(Session session,String filePathTemp){
		
		String filePath = filePathTemp;
		InputStream fs = null;
		Workbook workBook = null;

		try {
			// 加载excel文件
			fs = new FileInputStream(filePath);
			// 得到 workbook
			workBook = Workbook.getWorkbook(fs);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		operat(session,workBook);		
		workBook.close();// 记得关闭
		
		
	}
	
	public static void operat(Session session,Workbook workBook){		
		// 取得sheet，如果你的workbook里有多个sheet 可以利用 wb.getSheets()方法来得到所有的。
		// getSheets() 方法返回 Sheet[] 数组 然后利用数组来操作。就是多次循环的事。
		Sheet sheet = workBook.getSheet(0);// 这里只取得第一个sheet的值，默认从0开始
		//System.out.println(sheet.getColumns());// 查看sheet的列
		//System.out.println(sheet.getRows());// 查看sheet的行
		Cell cell = null;// 就是单个单元格
		// 开始循环，取得 cell 里的内容，这里都是按String来取的 为了省事，具体你自己可以按实际类型来取。或者都按
		// String来取。然后根据你需要强制转换一下。
		int m = 0;		
		List list = new ArrayList();
		
		for (int i = 0; i < sheet.getRows(); i++) {			
			test2 t = new test2();
			cell = sheet.getCell(1,i);
			t.setUsername(StringUtil.getNotNullStr(cell.getContents()));
			
			cell = sheet.getCell(2,i);
			t.setPassword(StringUtil.getNotNullStr(cell.getContents()));
			
			cell = sheet.getCell(3,i);
			t.setTid(StringUtil.parseInt(cell.getContents()));
			
			cell = sheet.getCell(4,i);
			t.setUrl(StringUtil.getNotNullStr(cell.getContents()));			
			
			list.add(t);
			
			m++;
			if(m>5){
				saveDate(session,list);
				m=0;
				list.clear();				
			}			
		}
		saveDate(session,list);			
		list.clear();
		
	}
	
	public static void saveDate(Session session,List list){
		Object[] obj = new Object[list.size()];
				
		for(int j=0;j<list.size();j++){
			obj[j]=list.get(j);
		}
		
		EntityManager.batchSave(obj, session);
		session.flush();
		session.clear();		
	}
}