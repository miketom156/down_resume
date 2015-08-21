/**
 * Copyright (c) 2000-2003 Liferay Corporation
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.job5156.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * <a href="StringUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author  Brian Chan
 * @version $Revision: 1.1.1.1 $
 * 
 */
public class StringUtil {

	public static String combineArray(int[] array, String delim)
    {
        if (array == null || array.length == 0) return "";

        int length = array.length - 1;
        if (delim == null) delim = "";

        StringBuffer result = new StringBuffer();
        for (int i = 0; i < length; i++)
        {
            result.append(Integer.toString(array[i]));
            result.append(delim);
        }
        result.append(Integer.toString(array[length]));
        return result.toString();
    }

    public static String combineStringArray(String[] array, String delim)
    {
        if (array == null) return "";
        int length = array.length - 1;
        if (delim == null)
        {
            delim = "";
        }
        StringBuffer result = new StringBuffer(length * 8);
        for (int i = 0; i < length; i++)
        {
            result.append(array[i]);
            result.append(delim);
        }
        result.append(array[length]);
        return result.toString();
    }

    public static String combineStringList(List list, String delim)
    {
        if (list == null || list.size() == 0)
        {
            return "";
        }
        else
        {
            StringBuffer result = new StringBuffer();
            for (int i = 0; i < list.size() - 1; i++)
            {
                result.append((String) list.get(i));
                result.append(delim);
            }
            result.append((String) list.get(list.size() - 1));
            return result.toString();
        }
    }

    public static boolean contains(String[] strings, String string)
    {
        return contains(strings, string, true);
    }

    public static boolean contains(String[] strings, String string,
            boolean caseSensitive)
    {
        for (int i = 0; i < strings.length; i++)
        {
            if (caseSensitive == true)
            {
                if (strings[i].equals(string)) { return true; }
            }
            else
            {
                if (strings[i].equalsIgnoreCase(string)) { return true; }
            }
        }
        return false;
    }
    public static String getGBKText(String str)
    {
    	if(str!=null)
    	{
        try
        {
            /*String temp_p;
            temp_p = str;
            byte[] temp_t = temp_p.getBytes("ISO8859_1");
            String temp = new String(temp_t, "GBK");*/
            return str;
        }
        catch (Exception e)
        {
            return "";
        }
    	}
    	else
    	{
    		return  "";
    	}
    } 
    public static boolean containsIgnoreCase(String[] strings, String string)
    {
        return contains(strings, string, false);
    }
	public static String add(String s, String add) {
		return add(s, add, StringPool.COMMA);
	}

	public static String add(String s, String add, String delimiter) {
		return add(s, add, delimiter, false);
	}

	public static String add(
		String s, String add, String delimiter, boolean allowDuplicates) {

		if ((add == null) || (delimiter == null)) {
			return null;
		}

		if (s == null) {
			s = StringPool.BLANK;
		}

		if (allowDuplicates || !contains(s, add, delimiter)) {
			if (Validator.isNull(s) || s.endsWith(delimiter)) {
				s += add + delimiter;
			}
			else {
				s += delimiter + add + delimiter;
			}
		}

		return s;
	}

	public static boolean contains(String s, String text) {
		return contains(s, text, StringPool.COMMA);
	}

	public static boolean contains(String s, String text, String delimiter) {
		if ((s == null) || (text == null) || (delimiter == null)) {
			return false;
		}

		if (!s.endsWith(delimiter)) {
			s += delimiter;
		}

		int pos = s.indexOf(delimiter + text + delimiter);

		if (pos == -1) {
			if (s.startsWith(text + delimiter)) {
				return true;
			}

			return false;
		}

		return true;
	}

	public static int count(String s, String text) {
		if ((s == null) || (text == null)) {
			return 0;
		}

		int count = 0;

		int pos = s.indexOf(text);

		while (pos != -1) {
			pos = s.indexOf(text, pos + text.length());
			count++;
		}

		return count;
	}

	public static String merge(String array[]) {
		return merge(array, StringPool.COMMA);
	}

	public static String merge(String array[], String delimiter) {
		if (array == null) {
			return null;
		}

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < array.length; i++) {
			sb.append(array[i].trim());

			if ((i + 1) != array.length) {
				sb.append(delimiter);
			}
		}

		return sb.toString();
	}

	public static String randomize(String s) {
		Randomizer r = new Randomizer();

		return r.randomize(s);
	}

	public static String read(ClassLoader classLoader, String name)
		throws IOException {

		return read(classLoader.getResourceAsStream(name));
	}

	public static String read(InputStream is) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		StringBuffer sb = new StringBuffer();
		String line = null;

		while ((line = br.readLine()) != null) {
			sb.append(line).append('\n');
		}

		br.close();

		return sb.toString().trim();
	}

	public static String remove(String s, String remove) {
		return remove(s, remove, StringPool.COMMA);
	}

	public static String remove(String s, String remove, String delimiter) {
		if ((s == null) || (remove == null) || (delimiter == null)) {
			return null;
		}

		if (Validator.isNotNull(s) && !s.endsWith(delimiter)) {
			s += delimiter;
		}

		while (contains(s, remove, delimiter)) {
			int pos = s.indexOf(delimiter + remove + delimiter);

			if (pos == -1) {
				if (s.startsWith(remove + delimiter)) {
					s = s.substring(
							remove.length() + delimiter.length(), s.length());
				}
			}
			else {
				s = s.substring(0, pos) + s.substring(pos + remove.length() +
					delimiter.length(), s.length());
			}
		}

		return s;
	}

	public static String replace(String s, char oldSub, char newSub) {
		return replace(s, oldSub, new Character(newSub).toString());
	}

	public static String replace(String s, char oldSub, String newSub) {
		if ((s == null) || (newSub == null)) {
			return null;
		}

		char[] c = s.toCharArray();

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < c.length; i++) {
			if (c[i] == oldSub) {
				sb.append(newSub);
			}
			else {
				sb.append(c[i]);
			}
		}

		return sb.toString();
	}

	public static String replace(String s, String oldSub, String newSub) {
		if ((s == null) || (oldSub == null) || (newSub == null)) {
			return null;
		}

		int y = s.indexOf(oldSub);

		if (y >= 0) {
			StringBuffer sb = new StringBuffer();
			int length = oldSub.length();
			int x = 0;

			while (x <= y) {
				sb.append(s.substring(x, y));
				sb.append(newSub);
				x = y + length;
				y = s.indexOf(oldSub, x);
			}

			sb.append(s.substring(x));

			return sb.toString();
		}
		else {
			return s;
		}
	}

	public static String replace(String s, String[] oldSubs, String[] newSubs) {
		if ((s == null) || (oldSubs == null) || (newSubs == null)) {
			return null;
		}

		if (oldSubs.length != newSubs.length) {
			return s;
		}

		for (int i = 0; i < oldSubs.length; i++) {
			s = replace(s, oldSubs[i], newSubs[i]);
		}

		return s;
	}

	public static String reverse(String s) {
		if (s == null) {
			return null;
		}

		char[] c = s.toCharArray();
		char[] reverse = new char[c.length];

		for (int i = 0; i < c.length; i++) {
			reverse[i] = c[c.length - i - 1];
		}

		return new String(reverse);
	}

	public static String shorten(String s) {
		return shorten(s, 20);
	}

	public static String shorten(String s, int length) {
		return shorten(s, length, "..");
	}

	public static String shorten(String s, String suffix) {
		return shorten(s, 20, suffix);
	}

	public static String shorten(String s, int length, String suffix) {
		if (s == null || suffix == null)  {
			return null;
		}

		if (s.length() > length) {
			s = s.substring(0, length) + suffix;
		}

		return s;
	}

	public static String[] split(String s) {
		return split(s, StringPool.COMMA);
	}

	public static String[] split(String s, String delimiter) {
		if (s == null || delimiter == null) {
			return new String[0];
		}
		if (!s.endsWith(delimiter)) {
			s += delimiter;
		}

		s = s.trim();

		if (s.equals(delimiter)) {
			return new String[0];
		}

		List nodeValues = new ArrayList();

		if (delimiter.equals("\n") || delimiter.equals("\r")) {
			try {
				BufferedReader br = new BufferedReader(new StringReader(s));

				String line = null;

				while ((line = br.readLine()) != null) {
					nodeValues.add(line);
				}

				br.close();
			}
			catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		else {
			int offset = 0;
			int pos = s.indexOf(delimiter, offset);

			while (pos != -1) {
				nodeValues.add(s.substring(offset, pos));

				offset = pos + delimiter.length();
				pos = s.indexOf(delimiter, offset);
			}
		}

		return (String[])nodeValues.toArray(new String[0]);
	}

	public static boolean[] split(String s, String delimiter, boolean x) {
		String[] array = split(s, delimiter);
		boolean[] newArray = new boolean[array.length];

		for (int i = 0; i < array.length; i++) {
			boolean value = x;

			try {
				value = Boolean.valueOf(array[i]).booleanValue();
			}
			catch (Exception e) {
			}

			newArray[i] = value;
		}

		return newArray;
	}

	public static double[] split(String s, String delimiter, double x) {
		String[] array = split(s, delimiter);
		double[] newArray = new double[array.length];

		for (int i = 0; i < array.length; i++) {
			double value = x;

			try {
				value = Double.parseDouble(array[i]);
			}
			catch (Exception e) {
			}

			newArray[i] = value;
		}

		return newArray;
	}

	public static float[] split(String s, String delimiter, float x) {
		String[] array = split(s, delimiter);
		float[] newArray = new float[array.length];

		for (int i = 0; i < array.length; i++) {
			float value = x;

			try {
				value = Float.parseFloat(array[i]);
			}
			catch (Exception e) {
			}

			newArray[i] = value;
		}

		return newArray;
	}

	public static int[] split(String s, String delimiter, int x) {
		String[] array = split(s, delimiter);
		int[] newArray = new int[array.length];

		for (int i = 0; i < array.length; i++) {
			int value = x;

			try {
				value = Integer.parseInt(array[i]);
			}
			catch (Exception e) {
			}

			newArray[i] = value;
		}

		return newArray;
	}

	public static long[] split(String s, String delimiter, long x) {
		String[] array = split(s, delimiter);
		long[] newArray = new long[array.length];

		for (int i = 0; i < array.length; i++) {
			long value = x;

			try {
				value = Long.parseLong(array[i]);
			}
			catch (Exception e) {
			}

			newArray[i] = value;
		}

		return newArray;
	}

	public static short[] split(String s, String delimiter, short x) {
		String[] array = split(s, delimiter);
		short[] newArray = new short[array.length];

		for (int i = 0; i < array.length; i++) {
			short value = x;

			try {
				value = Short.parseShort(array[i]);
			}
			catch (Exception e) {
			}

			newArray[i] = value;
		}

		return newArray;
	}
	public static Long[] split(String s, String delimiter,Long defaultValue) {
				String[] array = split(s, delimiter);
				Long[] newArray = new Long[array.length];

				for (int i = 0; i < array.length; i++) {
					Long value = defaultValue;

					try {
						value = new Long(array[i]);
					}
					catch (Exception e) {
					}

					newArray[i] = value;
				}

				return newArray;
			}
    public static final String stackTrace(Throwable t) {
		String s = null;

		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			t.printStackTrace(new PrintWriter(baos, true));
			s = baos.toString();
		}
		catch (Exception e) {
		}

		return s;
    }

	public static boolean startsWith(String s, char begin) {
		return startsWith(s, (new Character(begin)).toString());
	}

	public static boolean startsWith(String s, String begin) {
		if ((s == null) || (begin == null)) {
			return false;
		}

		if (begin.length() > s.length()) {
			return false;
		}

		String temp = s.substring(0, begin.length());

		if (temp.equalsIgnoreCase(begin)) {
			return true;
		}
		else {
			return false;
		}
	}

	public static String wrap(String text) {
		return wrap(text, 80);
	}

	public static String wrap(String text, int width) {
		if (text == null) {
			return null;
		}

		StringBuffer sb = new StringBuffer();

		try {
			BufferedReader br = new BufferedReader(new StringReader(text));

			String s = "";

			while ((s = br.readLine()) != null) {
				if (s.length() == 0) {
					sb.append("\n");
				}
				else {
					while (true) {
						int pos = s.lastIndexOf(' ', width);

						if ((pos == -1) && (s.length() > width)) {
							sb.append(s.substring(0, width));
							sb.append("\n");

							s = s.substring(width, s.length()).trim();
						}
						else if ((pos != -1) && (s.length() > width)) {
							sb.append(s.substring(0, pos));
							sb.append("\n");

							s = s.substring(pos, s.length()).trim();
						}
						else {
							sb.append(s);
							sb.append("\n");

							break;
						}
					}
				}
			}
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return sb.toString();
	}
	
	/**
	 * 拆逗号分隔的字符串，结果保存在List中
	 * @param currLanguage 当前语言版本
	 * @param unionStr  要分隔得字符串
	 * @deprecated replace by getListFromString(String unionStr)
	 * @return List
	 */
	public static List getListFromString(byte currLanguage ,String unionStr) {
		return getListFromString(unionStr);
	}
	/**
	 * 拆逗号分隔的字符串，结果保存在List中
	 * @param unionStr  要分隔得字符串
	 * @return List
	 */
	public static List getListFromString(String unionStr) {
		List list = null;

		if (Validator.isNotNull(unionStr)) {
			list = new ArrayList();

			String[] str = unionStr.split(StringPool.COMMA);

			for (int i = 0; i < str.length; i++) {
				list.add(str[i]);
			}
		}

		return list;
	}
		
	
	public static String toString(Collection collection){
		StringBuffer str = new StringBuffer();
		if(Validator.isNotNull(collection)){
			Iterator iter = collection.iterator();
			while(iter.hasNext())
				str.append(iter.next()).append(",");
						
			return str.substring(0,str.length() -1);
		}
		
		
		return str.toString();
	}

	public static String mapkeyToString(ObjectValuePair[] ovArray) {
		StringBuffer str = new StringBuffer();
		if (ovArray != null) {
			for (int i=0; i<ovArray.length; i++) {
				str.append(ovArray[i].getKey().toString()+",");
			}
		}
		if (str.indexOf(",")>0) {
			str.deleteCharAt(str.length()-1);
		}
		return str.toString();
	}

    


    /** 获取GBK码 */
    public static String getGBKCode(Object alias) {
        if (alias != null) {
            return getGBKCode(alias.toString());
        } else {
            return "";
        }
    }
    
    public static String getGBKCode(String alias) {
    	return getGBKStr(alias);
    }
    public static String getBrText(String str)
    {
        if (str == null || str.equals("")) return ("");

        StringBuffer buf = new StringBuffer(str.length() + 50);
        char ch = '\n';
        try
        {
            for (int i = 0; i < str.length(); i++)
            {
                ch = str.charAt(i);
                if (ch == '\n')
                {
                    buf.append("<br>");
                }
                else if (ch == '\t')
                {
                    buf.append("&nbsp;&nbsp;&nbsp;&nbsp;");
                }
                else if (ch == ' ')
                {
                    buf.append("&nbsp;");
                }
                else
                {
                    buf.append(ch);
                }
            }
        }
        catch (Exception ex)
        {
            System.out.println("getBrText()"+ex.getMessage());
        }
        return buf.toString();
    }
    public static String getNotNullStr(Object s)
    {
        return (s == null) ? "" : s.toString().trim();
        /*
         String result = "";
         if(s != null){
         result = s.trim();
         }
         return result;
         */
    }
    public static String getNotNullStr(String s)
    {
        return (s == null) ? "" : s.trim();
        /*
         String result = "";
         if(s != null){
         result = s.trim();
         }
         return result;
         */
    }
    public static String getNotNullStr(String s,String defaultValue)
    {
        return (s == null) ? defaultValue : s.trim();
        /*
         String result = "";
         if(s != null){
         result = s.trim();
         }
         return result;
         */
    }
    
    public static String getNotNullStr(Object s,String defaultValue)
    {
        return (s == null) ? defaultValue : s.toString().trim();
        /*
         String result = "";
         if(s != null){
         result = s.trim();
         }
         return result;
         */
    }
    /**返回整数类型的数值，为NULL返回0**/
    public static int intValue(Integer i)
    {
        return intValue(i,0);
    }
    /**返回整数类型的数值,为NULL返回默认值**/
    public static int intValue(Integer i,int defaultValue)
    {
        if(i==null) return defaultValue;
        else return i.intValue();
    }
    public static int parseInt(Object s)
    {
    	if(s!=null)
         return parseInt(s.toString(), 0);
    	else
    	 return 0;	
    }
    public static int parseInt(String s)
    {
        return parseInt(s, 0);
    }

    public static int parseInt(String s, int defaultValue)
    {
        int rt = defaultValue;
        try
        {
            s=s.trim();
            rt = Integer.parseInt(s);
        }
        catch (NumberFormatException e)
        {
            rt = defaultValue;
        }
        catch(NullPointerException e)
        {
            rt=defaultValue;
        }
        catch(Exception e)
        {
            rt=defaultValue;
        }
        return rt;
    }
    
    public static boolean parseBoolean(String strX)
    {
        if (strX == null || strX.equals("null")) strX = "0";
        if (strX.equals("0")) return false;
        else if (strX.equals("1")) return true;
        else return false;
    }
    //mlf add begin
    public static String getInputAuthor(Object str)
	{
    	String rstr="";
		if(str==null)
		{
			rstr="";
		}
		else
		{
			rstr=str.toString().replaceAll("'","＼'");
		}
		return rstr;
	}
    /**数据库改用gbk码，换用mysql 5.0驱动包后不再需要转化编码 xurun 2006-5-24*/
	 public static String getGBKStr(String str)
	    {	
//	 		if(str!=null)
//	 			return str;
//	 		else
//	 			return "";
	    	if(str!=null)
	    	{
    	        try
    	        {
    	            String temp_p;
    	            temp_p = str;
    	            temp_p = getNotNullStr(temp_p);
    	            
                    temp_p = Tools.toHtmlStr(temp_p);
//    
   	            byte[] temp_t = temp_p.getBytes("ISO8859_1");
   	            String temp = new String(temp_t, "GBK");
    	            
                    temp_p = HtmlUtil.getBrText(temp_p);
    	            return temp_p;
    	        }
    	        catch (Exception e)
    	        {
    	            return "";
    	        }
	    	}
	    	else
	    	{
	    		return  "";
	    	}
	    }
     
     public static String getXmlStr(String str)
     {
         if(str!=null)
            {
                try
                {
                    str = replace(str, "<", "&lt;");
                    str = replace(str, ">", "&gt;");
                    str = replace(str, "\"", "&quot;");
                    str = replace(str, "'", "&#39;");
                    str = replace(str, "&", "&amp;");
                    return str;
                }
                catch (Exception e)
                {
                    return "";
                }
            }
            else
            {
                return  "";
            }
     }
	    


	    public static String getIsoCode(Object obj) {
	        if(obj!=null){
	            return getIsoCode(obj.toString());
	        }else{
	            return "";
	        }
	    }
	    
	    public static String getIsoCode(String string) {
	        String returnstring = Tools.toHtmlStr(string);
	        try {
//	            returnstring = new String(string.getBytes("GBK"),"ISO-8859-1");
	        } catch (Exception ex) {
	            returnstring = string;
	        }
	        return returnstring;
	    }
	    
	    public static boolean isDoubleByte(char c)
	    {
	        return !((c >>> 8) == 0);
	    }
	    public static int getByteLength(String source)
	    {
	        int len = 0;
	        for (int i = 0; i < source.length(); i++)
	        {
	            char c = source.charAt(i);
	            int highByte = c >>> 8;
	            len += highByte == 0 ? 1 : 2;
	        }
	        return len;
	    }
	    public static String getSubStr(String source, int len)
	    {
	        return getSubStr(source, len, "", "."); 
	    }

	    public static String getSun0769SubStr(String source, int len)
	    {
	        return getSubStr(source, len, "", "...");  //2006-6-8 xurun 只显示一个扩展点
	    }
	    
	    public static String getSubStr(String source, int len, String exChar,
	            String exStr)
	    {
	    	if(source==null) return null;
	        source = source.replaceAll("&nbsp;"," ");  //xurun2006-6-29变更:将所有&nsp;空格代码换成空格
	        if (getByteLength(source) <= len) { return source; }
	        StringBuffer result = new StringBuffer();
	        char c = '\u0000';
	        int i = 0, j = 0;
	        for (; i < len; j++)
	        {
	            result.append(c);
	            c = source.charAt(j);
	            i += isDoubleByte(c) ? 2 : 1;
	        }
	        
	        if (i > len)
	        {
	            result.append(exChar);
	        }
	        else
	        {
	            result.append(c);
	        }
	        result.append(exStr);

	        return result.toString();
	    }
		    
	    public static String getSubStr(String str,int beginp,int endp)
	    {
	    	if(str!=null)
	    	{
	        try
	        {
	        	if(str.length()<endp)
	        		endp=str.length();
	            str=str.substring(beginp,endp);
	            return str;
	            
	        }
	        catch (Exception e)
	        {
	            return "";
	        }
	    	}
	    	else
	    	{
	    		return  "";
	    	}
	    } 
	    public static String getEmailCode(Integer i)
	    {
	    	if(i==null)
	    	{
	    		return "简体中文";
	    	}
	    	else
	    	{
	    		if(i==0)
	    		{
	    			return "简体中文";
	    		}
	    		else
	    		{
	    			return "繁体中文";
	    		}
	    	}
	    }
    //mlf add end
	    /**返回完整月份，比如3==>03*/
	    public static String getFullMonth(Integer month)
	    {
	    	if(month==null) return "0";
	    	String monthStr = month.toString();
	    	if(monthStr.length()==1)
	    		monthStr = 0+monthStr;
	    	return monthStr;
	    }
	    
	    /**将用逗号分隔的字符串转化为List对象*/
	    public static List string2List(String str){
	        List list = new ArrayList();
	        String[] div = str.split(",");
	        for(int i=0;i<div.length;i++){
	            list.add(div[i]);
	        }
	        return list;
	    }
	    

	    /**将用逗号分隔的字符串转化为Set对象*/
	    public static Set string2Set(String str){
	        Set set = new HashSet();
	        if(Validator.isNotNull(str)){
	            String[] div = str.split(",");
	            for(int i=0;i<div.length;i++){
	                set.add(div[i]);
	            }
	        }
	        return set;
	    }    
        
        public static String escapeCharacter(String source, HashMap escapeCharMap)
        {
            if (source == null || source.length() == 0) { return source; }
            if (escapeCharMap.size() == 0) { return source; }
            StringBuffer sb = new StringBuffer();
            StringCharacterIterator sci = new StringCharacterIterator(source);
            for (char c = sci.first(); c != StringCharacterIterator.DONE; c = sci.next())
            {
                String character = String.valueOf(c);
                if (escapeCharMap.containsKey(character))
                {
                    character = (String) escapeCharMap.get(character);
                }
                sb.append(character);
            }
            return sb.toString();
        }
	    /**
	     * 返回取字符串特定部分内容
	     * @param src 传入字符串
	     * @param begin 开始位
	     * @param end 结束位
	     * @return
	     */
	    public static String substring(String src,int begin,int end)
	    {
	    	if(src==null || "".equals(src))
	    		return "";
	    	int len = src.length();
	    	if(end>len)
	    		end = len;
	    	return src.substring(begin,end);
	    }
	    
	    public static String getModToUrl(String mod){
	    	if(mod!=null && !"".equals(mod)){
	    		mod = Tools.replace(mod,"(","");
	    		mod = Tools.replace(mod,")","");
	    		mod = Tools.replace(mod,",","/");
	    	}
	    	return mod;
	    }
}