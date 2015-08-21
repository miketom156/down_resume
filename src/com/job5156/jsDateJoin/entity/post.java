package com.job5156.jsDateJoin.entity;

import com.job5156.framework.dao.AbstractBaseEntity;

public class post extends AbstractBaseEntity {
	private int pid;				//职位ID
	private int uid;				//公司ID
	private String UnitName;		//公司名称
	private String PostName;		//职位名称
	private String PositionName;	//职位类别
	private String Speciality;		//专业要求
	private String Degree;			//学历要求
	private String Experience;		//工作经验
	private String Age;				//年龄要求
	private String Number1;			//招聘人数
	private String Sex;				//性别要求
	private String Title;			//职称要求
	private String MonthlyPay;		//月薪水平
	private String WorkPlace;		//工作地区
	private String ReleaseDate;		//发布时间
	private String Period;			//有效期
	private String Memo;			//职责和要求
	private String VisitNum;		//访问数量
	private String postnum;
	private String LocalStation;
	private String ReleaseStation;
	private String PreStation;
	private String PushTime;
	
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUnitName() {
		return UnitName;
	}
	public void setUnitName(String unitName) {
		UnitName = unitName;
	}
	public String getPostName() {
		return PostName;
	}
	public void setPostName(String postName) {
		PostName = postName;
	}
	public String getNumber1() {
		return Number1;
	}
	public void setNumber1(String number1) {
		Number1 = number1;
	}
	public String getPositionName() {
		return PositionName;
	}
	public void setPositionName(String positionName) {
		PositionName = positionName;
	}
	public String getSpeciality() {
		return Speciality;
	}
	public void setSpeciality(String speciality) {
		Speciality = speciality;
	}
	public String getDegree() {
		return Degree;
	}
	public void setDegree(String degree) {
		Degree = degree;
	}
	public String getExperience() {
		return Experience;
	}
	public void setExperience(String experience) {
		Experience = experience;
	}
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getMonthlyPay() {
		return MonthlyPay;
	}
	public void setMonthlyPay(String monthlyPay) {
		MonthlyPay = monthlyPay;
	}
	public String getWorkPlace() {
		return WorkPlace;
	}
	public void setWorkPlace(String workPlace) {
		WorkPlace = workPlace;
	}
	public String getReleaseDate() {
		return ReleaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		ReleaseDate = releaseDate;
	}
	public String getPeriod() {
		return Period;
	}
	public void setPeriod(String period) {
		Period = period;
	}
	public String getMemo() {
		return Memo;
	}
	public void setMemo(String memo) {
		Memo = memo;
	}
	public String getVisitNum() {
		return VisitNum;
	}
	public void setVisitNum(String visitNum) {
		VisitNum = visitNum;
	}
	public String getPostnum() {
		return postnum;
	}
	public void setPostnum(String postnum) {
		this.postnum = postnum;
	}
	public String getLocalStation() {
		return LocalStation;
	}
	public void setLocalStation(String localStation) {
		LocalStation = localStation;
	}
	public String getReleaseStation() {
		return ReleaseStation;
	}
	public void setReleaseStation(String releaseStation) {
		ReleaseStation = releaseStation;
	}
	public String getPreStation() {
		return PreStation;
	}
	public void setPreStation(String preStation) {
		PreStation = preStation;
	}
	public String getPushTime() {
		return PushTime;
	}
	public void setPushTime(String pushTime) {
		PushTime = pushTime;
	}	
}
