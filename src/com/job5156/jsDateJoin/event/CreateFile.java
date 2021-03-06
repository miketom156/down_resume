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

import com.job5156.util.StaticFileTools;
import com.job5156.util.StringUtil;

public class CreateFile {
	
	public static void main(String[] args) {
		System.out.println("---开始---");
		loadingCompanyFile("F:/jsInpuDate/shop.xls");
		System.out.println("---结束---");

	}
	
	public static void loadingCompanyFile(String filePathTemp){		
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
		
		//operat(workBook);
		operat(workBook);
		workBook.close();// 记得关闭	
	}
	
	public static void operat(Workbook workBook){
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
		StringBuffer buffer = new StringBuffer();
		buffer.append("public static final String[][] shop=\n");
		buffer.append("{\n");
		for (int i=0;i<sheet.getRows();i++){
			cell = sheet.getCell(0,i);
			String temp1 = StringUtil.getNotNullStr(cell.getContents());
			
			cell = sheet.getCell(1,i);
			String temp2 = StringUtil.getNotNullStr(cell.getContents());
			
			buffer.append("{\""+temp1+"\",\""+temp2+"\",\"\"},\n");			
		}
		buffer.append("};");
		
		StaticFileTools.saveFile2Disk("f:/shop.html",buffer.toString());
	}
	
	public static void operatNation(Workbook workBook){
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
		StringBuffer buffer = new StringBuffer();
		buffer.append("public static final String[][] nationT=\n");
		buffer.append("{\n");
		for (int i=0;i<sheet.getRows();i++){
			cell = sheet.getCell(0,i);
			String temp1 = StringUtil.getNotNullStr(cell.getContents());
			
			cell = sheet.getCell(1,i);
			String temp2 = StringUtil.getNotNullStr(cell.getContents());
			
			buffer.append("{\""+temp1+"\",\"\",\""+temp2+"\"},\n");			
		}
		buffer.append("};");
		
		StaticFileTools.saveFile2Disk("f:/shop.html",buffer.toString());
	}

}
