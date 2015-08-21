package com.job5156.jsDateJoin.event;

import java.io.File;
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
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import com.job5156.util.StaticFileTools;
import com.job5156.util.StringUtil;

public class CreateFileXiAn {
	
	public static void main(String[] args) {
		/*  try {
    WritableWorkbook writableWorkbook = Workbook .createWorkbook(new File("c://test.xls"));
         // 1.2 ����Excel������
         WritableSheet writableSheet = writableWorkbook.createSheet("������Ϣ", 0);
         
         // 2.1 ���Label����
         Label label00 = new Label(1,2, "���Դ�����ͨ��Ԫ��label00");
         writableSheet.addCell(label00);
         // 3.1 д��Exel������
         writableWorkbook.write();
         // 4.1 �ر�Excel����������
         writableWorkbook.close();
	}
		
         catch (Exception e) {
 			// TODO Auto-generated catch block
 			e.printS
 			tackTrace();
 		}*/
			 
			 File file=new File("c://2.xls");
			 Workbook book;
			try {
				book = Workbook.getWorkbook(file);
				 Sheet sheet = book.getSheet(0);
				   // ��ȡ��  
			        int length = sheet.getRows();  
			        System.out.println(length);  
			        WritableWorkbook wbook = Workbook.createWorkbook(file, book); // ����book����һ����������  
			        WritableSheet sh = wbook.getSheet(0);// �õ�һ����������  
			        System.out.println(sh.getRows()+"---______________");
			        // �����һ�п�ʼ��  
			        String []  str={"1","2","3","4","5","6"};
			      //  for (int i = 0; i < args.length; i++) {  
			            Label label = new Label(0, 1, "��12312����");  
			            sh.addCell(label);  
			      //  }  
			        wbook.write();  
			        wbook.close();  
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				e.printStackTrace();
			}  
		    
		     
			 
			 
			 

/*System.out.println("---��ʼ---");
		loadingCompanyFile("F:/jsInpuDate/shop.xls");
		System.out.println("---����---");*/

	}
	
	public static void loadingCompanyFile(String filePathTemp){		
		String filePath = filePathTemp;
		InputStream fs = null;
		Workbook workBook = null;
		
		try {
			// ����excel�ļ�
			fs = new FileInputStream(filePath);
			// �õ� workbook
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
		workBook.close();// �ǵùر�	
	}
	
	public static void operat(Workbook workBook){
		// ȡ��sheet��������workbook���ж��sheet �������� wb.getSheets()�������õ����еġ�
		// getSheets() �������� Sheet[] ���� Ȼ���������������������Ƕ��ѭ�����¡�
		Sheet sheet = workBook.getSheet(0);// ����ֻȡ�õ�һ��sheet��ֵ��Ĭ�ϴ�0��ʼ
		//System.out.println(sheet.getColumns());// �鿴sheet����
		//System.out.println(sheet.getRows());// �鿴sheet����
		Cell cell = null;// ���ǵ�����Ԫ��
		// ��ʼѭ����ȡ�� cell ������ݣ����ﶼ�ǰ�String��ȡ�� Ϊ��ʡ�£��������Լ����԰�ʵ��������ȡ�����߶���
		// String��ȡ��Ȼ���������Ҫǿ��ת��һ�¡�
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
		// ȡ��sheet��������workbook���ж��sheet �������� wb.getSheets()�������õ����еġ�
		// getSheets() �������� Sheet[] ���� Ȼ���������������������Ƕ��ѭ�����¡�
		Sheet sheet = workBook.getSheet(0);// ����ֻȡ�õ�һ��sheet��ֵ��Ĭ�ϴ�0��ʼ
		//System.out.println(sheet.getColumns());// �鿴sheet����
		//System.out.println(sheet.getRows());// �鿴sheet����
		Cell cell = null;// ���ǵ�����Ԫ��
		// ��ʼѭ����ȡ�� cell ������ݣ����ﶼ�ǰ�String��ȡ�� Ϊ��ʡ�£��������Լ����԰�ʵ��������ȡ�����߶���
		// String��ȡ��Ȼ���������Ҫǿ��ת��һ�¡�
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
