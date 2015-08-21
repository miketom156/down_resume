package com.job5156.jsDateJoin.entity;

import java.util.Date;

import com.job5156.framework.dao.AbstractBaseEntity;
import com.job5156.util.DateUtil;

/**
 * <p>
 * 该程序是设置公司职位资料的字段变量
 * </p>
 * 
 * @author: zzk
 * @date:2006.3.6
 * @see java.util.Date;
 */
public class ComPosition extends AbstractBaseEntity {
	private Integer comid; // 公司编号
	private String comname = ""; // 公司名称
	private Integer jobfunction1; // 职位岗位类别一
	private Integer jobfunction2; // 职位岗位类别二
	private Integer jobfunction3; // 职位岗位类别三
	private String posname = ""; // 职位名称
	private Integer deptid; // 招聘部门编号
	private Integer candidatesnum; // 招聘人数
	private Date tdate = new Date();
	private String endvaliddate // 最终有效日期
	= DateUtil.dateAdd("m", 3, tdate);

	private Integer joblocation1; // 工作地区一
	private Integer joblocation2; // 工作地区二
	private Integer joblocation3; // 工作地区三
	private String posdescription = ""; // 职位描述
	private String salary; // 工资待遇
	private Integer reqdegreeid; // 学历要求（0为不限）
	private Integer reqworkyear; // 工龄要求(初始值99表示工作经验不限) edit by yanf on
									// 200-11-29
	private Integer reqsex; // 性别要求（不限0、男1、女2）
	private Integer reqage1; // 年龄要求（下限0为不限）
	private Integer reqage2 = 100; // 年龄要求（上限100为不限）
	private Integer reqlocationp; // 现所在地区要求(省)
	private Integer reqlocationc; // 现所在地区要求(市)
	private Integer langtype; // 外语语种
	private Integer langlevel; // 外语水平
	private Integer certificate; // 语言证书
	private Integer langtype2; // 语种 2 新增
	private Integer langlevel2; // 水平2 新增
	private Integer certificate2; // 语言证书2 新增
	private Integer yueyulevel; // 粤语水平
	private Integer computerlev; // 计算机能力
	private Integer certificate1; // 计算机证书
	private String examnotice = ""; // 面试须知
	private Integer examaddressp; // 面试地址（省）
	private String examaddress = ""; // 面试地址
	private Integer exampaperid; // 试题ID号
	private Integer needhunt; // 是否急聘
	private Integer ishunt; // 是否需要猎头服务[0不是，1不是]
	private Integer fltdegreeid; // 学历要求（简历过滤）
	private Integer fltworkyear; // 工龄要求（简历过滤）
	private Integer contact1; // 联系方式1
	private Integer contact2; // 联系方式2
	private String contactperson = ""; // 联系人
	private String contacttel = ""; // 联系电话
	private Integer telshowflag; // 是否显示电话资料[1为不公开，0为公开]
	private String contactfax = ""; // 传真
	private Integer faxshowflag; // 是否显示传真
	private String email = ""; // Email
	private Integer emailshowflag; // 是否显示Email(1为不公开，0为公开) 是否接收Email
	private Integer emailcodeflag; // 邮件接收方式（0为简、1为繁）
	private Integer emailattachfile; // 以附件方式接收邮件 是否显示Email 前台显示(1为不公开，0为公开)
	private Integer addressp; // 通讯地址
	private String address = ""; // 详细通讯地址
	private String zipcode = ""; // 邮政编码

	/**
	 * 职位状态: [前台] [后台] 过期 0: 公司过期导致所有职位过期 招聘 1: 正常招聘 停止 2: 停止招聘 过期 3: 已过期 删除 4:
	 * 已删除 待审核 5: 待审核[非工作时间发布的职位] 暂停 6: 未通过审核[发布不良信息的] 暂停 7: 超时屏蔽[超过1个工作日还未完善的]
	 * 招聘 8: 已审核待完善[审核后需要客户完善信息的职位] 招聘 9: 正在招聘[工作时间发布的职位]
	 */
	private Integer posstate; // 前台职位状态

	/**
	 * 1、记录前一个状态(主要是防止前台企业管理中心通过‘停止’操作来将8,9的状态变为1)。 2、当后台将职位正在招聘 审核未 已审核待完善时
	 * 记录前一个
	 */
	private Integer prevState;

	// private Integer sysPosState; //后台职位状态

	private String registerdate = ""; // 登记日期
	private String updatedate = ""; // 更新日期
	private Integer hitcounter; // 查看次数
	private Integer posflag = new Integer(1); // 职位等级(1:正式资料;2:51job资料;3:jobcn资料;4:job88资料,5.baicai资料，9.cqjob导入资料)
	private String postdate = ""; // 职位修改日期
	private Integer resumenum; // 职位收到的简历数
	private Integer fltsex; // 性别要求（简历过滤1为过滤）
	private Integer fltage; // 性别要求（简历过滤）
	private Integer updateflag; // 同步更新所有招聘信息中的联系方式
	private Integer showcontactperson; // 是否隐藏联系人
	private String busway; // 乘车路线
	private Integer extendFlag; // 扩展字段 现用于表示是否为校园职位 1是校园职位
	private Integer comUserID; // 发布职位的公司用户ID
	private Integer auditorId; // 审核者ID号 2010-03-04新增字段
	private String auditDate; // 审核时间 2010-03-24新增字段

	public Integer getComid() {
		return comid;
	}

	public void setComid(Integer comid) {
		this.comid = comid;
	}

	public String getComname() {
		return comname;
	}

	public void setComname(String comname) {
		this.comname = comname;
	}

	public Integer getJobfunction1() {
		return jobfunction1;
	}

	public void setJobfunction1(Integer jobfunction1) {
		this.jobfunction1 = jobfunction1;
	}

	public Integer getJobfunction2() {
		return jobfunction2;
	}

	public void setJobfunction2(Integer jobfunction2) {
		this.jobfunction2 = jobfunction2;
	}

	public Integer getJobfunction3() {
		return jobfunction3;
	}

	public void setJobfunction3(Integer jobfunction3) {
		this.jobfunction3 = jobfunction3;
	}

	public String getPosname() {
		return posname;
	}

	public void setPosname(String posname) {
		this.posname = posname;
	}

	public Integer getDeptid() {
		return deptid;
	}

	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}

	public Integer getCandidatesnum() {
		return candidatesnum;
	}

	public void setCandidatesnum(Integer candidatesnum) {
		this.candidatesnum = candidatesnum;
	}

	public Date getTdate() {
		return tdate;
	}

	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}

	public String getEndvaliddate() {
		return endvaliddate;
	}

	public void setEndvaliddate(String endvaliddate) {
		this.endvaliddate = endvaliddate;
	}

	public Integer getJoblocation1() {
		return joblocation1;
	}

	public void setJoblocation1(Integer joblocation1) {
		this.joblocation1 = joblocation1;
	}

	public Integer getJoblocation2() {
		return joblocation2;
	}

	public void setJoblocation2(Integer joblocation2) {
		this.joblocation2 = joblocation2;
	}

	public Integer getJoblocation3() {
		return joblocation3;
	}

	public void setJoblocation3(Integer joblocation3) {
		this.joblocation3 = joblocation3;
	}

	public String getPosdescription() {
		return posdescription;
	}

	public void setPosdescription(String posdescription) {
		this.posdescription = posdescription;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public Integer getReqdegreeid() {
		return reqdegreeid;
	}

	public void setReqdegreeid(Integer reqdegreeid) {
		this.reqdegreeid = reqdegreeid;
	}

	public Integer getReqworkyear() {
		return reqworkyear;
	}

	public void setReqworkyear(Integer reqworkyear) {
		this.reqworkyear = reqworkyear;
	}

	public Integer getReqsex() {
		return reqsex;
	}

	public void setReqsex(Integer reqsex) {
		this.reqsex = reqsex;
	}

	public Integer getReqage1() {
		return reqage1;
	}

	public void setReqage1(Integer reqage1) {
		this.reqage1 = reqage1;
	}

	public Integer getReqage2() {
		return reqage2;
	}

	public void setReqage2(Integer reqage2) {
		this.reqage2 = reqage2;
	}

	public Integer getReqlocationp() {
		return reqlocationp;
	}

	public void setReqlocationp(Integer reqlocationp) {
		this.reqlocationp = reqlocationp;
	}

	public Integer getReqlocationc() {
		return reqlocationc;
	}

	public void setReqlocationc(Integer reqlocationc) {
		this.reqlocationc = reqlocationc;
	}

	public Integer getLangtype() {
		return langtype;
	}

	public void setLangtype(Integer langtype) {
		this.langtype = langtype;
	}

	public Integer getLanglevel() {
		return langlevel;
	}

	public void setLanglevel(Integer langlevel) {
		this.langlevel = langlevel;
	}

	public Integer getCertificate() {
		return certificate;
	}

	public void setCertificate(Integer certificate) {
		this.certificate = certificate;
	}

	public Integer getLangtype2() {
		return langtype2;
	}

	public void setLangtype2(Integer langtype2) {
		this.langtype2 = langtype2;
	}

	public Integer getLanglevel2() {
		return langlevel2;
	}

	public void setLanglevel2(Integer langlevel2) {
		this.langlevel2 = langlevel2;
	}

	public Integer getCertificate2() {
		return certificate2;
	}

	public void setCertificate2(Integer certificate2) {
		this.certificate2 = certificate2;
	}

	public Integer getYueyulevel() {
		return yueyulevel;
	}

	public void setYueyulevel(Integer yueyulevel) {
		this.yueyulevel = yueyulevel;
	}

	public Integer getComputerlev() {
		return computerlev;
	}

	public void setComputerlev(Integer computerlev) {
		this.computerlev = computerlev;
	}

	public Integer getCertificate1() {
		return certificate1;
	}

	public void setCertificate1(Integer certificate1) {
		this.certificate1 = certificate1;
	}

	public String getExamnotice() {
		return examnotice;
	}

	public void setExamnotice(String examnotice) {
		this.examnotice = examnotice;
	}

	public Integer getExamaddressp() {
		return examaddressp;
	}

	public void setExamaddressp(Integer examaddressp) {
		this.examaddressp = examaddressp;
	}

	public String getExamaddress() {
		return examaddress;
	}

	public void setExamaddress(String examaddress) {
		this.examaddress = examaddress;
	}

	public Integer getExampaperid() {
		return exampaperid;
	}

	public void setExampaperid(Integer exampaperid) {
		this.exampaperid = exampaperid;
	}

	public Integer getNeedhunt() {
		return needhunt;
	}

	public void setNeedhunt(Integer needhunt) {
		this.needhunt = needhunt;
	}

	public Integer getIshunt() {
		return ishunt;
	}

	public void setIshunt(Integer ishunt) {
		this.ishunt = ishunt;
	}

	public Integer getFltdegreeid() {
		return fltdegreeid;
	}

	public void setFltdegreeid(Integer fltdegreeid) {
		this.fltdegreeid = fltdegreeid;
	}

	public Integer getFltworkyear() {
		return fltworkyear;
	}

	public void setFltworkyear(Integer fltworkyear) {
		this.fltworkyear = fltworkyear;
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

	public String getContactperson() {
		return contactperson;
	}

	public void setContactperson(String contactperson) {
		this.contactperson = contactperson;
	}

	public String getContacttel() {
		return contacttel;
	}

	public void setContacttel(String contacttel) {
		this.contacttel = contacttel;
	}

	public Integer getTelshowflag() {
		return telshowflag;
	}

	public void setTelshowflag(Integer telshowflag) {
		this.telshowflag = telshowflag;
	}

	public String getContactfax() {
		return contactfax;
	}

	public void setContactfax(String contactfax) {
		this.contactfax = contactfax;
	}

	public Integer getFaxshowflag() {
		return faxshowflag;
	}

	public void setFaxshowflag(Integer faxshowflag) {
		this.faxshowflag = faxshowflag;
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

	public Integer getEmailcodeflag() {
		return emailcodeflag;
	}

	public void setEmailcodeflag(Integer emailcodeflag) {
		this.emailcodeflag = emailcodeflag;
	}

	public Integer getEmailattachfile() {
		return emailattachfile;
	}

	public void setEmailattachfile(Integer emailattachfile) {
		this.emailattachfile = emailattachfile;
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

	public Integer getPosstate() {
		return posstate;
	}

	public void setPosstate(Integer posstate) {
		this.posstate = posstate;
	}

	public Integer getPrevState() {
		return prevState;
	}

	public void setPrevState(Integer prevState) {
		this.prevState = prevState;
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

	public Integer getHitcounter() {
		return hitcounter;
	}

	public void setHitcounter(Integer hitcounter) {
		this.hitcounter = hitcounter;
	}

	public Integer getPosflag() {
		return posflag;
	}

	public void setPosflag(Integer posflag) {
		this.posflag = posflag;
	}

	public String getPostdate() {
		return postdate;
	}

	public void setPostdate(String postdate) {
		this.postdate = postdate;
	}

	public Integer getResumenum() {
		return resumenum;
	}

	public void setResumenum(Integer resumenum) {
		this.resumenum = resumenum;
	}

	public Integer getFltsex() {
		return fltsex;
	}

	public void setFltsex(Integer fltsex) {
		this.fltsex = fltsex;
	}

	public Integer getFltage() {
		return fltage;
	}

	public void setFltage(Integer fltage) {
		this.fltage = fltage;
	}

	public Integer getUpdateflag() {
		return updateflag;
	}

	public void setUpdateflag(Integer updateflag) {
		this.updateflag = updateflag;
	}

	public Integer getShowcontactperson() {
		return showcontactperson;
	}

	public void setShowcontactperson(Integer showcontactperson) {
		this.showcontactperson = showcontactperson;
	}

	public String getBusway() {
		return busway;
	}

	public void setBusway(String busway) {
		this.busway = busway;
	}

	public Integer getExtendFlag() {
		return extendFlag;
	}

	public void setExtendFlag(Integer extendFlag) {
		this.extendFlag = extendFlag;
	}

	public Integer getComUserID() {
		return comUserID;
	}

	public void setComUserID(Integer comUserID) {
		this.comUserID = comUserID;
	}

	public Integer getAuditorId() {
		return auditorId;
	}

	public void setAuditorId(Integer auditorId) {
		this.auditorId = auditorId;
	}

	public String getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(String auditDate) {
		this.auditDate = auditDate;
	}
}
