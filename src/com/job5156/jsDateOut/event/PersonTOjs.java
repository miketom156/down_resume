package com.job5156.jsDateOut.event;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.job5156.jsDateJoin.entity.PersonBaseInfo;
import com.job5156.jsDateJoin.entity.PersonIntent;
import com.job5156.jsDateJoin.entity.PersonSchool;
import com.job5156.jsDateJoin.entity.PersonSkill;
import com.job5156.jsDateJoin.entity.PersonWork;
import com.job5156.jsDateJoin.event.InputMap;
import com.job5156.server.EntityManager;
import com.job5156.server.SessionManager;
import com.job5156.util.DateUtil;
import com.job5156.util.StringUtil;

public class PersonTOjs {
	private static Logger log = Logger.getLogger(PersonTOjs.class);
	
	public static void main(String[] args) {		
		System.out.println("----------江苏人才网 企业基本数据和职位 导入本地数据库 开始！--------------");
		long begintime = System.currentTimeMillis();		
		Session session29  = SessionManager.currentSession();
		
		//主程序运行		
		//南京数据添加
		runAdd(session29);
		//南京数据修改
		//runUpdate(session29);
		
		session29.close();		
		long endtime = System.currentTimeMillis();
		System.out.println("----------江苏人才网 企业基本数据和职位 导入本地数据库 结束！用时："+(endtime - begintime)/1000/60+" 分钟");
		log.error("江苏人才网 企业基本数据和职位 导入数据库 用时："+(endtime - begintime)/1000/60+" 分钟");
	}
	
	public static boolean isTrue(Connection conn,PreparedStatement pstmt,String email) throws SQLException{
		boolean flag = true;
		
		ResultSet rs = null;
		String sql = "select count(*) from usersp where email = '"+email+"'";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		rs.next();
		int num = rs.getInt(1);		
		if(num > 0){
			flag = false;
		}
		return flag;
	}
	
	
	
	public static void runAdd(Session session29){
		Connection con = null;
		try {
			//江苏人才网链接字符串
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// 此处加载驱动，必须的
			con = DriverManager.getConnection(
					"jdbc:sqlserver://218.94.11.46:1433;DatabaseName=rc",
					"njzt", "njztnjztnjzt");
			PreparedStatement pstmt = null;
		
				String nowDate = DateUtil.getNowDate();
				String hqlCount = "SELECT COUNT(p.id) FROM PersonBaseInfo p where p.useraccounts = 'jiuzhou1986@163.com'";
				String hql = "SELECT p FROM PersonBaseInfo p where p.useraccounts = 'jiuzhou1986@163.com'";
				
				
//				String hqlCount = "SELECT COUNT(p.id) FROM PersonBaseInfo p where p.cre_date >= '"+nowDate+" 00:00:00' and p.cre_date <'"+nowDate+" 23:59:59' and ( p.location_p = 1601 or p.location_c = 1601 ) order by p.id";
//				String hql = "SELECT p FROM PersonBaseInfo p where p.cre_date >= '"+nowDate+" 00:00:00' and p.cre_date <'"+nowDate+" 23:59:59' and ( p.location_p = 1601 or p.location_c = 1601 ) order by p.id";

				
				
				int allRecord = EntityManager.getAllEntityNumberByHql(hqlCount, session29);
				int dataLoadNumber = 2000;
				int allPage = allRecord > 0 ? 1 : 0;
				if(allRecord > dataLoadNumber){
					allPage = allRecord / dataLoadNumber + ((allRecord % dataLoadNumber == 0) ? 0 : 1);
				}
				
				for(int m=0; m<allPage; m++){
					System.out.println("公司基本信息 第"+m+"页");
					
					List list = EntityManager.getEntityByHqlAndStartRecords(hql, session29, m*dataLoadNumber, dataLoadNumber);
					if(list != null && list.size() > 0){
						for(int i=0; i<list.size(); i++){
							String sql = "";
							PersonBaseInfo pbi = (PersonBaseInfo)list.get(i);
							int id = StringUtil.parseInt(pbi.getId());
							if(isTrue(con,pstmt,StringUtil.getNotNullStr(pbi.getEmail()))){
								sql = getSqlAdd();
							}else{
								sql = getSqlUpdate(StringUtil.getNotNullStr(pbi.getEmail()));
							}
							
							saveOrUpdate(con,pstmt,pbi,id,sql,session29);							
						}				
					}
				}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{				
				if(con != null){
					con.close();
					con = null;
				}
				
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}		
	}
	
	public static void runUpdate(Session session29){
		Connection con = null;
		try {
			//江苏人才网链接字符串
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// 此处加载驱动，必须的
			con = DriverManager.getConnection(
					"jdbc:sqlserver://218.94.11.46:1433;DatabaseName=rc",
					"njzt", "njztnjztnjzt");
			PreparedStatement pstmt = null;
		
				String nowDate = DateUtil.getNowDate();
				
				String hqlCount = "SELECT COUNT(p.id) FROM PersonBaseInfo p where p.useraccounts = 'jiuzhou1986@163.com'";
				String hql = "SELECT p FROM PersonBaseInfo p where p.useraccounts = 'jiuzhou1986@163.com'";
				
				
//				String hqlCount = "SELECT COUNT(p.id) FROM PersonBaseInfo p where p.lastedit >= '"+nowDate+" 00:00:00' and p.lastedit <'"+nowDate+" 23:59:59' and ( p.location_p = 1601 or p.location_c = 1601 ) order by p.id";
//				String hql = "SELECT p FROM PersonBaseInfo p where p.lastedit >= '"+nowDate+" 00:00:00' and p.lastedit <'"+nowDate+" 23:59:59' and ( p.location_p = 1601 or p.location_c = 1601 ) order by p.id";
				
				int allRecord = EntityManager.getAllEntityNumberByHql(hqlCount, session29);
				int dataLoadNumber = 2000;
				int allPage = allRecord > 0 ? 1 : 0;
				if(allRecord > dataLoadNumber){
					allPage = allRecord / dataLoadNumber + ((allRecord % dataLoadNumber == 0) ? 0 : 1);
				}
				
				for(int m=0; m<allPage; m++){
					System.out.println("公司基本信息 第"+m+"页");
					
					List list = EntityManager.getEntityByHqlAndStartRecords(hql, session29, m*dataLoadNumber, dataLoadNumber);
					if(list != null && list.size() > 0){
						for(int i=0; i<list.size(); i++){
							String sql = "";
							PersonBaseInfo pbi = (PersonBaseInfo)list.get(i);
							int id = StringUtil.parseInt(pbi.getId());
							if(isTrue(con,pstmt,StringUtil.getNotNullStr(pbi.getEmail()))){
								sql = getSqlAdd();
							}else{
								sql = getSqlUpdate(StringUtil.getNotNullStr(pbi.getEmail()));
							}							
							saveOrUpdate(con,pstmt,pbi,id,sql,session29);							
						}				
					}
				}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{				
				if(con != null){
					con.close();
					con = null;
				}
				
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}		
	}
	
	public static String getSqlAdd(){
		String sql = "insert into usersp(realname,uname,pwd,pwdquestion,pwdanswer,cardtype,cardno,sex,birthday,nation,politics,marriage,homecity,staycity,"+
			"height,eyesight,edulevel1,eduuniv1,edudate1,specialitytype1,specialityname1,edulevel2,eduuniv2,edudate2,"+
			"specialitytype2,specialityname2,techposttype,techpostname,nowunit,startworkdate,computerlevel,typingspeed,foreign1,foreignlevel1,"+
			"foreign2,foreignlevel2,mandarinlevel,drivelicense,specialty,jobcause,jobform,jobposition1,jobposition2,jobposition3,monthlypay,"+			
			"jobcity,canout,needhouse,unittype,otherneed,edulist,worklist,aboutself,address,zipcode,phone,email,secretsetting,visitcount,"+
			"state,archiveno,type,lastlogintime,highlevel,locked,specialityinput1,specialityinput2,registertime) " +
		    "values(?, ?, ?, ?, ?,  ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		System.out.println(sql);
		return sql;
		
	}
	
	public static String getSqlUpdate(String email){
		String sql = "update usersp set realname=?,uname=?,pwd=?,pwdquestion=?,pwdanswer=?,cardtype=?,cardno=?,sex=?,birthday=?,nation=?,politics=?,marriage=?,homecity=?,staycity=?,"+
			"height=?,eyesight=?,edulevel1=?,eduuniv1=?,edudate1=?,specialitytype1=?,specialityname1=?,edulevel2=?,eduuniv2=?,edudate2=?,"+
			"specialitytype2=?,specialityname2=?,techposttype=?,techpostname=?,nowunit=?,startworkdate=?,computerlevel=?,typingspeed=?,foreign1=?,foreignlevel1=?,"+
			"foreign2=?,foreignlevel2=?,mandarinlevel=?,drivelicense=?,specialty=?,jobcause=?,jobform=?,jobposition1=?,jobposition2=?,jobposition3=?,monthlypay=?,"+			
			"jobcity=?,canout=?,needhouse=?,unittype=?,otherneed=?,edulist=?,worklist=?,aboutself=?,address=?,zipcode=?,phone=?,email=?,secretsetting=?,visitcount=?,"+
			"state=?,archiveno=?,type=?,lastlogintime=?,highlevel=?,locked=?,specialityinput1=?,specialityinput2=?,registertime=?"
			 + " where email = '"+email+"'";
		System.out.println(sql);
		return sql;
		
	}
	
	public static List getPSList(int id,Session session29){
		String hql = "select p from PersonSchool p where p.userid="+id;
		List list = EntityManager.getAllEntityByHql(hql, session29);
		return list;
	}
	public static List getPWList(int id,Session session29){
		String hql = "select p from PersonWork p where p.userid="+id;
		List list = EntityManager.getAllEntityByHql(hql, session29);
		return list;
	}
	public static PersonIntent getPI(int id,Session session29){
		String hql = "select p from PersonIntent p where p.userid="+id;
		PersonIntent pit = (PersonIntent)EntityManager.getFirstEntityByHql(hql, session29);
		return pit;
	}
	
	public static PersonSkill getPsk(int id,Session session29){
		String hql = "select p from PersonSkill p where p.userid="+id;
		PersonSkill psk = (PersonSkill)EntityManager.getFirstEntityByHql(hql, session29);
		return psk;
	}
	
	
	public static void saveOrUpdate(Connection con,PreparedStatement pstmt,PersonBaseInfo pbi,int id,String sql,Session session29) throws SQLException{
		PersonIntent pit = getPI(id,session29);
		PersonSkill psk = getPsk(id,session29);
		List psList = getPSList(id,session29);
		List pwList = getPWList(id,session29);		
		
//		PersonWork pw = (PersonWork)EntityManager.getEntityInstanceById(PersonWork.class, id, session29);
//		PersonSchool psl = (PersonSchool)EntityManager.getEntityInstanceById(PersonSchool.class, id, session29);
		if(pbi != null || pit != null || psk != null || psList.size() != 0 || pwList.size() != 0){
			
			PersonSchool psl = (PersonSchool)psList.get(0);			
			PersonWork pw = (PersonWork)pwList.get(0);
			try{
				pstmt = con.prepareStatement(sql);
				
				String temp = "";
				String[] obj = null;
				pstmt.setString(1, StringUtil.getNotNullStr(pbi.getUsername()));
				pstmt.setString(2, StringUtil.getNotNullStr(pbi.getUseraccounts()));
//				pstmt.setString(2, "j123321");
				pstmt.setString(3, StringUtil.getNotNullStr(pbi.getUserpassword()));
				pstmt.setString(4, "");
				pstmt.setString(5, "");
				pstmt.setString(6, InputMap.getOtherCode(InputMap.cardtypeT, StringUtil.getNotNullStr(pbi.getCardtype(),"3")));							
				pstmt.setString(7, StringUtil.getNotNullStr(pbi.getCardtypenum()));
				pstmt.setString(8, StringUtil.getNotNullStr(InputMap.getOtherCode(InputMap.sexT, StringUtil.getNotNullStr(pbi.getSex())),"0"));
				String birthday = StringUtil.getNotNullStr(pbi.getBirthday());
				obj = birthday.split("-");
				if(2<=obj.length){
					pstmt.setString(9, obj[0]+obj[1]);
				}
				temp = StringUtil.getNotNullStr(pbi.getNation());
				if(!(temp.indexOf("族")!=-1)){
					temp = temp + "族";
				}
				temp = StringUtil.getNotNullStr(InputMap.getOtherCode(InputMap.nationT, temp),"00");
				pstmt.setString(10, temp);	
				pstmt.setString(11, "");
				pstmt.setString(12, StringUtil.getNotNullStr(InputMap.getOtherCode(InputMap.marriageT, StringUtil.getNotNullStr(pbi.getMarriage())),"0"));
				
				if(!("".equals(StringUtil.getNotNullStr(pbi.getHometown_p())))){
					temp = StringUtil.getNotNullStr(pbi.getHometown_p());
				}else{
					temp = StringUtil.getNotNullStr(pbi.getHometown_c());
				}
				pstmt.setString(13, StringUtil.getNotNullStr(InputMap.getOtherCode(InputMap.cityT, temp),"0101"));
				
				if(!("".equals(StringUtil.getNotNullStr(pbi.getLocation_p())))){
					temp = StringUtil.getNotNullStr(pbi.getLocation_p());
				}else{
					temp = StringUtil.getNotNullStr(pbi.getLocation_c());
				}
				
				pstmt.setString(14, StringUtil.getNotNullStr(InputMap.getOtherCode(InputMap.cityT, temp),"0101"));
				pstmt.setString(15, StringUtil.getNotNullStr(pbi.getStature()));
				pstmt.setString(16, "");
//				pstmt.setString(17, "");							
//				pstmt.setString(18, "");
				pstmt.setString(17, StringUtil.getNotNullStr(InputMap.getOtherCode(InputMap.DegreeT, StringUtil.getNotNullStr(pbi.getHighdegree())),"99"));
				pstmt.setString(18, StringUtil.getNotNullStr(pbi.getSchool()));
				temp = StringUtil.getNotNullStr(psl.getEnddatemonth());	
				if(temp.length() == 1){
					temp = "0"+temp;
				}
				temp = StringUtil.getNotNullStr(psl.getEnddateyear()) + temp;
				pstmt.setString(19, temp);				
				pstmt.setString(20, "0");
				
				pstmt.setInt(21, StringUtil.parseInt(InputMap.getOtherCode(InputMap.specialT, pbi.getSpecial()),99));
				pstmt.setString(22, StringUtil.getNotNullStr(InputMap.getOtherCode(InputMap.DegreeT, StringUtil.getNotNullStr(pbi.getHighdegree())),"99"));
				pstmt.setString(23, StringUtil.getNotNullStr(pbi.getSchool()));
				temp = StringUtil.getNotNullStr(psl.getEnddatemonth());	
				if(temp.length() == 1){
					temp = "0"+temp;
				}
				temp = StringUtil.getNotNullStr(psl.getEnddateyear()) + temp;
				pstmt.setString(24, temp);							
				pstmt.setString(25, "0");
				pstmt.setInt(26, StringUtil.parseInt(InputMap.getOtherCode(InputMap.specialT, pbi.getSpecial()),99));
				pstmt.setString(27, "05");
				pstmt.setString(28, StringUtil.getNotNullStr(pw.getOtherposition()));
				
				pstmt.setString(29, StringUtil.getNotNullStr(pw.getComname()));
				
				temp = StringUtil.getNotNullStr(pw.getBegindatemonth());	
				if(temp.length() == 1){
					temp = "0"+temp;
				}
				temp = StringUtil.getNotNullStr(pw.getBegindateyear()) + temp;
				
				pstmt.setString(30, temp);
				pstmt.setString(31, StringUtil.getNotNullStr(InputMap.getOtherCode(InputMap.computerT, StringUtil.getNotNullStr(psk.getComputerlevel())),"4"));
				pstmt.setString(32, "");
				pstmt.setString(33, InputMap.getOtherCode(InputMap.languageT, StringUtil.getNotNullStr(psk.getLanguage1())));
				pstmt.setString(34, "4");							
				pstmt.setString(35, InputMap.getOtherCode(InputMap.languageT, StringUtil.getNotNullStr(psk.getLanguage2())));
				pstmt.setString(36, "4");
				pstmt.setString(37, "");
				pstmt.setString(38, "");
				
				pstmt.setString(39, StringUtil.getNotNullStr(psk.getOtherskills()));
				pstmt.setInt(40, StringUtil.parseInt(InputMap.getOtherCode(InputMap.JobCauseT, StringUtil.getNotNullStr(pw.getLeftreason())),0));
				pstmt.setString(41, "");
				pstmt.setString(42, StringUtil.getNotNullStr(InputMap.getOtherCode(InputMap.JobfunctionT, StringUtil.getNotNullStr(pit.getJobcode1())),"22"));
				pstmt.setString(43, StringUtil.getNotNullStr(InputMap.getOtherCode(InputMap.JobfunctionT, StringUtil.getNotNullStr(pit.getJobcode2())),"22"));
				pstmt.setString(44, StringUtil.getNotNullStr(InputMap.getOtherCode(InputMap.JobfunctionT, StringUtil.getNotNullStr(pit.getJobcode3())),"22"));							
				pstmt.setString(45, StringUtil.getNotNullStr(InputMap.getOtherCode(InputMap.salaryT, StringUtil.getNotNullStr(pit.getSalary())),"00"));
				pstmt.setString(46, StringUtil.getNotNullStr(InputMap.getOtherCode(InputMap.cityT, StringUtil.getNotNullStr(pit.getJoblocation1())),"0101"));
				pstmt.setString(47, "");
				pstmt.setString(48, StringUtil.getNotNullStr(pit.getNeededhouse()));
				
				pstmt.setString(49, "");
				pstmt.setString(50, StringUtil.getNotNullStr(pit.getOtherrequirement()));
				
				temp = "";
				for(int i=0;i<psList.size();i++){
					PersonSchool psl1 = (PersonSchool)psList.get(0);
					
					String beginYear = StringUtil.getNotNullStr(psl1.getBegindateyear());
					String beginMonth = StringUtil.getNotNullStr(psl1.getBegindatemonth());
					String endYear = StringUtil.getNotNullStr(psl1.getEnddateyear());
					String endMonth = StringUtil.getNotNullStr(psl1.getEnddatemonth());
					String school = StringUtil.getNotNullStr(psl1.getSchool());
					String degree = StringUtil.getNotNullStr(InputMap.getOtherCode(InputMap.DegreeT, StringUtil.getNotNullStr(psl1.getDegree(),"99")));
					String special = StringUtil.getNotNullStr(psl1.getSpeciality());
					
					temp +=beginYear+"-"+beginMonth+"至"+endYear+"-"+endMonth+"  "+school+"  "+degree +"  "+special;				
				}
				
				pstmt.setString(51, temp);  //教育经历
				temp = "";
				for(int i=0;i<pwList.size();i++){
					PersonWork pw1 = (PersonWork)pwList.get(0);
					
					String beginYear = StringUtil.getNotNullStr(pw1.getBegindateyear());
					String beginMonth = StringUtil.getNotNullStr(pw1.getBegindatemonth());
					String endYear = StringUtil.getNotNullStr(pw1.getEnddateyear());
					String endMonth = StringUtil.getNotNullStr(pw1.getEnddatemonth());
					String comName = StringUtil.getNotNullStr(pw1.getComname());
					String positionName = StringUtil.getNotNullStr(pw1.getOtherposition());
					temp += beginYear+"-"+beginMonth+"至"+endYear+"-"+endMonth+"  "+ comName + " "+positionName + StringUtil.getNotNullStr(pw1.getDescription());
					
					
				}
				
				pstmt.setString(52, temp);  //工作经历
				pstmt.setString(53, StringUtil.getNotNullStr(pbi.getSelfappraise()));  
				pstmt.setString(54, StringUtil.getNotNullStr(pbi.getAddress()));							
				pstmt.setString(55, StringUtil.getNotNullStr(pbi.getZipcode()));
				pstmt.setString(56, StringUtil.getNotNullStr(pbi.getMobile()));
				pstmt.setString(57, StringUtil.getNotNullStr(pbi.getEmail()));
				pstmt.setString(58, "");
				
				pstmt.setString(59, "");
				pstmt.setString(60, "");
				pstmt.setString(61, "");
				pstmt.setString(62, "");
				pstmt.setString(63, DateUtil.getNowDate());
				pstmt.setString(64, "");							
				pstmt.setString(65, "");
				pstmt.setString(66, StringUtil.getNotNullStr(pbi.getSpecial()));
				pstmt.setString(67, StringUtil.getNotNullStr(pbi.getSpecial()));
				pstmt.setString(68, DateUtil.getNowDate());
				System.out.println(pstmt);
				//System.out.println(pstmt.getConnection());
				pstmt.executeUpdate();	
			}catch(Exception e1){
				e1.printStackTrace();
				try{				
					if(pstmt != null){
						pstmt.close();
						pstmt = null;
					}
					
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		}
	}
}
