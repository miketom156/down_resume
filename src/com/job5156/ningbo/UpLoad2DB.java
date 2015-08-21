package com.job5156.ningbo;

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
		System.out.println("��������ʼ...........");
		upload.createBaseInfo();
		System.out.println("����������...........");
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
             int dataLoadNumber = 500;
             int allRecord = 0;
             int recordCount = 0;
             //////////��ѯ�ܵļ�¼��///////////////
             allRecord = EntityManager.getAllEntityNumberByHql("select count(*) from NingBoResume m", sourceSession);
            ///////////��ѯ�ܵļ�¼��/////////////
            int allPage=1;
            if(allRecord>dataLoadNumber){             
                 allPage = allRecord / dataLoadNumber + ((allRecord % dataLoadNumber == 0) ? 0 : 1);
            }
            //allPage=1;//����ʹ�á�
            System.out.println("----------------һ����Ҫ���� ("+allRecord+") ������,�� ("+allPage+") ������-----------------");
            List list = null;
            for(int icount = 44; icount<allPage; icount++){
            	list = EntityManager.getEntityByHqlAndStartRecords("from NingBoResume", sourceSession, icount*dataLoadNumber, dataLoadNumber);
                int j = 0;
                if(list != null && list.size() > 0){
                	NingBoResume ningbo = null;
                	for(int i=0; i<list.size(); i++){
                		System.out.print("===========�����"+(icount+1)+"������,��"+(++j)+"���û�������Ϣ===============\n");
                		String fileName = "";
                		int temp = 0;
                		ningbo = (NingBoResume)list.get(i);
                        temp = checkEmail(StringUtil.getNotNullStr(ningbo.getEmail()),targetCon);
                        if(temp == 3){
                        	recordCount ++;
                        	System.out.println("------��ǰ�� "+recordCount+" ������-------");
                            ///////////////�����û�ͼƬ��ַ����ͼƬ�����ز�����ͼƬ��///////////////////
                        	/*if(checkPhotoStr(StringUtil.getNotNullStr(ningbo.getPhotoUrl()))){
                            	String picUrl = "http://www.nbrc.com.cn/";
                            	String picUrl="http://www.nbrc.com.cn/Project_rsj/person/photo/8aca8844220aefa201221b37aacb4f60.gif";һ�������ļ���ͼƬ��ַ��
                            	picUrl += StringUtil.getNotNullStr(ningbo.getPhotoUrl()).substring(3);
                            	fileName = DownPhoto.download(picUrl,recordCount,"J121");
                        	}*/
                        	///////////////�����û�ͼƬ��ַ����ͼƬ�����ز�����ͼƬ��///////////////////
                        	id = insertUserBasicdata(targetCon,ningbo,fileName);
                        	System.out.println("�û�����:"+id);
                            if(id>0)
                            {
                            	insertUserIntent(targetCon,ningbo,id);
        	                    insertUserSkill(targetCon,ningbo,id);
        	                    if(checkSchool(ningbo)){
        	                    	insertUserSchool(targetCon,ningbo,id);
        	                    }else{
        	                    	System.out.println("������ⲻ����,������");
        	                    }
        	                    if(checkText(ningbo)){
        	                    	insertUserWork(targetCon,ningbo,id);
        	                    }else{
        	                    	System.out.println("����������ⲻ����,������");
        	                    }
       	                    	if(!fileName.equals("")){
           	                    	//insertPhoto(targetCon,fileName,id);
       	                    	}else{
       	                    		System.out.println("��Ƭ������,������");
       	                    	}
                            }
                        }else{
                        	System.out.println("Email����־:"+temp);
                        	if(temp == 1){
                        		System.out.println("�û�Email�����ڻ��߲��Ϸ�,������һ������");
                        	}else if(temp == 2){
                        		System.out.println("�û�Email�ظ�,������һ������");
                        	}
                        }
                        
                        ningbo = null;
                	}
                }
                list = null;
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

  public int insertUserBasicdata(Connection con1,NingBoResume resume,String photoName) {
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
          pstmt.setString(2,getRandomPwd());       //userpassword������ַ�����������6λ����
          pstmt.setString(3,StringUtil.getNotNullStr(resume.getUserName()));   //username
          int sex = StringUtil.parseInt(MapTable.getCodeTwo(StringUtil.getNotNullStr(resume.getSex()), MapTable.sex), 0);
          pstmt.setInt(4,sex);
          pstmt.setString(5,MapTable.getNation(StringUtil.getNotNullStr(resume.getNation())));//����  
          
          pstmt.setInt(6,StringUtil.parseInt(MapTable.getCodeTwo(StringUtil.getNotNullStr(resume.getMarriage()), MapTable.marriage), 3));  //��������֪��������
          pstmt.setString(7,StringUtil.getNotNullStr(resume.getBirthday()));  //��������
          
          pstmt.setInt(8,StringUtil.parseInt(resume.getStature())); //���
       	  pstmt.setInt(9,0);//֤������
          pstmt.setString(10,""); //���֤����
         
          //����
          tempCity = AnalysisHelper.analysisCity(StringUtil.getNotNullStr(resume.getHometown_c()));
          pstmt.setInt(11,StringUtil.parseInt(tempCity[0]));
          pstmt.setInt(12,StringUtil.parseInt(tempCity[1]));
          tempCity = null;
         
          //�������ڵ�
          tempCity = AnalysisHelper.analysisCity(StringUtil.getNotNullStr(resume.getNowAddress()));
          pstmt.setInt(13,StringUtil.parseInt(tempCity[0]));
          pstmt.setInt(14,StringUtil.parseInt(tempCity[1]));
          
         
          
          pstmt.setInt(18,0);//��ʾ   
          pstmt.setInt(20,0); //��ʾ 
          
//////////////////////////////////////////////////////��Ҫ���������޸�//////////////////////////
          contact = AnalysisHelper.analysisContact(StringUtil.getNotNullStr(resume.getPhone()),StringUtil.getNotNullStr(resume.getMobile()));
          
          pstmt.setInt(15,StringUtil.parseInt(contact[0][0]));  //��Ҫ��ϵ��ʽΪ�ֻ�
          pstmt.setInt(16,StringUtil.parseInt(contact[1][0]));  //����ϵ��ʽΪ�绰 
          pstmt.setString(17,contact[1][1]);    //�绰
          pstmt.setString(19,contact[0][1]);    //�ֻ� 
          
          contact = null;
          /////////////////////////////////////////////////////////////////////////////////////////////
          /////////////////////////////////////////////////////////////////////////////////
          
          pstmt.setString(21,StringUtil.getNotNullStr(resume.getEmail())); //email
          pstmt.setInt(22,0);//����email
          pstmt.setString(23,null);//IM
          
          pstmt.setString(24,StringUtil.getNotNullStr(resume.getCallAddress()));//address
          pstmt.setString(25,StringUtil.getNotNullStr(resume.getZipcode()));//�ʱ�
          String schoolInfo[]=AnalysisHelper.analysisSchool(StringUtil.getNotNullStr(resume.getSchoolText()));
          pstmt.setInt(26,StringUtil.parseInt(schoolInfo[0])); //���ѧ��
//          pstmt.setString(27,AnalysisHelper.getSpecial(StringUtil.getNotNullStr(resume.getSpecial()), StringUtil.getNotNullStr(resume.getSpecial1())));  //רҵ
          pstmt.setString(27,StringUtil.getNotNullStr(schoolInfo[1]));
          pstmt.setString(28,StringUtil.getNotNullStr(schoolInfo[2])); //ѧУ
          pstmt.setString(29,""); //������ҳ
          
          pstmt.setString(30,inputDate);//����ʱ��
          pstmt.setString(31,inputDate);//����¼ʱ��
          pstmt.setInt(32,0);   //�Ƿ����,Ĭ�ϲ����

          pstmt.setInt(33,0);   //�����Ƿ�ɼ�
          pstmt.setInt(34,0);   //����ҵ�鿴����
          pstmt.setInt(35,0);   //��¼����
          pstmt.setInt(36,0);  //ģ������
          pstmt.setString(37,StringUtil.getNotNullStr(resume.getOtherInfo()));  //��������=========================
          pstmt.setInt(38,0);//������ҵ��
          pstmt.setInt(39,StringUtil.parseInt(resume.getJobYear().replaceAll("��","")));//������          
          pstmt.setInt(40,0);//������  
          pstmt.setInt(41,0);//�������� 1ΪӦ����===============================
          pstmt.setString(42,"0"); //���˹�˾ID
          pstmt.setInt(43,0);//resume_grade
          pstmt.setString(44,StringUtil.getNotNullStr(resume.getUserName()));  //lastedit by 
          pstmt.setString(45,inputDate);//lastedit
          pstmt.setString(46,null); //passdate
          pstmt.setInt(47,123);  //come from = 123 ��ʾ������Դ�������˲�����www.nbrc.com����������
          pstmt.setInt(48,photoName.equals("")?0:1);//havephoto
          pstmt.setString(49,null);//IP 
          pstmt.setInt(50,1); //EmailWilling
          pstmt.setInt(51,0); //����VIP
          pstmt.setString(52,inputDate); //����ʱ��
          pstmt.executeUpdate();
          
          String getIdSql = "select userid from user_basicdata where comefrom=123 and useraccounts='"+StringUtil.getNotNullStr(resume.getEmail())+"'";
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
  
  
      public void insertUserIntent(Connection con1,NingBoResume resume,int userID) {
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
          /////////////////////////////////��Ҫ����///////////////////////////////////////////////////////////
          tempStr = AnalysisHelper.analysJobCata(resume);
          pstmt.setInt(2,StringUtil.parseInt(tempStr[0]));//��λ����1
          pstmt.setInt(3,StringUtil.parseInt(tempStr[1]));//��λ����2
          pstmt.setInt(4,StringUtil.parseInt(tempStr[2]));//��λ����3
          pstmt.setString(20,tempStr[3]);//��λ����1
          pstmt.setString(21,null);//��λ����2
          pstmt.setString(22,null);//��λ����3
          tempStr = null;
          ///////////////////////////////////////////////////////////////////////////////////////////////////
          pstmt.setInt(5,0);//������
          pstmt.setInt(6,0);//������
          pstmt.setString(7,null);//������ҵ
          pstmt.setString(8,null);//������ҵ
          tempStr = AnalysisHelper.analysJobLocation(resume);
          pstmt.setInt(9,StringUtil.parseInt(tempStr[0]));//�����ص�1
          pstmt.setInt(10,StringUtil.parseInt(tempStr[1]));//�����ص�2
          pstmt.setInt(11,StringUtil.parseInt(tempStr[2]));//�����ص�3
          tempStr = null;
          
          pstmt.setString(12,AnalysisHelper.analysisSalary(resume));//нˮ
          pstmt.setInt(13,0);//ס��
          pstmt.setInt(14,0);//����ʱ��
          pstmt.setString(15,null);//����ʱ��
          pstmt.setString(16,null);//����Ҫ��
          pstmt.setString(17,inputDate); //����ʱ��
          pstmt.setString(18,inputDate); //�޸�ʱ��
          pstmt.setString(19,null);//����ʱ��
          pstmt.executeUpdate();
          pstmt.close();

      } catch (Exception e) {
          System.out.println("insertUserIntent()�l����" + e.getMessage() + "����");
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

  public void insertUserWork(Connection con1,NingBoResume resume,int userID) {
      PreparedStatement pstmt = null;
      StringBuffer sqlBuffer = new StringBuffer();
      List workList = null;
      try{
    	  workList = AnalysisHelper.getWorkInfo(StringUtil.getNotNullStr(resume.getWorkText()));
		  sqlBuffer.append("INSERT INTO user_work(");
          sqlBuffer.append("userid,begindateyear,begindatemonth,enddateyear,enddatemonth,");
          sqlBuffer.append("comname,comType,comCalling,mainCatalog,jobFunctionId,salary,");
          sqlBuffer.append("flag,otherPosition,description,leftReason,cre_date,rev_date");
          sqlBuffer.append(")VALUES");
          sqlBuffer.append("(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                  
          if(workList != null && workList.size()>0){
    		  for(int i=0;i<workList.size();i++){
    			  String [] info=new String[5];
    			  info=(String[])workList.get(i);
    			  pstmt = con1.prepareStatement(sqlBuffer.toString());
                  pstmt.setInt(1,userID);
                  pstmt.setInt(2,StringUtil.parseInt(AnalysisHelper.getYear(info[0])[0]));//��ʼ��
                  pstmt.setInt(3,StringUtil.parseInt(AnalysisHelper.getMonth(info[0])[0]));//��ʼ��
                  pstmt.setInt(4,StringUtil.parseInt(AnalysisHelper.getYear(info[0])[1]));//������
                  pstmt.setInt(5,StringUtil.parseInt(AnalysisHelper.getMonth(info[0])[1]));//������
                  pstmt.setString(6,StringUtil.getNotNullStr(info[1]));//��˾��
                  pstmt.setInt(7,0);//��˾����
                  pstmt.setInt(8,0);//��ҵ����
                  pstmt.setInt(9,0);//��λ����
                  pstmt.setInt(10,0);//С��
                  pstmt.setString(11,"����");//нˮ
                  pstmt.setInt(12,0);//�Ƿ���ְ
                  pstmt.setString(13,StringUtil.getNotNullStr(info[3]));//����ְλ
                  pstmt.setString(14,StringUtil.getNotNullStr(info[4]));//����
                  pstmt.setString(15,"");//��ְԭ��
                  pstmt.setString(16,inputDate);//��������
                  pstmt.setString(17,inputDate);//����
                  pstmt.executeUpdate();
                  pstmt = null;
                  info = null;
    		  }
    	  }else{
    		  return;
    	  }
      } catch (Exception e) {
          System.out.println("insertUserWork()�l����" + e.getMessage() + "����");
      } finally {
    	  workList = null;
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
  

  public void insertUserSkill(Connection con1,NingBoResume resume,int userID) {
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
          pstmt.setInt(3,0);//�����ˮƽ
          pstmt.setString(4,null);//���������
          pstmt.setInt(5,0);//֤��
          pstmt.setInt(6,StringUtil.parseInt(MapTable.getCodeTwo(StringUtil.getNotNullStr(resume.getLanguageType1()), MapTable.languageType), 1000));//��������1,Ӣ��
          pstmt.setInt(7,MapTable.getLanguageLever(StringUtil.getNotNullStr(resume.getLanguageLever1())));//����ˮƽ1
          pstmt.setInt(8,0);//֤��1Ĭ��Ϊһ��
          pstmt.setInt(9,0);//��������2,Ĭ����������
          pstmt.setInt(10,0);//����ˮƽ2
          pstmt.setInt(11,0);//֤��2
          pstmt.setInt(12,0);//��ͨ��
          pstmt.setInt(13,0);//����
          pstmt.setString(14,null);
          pstmt.setString(15,AnalysisHelper.getOtherSkill(StringUtil.getNotNullStr(resume.getPersonSkill())));//��������
          pstmt.setString(16,inputDate); //����ʱ��
          pstmt.setString(17,inputDate); //�޸�ʱ��
          pstmt.executeUpdate();
          pstmt.close();
      } catch (Exception e) {
          System.out.println("insertUserSkill()�l����" + e.getMessage() + "����");
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

  
  public void insertUserSchool(Connection con1,NingBoResume resume,int userID) {
      PreparedStatement pstmt = null;
      StringBuffer sqlBuffer = new StringBuffer();
      List schoolList =null;
      List trainList = null;
      try {
    	  schoolList = AnalysisHelper.getSchoolInfo(StringUtil.getNotNullStr(resume.getSchoolText()));
    	  trainList = AnalysisHelper.getTrainInfo(StringUtil.getNotNullStr(resume.getCultivateText()));
    	  sqlBuffer.append("INSERT INTO user_school(");
          sqlBuffer.append("userid,degree,begindateyear,begindatemonth,enddateyear,");
          sqlBuffer.append("enddatemonth,school,speciality,certificate,cre_date,rev_date,");
          sqlBuffer.append("course,flag)VALUES");
          sqlBuffer.append("(?,?,?,?,?,?,?,?,?,?,?,?,?)");
          if(schoolList.size()>0 && schoolList!=null){
        	  for(int i=0;i<schoolList.size();i++){
        		  String info[] = new String[4];
        		  info=(String[])schoolList.get(i);
                  pstmt = con1.prepareStatement(sqlBuffer.toString());
                  pstmt.setInt(1,userID); 
                  pstmt.setInt(2,StringUtil.parseInt(MapTable.getCodeTwo(StringUtil.getNotNullStr(info[3]), MapTable.highDegree))); //ѧ��
                  pstmt.setInt(3,StringUtil.parseInt(AnalysisHelper.getYear(info[0])[0]));//��ʼ��
                  pstmt.setInt(4,StringUtil.parseInt(AnalysisHelper.getMonth(info[0])[0]));//��ʼ��
                  pstmt.setInt(5,StringUtil.parseInt(AnalysisHelper.getYear(info[0])[1]));//������
                  pstmt.setInt(6,StringUtil.parseInt(AnalysisHelper.getMonth(info[0])[1]));//������
                  pstmt.setString(7,StringUtil.getNotNullStr(info[1])); //��ҵѧУ
                  pstmt.setString(8,StringUtil.getNotNullStr(info[2])); //רҵ
                  pstmt.setString(9,"");//֤��
                  pstmt.setString(10,inputDate); //����ʱ��
                  pstmt.setString(11,inputDate); //�޸�ʱ��
                  pstmt.setString(12,"");
                  pstmt.setInt(13,0);//�Ƿ��ڶ� 
                  pstmt.executeUpdate();
                  pstmt=null;
                  info=null;
        	  }
          }
    	  if(trainList.size()>0 && trainList!=null){
    		  for(int i=0;i<trainList.size();i++){
        		  String train[] = new String[4];
        		  train=(String[])trainList.get(i);
                  pstmt = con1.prepareStatement(sqlBuffer.toString());
                  pstmt.setInt(1,userID); 
                  pstmt.setInt(2,0); //ѧ��
                  pstmt.setInt(3,StringUtil.parseInt(AnalysisHelper.getYear(train[0])[0]));//��ʼ��
                  pstmt.setInt(4,StringUtil.parseInt(AnalysisHelper.getMonth(train[0])[0]));//��ʼ��
                  pstmt.setInt(5,StringUtil.parseInt(AnalysisHelper.getYear(train[0])[1]));//������
                  pstmt.setInt(6,StringUtil.parseInt(AnalysisHelper.getMonth(train[0])[1]));//������
                  pstmt.setString(7,StringUtil.getNotNullStr(train[1])); //��ѵѧУ
                  pstmt.setString(8,StringUtil.getNotNullStr(train[2])); //רҵ
                  pstmt.setString(9,"");//֤��
                  pstmt.setString(10,inputDate); //����ʱ��
                  pstmt.setString(11,inputDate); //�޸�ʱ��
                  pstmt.setString(12,StringUtil.getNotNullStr(train[3]));
                  pstmt.setInt(13,0);//�Ƿ��ڶ� 
                  pstmt.executeUpdate();
                  pstmt=null;
                  train=null;
        	  }
    	  }
    	  
      } catch (Exception e) {
          System.out.println("insertUserSchool()�l����" + e.getMessage() + "����");
      } finally {
          try {
        	  schoolList = null;
        	  trainList = null;
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
          pstmt.setInt(2,0); //��Ƭ
          pstmt.setString(3,path);
          pstmt.setString(4,inputDate);
          pstmt.setInt(5,0);
          pstmt.setString(6,"");
          pstmt.setInt(7,0); 
          pstmt.executeUpdate();
          pstmt.close();
      } catch (Exception e) {
          System.out.println("insertPhoto()�l����" + e.getMessage() + "����");
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
          System.out.println("updateBaseInfo()�l����" + e.getMessage() + "����");
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
   * 1; //email Ϊ�� or email ���Ϸ� ������
   * 2;//email ����,������
   * 3;//email ������
   * 4;//email ������ �ʺŴ���  ����Ϊemail
   */
  public int checkEmail(String email,Connection con)
  {
	  int flag = 0;
	  if(StringUtil.getNotNullStr(email).equals("") || StringUtil.getNotNullStr(email).indexOf("@")==-1)
	  {
		  flag = 1; //email Ϊ�� or email ���Ϸ� ������
	  }
	  else 
	  {
		  if(isExistEmail(con,email)==1)
		  {
			  flag = 2;//email �����ظ���¼,������
		  }
		  else
		  {
			  flag = 3;//email �������ظ���¼
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
   * 0 ��ʾemail ������
   * 1 ��ʾemail ����
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
   * 0 ��ʾaccount ������
   * 1 ��ʾaccount ����
   */
  private int isExistAccount(Connection con, String account)
  {
	  int  flag = 0;
	  String sql = " select * from user_basicdata where useraccounts='"+account+"'";
	  long count = getResuleCount(con, sql);
	  if(count>0) flag = 1;
	  return flag;
  }
  
  /**���ݳ��Ȼ��һ����ֵ��ɵ��ַ���*/
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
  
  /**��������(����ȫ�����ֻ�����ĸ�������ĺ���)**/
  private boolean checkText(NingBoResume resume){
	  boolean isCheck = false;
	  if(!AnalysisHelper.isCharacter(StringUtil.getNotNullStr(resume.getWorkText())) && 
			  !AnalysisHelper.isChinese(StringUtil.getNotNullStr(resume.getWorkText())) && 
			  !AnalysisHelper.isNumeric(StringUtil.getNotNullStr(resume.getWorkText()))){
		  isCheck = true;
	  }
	  return isCheck;
  }

  private boolean checkSchool(NingBoResume resume){
	  boolean isCheck = false;
	  List schoolList = AnalysisHelper.getSchoolInfo(StringUtil.getNotNullStr(resume.getSchoolText()));
	  if(schoolList!=null && schoolList.size()>0){
		  isCheck = true;
	  }
	  schoolList = null;
	  return isCheck;
  }
  
  /**�õ��ܵļ�¼��**/
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
	/*
	 * �����������������ַ���
	 */
	 private  String getRandomPwd() throws Exception{
		 RandomString test = new RandomString();
		 test.setLength(6);
	     test.setCharset("A-Z0-9");
	     test.generateRandomObject();
	     return test.getRandom();
	}
}
