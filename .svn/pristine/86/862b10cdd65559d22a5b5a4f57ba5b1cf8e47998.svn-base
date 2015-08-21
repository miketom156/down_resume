package com.job5156.server;

import java.io.*;
import java.util.Date;
import java.text.DateFormat;
/**
 * 用于在文件上保存日志
 */
public class FileLog
{
    private static final boolean displaySystemLog   = false;
    private static final boolean displaySecurityLog = false;
    private static final boolean displayDebugLog    = false;
    private static final boolean displayErrorLog    = false;

    private static final String SYSTEM_LOG_FILE   = "SystemLog.txt";
    private static final String SECURITY_LOG_FILE = "SecurityLog.txt";
    private static final String DEBUG_LOG_FILE    = "DebugLog.txt";
    private static final String ERROR_LOG_FILE    = "ErrorLog.txt";

    private static PrintWriter sysLog;
    private static PrintWriter secLog;
    private static PrintWriter debugLog;
    private static PrintWriter errLog;

    private int logType;
    private static final int TYPE_SYSTEM   = 0;
    private static final int TYPE_ERROR    = 1;
    private static final int TYPE_SECURITY = 2;
    private static final int TYPE_DEBUG    = 3;


    private FileLog(int logType)
    {
        this.logType = logType;
    }


    private static FileLog sysIns = new FileLog(TYPE_SYSTEM);
   


    private static FileLog secIns = new FileLog(TYPE_SECURITY);
    

    private static FileLog debugIns = new FileLog(TYPE_DEBUG);
    

    private static FileLog errIns = new FileLog(TYPE_ERROR);
    static{
        try {
            File dir = new File(FileUtil.getRootPath(),"logs");
            if(!dir.exists())
                dir.mkdirs();
			System.out.println(dir);
            boolean append = true;
            boolean autoFlush = true;

            File logFile;
            FileOutputStream fos;
            OutputStreamWriter osr;

            /////////////////////////////////////////////////////
            logFile = new File(dir,SYSTEM_LOG_FILE);
            if(!logFile.exists()) logFile.createNewFile();
            fos = new FileOutputStream (logFile.toURL().getFile(),append);
            osr = new OutputStreamWriter (fos,"gb2312");
            sysLog = new PrintWriter(osr,autoFlush);
            /////////////////////////////////////////////////////
            logFile = new File(dir,SECURITY_LOG_FILE);
            if(!logFile.exists()) logFile.createNewFile();
            fos = new FileOutputStream (logFile.toURL().getFile(),append);
            osr = new OutputStreamWriter (fos,"gb2312");
            secLog = new PrintWriter(osr,autoFlush);
            ////////////////////////////////////////////////////////
            logFile = new File(dir,DEBUG_LOG_FILE);
            if(!logFile.exists()){
                logFile.createNewFile();
            }
            fos = new FileOutputStream
                (logFile.toURL().getFile(),append);
            osr = new OutputStreamWriter
                (fos,"gb2312");
            debugLog = new PrintWriter(osr,autoFlush);
            ///////////////////////////////////////////////////////////
            logFile = new File(dir,ERROR_LOG_FILE);
            if(!logFile.exists()){
                logFile.createNewFile();
            }
            fos = new FileOutputStream
                (logFile.toURL().getFile(),append);
            osr = new OutputStreamWriter
                (fos,"gb2312");
            errLog = new PrintWriter(osr,autoFlush);
        }catch (IOException ex) {
            System.err.println("日志文件不能初始化");
            ex.printStackTrace();
        }
    }

    private void innerLog(String msg,PrintWriter log,boolean debug){
        synchronized(log){
        Date d = new Date();
        String s = DateFormat.getDateTimeInstance()
            .format(d);
        log.println(s+"："+msg);
        if(debug)
            System.out.println(s+"："+msg);
        }
    }

    private void innerLog(Throwable e,String msg,PrintWriter log,boolean debug){
        synchronized(log){
        Date d = new Date();
        String s = DateFormat.getDateTimeInstance()
            .format(d);
        log.println(s+"："+msg);
        log.println(s+"：该错误如下：");
        e.printStackTrace(log);
        if(debug){
            System.out.println(s+"："+msg);
            System.out.println(s+"：该错误如下：");
            e.printStackTrace(System.out);
          }
        }
    }

    private void innerLog(Throwable e,PrintWriter log,boolean debug){
        synchronized(log){
        Date d = new Date();
        String s = DateFormat.getDateTimeInstance()
            .format(d);
        log.println(s+"：发生错误：");
        e.printStackTrace(log);
        if(debug){
            System.out.println(s+"：发生错误：");
            e.printStackTrace(System.out);
        }
        }
    }


    private void log(String msg){
        switch(logType){
            case TYPE_SYSTEM:
                innerLog(msg,sysLog,displaySystemLog);
                break;
            case TYPE_SECURITY:
                innerLog(msg,secLog,displaySecurityLog);
                break;
            case TYPE_DEBUG:
                innerLog(msg,debugLog,displayDebugLog);
                break;
            case TYPE_ERROR:
                innerLog(msg,errLog,displayErrorLog);
                break;

        }
    }

    private void log(Throwable e,String msg){
        switch(logType){
            case TYPE_SYSTEM:
                innerLog(e,msg,sysLog,displaySystemLog);
                break;
            case TYPE_SECURITY:
                innerLog(e,msg,secLog,displaySecurityLog);
                break;
            case TYPE_DEBUG:
                innerLog(e,msg,debugLog,displayDebugLog);
                break;
            case TYPE_ERROR:
                innerLog(e,msg,errLog,displayErrorLog);
                break;
        }
    }

    private void log(Throwable e){
        switch(logType){
            case TYPE_SYSTEM:
                innerLog(e,sysLog,displaySystemLog);
                break;
            case TYPE_SECURITY:
                innerLog(e,secLog,displaySecurityLog);
                break;
            case TYPE_DEBUG:
                innerLog(e,debugLog,displayDebugLog);
                break;
            case TYPE_ERROR:
                innerLog(e,errLog,displayErrorLog);
                break;
        }
    }


    public static  void logSystem(String msg){
        sysIns.log(msg);
    }

    public static  void logSystem(Throwable e,String msg){
        sysIns.log(e,msg);
    }

    public static  void logSystem(Throwable e){
        sysIns.log(e);
    }
    public static  void logSecurity(String msg){
        secIns.log(msg);
    }

    public static  void logSecurity(Throwable e,String msg){
        secIns.log(e,msg);
    }

    public static  void logSecurity(Throwable e){
        secIns.log(e);
    }

    public static  void logDebug(String msg){
    	boolean bLog=true;
    	if(bLog) 
    	{
    	    debugIns.log("调试信息:" + msg);
    	}
    }

    public static  void logDebug(Throwable e,String msg){
        debugIns.log(e,msg);
    }

    public static  void logDebug(Throwable e){
        debugIns.log(e);
    }

    public static  void logError(String msg){
        errIns.log(msg);
    }

    public static  void logError(Throwable e,String msg){
        errIns.log(e,msg);
    }

    public static  void logError(Throwable e){
        errIns.log(e);
    }
    /**
     * 捕获例外抛出的信息
     * @param c
     * @param sMethodName
     * @param e
     */
    public synchronized static void  logError(Class c,String sMethodName,Exception e)
    {
        String str = null;
        if(c!=null)
            str = c.getName();
        String msg = "发生错误！\r\n"+"类："+str+"\r\n方法："+sMethodName;
        logError(e,msg);
    }
    /**
     * 调试信息
     * @param c
     * @param sMsg
     */
    public synchronized static void  logMsg(Class c,String sMsg)
    {
        String str = null;
        if(c!=null)
            str = c.getName();
        String msg = "调试信息！\r\n"+"类："+str+"\r\n信息："+sMsg;
        logDebug(null,msg);
    }
   public static void main(String[] args)
   {
       logDebug("xxxxxxxxxxxxx");
       logSystem("hello你好啊！");
   }
}

