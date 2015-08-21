package com.job5156.jsDateJoin.entity;

import com.job5156.framework.dao.AbstractBaseEntity;

public class unit extends AbstractBaseEntity {
	private int uid;				//单位ID
	private String name;			//单位中文名称
	private String ename;			//单位英文名称
	private String uname;			//用户名
	private String pwd;				//密码
	private String pwdquestion;		//密码提示问题(无)
	private String pwdanswer;		//密码回答问题(无)
	private String superunit;		//主管单位名称（无）
	private String artiperson;		//法人代表
	private String artipersonpost;	//法人代表职务：
	private String artipersonstru;	//法人治理结构
	private String unitproperty;	//所有制性质(公司性质)
	private int regfund;			//注册资金(万元)
	private String regaddress;		//注册地址
	private String regphone;		//注册地址电话
	private String regzipcode;		//注册地址邮编：
	private String busiaddress;		//经营地址
	private String busizipcode;		//经营地址邮编
	private String busilicense;		//营业执照编号
	private String regunit;			//发证单位(不确定)
	private String busiwhat;		//经营范围
	private int employeea;		//博士及以上
	private int employeeb;		//硕士人数
	private int employeec;		//本科人数
	private int employeed;		//大专人数
	private int employeee;		//中专人数
	private int employeef;		//高中人数
	private int employeeg;		//初中人数
	private int employeeh;		//其他人数
	private String linkman;			//联系人
	private String linkmanpost;		//职务
	private String fax;				//传真
	private String phone;			//联系电话
	private String address;			//公司地址
	private String zipcode;			//邮政编码
	private String email;			//电子邮箱
	private String mobile;			//手机
	private String http;			//公司网址
	private String infomobile;		//业务短信接收手机
	private String infoemail;		//业务接收电子邮件：
	private String remark;			//备注
	private Integer state;			//开通状态或会员类型（不确定）
	private String busino;			//工商注册号
	private String lastlogintime;	//最后登录时间
	private Integer locked;			//
	private String registertime;	//注册时间
	private String intro;			//单位简介

	
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPwdquestion() {
		return pwdquestion;
	}
	public void setPwdquestion(String pwdquestion) {
		this.pwdquestion = pwdquestion;
	}
	public String getPwdanswer() {
		return pwdanswer;
	}
	public void setPwdanswer(String pwdanswer) {
		this.pwdanswer = pwdanswer;
	}
	public String getSuperunit() {
		return superunit;
	}
	public void setSuperunit(String superunit) {
		this.superunit = superunit;
	}
	public String getArtiperson() {
		return artiperson;
	}
	public void setArtiperson(String artiperson) {
		this.artiperson = artiperson;
	}
	public String getArtipersonpost() {
		return artipersonpost;
	}
	public void setArtipersonpost(String artipersonpost) {
		this.artipersonpost = artipersonpost;
	}
	public String getArtipersonstru() {
		return artipersonstru;
	}
	public void setArtipersonstru(String artipersonstru) {
		this.artipersonstru = artipersonstru;
	}
	public String getUnitproperty() {
		return unitproperty;
	}
	public void setUnitproperty(String unitproperty) {
		this.unitproperty = unitproperty;
	}
	public int getRegfund() {
		return regfund;
	}
	public void setRegfund(int regfund) {
		this.regfund = regfund;
	}
	public String getRegaddress() {
		return regaddress;
	}
	public void setRegaddress(String regaddress) {
		this.regaddress = regaddress;
	}
	public String getRegphone() {
		return regphone;
	}
	public void setRegphone(String regphone) {
		this.regphone = regphone;
	}
	public String getRegzipcode() {
		return regzipcode;
	}
	public void setRegzipcode(String regzipcode) {
		this.regzipcode = regzipcode;
	}
	public String getBusiaddress() {
		return busiaddress;
	}
	public void setBusiaddress(String busiaddress) {
		this.busiaddress = busiaddress;
	}
	public String getBusizipcode() {
		return busizipcode;
	}
	public void setBusizipcode(String busizipcode) {
		this.busizipcode = busizipcode;
	}
	public String getBusilicense() {
		return busilicense;
	}
	public void setBusilicense(String busilicense) {
		this.busilicense = busilicense;
	}
	public String getRegunit() {
		return regunit;
	}
	public void setRegunit(String regunit) {
		this.regunit = regunit;
	}
	public String getBusiwhat() {
		return busiwhat;
	}
	public void setBusiwhat(String busiwhat) {
		this.busiwhat = busiwhat;
	}
	
	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	public String getLinkmanpost() {
		return linkmanpost;
	}
	public void setLinkmanpost(String linkmanpost) {
		this.linkmanpost = linkmanpost;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getHttp() {
		return http;
	}
	public void setHttp(String http) {
		this.http = http;
	}
	public String getInfomobile() {
		return infomobile;
	}
	public void setInfomobile(String infomobile) {
		this.infomobile = infomobile;
	}
	public String getInfoemail() {
		return infoemail;
	}
	public void setInfoemail(String infoemail) {
		this.infoemail = infoemail;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getBusino() {
		return busino;
	}
	public void setBusino(String busino) {
		this.busino = busino;
	}
	public String getLastlogintime() {
		return lastlogintime;
	}
	public void setLastlogintime(String lastlogintime) {
		this.lastlogintime = lastlogintime;
	}
	public Integer getLocked() {
		return locked;
	}
	public void setLocked(Integer locked) {
		this.locked = locked;
	}
	public String getRegistertime() {
		return registertime;
	}
	public void setRegistertime(String registertime) {
		this.registertime = registertime;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public int getEmployeea() {
		return employeea;
	}
	public void setEmployeea(int employeea) {
		this.employeea = employeea;
	}
	public int getEmployeeb() {
		return employeeb;
	}
	public void setEmployeeb(int employeeb) {
		this.employeeb = employeeb;
	}
	public int getEmployeec() {
		return employeec;
	}
	public void setEmployeec(int employeec) {
		this.employeec = employeec;
	}
	public int getEmployeed() {
		return employeed;
	}
	public void setEmployeed(int employeed) {
		this.employeed = employeed;
	}
	public int getEmployeee() {
		return employeee;
	}
	public void setEmployeee(int employeee) {
		this.employeee = employeee;
	}
	public int getEmployeef() {
		return employeef;
	}
	public void setEmployeef(int employeef) {
		this.employeef = employeef;
	}
	public int getEmployeeg() {
		return employeeg;
	}
	public void setEmployeeg(int employeeg) {
		this.employeeg = employeeg;
	}
	public int getEmployeeh() {
		return employeeh;
	}
	public void setEmployeeh(int employeeh) {
		this.employeeh = employeeh;
	}	
}
