package com.job5156.util;

/**
 * <p>工具类</p>
 */
import java.util.Date;
import java.util.Hashtable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.*;
import java.net.*;

public class Tools
{
    private Tools()
    {
    }
    
    /****
     * 对简历编号加密
     * @param perid
     * @return
     */
    public static int encodePersonId(Object perid)
    {
    	int iTemp =0;
        iTemp = StringUtil.parseInt(perid) * 102;
    	return iTemp;
    }
    
    /****
     * 对简历编号解密
     * @param perid
     * @return
     */
    public static int decodePersonId(Object perid){
    	int iTemp =0;
    	iTemp = StringUtil.parseInt(perid) / 102;
    	return iTemp;
    }
    
    /**
     * 对给定字符进行 URL 编码
     * @param value String
     * @return String
     */
    public static String encode(String value)
    {
        String result = "";
        if (!isEmpty(value))
        {
            try
            {
                result = java.net.URLEncoder.encode(value, "UTF-8");
            }
            catch (UnsupportedEncodingException ex)
            {
                ex.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 对给定字符进行 URL 解码
     * @param value String
     * @return String
     */
    public static String decode(String value)
    {
        String result = "";
        if (!isEmpty(value))
        {
            try
            {
                result = java.net.URLDecoder.decode(value, "UTF-8");
            }
            catch (UnsupportedEncodingException ex)
            {
            	 ex.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 判断是否为空，为空返回true
     * @param value String
     * @return boolean
     */
    private static boolean isEmpty(String value)
    {
        if (value == null || value.trim().equals("")) return true;
        else return false;
    }

    public static String toStr(String str)
    {
        if (str == null)
        {
            return "";
        }
        else
        {
            return str.trim();
        }
    }

    public static String toStr(String str, String strReturn)
    {
        if (str == null)
        {
            return strReturn;
        }
        else
        {
            if (str.trim().equals("") || str.trim().equalsIgnoreCase("null"))
            {
                return strReturn;
            }
            else
            {
                return str.trim();
            }
        }
    }

    public static String toStr(Object obj)
    {
        if (obj == null)
        {
            return "";
        }
        else
        {
            return obj.toString().trim();
        }
    }

    public static boolean isNullStr(String str)
    {
        if (str == null)
        {
            return true;
        }
        else
        {
            if (str.trim().equals("") || str.trim().equalsIgnoreCase("null"))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    public static void log(String msg)
    {
       
    }

    public static void log(String fileName, String msg)
    {
        
    }

    public static int toInt(String strNum)
    {
        try
        {
            if (strNum == null || strNum.trim().equals(""))
            {
                return 0;
            }
            else
            {
                return Integer.parseInt(strNum.trim());
            }
        }
        catch (Exception ex)
        {
            return 0;
        }
    }

    public static int toInt(Object obj)
    {
        try
        {
            if (obj == null || obj.toString().equals(""))
            {
                return 0;
            }
            else
            {
                return Integer.parseInt(obj.toString().trim());
            }
        }
        catch (Exception ex)
        {
            return 0;
        }
    }

    public static int toInt(String strNum, int iReturn)
    {
        try
        {
            if (strNum == null)
            {
                return iReturn;
            }
            else
            {
                return Integer.parseInt(strNum.trim());
            }
        }
        catch (Exception ex)
        {
            return iReturn;
        }
    }

    public static String toHtmlStr1(String str)
    {
        if (str == null) return "";
        return toHtmlStr(str);
    }

    public static String toTextAreaStr(String str)
    {
        if (str == null) { return ""; }

        String szTmp = str;
        szTmp = replace(szTmp, "<", "&lt;");
        szTmp = replace(szTmp, ">", "&gt;");
        szTmp = replace(szTmp, "\"", "&quot;");
        szTmp = replace(szTmp, "\\", "&#92;"); //有无必要呢.
        return szTmp;
        /*
         &#61; --> '='
         &#34; --> '"'
         &#36; --> '$'
         &#37; --> '%'
         &#40; --> '('
         &#41; --> ')'
         &#47; --> '/'
         
         &#60; --> '<'
         &#61; --> '='
         &#62; --> '>'
         &#63; --> '?'
         &#64; --> '@'
         */
    }

    public static String toHtmlValue(String str)
    {
        String szTmp = str;
        szTmp = replace(szTmp, "''", "'");
        szTmp = replace(szTmp, "=", "&#61;");
        szTmp = replace(szTmp, "<", "&#60;");
        szTmp = replace(szTmp, ">", "&#62;");
        szTmp = replace(szTmp, "\"", "&#34;");
        szTmp = replace(szTmp, "\\", "&#92;");
        return szTmp;
    }

    public static String toHtmlSrc(String str)
    {
        if (str == null) { return ""; }

        String szTmp = str;
        szTmp = replace(szTmp, "<", "&lt;");
        szTmp = replace(szTmp, ">", "&gt;");
        szTmp = replace(szTmp, "\"", "&quot;");
        szTmp = replace(szTmp, "=", "&#61;");
        szTmp = replace(szTmp, "\n", "<br>");
        return szTmp;
    }

    public static String toHtmlStr(String str)
    {
        if (str == null) { return ""; }

        String szTmp = str;
        szTmp = replace(szTmp, "<br>", "\n");
        szTmp = replace(szTmp, "<", "&lt;");
        szTmp = replace(szTmp, ">", "&gt;");
        szTmp = replace(szTmp, "\"", "&quot;");
        szTmp = replace(szTmp, "=", "&#61;");
        return szTmp.trim();
    }
    
    public static String toHtmlImgStr(String str)
    {
        if (str == null) { return ""; }

        String szTmp = str;
        szTmp = replace(szTmp, "<br>", "\n");
        szTmp = replace(szTmp, "<", "&lt;");
        szTmp = replace(szTmp, ">", "&gt;");
        szTmp = replace(szTmp, "\"", "&quot;");
        szTmp = replace(szTmp, "=", "&#61;");
//        szTmp = replace(szTmp, "&lt;img", "<img");
        return szTmp.trim();
    }

    public static String toInsStr(String str)
    {
        if (str == null || str.trim().equals("")) { return ""; }
        return replace(str.trim(), "'", "''");
    }

    public static String toInsSqlStr(String str)
    {
        StringBuffer sb = new StringBuffer("");
        if (str == null || str.trim().equals("")) { return ""; }
        String szStr = str.trim();
        for (int i = 0; i < szStr.length(); i++)
        {
            if (szStr.substring(i, i + 1).equals("'")) sb.append("''");
            else sb.append(szStr.substring(i, i + 1));
        }

        return sb.toString();
    }

    public static Hashtable splitDateStr(String str)
    {
        Hashtable<Object, Object> hb = new Hashtable<Object, Object>();
        if (str == null || str.trim().equals("")) return hb;
        int iLen = str.trim().length();
        if (iLen >= 6 && str.trim().indexOf("-") > -1)
        {
            hb.put("YEAR", str.trim().substring(0, 4));
            hb.put("MONTH", str.trim().substring(5));
        }
        return hb;
    }

    public static Hashtable splitDateStr1(String str)
    {
        Hashtable<Object, Object> hb = new Hashtable<Object, Object>();
        if (str == null || str.trim().equals("")) return hb;
        int iLen = str.trim().length();
        if (iLen >= 10 && toDate(str.trim().substring(0, 10)) != null)
        {
            hb.put("YEAR", str.trim().substring(0, 4));
            hb.put("MONTH", str.trim().substring(5, 7));
            hb.put("DAY", str.trim().substring(8, 10));
        }
        return hb;
    }

    public static Date toDate(String strDate)
    {
        try
        {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            return (Date) df.parse(strDate);
        }
        catch (Exception ex)
        {
            return null;
        }
    }

    public static String toUpperCaseFirstLetter(String s)
    {
        return isNullStr(s) ? s : s.substring(0, 1).toUpperCase()
                + s.substring(1);
    }

    public static boolean isNullStr(Object o)
    {
        return (o == null || o.toString().equals("null") || o.toString().equals("")) ? true
                : false;
    }

    public static boolean isNull(String str)
    {
        if (str == null) return true;
        if (str.equals(" ")) return true;
        else return false;
    }

    public static boolean isNull(Object obj)
    {
        if (obj == null) return true;
        String szTmp = obj.toString();
        if (szTmp.equals("") || szTmp.equalsIgnoreCase("null")) return true;
        else return false;
    }

    public static String replace(String szSrc, String szOld, String szNew)
    {
        try
        {
            int iPos = -1;
            if (szSrc == null || szSrc.trim().equals("")) return "";
            StringBuffer sb = new StringBuffer();
            String szTmp = szSrc.trim();
            if (szNew == null) return szTmp;
            if (szOld == null || szOld.equals("")) return szTmp;
            if ((iPos = szTmp.indexOf(szOld)) == -1) return szTmp; //提前退出
            int iOldLen = szOld.length();
            int iNewLen = szNew.length();
            int iSrcLen = szSrc.length();
            int iStart = 0;
            while ((iPos = szTmp.indexOf(szOld, iStart)) > -1)
            {
                sb.append(szTmp.substring(iStart, iPos));
                sb.append(szNew);
                iStart = iPos + iOldLen;
            }
            if (iStart < iSrcLen) sb.append(szTmp.substring(iStart));
            return sb.toString();
        }
        catch (Exception ex)
        {
            return "";
        }
        
    }

    public static String replace_hl(String szSrc, String szOld, String szNew)
    {
        try
        {
            int iPos = -1;
            if (szSrc == null || szSrc.trim().equals("")) return "";
            StringBuffer sb = new StringBuffer();
            String szTmp = szSrc.trim();
            if (szNew == null) return szTmp;
            if (szOld == null || szOld.equals("")) return szTmp;
            if ((iPos = szTmp.toLowerCase().indexOf(szOld.toLowerCase())) == -1)
                return szTmp; //提前退出
            //avoid to replace [font color='red' color_kw]
            if (";font;color;red;color_kw;".indexOf(szOld.toLowerCase()) > -1)
                return szTmp;
            int iOldLen = szOld.length();
            int iSrcLen = szSrc.length();
            int iStart = 0;
            while ((iPos = szTmp.toLowerCase().indexOf(szOld.toLowerCase(), iStart)) > -1)
            {
                //说明源串里是javascript:不再替换
                sb.append(szTmp.substring(iStart, iPos));
                if (iPos != szTmp.toLowerCase().indexOf("javascript:", iStart)) sb.append(szNew);
                else sb.append(szOld);
                iStart = iPos + iOldLen;
            }
            if (iStart < iSrcLen) sb.append(szTmp.substring(iStart));
            return sb.toString();
        }
        catch (Exception ex)
        {
            return "";
        }
    }

    public static String toKeyStr(String szSrc)
    {
        if (szSrc == null || szSrc.trim().equals("")) return "";
        String szTmp = szSrc.trim();
        szTmp = replace(szTmp, "\"", "");
        szTmp = replace(szTmp, "，", ",");
        szTmp = replace(szTmp, "；", ";");
        szTmp = replace(szTmp, "\uFF08", "(");
        szTmp = replace(szTmp, "\uFF09", ")");
        szTmp = replace(szTmp, "'", "''");
        szTmp = Tools.replace(szTmp, " and ", ",");
        szTmp = Tools.replace(szTmp, " or ", ";");
        szTmp = replace(szTmp, " ", "");

        szTmp = replace(szTmp, ",", " and ");
        szTmp = replace(szTmp, ";", " or ");
        /*
         szTmp = Tools.replace(szTmp, "\"", "");
         szTmp = Tools.replace(szTmp, " and ", ",");
         szTmp = Tools.replace(szTmp, " or ", ";");
         szTmp = Tools.replace(szTmp, "\uFF1B", ";");
         szTmp = Tools.replace(szTmp, "\uFF0C", ",");
         szTmp = Tools.replace(szTmp, "\uFF08", "(");
         szTmp = Tools.replace(szTmp, "\uFF09", ")");
         //最后统一转换
         szTmp = Tools.replace(szTmp, ",", " and ");
         szTmp = Tools.replace(szTmp, ";", " or ");
         */
        return szTmp;
    }

    public static String showPage(int iCurrPage, int iTotalPage)
    {
        StringBuffer sbPage = new StringBuffer("\n");
        if (iTotalPage > 1)
        {
            sbPage.append("  <tr>  \n"); //valign='absbottom'
            sbPage.append("    <td height='22' width='65%' align='right'> \n");
            if (iCurrPage > 1)
                sbPage.append("<a href='javascript:GoPage(1)'><img src='/gbimage/firs_button.gif' border='0' valign='absbottom'></a><a href='javascript:GoPage("
                        + (iCurrPage - 1)
                        + ")'><img src='/gbimage/prev_button.gif' border='0' valign='absbottom'></a>");
            if (iCurrPage < iTotalPage)
                sbPage.append("<a href='javascript:GoPage("
                        + (iCurrPage + 1)
                        + ")'><img src='/gbimage/next_button.gif' border='0' valign='absbottom'></a><a href='javascript:GoPage("
                        + iTotalPage
                        + ")'><img src='/gbimage/last_button.gif' border='0' valign='absbottom'></a>\n");

            sbPage.append("    </td>  \n");
            if (iTotalPage > 1)
            {
                sbPage.append("    <td height='22' width='28%' align='right'>直接查看第 \n");
                sbPage.append("      <select name='page' onchange='GoPage(this.value)'>    \n");
                for (int i = 1; i <= iTotalPage; i++)
                {
                    if (i == iCurrPage) sbPage.append("        <option selected value='"
                            + i + "'>" + i + "</option>  \n");
                    else sbPage.append("        <option value='" + i + "'>" + i
                            + "</option>  \n");
                }
                sbPage.append("      </select>页 \n");
                sbPage.append("     </td>  \n");
            }
            sbPage.append("  </tr>  \n");
        }

        return sbPage.toString();
    }

    public static String replace_str(String szSrc, String szOld, String szNew)
    {
        try
        {
            if (szSrc == null || szSrc.trim().equals("")) return "";
            StringBuffer sb = new StringBuffer();
            String szTmp = szSrc.trim();
            if (szOld == null || szOld.equals("")) return szTmp;
            if (szNew == null) return szTmp;
            int iOldLen = szOld.length();
            int iNewLen = szNew.length();
            int iSrcLen = szSrc.length();
            int iPos = -1;
            int iStart = 0;
            while ((iPos = szTmp.indexOf(szOld, iStart)) > -1)
            {
                sb.append(szTmp.substring(iStart, iPos));
                sb.append(szNew);
                iStart = iPos + iOldLen;
            }
            if (iStart < iSrcLen) sb.append(szTmp.substring(iStart));
            return sb.toString();
        }
        catch (Exception ex)
        {
            return "";
        }
    }

    public static String[] splitStr(String list)
    {
        String[] arrStr = null;
        Hashtable<Object, Object> hb = null;
        String str = null;
        String key = null;
        Object obj = null;
        int iLen = 0;
        int iPos = -1;
        int iTmp = -1;
        if ((list == null) || list.trim().equals(""))
        {
            return new String[0];
        }
        else
        {
            str = list.trim();
        }

        hb = new Hashtable<Object, Object>();
        iPos = str.indexOf(',');
        if (iPos < 0)
        {
            if (!str.equals("") && !hb.contains((Object) str))
            {
                obj = hb.put(new Integer(iLen), str);
                iLen++;
            }
        }

        while ((iPos > -1))
        {
            key = "";
            iTmp = str.indexOf(',', iPos + 1);
            if (iTmp > iPos)
            {
                key = str.substring(0, iPos);
                str = str.substring(iPos + 1);
                if (!key.equals("") && !hb.contains((Object) key))
                {
                    obj = hb.put(new Integer(iLen), key);
                    iLen++;
                }
                iPos = str.indexOf(',');
            }
            else
            {
                key = str.substring(0, iPos);
                str = str.substring(iPos + 1);

                if (!key.equals("") && !hb.contains((Object) key))
                {
                    hb.put(new Integer(iLen), key);
                    iLen++;
                }

                if (!str.equals("") && !hb.contains((Object) str))
                {
                    hb.put(new Integer(iLen), str);
                    iLen++;
                }
                iPos = -1;
            }
        }

        arrStr = new String[iLen];
        for (int i = 0; i < iLen; i++)
        {
            arrStr[i] = (String) hb.get(new Integer(i));
        }
        return arrStr;
    }

    public static String getSrc(String url)
    {
        HttpURLConnection conn = null;
        BufferedReader in = null;
        PrintWriter out = null;
        Object obj = null;
        StringBuffer sb = new StringBuffer("");
        boolean bOpen = false;

        try
        {
            conn = (HttpURLConnection) (new URL(url)).openConnection();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            bOpen = true;
        }
        catch (Exception e)
        {
            bOpen = false;
            System.out.println("Can not open HttpURLConnection! err:" + e);
        }

        try
        {
            if (bOpen)
            {
                String line = null;
                while ((line = in.readLine()) != null)
                {
                    if (line.indexOf("javascript:window.print();") == -1)
                        sb.append(line + "\n");
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Close Object err:" + e);
        }
        finally
        {
            try
            {
                if (in != null)
                {
                    in.close();
                    in = null;
                }
                if (conn != null)
                {
                    conn.disconnect();
                    conn = null;
                }
            }
            catch (Exception e)
            {
                System.out.println("Close Object err:" + e);
            }
        }
        return sb.toString();
    }

    public static String[] toStrArr(String list)
    {
        String[] arrStr = null;
        Hashtable<Object, Object> hb = null;
        String str = null;
        String key = null;
        Object obj = null;
        int iLen = 0;
        int iPos = -1;
        int iTmp = -1;
        if ((list == null) || list.trim().equals(""))
        {
            return new String[0];
        }
        else
        {
            str = list.trim();
        }

        //可用扩展
        str = Tools.replace(str, ",", ";");
        str = Tools.replace(str, "；", ";");
        str = Tools.replace(str, "，", ";");

        hb = new Hashtable<Object, Object>();
        iPos = str.indexOf(';');
        if (iPos < 0)
        {
            if (!str.equals("") && !hb.contains((Object) str))
            {
                obj = hb.put(new Integer(iLen), str);
                iLen++;
            }
        }

        while ((iPos > -1))
        {
            key = "";
            iTmp = str.indexOf(';', iPos + 1);
            if (iTmp > iPos)
            {
                key = str.substring(0, iPos);
                str = str.substring(iPos + 1);
                if (!key.equals("") && !hb.contains((Object) key))
                {
                    obj = hb.put(new Integer(iLen), key);
                    iLen++;
                }
                iPos = str.indexOf(';');
            }
            else
            {
                key = str.substring(0, iPos);
                str = str.substring(iPos + 1);

                if (!key.equals("") && !hb.contains((Object) key))
                {
                    hb.put(new Integer(iLen), key);
                    iLen++;
                }

                if (!str.equals("") && !hb.contains((Object) str))
                {
                    hb.put(new Integer(iLen), str);
                    iLen++;
                }
                iPos = -1;
            }
        }

        arrStr = new String[iLen];
        for (int i = 0; i < iLen; i++)
        {
            arrStr[i] = (String) hb.get(new Integer(i));
        }
        return arrStr;
    }

    public static String toAlertStr(String str)
    {
        if (str == null) { return ""; }

        String szTmp = str;

        szTmp = replace(szTmp, "\\", "\\\\");
        szTmp = replace(szTmp, "=", "&#61;");
        szTmp = replace(szTmp, "\"", "\\\"");
        szTmp = replace(szTmp, "'", "\\\"");
        return szTmp;
    }

    public static String toLimitStr(String src, int len)
    {
        String szTmp = toStr(src);
        String szAlt = toStr(src);
        int iLen = szTmp.length();
        int iMax = 1;
        if (len > 1) iMax = len;
        iMax = 10000; //绕过截取
        if (iLen == 0) return "";
        else if (iLen > iMax) szTmp = szTmp.substring(0, iMax);
        //szAlt = replace(szAlt, "\"", "\\\"");
        //szAlt = replace(szAlt, "\n", "");
        //szAlt = toAlertStr(szAlt);
        if (iLen > iMax) szTmp = toHtmlStr(szTmp)
                + "<a href='javascript:alert(\"" + szAlt + "\");'>...</a>";
        else szTmp = toHtmlStr(szTmp);
        return szTmp;
    }

    public static String toLimitHrefStr(String src, String js_str, int len)
    {
        String szTmp = toStr(src);
        String szAlt = toStr(src);
        String szJs = toStr(js_str);
        int iLen = szTmp.length();
        int iMax = 1;
        if (len > 1) iMax = len;
        iMax = 10000; //绕过截取
        if (iLen == 0) return "";
        else if (iLen > iMax) szTmp = szTmp.substring(0, iMax);
        //szAlt = replace(szAlt, "\"", "\\\"");
        //szAlt = replace(szAlt, "\n", "");
        //szAlt = toAlertStr(szAlt);
        if (szJs.equals("")) szJs = "return false;";
        if (szJs.indexOf("onclick=") > -1)
        {
            if (iLen > iMax) szTmp = "<a href='" + js_str + "'>"
                    + toHtmlStr(szTmp)
                    + "</a>&nbsp;<a href='javascript:alert(\"" + szAlt
                    + "\");'>...</a>";
            else szTmp = "<a href='" + js_str + "'>" + toHtmlStr(szTmp)
                    + "</a>";
        }
        else
        {
            if (iLen > iMax) szTmp = "<a href='#' onclick='javascript:"
                    + js_str + "'>" + toHtmlStr(szTmp)
                    + "</a>&nbsp;<a href='javascript:alert(\"" + szAlt
                    + "\");'>...</a>";
            else szTmp = "<a href='#' onclick='javascript:" + js_str + "'>"
                    + toHtmlStr(szTmp) + "</a>";
        }
        return szTmp;
    }

    public static int outToFile(String filename, String filecontent,
            boolean mode)
    {
        PrintWriter outfile = null;
        String f_name = null;
        String f_content = null;

        try
        {
            if (filename == null || filename.trim().equals("")) f_name = ".\\NoFoundFile.htm";
            else f_name = ".\\" + filename.trim();

            if (filecontent == null || filecontent.trim().equals("")) f_content = "";
            else f_content = filecontent;

            try
            {
                outfile = new PrintWriter(new FileWriter(f_name, mode));
            }
            catch (Exception e)
            {
                System.out.println("Err(close stream):" + e);
                return -3;
            }

            try
            {
                if (outfile != null)
                {
                    outfile.close();
                    outfile = null;
                }
            }
            catch (Exception e)
            {
                System.out.println("Err(close stream):" + e);
                return -2;
            }
            //执行成功!
            return 0;
        }
        catch (Exception e)
        {
            System.out.println("Err(write file):" + e);
            //log("Err(out to file):"+e);
            return -1;
        }
        finally
        {
            ;//log("### finally (outToFile) ^_^ "+f_name+"");
        }
    }
}
