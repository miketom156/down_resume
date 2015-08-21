package com.job5156.ningboAccessToMysql;

import com.job5156.jsDateJoin.entity.ComTranHistory;
import com.job5156.util.DateUtil;

public class GetComTranHistory {
	public ComTranHistory getCTH(int comid){
		String strDate = DateUtil.getNowDate();
		String endDate = DateUtil.dateAdd("d", 40, DateUtil.getDate());
		ComTranHistory cth = new ComTranHistory();
		cth.setComid(comid);
		cth.setMemberclass(6);
		cth.setBeginvaliddate(strDate);
		cth.setEndvaliddate(endDate);
		cth.setMaxposnum(0);
		cth.setSaler(109);
		cth.setSigndate(strDate);
		cth.setRegisterdate(strDate);
		cth.setMaxmsgnum(0);
		cth.setCountnum(0);
		cth.setCheckuser("nbrc");
		cth.setRestrictArea(null);
		cth.setMaxresumenum(0);
		return cth;
		
	}
}
