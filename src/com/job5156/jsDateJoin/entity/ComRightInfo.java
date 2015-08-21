package  com.job5156.jsDateJoin.entity;
import com.job5156.framework.dao.AbstractBaseEntity;
public class ComRightInfo  extends AbstractBaseEntity
{
  private  Integer comid;                //公司ID
  private  Integer memberclass;          //会员类型[1-试用会员 2-一月期会员 3-三月期会员 4-半年期会员 5-一年期会员 6-导入企业会员 7-终止企业会员]
  private  Integer othermember;          //扩展类型[1-LOGO会员 2-热门推荐会员 11-体验会员 21-点数自定义会员]
  private  String beginvaliddate;        //开始日期
  private  String endvaliddate;          //终止日期
  private  Integer maxposnum;            //发布职位[-1:不限]
  private  Integer maxresumenum;         //查看简历(个/月)
  private  Integer viewingresume;        //当月已用点数
  private  Integer viewedresume;         //已用点数
  private  String checkuser;             //后台操作人姓名
  private  String checkdate;             //后台操作时间
  private  Integer maxmsgnum;            
  private  Integer msgingnum;
  private  Integer saler;                //业务员id
  private  Integer displayflag;          //是否显示企业联系方式[1-是 0-否]
  private  Integer money;                //购买金额 
  private  Integer countnum;             //(一共)购买点数
  private  Integer usenum;               //(一共)使用点数
  private  String mark;                  //备注
  private  Integer displayflagsee;       //是否查看简历联系方式[1-是 0-否]
  private  String creDate;               //后台创建日期
  private  String creUserName;           //后台创建人姓名
  private  String restrictArea;          //限制区域
  private  Integer accountNum;			 //最大子账号数
  private  Integer careergo; 			 //是否允许进入事业起点 0：不可以 1：可以
  
  
  private ComBaseInfo comBaseInfo;

  
  
public Integer getAccountNum() {
	return accountNum;
}
public void setAccountNum(Integer accountNum) {
	this.accountNum = accountNum;
}
/**
 * @return the creDate
 */
public String getCreDate()
{
	return creDate;
}
/**
 * @param creDate the creDate to set
 */
public void setCreDate(String creDate)
{
	this.creDate = creDate;
}
/**
 * @return the creUserName
 */
public String getCreUserName()
{
	return creUserName;
}
/**
 * @param creUserName the creUserName to set
 */
public void setCreUserName(String creUserName)
{
	this.creUserName = creUserName;
}
/**
 * @return Returns the othermember.
 */
public Integer getOthermember() {
    return othermember;
}
/**
 * @param othermember The othermember to set.
 */
public void setOthermember(Integer othermember) {
    this.othermember = othermember;
}
    /**
     * @return Returns the comBaseInfo.
     */
    public ComBaseInfo getComBaseInfo() {
        return comBaseInfo;
    }
    /**
     * @param comBaseInfo The comBaseInfo to set.
     */
    public void setComBaseInfo(ComBaseInfo comBaseInfo) {
        this.comBaseInfo = comBaseInfo;
    }
    
	/**
	 * @return Returns the comid.
	 */
	public Integer getComid() {
		return comid;
	}
	/**
	 * @param comid The comid to set.
	 */
	public void setComid(Integer comid) {
		this.comid = comid;
	}
  public Integer getMemberclass()
  {
     return memberclass;
  }
  public void setMemberclass(Integer memberclass)
  {
     this.memberclass=memberclass;
  }
  public String getBeginvaliddate()
  {
     return beginvaliddate;
  }
  public void setBeginvaliddate(String beginvaliddate)
  {
     this.beginvaliddate=beginvaliddate;
  }
  public String getEndvaliddate()
  {
     return endvaliddate;
  }
  public void setEndvaliddate(String endvaliddate)
  {
     this.endvaliddate=endvaliddate;
  }
  public Integer getMaxposnum()
  {
     return maxposnum;
  }
  public void setMaxposnum(Integer maxposnum)
  {
     this.maxposnum=maxposnum;
  }
  public Integer getMaxresumenum()
  {
     return maxresumenum;
  }
  public void setMaxresumenum(Integer maxresumenum)
  {
     this.maxresumenum=maxresumenum;
  }
  public Integer getViewingresume()
  {
     return viewingresume;
  }
  public void setViewingresume(Integer viewingresume)
  {
     this.viewingresume=viewingresume;
  }
  public Integer getViewedresume()
  {
     return viewedresume;
  }
  public void setViewedresume(Integer viewedresume)
  {
     this.viewedresume=viewedresume;
  }
  public String getCheckuser()
  {
     return checkuser;
  }
  public void setCheckuser(String checkuser)
  {
     this.checkuser=checkuser;
  }
  public String getCheckdate()
  {
     return checkdate;
  }
  public void setCheckdate(String checkdate)
  {
     this.checkdate=checkdate;
  }
  public Integer getMaxmsgnum()
  {
     return maxmsgnum;
  }
  public void setMaxmsgnum(Integer maxmsgnum)
  {
     this.maxmsgnum=maxmsgnum;
  }
  public Integer getMsgingnum()
  {
     return msgingnum;
  }
  public void setMsgingnum(Integer msgingnum)
  {
     this.msgingnum=msgingnum;
  }
  public Integer getSaler()
  {
     return saler;
  }
  public void setSaler(Integer saler)
  {
     this.saler=saler;
  }
  public Integer getDisplayflag()
  {
     return displayflag;
  }
  public void setDisplayflag(Integer displayflag)
  {
     this.displayflag=displayflag;
  }
  public Integer getMoney()
  {
     return money;
  }
  public void setMoney(Integer money)
  {
     this.money=money;
  }
  public Integer getCountnum()
  {
     return countnum;
  }
  public void setCountnum(Integer countnum)
  {
     this.countnum=countnum;
  }
  public Integer getUsenum()
  {
     return usenum;
  }
  public void setUsenum(Integer usenum)
  {
     this.usenum=usenum;
  }
  public String getMark()
  {
     return mark;
  }
  public void setMark(String mark)
  {
     this.mark=mark;
  }
  public Integer getDisplayflagsee()
  {
     return displayflagsee;
  }
  public void setDisplayflagsee(Integer displayflagsee)
  {
     this.displayflagsee=displayflagsee;
  }
/**
 * @return the restrictArea
 */
public String getRestrictArea() {
	return restrictArea;
}
/**
 * @param restrictArea the restrictArea to set
 */
public void setRestrictArea(String restrictArea) {
	this.restrictArea = restrictArea;
}

public Integer getCareergo() {
	return careergo;
}
public void setCareergo(Integer careergo) {
	this.careergo = careergo;
}
}
