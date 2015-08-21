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
 * @date 2015年8月5日
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
		//写入个人基本信息
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
		System.out.println("-------执行--------"+page+"---------批处理--------------");
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
		//写入个人基本信息
	    page=AnalyDB.getPerPage(con);
		System.out.println("----------执行-----"+page+"-------批处理----------------");
		for(int i=0;i<page;i++){
			Integer startIndex = i * 1000;
			List listData = AnalyDB.PerUsers(con, startIndex, 1000);
			//WriterPerUser(listData, i);
	     System.out.println("----------执行-----"+i+"-------分页处理----------------");	
		}
	}

	public static void getPerExcel2(Connection con,Integer index,String f) {
		Integer page;
		//写入个人基本信息
	    page=AnalyDB.getPerPage(con);
	    int temp=index==0?0:index;
		System.out.println("----------执行-----"+page+"-------批处理----------------");
		for(int i=temp;i<page;i++){
			Integer startIndex = i * 1000;
			List listData = AnalyDB.PerUsers(con, startIndex, 1000);
			WriterPerUser(listData, i, f);
			if(Thread.interrupted()){
				getPerExcel2(con,i,f);
			}
	     System.out.println("----------执行-----"+i+"-------分页处理----------------");	
		}
	}
	public static void WriterPerUser(List listData, Integer page,String f) {
		f = getByFileS(page);
		String path = filePath+"peruser"+f+".xls";
		File file = new File(path);
		WritableWorkbook writableWorkbook = null; //写工作本
		Workbook book;
		WritableSheet writableSheet; //得到写入的表单
		Integer No=page/63; //得到表单编号

		No = getPageNo(page);
		int length=1;
		try {
			//先判断文件 是否存在	
			if (!file.exists()) {
				writableWorkbook = Workbook.createWorkbook(file);
				writableSheet = writableWorkbook.createSheet("per0", 0);
				 writeMetaDate(writableSheet);
			} else{
				FileInputStream in = new FileInputStream(file);
				book = Workbook.getWorkbook(in);
				writableWorkbook = Workbook.createWorkbook(file, book); // 根据book创建一个操作对象
				writableSheet = writableWorkbook.getSheet(No);// 得到一个工作对象
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
			System.out.println("--------写入---------"+No+"文件编号 "+f+"--------表单-----"+page+"----------");
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
					//System.out.println("--------写入---------"+i1+"----------"+No+"---表单-----------");
					i1++;
				}

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

	/** 
	* @Description: 得到 表单编号 
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
	* @Description: 得到文件编号
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
		Label label = new Label(0, i1, "个人编号");
		Label labe2 = new Label(1, i1, "用户名");
		Label labe3 = new Label(2, i1, "密码");
		Label labe4 = new Label(3, i1,"电子邮件");
		Label labe5 = new Label(4, i1, "真实姓名");
		Label labe6 = new Label(5, i1, "身份证号码");
		Label labe7 = new Label(6, i1,"性别");
		Label labe8 = new Label(7, i1, "户籍所在地");
		Label labe9 = new Label(8, i1, "居住地");
		Label labe10 = new Label(9, i1, "出生日期");
		Label labe11 = new Label(10, i1, "个人主页");
		Label labe12 = new Label(11, i1, "联系号码");
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
		Label label = new Label(0, i1, "编号");
		Label labe2 = new Label(1, i1, "个人编号");
		Label labe3 = new Label(2, i1, "个人求职类型");
		Label labe4 = new Label(3, i1, "工作地区");
		Label labe5 = new Label(4, i1, "职位类型");
		Label labe6 = new Label(5, i1, "薪资要求");

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
		Label label = new Label(0, i1, "编号");
		Label labe2 = new Label(1, i1, "个人编号");
		Label labe3 = new Label(2, i1, "毕业时间");
		Label labe4 = new Label(3, i1, "毕业院校");
		Label labe5 = new Label(4, i1, "专业");
		Label labe6 = new Label(5, i1, "学历");

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
		Label label = new Label(0, i1, "编号");
		Label labe2 = new Label(1, i1, "个人编号");
		Label labe3 = new Label(2, i1, "开始时间");
		Label labe4 = new Label(3, i1, "结束时间");
		Label labe5 = new Label(4, i1, "培训机构");
		Label labe6 = new Label(5, i1, "培训地址");
		Label labe7 = new Label(6, i1, "培训课程");
		Label labe8 = new Label(7, i1, "培训证书");
		Label labe9 = new Label(8, i1, "培训详细情况");

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
		Label label = new Label(0, i1, "编号");
		Label labe2 = new Label(1, i1, "个人编号");
		Label labe3 = new Label(2, i1, "单位名称");
		Label labe4 = new Label(3, i1,"单位性质");
		Label labe5 = new Label(4, i1, "企业规模");
		Label labe6 = new Label(5, i1, "企业行业");
		Label labe7 = new Label(6, i1,"工作部门");
		Label labe8 = new Label(7, i1, "职位");
		Label labe9 = new Label(8, i1, "开始时间");
		Label labe10 = new Label(9, i1, "结束时间");
		Label labe11 = new Label(10, i1, "薪资待遇");
		Label labe12 = new Label(11, i1, "职位描述");
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
	
	
	
	
	
	// //求职意图
	public static void wirteExcel(List listData) {
		WritableWorkbook writableWorkbook;
		try {
			writableWorkbook = Workbook.createWorkbook(new File("C://Users//Administrator//Desktop//jiansu//excel//intentinfo.xls"));
			WritableSheet writableSheet = writableWorkbook.createSheet("求职意向", 0);

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

	// 工作信息
	public static void wirteExcel2(List listData) {
		WritableWorkbook writableWorkbook;
		try {
			writableWorkbook = Workbook.createWorkbook(new File("C://Users//Administrator//Desktop//jiansu//excel//workinfo.xls"));
			WritableSheet writableSheet = writableWorkbook.createSheet("求职意向", 0);

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

	// 培训信息
	public static void wirteExcel3(List listData) {
		WritableWorkbook writableWorkbook;
		try {
			writableWorkbook = Workbook.createWorkbook(new File("C://Users//Administrator//Desktop//jiansu//excel//traninfo.xls"));
			WritableSheet writableSheet = writableWorkbook.createSheet("培训信息", 0);

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

	// 教育信息
	public static void wirteExcel4(List listData) {
		WritableWorkbook writableWorkbook;
		try {
			writableWorkbook = Workbook.createWorkbook(new File("C://Users//Administrator//Desktop//jiansu//excel//eduacation.xls"));
			WritableSheet writableSheet = writableWorkbook.createSheet("教育信息", 0);

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

	// 教育信息
	public static void wirteExcelToAppend(List listData) {
		WritableWorkbook writableWorkbook;
		Workbook book;
		File file = new File("C://Users//Administrator//Desktop//jiansu//test.xls");
		try {
			FileInputStream in = new FileInputStream(file);
			book = Workbook.getWorkbook(in);
			// Sheet sheet = book.getSheet(0);
			// 获取行
			// int length = sheet.getRows();
			writableWorkbook = Workbook.createWorkbook(file, book); // 根据book创建一个操作对象
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
			// 获取行
			// int length = sheet.getRows();
			WritableWorkbook wbook = Workbook.createWorkbook(file, book); // 根据book创建一个操作对象
			WritableSheet sh = wbook.getSheet(0);// 得到一个工作对象
			for (int i = 1; i <= listData.size(); i++) {
				int j = i - 1;
				Object[] obj = (Object[]) listData.get(j);

				// 职位信息
				/* Label label = new Label(12, i, (String) obj[0]); sh.addCell(label); Label label1 = new Label(13, i, (String) obj[1]); sh.addCell(label1); Label lab2 = new Label(14, i, (String)
				 * obj[2]); sh.addCell(lab2); String str="不限"; if(StringUtils.isNotBlank((String)obj[3])){ str=(String)obj[3]; } Label lab22 = new Label(15, i, str); sh.addCell(lab22); Label lab21 =
				 * new Label(16, i, (String) obj[4]); sh.addCell(lab21); */

				// 个人信息
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
