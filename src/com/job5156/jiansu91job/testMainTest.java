/**
 * 
 */
package com.job5156.jiansu91job;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

/**
 * @author lyh
 * @Description
 * @date 2015年7月15日
 */
public class testMainTest {

	/**
	 * @Description: TODO
	 * @param @param args
	 * @return void
	 * @throws 专科生数据的抓取
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// /String urlString = "http://www.91job.gov.cn/manage/USC/USC001.aspx?a1=USC&a2=USC001&xb=0&zy=&xldm=&xx=";
		// MainTestCrawel.MainCrawel(urlString);
		
		try {
			//BufferedReader bufferedReader=new BufferedReader(new FileReader(new File("C:\\Users\\Administrator\\Desktop\\专业名录.doc")));
			/*String readline=bufferedReader.readLine();
	         while(bufferedReader.read()!=-1){
	        	 readline=new String(readline.getBytes("UTF-8"),"GBK");
	        	 System.out.println(readline);
	        	 readline=bufferedReader.readLine();
	         }*/
			BufferedInputStream  in=new BufferedInputStream(new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\专业名录.doc")));
		     byte [] byt=new byte[1024];
			while(in.read(byt)!=-1){
				System.out.println(new String(byt,"UTF-8"));
				
			}
	        in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
