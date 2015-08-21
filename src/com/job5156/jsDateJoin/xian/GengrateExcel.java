/**
 * 
 */
package com.job5156.jsDateJoin.xian;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 * @author lyh
 * @Description 
 * @date 2015��8��18��
 * 
 */
public class GengrateExcel {
	
	public static void WriterExcel(List listData, Integer page,String path,Integer metaType,int lables) {
		String f=CopyOfTestDb.getByFileS(page);
		String path1=path+f+".xls";
		File file = new File(path1);
		WritableWorkbook writableWorkbook = null; //д������
		Workbook book;
		WritableSheet writableSheet; //�õ�д��ı�
		Integer No=page/63; //�õ������
		No=CopyOfTestDb.getPageNo(page);
		int length=1;
		try {
			//���ж��ļ� �Ƿ����	
			if (!file.exists()) {
				writableWorkbook = Workbook.createWorkbook(file);
				writableSheet = writableWorkbook.createSheet(String.valueOf(metaType), 0);
				getMetaMethod(metaType, writableSheet);
			} else{
					FileInputStream in = new FileInputStream(file);
					book = Workbook.getWorkbook(in);
					writableWorkbook = Workbook.createWorkbook(file, book); // ����book����һ����������
					writableSheet = writableWorkbook.getSheet(No);// �õ�һ����������
				   if(writableSheet!=null){
					   length=writableSheet.getRows();
					   int temp=length+1000;
					   if(temp>63000){
						  No++;
						  writableSheet = writableWorkbook.createSheet(String.valueOf(metaType)+No,No);
						  getMetaMethod(metaType, writableSheet);
						  length=1;
					   }
					   
				   }else{
					   writableSheet = writableWorkbook.createSheet(String.valueOf(metaType)+No,No);
					   getMetaMethod(metaType, writableSheet);
						length=1;
				   }
				}
			int i1=length;
			int dataLen = listData.size();
			for (int i = 1; i <= dataLen; i++) {
				Object[] obj = (Object[]) listData.get(i - 1);
				for (int j = 1; j < lables; j++) {
					Label[] labels = new Label[lables];
					labels[0] = new Label(0, i1, String.valueOf(i1));
					labels[j] = new Label(j, i1, (String) obj[j]);
					writableSheet.addCell(labels[j]);
					writableSheet.addCell(labels[0]);

				}
				i1++;
			}
		System.out.println("--------д��---------"+No+"�ļ���� "+f+"--------��-----"+page+"----------");

			//System.out.println("---------------��------" + page + "--------ҳ����ɹ���-----------------");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			// 3.1 д��Exel������
			try {
				writableWorkbook.write();
				// 4.1 �ر�Excel����������
				try {
					writableWorkbook.close();
				} catch (WriteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		// 1.2 ����Excel������

	}
	
	public static void getMetaMethod(Integer mediType,WritableSheet writableSheet){
		
		if(mediType==0){
			CopyOfTestDb.writeMetaDate(writableSheet);
		}
		else if(mediType==1){
			CopyOfTestDb.writePerIntentInfoMetaData(writableSheet);
		}
		else if(mediType==2){
			CopyOfTestDb.writePerTraninfoMetaData(writableSheet);
		}
		else if(mediType==3){
			CopyOfTestDb.writePerEducationMetaData(writableSheet);
		}
		else if(mediType==4){
			CopyOfTestDb.writePerWorkInfoMetaDate(writableSheet);
		}
	}

}
