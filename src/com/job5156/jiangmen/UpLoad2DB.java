package com.job5156.jiangmen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Session;

import com.job5156.down.util.DownPhoto;
import com.job5156.server.EntityManager;
import com.job5156.server.SessionManager;
import com.job5156.util.DateUtil;
import com.job5156.util.RandomString;
import com.job5156.util.StringUtil;


public class UpLoad2DB {
	private static String inputDate = DateUtil.getNowDateTime();

	public static void main(String args[]) 
	{ 
		UpLoad2DB upload = new UpLoad2DB();
		System.out.println("导简历开始...........");
		upload.createBaseInfo();
		System.out.println("导简历结束...........");
	}

	public void createBaseInfo() 
	{
        Connection targetCon = null;
        Session sourceSession = null;
        int id = 0;
        try {
        	 sourceSession = SessionManager.currentSession();
             String targetUrl ="jdbc:mysql://192.168.2.187/changsha?user=root&password=123&zeroDateTimeBehavior=convertToNull";
             targetCon = DriverManager.getConnection(targetUrl);
             int dataLoadNumber = 5000;
             int allRecord = 0;
             int recordCount = 0;
             //////////查询总的记录数///////////////
             allRecord = EntityManager.getAllEntityNumberByHql("select count(m.id) from JiangMenResume m", sourceSession);
            ///////////查询总的记录数/////////////
            int allPage=1;
            if(allRecord>dataLoadNumber){             
                 allPage = allRecord / dataLoadNumber + ((allRecord % dataLoadNumber == 0) ? 0 : 1);
            }
            for(int icount = 0; icount<allPage; icount++){
            	List list = EntityManager.getEntityByHqlAndStartRecords("from JiangMenResume", sourceSession, icount*dataLoadNumber, dataLoadNumber);
                int j = 0;
                if(list != null && list.size() > 0){
                	for(int i=0; i<list.size(); i++){
                		System.out.print("===========导入第"+(icount+1)+"批数据,第"+(++j)+"个用户基本信息===============\n");
                		String fileName = "";
                		int temp = 0;
                		JiangMenResume jiangmen = (JiangMenResume)list.get(i);
                        temp = checkEmail(StringUtil.getNotNullStr(jiangmen.getEmail()),targetCon);
                        if(temp == 3){
                        	recordCount ++;
                        	System.out.println("------当前第 "+recordCount+" 条数据-------");
                            ///////////////根据用户图片地址下载图片到本地并返回图片名///////////////////
                        	if(checkPhotoStr(StringUtil.getNotNullStr(jiangmen.getPhotoStr()))){
                            	String picUrl = "http://www.xhrc.com.cn/";
                            	picUrl += StringUtil.getNotNullStr(jiangmen.getPhotoStr()).substring(3);
                            	fileName = DownPhoto.download(picUrl,recordCount,"J121");
                        	}
                        	///////////////根据用户图片地址下载图片到本地并返回图片名///////////////////
                        	id = insertUserBasicdata(targetCon,jiangmen,fileName);
                        	System.out.println("用户主键:"+id);
                            if(id>0)
                            {
                            	insertUserIntent(targetCon,jiangmen,id);
        	                    insertUserSkill(targetCon,jiangmen,id);
        	                    if(checkSchool(jiangmen)){
        	                    	insertUserSchool(targetCon,jiangmen,id);
        	                    }else{
        	                    	System.out.println("教育检测不符合,不保存");
        	                    }
        	                    if(checkText(jiangmen)){
        	                    	insertUserWork(targetCon,jiangmen,id);
        	                    }else{
        	                    	System.out.println("工作经历检测不符合,不保存");
        	                    }
       	                    	if(!fileName.equals("")){
           	                    	insertPhoto(targetCon,fileName,id);
       	                    	}else{
       	                    		System.out.println("照片不存在,不保存");
       	                    	}
                            }
                        }else{
                        	System.out.println("Email检测标志:"+temp);
                        	if(temp == 1){
                        		System.out.println("用户Email不存在或者不合法,导入下一条数据");
                        	}else if(temp == 2){
                        		System.out.println("用户Email重复,导入下一条数据");
                        	}
                        }
                	}
                }
                sourceSession.clear();
            }
          }
	      catch (Exception e) 
	      {
	         e.printStackTrace();
	      }
        finally 
        {
            try 
            {
            	if(sourceSession != null){
            		sourceSession.close();
            		sourceSession = null;
            	}
                if (targetCon != null){
                	targetCon.close();
                	targetCon = null;
                }
            }catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
    }

  public int insertUserBasicdata(Connection con1,JiangMenResume resume,String photoName) {
      PreparedStatement pstmt = null;
      StringBuffer sqlBuffer = new StringBuffer();
      int id = 0;
      String[] tempCity = null;
      String[][] contact = null;
      try {
          sqlBuffer.append("INSERT INTO user_basicdata(");
          sqlBuffer.append("useraccounts,userpassword,username,sex,nation,marriage,birthday,stature,cardtype,cardtypenum,");
          sqlBuffer.append("hometown_p,hometown_c,location_p,location_c,contact1,contact2,phone,hiddenphone,mobile,hiddenmobile,");
          sqlBuffer.append("email,hiddenemail,IM,address,zipcode,highDegree,special,school,homepage,cre_date,rev_date,pass,");
          sqlBuffer.append("flag,readcount,logincount,resume_set,selfappraise,jobcount,jobyear,jobmonth,resumetype,comid,");
          sqlBuffer.append("resume_grade,lasteditby,lastedit,passdate,comefrom,havephoto,ip,EmailWilling,vipMember,fre_date");
          sqlBuffer.append(")VALUES");
          sqlBuffer.append("(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
          pstmt = con1.prepareStatement(sqlBuffer.toString());
          pstmt.setString(1,StringUtil.getNotNullStr(resume.getEmail()));  //useraccounts
          pstmt.setString(2,"job5156");       //userpassword
          pstmt.setString(3,StringUtil.getNotNullStr(resume.getUserName()));   //username
          int sex = StringUtil.parseInt(MapTable.getCodeTwo(StringUtil.getNotNullStr(resume.getSex()), MapTable.sex), 0);
          pstmt.setInt(4,sex);
          pstmt.setString(5,MapTable.getNation(StringUtil.getNotNullStr(resume.getNation())));//民族  
          
          pstmt.setInt(6,StringUtil.parseInt(MapTable.getCodeTwo(StringUtil.getNotNullStr(resume.getMarriage()), MapTable.marriage), 3));  //婚否，如果不知道，则保密
          pstmt.setString(7,"");  //出生年月
          
          pstmt.setInt(8,StringUtil.parseInt(resume.getStature())); //身高
       	  pstmt.setInt(9,0);//证件类型
          pstmt.setString(10,""); //身份证号码
         
          //城市
          tempCity = AnalysisHelper.analysisCity(StringUtil.getNotNullStr(resume.getHometown_c()));
          pstmt.setInt(11,StringUtil.parseInt(tempCity[0]));
          pstmt.setInt(12,StringUtil.parseInt(tempCity[1]));
          
          //现在所在地
          pstmt.setInt(13,0);
          pstmt.setInt(14,0);
          
          tempCity = null;
          
          pstmt.setInt(18,0);//显示   
          pstmt.setInt(20,0); //显示 
          
          //////////////////////////////////////////////////////需要制作程序修改//////////////////////////
          contact = AnalysisHelper.analysisContact(StringUtil.getNotNullStr(resume.getPhone()),StringUtil.getNotNullStr(resume.getMobile()));
          
          pstmt.setInt(15,StringUtil.parseInt(contact[0][0]));  //主要联系方式为手机
          pstmt.setInt(16,StringUtil.parseInt(contact[1][0]));  //后备联系方式为电话 
          pstmt.setString(17,contact[1][1]);    //电话
          pstmt.setString(19,contact[0][1]);    //手机 
          
          contact = null;
          /////////////////////////////////////////////////////////////////////////////////////////////
          
          pstmt.setString(21,StringUtil.getNotNullStr(resume.getEmail())); //email
          pstmt.setInt(22,0);//公开email
          pstmt.setString(23,null);//IM
          
          pstmt.setString(24,StringUtil.getNotNullStr(resume.getAddress()));//address
          pstmt.setString(25,StringUtil.getNotNullStr(resume.getPostCode()));//邮编
          
          pstmt.setInt(26,StringUtil.parseInt(MapTable.getCodeTwo(StringUtil.getNotNullStr(resume.getHighDegree()), MapTable.highDegree))); //最高学历
          pstmt.setString(27,AnalysisHelper.getSpecial(StringUtil.getNotNullStr(resume.getSpecial()), StringUtil.getNotNullStr(resume.getSpecial1())));  //专业
          pstmt.setString(28,StringUtil.getNotNullStr(resume.getSchool())); //学校
          pstmt.setString(29,""); //个人主页
          
          pstmt.setString(30,inputDate);//创建时间
          pstmt.setString(31,inputDate);//最后登录时间
          pstmt.setInt(32,0);   //是否审核,默认不审核

          pstmt.setInt(33,0);   //简历是否可见
          pstmt.setInt(34,0);   //被企业查看次数
          pstmt.setInt(35,0);   //登录次数
          pstmt.setInt(36,0);  //模板类型
          pstmt.setString(37,StringUtil.getNotNullStr(resume.getSelfappraise()));  //自我评价=========================
          pstmt.setInt(38,0);//工作企业数
          pstmt.setInt(39,0);//工作年          
          pstmt.setInt(40,0);//工作月  
          pstmt.setInt(41,0);//简历类型 1为应届生===============================
          pstmt.setString(42,"0"); //过滤公司ID
          pstmt.setInt(43,0);//resume_grade
          pstmt.setString(44,StringUtil.getNotNullStr(resume.getUserName()));  //lastedit by 
          pstmt.setString(45,inputDate);//lastedit
          pstmt.setString(46,null); //passdate
          pstmt.setInt(47,121);  //come from = 121 表示简历来源于江门
          pstmt.setInt(48,photoName.equals("")?0:1);//havephoto
          pstmt.setString(49,null);//IP 
          pstmt.setInt(50,1); //EmailWilling
          pstmt.setInt(51,0); //不是VIP
          pstmt.setString(52,inputDate); //更新时间
          pstmt.executeUpdate();
          
          String getIdSql = "select userid from user_basicdata where comefrom=121 and useraccounts='"+StringUtil.getNotNullStr(resume.getEmail())+"'";
          ResultSet rs = pstmt.executeQuery(getIdSql);
          if(rs.next()){
          	id = Integer.parseInt(rs.getString(1));
          } 
          if(rs != null)
          {
        	  rs.close();
              rs = null;
          }
      } catch (Exception e) {
          e.printStackTrace();
      } finally {
          try {
              if(pstmt != null) {
                  pstmt.close();
              }
              if(sqlBuffer != null){
                  sqlBuffer = null;
              }
          } catch (Exception e) {
              e.printStackTrace();
          }
      }
      
      return id;
  }
  
  
      public void insertUserIntent(Connection con1,JiangMenResume resume,int userID) {
      PreparedStatement pstmt = null;
      StringBuffer sqlBuffer = new StringBuffer();
      try {
          //23
          String[] tempStr = null;
          sqlBuffer.append("INSERT INTO user_intent(");
          sqlBuffer.append("userid,jobcode1,jobcode2,jobcode3,workyear,workyear1,workcalling1,");
          sqlBuffer.append("workcalling,jobLocation1,jobLocation2,jobLocation3,salary,Neededhouse,");
          sqlBuffer.append("checkinDate,checkinDate1,otherRequirement,rev_date,cre_date,checkinDate2,");
          sqlBuffer.append("otherJob1,otherJob2,otherJob3");
          sqlBuffer.append(")VALUES");
          
          sqlBuffer.append("(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
          pstmt = con1.prepareStatement(sqlBuffer.toString());
          pstmt.setInt(1,userID);
          /////////////////////////////////需要处理///////////////////////////////////////////////////////////
          tempStr = AnalysisHelper.analysJobCata(resume);
          pstmt.setInt(2,StringUtil.parseInt(tempStr[0]));//岗位类型1
          pstmt.setInt(3,StringUtil.parseInt(tempStr[1]));//岗位类型2
          pstmt.setInt(4,StringUtil.parseInt(tempStr[2]));//岗位类型3
          pstmt.setString(20,tempStr[3]);//岗位类型1
          pstmt.setString(21,null);//岗位类型2
          pstmt.setString(22,null);//岗位类型3
          tempStr = null;
          ///////////////////////////////////////////////////////////////////////////////////////////////////
          pstmt.setInt(5,0);//工作年
          pstmt.setInt(6,0);//工作年
          pstmt.setString(7,null);//工作行业
          pstmt.setString(8,null);//工作行业
          tempStr = AnalysisHelper.analysJobLocation(resume);
          pstmt.setInt(9,StringUtil.parseInt(tempStr[0]));//工作地点1
          pstmt.setInt(10,StringUtil.parseInt(tempStr[1]));//工作地点2
          pstmt.setInt(11,StringUtil.parseInt(tempStr[2]));//工作地点3
          tempStr = null;
          
          pstmt.setString(12,AnalysisHelper.analysisSalary(StringUtil.getNotNullStr(resume.getSalary())));//薪水
          pstmt.setInt(13,0);//住房
          pstmt.setInt(14,StringUtil.parseInt(MapTable.getCodeTwo(StringUtil.getNotNullStr(resume.getCheckindate()),MapTable.checkInDate)));//到岗时间
          pstmt.setString(15,null);//到岗时间
          pstmt.setString(16,null);//其它要求
          pstmt.setString(17,inputDate); //创建时间
          pstmt.setString(18,inputDate); //修改时间
          pstmt.setString(19,null);//到岗时间
          pstmt.executeUpdate();
          pstmt.close();

      } catch (Exception e) {
          System.out.println("insertUserIntent()發生了" + e.getMessage() + "例外");
      } finally {
          try {
              if (pstmt != null) {
                  pstmt.close();
                  pstmt = null;
              }
              if(sqlBuffer != null){
                  sqlBuffer = null;
              }
          } catch (Exception e) {
              e.printStackTrace();
          }
      }
  }

  public void insertUserWork(Connection con1,JiangMenResume resume,int userID) {
      PreparedStatement pstmt = null;
      StringBuffer sqlBuffer = new StringBuffer();
      try {
    	  String[] info = AnalysisHelper.getWorkInfo(StringUtil.getNotNullStr(resume.getWorkText()));
    	  if(info != null){
              sqlBuffer.append("INSERT INTO user_work(");
              sqlBuffer.append("userid,begindateyear,begindatemonth,enddateyear,enddatemonth,");
              sqlBuffer.append("comname,comType,comCalling,mainCatalog,jobFunctionId,salary,");
              sqlBuffer.append("flag,otherPosition,description,leftReason,cre_date,rev_date");
              sqlBuffer.append(")VALUES");
              sqlBuffer.append("(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
              pstmt = con1.prepareStatement(sqlBuffer.toString());
              pstmt.setInt(1,userID);
              pstmt.setInt(2,Integer.parseInt(info[0]));//开始年
              pstmt.setInt(3,Integer.parseInt(info[1]));//开始月
              pstmt.setInt(4,Integer.parseInt(info[2]));//结束年
              pstmt.setInt(5,Integer.parseInt(info[3]));//结束月
              pstmt.setString(6,StringUtil.getSubStr(info[4], 0, 25));//公司名
              pstmt.setInt(7,0);//公司类型
              pstmt.setInt(8,0);//行业类型
              pstmt.setInt(9,0);//岗位大类
              pstmt.setInt(10,0);//小类
              pstmt.setString(11,"保密");//薪水
              pstmt.setInt(12,0);//是否在职
              pstmt.setString(13,"");//其它职位
              pstmt.setString(14,StringUtil.getNotNullStr(resume.getWorkText()));//描述
              pstmt.setString(15,"");//离职原因
              pstmt.setString(16,inputDate);//创建日期
              pstmt.setString(17,inputDate);//日期
              pstmt.executeUpdate();
              pstmt.close();
              info = null;
    	  }else{
    		  info = null;
    		  return;
    	  }
      } catch (Exception e) {
          System.out.println("insertUserWork()發生了" + e.getMessage() + "例外");
      } finally {
          try {
              if (pstmt != null) {
                  pstmt.close();
                  pstmt = null;
              }
              if(sqlBuffer != null){
                  sqlBuffer = null;
              }
          } catch (Exception e) {
              e.printStackTrace();
          }
      }
  }
  

  public void insertUserSkill(Connection con1,JiangMenResume resume,int userID) {
      PreparedStatement pstmt = null;
      StringBuffer sqlBuffer = new StringBuffer();
      try {
          sqlBuffer.append("INSERT INTO user_skill(");
          
          sqlBuffer.append("userid,techTitle,computerLevel,computerskill,certificate,");
          sqlBuffer.append("language1,Leve1,certificate1,language2,Leve2,certificate2,");
          sqlBuffer.append("chineseLevel,cantoneseLevel,Language3,otherskills,cre_date,rev_date");
          sqlBuffer.append(")VALUES");

          sqlBuffer.append("(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
          pstmt = con1.prepareStatement(sqlBuffer.toString());
          pstmt.setInt(1,userID);
          pstmt.setString(2,null);
          pstmt.setInt(3,-1);//计算机水平
          pstmt.setString(4,null);//计算机技能
          pstmt.setInt(5,0);//证书
          pstmt.setInt(6,1000);//语言类型1,英语
          pstmt.setInt(7,0);//语言水平1
          pstmt.setInt(8,StringUtil.parseInt(MapTable.getCodeTwo(StringUtil.getNotNullStr(resume.getEnglishLever()), MapTable.englishLevel), 4));//证书1默认为一般
          pstmt.setInt(9,StringUtil.parseInt(MapTable.getCodeTwo(StringUtil.getNotNullStr(resume.getOtherEnglish()), MapTable.otherEnglish), 2400));//语言类型2,默认其他类型
          pstmt.setInt(10,0);//语言水平2
          pstmt.setInt(11,StringUtil.parseInt(MapTable.getCodeTwo(StringUtil.getNotNullStr(resume.getOtherEnglishLevel()),MapTable.englishLevel), 4));//证书2
          pstmt.setInt(12,0);//普通话
          pstmt.setInt(13,0);//粤语
          pstmt.setString(14,null);
          pstmt.setString(15,StringUtil.getNotNullStr(resume.getPersonSkill()));//其它技能
          pstmt.setString(16,inputDate); //创建时间
          pstmt.setString(17,inputDate); //修改时间
          pstmt.executeUpdate();
          pstmt.close();
      } catch (Exception e) {
          System.out.println("insertUserSkill()發生了" + e.getMessage() + "例外");
      } finally {
          try {
              if (pstmt != null) {
                  pstmt.close();
                  pstmt = null;
              }
              if(sqlBuffer != null){
                  sqlBuffer = null;
              }
          } catch (Exception e) {
              e.printStackTrace();
          }
      }
  }

  
  public void insertUserSchool(Connection con1,JiangMenResume resume,int userID) {
      PreparedStatement pstmt = null;
      StringBuffer sqlBuffer = new StringBuffer();
      int temp = 0;
      int year = 0;
      try {
          sqlBuffer.append("INSERT INTO user_school(");
          sqlBuffer.append("userid,degree,begindateyear,begindatemonth,enddateyear,");
          sqlBuffer.append("enddatemonth,school,speciality,certificate,cre_date,rev_date,");
          sqlBuffer.append("course,flag)VALUES");
          sqlBuffer.append("(?,?,?,?,?,?,?,?,?,?,?,?,?)");
          pstmt = con1.prepareStatement(sqlBuffer.toString());
          pstmt.setInt(1,userID); 
          pstmt.setInt(2,StringUtil.parseInt(MapTable.getCodeTwo(StringUtil.getNotNullStr(resume.getHighDegree()), MapTable.highDegree))); //学历
          pstmt.setInt(3,AnalysisHelper.getSchoolBeginDate(resume));//开始年
          pstmt.setInt(4,9);//开始月
          pstmt.setInt(5,AnalysisHelper.getSchoolEndYear(StringUtil.getNotNullStr(resume.getGraduateDate())));//结束年
          pstmt.setInt(6,7);//结束月
          pstmt.setString(7,StringUtil.getNotNullStr(resume.getSchool())); //毕业学校
          pstmt.setString(8,AnalysisHelper.getSpecial(StringUtil.getNotNullStr(resume.getSpecial()), StringUtil.getNotNullStr(resume.getSpecial1()))); //专业
          pstmt.setString(9,"");//证书
          pstmt.setString(10,inputDate); //创建时间
          pstmt.setString(11,inputDate); //修改时间
          pstmt.setString(12,"");
          pstmt.setInt(13,0);//是否在读 

          pstmt.executeUpdate();
          pstmt.close();
      } catch (Exception e) {
          System.out.println("insertUserSchool()發生了" + e.getMessage() + "例外");
      } finally {
          try {
              if (pstmt != null) {
                  pstmt.close();
                  pstmt = null;
              }
              if(sqlBuffer != null){
                  sqlBuffer = null;
              }
          } catch (Exception e) {
              e.printStackTrace();
          }
      }
  }
  
  
  
  public void insertPhoto(Connection con1,String path,int userID) {
      PreparedStatement pstmt = null;
      StringBuffer sqlBuffer = new StringBuffer();
      String inputDate = DateUtil.getNowDateTime();
      try {
          sqlBuffer.append("INSERT INTO user_upload(");
          sqlBuffer.append("UserId,UploadType,UploadPath,UploadDate,HiddenTag,");
          sqlBuffer.append("Description,flag");
          sqlBuffer.append(")VALUES");
          sqlBuffer.append("(?,?,?,?,?,?,?)");
          pstmt = con1.prepareStatement(sqlBuffer.toString());
          pstmt.setInt(1,userID); 
          pstmt.setInt(2,0); //照片
          pstmt.setString(3,path);
          pstmt.setString(4,inputDate);
          pstmt.setInt(5,0);
          pstmt.setString(6,"");
          pstmt.setInt(7,0); 
          pstmt.executeUpdate();
          pstmt.close();
      } catch (Exception e) {
          System.out.println("insertPhoto()發生了" + e.getMessage() + "例外");
      } finally {
          try {
              if (pstmt != null) {
                  pstmt.close();
                  pstmt = null;
              }
              if(sqlBuffer != null){
                  sqlBuffer = null;
              }
          } catch (Exception e) {
              e.printStackTrace();
          }
      }
  }
  
  public void updateBaseInfo(Connection con,int userid,int havephoto){
	  PreparedStatement pstmt = null;
	  StringBuffer sqlBuffer = new StringBuffer();
      try {
	      sqlBuffer.append("UPDATE user_basicdata set ");
	      sqlBuffer.append("havephoto= ?");
	      sqlBuffer.append(" where userid = " +userid);
	      pstmt = con.prepareStatement(sqlBuffer.toString());
	      pstmt.setInt(1,havephoto);
	      pstmt.executeUpdate();
	      pstmt.close();
	      sqlBuffer = null;
      } catch (Exception e) {
          System.out.println("updateBaseInfo()發生了" + e.getMessage() + "例外");
      } finally {
	      try {
	          if (pstmt != null) {
	              pstmt.close();
	              pstmt = null;
	          }
              if(sqlBuffer != null){
                  sqlBuffer = null;
              }
	      } catch (Exception e) {
	          e.printStackTrace();
	      }
      }
  }
  /**
   * @param email
   * @param account
   * @param con
   * @return
   * 1; //email 为空 or email 不合法 不保存
   * 2;//email 存在,不保存
   * 3;//email 不存在
   * 4;//email 不存在 帐号存在  保存为email
   */
  public int checkEmail(String email,Connection con)
  {
	  int flag = 0;
	  if(StringUtil.getNotNullStr(email).equals("") || StringUtil.getNotNullStr(email).indexOf("@")==-1)
	  {
		  flag = 1; //email 为空 or email 不合法 不保存
	  }
	  else 
	  {
		  if(isExistEmail(con,email)==1)
		  {
			  flag = 2;//email 存在重复记录,不保存
		  }
		  else
		  {
			  flag = 3;//email 不存在重复记录
		  }
	  }
	  return flag;
  }
  
  private boolean checkPhotoStr(String photoStr){
	  boolean isCheck = false;
	  if(photoStr != null && !"".equals(photoStr) && 
		!"../uploadfile/photo/nopic2.gif".equals(photoStr) && 
		!"../uploadfile/photo/nopic1.gif".equals(photoStr) &&
		photoStr.indexOf(".jpg") != -1){
		  isCheck = true;
	  }
	  return isCheck;
  }
  
  /**
   * @param con
   * @param email
   * @return
   * 0 表示email 不存在
   * 1 表示email 存在
   */
  private int isExistEmail(Connection con, String email)
  {
	  int  flag = 0;
	  String sql = " select * from user_basicdata where email='"+email+"'";
	  long count = getResuleCount(con, sql);
	  if(count>0) flag = 1;
	  return flag;
  }
  
  /**
   * @param con
   * @param account
   * @return
   * 0 表示account 不存在
   * 1 表示account 存在
   */
  private int isExistAccount(Connection con, String account)
  {
	  int  flag = 0;
	  String sql = " select * from user_basicdata where useraccounts='"+account+"'";
	  long count = getResuleCount(con, sql);
	  if(count>0) flag = 1;
	  return flag;
  }
  
  /**根据长度获得一串数值组成的字符串*/
  private String getMathStringByLength(int length){
      RandomString test = new RandomString();
      String code="";
      test.setLength(length);
      test.setCharset("0-9a-z");
      try {
          test.generateRandomObject();
          code = test.getRandom();
      } catch (Exception e) {
          e.printStackTrace();
      }        
      return code;
  }
  
  /**过滤内容(不能全是数字或者字母或者中文汉字)**/
  private boolean checkText(JiangMenResume resume){
	  boolean isCheck = false;
	  if(!AnalysisHelper.isCharacter(StringUtil.getNotNullStr(resume.getWorkText())) && 
			  !AnalysisHelper.isChinese(StringUtil.getNotNullStr(resume.getWorkText())) && 
			  !AnalysisHelper.isNumeric(StringUtil.getNotNullStr(resume.getWorkText()))){
		  isCheck = true;
	  }
	  return isCheck;
  }

  /**过滤教育培训**/
  private boolean checkSchool(JiangMenResume resume){
	  boolean isCheck = false;
	  if(!"".equals(StringUtil.getNotNullStr(resume.getHighDegree())) && 
			  !"".equals(StringUtil.getNotNullStr(resume.getGraduateDate())) && 
			  !"".equals(StringUtil.getNotNullStr(resume.getSchool()))){
		  if(AnalysisHelper.getSchoolBeginDate(resume) > 0){
			  isCheck = true;
		  }
	  }
	  return isCheck;
  }
  
  /**得到总的记录数**/
	private  long getResuleCount(Connection con,String sql) 
	{
		ResultSet rs = null;
		long rscount = 0;
		Statement stmt = null;
		try
		{
			if(con!=null)
			{
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next())
				{
					rscount = rs.getLong(1);
				}
				stmt = null;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null)
			{
				try
				{
					rs.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
				rs = null;
			}
		}
		return rscount;
	}
	
}
