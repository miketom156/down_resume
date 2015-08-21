package com.job5156.ningbo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import org.hibernate.Session;

import com.job5156.foshan.HtmlMethodImpl;
import com.job5156.server.FileLog;
import com.job5156.util.StringUtil;

public class DownResume{
	
	private static final String FILE_PATH = "com.job5156.ningbo.DownResume";
	//private static final String SEARCH_PATH = "http://www3.nbrs.gov.cn/nbrs/rc/jianli/search.jsp?prepage=20&channelid=75025&sortfield=-ZHSXSJ";
	private static final String SEARCH_PATH = "http://www3.nbrs.gov.cn/nbrs/rc/jianli/search.jsp?searchword=PERSONID%21%3D0+AND+HIGH+%3D+%270%27++AND+ZHSXSJ+%3E%3D%272009.12.1+8%3A25%3A17%27&sortfield=-ZHSXSJ&channelid=75025";
	private static final String PERSON_PATH = "http://www.nbrc.com.cn/project/enterprise/rcViewEx.do?personid=";

	public static void main(String[] args)
	{
		Session session = null;
		Connection con = null;
		HtmlMethodImpl loadHtml = null;
		System.out.println("�����������������������ؿ�ʼ��������������");
		try{
			//String loginUrl = getLoginUrl("cqlihua", "xinqiao1163");
			String loginUrl = getLoginUrl("ningbobft", "123654");
			loadHtml = new HtmlMethodImpl(true, loginUrl);
			String targetUrl = "jdbc:mysql://192.168.2.187/changsha?user=root&password=123&zeroDateTimeBehavior=convertToNull";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(targetUrl);
			int totalPage = 0;                                //���������ҳ��
			loadHtml.setUrl(SEARCH_PATH+"&page=1");
			String searchList = loadHtml.getHtml();
			totalPage = getTotalPageCount(searchList);
			if(totalPage > 0){
				downResumeData(searchList, loadHtml, con);
				for(int i=1; i<=totalPage; i++){
					loadHtml.setUrl(SEARCH_PATH+"&page="+i);
					searchList = loadHtml.getHtml();
					downResumeData(searchList, loadHtml, con);
					System.out.println("------------------��ǰ�� "+i+" ҳ-----------------");
					Thread.sleep(1000);
				}
			}
		}catch(Exception e){
			loadHtml.release();
			e.printStackTrace();
		}finally{
			try {
				if(con != null){
					con.close();
					con = null;
				}
				loadHtml.release();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("�����������������������ؽ�������������������");
	}
	
	/**
	 * ���ر��������б��еļ�������
	 * @param searchList
	 */
	public static void downResumeData(String searchList, HtmlMethodImpl loadHtml, Connection con){
		String listData = getListData(searchList);
		Vector vector = getUserCodeArray(listData);
		if(vector.size() > 0){
			for(int i=0; i<vector.size(); i++){
				String code = StringUtil.getNotNullStr(vector.get(i));
				if(!hasData(con, code)){
					loadHtml.setUrl(PERSON_PATH+code);
					String userResume = loadHtml.getHtml();
					if(checkEmail(userResume, "email��", "<td align=\"left\" width=\"40%\">", "</td>")){
						System.out.println("�������ؼ���======="+code);
						userResume = getInterceptStr(userResume, "<b> ��<img src=\"/project/enterprise/images/space.gif\" width=\"20\" height=\"1\">�� </b>", 
								"<img src=\"/project/enterprise/images/space.gif\" height=\"5\" width=\"1\" border=\"0\">",
								"<table cellpadding=\"0\" cellspacing=\"0\" width=\"780\" align=\"center\" border=\"0\">");
						if(!"".equals(userResume)){
							insertData(con, userResume, code);
							System.out.println("�����������======="+code);
						}
					}else{
						System.out.println("���䲻����!ȡ������!");
					}
				}else{
					System.out.println("�����Ѵ���!ȡ������!");
				}
			}
		}
	}
	
	
	/**
	 * ����ѭ�����ݣ�ȡ���û�����
	 * @param dataListContent
	 * @return
	 */
	public static Vector getUserCodeArray(String dataListContent){
		Vector vector = new Vector();
		while(true){
			String userCode = HtmlMethodImpl.getValue(dataListContent, "<INPUT type=\"checkbox\" VALUE='", "' name=\"selected_id\">");
			if(!"".equals(userCode)){
				vector.add(userCode);
				String inputStr = "<INPUT type=\"checkbox\" VALUE='"+userCode+"' name=\"selected_id\">";
				int pos = dataListContent.indexOf(inputStr);
				dataListContent = dataListContent.substring(pos+inputStr.length());
			}else{
				break;
			}
		}
		return vector;
	}
	
	/**
	 * ��ȡ��������б��е�ѭ������
	 * @param searchListContent
	 * @return
	 */
	public static String getListData(String searchListContent){
		return HtmlMethodImpl.getValue(searchListContent, "<!-- ����ѭ����ʼ -->", "<!-- ����ѭ������ -->");
	}
	
	/**
	 * ������������б� ��ȡ��ҳ��
	 * @param searchListContent
	 * @return
	 */
	public static int getTotalPageCount(String searchListContent){
		int page = 0;
		String pageStr = HtmlMethodImpl.getValue(searchListContent, "<!-- ����ѭ������ -->", "<script language=\"javascript\">");
		if(pageStr != "" && !"".equals(pageStr)){
			pageStr = HtmlMethodImpl.getValue(pageStr, "��", "ҳ");
			int splitCharPos = pageStr.indexOf("/");
			if(splitCharPos != -1){
				page = StringUtil.parseInt(pageStr.substring(splitCharPos+1));
			}
		}
		return page;
	}
	
	/**
	 * ��֤�Ƿ��������
	 * @param content
	 * @return
	 */
	public static boolean checkEmail(String content, String intercept, String beginStr, String endStr){
		boolean isCheck = false;
		if(!"".equals(getInterceptStr(content, intercept, beginStr, endStr)))isCheck = true;
		return isCheck;
	}
	
	/**
	 * ��ȡ�ַ���
	 * @return
	 */
	public static String getInterceptStr(String content, String intercept, String beginStr, String endStr){
		String temp = "";
		int interceptPos = content.indexOf(intercept);
		if(interceptPos != -1){
			String interceptStr = content.substring(interceptPos+intercept.length());
			temp = HtmlMethodImpl.getValue(interceptStr, beginStr, endStr);
		}
		return temp.trim();
	}
	
	public static int checkExist(String content){
		int flag = 1; //��������
		if(content.indexOf("�ü��������ڣ����ѱ�����Աɾ��") != -1){
			flag = 2;
		}
		return flag;
	}
	
	public static void insertData(Connection con, String content, String userCode){
		String sql = "insert into NingBo(resumeContent, userCode) values(?,?)";
		PreparedStatement pstmt = null;
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, content);
			pstmt.setString(2, userCode);
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
	
	public static boolean hasData(Connection con, String userCode){
		boolean isCheck = false;
		String sql = "select count(*) from NingBo where userCode = '"+userCode+"'";
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
	
	public static String getLoginUrl(String userName, String password){
		String loginUrl = "http://www.nbrc.com.cn/project/enterprise/login.do?zhangHao="+userName+"&danWeiMm="+password;
		return loginUrl;
	}
}
