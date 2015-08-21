package com.job5156.foshan;

import com.job5156.util.Validator;

/**
 * @author wufalong
 * create on 2008-6-3
 */
public class MapTable
{
	 public static String getCodeTwo(String value,String[][] array)
	 {
		if(Validator.isNull(value))return "";
	    try
	    {
	        for(int i=0;i<array.length;i++){
	            String[] div = (String[])(array[i]);
	            if(div[1].trim().equalsIgnoreCase(value.trim())){
	                return div[0];
	            }
	        }
	    }
	    catch(Exception e)
	    {
	        e.printStackTrace();
	    }
	
	    return "";
	 }
	 
	 public static String[][] sex = 
	 {
		 {"1","��"},
		 {"2","Ů"},
	 };
	 
	 public static String[][] marriage = 
	 {
		 {"0","δ��"},
		 {"1","�ѻ�"},
	 };
	 
	 
	 public static String[][] highDegree = 
	 {
		{"1","����"},
		{"2","����"},
		{"3","��ר"},
		{"4","��ר"},
		{"5","����"},
		{"6","˶ʿ"},
		{"8","��ʿ"},
	 };
	 
	 public static String[][] salary = 
	 {
		 {"0","����"},
		 {"1","1000����"},
		 {"2","1000-1500"},
		 {"2","1500-2000"},
		 {"3","2000-2500"},
		 {"3","2500-3000"},
		 {"4","3000-4000"},
		 {"5","4000-5000"},
		 {"7","5000-7000"},
		 {"9","7000-10000"},
		 {"11","10000����"},
	 };
	 
	 public static String[][] computerLevel = 
	 {
		 {"0","����"},
		 {"0","һ��"},
		 {"1","����"},
		 {"2","����"},
		 {"2","��ͨ"},
	 };
	 
	 public static String[][] englishLevel = 
	 {
		 {"4","һ��"},
		 {"3","����"},
		 {"1","����"},
		 {"2","��ͨ"},
		 {"1001","CET4"},
		 {"1002","CET6"},
		 {"1003","TEM4"},
		 {"1004","TEM8"},
		 {"1010","TOFEL"},
		 {"1013","��˼"},
		 {"1011","GRE"},
		 {"1005","PETS1"},
		 {"1006","PETS2"},
		 {"1007","PETS3"},
		 {"1008","PETS4"},
		 {"1009","PETS5"},
		 {"1014","BEC1"},
		 {"1015","BEC2"},
		 {"1016","BEC3"},
	 };
	 
	 public static String[][] year = 
	 {
		 {"3","����"},
		 {"3","����"},
		 {"3","��ר"},
		 {"3","��ר"},
		 {"4","����"},
		 {"2","˶ʿ"},
		 {"4","��ʿ"}
	 };
	 
	 public static String[][] addYear = 
	 {
		 {"12","����"},
		 {"15","����"},
		 {"15","��ר"},
		 {"18","��ר"},
		 {"18","����"},
		 {"22","˶ʿ"},
		 {"24","��ʿ"},
	 };
	 
	 public static String[][] jobLocation =
	 {
		 {"1400","�㶫ʡ"},
		 {"1404","��ɽ��"},
		 {"1404","��ɽ����"},
		 {"1404","��ɽ����"},
		 {"1404","��ɽ����"},
		 {"1404","��ɽ����"},
		 {"1404","��ɽʯ���"},
		 {"1404","��ɽС���"},
		 {"1404","��ɽɳϪ��"},
		 {"1404","��ɽ̹����"},
		 {"1404","��ɽ������"},
		 {"1404","��ɽ������"},
		 {"1404","��ɽ������"},
		 {"1404","��ɽ������"},
		 {"1404","��ɽ���ɽ"},
		 {"1404","��ɽ������"},
		 {"1404","��ɽ��ɳ��"},
		 {"1404","��ɽ������"},
		 {"1404","��ɽ������"},
		 {"1404","��ɽ�����"},
		 {"1404","��ɽ������"},
		 {"1404","��ɽ��ܽ��"},
		 {"1404","��ɽ��ӿ��"},
		 {"1404","��ɽ����"},
		 {"1404","��ɽ������"},
		 {"1404","��ɽ�ۿ���"},
		 {"1404","��ɽ��ͷ��"},
		 {"1403","������"},
		 {"1403","���ݷ�خ��"},
		 {"1403","���ݻ�����"},
		 {"1403","���������"},
		 {"1403","���ݰ�����"},
		 {"1403","����������"},
		 {"1403","����Խ����"},
		 {"1403","���ݺ�����"},
		 {"1403","���ݻ�����"},
		 {"1403","������ɳ��"},
		 {"1403","�����ܸ���"},
		 {"1403","����������"},
		 {"1403","���ݴӻ���"},
		 {"1401","��ݸ��"},
		 {"1401","��ݸݸ����"},
		 {"1401","��ݸ�ϳ���"},
		 {"1401","��ݸ������"},
		 {"1401","��ݸ����"},
		 {"1401","��ݸ������"},
		 {"1401","��ݸ������"},
		 {"1401","��ݸ������"},
		 {"1401","��ݸ��ƽ��"},
		 {"1401","��ݸ�����"},
		 {"1401","��ݸ�����"},
		 {"1401","��ݸ��Ϫ��"},
		 {"1401","��ݸ弲���"},
		 {"1401","��ݸʯ����"},
		 {"1401","��ݸʯ����"},
		 {"1401","��ݸ��ľͷ��"},
		 {"1401","��ݸ������"},
		 {"1401","��ݸ��ӿ��"},
		 {"1401","��ݸ������"},
		 {"1401","��ݸ����ɽ��"},
		 {"1401","��ݸ������"},
		 {"1401","��ݸ��ɽ��"},
		 {"1401","��ݸ�߲���"},
		 {"1401","��ݸ������"},
		 {"1401","��ݸʯ����"},		 
		 {"1401","��ݸ������"},
		 {"1401","��ݸ�ƽ���"},
		 {"1401","��ݸ��ͷ��"},
		 {"1401","��ݸ��ʯ��"},
		 {"1401","��ݸл����"},
		 {"1401","��ݸɳ����"},
		 {"1401","��ݸ��÷��"},
		 {"1401","��ݸ��ţ����"},
		 {"1401","��ݸ����"},
		 {"1402","������"},
		 {"1402","�����޺���"},
		 {"1402","���ڸ�����"},
		 {"1402","������ɽ��"},
		 {"1402","���ڱ�����"},
		 {"1402","����������"},
		 {"1402","����������"},
		 {"1409","��ɽ��"},
		 {"1409","��ɽ˳����"}, 
		 {"1409","��ɽ�Ϻ���"}, 
		 {"1409","��ɽ��ˮ��"}, 
		 {"1409","��ɽ������"}, 
		 {"1409","��ɽ������"}, 
		 {"1405","�麣��"}, 
		 {"1405","�麣������"}, 
		 {"1405","�麣������"}, 
		 {"1405","�麣������"}, 
		 {"1407","������"}, 
		 {"1407","���ݻݳ���"}, 
		 {"1407","���ݻ�����"}, 
		 {"1407","���ݲ�����"}, 
		 {"1407","���ݻݶ���"}, 
		 {"1407","����������"}, 
		 {"1406","��ͷ��"}, 
		 {"1406","��ͷ������"}, 
		 {"1406","��ͷ��ƽ��"}, 
		 {"1406","��ͷ婽���"}, 
		 {"1406","��ͷ������"}, 
		 {"1406","��ͷ������"}, 
		 {"1406","��ͷ�κ���"}, 
		 {"1406","��ͷ�ϰ���"}, 
		 {"1414","������"}, 
		 {"1414","���ݷ�Ϫ��"}, 
		 {"1414","����������"}, 
		 {"1414","���ݳ�����"}, 
		 {"1414","������ƽ��"}, 
		 {"1418","��β��"}, 
		 {"1418","��β����"}, 
		 {"1418","��β������"}, 
		 {"1418","��β½����"}, 
		 {"1418","��β½����"}, 
		 {"1421","������"}, 
		 {"1421","�����ų���"}, 
		 {"1421","�����Ҷ���"}, 
		 {"1421","����������"}, 
		 {"1421","����������"}, 
		 {"1421","����������"}, 
		 {"1421","������ɽ��"}, 
		 {"1415","տ����"}, 
		 {"1415","տ���࿲��"}, 
		 {"1415","տ��ϼɽ��"}, 
		 {"1415","տ����ͷ��"}, 
		 {"1415","տ��������"}, 
		 {"1415","տ����Ϫ��"}, 
		 {"1415","տ��������"}, 
		 {"1415","տ��������"}, 
		 {"1415","տ��������"}, 
		 {"1415","տ���⴨��"}, 
		 {"1408","������"}, 
		 {"1408","�������"}, 
		 {"1408","���Ž�����"}, 
		 {"1408","�����»���"}, 
		 {"1408","����̨ɽ��"}, 
		 {"1408","���ſ�ƽ��"}, 
		 {"1408","���ź�ɽ��"}, 
		 {"1408","���Ŷ�ƽ��"}, 
		 {"1416","ï����"}, 
		 {"1416","ï��ï����"}, 
		 {"1416","ï��ï����"}, 
		 {"1416","ï�������"}, 
		 {"1416","ï��������"}, 
		 {"1416","ï��������"}, 
		 {"1416","ï��������"}, 
		 {"1410","������"}, 
		 {"1410","����������"}, 
		 {"1410","����������"}, 
		 {"1410","����������"}, 
		 {"1410","����������"}, 
		 {"1413","������"}, 
		 {"1413","���������"}, 
		 {"1413","���춦����"}, 
		 {"1413","���������"}, 
		 {"1413","���컳����"}, 
		 {"1413","����⿪��"}, 
		 {"1413","���������"}, 
		 {"1413","�����Ҫ��"}, 
		 {"1413","�����Ļ���"}, 
		 {"1417","÷����"}, 
		 {"1417","÷��÷����"}, 
		 {"1417","÷��÷��"}, 
		 {"1417","÷�ݴ�����"}, 
		 {"1417","÷�ݷ�˳��"}, 
		 {"1417","÷���廪��"}, 
		 {"1417","÷��ƽԶ��"}, 
		 {"1417","÷�ݽ�����"}, 
		 {"1417","÷��������"}, 
		 {"1420","�Ƹ���"}, 
		 {"1420","�Ƹ��Ƴ���"}, 
		 {"1420","�Ƹ�������"}, 
		 {"1420","�Ƹ������� "}, 
		 {"1420","�Ƹ��ư��� "}, 
		 {"1420","�Ƹ��޶���"}, 
		 {"1411","��Զ��"}, 
		 {"1411","��Զ�����"}, 
		 {"1411","��Զ�����"}, 
		 {"1411","��Զ��ɽ��"}, 
		 {"1411","��Զ��ɽ׳������������"}, 
		 {"1411","��Զ��������������"}, 
		 {"1411","��Զ������"}, 
		 {"1411","��ԶӢ����"}, 
		 {"1411","��Զ������"}, 
		 {"1412","�ع���"}, 
		 {"1412","�ع��佭��"}, 
		 {"1412","�ع�䥽���"}, 
		 {"1412","�ع�������"}, 
		 {"1412","�ع�ʼ����"}, 
		 {"1412","�ع��ʻ���"}, 
		 {"1412","�ع���Դ��"}, 
		 {"1412","�ع���Դ����������"}, 
		 {"1412","�ع��·���"}, 
		 {"1412","�ع��ֲ���"}, 
		 {"1412","�ع�������"}, 
		 {"1419","��Դ��"}, 
		 {"1419","��ԴԴ����"}, 
		 {"1419","��Դ�Ͻ���"}, 
		 {"1419","��Դ������"}, 
		 {"1419","��Դ��ƽ��"}, 
		 {"1419","��Դ��ƽ��"}, 
		 {"1422","��Դ��"}, 
		 {"1422","�㶫������"}, 
		 {"2900","����ʡ"}, 
		 {"2901","�ϲ�"}, 
		 {"2907","Ƽ��"}, 
		 {"2910","����"}, 
		 {"2912","�ٴ�"}, 
		 {"2902","������"}, 
		 {"2904","ӥ̶"}, 
		 {"2903","�Ž�"}, 
		 {"2905","�˴�"}, 
		 {"2906","����"}, 
		 {"2908","����"}, 
		 {"2909","����"}, 
		 {"2912","����ɽ"}, 
		 {"2911","����"}, 
		 {"2800","����ʡ"}, 
		 {"2801","��ɳ"}, 
		 {"2815","����"}, 
		 {"2806","����"}, 
		 {"2802","��̶"}, 
		 {"2804","����"}, 
		 {"2805","�żҽ�"}, 
		 {"2807","����"}, 
		 {"2815","����"}, 
		 {"2815","����"}, 
		 {"2808","����"}, 
		 {"2815","��"}, 
		 {"2815","����"}, 
		 {"2809","¦��"}, 
		 {"2815","��Դ"}, 
		 {"2815","��ˮ��"}, 
		 {"2810","����"}, 
		 {"2815","�齭"}, 
		 {"2811","����"}, 
		 {"2812","����"}, 
		 {"2813","����"}, 
		 {"2815","��ˮ̲"}, 
		 {"2803","����"}, 
		 {"2700","����ʡ"}, 
		 {"2701","�人"}, 
		 {"2705","�差"}, 
		 {"2702","�˲�"}, 
		 {"2703","Т��"}, 
		 {"2704","����"}, 
		 {"2717","�Ϻӿ�"}, 
		 {"2717","֦��"}, 
		 {"2717","����"}, 
		 {"2706","����"}, 
		 {"2717","�˳�"}, 
		 {"2707","��ʯ"}, 
		 {"2708","����"}, 
		 {"2709","�Ƹ�"}, 
		 {"2710","����"}, 
		 {"2717","��Ѩ"}, 
		 {"2717","���"}, 
		 {"2717","���"}, 
		 {"2711","ʮ��"}, 
		 {"2713","��ʩ"}, 
		 {"2717","����"}, 
		 {"2717","����"}, 
		 {"2717","����"}, 
		 {"2717","���"}, 
		 {"2717","Ӧ��"}, 
		 {"2714","Ǳ��"}, 
		 {"2717","��½"}, 
		 {"2716","����"}, 
		 {"2712","����"}, 
		 {"2717","ʯ��"}, 
		 {"3200","�Ĵ�ʡ"}, 
		 {"3201","�ɶ�"}, 
		 {"3212","�Թ�"}, 
		 {"3205","��֦��"}, 
		 {"3204","�ڽ�"}, 
		 {"3202","�˱�"}, 
		 {"3203","����"}, 
		 {"3222","����"}, 
		 {"3206","����"}, 
		 {"3207","�Ű� "}, 
		 {"3208","����"}, 
		 {"3209","�ϳ�"}, 
		 {"3210","����"}, 
		 {"3211","��Ԫ"}, 
		 {"3222","������ "}, 
		 {"3216","����"}, 
		 {"3222","����"}, 
		 {"3213","��ɽ"}, 
		 {"1300","������"}, 
		 {"1800","�ӱ�ʡ"}, 
		 {"1801","ʯ��ׯ"}, 
		 {"1812","����"}, 
		 {"1812","����"}, 
		 {"1802","����"}, 
		 {"1803","����"}, 
		 {"1804","�żҿ�"}, 
		 {"1805","�ػʵ�"}, 
		 {"1812","����"}, 
		 {"1806","��̨"}, 
		 {"1812","��ͷ"}, 
		 {"1807","��ɽ"}, 
		 {"1808","�ȷ�"}, 
		 {"1812","������"}, 
		 {"1812","�Ϲ�"}, 
		 {"1809","��ˮ"}, 
		 {"1812","ɳ��"}, 
		 {"1810","����"}, 
		 {"1812","����"}, 
		 {"1811","�е�"}, 
		 {"1000","�Ϻ���"}, 
		 {"1100","������"}, 
		 {"1200","�����"}, 
		 {"2600","ɽ��ʡ"}, 
		 {"2601","̫ԭ"}, 
		 {"2602","��ͬ"}, 
		 {"2603","����"}, 
		 {"2604","�ٷ�"}, 
		 {"2605","�˳�"}, 
		 {"2606","����"}, 
		 {"2612","�ܴ�"}, 
		 {"2612","����"}, 
		 {"2607","��Ȫ"}, 
		 {"2608","����"}, 
		 {"3000","���ɹ�������"}, 
		 {"3001","���ͺ���"}, 
		 {"3002","���"}, 
		 {"3003","��ͷ"}, 
		 {"3013","��������"}, 
		 {"3013","�ٺ�"}, 
		 {"3013","��ʤ"}, 
		 {"3013","������"}, 
		 {"3013","��������"}, 
		 {"3013","���ֹ���"}, 
		 {"3013","����"}, 
		 {"3004","�ں�"}, 
		 {"3013","������"}, 
		 {"3013","����ʯ"}, 
		 {"3013","���ֺ���"}, 
		 {"3005","ͨ��"}, 
		 {"2100","����ʡ"}, 
		 {"2101","����"}, 
		 {"2102","����"}, 
		 {"2103","��˳"}, 
		 {"2104","����"}, 
		 {"2105","��Ϫ"}, 
		 {"2106","Ӫ��"}, 
		 {"2107","����"}, 
		 {"2115","�˳�"}, 
		 {"2115","��Ʊ"}, 
		 {"2108","�̽�"}, 
		 {"2109","����"}, 
		 {"2115","����"}, 
		 {"2115","�߷���"}, 
		 {"2110","��ɽ"}, 
		 {"2111","����"}, 
		 {"2115","����"}, 
		 {"2112","����"}, 
		 {"2113","����"}, 
		 {"2115","����"}, 
		 {"2200","����ʡ"}, 
		 {"2201","����"}, 
		 {"2206","����"}, 
		 {"2202","ͨ��"}, 
		 {"2210","���"}, 
		 {"2210","����"}, 
		 {"2210","�Ӽ�"}, 
		 {"2210","ͼ��"}, 
		 {"2210","����"}, 
		 {"2210","�ػ�"}, 
		 {"2210","���� "}, 
		 {"2210","�뽭"}, 
		 {"2203","��ƽ"}, 
		 {"2210","÷�ӿ�"}, 
		 {"2210","������"}, 
		 {"2210","��Զ"}, 
		 {"2205","�׳�"}, 
		 {"2210","��̨"}, 
		 {"2210","���"}, 
		 {"2000","������ʡ"}, 
		 {"2001","������"}, 
		 {"2002","��ľ˹"}, 
		 {"2003","ĵ����"}, 
		 {"2004","����"}, 
		 {"2005","�������"}, 
		 {"2014","���� "}, 
		 {"2014","�ض�"}, 
		 {"2006","�绯"}, 
		 {"2007","����"}, 
		 {"2009","��̨��"}, 
		 {"2008","�׸�"}, 
		 {"2014","ͬ��"}, 
		 {"2010","˫Ѽ"}, 
		 {"2014","��ں�"}, 
		 {"2011","����"}, 
		 {"2014","����"}, 
		 {"2012","�ں�"}, 
		 {"2014","�������"}, 
		 {"1600","����ʡ"}, 
		 {"1601","�Ͼ�"}, 
		 {"1610","��Ǩ"}, 
		 {"1602","����"}, 
		 {"1603","����"}, 
		 {"1604","����"}, 
		 {"1605","����"}, 
		 {"1606","��"}, 
		 {"1607","��ͨ"}, 
		 {"1614","����"}, 
		 {"1609","����"}, 
		 {"1608","���Ƹ�"}, 
		 {"1614","����"}, 
		 {"1614","��̨"}, 
		 {"1611","̩��"}, 
		 {"1614","����"}, 
		 {"1614","����"}, 
		 {"1614","����"}, 
		 {"1614","����"}, 
		 {"1613","����"}, 
		 {"1612","�γ�"}, 
		 {"1614","�˻�"}, 
		 {"1614","����"}, 
		 {"1614","����"}, 
		 {"1500","�㽭ʡ"}, 
		 {"1501","����"}, 
		 {"1512","�ٺ�"}, 
		 {"1507","����"}, 
		 {"1502","����"}, 
		 {"1503","����"}, 
		 {"1504","��"}, 
		 {"1512","����"}, 
		 {"1505","����"}, 
		 {"1506","����"}, 
		 {"1512","��Ҧ"}, 
		 {"1512","��ɽ"}, 
		 {"1512","�ٰ�"}, 
		 {"1512","����"}, 
		 {"1512","����"}, 
		 {"1512","����"}, 
		 {"1512","ͩ��"}, 
		 {"1508","����"}, 
		 {"1512","����"}, 
		 {"1512","����"}, 
		 {"1512","��Ϫ"}, 
		 {"1512","걺�"}, 
		 {"1512","����"}, 
		 {"1512","����"}, 
		 {"1510","̨��"}, 
		 {"1509","��ˮ"}, 
		 {"2400","����ʡ"}, 
		 {"2401","�Ϸ�"}, 
		 {"2418","���"}, 
		 {"2402","�ߺ�"}, 
		 {"2404","����"}, 
		 {"2403","����ɽ"}, 
		 {"2405","ͭ��"}, 
		 {"2406","����"}, 
		 {"2407","����"}, 
		 {"2408","����"}, 
		 {"2409","����"}, 
		 {"2410","��ɽ"}, 
		 {"2411","����"}, 
		 {"2412","����"}, 
		 {"2413","���� "}, 
		 {"2414","����"}, 
		 {"2418","����"}, 
		 {"2410","��ɽ"}, 
		 {"2416","����"}, 
		 {"1700","����ʡ"}, 
		 {"1701","����"}, 
		 {"1710","����"}, 
		 {"1702","����"}, 
		 {"1703","Ȫ��"}, 
		 {"1704","����"}, 
		 {"1710","ʯʨ"}, 
		 {"1705","����"}, 
		 {"1706","��ƽ"}, 
		 {"1707","����"}, 
		 {"1710","���� "}, 
		 {"1708","����"}, 
		 {"2500","ɽ��ʡ"}, 
		 {"2501","����"}, 
		 {"2506","����"}, 
		 {"2518","����"}, 
		 {"2516","��Ӫ"}, 
		 {"2502","�ൺ"}, 
		 {"2503","��̨"}, 
		 {"2504","�Ͳ�"}, 
		 {"2505","Ϋ��"}, 
		 {"2507","����"}, 
		 {"2508","����"}, 
		 {"2509","����"}, 
		 {"2518","����"}, 
		 {"2510","����"}, 
		 {"2518","����"}, 
		 {"2511","�ĳ�"}, 
		 {"2512","����"}, 
		 {"2513","����"}, 
		 {"2518","����"}, 
		 {"2514","����"}, 
		 {"2515","̩��"}, 
		 {"2518","��̩"}, 
		 {"2518","���"}, 
		 {"2517","��ׯ"}, 
		 {"2509","����"}, 
		 {"1900","����ʡ"}, 
		 {"1918","����"}, 
		 {"1901","֣��"}, 
		 {"1902","����"}, 
		 {"1903","����"}, 
		 {"1904","�ױ�"}, 
		 {"1905","����"}, 
		 {"1906","����"}, 
		 {"1907","פ����"}, 
		 {"1908","�ܿ�"}, 
		 {"1909","����"}, 
		 {"1910","����"}, 
		 {"1913","����"}, 
		 {"1911","���"}, 
		 {"1912","���"}, 
		 {"1914","ƽ��"}, 
		 {"1915","����Ͽ"}, 
		 {"1916","����"}, 
		 {"1917","����"}, 
		 {"3100","����������"}, 
		 {"3101","����"}, 
		 {"3103","����"}, 
		 {"3104","����"}, 
		 {"3102","����"}, 
		 {"3111","����"}, 
		 {"3105","����"}, 
		 {"3106","��ɫ"}, 
		 {"3107","�ӳ�"}, 
		 {"3115","ƾ��"}, 
		 {"3110","����"}, 
		 {"3115","��ɽ"}, 
		 {"3300","����ʡ"}, 
		 {"3301","����"}, 
		 {"3302","����"}, 
		 {"3303","ͭ��"}, 
		 {"3310","����"}, 
		 {"3310","����"}, 
		 {"3310","��ˮ"}, 
		 {"3304","����ˮ"}, 
		 {"3305","��˳"}, 
		 {"3310","����"}, 
		 {"3400","����ʡ"}, 
		 {"3401","������"}, 
		 {"3402","������"}, 
		 {"3404","��Ϫ��"}, 
		 {"3409","��ɽ��"}, 
		 {"3408","��ͨ��"}, 
		 {"3405","������"}, 
		 {"3417","�ն���"}, 
		 {"3412","�ٲ���"}, 
		 {"3413","�º���徰����������"}, 
		 {"3414","ŭ��������������"}, 
		 {"3407","�������������"}, 
		 {"3403","��������������"}, 
		 {"3406","��������������"}, 
		 {"3415","��ӹ���������������"}, 
		 {"3410","��ɽ׳������������"}, 
		 {"3416","��˫���ɴ���������"}, 
		 {"3900","����������"}, 
		 {"2300","����ʡ"}, 
		 {"2301","����"}, 
		 {"2302","����"}, 
		 {"2303","����"}, 
		 {"2304","ͭ��"}, 
		 {"2305","μ��"}, 
		 {"2306","�Ӱ�"}, 
		 {"2307","����"}, 
		 {"2311","����"}, 
		 {"3500","����ʡ"}, 
		 {"3501","����"}, 
		 {"3502","��Ȫ"}, 
		 {"3503","����"}, 
		 {"3504","��Ҵ"}, 
		 {"3505","������"}, 
		 {"3506","���"}, 
		 {"3507","ƽ��"}, 
		 {"3508","����"}, 
		 {"3509","����"}, 
		 {"3515","����"}, 
		 {"3510","��ˮ"}, 
		 {"3515","����"}, 
		 {"3600","�ຣʡ"}, 
		 {"3601","����"}, 
		 {"3609","���ľ"}, 
		 {"3609","����"}, 
		 {"3609","�����"}, 
		 {"3700","����������"}, 
		 {"3701","����"}, 
		 {"3705","��ͭϿ"}, 
		 {"3702","����"}, 
		 {"3703","ʯ��ɽ"}, 
		 {"3800","�½�������"}, 
		 {"3801","��³ľ����"}, 
		 {"3813","ʯ������"}, 
		 {"3802","����������"}, 
		 {"3813","�������"}, 
		 {"3813","��������"}, 
		 {"3813","ͼľ�����"}, 
		 {"3813","������"}, 
		 {"3813","������"}, 
		 {"3813","������"}, 
		 {"3813","������"}, 
		 {"3813","����̩��"}, 
		 {"3810","������"}, 
		 {"3813","������"}, 
		 {"3813","��Ȫ��"}, 
		 {"3813","������"}, 
		 {"3807","������"}, 
		 {"3813","��ͼ����"}, 
		 {"3804","��������"}, 
		 {"3806","��ʲ��"}, 
		 {"3803","������"}, 
		 {"3813","�������"}, 
		 {"3805","��³����"}, 
		 {"4100","����ر�������"}, 
		 {"4300","̨��ʡ"}, 
		 {"4200","�����ر�������"}, 
		 {"4000","����ʡ"}, 
		 {"4001","����"}, 
		 {"4002","����"}, 
		 {"4003","����"}, 
		 {"4003","ͨʲ"}, 
		 {"4003","�Ĳ�"}, 
		 {"4003","����"}, 
		 {"4003","��ˮ"}, 
		 {"4003","��ָɽ"}, 
		 {"4003","����"}, 
		 {"4003","����"}, 
		 {"4003","����"}, 
		 {"4003","����"}, 
		 {"4003","�Ͳ�"}, 
		 {"4003","�ٸ�"}, 
		 {"4003","����"}, 
		 {"4003","��ɳ"}, 
		 {"4003","����"}, 
		 {"4003","�ֶ�"}, 
		 {"4003","��ͤ"}, 
		 {"4400","����"}, 
	 };
	 
	 public static String[][] jobCode =
	 {
		 {"1000","�����ҵ(IT)��"},
		 {"1003","���ݿ⿪�������(DBA)"},
		 {"1005","ϵͳ����Ա"},
		 {"1015","��������ʦ"},
		 {"1019","��ҳ���ʦ"},
		 {"1022","��������"},
		 {"1020","��վ�߻�"},
		 {"1021","��վ�༭"},
		 {"1023","��Ŀ������"},
		 {"1012","INTERNET/WEB/��������"},
		 {"1099","���Թ���ʦ"},
		 {"1009","MRP/ERP/SAPʵʩ����ʦ"},
		 {"1105","ϵͳ����/����֧��"},
		 {"1018","Ӳ������ʦ"},
		 {"1006","ϵͳά��Ա"},
		 {"1008","�������Ա"},
		 {"1099","CAM��MI����ʦ�뼼��Ա"},
		 {"1011","��ý��/��Ϸ��������ʦ"},
		 {"1010","��վ���򿪷�"},
		 {"1099","��ӡ/��ӡ/����ά��"},
		 {"1099","���������Ա"},
	 
		 {"1400","������"},
		 {"1403","���۲�����"},
		 {"1404","��������"},
		 {"1501","���۴���"},
		 {"1405","��������"},
		 {"1504","�ƣ�Ӫ����Ա"},
		 {"1402","���۹���ʦ"},
		 {"1410","������/����רԱ"},
		 {"1406","��������"},
		 {"1407","��������"},
		 {"1409","�������۾���"},
		 {"1408","��������"},
		 {"1503","ҵ��Ա"},
		 
		 {"1700","�г�Ӫ��/������"},
		 {"1715","�г�/Ӫ������"},
		 {"1705","�г�����/רԱ"},
		 {"1706","�г�������"},
		 {"1707","�г�����/ҵ�����"},
		 {"1708","�г�/������"},
		 {"1710","��Ʒ/Ʒ����"},
		 {"1711","Ʒ�ƾ���"},
		 {"1712","�۸���"},
		 {"1713","�����"},
		 {"1701","����ý����"},
		 {"1709","�г��ƹ�/��չ/����"},
		 {"1702","����/����רԱ"},
		 {"1703","���ؾ���"},
		 {"1704","����רԱ"},
		 
		 {"1600","�ͻ�������"},
		 {"1606","�ͻ�������"},
		 {"1699","�ͻ����ݿ����"},
		 {"1604","�ͻ���ϵ����"},
		 {"1699","�ͻ���ѵ"},
		 {"1605","�ͻ���ѯ"},
		 {"1605","������ѯ"},
		 {"1601","�ͻ�����"},
		 {"1602","��ǰ/�ۺ�֧��"},
		 {"1603","Ͷ�ߴ���"},
		 {"1699","Ͷ�߼��"},
		 {"1699","�ͻ�����"},
		 
		 {"1800","��Ӫ/������"},
		 {"1801","(��/��)�ܲ�/�ܾ���/CEO"},
		 {"1810","����/������"},
		 {"1111","�����ܼ�CTO"},
		 {"1899","�г��ܼ�"},
		 {"2203","������Դ�ܼ�"},
		 {"2208","�����ܼ�"},
		 {"1112","��Ϣ����/CIO"},
		 {"1807","���ž���"},
		 {"1807","��������"},
		 {"1808","�ܾ�������"},
		 {"1809","��������"},
		 {"1811","��Ŀ����"},
		 {"2018","�����ܼ�"},
		 
		 {"2000","����/��(ͳ)����"},
		 {"2015","��������/����"},
		 {"2005","���"},
		 {"2005","�������"},
		 {"2002","����"},
		 {"2004","ע����ʦ"},
		 {"2014","ע�����ʦ"},
		 {"2013","���"},
		 {"2003","ͳ��"},
		 {"2017","�������"},
		 {"2008","�ɱ�����/����"},
		 {"2006","��Ŀ(������)����"},
		 
		 {"2300","��˾��ְ��"},
		 {"2307","ͼ���鱨/��������"},
		 {"2301","�İ��߻�/���ϱ�д"},
		 {"2305","�߼���Ա"},
		 {"2302","�߼�����"},
		 {"2306","���Բ���Ա/����Ա"},
		 {"2304","ǰ̨��Ա�Ӵ�"},
		 {"2303","����Ա"},
		 {"2305","��Ա"},
		 
		 {"2200","����/������"},
		 {"2204","���¾���"},
		 {"2209","��������"},
		 {"2205","��������"},
		 {"2210","��������"},
		 {"2205","������Ա"},
		 {"2210","������Ա"},
		 {"2214","����"},
		 {"2202","н�ʸ�������/����/רԱ"},
		 {"2206","��Ч���˾���/����/רԱ"},
		 {"2201","Ա����ѵ����/����"},
		 {"2207","��Ƹ����/����"},
		 {"2207","��ƸרԱ"},
		 
		 {"2400","��ҵ/������"},
		 {"2426","��Ʒ����"},
		 {"2424","��������"},
		 {"2424","��������/����"},
		 {"2408","����Ա"},
		 {"2409","PE����ʦ"},
		 {"2410","IE����ʦ"},
		 {"2406","���չ���ʦ"},
		 {"2413","�鳤/����"},
		 {"2425","���̾���/����"},
		 {"2412","�����豸����ʦ"},
		 {"2502","Ʒ�ܾ���/����"},
		 {"2508","Ʒ�ʹ���ʦ"},
		 {"2507","Ʒ��Ա"},
		 {"2505","ISOרԱ"},
		 {"2422","��ؾ���/����"},
		 {"2414","���Ա"},
		 {"2402","�ֿ����Ա"},
		 {"2403","�ƻ�Ա/����Ա"},
		 {"2423","�豸����/����"},
		 {"2506","����/����Ա"},
		 {"2516","��ȫ����"},
		 {"2404","����Ա"},
		 {"2415","ͳ��Ա"},
		 {"2427","�ɹ�����"},
		 {"2405","SMT����Ա"},
		 {"2411","ME����ʦ"},
		 {"2416","����γ�"},
		 {"2417","RD����"},
		 {"2499","�豸����Ա"},
		 {"2401","���Ϲ���������Ա"},
		 {"2419","�������"},
		 {"2405","PMC����ʦ"},
		 {"2499","�շ�Ա"},
		 {"2418","�����ɲ�"},
		 
		 {"1300","����ͨѶ/����(��)��"},
		 {"1301","���ӹ���ʦ"},
		 {"1302","��������ʦ"},
		 {"1303","��������ʦ"},
		 {"1304","��������ʦ"},
		 {"1203","���Ź���ʦ/ͨѶ����ʦ"},
		 {"1311","��ѹ��/�ŵ繤��ʦ"},
		 {"1312","��������ʦ"},
		 {"1323","�����Ʒ��������ʦ"},
		 {"1317","��Ƭ��/DSP/�ײ���������"},
		 {"1306","��·(����)���"},
		 {"1307","���ܴ���/�ۺϲ���/����"},
		 {"1318","��Դ����������"},
		 {"1319","�����з�����ʦ"},
		 {"1320","����ά��"},
		 {"1308","�Զ�����"},
		 {"1309","���ߵ缼��"},
		 {"1310","�뵼�弼��"},
		 {"1321","���õ���"},
		 {"1322","С�ҵ�"},
		 {"1305","���Թ���ʦ"},
		 
		 {"2600","��е(��)/�Ǳ���"},
		 {"2605","��е���������"},
		 {"2606","��е����ʦ"},
		 {"2604","��е����ʦ"},
		 {"2701","ģ�߹���ʦ"},
		 {"2716","���߹���ʦ"},
		 {"2608","CNC����ʦ"},
		 {"2602","�ṹ���ʦ"},
		 {"2616","����һ�廯"},
		 {"2617","����/����"},
		 {"2707","ע�ܳ���"},
		 {"2615","����/Һѹ"},
		 {"2601","��е��ͼ"},
		 {"2611","���ܻ�е/�����Ǳ�"},
		 {"2620","�豸����"},
		 {"2613","����/Ħ�г�����ʦ"},
		 {"2622","�����/������Ʒ"},
		 {"2619","��¯/ѹ������"},
		 {"2612","��֯��е"},
		 {"2607","������е"},
		 {"2609","ʳƷ��е"},
		 {"2610","���ӻ�е"},
		 
		 {"2100","����/����/֤ȯ��"},
		 {"2106","֤ȯ�ڻ�"},
		 {"2129","�����Ŵ�"},
		 {"2110","����Ͷ�ʷ���"},
		 {"2114","���ʾ���/����"},
		 {"2125","����Ա/����רԱ"},
		 {"2126","Ԥ����רԱ"},
		 {"2001","˰��רԱ"},
		 {"2101","����ʦ"},
		 {"2112","���ɲ�����"},
		 {"2118","����ҵ��/���վ�����/���մ�����"},
		 {"2104","����ʦ"},
		 {"2115","����רԱ/����"},
		 {"2102","����ʦ"},
		 {"2110","֤ȯ/Ͷ��/����/�ڻ�����"},
		 
		 {"2800","���ز�/����ʩ����"},
		 {"2807","���ز�����/�߻�"},
		 {"2808","���ز�����"},
		 {"2801","���ز��н�"},
		 {"2804","��ҵ����"},
		 {"2903","����(�ṹ)����ʦ"},
		 {"2905","ע�Ὠ��ʦ"},
		 {"2904","������ͼ"},
		 {"2914","���̼���"},
		 {"2916","�ܵ�(ˮ����)"},
		 {"2918","����ůͨ"},
		 {"2917","����ˮ/��ˮ(��)����"},
		 {"2907","����"},
		 {"2911","����Ԥ����/ʩ��"},
		 {"2912","·�ż���/��������"},
		 {"2913","����/��������"},
		 {"2919","�ۿ��뺽������"},
		 {"2921","԰�չ���/԰�ּ���"},
		 {"2910","�������/Ԥ���㹤��ʦ"},
		 {"2902","����/����רԱ"},
		 {"2906","��������ʦ"},
		 {"2901","Ͷ������"},
		 
		 {"3000","���(װ�ꡢ��װ)�����"},
		 {"3017","ƽ�����"},
		 {"3007","��ά�������"},
		 {"3008","��ý�����������"},
		 {"3010","��Ʒ��װ���"},
		 {"3004","����(��)װ��/װ�����"},
		 {"3011","����Ʒ���"},
		 {"3012","��ҵ��Ʒ���"},
		 {"3014","��֯/����(װ)���"},
		 {"3017","�������"},
		 {"3018","������"},
		 {"3019","�鱦���"},
		 {"3003","�İ�/ý��߻�"},
		 {"3002","������/����߻�"},
		 {"1013","������������CAD"},
		 {"3099","������/��������"},
		 {"3099","D��ģ"},
		 {"3016","�Ҿ����"},
		 
		 {"3200","����/����/��ѵ��"},
		 {"4409","���ų���"},
		 {"3111","����"},
		 {"3100","�㲥����(Ӱ)"},
		 {"3201","�Ļ�����"},
		 {"3205","�ߵȽ���"},
		 {"3206","�м�����"},
		 {"3208","Сѧ/�׶�����"},
		 {"3209","����/����"},
		 {"3212","ְҵ����/��ѵ"},
		 {"3299","԰��"},
		 {"3210","�ҽ�"},
		 
		 {"3300","����ҽ��/���ݱ�����"},
		 {"3301","ҽ��/ҽʦ"},
		 {"3302","����ҽ��"},
		 {"3302","����ҽ��"},
		 {"3302","���ҽ��"},
		 {"3302","������ҽ��"},
		 {"3302","Ԥ��ҽ��"},
		 {"3303","��ʿ/����"},
		 {"3312","����/����"},
		 {"3310","����/����"},
		 {"3306","ҩ��/��ҩ/��ҩ/ҩ��"},
		 {"3304","�������"},
		 {"3305","�ٴ�ҽѧ"},
		 {"3304","���ױ���"},
		 {"3304","��������"},
		 {"3420","ҽҩ����"},
		 {"3421","ҽҩ����"},
		 {"3308","��ҽ"},
		 {"3309","��ױ/����/����ʦ"},
		 {"3315","��ԡ��ʦ/ϴͷ��ʦ"},
		 {"3310","����ʦ"},
		 {"3311","����ʦ"},
		 {"3312","����/Ӫ��ʦ"},
		 
		 {"3400","����/��ҩ��"},
		 {"3403","���û���"},
		 {"3405","���ﻯ��/������ҩ"},
		 {"3406","��ֽ/��Ʒ����"},
		 {"3413","��ѧҩ��/ҩƷ"},
		 {"3408","����/�����ι�ҵ"},
		 {"3409","ũҩ������"},
		 {"3410","�޻�����"},
		 {"3410","�л�����"},
		 {"3412","��ϸ����"},
		 {"3412","��������"},
		 {"3411","�߷��ӻ���/����/�²���"},
		 {"3412","��ƻ���"},
		 
		 {"3500","��Դ������"},
		 {"3501","ˮ����ˮ��"},
		 {"3502","�˵硢���"},
		 {"3503","�糧������"},
		 {"3504","���䡢ůͨ"},
		 {"3505","�յ�����¯"},
		 {"3506","ʯ��/��ȼ��/����"},
		 {"3508","����ȼ��"},
		 
		 {"3600","���ݷ���/����������"},
		 {"3602","���þ���/����"},
		 {"3604","�Ƶ����"},
		 {"3603","¥�澭��/����"},
		 {"3607","����Ա/����/��ͯ"},
		 {"3608","�߼���ʦ/����ʦ"},
		 {"3613","����"},
		 {"3606","ǰ̨�Ӵ�/����/������"},
		 {"3699","��±��ʦ��"},
		 {"3610","���/���ʦ��"},
		 {"3608","��/����ʦ"},
		 {"3610","���ĳ�ʦ"},
		 {"3699","���/ˮ̨/ճ��"},
		 
		 {"3900","�̵�/���۷�����"},
		 {"3904","�곤"},
		 {"3906","Ӫ������"},
		 {"3901","ӪҵԱ/����Ա/��Ա"},
		 {"3907","����Ա"},
		 {"3902","����Ա"},
		 {"3903","����Ա"},
		 
		 {"4000","����/�չ���"},
		 {"4005","����ϳ���١�ĥ"},
		 {"4005","ǯ���ӡ�í���塢������"},
		 {"4008","�á����������졢�١���"},
		 {"4012","ˮ��/ľ��/���Ṥ"},
		 {"4002","�繤"},
		 {"4010","��¯��"},
		 {"4014","��ͨ����"},
		 {"4011","Ħ�г�/�泵/����ά�޹�"},
		 {"4101","װ�乤/��װ��"},
		 {"4016","���س���/CNC/ģ�߹�"},
		 {"4010","�յ�/����ά�޹�"},
		 {"3705","ӡˢ����/����"},
		 {"4015","��߼���"},
		 {"4015","�մɼ���"},
		 {"4015","��Ƽ���"},
		 {"2712","���и�"},
		 
		 {"4100","�Ṥ��"},
		 {"4102","��װ��֯"},
		 {"4105","ӡˢ/Ⱦ������"},
		 {"4107","ֽ����ֽ����"},
		 {"4108","��Ь/����/�Ƹ�/�ִ�"},
		 {"4114","ʳƷ����/�Ǿ�����/���͸�ʳ"},
		 {"4116","�մɼ���"},
		 {"4115","�������μӹ�"},
		 {"4199","ע��ʦ��/��ƿʦ��"},
		 {"3808","��ɫʦ��/��ɫ/����Ա"},
		 {"4111","��װ����/�ư�"},
		 {"3806","ֽ��ʦ��/����"},
		 {"4110","����/�ͷ/�׸����ʦ"},
		 {"4109","����/���Ͽ���/�ɹ�רԱ"},
		 
		 {"4300","���ڱ�����"},
		 {"4206","���Ա"},
		 {"4310","Ѱ��/��Ѷ����"},
		 {"4305","��������"},
		 {"4306","��๤/����"},
		 {"4308","ʳ�ó�ʦ"},
		 {"4303","˾��"},
		 {"4309","����"},
		 {"4302","����"},
		 {"4399","�ͻ�Ա"},
		 
		 {"4500","������"},
		 {"4501","Ӣ�﷭��"},
		 {"4502","���﷭��"},
		 {"4503","���﷭��"},
		 {"4504","���﷭��"},
		 {"4505","���﷭��"},
		 {"4506","�����﷭��"},
		 {"4508","�������﷭��"},
		 {"4599","���﷭��"},
		 
		 {"4200","����/ó����"},
		 {"4204","��������"},
		 {"4204","��������"},
		 {"4211","�ֿ⾭��/����"},
		 {"4212","�ֿ����Ա"},
		 {"4208","���侭��/����"},
		 {"4205","��֤Ա"},
		 {"4206","���Ա"},
		 {"4201","��������Ա"},
		 {"4227","������Ա"},
		 {"4225","����Ա"},
		 {"4220","����ҵ��"},
		 {"4226","����Ա"},
		 {"4222","��óҵ��Ա"},
		 
		 {"1900","��ѯ/������"},
		 {"1913","��ҵ�߻�/����"},
		 {"1908","��ҵ����/��ܹ���"},
		 {"1909","������ѯʦ"},
		 {"1910","�߼���ͷ����"},
		 {"1911","��ѯ�ܼ�"},
		 {"1911","��ѯ����"},
		 {"1912","��ѯԱ"},
		 {"1912","��Ϣ�н�"},
		 {"1912","רҵ����"},
		 
		 {"1900","����רҵ��Ա��"},
		 {"1901","��ʦ"},
		 {"1902","���ɹ���"},
		 {"1903","������Ա"},
		 {"1904","��ʦ����"},
		 {"1905","���Ա"},
		 
		 {"3100","Ӱ��/��Ӱרҵ��"},
		 {"3101","Ӱ�Ӳ߻�/������Ա"},
		 {"3102","Ӱ�����Ĺ���"},
		 {"3112","��Ա"},
		 {"3105","ģ�ض�"},
		 {"3106","��Ӱʦ"},
		 {"3107","��Чʦ"},
		 {"3108","��Ŀ������"},
		 
		 {"4400","�༭/������"},
		 {"4401","�ܱ�"},
		 {"4401","���ܱ�"},
		 {"4403","�༭����"},
		 {"4411","�༭"},
		 {"4406","�����༭"},
		 {"4402","��������"},
		 {"4402","��������"},
		 
		 {"9900","ˮ����"},
		 {"9999","��������"},
		 {"9999","��������ֳ"},
		 {"9999","��ˮ��ֳ"},
		 {"9999","��ˮ��ֳ"},
		 {"9999","ˮ���ӹ�"},
		 {"9999","ˮ����ó"},
		 {"9999","�澭����"},
		 {"9999","ˮ������"},
		 {"9999","ˮ����ѧ"},
		 
		 {"9900","������"},
		 {"9902","��ͨ����"},
		 {"9903","���⼼��"},
		 {"9904","���＼��"},
		 {"9905","��漼��"},
		 {"9906","���⼼��"},
		 {"9907","���ʿ�̽"},
		 {"9908","���ұ��"},
		 {"9909","��������"},
		 {"9911","��������/���й滮"},
		 {"9910","ũ���֡������桢����"}
	 };
}