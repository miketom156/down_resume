package com.job5156.jsDateJoin.event;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import com.job5156.jsDateJoin.entity.PersonBaseInfo;
import com.job5156.jsDateJoin.entity.PersonIntent;
import com.job5156.jsDateJoin.entity.PersonSchool;
import com.job5156.jsDateJoin.entity.PersonSkill;
import com.job5156.jsDateJoin.entity.PersonWork;
import com.job5156.jsDateJoin.entity.person;
import com.job5156.server.EntityManager;
import com.job5156.server.LocalSessionManager;
import com.job5156.server.SessionManager;
import com.job5156.util.DateUtil;
import com.job5156.util.RandomString;
import com.job5156.util.StringUtil;

public class InputPersonTO29 {
	private static Logger log = Logger.getLogger(InputPersonTO29.class);
	public static int sum = 0;
	
	public static void main(String[] args) {		
		System.out.println("----------江苏人才网 个人会员 导入本地数据库 开始！--------------");
		long begintime = System.currentTimeMillis();
		Session localsession  = LocalSessionManager.currentSession();
		Session session29  = SessionManager.currentSession();
		
		runCompanyDate(localsession,session29);
		
		session29.close();
		localsession.close();
		long endtime = System.currentTimeMillis();
		System.out.println("----------江苏人才网 个人会员 导入本地数据库 结束！用时："+(endtime - begintime)/1000/60+" 分钟");
		System.out.println("sum="+sum);
		log.error("江苏人才网 个人会员 导入数据库 用时："+(endtime - begintime)/1000/60+" 分钟");		
	}
	
	public static void runCompanyDate(Session localsession,Session session29){
		String hqlCount = "SELECT COUNT(p.id) FROM person p order by p.id";
		String hql = "SELECT p FROM person p order by p.id";
		
		int allRecord = EntityManager.getAllEntityNumberByHql(hqlCount, localsession);
		//int dataLoadNumber = 2000;
		int dataLoadNumber = 1000;
		int allPage = allRecord > 0 ? 1 : 0;
		if(allRecord > dataLoadNumber){
			allPage = allRecord / dataLoadNumber + ((allRecord % dataLoadNumber == 0) ? 0 : 1);
		}
		//allPage = 1;
		List list = null;
		String email = "";
		PersonBaseInfo pbi = null;
		PersonSchool ps = null;
		PersonWork pw = null;
		PersonIntent it = null;
		PersonSkill s = null;
		int k = 0;
		
		for(int m=5; m<allPage; m++){
			System.out.println("第"+m+"页数");
			list = EntityManager.getEntityByHqlAndStartRecords(hql, localsession, m*dataLoadNumber, dataLoadNumber);
			if(list != null && list.size() > 0){
				for(int i=0; i<list.size(); i++){					
					person p = (person)list.get(i);
					email = StringUtil.getNotNullStr(p.getEmail());					
					//判断是否存在
					if(isTrue(email,session29)&&isChince1(StringUtil.getNotNullStr(p.getStartworkdate()))){					
							System.out.println(i);
							String startworkdate = StringUtil.getNotNullStr(p.getStartworkdate());
							if("".equals(startworkdate)){
								p.setStartworkdate("201107");
							}
							//保存个人基本信息
							pbi = savePerson(p,session29);
							EntityManager.saveEntity(pbi, session29);						
							//保存教育经历
							ps = saveSchool(pbi.getId(),p);
							EntityManager.saveEntity(ps, session29);
							//保持工作经历
							pw = savePWork(pbi.getId(),p);
							EntityManager.saveEntity(pw, session29);
							//保存求职意向
							it = saveIntent(pbi.getId(),p);
							EntityManager.saveEntity(it, session29);
							//保存工作技巧
							s = saveSkill(pbi.getId(),p);
							EntityManager.saveEntity(s, session29);							
							
							pbi = null;
							ps = null;
							pw = null;
							it = null;
							s = null;
							k++;
							if(k>100){
								session29.clear();
								localsession.clear();
								k=0;
							}
					}
					email = "";
					try {
						Thread.sleep(500);
						System.out.println("休眠半秒钟！");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						System.out.println("休眠半秒钟 出错！");
						e.printStackTrace();
					}
				}
				
			}			
			list.clear();			
		}		
	}
	
	public static PersonSkill saveSkill(int pbiID,person p){
		PersonSkill s = new PersonSkill();
		s.setUserid(pbiID);
		InputMap imap = new InputMap();
		String temp = "";
		temp = imap.getJob5156Code(imap.computerT,StringUtil.getNotNullStr(p.getComputerlevel()),true);
		if("".equals(temp)){
			temp = "0";
		}
		s.setComputerlevel(StringUtil.parseInt(temp));
		temp = imap.getJob5156Code(imap.languageT,StringUtil.getNotNullStr(p.getForeign1()),true);
		if("".equals(temp)){
			temp = "0";
		}
		s.setLanguage1(StringUtil.parseInt(temp));
		
		temp = imap.getJob5156Code(imap.languageTypeT,StringUtil.getNotNullStr(p.getForeignlevel1()),true);
		if("".equals(temp)){
			temp = "0";
		}
		s.setCertificate1(StringUtil.parseInt(temp));
		
		temp = imap.getJob5156Code(imap.languageT,StringUtil.getNotNullStr(p.getForeign2()),true);
		if("".equals(temp)){
			temp = "0";
		}
		s.setLanguage2(StringUtil.parseInt(temp));
		
		temp = imap.getJob5156Code(imap.languageTypeT,StringUtil.getNotNullStr(p.getForeignlevel2()),true);
		if("".equals(temp)){
			temp = "0";
		}
		s.setCertificate2(StringUtil.parseInt(temp));
		
		s.setOtherskills(StringUtil.getNotNullStr(p.getSpecialty()));
		s.setCre_date(DateUtil.getNowDateTime());
		s.setRev_date(DateUtil.getNowDateTime());
		
		return s;
	}
	
	public static PersonIntent saveIntent(int pbiID,person p){
		PersonIntent it = new PersonIntent();
		InputMap imap = new InputMap();
		String temp = "";
		it.setUserid(StringUtil.parseInt(pbiID));
		it.setRev_date(DateUtil.getNowDateTime());
		it.setCre_date(DateUtil.getNowDateTime());
		
		temp = StringUtil.getNotNullStr(p.getStartworkdate());
		
		int year1 = 0;
		int month1 = 0;
		if(6 == temp.length()){
			year1 = StringUtil.parseInt(temp.substring(0,4));
			month1 = StringUtil.parseInt(temp.substring(4,6));
		}else{
			year1 = StringUtil.parseInt(temp.substring(0,4));
			month1 = StringUtil.parseInt(temp.substring(4,5));			
		}
		
		
		Date nowDate = new Date();
		int year2 = StringUtil.parseInt(nowDate.getYear())+1900;
		int month2 = StringUtil.parseInt(nowDate.getMonth())+1;
		int[] obj = new int[2];
		if(month2<month1){
			year2 = year2 -1;
			month2 = month2+12;
			obj[0] = (year2 - year1);
			obj[1] = (month2 - month1);
		}else{
			obj[0] = (year2 - year1);
			obj[1] = (month2 - month1);
		}
		
		
		it.setWorkyear(obj[0]);
		it.setWorkyear1(0);
		it.setWorkcalling("");
		
		temp = imap.getJob5156Code(imap.JobfunctionT,StringUtil.getNotNullStr(p.getJobposition1()),true);		
		it.setJobcode1(StringUtil.parseInt(temp));
		
		temp = imap.getJob5156Code(imap.JobfunctionT,StringUtil.getNotNullStr(p.getJobposition2()),true);		
		it.setJobcode2(StringUtil.parseInt(temp));
		
		temp = imap.getJob5156Code(imap.JobfunctionT,StringUtil.getNotNullStr(p.getJobposition3()),true);		
		it.setJobcode3(StringUtil.parseInt(temp));
		
		temp = imap.getJob5156Code(imap.cityT,StringUtil.getNotNullStr(p.getJobcity()),true);		
		it.setJoblocation1(StringUtil.parseInt(temp,1600));
		
		temp = imap.getJob5156Code(imap.salaryT,StringUtil.getNotNullStr(p.getMonthlypay()),true);
		if("".equals(temp)){
			temp = "0";
		}
		it.setSalary(StringUtil.getNotNullStr(temp));		
		it.setNeededhouse(StringUtil.parseInt(p.getNeedhouse()));
		it.setOtherrequirement(StringUtil.getNotNullStr(p.getOtherneed()));
		it.setCheckindate(0);
		it.setCheckindate1("");
		it.setState(0);
		it.setOtherjob1("");
		it.setOtherjob2("");
		it.setOtherjob3("");
		
		it.setWorkcalling(StringUtil.getNotNullStr(p.getTechpostname()));
		return it;
	}
	public static PersonWork savePWork(int pbiID,person p){
		PersonWork pw = new PersonWork();
		InputMap imap = new InputMap();
		String temp = "";
		
		pw.setUserid(StringUtil.parseInt(pbiID));
		temp = StringUtil.getNotNullStr(p.getStartworkdate());
		
		if(6 == temp.length()){
			pw.setBegindateyear(StringUtil.parseInt(temp.substring(0,4)));
			pw.setBegindatemonth(StringUtil.parseInt(temp.substring(4,6)));
		}else{
			pw.setBegindateyear(StringUtil.parseInt(temp.substring(0,4)));
			pw.setBegindatemonth(StringUtil.parseInt("0"+temp.substring(4,5)));
			
		}
		
		
		pw.setEnddateyear(2011);
		pw.setEnddatemonth(6);
		pw.setComname(StringUtil.getNotNullStr(p.getNowunit()));
		pw.setComtype(0);
		pw.setComcalling(0);
		pw.setMaincatalog(0);
		pw.setSalary("保密");
		pw.setFlag(6);
		pw.setOtherposition(StringUtil.getNotNullStr(p.getTechpostname()));
		temp = StringUtil.getNotNullStr(p.getWorklist());
		if("".equals(temp)){
			temp = " " + StringUtil.getNotNullStr(p.getStartworkdate()) + " " + StringUtil.getNotNullStr(p.getTechpostname()) + " " + imap.getJob5156Code(imap.typeT,StringUtil.getNotNullStr(p.getType()),true);
		}
		pw.setDescription("##=@!=####=@!=##"+temp);
		temp = imap.getJob5156Code(imap.JobCauseT,StringUtil.getNotNullStr(p.getJobcause()),true);
		pw.setLeftreason(temp);
		pw.setCre_date(DateUtil.getNowDateTime());
		pw.setRev_date(DateUtil.getNowDateTime());		
		return pw;
	}
	
//	public static Object[] getWorkDate(){
//		Object[] obj = new Object[2];
//		
//		return obj;
//	}
	
	//个人基本信息
	public static PersonSchool saveSchool(int pbiID,person p){
		InputMap imap = new InputMap();
		PersonSchool ps = new PersonSchool();
		String temp = "";
		ps.setUserid(StringUtil.parseInt(pbiID));
		
		temp = imap.getJob5156Code(imap.DegreeT,StringUtil.getNotNullStr(p.getEdulevel1()),true);
		if("".equals(temp)){
			temp = "01";
		}
		ps.setDegree(StringUtil.parseInt(temp));
		
		String Edudate1 = StringUtil.getNotNullStr(p.getEdudate1());
		
		if(!"".equals(Edudate1)){
			Object[] obj = calYear(temp,p);
			ps.setBegindateyear(StringUtil.parseInt(obj[0]));
			ps.setBegindatemonth(StringUtil.parseInt(obj[1]));
			ps.setEnddateyear(StringUtil.parseInt(obj[2]));
			ps.setEnddatemonth(StringUtil.parseInt(obj[3]));
		}
		
		ps.setSchool(StringUtil.getNotNullStr(p.getEduuniv1()));
		temp = imap.getJob5156Code(imap.specialT,StringUtil.getNotNullStr(p.getSpecialityname1()),true);
		ps.setSpeciality(temp);
		ps.setCertificate("");
		ps.setCre_date(DateUtil.getNowDateTime());
		ps.setRev_date(DateUtil.getNowDateTime());
		ps.setCourse("");
		ps.setFlag(0);		
		return ps;
	}
	
	public static Object[] calYear(String temp,person p){
		Object[] obj = new Object[4];
		String timeT = StringUtil.getNotNullStr(p.getEdudate1());
		if(6 == timeT.length()){
			obj[2] = StringUtil.getNotNullStr(timeT.substring(0,4));
			obj[3] = StringUtil.getNotNullStr(timeT.substring(4,6));
		}else{
			obj[2] = StringUtil.getNotNullStr(timeT.substring(0,4));
			obj[3] = "0"+StringUtil.getNotNullStr(timeT.substring(4,5));
			
		}
		
		
		timeT = obj[2]+"-"+obj[3]+ "-"+"01 00:00:00";
		Date GDate = new Date();
		try {
			GDate = DateUtil.string2Date(timeT);
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		String GDate1 = "";		
		switch(StringUtil.parseInt(temp)) 
		{ 
		   case 1: 
			   GDate1 = DateUtil.dateAdd("y", -3, GDate);
		       break; 
		   case 2: 
			   GDate1 = DateUtil.dateAdd("y", -3, GDate);
		       break; 
		   case 3: 
			   GDate1 = DateUtil.dateAdd("y", -3, GDate);
		       break;
		   case 4: 
			   GDate1 = DateUtil.dateAdd("y", -3, GDate);
		       break;
		   case 5: 
			   GDate1 = DateUtil.dateAdd("y", -4, GDate);
		       break; 
		   case 6: 
			   GDate1 = DateUtil.dateAdd("m", -18, GDate);
		       break; 
		   case 7:
			   GDate1 = DateUtil.dateAdd("y", -3, GDate);
		       break;
		   case 8: 
			   GDate1 = DateUtil.dateAdd("y", -3, GDate);
		       break;		   
		} 
		String[] temp1 = GDate1.split("-");
		obj[0] = temp1[0];
		obj[1] = 9;	
		return obj;
	}
	
	public static boolean isChince(String str){
		boolean flag = true;
		if("".equals(str)){
			flag = false;
		}
		int count = 0;       
        String regEx = "[\\u4e00-\\u9fa5]";           
        Pattern p = Pattern.compile(regEx);       
        Matcher m = p.matcher(str);       
        while (m.find()) {       
           for (int i = 0; i <= m.groupCount(); i++) {       
                count = count + 1;
                break;
            }       
        }       
        if(count > 0){
        	flag = false;
        }

		return flag;
	}
	
	public static boolean isChince1(String str){
		boolean flag = true;
		
		int count = 0;       
        String regEx = "[\\u4e00-\\u9fa5]";           
        Pattern p = Pattern.compile(regEx);       
        Matcher m = p.matcher(str);       
        while (m.find()) {       
           for (int i = 0; i <= m.groupCount(); i++) {       
                count = count + 1;
                break;
            }       
        }       
        if(count > 0){
        	flag = false;
        }

		return flag;
	}
	
	/**根据长度获得一串数值组成的字符串*/
	 public static String getMathStringByLength(int length){
	     RandomString test = new RandomString();
	
	     String code="";
	     test.setLength(length);
	     test.setCharset("0-9a-z");
	     try {
	         test.generateRandomObject();
	         code = test.getRandom();
	     } catch (Exception e) {
	         e.printStackTrace();
	     }        
	     return code;
	 }
	public static PersonBaseInfo savePerson(person p,Session session29){
		
		PersonBaseInfo pbi = new PersonBaseInfo();
		InputMap imap = new InputMap();
		String temp = "";
		temp = StringUtil.getNotNullStr(p.getUname());
		
		if(isChince(temp) && isTureAccount(p,session29)){
			pbi.setUseraccounts(temp);			
		}else{			
			pbi.setUseraccounts("job5156"+getMathStringByLength(6));			
		}
		
		pbi.setUserpassword(StringUtil.getNotNullStr(p.getPwd()));
		pbi.setUsername(StringUtil.getNotNullStr(p.getRealname()));
		//对照 OK
		temp = imap.getJob5156Code(imap.sexT,StringUtil.getNotNullStr(p.getSex()),true);
		if("".equals(temp)){
			temp = "0";
		}
		pbi.setSex(StringUtil.parseInt(temp));
		
		temp = imap.getJob5156Code(imap.nationT,StringUtil.getNotNullStr(p.getNation()),true);
		if("".equals(temp)){
			temp = "汉族";
		}
		pbi.setNation(temp);   //民族
		
		temp = imap.getJob5156Code(imap.marriageT,StringUtil.getNotNullStr(p.getMarriage()),true);
		if("".equals(temp)){
			temp = "3";
		}
		pbi.setMarriage(StringUtil.parseInt(temp));     //婚姻状况
		
		
		temp = StringUtil.getNotNullStr(p.getBirthday());
		
		if(!"".equals(temp)){
			String year = "";
			String month = "";
			
			if(6 == temp.length()){
				year = temp.substring(0,4);
				month = temp.substring(4,6);
			}else{
				year = temp.substring(0,4);
				month = "0"+temp.substring(4,5);
				
			}
			
			pbi.setBirthday(year+"-"+month+"-01 00:00:00");//出生年月
		}
		
		
		
		pbi.setStature(StringUtil.parseInt(p.getHeight()));//身高
		//pbi.setWeight("");//体重
		
		
		temp = imap.getJob5156Code(imap.cardtypeT,StringUtil.getNotNullStr(p.getCardtype()),true);
		if("".equals(temp)){
			temp = "1";
		}
		pbi.setCardtype(StringUtil.parseInt(temp));
		pbi.setCardtypenum(StringUtil.getNotNullStr(p.getCardno()));
		//户口所在地-省
		temp = imap.getJob5156Code(imap.cityT,StringUtil.getNotNullStr(p.getHomecity()),true);
		if("".equals(temp)){
			temp = "1600";
		}		
		if("00".equals(temp.substring(2,4))){
			pbi.setHometown_p(StringUtil.parseInt(temp));
		}else{
			pbi.setHometown_p(StringUtil.parseInt(temp.substring(0,2)+"00"));
			pbi.setHometown_c(StringUtil.parseInt(temp));
		}
		temp = imap.getJob5156Code(imap.cityT,StringUtil.getNotNullStr(p.getStaycity()),true);
		if("".equals(temp)){
			temp = "1600";
		}
		//现所在地-省
		if("00".equals(temp.substring(2,4))){
			pbi.setLocation_p(StringUtil.parseInt(temp));
		}else{
			pbi.setLocation_p(StringUtil.parseInt(temp.substring(0,2)+"00"));
			pbi.setLocation_c(StringUtil.parseInt(temp));
		}
		pbi.setContact1(1);
		pbi.setContact2(0);
		
		pbi.setPhone("");
		pbi.setHiddenphone(0);
		pbi.setMobile(StringUtil.getNotNullStr(p.getPhone()));
		pbi.setHiddenmobile(0);
		pbi.setEmail(StringUtil.getNotNullStr(p.getEmail()));
		pbi.setHiddenemail(0);
		pbi.setIm(null);
		pbi.setAddress(StringUtil.getNotNullStr(p.getAddress()));
		pbi.setZipcode(StringUtil.getNotNullStr(p.getZipcode()));
		
		temp = imap.getJob5156Code(imap.DegreeT,StringUtil.getNotNullStr(p.getEdulevel1()),true);
		if("".equals(temp)){
			temp = "0";
		}	
		pbi.setHighdegree(StringUtil.parseInt(temp));
		
		
		temp = imap.getJob5156Code(imap.specialT,StringUtil.getNotNullStr(p.getSpecialityname1()),true);			
		pbi.setSpecial(StringUtil.getNotNullStr(temp));
		
		pbi.setSchool(StringUtil.getNotNullStr(p.getEduuniv1()));
		pbi.setHomepage("");
		pbi.setCre_date(StringUtil.getNotNullStr(p.getRegistertime()));
		pbi.setRev_date(DateUtil.getNowDateTime());
		pbi.setFre_date(DateUtil.getNowDateTime());
		
		if(isPass(p)){
			pbi.setPass(1);//后期在定 状态
			sum++;
		}else{
			pbi.setPass(2);//后期在定 状态
		}
		
		
		
		pbi.setFlag(2);
		pbi.setReadcount(0);
		pbi.setLogincount(0);
		pbi.setResume_set(0);
		pbi.setSelfappraise(StringUtil.getNotNullStr(p.getAboutself()));
		
		temp = StringUtil.getNotNullStr(p.getStartworkdate());
		
		int year1 = 0;
		int month1 = 0;
		if(6 == temp.length()){
			year1 = StringUtil.parseInt(temp.substring(0,4));
			month1 = StringUtil.parseInt(temp.substring(4,6));
		}else{
			year1 = StringUtil.parseInt(temp.substring(0,4));
			month1 = StringUtil.parseInt(temp.substring(4,5));
			
		}		
		
		
		
		Date nowDate = new Date();
		int year2 = StringUtil.parseInt(nowDate.getYear())+1900;
		int month2 = StringUtil.parseInt(nowDate.getMonth())+1;
		int[] obj = new int[2];
		if(month2<month1){
			year2 = year2 -1;
			month2 = month2+12;
			obj[0] = (year2 - year1);
			obj[1] = (month2 - month1);
		}else{
			obj[0] = (year2 - year1);
			obj[1] = (month2 - month1);
		}
		
		pbi.setJobyear(obj[0]);
		pbi.setJobmonth(obj[1]);
		
		pbi.setJobcount(1);
		pbi.setResumetype(3);
		
		pbi.setComid(null);
		pbi.setResume_grade(0);
		pbi.setLasteditby(null);
		pbi.setLastedit(DateUtil.getNowDateTime());
		pbi.setPassdate(null);
		pbi.setComefrom(10);
		pbi.setHavephoto(0);
		pbi.setIp(null);
		pbi.setEmailwilling(1);
		pbi.setChangeresumewilling(1);
		pbi.setVipMember(0);
		pbi.setReceiveShortMsg(0);
		pbi.setMenu("");
		pbi.setRecommendName(null);
		pbi.setRecommendPhone(null);
		pbi.setAdduserid(0);
		pbi.setPerfectInfo("");
		pbi.setOpenResumeEn(0);
		pbi.setPolitical(0);
		return pbi;
	}
	
	public static boolean isTrue(String email,Session session29){
		boolean flag = true;
		if("".equals(email)){
			flag = false;
			return flag;
		}		
		String hql = "SELECT COUNT(p.id) FROM PersonBaseInfo p WHERE p.email = '"+email+"'";
		int num = EntityManager.getAllEntityNumberByHql(hql, session29);
		if(num > 0){
			flag = false;
		}
		return flag;
	}
	
	public static void saveDate(Session session29,List list){
		Object[] obj = new Object[list.size()];
				
		for(int j=0;j<list.size();j++){
			obj[j]=list.get(j);
		}
		
		EntityManager.batchSave(obj, session29);
		session29.flush();
		session29.clear();
		obj = null;
	}
	
	public static boolean isPass(person p){
		InputMap imap = new InputMap();
		boolean flag = true;
		String temp1 = "";
		String temp2 = "";
		String temp3 = "";
		String temp4 = "";
		String temp5 = "";
		
		//主要联系方式不能为空 或 长度不能小于 7
		if(flag){
			temp1 = StringUtil.getNotNullStr(p.getPhone());
			if("".equals(temp1) || temp1.length()<7){
				flag = false;
			}
		}
		
		//1、学校名称、毕业时间、专业、学历不能为空
		if(flag){
			temp1 = StringUtil.getNotNullStr(p.getEduuniv1());
			temp2 = StringUtil.getNotNullStr(imap.getJob5156Code(imap.DegreeT,StringUtil.getNotNullStr(p.getEdulevel1()),true));
			temp3 = StringUtil.getNotNullStr(p.getEdudate1());
			temp4 = StringUtil.getNotNullStr(imap.getJob5156Code(imap.specialT,StringUtil.getNotNullStr(p.getSpecialityname1()),true));
			if("".equals(temp1) && "".equals(temp2) && "".equals(temp3) && "".equals(temp4)){
				flag = false;
			}
		}
		//1、职位名称 和 工作简历 必须有一个不能为空
		if(flag){
			temp1 = StringUtil.getNotNullStr(p.getWorklist());
			temp2 = StringUtil.getNotNullStr(p.getTechpostname());
			if("".equals(temp1) && "".equals(temp2)){
				flag = false;
			}			
		}
		
		if(flag){
			temp1 = StringUtil.getNotNullStr(p.getWorklist());
			temp2 = StringUtil.getNotNullStr(p.getTechpostname());
			if("".equals(temp1) && ("未填写无其他".indexOf(temp2)!=-1)){
				flag = false;
			}			
		}
		
		//求职意向 3个 必须有一个 不能为 其他。
//		if(flag){
//			temp1 = imap.getJob5156Code(imap.JobfunctionT,StringUtil.getNotNullStr(p.getJobposition1()),true); 
//			temp2 = imap.getJob5156Code(imap.JobfunctionT,StringUtil.getNotNullStr(p.getJobposition2()),true); 
//			temp3 = imap.getJob5156Code(imap.JobfunctionT,StringUtil.getNotNullStr(p.getJobposition3()),true); 
//			if(!"".equals(temp1) || !"".equals(temp2) || !"".equals(temp3)){
//				if(!"99".equals(temp1.substring(3,4)) || !"99".equals(temp2.substring(3,4)) || !"99".equals(temp3.substring(3,4))){
//					flag = false;
//				}
//			}
//		}	
		if(flag){
			if("".equals(temp1) && "" .equals(temp2) && "".equals(temp3)){
				flag = false;
			}
		}
		return flag;
	}
	
	public static boolean isTureAccount(person p,Session session29){
		boolean flag = true;
		String hql = "SELECT COUNT(p.id) FROM PersonBaseInfo p WHERE p.useraccounts = '"+p.getUname() + "' and p.userpassword = '" + p.getPwd()+"'";
		int num = 0;		
		System.out.println("num="+num);
		num = EntityManager.getAllEntityNumberByHql(hql, session29);
		if(num > 0){
			flag = false;
		}
		return flag;
	}
}
