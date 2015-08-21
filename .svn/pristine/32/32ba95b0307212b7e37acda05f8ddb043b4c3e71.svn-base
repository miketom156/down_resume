package com.job5156.foshan;

import com.job5156.down.util.LoadHtml;

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
                if(start==-1)   //当匹配不到时，返回""
                    return "";
                value = content.substring(0,start);
                setPageHtml(content.substring(start));
            }
            catch(StringIndexOutOfBoundsException ex)
            {
                return content;
            }
        }
        return  value.trim().replaceAll("　","");  
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
		 {"最近登陆时间：", "<span id=\"latestlogin\">", "</span>"},
		 {"<a id=\"pic\"", "<img border='0' src='", "' width='100' />"},
		 {"姓 名：" , "<span id=\"Jw_Name\">" , "</span>"},
		 {"求职类型：", "<span id=\"jobkind\">", "</span>"},
		 {"性 别：", "<span id=\"sex\">", "</span>"},
		 {"年 龄：", "<span id=\"age\">", "</span>"},
		 {"身 高：", "<span id=\"height\">", "</span>"},
		 {"婚姻状况：", "<span id=\"marry\">", "</span>"},
		 {"现居住地：", "<span id=\"livin\">", "</span>"},
		 {"户 口：", "<span id=\"hukou\">", "</span>"},
		 {"月薪要求：", "<span id=\"money\">", "</span>"},
		 {"学 历：", "<span id=\"learn\">", "</span>"},
		 {"工作经验：", "<span id=\"expr\">", "</span>"},
		 {"毕业院校：", "<span id=\"graduate\">", "</span>"},
		 {"主 修：", "<span id=\"major\">", "</span>"},
		 {"电脑水平：", "<span id=\"computer\">", "</span>"},
		 {"英语水平：", "<span id=\"english\">", "</span>"},
		 
		 {"希望工作地点：", "<span id=\"workcity_cn\">", "</span>"},
		 {"../images/comm/jw_jobtype1.gif", "<span id=\"jobtype1\">", "</span>"},
		 {"../images/comm/jw_jobtype2.gif", "<span id=\"jobtype2\">", "</span>"},
		 {"../images/comm/jw_jobtype3.gif", "<span id=\"jobtype3\">", "</span>"},
		 {"补充说明：", "<span id=\"wantto\">", "</span>"},
		 {"教育培训", "<span id=\"edu\">", "</span>"},
		 {"技能专长", "<span id=\"ability\">", "</span>"},
		 {"工作经历", "<span id=\"direct\">", "</span>"},
		 {"自我评价", "<span id=\"selfintro\">", "</span>"},
		 
		 {"联系电话:", "<span id=\"phone\">", "</span>"},
		 {"电子信箱:", "<span id=\"email\">", "</span>"},
		 {"移动电话:", "<span id=\"mobile\">", "</span>"},
		 {"邮政编码:", "<span id=\"zipcode\">", "</span>"},
		 {"个人主页:", "<a id=\"homepage\" target=\"_blank\">", "</a>"},
		 {"联系地址:", "<span id=\"contactAdd\">", "</span>"},
		 {"在线QQ:", "<span id=\"contactQQ\">", "</span>"},
	 };
	 
	 /**简历对应数组**/
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
			 case 8: foshan.setLocation_c(value);break;
			 case 9: foshan.setHometown_c(value);break;
			 case 10: foshan.setSalary(value);break;
			 case 11: foshan.setHighDegree(value);break;
			 case 12: foshan.setJobyear(value);break;
			 case 13: foshan.setSchool(value);break;
			 case 14: foshan.setSpecial(value);break;
			 case 15: foshan.setComputerLever(value);break;
			 case 16: foshan.setEnglishLever(value);break;
			 
			 case 17: setJobLocation(foshan, value);break;
			 case 18: foshan.setJobcode1(value);break;
			 case 19: foshan.setJobcode2(value);break;
			 case 20: foshan.setJobcode3(value);break;
			 case 21: foshan.setIntentInfo(value);break;
			 
			 case 22: foshan.setSchoolText(value);break;
			 case 23: foshan.setPersonSkill(value);break;
			 case 24: foshan.setWorkText(value);break;
			 case 25: foshan.setSelfappraise(value);break;
			 
			 case 26: foshan.setPhone(value);break;
			 case 27: foshan.setEmail(value);break;
			 case 28: foshan.setMobile(value);break;
			 case 29: foshan.setPostCode(value);break;
			 case 30: foshan.setHomepage(value);break;
			 case 31: foshan.setAddress(value);break;
			 case 32: setQQValue(foshan, value);break;
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
			 if(QQStr.indexOf("未填写") == -1){
				 String qq = LoadHtml.getValue(QQStr, "<a target=blank href=tencent://message/?uin=", "&Site=大佛山人才网&Menu=yes");
				 if(!"".equals(qq)){
					 fs.setQQ(qq);
				 }
			 }
		 }
	 }
	 
	 public void setJobCode(FoShanResume zs, String jobCode){
		 if(jobCode != null && !jobCode.equals("")){
			 String[] job = jobCode.split(" ");
			 if(job != null && job.length > 0){
				 if(job.length == 3){
					 zs.setJobcode1(job[0]);
					 zs.setJobcode2(job[1]);
					 zs.setJobcode3(job[2]);
				 }else if(job.length == 2){
					 zs.setJobcode1(job[0]);
					 zs.setJobcode2(job[1]);
				 }else{
					 zs.setJobcode1(job[0]);
				 }
			 }
		 }
	 }

}
