/*
 * Created on 2006-9-6
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.job5156.util;

/**
 * @author alpha
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class FilterSpecial {
    
      public FilterSpecial()
      {
          
      }
      
      public static String filter(String input)
      {
          boolean flags = false;
        if(!hasSpecialChars(input))
        { 
            return input;
        }
        
        StringBuffer filtered =new StringBuffer(input.length());
        char c;
        
        for(int i=0; i<=input.length()-1; i++)
        {
            c=input.charAt(i);
            if(c=='<'){
                flags = true;
            }
            if(!flags)
                filtered.append(c);
            if(c=='>'){
                flags = false;
            }    
            
        }
        String reStr = filtered.toString();
        reStr=reStr.replaceAll("&nbsp;","");
        reStr=reStr.replaceAll(" ","");
        reStr=reStr.replaceAll("\n","");
        reStr=reStr.replaceAll("\r","");
        reStr=reStr.replaceAll("\n\r","");
        reStr=reStr.replaceAll("\t","");
        reStr=reStr.replaceAll("　　","");
        reStr=reStr.replaceAll(" 　　","");
        return reStr;
      }
      
      public static String filter(String input,int num)
      {
          if(filter(input).length()>num)
              return (filter(input)).substring(0,num);
          else
              return filter(input);
      }
      
      public static boolean hasSpecialChars(String input)
      {
        boolean flag=false;
        if((input!=null)&&(input.length()>0))
        {
          char c;
          for(int i=0; i<=input.length()-1; i++)
          {
            c=input.charAt(i);      
            switch(c)
            {
              case '>': flag=true; break;
              case '<': flag=true; break;
            }
          }
        }
        return flag;
      }
}
