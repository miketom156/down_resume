package com.job5156.jsDateJoin.event;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


public class test {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
//		System.out.println("----------jsonTest start!--------------");
//		long begintime = System.currentTimeMillis();
//		Session localsession  = LocalSessionManager.currentSession();		
		String json = "[{\"username\":\"æ√÷€\",\"password\":\"123456\",\"tid\":\"2\",\"url\":\"http://www.baidu.com\",\"111\":\"6\"}]";
		//String json = "{\"username\":\"æ√÷€\",\"password\":\"123456\"}";
		ObjectMapper o = new ObjectMapper();
		//test2 t = o.readValue(json, test2.class);
		//Map map = o.readValue(json, Map.class);
		List list = o.readValue(json, List.class);
		//List<LinkedHashMap<String, Object>> list = objectMapper.readValue(json, List.class);
		System.out.println(list.size());
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		//System.out.println(map.get("111"));
		//EntityManager.saveEntity(t, localsession);
		
//		localsession.close();
//		long endtime = System.currentTimeMillis();
//		System.out.println("----------jsonTest end£°”√ ±£∫"+(endtime - begintime)/1000/60+" ∑÷÷”");		
	}
	
	
}
