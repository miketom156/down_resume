package com.job5156.ningboAccessToMysql;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.job5156.jsDateJoin.entity.NingboEntity;
import com.job5156.ningboAccessToMysql.entity.ComPosition;
import com.job5156.server.EntityManager;
import com.job5156.util.DateUtil;
import com.job5156.util.StringUtil;

@SuppressWarnings("unchecked")
public class GetComPosition {
	@SuppressWarnings("static-access")
	public ComPosition getCP(NingboEntity nibo, int comId, Session session) {
		ComPosition cp = new ComPosition();
		InputMap input = new InputMap();
		String temp = null;
		Date nowDate = DateUtil.getDate();
		String strDate = DateUtil.getNowDate();
		cp.setComid(comId);
		cp.setComname(nibo.getComname());

		// 对照岗位
		temp = input.getJob5156Code(input.JobfunctionT, StringUtil.getNotNullStr(nibo.getJobfunction1()), true);
		cp.setJobfunction1(StringUtil.parseInt(temp));
		cp.setJobfunction2(0);
		cp.setJobfunction3(0);
		cp.setPosname(nibo.getPosname());
		cp.setDeptid(0);
		cp.setCandidatesnum(nibo.getCandidatesnum());
		cp.setTdate(nowDate);
		
		//最后时间，数据库是Date
		String Date=nibo.getEndvaliddate();
		String endDate="";
		if(Date != null || Date != ""){
			endDate=StringUtil.getSubStr(Date, 11, 21);
		}
		cp.setEndvaliddate(endDate);

		// 工作地区对照(以“，”拆开分别存入)
		String jobloca1 = "";
		String jobloca[] = new String[3];
		String Joblocation = nibo.getJoblocation1();
		if (Joblocation != null) {
			if (Joblocation.indexOf(",") != -1) {
				String[] location = Joblocation.split(",");
				for (int i = 0; i < 3; i++) {
					if (i < location.length) {
						jobloca1 = input.getJob5156Code(input.cityT, StringUtil.getNotNullStr(location[i]), true);
						if (jobloca1 == "" || jobloca1 == null) {
							jobloca[i] = "0";
						} else {
							jobloca[i] = jobloca1;
						}
					} else {
						jobloca[i] = "0";
					}
				}
			} else {
				jobloca1 = input.getJob5156Code(input.cityT, StringUtil.getNotNullStr(Joblocation), true);
				if (jobloca1 == "" || jobloca1 == null) {
					jobloca[0] = "0";
					jobloca[1] = "0";
					jobloca[2] = "0";
				} else {
					jobloca[0] = jobloca1;
					jobloca[1] = "0";
					jobloca[2] = "0";
				}

			}
		} else {
			jobloca[0] = "0";
			jobloca[1] = "0";
			jobloca[2] = "0";
		}
		cp.setJoblocation1(StringUtil.parseInt(jobloca[0]));
		cp.setJoblocation2(StringUtil.parseInt(jobloca[1]));
		cp.setJoblocation3(StringUtil.parseInt(jobloca[2]));
		cp.setPosdescription(nibo.getPosdescription());
		cp.setSalary("0");// 宁波人才网无待遇

		// 学历对照
		temp = input.getJob5156Code(input.DegreeT, StringUtil.getNotNullStr(nibo.getReqdegreeid()), true);
		cp.setReqdegreeid(StringUtil.parseInt(temp));

		// 工龄对照
		temp = input.getJob5156Code(input.ReqworkyearT, StringUtil.getNotNullStr(nibo.getReqworkyear()), true);
		if(temp == "" || temp == null){
			temp="99";
		}
		cp.setReqworkyear(StringUtil.parseInt(temp));

		// 性别对照
		temp = input.getJob5156Code(input.sexT, StringUtil.getNotNullStr(nibo.getReqsex()), true);
		cp.setReqsex(StringUtil.parseInt(temp));
		cp.setReqage1(null);
		cp.setReqage2(null);
		cp.setReqlocationp(0);
		cp.setReqlocationc(0);
		cp.setLangtype(0);
		cp.setLanglevel(0);
		cp.setCertificate(0);
		cp.setLangtype2(0);
		cp.setLanglevel2(0);
		cp.setCertificate2(0);
		cp.setYueyulevel(0);
		cp.setComputerlev(0);
		cp.setCertificate1(0);
		cp.setExamnotice("");
		cp.setExamaddressp(0);
		cp.setExamaddress(nibo.getExamaddress());
		cp.setExampaperid(0);
		cp.setNeedhunt(0);
		cp.setIshunt(0);
		cp.setFltdegreeid(0);
		cp.setFltworkyear(0);
		cp.setContact1(0);
		cp.setContact2(0);
		cp.setContactperson(nibo.getContactperson());
		cp.setContacttel(nibo.getContacttel());
		cp.setTelshowflag(0);
		cp.setContactfax(nibo.getContactfax());
		cp.setFaxshowflag(0);
		cp.setEmail(nibo.getEmail());
		cp.setEmailshowflag(1);
		cp.setEmailcodeflag(0);
		cp.setEmailattachfile(1);
		cp.setAddressp(0);
		cp.setAddress(nibo.getAddress());
		cp.setZipcode(nibo.getZipcode());
		cp.setPosstate(2);
		cp.setPrevState(0);
		cp.setRegisterdate(strDate);
		cp.setUpdatedate(strDate);
		cp.setHitcounter(0);
		cp.setPosflag(13); // 13宁波人才网
		cp.setPostdate(strDate);
		cp.setResumenum(0);
		cp.setFltsex(0);
		cp.setFltage(0);
		cp.setUpdateflag(0);
		cp.setShowcontactperson(0);
		cp.setBusway("");
		/*
		 * 上传到Dowjob数据库因为没有下面这四个字段，所以注释掉
		 * cp.setExtendFlag(0);
		
		//获取Userid
		String HQL="FROM ComUserInfo c WHERE c.comid='"+comId+"'";
		ComUserInfo comUserInfo = (ComUserInfo)EntityManager.getAllEntityByHql(HQL, session).get(0);
		cp.setComUserID(comUserInfo.getId());
		cp.setAuditorId(0);
		cp.setAuditDate("");*/
		return cp;

	}
	
	//查询公司ID和职位名称查询“composition”表是否有记录
	public int getCP(String comName, String Posname, Session session) {
		String HQL = "FROM ComPosition c WHERE c.comname='" + comName + "' AND c.posname='" + Posname + "'";
		return EntityManager.getAllEntityNumberByHql(HQL, session);
	}
}
