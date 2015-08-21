package com.job5156.server;

import java.io.IOException;
import java.io.File;
import javax.servlet.ServletContext;


/**
 * 文件操作效用类
 */
public class FileUtil{
  /**
   * 获得某个文件的绝对路径
   * @param x
   * @return
   */
  public static String getPath(String x) {
    String path = "";
    try {
      File file = new File(".");
      path = file.getCanonicalPath() + "\\" + x + "\\";
    }
    catch (IOException e) {
      System.out.println("com.jobcn.util.FileUtil getPath()  error :" +
                         e.getMessage());
    }
    return path;
  }

  /**
   * 获得当前应用的根路径
   * @param servletContext ServletContext
   * @return String
   */
  public static String getPath(ServletContext servletContext) {
    return servletContext.getRealPath("/");
  }

  /**
   * 获得路径
   * @return  根目录，java/jsp应用程序的根目录
   */
  public static String getPath() {
    String path = "";
    File file = new File(".");
    try {
      path = file.getCanonicalPath();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    return path;
  }

  /**
   * 获得路径
   * @return 根目录
   */
  public static String getRootPath() { return getPath(); }
  
}
