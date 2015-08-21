package com.job5156.ningboAccessToMysql;

import java.util.List;

import org.hibernate.Session;

import com.job5156.jsDateJoin.entity.NingboEntity;
import com.job5156.ningboAccessToMysql.entity.ComBaseInfo;
import com.job5156.server.EntityManager;
import com.job5156.util.DateUtil;

@SuppressWarnings("unchecked")
public class GetComBaseInfo {
	public ComBaseInfo getCBI(NingboEntity nibo){
		ComBaseInfo cbi = new ComBaseInfo();
		String strDate = DateUtil.getNowDate();
		cbi.setComname(nibo.getComname());
		cbi.setLicencenumber("");
		cbi.setCalling(0);
		cbi.setProperity(0);
		cbi.setFounddate("");
		cbi.setRegisterfund("0");
		cbi.setCurrency("RMB");
		cbi.setEmployeenumber("");
		cbi.setCompanyintroduction(nibo.getCbpanyintroduction());
		cbi.setProductintroduction("");
		cbi.setContactperson(nibo.getCbcontactperson());
		cbi.setContactposition("");
		cbi.setContactdepartment("");
		cbi.setContacttel(nibo.getCbcontacttel());
		cbi.setContact1(1);
		cbi.setContact2(2);
		cbi.setTelshowflag(0);
		cbi.setTelshowflag2(0);
		cbi.setContactfax(nibo.getContactfax());
		cbi.setEmail(nibo.getEmail());
		cbi.setEmailshowflag(0);
		cbi.setAddressp(0);
		cbi.setAddress("");
		cbi.setZipcode(nibo.getZipcode());
		cbi.setHomepage(nibo.getCbhomepage());
		cbi.setMailcode(0);
		cbi.setRegisterdate(strDate);					//如何获取注册时间
		cbi.setUpdatedate(strDate);
		cbi.setComflag(13);							//13 宁波人才网导入标志
		cbi.setLasteditby("");
		cbi.setStatus(0);
		cbi.setFilterperid("");
		cbi.setRegip("");
		cbi.setAddressc(0);
		cbi.setInterviewadd(nibo.getAddress());
		cbi.setEmailmode(0);
		cbi.setIshunt(0);
		cbi.setBusway("");
		cbi.setEmailwilling(1);
		cbi.setMapBeginDate(null);
		cbi.setMapValidDay(0);
		cbi.setExtendFlag(null);
		cbi.setSalerName("导入资料");
		cbi.setSalerId(0);
		cbi.setSalerIssee(0);
		/*
		cbi.setCanUseOrder(0);
		cbi.setUnLaw(null);
		cbi.setComIDFilterIP(0);
		*/
		return cbi;
	}
	
	public int getCBI(String name, Session session) {
		String HQL = "FROM ComBaseInfo c WHERE c.comname='" + name + "'";
		return EntityManager.getAllEntityNumberByHql(HQL, session);
	}
}
