package com.job5156.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.dom4j.Element;

/**
 * @author xurun<br>
 * 静态文件相关的一些静态方法：
 */
public class StaticFileTools {
	/**文件生成机制，在本系统中：为了解决同一目录下子目录多，采用分组方案每5000个公司或个人信息为一个目录。
	 * 即根据id来创建一个父目录*/
	public static String getFolderById(Object obj){
		String folder ="";
		if(obj!=null  && Validator.isDigit(obj.toString())){
			int id = Integer.parseInt(obj.toString());
			int folderInt = id / 5000;
			folder = String.valueOf(folderInt);
		}
		return folder;
	}
		
	/**根据传来的目录，删除下面的所有文件*/
	public static boolean deleteFolder(String folder){
        File dir = new File(folder);
        try{
	        if (dir.exists()){
	        	if(dir.isDirectory()){
	        		File file[] = dir.listFiles();
	        		for(int i=0;i<file.length;i++){
	        			file[i].delete();
	        		}
	        	}
	        	dir.delete();
	            System.out.println("删除"+folder+"成功");
	        }
	        return true;
        }catch(Exception ex){
        	ex.printStackTrace();
        	return false;
        }
	}
	
/**判断一个文件或目录是否存在,传来完整路径*/	
public static boolean fileExistCheckByFullPath(String fileName){
	
	File dirPath = new File(fileName);
	if(!dirPath.exists())
		return false;
	else
		return true;
}
	
/**根据传来的文件目录，和文件名，删除它*/
public static boolean deleteFile(String folder,String fileName){
    File file = new File(folder,fileName);
    try{
        if (file.exists()){
        	file.delete();
            System.out.println("删除"+folder+"/"+fileName+"成功");
        }
        return true;
    }catch(Exception ex){
    	ex.printStackTrace();
    	return false;
    }
}

	
	/**为了防止猜联系地址的静态文件名，对联系信息的文件名进行干扰*/
	public static String getContactFileNameById(Object personId){
		String returnString="";
		
		
		if(personId!=null){
			String id = personId.toString();
			char start= 0 ;
			for(int i=0;i<id.length();i++){
				char ch = id.charAt(i);
				returnString+=((start+ch)) % 9;
				start = ch;
			}
		}
		return returnString;
	}
	


    /** 通过配置文件生成的Element获取ResultSet */
    public static ResultSet getResultSetByElement(Element element) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            String driverClassName = element.elementText("driverClassName");
            String url = element.elementText("url");
            String userName = element.elementText("username");
            String password = element.elementText("password");
            String sql = element.element("sql").attributeValue("select");

            Class.forName(driverClassName).newInstance();
            conn = DriverManager.getConnection(url, userName, password);
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            return rs;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                //if (conn != null)
                //    conn.close();
            } catch (Exception e) {
                System.out.println("finally error:" + e.getMessage());
            }
        }
    }

    /** 读取模板文件 */
    public static String loadModelFile(String fileName) {
        StringBuffer buffer = new StringBuffer();
        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(reader);
            String date = null;
            while ((date = br.readLine()) != null) {
                buffer.append(date);
            }
            br.close();
            reader.close();
        } catch (IOException e) {
            System.out.println("IOException:" + e);
        }
        return buffer.toString();
    }

    /** 创建文件路径并返回文件名 */
    public static String createFileName(String folder, String businessName,
            String suffix) {
        String fullFileName = "";
        Date date = new Date(System.currentTimeMillis());
        java.util.Random ran1 = new java.util.Random();
        int ranInt = ran1.nextInt();
        if (ranInt < 0)
            ranInt = -ranInt;

        int ranInt1 = ran1.nextInt();
        if (ranInt1 < 0)
            ranInt1 = -ranInt1;

        String fileName = String.valueOf(ranInt) + String.valueOf(ranInt1);
        if (Validator.isNull(suffix)) {
            suffix = "html";
        }

        mkDir(folder + "/" + businessName);
        mkDir(folder + "/" + businessName + "/" + date);

        fullFileName = businessName + "/" + date + "/" + fileName + "."
                + suffix;

        return fullFileName;
    }


    /** 创建文件路径并返回文件名(这里的文件名：是相对系统静态文件指定路径后面的全名) */
    public static String createFileName(Object id,String folder, String businessName,
            String suffix) {
        String fullFileName = "";
        Date date = new Date(System.currentTimeMillis());

        java.util.Random ran1 = new java.util.Random();

        String ranString="";
        if(id!=null){
            ranString = id.toString()+"_";
        }else{
            int ranInt = ran1.nextInt();
            if (ranInt < 0)
                ranInt = -ranInt;
                ranString=String.valueOf(ranInt);
        }

        int ranInt1 = ran1.nextInt();
        if (ranInt1 < 0)
            ranInt1 = -ranInt1;

        String fileName = ranString + String.valueOf(ranInt1);
        if (Validator.isNull(suffix)) {
            suffix = "html";
        }

        mkDir(folder + "/" + businessName);
        mkDir(folder + "/" + businessName + "/" + date);

        fullFileName = businessName + "/" + date + "/" + fileName + "."
                + suffix;

        return fullFileName;
    }

    
    private static void mkDir(String folder) {
        File dir = null;
        try{
        	dir = new File(folder);
	        if (dir == null || !dir.exists()) {
	            dir.mkdir();
	        }
        }
        catch(Exception ex){}
        finally{
        	if(dir!=null)dir=null;
        }
    }

    /** 根据文件全名，保存文件 */
    public static boolean saveFile2Disk(String fullFileName, String content) {
    	File dir = null;
    	PrintWriter pw = null;
        try {
            //System.out.println("正在保存.."+fullFileName);
            //System.out.println("内容是："+content);
            dir = new File(fullFileName);

            pw = new PrintWriter(new OutputStreamWriter(
                    new FileOutputStream(fullFileName)), false);
            pw.print(content);
            pw.flush();
            pw.close();
            dir=null;
            pw=null;
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }finally{
        	if(pw!=null){pw.close();pw=null;}
        	if(dir!=null){dir=null;}
        }
    }


    /** 替换模板中的内容<br>
     * 要求模板中被替换的内容是 $dddd$ 的样式
     */
    public static String stringReplace(String express, String oldValue,
            String newValue) {
        String ret = "";
        try {
            Pattern pat = Pattern.compile("\\$" + oldValue + "\\$");
            Matcher mat = pat.matcher(express.trim());
            ret = mat.replaceAll(newValue);
        } catch (Exception e) {
            ret = express;
        }
        return ret;
    }

    
    /** 变更数据库 */
    public static boolean updateUrl(Map map, Element element) {
        // if(element.element("hql").attributeValue("update")==null)return true;
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            String driverClassName = element.elementText("driverClassName");
            String url = element.elementText("url");
            String userName = element.elementText("username");
            String password = element.elementText("password");

            String sql = element.element("sql").attributeValue("update");

            Class.forName(driverClassName).newInstance();
            conn = DriverManager.getConnection(url, userName, password);

            Iterator it = map.keySet().iterator();

            while (it.hasNext()) {
                Object key = it.next();
                String fileName = map.get(key).toString();
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, fileName);
                pstmt.setObject(2, key);
                pstmt.execute();
            }
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                System.out.println("finally error:" + e.getMessage());
            }
        }
    }
    
    
    /**取得文件的后缀名*/
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
