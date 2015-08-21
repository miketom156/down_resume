package com.job5156.util;

/**
 * @author <a href="mailto:lzjliu307@sohu.com">Lzj.Liu</a>
 * @deprecated 系统数据库连接池的管理类
 */
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.Date;
import com.job5156.util.*;

/**
 * 定义数据库连接池的访问.
 * 客户程序可以调用getInstance()方法访问本类的唯一实例.
 */
public class DBConnectionManager
{
    private static DBConnectionManager instance; // 唯一实例

    private static int clients;

    static int conNumber = 0;

    private Vector<Object> drivers = new Vector<Object>();

    private PrintWriter log;

    public Hashtable<String, Object> pools = new Hashtable<String, Object>();

    /**
     * 返回唯一实例.如果是第一次调用此方法,则创建实例
     *
     * @return DBConnectionManager 唯一实例
     */
    public static synchronized DBConnectionManager getInstance()
    {
        if (instance == null)
        {
            instance = new DBConnectionManager();
        }
        clients++;
        return instance;
    }

    /**
     * 建构函数私有以防止其它对象创建本类实例
     */
    private DBConnectionManager()
    {
        init();
    }

    /**
     * 将连接对象返回给由名字指定的连接池
     *
     * @param name 在属性文件中定义的连接池名字
     * @param con 连接对象\\r
     */
    public void freeConnection(String name, Connection con)
    {
        DBConnectionPool pool = (DBConnectionPool) pools.get(name);
        if (pool != null)
        {
            pool.freeConnection(con);
        }
    }

    /**
     * 获得一个可用的(空闲的)连接.如果没有可用连接,且已有连接数小于最大连接数
     * 限制,则创建并返回新连接
     *
     * @param name 在属性文件中定义的连接池名字
     * @return Connection 可用连接或null
     */
    public synchronized Connection getConnection(String name)
    {
       // System.out.println(name+"=");
        DBConnectionPool pool = (DBConnectionPool) pools.get(name);
      //  System.out.println("this:  " + pool);
        if (pool != null) { return pool.getConnection(); }
        return null;
    }

    /**
     * 获得一个可用连接.若没有可用连接,且已有连接数小于最大连接数限制,
     * 则创建并返回新连接.否则,在指定的时间内等待其它线程释放连接.
     *
     * @param name 连接池名字
     * @param time 以毫秒计的等待时间\\r

     * @return Connection 可用连接或null
     */
    public synchronized Connection getConnection(String name, long time)
    {
        DBConnectionPool pool = (DBConnectionPool) pools.get(name);
        if (pool != null) { return pool.getConnection(time); }
        return null;
    }

    /**
     * 关闭所有连接,撤销驱动程序的注册\\r

     */
    public synchronized void release()
    {
        // 等待直到最后一个客户程序调用
        if (--clients != 0) { return; }

        Enumeration allPools = pools.elements();
        while (allPools.hasMoreElements())
        {
            DBConnectionPool pool = (DBConnectionPool) allPools.nextElement();
            pool.release();
        }
        Enumeration allDrivers = drivers.elements();
        while (allDrivers.hasMoreElements())
        {
            Driver driver = (Driver) allDrivers.nextElement();
            try
            {
                DriverManager.deregisterDriver(driver);
                
                //FileLog.logDebug("撤销JDBC驱动程序 " + driver.getClass().getName()+ "的注册");
            }
            catch (SQLException e)
            {
                log(e, "无法撤销下列JDBC驱动程序的注册: " + driver.getClass().getName());
            }
        }
    }

    /**
     * 根据指定属性创建连接池实例.
     *
     * @param props 连接池属性
     */
    private void createPools()
    {
        String url1 = "jdbc:mysql://192.168.2.187/Jobquery";
        //String url2 = "jdbc:microsoft:sqlserver://192.168.2.185:1433;DatabaseName=position";
        //String url3 = "jdbc:microsoft:sqlserver://192.168.5.227:1433;DatabaseName=tempdb";
        //String url4 = "jdbc:microsoft:sqlserver://192.168.2.185:1433;DatabaseName=5156Query";
        String user = "root";
        String password = "123";
        DBConnectionPool pool1 = new DBConnectionPool("jobquery", url1, user, password, 150);
        //DBConnectionPool pool2 = new DBConnectionPool("chitone", url2, user, password, 150);
        //DBConnectionPool pool3 = new DBConnectionPool("temp", url3, user, password, 150);
        //DBConnectionPool pool4 = new DBConnectionPool("query5156", url4, user, password, 150);
        pools.put("jobquery", pool1);
        //pools.put("chitone", pool2);
        //pools.put("temp", pool3);
        //pools.put("query5156", pool4);
    }

    /**
     * 数据库连接初始化
     */
    private void init()
    {
        //System.out.println("xxxxxxxxxxxxxx");
        loadDrivers();
        createPools();
    }

    /**
     * 装载和注册JDBC驱动程序
     */
    private void loadDrivers()
    {
        String driverClassName = "com.mysql.jdbc.Driver";
        try
        {
            Driver driver = (Driver) Class.forName(driverClassName).newInstance();
            DriverManager.registerDriver(driver);
            drivers.addElement(driver);
        }
        catch (Exception e)
        {
            System.out.println("无法注册JDBC驱动程序: " + driverClassName + ", 错误: "
                    + e);
        }
    }

    /**
     * 将文本信息写入日志文件
     */
    private void log(String msg)
    {
       // log.println(new Date() + ": " + msg);
    }

    /**
     * 将文本信息与异常写入日志文件
     */
    private void log(Throwable e, String msg)
    {
       // FileLog.logDebug(e.toString() + ": " + msg);
      //  e.printStackTrace(log);
    }

    /**
     * 此内部类定义了一个连接池.它能够根据要求创建新连接,直到预定的最\\r

     * 大连接数为止.在返回连接给客户程序之前,它能够验证连接的有效性.
     */
    class DBConnectionPool
    {
        private int checkedOut;

        private Vector<Object> freeConnections = new Vector<Object>();

        public int maxConn;

        private String name;

        private String password;

        private String URL;

        private String user;

        /**
         * 创建新的连接池
         *
         * @param name 连接池名字
         * @param URL 数据库的JDBC URL
         * @param user 数据库帐号,或 null
         * @param password 密码,或 null
         * @param maxConn 此连接池允许建立的最大连接数
         */
        public DBConnectionPool(String name, String URL, String user,
                String password, int maxConn)
        {
            this.name = name;
            this.URL = URL;
            this.user = user;
            this.password = password;
            this.maxConn = maxConn;
        }

        /**
         * 将不再使用的连接返回给连接池
         *
         * @param con 客户程序释放的连接
         */
        public synchronized void freeConnection(Connection con)
        {
            //将指定连接加入到向量末尾
            freeConnections.addElement(con);
            checkedOut--;
            //System.out.println("!!!!数据库连接池观察:conNumber="+conNumber+", checkedOut="+checkedOut+", maxConn="+maxConn+", freeConnections.size()"+freeConnections.size()+"，pools.size()"+pools.size()+"xxxxxxxxxxxxx");
            notifyAll();
        }

        /**
         * 从连接池获得一个可用连接.如没有空闲的连接且当前连接数小于最大连接
         * 数限制,则创建新连接.如原来登记为可用的连接不再有效,则从向量删除之,
         * 然后递归调用自己以尝试新的可用连接.
         */
        public synchronized Connection getConnection()
        {
            Connection con = null;
            if (freeConnections.size() > 0)
            {
                //获空闲的连接向量中取第一个可用连接
                con = (Connection) freeConnections.firstElement();
                freeConnections.removeElementAt(0);
                try
                {
                    if (con.isClosed())
                    {
                        log("从连接池" + name + "删除一个无效连接");
                        //    递归调用自己,尝试再次获取可用连接
                        con = getConnection();
                    }
                }
                catch (SQLException e)
                {
                    log("从连接池" + name + "删除一个无效连接");
                    //    递归调用自己,尝试再次获取可用连接
                    con = getConnection();
                }
            }
            else if (maxConn == 0
                    || freeConnections.size() + checkedOut < maxConn)
            {
                con = newConnection();
            }

            if (con != null)
            {
                checkedOut++;
            }
            else
            {
                con = newConnection();
                checkedOut++;
            }
            //System.out.println("@@@@@@@@@@@@@@@@@@数据库连接池观察:conNumber="+conNumber+", checkedOut="+checkedOut+", maxConn="+maxConn+", freeConnections.size()"+freeConnections.size()+"@@@@@@@@@@@@@@@");
            return con;
        }

        /**
         * 从连接池获取可用连接.可以指定客户程序能够等待的最长时间\\r

         * 参见前一个getConnection()方法.
         *
         * @param timeout 以毫秒计的等待时间限制
         */
        public synchronized Connection getConnection(long timeout)
        {
            long startTime = new Date().getTime();
            Connection con;
            while ((con = getConnection()) == null)
            {
                try
                {
                    wait(timeout);
                }
                catch (InterruptedException e)
                {
                }
                if ((new Date().getTime() - startTime) >= timeout)
                {
                    //    wait()返回的原因是超时
                    return null;
                }
            }
            return con;
        }

        /**
         * 关闭所有连接
         */
        public synchronized void release()
        {
            Enumeration allConnections = freeConnections.elements();
            while (allConnections.hasMoreElements())
            {
                Connection con = (Connection) allConnections.nextElement();
                try
                {
                    con.close();
                    log("关闭连接池" + name + "中的一个连接");
                }
                catch (SQLException e)
                {
                    log(e, "无法关闭连接池" + name + "中的连接");
                }
            }
            freeConnections.removeAllElements();
        }

        /**
         * 创建新的连接
         */
        private Connection newConnection()
        {
            Connection con = null;
            try
            {
                if (user == null)
                {
                    con = DriverManager.getConnection(URL);
                }
                else
                {
                    con = DriverManager.getConnection(URL, user, password);
                }
                log("连接池" + name + "创建一个新的连接");
            }
            catch (SQLException e)
            {
                log(e, "无法创建下列URL的连接: " + URL);
                return null;
            }
            if (con != null) conNumber++;
            return con;
        }
    }
   
     public static void main(String args[])
     {
     DBConnectionManager connMgr=null;
     connMgr = DBConnectionManager.getInstance();
     System.out.println(connMgr);
     connMgr.release();
    
     
     connMgr.getConnection("jobquery");
     System.out.println(connMgr+"=========");
     Connection con =  connMgr.getConnection("jobquery");
     if(con==null)
     {
     System.out.print("nulll"+con);
     }  
     DBConnectionManager.DBConnectionPool pool =(DBConnectionPool)connMgr.pools.get("idb");
     
     for(int k=0;k<=30;k++){
     System.out.println("conn"+connMgr.getConnection("jobquery"));
     }
     
     }
     
}
