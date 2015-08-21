package com.job5156.jsDateJoin.event;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.job5156.jsDateJoin.entity.ComBaseInfo;
import com.job5156.jsDateJoin.entity.ComPosition;
import com.job5156.jsDateJoin.entity.ComUserInfo;
import com.job5156.server.EntityManager;
import com.job5156.server.SessionManager;
import com.job5156.util.StringUtil;

public class DelInputCompany29 {
	private static Logger log = Logger.getLogger(DelInputCompany29.class);
	public static void main(String[] args){
		System.out.println("----------江苏人才网 企业基本数据和职位 删除29 开始！--------------");
		long begintime = System.currentTimeMillis();
		Session session29  = SessionManager.currentSession();
		delComDate(session29);
		session29.close();
		long endtime = System.currentTimeMillis();
		System.out.println("----------江苏人才网 企业基本数据和职位 删除29 结束！用时："+(endtime - begintime)/1000/60+" 分钟");
		log.error("江苏人才网 企业基本数据和职位 删除29 用时："+(endtime - begintime)/1000/60+" 分钟");
	}
	
	public static void delComDate(Session session29){
		String hqlCount = "SELECT COUNT(c.id) FROM ComBaseInfo c where c.comflag = 10";
		String hql = "SELECT c FROM ComBaseInfo c where c.comflag = 10";
		
		int allRecord = EntityManager.getAllEntityNumberByHql(hqlCount, session29);
		int dataLoadNumber = 50;
		int allPage = allRecord > 0 ? 1 : 0;
		if(allRecord > dataLoadNumber){
			allPage = allRecord / dataLoadNumber + ((allRecord % dataLoadNumber == 0) ? 0 : 1);
		}
		
		for(int m=0; m<allPage; m++){
			List list = EntityManager.getEntityByHqlAndStartRecords(hql, session29, 0, dataLoadNumber);
			if(list != null && list.size() > 0){
				Object[] objcbi = new Object[list.size()];
				String buffer = new String();
				
				List listCUI = null;
				List listPos = null;
				
				
				for(int i=0; i<list.size(); i++){
					ComBaseInfo cbi = (ComBaseInfo)list.get(i);
					objcbi[i] = cbi;
					buffer += StringUtil.parseInt(cbi.getId());
					buffer += ",";
				}
				
				if(!"".equals(buffer)){
					buffer = buffer.substring(0,buffer.length()-1);
					String hql2 = "select c from ComUserInfo c where c.comid in ("+buffer+")";
					listCUI = (List)EntityManager.getAllEntityByHql(hql2, session29);
					
					String hql3 = "select p from ComPosition p where p.comid in ("+buffer+")";
					listPos = (List)EntityManager.getAllEntityByHql(hql3, session29);						
				}
				
				if(listCUI != null && listCUI.size()>0){
					Object[] objcui = new Object[listCUI.size()];
					for(int j=0;j<listCUI.size();j++){
						objcui[j] = (ComUserInfo)listCUI.get(j);
					}
					EntityManager.batchDelete(objcui, session29);
					objcui = null;
				}
				
				if(listPos != null && listPos.size()>0){
					Object[] objpos = new Object[listPos.size()];
					for(int j=0;j<listPos.size();j++){
						objpos[j] = (ComPosition)listPos.get(j);
					}
					EntityManager.batchDelete(objpos, session29);
					objpos = null;
				}
				
				EntityManager.batchDelete(objcbi, session29);
				objcbi = null;
				
				listCUI.clear();
				listPos.clear();
			}
			
			list.clear();
			session29.clear();			
		}
		
	}
	
	public static void delDate(Session session29){
		String hql = "select c from ComBaseInfo c where c.comflag = 10";
		List list = (List)EntityManager.getAllEntityByHql(hql, session29);
		String buffer = new String();
		
		if(list !=null && list.size()>0){
			Object[] obj = new Object[list.size()];
			
			for(int i=0;i<list.size();i++){
				ComBaseInfo cbi = (ComBaseInfo)list.get(i);
				obj[i] = cbi;
				//buffer.append(StringUtil.parseInt(cbi.getId()));
				//buffer.append(",");
				buffer += StringUtil.parseInt(cbi.getId());
				buffer += ",";
				
			}
			EntityManager.batchDelete(obj, session29);			
		}
		if(!"".equals(buffer)){
			buffer = buffer.substring(0,buffer.length()-1);
			String hql1 = "select c from ComUserInfo c where c.comid in ("+buffer.toString()+")";
			List cuiList = (List)EntityManager.getAllEntityByHql(hql1, session29);			

			if(cuiList !=null && cuiList.size()>0){
				Object[] obj1 = new Object[cuiList.size()];
				
				for(int j=0;j<list.size();j++){
					ComUserInfo cui = (ComUserInfo)cuiList.get(j);
					obj1[j] = cui;									
				}
				EntityManager.batchDelete(obj1, session29);			
			}
			
			String hql2 = "select c from ComPosition c where c.comid in ("+buffer+")";
			List cpList = (List)EntityManager.getAllEntityByHql(hql2, session29);			

			if(cpList !=null && cpList.size()>0){
				Object[] obj2 = new Object[cpList.size()];				
				for(int k=0;k<cpList.size();k++){
					ComPosition cp = (ComPosition)cpList.get(k);
					obj2[k] = cp;									
				}
				EntityManager.batchDelete(obj2, session29);			
			}
		}
	}
}
