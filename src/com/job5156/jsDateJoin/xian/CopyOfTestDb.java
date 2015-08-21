/**
 * 
 */
package com.job5156.jsDateJoin.xian;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;

import com.job5156.jsDateJoin.xian.PerResumeVo.EducationInfoVo;
import com.job5156.jsDateJoin.xian.PerResumeVo.IntentInfoVo;
import com.job5156.jsDateJoin.xian.PerResumeVo.TrainInfoVo;
import com.job5156.jsDateJoin.xian.PerResumeVo.WorkInfoVo;
import com.job5156.server.SessionManager;

/**
 * @author lyh
 * @Description
 * @date 2015��8��5��
 */
public class CopyOfTestDb {

	/**
	 * @Description: TODO
	 * @param @param args
	 * @return void
	 * @throws
	 */
	
	private static String filePath="C://Users//Administrator//Desktop//jiansu//excel2//";
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CopyOfTestDb ctd = new CopyOfTestDb();
		Thread t1 = new Thread(ctd.new ExcelRunner(), "t1");
		t1.start();
		
	}

class ExcelRunner implements Runnable{

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		getExcelData();
	}
	
	
}
	
	
	
	
	
	
	
	
	
	/** 
	* @Description: TODO
	* @param    
	* @return void
	* @throws 
	*/
	private static void getExcelData() {
		Session session = null;
		Connection con = null;
		session = SessionManager.currentSession();
		con = session.connection();
		Integer page=0;
		//getPerExcel2(con,0,"0");
		//д����˻�����Ϣ
		//page=AnalyDB.getPerIntentPage(con);
		//getPerIntentInfosExcel(con, page);
		page=AnalyDB.getPerWorkPage(con);
		getPerWorkinfoExcel(con, page);
		page=AnalyDB.getPerEducationPage(con);
		getPerEducationExcel(con, page);
		page=AnalyDB.getPerTrainPage(con);
		getPerTraninfoExcel(con, page);
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/** 
	* @Description: TODO
	* @param @param con
	* @param @param page   
	* @return void
	* @throws 
	*/
	public static void getPerTraninfoExcel(Connection con, Integer page) {
		for(int i=0;i<page;i++){
			Integer startIndex = i * 1000;
			List listData = AnalyDB.traninfos(con, startIndex, 1000);
			GengrateExcel.WriterExcel(listData, i, filePath+"traninfo", 2, 9);
		}
	}

	/** 
	* @Description: TODO
	* @param @param con
	* @param @param page   
	* @return void
	* @throws 
	*/
	public static void getPerEducationExcel(Connection con, Integer page) {
		for(int i=0;i<page;i++){
			Integer startIndex = i * 1000;
			List listData = AnalyDB.educations(con, startIndex, 1000);
			GengrateExcel.WriterExcel(listData, i, filePath+"edu", 3, 6);
		}
	}

	/** 
	* @Description: TODO
	* @param @param con
	* @param @param page   
	* @return void
	* @throws 
	*/
	public static void getPerWorkinfoExcel(Connection con, Integer page) {
		for(int i=0;i<page;i++){
			Integer startIndex = i * 1000;
			List listData = AnalyDB.WorkInfos(con, startIndex, 1000);
			GengrateExcel.WriterExcel(listData, i, filePath+"workinfo", 4, 12);
		}
	}

	/** 
	* @Description: TODO
	* @param @param con
	* @param @param page   
	* @return void
	* @throws 
	*/
	public static void getPerIntentInfosExcel(Connection con, Integer page) {
		System.out.println("-------ִ��--------"+page+"---------������--------------");
		for(int i=400;i<page;i++){
			Integer startIndex = i * 1000;   
			List listData = AnalyDB.intentInfos(con, startIndex, 1000);
			GengrateExcel.WriterExcel(listData, i, filePath+"intentinfo", 1, 6);
		}
	}

	/** 
	* @Description: TODO
	* @param @param con   
	* @return void
	* @throws 
	*/
	public static void getPerExcel(Connection con) {
		Integer page;
		//д����˻�����Ϣ
	    page=AnalyDB.getPerPage(con);
		System.out.println("----------ִ��-----"+page+"-------������----------------");
		for(int i=0;i<page;i++){
			Integer startIndex = i * 1000;
			List listData = AnalyDB.PerUsers(con, startIndex, 1000);
			//WriterPerUser(listData, i);
	     System.out.println("----------ִ��-----"+i+"-------��ҳ����----------------");	
		}
	}

	public static void getPerExcel2(Connection con,Integer index,String f) {
		Integer page;
		//д����˻�����Ϣ
	    page=AnalyDB.getPerPage(con);
	    int temp=index==0?0:index;
		System.out.println("----------ִ��-----"+page+"-------������----------------");
		for(int i=temp;i<page;i++){
			Integer startIndex = i * 1000;
			List listData = AnalyDB.PerUsers(con, startIndex, 1000);
			WriterPerUser(listData, i, f);
			if(Thread.interrupted()){
				getPerExcel2(con,i,f);
			}
	     System.out.println("----------ִ��-----"+i+"-------��ҳ����----------------");	
		}
	}
	public static void WriterPerUser(List listData, Integer page,String f) {
		f = getByFileS(page);
		String path = filePath+"peruser"+f+".xls";
		File file = new File(path);
		WritableWorkbook writableWorkbook = null; //д������
		Workbook book;
		WritableSheet writableSheet; //�õ�д��ı�
		Integer No=page/63; //�õ������

		No = getPageNo(page);
		int length=1;
		try {
			//���ж��ļ� �Ƿ����	
			if (!file.exists()) {
				writableWorkbook = Workbook.createWorkbook(file);
				writableSheet = writableWorkbook.createSheet("per0", 0);
				 writeMetaDate(writableSheet);
			} else{
				FileInputStream in = new FileInputStream(file);
				book = Workbook.getWorkbook(in);
				writableWorkbook = Workbook.createWorkbook(file, book); // ����book����һ����������
				writableSheet = writableWorkbook.getSheet(No);// �õ�һ����������
				if (writableSheet != null) {
					length = writableSheet.getRows();
					  length=writableSheet.getRows();
					  int temp=length+1000;
					if (temp > 63000) {
						No++;
						writableSheet = writableWorkbook.createSheet("per" + No, No);
						writeMetaDate(writableSheet);
						length = 1;
					}

				} else {
					writableSheet = writableWorkbook.createSheet("per" + No, No);
					writeMetaDate(writableSheet);
					length = 1;
				}
				}
			System.out.println("--------д��---------"+No+"�ļ���� "+f+"--------��-----"+page+"----------");
			 int i1=length;
			 int listLen=listData.size();
				for (int i = 1; i<= listLen; i++) {
					Object[] obj = (Object[]) listData.get(i-1);
					Label label = new Label(0, i1, (String) obj[0]);
					//System.out.println(obj[0]+"----id--??");
					Label labe2 = new Label(1, i1, (String) obj[1]);
					Label labe3 = new Label(2, i1, (String) obj[2]);
					Label labe4 = new Label(3, i1, (String) obj[3]);
					Label labe5 = new Label(4, i1, (String) obj[4]);
					Label labe6 = new Label(5, i1, (String) obj[5]);
					Label labe7 = new Label(6, i1, (String) obj[6]);
					Label labe8 = new Label(7, i1, (String) obj[7]);
					Label labe9 = new Label(8, i1, (String) obj[8]);
					Label labe10 = new Label(9, i1, (String) obj[9]);
					Label labe11 = new Label(10, i1, (String) obj[10]);
					Label labe12 = new Label(11, i1, (String) obj[11]);
					writableSheet.addCell(label);
					writableSheet.addCell(labe2);
					writableSheet.addCell(labe3);
					writableSheet.addCell(labe4);
					writableSheet.addCell(labe5);
					writableSheet.addCell(labe6);
					writableSheet.addCell(labe7);
					writableSheet.addCell(labe8);
					writableSheet.addCell(labe9);
					writableSheet.addCell(labe10);
					writableSheet.addCell(labe11);
					writableSheet.addCell(labe12);
					//System.out.println("--------д��---------"+i1+"----------"+No+"---��-----------");
					i1++;
				}

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

	/** 
	* @Description: �õ� ����� 
	* @param @param page
	* @param @param No
	* @param @return   
	* @return Integer
	* @throws 
	*/
	public static Integer getPageNo(Integer page) {
		Integer No=0;
		if(page>=100){
			No=(page-100)/63;
		}
		if(page>=200){
			No=(page-200)/63;
		}
		if(page>=300){
			No=(page-300)/63;
		}
		if(page>=400){
			No=(page-400)/63;
		}
		if(page>=500){
			No=(page-500)/63;
		}
		return No;
	}

	/** 
	* @Description: �õ��ļ����
	* @param @param page
	* @param @param f
	* @param @return   
	* @return String
	* @throws 
	*/
	public static String getByFileS(Integer page) {
		String f="0";
		if(page>=100){
			f="1";
		}
		if(page>=200){
			f="2";
		}
		if(page>=300){
			f="3";
		}
		
		if(page>=400){
			f="4";
		}
		if(page>=500){
			f="5";
		}
		return f;
	}
	
	
	public  static void writeMetaDate(WritableSheet writableSheet)
	{
		int i1=0;
		Label label = new Label(0, i1, "���˱��");
		Label labe2 = new Label(1, i1, "�û���");
		Label labe3 = new Label(2, i1, "����");
		Label labe4 = new Label(3, i1,"�����ʼ�");
		Label labe5 = new Label(4, i1, "��ʵ����");
		Label labe6 = new Label(5, i1, "���֤����");
		Label labe7 = new Label(6, i1,"�Ա�");
		Label labe8 = new Label(7, i1, "�������ڵ�");
		Label labe9 = new Label(8, i1, "��ס��");
		Label labe10 = new Label(9, i1, "��������");
		Label labe11 = new Label(10, i1, "������ҳ");
		Label labe12 = new Label(11, i1, "��ϵ����");
		try {
			writableSheet.addCell(label);
			writableSheet.addCell(labe2);
			writableSheet.addCell(labe3);
			writableSheet.addCell(labe4);
			writableSheet.addCell(labe5);
			writableSheet.addCell(labe6);
			writableSheet.addCell(labe7);
			writableSheet.addCell(labe8);
			writableSheet.addCell(labe9);
			writableSheet.addCell(labe10);
			writableSheet.addCell(labe11);
			writableSheet.addCell(labe12);
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void writePerIntentInfoMetaData(WritableSheet writableSheet) {
		int i1 = 0;
		Label label = new Label(0, i1, "���");
		Label labe2 = new Label(1, i1, "���˱��");
		Label labe3 = new Label(2, i1, "������ְ����");
		Label labe4 = new Label(3, i1, "��������");
		Label labe5 = new Label(4, i1, "ְλ����");
		Label labe6 = new Label(5, i1, "н��Ҫ��");

		try {
			writableSheet.addCell(label);
			writableSheet.addCell(labe2);
			writableSheet.addCell(labe3);
			writableSheet.addCell(labe4);
			writableSheet.addCell(labe5);
			writableSheet.addCell(labe6);
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public static void writePerEducationMetaData(WritableSheet writableSheet) {
		int i1 = 0;
		Label label = new Label(0, i1, "���");
		Label labe2 = new Label(1, i1, "���˱��");
		Label labe3 = new Label(2, i1, "��ҵʱ��");
		Label labe4 = new Label(3, i1, "��ҵԺУ");
		Label labe5 = new Label(4, i1, "רҵ");
		Label labe6 = new Label(5, i1, "ѧ��");

		try {
			writableSheet.addCell(label);
			writableSheet.addCell(labe2);
			writableSheet.addCell(labe3);
			writableSheet.addCell(labe4);
			writableSheet.addCell(labe5);
			writableSheet.addCell(labe6);
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void writePerTraninfoMetaData(WritableSheet writableSheet) {
		int i1 = 0;
		Label label = new Label(0, i1, "���");
		Label labe2 = new Label(1, i1, "���˱��");
		Label labe3 = new Label(2, i1, "��ʼʱ��");
		Label labe4 = new Label(3, i1, "����ʱ��");
		Label labe5 = new Label(4, i1, "��ѵ����");
		Label labe6 = new Label(5, i1, "��ѵ��ַ");
		Label labe7 = new Label(6, i1, "��ѵ�γ�");
		Label labe8 = new Label(7, i1, "��ѵ֤��");
		Label labe9 = new Label(8, i1, "��ѵ��ϸ���");

		try {
			writableSheet.addCell(label);
			writableSheet.addCell(labe2);
			writableSheet.addCell(labe3);
			writableSheet.addCell(labe4);
			writableSheet.addCell(labe5);
			writableSheet.addCell(labe6);
			writableSheet.addCell(labe7);
			writableSheet.addCell(labe8);
			writableSheet.addCell(labe9);
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public  static void writePerWorkInfoMetaDate(WritableSheet writableSheet)
	{
		int i1=0;
		Label label = new Label(0, i1, "���");
		Label labe2 = new Label(1, i1, "���˱��");
		Label labe3 = new Label(2, i1, "��λ����");
		Label labe4 = new Label(3, i1,"��λ����");
		Label labe5 = new Label(4, i1, "��ҵ��ģ");
		Label labe6 = new Label(5, i1, "��ҵ��ҵ");
		Label labe7 = new Label(6, i1,"��������");
		Label labe8 = new Label(7, i1, "ְλ");
		Label labe9 = new Label(8, i1, "��ʼʱ��");
		Label labe10 = new Label(9, i1, "����ʱ��");
		Label labe11 = new Label(10, i1, "н�ʴ���");
		Label labe12 = new Label(11, i1, "ְλ����");
		try {
			writableSheet.addCell(label);
			writableSheet.addCell(labe2);
			writableSheet.addCell(labe3);
			writableSheet.addCell(labe4);
			writableSheet.addCell(labe5);
			writableSheet.addCell(labe6);
			writableSheet.addCell(labe7);
			writableSheet.addCell(labe8);
			writableSheet.addCell(labe9);
			writableSheet.addCell(labe10);
			writableSheet.addCell(labe11);
			writableSheet.addCell(labe12);
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	/*
	 * 
	 * 
	 */
	
	
	
	
	
	// //��ְ��ͼ
	public static void wirteExcel(List listData) {
		WritableWorkbook writableWorkbook;
		try {
			writableWorkbook = Workbook.createWorkbook(new File("C://Users//Administrator//Desktop//jiansu//excel//intentinfo.xls"));
			WritableSheet writableSheet = writableWorkbook.createSheet("��ְ����", 0);

			for (int i = 1; i <= listData.size(); i++) {
				Object[] obj = (Object[]) listData.get(i - 1);
				PerResumeVo.IntentInfoVo intent = (IntentInfoVo) obj[0];
				String useId = (String) obj[1];
				Label label = new Label(0, i, String.valueOf(i));
				writableSheet.addCell(label);
				Label label11 = new Label(1, i, useId);
				writableSheet.addCell(label11);
				Label lab2 = new Label(2, i, intent.getJobTypeStr() != null ? intent.getJobTypeStr() : "112");
				writableSheet.addCell(lab2);
				Label lab3 = new Label(3, i, intent.getJobLocationStr());
				writableSheet.addCell(lab3);
				Label lab4 = new Label(4, i, intent.getJobCodeStr());
				writableSheet.addCell(lab4);
				Label lab5 = new Label(5, i, intent.getSalaryStr());
				writableSheet.addCell(lab5);

			}
			// 3.1 д��Exel������
			writableWorkbook.write();
			// 4.1 �ر�Excel����������
			writableWorkbook.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 1.2 ����Excel������

	}

	// ������Ϣ
	public static void wirteExcel2(List listData) {
		WritableWorkbook writableWorkbook;
		try {
			writableWorkbook = Workbook.createWorkbook(new File("C://Users//Administrator//Desktop//jiansu//excel//workinfo.xls"));
			WritableSheet writableSheet = writableWorkbook.createSheet("��ְ����", 0);

			for (int i = 1; i <= listData.size(); i++) {
				Object[] obj = (Object[]) listData.get(i - 1);
				PerResumeVo.WorkInfoVo work = (WorkInfoVo) obj[0];
				String UseId = (String) obj[1];
				Label label = new Label(0, i, String.valueOf(i));
				Label labe12 = new Label(1, i, UseId);
				Label labe2 = new Label(2, i, work.getComName());
				Label labe3 = new Label(3, i, work.getComTypeStr());
				Label labe4 = new Label(4, i, work.getComScaleStr());
				Label labe5 = new Label(5, i, work.getComCallingStr());
				Label labe6 = new Label(6, i, work.getSection());
				Label labe7 = new Label(7, i, work.getJobNameStr());
				Label labe8 = new Label(8, i, work.getBegin());
				Label labe9 = new Label(9, i, work.getEnd());
				Label labe10 = new Label(10, i, work.getSalaryStr());
				Label labe11 = new Label(11, i, work.getDescription());
				writableSheet.addCell(label);
				writableSheet.addCell(labe2);
				writableSheet.addCell(labe3);
				writableSheet.addCell(labe4);
				writableSheet.addCell(labe5);
				writableSheet.addCell(labe6);
				writableSheet.addCell(labe7);
				writableSheet.addCell(labe8);
				writableSheet.addCell(labe9);
				writableSheet.addCell(labe10);
				writableSheet.addCell(labe11);
				writableSheet.addCell(labe12);
			}
			// 3.1 д��Exel������
			writableWorkbook.write();
			// 4.1 �ر�Excel����������
			writableWorkbook.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 1.2 ����Excel������

	}

	// ��ѵ��Ϣ
	public static void wirteExcel3(List listData) {
		WritableWorkbook writableWorkbook;
		try {
			writableWorkbook = Workbook.createWorkbook(new File("C://Users//Administrator//Desktop//jiansu//excel//traninfo.xls"));
			WritableSheet writableSheet = writableWorkbook.createSheet("��ѵ��Ϣ", 0);

			for (int i = 1; i <= listData.size(); i++) {
				Object[] obj = (Object[]) listData.get(i - 1);
				PerResumeVo.TrainInfoVo work = (TrainInfoVo) obj[0];
				String UseId = (String) obj[1];
				Label label = new Label(0, i, String.valueOf(i));
				Label labe2 = new Label(1, i, UseId);
				Label labe3 = new Label(2, i, work.getBegin());
				Label labe4 = new Label(3, i, work.getEnd());
				Label labe5 = new Label(4, i, work.getTrainSchoolName());
				Label labe6 = new Label(5, i, work.getPlaceStr());
				Label labe7 = new Label(6, i, work.getTrainCourse());
				Label labe8 = new Label(7, i, work.getCertificate());
				Label labe9 = new Label(8, i, work.getCourseDescription());

				writableSheet.addCell(label);
				writableSheet.addCell(labe2);
				writableSheet.addCell(labe3);
				writableSheet.addCell(labe4);
				writableSheet.addCell(labe5);
				writableSheet.addCell(labe6);
				writableSheet.addCell(labe7);
				writableSheet.addCell(labe8);
				writableSheet.addCell(labe9);

			}
			// 3.1 д��Exel������
			writableWorkbook.write();
			// 4.1 �ر�Excel����������
			writableWorkbook.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 1.2 ����Excel������

	}

	// ������Ϣ
	public static void wirteExcel4(List listData) {
		WritableWorkbook writableWorkbook;
		try {
			writableWorkbook = Workbook.createWorkbook(new File("C://Users//Administrator//Desktop//jiansu//excel//eduacation.xls"));
			WritableSheet writableSheet = writableWorkbook.createSheet("������Ϣ", 0);

			for (int i = 1; i <= listData.size(); i++) {
				Object[] obj = (Object[]) listData.get(i - 1);
				PerResumeVo.EducationInfoVo work = (PerResumeVo.EducationInfoVo) obj[0];
				String UseId = (String) obj[1];
				Label label = new Label(0, i, String.valueOf(i));
				Label labe2 = new Label(1, i, UseId);
				Label labe3 = new Label(2, i, work.getEnd());
				Label labe4 = new Label(3, i, work.getSchoolName());
				Label labe5 = new Label(4, i, work.getSpeciality());
				Label labe6 = new Label(5, i, work.getDegreeStr());

				writableSheet.addCell(label);
				writableSheet.addCell(labe2);
				writableSheet.addCell(labe3);
				writableSheet.addCell(labe4);
				writableSheet.addCell(labe5);
				writableSheet.addCell(labe6);
			}
			// 3.1 д��Exel������
			writableWorkbook.write();
			// 4.1 �ر�Excel����������
			writableWorkbook.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 1.2 ����Excel������

	}

	// ������Ϣ
	public static void wirteExcelToAppend(List listData) {
		WritableWorkbook writableWorkbook;
		Workbook book;
		File file = new File("C://Users//Administrator//Desktop//jiansu//test.xls");
		try {
			FileInputStream in = new FileInputStream(file);
			book = Workbook.getWorkbook(in);
			// Sheet sheet = book.getSheet(0);
			// ��ȡ��
			// int length = sheet.getRows();
			writableWorkbook = Workbook.createWorkbook(file, book); // ����book����һ����������
			WritableSheet writableSheet = writableWorkbook.createSheet("ss", 7);

			for (int i = 1; i <= listData.size(); i++) {
				Object[] obj = (Object[]) listData.get(i - 1);
				PerResumeVo.EducationInfoVo work = (PerResumeVo.EducationInfoVo) obj[0];
				String UseId = (String) obj[1];
				Label label = new Label(0, i, String.valueOf(i));
				Label labe2 = new Label(1, i, UseId);
				Label labe3 = new Label(2, i, work.getEnd());
				Label labe4 = new Label(3, i, work.getSchoolName());
				Label labe5 = new Label(4, i, work.getSpeciality());
				Label labe6 = new Label(5, i, work.getDegreeStr());

				writableSheet.addCell(label);
				writableSheet.addCell(labe2);
				writableSheet.addCell(labe3);
				writableSheet.addCell(labe4);
				writableSheet.addCell(labe5);
				writableSheet.addCell(labe6);
			}
			// 3.1 д��Exel������
			writableWorkbook.write();
			// 4.1 �ر�Excel����������
			writableWorkbook.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 1.2 ����Excel������

	}

	public static void get(String filepath, List listData) {

		System.out.println(listData.size() + "====");
		File file = new File(filepath);
		Workbook book;
		try {
			book = Workbook.getWorkbook(file);
			Sheet sheet = book.getSheet(0);
			// ��ȡ��
			int length = sheet.getRows();
			WritableWorkbook wbook = Workbook.createWorkbook(file, book); // ����book����һ����������
			WritableSheet sh = wbook.getSheet(0);// �õ�һ����������

			/* for (int i = 1; i <= listData.size(); i++) {
			 * 
			 * int j=i-1; Object[] obj = (Object[]) listData.get(j); Label label = new Label(13, i, (String) obj[0]); sh.addCell(label); Label label1 = new Label(14, i, (String) obj[1]);
			 * sh.addCell(label1); Label lab2 = new Label(15, i, (String) obj[2]); sh.addCell(lab2); Label lab22 = new Label(16, i, (String) obj[3]); sh.addCell(lab22); Label lab21 = new Label(16, i,
			 * (String) obj[4]); sh.addCell(lab21);
			 * 
			 * } */

			Label label = new Label(2, 1, "what");
			sh.addCell(label);

			/* for (int i = 1; i <= listData.size(); i++) { Object [] obj=(Object[]) listData.get(i-1); Label label = new Label(13, i, (String) obj[0]); sh.addCell(label); Label label1 = new Label(14,
			 * i, (String) obj[1]); sh.addCell(label1); Label lab2 = new Label(15, i, (String) obj[2]); sh.addCell(lab2); Label lab3 = new Label(16, i, (String) obj[3]); sh.addCell(lab3); } */
			wbook.write();
			wbook.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public static void get(String filepath, List listData, int flag) {

		// System.out.println(listData.size() + "====");
		File file = new File(filepath);

		System.out.println(file.getAbsolutePath());
		Workbook book;
		try {
			FileInputStream in = new FileInputStream(file);
			book = Workbook.getWorkbook(in);
			// Sheet sheet = book.getSheet(0);
			// ��ȡ��
			// int length = sheet.getRows();
			WritableWorkbook wbook = Workbook.createWorkbook(file, book); // ����book����һ����������
			WritableSheet sh = wbook.getSheet(0);// �õ�һ����������
			for (int i = 1; i <= listData.size(); i++) {
				int j = i - 1;
				Object[] obj = (Object[]) listData.get(j);

				// ְλ��Ϣ
				/* Label label = new Label(12, i, (String) obj[0]); sh.addCell(label); Label label1 = new Label(13, i, (String) obj[1]); sh.addCell(label1); Label lab2 = new Label(14, i, (String)
				 * obj[2]); sh.addCell(lab2); String str="����"; if(StringUtils.isNotBlank((String)obj[3])){ str=(String)obj[3]; } Label lab22 = new Label(15, i, str); sh.addCell(lab22); Label lab21 =
				 * new Label(16, i, (String) obj[4]); sh.addCell(lab21); */

				// ������Ϣ
				Label label = new Label(1, i, (String) obj[0]);
				sh.addCell(label);
				Label label1 = new Label(2, i, (String) obj[1]);
				sh.addCell(label1);
				Label lab2 = new Label(3, i, (String) obj[2]);
				sh.addCell(lab2);

			}
			wbook.write();
			wbook.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
