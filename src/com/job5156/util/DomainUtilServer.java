/*
 * Created on 2008-4-1
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.job5156.util;

import org.dom4j.Document;

/**
 * @author Alpha
 *
 * TODO 二级域名管理
 */
public class DomainUtilServer {
	
	//	VISITDOMAIN:  1: http://219.136.248.210  2:  http://www.job5156.com
	public static String VISITDOMAIN = "http://www.job5156.com";  //主站域名
	public static String IMAGESDOMAIN = "http://images.job5156.com"; //上传图片二级域名
	
    /**
	 * 个人管理中心二级域名
	 * @return
	 */
	public static String getPersonDomain(Document document){
    	return StringUtil.getNotNullStr(document.getRootElement().elementText("personDomain"));
    }
	
	/**
	 * 企业管理中心二级域名
	 * @return
	 */
	public static String getCompanyDomain(Document document){
    	return StringUtil.getNotNullStr(document.getRootElement().elementText("companyDomain"));
    }
	
	/**
	 * 搜索二级域名
	 * @return
	 */
	public static String getSearchDomain(Document document){
    	return StringUtil.getNotNullStr(document.getRootElement().elementText("searchDomain"));
    }
	
	/**
	 * 行业站点二级域名
	 * @return
	 */
	public static String getSpecialDomain(Document document){
    	return StringUtil.getNotNullStr(document.getRootElement().elementText("specialDomain"));
    }
	

	/****
	 * 图片二级域名
	 * @return
	 */
    public static String getPhotoDomain(Document document) {
    	return StringUtil.getNotNullStr(document.getRootElement().elementText("photoDomain"));
    }
    
    /****
     * 分站点二级域名
     * @param website 站点名
     * @return
     */
    public static String getWebsiteDomain(Document document,String website) {
    	return StringUtil.getNotNullStr(document.getRootElement().element("websiteDomain").elementText(website));
    }
    
    /***
     * 职位查看 搜索频道 二级域名
     * @return
     */
    public static String getPositionLinkFromSearch(Document document){
    	return StringUtil.getNotNullStr(document.getRootElement().element("positionLink").elementText("search"));
    }
    
    /***
     * 职位查看 包含文件 二级域名
     * @return
     */
    public static String getPositionLinkFromInclude(Document document){
    	return StringUtil.getNotNullStr(document.getRootElement().element("positionLink").elementText("include"));
    }
    
    /***
     * 简历查看 搜索频道 二级域名
     * @return
     */
    public static String getResumeLinkFromSearch(Document document){
    	return StringUtil.getNotNullStr(document.getRootElement().element("resumeLink").elementText("search"));
    }
    
    /***
     * 简历查看 包含文件 二级域名
     * @return
     */
    public static String getResumeLinkFromInclude(Document document){
    	return StringUtil.getNotNullStr(document.getRootElement().element("resumeLink").elementText("include"));
    }
    
    /***
     *  访问主站点域名
     * @return
     */
    public static String getVisitDomain(Document document){
    	return StringUtil.getNotNullStr(document.getRootElement().elementText("visitDomain"));
    }
    
    /**公司上传图片的目录已修改,以前的图片如果要删除,只能去旧的目录,此方法判断公司上传图片时候和路径*/
    public static boolean getCompanyUploadTime(String date1)
    {
    	if(DateUtil.compareDateString(date1, "2008-5-25")<0)
    		return true;
    	else return false;
    }

}
