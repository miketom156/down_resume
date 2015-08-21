/**
 * 
 */
package com.job5156.jsDateJoin.xian;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jxl.write.Label;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.job5156.jsDateJoin.xian.PerResumeVo.WorkInfoVo;
import com.job5156.util.option.OptionMap;
import com.job5156.util.option.OptionMap.OptionType;

/**
 * @author lyh
 * @Description
 * @date 2015年8月4日
 */
public class AnalyDB {

	public static ResultSet getResultSet(String sql, Connection con) {
		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	
	 public static Integer getCount(String sql,Connection con){
		  Integer   count=0;
		  Integer   page=0;
		  ResultSet res = getResultSet(sql,con);
		  try {
			while(res.next()){
				  count= res.getInt(1);
				  page=count/1000;
				  if(count%1000>0){
					  page++; 
				  }
				  
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return page;
		  
	  }

	public static  List getComIdByComName(Connection con,List comNames){
            String comNameStr=StringUtils.join(comNames, ",");
			String sql = "select id from com_info where com_name in (" +comNameStr+")";
			ResultSet res = getResultSet(sql, con);
			System.out.println(sql+"--comNames----");
			List lists = new ArrayList<>();
			try {
				while (res.next()) {
				    lists.add(res.getInt(1));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				    try {
						res.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			return lists;
	}
	
	
	
	
	 
	 
	 
	 
	// 得到企业基本信息
	public static List getComBaseInfo(Connection con) {
		String sql = "select  c.property ,c.industry,c.employee_number,t.address from com_info c inner join com_contact t on  c.id=t.com_id and t.default_flag=1 and   c.location= 23010000";
		ResultSet res = getResultSet(sql, con);
		List lists = new ArrayList<>();
		try {
			while (res.next()) {
				Object[] obj = new Object[4];
				// System.out.println(res.getInt(1));
				obj[0] = OptionMap.getValue(OptionType.OPT_COM_PROPERTY, res.getInt(1));
				obj[1] = OptionMap.getValue(OptionType.OPT_INDUSTRY, res.getInt(2));
				obj[2] = OptionMap.getValue(OptionType.OPT_COM_EMPLOYEE, res.getInt(3));
				//System.out.println(obj[2]);
				//obj[3] = getAddressStr(res.getString(4));
				lists.add(obj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				res.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return lists;
	}

	// 得到企业的职位信息
	public static List ComPostions(Connection con) {
		String sql = "SELECT p.pos_type,p.work_location,p.property,p.req_degree,p.pos_keyword  from com_position p  inner JOIN com_info c on  p.com_id=c.id where c.location= 23010000 ";
		ResultSet res = getResultSet(sql, con);
		List lists = new ArrayList<>();
		try {
			while (res.next()) {
				Object[] obj = new Object[5];
				// System.out.println(res.getInt(1));
				obj[0] = getPosTypeStr(res.getString(1));
				obj[1] = getWorkLocationStr(res.getString(2));
				obj[2] = OptionMap.getValue(OptionMap.OptionType.OPT_JOBTYPE, res.getInt(3));
				obj[3] = OptionMap.getValue(OptionMap.OptionType.OPT_PER_DEGREE, res.getInt(4));
				obj[4] =getPosTypeString(res.getString(5));
				lists.add(obj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				res.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return lists;
	}

	
	//

	// 得到企业的职位信息
	public static List PerUsers(Connection con,Integer startIndex,Integer pageSize) {
		StringBuffer str=new StringBuffer();
		str.append("select  u.id,u.user_name,u.password,u.email,u.account,u.card_num,u.gender, u.hometown, ");
		str.append("u.address,u.birthday,u.homepage,u.phone  from per_user u where u.id >=");
		str.append("(select id from per_user where location like '23%' order by id asc limit ");
		str.append(startIndex+", 1)");
		str.append(" and u.location like '23%' order by u.id asc limit ");
		str.append(pageSize);
		ResultSet res = getResultSet(str.toString(), con);
		System.out.println(str.toString()+"-----");
		List lists = new ArrayList<>();
		try {
			while (res.next()) {
				Object[] obj = new Object[12];
				// System.out.println(res.getInt(1));
				obj[0]=res.getString(1);
				//System.out.println(obj[0]);
				obj[1]=res.getString(2);
				obj[2]=res.getString(3);
				obj[3]=res.getString(4);
				obj[4]=res.getString(5);
				obj[5]=res.getString(6);
				obj[6] = res.getInt(7) == 1 ? "男" : "女";
				obj[7] = getHometownStr(res.getInt(8));
				obj[8] = getAddressStr(res.getString(9));
				obj[9]=res.getString(10);
				obj[10]=res.getString(11);
				obj[11]=res.getString(12);	
				lists.add(obj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return lists;
	}
	
	public static Integer getPerPage(Connection con) {
		String sql="select count(0) from per_user where location like '23%' ";
		return getCount(sql, con);
	}
	
	//
	public static List intentInfos(Connection con,Integer startIndex,Integer pageSize) {
		StringBuffer str=new StringBuffer();
		str.append("select r.intent_info, u.id from per_user u inner join per_resume r on u.res_id = r.id where r.intent_info != '[]' ");
		str.append("and u.id >= ( select u.id from per_user u inner join per_resume r on u.res_id = r.id and u.location like '23%' order by u.id asc limit ");
		str.append(startIndex);
		str.append(" , 1 ) and u.location like '23%'  order by u.id asc  limit ");
        str.append(pageSize);
		System.out.println(str.toString()+"-----");

		//String sql = "select r.intent_info,u.id from per_user u INNER JOIN per_resume r on u.res_id=r.id  where r.intent_info!='[]' and  u.location like '23%' ";
		ResultSet res = getResultSet(str.toString(), con);
		List lists = new ArrayList<>();
		try {
			while (res.next()) {
				Object[] obj = new Object[6];
				PerResumeVo.IntentInfoVo intent = new PerResumeVo.IntentInfoVo();
				intent = new Gson().fromJson(res.getString(1), PerResumeVo.IntentInfoVo.class);
				//if (CollectionUtils.isNotEmpty(intents)) {
				obj[0] =1;
				//}
				obj[1] =res.getString(2);
				obj[2]=intent.getJobTypeStr();
				obj[3]=intent.getJobLocationStr();
				obj[4]=intent.getJobCodeStr();
				obj[5]=intent.getSalaryStr();
				lists.add(obj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				res.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return lists;
	}
	
	
	
	public static Integer getPerIntentPage(Connection con) {
		String sql="select count(0)  from per_user u INNER JOIN per_resume r on u.res_id=r.id  where r.intent_info!='[]' and  u.location like '23%'  ";
		return getCount(sql, con);
	}
	public static Integer getPerWorkPage(Connection con) {
		String sql="select count(0)  from per_user u INNER JOIN per_resume r on u.res_id=r.id  where r.work_info!='[]' and  u.location like '23%'  ";
		return getCount(sql, con);
	}
	public static Integer getPerEducationPage(Connection con) {
		String sql="select count(0)  from per_user u INNER JOIN per_resume r on u.res_id=r.id  where r.education_info!='[]' and  u.location like '23%'  ";
		return getCount(sql, con);
	}
	public static Integer getPerTrainPage(Connection con) {
		String sql="select count(0)  from per_user u INNER JOIN per_resume r on u.res_id=r.id  where r.train_info!='[]' and  u.location like '23%'  ";
		return getCount(sql, con);
	}
	//
	public static List WorkInfos(Connection con,Integer startIndex,Integer pageSize) {
		StringBuffer str=new StringBuffer();
		str.append("select r.work_info, u.id from per_user u inner join per_resume r on u.res_id = r.id where r.intent_info != '[]' ");
		str.append("and u.id >= ( select u.id from per_user u inner join per_resume r on u.res_id = r.id and u.location like '23%'  order by u.id asc limit ");
		str.append(startIndex);
		str.append(" , 1 ) and u.location like '23%'  order by u.id asc  limit ");
        str.append(pageSize);
		//String sql = "select r.work_info,u.id from per_user u INNER JOIN per_resume r on u.res_id=r.id  where   r.work_info!='[]' and  u.location like '23%' ";
		ResultSet res = getResultSet(str.toString(), con);
		System.out.println(str.toString()+"-----");
		List lists = new ArrayList<>();
		try {
			while (res.next()) {
				Object[] obj = new Object[12];
				// PerResumeVo.WorkInfoVo intent=new PerResumeVo.WorkInfoVo();
				List<PerResumeVo.WorkInfoVo> intent = new Gson().fromJson(res.getString(1), new TypeToken<List<WorkInfoVo>>() {
				}.getType());

				// System.out.println(res.getInt(1));
				if (CollectionUtils.isNotEmpty(intent)) {
					obj[0] = 1;

					obj[2]=intent.get(0).getComName();
					obj[3]=intent.get(0).getComTypeStr();
					obj[4]=intent.get(0).getComScaleStr();
					obj[5]=intent.get(0).getComCallingStr();
					obj[6]=intent.get(0).getSection();
					obj[7]=intent.get(0).getJobName();
					obj[8]=intent.get(0).getBegin();
					obj[9]=intent.get(0).getEnd();
					obj[10]=intent.get(0).getSalaryStr();
					obj[11]=intent.get(0).getDescription();
				}
				obj[1] = res.getString(2);
				lists.add(obj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return lists;
	}

	public static List educations(Connection con,Integer startIndex,Integer pageSize) {
		StringBuffer str=new StringBuffer();
		str.append("select r.education_info, u.id from per_user u inner join per_resume r on u.res_id = r.id where r.intent_info != '[]' ");
		str.append("and u.id >= ( select u.id from per_user u inner join per_resume r on u.res_id = r.id and u.location like '23%'  order by u.id asc  limit ");
		str.append(startIndex);
		str.append(" , 1 ) and u.location like '23%'  order by u.id asc limit ");
        str.append(pageSize);
		
		//String sql = "select r.education_info,u.id from per_user u INNER JOIN per_resume r on u.res_id=r.id  where r.education_info!='[]' and  u.location like '23%'  ";
		ResultSet res = getResultSet(str.toString(), con);
		List lists = new ArrayList<>();
		System.out.println(str.toString()+"-----");
		try {
			while (res.next()) {
				Object[] obj = new Object[6];
				// PerResumeVo.EducationInfoVo intent=new PerResumeVo.EducationInfoVo();
				// System.out.println(res.getString(1));
				List<PerResumeVo.EducationInfoVo> intents = new Gson().fromJson(res.getString(1), new TypeToken<List<PerResumeVo.EducationInfoVo>>() {
				}.getType());
				// System.out.println(res.getInt(1));
				if (CollectionUtils.isNotEmpty(intents)) {
					obj[0] = 1;
					obj[2]=intents.get(0).getEnd();
					obj[3]=intents.get(0).getSchoolName();
					obj[4]=intents.get(0).getSpeciality();
					obj[5]=intents.get(0).getDegreeStr();
					
					System.out.println(intents.get(0).getDegree() + "---" + intents.get(0).getDegreeStr());
				}
				obj[1] = res.getString(2);
				lists.add(obj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return lists;
	}

	public static List traninfos(Connection con,Integer startIndex,Integer pageSize) {
		
		StringBuffer str=new StringBuffer();
		str.append("select r.train_info, u.id from per_user u inner join per_resume r on u.res_id = r.id where r.intent_info != '[]' ");
		str.append("and u.id >= ( select u.id from per_user u inner join per_resume r on u.res_id = r.id and u.location like '23%'  order by u.id asc limit ");
		str.append(startIndex);
		str.append(" , 1 ) and u.location like '23%' order by u.id asc  limit ");
        str.append(pageSize);
		//String sql = "select r.train_info,u.id from per_user u INNER JOIN per_resume r on u.res_id=r.id  where r.train_info!='[]'  u.location like '23%' ";
		ResultSet res = getResultSet(str.toString(), con);
		List lists = new ArrayList<>();
		System.out.println(str.toString()+"-----");
		try {
			while (res.next()) {
				Object[] obj = new Object[9];
				List<PerResumeVo.TrainInfoVo> intent = new Gson().fromJson(res.getString(1), new TypeToken<List<PerResumeVo.TrainInfoVo>>() {
				}.getType());
				if (CollectionUtils.isNotEmpty(intent)) {
				obj[0] = 1;
				PerResumeVo.TrainInfoVo tran=intent.get(0);
				obj[2]=tran.getBegin();
				obj[3]=tran.getEnd();
				obj[4]=tran.getTrainSchoolName();
				obj[5]=tran.getPlaceStr();
				obj[6]=tran.getTrainCourse();
				obj[7]=tran.getCertificate();
				obj[8]=tran.getCourseDescription();
				}
				obj[1] = res.getString(2);
				lists.add(obj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				res.close();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return lists;
	}

	private static String getAddressStr(String address) {
		String str = "";
		if (!isBlank(address)) {
			if (address.indexOf("prov")!=-1 && address.indexOf("{")!=-1) {
				Map<String, String> map = new Gson().fromJson(address, new TypeToken<Map<String, String>>() {}.getType());
				if (!isBlank(map.get("prov"))) {
					str += map.get("prov") + "省";
				}
				if (!isBlank(map.get("city"))) {
					str += map.get("city");
					// 为兼容前端JS将公共选择添加了“市”，固需要处理旧数据未包含“市”的职位自动添加“市” by 2014-12-09
					if (map.get("city") != null && map.get("city").indexOf("市") == -1) {
						str += "市";
					}
				}
				if (!isBlank(map.get("dist"))) {
					str += map.get("dist");
				}
				if (!isBlank(map.get("addr"))) {
					str += map.get("addr");
				}
			}
			return str;
		}
		return address;
	}

	public static boolean isBlank(String str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if ((Character.isWhitespace(str.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}

	//
	public static String getPosTypeStr(String protery) {
		List<String> list = Lists.newArrayList();
		List<Integer> posTypeList = getPosTypeList(protery);
		if (CollectionUtils.isNotEmpty(posTypeList)) {
			for (Integer posType : posTypeList) {
				String posStr = OptionMap.getValue(OptionMap.OptionType.OPT_POSITION, posType);
				if (!list.contains(posStr)) {
					list.add(posStr);
				}
			}
		}
		return StringUtils.join(list, " ");
	}

	public static List<Integer> getPosTypeList(String posType) {
		if (StringUtils.isNotBlank(posType) && !StringUtils.equals(posType, "[]")) {
			Gson gson = new Gson();
			return gson.fromJson(posType, new TypeToken<List<Integer>>() {
			}.getType());
		}
		return null;
	}

	public static String getWorkLocationStr(String workLocation) {
		List<String> list = Lists.newArrayList();
		if (StringUtils.isNotBlank(workLocation) && !StringUtils.equals(workLocation, "[]")) {
			Gson gson = new Gson();
			List<Integer> workLocationList = gson.fromJson(workLocation, new TypeToken<List<Integer>>() {
			}.getType());
			if (CollectionUtils.isNotEmpty(workLocationList)) {
				for (Integer work : workLocationList) {
					String locStr = OptionMap.getFullAddr(work);
					if (!list.contains(locStr)) {
						list.add(locStr);
					}
				}
			}
		}
		return StringUtils.join(list, " ");
	}

	// 籍贯对应文字
	public static String getHometownStr(Integer hometown) {
		return OptionMap.getFullAddr(hometown);
	}

	// 现所在地对应文字
	public static String getLocationStr(Integer location) {
		return OptionMap.getFullAddr(location);
	}

	public static String getPosTypeString(String posTypeStr) {
		List<String> list = Lists.newArrayList();
		if (StringUtils.isNotBlank(posTypeStr) && !StringUtils.equals(posTypeStr, "[]")) {
			Gson gson = new Gson();
			list= gson.fromJson(posTypeStr, new TypeToken<List<String>>() {
			}.getType());
		}
		return StringUtils.join(list, " ");
	}

}
