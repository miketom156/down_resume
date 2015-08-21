package com.job5156.foshan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.Session;

import com.job5156.server.FileLog;
import com.job5156.down.util.LoadHtml;
import com.job5156.server.SessionManager;

/**
 * @author yanf
 * create on 2008-9-9
 */
public class DownResume
{
	private static final String FILE_PATH = "com.job5156.foshan.DownResume";
	
	private static final String url = "http://www.0757rc.com/ent/showresume.aspx?jwsn=";
	private static final String loginUrl = "http://www.0757rc.com/index.aspx?__EVENTTARGET=login&__EVENTARGUMENT=&__VIEWSTATE=/wEPDwUKMTczOTUzMzUyMWQYAQUeX19Db250cm9sc1JlcXVpcmVQb3N0QmFja0tleV9fFgEFBWxvZ2luFju/CKSS2wtGZ0rZmcvyQUM5vn8=&LoginID=zhengying&LoginPwd=6406015&lx=2";
	public static StringBuffer buffer = new StringBuffer();

	static{
		buffer.append("/wEPDwUJLTM0NTMzOTIyDxYEHgRqd3NuBQY5NTYwNDMeB0p3X05hbWUFCem7hOS8n+WFiRYCAgMPZBZAAgEPFgIeC18hSXRlbUNvdW50AgUWCmYPZBYCZg8VAZwB");
		buffer.append("PGEgaHJlZj0iL2Fkdi9hZHRyYWNlLmFzcHg/aWQ9MTAwNTIiICB0YXJnZXQ9Il9ibGFuayI+PGltZyBzcmM9Ii9waWMvZm9zaC9sb2dvX3VwZmlsZXMvMjAwNzkx");
		buffer.append("MTE1OTI0cy5naWYiIHRpdGxlPSIiIGhlaWdodD0iNDUiICB3aWR0aD0iMTQ4IiAgYm9yZGVyPSIwIj48L2E+ZAIBD2QWAmYPFQGcATxhIGhyZWY9Ii9hZHYvYWR0");
		buffer.append("cmFjZS5hc3B4P2lkPTEwMDYxIiAgdGFyZ2V0PSJfYmxhbmsiPjxpbWcgc3JjPSIvcGljL2Zvc2gvbG9nb191cGZpbGVzLzIwMDgxMTc1OTQyN3MuZ2lmIiB0aXRs");
		buffer.append("ZT0iIiBoZWlnaHQ9IjQ1IiAgd2lkdGg9IjE0OCIgIGJvcmRlcj0iMCI+PC9hPmQCAg9kFgJmDxUBnAE8YSBocmVmPSIvYWR2L2FkdHJhY2UuYXNweD9pZD0xMDA0");
		buffer.append("NSIgIHRhcmdldD0iX2JsYW5rIj48aW1nIHNyYz0iL3BpYy9mb3NoL2xvZ29fdXBmaWxlcy8yMDA3ODI3NDYzNTNzLmdpZiIgdGl0bGU9IiIgaGVpZ2h0PSI0NSIg");
		buffer.append("IHdpZHRoPSIxNDgiICBib3JkZXI9IjAiPjwvYT5kAgMPZBYCZg8VAZsBPGEgaHJlZj0iL2Fkdi9hZHRyYWNlLmFzcHg/aWQ9MTAwMzkiICB0YXJnZXQ9Il9ibGFu");
		buffer.append("ayI+PGltZyBzcmM9Ii9waWMvZm9zaC9sb2dvX3VwZmlsZXMvMjAwNzc2MjQ2NzRzLmdpZiIgdGl0bGU9IiIgaGVpZ2h0PSI0NSIgIHdpZHRoPSIxNDgiICBib3Jk");
		buffer.append("ZXI9IjAiPjwvYT5kAgQPZBYCZg8VAZsBPGEgaHJlZj0iL2Fkdi9hZHRyYWNlLmFzcHg/aWQ9MTAwNDciICB0YXJnZXQ9Il9ibGFuayI+PGltZyBzcmM9Ii9waWMv");
		buffer.append("Zm9zaC9sb2dvX3VwZmlsZXMvMjAwNzk1NDc3NzZzLmdpZiIgdGl0bGU9IiIgaGVpZ2h0PSI0NSIgIHdpZHRoPSIxNDgiICBib3JkZXI9IjAiPjwvYT5kAgIPDxYC");
		buffer.append("HgRUZXh0BQgyMDA5LTMtNWRkAgMPDxYCHghJbWFnZVVybAUWL2ltYWdlcy9ub3BpYy9mb3NoLmdpZmRkAgQPDxYCHwMFCem7hOS8n+WFiWRkAgUPDxYCHwMFBuWF");
		buffer.append("qOiBjGRkAgYPDxYCHwMFA+eUt2RkAgcPDxYCHwMFAjIyZGQCCA8PFgIfAwUDMTc2ZGQCCQ8PFgIfAwUG5pyq5amaZGQCCg8PFgIfAwUJ5L2b5bGx5biCZGQCCw8P");
		buffer.append("FgIfAwUP5bm/6KW/6Ieq5rK75Yy6ZGQCDA8PFgIfAwUJMTAwMC0xNTAwZGQCDQ8PFgIfAwUG5Lit5LiTZGQCDg8PFgIfAwUEM+W5tGRkAg8PDxYCHwMFIeW5v+il");
		buffer.append("v+aip+W3nuW4gueOsOS7o+enkeaKgOWtpuagoWRkAhAPDxYCHwNlZGQCEQ8PFgIfAwUG54af57uDZGQCEg8PFgIfA2VkZAITDw8WAh8DBQnkvZvlsbHluIJkZAIU");
		buffer.append("Dw8WAh8DBRLorqHnrpfmnLrmioDmnK/lkZhkZAIVDw8WAh8DZGRkAhYPDxYCHwNkZGQCFw8PFgIfAwVv5Zyo6K6k55yf5YGa5aW95pys6IGM5bel5L2c55qE5ZCM");
		buffer.append("5pe277yM5Li76KaB5oqK6Ieq5bex55qE5Lia5Yqh6IyD5Zu05ouT5a6977yB5Li65YWs5Y+45YGa5Yiw5pu06auY55qE5Yip5ram77yBZGQCGA8PFgIfAwWdATIw");
		buffer.append("MDDlubTigJQyMDAz5bm0ICDmr5XkuJrkuo4gIOW5v+ilv+i0tea4r+W4guWkp+WyreS5oeWInee6p+S4reWtpijliJ3kuK0pPGJyLz4KMjAwM+W5tOKAlDIwMDbl");
		buffer.append("ubQgIOavleS4muS6jiAg5bm/6KW/5qKn5bee5biC546w5Luj56eR5oqA5a2m5qChKOS4reS4kyk8YnIvPgpkZAIZDw8WAh8DBbgC5Zyo6K6h566X5py6572R57uc");
		buffer.append("44CB56Gs5Lu244CB6L2v5Lu244CB566h55CG5pa56Z2i54af5oKJ77yM5Lul5Y+K55S16ISR57u05oqk5LiT5Lia55+l6K+G5omO5a6e77yM6IO95aSf5Zyo5a6e");
		buffer.append("6Le15Lit57uT5ZCI5bm254G15rS76L+Q55So77yM54us56uL5oCd57u05oCn5ZKM6Ieq5a2m6IO95Yqb6L6D5aW977yM5bm25pyJ5LiA5a6a55qE5Yib5paw6IO9");
		buffer.append("5Yqb44CC5aaC5p6c6KaB5YGa5Lia5Yqh77yM5Li76KaB5piv5ouT5a696Ieq5bex55qE5Lia5Yqh6IyD5Zu044CCPGJyLz4KPGJyLz4K5rOo77ya5pys5Lq65pyJ");
		buffer.append("5pGp6L2m6am+5L2/6K+BZGQCGg8PFgIfAwVqMjAwNuW5tOKAlDIwMDjlubQgICA8YnIvPgrlnKjkuK3lsbHlqIHor5rnvZHnu5zlhazlj7jlt6XkvZwgICAgICAg");
		buffer.append("6IGM5Yqh5pivIOiuoeeul+acuuaKgOacr+WRmOOAgeS4muWKoeWRmGRkAhsPDxYCHwMF7QHkuLrkurror5rmgbPjgIHlloTkuo7msp/pgJrvvIzlr7nlt6XkvZzo");
		buffer.append("rqTnnJ/jgIHnu4blv4PjgIHotJ/otKPvvIzmnInljY/osIPjgIHnu4Tnu4flt6XkvZzog73lipvjgIHlm6LpmJ/nsr7npZ7jgIHlloTkuo7lrabkuaDlkozmjqXl");
		buffer.append("j5fmlrDpspzkuovnianvvIzog73lpJ/lkIPoi6bogJDlirPvvIzog73pgbXlrojlhazlj7jnmoTlkITpobnop4Tnq6DliLbluqbvvIzog73mnI3ku47pooblr7zn");
		buffer.append("moTlronmjpLjgIJkZAIcDw8WAh8DBTQo6LS15Y+45ZyoMjAwOS0zLTUgMTQ6MDM6MDXlt7LpmIXor7vov4for6XmsYLogYzogIUpZGQCHQ9kFgJmDw9kFgIeBWFs");
		buffer.append("aWduBQlhYnNtaWRkbGVkAiMPDxYCHgdWaXNpYmxlZ2RkAiYPDxYCHwZnZBYCAgEPEA8WBh4ORGF0YVZhbHVlRmllbGQFBkpvYl9TTh4NRGF0YVRleHRGaWVsZAUI");
		buffer.append("Sm9iX05hbWUeC18hRGF0YUJvdW5kZ2QQFQUb77yN77yN6YKA6K+355qE6IGM5L2N77yN77yNDOmUgOWUruWKqeeQhgznu4/nkIbliqnnkIYP5LuT5bqT566h55CG");
		buffer.append("5ZGYBuaWh+WRmBUFATAGMzEyNTg0BjMxMzQ5MgY0MjQ0ODUGNDI3NzI4FCsDBWdnZ2dnFgFmZAIoDxYCHwICARYCZg9kFgJmDxUBlQQ8b2JqZWN0IGNsYXNzaWQ9");
		buffer.append("ImNsc2lkOkQyN0NEQjZFLUFFNkQtMTFjZi05NkI4LTQ0NDU1MzU0MDAwMCINCmNvZGViYXNlPSJodHRwOi8vZG93bmxvYWQubWFjcm9tZWRpYS5jb20vcHViL3No");
		buffer.append("b2Nrd2F2ZS9jYWJzL2ZsYXNoL3N3Zmxhc2guY2FiI3ZlcnNpb249NywwLDE5LDAiIHdpZHRoPTQ2NCBoZWlnaHQ9NTA+DQo8cGFyYW0gbmFtZT0ibW92aWUiIHZh");
		buffer.append("bHVlPS9waWMvZm9zaC9sb2dvX3VwZmlsZXMvMjAwNzc2MjE1MjJzLnN3ZiAvPg0KPHBhcmFtIG5hbWU9InF1YWxpdHkiIHZhbHVlPSJoaWdoIi8+DQo8cGFyYW0g");
		buffer.append("bmFtZT0id21vZGUiIHZhbHVlPSJ0cmFuc3BhcmVudCIgLz4NCjxlbWJlZCBzcmM9L3BpYy9mb3NoL2xvZ29fdXBmaWxlcy8yMDA3NzYyMTUyMnMuc3dmIHF1YWxp");
		buffer.append("dHk9ImhpZ2giDQpwbHVnaW5zcGFnZT0iaHR0cDovL3d3dy5tYWNyb21lZGlhLmNvbS9nby9nZXRmbGFzaHBsYXllciIgdHlwZT0iYXBwbGljYXRpb24veC1zaG9j");
		buffer.append("a3dhdmUtZmxhc2giIHdpZHRoPTQ2NCBoZWlnaHQ9NTA+PC9lbWJlZD48L29iamVjdD4NCmRkU6NYnn5FOfMaIAJE8DwevZYMQvo=");
	}
	
	public static void main(String[] args)
	{
		Session session = null;
		Connection con = null;
		try{
			LoadHtml loadHtml = new LoadHtml();
			loadHtml.setUrl(url);
			loadHtml.setIsLogin(true);
			loadHtml.setLoginUrl(loginUrl);
			session = SessionManager.currentSession();
			con = session.connection();
			int j = 633;
			for(int userid = 900263; userid < 1000000; userid++)
			{
				if(!hasData(con, userid)){
					String content = loadHtml.getBigHtml(userid);
					if(checkExist(content) == 1){
						System.out.println("==============正在下载第 "+(++j)+" 条数据 用户ID:"+userid+"============");
						if(content.indexOf("点击按钮查看该求职者联系方式") != -1){
							loadHtml.setIsParam(true);
							String viewState = LoadHtml.getValue(content, "<input type=\"hidden\" name=\"__VIEWSTATE\" id=\"__VIEWSTATE\" value=\"", "\" />");
							loadHtml.setParam(new String[][]{{"__VIEWSTATE",viewState},{"Button2","查看联系方式"}});
							content = loadHtml.getBigHtml(userid);
							loadHtml.setIsParam(false);
						}
						if(checkEmail(content) == 1){
							content = LoadHtml.getValue(content, "<a name='topEnd'></a>", "<div id=\"sendyq\">");
							System.out.println("--------------正在保存第 "+j+" 条数据--------------");
							insertData(con, content, userid);
							System.out.println("--------------数据保存成功--------------");
						}else{
							System.out.println("--------------第 "+j+" 条数据邮箱不存在,取消下载--------------");
						}
					}else{
						System.out.println("==============第 "+(++j)+" 条用户数据不存在,取消下载============");
					}
				}
			}
		}catch(Exception e){
			FileLog.logDebug(FILE_PATH+".main()=="+e);
			e.printStackTrace();
		}finally{
			try {
				if(con != null){
					con.close();
					con = null;
				}
			} catch (SQLException e) {
				FileLog.logDebug(FILE_PATH+".main()=="+e);
				e.printStackTrace();
			}
		}
	}
	
	public static int checkEmail(String content){
		int flag = 1; //email存在
		String email = LoadHtml.getValue(content, "<span id=\"email\">", "</span>");
		if("".equals(email)){
			flag = 2; //email不存在
		}
		return flag;
	}
	
	public static int checkExist(String content){
		int flag = 1; //简历存在
		if(content.indexOf("该简历不存在，或已被管理员删除") != -1){
			flag = 2;
		}
		return flag;
	}
	
	public static void insertData(Connection con, String content, int userId){
		String sql = "insert into FoShan(resumeContent, userId) values(?,?)";
		PreparedStatement pstmt = null;
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, content);
			pstmt.setInt(2, userId);
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
            try{
                if(pstmt != null) {
                    pstmt.close();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
	}
	
	public static boolean hasData(Connection con, int userId){
		boolean isCheck = false;
		String sql = "select count(*) from FoShan where userId = "+userId;
		Statement st = null;
		ResultSet rs = null;
		try{
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs != null){
				while(rs.next()){
					if(rs.getInt(1) > 0)isCheck = true;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs != null){
					rs.close();
					rs = null;
				}
				if(st != null){
					st.close();
					st = null;
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return isCheck;
	}
}
