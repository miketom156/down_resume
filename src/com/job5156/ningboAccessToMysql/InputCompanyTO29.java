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
	 * ��������Ҫ��󣬲��������
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws SQLException {
		System.out.println("----------�����˲��� ��ҵ�������ݺ�ְλ ���뱾�����ݿ� ��ʼ��--------------");
		long begintime = System.currentTimeMillis();
		Session session29=LocalSessionManager.currentSession();
		
		//ʹ��JDBC��ѯAccess
		JDBCAccess jdbc = new JDBCAccess();
		Connection conn = jdbc.getConn();
		runCompanyDate(conn, session29);
		session29.close();
		jdbc.closeAll(conn, null, null);
		long endtime = System.currentTimeMillis();
		System.out.println("----------�����˲��� ��ҵ�������ݺ�ְλ ���뱾�����ݿ� ��������ʱ��" + (endtime - begintime) / 1000 / 60 + " ����");
		log.error("�����˲��� ��ҵ�������ݺ�ְλ �������ݿ� ��ʱ��" + (endtime - begintime) / 1000 / 60 + " ����");

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
		int allRecord = 0;			//�ܼ�¼��
		while (rs.next()) {
			allRecord = StringUtil.parseInt(StringUtil.getNotNullStr(rs.getString(1)));
		}
		rs.close();
		ps.close();
		int dataLoadNumber = 2000;				//ÿҳ��ʾ����
		int allPage = allRecord > 0 ? 1 : 0;	//ҳ��
		if(allRecord > dataLoadNumber){
			allPage = allRecord / dataLoadNumber + ((allRecord % dataLoadNumber == 0) ? 0 : 1);
		}

		for (int m = 0; m < allPage; m++) {
			System.out.println("��˾������Ϣ ��" + (m+1) + "ҳ");
			int k = 0;
			
			//��ȡAccess����һҳ������(conn,sql,��ʼҳ��һҳ��¼������)
			rs = queryPageRelative(conn, pageSql, m, dataLoadNumber);
			rs.last();						//������Ƶ�����ȡ��ҳ���ѯ������������	
			int row = rs.getRow();
			if (rs != null && row > 0) {
					
				// ���ݴ��� ����Access���ȡ�������ݴ���NingboEntity��
				rs.first();							//������Ƶ���һ��
				int i=1;
				while (rs.next()) {
					//��while����rsʱ���Ѿ�next()�ˣ�����һ�����Ѿ��ǵڶ��У����Ե�I=1ʱ��ָ��ָ���һ��
					if(i == 1){
						rs.first();
					}
					NingboEntity nibo = getnb.getNO(rs);
						try {
							System.out.println("��ע�ṫ˾������Ϣ ��" + i + "��");

							// ��ҵ ComBaseInfo ���� ��������Ϊ�޸���GetComBaseInfo��
							ComBaseInfo cbi = getcbi.getCBI(nibo);
							EntityManager.saveEntity(cbi, session29);// ��������
							int comID = StringUtil.parseInt(cbi.getId());

							// ��ҵComPosition����
							ComPosition cp = (ComPosition) getcp.getCP(nibo, comID, session29);
							EntityManager.saveEntity(cp, session29);

						} catch (Exception e) {
							e.printStackTrace();
							log.error("����������˲������ݵ� ��" + m * dataLoadNumber + i + "�������⣡");
						}
					i++;				//�ڼ��ҹ�˾
					
					k++;
					if (k > 100) {
						session29.clear();
						k = 0;
					}

					try {
						Thread.sleep(500);
						System.out.println("���߰����ӣ�");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						System.out.println("���߰����� ����");
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
	 * @return flag>0�û���ע�᷵��false
	 * @return boolean ��������
	 * @throws [�׳����쳣����]
	 *             �쳣˵��
	 
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
	 * ��������: �жϸ�ְλ�Ƿ��Ѿ���������Ϊ�ܶ��඼Ҫ�õ�����ְλ��������ȡ������������
	 * 
	 * @return void ��������
	 * @throws [�׳����쳣����]
	 *             �쳣˵��
	 
	public static void checkPosition(int comId, Session session, NingboEntity nibo, GetComPosition getcp) {
		List<ComPosition> listCP = getcp.getCP(comId, nibo.getPosname(), session);
		if (listCP == null || listCP.size() == 0) {
			// ����ְλ
			ComPosition cp = getcp.getCP(nibo, comId, session);
			EntityManager.saveEntity(cp, session);
		}
	}*/
	
	/**  
     * JDBC ��ҳ��ѯ  
     * @param sql        SQL ��ѯ���  
     * @param firstSize  ��ʼҳ  
     * @param maxSize    ������������  
     * @return ResultSet ���ؽ����  
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
