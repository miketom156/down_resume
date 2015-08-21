package com.job5156.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

public class Options
{
  private static Object currentValue;


public Options()
  {
  }

public static String loadNumberLimit(Object start,Object end,Object currentValue){
    return loadNumberLimit(start,end,currentValue,"");
}
  public static String loadNumberLimit(Object start,Object end,Object currentValue,Object disDefault){
    String rstr="";
    if(start==null) start="";
    if(end==null) end="";
    if(disDefault==null) disDefault="";
    
    int istart=StringUtil.parseInt(start.toString());
    int iend=StringUtil.parseInt(end.toString());
    int icurrentv=StringUtil.parseInt(currentValue.toString());
    while(istart<=iend)
    {
        if(istart==icurrentv)
            rstr= rstr+"<option value="+istart+"  selected>"+istart+disDefault+"</option>"; 
        else
            rstr= rstr+"<option value="+istart+">"+istart+disDefault+"</option>";
        istart++;
    }
    return rstr;
  } 


  public static String loadAllOptions(int options){
    return loadAllOptions(options,"");
  }
  
  /**装载某个值的option项，如在岗位选择中，已经有三个岗位，这时候可用此方法直接生成这三个岗位在select框中的option*/
  public static String getOneOption(int options,Object currentValue){
    if(currentValue==null  ||"0".equalsIgnoreCase(currentValue.toString()))return "";
    
    HashMap map = (HashMap) allKeyMap.get(String.valueOf(options));     
    if(map.containsKey(currentValue.toString())){
        Object obj = map.get(currentValue.toString());
        return "<option value="+currentValue+">"+obj+"</option>";
    }else
    {
        return "";
    }
  }
    
  /**装载下拉框的所有options<br>
   * 其中的options请参考本类的一些定义,如：<br>
   * Options.OPT_DEGREE...*/
  public static String loadAllOptions(int options,Object currentValue){
    TreeMap <Object,Object>map = new TreeMap<Object,Object>((HashMap) allKeyMap.get(String.valueOf(options)));
    Iterator it = map.keySet().iterator();
    String optionString="";
    while(it.hasNext()){
        String key = it.next().toString();
        String value="";
        try{
            value = map.get(key).toString();
        }
        catch(Exception x){
            value = map.get(new Integer(key)).toString();
        }
        if(currentValue!=null && Validator.isNotNull(currentValue.toString()) && key.equalsIgnoreCase(currentValue.toString())){
            optionString += "<option value=\""+key+"\" selected>"+value+"</option>\n";
        }else{
            optionString += "<option value=\""+key+"\">"+value+"</option>\n";
        }
    }
    //System.out.println("<select>"+optionString+"</select>");
    return optionString;
  }
  

  /**装载省份，没有初始选择项*/
  public static String loadProvinceOptions(){
        return loadProvinceOptions("");
  }
  
  /**装载省份，有初始选择项*/
  public static String loadProvinceOptions(Object currentValue){
    TreeMap <Object,Object>map = new TreeMap<Object,Object>((HashMap) allKeyMap.get(String.valueOf(Options.OPT_CITY)));
    String tempProvince="";
    if(currentValue!=null && Validator.isNotNull(currentValue.toString()) && currentValue.toString().length()==4){
        tempProvince = currentValue.toString().substring(0,2)+"00";
    }
    String optionString="";
    List sortList = new ArrayList();
    Iterator it = map.keySet().iterator();
    
    while(it.hasNext()){
        String key = it.next().toString();      
        String value = map.get(key).toString();
        if(key.length()==4 && key.substring(2).equalsIgnoreCase("00")){     
            if(Validator.isNotNull(tempProvince) && tempProvince.equalsIgnoreCase(key)){
                optionString +="<option value=\""+key+"\"  selected>"+value+"</option>\n";                  
            }else{
                optionString +="<option value=\""+key+"\">"+value+"</option>\n";
            }
        }
    }
//  return "<select>"+optionString+"</select>";
    return optionString;
  }
////////////////mlf add begin
  /**装载省职位编历时用到*/
  public static List loadProvince(){
    TreeMap <Object,Object>map = new TreeMap<Object,Object>((HashMap) allKeyMap.get(String.valueOf(Options.OPT_CITY)));
    String tempProvince="";
    if(currentValue!=null && Validator.isNotNull(currentValue.toString()) && currentValue.toString().length()==4){
        tempProvince = currentValue.toString().substring(0,2)+"00";
    }
    List sortList = new ArrayList();
    Iterator it = map.keySet().iterator();
    List relist=new ArrayList();
    
    while(it.hasNext()){
        String key = it.next().toString();      
        String value = map.get(key).toString();
        if(key.length()==4 && key.substring(2).equalsIgnoreCase("00"))
        {   
                List templist=new ArrayList();;
                if(key==null)key="";
                if(value==null)value="";
                templist.add(key);
                templist.add(value);
                relist.add(templist);
        }   
    }
    return relist;
  }
  
  /**根据省份装载城市，职位编历时用到*/
  public static List loadCity(Object provinceValue){
    if(provinceValue==null || "".equalsIgnoreCase(provinceValue.toString()))return null;
    String tempProvince = "";
     tempProvince = provinceValue.toString().substring(0,2)+"00";
    TreeMap <Object,Object>map = new TreeMap<Object,Object>((HashMap) allKeyMap.get(String.valueOf(Options.OPT_CITY)));
    Iterator it = map.keySet().iterator();
    String optionString="";
    List relist=new ArrayList();
    while(it.hasNext()){
        String key = it.next().toString();      
        String value = map.get(key).toString();
        String provincevaluestr=StringUtil.getNotNullStr(provinceValue);
        if(tempProvince.length()==4 && key.length()==4 && key.substring(0,2).equalsIgnoreCase(tempProvince.substring(0,2))){ 
             List templist=new ArrayList();;
            if(key==null)key="";
            if(value==null)value="";
              templist.add(key);
              templist.add(value);
              relist.add(templist);
        }
    }
    //return "<select>"+optionString+"</select>";
    return relist;
  }
  
  /**装载岗位大类别，没有初始选择项*/
  public static List loadJobCat(){
        return loadJobCat("");
  }
  
  /**装载岗位大类别，有初始选择项*/
  public static List loadJobCat(Object currentValue){
    TreeMap <Object,Object>map = new TreeMap<Object,Object>((HashMap) allKeyMap.get(String.valueOf(Options.OPT_JOB_CATA)));
    String optionString="";
    List sortList = new ArrayList();
    Iterator it = map.keySet().iterator();
    List relist=new ArrayList();
    while(it.hasNext()){
        String key = it.next().toString();      
        String value = map.get(key).toString();
        if(key.length()==4 && key.substring(2).equalsIgnoreCase("00")){     
            List templist=new ArrayList();
            if(Validator.isNotNull(currentValue.toString()) && currentValue.toString().equalsIgnoreCase(key)){
                templist.add(key);
                templist.add(value);
            }else{
                templist.add(key);
                templist.add(value);
            }
            relist.add(templist);
        }
    }
    return relist;
  }


  /**根据岗位大类装载具体项，没有初始值*/
  public static List loadJobItem(Object jobCatValue){
    return loadJobItem(jobCatValue,"");
  }
  
  /**根据岗位大类装载具体项，有初始值*/
  public static List loadJobItem(Object jobCatValue,Object currentValue){
    if(jobCatValue==null || "".equalsIgnoreCase(jobCatValue.toString()))return null;
    TreeMap map = new TreeMap((HashMap) allKeyMap.get(String.valueOf(Options.OPT_JOB_CATA)));
    Iterator it = map.keySet().iterator();
    List relist=new ArrayList();
    String optionString="";
    while(it.hasNext()){
        List templist=new ArrayList();
        String key = it.next().toString();      
        String value = map.get(key).toString();
        if(key.equalsIgnoreCase(jobCatValue.toString()))continue;
        if(key.length()==4 && key.substring(0,2).equalsIgnoreCase(jobCatValue.toString().substring(0,2))){      
            if(!Validator.isNotNull(currentValue.toString()) && currentValue.toString().equalsIgnoreCase(key)){
            templist.add(key);
            templist.add(value);
            }else{
                templist.add(key);
                templist.add(value);
            }
            relist.add(templist);
        }
    }
    return relist;
  }
  
  public static List loadAllFirstCata(Object option){
    
        TreeMap <Object,Object>map = new TreeMap<Object,Object>((HashMap) allKeyMap.get(String.valueOf(option)));
        String tempProvince="";
        if(currentValue!=null && Validator.isNotNull(currentValue.toString()) && currentValue.toString().length()==4){
            tempProvince = currentValue.toString().substring(0,2)+"00";
        }
        List sortList = new ArrayList();
        Iterator it = map.keySet().iterator();
        List relist=new ArrayList();
        
        while(it.hasNext()){
            String key = it.next().toString();      
            String value = map.get(key).toString();
            if(key.length()==4 && key.substring(2).equalsIgnoreCase("00"))
            {   
                    List templist=new ArrayList();;
                    if(key==null)key="";
                    if(value==null)value="";
                
                    templist.add(key);
                    templist.add(value);
                    relist.add(templist);
                    
            }   
        }
        
        return relist;
    
  }
  
  /////////////////////////////mlf add end
  
  /**根据省份装载城市，没有初始值*/
  public static String loadCityOptions(Object provinceValue){
    return loadCityOptions(provinceValue,"");
  }
  
  /**根据省份装载城市，有初始值*/
  public static String loadCityOptions(Object provinceValue,Object currentValue){
    if(provinceValue==null || "".equalsIgnoreCase(provinceValue.toString()))return "";
    String tempProvince = "";
    if(currentValue!=null && currentValue.toString().length()==4){ tempProvince = provinceValue.toString().substring(0,2)+"00";}
    TreeMap <Object,Object>map = new TreeMap<Object,Object>((HashMap) allKeyMap.get(String.valueOf(Options.OPT_CITY)));
    Iterator it = map.keySet().iterator();
    String optionString="";
    while(it.hasNext()){
        String key = it.next().toString();      
        String value = map.get(key).toString();
        if(key.equalsIgnoreCase(tempProvince))continue;
        if(tempProvince.length()==4 && key.length()==4 && key.substring(0,2).equalsIgnoreCase(tempProvince.substring(0,2))){    
            if(Validator.isNotNull(currentValue.toString()) && currentValue.toString().equalsIgnoreCase(key)){
                optionString += "<option value=\""+key+"\" selected>"+value+"</option>\n";
            }else{
                optionString += "<option value=\""+key+"\">"+value+"</option>\n";
            }
        }
    }
    //return "<select>"+optionString+"</select>";
    return optionString;
  }
  
  /**根据城市值，同时装载所在省份和城市*/
  public static String getProvinceAndCityByCity(Object city){
    if(city==null || Validator.isNull(city.toString().trim())){
        return "";
    }
    else{
        if(city.toString().trim().length()==4){
            String tempProvince = city.toString().substring(0,2)+"00";
            if(city.toString().equalsIgnoreCase(tempProvince)){   //如果传进来的本来就是一个省的代码，则不需要选择市了
                return getValue(OPT_CITY,tempProvince);
            }
            else{
                return getValue(OPT_CITY,tempProvince)+getValue(OPT_CITY,city.toString());
            }
        }else{
            return "";
        }
    }
  }

  /**装载岗位大类别，没有初始选择项*/
  public static String loadJobCatOptions(){
        return loadJobCatOptions("");
  }
  
  /**装载岗位大类别，有初始选择项*/
  public static String loadJobCatOptions(Object currentValue){
    TreeMap <Object,Object>map = new TreeMap<Object,Object>((HashMap) allKeyMap.get(String.valueOf(Options.OPT_JOB_CATA)));
    String optionString="";
    List sortList = new ArrayList();
    Iterator it = map.keySet().iterator();
    
    while(it.hasNext()){
        String key = it.next().toString();      
        String value = map.get(key).toString();
        if(key.length()==4 && key.substring(2).equalsIgnoreCase("00")){     
            if(Validator.isNotNull(currentValue.toString()) && currentValue.toString().equalsIgnoreCase(key)){
                optionString +="<option value=\""+key+"\"  selected>"+value+"</option>\n";                  
            }else{
                optionString +="<option value=\""+key+"\">"+value+"</option>\n";
            }
        }
    }
//  return "<select>"+optionString+"</select>";
    return optionString;
  }

  /**根据岗位大类装载具体项，没有初始值*/
  public static String loadJobItemOptions(Object jobCatValue){
    return loadJobItemOptions(jobCatValue,"");
  }
  
  /**根据岗位大类装载具体项，有初始值*/
  public static String loadJobItemOptions(Object jobCatValue,Object currentValue){
    if(jobCatValue==null || "".equalsIgnoreCase(jobCatValue.toString()))return "";
    TreeMap map = new TreeMap((HashMap) allKeyMap.get(String.valueOf(Options.OPT_JOB_CATA)));
    Iterator it = map.keySet().iterator();
    String optionString="";
    while(it.hasNext()){
        String key = it.next().toString();      
        String value = map.get(key).toString();
        if(key.equalsIgnoreCase(jobCatValue.toString()))continue;
        if(key.length()==4 && key.substring(0,2).equalsIgnoreCase(jobCatValue.toString().substring(0,2))){      
            if(Validator.isNotNull(currentValue.toString()) && currentValue.toString().equalsIgnoreCase(key)){
            optionString += "<option value=\""+key+"\" selected>"+value+"</option>\n";
            }else{
                optionString += "<option value=\""+key+"\">"+value+"</option>\n";
            }
        }
    }
    //return "<select>"+optionString+"</select>";
    return optionString;
  }
  
  /**
   * 装载有初始值小类具体项,方法同上  (zzk)
   * @param currentValue 职位小类初始值
   */
  public static String loadSmallJobByDefualt(int currentValue){
    if(currentValue==0 || "0".equalsIgnoreCase(String.valueOf(currentValue)))return "";
    TreeMap <Object,Object>map = new TreeMap<Object,Object>((HashMap) allKeyMap.get(String.valueOf(Options.OPT_JOB_CATA)));
    Iterator it = map.keySet().iterator();
    String optionString="";
    String tmpCurrentValue = String.valueOf(currentValue);
    int len = tmpCurrentValue.length();
    //如果传来参数长度小于4，则在后面补0
    if(len<4)
    {
        int tmpLen = 4-len;
        for(int i=0;i<tmpLen;i++)
        {
            tmpCurrentValue += "0";
        }
    }
    String fatherValue = String.valueOf(tmpCurrentValue).substring(0,2)+"00";
    while(it.hasNext()){
        String key = it.next().toString();      
        String value = map.get(key).toString();
        if(key.equalsIgnoreCase(fatherValue))continue;
        if(key.length()==4 && key.substring(0,2).equalsIgnoreCase(String.valueOf(fatherValue).substring(0,2))){     
            if(Validator.isNotNull(String.valueOf(tmpCurrentValue)) && String.valueOf(tmpCurrentValue).equalsIgnoreCase(key)){
            optionString += "<option value=\""+key+"\" selected>"+value+"</option>\n";
            }else{
                optionString += "<option value=\""+key+"\">"+value+"</option>\n";
            }
        }
    }
    //return "<select>"+optionString+"</select>";
    return optionString;
  }
  
  /**装载行业名称，没有初始选择项*/
  public static List loadCompanyCata(){
        return loadCompanyCata("");
  }
  
  /**装载行业名称，有初始选择项*/
  public static List loadCompanyCata(Object currentValue){
    TreeMap <Object,Object>map = new TreeMap<Object,Object>((HashMap) allKeyMap.get(String.valueOf(Options.OPT_COMPANY_CATA)));
    String optionString="";
    List sortList = new ArrayList();
    Iterator it = map.keySet().iterator();
    List relist=new ArrayList();
    while(it.hasNext()){
        int key = ((Integer)it.next()).intValue();      
        String value = map.get(key).toString();
 
            List templist=new ArrayList();
            if(!currentValue.equals("") && currentValue==(new Integer(key))){
                templist.add(key);
                templist.add(value);
            }else{
                templist.add(key);
                templist.add(value);
            }
            relist.add(templist);
     
    }
    return relist;
  }
  
  /**装载学历*/
  public static List loadDegree(){
    TreeMap <Object,Object>map = new TreeMap<Object,Object>((HashMap) allKeyMap.get(String.valueOf(Options.OPT_DEGREE)));
    String optionString="";
    List sortList = new ArrayList();
    Iterator it = map.keySet().iterator();
    List relist=new ArrayList();
    while(it.hasNext()){
        String key = it.next().toString();      
        String value = map.get(key).toString();   
            List templist=new ArrayList();

            templist.add(key);
            templist.add(value);
            relist.add(templist);
    }
    return relist;
  }
  
  /**装载会员类型*/
  public static List loadMemberClass(){
    TreeMap <Object,Object>map = new TreeMap<Object,Object>((HashMap) allKeyMap.get(String.valueOf(Options.OPT_MEMBERCLASS)));
    String optionString="";
    List sortList = new ArrayList();
    Iterator it = map.keySet().iterator();
    List relist=new ArrayList();
    while(it.hasNext()){
        String key = it.next().toString();      
        String value = map.get(key).toString();   
            List templist=new ArrayList();

            templist.add(key);
            templist.add(value);
            relist.add(templist);
    }
    return relist;
  } 
  
  /**
   * 通过指定选项列表的查询字符串来获取相关值
   * @param options 指定的选项列表
   * @param key 关键字
   * @return 字符类型的值
   */
  public static String getValue(int options,Object key){    
        if(key==null)return "";
        return getValue(key.toString(),options);
  }
  
  /**
   * 通过指定选项列表的查询字符串来获取相关值
   * @param key 关键字
   * @param options 指定的选项列表
   * @return 字符类型的值
   */
  public static String getValue(Object key,int options)
  {
    if (key==null) return "";
    HashMap map = (HashMap) allKeyMap.get(String.valueOf(options));
    if(map.containsKey(key.toString())){
        String s=(String)map.get(key.toString());
        return s;
    }else
        return "";
  }
  /**
   * 通过薪水代号取得薪水值
   * @param key 关键字
   * @param options 指定的选项列表
   * @return 字符类型的值
   */
  public static String getSaraly(Object key,int options)
  {
    if (key==null) return "";
    HashMap map = (HashMap) allKeyMap.get(String.valueOf(options));
    int keyInt = StringUtil.parseInt(key.toString(),-1);
    if(map.containsKey(keyInt)){
        String s=(String)map.get(keyInt);
        return s;
    }else
        return key.toString();
  }
  /**
   * 通过指定选项列表的查询整型来获取相关值
   * @param key 关键字
   * @param options 指定的选项列表
   * @return 字符类型的值
   */
  public static String getIntValue(Object key,int options)
  {
    if (key==null) return "";
    HashMap map = (HashMap) allKeyMap.get(String.valueOf(options));
    if(map.containsKey(key)){
        String s=(String)map.get(key);
        return s;
    }else
        return "";
  }
  
  public static String getIntValue(int options,Object key){    
      if(key==null)return "";
      return getIntValue(key,options);
  }
  
  /**学历数字得到学历名，初始化时随便传个值*/
  public static String loadDegree(int currentValue){
    TreeMap <String,Object>map = new TreeMap<String,Object>((HashMap) allKeyMap.get(String.valueOf(Options.OPT_DEGREE)));
    String optionString="";
    try
    {
        Iterator it = map.keySet().iterator();
        System.out.println(map.keySet().size());
        while(it.hasNext()){
            String key = it.next().toString();      
            int keyInt = (key==null?0:Integer.parseInt(key));
            //int keyInt = Integer.parseInt(key);
            String value = map.get(key).toString();
            if(keyInt==currentValue)
            {   
                optionString +="<option value=\""+key+"\"  selected>"+value+"</option>\n";                  
            }
            else
            {
                optionString +="<option value=\""+key+"\">"+value+"</option>\n";
            }
        }
    }
    catch(Exception ex)
    {
        System.out.println("loadDegree() was error:"+ex.toString());
        return optionString;
    }
    return optionString;
  }
  
  
  public static void main(String[] args)
  {
    //System.out.println(Options.getValue("1421",Options.OPT_CITY));
    //System.out.println(Options.getValue("4",Options.OPT_DEGREE));
//      System.out.println(loadSelectString(Options.OPT_CITY,"1"));
//      System.out.println(loadProvinceOptions("1400"));
    System.out.println(loadSmallJobByDefualt(1006));
    //System.out.println(loadJobCatOptions());
    //System.out.println(loadJobItemOptions("2300"));
  }

  /**学历*/
  public final static int OPT_DEGREE=1;
  
  /**城市*/
  public final static int OPT_CITY=2;
  
  /**岗位类型*/
  public final static int OPT_JOB_CATA=3;
  
  /**外语水平*/
  public final static int OPT_LANG_LVL=4;
  
  /**外语类型*/
  public final static int OPT_LANG_TYPE=5;
  
  /**普通话和粤语*/
  public final static int OPT_CANT_LVL=6;
  
  /**计算机水平*/
  public final static int OPT_COMPUTER_LVL=7;
  
  /**公司类型*/
  public final static int OPT_COMPANY_TYPE=8;
  
  /**行业类别*/
  public final static int OPT_COMPANY_CATA=9;
  
  /**性别，用于增加\修改等*/
  public final static int OPT_SEX=10;
  
  /**性别，用于查询*/
  public final static int OPT_SEX_QUERY=11;
  
  /**职位状态**/
  public final static int OPT_POS=12;
  
  /**资金范围**/
  public final static int OPT_MONEY_LIMIT=13;
  /**员工人数**/
  public final static int OPT_EMPLOYNUM=14;
  
  /**搜索时间条件**/
  public final static int OPT_SEARCHDATERANG=15;
  
  /**薪水情况**/
  public final static int OPT_SALARY=16;
  
  /**联系方式**/
  public final static int OPT_CONTACT=17;
  
  /**何时到岗**/
  public final static int OPT_COMEON=18;
  
  /**个人联系方式**/
  public final static int OPT_CONTACTPERSON=19;

  /**婚否**/
  public final static int OPT_MARRIAGE=20;
  
  /**身份证类型**/
  public final static int OPT_IDCARD=21;
  
  /**招聘会地点**/
  public final static int OPT_ADDRESS=22;
  
  /**会员类型**/
  public final static int OPT_MEMBERCLASS=23;
  
  private final static HashMap <Object,Object>allKeyMap = new HashMap<Object,Object>();
  
  private final static HashMap <Object,Object>degree=new HashMap<Object,Object>();
  private final static HashMap <Object,Object>cities=new HashMap<Object,Object>();
  private final static HashMap<Object,Object> jobCata=new HashMap<Object,Object>();
  private final static HashMap<Object,Object> langLvl=new HashMap<Object,Object>();
  private final static HashMap<Object,Object> langType=new HashMap<Object,Object>();
  private final static HashMap<Object,Object> cantLvl=new HashMap<Object,Object>();
  private final static HashMap<Object,Object> computerLvl=new HashMap<Object,Object>();
  private final static HashMap<Object,Object> companyType=new HashMap<Object,Object>();
  private final static HashMap<Object,Object> companyCata=new HashMap<Object,Object>();
  private final static HashMap<Object,Object> sex=new HashMap<Object,Object>();
  private final static HashMap<Object,Object> sexQuery=new HashMap<Object,Object>();
  private final static HashMap<Object,Object> posStat=new HashMap<Object,Object>();
  private final static HashMap<Object,Object> moneyLimit=new HashMap<Object,Object>();
  private final static HashMap<Object,Object> employnum=new HashMap<Object,Object>();    
  private final static HashMap<Object,Object> searchdaterang=new HashMap<Object,Object>(); 
  private final static HashMap<Object,Object> salary=new HashMap<Object,Object>(); 
  private final static HashMap<Object,Object> contact=new HashMap<Object,Object>(); 
  private final static HashMap<Object,Object> comeon=new HashMap<Object,Object>(); //到岗时间
  private final static HashMap<Object,Object> contactPerson=new HashMap<Object,Object>(); //到岗时间
  

  private final static HashMap<Object,Object> marriage=new HashMap<Object,Object>(); //婚否
  private final static HashMap<Object,Object> idcard=new HashMap<Object,Object>(); //身份证类型
  private final static HashMap<Object,Object> address=new HashMap<Object,Object>(); //招聘会地点
  private final static HashMap<Object,Object> memberClass = new HashMap<Object,Object>();  //会员类型
  
  
  
  static
  {

    allKeyMap.put(String.valueOf(OPT_DEGREE),degree);
    allKeyMap.put(String.valueOf(OPT_CITY),cities);
    allKeyMap.put(String.valueOf(OPT_JOB_CATA),jobCata);
    allKeyMap.put(String.valueOf(OPT_LANG_LVL),langLvl);
    allKeyMap.put(String.valueOf(OPT_LANG_TYPE),langType);
    allKeyMap.put(String.valueOf(OPT_CANT_LVL),cantLvl);
    allKeyMap.put(String.valueOf(OPT_COMPUTER_LVL),computerLvl);
    allKeyMap.put(String.valueOf(OPT_COMPANY_TYPE),companyType);
    allKeyMap.put(String.valueOf(OPT_COMPANY_CATA),companyCata);
    allKeyMap.put(String.valueOf(OPT_SEX),sex);
    allKeyMap.put(String.valueOf(OPT_SEX_QUERY),sexQuery);
    allKeyMap.put(String.valueOf(OPT_POS),posStat);
    allKeyMap.put(String.valueOf(OPT_MONEY_LIMIT),moneyLimit);
    allKeyMap.put(String.valueOf(OPT_EMPLOYNUM),employnum);
    allKeyMap.put(String.valueOf(OPT_SEARCHDATERANG),searchdaterang);
    allKeyMap.put(String.valueOf(OPT_SALARY),salary);
    allKeyMap.put(String.valueOf(OPT_CONTACT),contact);
    allKeyMap.put(String.valueOf(OPT_COMEON),comeon);
    allKeyMap.put(String.valueOf(OPT_CONTACTPERSON),contactPerson);
    allKeyMap.put(String.valueOf(OPT_MARRIAGE),marriage);
    allKeyMap.put(String.valueOf(OPT_IDCARD),idcard);
    allKeyMap.put(String.valueOf(OPT_ADDRESS),address);
    allKeyMap.put(String.valueOf(OPT_MEMBERCLASS),memberClass);

    //婚否
    marriage.put("0","未婚");
    marriage.put("1","已婚");
    marriage.put("2","离异");
    marriage.put("3","保密");     

    //身分证类型 
    idcard.put("1","身份证");
    idcard.put("2","护照");
    idcard.put("3","军人证");
    idcard.put("4","其他");
    idcard.put("5","驾证");
    
    //会员类型
    memberClass.put("0","测试会员");
    memberClass.put("1","试用会员");
    memberClass.put("2","一月期会员");
    memberClass.put("3","三月期会员");
    memberClass.put("4","半年期会员");
    memberClass.put("5","一年期会员");
    memberClass.put("6","导入的企业会员");
    memberClass.put("7","终止的企业会员");
    
    //搜索时间范围
    searchdaterang.put(new Integer("-1"),"一天");
    searchdaterang.put(new Integer("-7"),"一周内");
    searchdaterang.put(new Integer("-15"),"半个月内");
    searchdaterang.put(new Integer("-30"),"一个月内");
    searchdaterang.put(new Integer("-90"),"三个月内");
    searchdaterang.put(new Integer("-180"),"半年内");
    searchdaterang.put(new Integer("-365"),"一年内");

    //员工人数范围
    employnum.put("0","1-49人");
    employnum.put("1","50-100人");
    employnum.put("2","100-200人");
    employnum.put("3","200-500人");
    employnum.put("4","500-1000人");
    employnum.put("5","1000-2000人");
    employnum.put("6","2000人以上");
    //资金范围
    moneyLimit.put("0","50万以下");
    moneyLimit.put("1","50万-100万");
    moneyLimit.put("2","100万-500万");
    moneyLimit.put("3","500万-1000万");
    moneyLimit.put("4","1000万-5000万");
    moneyLimit.put("5","5000万以上");
    
    //性别，用于增加修改
    sex.put("0","未知");
    sex.put("1","男");
    sex.put("2","女");

    
    //性别，用于查询
    sexQuery.put("0","不限");
    sexQuery.put("1","男");
    sexQuery.put("2","女");
    
    //职位状态
    posStat.put("0","<font color='green'>[未知]</font>");
    posStat.put("1","[正在招聘]");
    posStat.put("2","<font color='red'>[停止招聘]</font>");
    posStat.put("3","<font color='#808080'>[已过期]</font>");
    posStat.put("4","[已删除]");
    
    //学历
    degree.put("0","不限");
    degree.put("1","初中");
    degree.put("2","高中");
    degree.put("3","中专");
    degree.put("4","大专");
    degree.put("5","本科");
    degree.put("6","硕士");
    degree.put("7","MBA");
    degree.put("8","博士");
    degree.put("9","培训");
    
    //薪水值
    salary.put(0,"面议");
    salary.put(1,"1000以下");
    salary.put(2,"1000~2000");
    salary.put(3,"2000~3000");
    salary.put(4,"3000~4000");
    
    salary.put(5,"4000~5000");
    salary.put(6,"5000~6000");
    salary.put(7,"6000~7000");
    salary.put(8,"7000~8000");
    salary.put(9,"8000~9000");
    salary.put(10,"9000~10000");
    salary.put(11,"10000以上");

    //公司联系方式
    contact.put("0","手机");
    contact.put("1","电话");
    contact.put("2","传真");
    contact.put("3","MSN");
    contact.put("4","QQ");
    contact.put("5","其他");
    contact.put("6","未知");
    
    //个人联系方式
    contactPerson.put("0","手机");
    contactPerson.put("1","家庭电话");
    contactPerson.put("2","工作电话");
    contactPerson.put("3","宿舍电话");
    contactPerson.put("4","传真");
    contactPerson.put("5","MSN Messenger");
    contactPerson.put("6","QQ");
    contactPerson.put("7","其他");
    
    //招聘会地点
    address.put("0","莞城总部A馆");
    address.put("1","莞城总部B馆");
    address.put("2","专业市场");
    address.put("3","塘厦分部");
    address.put("4","长安分部");
    address.put("5","横沥分部");
    address.put("6","佛山分部");
    address.put("7","郴州分部");
    address.put("8","江门分部");
    
    //城市
    cities.put("","");
    cities.put("1100","北京");
    cities.put("1000","上海");
    cities.put("1200","天津");
    cities.put("1300","重庆");
    cities.put("1400","广东");
    cities.put("1403","广州");
    cities.put("1402","深圳");
    cities.put("1401","东莞");
    cities.put("1404","中山");
    cities.put("1405","珠海");
    cities.put("1406","汕头");
    cities.put("1407","惠州");
    cities.put("1408","江门");
    cities.put("1409","佛山");
    cities.put("1410","阳江");
    cities.put("1411","清远");
    cities.put("1412","韶关");
    cities.put("1413","肇庆");
    cities.put("1414","潮州");
    cities.put("1415","湛江");
    cities.put("1416","茂名");
    cities.put("1417","梅州");
    cities.put("1418","汕尾");
    cities.put("1419","河源");
    cities.put("1420","云浮");
    cities.put("1421","揭阳");
    cities.put("1422","其他");
    cities.put("1500","浙江");
    cities.put("1501","杭州");
    cities.put("1502","宁波");
    cities.put("1503","温州");
    cities.put("1504","金华");
    cities.put("1505","绍兴");
    cities.put("1506","湖州");
    cities.put("1507","嘉兴");
    cities.put("1508","衢州");
    cities.put("1509","丽水");
    cities.put("1510","台州");
    cities.put("1511","舟山");
    cities.put("1512","其他");
    cities.put("1600","江苏");
    cities.put("1601","南京");
    cities.put("1602","苏州");
    cities.put("1603","无锡");
    cities.put("1604","扬州");
    cities.put("1605","常州");
    cities.put("1606","镇江");
    cities.put("1607","南通");
    cities.put("1608","连云港");
    cities.put("1609","徐州");
    cities.put("1610","宿迁");
    cities.put("1611","泰州");
    cities.put("1612","盐城");
    cities.put("1613","淮安");
    cities.put("1614","其他");
    cities.put("1700","福建");
    cities.put("1701","福州");
    cities.put("1702","厦门");
    cities.put("1703","泉州");
    cities.put("1704","漳州");
    cities.put("1705","三明");
    cities.put("1706","南平");
    cities.put("1707","莆田");
    cities.put("1708","龙岩");
    cities.put("1709","宁德");
    cities.put("1710","其他");
    cities.put("1800","河北");
    cities.put("1801","石家庄");
    cities.put("1802","邯郸");
    cities.put("1803","保定");
    cities.put("1804","张家口");
    cities.put("1805","秦皇岛");
    cities.put("1806","邢台");
    cities.put("1807","唐山");
    cities.put("1808","廊坊");
    cities.put("1809","衡水");
    cities.put("1810","沧州");
    cities.put("1811","承德");
    cities.put("1812","其他");
    cities.put("1900","河南");
    cities.put("1901","郑州");
    cities.put("1902","洛阳");
    cities.put("1903","开封");
    cities.put("1904","鹤壁");
    cities.put("1905","焦作");
    cities.put("1906","许昌");
    cities.put("1907","驻马店");
    cities.put("1908","周口");
    cities.put("1909","新乡");
    cities.put("1910","安阳");
    cities.put("1911","濮阳");
    cities.put("1912","漯河");
    cities.put("1913","信阳");
    cities.put("1914","平顶山");
    cities.put("1915","三门峡");
    cities.put("1916","南阳");
    cities.put("1917","商丘");
    cities.put("1918","其他");
    cities.put("2000","黑龙江");
    cities.put("2001","哈尔滨");
    cities.put("2002","佳木斯");
    cities.put("2003","牡丹江");
    cities.put("2004","大庆");
    cities.put("2005","齐齐哈尔");
    cities.put("2006","绥化");
    cities.put("2007","伊春");
    cities.put("2008","鹤岗");
    cities.put("2009","七台河");
    cities.put("2010","双鸭山");
    cities.put("2011","鸡西");
    cities.put("2012","黑河");
    cities.put("2013","大兴安岭");
    cities.put("2014","其他");
    cities.put("2100","辽宁");
    cities.put("2101","沈阳");
    cities.put("2102","铁岭");
    cities.put("2103","抚顺");
    cities.put("2104","大连");
    cities.put("2105","本溪");
    cities.put("2106","营口");
    cities.put("2107","锦州");
    cities.put("2108","盘锦");
    cities.put("2109","辽阳");
    cities.put("2110","鞍山");
    cities.put("2111","丹东");
    cities.put("2112","朝阳");
    cities.put("2113","阜新");
    cities.put("2114","葫芦岛");
    cities.put("2115","其他");
    cities.put("2200","吉林");
    cities.put("2201","长春");
    cities.put("2202","通化");
    cities.put("2203","四平");
    cities.put("2204","辽源");
    cities.put("2205","白城");
    cities.put("2206","吉林");
    cities.put("2207","松原");
    cities.put("2208","白山");
    cities.put("2209","延边");
 //   cities.put("2210","其他");
    cities.put("2300","陕西");
    cities.put("2301","西安");
    cities.put("2302","咸阳");
    cities.put("2303","宝鸡");
    cities.put("2304","铜川");
    cities.put("2305","渭南");
    cities.put("2306","延安");
    cities.put("2307","汉中");
    cities.put("2308","榆林");
    cities.put("2309","商洛");
    cities.put("2310","安康");
    cities.put("2311","其他");
    cities.put("2400","安徽");
    cities.put("2401","合肥");
    cities.put("2402","芜湖");
    cities.put("2403","马鞍山");
    cities.put("2404","蚌埠");
    cities.put("2405","铜陵");
    cities.put("2406","淮北");
    cities.put("2407","淮南");
    cities.put("2408","亳州");
    cities.put("2409","巢湖");
    cities.put("2410","黄山");
    cities.put("2411","宿州");
    cities.put("2412","阜阳");
    cities.put("2413","六安");
    cities.put("2414","滁州");
    cities.put("2415","宣城");
    cities.put("2416","安庆");
    cities.put("2417","池州");
    cities.put("2418","其他");
    cities.put("2500","山东");
    cities.put("2501","济南");
    cities.put("2502","青岛");
    cities.put("2503","烟台");
    cities.put("2504","淄博");
    cities.put("2505","潍坊");
    cities.put("2506","临沂");
    cities.put("2507","莱芜");
    cities.put("2508","济宁");
    cities.put("2509","荷泽");
    cities.put("2510","日照");
    cities.put("2511","聊城");
    cities.put("2512","德州");
    cities.put("2513","滨州");
    cities.put("2514","威海");
    cities.put("2515","泰安");
    cities.put("2516","东营");
    cities.put("2517","枣庄");
    cities.put("2518","其他");
    cities.put("2600","山西");
    cities.put("2601","太原");
    cities.put("2602","大同");
    cities.put("2603","忻州");
    cities.put("2604","临汾");
    cities.put("2605","运城");
    cities.put("2606","长治");
    cities.put("2607","阳泉");
    cities.put("2608","晋城");
    cities.put("2609","朔州");
    cities.put("2610","晋中");
    cities.put("2611","吕梁");
    cities.put("2612","其他");
    cities.put("2700","湖北");
    cities.put("2701","武汉");
    cities.put("2702","宜昌");
    cities.put("2703","孝感");
    cities.put("2704","荆州");
    cities.put("2705","襄樊");
    cities.put("2706","荆门");
    cities.put("2707","黄石");
    cities.put("2708","鄂州");
    cities.put("2709","黄冈");
    cities.put("2710","咸宁");
    cities.put("2711","十堰");
    cities.put("2712","随州");
    cities.put("2713","恩施");
    cities.put("2714","潜江市");
    cities.put("2715","天门市");
    cities.put("2716","仙桃市");
    cities.put("2717","其他");
    cities.put("2800","湖南");
    cities.put("2801","长沙");
    cities.put("2802","湘潭");
    cities.put("2803","岳阳");
    cities.put("2804","株洲");
    cities.put("2805","张家界");
    cities.put("2806","衡阳");
    cities.put("2807","郴州");
    cities.put("2808","常德");
    cities.put("2809","娄底");
    cities.put("2810","怀化");
    cities.put("2811","益阳");
    cities.put("2812","邵阳");
    cities.put("2813","永州");
    cities.put("2814","湘西");
    cities.put("2815","其他");
    cities.put("2900","江西");
    cities.put("2901","南昌");
    cities.put("2902","景德镇");
    cities.put("2903","九江");
    cities.put("2904","鹰潭");
    cities.put("2905","宜春");
    cities.put("2906","新余");
    cities.put("2907","萍乡");
    cities.put("2908","赣州");
    cities.put("2909","吉安");
    cities.put("2910","抚州");
    cities.put("2911","上饶");
    cities.put("2912","其他");
    cities.put("3000","内蒙古");
    cities.put("3001","呼和浩特");
    cities.put("3002","赤峰");
    cities.put("3003","包头");
    cities.put("3004","乌海");
    cities.put("3005","通辽");
    cities.put("3006","鄂尔多斯");
    cities.put("3007","呼伦贝尔");
    cities.put("3008","乌兰察布");
    cities.put("3009","锡林郭勒");
    cities.put("3010","阿拉善");
    cities.put("3011","兴安");
    cities.put("3012","巴彦淖尔");
    cities.put("3013","其他");
    cities.put("3100","广西");
    cities.put("3101","南宁");
    cities.put("3102","桂林");
    cities.put("3103","北海");
    cities.put("3104","柳州");
    cities.put("3105","玉林");
    cities.put("3106","百色");
    cities.put("3107","河池");
    cities.put("3108","防城港");
    cities.put("3109","崇左");
    cities.put("3110","钦州");
    cities.put("3111","梧州");
    cities.put("3112","贵港");
    cities.put("3113","来宾");
    cities.put("3114","贺州");
    cities.put("3115","其他");
    cities.put("3200","四川");
    cities.put("3201","成都");
    cities.put("3202","宜宾");
    cities.put("3203","泸州");
    cities.put("3204","内江");
    cities.put("3205","攀枝花");
    cities.put("3206","德阳");
    cities.put("3207","雅安");
    cities.put("3208","遂宁");
    cities.put("3209","南充");
    cities.put("3210","绵阳");
    cities.put("3211","广元");
    cities.put("3212","自贡");
    cities.put("3213","乐山");
    cities.put("3214","广安");
    cities.put("3215","巴中");
    cities.put("3216","达州");
    cities.put("3217","资阳");
    cities.put("3218","眉山");
    cities.put("3219","阿坝");
    cities.put("3220","甘孜");
    cities.put("3221","凉山");
    cities.put("3222","其他");
    cities.put("3300","贵州");
    cities.put("3301","贵阳");
    cities.put("3302","遵义");
    cities.put("3303","铜仁");
    cities.put("3304","六盘水");
    cities.put("3305","安顺");
    cities.put("3306","毕节");
    cities.put("3307","黔西");
    cities.put("3308","黔东");
    cities.put("3309","黔南");
    cities.put("3310","其他");
    cities.put("3400","云南");
    cities.put("3401","昆明");
    cities.put("3402","曲靖");
    cities.put("3403","大理");
    cities.put("3404","玉溪");
    cities.put("3405","丽江");
    cities.put("3406","楚雄");
    cities.put("3407","迪庆");
    cities.put("3408","昭通");
    cities.put("3409","保山");
    cities.put("3410","文山");
    cities.put("3411","思茅");
    cities.put("3412","临沧");
    cities.put("3413","德宏");
    cities.put("3414","怒江");
    cities.put("3415","红河");
    cities.put("3416","西双版纳");
    cities.put("3417","其他");
    cities.put("3500","甘肃");
    cities.put("3501","兰州");
    cities.put("3502","酒泉");
    cities.put("3503","临夏");
    cities.put("3504","张掖");
    cities.put("3505","嘉峪关");
    cities.put("3506","金昌");
    cities.put("3507","平凉");
    cities.put("3508","白银");
    cities.put("3509","武威");
    cities.put("3510","天水");
    cities.put("3511","庆阳");
    cities.put("3512","定西");
    cities.put("3513","陇南");
    cities.put("3514","甘南");
    cities.put("3515","其他");
    cities.put("3600","青海");
    cities.put("3601","西宁");
    cities.put("3602","海东");
    cities.put("3603","海南");
    cities.put("3604","海西");
    cities.put("3605","海北");
    cities.put("3606","黄南");
    cities.put("3607","玉树");
    cities.put("3608","果洛");
    cities.put("3609","其他");
    cities.put("3700","宁夏");
    cities.put("3701","银川");
    cities.put("3702","吴忠");
    cities.put("3703","石嘴山");
    cities.put("3704","固原");
    cities.put("3705","其他");
    cities.put("3800","新疆");
    cities.put("3801","乌鲁木齐");
    cities.put("3802","克拉玛依");
    cities.put("3803","哈密");
    cities.put("3804","阿克苏");
    cities.put("3805","吐鲁番");
    cities.put("3806","喀什");
    cities.put("3807","和田");
    cities.put("3808","克孜勒蘇");
    cities.put("3809","巴音郭楞");
    cities.put("3810","昌吉");
    cities.put("3811","博爾塔拉");
    cities.put("3812","伊犁");
    cities.put("3813","其他");
    cities.put("3900","西藏");
    cities.put("3901","拉萨");
    cities.put("3902","那曲");
    cities.put("3903","昌都");
    cities.put("3904","山南");
    cities.put("3905","日喀则");
    cities.put("3906","阿里");
    cities.put("3907","林芝");
    cities.put("3908","其他");
    cities.put("4000","海南");
    cities.put("4001","海口");
    cities.put("4002","三亚");
    cities.put("4003","其他");
    cities.put("4100","香港");
    cities.put("4200","澳门");
    cities.put("4300","台湾");
    cities.put("4400","国外");
    cities.put("4500","其他");
    
    //岗位名称
    jobCata.put("1000","计算机（IT）类");
    jobCata.put("1001","技术总监");
    jobCata.put("1002","信息主管/CIO");
    jobCata.put("1003","数据库开发与管理");
    jobCata.put("1004","软件工程师");
    jobCata.put("1005","硬件工程师");
    jobCata.put("1006","系统管理员/网络管理员");
    jobCata.put("1007","系统集成/技术支持");
    jobCata.put("1008","MRP/ERP/SAP工程师");
    jobCata.put("1009","系统分析员");
    jobCata.put("1010","测试工程师");
    jobCata.put("1011","信息安全工程师");
    jobCata.put("1012","网页设计师");
    jobCata.put("1013","INTERNET/WEB电子商务");
    jobCata.put("1014","网站策划");
    jobCata.put("1015","网站编辑/栏目主持人");
    jobCata.put("1016","系统维护员");
    jobCata.put("1017","计算机类其他相关职位");
    jobCata.put("1100","经营/管理类");
    jobCata.put("1101","首席执行官CEO");
    jobCata.put("1102","（正/副）总裁/总经理/总监");
    jobCata.put("1103","人力资源总监");
    jobCata.put("1104","行政总监");
    jobCata.put("1105","企划总监");
    jobCata.put("1106","财务总监");
    jobCata.put("1107","分公司/办事处经理/主管");
    jobCata.put("1108","部门经理/主管");
    jobCata.put("1109","总经理助理");
    jobCata.put("1110","经理助理");
    jobCata.put("1111","厂长/副厂长");
    jobCata.put("1112","项目经理/主管");
    jobCata.put("1113","经营/管理类其他相关职位");
    jobCata.put("1200","销售/客服类");
    jobCata.put("1201","销售总监");
    jobCata.put("1202","销售经理/主管");
    jobCata.put("1203","销售助理");
    jobCata.put("1204","销售工程师");
    jobCata.put("1205","销售代表");
    jobCata.put("1206","业务员");
    jobCata.put("1207","医药代表");
    jobCata.put("1208","商务经理/商务专员");
    jobCata.put("1209","渠道经理/主管");
    jobCata.put("1210","区域销售经理");
    jobCata.put("1211","分销经理");
    jobCata.put("1212","客户服务");
    jobCata.put("1213","售前/售后服务/技术支持");
    jobCata.put("1214","投诉处理");
    jobCata.put("1215","销售/客服类其他相关职位");
    jobCata.put("1300","电子/通讯类");
    jobCata.put("1301","电子工程师");
    jobCata.put("1302","通信工程师/通讯工程师");
    jobCata.put("1303","产品研发工程师");
    jobCata.put("1304","PCB工程师");
    jobCata.put("1305","测试工程师");
    jobCata.put("1306","自动控制");
    jobCata.put("1307","变压器/磁电工程师");
    jobCata.put("1308","电声工程师");
    jobCata.put("1309","数码产品开发工程师");
    jobCata.put("1310","单片机/DSP/底层软件");
    jobCata.put("1311","无线电技术");
    jobCata.put("1312","半导体技术");
    jobCata.put("1313","ARM开发工程师");
    jobCata.put("1314","MCU底层开发工程师");
    jobCata.put("1315","电池/电源开发工程师");
    jobCata.put("1316","FAE工程师");
    jobCata.put("1317","电子/通讯类其他相关职位");
    jobCata.put("1400","电器/电气类");
    jobCata.put("1401","电气工程师");
    jobCata.put("1402","电器工程师");
    jobCata.put("1403","家用电器研发");
    jobCata.put("1404","家用电器/小家电");
    jobCata.put("1405","灯饰研发工程师");
    jobCata.put("1406","电气/电子/电器维修");
    jobCata.put("1407","智能大厦/综合布线/弱电");
    jobCata.put("1408","光源与照明工程");
    jobCata.put("1409","电器/电气类其他相关职位");
    jobCata.put("1500","机械（电）/仪表类");
    jobCata.put("1501","机械设计与制造");
    jobCata.put("1502","机械工程师");
    jobCata.put("1503","模具工程师");
    jobCata.put("1504","结构设计师");
    jobCata.put("1505","机电一体化");
    jobCata.put("1506","注塑工程师");
    jobCata.put("1507","CAM/CNC工程师");
    jobCata.put("1508","机械制图");
    jobCata.put("1509","电镀/热处理");
    jobCata.put("1510","机械工艺师");
    jobCata.put("1511","汽车/摩托车工程师");
    jobCata.put("1512","纺织/船舶/食品/化工机械");
    jobCata.put("1513","锅炉/压力容器");
    jobCata.put("1514","焊接工程师");
    jobCata.put("1515","刀具工程师");
    jobCata.put("1516","五金矿产/金属制品");
    jobCata.put("1517","气动/液压");
    jobCata.put("1518","精密机械/仪器仪表");
    jobCata.put("1519","铸造工程师");
    jobCata.put("1520","设备维修");
    jobCata.put("1521","机械（电）/仪表类其他相关职位");
    jobCata.put("1600","工业/工厂类");
    jobCata.put("1601","生产经理");
    jobCata.put("1602","R&D经理");
    jobCata.put("1603","工程经理/主管");
    jobCata.put("1604","品质管理");
    jobCata.put("1605","物控管理");
    jobCata.put("1606","采购管理");
    jobCata.put("1607","设备经理/主管");
    jobCata.put("1608","ME工程师");
    jobCata.put("1609","制造课长");
    jobCata.put("1610","SMT工程师/技术员");
    jobCata.put("1611","工艺工程师");
    jobCata.put("1612","PE工程师/产品开发");
    jobCata.put("1613","IE工程师");
    jobCata.put("1614","ISO专员");
    jobCata.put("1615","生管主管/督导");
    jobCata.put("1616","工程设备工程师");
    jobCata.put("1617","计划员/调度员");
    jobCata.put("1618","生管员");
    jobCata.put("1619","跟单员");
    jobCata.put("1620","仓库管理");
    jobCata.put("1621","统计员");
    jobCata.put("1622","安全主任");
    jobCata.put("1623","化验/检验员");
    jobCata.put("1624","储备干部");
    jobCata.put("1625","组长/拉长");
    jobCata.put("1626","工业/工厂类其他相关职位");
    jobCata.put("1700","市场营销/公关/广告类");
    jobCata.put("1701","市场/营销总监");
    jobCata.put("1702","市场/营销经理/主管");
    jobCata.put("1703","市场助理/专员");
    jobCata.put("1704","市场调研/业务分析");
    jobCata.put("1705","市场/行销企划");
    jobCata.put("1706","产品/品牌经理/主管");
    jobCata.put("1707","产品/品牌企划");
    jobCata.put("1708","广告企划");
    jobCata.put("1709","新闻媒介企划");
    jobCata.put("1710","市场推广/拓展/合作");
    jobCata.put("1711","价格企划");
    jobCata.put("1712","客户经理");
    jobCata.put("1713","公关经理/专员");
    jobCata.put("1714","广告设计/创意策划");
    jobCata.put("1715","文案策划");
    jobCata.put("1716","广告制作");
    jobCata.put("1717","市场营销/公关/广告类其他相关职位");
    jobCata.put("1800","行政/人事类");
    jobCata.put("1801","行政经理/主管");
    jobCata.put("1802","行政助理/文员");
    jobCata.put("1803","人事经理/主管");
    jobCata.put("1804","人事助理/文员");
    jobCata.put("1805","办公室主任");
    jobCata.put("1806","总务");
    jobCata.put("1807","招聘经理/主管/专员");
    jobCata.put("1808","培训经理/主管/专员");
    jobCata.put("1809","薪资福利经理/主管/专员");
    jobCata.put("1810","绩效考核经理/主管/专员");
    jobCata.put("1811","企业文化专员");
    jobCata.put("1812","行政/人事类其他相关职位");
    jobCata.put("1900","物流/贸易/采购类");
    jobCata.put("1901","物流经理/主管");
    jobCata.put("1902","仓储经理/主管");
    jobCata.put("1903","仓库管理");
    jobCata.put("1904","货运经理/主管");
    jobCata.put("1905","采购经理/主管");
    jobCata.put("1906","国际贸易");
    jobCata.put("1907","报关员");
    jobCata.put("1908","采购员");
    jobCata.put("1909","船务");
    jobCata.put("1910","单证员");
    jobCata.put("1911","快递员");
    jobCata.put("1912","物流操作员");
    jobCata.put("1913","外销员");
    jobCata.put("1914","验货员/送货员/押运员");
    jobCata.put("1915","物流/贸易/采购类其他相关职位");
    jobCata.put("2000","财务/审（统）计类");
    jobCata.put("2001","财务经理/主管");
    jobCata.put("2002","会计");
    jobCata.put("2003","成本会计");
    jobCata.put("2004","审计");
    jobCata.put("2005","会计助理/出纳");
    jobCata.put("2006","帐目（进出口）管理");
    jobCata.put("2007","注册会计师");
    jobCata.put("2008","注册审计师");
    jobCata.put("2009","财务分析");
    jobCata.put("2010","统计");
    jobCata.put("2011","财务/审（统）计类其他相关职位");
    jobCata.put("2100","翻译类");
    jobCata.put("2101","英语翻译");
    jobCata.put("2102","日语翻译");
    jobCata.put("2103","法语翻译");
    jobCata.put("2104","德语翻译");
    jobCata.put("2105","韩语翻译");
    jobCata.put("2106","俄语翻译");
    jobCata.put("2107","意大利语翻译");
    jobCata.put("2108","阿拉伯语翻译");
    jobCata.put("2109","西班牙语翻译");
    jobCata.put("2110","翻译类其他相关职位");
    jobCata.put("2200","房地产/建筑施工类");
    jobCata.put("2201","建筑工程师");
    jobCata.put("2202","结构/土建工程师");
    jobCata.put("2203","建筑制图");
    jobCata.put("2204","工程项目经理");
    jobCata.put("2205","工程监理");
    jobCata.put("2206","房地产开发/策划");
    jobCata.put("2207","房地产评估");
    jobCata.put("2208","造价师/工程预决算");
    jobCata.put("2209","建筑施工管理");
    jobCata.put("2210","物业管理");
    jobCata.put("2211","房地产中介/经纪");
    jobCata.put("2212","室内外装潢设计");
    jobCata.put("2213","管道（水、电）");
    jobCata.put("2214","给排水/暖通工程师");
    jobCata.put("2215","路桥工程");
    jobCata.put("2216","隧道/港口/航道");
    jobCata.put("2217","园艺工程/园林技术");
    jobCata.put("2218","注册建筑师");
    jobCata.put("2219","工民建");
    jobCata.put("2220","施工员");
    jobCata.put("2221","基建/岩土工程");
    jobCata.put("2222","房地产/建筑施工类其他相关职位");
    jobCata.put("2300","公司文职类");
    jobCata.put("2301","文员/高级文员");
    jobCata.put("2302","秘书/高级秘书");
    jobCata.put("2303","前台文员接待");
    jobCata.put("2304","电脑操作员/打字员");
    jobCata.put("2305","总机/话务员");
    jobCata.put("2306","文案策划/资料编写");
    jobCata.put("2307","图书情报/档案管理");
    jobCata.put("2308","公司文职类其他相关职位");
    jobCata.put("2400","金融/保险/证券类");
    jobCata.put("2401","证券/股票/期货");
    jobCata.put("2402","金融投资分析");
    jobCata.put("2403","投资顾问");
    jobCata.put("2404","保险经纪");
    jobCata.put("2405","税务专员");
    jobCata.put("2406","评估师");
    jobCata.put("2407","信贷/信用调查分析");
    jobCata.put("2408","融资经理/主管");
    jobCata.put("2409","银行出纳");
    jobCata.put("2410","预结算专员");
    jobCata.put("2411","炒股操盘手");
    jobCata.put("2412","证券经纪人");
    jobCata.put("2413","注册分析师");
    jobCata.put("2414","外汇主管");
    jobCata.put("2415","投资/基金项目经理");
    jobCata.put("2416","金融/保险/证券类其他相关职位");
    jobCata.put("2500","服装/鞋帽/皮具类");
    jobCata.put("2501","服装设计师");
    jobCata.put("2502","手袋设计");
    jobCata.put("2503","皮具开发设计");
    jobCata.put("2504","染整工程师");
    jobCata.put("2505","制版师");
    jobCata.put("2506","专卖店/加盟店管理");
    jobCata.put("2507","陈列展示");
    jobCata.put("2508","纸样师");
    jobCata.put("2509","市场督导/调查");
    jobCata.put("2510","制鞋");
    jobCata.put("2511","跟单员");
    jobCata.put("2512","调色员");
    jobCata.put("2513","面辅料采购");
    jobCata.put("2514","计量员");
    jobCata.put("2515","打版师");
    jobCata.put("2516","机织车缝工艺员");
    jobCata.put("2517","服装/鞋帽/皮具类其他相关职位");
    jobCata.put("2600","设计类");
    jobCata.put("2601","产品设计");
    jobCata.put("2602","工艺品设计");
    jobCata.put("2603","平面设计");
    jobCata.put("2604","艺术设计");
    jobCata.put("2605","玩具设计");
    jobCata.put("2606","家具设计");
    jobCata.put("2607","珠宝设计");
    jobCata.put("2608","游戏设计");
    jobCata.put("2609","三维动画设计");
    jobCata.put("2610","多媒体设计与制作");
    jobCata.put("2611","工业产品设计");
    jobCata.put("2612","形象设计");
    jobCata.put("2613","设计类其他相关职位");
    jobCata.put("2700","化工/制药类");
    jobCata.put("2701","日用化工");
    jobCata.put("2702","生物化工/制药");
    jobCata.put("2703","精细化工");
    jobCata.put("2704","高分子化工/化纤/新材料");
    jobCata.put("2705","化学药剂/药品");
    jobCata.put("2706","电镀化工");
    jobCata.put("2707","无机化工");
    jobCata.put("2708","有机化工");
    jobCata.put("2709","农药、化肥");
    jobCata.put("2710","分析化工");
    jobCata.put("2711","造纸/废品处理");
    jobCata.put("2712","玻璃/硅酸盐工业");
    jobCata.put("2713","化工/制药类其他相关职位");
    jobCata.put("2800","法律专业人员类");
    jobCata.put("2801","律师");
    jobCata.put("2802","法律顾问");
    jobCata.put("2803","法务人员/助理");
    jobCata.put("2804","律师助理");
    jobCata.put("2805","知识产权");
    jobCata.put("2806","书记员");
    jobCata.put("2807","法律专业人员类其他相关职位");
    jobCata.put("2900","轻工业类");
    jobCata.put("2901","印刷/染整技术");
    jobCata.put("2902","纸浆造纸工艺");
    jobCata.put("2903","食品工程/糖酒饮料/粮油");
    jobCata.put("2904","陶瓷技术");
    jobCata.put("2905","金银首饰加工");
    jobCata.put("2906","轻工业类其他相关职位");
    jobCata.put("3000","卫生医疗/保健类");
    jobCata.put("3001","医生（中、西）/医师");
    jobCata.put("3002","牙科医生");
    jobCata.put("3003","内（外）科医生");
    jobCata.put("3004","预防医生");
    jobCata.put("3005","儿科医生");
    jobCata.put("3006","心理医生");
    jobCata.put("3007","护士/护理");
    jobCata.put("3008","药剂/中药/西药/药检");
    jobCata.put("3009","针灸推拿");
    jobCata.put("3010","临床医学");
    jobCata.put("3011","妇幼保健");
    jobCata.put("3012","卫生防预");
    jobCata.put("3013","医药检验");
    jobCata.put("3014","兽医/宠物医生");
    jobCata.put("3015","麻醉师");
    jobCata.put("3016","妇产科医生");
    jobCata.put("3017","保健/健美");
    jobCata.put("3018","卫生医疗/保健类其他相关职位");
    jobCata.put("3100","咨询/顾问类");
    jobCata.put("3101","企划顾问");
    jobCata.put("3102","企管顾问");
    jobCata.put("3103","猎头顾问");
    jobCata.put("3104","咨询总监");
    jobCata.put("3105","咨询经理");
    jobCata.put("3106","涉外咨询师");
    jobCata.put("3107","咨询员");
    jobCata.put("3108","信息中介");
    jobCata.put("3109","专业顾问");
    jobCata.put("3110","咨询/顾问类其他相关职位");
    jobCata.put("3200","文体/教育/培训类");
    jobCata.put("3201","教务/教学管理人员");
    jobCata.put("3202","正、副教授/助教");
    jobCata.put("3203","讲师");
    jobCata.put("3204","高校教师");
    jobCata.put("3205","外籍教师");
    jobCata.put("3206","小学老师");
    jobCata.put("3207","幼师");
    jobCata.put("3208","职业教育/培训教师");
    jobCata.put("3209","教材编辑");
    jobCata.put("3210","竞技/体育教练");
    jobCata.put("3211","驾驶教练");
    jobCata.put("3212","家教");
    jobCata.put("3213","文体/教育/培训类其他相关职位");
    jobCata.put("3300","能源动力类");
    jobCata.put("3301","水利、水电");
    jobCata.put("3302","核电、火电");
    jobCata.put("3303","电厂、电力");
    jobCata.put("3304","制冷、通暖");
    jobCata.put("3305","空调、锅炉");
    jobCata.put("3306","石油/天然气/储运");
    jobCata.put("3307","城市燃气");
    jobCata.put("3308","能源动力类其他相关职位");
    jobCata.put("3400","广播/影视/摄影类");
    jobCata.put("3401","主持人/播音员/DJ");
    jobCata.put("3402","电视记者/编导");
    jobCata.put("3403","剪接师");
    jobCata.put("3404","导演");
    jobCata.put("3405","影视策划/制作人员");
    jobCata.put("3406","摄影师");
    jobCata.put("3407","音效师");
    jobCata.put("3408","影音器材管理");
    jobCata.put("3409","演艺人员");
    jobCata.put("3410","模特儿");
    jobCata.put("3411","化妆师");
    jobCata.put("3412","舞台设计/舞美");
    jobCata.put("3413","广播/影视/摄影类其他相关职位");
    jobCata.put("3500","新闻/出版/发行类");
    jobCata.put("3501","文字/摄影记者");
    jobCata.put("3502","总编/副总编");
    jobCata.put("3503","编辑主任");
    jobCata.put("3504","编辑");
    jobCata.put("3505","美术编辑");
    jobCata.put("3506","排版/校对");
    jobCata.put("3507","发行主管");
    jobCata.put("3508","发行助理");
    jobCata.put("3509","新闻/出版/发行类其他相关职位");
    jobCata.put("3600","宾馆饭店/餐饮旅游类");
    jobCata.put("3601","酒店管理");
    jobCata.put("3602","大堂经理/副理");
    jobCata.put("3603","楼面经理/主任");
    jobCata.put("3604","客房主管/文员");
    jobCata.put("3605","餐饮经理/主管");
    jobCata.put("3606","公关主任");
    jobCata.put("3607","培训主任");
    jobCata.put("3608","外联/计调（旅行社）");
    jobCata.put("3609","导游");
    jobCata.put("3610","部长/领班/服务员");
    jobCata.put("3611","康乐/宴会/娱乐");
    jobCata.put("3612","厨师/厨工/点心师");
    jobCata.put("3613","调酒师");
    jobCata.put("3614","美容/技师/足浴");
    jobCata.put("3615","前台/接待/礼仪");
    jobCata.put("3616","咨客");
    jobCata.put("3617","宾馆饭店/餐饮旅游类其他相关职位");
    jobCata.put("3700","超市/商店/零售类");
    jobCata.put("3701","店长");
    jobCata.put("3702","营销主管");
    jobCata.put("3703","生鲜/干（杂）货管理");
    jobCata.put("3704","防损管理");
    jobCata.put("3705","货品配送");
    jobCata.put("3706","营业员/服务员/店员");
    jobCata.put("3707","导购员");
    jobCata.put("3708","收银员");
    jobCata.put("3709","理货员");
    jobCata.put("3710","超市/商店/零售类其他相关职位");
    jobCata.put("3800","后勤保障类");
    jobCata.put("3801","保安");
    jobCata.put("3802","司机");
    jobCata.put("3803","搬运");
    jobCata.put("3804","寻呼/声讯");
    jobCata.put("3805","社区服务");
    jobCata.put("3806","清洁工/后勤");
    jobCata.put("3807","食堂厨师");
    jobCata.put("3808","保姆/钟点工");
    jobCata.put("3809","后勤保障类其他相关职位");
    jobCata.put("3900","技工/普工类");
    jobCata.put("3901","钳工、机修工、钣金工");
    jobCata.put("3902","电焊工、铆焊工");
    jobCata.put("3903","车工、磨床、铣工、冲床、锣床、车床");
    jobCata.put("3904","模具工");
    jobCata.put("3905","水工、木工、油漆工");
    jobCata.put("3906","电工");
    jobCata.put("3907","空调工、电梯工、锅炉工");
    jobCata.put("3908","铲车工、叉车工");
    jobCata.put("3909","裁、剪、车、缝、熨、烫");
    jobCata.put("3910","技师");
    jobCata.put("3911","普工");
    jobCata.put("3912","技工/普工类其他相关职位");
    jobCata.put("4000","其他类");
    jobCata.put("4001","声光技术");
    jobCata.put("4002","生物技术");
    jobCata.put("4003","测绘技术");
    jobCata.put("4004","激光技术");
    jobCata.put("4005","地质勘探");
    jobCata.put("4006","矿产冶金");
    jobCata.put("4007","环境工程");
    jobCata.put("4008","市政建设/城市规划");
    jobCata.put("4009","农、林、牧、副、渔");
    jobCata.put("4010","其他类其他相关职位");

    jobCata.put("5000","模具类");
    jobCata.put("5001","塑胶模设计师/工程师");
    jobCata.put("5002","五金模设计师/工程师");
    jobCata.put("5003","塑胶模师傅/普师/补师");
    jobCata.put("5004","五金模师傅/普师/补师");
    jobCata.put("5005","塑胶模经理/主管");
    jobCata.put("5006","五金模经理/主管");
    jobCata.put("5007","跟模/试模/校模");
    jobCata.put("5008","省模/组模/修模");
    jobCata.put("5009","CNC/编程");
    jobCata.put("5010","快走丝/慢走丝/线切割");
    jobCata.put("5011","铣床/磨床/钻床");
    jobCata.put("5012","冲床/车床/火花机");
    jobCata.put("5013","模具QC/品管/品保");
    jobCata.put("5014","模具类其他职务");

    jobCata.put("5100","印刷、包装、纸品类");
    jobCata.put("5101","单色机长");
    jobCata.put("5102","罗兰机机长");
    jobCata.put("5103","单色机长");
    jobCata.put("5104","印刷工程师");
    jobCata.put("5105","折页机长");
    jobCata.put("5106","过胶机机长");
    jobCata.put("5107","切纸机机长");
    jobCata.put("5108","啤机机长");
    jobCata.put("5109","UV机机长");
    jobCata.put("5110","纸闸机机长");
    jobCata.put("5111","骑马钉机长");
    jobCata.put("5112","排书机机长");
    jobCata.put("5113","工艺开单员/工艺工程师");
    jobCata.put("5114","设计制版/排版/组版");
    jobCata.put("5115","凹版印刷技术员");
    jobCata.put("5116","丝印机长/主管");
    jobCata.put("5117","菲林输出");
    jobCata.put("5118","水印印刷");
    jobCata.put("5119","晒版技工");
    jobCata.put("5120","单面/双面瓦楞纸机长");
    jobCata.put("5121","制浆造纸工程师");
    jobCata.put("5122","裱纸/分纸/印唛/烫金");
    jobCata.put("5123","打稿师傅");
    
    
//  外语水平
    langLvl.put(1,"熟练");
    langLvl.put(2,"精通");
    langLvl.put(3,"良好");
    langLvl.put(4,"一般");
    langLvl.put(1001,"大学英语等级考试CET-4");
    langLvl.put(1002,"大学英语等级考试CET-6");
    langLvl.put(1003,"英语专业4级");
    langLvl.put(1004,"英语专业8级");
    langLvl.put(1005,"全国英语等级考试PETS-1初始级");
    langLvl.put(1006,"全国英语等级考试PETS-2中下级");
    langLvl.put(1007,"全国英语等级考试PETS-3中间级");
    langLvl.put(1008,"全国英语等级考试PETS-4中上级");
    langLvl.put(1009,"全国英语等级考试PETS-5最高级");
    langLvl.put(1010,"托福");
    langLvl.put(1011,"GRE");
    langLvl.put(1012,"GMAT");
    langLvl.put(1013,"雅思");;
    langLvl.put(1014,"剑桥商务英语证书1级");
    langLvl.put(1015,"剑桥商务英语证书2级");
    langLvl.put(1016,"剑桥商务英语证书3级");
    langLvl.put(1017,"剑桥英语入门考试");
    langLvl.put(1018,"剑桥初级英语考试");
    langLvl.put(1019,"剑桥第一英语证书考试");
    langLvl.put(1020,"中级口译证书");
    langLvl.put(1021,"高级口译证书");
    
    langLvl.put(1401,"俄语四级证书");
    langLvl.put(1402,"俄语六级证书");
    
    langLvl.put(1201,"法语四级证书");
    langLvl.put(1202,"法语六级证书");
    
    langLvl.put(1101,"日语一级证书");
    langLvl.put(1102,"日语二级证书");
    langLvl.put(1103,"日语三级证书");
    langLvl.put(1104,"日语四级证书");

    langLvl.put(1301,"德语四级证书");
    langLvl.put(1302,"德语六级证书"); 
    

    
    //外语名称
    langType.put(1000,"英语");
    langType.put(1100,"日语");
    langType.put(1200,"法语");
    langType.put(1300,"德语");
    langType.put(1400,"俄语");
    langType.put(1500,"韩语");
    langType.put(1600,"西班牙语");
    langType.put(1700,"葡萄牙语");
    langType.put(1800,"阿拉伯语");
    langType.put(1900,"意大利语");
    langType.put(2000,"普通话");
    langType.put(2100,"粤语");
    langType.put(2200,"上海话");
    langType.put(2300,"闽南话");
    langType.put(2400,"其他");
    
    //普通话和粤语
    cantLvl.put(1,"熟练");
    cantLvl.put(2,"精通");
    cantLvl.put(3,"良好");
    cantLvl.put(4,"一般");
    
    //随时到岗
    comeon.put(1,"随时到岗");
    comeon.put(2,"3天内");
    comeon.put(3,"1周内");
    comeon.put(4,"1个月内");
    comeon.put(5,"1—3个月");
    comeon.put(6,"半年内");
    
    //计算机水平
    computerLvl.put(0,"一般");
    computerLvl.put(1,"良好");
    computerLvl.put(2,"熟练");
    computerLvl.put(3,"全国计算机等级考试一级");
    computerLvl.put(4,"全国计算机等级考试二级");
    computerLvl.put(5,"全国计算机等级考试三级");
    computerLvl.put(6,"全国计算机等级考试四级");
    computerLvl.put(7,"全国计算机应用技术证书（NIT）");
    computerLvl.put(8,"计算机软件专业技术资格和水平考试");
    computerLvl.put(9,"初级：程序员");
    computerLvl.put(10,"网络管理员");
    computerLvl.put(11,"中级：软件设计师");
    computerLvl.put(12,"网络工程师");
    computerLvl.put(13,"软件评测师");
    computerLvl.put(14,"多媒体应用设计师");
    computerLvl.put(15,"信息系统监理师");
    computerLvl.put(16,"高级：系统分析师");
    computerLvl.put(17,"信息系统项目管理师");
    computerLvl.put(18,"微软认证产品专家{MCP}");
    computerLvl.put(19,"微软认证系统工程师{MCSE}");
    computerLvl.put(20,"微软认证数据库管理员{MCDBA}");
    computerLvl.put(21,"微软认证软件开发专家（MCSD）");
    computerLvl.put(22,"Adobe中国认证专业平面设计师");
    computerLvl.put(23,"Adobe中国认证网页设计师");
    computerLvl.put(24,"Adobe中国认证数码视频设计师");
    computerLvl.put(25,"Adobe中国认证商务出版设计师");
    computerLvl.put(26,"Cisco职业资格认证CCNA");
    computerLvl.put(27,"Cisco职业资格认证CCNP");
    computerLvl.put(28,"Cisco职业资格认证CCIE");
    computerLvl.put(29,"Cisco职业资格认证CCDA");
    computerLvl.put(30,"Cisco职业资格认证CCDP");
    computerLvl.put(31,"Lotus-CLS资格认证");
    computerLvl.put(32,"Lotus-CLP资格认证");
    computerLvl.put(33,"Lotus-CLI资格认证");
    computerLvl.put(34,"Notes应用开发工程师");
    computerLvl.put(35,"Notes系统管理工程师");
    computerLvl.put(36,"Notes高级应用开发工程师");
    computerLvl.put(37,"Notes高级系统管理工程师");
    computerLvl.put(38,"IBM-BD2数据库管理员");
    computerLvl.put(39,"IBM-BD2应用开发专家");
    computerLvl.put(40,"IBM-MQSeries工程师");
    computerLvl.put(41,"Oracle8数据库管理员");
    
    //公司性质
    companyType.put(1,"外商独资·外企办事处");
    companyType.put(2,"中外合营（合资、合作）");
    companyType.put(3,"台资企业");
    companyType.put(4,"港资企业");
    companyType.put(5,"私营·民营企业");
    companyType.put(6,"股份制企业");
    companyType.put(7,"跨国公司（集团）");
    companyType.put(8,"国有企业");
    companyType.put(9,"事业单位");
    companyType.put(10,"社会团体");
    companyType.put(11,"政府机关");
    companyType.put(12,"日资企业");
    companyType.put(13,"韩资企业");
    companyType.put(14,"美资企业");
    companyType.put(20,"其他");    //预留
    
    //行业名称
    companyCata.put(1,"互联网·电子商务");
    companyCata.put(2,"计算机业（软件、数据库、系统集成）");
    companyCata.put(3,"计算机业（硬件、网络设备）");
    companyCata.put(4,"电子·微电子技术");
    companyCata.put(5,"通讯·电信业");
    companyCata.put(6,"快速消费品（饮料、食品、烟酒、日化等）");
    companyCata.put(7,"纺织品业（服饰、鞋帽、家纺用品、皮具等）");
    companyCata.put(8,"金融业（银行、保险、证券、投资、基金）");
    companyCata.put(9,"家电·电器·电气");
    companyCata.put(10,"贸易·商务·进出口");
    companyCata.put(11,"生产·制造·加工");
    companyCata.put(12,"建筑·房地产·物业管理·装潢");
    companyCata.put(13,"机械制造·机电设备·重工业");
    companyCata.put(14,"交通·运输·物流·快递");
    companyCata.put(15,"广告·公关·设计");
    companyCata.put(16,"批发·零售（超市、百货、商场、专卖店）");
    companyCata.put(17,"汽车·摩托车");
    companyCata.put(18,"仪器仪表·电工设备");
    companyCata.put(19,"制药·生物工程·环保");
    companyCata.put(20,"餐饮·酒店·旅游");
    companyCata.put(21,"塑胶·五金");
    companyCata.put(22,"印刷·包装·造纸");
    companyCata.put(23,"电力·能源·矿产");
    companyCata.put(24,"石油·化工业");
    companyCata.put(25,"办公设备·文体休闲用品·家居用品");
    companyCata.put(26,"法律");
    companyCata.put(27,"媒体·影视制作·新闻出版");
    companyCata.put(28,"艺术·文化传播");
    companyCata.put(29,"娱乐·体育·休闲");
    companyCata.put(30,"教育·培训·科研院所");
    companyCata.put(31,"顾问·咨询");
    companyCata.put(32,"医疗·保健·卫生服务");
    companyCata.put(33,"人才交流·中介");
    companyCata.put(34,"政府·公用事业·社区服务");
    companyCata.put(35,"农、林、牧、副、渔业");
    companyCata.put(36,"协会·社团·非营利机构");
    companyCata.put(37,"其他");
  };
  
  /**根据值进行查询对应的汉字<br>
   * 如知道编号1011的地址，要查询其对应的地址：北京<br>
   * @param value-当前项的值
   * @param option-当前option
   * */
  public static String getNameByValue(Object value,Object option)
  {
  	if (value==null) return "";
  	try{
	    HashMap map = (HashMap) allKeyMap.get(String.valueOf(option));
	    if(map.containsKey(value.toString())){
		    String s=(String)map.get(value.toString());
		    return s;
	    }else if(map.containsKey(Integer.parseInt(value.toString()))){
		    String s=(String)map.get(Integer.parseInt(value.toString()));
		    return s;
	    }
	    	return "";
  	}catch(Exception ex){
  		return "";
  	}
  }
  
}
