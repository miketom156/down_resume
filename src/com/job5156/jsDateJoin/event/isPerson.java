package com.job5156.jsDateJoin.event;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Session;

import com.job5156.jsDateJoin.entity.PersonBaseInfo;
import com.job5156.jsDateJoin.entity.PersonIntent;
import com.job5156.jsDateJoin.entity.PersonSchool;
import com.job5156.jsDateJoin.entity.PersonSkill;
import com.job5156.jsDateJoin.entity.PersonWork;
import com.job5156.jsDateJoin.entity.person;
import com.job5156.server.EntityManager;
import com.job5156.server.LocalSessionManager;
import com.job5156.server.SessionManager;
import com.job5156.util.StringUtil;

public class isPerson {
	private static int sum = 0;
	private static int sum1 = 0;

	public static void main(String[] args) {
		System.out.println("----------江苏人才网 个人会员 导入本地数据库 开始！--------------");
		long begintime = System.currentTimeMillis();
		Session localsession  = LocalSessionManager.currentSession();
		Session session29  = SessionManager.currentSession();
		
		runCompanyDate(localsession,session29);
		
		session29.close();
		localsession.close();
		long endtime = System.currentTimeMillis();
		System.out.println("----------江苏人才网 个人会员 导入本地数据库 结束！用时："+(endtime - begintime)/1000/60+" 分钟");
		System.out.println("sum="+sum);
		System.out.println("sum1="+sum1);
		
	}
	
	
		public static void runCompanyDate(Session localsession,Session session29){
			String hqlCount = "SELECT COUNT(p.id) FROM person p order by p.id";
			String hql = "SELECT p FROM person p order by p.id";
			
			int allRecord = EntityManager.getAllEntityNumberByHql(hqlCount, localsession);
			int dataLoadNumber = 2000;
			int allPage = allRecord > 0 ? 1 : 0;
			if(allRecord > dataLoadNumber){
				allPage = allRecord / dataLoadNumber + ((allRecord % dataLoadNumber == 0) ? 0 : 1);
			}
			List list = null;
			String email = "";			
			int k = 0;
			for(int m=0; m<allPage; m++){
				System.out.println("第"+m+"页数");
				list = EntityManager.getEntityByHqlAndStartRecords(hql, localsession, m*dataLoadNumber, dataLoadNumber);
				if(list != null && list.size() > 0){
					for(int i=0; i<list.size(); i++){					
						person p = (person)list.get(i);
						email = StringUtil.getNotNullStr(p.getEmail());	
						//System.out.println(i);
						//判断是否存在
//						if(isTrue(email,session29)){					
//															
//						}else{
//							sum++;
//							System.out.println("sum="+sum);
//						}
						if(isChince(StringUtil.getNotNullStr(p.getStartworkdate()))){					
															
						}else{
							sum1++;
							System.out.println("sum1="+sum1);
							System.out.println(p.getStartworkdate());
						}
						
						email = "";
					}
					
				}
				session29.clear();
				localsession.clear();
				list.clear();
			}		
		}
	
	
	public static boolean isTrue(String email,Session session29){
		boolean flag = true;
		if("".equals(email)){
			flag = false;
			return flag;
		}		
		String hql = "SELECT COUNT(p.id) FROM PersonBaseInfo p WHERE p.email = '"+email+"'";
		int num = EntityManager.getAllEntityNumberByHql(hql, session29);
		if(num > 0){
			flag = false;
		}
		return flag;
	}
	
	public static boolean isChince(String str){
		boolean flag = true;
//		if("".equals(str)){
//			flag = false;
//		}
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
        if(count > 0){
        	flag = false;
        }

		return flag;
	}

}