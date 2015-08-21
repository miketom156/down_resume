package com.job5156.util.option;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class OptionMap {

    public static final String NAME = "name";//中文名称
    public static final String EN = "en";//英文名称
    public static final String ST = "st";//缩写
    public static final String CODE = "code";//代码
    public static final String LAT = "lat";//纬度
    public static final String LNG = "lng";//经度


    public static enum OptionType {
        OPT_PER_MARRIAGE, // 婚姻状态
        OPT_PER_CARDTYPE, // 证件类型
        OPT_PER_JOBSTATUS, // 求职状态
        OPT_PER_NOWSALARY, // 目前月薪
        OPT_PER_POLITIC, // 政治面貌
        OPT_JOBTYPE, // 工作类型
        OPT_PER_ARRIVAL, // 到岗时间
        // OPT_PER_LANGTYPE, //语言类型
        // OPT_PER_LANGLEVEL, //语言水平
        // OPT_PER_NATION, //民族
        OPT_PER_DEGREE, // 学历--个人
        OPT_PER_WORKYEAR, // 工作经验

        OPT_COM_REQ_WORKYEAR, // 企业要求工作经验
        OPT_COM_PROPERTY, // 企业性质
        OPT_COM_FUND, // 注册资金
        OPT_COM_EMPLOYEE, // 员工人数

        OPT_GENDER, // 性别
        OPT_SALARY, // 月薪
        OPT_LANGUAGE, // 月薪
        OPT_INDUSTRY, // 企业行业
        OPT_POSITION // 职位
    }

    @SuppressWarnings("rawtypes")
    private final static Map<OptionType, Map> ALLKEYMAP = Maps.newHashMap();

    private final static Map<Integer, Map<String, String>> OPT_MAP_PER_MARRIAGE = new LinkedHashMap<>();
    private final static Map<Integer, Map<String, String>> OPT_MAP_PER_CARDTYPE = new LinkedHashMap<>();
    private final static Map<Integer, Map<String, String>> OPT_MAP_PER_JOBSTATUS = new LinkedHashMap<>();
    private final static Map<Integer, Map<String, String>> OPT_MAP_PER_NOWSALARY = new LinkedHashMap<>();
    private final static Map<Integer, Map<String, String>> OPT_MAP_PER_POLITIC = new LinkedHashMap<>();
    private final static Map<Integer, Map<String, String>> OPT_MAP_JOBTYPE = new LinkedHashMap<>();
    private final static Map<Integer, Map<String, String>> OPT_MAP_PER_ARRIVAL = new LinkedHashMap<>();
    // private final static Map<Integer, Map<String,String>>
    // OPT_MAP_PER_LANGTYPE = new LinkedHashMap<>();
    // private final static Map<Integer, Map<String,String>>
    // OPT_MAP_PER_LANGLEVEL = new LinkedHashMap<>();
    // private final static Map<Integer, String> OPT_MAP_PER_NATION = new
    // LinkedHashMap<Integer, String>();
    private final static Map<Integer, Map<String, String>> OPT_MAP_PER_DEGREE = new LinkedHashMap<>();
    private final static Map<Integer, Map<String, String>> OPT_MAP_PER_WORKYEAR = new LinkedHashMap<>();
    private final static Map<Integer, Map<String, String>> OPT_MAP_COM_REQ_WORKYEAR = new LinkedHashMap<>();
    private final static Map<Integer, Map<String, String>> OPT_MAP_COM_PROPERTY = new LinkedHashMap<>();
    private final static Map<Integer, Map<String, String>> OPT_MAP_COM_FUND = new LinkedHashMap<>();
    private final static Map<Integer, Map<String, String>> OPT_MAP_COM_EMPLOYEE = new LinkedHashMap<>();

    private final static Map<Integer, Map<String, String>> OPT_MAP_GENDER = new LinkedHashMap<>();
    private final static Map<Integer, Map<String, String>> OPT_MAP_SALARY = new LinkedHashMap<>();
    private final static Map<Integer, Map<String, String>> OPT_MAP_LANGUAGE = new LinkedHashMap<>();
    private final static Map<Integer, Map<String, String>> OPT_MAP_INDUSTRY = new LinkedHashMap<>();
    private final static Map<Integer, Map<String, String>> OPT_MAP_POSITION = OptionPositionMap.OPT_MAP_POSITION;
    
    // 直辖市
    private final static List<Integer> CENTRAL_CITY_LIST = Lists.newArrayList(10000000, 11000000, 12000000, 13000000);
    // 职位薪资映射MAP
    public final static Map<Integer, Object[]> POS_SEARCH_SALARY = Maps.newHashMap();
    
    static {
        // 全部
        ALLKEYMAP.put(OptionType.OPT_PER_MARRIAGE, OPT_MAP_PER_MARRIAGE);
        ALLKEYMAP.put(OptionType.OPT_PER_CARDTYPE, OPT_MAP_PER_CARDTYPE);
        ALLKEYMAP.put(OptionType.OPT_PER_JOBSTATUS, OPT_MAP_PER_JOBSTATUS);
        ALLKEYMAP.put(OptionType.OPT_PER_NOWSALARY, OPT_MAP_PER_NOWSALARY);
        ALLKEYMAP.put(OptionType.OPT_PER_POLITIC, OPT_MAP_PER_POLITIC);
        ALLKEYMAP.put(OptionType.OPT_JOBTYPE, OPT_MAP_JOBTYPE);
        ALLKEYMAP.put(OptionType.OPT_PER_ARRIVAL, OPT_MAP_PER_ARRIVAL);
        // ALLKEYMAP.put(OptionType.OPT_PER_LANGTYPE, OPT_MAP_PER_LANGTYPE);
        // ALLKEYMAP.put(OptionType.OPT_PER_LANGLEVEL, OPT_MAP_PER_LANGLEVEL);
        // ALLKEYMAP.put(OptionType.OPT_PER_NATION, OPT_MAP_PER_NATION);
        ALLKEYMAP.put(OptionType.OPT_PER_DEGREE, OPT_MAP_PER_DEGREE);
        ALLKEYMAP.put(OptionType.OPT_PER_WORKYEAR, OPT_MAP_PER_WORKYEAR);
        ALLKEYMAP.put(OptionType.OPT_COM_REQ_WORKYEAR, OPT_MAP_COM_REQ_WORKYEAR);
        ALLKEYMAP.put(OptionType.OPT_COM_PROPERTY, OPT_MAP_COM_PROPERTY);
        ALLKEYMAP.put(OptionType.OPT_COM_FUND, OPT_MAP_COM_FUND);
        ALLKEYMAP.put(OptionType.OPT_COM_EMPLOYEE, OPT_MAP_COM_EMPLOYEE);

        ALLKEYMAP.put(OptionType.OPT_GENDER, OPT_MAP_GENDER);
        ALLKEYMAP.put(OptionType.OPT_SALARY, OPT_MAP_SALARY);   // 个人期望月薪--职位不要使用 ,只使用到个人期望月薪
        ALLKEYMAP.put(OptionType.OPT_LANGUAGE, OPT_MAP_LANGUAGE);
        ALLKEYMAP.put(OptionType.OPT_INDUSTRY, OPT_MAP_INDUSTRY);
        ALLKEYMAP.put(OptionType.OPT_POSITION, OPT_MAP_POSITION);

        // 婚姻状态
        OPT_MAP_PER_MARRIAGE.put(0, setMap("未婚", "Unmarried","um"));
        OPT_MAP_PER_MARRIAGE.put(1, setMap("已婚", "Married","m"));
        OPT_MAP_PER_MARRIAGE.put(2, setMap("保密", "Secret","s"));
        // 证件类型
        OPT_MAP_PER_CARDTYPE.put(1, setMap("身份证", "ID Card","idcard"));
        OPT_MAP_PER_CARDTYPE.put(2, setMap("军人证", "Officer Card","oficer"));
        OPT_MAP_PER_CARDTYPE.put(3, setMap("驾驶证", "Drive Card","drive"));
        OPT_MAP_PER_CARDTYPE.put(4, setMap("护照", "Passport","passport"));
        OPT_MAP_PER_CARDTYPE.put(5, setMap("其它", "Other","other"));
        // 求职状态
        OPT_MAP_PER_JOBSTATUS.put(0, setMap("目前正在找工作", "I'm looking for jobs now","finding"));
        OPT_MAP_PER_JOBSTATUS.put(1, setMap("半年内无换工作的计划", "I don't want to change job in 6 months","fjob6m"));
        OPT_MAP_PER_JOBSTATUS.put(2, setMap("一年内无换工作的计划", "I don't want to change job in one year","fjob1y"));
        OPT_MAP_PER_JOBSTATUS.put(3, setMap("观望有好的机会再考虑", "Only good opportunities I will consider","thinking"));
        OPT_MAP_PER_JOBSTATUS.put(4, setMap("我暂时不想找工作", "I don't want to look for jobs for the moment","wanot"));
        // 目前月薪
        OPT_MAP_PER_NOWSALARY.put(1, setMap("1500以下", "<1500","<1.5k"));
        OPT_MAP_PER_NOWSALARY.put(2, setMap("1500-1999", "1500-1999","1.5-2k"));
        OPT_MAP_PER_NOWSALARY.put(3, setMap("2000-2999", "2000-2999","2-3k"));
        OPT_MAP_PER_NOWSALARY.put(4, setMap("3000-4499", "3000-4499","3-4k"));
        OPT_MAP_PER_NOWSALARY.put(5, setMap("4500-5999", "4500-5999","4-5k"));
        OPT_MAP_PER_NOWSALARY.put(6, setMap("6000-7999", "6000-7999","6-7k"));
        OPT_MAP_PER_NOWSALARY.put(7, setMap("8000-9999", "8000-9999","8-9k"));
        OPT_MAP_PER_NOWSALARY.put(8, setMap("10000-14999", "10000-14999","10-15k"));
        OPT_MAP_PER_NOWSALARY.put(9, setMap("15000-19999", "15000-19999","15-19k"));
        OPT_MAP_PER_NOWSALARY.put(10, setMap("20000-29999", "20000-29999","20-30k"));
        OPT_MAP_PER_NOWSALARY.put(11, setMap("30000-49999", "30000-49999","30-50k"));
        OPT_MAP_PER_NOWSALARY.put(12, setMap("50000及以上", ">=50000","50k-up"));
        // 政治面貌
        OPT_MAP_PER_POLITIC.put(1, setMap("中共党员", "Party Member","c-party"));
        OPT_MAP_PER_POLITIC.put(2, setMap("团员", "League Member","league"));
        OPT_MAP_PER_POLITIC.put(3, setMap("民主党派", "Democratic Party","d-party"));
        OPT_MAP_PER_POLITIC.put(4, setMap("无党派人士", "No Party","no-party"));
        OPT_MAP_PER_POLITIC.put(5, setMap("群众", "Citizen","citizen"));
        OPT_MAP_PER_POLITIC.put(6, setMap("其他", "Others","others"));
        // 工作类型
        OPT_MAP_JOBTYPE.put(-1, setMap("不限", "ALL","all"));
		OPT_MAP_JOBTYPE.put(1, setMap("全职", "Full-time","f-time"));
		OPT_MAP_JOBTYPE.put(2, setMap("兼职", "Part-time","p-time"));
		OPT_MAP_JOBTYPE.put(3, setMap("实习", "Trainee","trainee"));
		OPT_MAP_JOBTYPE.put(4, setMap("全职/兼职", "Full/Part-time","fp-time"));
		OPT_MAP_JOBTYPE.put(5, setMap("兼职/实习", "Part/Trainee","pt-time"));
        OPT_MAP_JOBTYPE.put(6, setMap("全职/实习", "Full/Trainee","ft-time"));

        // 到岗时间
        OPT_MAP_PER_ARRIVAL.put(1, setMap("随时到岗", "Immediately","any"));
        OPT_MAP_PER_ARRIVAL.put(2, setMap("3天内", "Within 3 days","3day"));
        OPT_MAP_PER_ARRIVAL.put(3, setMap("1周内", "Within 1 week","1week"));
        OPT_MAP_PER_ARRIVAL.put(7, setMap("两周(半个月内)", "Within 1 month","15day"));
        OPT_MAP_PER_ARRIVAL.put(4, setMap("1个月内", "Within 1 month","30day"));
        OPT_MAP_PER_ARRIVAL.put(5, setMap("1—3个月", "From 1 to 3 months","1-3mon"));
        OPT_MAP_PER_ARRIVAL.put(6, setMap("半年内", "Within 6 months","6mon"));
        // 语言类型
        // OPT_MAP_PER_LANGTYPE.put(1, setMap("英语","English"));
        // OPT_MAP_PER_LANGTYPE.put(2, setMap("日语","Japanese"));
        // OPT_MAP_PER_LANGTYPE.put(3, setMap("法语","French"));
        // OPT_MAP_PER_LANGTYPE.put(4, setMap("德语","German"));
        // 语言水平
        // OPT_MAP_PER_LANGLEVEL.put(1, setMap("熟练","Excellent"));
        // OPT_MAP_PER_LANGLEVEL.put(2, setMap("精通","Very Good"));
        // OPT_MAP_PER_LANGLEVEL.put(3, setMap("良好","Good"));
        // OPT_MAP_PER_LANGLEVEL.put(4, setMap("一般","Average"));
        // 语言
        OPT_MAP_LANGUAGE.put(1, setMap("熟练", "skilled","skilled"));
        OPT_MAP_LANGUAGE.put(2, setMap("精通", "Excellent","excellent"));
        OPT_MAP_LANGUAGE.put(3, setMap("良好", "Good","good"));
        OPT_MAP_LANGUAGE.put(4, setMap("一般", "General","general"));
        OPT_MAP_LANGUAGE.put(1000, setMap("英语", "English","english"));
        OPT_MAP_LANGUAGE.put(1001, setMap("大学英语等级考试CET-4", "CET-4","cet4"));
        OPT_MAP_LANGUAGE.put(1002, setMap("大学英语等级考试CET-6", "CET-6","cet6"));
        OPT_MAP_LANGUAGE.put(1003, setMap("英语专业4级", "TEM-4","tem4"));
        OPT_MAP_LANGUAGE.put(1004, setMap("英语专业8级", "TEM-8","tem8"));
        OPT_MAP_LANGUAGE.put(1005, setMap("全国英语等级考试PETS-1初始级", "PETS-1","pest-1"));
        OPT_MAP_LANGUAGE.put(1006, setMap("全国英语等级考试PETS-2中下级", "PETS-2","pest-2"));
        OPT_MAP_LANGUAGE.put(1007, setMap("全国英语等级考试PETS-3中间级", "PETS-3","pest-3"));
        OPT_MAP_LANGUAGE.put(1008, setMap("全国英语等级考试PETS-4中上级", "PETS-4","pest-4"));
        OPT_MAP_LANGUAGE.put(1009, setMap("全国英语等级考试PETS-5最高级", "PETS-5","pest-5"));
        OPT_MAP_LANGUAGE.put(1010, setMap("托福", "TOEFL","teefl"));
        OPT_MAP_LANGUAGE.put(1011, setMap("GRE", "GRE","gre"));
        OPT_MAP_LANGUAGE.put(1012, setMap("GMAT", "GMAT","gmat"));
        OPT_MAP_LANGUAGE.put(1013, setMap("雅思", "IELTS","ielts"));
        OPT_MAP_LANGUAGE.put(1014, setMap("剑桥商务英语证书1级", "BEC-1","bec-1"));
        OPT_MAP_LANGUAGE.put(1015, setMap("剑桥商务英语证书2级", "BEC-2","bec-2"));
        OPT_MAP_LANGUAGE.put(1016, setMap("剑桥商务英语证书3级", "BEC-3","bec-3"));
        OPT_MAP_LANGUAGE.put(1017, setMap("剑桥英语入门考试", "KET","ket"));
        OPT_MAP_LANGUAGE.put(1018, setMap("剑桥初级英语考试", "PET","pet"));
        OPT_MAP_LANGUAGE.put(1019, setMap("剑桥第一英语证书考试", "FCE","fce"));
        OPT_MAP_LANGUAGE.put(1020, setMap("中级口译证书", "Certification of Intermediate Interpreter","coii"));
        OPT_MAP_LANGUAGE.put(1021, setMap("高级口译证书", "Certification of Advanced Interpreter","coai"));

        OPT_MAP_LANGUAGE.put(1100, setMap("日语", "Japanese","japanese"));
        OPT_MAP_LANGUAGE.put(1101, setMap("日语一级证书", "Japanese Test Band 1","jtb-1"));
        OPT_MAP_LANGUAGE.put(1102, setMap("日语二级证书", "Japanese Test Band 2","jtb-2"));
        OPT_MAP_LANGUAGE.put(1103, setMap("日语三级证书", "Japanese Test Band 3","jtb-3"));
        OPT_MAP_LANGUAGE.put(1104, setMap("日语四级证书", "Japanese Test Band 4","jtb-4"));

        OPT_MAP_LANGUAGE.put(1200, setMap("法语", "French","french"));
        OPT_MAP_LANGUAGE.put(1201, setMap("法语四级证书", "CFT4","cft-4"));
        OPT_MAP_LANGUAGE.put(1202, setMap("法语六级证书", "CFT6","cft-6"));

        OPT_MAP_LANGUAGE.put(1300, setMap("德语", "German","german"));
        OPT_MAP_LANGUAGE.put(1301, setMap("德语四级证书", "CGT4","cgt4"));
        OPT_MAP_LANGUAGE.put(1302, setMap("德语六级证书", "CGT6","cgt6"));

        OPT_MAP_LANGUAGE.put(1400, setMap("俄语", "Russian","russian"));
        OPT_MAP_LANGUAGE.put(1401, setMap("俄语四级证书", "CRT4","crt4"));
        OPT_MAP_LANGUAGE.put(1402, setMap("俄语六级证书", "CRT6","crt6"));

        OPT_MAP_LANGUAGE.put(1500, setMap("韩语", "Korean","korean"));
        OPT_MAP_LANGUAGE.put(1600, setMap("西班牙语", "Spanish","spanish"));
        OPT_MAP_LANGUAGE.put(1700, setMap("葡萄牙语", "Portuguese","portuguese"));
        OPT_MAP_LANGUAGE.put(1800, setMap("阿拉伯语", "Arabic","arabic"));
        OPT_MAP_LANGUAGE.put(1900, setMap("意大利语", "Italian","italian"));
        OPT_MAP_LANGUAGE.put(2000, setMap("普通话", "Chinese Mandarin","mandarin"));
        OPT_MAP_LANGUAGE.put(2100, setMap("粤语", "Cantonese","cantonese"));
        OPT_MAP_LANGUAGE.put(2200, setMap("上海话", "Shanghai Dialect","shanghai-dia"));
        OPT_MAP_LANGUAGE.put(2300, setMap("闽南话", "Minnan Dialect","minnan"));
        OPT_MAP_LANGUAGE.put(2400, setMap("其他", "Others","other"));
        // 民族
        // OPT_MAP_PER_NATION.put(0, "未知");
        // 学历-个人
        OPT_MAP_PER_DEGREE.put(1, setMap("初中及以下", "Junior High","junior"));
        OPT_MAP_PER_DEGREE.put(2, setMap("高中", "Senior High","seniro"));
        OPT_MAP_PER_DEGREE.put(3, setMap("中专", "Technical School","technical"));
        OPT_MAP_PER_DEGREE.put(4, setMap("大专", "College","college"));
        OPT_MAP_PER_DEGREE.put(5, setMap("本科", "Bachelor","bachelor"));
        OPT_MAP_PER_DEGREE.put(6, setMap("硕士", "Master","master"));
        OPT_MAP_PER_DEGREE.put(8, setMap("博士", "Doctor","doctor"));
        // 工作经验
        OPT_MAP_PER_WORKYEAR.put(-1, setMap("在读学生", "Student","student"));
        OPT_MAP_PER_WORKYEAR.put(0, setMap("应届生", "Graduates","graduates"));
        OPT_MAP_PER_WORKYEAR.put(1, setMap("1年", "1 year","1y"));
        OPT_MAP_PER_WORKYEAR.put(2, setMap("2年", "2 years","2y"));
        OPT_MAP_PER_WORKYEAR.put(3, setMap("3年", "3 years","3y"));
        OPT_MAP_PER_WORKYEAR.put(4, setMap("4年", "4 years","4y"));
        OPT_MAP_PER_WORKYEAR.put(5, setMap("5年", "5 years","5y"));
        OPT_MAP_PER_WORKYEAR.put(6, setMap("6年", "6 years","6y"));
        OPT_MAP_PER_WORKYEAR.put(7, setMap("7年", "7 years","7y"));
        OPT_MAP_PER_WORKYEAR.put(8, setMap("8年", "8 years","8y"));
        OPT_MAP_PER_WORKYEAR.put(9, setMap("9年", "9 years","9y"));
        OPT_MAP_PER_WORKYEAR.put(10, setMap("10年", "10 years","10y"));
        OPT_MAP_PER_WORKYEAR.put(11, setMap("10年及以上", ">=11 years","10y-up"));
        // 企业要求工作经验
        OPT_MAP_COM_REQ_WORKYEAR.put(-1, setMap("在读学生", "Student","student"));
        OPT_MAP_COM_REQ_WORKYEAR.put(0, setMap("应届生", "Graduates","graduates"));
        OPT_MAP_COM_REQ_WORKYEAR.put(1, setMap("1年", "1 year","1y"));
        OPT_MAP_COM_REQ_WORKYEAR.put(2, setMap("2年", "2 years","2y"));
        OPT_MAP_COM_REQ_WORKYEAR.put(3, setMap("3年", "3 years","3y"));
        OPT_MAP_COM_REQ_WORKYEAR.put(4, setMap("4年", "4 years","4y"));
        OPT_MAP_COM_REQ_WORKYEAR.put(5, setMap("5年", "5 years","5y"));
        OPT_MAP_COM_REQ_WORKYEAR.put(6, setMap("6年", "6 years","6y"));
        OPT_MAP_COM_REQ_WORKYEAR.put(7, setMap("7年", "7 years","7y"));
        OPT_MAP_COM_REQ_WORKYEAR.put(8, setMap("8年", "8 years","8y"));
        OPT_MAP_COM_REQ_WORKYEAR.put(9, setMap("9年", "9 years","9y"));
        OPT_MAP_COM_REQ_WORKYEAR.put(10, setMap("10年", "10 years","10y"));
        OPT_MAP_COM_REQ_WORKYEAR.put(11, setMap("10年及以上", ">=11 years","11y-up"));
        // 企业性质
        OPT_MAP_COM_PROPERTY.put(1, setMap("外资企业", "Foreign Enterprise","foreign"));
        OPT_MAP_COM_PROPERTY.put(2, setMap("中外合营（合资、合作）", "Joint Venture","joint"));
        OPT_MAP_COM_PROPERTY.put(3, setMap("台资企业", "Taiwan-funded Enterprise","taiwan"));
        OPT_MAP_COM_PROPERTY.put(4, setMap("港资企业", "Hong Kong-funded Enterprise","hongkong"));
        OPT_MAP_COM_PROPERTY.put(5, setMap("私营·民营企业", "Private Enterprise·Civil Enterprise",""));
        OPT_MAP_COM_PROPERTY.put(6, setMap("股份制企业", "Stock company","stock"));
        OPT_MAP_COM_PROPERTY.put(7, setMap("跨国公司（集团）", "Multinational Enterprise","group"));
        OPT_MAP_COM_PROPERTY.put(8, setMap("国有企业", "State Owned Enterprise","state"));
        OPT_MAP_COM_PROPERTY.put(9, setMap("事业单位", "Career Office","career"));
        OPT_MAP_COM_PROPERTY.put(10, setMap("社会团体", "Caste","caste"));
        OPT_MAP_COM_PROPERTY.put(11, setMap("政府机关", "Government","gov"));
//        OPT_MAP_COM_PROPERTY.put(12, setMap("日资企业", "Japanese investment enterprise","jie"));
//        OPT_MAP_COM_PROPERTY.put(13, setMap("韩资企业", "Korean investment enterprise","kie"));
//        OPT_MAP_COM_PROPERTY.put(14, setMap("美资企业", "American fund enterprise","afe"));
        OPT_MAP_COM_PROPERTY.put(20, setMap("其他", "Others","other"));
        // 注册资金
        OPT_MAP_COM_FUND.put(0, setMap("50万以下", "Less than 500,000","500k"));
        OPT_MAP_COM_FUND.put(1, setMap("50万-100万", "500,000-1,000,000","500-1000k"));
        OPT_MAP_COM_FUND.put(2, setMap("100万-500万", "1,000,000-5,000,000","1-5m"));
        OPT_MAP_COM_FUND.put(3, setMap("500万-1000万", "5,000,000-10,000,000","5-10m"));
        OPT_MAP_COM_FUND.put(4, setMap("1000万-5000万", "10,000,000-50,000,000","10-50m"));
        OPT_MAP_COM_FUND.put(5, setMap("5000万以上", "50,000,000 or more","50m-up"));
        // 员工人数
        OPT_MAP_COM_EMPLOYEE.put(1, setMap("1-100", "1-100", "1-100"));
        OPT_MAP_COM_EMPLOYEE.put(2, setMap("100-200", "100-200", "100-200"));
        OPT_MAP_COM_EMPLOYEE.put(3, setMap("200-500", "200-500", "200-500"));
        OPT_MAP_COM_EMPLOYEE.put(4, setMap("500-1000", "500-1000", "500-1000"));
        OPT_MAP_COM_EMPLOYEE.put(5, setMap("1000-2000", "1000-2000", "1000-2000"));
        OPT_MAP_COM_EMPLOYEE.put(6, setMap("2000以上", "2000 or more","2000up"));

        // 性别
        OPT_MAP_GENDER.put(0, setMap("未知", "Unknown","un"));
        OPT_MAP_GENDER.put(1, setMap("男", "Male","male"));
        OPT_MAP_GENDER.put(2, setMap("女", "Female","female"));
        // 个人期望月薪--职位不要使用 ,只使用到个人期望月薪
        OPT_MAP_SALARY.put(0, setMap("面议", "Negotiable","nego"));
        OPT_MAP_SALARY.put(1, setMap("1500以下", "<1500","1500"));
        OPT_MAP_SALARY.put(2, setMap("1500-1999", "1500-1999", "1500-1999"));
        OPT_MAP_SALARY.put(3, setMap("2000-2999", "2000-2999", "2000-2999"));
        OPT_MAP_SALARY.put(4, setMap("3000-4499", "3000-4499", "3000-4499"));
        OPT_MAP_SALARY.put(5, setMap("4500-5999", "4500-5999", "4500-5999"));
        OPT_MAP_SALARY.put(6, setMap("6000-7999", "6000-7999", "6000-7999"));
        OPT_MAP_SALARY.put(7, setMap("8000-9999", "8000-9999", "8000-9999"));
        OPT_MAP_SALARY.put(8, setMap("10000-14999", "10000-14999", "10000-14999"));
        OPT_MAP_SALARY.put(9, setMap("15000-19999", "15000-19999", "15000-19999"));
        OPT_MAP_SALARY.put(10, setMap("20000-29999", "20000-29999", "20000-29999"));
        OPT_MAP_SALARY.put(11, setMap("30000-49999", "30000-49999", "30000-49999"));
        OPT_MAP_SALARY.put(12, setMap("50000及以上", ">=50000","50000up"));

        // 行业
        OPT_MAP_INDUSTRY.put(1, setMap("互联网/电子商务", "Internet/E-Commerce","internet"));
        OPT_MAP_INDUSTRY.put(2, setMap("计算软件", "Computers Software","software"));
        OPT_MAP_INDUSTRY.put(3, setMap("计算硬件", "Computers Hardware","hardware"));
        OPT_MAP_INDUSTRY.put(4, setMap("电子/微电子技术/集成电路", "Electrical/Micro-electronics/Integrated circuit","elect"));
        OPT_MAP_INDUSTRY.put(5, setMap("通讯/电信业", "Telecommunications","telec"));
        OPT_MAP_INDUSTRY.put(6, setMap("快速消费品", "Fast consumable","consumable"));
        OPT_MAP_INDUSTRY.put(7, setMap("服装/纺织/皮革", "Dress/Textile/leather","textile"));
        OPT_MAP_INDUSTRY.put(8, setMap("金融业（银行、保险、证券、投资、基金）", "Finance(Banking、Venture Capital、Insurance)","finance"));
        OPT_MAP_INDUSTRY.put(9, setMap("家具/家电/玩具/礼品", "Furniture/Household appliances/Toy/Gift","jiadian"));
        OPT_MAP_INDUSTRY.put(10, setMap("贸易/商务/进出口", "Tading/Commerce/Imports and Exports","trad"));
        OPT_MAP_INDUSTRY.put(11, setMap("生产/制造/加工", "Manufacturing","manufacture"));
        OPT_MAP_INDUSTRY.put(12, setMap("房地产/建筑/建材/工程", "Real estate/Build/Project","building"));
        OPT_MAP_INDUSTRY.put(13, setMap("钢铁/机械/设备/重工", "Iron/Machine-building/Machine/Heavy industry","machine"));
        OPT_MAP_INDUSTRY.put(14, setMap("交通/运输/物流/快递", "Transportation/Distribution","transport"));
        OPT_MAP_INDUSTRY.put(15, setMap("广告/创意/设计", "Advertising/create/Design","adv"));
        OPT_MAP_INDUSTRY.put(16, setMap("批发/零售（超市、百货、商场、专卖店）", "Sales","sales"));
        OPT_MAP_INDUSTRY.put(17, setMap("汽车/摩托车及零配件", "Automobile/Autocycle installation","auto"));
        OPT_MAP_INDUSTRY.put(18, setMap("仪器仪表/电工设备/工业自动化", "Apparatus/Electric devices/Industrialc","apparatus"));
        OPT_MAP_INDUSTRY.put(19, setMap("制药/生物工程", "Biology engineering/Pharmacy","biology"));
        OPT_MAP_INDUSTRY.put(20, setMap("餐饮/酒店/旅游", "Tourism/Catering/Entertainment/Hotels","tourism"));
        OPT_MAP_INDUSTRY.put(21, setMap("橡胶/塑胶/五金", "Rubber/Plastic/Hardware","plastic"));
        OPT_MAP_INDUSTRY.put(22, setMap("印刷/包装/造纸", "Press/Casing/Paper making","paper"));
        OPT_MAP_INDUSTRY.put(23, setMap("电力/电气/水利", "Electric Power/Electrical/Water conservancy","energy"));
        OPT_MAP_INDUSTRY.put(24, setMap("石油/化工/地质", "Petroleum/Chemical engineering/ geology","oil"));
        OPT_MAP_INDUSTRY.put(25, setMap("办公设备/文体休闲用品/家居用品", "OA devices/Culture Articles/Home articles","office"));
        OPT_MAP_INDUSTRY.put(26, setMap("法律/法务", "Law","law"));
        OPT_MAP_INDUSTRY.put(27, setMap("媒体/出版/影视/文化传播", "Media/Publishin/Movie facture/Culture transmit","movie"));
        OPT_MAP_INDUSTRY.put(28, setMap("艺术/文体", "Arts/recreation and sports","culture"));
        OPT_MAP_INDUSTRY.put(29, setMap("娱乐/体育/休闲", "Entertainment/Sports/Leisure","leisure"));
        OPT_MAP_INDUSTRY.put(30, setMap("教育/培训/科研院所", "Education/Training/Research","edu"));
        OPT_MAP_INDUSTRY.put(31, setMap("咨询与调查业（顾问/企业管理/知识产权）", "Consultation(Consultant/Business management/ Intellectual property rights)","advisory"));
        OPT_MAP_INDUSTRY.put(32, setMap("医疗/护理/美容/保健/卫生服务", "Medical Treatment/nurse/Cosmetology Health/Sanitation","medical"));
        OPT_MAP_INDUSTRY.put(33, setMap("人才交流/中介服务", "Human Resources","hr"));
        OPT_MAP_INDUSTRY.put(34, setMap("政府/公用事业/社区服务", "Government/Public service/Community service ","gov"));
        OPT_MAP_INDUSTRY.put(35, setMap("农、林、牧、副、渔业", "Agriculture/Forestry/Animal husbandry/Fishery","nlmfr"));
        OPT_MAP_INDUSTRY.put(36, setMap("协会/社团/非营利机构", "Community/Social services/Government/Nonprofit","social"));
        OPT_MAP_INDUSTRY.put(37, setMap("其他", "Other","other"));
        OPT_MAP_INDUSTRY.put(38, setMap("IT服务（系统/数据/维护）", "IT service(system, data, Maintain)","it-service"));
        OPT_MAP_INDUSTRY.put(39, setMap("网络游戏", "Online games","online-games"));
        OPT_MAP_INDUSTRY.put(40, setMap("珠宝/首饰/钟表", "Jewels/ewelry/Clocks","jewels"));
        OPT_MAP_INDUSTRY.put(41, setMap("会计/审计", "Accountant/Audit","accountant"));
        OPT_MAP_INDUSTRY.put(42, setMap("信托/担保/拍卖/典当", "Trust/Assure/Auction/Pawn","trust"));
        OPT_MAP_INDUSTRY.put(43, setMap("奢侈品/收藏品/工艺品", "Luxury/Collection/Craftware  ","luxury"));
        OPT_MAP_INDUSTRY.put(44, setMap("物业管理/商业中心", "Property management/Commercial centre","property-management"));
        OPT_MAP_INDUSTRY.put(45, setMap("外包服务", "Outsourcing service","outsourcing"));
        OPT_MAP_INDUSTRY.put(46, setMap("人力资源服务", "Human resource service","human"));
        OPT_MAP_INDUSTRY.put(47, setMap("检测/认证", "Testing/Authentication","testing"));
        OPT_MAP_INDUSTRY.put(48, setMap("租赁服务", "Rental service","rental"));
//        OPT_MAP_INDUSTRY.put(49, setMap("医药/生物工程", "Medicine/Bioengineering","medicine"));
        OPT_MAP_INDUSTRY.put(50, setMap("环保", "Environmental protection","environmental"));
        OPT_MAP_INDUSTRY.put(51, setMap("航天/航空", "Space flight/Aviation","space-flight"));
        OPT_MAP_INDUSTRY.put(52, setMap("多元化业务集团", "Diversified business group","diversified"));
        OPT_MAP_INDUSTRY.put(53, setMap("家居/室内设计/装潢", "Home Furnishing/Interior design/Decoration","interior-design"));
        OPT_MAP_INDUSTRY.put(54, setMap("公关/市场推广/会展", "Public relations/Market promotion/Exhibition","public-relations"));
        OPT_MAP_INDUSTRY.put(55, setMap("能源/矿产/采掘/冶炼", "Energy/Mineral products/Mining/Smelting","energy"));
        
        // 职位薪资MAP，主要用于职位薪资分类统计
		POS_SEARCH_SALARY.put(1, new Object[]{0, 1499, "1500以下"});
		POS_SEARCH_SALARY.put(2, new Object[]{1500, 1999, "1500-1999"});
		POS_SEARCH_SALARY.put(3, new Object[]{2000, 2999, "2000-2999"});
		POS_SEARCH_SALARY.put(4, new Object[]{3000, 4499, "3000-4499"});
		POS_SEARCH_SALARY.put(5, new Object[]{4500, 5999, "4500-5999"});
		POS_SEARCH_SALARY.put(6, new Object[]{6000, 7999, "6000-7999"});
		POS_SEARCH_SALARY.put(7, new Object[]{8000, 9999, "8000-9999"});
		POS_SEARCH_SALARY.put(8, new Object[]{10000, 14999, "10000-14999"});
		POS_SEARCH_SALARY.put(9, new Object[]{15000, 19999, "15000-19999"});
		POS_SEARCH_SALARY.put(10, new Object[]{20000, 29999, "20000-29999"});
		POS_SEARCH_SALARY.put(11, new Object[]{30000, 49999, "30000-49999"});
		POS_SEARCH_SALARY.put(12, new Object[]{50000, 100000, "50000及以上"});
    }

    public static Map<String, String> setMap(final String name, final String en,final String st) {
        return ImmutableMap.of(OptionMap.NAME, name, OptionMap.EN, en,OptionMap.ST,st);
    }

    public static String getValue(OptionType optionType, Integer key) {
        return getValueByType(optionType, key, null);
    }


    /**
     * 根据传入的数字代号和类型返回对应的字符串
     *
     * @param optionType 类型, 如性别是 OptionType.OPT_GENDER
     * @param key        要查询的数字代号, 如查询性别类别1代表什么则传入 1
     * @param type       要获取内容类型，某些字段有英文的则传入en，否则传null或空则返回默认为name的值
     * @return 返回对应的字符串, 对于上述例子返回的内容是 "未知"
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static String getValueByType(OptionType optionType, Integer key, String type) {
        Map map = ALLKEYMAP.get(optionType);
        if (map.containsKey(key)) {
            Object mapValue = map.get(key);
            if (mapValue instanceof String) {
                return (String) mapValue;
            } else if (mapValue instanceof Map) {
                if (StringUtils.isNotBlank(type)) {
                    return ((Map<String, String>) mapValue).get(type);
                } else {
                    return ((Map<String, String>) mapValue).get("name");
                }
            }
        }
        return "";
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static Integer getKeyByValueAndType(OptionType optionType,String value,String type) {
        Map map = OPT_MAP_POSITION;
        for (Object obj : map.keySet()) {
            Integer key = (Integer) obj;
            Map<String, String> valueMap = (Map<String, String>) map.get(key);
            if (StringUtils.equals(value, valueMap.get(type))) {
                return key;
            }
        }
        return null;
    }


    @SuppressWarnings({"rawtypes", "unchecked"})
    public static Integer getKeyByValue(OptionType optionType, String value) {
        Map map = ALLKEYMAP.get(optionType);
        for (Object obj : map.keySet()) {
            Integer key = (Integer) obj;
            Map<String, String> valueMap = (Map<String, String>) map.get(key);
            if (StringUtils.equals(value, valueMap.get("name"))) {
                return key;
            }
        }
        return null;
    }

    /**
     * <p>
     * 返回完整的城市镇区地址，默认取中文地址。例：广东东莞莞城区
     * </p>
     *
     * @param key
     *            地区编码
     * @return
     */
    public static String getFullAddr(Integer key) {
        return getFullAddr(key, null);
    }

    /**
     * <p>
     * 返回完整的城市镇区地址
     * </p>
     *
     * @param key
     *            地区编码
     * @param type
     *            显示类型：name-中文地址,en-英文地址
     * @return
     */
    public static String getFullAddr(Integer key, String type) {
        return getProvStr(key, type) + getCityStr(key, type, false) + getTownStr(key, type);
    }

    public static String getProvAddr(Integer key) {
        return getProvStr(key, null);
    }

    /**
     * 取得城市+镇区组成的字串 : 东莞南城区
     * @param key  地区代码
     * @return
     */
    public static String getCityAndTownStr(Integer key) {
        if(key == null || key < 0){
            return "";
        }
        return getCityAddr(key) + getTownAddr(key);
    }

	/**
     * <p>
     * 返回所在城市地址，默认取中文地址 。例：东莞<br>
     * 说明：<br>
     * 如果当前key是省编码，则返回省<br>
     * 如果当前key是市编码，则返回市<br>
     * </p>
     *
     * @param key
     *            地区编码
     * @return
     */
    public static String getCityAddr(Integer key) {
        return getCityAddr(key, null);
    }

    /**
     * <p>
     * 返回所在城市地址<br>
     * 说明：<br>
     * 如果当前key是省编码，则返回省<br>
     * 如果当前key是市编码，则返回市<br>
     * </p>
     *
     * @param key
     *            地区编码
     * @param type
     *            显示类型：name-中文地址,en-英文地址
     * @return
     */
    public static String getCityAddr(Integer key, String type) {
        return getCityStr(key, type, true);
    }

    /**
     * <p>
     * 返回镇区地址，默认取中文地址。例：莞城区
     * </p>
     *
     * @param key
     *            地区编码
     * @return
     */
    public static String getTownAddr(Integer key) {
        return getTownAddr(key, null);
    }

    /**
     * <p>
     * 返回镇区地址
     * </p>
     *
     * @param key
     *            地区编码
     * @param type
     *            显示类型：name-中文地址,en-英文地址
     * @return
     */
    public static String getTownAddr(Integer key, String type) {
        return getTownStr(key, type);
    }

    /**
     * <p>
     * 返回地区编码映射地址，默认取中文地址<br>
     * 例如：14000000-广东，14010000-东莞 <br>
     * </p>
     *
     * @param key
     *            地区编码
     * @return
     */
    public static String getAddrWithCityCode(Integer key) {
        return getAddrWithCityCode(key, null);
    }

    /**
     * <p>
     * 返回地区编码映射地址<br>
     * <p>
     *
     * @param key
     *            地区编码
     * @param type
     *            显示类型：name-中文地址,en-英文地址
     * @return
     */
    public static String getAddrWithCityCode(Integer key, String type) {
        if (key != null && ObjectUtils.toString(key, "").length() >= 4) {
            Map<Integer, Map<String, String>> cityMap = OptionCityMap.OPT_MAP_CITY;
            Integer cityCode = formatCityCode(getCityCodeBits(String.valueOf(key)));
            Map<String, String> cityDataMap = cityMap.get(cityCode);
            if (cityDataMap != null) {
                return cityDataMap.get(StringUtils.defaultIfBlank(type, "name"));
            } else {
                Map<Integer, Map<String, String>> townMap = OptionTownMap.OPT_MAP_TOWN;
                Map<String, String> townDataMap = townMap.get(cityCode);
                if (townDataMap != null) {
                    return townDataMap.get(StringUtils.defaultIfBlank(type, "name"));
                }
            }
        }
        return "";
    }

    /**
     * <p>
     * 根据地址字符串返回城市编码，默认精确到镇区<br>
     * 例:广东省东莞市南城区，返回14010300<br>
     * </p>
     *
     * @param addr
     *            地址字符串
     * @return
     */
    public static Integer getCityCodeByAddr(String addr) {
        return getCityCodeByAddr(addr, AreaType.TOWN);
    }

    /**
     * <p>
     * 根据地址字符串返回城市编码
     * </p>
     *
     * @param addr
     *            地址字符串
     * @param areaType
     *            返回编码精度
     * @return
     */
    public static Integer getCityCodeByAddr(String addr, AreaType areaType) {
        List<Integer[]> matchedList = Lists.newArrayList();
        Integer cityCode = getCityCodeByAddr(addr, null, null);
        while (cityCode > 0) {
            Integer[] matchedCodeArr = getMatchedCityCode(cityCode, addr);
            if (areaType.equals(AreaType.TOWN) && matchedCodeArr[2] > 0) {
                return matchedCodeArr[2];
            }
            if (areaType.equals(AreaType.CITY) && matchedCodeArr[1] > 0) {
                return matchedCodeArr[1];
            }
            matchedList.add(matchedCodeArr);
            cityCode = getCityCodeByAddr(addr, cityCode + 1, null);
        }

        for (Integer[] matchedCodeArr : matchedList) {
            if (matchedCodeArr[1] > 0) {
                return matchedCodeArr[1];
            }
        }

        return CollectionUtils.isNotEmpty(matchedList) ? matchedList.get(0)[0] : 0;
    }

    /**
     * <p>
     * 根据城市名称返回完全匹配城市编码<br>
     * 例：东莞，返回14010000<br>
     * </p>
     *
     * @param value
     *            城市名称
     * @return
     */
    public static Integer getCityCodeByValue(String value) {
        if (StringUtils.isNotBlank(value)) {
            Map<Integer, Map<String, String>> cityMap = OptionCityMap.OPT_MAP_CITY;
            for (Map.Entry<Integer, Map<String, String>> entry : cityMap.entrySet()) {
                Integer code = entry.getKey();
                Map<String, String> cityDataMap = entry.getValue();
                if (StringUtils.equals(value, cityDataMap.get("name"))) {
                    return code;
                }
            }
        }
        return 0;
    }

    /**
     * 从城市值及类别取得城市代码
     * 例如: 输入：dongguan，en -> 14010000
     * @param value
     * @param type
     * @return
     */
    public static Integer getCityCodeByValue(String value,String type) {
        if (StringUtils.isNotBlank(value)) {
            Map<Integer, Map<String, String>> cityMap = OptionCityMap.OPT_MAP_CITY;
            for (Map.Entry<Integer, Map<String, String>> entry : cityMap.entrySet()) {
                Integer code = entry.getKey();
                Map<String, String> cityDataMap = entry.getValue();
                if (StringUtils.equals(value, cityDataMap.get(type))) {
                    return code;
                }
            }
        }
        return 0;
    }

    /**
     * 输入城市拼音得到城市中文名称
     * @param cityName
     * @return
     */
    public static String getCityStrByEnName(String cityName) {
        if (StringUtils.isNotBlank(cityName)) {
            Integer cityCode = getCityCodeByValue(cityName, "en");
            return getCityStr(cityCode, "name", true);
        }
        return "";
    }

    /**
     * 输入城市拼音+镇区拼音,得到地址
     * @param cityName
     * @return
     */
    public static String getTownStrByEnName(String cityName,String townName) {
        if (StringUtils.isNotBlank(cityName) &&  StringUtils.isNotBlank(townName)) {
            Integer cityCode = getCityCodeByValue(cityName, "en");
            Integer townCode = getTownCodeByCityCodeAndTownEn(cityCode, townName);
            return getTownStr(townCode, "name");
        }
        return "";
    }


    /**
     * 从城市代码 + 镇区拼音,取得镇区的代码
     * 东莞:1401 莞城区:guancheng
     * 例如: 输入：1401，guanchen -> 14010100
     * @param cityCode
     * @param townEnName
     * @return
     */
    public static Integer getTownCodeByCityCodeAndTownEn(Integer cityCode,String townEnName) {
        Integer townCode = 0;
        if (cityCode == null || StringUtils.isBlank(townEnName)) {
            return townCode;
        }
        cityCode = NumberUtils.toInt(OptionMap.getCityCodeBits(cityCode));
        List<Map<String,String>> townList = OptionTownMap.OPT_MAP_CITY_TWON.get(cityCode);
        if (CollectionUtils.isNotEmpty(townList)) {
            for (Map<String, String> map : townList) {
                if (StringUtils.equalsIgnoreCase(map.get("en"), townEnName)) {
                    townCode = NumberUtils.toInt(String.valueOf(map.get("code")));
                    break;
                }
            }
        }
        return townCode;
    }

    /**
     * <p>
     * 格式化城市编码，如果编码数据异常则返回默认编码0<br>
     * 兼容旧版4位编码，全部升级到8位编码<br>
     * </p>
     *
     * @param key
     *            地区编码
     * @return
     */
    public static Integer formatCityCode(Object key) {
        return formatCityCode(key, 0);
    }

    /**
     * <p>
     * 格式化城市编码<br>
     * 兼容旧版4位编码，全部升级到8位编码<br>
     * </p>
     *
     * @param key
     *            地区编码
     * @param defaultCode
     *            默认编码
     * @return
     */
    public static Integer formatCityCode(Object key, Integer defaultCode) {
        return NumberUtils.toInt(ObjectUtils.toString(key), 0) > 0 ? NumberUtils.toInt(StringUtils.rightPad(
                ObjectUtils.toString(key), 8, "0")) : defaultCode;
    }

    /**
     * <p>
     * 获取2位省份编码<br>
     * 例：14010000，从左边取2位编码，返回14<br>
     * </p>
     *
     * @param key
     *            地区编码
     * @return
     */
    public static String getProvCodeBits(Object key) {
        return StringUtils.length(ObjectUtils.toString(key)) >= 4 ? StringUtils.substring(ObjectUtils.toString(key), 0,
                2) : StringUtils.EMPTY;
    }

    /**
     * <p>
     * 获取4位城市编码<br>
     * 例：14010000，从左边取4位编码，返回1401<br>
     * </p>
     *
     * @param key
     *            地区编码
     * @return
     */
    public static String getCityCodeBits(Object key) {
        return StringUtils.length(ObjectUtils.toString(key)) >= 4 ? StringUtils.substring(ObjectUtils.toString(key), 0,
                4) : StringUtils.EMPTY;
    }

    /**
     * <p>
     * 判断是否直辖市<br>
     * 例：10000000，返回true<br>
     * </p>
     *
     * @param key
     *            地区编码
     * @return true-是 false-否
     */
    public static boolean isCentralCity(Integer key) {
        return CENTRAL_CITY_LIST.contains(formatCityCode(key));
    }

    /**
     * <p>
     * 判断是否直辖市，完全匹配城市名称<br>
     * 例：上海，返回true<br>
     * </p>
     *
     * @param city
     *            城市名称
     *
     * @return
     */
    public static boolean isCentralCity(String city) {
        if (StringUtils.isNotBlank(city)) {
            for (Integer key : CENTRAL_CITY_LIST) {
                if (city.equals(getCityAddr(key))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 返回指定类型的MAP数据
     *
     * @param optionType
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Map<Integer, String> getMap(OptionType optionType) {
        return ALLKEYMAP.get(optionType);
    }
    
    /**
     * 返回指定类型的MAP数据
     *
     * @param optionType
     * @return
     */
    @SuppressWarnings("unchecked")
    public static String getMap(OptionType optionType,Integer industryId,String key) {
    	Map<String,String> param = (Map<String,String>)ALLKEYMAP.get(optionType).get(industryId);
        return param.get(key);
    }

    /**
     * 根据地址字符串找到一个匹配的地区编码
     *
     * @param key
     *            地区编码
     * @param addr
     *            地址字符串
     * @return 返回一维数组，[0]=省编码,[1]=市编码,[2]=镇区编码
     */
    private static Integer[] getMatchedCityCode(Integer key, String addr) {
        Integer[] cityCodeArr = new Integer[]{0, 0, 0};
        if (StringUtils.substring(String.valueOf(key), 2, 4).equals("00")) {
            cityCodeArr[0] = key;
            // 直辖市
            if (CENTRAL_CITY_LIST.contains(key)) {
                cityCodeArr[1] = key;
            } else {
                addr = StringUtils.replaceOnce(addr, getCityAddr(key), "");
                Integer rangeLeft = formatCityCode(key / 1000000) + 1;
                Integer rangeRight = formatCityCode(key / 1000000) + 999999;
                cityCodeArr[1] = getCityCodeByAddr(addr, rangeLeft, rangeRight);
            }
        } else {
            cityCodeArr[0] = formatCityCode(key / 1000000);
            cityCodeArr[1] = key;
        }
        if (cityCodeArr[1] > 0) {
            addr = StringUtils.replaceOnce(addr, getCityAddr(cityCodeArr[1]), "");
            Integer rangeLeft = formatCityCode(cityCodeArr[1] / 10000) + 1;
            Integer rangeRight = formatCityCode(cityCodeArr[1] / 10000) + 9999;
            cityCodeArr[2] = getTownCodeByAddr(addr, rangeLeft, rangeRight);
        }
        return cityCodeArr;
    }

    /**
     * 返回预定范围内匹配的镇区编码
     *
     * @param addr
     *            地址字符串
     * @param rangeLeft
     *            范围下边界
     * @param rangeRight
     *            范围上边界
     * @return
     */
    private static Integer getTownCodeByAddr(String addr, Integer rangeLeft, Integer rangeRight) {
        if (StringUtils.isNotBlank(addr)) {
            Map<Integer, Map<String, String>> townMap = OptionTownMap.OPT_MAP_TOWN;
            for (Map.Entry<Integer, Map<String, String>> entry : townMap.entrySet()) {
                Integer code = entry.getKey();
                Map<String, String> townDataMap = entry.getValue();

                if (NumberUtils.toInt(String.valueOf(rangeLeft), 0) > 0 && code < rangeLeft) {
                    continue;
                }
                if (NumberUtils.toInt(String.valueOf(rangeRight), 0) > 0 && code > rangeRight) {
                    continue;
                }
                if (StringUtils.contains(addr, townDataMap.get("name"))) {
                    return code;
                }
            }
        }
        return 0;
    }

    /**
     * 返回预定范围内匹配的城市编码
     *
     * @param addr
     *            地址字符串
     * @param rangeLeft
     *            范围下边界
     * @param rangeRight
     *            范围上边界
     * @return
     */
    private static Integer getCityCodeByAddr(String addr, Integer rangeLeft, Integer rangeRight) {
        if (StringUtils.isNotBlank(addr)) {
            Map<Integer, Map<String, String>> cityMap = OptionCityMap.OPT_MAP_CITY;
            for (Map.Entry<Integer, Map<String, String>> entry : cityMap.entrySet()) {
                Integer code = entry.getKey();
                Map<String, String> cityDataMap = entry.getValue();
                if (NumberUtils.toInt(String.valueOf(rangeLeft), 0) > 0 && code < rangeLeft) {
                    continue;
                }
                if (NumberUtils.toInt(String.valueOf(rangeRight), 0) > 0 && code > rangeRight) {
                    continue;
                }
                if (StringUtils.contains(addr, cityDataMap.get("name"))) {
                    return code;
                }
            }
        }
        return 0;
    }

    /**
     * 获取省/直辖市
     *
     * @param key
     *            地区编码
     * @param type
     *            显示类型：name-中文地址,en-英文地址
     * @return
     */
    private static String getProvStr(Integer key, String type) {
        Map<Integer, Map<String, String>> cityMap = OptionCityMap.OPT_MAP_CITY;
        if (key != null && ObjectUtils.toString(key, "").length() >= 4) {
            Integer cityCode = formatCityCode(getProvCodeBits(String.valueOf(key)));
            Map<String, String> cityDataMap = cityMap.get(cityCode);
            return cityDataMap != null ? cityDataMap.get(StringUtils.defaultIfBlank(type, "name")) : "";
        }
        return "";
    }

    /**
     * 获取市区
     *
     * @param key
     *            地区编码
     * @param type
     *            显示类型：name-中文地址,en-英文地址
     * @param ignoreFlag
     *            是否显示省/直辖市编码：true-显示,false-不显示
     * @return
     */
    private static String getCityStr(Integer key, String type, boolean ignoreFlag) {
        Map<Integer, Map<String, String>> cityMap = OptionCityMap.OPT_MAP_CITY;
        if (key != null && ObjectUtils.toString(key, "").length() >= 4) {
            Integer cityCode = formatCityCode(getCityCodeBits(String.valueOf(key)));
            if (ignoreFlag || (!CENTRAL_CITY_LIST.contains(cityCode) && (cityCode / 10000 % 100 > 0))) {
                Map<String, String> cityDataMap = cityMap.get(cityCode);
                return cityDataMap != null ? cityDataMap.get(StringUtils.defaultIfBlank(type, "name")) : "";
            }
        }
        return "";
    }
    

    /**
     * 获取镇区
     *
     * @param key
     *            地区编码
     * @param type
     *            显示类型：name-中文地址,en-英文地址
     * @return
     */
    public static String getTownStr(Integer key, String type) {
        Map<Integer, Map<String, String>> townMap = OptionTownMap.OPT_MAP_TOWN;
        if (key != null && ObjectUtils.toString(key, "").length() == 8) {
            if (key / 100 % 100 > 0) {
                Map<String, String> townDataMap = townMap.get(key);
                return townDataMap != null ? townDataMap.get(StringUtils.defaultIfBlank(type, "name")) : "";
            }
        }
        return "";
    }

    /**
     * townListByAddcode("10010","10020")
     * @param codeStr
     * @return
     */
    public static List<Map<String, String>> townListByAddcode(Integer[] codeStr) {

        List<Map<String, String>> townList = Lists.newArrayList();
        for (Integer s : codeStr) {
            Map<String, String> townMap = new HashMap<String, String>();
            String townName = null;
            if (OptionCityMap.isTown(s)) {
                townName = getTownStr(s, "name");
            } else {
                townName = getCityStr(s, "name", true);
            }
            if (StringUtils.isNotEmpty(townName)) {
                if (StringUtils.length(townName) > 2 && !townName.contains("市区") && !townName.contains("镇镇")) {
                    townName = StringUtils.replace(townName, "区", "");
                    townName = StringUtils.replace(townName, "县", "");
                    townName = StringUtils.replace(townName, "镇", "");
                    townName = StringUtils.replace(townName, "市", "");
                }
                townMap.put("id", String.valueOf(s));
                townMap.put("name", townName);
                townList.add(townMap);
            }
        }

        return townList;
    }

    /**
     * 工作类型转换
     * 单项-->多项数组 格式
     */
    public static Integer[] getJobTypeArr(Integer jobType) {
        if (jobType == null) {
            jobType = -1;
        }
        Integer[] jobTypeArr = new Integer[]{jobType};
        if (jobType == -1) { //不限
            jobTypeArr = new Integer[]{1, 2, 3};
        }
        if (jobType == 4) { // 全|兼职
            jobTypeArr = new Integer[]{1, 2};
        }
        if (jobType == 5) {   //兼职+实习
            jobTypeArr = new Integer[]{2, 3};
        }
        if (jobType == 6) {   //全职+实习
            jobTypeArr = new Integer[]{1, 3};
        }
        return jobTypeArr;
    }

    /**
     * 把多选的工作状态转换为单选 , OPT_MAP_JOBTYPE
     * 多项数组格式 -- > 单选值
     * @param jobTypeArr
     * @return
     */
    public static Integer getJobTypeForArr(Integer[] jobTypeArr) {
        if(ArrayUtils.isEmpty(jobTypeArr)){ //未选择，默认为全职
            return 1;
        }
        List<Integer> jobTypeList = Arrays.asList(jobTypeArr);
        if (jobTypeList.contains(1) && jobTypeList.contains(2) && jobTypeList.contains(3)) {  //不限
            return -1;
        }
        if (jobTypeList.contains(1) && jobTypeList.contains(2)) { // 全|兼职
            return 4;
        }
        if (jobTypeList.contains(2) && jobTypeList.contains(3)) {//兼职+实习
            return 5;
        }
        if (jobTypeList.contains(1) && jobTypeList.contains(3)) {//全职+实习
            return 6;
        }
        return jobTypeArr[0];
    }
    /**
     * 薪资转换为描述
     * @param minSalary  最高薪资
     * @param maxSalary  最低薪资
     * @param negotiableFlag 是否显示为面议  1:显示为面议 否则不显示面议
     * @return
     */
    public static String getSalaryStr(Integer salary, Integer minSalary, Integer maxSalary, Integer negotiableFlag){
    	if(negotiableFlag != null && negotiableFlag == 1){
    		return "面议";
    	}
    	if(maxSalary != null && maxSalary > 0){
    		return StringUtils.defaultIfBlank(String.valueOf(minSalary), "0") + "-" + maxSalary;
    	}
    	if(salary != null && salary > 0){
    		String salaryStr = OptionMap.getValue(OptionMap.OptionType.OPT_SALARY, salary);
    		return StringUtils.isNotBlank(salaryStr) ? salaryStr : "面议";
    	}
    	return "面议";
    }
    /**
     * 根据最大薪资取得旧版薪资范围
     * @param maxSalary
     * @return
     */
    public static  Integer getOldSalaryByMaxSalary(Integer maxSalary){
        if(maxSalary==null||maxSalary==0){
            return  0;
        }
        if(maxSalary>0&&maxSalary<1500){
            return 1;
        }
        if(maxSalary>=1500&&maxSalary<=1999){
            return 2;
        }
        if(maxSalary>=2000&&maxSalary<=2999){
            return 3;
        }
        if(maxSalary>=3000&&maxSalary<=4499){
            return 4;
        }
        if(maxSalary>=4500&&maxSalary<=5999){
            return 5;
        }
        if(maxSalary>=6000&&maxSalary<=7999){
            return 6;
        }
        if(maxSalary>=8000&&maxSalary<=9999){
            return 7;
        }
        if(maxSalary>=10000&&maxSalary<=14999){
            return 8;
        }
        if(maxSalary>=15000&&maxSalary<=19999){
            return 9;
        }
        if(maxSalary>=20000&&maxSalary<=29999){
            return 10;
        }
        if(maxSalary>=30000&&maxSalary<=49999){
            return 11;
        }
        if(maxSalary>=50000){
            return 12;
        }
        return  12;
    }
    
    /**
     * 调整月薪显示为年薪，兼容新旧版薪资，单位：万
     * @param salary
     * 				旧版本薪资映射值
     * @param maxSalary
     * 				新版最大薪资具体值
     * @param precision
     * 				精度，保留小数点位数
     * @return
     */
    public static String parseMonthToYearSalary(Integer salary, Integer maxSalary, Integer precision){
    	if(precision == null){
    		precision = 0;
    	}
    	String pattern = "\\d*\\.(0)+";
		if(maxSalary != null && maxSalary > 0){
			Double yearSalary = BigDecimal.valueOf(maxSalary * 12).divide(BigDecimal.valueOf(10000)).setScale(precision, RoundingMode.HALF_UP).doubleValue();
			return ((precision == 0 || yearSalary.toString().matches(pattern)) ? yearSalary.intValue() : yearSalary.toString()) + "万";
    	}
		if(salary != null && salary > 0){
			String salaryStr = OptionMap.getValue(OptionMap.OptionType.OPT_SALARY, salary);
			if(StringUtils.isNotBlank(salaryStr)){
				String[] salaryArr = StringUtils.split(salaryStr, "-");
				salaryStr = (salaryArr != null && salaryArr.length == 2) ? salaryArr[1] : salaryStr.replaceAll("[^0-9]", "");
				long salaryVal = NumberUtils.toLong(salaryStr, 0);
				
				if(salaryVal > 0){
					Double yearSalary = BigDecimal.valueOf(salaryVal * 12).divide(BigDecimal.valueOf(10000)).setScale(precision, RoundingMode.HALF_UP).doubleValue();
					return ((precision == 0 || yearSalary.toString().matches(pattern)) ? yearSalary.intValue() : yearSalary.toString()) + "万";
				}
			}
		}
    	return "面议";
    }
    
    public static void main(String[] args) {
//        getTownCodeByCityCodeAndTownEn(1401, "dg");
        //test 增加新type
//        System.out.printf(getValueByType(OptionType.OPT_INDUSTRY,1,OptionMap.NAME));
    	Map<Integer, Map<String, String>> map = OptionMap.OPT_MAP_COM_EMPLOYEE;
    	System.out.println(map.toString());
    }
    
    public enum AreaType {
    	PROV, CITY, TOWN;
    }
}
