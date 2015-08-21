package com.job5156.jiangmen;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.job5156.util.DateUtil;
import com.job5156.util.StringUtil;

public class AnalysisHelper {

	public static String getBirthday(String age){
		String birthday = "";
		int tempAge = StringUtil.parseInt(age);
		if(tempAge > 0){
			int currentYear = DateUtil.getThisYear();
			birthday = (currentYear - tempAge)+"-1-1";
		}
		return birthday;
	}
	
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
	
	public static String[][] analysisContact(String phone, String mobile){
		String[][] contact = {{"0",""},{"1",""}};
		if(!"".equals(phone)){
			if(phone.startsWith("1")){
				contact[0][0] = "0";
				contact[0][1] = phone;
				contact[1][0] = "1";
				contact[1][1] = "";
			}else{
				contact[0][0] = "1";
				contact[0][1] = phone;
				contact[1][0] = "0";
				contact[1][1] = "";
			}
		}else{
			if(!"".equals(mobile)){
				if(mobile.startsWith("1")){
					contact[0][0] = "0";
					contact[0][1] = mobile;
					contact[1][0] = "1";
					contact[1][1] = "";
				}else{
					contact[0][0] = "1";
					contact[0][1] = mobile;
					contact[1][0] = "0";
					contact[1][1] = "";
				}
			}
		}
		return contact;
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
	
	public static String[] analysJobCata(JiangMenResume resume){
		String[] job = {"","","",""};
		Set jobSet = new HashSet();
		if(resume != null){
			String job1 = "",job2 = "",job3 = "";
			if(!"".equals(StringUtil.getNotNullStr(resume.getJobcode1()))){
				job1 = MapTable.getCodeTwo(StringUtil.getNotNullStr(resume.getJobcode1()), MapTable.jobCode);
				job[3] = StringUtil.getNotNullStr(resume.getJobcode1());
			}
			if(!"".equals(StringUtil.getNotNullStr(resume.getJobcode2()))){
				job2 = MapTable.getCodeTwo(StringUtil.getNotNullStr(resume.getJobcode2()), MapTable.jobCode);
				if("".equals(job[3]))job[3] = StringUtil.getNotNullStr(resume.getJobcode2());
			}
			if(!"".equals(StringUtil.getNotNullStr(resume.getJobcode3()))){
				job3 = MapTable.getCodeTwo(StringUtil.getNotNullStr(resume.getJobcode3()), MapTable.jobCode);
				if("".equals(job[3]))job[3] = StringUtil.getNotNullStr(resume.getJobcode2());
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
	
	public static String[] analysJobLocation(JiangMenResume resume){
		String[] loc = {"","",""};
		Set locSet = new HashSet();
		if(resume != null){
			String loc1 = "",loc2 = "";
			if(!"".equals(StringUtil.getNotNullStr(resume.getJobLocation1()))){
				loc1 = MapTable.getCodeTwo(StringUtil.getNotNullStr(resume.getJobLocation1()), MapTable.jobLocation);
			}
			if(!"".equals(StringUtil.getNotNullStr(resume.getJobLocation2()))){
				loc2 = MapTable.getCodeTwo(StringUtil.getNotNullStr(resume.getJobLocation2()).replaceAll("　", ""), MapTable.jobLocation);
			}
			if(!"".equals(loc1)){
				locSet.add(loc1);
			}
			if(!"".equals(loc2)){
				locSet.add(loc2);
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
	
	public static String analysisSalary(String salary){
		String sal = "";
		if(!"".equals(salary)){
			if("面议".equals(salary)){
				sal = "0";
			}else{
				sal = getSalary(salary);
			}
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
	
	public static int getSchoolBeginDate(JiangMenResume resume){
		int beginDate = 0;
		String endDate = StringUtil.getNotNullStr(resume.getGraduateDate());
		int addYear = StringUtil.parseInt(MapTable.getCodeTwo(StringUtil.getNotNullStr(resume.getHighDegree()), MapTable.addYear));
		if(addYear > 0){
			String[] temp = endDate.split("年");
			if(temp != null && temp.length > 0){
				int beginYear = StringUtil.parseInt(temp[0]);
				beginDate = beginYear - addYear;	
			}
			temp = null;
		}
		return beginDate;
	}
	
	public static int getSchoolEndYear(String endDate){
		int endYear = 0;
		if(!"".equals(endDate)){
			String[] temp = endDate.split("年");
			if(temp != null && temp.length > 0){
				endYear = StringUtil.parseInt(temp[0]);
			}
			temp = null;
		}
		return endYear;
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
	 
	 public static String[] getWorkInfo(String workText){
		 String[] info = null;
		 String[] tempInfo = null;
		 if(!isNumeric(workText) && !isCharacter(workText) && !isChinese(workText)){
			 tempInfo = workText.split("<br>");
			 for(int i=0;i<tempInfo.length;i++){
				 String[] temp = processWorkInfo(tempInfo[i]);
				 if(temp != null){
					 info = temp;
					 temp = null;
					 break;
				 }
			 }
			 tempInfo = null;
		 }else{
			 System.out.println("----工作数据不符合要求,全部为数字或者字母或者中文汉字,数据丢弃!");
		 }
		 return info;
	 }
	  
	 /**
	  * 截取字符串中的开始时间
	  * @param str
	  * @return
	  */
	 public static String[] getYear(String str){
		 String[] year = null;
		 if(str != null && str.trim().length() > 0){
			 String temp = "";
			 int beginPos = 0; //指针开始位置
			 int endPos = 0;   //指针结束位置
			 int movePos = 0;  //移动位置
			 int flag = 0;     //标志一个数字的开始[1-开始 0-暂停开始]
			 boolean find = false; //标志是否找到年份数据
			 boolean special = false; //标志特殊年份(93年/02年)
			 while(beginPos <= endPos && endPos < str.length() && movePos < str.length()){
				 if(Character.isDigit(str.charAt(movePos))){
					 if((endPos - beginPos == 1) && (flag == 1)){
						 if(str.substring(endPos+1, endPos+2).equals("年")){
							 find = true;
							 special = true;
							 break;
						 }
					 }
					 if((endPos - beginPos == 3) && (flag == 1)){
						 find = true;
						 break;
					 }
					 if(flag == 0){
						 flag = 1;
						 beginPos = movePos; //标志开始位置
					 }
					 movePos ++;
					 endPos ++;
					 continue;
				 }else{
					 if(flag == 1){ //已经标志一个数字的开始
						 flag = 0;
					 }
					 movePos ++;
					 endPos ++;
				 }
			 }
			 if(find){
				 if(special){
					 String tempStr = StringUtil.getSubStr(str, beginPos, endPos+1);
					 if(tempStr.startsWith("0")){
						 tempStr = "20"+tempStr;
					 }else{
						 tempStr = "19"+tempStr;
					 }
					 year = new String[3];
					 year[0] = tempStr;
					 year[1] = String.valueOf(beginPos);
					 year[2] = String.valueOf(endPos);
				 }else{
					 year = new String[3];
					 year[0] = StringUtil.getSubStr(str, beginPos, endPos+1);
					 year[1] = String.valueOf(beginPos);
					 year[2] = String.valueOf(endPos);
				 }
			 }
		 }
		 return year;
	 }
	
	 /**
	  * 处理一条基本的工作信息
	  * @param str
	  * @return
	  */
	 public static String[] processWorkInfo(String str){
		 String[] info = null;
		 try{
			 if(str != null && !str.equals("")){
				 String[] tempYear = getYear(str);
				 if(tempYear != null){
					info = new String[5];
				    info[0] = tempYear[0];
				    String[] monthInfo = findMonth(str,Integer.parseInt(tempYear[2]));
				    info[1] = monthInfo[0].equals("")?"1":monthInfo[0];
					str = StringUtil.getSubStr(str, monthInfo[1].equals("")?Integer.parseInt(tempYear[2])+1:Integer.parseInt(monthInfo[1]), str.length());
					String[] temp1Year = getYear(str);
					if(temp1Year != null){
					    info[2] = temp1Year[0];
					    monthInfo = findMonth(str,Integer.parseInt(temp1Year[2]));
					    info[3] = monthInfo[0].equals("")?"9":monthInfo[0];
					    info[4] = StringUtil.getSubStr(str, monthInfo[1].equals("")?Integer.parseInt(temp1Year[2])+1:Integer.parseInt(monthInfo[1]), str.length());
					}else{
						info[2] = "2008";
						info[3] = "9";
						info[4] = str;
					}
					tempYear = null;
					temp1Year = null;
				 }else{
					 System.out.println("----没有找到年份数据,数据丢弃!");
				 }
			 }
		 }catch(Exception e){
			 info = null;
			 return info;
		 }
		 return info;
	 }
	 
	 /**
	  * 截取字符串的月份
	  * @param str
	  * @param begIndex
	  * @return
	  */
	 public static String[] findMonth(String str,int begIndex){
		 String month[] = {"",""};
		 int moveIndex = 2; //年份后第2个字符(1984.7/1984年7月)
		 if(Character.isDigit(str.charAt(begIndex+moveIndex))){
			 month[0] += str.charAt(begIndex+moveIndex);
			 month[1] = String.valueOf(begIndex+moveIndex+1);
			 moveIndex ++;
			 if(Character.isDigit(str.charAt(begIndex+moveIndex))){  //年份后第3个字符(1984.07/1984年07月
				 month[0] += str.charAt(begIndex+moveIndex);
				 month[1] = String.valueOf(begIndex+moveIndex+1);
			 }
		 }
		 if(!month[0].equals("")){
			 if(StringUtil.parseInt(month[0]) > 12){
				 month[0] = "";
				 month[1] = "";
			 }
		 }
		 return month;
	 }
	 
	public static void main(String[] args){
		JiangMenResume resume = new JiangMenResume();
		resume.setJobLocation1("江门市");
		resume.setJobLocation2("广东新会");
		String[] result = analysJobLocation(resume);
		System.out.println(result[0]+":"+result[1]+":"+result[2]);
	}
}
