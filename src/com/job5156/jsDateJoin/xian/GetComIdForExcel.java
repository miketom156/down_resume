/**
 * 
 */
package com.job5156.jsDateJoin.xian;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;

import com.job5156.server.SessionManager;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * @author lyh
 * @Description 
 * @date 2015Äê8ÔÂ20ÈÕ
 * 
 */
public class GetComIdForExcel {

	/** 
	 * @Description: TODO
	 * @param @param args   
	 * @return void
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file=new File("C://Users//Administrator//Desktop//jiansu//com.xls");
		FileInputStream in;
		Session session = null;
		Connection con = null;
		try {
			in = new FileInputStream(file);
			Workbook book = Workbook.getWorkbook(in);
			Sheet sheet=book.getSheet(0);
			Cell cell=null;
			List LComNames=new ArrayList();
			for(int i=1;i<=811;i++){
				String comName=sheet.getCell(1, i).getContents();
				LComNames.add("'"+comName+"'");
				
			}
			
			session = SessionManager.currentSession();
			con = session.connection();
			List list=AnalyDB.getComIdByComName(con, LComNames);
			System.out.println(StringUtils.join(list,","));
			
			
		} catch (BiffException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		     try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		}
	
	}

}
