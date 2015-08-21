package com.job5156.jiangmen;

import com.job5156.util.StringUtil;

/**
 * @author wufalong
 * create on 2008-6-2
 */
public class PageAnalyzeTools
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
	
	public String getValue(String begStr,String endStr){
		return getValue(begStr, endStr, false);
	}
	
	public String getValue(String begStr,String endStr,boolean isFilter){
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
                if(start==-1)   //当匹配不到时，返回""
                    return "";
                value = content.substring(0,start);
                if(isFilter){
                    value = value.replaceAll("&nbsp;&nbsp;", ",");
                }
                value = value.replaceAll("&nbsp;", "");
                setPageHtml(content.substring(start));
            }
            catch(StringIndexOutOfBoundsException ex)
            {
                return content;
            }
        }
        return  value.trim();  
    }
	 
	 /**重设简历HTML**/
	 public void reSetPageHtml(String str)
    {
        int start = -1;
        start = this.getPageHtml().indexOf(str);
        if(start!=-1)
        {   
        	setPageHtml(this.getPageHtml().substring(start));
        }
    }
	
	 /**简历对应数组**/
	 public String[][] splitFormValue = 
	 {
		 {"更新日期：", "<font face=\"宋体\">", "</font>"},
		 {"真实姓名：", "<font face=\"宋体\">", "</font>"},
		 {"性　　别：" ,"<font face=\"宋体\">", "</font>"},
		 {"<img border=0 height=150", "src=", "width=120"},
		 {"&nbsp;年&nbsp;   &nbsp;&nbsp;龄：", "<font face=\"宋体\">", "</font>"},
		 {"<SPAN id=lbl_homeplace0                   style=\"COLOR: navy\">", "<font face=\"宋体\">", "</font>"},
		 {"民&nbsp;&nbsp;&nbsp;&nbsp;族：", "<font face=\"宋体\">", "</font>"},
		 {"身&nbsp;&nbsp;&nbsp;&nbsp;高：", "<font face=\"宋体\">", "</font>"},
		 {"<span id=lbl_marriage1                   style=\"COLOR: navy\">", "<font face=\"宋体\">", "</font>"},
		 {"最高学历：", "<font face=\"宋体\">", "</font>"},
		 {"毕业院校：", "<font face=\"宋体\">", "</font>"},
		 {"所学专业：", "<font face=\"宋体\">", "</font>"},
		 {"副修专业：", "<font face=\"宋体\">", "</font>"},
		 {"英语水平：", "<font face=\"宋体\">", "</font>"},
		 {"<span id=lbl_updatedate1>", "<font face=\"宋体\">", "</font>"},
		 {"<span id=lbl_updatedate0                   style=\"COLOR: navy\">", "<font face=\"宋体\">", "</font>"},
		 {"毕业年份：", "<font face=\"宋体\">", "</font>"},

		 {"教育/培训", "<font face=\"宋体\" color=\"#000080\">", "</font>"},
		 {"工作经历", "<font face=\"宋体\" color=\"#000080\">", "</font>"},
		 {"个人简历", "<font face=\"宋体\" color=\"#000080\">", "</font>"},
		 {"技能特长", "<font face=\"宋体\" color=\"#000080\">", "</font>"},
		 
		 {"最  快  到  职：", "<font face=\"宋体\">", "</font>"},
		 {"希  望  地  区：", "<font face=\"宋体\">", "</font>"},
		 {"待  遇  要  求：", "<font face=\"宋体\">", "</font>"},
		 {"希  望  岗  位：", "<font face=\"宋体\">", "</font>"},
		 
		 {"联系电话：", "<font face=\"宋体\">", "</font>"},
		 {"电子邮件：", "<font face=\"宋体\">", "</font>"},
		 {"移动电话：", "<font face=\"宋体\">", "</font>"},
		 {"QQ/OICQ：", "<font face=\"宋体\">", "</font>"},
		 {"通讯地址：", "<font face=\"宋体\">", "</font>"},
		 {"邮编：","<font face=\"宋体\">", "</font>"}
	 };
	 
	 /**简历对应数组**/
	 public void setValue(int i, JiangMenResume jiangmen, String value) 
	 {
		 switch (i) 
		 {
			 case 0: jiangmen.setRevDate(value);break;
			 case 1: jiangmen.setUserName(value);break;
			 case 2: jiangmen.setSex(value);break;
			 case 3: jiangmen.setPhotoStr(value);break;
			 case 4: jiangmen.setUserAge(value);break;
			 case 5: jiangmen.setHometown_c(value);break;
			 case 6: jiangmen.setNation(value);break;
			 case 7: jiangmen.setStature(value);break;
			 case 8: jiangmen.setMarriage(value);break;
			 case 9: jiangmen.setHighDegree(value);break;
			 case 10: jiangmen.setSchool(value);break;
			 case 11: jiangmen.setSpecial(value);break;
			 case 12: jiangmen.setSpecial1(value);break;
			 case 13: jiangmen.setEnglishLever(value);break;
			 case 14: jiangmen.setOtherEnglish(value);break;
			 case 15: jiangmen.setOtherEnglishLevel(value);break;
			 case 16: jiangmen.setGraduateDate(value);break;
			 
			 case 17: jiangmen.setSchoolText(value);break;
			 case 18: jiangmen.setWorkText(value);break;
			 case 19: jiangmen.setSelfappraise(value);break;
			 case 20: jiangmen.setPersonSkill(value);break;
			 
			 case 21: jiangmen.setCheckindate(value);break;
			 case 22: setJobLocation(jiangmen, value);break;
			 case 23: jiangmen.setSalary(value);break;
			 case 24: setJobCode(jiangmen, value);break;
			 
			 case 25: jiangmen.setPhone(value);break;
			 case 26: jiangmen.setEmail(value);break;
			 case 27: jiangmen.setMobile(value);break;
			 case 28: jiangmen.setQQorOICQ(value);break;
			 case 29: jiangmen.setAddress(value);break;
			 case 30: jiangmen.setPostCode(value);break;
		 } 
	 };
	 
	 public void setJobLocation(JiangMenResume JM, String location){
		 if(location != null && !location.equals("")){
			 String[] local = location.split(",");
			 if(local != null && local.length > 0){
				 if(local.length == 2){
					 JM.setJobLocation1(local[0]);
					 JM.setJobLocation2(local[1]);
				 }else{
					 JM.setJobLocation1(local[0]);
				 }
			 }
		 }
	 }
	 
	 public void setJobCode(JiangMenResume JM, String jobCode){
		 if(jobCode != null && !jobCode.equals("")){
			 String[] job = jobCode.split(",");
			 if(job != null && job.length > 0){
				 if(job.length == 3){
					 JM.setJobcode1(job[0]);
					 JM.setJobcode2(job[1]);
					 JM.setJobcode3(job[2]);
				 }else if(job.length == 2){
					 JM.setJobcode1(job[0]);
					 JM.setJobcode2(job[1]);
				 }else{
					 JM.setJobcode1(job[0]);
				 }
			 }
		 }
	 }

}
