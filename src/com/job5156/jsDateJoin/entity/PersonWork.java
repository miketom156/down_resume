package  com.job5156.jsDateJoin.entity;
import com.job5156.framework.dao.AbstractBaseEntity;
public class PersonWork  extends AbstractBaseEntity
{
  private  Integer userid;
  private  Integer begindateyear;
  private  Integer begindatemonth;
  private  Integer enddateyear;
  private  Integer enddatemonth;
  private  String comname;
  private  Integer comtype;	//公司性质
  private  Integer comcalling;	//公司行业
  private  Integer maincatalog;
  private  Integer jobfunctionid;
  private  String salary;
  private  Integer flag;	//是否仍在职 5.社会实践 6.工作经验(分站点)by zhangt 2009-5-1
  private  String otherposition;
  private  String description;
  private  String leftreason;
  private  String cre_date;
  private  String rev_date;
  //private  PersonBaseInfo person;         //个人基本信息表
  
  public Integer getUserid()
  {
     return userid;
  }
  public void setUserid(Integer userid)
  {
     this.userid=userid;
  }
  public Integer getBegindateyear()
  {
     return begindateyear;
  }
  public void setBegindateyear(Integer begindateyear)
  {
     this.begindateyear=begindateyear;
  }

  public Integer getBegindatemonth()
  {
     return begindatemonth;
  }
  public void setBegindatemonth(Integer begindatemonth)
  {
     this.begindatemonth=begindatemonth;
  }
  public Integer getEnddateyear()
  {
     return enddateyear;
  }
  public void setEnddateyear(Integer enddateyear)
  {
     this.enddateyear=enddateyear;
  }
  public Integer getEnddatemonth()
  {
     return enddatemonth;
  }
  public void setEnddatemonth(Integer enddatemonth)
  {
     this.enddatemonth=enddatemonth;
  }
  public String getComname()
  {
     return comname;
  }
  public void setComname(String comname)
  {
     this.comname=comname;
  }
  public Integer getComtype()
  {
     return comtype;
  }
  public void setComtype(Integer comtype)
  {
     this.comtype=comtype;
  }
  public Integer getComcalling()
  {
     return comcalling;
  }
  public void setComcalling(Integer comcalling)
  {
     this.comcalling=comcalling;
  }
  public Integer getMaincatalog()
  {
     return maincatalog;
  }
  public void setMaincatalog(Integer maincatalog)
  {
     this.maincatalog=maincatalog;
  }
  public Integer getJobfunctionid()
  {
     return jobfunctionid;
  }
  public void setJobfunctionid(Integer jobfunctionid)
  {
     this.jobfunctionid=jobfunctionid;
  }
  public String getOtherposition()
  {
     return otherposition;
  }
  public void setOtherposition(String otherposition)
  {
     this.otherposition=otherposition;
  }
  public String getDescription()
  {
     return description;
  }
  public void setDescription(String description)
  {
     this.description=description;
  }
  public String getLeftreason()
  {
     return leftreason;
  }
  public void setLeftreason(String leftreason)
  {
     this.leftreason=leftreason;
  }
  public String getCre_date()
  {
     return cre_date;
  }
  public void setCre_date(String cre_date)
  {
     this.cre_date=cre_date;
  }
  public String getRev_date()
  {
     return rev_date;
  }
  public void setRev_date(String rev_date)
  {
     this.rev_date=rev_date;
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
