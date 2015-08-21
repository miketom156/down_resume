package com.job5156.ningboAccessToMysql;

import com.job5156.jsDateJoin.entity.ComUserInfo;
import com.job5156.util.DateUtil;
import com.job5156.util.StringUtil;

public class GetComUserInfo {
	public ComUserInfo getCUI(int comid){
		ComUserInfo cui = new ComUserInfo();
		String nowDate = DateUtil.getNowDate();
		cui.setComid(comid);
		cui.setDeptid(0);

		// 用户名和密码都是“job5156”+cbi.id
		String userName = "job5156" + StringUtil.getNotNullStr(comid);
		cui.setUsername(userName);
		cui.setPassword(userName);
		cui.setIsadmin(true);
		cui.setRegisterdate("");
		cui.setUpdatedate(nowDate);
		cui.setLastLogindate("");
		cui.setLastLoginip("");
		cui.setLoginnum(0);
		cui.setMenu(null);
		cui.setSafeSet(0);
		cui.setCountNum(0);
		cui.setUsedNum(0);
		cui.setIsCount(0);
		cui.setCountNum(0);
		cui.setFlag(0);
		return cui;
	}
}
