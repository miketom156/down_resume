package com.job5156.jiangmen;

import com.job5156.down.util.LoadHtml;
import com.job5156.server.FileLog;

public class AnalysisUserId {
	
	private static final String FILE_PATH = "com.job5156.jiangmen.AnalysisUserId";
	private static final String url = "http://www.xhrc.com.cn/person/pdisplay.asp?id=";
	
	public static void main(String[] args){
		try{
			LoadHtml loadHtml = new LoadHtml();
			loadHtml.setUrl(url);
			int userid = 0;
			for(int i=42275; i<10000000; i++){
				userid = i;
				String content = loadHtml.getBigHtmlByCode(i);
				if(checkExist(content) == 1){
					System.out.println("用户:"+i+" 存在!!");
					FileLog.logDebug(String.valueOf(i));
				}else{
					System.out.println("用户:"+i+" 不存在!!");
				}
			}
			FileLog.logDebug("检测结束: 当前用户ID "+userid);
		}catch(Exception e){
			FileLog.logDebug(FILE_PATH+".main()=="+e);
			e.printStackTrace();
		}
	}
	
	public static int checkExist(String content){
		int flag = 1; //简历存在
		if(content.indexOf("无此人才资料！") != -1){
			flag = 2;
		}
		return flag;
	}
}
