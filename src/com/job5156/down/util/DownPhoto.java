package com.job5156.down.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Date;

import com.job5156.util.RandomString;

public class DownPhoto {
	 
		 /***
	  * ͼƬ�ϴ�����
	  * @param picUrl ����ͼƬ��ַ
	  * @param personID  �û�ID
	  * @return
	  */
	 public static String download(String picUrl,int countId,String prefix)
	 {
	     if(picUrl==null || "".equals(picUrl))   //����Ҳ���ͼƬ�ͷ���Null
	         return null;
	     String uploadDir = "/opt/photo";
	     String fileName = prefix+"_"+countId+getMathStringByLength(10)+".jpg";
	     String yearMonthFolder = (new Date(System.currentTimeMillis())).toString().substring(0,7);  //��ǰʱ�䣬�Ե�ǰ���¹���Ŀ¼
	     String sep = System.getProperty("file.separator");
	     sep = sep.replace('\\','/');  //ת��ת���ַ�,����js����
	     String uploadFullDir = uploadDir+sep+yearMonthFolder;
	     String tmp = yearMonthFolder + sep + fileName;
	     File dirPath = new File(uploadFullDir);
	 
	     if (!dirPath.exists()) {
	         dirPath.mkdirs();
	     }                   
	     try
	     {
	         URLConnection urlconnection;
	         URL url = new URL(picUrl);
	         urlconnection = url.openConnection();
	         urlconnection.connect();
	         HttpURLConnection httpurlconnection = (HttpURLConnection)urlconnection;
	         int i = httpurlconnection.getResponseCode();
	         if(i != 200)
	         {
	             System.out.println("���ӵ�" + picUrl + " ʧ�ܡ�����:" + i);
	             return "";
	         }    
	         int j = urlconnection.getContentLength();
	         byte abyte0[] = new byte[1024];
	         File file = new File(uploadFullDir + sep + fileName);
	         if(!file.exists())
	             file.createNewFile();
	         InputStream inputstream = urlconnection.getInputStream();
	         BufferedInputStream bufferInStream = new BufferedInputStream(inputstream);
	         FileOutputStream fileoutputstream = new FileOutputStream(file);
	         BufferedOutputStream bufferOutStream = new BufferedOutputStream(fileoutputstream);
	         int k = 0;
	         if(j > 0)
	         {
	             while(k > -1) 
	             {
	                 k = bufferInStream.read(abyte0);
	                 if(k > 0)
	                     bufferOutStream.write(abyte0, 0, k);
	             }
	         }
	         bufferOutStream.flush();
	         bufferOutStream.close();
	         bufferInStream.close();
	         fileoutputstream.close();
	         inputstream.close();
	         file = null;
	         abyte0 = null;
	         httpurlconnection.disconnect();
	         urlconnection = null;
	         url = null;
	     }
	     catch(Exception e)
	     {
	         e.printStackTrace();
	         return "";
	     }    
	     return tmp;
	 }
	 /**���ݳ��Ȼ��һ����ֵ��ɵ��ַ���*/
	 public static String getMathStringByLength(int length){
	     RandomString test = new RandomString();
	
	     String code="";
	     test.setLength(length);
	     test.setCharset("0-9a-z");
	     try {
	         test.generateRandomObject();
	         code = test.getRandom();
	     } catch (Exception e) {
	         e.printStackTrace();
	     }        
	     return code;
	 }
	 
	 /**ȡ���ļ��ĺ�׺��*/
	 public static String getFileSuffix(String fileName){
	     String suffix="";
	     for(int i = fileName.length()-1;i>=0;i--){
	         if(fileName.charAt(i)=='.')
	             break;
	         else
	             suffix = fileName.charAt(i)+suffix;
	     }
	     return "."+suffix;
	 }
}
