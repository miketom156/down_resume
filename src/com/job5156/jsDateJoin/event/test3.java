package com.job5156.jsDateJoin.event;

import java.util.List;

import org.hibernate.Session;

import com.job5156.jsDateJoin.entity.test2;
import com.job5156.server.EntityManager;
import com.job5156.server.LocalSessionManager;

public class test3 {

	
	public static void main(String[] args) {
		long begintime = System.currentTimeMillis();
		Session localsession  = LocalSessionManager.currentSession();
		
		
		
		localsession.close();
		long endtime = System.currentTimeMillis();
	}
	
	public static void saveDate(Session localsession,List list){
		if(list != null && list.size()>0){
			Object[] obj = new Object[list.size()];
			
			for(int j=0;j<list.size();j++){
				obj[j]=list.get(j);
			}
			
			EntityManager.batchSave(obj, localsession);
			localsession.flush();
			localsession.clear();
			obj = null;
		}
		
	}
	

}
