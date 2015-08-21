package com.job5156.jsDateJoin.entity;


import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;


public class PerUser implements Serializable{

	private static final long serialVersionUID = 1L;
	

	private Integer id;                   //�˺�id
	private Integer accountId;			  //ͨ��֤ID
	private Integer accountType;          //�˺�����
	private String account;               //�˺�
	private String password;              //����
	private Integer loginCount;           //��¼����
	private Date freDate;                 //ˢ��ʱ��
	private Date createDate;              //����ʱ��
	private Date loginDate;               //��¼ʱ��
	private Integer publicSettings;       //����״̬��0-��ȫ������1-��ȫ���ܣ�2-����ͨ����
	private String filterComId;                 //���˵���ҵID
	private Integer vipMember;            //�Ƿ�Ϊ���˻�Ա Ĭ��Ϊ0 ��1Ϊ��Ա
	private Integer refreshRemind;        //ˢ�����ѣ�0��ʾ����15��û�и��¾���ʾ��1��ʾ������ʾ��
	private Integer adminId;              //�����û� ¼����ID ���Ǻ��쵼��� Ĭ��0
	private String ip;                    //����û���¼ʱ��IP��ַ
	private String recommendName;         //��ͷ�Ƽ���
	private String recommendPhone;        //��ͷ�Ƽ�����ϵ��ʽ
	private String userName;              //�����û���������
	private Integer gender;               //�Ա�1Ϊ�У�2ΪŮ
	private Date birthday;                //��������
	private Integer location;             //���ڵ�ʡ/������Ӧ�� ���
	private Integer locationTown;         //���ڵس�������Ӧ�ı��
	private String email;                 //��������
//	private Integer hiddenEmail;          //���������Ƿ���ʾ��0Ϊ��ʾ��1Ϊ����
	private Integer cardType;             //֤������
	private String cardNum;               //֤������
	private Integer hometown;             //�������ڵ� ʡ/������Ӧ����
	private Integer hometownTown;         //�������ڵ� �����Ӧ�ı���
	private String phone;                 //�̶��绰
//	private Integer hiddenPhone;          //�Ƿ���ʾ�̶��绰��0Ϊ��ʾ��1Ϊ����
	private String mobile;                //�ֻ�����
//	private Integer hiddenMobile;         //�Ƿ���ʾ�ֻ����룺0Ϊ��ʾ��1Ϊ����
	private String nation;                //����
	private String nationEn;              //Ӣ������
	private Integer marriage;             //����״������Ӧ�ı���
	private Integer stature;              //���
	private Integer weight;               //����
	private String zipcode;               //�ʱ�
	private Integer mobileActivation;     //�ֻ����0��δ���1���Ѽ��
	private Integer identification;       //ʵ����֤��0��δ��֤��1������֤��
	private Integer mailActivation;       //�ʼ����0��δ���1���Ѽ��
	private String address;               //��ϸ��ַ
	private String homepage;              //������ҳ
	private String qq;                    //QQ
	private Integer political;            //������ò
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public Integer getAccountType() {
		return accountType;
	}
	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getLoginCount() {
		return loginCount;
	}
	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}
	public Date getFreDate() {
		return freDate;
	}
	public void setFreDate(Date freDate) {
		this.freDate = freDate;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	public Integer getPublicSettings() {
		return publicSettings;
	}
	public void setPublicSettings(Integer publicSettings) {
		this.publicSettings = publicSettings;
	}
	public String getFilterComId() {
		return filterComId;
	}
	public void setFilterComId(String filterComId) {
		this.filterComId = filterComId;
	}
	public Integer getVipMember() {
		return vipMember;
	}
	public void setVipMember(Integer vipMember) {
		this.vipMember = vipMember;
	}
	public Integer getRefreshRemind() {
		return refreshRemind;
	}
	public void setRefreshRemind(Integer refreshRemind) {
		this.refreshRemind = refreshRemind;
	}
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getRecommendName() {
		return recommendName;
	}
	public void setRecommendName(String recommendName) {
		this.recommendName = recommendName;
	}
	public String getRecommendPhone() {
		return recommendPhone;
	}
	public void setRecommendPhone(String recommendPhone) {
		this.recommendPhone = recommendPhone;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getLocation() {
		return location;
	}
	public void setLocation(Integer location) {
		this.location = location;
	}
	public Integer getLocationTown() {
		return locationTown;
	}
	public void setLocationTown(Integer locationTown) {
		this.locationTown = locationTown;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getCardType() {
		return cardType;
	}
	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public Integer getHometown() {
		return hometown;
	}
	public void setHometown(Integer hometown) {
		this.hometown = hometown;
	}
	public Integer getHometownTown() {
		return hometownTown;
	}
	public void setHometownTown(Integer hometownTown) {
		this.hometownTown = hometownTown;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getNationEn() {
		return nationEn;
	}
	public void setNationEn(String nationEn) {
		this.nationEn = nationEn;
	}
	public Integer getMarriage() {
		return marriage;
	}
	public void setMarriage(Integer marriage) {
		this.marriage = marriage;
	}
	public Integer getStature() {
		return stature;
	}
	public void setStature(Integer stature) {
		this.stature = stature;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public Integer getMobileActivation() {
		return mobileActivation;
	}
	public void setMobileActivation(Integer mobileActivation) {
		this.mobileActivation = mobileActivation;
	}
	public Integer getIdentification() {
		return identification;
	}
	public void setIdentification(Integer identification) {
		this.identification = identification;
	}
	public Integer getMailActivation() {
		return mailActivation;
	}
	public void setMailActivation(Integer mailActivation) {
		this.mailActivation = mailActivation;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public Integer getPolitical() {
		return political;
	}
	public void setPolitical(Integer political) {
		this.political = political;
	}
	public Integer getJobyearType() {
		return jobyearType;
	}
	public void setJobyearType(Integer jobyearType) {
		this.jobyearType = jobyearType;
	}
	public Integer getJobState() {
		return jobState;
	}
	public void setJobState(Integer jobState) {
		this.jobState = jobState;
	}
	public Integer getNowSalary() {
		return nowSalary;
	}
	public void setNowSalary(Integer nowSalary) {
		this.nowSalary = nowSalary;
	}
	public String getUserNameEn() {
		return userNameEn;
	}
	public void setUserNameEn(String userNameEn) {
		this.userNameEn = userNameEn;
	}
	public String getAddressEn() {
		return addressEn;
	}
	public void setAddressEn(String addressEn) {
		this.addressEn = addressEn;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Integer getResId() {
		return resId;
	}
	public void setResId(Integer resId) {
		this.resId = resId;
	}
	public Integer getResRecommend() {
		return resRecommend;
	}
	public void setResRecommend(Integer resRecommend) {
		this.resRecommend = resRecommend;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getAccountFrom() {
		return accountFrom;
	}
	public void setAccountFrom(Integer accountFrom) {
		this.accountFrom = accountFrom;
	}
	public String getMobilePlace() {
		return mobilePlace;
	}
	public void setMobilePlace(String mobilePlace) {
		this.mobilePlace = mobilePlace;
	}
	public Integer getDegree() {
		return degree;
	}
	public void setDegree(Integer degree) {
		this.degree = degree;
	}
	private Integer jobyearType;          //������������
	private Integer jobState;             //��ְ״̬����
	private Integer nowSalary;            //Ŀǰнˮ
	private String userNameEn;            //Ӣ������
	private String addressEn;             //Ӣ�ĵ�ַ
	private String fileName;              //ͷ���ļ�����
	private String filePath;              //ͷ���ļ�·��  
	private Integer resId;                //Ĭ�ϼ���ID
	private Integer resRecommend;		  //�����Ƽ���0��ͬ�⣬1ͬ�⣩
	private Integer status;               //�˻�״̬-1=��ɾ����0=���ã�1=����
	private Integer accountFrom;          //�˻���Դ
	private String mobilePlace;		      //�ֻ���������Ϣ
    private Integer degree;               //���ѧ��
}
