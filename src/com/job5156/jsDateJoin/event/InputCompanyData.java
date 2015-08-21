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

import com.job5156.jsDateJoin.entity.post;
import com.job5156.jsDateJoin.entity.unit;
import com.job5156.server.EntityManager;
import com.job5156.server.LocalSessionManager;
import com.job5156.util.DateUtil;
import com.job5156.util.StringUtil;

public class InputCompanyData {
	private static Logger log = Logger.getLogger(InputCompanyData.class);
	private static String[][] OPT_Company={
		{"1", "E:/jsDate/combaseinfo.xls",""},
		//{"2", "F:/jsInpuDate/unit2.XLS",""}		
	};
	private static String[][] OPT_Position={
		{"1", "E:/jsDate/postion.xls",""},
		//{"2", "F:/jsInpuDate/post2.XLS",""}		
	};
	
	public static void main(String[] args){
		System.out.println("----------江苏人才网 企业基本数据和职位 导入本地数据库 开始！--------------");
		long begintime = System.currentTimeMillis();
		Session localsession  = LocalSessionManager.currentSession();		
		
		initCompany(localsession);
		//initPosition(localsession);
		
		localsession.close();
		long endtime = System.currentTimeMillis();
		System.out.println("----------江苏人才网 企业基本数据和职位 导入本地数据库 结束！用时："+(endtime - begintime)/1000/60+" 分钟");
		log.error("江苏人才网 企业基本数据和职位 导入数据库 用时："+(endtime - begintime)/1000/60+" 分钟");
	}
	
	public static void initCompany(Session localsession){
				
		for(int i=0;i<OPT_Company.length;i++){
			loadingCompanyFile(localsession,OPT_Company[i][1]);
		}
		
	}
	
	public static void initPosition(Session localsession){		
		for(int i=0;i<OPT_Position.length;i++){
			loadingPostionFile(localsession,OPT_Position[i][1]);
		}	
		
	}
	
	public static void loadingCompanyFile(Session Localsession,String filePathTemp){		
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
		
		operatCompany(Localsession,workBook);		
		workBook.close();// 记得关闭	
	}
	
	public static void loadingPostionFile(Session Localsession,String filePathTemp){		
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
		
		operatPosition(Localsession,workBook);		
		workBook.close();// 记得关闭	
	}
	
	public static void operatPosition(Session Localsession,Workbook workBook){		
		// 取得sheet，如果你的workbook里有多个sheet 可以利用 wb.getSheets()方法来得到所有的。
		// getSheets() 方法返回 Sheet[] 数组 然后利用数组来操作。就是多次循环的事。
		Sheet sheet = workBook.getSheet(0);// 这里只取得第一个sheet的值，默认从0开始
		//System.out.println(sheet.getColumns());// 查看sheet的列
		//System.out.println(sheet.getRows());// 查看sheet的行
		Cell cell = null;// 就是单个单元格
		// 开始循环，取得 cell 里的内容，这里都是按String来取的 为了省事，具体你自己可以按实际类型来取。或者都按
		// String来取。然后根据你需要强制转换一下。
		int m = 0;		
		List list = new ArrayList();
		
		for (int i=0;i<sheet.getRows();i++){
			String temp = "";
			post p = new post();
			System.out.println("职位 导入第"+i+"条记录");
			cell = sheet.getCell(0,i);
			p.setPid(StringUtil.parseInt(cell.getContents())); //职位id
			
			cell = sheet.getCell(1,i);
			p.setUid(StringUtil.parseInt(cell.getContents())); //公司id
			
			cell = sheet.getCell(2,i);
			p.setUnitName(StringUtil.getNotNullStr(cell.getContents())); //公司名称
			
			cell = sheet.getCell(3,i);
			p.setPostName(StringUtil.getNotNullStr(cell.getContents())); //职位名称

			cell = sheet.getCell(4,i);
			p.setPositionName(StringUtil.getNotNullStr(cell.getContents())); //职位类别
			
			cell = sheet.getCell(5,i);
			p.setSpeciality(StringUtil.getNotNullStr(cell.getContents())); //专业要求
			
			cell = sheet.getCell(6,i);
			p.setDegree(StringUtil.getNotNullStr(cell.getContents())); //学历要求
			
			cell = sheet.getCell(7,i);
			p.setExperience(StringUtil.getNotNullStr(cell.getContents())); //工作经验
			
			cell = sheet.getCell(8,i);
			p.setAge(StringUtil.getNotNullStr(cell.getContents())); //年龄要求
			
			cell = sheet.getCell(9,i);
			p.setNumber1(StringUtil.getNotNullStr(cell.getContents())); //招聘人数

			cell = sheet.getCell(10,i);
			p.setSex(StringUtil.getNotNullStr(cell.getContents())); //性别要求
			
			cell = sheet.getCell(11,i);
			p.setTitle(StringUtil.getNotNullStr(cell.getContents())); //职称要求
			
			cell = sheet.getCell(12,i);
			p.setMonthlyPay(StringUtil.getNotNullStr(cell.getContents())); //月薪水平
			
			cell = sheet.getCell(13,i);
			p.setWorkPlace(StringUtil.getNotNullStr(cell.getContents())); //工作地区
			
			cell = sheet.getCell(14,i);
			p.setReleaseDate(StringUtil.getNotNullStr(cell.getContents())); //发布时间
			
			cell = sheet.getCell(15,i);
			p.setPeriod(StringUtil.getNotNullStr(cell.getContents())); //有效期
			
			cell = sheet.getCell(16,i);
			p.setMemo(StringUtil.getNotNullStr(cell.getContents())); //职责和要求
			
			cell = sheet.getCell(17,i);
			p.setVisitNum(StringUtil.getNotNullStr(cell.getContents())); //访问数量
			
			cell = sheet.getCell(18,i);
			p.setPostnum(StringUtil.getNotNullStr(cell.getContents())); 
			
			cell = sheet.getCell(19,i);
			p.setLocalStation(StringUtil.getNotNullStr(cell.getContents())); 
			
//			cell = sheet.getCell(20,i);
//			p.setReleaseStation(StringUtil.getNotNullStr(cell.getContents())); 
//			
//			cell = sheet.getCell(21,i);
//			p.setPreStation(StringUtil.getNotNullStr(cell.getContents())); 
//			
//			cell = sheet.getCell(22,i);
//			p.setPushTime(StringUtil.getNotNullStr(cell.getContents()));
			
			list.add(p);
			
			m++;
			if(m>5){
				saveDate(Localsession,list);
				m=0;
				list.clear();				
			}			
		}
		saveDate(Localsession,list);			
		list.clear();		
	}
	
	public static void operatCompany(Session Localsession,Workbook workBook){		
		// 取得sheet，如果你的workbook里有多个sheet 可以利用 wb.getSheets()方法来得到所有的。
		// getSheets() 方法返回 Sheet[] 数组 然后利用数组来操作。就是多次循环的事。
		Sheet sheet = workBook.getSheet(0);// 这里只取得第一个sheet的值，默认从0开始
		//System.out.println(sheet.getColumns());// 查看sheet的列
		//System.out.println(sheet.getRows());// 查看sheet的行
		Cell cell = null;// 就是单个单元格
		// 开始循环，取得 cell 里的内容，这里都是按String来取的 为了省事，具体你自己可以按实际类型来取。或者都按
		// String来取。然后根据你需要强制转换一下。
		int m = 0;		
		List list = new ArrayList();
		
		for (int i=0;i<sheet.getRows();i++){
			System.out.println("公司 导入第"+i+"条记录");
//			test2 t = new test2();
//			cell = sheet.getCell(1,i);
//			t.setUsername(StringUtil.getNotNullStr(cell.getContents()));
//			
//			cell = sheet.getCell(2,i);
//			t.setPassword(StringUtil.getNotNullStr(cell.getContents()));
//			
//			cell = sheet.getCell(3,i);
//			t.setTid(StringUtil.parseInt(cell.getContents()));
//			
//			cell = sheet.getCell(4,i);
//			t.setUrl(StringUtil.getNotNullStr(cell.getContents()));			
//			
//			list.add(t);
			
			unit u = new unit();
			String temp = "";
			
			cell = sheet.getCell(0,i);
			u.setUid(StringUtil.parseInt(cell.getContents())); //id
			
			cell = sheet.getCell(1,i);
			u.setName(StringUtil.getNotNullStr(cell.getContents())); //单位中文名称
			
			cell = sheet.getCell(2,i);
			u.setEname(StringUtil.getNotNullStr(cell.getContents())); //单位英文名称
			
			cell = sheet.getCell(3,i);
			u.setUname(StringUtil.getNotNullStr(cell.getContents())); //用户名
			
			cell = sheet.getCell(4,i);
			u.setPwd(StringUtil.getNotNullStr(cell.getContents())); //密码
			
			cell = sheet.getCell(5,i);
			u.setPwdquestion(StringUtil.getNotNullStr(cell.getContents())); //密码提示问题(无)
			
			cell = sheet.getCell(6,i);
			u.setPwdanswer(StringUtil.getNotNullStr(cell.getContents())); //密码回答问题(无)
			
			cell = sheet.getCell(7,i);
			u.setSuperunit(StringUtil.getNotNullStr(cell.getContents())); //主管单位名称（无）
			
			cell = sheet.getCell(8,i);
			u.setArtiperson(StringUtil.getNotNullStr(cell.getContents())); //法人代表
			
			
			cell = sheet.getCell(9,i);
			u.setArtipersonpost(StringUtil.getNotNullStr(cell.getContents())); //法人代表职务：

			cell = sheet.getCell(10,i);
			u.setArtipersonstru(StringUtil.getNotNullStr(cell.getContents())); //法人治理结构：
			
			cell = sheet.getCell(11,i);
			u.setUnitproperty(StringUtil.getNotNullStr(cell.getContents())); //所有制性质(公司性质：
			
			cell = sheet.getCell(12,i);
			u.setRegfund(StringUtil.parseInt(cell.getContents())); //注册资金(万元)
			
			cell = sheet.getCell(13,i);
			u.setRegaddress(StringUtil.getNotNullStr(cell.getContents())); //注册地址
			
			cell = sheet.getCell(14,i);
			u.setRegphone(StringUtil.getNotNullStr(cell.getContents())); //注册地址电话
			
			cell = sheet.getCell(15,i);
			u.setRegzipcode(StringUtil.getNotNullStr(cell.getContents())); //注册地址邮编：
			
			cell = sheet.getCell(16,i);
			u.setBusiaddress(StringUtil.getNotNullStr(cell.getContents())); //经营地址
			
			cell = sheet.getCell(17,i);
			u.setBusizipcode(StringUtil.getNotNullStr(cell.getContents())); //经营地址邮编
			
			cell = sheet.getCell(18,i);
			u.setBusilicense(StringUtil.getNotNullStr(cell.getContents())); //营业执照编号
			
			cell = sheet.getCell(19,i);
			u.setRegunit(StringUtil.getNotNullStr(cell.getContents())); //发证单位(不确定)
			
			//cell = sheet.getCell(20,i);
			//u.setBusiwhat(StringUtil.getNotNullStr(cell.getContents())); //经营范围
			
			cell = sheet.getCell(21,i);
			u.setEmployeea(StringUtil.parseInt(cell.getContents())); //博士及以上
			
			cell = sheet.getCell(22,i);
			u.setEmployeeb(StringUtil.parseInt(cell.getContents())); //硕士人数
			
			cell = sheet.getCell(23,i);
			System.out.println(StringUtil.parseInt(cell.getContents()));
			u.setEmployeec(StringUtil.parseInt(cell.getContents())); //本科人数
			
			cell = sheet.getCell(24,i);
			u.setEmployeed(StringUtil.parseInt(cell.getContents())); //大专人数

			cell = sheet.getCell(25,i);
			u.setEmployeee(StringUtil.parseInt(cell.getContents())); //中专人数
			
			cell = sheet.getCell(26,i);
			u.setEmployeef(StringUtil.parseInt(cell.getContents())); //高中人数
			
			cell = sheet.getCell(27,i);
			u.setEmployeeg(StringUtil.parseInt(cell.getContents())); //初中人数
			
			cell = sheet.getCell(28,i);
			u.setEmployeeh(StringUtil.parseInt(cell.getContents())); //其他人数
			
			cell = sheet.getCell(29,i);
			u.setLinkman(StringUtil.getNotNullStr(cell.getContents())); //联系人
			
			cell = sheet.getCell(30,i);
			u.setLinkmanpost(StringUtil.getNotNullStr(cell.getContents())); //职务
			
			cell = sheet.getCell(31,i);
			u.setFax(StringUtil.getNotNullStr(cell.getContents())); //传真
			
			cell = sheet.getCell(32,i);
			u.setPhone(StringUtil.getNotNullStr(cell.getContents())); //联系电话
			
			cell = sheet.getCell(33,i);
			u.setAddress(StringUtil.getNotNullStr(cell.getContents())); //公司地址
			
			cell = sheet.getCell(34,i);
			u.setZipcode(StringUtil.getNotNullStr(cell.getContents())); //邮政编码
			
			cell = sheet.getCell(35,i);
			u.setEmail(StringUtil.getNotNullStr(cell.getContents())); //电子邮箱
			
			cell = sheet.getCell(36,i);
			u.setMobile(StringUtil.getNotNullStr(cell.getContents())); //手机
			
			cell = sheet.getCell(37,i);
			u.setHttp(StringUtil.getNotNullStr(cell.getContents())); //公司网址
			
			cell = sheet.getCell(38,i);
			u.setInfomobile(StringUtil.getNotNullStr(cell.getContents())); //业务短信接收手机
			
			cell = sheet.getCell(39,i);
			u.setInfoemail(StringUtil.getNotNullStr(cell.getContents())); //业务短信接收手机
			
			//cell = sheet.getCell(40,i);
			//u.setRemark(StringUtil.getNotNullStr(cell.getContents())); //备注
			
			cell = sheet.getCell(41,i);
			u.setState(StringUtil.parseInt(cell.getContents())); //开通状态或会员类型（不确定）
			
			cell = sheet.getCell(42,i);
			u.setBusino(StringUtil.getNotNullStr(cell.getContents())); //工商注册号
			
			cell = sheet.getCell(43,i);
			if(!"".equals(StringUtil.getNotNullStr(cell.getContents()))){
				u.setLastlogintime(StringUtil.getNotNullStr(cell.getContents())); //最后登录时间
			}else{
				u.setLastlogintime(DateUtil.getNowDateTime());
			}
			cell = sheet.getCell(44,i);
			u.setLocked(StringUtil.parseInt(cell.getContents())); //NO
			
			cell = sheet.getCell(45,i);
			u.setRegistertime(StringUtil.getNotNullStr(cell.getContents())); //注册时间
			
			cell = sheet.getCell(46,i);
			u.setIntro(StringUtil.getNotNullStr(cell.getContents())); //注册时间			
			
			list.add(u);
			
			m++;
			if(m>5){
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