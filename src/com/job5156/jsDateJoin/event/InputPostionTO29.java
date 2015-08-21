package com.job5156.jsDateJoin.event;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.job5156.jsDateJoin.entity.ComBaseInfo;
import com.job5156.jsDateJoin.entity.ComPosition;
import com.job5156.jsDateJoin.entity.post;
import com.job5156.server.EntityManager;
import com.job5156.server.LocalSessionManager;
import com.job5156.server.SessionManager;
import com.job5156.util.DateUtil;
import com.job5156.util.StringUtil;

public class InputPostionTO29 {
	
	private static Logger log = Logger.getLogger(InputPostionTO29.class);
	
	public static void main(String[] args) {
		System.out.println("----------江苏人才网 企业基本数据和职位 导入本地数据库 开始！--------------");
		long begintime = System.currentTimeMillis();
		Session localsession  = LocalSessionManager.currentSession();
		Session session29  = SessionManager.currentSession();
		
		runCompanyDate(localsession,session29);
		
		localsession.close();
		long endtime = System.currentTimeMillis();
		System.out.println("----------江苏人才网 企业基本数据和职位 导入本地数据库 结束！用时："+(endtime - begintime)/1000/60+" 分钟");
		log.error("江苏人才网 企业基本数据和职位 导入数据库 用时："+(endtime - begintime)/1000/60+" 分钟");
	}
	
	public static void runCompanyDate(Session localsession,Session session29){
		String hqlCount = "SELECT COUNT(p.id) FROM post p order by p.id";
		String hql = "SELECT p FROM post p order by p.id";
		
		int allRecord = EntityManager.getAllEntityNumberByHql(hqlCount, localsession);
		int dataLoadNumber = 10;
		int allPage = allRecord > 0 ? 1 : 0;
		if(allRecord > dataLoadNumber){
			allPage = allRecord / dataLoadNumber + ((allRecord % dataLoadNumber == 0) ? 0 : 1);
		}
		
		for(int m=0; m<allPage; m++){
			System.out.println("公司职位信息 第"+m+"页");
			List list = EntityManager.getEntityByHqlAndStartRecords(hql, localsession, m*dataLoadNumber, dataLoadNumber);
			if(list != null && list.size() > 0){
				List listPos = new ArrayList();
				for(int i=0; i<list.size(); i++){					
					post p = (post)list.get(i);
					List temp = isTrue(StringUtil.getNotNullStr(p.getUnitName()),StringUtil.getNotNullStr(p.getPostName()),session29);
					if(temp !=null && temp.size()>0){
						ComBaseInfo cbi = (ComBaseInfo)temp.get(0);
						ComPosition cp = (ComPosition)temp.get(1);						
						if(cbi!=null && cp == null && p!=null){
							//数据处理	
							System.out.println("公司职位信息 第"+i+"条");
							cp = getPost(cbi,p);							
							listPos.add(cp);
						}
					}
				}
				
				//保存数据
				saveDate(session29,listPos);
				listPos.clear();
				try {
					Thread.sleep(1000);
					System.out.println("休眠1秒钟！");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("休眠1秒钟 出错！");
					e.printStackTrace();
				}
			}
			
			try {
				Thread.sleep(1000);
				System.out.println("休眠一秒钟！");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("休眠一秒钟 出错！");
				e.printStackTrace();
			}
		}
	}
	
	public static ComPosition getPost(ComBaseInfo cbi,post p){		
		ComPosition c = new ComPosition();
		InputMap imap = new InputMap();
		
		c.setComid(StringUtil.parseInt(cbi.getId()));//企业ID
		c.setComname(StringUtil.getNotNullStr(cbi.getComname()));//公司名称
		//对照 OK
		
		String temp = imap.getJob5156Code(imap.JobfunctionT,StringUtil.getNotNullStr(p.getPositionName()),true);
		if("".equals(temp)){
			temp = "0";
		}
		
		c.setJobfunction1(StringUtil.parseInt(temp));//职位岗位类别一
		
		c.setJobfunction2(0);
		c.setJobfunction3(0);
		c.setPosname(StringUtil.getNotNullStr(p.getPostName()));//职位名称
		c.setDeptid(0);//招聘部门编号
		c.setCandidatesnum(StringUtil.parseInt(p.getNumber1()));//招聘人数
		
		
		temp = StringUtil.getNotNullStr(p.getReleaseDate());
		Date nowDate = null;
		if(!"".equals(temp)){
			try{
			nowDate = DateUtil.string2Date(temp + " 00:00:00");
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			nowDate = new Date();
		}
		
		c.setTdate(nowDate);//发布时间
		String temp1 = imap.getJob5156Code(imap.EndvaliddateT,StringUtil.getNotNullStr(StringUtil.parseInt(p.getPeriod())),true);
		//对照 OK
		c.setEndvaliddate(StringUtil.getNotNullStr(DateUtil.dateAdd("d", StringUtil.parseInt(temp1), nowDate)));//最终有效日期
		//对照
		temp = imap.getJob5156Code(imap.cityT,StringUtil.getNotNullStr(p.getWorkPlace()),true);
		if("".equals(temp)){
			temp = "0";
		}
		c.setJoblocation1(StringUtil.parseInt(temp));//工作地区一
		
		c.setJoblocation2(0);
		c.setJoblocation3(0);
		c.setPosdescription(StringUtil.getNotNullStr(p.getMemo()));//职位描述
		
		//对照 ok		
		temp = imap.getJob5156Code(imap.salaryT,StringUtil.getNotNullStr(p.getMonthlyPay()),true);
		if("".equals(temp)){
			temp = "2";
		}
		c.setSalary(StringUtil.getNotNullStr(temp));//工资待遇
		//对照 OK
		temp = imap.getJob5156Code(imap.DegreeT,StringUtil.getNotNullStr(p.getDegree()),true);
		if("".equals(temp)){
			temp = "0";
		}
		
		c.setReqdegreeid(StringUtil.parseInt(temp));//学历要求
		
		
		//对照 OK
		temp = imap.getJob5156Code(imap.ReqworkyearT,StringUtil.getNotNullStr(p.getExperience()),true);
		if("".equals(temp)){
			temp = "0";
		}
		c.setReqworkyear(StringUtil.parseInt(p.getExperience()));//工龄要求(初始值99表示工作经验不限)
		
		//年龄 OK  
		temp = imap.getJob5156Code(imap.sexT,StringUtil.getNotNullStr(p.getSex()),true);				
		if("".equals(temp)){
			temp = "0";
		}
		c.setReqsex(StringUtil.parseInt(p.getSex()));//性别		
		
		//年龄 OK
		temp = imap.getJob5156Code(imap.ageT,StringUtil.getNotNullStr(p.getAge()),true);				
		if("".equals(temp)){
			temp = "0-0";
		}
		String[] temp2 = temp.split("-");
		c.setReqage1(StringUtil.parseInt(temp2[0]));//Age
		c.setReqage2(StringUtil.parseInt(temp2[1]));
		
		c.setReqlocationp(1600);//现所在地区要求(省)
		c.setReqlocationc(0);//现所在地区要求(市)
		c.setLangtype(0);	//外语语种
		c.setLanglevel(0);	//外语水平
		c.setCertificate(0);	//语言证书
		c.setLangtype2(0);		//语种2 新增
		c.setLanglevel2(0);		//水平2    新增
		c.setCertificate2(0);	//语言证书2 新增
		c.setYueyulevel(0);		//粤语水平
		c.setComputerlev(0);	//计算机能力
		c.setCertificate1(0);	//计算机证书
		c.setExamnotice(""); //面试须知
		c.setExamaddressp(1600);//面试地址（省）
		c.setExamaddress(StringUtil.getNotNullStr(cbi.getAddress()));//面试地址
		c.setExampaperid(0);//试题ID号
		c.setNeedhunt(0);//是否急聘
		c.setIshunt(0);//是否需要猎头服务[0不是，1是]
		c.setFltdegreeid(0);//学历要求（简历过滤）
		c.setFltworkyear(0);//工龄要求（简历过滤）
		c.setContact1(1);//联系方式1
		c.setContact2(2);//联系方式2
		c.setContactperson(StringUtil.getNotNullStr(cbi.getContactperson()));//待定  联系人
		c.setContacttel(StringUtil.getNotNullStr(cbi.getContacttel()));//待定  联系电话
		c.setTelshowflag(0);//是否显示电话资料[1为不公开，0为公开]
		c.setContactfax(StringUtil.getNotNullStr(cbi.getContactfax()));//待定   传真
		c.setFaxshowflag(0); //是否显示传真
		c.setEmail(StringUtil.getNotNullStr(cbi.getEmail()));  //email
		c.setEmailshowflag(0); //是否显示Email(1为不公开，0为公开) 是否接收Email
		c.setEmailcodeflag(0); //邮件接收方式（0为简、1为繁）
		c.setEmailattachfile(0); //以附件方式接收邮件  是否显示Email 前台显示(1为不公开，0为公开)
		c.setAddressp(1600); //通讯地址
		c.setAddress(StringUtil.getNotNullStr(cbi.getAddress()));//详细通讯地址
		c.setZipcode(StringUtil.getNotNullStr(cbi.getZipcode()));//邮政编码
		c.setPosstate(2);//职位状态
		//c.setPrevState("");
		c.setRegisterdate(StringUtil.getNotNullStr(""));//待定登记日期
		c.setUpdatedate(DateUtil.getNowDateTime());//更新日期
		c.setHitcounter(StringUtil.parseInt(p.getVisitNum()));//查看次数
		c.setPosflag(10);////职位等级(1:正式资料;2:51job资料;3:jobcn资料;4:job88资料,5.baicai资料，9.cqjob导入资料)
		c.setPostdate(DateUtil.getNowDateTime());//职位修改日期
		c.setResumenum(0);//职位收到的简历数
		c.setFltsex(0);//性别要求（简历过滤1为过滤）
		c.setFltage(0);//性别要求（简历过滤）
		c.setUpdateflag(0);//同步更新所有招聘信息中的联系方式
		c.setShowcontactperson(0);//是否隐藏联系人
		c.setBusway("");//乘车路线
		c.setExtendFlag(0);//扩展字段 现用于表示是否为校园职位 1是校园职位		
		c.setComUserID(0);//发布职位的公司用户ID
		c.setAuditorId(0);//审核者ID号 2010-03-04新增字段
		c.setAuditDate("");//审核时间   2010-03-24新增字段
		return c;
	}
	
	public static List isTrue(String name,String posname,Session session29){
		List temp = new ArrayList();
		String hql = "SELECT c FROM ComBaseInfo c WHERE c.comname = '"+name+"'";
		ComBaseInfo cbi = (ComBaseInfo)EntityManager.getFirstEntityByHql(hql, session29);
		ComPosition cp = null;
		if(cbi != null){
			String hql1 = "SELECT c1 FROM ComPosition c1 WHERE c1.comname = '"+name+"' and c1.posname = '"+posname+"'";
			cp = (ComPosition)EntityManager.getFirstEntityByHql(hql1, session29);
			
		}
		temp.add(cbi);
		temp.add(cp);
		return temp;
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

}
