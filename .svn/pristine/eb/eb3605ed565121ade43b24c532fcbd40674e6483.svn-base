package com.job5156.ningbo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.job5156.util.DateUtil;
import com.job5156.util.StringUtil;

public class AnalysisHelper {

	private static String fieldContent="";
	
	public static String getBirthday(String age){
		String birthday = "";
		int tempAge = StringUtil.parseInt(age);
		if(tempAge > 0){
			int currentYear = DateUtil.getThisYear();
			birthday = (currentYear - tempAge)+"-1-1";
		}
		return birthday;
	}
	/*
	 * 解析城市。
	 */
	public static String[] analysisCity(String city){
		String[] data = {"4500","4500"};
		if(!"".equals(city)){
			String cityCode = MapTable.getCodeTwo(city, MapTable.jobLocation);
			if(!"".equals(cityCode) && cityCode.length() == 4){
				data[0] = StringUtil.getSubStr(cityCode, 0, 2)+"00";
				data[1] = cityCode;
			}
		}
		return data;
	}
	
	/*
	 * 解析个人信息表中的最高学历，专业，学校。
	 * 
	 */
	public static  String [] analysisSchool(String schoolText){
		String info[]={"0","",""};
		if(schoolText!=null && !"".equals(schoolText)){
			int highDegree=0;
			schoolText=schoolText.replaceAll("&nbsp;","").replaceAll("<br>","");
			String [] array=schoolText.split("&lt;trheight&#61;&quot;25&quot;&gt;");
			if(array.length>0){
				for(int i=0;i<array.length;i++){
					fieldContent=StringUtil.getNotNullStr(array[i]);
					String schoolTime = StringUtil.getNotNullStr(getValue(fieldContent,"&lt;tdwidth&#61;&quot;25%&quot;&gt;","&lt;/td&gt;",true));
					String schoolName = StringUtil.getNotNullStr(getValue(fieldContent,"&lt;tdwidth&#61;&quot;25%&quot;&gt;","&lt;/td&gt;",true));
					String speciality = StringUtil.getNotNullStr(getValue(fieldContent,"&lt;tdwidth&#61;&quot;25%&quot;&gt;","&lt;/td&gt;",true));
					String degree = StringUtil.getNotNullStr(getValue(fieldContent,"&lt;tdwidth&#61;&quot;25%&quot;&gt;","&lt;/td&gt;",true));
					String degreeId=StringUtil.getNotNullStr(MapTable.getCodeTwo(degree,MapTable.highDegree));
					if(highDegree<=StringUtil.parseInt(degreeId)){
						highDegree=StringUtil.parseInt(degreeId);
						info[0]=degreeId;
						info[1]=speciality;
						info[2]=schoolName;
					}
				}
			}
		}
		return info;
	}

	public static String getSpecial(String special1, String special2){
		String special = "";
		if(!"".equals(special1)){
			special = special1;
		}else{
			if(!"".equals(special2)){
				special = special2;
			}
		}
		return special;
	}
	
	/**
	 * 解析职位类别
	 * @param resume
	 * @return
	 */
	public static String[] analysJobCata(NingBoResume resume){
		String[] job = {"","","",""};
		Set jobSet = new HashSet();
		if(resume != null){
			String job1 = "",job2 = "",job3 = "";
			if(!"".equals(StringUtil.getNotNullStr(resume.getJobCode1()))){
				job1 = MapTable.getCodeTwo(StringUtil.getNotNullStr(resume.getJobCode1()), MapTable.jobCode);
				job[3] = StringUtil.getNotNullStr(resume.getJobCode1());
			}
			if(!"".equals(StringUtil.getNotNullStr(resume.getJobCode2()))){
				job2 = MapTable.getCodeTwo(StringUtil.getNotNullStr(resume.getJobCode2()), MapTable.jobCode);
				if("".equals(job[3]))job[3] = StringUtil.getNotNullStr(resume.getJobCode2());
			}
			if(!"".equals(StringUtil.getNotNullStr(resume.getJobCode3()))){
				job3 = MapTable.getCodeTwo(StringUtil.getNotNullStr(resume.getJobCode3()), MapTable.jobCode);
				if("".equals(job[3]))job[3] = StringUtil.getNotNullStr(resume.getJobCode3());
			}
			if(!"".equals(job1)){
				jobSet.add(job1);
			}
			if(!"".equals(job2)){
				jobSet.add(job2);
			}
			if(!"".equals(job3)){
				jobSet.add(job3);
			}
			if(jobSet.size() > 0){
				int i=0;
				Iterator iterator = jobSet.iterator();
				while(iterator.hasNext()){
					job[i] = (String)iterator.next();
					i ++;
				}
			}
		}
		return job;
	}
	
	/**
	 * 解析工作地点
	 * @param resume
	 * @return
	 */
	public static String[] analysJobLocation(NingBoResume resume){
		String[] loc = {"","",""};
		Set locSet = new HashSet();
		if(resume != null){
			String loc1 = "",loc2 = "",loc3="";
			if(!"".equals(StringUtil.getNotNullStr(resume.getJobLocation1()))){
				loc1 = MapTable.getCodeTwo(StringUtil.getNotNullStr(resume.getJobLocation1()), MapTable.jobLocation);
			}
			if(!"".equals(StringUtil.getNotNullStr(resume.getJobLocation2()))){
				loc2 = MapTable.getCodeTwo(StringUtil.getNotNullStr(resume.getJobLocation2()).replaceAll("　", ""), MapTable.jobLocation);
			}
			if(!"".equals(StringUtil.getNotNullStr(resume.getJobLocation3()))){
				loc3 = MapTable.getCodeTwo(StringUtil.getNotNullStr(resume.getJobLocation3()).replaceAll("　", ""), MapTable.jobLocation);
			}
			if(!"".equals(loc1)){
				locSet.add(loc1);
			}
			if(!"".equals(loc2)){
				locSet.add(loc2);
			}
			if(!"".equals(loc3)){
				locSet.add(loc3);
			}
			if(locSet.size() > 0){
				int i=0; 
				Iterator iterator = locSet.iterator();
				while(iterator.hasNext()){
					loc[i] = (String)iterator.next();
					i ++;
				}
			}
		}
		return loc;
	}
	
	public static String analysisSalary(NingBoResume resume){
		String sal = "";
		String salary1=StringUtil.getNotNullStr(resume.getSalary1());
		String salary2=StringUtil.getNotNullStr(resume.getSalary2());
		String salary3=StringUtil.getNotNullStr(resume.getSalary3());
		
		if(!"".equals(salary1)){
			sal = getSalary(salary1);
		}else if(!"".equals(salary2)){
			sal = getSalary(salary2);
		}else if(!"".equals(salary3)){
			sal = getSalary(salary3);
		}else{
			sal = "0";
		}
		return sal;
	}
	
	public static String getSalary(String salary){
		String sal = "";
		Pattern pattern = Pattern.compile("[1-9]\\d+");
		Matcher matcher = pattern.matcher(salary);
		while(matcher.find()){
			if(StringUtil.parseInt(matcher.group()) > StringUtil.parseInt(sal)){
				sal = matcher.group();
			}
		}
		matcher = null;
		pattern = null;
		return sal;
	}
	
	
	/**
	 * 判断是否全部都是数字
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str){
		boolean isCheck = false;
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if(isNum.matches()){
			isCheck = true;
		}
	    return isCheck;
	} 
	
	/**
	 * 判断是否全部都是字母
	 * @param str
	 * @return
	 */  
	public static boolean isCharacter(String str){
		boolean isCheck = false;
		if(str.length() > 0){
			boolean temp = true;
			for(int i=0;i<str.length();i++){
				if(Character.isLetter(str.charAt(i))){
					continue;
				}else{
					temp = false;
					break;
				}
			}
			isCheck = temp;
		}
		return isCheck;
	 }

	 /**
	   * 判断是否全部都是中文字符
	   * @param str
	   * @return
	   */	
	 public static boolean isChinese(String str){
		 boolean isCheck = false;
		 if(str.length() > 0){
			 boolean temp = true;
			 for(int i=0;i<str.length();i++){
				 Pattern pattern = Pattern.compile("[\\u4e00-\\u9fa5]+");
				 Matcher isChin = pattern.matcher(str.substring(i,i+1));
				 if(isChin.matches()) {
					 continue;
				 } else{
					 temp = false;
					 break;
				 }
			 }  
			 isCheck = temp;
		 }
		 return isCheck;
	 }
	 
	 /**
	  * 解析工作经验
	  * @param workText
	  * @return
	  */
	 public static List getWorkInfo(String workText){
		 String [] array=null;
		 String workInfo=null;
		 List workList=new ArrayList();
		 if(!"".equals(workText) && !isNumeric(workText) && !isCharacter(workText) && !isChinese(workText)){
			 workInfo=StringUtil.getNotNullStr(workText).replaceAll("&nbsp;","").replaceAll("<br>","");
			 array = workInfo.split("&lt;HRsize&#61;&quot;1&quot;width&#61;&quot;100%&quot;align&#61;&quot;right&quot;style&#61;&quot;color:#e0e0e0&quot;&gt;");
			 if(array.length>0){
				 for(int i=0;i<array.length-1;i++){
					 fieldContent=StringUtil.getNotNullStr(array[i]);
					 String [] info=new String[5];
					 String nameAndTime=getValue(fieldContent,"&lt;tdcolspan&#61;&quot;4&quot;&gt;","&lt;/td&gt;",true);
					 info[0]=nameAndTime.split("：")[0];
					 info[1]=nameAndTime.split("：")[1];
					 info[2]=StringUtil.getNotNullStr(getValue(fieldContent,"&lt;b&gt;","&lt;/b&gt;",true));
					 info[3]=StringUtil.getNotNullStr(getValue(fieldContent,"&lt;b&gt;","&lt;/b&gt;",true));
					 info[4]=StringUtil.getNotNullStr(getValue(fieldContent,"word-wrap:break-word;overflow:auto&quot;&gt;","&lt;/td&gt;",true));
					 workList.add(info);
					 info=null;
				 }
			 }
		 }else{
			 System.out.println("----工作数据不符合要求,全部为数字或者字母或者中文汉字,数据丢弃!");
		 }
		 return workList;
	 }
	  
	 /**
	  * 解析教育经验
	  * @param schoolText
	  * @return
	  */
	 public static List getSchoolInfo(String schoolText){
		 String [] array=null;
		 String schoolInfo=null;
		 List schoolList=new ArrayList();
		 if(!"".equals(schoolText) && !isNumeric(schoolText) && !isCharacter(schoolText) && !isChinese(schoolText)){
			 schoolInfo=StringUtil.getNotNullStr(schoolText).replaceAll("&nbsp;","").replaceAll("<br>","");
			 array = schoolInfo.split("style&#61;&quot;color:#e0e0e0&quot;&gt;");
			 if(array.length>0){
				 for(int i=0;i<array.length-1;i++){
					 fieldContent=StringUtil.getNotNullStr(array[i]);
					 String [] info=new String[4];
					 info[0]=StringUtil.getNotNullStr(getValue(fieldContent,"&lt;tdwidth&#61;&quot;25%&quot;&gt;","&lt;/td&gt;",true).replaceAll("：",""));
					 info[1]=StringUtil.getNotNullStr(getValue(fieldContent,"&lt;tdwidth&#61;&quot;25%&quot;&gt;","&lt;/td&gt;",true));
					 info[2]=StringUtil.getNotNullStr(getValue(fieldContent,"&lt;tdwidth&#61;&quot;25%&quot;&gt;","&lt;/td&gt;",true));
					 info[3]=StringUtil.getNotNullStr(getValue(fieldContent,"&lt;tdwidth&#61;&quot;25%&quot;&gt;","&lt;/td&gt;",true));
					 schoolList.add(info);
					 info=null;
				 }
			 }
		 }else{
			 System.out.println("----教育数据不符合要求,全部为数字或者字母或者中文汉字,数据丢弃!");
		 }
		 return schoolList;
	 }
	 
	 /**
	  * 解析培训经验
	  * @param schoolText
	  * @return
	  */
	 public static List getTrainInfo(String schoolText){
		 String [] array=null;
		 String trainInfo=null;
		 List trainList=new ArrayList();
		 if(!"".equals(schoolText) && !isNumeric(schoolText) && !isCharacter(schoolText) && !isChinese(schoolText)){
			 trainInfo=StringUtil.getNotNullStr(schoolText).replaceAll("&nbsp;","").replaceAll("<br>","");
			 array = trainInfo.split("style&#61;&quot;color:#e0e0e0&quot;&gt;");
			 if(array.length>0){
				 for(int i=0;i<array.length-1;i++){
					 fieldContent=StringUtil.getNotNullStr(array[i]);
					 String [] info=new String[4];
					 info[0]=StringUtil.getNotNullStr(getValue(fieldContent,"&lt;tdwidth&#61;&quot;25%&quot;&gt;","&lt;/td&gt;",true).replaceAll("：",""));
					 info[1]=StringUtil.getNotNullStr(getValue(fieldContent,"&lt;tdwidth&#61;&quot;25%&quot;&gt;","&lt;/td&gt;",true));
					 info[2]=StringUtil.getNotNullStr(getValue(fieldContent,"&lt;tdwidth&#61;&quot;25%&quot;&gt;","&lt;/td&gt;",true));
					 info[3]=StringUtil.getNotNullStr(getValue(fieldContent,"style&#61;&quot;width:600px;word-wrap:break-word;overflow:auto&quot;&gt;","&lt;/td&gt;",true));
					 trainList.add(info);
					 info=null;
				 }
			 }
		 }else{
			 System.out.println("----培训数据不符合要求,全部为数字或者字母或者中文汉字,数据丢弃!");
		 }
		 return trainList;
	 }
	 	
	 public static String getOtherSkill(String otherSkillText){
		 String info="";
		 String context="";
		 String [] array=null;
		 if(!"".equals(otherSkillText) && otherSkillText!=null){
			 context=StringUtil.getNotNullStr(otherSkillText).replaceAll("&nbsp;","").replaceAll("<br>","");
			 array=context.split("&lt;trheight&#61;&quot;25&quot;&gt;");
			 if(array.length>0){
				 for(int i=0;i<array.length;i++){
					 String skillName="";
					 String skillLev="";
					 fieldContent=StringUtil.getNotNullStr(array[i]);
					 skillName=StringUtil.getNotNullStr(getValue(fieldContent,"&lt;tdwidth&#61;&quot;50%&quot;&gt;","&lt;/td&gt;",true));
					 skillLev=StringUtil.getNotNullStr(getValue(fieldContent,"&lt;tdwidth&#61;&quot;50%&quot;&gt;","&lt;/td&gt;",true));
					 info+=skillName+"："+skillLev+"\n";
					 if(info.startsWith("：")){
						 info=info.substring(1);
					 }
				 }
			 }
		 }
		 return info;
	 }
	 /**
	  * 截取字符串中的开始时间
	  * @param str
	  * @return
	  */
	 public static String[] getYear(String str){
		 String[] year = new String[2];
		 if(str != null && str.trim().length() > 0){
			String begDate=StringUtil.substring(str,0,10);
			String endDate=StringUtil.substring(str,10,20);
			String beg[]=StringUtil.split(begDate,"-");
			String end[]=StringUtil.split(endDate,"-");
			if(end.length>0 && beg.length>0){
				year[0]=StringUtil.getNotNullStr(beg[0]);
				year[1]=StringUtil.getNotNullStr(end[0]);
			}
		 }
		 return year;
	 }
	
	 public static String[] getMonth(String str){
		 String[] month = new String[2];
		 if(str != null && str.trim().length() > 0){
			String begDate=StringUtil.substring(str,0,9);
			String endDate=StringUtil.substring(str,10,19);
			String beg[]=StringUtil.split(begDate,"-");
			String end[]=StringUtil.split(endDate,"-");
			if(beg.length>0 && end.length>0){
				month[0]=StringUtil.getNotNullStr(beg[1]);
				month[1]=StringUtil.getNotNullStr(end[1]);
			}
		 }
		 return month;
	 }
	 
	 public static String[][] analysisContact(String phone, String mobile){
			String[][] contact = {{"0",""},{"1",""}};
			if(!"".equals(phone)){
				if(phone.startsWith("1")){
					contact[0][0] = "0";
					contact[0][1] = phone;
				}else{
					contact[1][0] = "1";
					contact[1][1] = phone;
				}
			}
			if(!"".equals(mobile)){
				if(mobile.startsWith("1")){
					contact[0][0] = "0";
					contact[0][1] = mobile;
				}else{
					contact[1][0] = "1";
					contact[1][1] = mobile;
				}
			}
			return contact;
		}
	 
//	public static void main(String[] args){
//		String workInfo="";
//		String FileName="d:\\111.txt";
//        File myFile=new File(FileName);
//        if(!myFile.exists())
//       { 
//            System.err.println("Can't Find " + FileName);
//        }
//
//        try 
//        {
//            BufferedReader in = new BufferedReader(new FileReader(myFile));
//            String str;
//            while ((str = in.readLine()) != null) 
//            {
//                workInfo+=str;  
//            }
//            System.out.println(HtmlUtil.toDocumentStr(workInfo));
//            //System.out.println(StringUtil.getBrText(workInfo).replaceAll("&nbsp","").replaceAll(";;",""));
////            System.out.println(workInfo);
////            String [] info=getWorkInfo(workInfo);
////            for(int i=0;i<info.length;i++){
////            	System.out.println(info[i]);
////            }
////            System.out.println(getWorkInfoText(info));
////            workInfo=htmlFilter(workInfo);
////            System.out.println(workInfo);
//            in.close();
//        } 
//        catch (IOException e) 
//        {
//            e.getStackTrace();
//        }
//	}
	
	public static String htmlFilter(String html){
		String str="";
		int start=html.indexOf("<body topmargin=\"0\" marginheight=\"0\">");
		int end=html.indexOf("</body>");
		str=html.substring(start,end+7);//取<body>之间的内容
		return str;
	}
	
	/**
     * 在一串字符串中截取所需要的值，并且边读边丢已读到内容
     * @param content 传入字符串
     * @param begStr  开始分隔符
     * @param endStr  结束分隔符
     * @param flag    需要丢弃[true]
     * @return
     */
    public static  String getValue(String content,String begStr,String endStr,boolean flag)
    {
        if(content==null) return "";
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
                value = content.substring(0,content.indexOf(endStr));
                /**如果允许的话，就读一次丢一次**/
                if(flag)
                    fieldContent=content;   
            }
            catch(StringIndexOutOfBoundsException ex)
            {
                //ex.printStackTrace();
                return content;
            }
        }
        return  value.trim().replaceAll("　","");  
    }
    
    public static void main(String args[]){
//    	String str="&lt;tr&gt;&lt;tdcolspan&#61;&quot;4&quot;&gt;2006-05-072008-07-02：浙江宁波鄞州天星电器&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;tdcolspan&#61;&quot;2&quot;&gt;&lt;b&gt;技术部&lt;/b&gt;&lt;/td&gt;&lt;tdcolspan&#61;&quot;2&quot;&gt;&lt;b&gt;技术员&lt;/b&gt;&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;tdcolspan&#61;&quot;4&quot;id&#61;&quot;Cur_Val&quot;style&#61;&quot;width:600px;word-wrap:break-word;overflow:auto&quot;&gt;负责继电器,点火线圈,传感器,电磁开关等新产品开发,图纸整理&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;tdcolspan&#61;&quot;4&quot;&gt;&lt;HRsize&#61;&quot;1&quot;width&#61;&quot;100%&quot;align&#61;&quot;right&quot;style&#61;&quot;color:#e0e0e0&quot;&gt;&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;tdcolspan&#61;&quot;4&quot;&gt;2003-07-152006-02-15：福建省厦工集团三明重型机器有限公司&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;tdcolspan&#61;&quot;2&quot;&gt;&lt;b&gt;工程研究所&lt;/b&gt;&lt;/td&gt;&lt;tdcolspan&#61;&quot;2&quot;&gt;&lt;b&gt;技术员&lt;/b&gt;&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;tdcolspan&#61;&quot;4&quot;id&#61;&quot;Cur_Val&quot;style&#61;&quot;width:600px;word-wrap:break-word;overflow:auto&quot;&gt;负责路面机械新产品开发,已有产品的改进&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;tdcolspan&#61;&quot;4&quot;&gt;&lt;HRsize&#61;&quot;1&quot;width&#61;&quot;100%&quot;align&#61;&quot;right&quot;style&#61;&quot;color:#e0e0e0&quot;&gt;&lt;/td&gt;&lt;/tr&gt;";
//    	String str="&lt;trheight&#61;&quot;25&quot;&gt;<br>&lt;tdwidth&#61;&quot;25%&quot;&gt;<br>2006-01-012008-01-01：<br>&lt;/td&gt;<br>&lt;tdwidth&#61;&quot;25%&quot;&gt;<br>中央电大<br>&lt;/td&gt;<br>&lt;tdwidth&#61;&quot;25%&quot;&gt;<br>行政管理<br>&lt;/td&gt;<br>&lt;tdwidth&#61;&quot;25%&quot;&gt;<br>本科<br>&lt;/td&gt;<br>&lt;/tr&gt;<br>&lt;tr&gt;<br>&lt;tdcolspan&#61;&quot;4&quot;&gt;<br>&lt;HRsize&#61;&quot;1&quot;width&#61;&quot;100%&quot;style&#61;&quot;color:#e0e0e0&quot;&gt;<br>&lt;/td&gt;<br>&lt;/tr&gt;<br><br>&lt;trheight&#61;&quot;25&quot;&gt;<br>&lt;tdwidth&#61;&quot;25%&quot;&gt;<br>2001-09-012004-06-30：<br>&lt;/td&gt;<br>&lt;tdwidth&#61;&quot;25%&quot;&gt;<br>浙江万里学院<br>&lt;/td&gt;<br>&lt;tdwidth&#61;&quot;25%&quot;&gt;<br>旅游管理<br>&lt;/td&gt;<br>&lt;tdwidth&#61;&quot;25%&quot;&gt;<br>大专<br>&lt;/td&gt;<br>&lt;/tr&gt;<br>&lt;tr&gt;<br>&lt;tdcolspan&#61;&quot;4&quot;&gt;<br>&lt;HRsize&#61;&quot;1&quot;width&#61;&quot;100%&quot;style&#61;&quot;color:#e0e0e0&quot;&gt;<br>&lt;/td&gt;<br>&lt;/tr&gt;";
//    	String str="&lt;trvalign&#61;&quot;top&quot;height&#61;&quot;25&quot;&gt;&lt;tdwidth&#61;&quot;25%&quot;&gt;2006-03-182006-04-20：&lt;/td&gt;&lt;tdwidth&#61;&quot;25%&quot;&gt;东华理工学院&lt;/td&gt;&lt;tdwidth&#61;&quot;25%&quot;&gt;普通话&lt;/td&gt;&lt;/tr&gt;&lt;trvalign&#61;&quot;top&quot;&gt;&lt;tdcolspan&#61;&quot;3&quot;style&#61;&quot;width:600px;word-wrap:break-word;overflow:auto&quot;&gt;训练标准的普通话能力&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;tdcolspan&#61;&quot;4&quot;&gt;&lt;HRsize&#61;&quot;1&quot;width&#61;&quot;100%&quot;style&#61;&quot;color:#e0e0e0&quot;&gt;&lt;/td&gt;&lt;/tr&gt;&lt;trvalign&#61;&quot;top&quot;height&#61;&quot;25&quot;&gt;&lt;tdwidth&#61;&quot;25%&quot;&gt;2006-03-072006-04-02：&lt;/td&gt;&lt;tdwidth&#61;&quot;25%&quot;&gt;东华理工学院&lt;/td&gt;&lt;tdwidth&#61;&quot;25%&quot;&gt;公关礼仪&lt;/td&gt;&lt;/tr&gt;&lt;trvalign&#61;&quot;top&quot;&gt;&lt;tdcolspan&#61;&quot;3&quot;style&#61;&quot;width:600px;word-wrap:break-word;overflow:auto&quot;&gt;培养社交礼仪与职场交际能力&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;tdcolspan&#61;&quot;4&quot;&gt;&lt;HRsize&#61;&quot;1&quot;width&#61;&quot;100%&quot;style&#61;&quot;color:#e0e0e0&quot;&gt;&lt;/td&gt;&lt;/tr&gt;";
    	String str="  &lt;trheight&#61;&quot;25&quot;&gt;&lt;tdwidth&#61;&quot;50%&quot;&gt;进料加工手册&lt;/td&gt;&lt;tdwidth&#61;&quot;50%&quot;&gt;进料加工&lt;/td&gt;&lt;/tr&gt;&lt;trheight&#61;&quot;25&quot;&gt;&lt;tdwidth&#61;&quot;50%&quot;&gt;英语&lt;/td&gt;&lt;tdwidth&#61;&quot;50%&quot;&gt;大学英语6级&lt;/td&gt;&lt;/tr&gt;&lt;trheight&#61;&quot;25&quot;&gt;&lt;tdwidth&#61;&quot;50%&quot;&gt;计算机&lt;/td&gt;&lt;tdwidth&#61;&quot;50%&quot;&gt;计算机2级&lt;/td&gt;&lt;/tr&gt;";
    	String info;
    	info=getOtherSkill(str);
    	System.out.println(info);
//    	for(int i=0;i<list.size();i++){
//    		String [] info=new String[4];
//    		info=(String[])list.get(i);
//    		for(int j=0;j<4;j++){
//    			System.out.println(info[j]);
//    		}
//    		info=null;
//    	}
    }
}

