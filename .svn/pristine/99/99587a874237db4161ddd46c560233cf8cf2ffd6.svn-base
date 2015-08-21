package com.job5156.ningbo;

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
		 {"姓&nbsp;&nbsp;&nbsp;&nbsp;名：", "<td width=\"40%\">", "</td>"},
		 {"性&nbsp;&nbsp;&nbsp;&nbsp;别：", "<td width=\"40%\">", "</td>"},
		 {"出生日期：" ,"<td width=\"40%\">", "</td>"},
		 {"户&nbsp;&nbsp;&nbsp;&nbsp;口：", "<td colspan=\"3\">", "</td>"},
		 {"婚姻状况：", "<td width=\"40%\">", "</td>"},
		 {"民&nbsp;&nbsp;&nbsp;&nbsp;族：", "<td colspan=\"3\">", "</td>"},
		 {"居 住 地：", "<td>", "</td>"},
		 {"工作年限：", "<td>", "</td>"},
		 {"语&nbsp;&nbsp;&nbsp;&nbsp;言：", "<td width=\"40%\">", "</td>"},
		 {"语言水平：", "<td colspan=\"3\">", "</td>"},
		 {"身&nbsp;&nbsp;&nbsp;&nbsp;高：", "<td>", "</td>"},
		 
		 {"工作性质：", "<td width=\"40%\">", "</td>"},
		 {"目标地点：", "<td width=\"40%\">", "</td>"},
		 {"目标岗位1：", "<td width=\"40%\">", "</td>"},
		 {"期望工资：", "<td width=\"40%\">", "</td>"},
		 {"目标岗位2：", "<td width=\"40%\">", "</td>"},
		 {"期望工资：", "<td width=\"40%\">", "</td>"},
		 {"目标岗位3：", "<td width=\"40%\">", "</td>"},
		 {"期望工资：", "<td width=\"40%\">", "</td>"},
		 
		 {"工 作 经 验", "<table align=\"center\" border=\"0\" cellPadding=\"1\" cellSpacing=\"0\" width=\"760\">", "</table>"},
		 {"教 育 经 历", "<table align=\"center\" border=\"0\" cellPadding=\"0\" cellSpacing=\"0\" width=\"760\">", "</table>"},
		 {"培 训 经 历", "<table align=\"center\" border=\"0\" cellPadding=\"0\" cellSpacing=\"0\" width=\"760\">", "</table>"},
		 {"证 书", "<table align=\"center\" border=\"0\" cellPadding=\"0\" cellSpacing=\"0\" width=\"760\">", "</table>"},
		 {"专 业 技 能", "<table align=\"center\" border=\"0\" cellPadding=\"0\" cellSpacing=\"0\" width=\"760\">", "</table>"},
		 {"附 加 信 息", "<pre style=\"width:600px;word-wrap: break-word; overflow:auto\">", "</pre>"},
		 
		 {"手&nbsp;&nbsp;&nbsp;&nbsp;机：", "<td width=\"40%\">", "</td>"},
		 {"联系电话：", "<td align=\"left\" width=\"40%\">", "</td>"},
		 {"email：", "<td align=\"left\" width=\"40%\">", "</td>"},
		 {"邮&nbsp;&nbsp;&nbsp;&nbsp;编：", "<td align=\"left\" width=\"40%\">", "</td>"},
		 {"通讯地址：", "<td colspan=\"3\" align=\"left\">", "</td>"}
	 };
	 
	 /**简历对应数组**/
	 public void setValue(int i, NingBoResume ningbo,String value) 
	 {
		 switch (i) 
		 {
		 	case 0: ningbo.setUserName(value);break;
		 	case 1: ningbo.setSex(value);break;
		 	case 2: ningbo.setBirthday(value);break;
		 	case 3: ningbo.setHometown_c(value);break;
		 	case 4: ningbo.setMarriage(value);break;
		 	case 5: ningbo.setNation(value);break;
		 	case 6: ningbo.setNowAddress(value);break;
		 	case 7: ningbo.setJobYear(value);break;
		 	case 8: setLanguageType(ningbo,value);break;
		 	case 9: setLanguageLever(ningbo,value);break;
		 	case 10: ningbo.setStature(value);break;
		 	case 11: ningbo.setJobCalling(value);break;
		 	case 12: setJobLocation(ningbo,value);break;
		 	case 13: ningbo.setJobCode1(value);break;
		 	case 14: ningbo.setSalary1(value);break;
		 	case 15: ningbo.setJobCode2(value);break;
		 	case 16: ningbo.setSalary2(value);break;
		 	case 17: ningbo.setJobCode3(value);break;
		 	case 18: ningbo.setSalary3(value);break;
		 	case 19: ningbo.setWorkText(value);break;
		 	case 20: ningbo.setSchoolText(value);break;
		 	case 21: ningbo.setCultivateText(value);break;
		 	case 22: ningbo.setCertificateText(value);break;
		 	case 23: ningbo.setPersonSkill(value);break;
		 	case 24: ningbo.setOtherInfo(value);break;
		 	case 25: ningbo.setMobile(value);break;
		 	case 26: ningbo.setPhone(value);break;
		 	case 27: ningbo.setEmail(value);break;
		 	case 28: ningbo.setZipcode(value);break;
		 	case 29: ningbo.setCallAddress(value);break;
		 } 
	 };
	 
	 public void setJobLocation(NingBoResume NB, String location){
		 if(location != null && !location.equals("")){
			 String[] local = location.split(",");
			 if(local != null && local.length > 0){
				 if(local.length == 3){
					 NB.setJobLocation1(local[0]);
					 NB.setJobLocation2(local[1]);
					 NB.setJobLocation3(local[2]);
				 }else if(local.length==2){
					 NB.setJobLocation1(local[0]);
					 NB.setJobLocation2(local[1]);
				 }
				 else{
					 NB.setJobLocation1(local[0]);
				 }
			 }
		 }
	 }

	 public void setLanguageType(NingBoResume NB, String language){
		 if(language != null && !language.equals("")){
			 String[] lang = language.split(",");
			 if(lang != null && lang.length > 0){
				 if(lang.length==2){
					 NB.setLanguageType1(lang[0]);
					 NB.setLanguageType2(lang[1]);
				 }
				 else{
					 NB.setLanguageType1(lang[0]);
				 }
			 }
		 }
	 }
	 
	 public void setLanguageLever(NingBoResume NB, String langLev){
		 if(langLev != null && !langLev.equals("")){
			 String[] lev = langLev.split(",");
			 if(lev != null && lev.length > 0){
				 if(lev.length==2){
					 NB.setLanguageLever1(lev[0]);
					 NB.setLanguageLever2(lev[1]);
				 }
				 else{
					 NB.setLanguageLever1(lev[0]);
				 }
			 }
		 }
	 }
}
