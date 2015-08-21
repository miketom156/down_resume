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
 * @date 2015年8月18日
 * 
 */
public class GengrateExcel {
	
	public static void WriterExcel(List listData, Integer page,String path,Integer metaType,int lables) {
		String f=CopyOfTestDb.getByFileS(page);
		String path1=path+f+".xls";
		File file = new File(path1);
		WritableWorkbook writableWorkbook = null; //写工作本
		Workbook book;
		WritableSheet writableSheet; //得到写入的表单
		Integer No=page/63; //得到表单编号
		No=CopyOfTestDb.getPageNo(page);
		int length=1;
		try {
			//先判断文件 是否存在	
			if (!file.exists()) {
				writableWorkbook = Workbook.createWorkbook(file);
				writableSheet = writableWorkbook.createSheet(String.valueOf(metaType), 0);
				getMetaMethod(metaType, writableSheet);
			} else{
					FileInputStream in = new FileInputStream(file);
					book = Workbook.getWorkbook(in);
					writableWorkbook = Workbook.createWorkbook(file, book); // 根据book创建一个操作对象
					writableSheet = writableWorkbook.getSheet(No);// 得到一个工作对象
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
		System.out.println("--------写入---------"+No+"文件编号 "+f+"--------表单-----"+page+"----------");

			//System.out.println("---------------第------" + page + "--------页输入成功！-----------------");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			// 3.1 写入Exel工作表
			try {
				writableWorkbook.write();
				// 4.1 关闭Excel工作薄对象
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
		// 1.2 创建Excel工作表

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
