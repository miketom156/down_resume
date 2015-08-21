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
public class CopyOfAnalyDB {

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



	

	// 得到企业的职位信息
	public static List PerUsers(Connection con) {
		String sql = "SELECT  u.address,u.hometown,u.gender from per_user  u   where u.location=23010000";
		ResultSet res = getResultSet(sql, con);
		List lists = new ArrayList<>();
		try {
			while (res.next()) {
				Object[] obj = new Object[3];
				// System.out.println(res.getInt(1));
				obj[0] = getAddressStr(res.getString(1));
				obj[1] = getHometownStr(res.getInt(2));
				obj[2] = res.getInt(3) == 1 ? "男" : "女";
				lists.add(obj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				res.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return lists;
	}

	//
	public static List intentInfos(Connection con) {
		String sql = "select r.intent_info,u.id from per_user u INNER JOIN per_resume r on u.res_id=r.id  where r.intent_info!='[]' and  u.location=23010000";
		ResultSet res = getResultSet(sql, con);
		List lists = new ArrayList<>();
		try {
			while (res.next()) {
				Object[] obj = new Object[2];
				PerResumeVo.IntentInfoVo intent = new PerResumeVo.IntentInfoVo();
				intent = new Gson().fromJson(res.getString(1), PerResumeVo.IntentInfoVo.class);
				//if (CollectionUtils.isNotEmpty(intents)) {
				obj[0] =intent;
				//}
				obj[1] =res.getString(2);
				lists.add(obj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				res.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return lists;
	}

	//
	public static List WorkInfos(Connection con) {
		String sql = "select r.work_info,u.id from per_user u INNER JOIN per_resume r on u.res_id=r.id  where   r.work_info!='[]' and u.location=23010000 ";
		ResultSet res = getResultSet(sql, con);
		List lists = new ArrayList<>();
		try {
			while (res.next()) {
				Object[] obj = new Object[2];
				// PerResumeVo.WorkInfoVo intent=new PerResumeVo.WorkInfoVo();
				List<PerResumeVo.WorkInfoVo> intent = new Gson().fromJson(res.getString(1), new TypeToken<List<WorkInfoVo>>() {
				}.getType());

				// System.out.println(res.getInt(1));
				if (CollectionUtils.isNotEmpty(intent)) {
					obj[0] = intent.get(0);
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
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return lists;
	}

	public static List educations(Connection con) {
		String sql = "select r.education_info,u.id from per_user u INNER JOIN per_resume r on u.res_id=r.id  where r.education_info!='[]' and u.location=23010000  ";
		ResultSet res = getResultSet(sql, con);
		List lists = new ArrayList<>();
		try {
			while (res.next()) {
				Object[] obj = new Object[2];
				// PerResumeVo.EducationInfoVo intent=new PerResumeVo.EducationInfoVo();
				// System.out.println(res.getString(1));
				List<PerResumeVo.EducationInfoVo> intents = new Gson().fromJson(res.getString(1), new TypeToken<List<PerResumeVo.EducationInfoVo>>() {
				}.getType());
				// System.out.println(res.getInt(1));
				if (CollectionUtils.isNotEmpty(intents)) {
					obj[0] = intents.get(0);
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
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return lists;
	}

	public static List traninfos(Connection con) {
		String sql = "select r.train_info,u.id from per_user u INNER JOIN per_resume r on u.res_id=r.id  where r.train_info!='[]' and u.location=23010000 ";
		ResultSet res = getResultSet(sql, con);
		List lists = new ArrayList<>();
		try {
			while (res.next()) {
				Object[] obj = new Object[2];
				List<PerResumeVo.TrainInfoVo> intent = new Gson().fromJson(res.getString(1), new TypeToken<List<PerResumeVo.TrainInfoVo>>() {
				}.getType());
				if (CollectionUtils.isNotEmpty(intent)) {
				obj[0] = intent.get(0);
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
				con.close();
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
			if (address.contains("{")) {
				Map<String, String> map = new Gson().fromJson(address, new TypeToken<Map<String, String>>() {
				}.getType());
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
