package com.job5156.foshan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.job5156.down.util.LoadHtml;
import com.job5156.util.StringUtil;

/**
 * @author wufalong
 * create on 2008-6-2
 */
public class PageAnalyzeToolsNew
{
	public String pageHtml;
	public String url;

	
	/**
	 * @return the url
	 */
	public String getUrl()
	{
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url)
	{
		this.url = url;
	}

	/**
	 * @return the pageHtml
	 */
	public String getPageHtml()
	{
		return pageHtml;
	}

	/**
	 * @param pageHtml the pageHtml to set
	 */
	public void setPageHtml(String pageHtml)
	{
		this.pageHtml = pageHtml;
	}
	
	
	 public String getValue(String begStr,String endStr)
     {
        String content = this.getPageHtml();
        String value = ""; 
        int start = -1;
        start = content.indexOf(begStr);
        if(start!=-1)
        {   
            try
            {
                content = content.substring(start+begStr.length());
                start = content.indexOf(endStr);
                if(start==-1)   //��ƥ�䲻��ʱ������""
                    return "";
                value = content.substring(0,start);
                setPageHtml(content.substring(start));
            }
            catch(StringIndexOutOfBoundsException ex)
            {
                return content;
            }
        }
        return  value.trim().replaceAll("��","");  
    }
	 
	 /**�������HTML**/
	 public void reSetPageHtml(String str)
    {
        int start = -1;
        start = this.getPageHtml().indexOf(str);
        if(start!=-1)
        {   
        	setPageHtml(this.getPageHtml().substring(start));
        }
    }
	
	 /**������Ӧ����**/
	 public String[][] splitFormValue = 
	 {
		 {"�����¼ʱ�䣺", "<span id=\"latestlogin\">", "</span>"},
		 {"<a id=\"pic\"", "<img border='0' src='", "' width='100' />"},
		 {"�� ����" , "<span id=\"Jw_Name\">" , "</span>"},
		 {"��ְ���ͣ�", "<span id=\"jobkind\">", "</span>"},
		 {"�� ��", "<span id=\"sex\">", "</span>"},
		 {"�� �䣺", "<span id=\"age\">", "</span>"},
		 {"�� �ߣ�", "<span id=\"height\">", "</span>"},
		 {"����״����", "<span id=\"marry\">", "</span>"},
		 {"�� �ڣ�", "<span id=\"hukou\">", "</span>"},
		 {"��нҪ��", "<span id=\"money\">", "</span>"},
		 {"ѧ ����", "<span id=\"learn\">", "</span>"},
		 {"�������飺", "<span id=\"expr\">", "</span>"},
		 {"��ҵԺУ��", "<span id=\"graduate\">", "</span>"},
		 {"�� �ޣ�", "<span id=\"major\">", "</span>"},
		 {"����ˮƽ��", "<span id=\"computer\">", "</span>"},
		 {"Ӣ��ˮƽ��", "<span id=\"english\">", "</span>"},
		 {"�־�ס�أ�", "<span id=\"livin\">", "</span>"},

		 {"ϣ�������ص㣺", "<span id=\"workcity_cn\">", "</span>"},
		 {"ϣ��������λ��", "<span id=\"jobtype\">", "</span>"},
		 {"����˵����", "<span id=\"wantto\">", "</span>"},
		 {"������ѵ", "<span id=\"edu\">", "</span>"},
		 {"����ר��", "<span id=\"ability\">", "</span>"},
		 {"��������", "<span id=\"direct\">", "</span>"},
		 {"��������", "<span id=\"selfintro\">", "</span>"},
		 
		 {"��ϵ�绰:", "<span id=\"phone\">", "</span>"},
		 {"��������:", "<span id=\"email\">", "</span>"},
		 {"����QQ:", "<span id=\"contactQQ\">", "</span>"},
		 {"�ƶ��绰:", "<span id=\"mobile\">", "</span>"},
		 {"��������:", "<span id=\"zipcode\">", "</span>"},
		 {"������ҳ:", "<a id=\"homepage\" target=\"_blank\">", "</a>"},
		 {"��ϵ��ַ:", "<span id=\"contactAdd\">", "</span>"},
	 };
	 
	 /**������Ӧ����**/
	 public void saveEntity(int i, FoShanResume foshan, String value) 
	 {
		 switch (i) 
		 {
			 case 0: foshan.setRevDate(value);break;
			 case 1: setPhotoStr(foshan, value);break;
			 case 2: foshan.setUserName(value);break;
			 case 3: foshan.setJobType(value);break;
			 case 4: foshan.setSex(value);break;
			 case 5: foshan.setUserAge(value);break;
			 case 6: foshan.setStature(value);break;
			 case 7: foshan.setMarriage(value);break;
			 case 8: foshan.setHometown_c(value);break;
			 case 9: foshan.setSalary(value);break;
			 case 10: foshan.setHighDegree(value);break;
			 case 11: foshan.setJobyear(value);break;
			 case 12: foshan.setSchool(value);break;
			 case 13: foshan.setSpecial(value);break;
			 case 14: foshan.setComputerLever(value);break;
			 case 15: foshan.setEnglishLever(value);break;
			 case 16: foshan.setLocation_c(value);break;
			 
			 case 17: setJobLocation(foshan, value);break;
			 case 18: setJobCode(foshan, value);break;
			 case 19: foshan.setIntentInfo(value);break;
			 case 20: foshan.setSchoolText(value);break;
			 case 21: foshan.setPersonSkill(value);break;
			 
			 case 22: foshan.setWorkText(value);break;
			 case 23: foshan.setSelfappraise(value);break;
			 case 24: foshan.setPhone(value);break;
			 case 25: foshan.setEmail(value);break;
			 
			 case 26: setQQValue(foshan, value);break;
			 case 27: foshan.setMobile(value);break;
			 case 28: foshan.setPostCode(value);break;
			 case 29: foshan.setHomepage(value);break;
			 case 30: foshan.setAddress(value);break;
		 } 
	 };
	 
	 public void setPhotoStr(FoShanResume fs, String photoStr){
		 String photo = "".equals(photoStr) ? "/images/nopic/fosh.gif" : photoStr;
		 fs.setPhotoStr(photo);
	 }
	 
	 public void setJobLocation(FoShanResume fs, String location){
		 if(location != null && !"".equals(location)){
			 String[] local = location.split(",");
			 if(local != null && local.length > 0){
				 if(local.length == 3){
					 fs.setJobLocation1(local[0]);
					 fs.setJobLocation2(local[1]);
					 fs.setJobLocation3(local[2]);
				 }else if(local.length == 2){
					 fs.setJobLocation1(local[0]);
					 fs.setJobLocation2(local[1]);
				 }else{
					 fs.setJobLocation1(local[0]);
				 }
			 }
		 }
	 }
	 
	 public void setQQValue(FoShanResume fs, String QQStr){
		 if(QQStr != null && !"".equals(QQStr)){
			 if(QQStr.indexOf("δ��д") == -1){
				 String qq = LoadHtml.getValue(QQStr, "<a target=blank href=tencent://message/?uin=", "&Site=���ɽ�˲���&Menu=yes");
				 if(!"".equals(qq)){
					 fs.setQQ(qq);
				 }
			 }
		 }
	 }
	 
	 public void setJobCode(FoShanResume fs, String jobCodeStr){
		 String imgJob1 = "<img src=\"../images/comm/jw_jobtype1.gif\" width=\"13\" height=\"13\" align=\"absmiddle\" />";
		 String imgJob2 = "<img src=\"../images/comm/jw_jobtype2.gif\" width=\"13\" height=\"13\" align=\"absmiddle\" />";
		 String imgJob3 = "<img src=\"../images/comm/jw_jobtype3.gif\" width=\"13\" height=\"13\" align=\"absmiddle\" />";
		 List jobList = new ArrayList();
		 if(jobCodeStr != null && !"".equals(jobCodeStr)){
			 jobCodeStr = jobCodeStr.replaceAll(imgJob1, "").replaceAll(imgJob2, "").replaceAll(imgJob3, "").replaceAll("&nbsp;", ",");
			 String[] code = jobCodeStr.split(",");
			 if(code != null && code.length > 0){
				 for(int i=0; i<code.length; i++){
					 if(!"".equals(StringUtil.getNotNullStr(code[i]))){
						 jobList.add(code[i]);
					 }
				 }
			 }
		 }
		 if(jobList.size() == 1){
			 fs.setJobcode1(StringUtil.getNotNullStr(jobList.get(0)));
		 }else if(jobList.size() == 2){
			 fs.setJobcode1(StringUtil.getNotNullStr(jobList.get(0)));
			 fs.setJobcode2(StringUtil.getNotNullStr(jobList.get(1)));
		 }else if(jobList.size() == 3){
			 fs.setJobcode1(StringUtil.getNotNullStr(jobList.get(0)));
			 fs.setJobcode2(StringUtil.getNotNullStr(jobList.get(1)));
			 fs.setJobcode3(StringUtil.getNotNullStr(jobList.get(2)));
		 }
	 }
}
