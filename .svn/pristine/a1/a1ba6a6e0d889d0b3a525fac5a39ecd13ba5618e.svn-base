package com.job5156.ningboAccessToMysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.job5156.jsDateJoin.entity.NingboEntity;
import com.job5156.util.StringUtil;

public class GetNiboEntity {
	public NingboEntity getNO(ResultSet rs) throws SQLException{
		NingboEntity nb = new NingboEntity();
			nb.setId(rs.getInt("id"));
			nb.setStatusCai(rs.getInt("已采"));
			nb.setStatusFa(rs.getInt("已发"));
			nb.setPosname(rs.getString("职位名称"));
			nb.setEndvaliddate(rs.getString("招聘期限"));
			nb.setContactperson(rs.getString("联系人"));
			nb.setJoblocation1(rs.getString("工作地区"));
			nb.setContacttel(rs.getString("联系电话"));
			nb.setExamaddress(rs.getString("面试地址"));
			nb.setReqdegreeid(rs.getString("学历要求"));
			nb.setReqsex(rs.getString("性别"));
			nb.setPosdescription(rs.getString("职位描述"));
			nb.setReqworkyear(rs.getString("工作经验"));
			nb.setCbpanyintroduction(rs.getString("公司简介"));
			nb.setCbcontactperson(rs.getString("企业联系人"));
			nb.setCbcontacttel(rs.getString("企业电话"));
			nb.setContactfax(rs.getString("企业传真"));
			nb.setAddress(rs.getString("企业地址"));
			nb.setZipcode(rs.getString("邮编"));
			nb.setEmail(rs.getString("电子邮件"));
			nb.setCbhomepage(rs.getString("公司网站"));
			nb.setJobfunction1(rs.getString("职位编号"));
			nb.setComname(rs.getString("企业名称"));
			nb.setCandidatesnum(StringUtil.parseInt(rs.getString("招聘人数")));
			nb.setImages(rs.getString("缩略图"));
			nb.setUrl(rs.getString("PageUrl"));
			return nb;
	}
}
