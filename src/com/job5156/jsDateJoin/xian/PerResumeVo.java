package com.job5156.jsDateJoin.xian;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import com.google.common.collect.Lists;
import com.job5156.util.option.OptionMap;
import com.job5156.util.option.OptionMap.OptionType;

public class PerResumeVo {
	private Integer id;                    //������ϢID
	private Integer accountType;           //�˺�����
	private Integer accountId;             //�����û��˺�ID
	private String resumeName;             //��������
	private Integer resumeType;            //��������:1Ϊ��ɳ���͵ļ���
	private Integer resumeId;              //����ID  ���ļ��� �� Ӣ�ļ����໥��Ӧ
	private String resumeStyle;            //����ģ�壬Ĭ��Ϊdefault
	private Integer languageType;          //��������:0Ϊ���ģ�1ΪӢ��
	private String userLastEditBy;         //�û�����޸���
	private Date userLastEditDate;         //�û�������޸�ʱ��
	private String adminLastEditBy;        //��̨����Ա����޸���
	private Date adminLastEditDate;        //��̨����Ա����޸�ʱ��
	private Date freDate;                  //����ˢ��ʱ��
	private Integer resumeGrade;           //�������ͣ�0-��ͨ,1-��Ӣ(��ͷ) 2-ģ���˲�. 101:�и߼��˲ţ�����ѯ�⣩  105:�и߼��˲�(���ܼ�������ѯ��)
	private Date passDate;                 //���ʱ��
	private Integer comeFrom;              //������Դ
	private Integer havePhoto;             //�Ƿ�����Ƭ��0Ϊ�ޣ�1Ϊ��
	private Integer pass;                  //-10:��ɱʽ���������õ�¼��-9������,-3����˲��ϸ�-1��δ��ͨ��0:δ���ƣ�1����ʱ��ͨ��10���ѿ�ͨ
	private Integer flag;                  //�������ܡ�0:��ȫ������1:��ȫ���ܡ�2:��������ϵ��ʽ����
	private Integer readCount;             //����ҵ�鿴����
	private Integer resFormwork;            //����ģ�壺0-6 Ĭ��Ϊ0
	private Double perfectNum;            //������������
	private Integer perfectInfo;           //�û�������Ϣ��������0:����Ͷ�ݣ�1����Ͷ�ݣ���д���б����
	private Integer age;                   //����
    private Integer displayEnResume;       //�Ƿ���ʾӢ�ļ���(0:Ĭ�ϲ���ʾ,1:��ʾ)
	
         //���ѧ��
	
    private IntentInfoVo intentInfoVo; //��ְ������Ϣ/�ҵ�����/��������
    private List<LanguageInfoVo> languageInfoVoList;             //���Լ�����Ϣ
    private List<CertificateInfoVo> certificateInfoVoList;       //֤����Ϣ | ����Ϣ
    private List<ProjectInfoVo> projectInfoVoList;               //��Ŀ��Ϣ
    private List<AccessoryInfoVo> accessoryInfoVoList;           //������Ϣ
    private EducationInfoVo educationInfoVo; 
              //רҵ����

  

    //=========== SUB CLASS =======================
    /**
     *     ��ְ����
     */
    public static class IntentInfoVo{
        private Long id;               //id���
        private Date creDate;          //����ʱ��
        private Date updDate;          //�޸�ʱ��
        private Integer jobType ;      //��������  1:ȫְ 2:��ְ 3��ʵϰ �μ�: CommonEnum.PositionPropertyType
        private String treatment;      //����
        private Integer salary;        //����нˮ
        private Boolean negotiable;    //������
        private String otherMandate;   //����Ҫ��
        private String jobCode;        //��������ְλ
        private String jobName;        //�Զ���ְλ
        private String jobLocation;    //���������ص�
        private Integer checkindate;   //����ʱ��
        private String keywords;       //�ؼ��� ���ֱ��Ϊ���ҵ�����
        private String professionSkill;//ְҵ���� ���ֱ��Ϊ����������
        private Integer[] jobTypeArr;  //�������Ͷ�ѡʱʹ��


        //=========== SUB CLASS NOT POJO ============
        //����ʱ���Ӧ����
        public String getCheckindateStr() {
            return OptionMap.getValue(OptionType.OPT_PER_ARRIVAL, checkindate);
        }

       //����ְλ���Ͷ�Ӧ����
       public String getJobCodeStr() {
           List<String> jobNameList = Lists.newArrayList();
           if(StringUtils.isNotBlank(jobCode)) {
               for (String code : jobCode.split(",| ")) {
                   String jobCodeStr = OptionMap.getValue(OptionMap.OptionType.OPT_POSITION, NumberUtils.toInt(code, 0));
                   if(!jobNameList.contains(jobCodeStr)) {
                       jobNameList.add(jobCodeStr);
                   }
               }
           }
           return StringUtils.join(jobNameList, ",");
       }
       
       /**
        * ��ȡ�Զ����λ�����б�
        * @return
        */
       public List<String> getJobCustomList(){
    	   return StringUtils.isNotBlank(jobName) ? Lists.newArrayList(jobName.split(",| ")) : null;
       }

       //������λ��Ӧ����
       public String getJobNameStr() {
            List<String> jobNameList = Lists.newArrayList();

            if(StringUtils.isNotBlank(jobCode)) {
                for (String code : jobCode.split(",| ")) {
                    String jobCodeStr = OptionMap.getValue(OptionMap.OptionType.OPT_POSITION, NumberUtils.toInt(code, 0));
                    if(!jobNameList.contains(jobCodeStr)) {
                        jobNameList.add(jobCodeStr);
                    }
                }
            }
            
            if(StringUtils.isNotBlank(jobName)) {
                for (String jobCodeStr : jobName.split(",| ")) {
                    if(!jobNameList.contains(jobCodeStr)) {
                        jobNameList.add(jobCodeStr);
                    }
                }
            }

            return StringUtils.join(jobNameList, ",");
        }

        //������Ӧ����
        public String getSalaryStr() {
            if(salary == null || salary == 0) {
                return "����";
            } else {
                return "(RMB) " +OptionMap.getValue(OptionType.OPT_PER_NOWSALARY, salary);
            }
        }

        //ϣ��������Ӧ����
        public String getJobLocationStr() {
            List<String> jobLocationList = Lists.newArrayList();

            if(StringUtils.isNotBlank(jobLocation)) {
                for (String location : jobLocation.split(",")) {
                    String locationStr = OptionMap.getFullAddr(NumberUtils.toInt(location, 0));
                    if(!jobLocationList.contains(locationStr)) {
                        jobLocationList.add(locationStr);
                    }
                }
            }

            return StringUtils.join(jobLocationList, ",");
        }

        //��������ת��
        public String getJobTypeStr(){
            if(jobType != null ){
                return OptionMap.getValue(OptionType.OPT_JOBTYPE, jobType);
            }
            return "";
        }
        //========= SUB CLASS  getter && setter =================
        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public Date getCreDate() {
            return creDate;
        }
        public void setCreDate(Date creDate) {
            this.creDate = creDate;
        }
        public Date getUpdDate() {
            return updDate;
        }
        public void setUpdDate(Date updDate) {
            this.updDate = updDate;
        }
        public Integer getJobType() {
            return jobType;
        }
        public void setJobType(Integer jobType) {
            this.jobType = jobType;
        }
        public String getKeywords() {
            return keywords;
        }
        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }
        public String getTreatment() {
            return treatment;
        }
        public void setTreatment(String treatment) {
            this.treatment = treatment;
        }
        public Integer getSalary() {
            return salary;
        }
        public void setSalary(Integer salary) {
            this.salary = salary;
        }
        public Boolean getNegotiable() {
            return negotiable;
        }
        public void setNegotiable(Boolean negotiable) {
            this.negotiable = negotiable;
        }
        public String getOtherMandate() {
            return otherMandate;
        }
        public void setOtherMandate(String otherMandate) {
            this.otherMandate = otherMandate;
        }
        public String getJobCode() {
            return jobCode;
        }
        public void setJobCode(String jobCode) {
            this.jobCode = jobCode;
        }
        public String getJobName() {
            return jobName;
        }
        public void setJobName(String jobName) {
            this.jobName = jobName;
        }
        public String getJobLocation() {
            return jobLocation;
        }
        public void setJobLocation(String jobLocation) {
            this.jobLocation = jobLocation;
        }
        public Integer getCheckindate() {
            return checkindate;
        }
        public void setCheckindate(Integer checkindate) {
            this.checkindate = checkindate;
        }
        public String getProfessionSkill() {
            return professionSkill;
        }
        public void setProfessionSkill(String professionSkill) {
            this.professionSkill = professionSkill;
        }
        public Integer[] getJobTypeArr() {
            return jobTypeArr;
        }

        public void setJobTypeArr(Integer[] jobTypeArr) {
            this.jobTypeArr = jobTypeArr;
        }
    }

    /**
     * ����
     */
    public static class LanguageInfoVo{
        private Long id;                   //id���
        private Integer skill;             //�������
        private Integer level;             //����ˮƽ
        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public Integer getSkill() {
            return skill;
        }
        public void setSkill(Integer skill) {
            this.skill = skill;
        }
        public Integer getLevel() {
            return level;
        }
        public void setLevel(Integer level) {
            this.level = level;
        }

        //���Զ�Ӧ����
        public String getSkillStr() {
            return OptionMap.getValue(OptionType.OPT_LANGUAGE, skill);
        }
        public String getLevelStr() {
            return OptionMap.getValue(OptionType.OPT_LANGUAGE, level);
        }
    }

    /**
     * ֤��
     */
    public static class CertificateInfoVo{
        private Long id;                   //id���
        private Date acquireDate;          //���ʱ��
        private String certificateName;    //֤������
        private String grade;              //�ɼ�
        private String certificateFileName;//֤���ļ�����
        private String certificatePath;    //֤��·��
        private Boolean isPrize = false;   //�Ƿ��ǻ�
        //======== not pojo ==================
      
        public Boolean getIsPrize() {
            return isPrize==null?false:isPrize;
        }
        //======== getter && setter ========
        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public Date getAcquireDate() {
            return acquireDate;
        }
        public void setAcquireDate(Date acquireDate) {
            this.acquireDate = acquireDate;
        }
        public String getCertificateName() {
            return certificateName;
        }
        public void setCertificateName(String certificateName) {
            this.certificateName = certificateName;
        }
        public String getGrade() {
            return grade;
        }
        public void setGrade(String grade) {
            this.grade = grade;
        }
        public String getCertificateFileName() {
            return certificateFileName;
        }
        public void setCertificateFileName(String certificateFileName) {
            this.certificateFileName = certificateFileName;
        }
        public String getCertificatePath() {
            return certificatePath;
        }
        public void setCertificatePath(String certificatePath) {
            this.certificatePath = certificatePath;
        }

        public void setIsPrize(Boolean isPrize) {
            this.isPrize = isPrize;
        }
    }

    /**
     * ��Ŀ����
     */
    public static class ProjectInfoVo{
        private Long id;               //id���

        private String begin;         //��ʼ
        private String end;          //����
      
        private String projectName;    //��Ŀ����
        private String proDescribe;
        private String dutyDescribe;   //��Ŀҵ��
        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public String getBegin() {
            return begin;
        }
        public void setBegin(String begin) {
            this.begin = begin;
        }
        public String getEnd() {
            return end;
        }
        public void setEnd(String end) {
            this.end = end;
        }
        public String getProjectName() {
            return projectName;
        }
        public void setProjectName(String projectName) {
            this.projectName = projectName;
        }
        public String getProDescribe() {
            return proDescribe;
        }
        public void setProDescribe(String proDescribe) {
            this.proDescribe = proDescribe;
        }
        public String getDutyDescribe() {
            return dutyDescribe;
        }
        public void setDutyDescribe(String dutyDescribe) {
            this.dutyDescribe = dutyDescribe;
        }
    }

    /**
     * ������Ϣ
     */
    public static class AccessoryInfoVo{
        private Long id;               //id���
        private String uploadName;     //��������
        private String opusPath;       //��Ʒ·��
        private String description;    //��������
        private Date uploadDate;       //�ϴ�ʱ��
       // @NotBlank
        private String uploadPath;     //����·��
       // @NotBlank
        private String fileName;       //�ļ�����
        private Integer show;          //�Ƿ���ʾ�����У�1Ϊ��ʾ��0Ϊ����ʾ

      
        public void setId(Long id) {
            this.id = id;
        }
        public String getUploadName() {
            return uploadName;
        }
        public void setUploadName(String uploadName) {
            this.uploadName = uploadName;
        }
        public String getOpusPath() {
            return opusPath;
        }
        public void setOpusPath(String opusPath) {
            this.opusPath = opusPath;
        }
        public String getUploadPath() {
            return uploadPath;
        }
        public void setUploadPath(String uploadPath) {
            this.uploadPath = uploadPath;
        }
        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }
        public Date getUploadDate() {
            return uploadDate;
        }
        public void setUploadDate(Date uploadDate) {
            this.uploadDate = uploadDate;
        }
        public Integer getShow() {
            return show;
        }
        public void setShow(Integer show) {
            this.show = show;
        }
        public String getFileName() {
            return fileName;
        }
        public void setFileName(String fileName) {
            this.fileName = fileName;
        }
        
    }

    /**
     * ��������
     */
    public static class EducationInfoVo{
        private Long id;                       //id���
        private String begin;         //��ʼ
        private String end;           //����
        private String schoolName;             //ѧУ����
        private String speciality;             //רҵ����
        private Date creDate;                  //����ʱ��
        private Date updDate;                  //�޸�ʱ��
        private String specialityDescription;  //רҵ����
        private Integer degree;                //ѧ��

        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public String getBegin() {
            return begin;
        }
        public void setBegin(String begin) {
            this.begin = begin;
        }
        public String getEnd() {
            return end;
        }
        public void setEnd(String end) {
            this.end = end;
        }
        public String getSchoolName() {
            return schoolName;
        }
        public void setSchoolName(String schoolName) {
            this.schoolName = schoolName;
        }
        public String getSpeciality() {
            return speciality;
        }
        public void setSpeciality(String speciality) {
            this.speciality = speciality;
        }
        public Date getCreDate() {
            return creDate;
        }
        public void setCreDate(Date creDate) {
            this.creDate = creDate;
        }
        public Date getUpdDate() {
            return updDate;
        }
        public void setUpdDate(Date updDate) {
            this.updDate = updDate;
        }
        public String getSpecialityDescription() {
            return specialityDescription;
        }
        public void setSpecialityDescription(String specialityDescription) {
            this.specialityDescription = specialityDescription;
        }
        public Integer getDegree() {
            return degree;
        }
        public void setDegree(Integer degree) {
            this.degree = degree;
        }

        //ѧ����Ӧ����
        public String getDegreeStr() {
            return OptionMap.getValue(OptionType.OPT_PER_DEGREE, degree);
        }
    }

    /**
     * ��ѵ
     */
    public static class TrainInfoVo{
        private Long id;                   //id���
        private String begin;         //��ʼ
        private String end;           //����
        private String trainSchoolName;    //��ѵ��������
        private String trainCourse;        //��ѵ�γ�
        private String certificate;        //֤������
        private Date creDate;              //����ʱ��
        private Date updDate;              //�޸�ʱ��
        private String courseDescription;  //��ѵ�γ�����
        private Integer place;             //��ѵ�ص�

        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public String getBegin() {
            return begin;
        }
        public void setBegin(String begin) {
            this.begin = begin;
        }
        public String getEnd() {
            return end;
        }
        public void setEnd(String end) {
            this.end = end;
        }
        public String getTrainSchoolName() {
            return trainSchoolName;
        }
        public void setTrainSchoolName(String trainSchoolName) {
            this.trainSchoolName = trainSchoolName;
        }
        public String getTrainCourse() {
            return trainCourse;
        }
        public void setTrainCourse(String trainCourse) {
            this.trainCourse = trainCourse;
        }
        public String getCertificate() {
            return certificate;
        }
        public void setCertificate(String certificate) {
            this.certificate = certificate;
        }
        public Date getCreDate() {
            return creDate;
        }
        public void setCreDate(Date creDate) {
            this.creDate = creDate;
        }
        public Date getUpdDate() {
            return updDate;
        }
        public void setUpdDate(Date updDate) {
            this.updDate = updDate;
        }
        public String getCourseDescription() {
            return courseDescription;
        }
        public void setCourseDescription(String courseDescription) {
            this.courseDescription = courseDescription;
        }
        public Integer getPlace() {
            return place;
        }
        public void setPlace(Integer place) {
            this.place = place;
        }

        //��ѵ�ص��Ӧ����
        public String getPlaceStr() {return OptionMap.getFullAddr(place);}
    }

    /**
     * ��������
     */
    public static class WorkInfoVo{
        private Long id;                   //id���
        private String begin;              //��ʼ
        private String end;                //����
        private String comName;            //��˾����
        private Integer comType;           //��˾����
        private Integer comCalling;        //��˾��ҵ
        private String jobName;            //ְλ���ƣ��Զ��壩
        private Integer jobFunctionId;     //ְλId���������
        private String description;        //��������
        private String leftreason;         //��ְԸ��
        private String section;            //��������
        private Integer comScale;           //��ҵ��ģ
        private Date creDate;              //����ʱ��
        private Date updDate;              //�޸�ʱ��
        private Boolean isTrainee = false; //false :�����Ա true��  ��ʵϰ����WorkInfoVoΪʵϰ����)
        private Integer salary;            //н��ˮƽ���ȼ���
        private String boss;               //��˾
        private Integer underlingNum;      //��������
        private String achievement;        //�����ɹ�

        //��ҵ���ʶ�Ӧ����
        public String getComTypeStr() {
            return OptionMap.getValue(OptionType.OPT_COM_PROPERTY, comType);
        }

        //��ҵ��ҵ��Ӧ����
        public String getComCallingStr() {
            return OptionMap.getValue(OptionType.OPT_INDUSTRY, comCalling);
        }

        //��ҵ��ģ��Ӧ����
        public String getComScaleStr() {
            return OptionMap.getValue(OptionType.OPT_COM_EMPLOYEE, comScale);
        }

        //ְλ����
        public String getJobNameStr() {
            if(StringUtils.isNotBlank(jobName)) {
                return jobName;
            } else {
                return OptionMap.getValue(OptionType.OPT_POSITION, jobFunctionId);
            }
        }

        //н���ִ�
        public String getSalaryStr() {
            if(salary == null || salary == 0) {
                return "����";
            } else {
                return OptionMap.getValue(OptionType.OPT_PER_NOWSALARY, salary) + "(RMB/��)";
            }
        }

        public Boolean getIsTrainee() {
            return isTrainee == null?false:isTrainee;
        }

        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public String getBegin() {
            return begin;
        }
        public void setBegin(String begin) {
            this.begin = begin;
        }
        public String getEnd() {
            return end;
        }
        public void setEnd(String end) {
            this.end = end;
        }
        public String getComName() {
            return comName;
        }
        public void setComName(String comName) {
            this.comName = comName;
        }
        public Integer getComType() {
            return comType;
        }
        public void setComType(Integer comType) {
            this.comType = comType;
        }
        public Integer getComCalling() {
            return comCalling;
        }
        public void setComCalling(Integer comCalling) {
            this.comCalling = comCalling;
        }
        public String getJobName() {
            return jobName;
        }
        public void setJobName(String jobName) {
            this.jobName = jobName;
        }
        public Integer getJobFunctionId() {
            return jobFunctionId;
        }
        public void setJobFunctionId(Integer jobFunctionId) {
            this.jobFunctionId = jobFunctionId;
        }
        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }
        public String getLeftreason() {
            return leftreason;
        }
        public void setLeftreason(String leftreason) {
            this.leftreason = leftreason;
        }
        public String getSection() {
            return section;
        }
        public void setSection(String section) {
            this.section = section;
        }
        public Integer getComScale() {
            return comScale;
        }
        public void setComScale(Integer comScale) {
            this.comScale = comScale;
        }
        public Date getCreDate() {
            return creDate;
        }
        public void setCreDate(Date creDate) {
            this.creDate = creDate;
        }
        public Date getUpdDate() {
            return updDate;
        }
        public void setUpdDate(Date updDate) {
            this.updDate = updDate;
        }

        public void setIsTrainee(Boolean isTrainee) {
            this.isTrainee = isTrainee;
        }

        public Integer getSalary() {
            return salary;
        }

        public void setSalary(Integer salary) {
            this.salary = salary;
        }

        public String getBoss() {
            return boss;
        }

        public void setBoss(String boss) {
            this.boss = boss;
        }

        public Integer getUnderlingNum() {
            return underlingNum;
        }

        public void setUnderlingNum(Integer underlingNum) {
            this.underlingNum = underlingNum;
        }

        public String getAchievement() {
            return achievement;
        }

        public void setAchievement(String achievement) {
            this.achievement = achievement;
        }
    }


    /**
     * רҵ����
     */
    public static class SkillVo{

        private Long id;           //���
        private String  name;      //��������
        private Integer level;     //���ճ̶ȣ��ȼ���
        private Integer duration;  //ʹ��ʱ��(�꣩
        private Boolean isTransform ; //�Ƿ���������ݵ�ת��

        public String getLevelStr(){ //���ճ̶ȣ��ȼ����ִ���ʽ
            if (level != null) {
                return OptionMap.getValue(OptionType.OPT_LANGUAGE, level);
            }
            return "";
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getLevel() {
            return level;
        }

        public void setLevel(Integer level) {
            this.level = level;
        }

        public Integer getDuration() {
            return duration;
        }

        public void setDuration(Integer duration) {
            this.duration = duration;
        }

        public Boolean getIsTransform() {
            return isTransform;
        }

        public void setIsTransform(Boolean isTransform) {
            this.isTransform = isTransform;
        }
    }

    /**
     * �������� -- �ҵ�����
     */
    public static class BriefVo {
        private String label; //�ҵ�����
        private String desc;  //����

        public String getLabel() {
            return label;
        }
        public void setLabel(String label) {
            this.label = label;
        }
        public String getDesc() {
            return desc;
        }
        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
    //========================= GETTER && SETTER ===============================



