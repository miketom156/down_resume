package com.job5156.util;

import java.util.GregorianCalendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Calendar;
import java.util.StringTokenizer;

/**
 * <p>Title: 日期时间处理</p>
 * <p>Description: 工具类</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: www.joauthor <a href="mailto:lzjliu307@sohu.com">Lzj.Liu</a>
 * @version 1.0
 */
public class DateUtil
{
    private static DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.SIMPLIFIED_CHINESE);

    private DateUtil()
    {
    }
    public static String getNowTime()
    {
        GregorianCalendar gcNow = new GregorianCalendar();
        java.util.Date dNow = gcNow.getTime();
        DateFormat df = DateFormat.getTimeInstance(DateFormat.MEDIUM, Locale.SIMPLIFIED_CHINESE);
        return df.format(dNow);
    }

    public static String getNowDate()
    {
        GregorianCalendar gcNow = new GregorianCalendar();
        java.util.Date dNow = gcNow.getTime();
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.SIMPLIFIED_CHINESE);
        return df.format(dNow);
    }

    public static String getNowDateTime()
    {
        GregorianCalendar gcNow = new GregorianCalendar();
        java.util.Date dNow = gcNow.getTime();
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.SIMPLIFIED_CHINESE);
        return df.format(dNow);
    }

    public static int getThisYear()
    {
        GregorianCalendar gcNow = new GregorianCalendar();
        return gcNow.get(GregorianCalendar.YEAR);
    }

    public static int getThisMonth()
    {
        GregorianCalendar gcNow = new GregorianCalendar();
        return gcNow.get(GregorianCalendar.MONTH) + 1;
    }

    public static int getToDayOfMonth()
    {
        GregorianCalendar gcNow = new GregorianCalendar();
        return gcNow.get(GregorianCalendar.DAY_OF_MONTH);
    }

    /**返当前时间字符串yyyy-mm-dd HH:mm:ss*/
    public static String todayString(){
        return formatSDate(new Date(System.currentTimeMillis()));
    }
    
    public static String formatDate(java.util.Date date)
    {
        if (date == null) return "";
        else return df.format(date);
    }

    public static String formatSDate(java.util.Date date)
    {
        if (date == null) return "";
        else
        {
            SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-M-d HH:mm:ss");
            return bartDateFormat.format(date);
        }
    }
    
    public static String formatMMDate(java.util.Date date)
    {
        if (date == null) return "";
        else
        {
            SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return bartDateFormat.format(date);
        }
    }
    
    public static String formatMDate(java.util.Date date)
    {
        if (date == null) return "";
        else
        {
            SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyyMdHHmmss");
            return bartDateFormat.format(date);
        }
    }
    
    public static String formatHDate(java.util.Date date)
    {
        if (date == null) return "";
        else
        {
            SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyyMMddHH");
            return bartDateFormat.format(date);
        }
    }

    public static Date getDate()
    {
    	    java.util.Date date=new Date();
            SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-M-d");
            String datestr=bartDateFormat.format(date);
            try
            {
            date = bartDateFormat.parse(datestr.trim());
            }
            catch(Exception e)
            {
            	System.out.println("turn dateformat find error:"+e.getMessage());
            }
            return date;
    }
    public static String dateAdd(String interval, int number,
            java.util.Date date)
    {
        String strTmp = "";
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        
        if (interval.equals("y"))
        {
            int currYear = gc.get(Calendar.YEAR);
            gc.set(Calendar.YEAR, currYear + number);
        }
        
        else if (interval.equals("m"))
        {
            int currMonth = gc.get(Calendar.MONTH);
            gc.set(Calendar.MONTH, currMonth + number);
        }
        
        else if (interval.equals("d"))
        {
            int currDay = gc.get(Calendar.DATE);
            gc.set(Calendar.DATE, currDay + number);
        }
        
        else if (interval.equals("h"))
        {
            int currDay = gc.get(Calendar.HOUR);
            gc.set(Calendar.HOUR, currDay + number);
        }
        SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-M-d HH:mm:ss");
        strTmp = bartDateFormat.format(gc.getTime());
        return strTmp;
    }
    
    public static String dateSAdd(String interval, int number,
            java.util.Date date)
    {
        String strTmp = "";
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        
        if (interval.equals("y"))
        {
            int currYear = gc.get(Calendar.YEAR);
            gc.set(Calendar.YEAR, currYear + number);
        }
        
        else if (interval.equals("m"))
        {
            int currMonth = gc.get(Calendar.MONTH);
            gc.set(Calendar.MONTH, currMonth + number);
        }
        
        else if (interval.equals("d"))
        {
            int currDay = gc.get(Calendar.DATE);
            gc.set(Calendar.DATE, currDay + number);
        }
        
        strTmp = df.format(gc.getTime());
        return strTmp;
    }

    public static int dateDiff(java.util.Date a, java.util.Date b)
    {
        int tempDifference = 0;
        int difference = 0;
        Calendar earlier = Calendar.getInstance();
        Calendar later = Calendar.getInstance();

        if (a.compareTo(b) < 0)
        {
            earlier.setTime(a);
            later.setTime(b);
        }
        else
        {
            earlier.setTime(b);
            later.setTime(a);
        }

        while (earlier.get(Calendar.YEAR) != later.get(Calendar.YEAR))
        {
            tempDifference = 365 * (later.get(Calendar.YEAR) - earlier.get(Calendar.YEAR));
            difference += tempDifference;

            earlier.add(Calendar.DAY_OF_YEAR, tempDifference);
        }

        if (earlier.get(Calendar.DAY_OF_YEAR) != later.get(Calendar.DAY_OF_YEAR))
        {
            tempDifference = later.get(Calendar.DAY_OF_YEAR)
                    - earlier.get(Calendar.DAY_OF_YEAR);
            difference += tempDifference;

            earlier.add(Calendar.DAY_OF_YEAR, tempDifference);
        }

        return difference;
    }

    public static String getDate(int i)
    {
        Calendar tt = Calendar.getInstance();
        int result = tt.get(Calendar.DAY_OF_WEEK);
        int day1 = 0;
        switch (result)
        {
            case 2: //Monday
                day1 = 4;
                break;
            case 3: //Tuesday
                day1 = 3;
                break;
            case 4: //Wednesday
                day1 = 2;
                break;
            case 5: //Thursday
                day1 = 1;
                break;
            case 6: //Friday
                day1 = 0;
                break;
            case 7: //Saturday
                day1 = 6;
                break;
            case 1: //sunday
                day1 = 5;
                break;
        }

        String getDate = dateSAdd("d", (day1+i), new Date());
        return getDate;
    }

    public static String checkTime(int id)
    {
        String bol = "";
        Calendar tt = Calendar.getInstance();
        int result = tt.get(Calendar.DAY_OF_WEEK);
        Date sdate = new Date();
        int shour = tt.get(Calendar.HOUR_OF_DAY);
        
        if (id == 3)
        {
            switch (result)
            {
                case 1:
                    break;
                case 7:
                    if ((shour >= 9) && (shour < 12))
                    {
                        bol = "disabled";
                        break;
                    }
                default:
                    if ((shour >= 9) && (shour < 12))
                    {
                        bol = "disabled";
                        break;
                    }
                    else if ((shour >= 14) && (shour < 17))
                    {
                        bol = "disabled";
                        break;
                    }
            }
        }
        return bol;
    }
    
    public static String checkIpViewTime(int id)
    {
        String bol = "";
        Calendar tt = Calendar.getInstance();
        int result = tt.get(Calendar.DAY_OF_WEEK);
        Date sdate = new Date();
        int shour = tt.get(Calendar.HOUR_OF_DAY);
        //System.out.println("&&&"+shour);
        
        if (id != 1)
        {

           bol = "disabled";

        }
        return bol;
    }
    public static void main(String []agrs)
    {
        System.out.println(DateUtil.getNowDate());
        System.out.println(DateUtil.getNowDateTime());
        System.out.println(DateUtil.getNowTime());
        try
        {
	        SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-M-d HH:mm:ss");
	        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.SIMPLIFIED_CHINESE);
	        Date d1 = bartDateFormat.parse("2003-5-8");//df.parse("2006-4-21");
	        System.out.println(dateDiff(new Date(),d1));
        }
        catch(Exception ex)
        {
        	
        }
    }
	/**
	 * 将字符串转化为日期（java.util.Date）
	 * 字符串格式要求为 yyyy-MM-dd hh:mm:ss
	 * **/
	public static Date string2Date(String str) throws Exception {
		int year, month, day, hour, minute, second;
		String s1 = str.substring(0, str.indexOf(" "));
		String s2 = str.substring(str.indexOf(" ") + 1);

		StringTokenizer st = new StringTokenizer(s1, "-");
		year = Integer.parseInt(st.nextToken());
		month = Integer.parseInt(st.nextToken());
		day = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(s2, ":");
		hour = Integer.parseInt(st.nextToken());
		minute = Integer.parseInt(st.nextToken());
		second = 0;
		try{
			String secondString = st.nextToken();
			if(secondString.endsWith(".0"))secondString = secondString.substring(0,secondString.length()-2);
			second = Integer.parseInt(secondString);
		}
		catch(Exception e){
			second = 0;
		}

		Calendar c = Calendar.getInstance();
		c.set(year, month - 1, day, hour, minute, second);

		return c.getTime();
	}
	

	/**
	 * 将字符串转化为日期（java.util.Date）
	 * 字符串格式要求为 yyyy-MM-dd hh:mm:ss
	 * 转化为yyy-MM-dd的util日期格式
	 * **/
	public static Date string2ShortDate(String str) throws Exception {

		int year, month, day, hour, minute, second;
		String s1 = str.substring(0, str.indexOf(" "));
		String s2 = str.substring(str.indexOf(" ") + 1);

		StringTokenizer st = new StringTokenizer(s1, "-");
		year = Integer.parseInt(st.nextToken());
		month = Integer.parseInt(st.nextToken());
		day = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(s2, ":");
		try{
			hour = Integer.parseInt(st.nextToken());
			minute = Integer.parseInt(st.nextToken());
			second = Integer.parseInt(st.nextToken());
		}catch(Exception ex){
			hour = 0;
			minute = 0;
			second = 0;
		}

		Calendar c = Calendar.getInstance();
		c.set(year, month - 1, day, 0, 0, 0);

		return c.getTime();
	}
	
	/**
	 * 将字符串转化为java.sql.date日期
	 * 字符串格式要求为 yyyy-MM-dd hh:mm:ss
	 * 转化为yyy-MM-dd的sql日期格式
	 * **/
	public static java.sql.Date string2SqlDate(String str){

		java.util.Date utilDate;
		java.sql.Date date=null;
		try {
			utilDate = DateUtil.string2ShortDate(str);
			date = new java.sql.Date(utilDate.getTime());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
    
    public static java.sql.Date string2MSqlDate(String str){

        java.util.Date utilDate;
        java.sql.Date date=null;
        try {
            utilDate = DateUtil.string2Date(str);
            date = new java.sql.Date(utilDate.getTime());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date;
    }


	//返回当前周的起始日期和终止日期,
	public static String getWeekRange(){
		Calendar cal = Calendar.getInstance(); 

		int dayOfWeek = cal.get(cal.DAY_OF_WEEK);

		String rString = "";
		
		try {
			Date date1 = string2SqlDate(DateUtil.dateAdd("d",(2-dayOfWeek),new Date(System.currentTimeMillis())));
			Date date2 = string2SqlDate(DateUtil.dateAdd("d",(8-dayOfWeek),new Date(System.currentTimeMillis())));
			rString = "<b>"+date1 +"至"+date2+"</b>";
			return rString;
		} catch (Exception e) {
			return "";
		}
		 
		
	}
    
//  返回当前周的起始日期
    public static String getWeekStart(){
        Calendar cal = Calendar.getInstance(); 

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

        String rString = "";
        
        try {
            Date date1 = string2SqlDate(DateUtil.dateAdd("d",(1-dayOfWeek),new Date(System.currentTimeMillis())));
            rString = ""+date1;
            return rString;
        } catch (Exception e) {
            return "";
        }
         
        
    }
    
    /**
     * 判断一个日期加上一个天数是否大于今天日期(zzk 07.1.22)
     * @param begDate  日期值
     * @param validDay  有效天数
     * @return 两值比较结果
     */
    public static int dateCompare(String begDate,int validDay)
    {
        int result = -1;
        if(begDate==null || "".equals(begDate))
            return result;
        try
        {
            GregorianCalendar gc = new GregorianCalendar();     //今天日期
            SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-M-d");     //开始日期
            
            gc.setTime(new Date(System.currentTimeMillis()));
            int currDay = gc.get(Calendar.DAY_OF_MONTH);
            gc.set(Calendar.DAY_OF_MONTH, currDay - validDay-1);        //往前推validDay+1天,因为当天值有一定的时分秒
            result = bartDateFormat.parse(begDate).compareTo(gc.getTime());
            return result;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return result;
        }
    }
    public static String getSendSMsgDateTime()
    {
    	String time="";
    	try
    	{
    	    SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	    java.util.Date date = new java.util.Date();
    	    time = simpleDateFormat.format(date);
    	}
    	catch(Exception e)
    	{
    		time="format datetime error:"+e.getMessage();
    	}
	    //System.out.println("now time is:"+time);
    	    return time;
    } 
    
    /**比较两个日期字符串大小
     * 1表示str1>str2, -1表示str1<str2, 0表示str1=str2
    **/
    
    public static int compareDateString(String str1,String str2)
    {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-d");    	
    	int result = -1;
    	if(str1==null || "".equals(str1) || str2==null || "".equals(str2))
    		return result;
    	try
    	{
    		result = dateFormat.parse(str1).compareTo(dateFormat.parse(str2));
    		return result;
    		
    	}catch(Exception e){
    		 e.printStackTrace();
             return result;
    	}    	
    }   
}

