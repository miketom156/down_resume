package  com.job5156.jsDateJoin.entity;
import java.util.Set;

import com.job5156.framework.dao.AbstractBaseEntity;
public class ComUserInfo  extends AbstractBaseEntity
{
    private Integer comid;
    private Integer deptid;
    private String username;
    private String password;
    private boolean isadmin;    
    private String registerdate;
    private String updatedate;
    private String lastLogindate;
    private String lastLoginip;    
    private Integer loginnum;
    private String menu;
    private Integer safeSet;   //��ȫ����,Ĭ�ϲ�����ͬһ�ʺ�ͬʱ����.�û������Լ�����.��Ϊ1ʱ����ͬʱ���� by wufalong 9-14
    private Integer countNum; //�����ܵĵ��� ���ʺ�Ϊ���ʺŷ�������鿴���� by wfl 2008-5-7
    private Integer usedNum;  // ��ʹ�õ��� by wfl 2008-5-7
    private Integer isCount;  // �Ƿ����ͳ�� by wfl 2008-5-7
    private Integer countPosNum;  // �ɷ���ְλ�� by wfl 2008-5-7
    private Integer flag;     //��Ƿֹ�˾�˺�[0-�����˺� 1-�ֹ�˾�˺�] by yanf 2011-4-13
    
    
	public Integer getComid() {
		return comid;
	}
	public void setComid(Integer comid) {
		this.comid = comid;
	}
	public Integer getDeptid() {
		return deptid;
	}
	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isIsadmin() {
		return isadmin;
	}
	public void setIsadmin(boolean isadmin) {
		this.isadmin = isadmin;
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
	public String getLastLogindate() {
		return lastLogindate;
	}
	public void setLastLogindate(String lastLogindate) {
		this.lastLogindate = lastLogindate;
	}
	public String getLastLoginip() {
		return lastLoginip;
	}
	public void setLastLoginip(String lastLoginip) {
		this.lastLoginip = lastLoginip;
	}
	public Integer getLoginnum() {
		return loginnum;
	}
	public void setLoginnum(Integer loginnum) {
		this.loginnum = loginnum;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public Integer getSafeSet() {
		return safeSet;
	}
	public void setSafeSet(Integer safeSet) {
		this.safeSet = safeSet;
	}
	public Integer getCountNum() {
		return countNum;
	}
	public void setCountNum(Integer countNum) {
		this.countNum = countNum;
	}
	public Integer getUsedNum() {
		return usedNum;
	}
	public void setUsedNum(Integer usedNum) {
		this.usedNum = usedNum;
	}
	public Integer getIsCount() {
		return isCount;
	}
	public void setIsCount(Integer isCount) {
		this.isCount = isCount;
	}
	public Integer getCountPosNum() {
		return countPosNum;
	}
	public void setCountPosNum(Integer countPosNum) {
		this.countPosNum = countPosNum;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}    
}
