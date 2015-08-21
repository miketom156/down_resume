package com.job5156.jsDateJoin.event;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.job5156.jsDateJoin.entity.PersonBaseInfo;
import com.job5156.jsDateJoin.entity.PersonIntent;
import com.job5156.jsDateJoin.entity.PersonSchool;
import com.job5156.jsDateJoin.entity.PersonSkill;
import com.job5156.jsDateJoin.entity.PersonWork;
import com.job5156.server.EntityManager;
import com.job5156.server.SessionManager;
import com.job5156.util.StringUtil;

public class DelInputPerson29 {

	private static Logger log = Logger.getLogger(DelInputPerson29.class);
	
	public static void main(String[] args) {
		System.out.println("----------江苏人才网 个人数据 删除29 开始！--------------");
		long begintime = System.currentTimeMillis();
		Session session29  = SessionManager.currentSession();
		delPerson(session29);
		session29.close();
		long endtime = System.currentTimeMillis();
		System.out.println("----------江苏人才网 企业基本数据和职位 删除29 结束！用时："+(endtime - begintime)/1000/60+" 分钟");
		log.error("江苏人才网 个人数据 删除29 用时："+(endtime - begintime)/1000/60+" 分钟");
	}
	
	public static void delPerson(Session session29){
		String hqlCount = "SELECT COUNT(p.id) FROM PersonBaseInfo p where p.comefrom = 134";
		String hql = "SELECT p FROM PersonBaseInfo p where p.comefrom = 134";
		
		int allRecord = EntityManager.getAllEntityNumberByHql(hqlCount, session29);
		int dataLoadNumber = 50;
		int allPage = allRecord > 0 ? 1 : 0;
		if(allRecord > dataLoadNumber){
			allPage = allRecord / dataLoadNumber + ((allRecord % dataLoadNumber == 0) ? 0 : 1);
		}
		
		for(int m=0; m<allPage; m++){
			List list = EntityManager.getEntityByHqlAndStartRecords(hql, session29, 0, dataLoadNumber);
			
			if(list != null && list.size() > 0){
				Object[] objpbi = new Object[list.size()];
				String buffer = new String();
				List listScholl = null;
				List listWork = null;
				List listInter = null;
				List listSkill = null;
				
				for(int i=0; i<list.size(); i++){
					PersonBaseInfo pbi = (PersonBaseInfo)list.get(i);
					objpbi[i] = pbi;
					buffer += StringUtil.parseInt(pbi.getId());
					buffer += ",";
				}
				
				if(!"".equals(buffer)){
					buffer = buffer.substring(0,buffer.length()-1);
					String hql2 = "select p from PersonSchool p where p.userid in ("+buffer+")";
					listScholl = (List)EntityManager.getAllEntityByHql(hql2, session29);
					
					String hql3 = "select p from PersonWork p where p.userid in ("+buffer+")";
					listWork = (List)EntityManager.getAllEntityByHql(hql3, session29);
					
					String hql4 = "select p from PersonIntent p where p.userid in ("+buffer+")";
					listInter = (List)EntityManager.getAllEntityByHql(hql4, session29);
					
					String hql5 = "select p from PersonSkill p where p.userid in ("+buffer+")";
					listSkill = (List)EntityManager.getAllEntityByHql(hql5, session29);				
				}
				
				if(listScholl != null && listScholl.size()>0){
					Object[] objSch = new Object[listScholl.size()];
					for(int j=0;j<listScholl.size();j++){
						objSch[j] = (PersonSchool)listScholl.get(j);
					}
					EntityManager.batchDelete(objSch, session29);
					objSch = null;
				}
				
				if(listWork != null && listWork.size()>0){
					Object[] objWork = new Object[listWork.size()];
					for(int j=0;j<listWork.size();j++){
						objWork[j] = (PersonWork)listWork.get(j);
					}
					EntityManager.batchDelete(objWork, session29);
					objWork = null;
				}
				
				if(listInter != null && listInter.size()>0){
					Object[] objInter = new Object[listInter.size()];
					for(int j=0;j<listInter.size();j++){
						objInter[j] = (PersonIntent)listInter.get(j);
					}
					EntityManager.batchDelete(objInter, session29);
					objInter = null;
				}
				
				if(listSkill != null && listSkill.size()>0){
					Object[] objSkill = new Object[listSkill.size()];
					for(int j=0;j<listSkill.size();j++){
						objSkill[j] = (PersonSkill)listSkill.get(j);
					}
					EntityManager.batchDelete(objSkill, session29);
					objSkill = null;
				}
				EntityManager.batchDelete(objpbi, session29);
				objpbi = null;
			}		
		}
		
	}
	
	
	

}
