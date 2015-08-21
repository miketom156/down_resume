package com.job5156.ningboAccessToMysql;

import java.util.List;

import org.hibernate.Session;

import com.job5156.jsDateJoin.entity.ComRightInfo;
import com.job5156.server.EntityManager;
import com.job5156.util.DateUtil;

@SuppressWarnings("unchecked")
public class GetComRightInfo {
	public ComRightInfo getCRI(int comID) {
		ComRightInfo cri = new ComRightInfo();
		cri.setComid(comID);
		cri.setMemberclass(6);
		cri.setOthermember(null);
		String nowDate = DateUtil.getNowDate();
		cri.setBeginvaliddate(nowDate);
		cri.setEndvaliddate(DateUtil.dateAdd("d", 40, DateUtil.getDate()));
		cri.setMaxposnum(0);
		cri.setMaxresumenum(0);
		cri.setViewingresume(0);
		cri.setViewedresume(0);
		cri.setCheckuser("nbrc");
		cri.setCheckdate(nowDate);
		cri.setMaxmsgnum(null);
		cri.setMsgingnum(null);
		cri.setSaler(109);
		cri.setDisplayflag(0);
		cri.setMoney(0);
		cri.setCountnum(0);
		cri.setUsenum(0);
		cri.setMark("nbrc");
		cri.setDisplayflagsee(1);
		cri.setCreDate(nowDate);
		cri.setCreUserName(null);
		cri.setRestrictArea(null);
		cri.setAccountNum(null);
		cri.setCareergo(0);
		return cri;
	}

	public List<ComRightInfo> getCRI(int comId, Session session) {
		String HQL = "FROM ComRightInfo c WHERE c.comid='" + comId + "'";
		return EntityManager.getAllEntityByHql(HQL, session);
	}
}
