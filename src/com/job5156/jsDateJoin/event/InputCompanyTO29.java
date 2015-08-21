package com.job5156.jsDateJoin.event;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.job5156.jsDateJoin.entity.ComBaseInfo;
import com.job5156.jsDateJoin.entity.ComUserInfo;
import com.job5156.jsDateJoin.entity.unit;
import com.job5156.server.EntityManager;
import com.job5156.server.LocalSessionManager;
import com.job5156.server.SessionManager;
import com.job5156.util.DateUtil;
import com.job5156.util.StringUtil;


public class InputCompanyTO29 {
	private static Logger log = Logger.getLogger(InputCompanyTO29.class);
	
	
	public static void main(String[] args) {
		//InputMap iMap = new InputMap();
		//String temp = iMap.getJob5156Code(InputMap.sexT, "1", true);
		System.out.println("----------江苏人才网 企业基本数据和职位 导入本地数据库 开始！--------------");
		long begintime = System.currentTimeMillis();
		Session localsession  = LocalSessionManager.currentSession();
		Session session29  = SessionManager.currentSession();
		runCompanyDate(localsession,session29);
		session29.close();
		localsession.close();
		long endtime = System.currentTimeMillis();
		System.out.println("----------江苏人才网 企业基本数据和职位 导入本地数据库 结束！用时："+(endtime - begintime)/1000/60+" 分钟");
		log.error("江苏人才网 企业基本数据和职位 导入数据库 用时："+(endtime - begintime)/1000/60+" 分钟");
		
		
	}
	
	public static void runCompanyDate(Session localsession,Session session29){
		String hqlCount = "SELECT COUNT(u.id) FROM unit u order by u.id";
		String hql = "SELECT u FROM unit u order by u.id";
		
		int allRecord = EntityManager.getAllEntityNumberByHql(hqlCount, localsession);
		int dataLoadNumber = 2000;
		int allPage = allRecord > 0 ? 1 : 0;
		if(allRecord > dataLoadNumber){
			allPage = allRecord / dataLoadNumber + ((allRecord % dataLoadNumber == 0) ? 0 : 1);
		}
		
		for(int m=5; m<allPage; m++){
			System.out.println("公司基本信息 第"+m+"页");
			//List listCBI = new ArrayList();//企业 ComBaseInfo 导入 的List
			int k = 0;
			List list = EntityManager.getEntityByHqlAndStartRecords(hql, localsession, m*dataLoadNumber, dataLoadNumber);
			if(list != null && list.size() > 0){
				for(int i=0; i<list.size(); i++){
					//数据处理
					unit u = (unit)list.get(i);					
					String name = StringUtil.getNotNullStr(u.getName());
					boolean flag = isTrue(name,1,session29);
					
					if(flag){
						try{
							//企业 ComBaseInfo 导入
							System.out.println("公司基本信息 第"+i+"条");
							ComBaseInfo cbi = getCBI(u);
							EntityManager.saveEntity(cbi, session29);
							int comID = StringUtil.parseInt(cbi.getId());
							
							//企业 ComUserInfo 导入
							ComUserInfo cui = getCUI(u,comID,session29);
							EntityManager.saveEntity(cui, session29);
							k++;
							if(k>100){
								session29.clear();
								k=0;
							}							
						}catch(Exception e){
							e.printStackTrace();
							log.error("导入的江苏人才网数据的 第"+ m*dataLoadNumber+i+"出了问题！");
						}
						
					}
					
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
		}
	}
	
	public static ComUserInfo getCUI(unit u,int comID,Session session29){
		ComUserInfo c = new ComUserInfo();
		c.setComid(comID);
		c.setDeptid(0);
		boolean flag = isChince(StringUtil.getNotNullStr(u.getUname()));
		boolean flag1 = isTrueAccount(u,session29);
		if(flag && flag1){
			c.setUsername(StringUtil.getNotNullStr(u.getUname()));
			
		}else{
			c.setUsername("job5156"+comID);
			
		}				
		c.setPassword(StringUtil.getNotNullStr(u.getPwd()));
		System.out.println(c.getUsername()+"  "+c.getPassword());
		c.setIsadmin(true);
		c.setRegisterdate(StringUtil.getNotNullStr(u.getRegistertime()));
		c.setUpdatedate(DateUtil.getNowDateTime());
		c.setLastLogindate(StringUtil.getNotNullStr(u.getLastlogintime()));
		c.setLoginnum(0);
		c.setMenu(null);
		c.setSafeSet(0);
		c.setUsedNum(0);
		c.setIsCount(0);
		c.setCountPosNum(0);	
		return c;
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
	
	public static ComBaseInfo getCBI(unit u){
		
		ComBaseInfo c = new ComBaseInfo();
		InputMap imap = new InputMap();
		c.setComname(StringUtil.getNotNullStr(u.getName()));  //企业名称
		c.setLicencenumber(u.getBusilicense());  //营业执照
		//对照
		int callingT = StringUtil.parseInt(imap.getJob5156Code(imap.CallingT, StringUtil.getNotNullStr(u.getUnitproperty()), true));
		c.setCalling(callingT);  //所属行业						
		c.setProperity(0);   //企业性质
		c.setFounddate("");  //成了日期
		int regfund = StringUtil.parseInt(u.getRegfund()) * 1000;
		c.setRegisterfund(StringUtil.getNotNullStr(regfund));//注册资金
		c.setCurrency("RMB");
		
		int employNumber = StringUtil.parseInt(u.getEmployeea())+StringUtil.parseInt(u.getEmployeeb())
		+ StringUtil.parseInt(u.getEmployeec())+StringUtil.parseInt(u.getEmployeed())
		+ StringUtil.parseInt(u.getEmployeee())+StringUtil.parseInt(u.getEmployeef())
		+ StringUtil.parseInt(u.getEmployeeg())+StringUtil.parseInt(u.getEmployeeg())
		+ StringUtil.parseInt(u.getEmployeeh());
		
		c.setEmployeenumber(StringUtil.getNotNullStr(employNumber)); //员工人数
		c.setCompanyintroduction(StringUtil.getNotNullStr(u.getIntro())); //企业简介
		c.setProductintroduction("");
		c.setContactperson(StringUtil.getNotNullStr(u.getLinkman()));	//联系人
		c.setContactposition(StringUtil.getNotNullStr(u.getLinkmanpost()));	//联系人的职位
		c.setContactdepartment("");//联系人部门
		c.setContacttel(StringUtil.getNotNullStr(u.getPhone()));//第一联系方式（主要联系方式）
		c.setContact1(1);//
		c.setContact2(2);//第二联系方式 
		c.setTelshowflag(0);//是否显示 第一联系方式 0：公开  1：不公开
		c.setTelshowflag2(0);//是否显示 第二联系方式 0：公开  1：不公开
		c.setContactfax(StringUtil.getNotNullStr(u.getFax()));//传真
		c.setEmail(StringUtil.getNotNullStr(u.getEmail()));//电子邮箱
		c.setEmailshowflag(0);//是否显示 email 0：公开  1：不公开
		c.setAddressp(1600); //所在地区省
		c.setAddress(StringUtil.getNotNullStr(u.getBusiaddress()));//经营地址
		c.setZipcode(StringUtil.getNotNullStr(u.getBusizipcode()));//邮政编码
		c.setHomepage(StringUtil.getNotNullStr(u.getHttp()));//个人主页
		c.setMailcode(0);// 邮件格式（0 中文简体  1 繁体） 默认中文简体
		c.setRegisterdate(StringUtil.getNotNullStr(u.getRegistertime()));//注册时间
		c.setUpdatedate(DateUtil.getNowDateTime());//默认当前时间
		c.setComflag(10); //来源标志    10 江苏人才网导入标志
		c.setLasteditby("");
		c.setStatus(0);//标志： //0,新注册 1,已开通 5,被锁定 6,作废 7,非法企业 8,公共
		c.setFilterperid(""); //过滤个人ID  （无）
		c.setRegip(""); //注册IP
		c.setAddressc(0); //所属市
		c.setInterviewadd(StringUtil.getNotNullStr(u.getBusiaddress())); //面试地址
		c.setEmailmode(0);// 邮件发送方式，0普通，1附件等  默认为  0
		c.setIshunt(0);//是否需要猎头企业[0不是，1是]  默认为  0
		c.setBusway("");//乘车路线
		c.setEmailwilling(1);//是否愿意接受来自智通人才风的资讯1-愿意，0不愿意EmailWilling  默认1
		c.setMapBeginDate(null);//地图录入生效时间  （需分析）
		c.setMapValidDay(0);//地图有效天数      （需分析）
		c.setExtendFlag(null); //扩展字段 目前用于校园招聘 默认为Null
		c.setSalerName("导入资料");
		c.setSalerId(109);
		c.setSalerIssee(0);//分配业务员之后.他是否看过此公司.默认为0 表示看过..1表示没看过
		c.setCanUseOrder(0);// 1表示 该公司有使用定制系统权限  默认为0
		c.setUnLaw(null);//非法企业，记录非法企业备注      默认为 null
		c.setComIDFilterIP(0);// 公司对IP的限制，默认为0
		
		
		return c;
	}
	
	public static boolean isTrue(String name,int temp,Session session29){
		boolean flag = true;
		String hql = "";
		if(1 == temp){
			hql = "SELECT COUNT(c.id) FROM ComBaseInfo c WHERE c.comname = '"+name+"'";
			
		}else if(2 == temp){
			
		}
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
	
	public static boolean isTrueAccount(unit u,Session session29){
		boolean flag = true;
		String hql = "SELECT COUNT(c.id) FROM ComUserInfo c WHERE c.username = '"+u.getUname() + "' and c.password = '" + u.getPwd()+ "'";		
		int num = 0;
		num = EntityManager.getAllEntityNumberByHql(hql, session29);
		if(num > 0){
			flag = false;
		}
		System.out.println(num);
		return flag;
	}
	
}
