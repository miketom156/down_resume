package com.job5156.foshan;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.job5156.util.DateUtil;
import com.job5156.util.StringUtil;

public class AnalysisHelper {

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
	
	/**
	 * 0-手机
	 * 1-电话
	 **/
	public static String[][] analysisContact(String phone, String mobile){
		String[][] contact = {{"0",""},{"1",""}};
		if(!"".equals(phone) || !"".equals(mobile)){
			if(!"".equals(phone)){
				if(phone.startsWith("1")){
					contact[0][0] = "0";
					contact[0][1] = phone;
					if(!"".equals(mobile)){
						if(mobile.startsWith("1")){
							contact[1][0] = "0";
						}else{
							contact[1][0] = "1";
						}
						contact[1][1] = mobile;
					}else{
						contact[1][0] = "1";
						contact[1][1] = "";
					}
				}else{
					if(!"".equals(mobile)){
						if(mobile.startsWith("1")){
							contact[0][0] = "0";
							contact[0][1] = mobile;
							contact[1][0] = "1";
							contact[1][1] = phone;
						}else{
							contact[0][0] = "1";
							contact[0][1] = phone;
							contact[1][0] = "1";
							contact[1][1] = mobile;
						}
					}else{
						contact[0][0] = "1";
						contact[0][1] = phone;
						contact[1][0] = "0";
						contact[1][1] = "";
					}
				}
			}else if(!"".equals(mobile)){
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
	
	public static String[] analysJobCata(FoShanResume resume){
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
				if("".equals(job[3]))job[3] = StringUtil.getNotNullStr(resume.getJobcode3());
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
	
	public static String[] analysJobLocation(FoShanResume resume){
		String[] loc = {"","",""};
		Set locSet = new HashSet();
		if(resume != null){
			String loc1 = "",loc2 = "",loc3 = "";
			if(!"".equals(StringUtil.getNotNullStr(resume.getJobLocation1()))){
				loc1 = MapTable.getCodeTwo(StringUtil.getNotNullStr(resume.getJobLocation1()), MapTable.jobLocation);
			}
			if(!"".equals(StringUtil.getNotNullStr(resume.getJobLocation2()))){
				loc2 = MapTable.getCodeTwo(StringUtil.getNotNullStr(resume.getJobLocation2()), MapTable.jobLocation);
			}
			if(!"".equals(StringUtil.getNotNullStr(resume.getJobLocation3()))){
				loc3 = MapTable.getCodeTwo(StringUtil.getNotNullStr(resume.getJobLocation3()), MapTable.jobLocation);
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
	
	/**
	 * 根据学历和年龄估算出教育经历的开始时间
	 * @param resume
	 * @return
	 */
	public static int getSchoolBeginDate(FoShanResume resume){
		int beginYear = 0;
		int birthdayYear = 0;
		int addYear = StringUtil.parseInt(MapTable.getCodeTwo(StringUtil.getNotNullStr(resume.getHighDegree()), MapTable.addYear));
		int age = StringUtil.parseInt(resume.getUserAge());
		if(age > 0){
			birthdayYear = DateUtil.getThisYear() - age;
		}
		if(birthdayYear > 0 && addYear > 0){
			beginYear = birthdayYear + addYear;
		}
		return beginYear;
	}
	
	/**
	 * 
	 * @param endDate
	 * @return
	 */
	public static int getSchoolEndYear(int beginYear, FoShanResume resume){
		int endYear = 0;
		int addYear = StringUtil.parseInt(MapTable.getCodeTwo(StringUtil.getNotNullStr(resume.getHighDegree()), MapTable.year));
		if(beginYear > 0 && addYear > 0){
			endYear = beginYear + addYear;
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
		 if(workText.indexOf("时间：") > -1 && workText.indexOf("公司名称：") > -1){
			 info = processSpecialWorkInfo(workText);
		 }else{
	    	 String[] tempInfo = workText.split("<br/>");
			 for(int i=0;i<tempInfo.length;i++){
				 String[] temp = processWorkInfo(tempInfo[i]);
				 if(temp != null){
					 info = temp;
					 temp = null;
					 break;
				 }
			 }
			 tempInfo = null;
		 }
		 return info;
	 }
	 
	 public static String[] processSpecialWorkInfo(String workText){
		 String[] info = new String[5];
		 String[] tempInfo = workText.split("<br/>");
		 int m = 0;
		 for(int i=0; i<tempInfo.length; i++){
			 if(!"".equals(StringUtil.getNotNullStr(tempInfo[i])) && tempInfo[i].indexOf("时间：") > -1){
				 if(tempInfo[i].indexOf("月") > -1){
					 String[] data = tempInfo[i].split("月");
					 for(int j=0; j<data.length; j++){
						 int year = data[j].indexOf("至今") != -1 ? DateUtil.getThisYear() : getTimeData(data[j], 1);
						 int month = data[j].indexOf("至今") != -1 ? DateUtil.getThisMonth() : getTimeData(data[j].replaceFirst(String.valueOf(year), ""), 2);
						 if(year > 0 && month > 0 && m < 3){
							 info[m] = String.valueOf(year);
							 info[m+1] = String.valueOf(month);
							 m += 2;
						 }
					 }
					 data = null;
					 if(i+1 < tempInfo.length && !"".equals(StringUtil.getNotNullStr(tempInfo[i+1])) && tempInfo[i+1].indexOf("公司名称：") > -1){
						 info[4] = StringUtil.replace(tempInfo[i+1], "公司名称：", "");
					 }
				 }
			 }
			 if(!"".equals(StringUtil.getNotNullStr(info[4]))&& 
			 	!"".equals(StringUtil.getNotNullStr(info[0]))&&
			 	!"".equals(StringUtil.getNotNullStr(info[1]))&&
			 	!"".equals(StringUtil.getNotNullStr(info[2]))&&
			 	!"".equals(StringUtil.getNotNullStr(info[3]))){
				 break;
			 }
		 }
		 tempInfo = null;
		 return info;
	 }
	  
	 public static int getTimeData(String timeStr, int type){
		 int time = 0;
		 Pattern pattern = null;
		 if(type == 1){ //年份
			 pattern = Pattern.compile("[12]\\d{3}");
		 }else if(type == 2){         //月份
			 pattern = Pattern.compile("(1[0-2]{1})|([1-9]{1})");
		 }
		 Matcher matcher = pattern.matcher(timeStr);
		 if(matcher.find()){
		 	time = StringUtil.parseInt(matcher.group());
		 }
		 return time;
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
		String workText = "参加学校每个学期组织的会计实务实训，掌握财务处理的过程，熟练记账、登记总账、明细账，编制资产负债表、利润表，懂得编制简易的现金流量表，掌握应收、应付账款核算、成本会计核算等，熟练点钞技能和金蝶用友财务软件的操作。<br/>   2006年6月——8月  在中美玩具厂担任销售工作，熟悉销售流程和技巧。<br/>2007年7月——8月  在益智园家教中心担任家教老师，辅导别人英语、数学等科目的学习。<br/>2008年12月——2009年1月  在海正会计师事务所实习，懂得汇税清缴<br/>时间：2009年3月2009年4月<br/>公司名称：佛山兴中达<br/>公司性质：私营企业<br/>担任职位：前台文员<br/>工作描述：<br/>主要的工作范围：接听电话，收发传真，整理文件，按公司要求制作报价单和相关的报表。帮客户下订单，并跟进发货的情况，必要时联系快递公司和物流公司进行发货，开发货单、收据等，并登记每天的发货、快递和物流情况，每天统计仓库的库存量，把工作任务记录下来上传到公司论坛上等相关的工作。<br/>离职原因：公司搬迁<br/>";
		String[] result = AnalysisHelper.processSpecialWorkInfo(workText);
		for(int i=0; i<result.length; i++){
			System.out.println(result[i]);
		}
	}
}
