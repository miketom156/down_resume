package com.job5156.jiansu91job;

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
		 {"姓　　名:", "<span id=\"Pe5\">", "</span>"},
		 {"性　　别:", "<span id=\"Pe6\">", "</span>"},
		 {"出生年月：" , " <span id=\"Pe8\">" , "</span>"},
		 {"求职类型：", "<span id=\"jobkind\">", "</span>"},
		 {"民　　族:", "<span id=\"Pe7\">", "</span>"},
		 {"政治面貌：", "<span id=\"Pe10\">", "</span>"},
		 {"生源地区：", "<span id=\"Pe14\">", "</span>"},
		 {"毕业院校：", " <span id=\"Pe16\">", "</span>"},
		 {"毕业年度：", " <span id=\"Pe15\">", "</span>"},
		 {"专业名称：", " <span id=\"Pe17\">", "</span>"},
		 
		 {"学 历：", "<span id=\"Pe9\">", "</span>"},
		 {"专业类别：", "<span id=\"Pe27\">", "</span>"},
		 {"计算机水平：", "<span id=\"Pe18\">", "</span>"},
		 {"主修外语：", "<span id=\"Pe21\">", "</span>"},
		 {"外语水平：", " <span id=\"Pe22\">", "</span>"},
		 
		 
		 {"特长爱好", "<span id=\"Pe42\">", "</span>"},
		 {"实习实践经历", "<TABLE cellSpacing=0 cellPadding=0 width=98% align=center border=0>", "</table>"},

		 {"移动电话:", "<span id=\"Pe26\">", "</span>"},
		 {"电子邮件：", " <span id=\"Pe24\">", "</span>"},
		 {"通信地址：", "<span id=\"Pe29\" style=\"color:Black;\">", "</span>"},
		 {"自荐信", "<span id=\"Pe43\">", "</span>"},
		 {"在校任职情况", "<span id=\"Pe50\">", "</span>"},
		 {"在校奖惩情况", "<span id=\"Pe51\">", "</span>"},
		 {"学校推荐评语", " <span id=\"Pe52\">", "</span>"},
		 
		
	 };
	 
	 /**简历对应数组**/
	 public void saveEntity(int i, JianSuResume foshan, String value) 
	 {
		 switch (i) 
		 {
			/* case 0: foshan.setRevDate(value);break;
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
			 case 30: foshan.setAddress(value);break;*/
		 } 
	 };
	 
	 public void setPhotoStr(JianSuResume fs, String photoStr){
		 String photo = "".equals(photoStr) ? "/images/nopic/fosh.gif" : photoStr;
		 fs.setPhotoUrl(photo);
	 }
	 
	/* public void setJobLocation(JianSuResume fs, String location){
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
	 }*/
	 
	/* public void setQQValue(FoShanResume fs, String QQStr){
		 if(QQStr != null && !"".equals(QQStr)){
			 if(QQStr.indexOf("未填写") == -1){
				 String qq = LoadHtml.getValue(QQStr, "<a target=blank href=tencent://message/?uin=", "&Site=大佛山人才网&Menu=yes");
				 if(!"".equals(qq)){
					 fs.setQQ(qq);
				 }
			 }
		 }
	 }*/
	 
	/* public void setJobCode(JianSuResume fs, String jobCodeStr){
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
	 }*/
}
