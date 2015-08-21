package com.job5156.util;

//简繁转换JAVA算法

import java.io.BufferedReader;
import java.io.*;
import java.util.Hashtable;

public class TransCode
{
    private Hashtable<Object, Object> hashGB = new Hashtable<Object, Object>();

    private Hashtable hashGBToBig5 = new Hashtable();

    private Hashtable hashBig = new Hashtable();

    private Hashtable hashBig5ToGB = new Hashtable();

    public String haveError = "FALSE";

    public TransCode()
    {
        int i = 0, total = 0, ch1 = 0, ch2 = 0;
        try
        {
            FileInputStream inGB = new FileInputStream("GBCode.DAT");//该文件是GB2312内码文件
            FileInputStream inGBToBig = new FileInputStream("Big5Code.DAT");//该文件是BIG5内码文件
            i = 0;
            while (inGB.available() > 0)
            {
                ch1 = inGB.read();
                ch2 = inGB.read();
                hashGB.put(Integer.toHexString(ch1) + Integer.toHexString(ch2), Integer.toString(i));
                i = i + 1;
            }
            i = 0;
            while (inGBToBig.available() > 0)
            {
                ch1 = inGBToBig.read();
                ch2 = inGBToBig.read();
                total = ch1 * 256 + ch2;
                //////hashGBToBig5.put(Integer.toString(i),Integer.toString(total));
                i = i + 1;
            }
        }
        catch (Exception e)
        {
            e.getMessage();
            haveError = "TRUE";
        }
    }

    public Hashtable getHashGB()
    {
        return hashGB;
    }

    public Hashtable getHashGBToBig5()
    {
        return hashGBToBig5;
    }

    public String getGBToBig(String source)
    {
        int ch1 = 0, ch2 = 0, twoChar = 0, total = 0;
        String position;
        String outStr = "";
        String keyValue = "";
        byte[] arrSource;
        byte[] arrDest = null;
        try
        {
            arrSource = source.getBytes();
            arrDest = new byte[arrSource.length];
            for (int i = 0; i < arrSource.length; i++)
            {
                ch1 = arrSource[i] & 0x000000ff;
                if (ch1 >= 0xa1 && ch1 <= 0xfe)
                {
                    ch2 = arrSource[i + 1] & 0x000000ff;
                    position = (String) hashGB.get(Integer.toHexString(ch1)
                            + Integer.toHexString(ch2));
                    if (position != null)
                    {
                        keyValue = (String) hashGBToBig5.get(position);
                        if (keyValue != null)
                        {
                            total = Integer.parseInt(keyValue);
                            ch1 = (total & 0xff00) >> 8;
                            ch2 = total & 0x00ff;
                        }
                    }
                    arrDest[i] = (byte) ch1;
                    arrDest[i + 1] = (byte) ch2;
                    i = i + 1;
                }
                else arrDest[i] = (byte) ch1;
            }
            outStr = new String(arrDest);
        }
        catch (Exception e)
        {
        }
        //if (haveError.equals("TRUE")) outStr = "No Found File!";
        return outStr;
    }

    static void writeOutput(String str, String strOutFile)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream(strOutFile);
            Writer out = new OutputStreamWriter(fos);
            out.write(str);
            out.close();

        }

        catch (IOException e)
        {
            e.printStackTrace();
            e.printStackTrace();
        }
    }

    static String readInput(String strInFile)
    {
        StringBuffer buffer = new StringBuffer();
        try
        {
            FileInputStream fis = new FileInputStream(strInFile);
            InputStreamReader isr = new InputStreamReader(fis);
            Reader in = new BufferedReader(isr);
            int ch;
            while ((ch = in.read()) > -1)
            {
                buffer.append((char) ch);
            }
            in.close();
            return buffer.toString();
        }

        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args)
    {
        TransCode cc = new TransCode();
        String temp = readInput("gb.txt");
        String destStr = cc.getGBToBig(temp);
        System.out.println(destStr);
        try
        {
            BufferedWriter out = new BufferedWriter(new FileWriter("big5.txt", false));
            out.write(destStr);
            out.close();
        }
        catch (Exception e)
        {
        }
    }

}
