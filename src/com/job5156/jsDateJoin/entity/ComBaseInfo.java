package com.job5156.jsDateJoin.entity;

import com.job5156.framework.dao.AbstractBaseEntity;

public class ComBaseInfo extends AbstractBaseEntity {

	private String comname;
	private String licencenumber;
	private Integer calling;
	private Integer properity;
	private String founddate;
	private String registerfund;
	private String currency;
	private String employeenumber;
	private String companyintroduction;
	private String productintroduction;
	private String contactperson;
	private String contactposition;
	private String contactdepartment;
	private String contacttel;
	private Integer contact1; // ��ϵ��ʽ1
	private Integer contact2; // ��ϵ��ʽ2
	private Integer telshowflag;
	private Integer telshowflag2;
	private String contactfax;
	private String email;
	private Integer emailshowflag;
	private Integer addressp;
	private String address;
	private String zipcode;
	private String homepage;
	private Integer mailcode;
	private String registerdate;
	private String updatedate;
	private Integer comflag; // 9 cqjob����
	private String lasteditby;
	private Integer status; // 0,��ע�� 1,�ѿ�ͨ 5,������ 6,���� 7,�Ƿ���ҵ 8,��������ҵ
	private String filterperid;
	private String regip;
	private Integer addressc;
	private String interviewadd;
	private Integer emailmode;// �ʼ����ͷ�ʽ��0��ͨ��1������
	private Integer ishunt; // �Ƿ���Ҫ��ͷ��ҵ[0���ǣ�1��]
	private String busway; // �˳�·��
	private Integer emailwilling; // �Ƿ�Ը�����������ͨ�˲ŷ����Ѷ1-Ը�⣬0��Ը��EmailWilling
	private String mapBeginDate; // ��ͼ¼����Чʱ��
	private Integer mapValidDay; // ��ͼ��Ч����
	private Integer extendFlag; // ��չ�ֶ� Ŀǰ����У԰��Ƹ 1��ʾΪУ԰��Ƹ��ҵ
	private String salerName;// ҵ��Ա����
	private Integer salerId; // ҵ��ԱID,Ĭ��Ϊ0,����ҵ��Ա����˿�ͨ���������ֶ�
	private Integer salerIssee; // ����ҵ��Ա֮��.���Ƿ񿴹��˹�˾.Ĭ��Ϊ0 ��ʾ����..1��ʾû����
	private Integer canUseOrder; // 1��ʾ �ù�˾��ʹ�ö���ϵͳȨ��
	private String unLaw; // �Ƿ���ҵ����¼�Ƿ���ҵ��ע
	private Integer comIDFilterIP; // ��˾��IP�����ƣ�Ĭ��Ϊ0�����Ϸ���IP��ֹ��¼�����Ϊ1���κ�IP�����Ե�¼
	private String mapID;
	private Integer terminate; // �Ƿ�����[0-�� 1-�� by yanf 2011-2-16]

	public String getComname() {
		return comname;
	}

	public void setComname(String comname) {
		this.comname = comname;
	}

	public String getLicencenumber() {
		return licencenumber;
	}

	public void setLicencenumber(String licencenumber) {
		this.licencenumber = licencenumber;
	}

	public Integer getCalling() {
		return calling;
	}

	public void setCalling(Integer calling) {
		this.calling = calling;
	}

	public Integer getProperity() {
		return properity;
	}

	public void setProperity(Integer properity) {
		this.properity = properity;
	}

	public String getFounddate() {
		return founddate;
	}

	public void setFounddate(String founddate) {
		this.founddate = founddate;
	}

	public String getRegisterfund() {
		return registerfund;
	}

	public void setRegisterfund(String registerfund) {
		this.registerfund = registerfund;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getEmployeenumber() {
		return employeenumber;
	}

	public void setEmployeenumber(String employeenumber) {
		this.employeenumber = employeenumber;
	}

	public String getCompanyintroduction() {
		return companyintroduction;
	}

	public void setCompanyintroduction(String companyintroduction) {
		this.companyintroduction = companyintroduction;
	}

	public String getProductintroduction() {
		return productintroduction;
	}

	public void setProductintroduction(String productintroduction) {
		this.productintroduction = productintroduction;
	}

	public String getContactperson() {
		return contactperson;
	}

	public void setContactperson(String contactperson) {
		this.contactperson = contactperson;
	}

	public String getContactposition() {
		return contactposition;
	}

	public void setContactposition(String contactposition) {
		this.contactposition = contactposition;
	}

	public String getContactdepartment() {
		return contactdepartment;
	}

	public void setContactdepartment(String contactdepartment) {
		this.contactdepartment = contactdepartment;
	}

	public String getContacttel() {
		return contacttel;
	}

	public void setContacttel(String contacttel) {
		this.contacttel = contacttel;
	}

	public Integer getContact1() {
		return contact1;
	}

	public void setContact1(Integer contact1) {
		this.contact1 = contact1;
	}

	public Integer getContact2() {
		return contact2;
	}

	public void setContact2(Integer contact2) {
		this.contact2 = contact2;
	}

	public Integer getTelshowflag() {
		return telshowflag;
	}

	public void setTelshowflag(Integer telshowflag) {
		this.telshowflag = telshowflag;
	}

	public Integer getTelshowflag2() {
		return telshowflag2;
	}

	public void setTelshowflag2(Integer telshowflag2) {
		this.telshowflag2 = telshowflag2;
	}

	public String getContactfax() {
		return contactfax;
	}

	public void setContactfax(String contactfax) {
		this.contactfax = contactfax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getEmailshowflag() {
		return emailshowflag;
	}

	public void setEmailshowflag(Integer emailshowflag) {
		this.emailshowflag = emailshowflag;
	}

	public Integer getAddressp() {
		return addressp;
	}

	public void setAddressp(Integer addressp) {
		this.addressp = addressp;
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

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public Integer getMailcode() {
		return mailcode;
	}

	public void setMailcode(Integer mailcode) {
		this.mailcode = mailcode;
	}

	public String getRegisterdate() {
		return registerdate;
	}

	public void setRegisterdate(String registerdate) {
		this.registerdate = registerdate;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

	public Integer getComflag() {
		return comflag;
	}

	public void setComflag(Integer comflag) {
		this.comflag = comflag;
	}

	public String getLasteditby() {
		return lasteditby;
	}

	public void setLasteditby(String lasteditby) {
		this.lasteditby = lasteditby;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getFilterperid() {
		return filterperid;
	}

	public void setFilterperid(String filterperid) {
		this.filterperid = filterperid;
	}

	public String getRegip() {
		return regip;
	}

	public void setRegip(String regip) {
		this.regip = regip;
	}

	public Integer getAddressc() {
		return addressc;
	}

	public void setAddressc(Integer addressc) {
		this.addressc = addressc;
	}

	public String getInterviewadd() {
		return interviewadd;
	}

	public void setInterviewadd(String interviewadd) {
		this.interviewadd = interviewadd;
	}

	public Integer getEmailmode() {
		return emailmode;
	}

	public void setEmailmode(Integer emailmode) {
		this.emailmode = emailmode;
	}

	public Integer getIshunt() {
		return ishunt;
	}

	public void setIshunt(Integer ishunt) {
		this.ishunt = ishunt;
	}

	public String getBusway() {
		return busway;
	}

	public void setBusway(String busway) {
		this.busway = busway;
	}

	public Integer getEmailwilling() {
		return emailwilling;
	}

	public void setEmailwilling(Integer emailwilling) {
		this.emailwilling = emailwilling;
	}

	public String getMapBeginDate() {
		return mapBeginDate;
	}

	public void setMapBeginDate(String mapBeginDate) {
		this.mapBeginDate = mapBeginDate;
	}

	public Integer getMapValidDay() {
		return mapValidDay;
	}

	public void setMapValidDay(Integer mapValidDay) {
		this.mapValidDay = mapValidDay;
	}

	public Integer getExtendFlag() {
		return extendFlag;
	}

	public void setExtendFlag(Integer extendFlag) {
		this.extendFlag = extendFlag;
	}

	public String getSalerName() {
		return salerName;
	}

	public void setSalerName(String salerName) {
		this.salerName = salerName;
	}

	public Integer getSalerId() {
		return salerId;
	}

	public void setSalerId(Integer salerId) {
		this.salerId = salerId;
	}

	public Integer getSalerIssee() {
		return salerIssee;
	}

	public void setSalerIssee(Integer salerIssee) {
		this.salerIssee = salerIssee;
	}

	public Integer getCanUseOrder() {
		return canUseOrder;
	}

	public void setCanUseOrder(Integer canUseOrder) {
		this.canUseOrder = canUseOrder;
	}

	public String getUnLaw() {
		return unLaw;
	}

	public void setUnLaw(String unLaw) {
		this.unLaw = unLaw;
	}

	public Integer getComIDFilterIP() {
		return comIDFilterIP;
	}

	public void setComIDFilterIP(Integer comIDFilterIP) {
		this.comIDFilterIP = comIDFilterIP;
	}

	public String getMapID() {
		return mapID;
	}

	public void setMapID(String mapID) {
		this.mapID = mapID;
	}

	public Integer getTerminate() {
		return terminate;
	}

	public void setTerminate(Integer terminate) {
		this.terminate = terminate;
	}
}
