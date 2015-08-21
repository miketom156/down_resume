package com.job5156.util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.URL;




public class URLUtil
{
	public static void main(String[] args)
	{
		String url = "http://www.job5156.com/process/compaper/person_paperIndex.jsp";
	}
    private static final String FILE_PATH="com.job5156.mail.bean.URLUtil";
    /**类的构造器*/
    public URLUtil(){}
  
    /**
    * 通过指定的地址获取HTML代码。<br>
    * 若10秒钟内无法下载数据，则自动重新启动下载。
    * @param url 网址
    * @return HTML代码
    */
    public static String getHtml(String url) {
    	return getHtml(url,null);
    }
    public static String getHtml(String url,String charSet){
        String s="";
        FetchURLDataThread thread=null;
        int i=0; 
        while(s.equals(""))
        {
            i++;
            System.out.println("GetURLContent: 开始第"+i+"次获取链接 "+url);
            try
            {
                if(thread==null || (!thread.isAlive()))
                {
                    thread=new FetchURLDataThread(url,charSet);
                    thread.start();
                    thread.join(200000);
                    s=thread.getHtml();                 
                }                
                if(s==null) s="";
                if(s.equals("")) thread=null;
                if(i==10) break;
            } 
            catch(InterruptedException e)
            {
                System.out.print("[ERROR]GetURLContent: 下载失败!!!重新启动下载。"+e);
            }           
        }
        thread=null;
       // System.out.println(s);
        return s;
    }
}

/**内部类，继承Thread，主要功能是取网页内容*/
class FetchURLDataThread extends Thread
{
    private String html;        //网页内容
    private String urlstring;   //网页地址
    private String charSet;   //编码
    /**构造器1*/
    public FetchURLDataThread(){}
    /**
     * 构造器2
     * @param url
     */
    public FetchURLDataThread(String url,String charSet)
    {
        this.urlstring=url;
        this.charSet = charSet;
    }
    public void run()
    {
        try
        {
            this.html=this.getHtmlCode();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    } 
  
    /**
     * 获取HTML代码
     * @return 获取到的HTML代码
    */
  public String getHtml()
  {
    return this.html;
  }
  
    /**
     * 返回网页内容
     * @return String
     */
    public String getHtmlCode() throws MalformedURLException,IOException
    {
        return this.getHtmlCode(this.urlstring);
    }
    /**
     * 通过指定网址获取网页内容
     * @param urlstring 网址字符串
     * @return 网页内容
     */
    public String getHtmlCode(String urlstring) 
    {
        String strContent="";
        HttpURLConnection connection=null;
        BufferedReader buffRead=null;
        try
        {
            URL url=new URL(urlstring);
            connection = (HttpURLConnection) url.openConnection();     
            connection.addRequestProperty("User-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)"); //浏览器伪造 xurun
            InputStreamReader inputStream = null;
            if(this.charSet!=null)
            	inputStream=new InputStreamReader(connection.getInputStream(),this.charSet);
            else
            	inputStream=new InputStreamReader(connection.getInputStream());
            buffRead=new BufferedReader(inputStream);
            StringBuffer sbStr=new StringBuffer("");
            String str="";
            while((str=buffRead.readLine())!=null)
            {
                sbStr.append(str+"\n");
            }
            strContent=sbStr.toString();
            buffRead.close();
        }
        catch(ConnectException ex)
        {
            System.out.println(ex);
        }
        catch(SocketException ex)
        {
            System.out.println(ex);
        }
        catch(MalformedURLException ex)
        {
            System.out.println(ex);
        }
        catch(IOException ex)
        {
            System.out.println(ex);
        }
        finally
        {
            try
            {                
                if(buffRead!=null)
                    buffRead.close();
                
            }
            catch(IOException ioEx)
            {
                ioEx.printStackTrace();
            }
        }
     //   System.out.println(strContent);
        return strContent;
        
    }
}