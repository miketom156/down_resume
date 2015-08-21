package  com.job5156.jsDateJoin.entity;
import com.job5156.framework.dao.AbstractBaseEntity;
/**
 * 个人求职意向实体类
 * @author zzk
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class PersonIntent  extends AbstractBaseEntity
{
  private  Integer userid; 
  private  String rev_date;
  private  String cre_date;
  
  private  Integer workyear;      //从业经验
  private  Integer workyear1;     //从业经验1
  private  String workcalling;    //公司类别 从业类别
  private  String workcalling1;  
  private  Integer jobcode1;      //期望工作职位
  private  Integer jobcode2;
  private  Integer jobcode3;
  private  Integer joblocation1;   //期望工作地点
  private  Integer joblocation2;
  private  Integer joblocation3;
  private  String salary;         //期望薪水
  private  Integer neededhouse;    //提供住房
  private  String otherrequirement;  //其他要求
  private  Integer checkindate;      //到岗时间
  private  String checkindate1;      //到岗时间1
  
  private Integer state ;//就业状态    1：正在找工作  2：有机会考虑看看 3：暂时不考虑 
  private String otherjob1;  //其它职位1
  private String otherjob2;
  private String otherjob3;
  
  //private  PersonBaseInfo person;         //个人基本信息表  

  
/**
 * @return Returns the checkindate.
 */
public Integer getCheckindate() {
    return checkindate;
}
/**
 * @param checkindate The checkindate to set.
 */
public void setCheckindate(Integer checkindate) {
    this.checkindate = checkindate;
}
/**
 * @return Returns the checkindate1.
 */
public String getCheckindate1() {
    return checkindate1;
}
/**
 * @param checkindate1 The checkindate1 to set.
 */
public void setCheckindate1(String checkindate1) {
    this.checkindate1 = checkindate1;
}

/**
 * @return Returns the cre_date.
 */
public String getCre_date() {
    return cre_date;
}
/**
 * @param cre_date The cre_date to set.
 */
public void setCre_date(String cre_date) {
    this.cre_date = cre_date;
}

/**
 * @return Returns the jobcode1.
 */
public Integer getJobcode1() {
    return jobcode1;
}
/**
 * @param jobcode1 The jobcode1 to set.
 */
public void setJobcode1(Integer jobcode1) {
    this.jobcode1 = jobcode1;
}
/**
 * @return Returns the jobcode2.
 */
public Integer getJobcode2() {
    return jobcode2;
}
/**
 * @param jobcode2 The jobcode2 to set.
 */
public void setJobcode2(Integer jobcode2) {
    this.jobcode2 = jobcode2;
}
/**
 * @return Returns the jobcode3.
 */
public Integer getJobcode3() {
    return jobcode3;
}
/**
 * @param jobcode3 The jobcode3 to set.
 */
public void setJobcode3(Integer jobcode3) {
    this.jobcode3 = jobcode3;
}
/**
 * @return Returns the joblocation1.
 */
public Integer getJoblocation1() {
    return joblocation1;
}
/**
 * @param joblocation1 The joblocation1 to set.
 */
public void setJoblocation1(Integer joblocation1) {
    this.joblocation1 = joblocation1;
}
/**
 * @return Returns the joblocation2.
 */
public Integer getJoblocation2() {
    return joblocation2;
}
/**
 * @param joblocation2 The joblocation2 to set.
 */
public void setJoblocation2(Integer joblocation2) {
    this.joblocation2 = joblocation2;
}
/**
 * @return Returns the joblocation3.
 */
public Integer getJoblocation3() {
    return joblocation3;
}
/**
 * @param joblocation3 The joblocation3 to set.
 */
public void setJoblocation3(Integer joblocation3) {
    this.joblocation3 = joblocation3;
}
/**
 * @return Returns the neededhouse.
 */
public Integer getNeededhouse() {
    return neededhouse;
}
/**
 * @param neededhouse The neededhouse to set.
 */
public void setNeededhouse(Integer neededhouse) {
    this.neededhouse = neededhouse;
}
/**
 * @return Returns the otherrequirement.
 */
public String getOtherrequirement() {
    return otherrequirement;
}
/**
 * @param otherrequirement The otherrequirement to set.
 */
public void setOtherrequirement(String otherrequirement) {
    this.otherrequirement = otherrequirement;
}

/**
 * @return Returns the rev_date.
 */
public String getRev_date() {
    return rev_date;
}
/**
 * @param rev_date The rev_date to set.
 */
public void setRev_date(String rev_date) {
    this.rev_date = rev_date;
}
/**
 * @return Returns the salary.
 */
public String getSalary() {
    return salary;
}
/**
 * @param salary The salary to set.
 */
public void setSalary(String salary) {
    this.salary = salary;
}
/**
 * @return Returns the userid.
 */
public Integer getUserid() {
    return userid;
}
/**
 * @param userid The userid to set.
 */
public void setUserid(Integer userid) {
    this.userid = userid;
}
/**
 * @return Returns the workcalling.
 */
public String getWorkcalling() {
    return workcalling;
}
/**
 * @param workcalling The workcalling to set.
 */
public void setWorkcalling(String workcalling) {
    this.workcalling = workcalling;
}
/**
 * @return Returns the workcalling1.
 */
public String getWorkcalling1() {
    return workcalling1;
}
/**
 * @param workcalling1 The workcalling1 to set.
 */
public void setWorkcalling1(String workcalling1) {
    this.workcalling1 = workcalling1;
}
/**
 * @return Returns the workyear.
 */
public Integer getWorkyear() {
    return workyear;
}
/**
 * @param workyear The workyear to set.
 */
public void setWorkyear(Integer workyear) {
    this.workyear = workyear;
}
/**
 * @return Returns the workyear1.
 */
public Integer getWorkyear1() {
    return workyear1;
}
/**
 * @param workyear1 The workyear1 to set.
 */
public void setWorkyear1(Integer workyear1) {
    this.workyear1 = workyear1;
}
/**
 * @return Returns the otherjob1.
 */
public String getOtherjob1() {
	return otherjob1;
}
/**
 * @param otherjob1 The otherjob1 to set.
 */
public void setOtherjob1(String otherjob1) {
	this.otherjob1 = otherjob1;
}
/**
 * @return Returns the otherjob2.
 */
public String getOtherjob2() {
	return otherjob2;
}
/**
 * @param otherjob2 The otherjob2 to set.
 */
public void setOtherjob2(String otherjob2) {
	this.otherjob2 = otherjob2;
}
/**
 * @return Returns the otherjob3.
 */
public String getOtherjob3() {
	return otherjob3;
}
/**
 * @param otherjob3 The otherjob3 to set.
 */
public void setOtherjob3(String otherjob3) {
	this.otherjob3 = otherjob3;
}

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
