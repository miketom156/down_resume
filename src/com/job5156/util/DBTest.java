package com.job5156.util;

/**
 * ���ݿ������������,������ʵ����
 * @Aurhor:Lzj.Liu
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTest
{
    /**�������*/
    //private static final String FILE_PATH = "com.job5156.sql.";

    /**��Ĺ�����*/
    public DBTest()
    {
    }

    public DBTest(String DBname)
    {
        this.DBName = DBname;
    }

    private String DBName = ""; //Ҫ���ӵ����ݿ�

    private Connection conn = null;

    public Connection getConn()
    {
        return this.conn;
    }

    static DBConnectionManager connMgr = DBConnectionManager.getInstance();

    public synchronized Connection getConnect()
    {
        boolean blnConn = false;
        int m = 0;
        while (!blnConn && m < 20)
        {
            try
            {
                if (m++ > 0) Thread.sleep(500);
                this.conn = connMgr.getConnection(this.DBName);

                if (this.conn != null && !this.conn.isClosed())
                    if (conn != null && !conn.isClosed()) blnConn = true;
            }
            catch (SQLException sqlEx)
            {
                sqlEx.printStackTrace();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        return conn;
    }

    /**
     * �ͷ� local ���ӵ� freeConnections ����
     *
     */
    public void closeConnection()
    {
        try
        {
            if (this.conn != null)
            {
                connMgr.freeConnection(this.DBName, this.conn);
            }

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    /**
     * ����Text���͵��ֶ�
     * @param rs
     * @param i
     * @return
     */
    public static String getTextFieldByI(ResultSet rs, int i)
    {
        String ret = "";
        try
        {
            ret = rs.getString(i);
        }
        catch (Exception ex)
        {
            return "";
        }
        return ret;
    }

    /**
     * ����Text���͵��ֶ�
     * @param rs
     * @param colName ��λ����
     * @return
     */
    public static String getTextFieldByN(ResultSet rs, String colName)
    {
        String ret = "";
        try
        {
            ret = rs.getString(colName);
        }
        catch (Exception ex)
        {
            return "";
        }
        return ret;
    }

    /**
     * ����Date���͵��ֶ�
     * @param rs
     * @param colName ��λ����
     * @return
     */
    public static String getDateFieldByN(ResultSet rs, String colName)
    {
        String ret = "";
        try
        {
            //ret = DateUtil.formatSDate(rs.getDate(colName)).trim();
            ret=rs.getString(colName);
            if(ret==null)
                ret="";
        }
        catch (Exception ex)
        {
            return "";
        }        
        return ret;
    }

    /**
     * <p>ȡ���������ϵı��</p>
     * @param tableName ���ϱ�����
     * @return int ���
     */
    public static int getTableID(String tableName)
    {
        DBTest DB = null;
        int iTmp = 0;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        Connection conn = null;
        try
        {
            DB = new DBTest("jobquery");
            String strSQL = "SELECT ident_current('" + tableName + "')";
            conn = DB.getConnect();
            pstmt = conn.prepareStatement(strSQL);
            rs = pstmt.executeQuery();
            if (rs.next()) iTmp = rs.getInt(1);
        }
        catch (Exception ex)
        {
        	ex.printStackTrace();
            //FileLog.logDebug("getTableID(tableName)" + ex.toString());
        }
        finally
        {
            if (rs != null)
            {
                try
                {
                    rs.close();
                }
                catch (SQLException ex)
                {
                }
            }
            if (pstmt != null)
            {
                try
                {
                    pstmt.close();
                }
                catch (SQLException ex)
                {
                }
            }
            DB.closeConnection();
        }
        return iTmp;
    }

    public static void main(String[] sfgdf)
    {
        DBTest db = new DBTest("jobquery");
        System.out.println("DD:"+db.DBName);
        db.getConnect();
        System.out.println(db.getConn());
        //System.out.println(conn);
        db.closeConnection();
    }
}