package  com.job5156.jsDateJoin.entity;
import com.job5156.framework.dao.AbstractBaseEntity;
public class PersonSchool  extends AbstractBaseEntity
{
  private  Integer userid;
  private  Integer degree;         //ѧ������/��ѵ
  private  Integer begindateyear;  //��ʼ���
  private  Integer begindatemonth; ///��ʼ�·�
  private  Integer enddateyear;   //�������
  private  Integer enddatemonth;  //�����·�
  private  String school;         //ѧУ��
  private  String speciality;     //רҵ����
  private  String certificate;    //֤������
  private  String cre_date;       //��������
  private  String rev_date;       //�޸�����
  private  String course;         //���޿�Ŀ�ɼ���
  private  Integer flag;  		   //�Ƿ����ڶ�

  //private  PersonBaseInfo person;         //���˻�����Ϣ��
/**
 * @return Returns the begindatemonth.
 */
public Integer getBegindatemonth() {
    return begindatemonth;
}
/**
 * @param begindatemonth The begindatemonth to set.
 */
public void setBegindatemonth(Integer begindatemonth) {
    this.begindatemonth = begindatemonth;
}
/**
 * @return Returns the begindateyear.
 */
public Integer getBegindateyear() {
    return begindateyear;
}
/**
 * @param begindateyear The begindateyear to set.
 */
public void setBegindateyear(Integer begindateyear) {
    this.begindateyear = begindateyear;
}

/**
 * @return Returns the certificate.
 */
public String getCertificate() {
    return certificate;
}
/**
 * @param certificate The certificate to set.
 */
public void setCertificate(String certificate) {
    this.certificate = certificate;
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
 * @return Returns the degree.
 */
public Integer getDegree() {
    return degree;
}
/**
 * @param degree The degree to set.
 */
public void setDegree(Integer degree) {
    this.degree = degree;
}
/**
 * @return Returns the enddatemonth.
 */
public Integer getEnddatemonth() {
    return enddatemonth;
}
/**
 * @param enddatemonth The enddatemonth to set.
 */
public void setEnddatemonth(Integer enddatemonth) {
    this.enddatemonth = enddatemonth;
}
/**
 * @return Returns the enddateyear.
 */
public Integer getEnddateyear() {
    return enddateyear;
}
/**
 * @param enddateyear The enddateyear to set.
 */
public void setEnddateyear(Integer enddateyear) {
    this.enddateyear = enddateyear;
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
 * @return Returns the school.
 */
public String getSchool() {
    return school;
}
/**
 * @param school The school to set.
 */
public void setSchool(String school) {
    this.school = school;
}
/**
 * @return Returns the speciality.
 */
public String getSpeciality() {
    return speciality;
}
/**
 * @param speciality The speciality to set.
 */
public void setSpeciality(String speciality) {
    this.speciality = speciality;
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
 * @return Returns the course.
 */
public String getCourse() {
	return course;
}
/**
 * @param course The course to set.
 */
public void setCourse(String course) {
	this.course = course;
}

/**
 * @return Returns the flag.
 */
public Integer getFlag() {
	return flag;
}
/**
 * @param flag The flag to set.
 */
public void setFlag(Integer flag) {
	this.flag = flag;
}
}
