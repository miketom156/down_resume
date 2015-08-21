package com.job5156.util;

import java.util.*;

/**
 * <p>Title: html助手类</p>
 * <p>Description: </p>
 * @author <a href="mailto:lzjliu307@sohu.com">Lzj.Liu</a>
 * @version 1.0
 */
public class HtmlUtil
{

    private static HashMap<String, String> escapeCharMap = new HashMap<String, String>();
    static
    {
        escapeCharMap.put("<", "&lt;");
        escapeCharMap.put(">", "&gt;");
        escapeCharMap.put("\"", "&quot;");
        escapeCharMap.put("'", "&#39;");
        escapeCharMap.put("=", "&#61;");
        escapeCharMap.put("&", "&amp;");
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
    
    public static String getTextNoBr(String str)
    {
        if (str == null || str.equals("")) return ("");

        StringBuffer buf = new StringBuffer(str.length() + 50);
        char ch = '\n';
        try
        {
            for (int i = 0; i < str.length(); i++)
            {
                ch = str.charAt(i);
                if (ch == '\t')
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

    public static String getOptionHtml(List list, String def)
    {
        String[] a;
        StringBuffer html = new StringBuffer();
        if (list != null)
        {
            for (Iterator iter = list.iterator(); iter.hasNext();)
            {
                a = (String[]) iter.next();

                html.append("\t<option value=\"");
                html.append(a[0]);
                html.append("\"");
                if (a[0].equals(def))
                {
                    html.append(" selected");
                }
                html.append(">");
                html.append(a[1]);
                html.append("</option>\n");
            }
        }
        return html.toString();
    }

    public static StringBuffer getRadioHtml(List list, String def, String name,
            String style, String theclass)
    {
        String[] a;
        StringBuffer html = new StringBuffer();
        if (list != null)
        {
            Iterator iter = list.iterator();
            while (iter.hasNext())
            {
                a = (String[]) iter.next();
                html.append("<input type=\"radio\" name=\"");
                html.append(name);
                html.append("\" ");
                html.append("value=\"");
                html.append(a[0]);
                html.append("\" ");
                html.append(style);
                html.append(theclass);

                if (a[0].equals(def))
                {
                    html.append("checked");
                }

                html.append(">");
                html.append(a[1]);
                html.append("\n");
            }
        }
        return html;
    }

    public static String getVarArrayScript(List list, String arrayName)
    {
        if (arrayName == null || arrayName.trim().length() == 0) { return "\n/*错误：输入的参数不正确，arrayName不能为空*/\n"; }
        if (list == null) { return "\n/*错误：输入的参数不正确，list不能为空*/\n"; }
        StringBuffer script = new StringBuffer();

        script.append(arrayName);
        script.append(" = new Array();\n");
        script.append("var i = 0; \n");

        Iterator iter = list.iterator();
        String[] a;
        int width = 0; //数组的宽度
        int i = 0;
        if (iter.hasNext())
        {
            a = (String[]) iter.next();
            width = a.length;
            script.append(arrayName);
            script.append("[i]= new Array(");

            for (; i < width - 1; i++)
            {
                script.append("\"");
                script.append(a[i]);
                script.append("\",");
            }
            script.append("\"");
            script.append(a[i]);
            script.append("\");i++;\n");
        }
        while (iter.hasNext())
        {
            a = (String[]) iter.next();
            script.append(arrayName);
            script.append("[i]= new Array(");
            i = 0;
            for (; i < width - 1; i++)
            {
                script.append("\"");
                script.append(a[i]);
                script.append("\",");
            }
            script.append("\"");
            script.append(a[i]);
            script.append("\");i++;\n");
        }

        return script.toString();
    }

    public static String toDocumentStr(String str)
    {
        return getBrText(StringUtil.escapeCharacter(str, escapeCharMap));
    }

    private HtmlUtil()
    {
    }
}
///:~
