package com.job5156.jsDateJoin.event;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.job5156.jsDateJoin.entity.person;
import com.job5156.server.EntityManager;
import com.job5156.server.LocalSessionManager;
import com.job5156.util.StringUtil;

public class sqlTomysql {
	
	private static Logger log = Logger.getLogger(InputPostionTO29.class);

	public static void main(String[] args) {
		System.out.println("----------江苏人才网 个人sqltomysql 导入本地数据库 开始！--------------");
		long begintime = System.currentTimeMillis();
		Session localsession  = LocalSessionManager.currentSession();
		
		run(localsession);
		
		localsession.close();
		long endtime = System.currentTimeMillis();
		System.out.println("----------江苏人才网 个人sqltomysql 导入本地数据库 结束！用时："+(endtime - begintime)/1000/60+" 分钟");
		log.error("江苏人才网 企业基本数据和职位 导入数据库 用时："+(endtime - begintime)/1000/60+" 分钟");
	}
	
	public static void run(Session localsession){
		Connection con = null;
		try {
			//江苏人才网链接字符串
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// 此处加载驱动，必须的
			con = DriverManager.getConnection(
					"jdbc:sqlserver://218.94.11.46:1433;DatabaseName=rc",
					"njzt", "njztnjztnjzt");
			
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// 此处加载驱动，必须的
//			con = DriverManager.getConnection(
//					"jdbc:sqlserver://CHITONE-486:1433;DatabaseName=test11",
//					"sa", "123");
			
			
			int allRecord = getRecordCount(con);
			int dataLoadNumber = 2000;
			int allPage = allRecord > 0 ? 1 : 0;
			if(allRecord > dataLoadNumber){
				allPage = allRecord / dataLoadNumber + ((allRecord % dataLoadNumber == 0) ? 0 : 1);
			}
			//allPage = 1;
			
			for(int m=49; m<allPage; m++){
				System.out.println("sqlToMysql 第"+m+"页");
				List list = getResumeData(localsession,con,dataLoadNumber,m*dataLoadNumber);
				if(list != null && list.size()>0){
					//批量保存
					saveDate(localsession,list);					
				}
				list.clear();
				localsession.flush();
				localsession.clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("失败");
		}
	}
	
	public static void saveDate(Session localsession,List list){
		if(list != null && list.size()>0){
			Object[] obj = new Object[list.size()];
			
			for(int j=0;j<list.size();j++){
				obj[j]=list.get(j);
			}
			
			EntityManager.batchSave(obj, localsession);
			localsession.flush();
			localsession.clear();
			obj = null;
		}
		
	}
	
	public static List getResumeData(Session localsession,Connection con, int dataLoadNumber, int m){
		List list = new ArrayList();
		Statement st = null;
		ResultSet rs = null;
		try{
			String sql = "select top "+dataLoadNumber+
			" id,realname,uname,pwd,pwdquestion,pwdanswer,cardtype,cardno,sex,birthday,nation,politics,marriage,homecity,staycity,"+
			"height,eyesight,photo,photo1,edulevel1,eduuniv1,edudate1,specialitytype1,specialityname1,edulevel2,eduuniv2,edudate2,"+
			"specialitytype2,specialityname2,techposttype,techpostname,nowunit,startworkdate,computerlevel,typingspeed,foreign1,foreignlevel1,"+
			"foreign2,foreignlevel2,mandarinlevel,drivelicense,specialty,jobcause,jobform,jobposition1,jobposition2,jobposition3,monthlypay,"+
			"jobcity,canout,needhouse,unittype,otherneed,edulist,worklist,aboutself,address,zipcode,phone,email,secretsetting,visitcount,"+
			"state,archiveno,type,lastlogintime,highlevel,locked,specialityinput1,specialityinput2,registertime " +
			"from usersp where id not in(select top "+m+" id from usersp) order by id asc";
			System.out.println(sql);
			st = con.createStatement();
			rs = st.executeQuery(sql);
			int w = 0;
			if(rs != null){
				while(rs.next()){
					w++;
					System.out.println("sqlToMysql 第"+w+"条");
					String email = StringUtil.getNotNullStr(rs.getString("email"));
					if(countEmail(email,localsession)){
						person p = new person();
						p.setPid(StringUtil.parseInt(rs.getInt("id")));
						p.setRealname(StringUtil.getNotNullStr(rs.getString("realname")));
						p.setUname(StringUtil.getNotNullStr(rs.getString("uname")));
						p.setPwd(StringUtil.getNotNullStr(rs.getString("pwd")));
						//p.setPwdquestion(StringUtil.getNotNullStr(rs.getString("pwdquestion")));
						p.setCardtype(StringUtil.getNotNullStr(rs.getString("cardtype")));
						p.setCardno(StringUtil.getNotNullStr(rs.getString("cardno")));
						p.setSex(StringUtil.getNotNullStr(rs.getString("sex")));
						p.setBirthday(StringUtil.getNotNullStr(rs.getString("birthday")));
						p.setNation(StringUtil.getNotNullStr(rs.getString("nation")));
						p.setPolitics(StringUtil.getNotNullStr(rs.getString("politics")));
						p.setMarriage(StringUtil.getNotNullStr(rs.getString("marriage")));
						p.setHomecity(StringUtil.getNotNullStr(rs.getString("homecity")));
						p.setStaycity(StringUtil.getNotNullStr(rs.getString("staycity")));
						p.setHeight(StringUtil.getNotNullStr(rs.getString("height")));
						p.setEyesight(StringUtil.getNotNullStr(rs.getString("eyesight")));
						p.setPhoto(StringUtil.getNotNullStr(rs.getString("photo")));
						//p.setPhone(phone)
						p.setEdulevel1(StringUtil.getNotNullStr(rs.getString("edulevel1")));
						p.setEduuniv1(StringUtil.getNotNullStr(rs.getString("eduuniv1")));
						p.setEdudate1(StringUtil.getNotNullStr(rs.getString("edudate1")));
						p.setSpecialitytype1(StringUtil.getNotNullStr(rs.getString("specialitytype1")));
						p.setSpecialityname1(StringUtil.getNotNullStr(rs.getString("specialityname1")));
						p.setEdulevel2(StringUtil.getNotNullStr(rs.getString("edulevel2")));
						p.setEduuniv2(StringUtil.getNotNullStr(rs.getString("eduuniv2")));
						p.setEdudate2(StringUtil.getNotNullStr(rs.getString("edudate2")));
						p.setSpecialitytype2(StringUtil.getNotNullStr(rs.getString("specialitytype2")));
						p.setSpecialityname2(StringUtil.getNotNullStr(rs.getString("specialityname2")));
						p.setTechposttype(StringUtil.getNotNullStr(rs.getString("techposttype")));
						p.setTechpostname(StringUtil.getNotNullStr(rs.getString("techpostname")));
						p.setNowunit(StringUtil.getNotNullStr(rs.getString("nowunit")));
						
						String temp = StringUtil.getNotNullStr(rs.getString("startworkdate"));
						if(!"190001".equals(temp)){
							p.setStartworkdate(temp);//参加工作时间
						}else{
							p.setStartworkdate("201107");//参加工作时间
						}
						
						//p.setStartworkdate(StringUtil.getNotNullStr(rs.getString("startworkdate")));
						p.setComputerlevel(StringUtil.getNotNullStr(rs.getString("computerlevel")));
						p.setTypingspeed(StringUtil.getNotNullStr(rs.getString("typingspeed")));
						p.setForeign1(StringUtil.getNotNullStr(rs.getString("foreign1")));
						p.setForeignlevel1(StringUtil.getNotNullStr(rs.getString("foreignlevel1")));
						p.setForeign2(StringUtil.getNotNullStr(rs.getString("foreign2")));
						p.setForeignlevel2(StringUtil.getNotNullStr(rs.getString("foreignlevel2")));
						p.setMandarinlevel(StringUtil.getNotNullStr(rs.getString("mandarinlevel")));
						p.setDrivelicense(StringUtil.getNotNullStr(rs.getString("drivelicense")));
						p.setSpecialty(StringUtil.getNotNullStr(rs.getString("specialty")));
						p.setJobcause(StringUtil.getNotNullStr(rs.getString("jobcause")));
						p.setJobform(StringUtil.getNotNullStr(rs.getString("jobform")));
						p.setJobposition1(StringUtil.getNotNullStr(rs.getString("jobposition1")));
						p.setJobposition2(StringUtil.getNotNullStr(rs.getString("jobposition2")));
						p.setJobposition3(StringUtil.getNotNullStr(rs.getString("jobposition3")));
						p.setMonthlypay(StringUtil.getNotNullStr(rs.getString("monthlypay")));
						p.setJobcity(StringUtil.getNotNullStr(rs.getString("jobcity")));
						p.setCanout(StringUtil.getNotNullStr(rs.getString("canout")));
						p.setNeedhouse(StringUtil.getNotNullStr(rs.getString("needhouse")));
						p.setUnittype(StringUtil.getNotNullStr(rs.getString("unittype")));
						p.setOtherneed(StringUtil.getNotNullStr(rs.getString("otherneed")));
						//教育经历不需要
						//p.setEdulist(StringUtil.getNotNullStr(rs.getString("edulist")));
						p.setWorklist(StringUtil.getNotNullStr(rs.getString("worklist")));
						p.setAboutself(StringUtil.getNotNullStr(rs.getString("aboutself")));
						p.setAddress(StringUtil.getNotNullStr(rs.getString("address")));
						p.setZipcode(StringUtil.getNotNullStr(rs.getString("zipcode")));
						p.setPhone(StringUtil.getNotNullStr(rs.getString("phone")));
						p.setEmail(email);
						p.setSecretsetting(StringUtil.getNotNullStr(rs.getString("secretsetting")));
						p.setVisitcount(StringUtil.getNotNullStr(rs.getString("visitcount")));
						p.setState(StringUtil.getNotNullStr(rs.getString("state")));
						p.setArchiveno(StringUtil.getNotNullStr(rs.getString("archiveno")));
						p.setType(StringUtil.getNotNullStr(rs.getString("type")));
						p.setLastlogintime(StringUtil.getNotNullStr(rs.getString("lastlogintime")));
						p.setHighlevel(StringUtil.getNotNullStr(rs.getString("highlevel")));
						p.setLocked(StringUtil.getNotNullStr(rs.getString("locked")));
						p.setSpecialityinput1(StringUtil.getNotNullStr(rs.getString("specialityinput1")));
						p.setSpecialityinput2(StringUtil.getNotNullStr(rs.getString("specialityinput2")));
						p.setRegistertime(StringUtil.getNotNullStr(rs.getString("registertime")));
						
						list.add(p);
						p = null;
					}										
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs != null){
					rs.close();
					rs = null;
				}
				if(st != null){
					st.close();
					st = null;
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return list;
	}
	
	public static boolean countEmail(String email,Session localsession){
		boolean flag = true;
		String hql = "select count(p.id) from person p where p.email = '"+email+"'";
		int num = EntityManager.getAllEntityNumberByHql(hql, localsession);
		if(num > 0){
			flag = false;
		}
		System.out.println(flag);
		return flag;
	}
	
	public static int getRecordCount(Connection con){
		int count = 0;
		Statement st = null;
		ResultSet rs = null;
		try{
//			String sql = "select count(*) from NingBo where id>332000";
			String sql = "select count(*) from usersp";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs != null){
				while(rs.next()){
					count = rs.getInt(1);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs != null){
					rs.close();
					rs = null;
				}
				if(st != null){
					st.close();
					st = null;
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return count;
	}

}
