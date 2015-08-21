package com.job5156.jsDateJoin.event;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.job5156.jsDateJoin.entity.person;
import com.job5156.server.EntityManager;
import com.job5156.server.LocalSessionManager;
import com.job5156.util.StringUtil;

public class InputPersonData {
	private static Logger log = Logger.getLogger(InputPersonData.class);
	private static String[][] OPT_Person={
		{"1", "F:/jsInpuDate/1.XLS",""},
		{"2", "F:/jsInpuDate/2.XLS",""},
		{"3", "F:/jsInpuDate/3.XLS",""},
		{"4", "F:/jsInpuDate/4.XLS",""},
		{"5", "F:/jsInpuDate/5.XLS",""},
		{"6", "F:/jsInpuDate/6.XLS",""},
		{"7", "F:/jsInpuDate/7.XLS",""},
		{"8", "F:/jsInpuDate/8.XLS",""},
		{"9", "F:/jsInpuDate/9.XLS",""},
		{"10", "F:/jsInpuDate/10.XLS",""},
		{"11", "F:/jsInpuDate/11.XLS",""},
		{"12", "F:/jsInpuDate/12.XLS",""},
		{"13", "F:/jsInpuDate/13.XLS",""},
		{"14", "F:/jsInpuDate/14.XLS",""}	
		
	};
	
	public static void main(String[] args) {
		System.out.println("----------江苏人才网 个人数据 导入本地数据库 开始！--------------");
		long begintime = System.currentTimeMillis();
		Session localsession  = LocalSessionManager.currentSession();		
		
		initCompany(localsession);
		
		localsession.close();
		long endtime = System.currentTimeMillis();
		System.out.println("----------江苏人才网 个人数据 导入本地数据库 结束！用时："+(endtime - begintime)/1000/60+" 分钟");
		log.error("江苏人才网 个人数据 导入数据库 用时："+(endtime - begintime)/1000/60+" 分钟");
	}
	
	public static void initCompany(Session localsession){
		
		for(int i=0;i<OPT_Person.length;i++){
			System.out.println(OPT_Person[i][1]);
			loadingPersonFile(localsession,OPT_Person[i][1]);
		}
		
	}
	
	public static void loadingPersonFile(Session Localsession,String filePathTemp){		
		String filePath = filePathTemp;
		InputStream fs = null;
		Workbook workBook = null;
		
		try {
			// 加载excel文件
			fs = new FileInputStream(filePath);
			// 得到 workbook
			workBook = Workbook.getWorkbook(fs);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		operatPerson(Localsession,workBook);		
		workBook.close();// 记得关闭	
	}
	
	public static void operatPerson(Session Localsession,Workbook workBook){		
		// 取得sheet，如果你的workbook里有多个sheet 可以利用 wb.getSheets()方法来得到所有的。
		// getSheets() 方法返回 Sheet[] 数组 然后利用数组来操作。就是多次循环的事。
		Sheet sheet = workBook.getSheet(0);// 这里只取得第一个sheet的值，默认从0开始
		//System.out.println(sheet.getColumns());// 查看sheet的列
		//System.out.println(sheet.getRows());// 查看sheet的行
		Cell cell = null;// 就是单个单元格
		// 开始循环，取得 cell 里的内容，这里都是按String来取的 为了省事，具体你自己可以按实际类型来取。或者都按
		// String来取。然后根据你需要强制转换一下。
		System.out.println(sheet.getRows());
		
		int m = 0;		
		List list = new ArrayList();
		
		for (int i=0;i<sheet.getRows();i++){		
			System.out.println("第导入"+i+"条记录");
			person p = new person();
			
			cell = sheet.getCell(0,i);
			p.setPid(StringUtil.parseInt(cell.getContents())); //pid
			
			cell = sheet.getCell(1,i);
			p.setRealname(StringUtil.getNotNullStr(cell.getContents()));//真实姓名
			
			cell = sheet.getCell(2,i);
			p.setUname(StringUtil.getNotNullStr(cell.getContents()));//用户名
				
			cell = sheet.getCell(3,i);
			p.setPwd(StringUtil.getNotNullStr(cell.getContents()));//输入密码
			
			//cell = sheet.getCell(4,i);
			//p.setPwdquestion(StringUtil.getNotNullStr(cell.getContents()));//密码验证问题
			
			//cell = sheet.getCell(5,i);
			//p.setPwdanswer(StringUtil.getNotNullStr(cell.getContents()));//密码验证问题答案
			
			cell = sheet.getCell(6,i);
			p.setCardtype(StringUtil.getNotNullStr(cell.getContents()));//证件类型
			
			cell = sheet.getCell(7,i);
			p.setCardno(StringUtil.getNotNullStr(cell.getContents()));//证件号码
			
			cell = sheet.getCell(8,i);
			p.setSex(StringUtil.getNotNullStr(cell.getContents()));//性别
			
			cell = sheet.getCell(9,i);
			p.setBirthday(StringUtil.getNotNullStr(cell.getContents()));//出生年月
			
			cell = sheet.getCell(10,i);
			p.setNation(StringUtil.getNotNullStr(cell.getContents()));//民族
			
			cell = sheet.getCell(11,i);
			p.setPolitics(StringUtil.getNotNullStr(cell.getContents()));//政治面貌
			
			cell = sheet.getCell(12,i);
			p.setMarriage(StringUtil.getNotNullStr(cell.getContents()));//婚姻状况
			
			cell = sheet.getCell(13,i);
			p.setHomecity(StringUtil.getNotNullStr(cell.getContents()));//户籍所在地
			
			cell = sheet.getCell(14,i);
			p.setStaycity(StringUtil.getNotNullStr(cell.getContents()));//现住城市
			
			cell = sheet.getCell(15,i);
			p.setHeight(StringUtil.getNotNullStr(cell.getContents()));//身高
			
			cell = sheet.getCell(16,i);
			p.setEyesight(StringUtil.getNotNullStr(cell.getContents()));//视力
			
			cell = sheet.getCell(17,i);
			p.setPhoto(StringUtil.getNotNullStr(cell.getContents()));//图片
			
			cell = sheet.getCell(18,i);
			p.setEdulevel1(StringUtil.getNotNullStr(cell.getContents()));//第一学历
			
			cell = sheet.getCell(19,i);
			p.setEduuniv1(StringUtil.getNotNullStr(cell.getContents()));//第一学历毕业院校
			
			cell = sheet.getCell(20,i);
			p.setEdudate1(StringUtil.getNotNullStr(cell.getContents()));//第一学历毕业年月
			
			cell = sheet.getCell(21,i);
			p.setSpecialitytype1(StringUtil.getNotNullStr(cell.getContents()));//第一学历类别
			
			cell = sheet.getCell(22,i);
			p.setSpecialityname1(StringUtil.getNotNullStr(cell.getContents()));//第一学历毕业专业
			
			cell = sheet.getCell(23,i);
			p.setEdulevel2(StringUtil.getNotNullStr(cell.getContents()));//最高学历
			
			cell = sheet.getCell(24,i);
			p.setEduuniv2(StringUtil.getNotNullStr(cell.getContents()));//最高学历毕业院校
			
			cell = sheet.getCell(25,i);
			p.setEdudate2(StringUtil.getNotNullStr(cell.getContents()));//最高学历毕业年月
			
			cell = sheet.getCell(26,i);
			p.setSpecialitytype2(StringUtil.getNotNullStr(cell.getContents()));//最高学历类别
			
			cell = sheet.getCell(27,i);
			p.setSpecialityname2(StringUtil.getNotNullStr(cell.getContents()));//最高学历毕业专业
			
			cell = sheet.getCell(28,i);
			p.setTechposttype(StringUtil.getNotNullStr(cell.getContents()));//职称类别
			
			cell = sheet.getCell(29,i);
			p.setTechpostname(StringUtil.getNotNullStr(cell.getContents()));//职称名称
			
			cell = sheet.getCell(30,i);
			p.setNowunit(StringUtil.getNotNullStr(cell.getContents()));//现工作单位
			
			cell = sheet.getCell(31,i);
			String temp = StringUtil.getNotNullStr(cell.getContents());
			if(!"190001".equals(temp)){
				p.setStartworkdate(temp);//参加工作时间
			}else{
				p.setStartworkdate("201107");//参加工作时间
			}
			
			
			cell = sheet.getCell(32,i);
			p.setComputerlevel(StringUtil.getNotNullStr(cell.getContents()));//电脑应用程度
			
			cell = sheet.getCell(33,i);
			p.setTypingspeed(StringUtil.getNotNullStr(cell.getContents()));//打字速度
			
			cell = sheet.getCell(34,i);
			p.setForeign1(StringUtil.getNotNullStr(cell.getContents()));//第一外语
			
			cell = sheet.getCell(35,i);
			p.setForeignlevel1(StringUtil.getNotNullStr(cell.getContents()));//第一外语水平
			
			cell = sheet.getCell(36,i);
			p.setForeign2(StringUtil.getNotNullStr(cell.getContents()));//第二外语
			
			cell = sheet.getCell(37,i);
			p.setForeignlevel2(StringUtil.getNotNullStr(cell.getContents()));//第二外语水平
			
			cell = sheet.getCell(38,i);
			p.setMandarinlevel(StringUtil.getNotNullStr(cell.getContents()));//普通话水平
			
			cell = sheet.getCell(39,i);
			p.setDrivelicense(StringUtil.getNotNullStr(cell.getContents()));//驾照
			
			cell = sheet.getCell(40,i);
			p.setSpecialty(StringUtil.getNotNullStr(cell.getContents()));//本人特长
			
			cell = sheet.getCell(41,i);
			p.setJobcause(StringUtil.getNotNullStr(cell.getContents()));//流动理由
			
			cell = sheet.getCell(42,i);
			p.setJobform(StringUtil.getNotNullStr(cell.getContents()));//流动形式
			
			cell = sheet.getCell(43,i);
			p.setJobposition1(StringUtil.getNotNullStr(cell.getContents()));//求职意向一
			
			cell = sheet.getCell(44,i);
			p.setJobposition2(StringUtil.getNotNullStr(cell.getContents()));//求职意向二
			
			cell = sheet.getCell(45,i);
			p.setJobposition3(StringUtil.getNotNullStr(cell.getContents()));//求职意向三
			
			cell = sheet.getCell(46,i);
			p.setMonthlypay(StringUtil.getNotNullStr(cell.getContents()));//期望月薪
			
			cell = sheet.getCell(47,i);
			p.setJobcity(StringUtil.getNotNullStr(cell.getContents()));//工作地点
			
			cell = sheet.getCell(48,i);
			p.setCanout(StringUtil.getNotNullStr(cell.getContents()));//是否可以出差或驻外
			
			cell = sheet.getCell(49,i);
			p.setNeedhouse(StringUtil.getNotNullStr(cell.getContents()));//是否要求住房
			
			cell = sheet.getCell(50,i);
			p.setUnittype(StringUtil.getNotNullStr(cell.getContents()));//公司性质
			
			cell = sheet.getCell(51,i);
			temp = StringUtil.getNotNullStr(cell.getContents());
			if(temp.length()>2000){
				temp = temp.substring(0,1900);
			}
			p.setOtherneed(temp);//特殊要求
			
			cell = sheet.getCell(52,i);
			p.setEdulist(StringUtil.getNotNullStr(cell.getContents()));//教育简历
			
			cell = sheet.getCell(53,i);
			p.setWorklist(StringUtil.getNotNullStr(cell.getContents()));//工作简历
			
			cell = sheet.getCell(54,i);
			p.setAboutself(StringUtil.getNotNullStr(cell.getContents()));//自述
			
			cell = sheet.getCell(55,i);
			p.setAddress(StringUtil.getNotNullStr(cell.getContents()));//讯地址
			
			cell = sheet.getCell(56,i);
			p.setZipcode(StringUtil.getNotNullStr(cell.getContents()));//邮政编码
			
			cell = sheet.getCell(57,i);
			p.setPhone(StringUtil.getNotNullStr(cell.getContents()));//联系电话
			
			cell = sheet.getCell(58,i);
			p.setEmail(StringUtil.getNotNullStr(cell.getContents()));//电子邮件
			
			cell = sheet.getCell(59,i);
			p.setSecretsetting(StringUtil.getNotNullStr(cell.getContents()));
			
			cell = sheet.getCell(60,i);
			p.setVisitcount(StringUtil.getNotNullStr(cell.getContents()));
			
			cell = sheet.getCell(61,i);
			p.setState(StringUtil.getNotNullStr(cell.getContents()));
			
			cell = sheet.getCell(62,i);
			p.setArchiveno(StringUtil.getNotNullStr(cell.getContents()));
			
			cell = sheet.getCell(63,i);
			p.setType(StringUtil.getNotNullStr(cell.getContents()));//0：普通人才，1：毕业生，2：国际人才
			
			cell = sheet.getCell(64,i);
			p.setLastlogintime(StringUtil.getNotNullStr(cell.getContents()));//最后登录时间
			
			cell = sheet.getCell(65,i);
			p.setHighlevel(StringUtil.getNotNullStr(cell.getContents()));
			
			cell = sheet.getCell(66,i);
			p.setLocked(StringUtil.getNotNullStr(cell.getContents()));
			
			cell = sheet.getCell(67,i);
			p.setSpecialityinput1(StringUtil.getNotNullStr(cell.getContents()));//第一学历专业名称
			
			cell = sheet.getCell(68,i);
			p.setSpecialityinput2(StringUtil.getNotNullStr(cell.getContents()));//最高学历专业名称
			
			cell = sheet.getCell(69,i);
			p.setRegistertime(StringUtil.getNotNullStr(cell.getContents()));//注册时间
			
			
			list.add(p);
			
			m++;
			if(m>100){
				saveDate(Localsession,list);
				m=0;
				list.clear();				
			}			
		}
		saveDate(Localsession,list);			
		list.clear();		
	}
	
	public static void saveDate(Session Localsession,List list){
		Object[] obj = new Object[list.size()];
				
		for(int j=0;j<list.size();j++){
			obj[j]=list.get(j);
		}
		
		EntityManager.batchSave(obj, Localsession);
		Localsession.flush();
		Localsession.clear();
		obj = null;
	}

}
