package com.job5156.ningboAccessToMysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.job5156.jsDateJoin.entity.ComBaseInfo;
import com.job5156.jsDateJoin.entity.ComPosition;
import com.job5156.jsDateJoin.entity.NingboEntity;
import com.job5156.server.EntityManager;
import com.job5156.server.LocalSessionManager;
import com.job5156.util.StringUtil;

public class InputCompanyTO29 {
	private static Logger log = Logger.getLogger(InputCompanyTO29.class);

	/*
	 * 后来更改要求后，不用这个类
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws SQLException {
		System.out.println("----------宁波人才网 企业基本数据和职位 导入本地数据库 开始！--------------");
		long begintime = System.currentTimeMillis();
		Session session29=LocalSessionManager.currentSession();
		
		//使用JDBC查询Access
		JDBCAccess jdbc = new JDBCAccess();
		Connection conn = jdbc.getConn();
		runCompanyDate(conn, session29);
		session29.close();
		jdbc.closeAll(conn, null, null);
		long endtime = System.currentTimeMillis();
		System.out.println("----------宁波人才网 企业基本数据和职位 导入本地数据库 结束！用时：" + (endtime - begintime) / 1000 / 60 + " 分钟");
		log.error("宁波人才网 企业基本数据和职位 导入数据库 用时：" + (endtime - begintime) / 1000 / 60 + " 分钟");

	}

	@SuppressWarnings("unchecked")
	public static void runCompanyDate(Connection conn, Session session29) throws SQLException {
		GetComPosition getcp = new GetComPosition();
		GetComBaseInfo getcbi = new GetComBaseInfo();
		GetNiboEntity getnb = new GetNiboEntity();
		
		String sql = "select count(id) from Content";
		String pageSql = "select * from Content";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		int allRecord = 0;			//总记录数
		while (rs.next()) {
			allRecord = StringUtil.parseInt(StringUtil.getNotNullStr(rs.getString(1)));
		}
		rs.close();
		ps.close();
		int dataLoadNumber = 2000;				//每页显示条数
		int allPage = allRecord > 0 ? 1 : 0;	//页数
		if(allRecord > dataLoadNumber){
			allPage = allRecord / dataLoadNumber + ((allRecord % dataLoadNumber == 0) ? 0 : 1);
		}

		for (int m = 0; m < allPage; m++) {
			System.out.println("公司基本信息 第" + (m+1) + "页");
			int k = 0;
			
			//记取Access里面一页的数据(conn,sql,起始页，一页记录数据数)
			rs = queryPageRelative(conn, pageSql, m, dataLoadNumber);
			rs.last();						//将光标移到最后获取分页后查询出来的总行数	
			int row = rs.getRow();
			if (rs != null && row > 0) {
					
				// 数据处理 将从Access里读取出的数据存入NingboEntity里
				rs.first();							//将光标移到第一行
				int i=1;
				while (rs.next()) {
					//用while遍历rs时，已经next()了，当第一进入已经是第二行，所以当I=1时把指针指向第一条
					if(i == 1){
						rs.first();
					}
					NingboEntity nibo = getnb.getNO(rs);
						try {
							System.out.println("无注册公司基本信息 第" + i + "条");

							// 企业 ComBaseInfo 导入 错误是因为修改了GetComBaseInfo类
							ComBaseInfo cbi = getcbi.getCBI(nibo);
							EntityManager.saveEntity(cbi, session29);// 保存数据
							int comID = StringUtil.parseInt(cbi.getId());

							// 企业ComPosition导入
							ComPosition cp = (ComPosition) getcp.getCP(nibo, comID, session29);
							EntityManager.saveEntity(cp, session29);

						} catch (Exception e) {
							e.printStackTrace();
							log.error("导入的宁波人才网数据的 第" + m * dataLoadNumber + i + "出了问题！");
						}
					i++;				//第几家公司
					
					k++;
					if (k > 100) {
						session29.clear();
						k = 0;
					}

					try {
						Thread.sleep(500);
						System.out.println("休眠半秒钟！");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						System.out.println("休眠半秒钟 出错！");
						e.printStackTrace();
					}
					
				}
				rs.close();
				ps.close();
			}
		}
	}

	public static boolean isChince(String str) {
		boolean flag = true;
		if ("".equals(str)) {
			flag = false;
		}
		int count = 0;
		String regEx = "[\\u4e00-\\u9fa5]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		while (m.find()) {
			for (int i = 0; i <= m.groupCount(); i++) {
				count = count + 1;
				break;
			}
		}
		if (count > 0) {
			flag = false;
		}

		return flag;
	}

	/**
	 * @param name
	 * @param temp
	 * @param session29
	 * @return flag>0用户已注册返回false
	 * @return boolean 返回类型
	 * @throws [抛出的异常类型]
	 *             异常说明
	 
	public static boolean isTrue(String name, int temp, Session session29) {
		boolean flag = true;
		String hql = "";
		if (1 == temp) {
			hql = "SELECT COUNT(c.id) FROM ComBaseInfo c WHERE c.comname = '" + name + "'";

		} else if (2 == temp) {

		}
		int num = EntityManager.getAllEntityNumberByHql(hql, session29);
		if (num > 0) {
			flag = false;
		}
		return flag;
	}

	@SuppressWarnings("unchecked")
	public static void saveDate(Session session29, List list) {
		Object[] obj = new Object[list.size()];

		for (int j = 0; j < list.size(); j++) {
			obj[j] = list.get(j);
		}

		EntityManager.batchSave(obj, session29);
		session29.flush();
		session29.clear();
		obj = null;
	}*/

	/**
	 * 功能描述: 判断该职位是否已经发布，因为很多类都要用到发布职位，所以提取出来以作调用
	 * 
	 * @return void 返回类型
	 * @throws [抛出的异常类型]
	 *             异常说明
	 
	public static void checkPosition(int comId, Session session, NingboEntity nibo, GetComPosition getcp) {
		List<ComPosition> listCP = getcp.getCP(comId, nibo.getPosname(), session);
		if (listCP == null || listCP.size() == 0) {
			// 发布职位
			ComPosition cp = getcp.getCP(nibo, comId, session);
			EntityManager.saveEntity(cp, session);
		}
	}*/
	
	/**  
     * JDBC 分页查询  
     * @param sql        SQL 查询语句  
     * @param firstSize  起始页  
     * @param maxSize    返回数据条数  
     * @return ResultSet 返回结果集  
     * @throws SQLException  
      
	
    public static ResultSet queryPageRelative(Connection conn,String sql,   
            int firstSize,int maxSize) throws SQLException {   
        PreparedStatement pre = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);   
        pre.setMaxRows(maxSize);   
        ResultSet rs = pre.executeQuery();
        rs.first();
        rs.relative(firstSize);   
        return rs;   
    }   
*/
}
