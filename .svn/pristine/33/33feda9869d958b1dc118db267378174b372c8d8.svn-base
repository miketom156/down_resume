/*
 * Created on 2006-3-22
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.job5156.server;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class EntityManager {
	 /** 通过hql取得当前实体的数量*/
    public static int getAllEntityNumberByHql(String hql,Session session) {
        String temphql = hql.toLowerCase();
        if (temphql.indexOf("count") == -1) {
            hql = " select count(*) " + hql;
        }
        List list = getAllEntityByHql(hql,session);
        if(list!=null && list.size()>0)
        	return ((Integer)(list.get(0))).intValue();
        else return 0;
    }
	
	/**通过现有的session和HQL显示所有记录，返回List对象**/
	public static List getAllEntityByHql(
		String hql,
		Session session) {
		List list = new ArrayList();
		try {
			Query query = session.createQuery(hql);
			list = query.list();		
		} catch (Exception e) {
			System.out.println("error:" + e.getMessage().toString());
		}
		return list;
	}

	/**通过现有的session和HQL显示所有记录，返回List对象**/
	public static List getEntityByHqlAndStartRecords(
		String hql,
		Session session,int first,int max) {
		List list = new ArrayList();
		try {			
			Query query = session.createQuery(hql);
			query.setFirstResult(first);
			query.setMaxResults(max);
			list = query.list();		
		} catch (Exception e) {
			System.out.println("error:" + e.getMessage().toString());
		}
		return list;
	}
	
	

	/**通过现有的session和HQL显示所有记录，返回List对象**/
	public static Object getFirstEntityByHql(
		String hql,
		Session session) {
		List list = new ArrayList();
		try {	
			list = getAllEntityByHql(hql,session);		
		} catch (Exception e) {
			System.out.println("error:" + e.getMessage().toString());
		}
		if(list!=null && list.size()>0)
			return list.get(0);
		else
			return null;
	}
    
    /****
     * 批量保存
     * @param saveObj
     * @return
     */
    public static boolean batchSave(Object[] saveObj,Session session){
        try{
            if(saveObj!=null){
                for(int i=0;i<saveObj.length;i++){
                    session.save(saveObj[i]);
                }
                session.flush();
            }
            return true;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    /****
     * 批量更新
     * @param updateObj
     * @param session
     * @return
     */
    public static boolean batchUpdate(Object[] updateObj,Session session)
    {
        try{
            if(updateObj!=null){
                for(int i=0;i<updateObj.length;i++){
                    session.update(updateObj[i]);                  
                }
                session.flush();
            }
            return true;
        }
        catch(Exception ex)
        {
            return false;
        }

    }
    
    /****
     * 实体更新
     * @param updateObj
     * @param session
     * @return
     */
    public static boolean  updateEntity(Object updateObj,Session session)
    {
        try{
            if(updateObj!=null){
                session.update(updateObj);                  
                session.flush();
            }
            return true;
        }
        catch(Exception ex)
        {
            return false;
        }

    }
    
    /****
     * 实体更新
     * @param updateObj
     * @param session
     * @return
     */
    public static boolean  saveEntity(Object saveObj,Session session)
    {
        try{
            if(saveObj!=null){
                session.save(saveObj);                  
                session.flush();
            }
            return true;
        }
        catch(Exception ex)
        {
        	ex.printStackTrace();
            return false;
        }

    }
    
    /***
     * 批量删除
     * @param delObj
     * @param session
     * @return
     */
    public static boolean batchDelete(Object[] delObj,Session session)
    {
        try{
            if(delObj!=null){
                for(int i=0;i<delObj.length;i++){
                    session.delete(delObj[i]);                  
                }
                session.flush();
            }
            return true;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return false;
        }

    }
	
	/**
	 * @param name
	 * @param comid
	 * @return
	 */
	public static Object getEntityInstanceById(Class className, Integer id,Session session) {
		// TODO Auto-generated method stub
		
		return session.load(className,id);
	}

}
