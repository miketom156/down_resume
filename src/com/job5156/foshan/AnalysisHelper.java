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
	 * 0-�ֻ�
	 * 1-�绰
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
	 * ����ѧ���������������������Ŀ�ʼʱ��
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
	 * �ж��Ƿ�ȫ����������
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
	 * �ж��Ƿ�ȫ��������ĸ
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
	   * �ж��Ƿ�ȫ�����������ַ�
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
		 if(workText.indexOf("ʱ�䣺") > -1 && workText.indexOf("��˾���ƣ�") > -1){
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
			 if(!"".equals(StringUtil.getNotNullStr(tempInfo[i])) && tempInfo[i].indexOf("ʱ�䣺") > -1){
				 if(tempInfo[i].indexOf("��") > -1){
					 String[] data = tempInfo[i].split("��");
					 for(int j=0; j<data.length; j++){
						 int year = data[j].indexOf("����") != -1 ? DateUtil.getThisYear() : getTimeData(data[j], 1);
						 int month = data[j].indexOf("����") != -1 ? DateUtil.getThisMonth() : getTimeData(data[j].replaceFirst(String.valueOf(year), ""), 2);
						 if(year > 0 && month > 0 && m < 3){
							 info[m] = String.valueOf(year);
							 info[m+1] = String.valueOf(month);
							 m += 2;
						 }
					 }
					 data = null;
					 if(i+1 < tempInfo.length && !"".equals(StringUtil.getNotNullStr(tempInfo[i+1])) && tempInfo[i+1].indexOf("��˾���ƣ�") > -1){
						 info[4] = StringUtil.replace(tempInfo[i+1], "��˾���ƣ�", "");
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
		 if(type == 1){ //���
			 pattern = Pattern.compile("[12]\\d{3}");
		 }else if(type == 2){         //�·�
			 pattern = Pattern.compile("(1[0-2]{1})|([1-9]{1})");
		 }
		 Matcher matcher = pattern.matcher(timeStr);
		 if(matcher.find()){
		 	time = StringUtil.parseInt(matcher.group());
		 }
		 return time;
	 }
	 /**
	  * ��ȡ�ַ����еĿ�ʼʱ��
	  * @param str
	  * @return
	  */
	 public static String[] getYear(String str){
		 String[] year = null;
		 if(str != null && str.trim().length() > 0){
			 String temp = "";
			 int beginPos = 0; //ָ�뿪ʼλ��
			 int endPos = 0;   //ָ�����λ��
			 int movePos = 0;  //�ƶ�λ��
			 int flag = 0;     //��־һ�����ֵĿ�ʼ[1-��ʼ 0-��ͣ��ʼ]
			 boolean find = false; //��־�Ƿ��ҵ��������
			 boolean special = false; //��־�������(93��/02��)
			 while(beginPos <= endPos && endPos < str.length() && movePos < str.length()){
				 if(Character.isDigit(str.charAt(movePos))){
					 if((endPos - beginPos == 1) && (flag == 1)){
						 if(str.substring(endPos+1, endPos+2).equals("��")){
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
						 beginPos = movePos; //��־��ʼλ��
					 }
					 movePos ++;
					 endPos ++;
					 continue;
				 }else{
					 if(flag == 1){ //�Ѿ���־һ�����ֵĿ�ʼ
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
	  * ����һ�������Ĺ�����Ϣ
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
					 System.out.println("----û���ҵ��������,���ݶ���!");
				 }
			 }
		 }catch(Exception e){
			 info = null;
			 return info;
		 }
		 return info;
	 }
	 
	 /**
	  * ��ȡ�ַ������·�
	  * @param str
	  * @param begIndex
	  * @return
	  */
	 public static String[] findMonth(String str,int begIndex){
		 String month[] = {"",""};
		 int moveIndex = 2; //��ݺ��2���ַ�(1984.7/1984��7��)
		 if(Character.isDigit(str.charAt(begIndex+moveIndex))){
			 month[0] += str.charAt(begIndex+moveIndex);
			 month[1] = String.valueOf(begIndex+moveIndex+1);
			 moveIndex ++;
			 if(Character.isDigit(str.charAt(begIndex+moveIndex))){  //��ݺ��3���ַ�(1984.07/1984��07��
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
		String workText = "�μ�ѧУÿ��ѧ����֯�Ļ��ʵ��ʵѵ�����ղ�����Ĺ��̣��������ˡ��Ǽ����ˡ���ϸ�ˣ������ʲ���ծ����������ñ��Ƽ��׵��ֽ�����������Ӧ�ա�Ӧ���˿���㡢�ɱ���ƺ���ȣ������㳮���ܺͽ�����Ѳ�������Ĳ�����<br/>   2006��6�¡���8��  ��������߳��������۹�������Ϥ�������̺ͼ��ɡ�<br/>2007��7�¡���8��  ������԰�ҽ����ĵ��μҽ���ʦ����������Ӣ���ѧ�ȿ�Ŀ��ѧϰ��<br/>2008��12�¡���2009��1��  �ں������ʦ������ʵϰ�����û�˰���<br/>ʱ�䣺2009��3��2009��4��<br/>��˾���ƣ���ɽ���д�<br/>��˾���ʣ�˽Ӫ��ҵ<br/>����ְλ��ǰ̨��Ա<br/>����������<br/>��Ҫ�Ĺ�����Χ�������绰���շ����棬�����ļ�������˾Ҫ���������۵�����صı�����ͻ��¶������������������������Ҫʱ��ϵ��ݹ�˾��������˾���з����������������վݵȣ����Ǽ�ÿ��ķ�������ݺ����������ÿ��ͳ�Ʋֿ�Ŀ�������ѹ��������¼�����ϴ�����˾��̳�ϵ���صĹ�����<br/>��ְԭ�򣺹�˾��Ǩ<br/>";
		String[] result = AnalysisHelper.processSpecialWorkInfo(workText);
		for(int i=0; i<result.length; i++){
			System.out.println(result[i]);
		}
	}
}
