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
 * @date 2015年8月5日
 */
public class TestDb {

	/**
	 * @Description: TODO
	 * @param @param args
	 * @return void
	 * @throws
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = null;
		Connection con = null;
		session = SessionManager.currentSession();
		con = session.connection();
		// List lists = AnalyDB.getComBaseInfo(con);
		// get("C://Users//Administrator//Desktop//jiansu//excel//combase.xls",lists,2);

		// List lists = AnalyDB.ComPostions(con); get("C://Users//Administrator//Desktop//jiansu//excel//pos1.xls",lists,1); 

		//List lists = AnalyDB.educations(con);
		//get("C://Users//Administrator//Desktop//jiansu//test.xls", lists, 1);
		
		//List lists = AnalyDB.educations(con);
		//wirteExcel4(lists);


		/*List lists = AnalyDB.intentInfos(con);
		wirteExcel(lists);*/
		
		
		/*List lists = AnalyDB.educations(con);
		wirteExcelToAppend(lists);*/
   
		List lists = AnalyDB.traninfos(con, null, null);
		wirteExcel3(lists);
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	////求职意图
	public static void wirteExcel(List listData) {
		WritableWorkbook writableWorkbook;
		try {
			writableWorkbook = Workbook.createWorkbook(new File("C://Users//Administrator//Desktop//jiansu//excel//intentinfo.xls"));
			WritableSheet writableSheet = writableWorkbook.createSheet("求职意向", 0);

			for (int i = 1; i <= listData.size(); i++) {
				 Object [] obj=(Object[]) listData.get(i-1);
				PerResumeVo.IntentInfoVo intent=(IntentInfoVo) obj[0];
				String useId=(String) obj[1];
				Label label = new Label(0, i,String.valueOf(i));
				writableSheet.addCell(label);
				Label label11 = new Label(1, i,useId);
			    writableSheet.addCell(label11);
				Label lab2 = new Label(2, i,intent.getJobTypeStr()!=null?intent.getJobTypeStr():"112");
				writableSheet.addCell(lab2);
				Label lab3 = new Label(3, i,intent.getJobLocationStr());
				writableSheet.addCell(lab3);
				Label lab4 = new Label(4, i,intent.getJobCodeStr());
				writableSheet.addCell(lab4);
				Label lab5 = new Label(5, i,intent.getSalaryStr());
				writableSheet.addCell(lab5);
				
				
			}
			// 3.1 写入Exel工作表
			writableWorkbook.write();
			// 4.1 关闭Excel工作薄对象
			writableWorkbook.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 1.2 创建Excel工作表
		
	}
	//工作信息
	public static void wirteExcel2(List listData) {
		WritableWorkbook writableWorkbook;
		try {
			writableWorkbook = Workbook.createWorkbook(new File("C://Users//Administrator//Desktop//jiansu//excel//workinfo.xls"));
			WritableSheet writableSheet = writableWorkbook.createSheet("求职意向", 0);

			for (int i = 1; i <= listData.size(); i++) {
				Object[] obj=(Object[]) listData.get(i-1);
				PerResumeVo.WorkInfoVo work=(WorkInfoVo) obj[0];
				String UseId=(String) obj[1];
				Label label = new Label(0, i,String.valueOf(i));
				Label labe12 = new Label(1, i,UseId);
				Label labe2 = new Label(2, i,work.getComName());
				Label labe3 = new Label(3, i,work.getComTypeStr());
				Label labe4 = new Label(4, i,work.getComScaleStr());
				Label labe5 = new Label(5, i,work.getComCallingStr());
				Label labe6 = new Label(6, i,work.getSection());
				Label labe7 = new Label(7, i,work.getJobNameStr());
				Label labe8= new Label(8, i,work.getBegin());
				Label labe9 = new Label(9, i,work.getEnd());
				Label labe10= new Label(10, i,work.getSalaryStr());
				Label labe11 = new Label(11, i,work.getDescription());
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
			// 3.1 写入Exel工作表
			writableWorkbook.write();
			// 4.1 关闭Excel工作薄对象
			writableWorkbook.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 1.2 创建Excel工作表
		
	}
	
	//培训信息
	public static void wirteExcel3(List listData) {
		WritableWorkbook writableWorkbook;
		try {
			writableWorkbook = Workbook.createWorkbook(new File("C://Users//Administrator//Desktop//jiansu//excel//traninfo.xls"));
			WritableSheet writableSheet = writableWorkbook.createSheet("培训信息", 0);

			for (int i = 1; i <= listData.size(); i++) {
				Object[] obj=(Object[]) listData.get(i-1);
				PerResumeVo.TrainInfoVo work=(TrainInfoVo) obj[0];
				String UseId=(String) obj[1];
				Label label = new Label(0, i,String.valueOf(i));
				Label labe2 = new Label(1, i,UseId);
				Label labe3 = new Label(2, i,work.getBegin());
				Label labe4 = new Label(3, i,work.getEnd());
				Label labe5 = new Label(4, i,work.getTrainSchoolName());
				Label labe6 = new Label(5, i,work.getPlaceStr());
				Label labe7 = new Label(6, i,work.getTrainCourse());
				Label labe8= new Label(7, i,work.getCertificate());
				Label labe9 = new Label(8, i,work.getCourseDescription());

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
			// 3.1 写入Exel工作表
			writableWorkbook.write();
			// 4.1 关闭Excel工作薄对象
			writableWorkbook.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 1.2 创建Excel工作表
		
	}
	
	//教育信息
	public static void wirteExcel4(List listData) {
		WritableWorkbook writableWorkbook;
		try {
			writableWorkbook = Workbook.createWorkbook(new File("C://Users//Administrator//Desktop//jiansu//excel//eduacation.xls"));
			WritableSheet writableSheet = writableWorkbook.createSheet("教育信息", 0);

			for (int i = 1; i <= listData.size(); i++) {
				Object[] obj=(Object[]) listData.get(i-1);
				PerResumeVo.EducationInfoVo work= (PerResumeVo.EducationInfoVo) obj[0];
				String UseId=(String) obj[1];
				Label label = new Label(0, i,String.valueOf(i));
				Label labe2 = new Label(1, i,UseId);
				Label labe3 = new Label(2, i,work.getEnd());
				Label labe4 = new Label(3, i,work.getSchoolName());
				Label labe5 = new Label(4, i,work.getSpeciality());
				Label labe6 = new Label(5, i,work.getDegreeStr());

				writableSheet.addCell(label);
				writableSheet.addCell(labe2);
				writableSheet.addCell(labe3);
				writableSheet.addCell(labe4);
				writableSheet.addCell(labe5);
				writableSheet.addCell(labe6);
			}
			// 3.1 写入Exel工作表
			writableWorkbook.write();
			// 4.1 关闭Excel工作薄对象
			writableWorkbook.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 1.2 创建Excel工作表
		
	}
	
	
	//教育信息
	public static void wirteExcelToAppend(List listData) {
		WritableWorkbook writableWorkbook;
		Workbook book;
		File file=new File("C://Users//Administrator//Desktop//jiansu//test.xls");
		try {
			FileInputStream in = new FileInputStream(file);
			book = Workbook.getWorkbook(in);
			 //Sheet sheet = book.getSheet(0);
			// 获取行
			//int length = sheet.getRows();
			writableWorkbook = Workbook.createWorkbook(file, book); // 根据book创建一个操作对象
			WritableSheet writableSheet = writableWorkbook.createSheet("ss", 7);

			for (int i = 1; i <= listData.size(); i++) {
				Object[] obj=(Object[]) listData.get(i-1);
				PerResumeVo.EducationInfoVo work= (PerResumeVo.EducationInfoVo) obj[0];
				String UseId=(String) obj[1];
				Label label = new Label(0, i,String.valueOf(i));
				Label labe2 = new Label(1, i,UseId);
				Label labe3 = new Label(2, i,work.getEnd());
				Label labe4 = new Label(3, i,work.getSchoolName());
				Label labe5 = new Label(4, i,work.getSpeciality());
				Label labe6 = new Label(5, i,work.getDegreeStr());

				writableSheet.addCell(label);
				writableSheet.addCell(labe2);
				writableSheet.addCell(labe3);
				writableSheet.addCell(labe4);
				writableSheet.addCell(labe5);
				writableSheet.addCell(labe6);
			}
			// 3.1 写入Exel工作表
			writableWorkbook.write();
			// 4.1 关闭Excel工作薄对象
			writableWorkbook.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 1.2 创建Excel工作表
		
	}
	
	public static void get(String filepath, List listData) {

		System.out.println(listData.size() + "====");
		File file = new File(filepath);
		Workbook book;
		try {
			book = Workbook.getWorkbook(file);
			Sheet sheet = book.getSheet(0);
			// 获取行
			int length = sheet.getRows();
			WritableWorkbook wbook = Workbook.createWorkbook(file, book); // 根据book创建一个操作对象
			WritableSheet sh = wbook.getSheet(0);// 得到一个工作对象
			
			/*for (int i = 1; i <= listData.size(); i++) {
				
				int j=i-1;
				Object[] obj = (Object[]) listData.get(j);
				Label label = new Label(13, i, (String) obj[0]);
				sh.addCell(label);
				Label label1 = new Label(14, i, (String) obj[1]);
				sh.addCell(label1);
				Label lab2 = new Label(15, i, (String) obj[2]);
				sh.addCell(lab2);
				Label lab22 = new Label(16, i, (String) obj[3]);
				sh.addCell(lab22);
				Label lab21 = new Label(16, i, (String) obj[4]);
				sh.addCell(lab21);
				
			}
			*/
			
			Label label = new Label(2, 1,"what");
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

		//System.out.println(listData.size() + "====");
		File file = new File(filepath);
		
		System.out.println(file.getAbsolutePath());
		Workbook book;
		try {
			FileInputStream in = new FileInputStream(file);
			book = Workbook.getWorkbook(in);
			 //Sheet sheet = book.getSheet(0);
			// 获取行
			//int length = sheet.getRows();
			WritableWorkbook wbook = Workbook.createWorkbook(file, book); // 根据book创建一个操作对象
			WritableSheet sh = wbook.getSheet(0);// 得到一个工作对象
			for (int i = 1; i <= listData.size(); i++) {
				int j=i-1;
				Object[] obj = (Object[]) listData.get(j);
				
				//职位信息
				/*Label label = new Label(12, i, (String) obj[0]);
				sh.addCell(label);
				Label label1 = new Label(13, i, (String) obj[1]);
				sh.addCell(label1);
				Label lab2 = new Label(14, i, (String) obj[2]);
				sh.addCell(lab2);
				String str="不限";
				if(StringUtils.isNotBlank((String)obj[3])){
			        str=(String)obj[3];
				}
				Label lab22 = new Label(15, i, str);
				sh.addCell(lab22);
				Label lab21 = new Label(16, i, (String) obj[4]);
				sh.addCell(lab21);*/
				
				//个人信息
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
