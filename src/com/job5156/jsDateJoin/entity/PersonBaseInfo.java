package  com.job5156.jsDateJoin.entity;
import com.job5156.framework.dao.AbstractBaseEntity;
public class PersonBaseInfo  extends AbstractBaseEntity
{

  private  String useraccounts;                    //帐    号 
  private  String userpassword;                    //密    码
  private  String username;                        //姓    名
  private  Integer sex;                            //性    别
  private  String nation;                          //民    族
  private  Integer marriage;                       //婚姻状况
  private  String birthday;                        //出生日期
  private  Integer stature;                        //身    高
  private Integer weight;							//体   重
  private  Integer cardtype;                       //证件类型
  private  String cardtypenum;                     //证件号码
  private  Integer hometown_p;                     //户口所在地-省
  private  Integer hometown_c;                     //户口所在地-市
  private  Integer location_p;                     //现所在地-省
  private  Integer location_c;                     //现所在地-市
  private  Integer contact1;                       //主要联系方式(选择项)
  private  Integer contact2;                       //后备联系方式(选择项)
  private  String phone;                           //后备联系方式(值)
  private  Integer hiddenphone;                    //是否隐藏后备联系方式
  private  String mobile;                          //主要联系方式(值)
  private  Integer hiddenmobile;                   //是否隐藏主要联系方式
  private  String email;                           //电子邮件
  private  Integer hiddenemail;                    //保密
  private  String im;
  private  String address;                         //地址
  private  String zipcode;                         //邮政编码
  private  Integer highdegree;                     //最高学历
  private  String special;                         //专业
  private  String school;                          //院校
  private  String homepage;                        //主页
  private  String cre_date;                        //创建时间
  private  String rev_date;                        //登陆时间
  private  String fre_date;                        //刷新时间
  private  Integer pass;                           //现在使用的(0-未审核 1-已开通 2-审核不合格 3-未开通 4-暂时开通 20-封锁 100-自杀式简历，不让登录) 以前使用的(0-未审核 1-已开通 2-审核不合格 3-未开通)
  private  Integer flag;                           //简历保密　0:完全公开　1:完全保密　2:公开但联系方式保密
  private  Integer readcount;                      //被企业查看次数                      
  private  Integer logincount;                     //登陆次数
  private  Integer resume_set;                     //简历模版 ，因没有用到此字段，所以用它来存简历更新提示设置，0表示超过15天没有更新就提示，1表示永不提示。
  private  String selfappraise;                    //自我评价
  private  Integer jobyear;                        //工作年限
  private  Integer jobmonth;                       //工作月数
  private  Integer jobcount;                       //服务公司数 
  private  Integer resumetype;                     //简历类型（1:学生，0:社会人士等,3:长沙简历）
  private  String comid;                           //过滤企业ID
  private  Integer resume_grade;                   //简历等级.0-普通,1-精英(猎头) 2-模具人才. 101:中高级人才（进查询库）  105:中高级人才(保密级不进查询库)
  private  String lasteditby;                      //修改人
  private  String lastedit;                        //修改时间
  private  String passdate;                        //开通时间
  private  Integer comefrom;                       //来自哪里，如从阳光网注册的简历是2
  private  Integer havephoto;                      //是否有照片(1有;0无)  
  private  String ip;                              //来访IP
  private  Integer emailwilling;                   //是否愿意接受来自智通人才风的资讯1-愿意，0不愿意EmailWilling
  private  Integer changeresumewilling;            //是否愿意将在job5156上简历被交换给其它网站0不愿意EmailWilling，默认为愿意
  private  Integer vipMember;                      //是否为vipMember会员1是，0否
  private  Integer receiveShortMsg;                //是否接收来自网站的短信 默认接收，，1为不接收
  private  String menu;                            //2008-6-23 by wfl  用来表示简历模板 0-6 默认为0
  private  String recommendName;                   //猎头推荐人
  private  String recommendPhone;                  //猎头推荐人联系方式
  
  private  Integer adduserid;                      //增加的用户ID，如果不为null，则表示是由后台录入的简历.2007-2-22,徐润增加
  private  String perfectInfo;                     //跟踪用户的完善信息,例[1-true:2-false:3-true:4-false]
  private  Integer openResumeEn;                   //是否开放英文简历[0-不开放 1-开放]
  private  Integer political;                      //新增－－政治面貌by zhangt 2009-4-20
	public String getUseraccounts() {
		return useraccounts;
	}
	public void setUseraccounts(String useraccounts) {
		this.useraccounts = useraccounts;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public Integer getMarriage() {
		return marriage;
	}
	public void setMarriage(Integer marriage) {
		this.marriage = marriage;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
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
	public Integer getCardtype() {
		return cardtype;
	}
	public void setCardtype(Integer cardtype) {
		this.cardtype = cardtype;
	}
	public String getCardtypenum() {
		return cardtypenum;
	}
	public void setCardtypenum(String cardtypenum) {
		this.cardtypenum = cardtypenum;
	}
	public Integer getHometown_p() {
		return hometown_p;
	}
	public void setHometown_p(Integer hometown_p) {
		this.hometown_p = hometown_p;
	}
	public Integer getHometown_c() {
		return hometown_c;
	}
	public void setHometown_c(Integer hometown_c) {
		this.hometown_c = hometown_c;
	}
	public Integer getLocation_p() {
		return location_p;
	}
	public void setLocation_p(Integer location_p) {
		this.location_p = location_p;
	}
	public Integer getLocation_c() {
		return location_c;
	}
	public void setLocation_c(Integer location_c) {
		this.location_c = location_c;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getHiddenphone() {
		return hiddenphone;
	}
	public void setHiddenphone(Integer hiddenphone) {
		this.hiddenphone = hiddenphone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getHiddenmobile() {
		return hiddenmobile;
	}
	public void setHiddenmobile(Integer hiddenmobile) {
		this.hiddenmobile = hiddenmobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getHiddenemail() {
		return hiddenemail;
	}
	public void setHiddenemail(Integer hiddenemail) {
		this.hiddenemail = hiddenemail;
	}
	public String getIm() {
		return im;
	}
	public void setIm(String im) {
		this.im = im;
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
	public Integer getHighdegree() {
		return highdegree;
	}
	public void setHighdegree(Integer highdegree) {
		this.highdegree = highdegree;
	}
	public String getSpecial() {
		return special;
	}
	public void setSpecial(String special) {
		this.special = special;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getCre_date() {
		return cre_date;
	}
	public void setCre_date(String cre_date) {
		this.cre_date = cre_date;
	}
	public String getRev_date() {
		return rev_date;
	}
	public void setRev_date(String rev_date) {
		this.rev_date = rev_date;
	}
	public String getFre_date() {
		return fre_date;
	}
	public void setFre_date(String fre_date) {
		this.fre_date = fre_date;
	}
	public Integer getPass() {
		return pass;
	}
	public void setPass(Integer pass) {
		this.pass = pass;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public Integer getReadcount() {
		return readcount;
	}
	public void setReadcount(Integer readcount) {
		this.readcount = readcount;
	}
	public Integer getLogincount() {
		return logincount;
	}
	public void setLogincount(Integer logincount) {
		this.logincount = logincount;
	}
	public Integer getResume_set() {
		return resume_set;
	}
	public void setResume_set(Integer resume_set) {
		this.resume_set = resume_set;
	}
	public String getSelfappraise() {
		return selfappraise;
	}
	public void setSelfappraise(String selfappraise) {
		this.selfappraise = selfappraise;
	}
	public Integer getJobyear() {
		return jobyear;
	}
	public void setJobyear(Integer jobyear) {
		this.jobyear = jobyear;
	}
	public Integer getJobmonth() {
		return jobmonth;
	}
	public void setJobmonth(Integer jobmonth) {
		this.jobmonth = jobmonth;
	}
	public Integer getJobcount() {
		return jobcount;
	}
	public void setJobcount(Integer jobcount) {
		this.jobcount = jobcount;
	}
	public Integer getResumetype() {
		return resumetype;
	}
	public void setResumetype(Integer resumetype) {
		this.resumetype = resumetype;
	}
	public String getComid() {
		return comid;
	}
	public void setComid(String comid) {
		this.comid = comid;
	}
	public Integer getResume_grade() {
		return resume_grade;
	}
	public void setResume_grade(Integer resume_grade) {
		this.resume_grade = resume_grade;
	}
	public String getLasteditby() {
		return lasteditby;
	}
	public void setLasteditby(String lasteditby) {
		this.lasteditby = lasteditby;
	}
	public String getLastedit() {
		return lastedit;
	}
	public void setLastedit(String lastedit) {
		this.lastedit = lastedit;
	}
	public String getPassdate() {
		return passdate;
	}
	public void setPassdate(String passdate) {
		this.passdate = passdate;
	}
	public Integer getComefrom() {
		return comefrom;
	}
	public void setComefrom(Integer comefrom) {
		this.comefrom = comefrom;
	}
	public Integer getHavephoto() {
		return havephoto;
	}
	public void setHavephoto(Integer havephoto) {
		this.havephoto = havephoto;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Integer getEmailwilling() {
		return emailwilling;
	}
	public void setEmailwilling(Integer emailwilling) {
		this.emailwilling = emailwilling;
	}
	public Integer getChangeresumewilling() {
		return changeresumewilling;
	}
	public void setChangeresumewilling(Integer changeresumewilling) {
		this.changeresumewilling = changeresumewilling;
	}
	public Integer getVipMember() {
		return vipMember;
	}
	public void setVipMember(Integer vipMember) {
		this.vipMember = vipMember;
	}
	public Integer getReceiveShortMsg() {
		return receiveShortMsg;
	}
	public void setReceiveShortMsg(Integer receiveShortMsg) {
		this.receiveShortMsg = receiveShortMsg;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
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
	public Integer getAdduserid() {
		return adduserid;
	}
	public void setAdduserid(Integer adduserid) {
		this.adduserid = adduserid;
	}
	public String getPerfectInfo() {
		return perfectInfo;
	}
	public void setPerfectInfo(String perfectInfo) {
		this.perfectInfo = perfectInfo;
	}
	public Integer getOpenResumeEn() {
		return openResumeEn;
	}
	public void setOpenResumeEn(Integer openResumeEn) {
		this.openResumeEn = openResumeEn;
	}
	public Integer getPolitical() {
		return political;
	}
	public void setPolitical(Integer political) {
		this.political = political;
	} 
}
