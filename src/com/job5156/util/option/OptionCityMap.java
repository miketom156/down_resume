package com.job5156.util.option;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OptionCityMap {

	public final static Map<Integer, Map<String, String>> OPT_MAP_CITY = new LinkedHashMap<>();
    public  static Map<Integer,List<Map<String,String>>>  OPT_MAP_PROVINCE_CITY  =null;//保存省份与其下城市
    public static List<Map<String,String>> OPT_LIST_PROVINCE  =null;//保存所有省份

	static {
        OPT_MAP_CITY.put(11000000, setCityMap("北京", "beijing", "BJ", "市", "010", "116.395645", "39.929986"));
        OPT_MAP_CITY.put(10000000, setCityMap("上海", "shanghai", "SH", "市", "021", "121.487899", "31.249162"));
        OPT_MAP_CITY.put(12000000, setCityMap("天津", "tianjin", "TJ", "市", "022", "117.210813", "39.14393"));
        OPT_MAP_CITY.put(13000000, setCityMap("重庆", "chongqing", "CQ", "市", "023", "106.530635", "29.544606"));
        OPT_MAP_CITY.put(14000000, setCityMap("广东", "guangdong", "GD", "省", "", "113.394818", "23.408004"));
        OPT_MAP_CITY.put(14030000, setCityMap("广州", "guangzhou", "GZ", "市", "020", "113.30765", "23.120049"));
        OPT_MAP_CITY.put(14020000, setCityMap("深圳", "shenzhen", "SZ", "市", "0755", "114.025974", "22.546054"));
        OPT_MAP_CITY.put(14010000, setCityMap("东莞", "dongguan", "DG", "市", "0769", "113.763434", "23.043024"));
        OPT_MAP_CITY.put(14040000, setCityMap("中山", "zhongshan", "ZS", "市", "0760", "113.42206", "22.545178"));
        OPT_MAP_CITY.put(14050000, setCityMap("珠海", "zhuhai", "ZH", "市", "0756", "113.562447", "22.256915"));
        OPT_MAP_CITY.put(14060000, setCityMap("汕头", "shantou", "ST", "市", "0754", "116.72865", "23.383908"));
        OPT_MAP_CITY.put(14070000, setCityMap("惠州", "huizhou", "HZ", "市", "0752", "114.410658", "23.11354"));
        OPT_MAP_CITY.put(14080000, setCityMap("江门", "jiangmen", "JM", "市", "0750", "113.078125", "22.575117"));
        OPT_MAP_CITY.put(14090000, setCityMap("佛山", "fushan", "FS", "市", "0757", "113.134026", "23.035095"));
        OPT_MAP_CITY.put(14100000, setCityMap("阳江", "yangjiang", "YJ", "市", "0662", "111.97701", "21.871517"));
        OPT_MAP_CITY.put(14110000, setCityMap("清远", "qingyuan", "QY", "市", "0763", "113.040773", "23.698469"));
        OPT_MAP_CITY.put(14120000, setCityMap("韶关", "shaoguan", "SG", "市", "0751", "113.594461", "24.80296"));
        OPT_MAP_CITY.put(14130000, setCityMap("肇庆", "zhaoqing", "ZQ", "市", "0758", "112.479653", "23.078663"));
        OPT_MAP_CITY.put(14140000, setCityMap("潮州", "chaozhou", "CZ", "市", "0768", "116.630076", "23.661812"));
        OPT_MAP_CITY.put(14150000, setCityMap("湛江", "zhanjiang", "ZJ", "市", "0759", "110.365067", "21.257463"));
        OPT_MAP_CITY.put(14160000, setCityMap("茂名", "maoming", "MM", "市", "0668", "110.931245", "21.668226"));
        OPT_MAP_CITY.put(14170000, setCityMap("梅州", "meizhou", "MZ", "市", "0753", "116.126403", "24.304571"));
        OPT_MAP_CITY.put(14180000, setCityMap("汕尾", "shanwei", "SW", "市", "0660", "115.372924", "22.778731"));
        OPT_MAP_CITY.put(14190000, setCityMap("河源", "heyuan", "HY", "市", "0762", "114.713721", "23.757251"));
        OPT_MAP_CITY.put(14200000, setCityMap("云浮", "yunfu", "YF", "市", "0766", "112.050946", "22.937976"));
        OPT_MAP_CITY.put(14210000, setCityMap("揭阳", "jieyang", "JY", "市", "0663", "116.379501", "23.547999"));
        OPT_MAP_CITY.put(14230000, setCityMap("顺德", "shunde", "SD", "市", "0757", "113.300001","22.810404"));
        OPT_MAP_CITY.put(14220000, setCityMap("其他", "Other", "O", "", "", "", ""));
        OPT_MAP_CITY.put(15000000, setCityMap("浙江", "zhejiang", "ZJ", "省", "", "119.957202", "29.159494"));
        OPT_MAP_CITY.put(15010000, setCityMap("杭州", "hangzhou", "HZ", "市", "0571", "120.219375", "30.259244"));
        OPT_MAP_CITY.put(15020000, setCityMap("宁波", "ningbo", "NB", "市", "0574", "121.579006", "29.885259"));
        OPT_MAP_CITY.put(15030000, setCityMap("温州", "wenzhou", "WZ", "市", "0577", "120.690635", "28.002838"));
        OPT_MAP_CITY.put(15040000, setCityMap("金华", "jinhua", "JH", "市", "0579", "119.652576", "29.102899"));
        OPT_MAP_CITY.put(15050000, setCityMap("绍兴", "shaoxing", "SX", "市", "0575", "120.592467", "30.002365"));
        OPT_MAP_CITY.put(15060000, setCityMap("湖州", "huzhou", "HZ", "市", "0572", "120.137243", "30.877925"));
        OPT_MAP_CITY.put(15070000, setCityMap("嘉兴", "jiaxing", "JX", "市", "0573", "120.760428", "30.773992"));
        OPT_MAP_CITY.put(15080000, setCityMap("衢州", "quzhou", "QZ", "市", "0570", "118.875842", "28.95691"));
        OPT_MAP_CITY.put(15090000, setCityMap("丽水", "lishui", "LS", "市", "0578", "119.929576", "28.4563"));
        OPT_MAP_CITY.put(15100000, setCityMap("台州", "taizhou", "TZ", "市", "0576", "121.440613", "28.668283"));
        OPT_MAP_CITY.put(15110000, setCityMap("舟山", "zhoushan", "ZS", "市", "0580", "122.169872", "30.03601"));
        OPT_MAP_CITY.put(15120000, setCityMap("其他", "Other", "O", "", "", "", ""));
        OPT_MAP_CITY.put(16000000, setCityMap("江苏", "jiangsu", "JS", "省", "", "119.368489", "33.013797"));
        OPT_MAP_CITY.put(16010000, setCityMap("南京", "nanjing", "NJ", "市", "025", "118.778074", "32.057236"));
        OPT_MAP_CITY.put(16020000, setCityMap("苏州", "suzhou", "SZ", "市", "0512", "120.619907", "31.317987"));
        OPT_MAP_CITY.put(16030000, setCityMap("无锡", "wuxi", "WX", "市", "0510", "120.305456", "31.570037"));
        OPT_MAP_CITY.put(16040000, setCityMap("扬州", "yangzhou", "YZ", "市", "0514", "119.427778", "32.408505"));
        OPT_MAP_CITY.put(16050000, setCityMap("常州", "changzhou", "CZ", "市", "0519", "119.981861", "31.771397"));
        OPT_MAP_CITY.put(16060000, setCityMap("镇江", "zhenjiang", "ZJ", "市", "0511", "119.455835", "32.204409"));
        OPT_MAP_CITY.put(16070000, setCityMap("南通", "nantong", "NT", "市", "0513", "120.873801", "32.014665"));
        OPT_MAP_CITY.put(16080000, setCityMap("连云港", "lianyungang", "LYG", "市", "0518", "119.173872", "34.601549"));
        OPT_MAP_CITY.put(16090000, setCityMap("徐州", "xuzhou", "XZ", "市", "0516", "117.188107", "34.271553"));
        OPT_MAP_CITY.put(16100000, setCityMap("宿迁", "suqian", "SQ", "市", "0527", "118.296893", "33.95205"));
        OPT_MAP_CITY.put(16110000, setCityMap("泰州", "taizhou", "TZ", "市", "0523", "119.919606", "32.476053"));
        OPT_MAP_CITY.put(16120000, setCityMap("盐城", "yancheng", "YC", "市", "0515", "120.148872", "33.379862"));
        OPT_MAP_CITY.put(16130000, setCityMap("淮安", "huaian", "HA", "市", "0517", "119.030186", "33.606513"));
        OPT_MAP_CITY.put(16140000, setCityMap("其他", "Other", "O", "", "", "", ""));
        OPT_MAP_CITY.put(17000000, setCityMap("福建", "fujian", "FJ", "省", "", "117.984943", "26.050118"));
        OPT_MAP_CITY.put(17010000, setCityMap("福州", "fuzhou", "FZ", "市", "0591", "119.330221", "26.047125"));
        OPT_MAP_CITY.put(17020000, setCityMap("厦门", "xiamen", "XM", "市", "0592", "118.103886", "24.489231"));
        OPT_MAP_CITY.put(17030000, setCityMap("泉州", "quanzhou", "QZ", "市", "0595", "118.600362", "24.901652"));
        OPT_MAP_CITY.put(17040000, setCityMap("漳州", "zhangzhou", "ZZ", "市", "0596", "117.676205", "24.517065"));
        OPT_MAP_CITY.put(17050000, setCityMap("三明", "sanming", "SM", "市", "0598", "117.642194", "26.270835"));
        OPT_MAP_CITY.put(17060000, setCityMap("南平", "nanping", "NP", "市", "0599", "118.181883", "26.643626"));
        OPT_MAP_CITY.put(17070000, setCityMap("莆田", "putian", "PT", "市", "0594", "119.077731", "25.44845"));
        OPT_MAP_CITY.put(17080000, setCityMap("龙岩", "longyan", "LY", "市", "0597", "117.017997", "25.078685"));
        OPT_MAP_CITY.put(17090000, setCityMap("宁德", "ningde", "ND", "市", "0593", "119.542082", "26.656527"));
        OPT_MAP_CITY.put(17100000, setCityMap("其他", "Other", "O", "", "", "", ""));
        OPT_MAP_CITY.put(18000000, setCityMap("河北", "hebei", "HB", "省", "", "115.661434", "38.61384"));
        OPT_MAP_CITY.put(18010000, setCityMap("石家庄", "shijiazhuang", "SJZ", "市", "0311", "114.522082", "38.048958"));
        OPT_MAP_CITY.put(18020000, setCityMap("邯郸", "handan", "HD", "市", "0310", "114.482694", "36.609308"));
        OPT_MAP_CITY.put(18030000, setCityMap("保定", "baoding", "BD", "市", "0312", "115.49481", "38.886565"));
        OPT_MAP_CITY.put(18040000, setCityMap("张家口", "zhangjiakou", "ZJK", "市", "0313", "114.893782", "40.811188"));
        OPT_MAP_CITY.put(18050000, setCityMap("秦皇岛", "qinhuangdao", "QHD", "市", "0335", "119.604368", "39.945462"));
        OPT_MAP_CITY.put(18060000, setCityMap("邢台", "xingtai", "XT", "市", "0319", "114.520487", "37.069531"));
        OPT_MAP_CITY.put(18070000, setCityMap("唐山", "tangshan", "TS", "市", "0315", "118.183451", "39.650531"));
        OPT_MAP_CITY.put(18080000, setCityMap("廊坊", "langfang", "LF", "市", "0316", "116.703602", "39.518611"));
        OPT_MAP_CITY.put(18090000, setCityMap("衡水", "hengshui", "HS", "市", "0318", "115.686229", "37.746929"));
        OPT_MAP_CITY.put(18100000, setCityMap("沧州", "cangzhou", "CZ", "市", "0317", "116.863806", "38.297615"));
        OPT_MAP_CITY.put(18110000, setCityMap("承德", "chengde", "CD", "市", "0314", "117.933822", "40.992521"));
        OPT_MAP_CITY.put(18120000, setCityMap("其他", "Other", "O", "", "", "", ""));
        OPT_MAP_CITY.put(19000000, setCityMap("河南", "henan", "HN", "省", "", "113.486804", "34.157184"));
        OPT_MAP_CITY.put(19010000, setCityMap("郑州", "zhengzhou", "ZZ", "市", "0371", "113.649644", "34.75661"));
        OPT_MAP_CITY.put(19020000, setCityMap("洛阳", "luoyang", "LY", "市", "0379", "112.447525", "34.657368"));
        OPT_MAP_CITY.put(19030000, setCityMap("开封", "kaifeng", "KF", "市", "0378", "114.351642", "34.801854"));
        OPT_MAP_CITY.put(19040000, setCityMap("鹤壁", "hebi", "HB", "市", "0392", "114.29777", "35.755426"));
        OPT_MAP_CITY.put(19050000, setCityMap("焦作", "jiaozuo", "JZ", "市", "0391", "113.211836", "35.234608"));
        OPT_MAP_CITY.put(19060000, setCityMap("许昌", "xuchang", "XC", "市", "0374", "113.835312", "34.02674"));
        OPT_MAP_CITY.put(19070000, setCityMap("驻马店", "zhumadian", "ZMD", "市", "0396", "114.049154", "32.983158"));
        OPT_MAP_CITY.put(19080000, setCityMap("周口", "zhoukou", "ZK", "市", "0394", "114.654102", "33.623741"));
        OPT_MAP_CITY.put(19090000, setCityMap("新乡", "xinxiang", "XX", "市", "0373", "113.91269", "35.307258"));
        OPT_MAP_CITY.put(19100000, setCityMap("安阳", "anyang", "AY", "市", "0372", "114.351807", "36.110267"));
        OPT_MAP_CITY.put(19110000, setCityMap("濮阳", "puyang", "PY", "市", "0393", "115.026627", "35.753298"));
        OPT_MAP_CITY.put(19120000, setCityMap("漯河", "luohe", "LH", "市", "0395", "114.046061", "33.576279"));
        OPT_MAP_CITY.put(19130000, setCityMap("信阳", "xinyang", "XY", "市", "0376", "114.085491", "32.128582"));
        OPT_MAP_CITY.put(19140000, setCityMap("平顶山", "pingdingshan", "PDS", "市", "0375", "113.300849", "33.745301"));
        OPT_MAP_CITY.put(19150000, setCityMap("三门峡", "sanmenxia", "SMX", "市", "0398", "111.181262", "34.78332"));
        OPT_MAP_CITY.put(19160000, setCityMap("南阳", "nanyang", "NY", "市", "0377", "112.542842", "33.01142"));
        OPT_MAP_CITY.put(19170000, setCityMap("商丘", "shangqiu", "SQ", "市", "0370", "115.641886", "34.438589"));
        OPT_MAP_CITY.put(19180000, setCityMap("其他", "Other", "O", "", "", "", ""));
        OPT_MAP_CITY.put(20000000, setCityMap("黑龙江", "heilongjiang", "HLJ", "省", "", "128.047414", "47.356592"));
        OPT_MAP_CITY.put(20010000, setCityMap("哈尔滨", "haerbin", "HEB", "市", "0451", "126.657717", "45.773225"));
        OPT_MAP_CITY.put(20020000, setCityMap("佳木斯", "jiamusi", "JMS", "市", "0454", "130.284735", "46.81378"));
        OPT_MAP_CITY.put(20030000, setCityMap("牡丹江", "mudanjiang", "MDJ", "市", "0453", "129.608035", "44.588521"));
        OPT_MAP_CITY.put(20040000, setCityMap("大庆", "daqing", "DQ", "市", "0459", "125.02184", "46.596709"));
        OPT_MAP_CITY.put(20050000, setCityMap("齐齐哈尔", "qiqihaer", "QQHE", "市", "0452", "123.987289", "47.3477"));
        OPT_MAP_CITY.put(20060000, setCityMap("绥化", "suihua", "SH", "市", "0455", "126.989095", "46.646064"));
        OPT_MAP_CITY.put(20070000, setCityMap("伊春", "yichun", "YC", "市", "0458", "128.910766", "47.734685"));
        OPT_MAP_CITY.put(20080000, setCityMap("鹤岗", "hegang", "HG", "市", "0468", "130.292472", "47.338666"));
        OPT_MAP_CITY.put(20090000, setCityMap("七台河", "qitaihe", "QTH", "市", "0464", "131.019048", "45.775005"));
        OPT_MAP_CITY.put(20100000, setCityMap("双鸭山", "shuangyashan", "SYS", "市", "0469", "131.171402", "46.655102"));
        OPT_MAP_CITY.put(20110000, setCityMap("鸡西", "jixi", "JX", "市", "0467", "130.941767", "45.32154"));
        OPT_MAP_CITY.put(20120000, setCityMap("黑河", "heihe", "HH", "市", "0456", "127.50083", "50.25069"));
        OPT_MAP_CITY.put(20130000, setCityMap("大兴安岭", "daxinganling", "DXAL", "地区", "0457", "124.196104", "51.991789"));
        OPT_MAP_CITY.put(20140000, setCityMap("其他", "Other", "O", "", "", "", ""));
        OPT_MAP_CITY.put(21000000, setCityMap("辽宁", "liaoning", "LN", "省", "", "122.753592", "41.6216"));
        OPT_MAP_CITY.put(21010000, setCityMap("沈阳", "shenyang", "SY", "市", "024", "123.432791", "41.808645"));
        OPT_MAP_CITY.put(21020000, setCityMap("铁岭", "tieling", "TL", "市", "0410", "123.85485", "42.299757"));
        OPT_MAP_CITY.put(21030000, setCityMap("抚顺", "fushun", "FS", "市", "0413", "123.92982", "41.877304"));
        OPT_MAP_CITY.put(21040000, setCityMap("大连", "dalian", "DL", "市", "0411", "121.593478", "38.94871"));
        OPT_MAP_CITY.put(21050000, setCityMap("本溪", "benxi", "BX", "市", "0414", "123.778062", "41.325838"));
        OPT_MAP_CITY.put(21060000, setCityMap("营口", "yingkou", "YK", "市", "0417", "122.233391", "40.668651"));
        OPT_MAP_CITY.put(21070000, setCityMap("锦州", "jinzhou", "JZ", "市", "0416", "121.147749", "41.130879"));
        OPT_MAP_CITY.put(21080000, setCityMap("盘锦", "panjin", "PJ", "市", "0427", "122.073228", "41.141248"));
        OPT_MAP_CITY.put(21090000, setCityMap("辽阳", "liaoyang", "LY", "市", "0419", "123.172451", "41.273339"));
        OPT_MAP_CITY.put(21100000, setCityMap("鞍山", "anshan", "AS", "市", "0412", "123.007763", "41.118744"));
        OPT_MAP_CITY.put(21110000, setCityMap("丹东", "dandong", "DD", "市", "0415", "124.338543", "40.129023"));
        OPT_MAP_CITY.put(21120000, setCityMap("朝阳", "chaoyang", "CY", "市", "0428", "120.446163", "41.571828"));
        OPT_MAP_CITY.put(21130000, setCityMap("阜新", "fuxin", "FX", "市", "0418", "121.660822", "42.01925"));
        OPT_MAP_CITY.put(21140000, setCityMap("葫芦岛", "huludao", "HLD", "市", "0429", "120.860758", "40.74303"));
        OPT_MAP_CITY.put(21150000, setCityMap("其他", "Other", "O", "", "", "", ""));
        OPT_MAP_CITY.put(22000000, setCityMap("吉林", "jilin", "JL", "省", "0432", "126.262876", "43.678846"));
        OPT_MAP_CITY.put(22010000, setCityMap("长春", "changchun", "CC", "市", "0431", "125.313642", "43.898338"));
        OPT_MAP_CITY.put(22020000, setCityMap("通化", "tonghua", "TH", "市", "0435", "125.94265", "41.736397"));
        OPT_MAP_CITY.put(22030000, setCityMap("四平", "siping", "SP", "市", "0434", "124.391382", "43.175525"));
        OPT_MAP_CITY.put(22040000, setCityMap("辽源", "liaoyuan", "LY", "市", "0437", "125.133686", "42.923303"));
        OPT_MAP_CITY.put(22050000, setCityMap("白城", "baicheng", "BC", "市", "0436", "122.840777", "45.621086"));
        OPT_MAP_CITY.put(22060000, setCityMap("吉林", "jilin", "JL", "市", "0432", "126.262876", "43.678846"));
        OPT_MAP_CITY.put(22070000, setCityMap("松原", "songyuan", "SY", "市", "0438", "124.832995", "45.136049"));
        OPT_MAP_CITY.put(22080000, setCityMap("白山", "baishan", "BS", "市", "0439", "126.435798", "41.945859"));
        OPT_MAP_CITY.put(22090000, setCityMap("延边", "yanbian", "YB", "州", "0433", "129.485902", "42.896414"));
        OPT_MAP_CITY.put(22100000, setCityMap("其他", "Other", "O", "", "", "", ""));
        OPT_MAP_CITY.put(23000000, setCityMap("陕西", "shanxi", "SX", "省", "", "109.503789", "35.860026"));
        OPT_MAP_CITY.put(23010000, setCityMap("西安", "xian", "XA", "市", "029", "108.953098", "34.2778"));
        OPT_MAP_CITY.put(23020000, setCityMap("咸阳", "xianyang", "XY", "市", "0910", "108.707509", "34.345373"));
        OPT_MAP_CITY.put(23030000, setCityMap("宝鸡", "baoji", "BJ", "市", "0917", "107.170645", "34.364081"));
        OPT_MAP_CITY.put(23040000, setCityMap("铜川", "tongchuan", "TC", "市", "0919", "108.968067", "34.908368"));
        OPT_MAP_CITY.put(23050000, setCityMap("渭南", "weinan", "WN", "市", "0913", "109.483933", "34.502358"));
        OPT_MAP_CITY.put(23060000, setCityMap("延安", "yanan", "YA", "市", "0911", "109.50051", "36.60332"));
        OPT_MAP_CITY.put(23070000, setCityMap("汉中", "hanzhong", "HZ", "市", "0916", "107.045478", "33.081569"));
        OPT_MAP_CITY.put(23080000, setCityMap("榆林", "yulin", "YL", "市", "0912", "109.745926", "38.279439"));
        OPT_MAP_CITY.put(23090000, setCityMap("商洛", "shangluo", "SL", "市", "0914", "109.934208", "33.873907"));
        OPT_MAP_CITY.put(23100000, setCityMap("安康", "ankang", "AK", "市", "0915", "109.038045", "32.70437"));
        OPT_MAP_CITY.put(23110000, setCityMap("其他", "Other", "O", "", "", "", ""));
        OPT_MAP_CITY.put(24000000, setCityMap("安徽", "anhui", "AH", "省", "", "117.216005", "31.859252"));
        OPT_MAP_CITY.put(24010000, setCityMap("合肥", "hefei", "HF", "市", "0551", "117.282699", "31.866942"));
        OPT_MAP_CITY.put(24020000, setCityMap("芜湖", "wuhu", "WH", "市", "0553", "118.384108", "31.36602"));
        OPT_MAP_CITY.put(24030000, setCityMap("马鞍山", "maanshan", "MAS", "市", "0555", "118.515882", "31.688528"));
        OPT_MAP_CITY.put(24040000, setCityMap("蚌埠", "bangbu", "BB", "", "0552", "117.35708", "32.929499"));
        OPT_MAP_CITY.put(24050000, setCityMap("铜陵", "tongling", "TL", "市", "0562", "117.819429", "30.94093"));
        OPT_MAP_CITY.put(24060000, setCityMap("淮北", "huaibei", "HB", "市", "0561", "116.791447", "33.960023"));
        OPT_MAP_CITY.put(24070000, setCityMap("淮南", "huainan", "HN", "市", "0554", "117.018639", "32.642812"));
        OPT_MAP_CITY.put(24080000, setCityMap("亳州", "bozhou", "BZ", "市", "0558", "115.787928", "33.871211"));
        OPT_MAP_CITY.put(24090000, setCityMap("巢湖", "chaohu", "CH", "市", "0565", "117.88049", "31.608733"));
        OPT_MAP_CITY.put(24100000, setCityMap("黄山", "huangshan", "HS", "市", "0559", "118.29357", "29.734435"));
        OPT_MAP_CITY.put(24110000, setCityMap("宿州", "suzhou", "SZ", "市", "0557", "116.988692", "33.636772"));
        OPT_MAP_CITY.put(24120000, setCityMap("阜阳", "fuyang", "FY", "市", "0558", "115.820932", "32.901211"));
        OPT_MAP_CITY.put(24130000, setCityMap("六安", "liuan", "LA", "市", "0564", "116.505253", "31.755558"));
        OPT_MAP_CITY.put(24140000, setCityMap("滁州", "chuzhou", "CZ", "市", "0550", "118.32457", "32.317351"));
        OPT_MAP_CITY.put(24150000, setCityMap("宣城", "xuancheng", "XC", "市", "0563", "118.752096", "30.951642"));
        OPT_MAP_CITY.put(24160000, setCityMap("安庆", "anqing", "AQ", "市", "0556", "117.058739", "30.537898"));
        OPT_MAP_CITY.put(24170000, setCityMap("池州", "chizhou", "CZ", "市", "0566", "117.494477", "30.660019"));
        OPT_MAP_CITY.put(24180000, setCityMap("其他", "Other", "O", "", "", "", ""));
        OPT_MAP_CITY.put(25000000, setCityMap("山东", "shandong", "SD", "省", "", "118.527663", "36.09929"));
        OPT_MAP_CITY.put(25010000, setCityMap("济南", "jinan", "JN", "市", "0531", "117.024967", "36.682785"));
        OPT_MAP_CITY.put(25020000, setCityMap("青岛", "qingdao", "QD", "市", "0532", "120.384428", "36.105215"));
        OPT_MAP_CITY.put(25030000, setCityMap("烟台", "yantai", "YT", "市", "0535", "121.309555", "37.536562"));
        OPT_MAP_CITY.put(25040000, setCityMap("淄博", "zibo", "ZB", "市", "0533", "118.059134", "36.804685"));
        OPT_MAP_CITY.put(25050000, setCityMap("潍坊", "weifang", "WF", "市", "0536", "119.142634", "36.716115"));
        OPT_MAP_CITY.put(25060000, setCityMap("临沂", "linyi", "LY", "市", "0539", "118.340768", "35.072409"));
        OPT_MAP_CITY.put(25070000, setCityMap("莱芜", "laiwu", "LW", "市", "0634", "117.684667", "36.233654"));
        OPT_MAP_CITY.put(25080000, setCityMap("济宁", "jining", "JN", "市", "0537", "116.600798", "35.402122"));
        OPT_MAP_CITY.put(25090000, setCityMap("荷泽", "heze", "HZ", "市", "0530", "115.472817", "35.275059"));
        OPT_MAP_CITY.put(25100000, setCityMap("日照", "rizhao", "RZ", "市", "0633", "119.50718", "35.420225"));
        OPT_MAP_CITY.put(25110000, setCityMap("聊城", "liaocheng", "LC", "市", "0635", "115.986869", "36.455829"));
        OPT_MAP_CITY.put(25120000, setCityMap("德州", "dezhou", "DZ", "市", "0534", "116.328161", "37.460826"));
        OPT_MAP_CITY.put(25130000, setCityMap("滨州", "binzhou", "BZ", "市", "0543", "117.968292", "37.405314"));
        OPT_MAP_CITY.put(25140000, setCityMap("威海", "weihai", "WH", "市", "0631", "122.093958", "37.528787"));
        OPT_MAP_CITY.put(25150000, setCityMap("泰安", "taian", "TA", "市", "0538", "117.089415", "36.188078"));
        OPT_MAP_CITY.put(25160000, setCityMap("东营", "dongying", "DY", "市", "0546", "118.583926", "37.487121"));
        OPT_MAP_CITY.put(25170000, setCityMap("枣庄", "zaozhuang", "ZZ", "市", "0632", "117.279305", "34.807883"));
        OPT_MAP_CITY.put(25180000, setCityMap("其他", "Other", "O", "", "", "", ""));
        OPT_MAP_CITY.put(26000000, setCityMap("山西", "shanxi", "SX", "省", "", "112.515496", "37.866566"));
        OPT_MAP_CITY.put(26010000, setCityMap("太原", "taiyuan", "TY", "市", "0351", "112.550864", "37.890277"));
        OPT_MAP_CITY.put(26020000, setCityMap("大同", "datong", "DT", "市", "0352", "113.290509", "40.113744"));
        OPT_MAP_CITY.put(26030000, setCityMap("忻州", "xinzhou", "XZ", "市", "0350", "112.727939", "38.461031"));
        OPT_MAP_CITY.put(26040000, setCityMap("临汾", "linfen", "LF", "市", "0357", "111.538788", "36.099745"));
        OPT_MAP_CITY.put(26050000, setCityMap("运城", "yuncheng", "YC", "市", "0359", "111.006854", "35.038859"));
        OPT_MAP_CITY.put(26060000, setCityMap("长治", "changzhi", "CZ", "市", "0355", "113.120292", "36.201664"));
        OPT_MAP_CITY.put(26070000, setCityMap("阳泉", "yangquan", "YQ", "市", "0353", "113.569238", "37.869529"));
        OPT_MAP_CITY.put(26080000, setCityMap("晋城", "jincheng", "JC", "市", "0356", "112.867333", "35.499834"));
        OPT_MAP_CITY.put(26090000, setCityMap("朔州", "shuozhou", "SZ", "市", "0349", "112.479928", "39.337672"));
        OPT_MAP_CITY.put(26100000, setCityMap("晋中", "jinzhong", "JZ", "市", "0354", "112.738514", "37.693362"));
        OPT_MAP_CITY.put(26110000, setCityMap("吕梁", "lvliang", "LL", "市", "0358", "111.143157", "37.527316"));
        OPT_MAP_CITY.put(26120000, setCityMap("其他", "Other", "O", "", "", "", ""));
        OPT_MAP_CITY.put(27000000, setCityMap("湖北", "hubei", "HB", "省", "", "112.410562", "31.209316"));
        OPT_MAP_CITY.put(27010000, setCityMap("武汉", "wuhan", "WH", "市", "027", "114.3162", "30.581084"));
        OPT_MAP_CITY.put(27020000, setCityMap("宜昌", "yichang", "YC", "市", "0717", "111.310981", "30.732758"));
        OPT_MAP_CITY.put(27030000, setCityMap("孝感", "xiaogan", "XG", "市", "0712", "113.935734", "30.927955"));
        OPT_MAP_CITY.put(27040000, setCityMap("荆州", "jingzhou", "JZ", "市", "0716", "112.241866", "30.332591"));
        OPT_MAP_CITY.put(27050000, setCityMap("襄樊", "xiangfan", "XF", "市", "0710", "112.176325", "32.094933"));
        OPT_MAP_CITY.put(27060000, setCityMap("荆门", "jingmen", "JM", "市", "0724", "112.21733", "31.042611"));
        OPT_MAP_CITY.put(27070000, setCityMap("黄石", "huangshi", "HS", "市", "0714", "115.050683", "30.216127"));
        OPT_MAP_CITY.put(27080000, setCityMap("鄂州", "ezhou", "EZ", "市", "0711", "114.895594", "30.384439"));
        OPT_MAP_CITY.put(27090000, setCityMap("黄冈", "huanggang", "HG", "市", "0713", "114.906618", "30.446109"));
        OPT_MAP_CITY.put(27100000, setCityMap("咸宁", "xianning", "XN", "市", "0715", "114.300061", "29.880657"));
        OPT_MAP_CITY.put(27110000, setCityMap("十堰", "shiyan", "SY", "市", "0719", "110.801229", "32.636994"));
        OPT_MAP_CITY.put(27120000, setCityMap("随州", "suizhou", "SZ", "市", "0722", "113.379358", "31.717858"));
        OPT_MAP_CITY.put(27130000, setCityMap("恩施", "enshi", "ES", "市", "0718", "109.517433", "30.308978"));
        OPT_MAP_CITY.put(27140000, setCityMap("潜江", "qianjiang", "QJ", "市", "0728", "112.768768", "30.343116"));
        OPT_MAP_CITY.put(27150000, setCityMap("天门", "tianmen", "TM", "市", "0728", "113.12623", "30.649047"));
        OPT_MAP_CITY.put(27160000, setCityMap("仙桃", "xiantao", "XT", "市", "0728", "113.387448", "30.293966"));
        OPT_MAP_CITY.put(27170000, setCityMap("其他", "Other", "O", "", "", "", ""));
        OPT_MAP_CITY.put(28000000, setCityMap("湖南", "hunan", "HN", "省", "", "111.720664", "27.695864"));
        OPT_MAP_CITY.put(28010000, setCityMap("长沙", "changsha", "CS", "市", "0731", "112.979353", "28.213478"));
        OPT_MAP_CITY.put(28020000, setCityMap("湘潭", "xiangtan", "XT", "市", "0731", "112.935556", "27.835095"));
        OPT_MAP_CITY.put(28030000, setCityMap("岳阳", "yueyang", "YY", "市", "0730", "113.146196", "29.378007"));
        OPT_MAP_CITY.put(28040000, setCityMap("株洲", "zhuzhou", "ZZ", "市", "0731", "113.131695", "27.827433"));
        OPT_MAP_CITY.put(28050000, setCityMap("张家界", "zhangjiajie", "ZJJ", "市", "0744", "110.48162", "29.124889"));
        OPT_MAP_CITY.put(28060000, setCityMap("衡阳", "hengyang", "HY", "市", "0734", "112.583819", "26.898164"));
        OPT_MAP_CITY.put(28070000, setCityMap("郴州", "chenzhou", "CZ", "市", "0735", "113.037704", "25.782264"));
        OPT_MAP_CITY.put(28080000, setCityMap("常德", "changde", "CD", "市", "0736", "111.653718", "29.012149"));
        OPT_MAP_CITY.put(28090000, setCityMap("娄底", "loudi", "LD", "市", "0738", "111.996396", "27.741073"));
        OPT_MAP_CITY.put(28100000, setCityMap("怀化", "huaihua", "HH", "市", "0745", "109.986959", "27.557483"));
        OPT_MAP_CITY.put(28110000, setCityMap("益阳", "yiyang", "YY", "市", "0737", "112.366547", "28.588088"));
        OPT_MAP_CITY.put(28120000, setCityMap("邵阳", "shaoyang", "SY", "市", "0739", "111.461525", "27.236811"));
        OPT_MAP_CITY.put(28130000, setCityMap("永州", "yongzhou", "YZ", "市", "0746", "111.614648", "26.435972"));
        OPT_MAP_CITY.put(28140000, setCityMap("湘西", "xiangxi", "XX", "州", "0743", "109.745745", "28.317950"));
        OPT_MAP_CITY.put(28150000, setCityMap("其他", "Other", "O", "", "", "", ""));
        OPT_MAP_CITY.put(29000000, setCityMap("江西", "jiangxi", "JX", "省", "", "115.676082", "27.757258"));
        OPT_MAP_CITY.put(29010000, setCityMap("南昌", "nanchang", "NC", "市", "0791", "115.893528", "28.689578"));
        OPT_MAP_CITY.put(29020000, setCityMap("景德镇", "jingdezhen", "JDZ", "市", "0798", "117.186523", "29.303563"));
        OPT_MAP_CITY.put(29030000, setCityMap("九江", "jiujiang", "JJ", "市", "0792", "115.999848", "29.71964"));
        OPT_MAP_CITY.put(29040000, setCityMap("鹰潭", "yingtan", "YT", "市", "0701", "117.03545", "28.24131"));
        OPT_MAP_CITY.put(29050000, setCityMap("宜春", "yichun", "YC", "市", "0795", "114.400039", "27.81113"));
        OPT_MAP_CITY.put(29060000, setCityMap("新余", "xinyu", "XY", "市", "0790", "114.947117", "27.822322"));
        OPT_MAP_CITY.put(29070000, setCityMap("萍乡", "pingxiang", "PX", "市", "0799", "113.859917", "27.639544"));
        OPT_MAP_CITY.put(29080000, setCityMap("赣州", "ganzhou", "GZ", "市", "0797", "114.935909", "25.845296"));
        OPT_MAP_CITY.put(29090000, setCityMap("吉安", "jian", "JA", "市", "0796", "114.992039", "27.113848"));
        OPT_MAP_CITY.put(29100000, setCityMap("抚州", "fuzhou", "FZ", "市", "0794", "116.360919", "27.954545"));
        OPT_MAP_CITY.put(29110000, setCityMap("上饶", "shangrao", "SR", "市", "0793", "117.955464", "28.457623"));
        OPT_MAP_CITY.put(29120000, setCityMap("其他", "Other", "O", "", "", "", ""));
        OPT_MAP_CITY.put(30000000, setCityMap("内蒙古", "namenggu", "NMG", "自治区", "", "114.415868", "43.468238"));
        OPT_MAP_CITY.put(30010000, setCityMap("呼和浩特", "huhehaote", "HHHT", "市", "0471", "111.660351", "40.828319"));
        OPT_MAP_CITY.put(30020000, setCityMap("赤峰", "chifeng", "CF", "市", "0476", "118.930761", "42.297112"));
        OPT_MAP_CITY.put(30030000, setCityMap("包头", "baotou", "BT", "市", "0472", "109.846239", "40.647119"));
        OPT_MAP_CITY.put(30040000, setCityMap("乌海", "wuhai", "WH", "市", "0473", "106.831999", "39.683177"));
        OPT_MAP_CITY.put(30050000, setCityMap("通辽", "tongliao", "TL", "市", "0475", "122.260363", "43.633756"));
        OPT_MAP_CITY.put(30060000, setCityMap("鄂尔多斯", "eerduosi", "EEDS", "市", "0477", "109.993706", "39.81649"));
        OPT_MAP_CITY.put(30070000, setCityMap("呼伦贝尔", "hulunbeier", "HLBE", "市", "0470", "119.760822", "49.201636"));
        OPT_MAP_CITY.put(30080000, setCityMap("乌兰察布", "wulanchabu", "WLCB", "市", "0474", "113.112846", "41.022363"));
        OPT_MAP_CITY.put(30090000, setCityMap("锡林郭勒", "xilinguole", "XLGL", "盟", "0479", "116.02734", "43.939705"));
        OPT_MAP_CITY.put(30100000, setCityMap("阿拉善", "alashan", "ALS", "盟", "0478", "105.695683", "38.843075"));
        OPT_MAP_CITY.put(30110000, setCityMap("兴安", "xingan", "XA", "盟", "0482", "122.048167", "46.083757"));
        OPT_MAP_CITY.put(30120000, setCityMap("巴彦淖尔", "bayanneer", "BYNE", "市", "0478", "107.423807", "40.76918"));
        OPT_MAP_CITY.put(30130000, setCityMap("其他", "Other", "O", "", "", "", ""));
        OPT_MAP_CITY.put(31000000, setCityMap("广西", "guangxi", "GX", "壮族自治区", "", "108.924274", "23.552255"));
        OPT_MAP_CITY.put(31010000, setCityMap("南宁", "nanning", "NN", "市", "0771", "108.297234", "22.806493"));
        OPT_MAP_CITY.put(31020000, setCityMap("桂林", "guilin", "GL", "市", "0773", "110.26092", "25.262901"));
        OPT_MAP_CITY.put(31030000, setCityMap("北海", "beihai", "BH", "市", "0779", "109.122628", "21.472718"));
        OPT_MAP_CITY.put(31040000, setCityMap("柳州", "liuzhou", "LZ", "市", "0772", "109.422402", "24.329053"));
        OPT_MAP_CITY.put(31050000, setCityMap("玉林", "yulin", "YL", "市", "0775", "110.151676", "22.643974"));
        OPT_MAP_CITY.put(31060000, setCityMap("百色", "baise", "BS", "市", "0776", "106.631821", "23.901512"));
        OPT_MAP_CITY.put(31070000, setCityMap("河池", "hechi", "HC", "市", "0778", "108.069948", "24.699521"));
        OPT_MAP_CITY.put(31080000, setCityMap("防城港", "fangchenggang", "FCG", "市", "0770", "108.351791", "21.617398"));
        OPT_MAP_CITY.put(31090000, setCityMap("崇左", "chongzuo", "CZ", "市", "0771", "107.357322", "22.415455"));
        OPT_MAP_CITY.put(31100000, setCityMap("钦州", "qinzhou", "QZ", "市", "0777", "108.638798", "21.97335"));
        OPT_MAP_CITY.put(31110000, setCityMap("梧州", "wuzhou", "WZ", "市", "0774", "111.305472", "23.485395"));
        OPT_MAP_CITY.put(31120000, setCityMap("贵港", "guigang", "GG", "市", "0775", "109.613708", "23.103373"));
        OPT_MAP_CITY.put(31130000, setCityMap("来宾", "laibin", "LB", "市", "0772", "109.231817", "23.741166"));
        OPT_MAP_CITY.put(31140000, setCityMap("贺州", "hezhou", "HZ", "市", "0774", "111.552594", "24.411054"));
        OPT_MAP_CITY.put(31150000, setCityMap("其他", "Other", "O", "", "", "", ""));
        OPT_MAP_CITY.put(32000000, setCityMap("四川", "sichuan", "SC", "省", "", "102.89916", "30.367481"));
        OPT_MAP_CITY.put(32010000, setCityMap("成都", "chengdu", "CD", "市", "028", "104.067923", "30.679943"));
        OPT_MAP_CITY.put(32020000, setCityMap("宜宾", "yibin", "YB", "市", "0831", "104.633019", "28.769675"));
        OPT_MAP_CITY.put(32030000, setCityMap("泸州", "luzhou", "LZ", "市", "0830", "105.44397", "28.89593"));
        OPT_MAP_CITY.put(32040000, setCityMap("内江", "najiang", "NJ", "市", "0832", "105.073056", "29.599462"));
        OPT_MAP_CITY.put(32050000, setCityMap("攀枝花", "panzhihua", "PZH", "市", "0812", "101.722423", "26.587571"));
        OPT_MAP_CITY.put(32060000, setCityMap("德阳", "deyang", "DY", "市", "0838", "104.402398", "31.13114"));
        OPT_MAP_CITY.put(32070000, setCityMap("雅安", "yaan", "YA", "市", "0835", "103.009356", "29.999716"));
        OPT_MAP_CITY.put(32080000, setCityMap("遂宁", "suining", "SN", "市", "0825", "105.564888", "30.557491"));
        OPT_MAP_CITY.put(32090000, setCityMap("南充", "nanchong", "NC", "市", "0817", "106.105554", "30.800965"));
        OPT_MAP_CITY.put(32100000, setCityMap("绵阳", "mianyang", "MY", "市", "0816", "104.705519", "31.504701"));
        OPT_MAP_CITY.put(32110000, setCityMap("广元", "guangyuan", "GY", "市", "0839", "105.819687", "32.44104"));
        OPT_MAP_CITY.put(32120000, setCityMap("自贡", "zigong", "ZG", "市", "0813", "104.776071", "29.359157"));
        OPT_MAP_CITY.put(32130000, setCityMap("乐山", "leshan", "LS", "市", "0833", "103.760824", "29.600958"));
        OPT_MAP_CITY.put(32140000, setCityMap("广安", "guangan", "GA", "市", "0826", "106.63572", "30.463984"));
        OPT_MAP_CITY.put(32150000, setCityMap("巴中", "bazhong", "BZ", "市", "0827", "106.757916", "31.869189"));
        OPT_MAP_CITY.put(32160000, setCityMap("达州", "dazhou", "DZ", "市", "0818", "107.494973", "31.214199"));
        OPT_MAP_CITY.put(32170000, setCityMap("资阳", "ziyang", "ZY", "市", "0832", "104.63593", "30.132191"));
        OPT_MAP_CITY.put(32180000, setCityMap("眉山", "meishan", "MS", "市", "0833", "103.84143", "30.061115"));
        OPT_MAP_CITY.put(32190000, setCityMap("阿坝", "aba", "AB", "州", "0837", "102.228565", "31.905763"));
        OPT_MAP_CITY.put(32200000, setCityMap("甘孜", "ganzi", "GZ", "州", "0836", "101.969232", "30.055144"));
        OPT_MAP_CITY.put(32210000, setCityMap("凉山", "liangshan", "LS", "州", "0834", "102.259591", "27.892393"));
        OPT_MAP_CITY.put(32220000, setCityMap("其他", "Other", "O", "", "", "", ""));
        OPT_MAP_CITY.put(33000000, setCityMap("贵州", "guizhou", "GZ", "省", "", "106.734996", "26.902826"));
        OPT_MAP_CITY.put(33010000, setCityMap("贵阳", "guiyang", "GY", "市", "0851", "106.709177", "26.629907"));
        OPT_MAP_CITY.put(33020000, setCityMap("遵义", "zunyi", "ZY", "市", "0852", "106.93126", "27.699961"));
        OPT_MAP_CITY.put(33030000, setCityMap("铜仁", "tongren", "TR", "市", "0856", "109.196161", "27.726271"));
        OPT_MAP_CITY.put(33040000, setCityMap("六盘水", "liupanshui", "LPS", "市", "0858", "104.852087", "26.591866"));
        OPT_MAP_CITY.put(33050000, setCityMap("安顺", "anshun", "AS", "市", "0853", "105.92827", "26.228595"));
        OPT_MAP_CITY.put(33060000, setCityMap("毕节", "bijie", "BJ", "市", "0857", "105.300492", "27.302612"));
        OPT_MAP_CITY.put(33070000, setCityMap("黔西南", "qianxi", "QX", "州", "0857", "104.900558", "25.095148"));
        OPT_MAP_CITY.put(33080000, setCityMap("黔东南", "qiandong", "QD", "州", "0855", "107.985353", "26.583992"));
        OPT_MAP_CITY.put(33090000, setCityMap("黔南", "qiannan", "QN", "州", "0854", "107.523205", "26.264536"));
        OPT_MAP_CITY.put(33100000, setCityMap("其他", "Other", "O", "", "", "", ""));
        OPT_MAP_CITY.put(34000000, setCityMap("云南", "yunnan", "YN", "省", "", "101.592952", "24.864213"));
        OPT_MAP_CITY.put(34010000, setCityMap("昆明", "kunming", "KM", "市", "0871", "102.714601", "25.049153"));
        OPT_MAP_CITY.put(34020000, setCityMap("曲靖", "qujing", "QJ", "市", "0874", "103.782539", "25.520758"));
        OPT_MAP_CITY.put(34030000, setCityMap("大理", "dali", "DL", "州", "0872", "100.223675", "25.5969"));
        OPT_MAP_CITY.put(34040000, setCityMap("玉溪", "yuxi", "YX", "市", "0877", "102.545068", "24.370447"));
        OPT_MAP_CITY.put(34050000, setCityMap("丽江", "lijiang", "LJ", "市", "0888", "100.229628", "26.875351"));
        OPT_MAP_CITY.put(34060000, setCityMap("楚雄", "chuxiong", "CX", "州", "0878", "101.529382", "25.066356"));
        OPT_MAP_CITY.put(34070000, setCityMap("迪庆", "diqing", "DQ", "市", "0887", "99.713682", "27.831029"));
        OPT_MAP_CITY.put(34080000, setCityMap("昭通", "zhaotong", "ZT", "市", "0870", "103.725021", "27.340633"));
        OPT_MAP_CITY.put(34090000, setCityMap("保山", "baoshan", "BS", "市", "0875", "99.177996", "25.120489"));
        OPT_MAP_CITY.put(34100000, setCityMap("文山", "wenshan", "WS", "州", "0876", "104.089112", "23.401781"));
        OPT_MAP_CITY.put(34110000, setCityMap("思茅", "simao", "SM", "市", "0879", "100.981112", "22.791189"));
        OPT_MAP_CITY.put(34120000, setCityMap("临沧", "lincang", "LC", "市", "0883", "100.092613", "23.887806"));
        OPT_MAP_CITY.put(34130000, setCityMap("德宏", "dehong", "DH", "州", "0692", "98.589434", "24.44124"));
        OPT_MAP_CITY.put(34140000, setCityMap("怒江", "nujiang", "NJ", "州", "0886", "98.859932", "25.860677"));
        OPT_MAP_CITY.put(34150000, setCityMap("红河", "honghe", "HH", "州", "0873", "103.384065", "23.367718"));
        OPT_MAP_CITY.put(34160000, setCityMap("西双版纳", "xishuangbanna", "XSBN", "州", "0691", "100.803038", "22.009433"));
        OPT_MAP_CITY.put(34170000, setCityMap("其他", "Other", "O", "", "", "", ""));
        OPT_MAP_CITY.put(35000000, setCityMap("甘肃", "gansu", "GS", "省", "", "102.457625", "38.103267"));
        OPT_MAP_CITY.put(35010000, setCityMap("兰州", "lanzhou", "LZ", "市", "0931", "103.823305", "36.064226"));
        OPT_MAP_CITY.put(35020000, setCityMap("酒泉", "jiuquan", "JQ", "市", "0937", "98.508415", "39.741474"));
        OPT_MAP_CITY.put(35030000, setCityMap("临夏", "linxia", "LX", "州", "0930", "103.215249", "35.598514"));
        OPT_MAP_CITY.put(35040000, setCityMap("张掖", "zhangye", "ZY", "市", "0936", "100.459892", "38.93932"));
        OPT_MAP_CITY.put(35050000, setCityMap("嘉峪关", "jiayuguan", "JYG", "市", "0937", "98.281635", "39.802397"));
        OPT_MAP_CITY.put(35060000, setCityMap("金昌", "jinchang", "JC", "市", "0935", "102.208126", "38.516072"));
        OPT_MAP_CITY.put(35070000, setCityMap("平凉", "pingliang", "PL", "市", "0933", "106.688911", "35.55011"));
        OPT_MAP_CITY.put(35080000, setCityMap("白银", "baiyin", "BY", "市", "0943", "104.171241", "36.546682"));
        OPT_MAP_CITY.put(35090000, setCityMap("武威", "wuwei", "WW", "市", "0935", "102.640147", "37.933172"));
        OPT_MAP_CITY.put(35100000, setCityMap("天水", "tianshui", "TS", "市", "0938", "105.736932", "34.584319"));
        OPT_MAP_CITY.put(35110000, setCityMap("庆阳", "qingyang", "QY", "市", "0930", "107.644227", "35.726801"));
        OPT_MAP_CITY.put(35120000, setCityMap("定西", "dingxi", "DX", "市", "0932", "104.626638", "35.586056"));
        OPT_MAP_CITY.put(35130000, setCityMap("陇南", "longnan", "LN", "市", "0939", "104.934573", "33.39448"));
        OPT_MAP_CITY.put(35140000, setCityMap("甘南", "gannan", "GN", "州", "0941", "102.917442", "34.992211"));
        OPT_MAP_CITY.put(35150000, setCityMap("其他", "Other", "O", "", "", "", ""));
        OPT_MAP_CITY.put(36000000, setCityMap("青海", "qinghai", "QH", "省", "", "96.202544", "35.499761"));
        OPT_MAP_CITY.put(36010000, setCityMap("西宁", "xining", "XN", "市", "0971", "101.767921", "36.640739"));
        OPT_MAP_CITY.put(36020000, setCityMap("海东", "haidong", "HD", "地区", "0972", "102.085207", "36.51761"));
        OPT_MAP_CITY.put(36030000, setCityMap("海南", "hainan", "HN", "州", "0974", "109.733755", "19.180501"));
        OPT_MAP_CITY.put(36040000, setCityMap("海西", "haixi", "HX", "州", "0979", "97.342625", "37.373799"));
        OPT_MAP_CITY.put(36050000, setCityMap("海北", "haibei", "HB", "州", "0970", "100.879802", "36.960654"));
        OPT_MAP_CITY.put(36060000, setCityMap("黄南", "huangnan", "HN", "州", "0973", "102.0076", "35.522852"));
        OPT_MAP_CITY.put(36070000, setCityMap("玉树", "yushu", "YS", "州", "0976", "97.013316", "33.00624"));
        OPT_MAP_CITY.put(36080000, setCityMap("果洛", "guoluo", "GL", "州", "0975", "100.223723", "34.480485"));
        OPT_MAP_CITY.put(36090000, setCityMap("其他", "Other", "O", "", "", "", ""));
        OPT_MAP_CITY.put(37000000, setCityMap("宁夏", "ningxia", "NX", "回族自治区", "", "106.155481", "37.321323"));
        OPT_MAP_CITY.put(37010000, setCityMap("银川", "yinchuan", "YC", "市", "0951", "106.206479", "38.502621"));
        OPT_MAP_CITY.put(37020000, setCityMap("吴忠", "wuzhong", "WZ", "市", "0953", "106.208254", "37.993561"));
        OPT_MAP_CITY.put(37030000, setCityMap("石嘴山", "shizuishan", "SZS", "市", "0952", "106.379337", "39.020223"));
        OPT_MAP_CITY.put(37040000, setCityMap("固原", "guyuan", "GY", "市", "0954", "106.285268", "36.021523"));
        OPT_MAP_CITY.put(37050000, setCityMap("其他", "Other", "O", "", "", "", ""));
        OPT_MAP_CITY.put(38000000, setCityMap("新疆", "xinjiang", "XJ", "维吾尔自治区", "", "85.614899", "42.127001"));
        OPT_MAP_CITY.put(38010000, setCityMap("乌鲁木齐", "wulumuqi", "WLMQ", "市", "0991", "87.564988", "43.84038"));
        OPT_MAP_CITY.put(38020000, setCityMap("克拉玛依", "kelamayi", "KLMY", "市", "0990", "84.88118", "45.594331"));
        OPT_MAP_CITY.put(38030000, setCityMap("哈密", "hami", "HM", "地区", "0902", "93.528355", "42.858596"));
        OPT_MAP_CITY.put(38040000, setCityMap("阿克苏", "akesu", "AKS", "地区", "0997", "80.269846", "41.171731"));
        OPT_MAP_CITY.put(38050000, setCityMap("吐鲁番", "tulufan", "TLF", "地区", "0995", "89.181595", "42.96047"));
        OPT_MAP_CITY.put(38060000, setCityMap("喀什", "kashi", "KS", "地区", "0998", "75.992973", "39.470627"));
        OPT_MAP_CITY.put(38070000, setCityMap("和田", "hetian", "HT", "地区", "0903", "79.930239", "37.116774"));
        OPT_MAP_CITY.put(38080000, setCityMap("克孜勒蘇", "kezile", "KZL", "州", "0908", "78.542165", "41.145652"));
        OPT_MAP_CITY.put(38090000, setCityMap("巴音郭楞", "bayinguoleng", "BYGL", "州", "0996", "86.121688", "41.771362"));
        OPT_MAP_CITY.put(38100000, setCityMap("昌吉", "changji", "CJ", "州", "0994", "87.296038", "44.007058"));
        OPT_MAP_CITY.put(38110000, setCityMap("博爾塔拉", "botala", "BTL", "州", "0909", "82.072686", "44.912244"));
        OPT_MAP_CITY.put(38120000, setCityMap("伊犁", "yili", "YL", "州", "0999", "81.297854", "43.922248"));
        OPT_MAP_CITY.put(38130000, setCityMap("其他", "Other", "O", "", "", "", ""));
        OPT_MAP_CITY.put(39000000, setCityMap("西藏", "xicang", "XC", "自治区", "", "89.137982", "31.367315"));
        OPT_MAP_CITY.put(39010000, setCityMap("拉萨", "lasa", "LS", "市", "0891", "91.111891", "29.662557"));
        OPT_MAP_CITY.put(39020000, setCityMap("那曲", "naqu", "NQ", "地区", "0896", "92.067018", "31.48068"));
        OPT_MAP_CITY.put(39030000, setCityMap("昌都", "changdu", "CD", "地区", "0895", "97.185582", "31.140576"));
        OPT_MAP_CITY.put(39040000, setCityMap("山南", "shannan", "SN", "地区", "0983", "91.750644", "29.229027"));
        OPT_MAP_CITY.put(39050000, setCityMap("日喀则", "rikaze", "RKZ", "地区", "0892", "88.891486", "29.269023"));
        OPT_MAP_CITY.put(39060000, setCityMap("阿里", "ali", "AL", "地区", "0897", "81.107669", "30.404557"));
        OPT_MAP_CITY.put(39070000, setCityMap("林芝", "linzhi", "LZ", "地区", "0894", "94.349985", "29.666941"));
        OPT_MAP_CITY.put(39080000, setCityMap("其他", "Other", "O", "", "", "", ""));
        OPT_MAP_CITY.put(40000000, setCityMap("海南", "hainan", "HN", "省", "0974", "109.733755", "19.180501"));
        OPT_MAP_CITY.put(40010000, setCityMap("海口", "haikou", "HK", "市", "0898", "110.330802", "20.022071"));
        OPT_MAP_CITY.put(40020000, setCityMap("三亚", "sanya", "SY", "市", "0898", "109.522771", "18.257776"));
        OPT_MAP_CITY.put(40030000, setCityMap("其他", "Other", "O", "", "", "", ""));
        OPT_MAP_CITY.put(46000000, setCityMap("三沙", "Sansha", "SS", "", "", "112.31547", "16.90535"));
        OPT_MAP_CITY.put(47000000, setCityMap("钓鱼岛", "Diaoyudao", "DYD", "", "", "123.495201", "25.751092"));
        OPT_MAP_CITY.put(41000000, setCityMap("香港", "xianggang", "XG", "特别行政区", "1852", "114.186124", "22.293586"));
        OPT_MAP_CITY.put(42000000, setCityMap("澳门", "aomen", "AM", "特别行政区", "1853", "113.557519", "22.204118"));
        OPT_MAP_CITY.put(43000000, setCityMap("台湾", "taiwan", "TW", "省", "1886", "120.961454", "23.80406"));
        OPT_MAP_CITY.put(44000000, setCityMap("国外", "guowai", "GW", "", "", "", ""));
        OPT_MAP_CITY.put(45000000, setCityMap("其他", "Other", "O", "", "", "", ""));
        fillCityTwonMap();//加入指向所有省份的list，或省份与城市对应关系的map
	}

    /**
     * 直接根据百度提供的城市经纬度数据初始化
     */
    private static void initLngLat(){
        JSONObject lngAndLat = new JSONObject(cityJson);
        JSONArray municipalities= lngAndLat.getJSONArray("municipalities");
        JSONArray other= lngAndLat.getJSONArray("other");
        JSONArray provinces= lngAndLat.getJSONArray("provinces");
         Map<String,Map<String,Double>> nameAndLngLat = Maps.newHashMap();
        for(int i =0;i<municipalities.length();i++){
            String tempLngLat =municipalities.getJSONObject(i).getString("g");
            tempLngLat =tempLngLat.split("\\|")[0];
            nameAndLngLat.put(municipalities.getJSONObject(i).getString("n"),ImmutableMap.of("lng",Double.valueOf(tempLngLat.split(",")[0]),"lat",Double.valueOf(tempLngLat.split(",")[1])));
             if(municipalities.getJSONObject(i).has("cities")){
                 JSONArray cities = municipalities.getJSONObject(i).getJSONArray("cities");
                 for(int j =0;j<cities.length();j++){
                 String tempLngLat1 =cities.getJSONObject(j).getString("g");
                 tempLngLat1 =tempLngLat1.split("\\|")[0];
                 nameAndLngLat.put(cities.getJSONObject(j).getString("n"),ImmutableMap.of("lng",Double.valueOf(tempLngLat1.split(",")[0]),"lat",Double.valueOf(tempLngLat1.split(",")[1])));
                 }
             }
        }
        for(int i =0;i<other.length();i++){
            String tempLngLat =other.getJSONObject(i).getString("g");
            tempLngLat =tempLngLat.split("\\|")[0];
            nameAndLngLat.put(other.getJSONObject(i).getString("n"),ImmutableMap.of("lng",Double.valueOf(tempLngLat.split(",")[0]),"lat",Double.valueOf(tempLngLat.split(",")[1])));
            if(other.getJSONObject(i).has("cities")){
                JSONArray cities = other.getJSONObject(i).getJSONArray("cities");
                for(int j =0;j<cities.length();j++){
                    String tempLngLat1 =cities.getJSONObject(j).getString("g");
                    tempLngLat1 =tempLngLat1.split("\\|")[0];
                    nameAndLngLat.put(cities.getJSONObject(j).getString("n"),ImmutableMap.of("lng",Double.valueOf(tempLngLat1.split(",")[0]),"lat",Double.valueOf(tempLngLat1.split(",")[1])));
                }
            }
        }
        for(int i =0;i<provinces.length();i++){
            String tempLngLat =provinces.getJSONObject(i).getString("g");
            tempLngLat =tempLngLat.split("\\|")[0];
            nameAndLngLat.put(provinces.getJSONObject(i).getString("n"),ImmutableMap.of("lng",Double.valueOf(tempLngLat.split(",")[0]),"lat",Double.valueOf(tempLngLat.split(",")[1])));
            if(provinces.getJSONObject(i).has("cities")){
                JSONArray cities = provinces.getJSONObject(i).getJSONArray("cities");
                for(int j =0;j<cities.length();j++){
                    String tempLngLat1 =cities.getJSONObject(j).getString("g");
                    tempLngLat1 =tempLngLat1.split("\\|")[0];
                    nameAndLngLat.put(cities.getJSONObject(j).getString("n"),ImmutableMap.of("lng",Double.valueOf(tempLngLat1.split(",")[0]),"lat",Double.valueOf(tempLngLat1.split(",")[1])));
                }
            }
        }
        for(Map.Entry<Integer, Map<String, String>> entry : OPT_MAP_CITY.entrySet()){
            if(entry.getValue().get("name").equals("其他")){
                System.out.println("OPT_MAP_CITY.put("+entry.getKey()+", setCityMap(\"其他\", \"Other\", \"O\", \"\", \"\", \"\", \"\"));");
            }else{
            Map temp = nameAndLngLat.get(entry.getValue().get("name"));
            temp = temp==null?nameAndLngLat.get(entry.getValue().get("name")+entry.getValue().get("s")):temp;
                if(temp==null){
                    System.out.println("地区【"+entry.getValue().get("name")+"】不存在！");
                    System.out.println("OPT_MAP_CITY.put("+entry.getKey()+", setCityMap(\""
                            +entry.getValue().get("name")+"\", \""
                            +entry.getValue().get("en")+"\", \""
                            +entry.getValue().get("f")+"\", \""
                            +entry.getValue().get("s")+"\", \""
                            +entry.getValue().get("a")+"\", \"\", \"\"));");
                }else{
                    System.out.println("OPT_MAP_CITY.put("+entry.getKey()+", setCityMap(\""
                            +entry.getValue().get("name")+"\", \""
                            +entry.getValue().get("en")+"\", \""
                            +entry.getValue().get("f")+"\", \""
                            +entry.getValue().get("s")+"\", \""
                            +entry.getValue().get("a")+"\", \""+temp.get("lng")+"\", \""+temp.get("lat")+"\"));");
                }
            }
        }
    }

	public static Map<String, String> setCityMap(final String name, final String en, final String f, String s, String a) {
        return ImmutableMap.of("name", name, "en", en, "f", f, "s", s, "a", a);
	}

    public static Map<String, String> setCityMap(final String name, final String en, final String f, String s, String a, String lng, String lat) {
        Map<String, String> temp = Maps.newHashMap();
        temp.putAll(ImmutableMap.of("name", name, "en", en, "f", f, "s", s, "a", a));
        temp.put(OptionMap.LNG,lng);
        temp.put(OptionMap.LAT,lat);
        return ImmutableMap.copyOf(temp);
    }

    /**
     * 简历根据城市对应镇区的关系map
     */
    private static void fillCityTwonMap(){
        Map<Integer,List<Map<String,String>>> tempProvinceCityMap = Maps.newHashMap();
        List<Map<String,String>> OPT_LIST_PROVINCE_TEMP = Lists.newArrayList();
        for(Map.Entry<Integer,Map<String,String>> entry : OPT_MAP_CITY.entrySet()){
            Integer provinceCode =Integer.parseInt(OptionMap.getProvCodeBits(entry.getKey()));//获取城市代码
            if(StringUtils.endsWith(OptionMap.getCityCodeBits(entry.getKey()),"00")){//是否省份代码
                Map<String, String> tempMapCity = entry.getValue();
                Map<String, String> result = Maps.newHashMap(tempMapCity);
                result.put("code",entry.getKey()+"");
                OPT_LIST_PROVINCE_TEMP.add(result);
            }else{
                List<Map<String,String>> tempList = tempProvinceCityMap.get(provinceCode);
                if(tempProvinceCityMap.get(provinceCode) == null){
                    tempList = Lists.newArrayList();
                    tempProvinceCityMap.put(provinceCode, tempList);
                }
                Map<String, String> tempMapCity = entry.getValue();
                Map<String, String> result = Maps.newHashMap(tempMapCity);
                result.put("code",entry.getKey()+"");
                if(OptionTownMap.OPT_MAP_CITY_TWON.get(Integer.parseInt(OptionMap.getCityCodeBits(entry.getKey()+"")))!=null){
                    result.put("hasChild","1");
                }else{
                    result.put("hasChild","0");
                }
                tempList.add(result);
            }
        }
        for(Map<String,String> province : OPT_LIST_PROVINCE_TEMP){
                 if(tempProvinceCityMap.get(Integer.parseInt(OptionMap.getProvCodeBits(province.get("code")+"")))!=null
                         ||OptionTownMap.OPT_MAP_CITY_TWON.get(Integer.parseInt(OptionMap.getCityCodeBits(province.get("code")+"")))!=null){
                     province.put("hasChild","1");
                 }else{
                     province.put("hasChild","0");
                 }
        }
        OPT_MAP_PROVINCE_CITY = ImmutableMap.copyOf(tempProvinceCityMap);
        OPT_LIST_PROVINCE =  ImmutableList.copyOf(OPT_LIST_PROVINCE_TEMP);
    }
    
    /**
     * 
    * 验证指定的城市代码是否为镇区代码
    * @param @param cityCode
    * @param @return    设定文件 
    * @return boolean    返回类型 
    * @throws
     */
    public static boolean isTown(Integer cityCode) {
    	boolean town = false;
    	String townCode = cityCode.toString();
    	if(townCode.length() == 8 && !townCode.substring(4, 6).equals("00"))
            town = true;
    	return town;
    }

    private static final String cityJson = "{municipalities:[{n:\"北京\",g:\"116.395645,39.929986|12\"},{n:\"上海\",g:\"121.487899,31.249162|12\"},{n:\"天津\",g:\"117.210813,39.14393|12\"},{n:\"重庆\",g:\"106.530635,29.544606|12\"}],provinces:[{n:\"安徽\",g:\"117.216005,31.859252|8\",cities:[{n:\"合肥\",g:\"117.282699,31.866942|12\"},{n:\"安庆\",g:\"117.058739,30.537898|13\"},{n:\"蚌埠\",g:\"117.35708,32.929499|13\"},{n:\"亳州\",g:\"115.787928,33.871211|13\"},{n:\"巢湖\",g:\"117.88049,31.608733|13\"},{n:\"池州\",g:\"117.494477,30.660019|14\"},{n:\"滁州\",g:\"118.32457,32.317351|13\"},{n:\"阜阳\",g:\"115.820932,32.901211|13\"},{n:\"淮北\",g:\"116.791447,33.960023|13\"},{n:\"淮南\",g:\"117.018639,32.642812|13\"},{n:\"黄山\",g:\"118.29357,29.734435|13\"},{n:\"六安\",g:\"116.505253,31.755558|13\"},{n:\"马鞍山\",g:\"118.515882,31.688528|13\"},{n:\"宿州\",g:\"116.988692,33.636772|13\"},{n:\"铜陵\",g:\"117.819429,30.94093|14\"},{n:\"芜湖\",g:\"118.384108,31.36602|12\"},{n:\"宣城\",g:\"118.752096,30.951642|13\"}]},{n:\"福建\",g:\"117.984943,26.050118|8\",cities:[{n:\"福州\",g:\"119.330221,26.047125|12\"},{n:\"龙岩\",g:\"117.017997,25.078685|13\"},{n:\"南平\",g:\"118.181883,26.643626|13\"},{n:\"宁德\",g:\"119.542082,26.656527|14\"},{n:\"莆田\",g:\"119.077731,25.44845|13\"},{n:\"泉州\",g:\"118.600362,24.901652|12\"},{n:\"三明\",g:\"117.642194,26.270835|14\"},{n:\"厦门\",g:\"118.103886,24.489231|12\"},{n:\"漳州\",g:\"117.676205,24.517065|12\"}]},{n:\"甘肃\",g:\"102.457625,38.103267|6\",cities:[{n:\"兰州\",g:\"103.823305,36.064226|12\"},{n:\"白银\",g:\"104.171241,36.546682|13\"},{n:\"定西\",g:\"104.626638,35.586056|13\"},{n:\"甘南州\",g:\"102.917442,34.992211|14\"},{n:\"嘉峪关\",g:\"98.281635,39.802397|13\"},{n:\"金昌\",g:\"102.208126,38.516072|13\"},{n:\"酒泉\",g:\"98.508415,39.741474|13\"},{n:\"临夏州\",g:\"103.215249,35.598514|13\"},{n:\"陇南\",g:\"104.934573,33.39448|14\"},{n:\"平凉\",g:\"106.688911,35.55011|13\"},{n:\"庆阳\",g:\"107.644227,35.726801|13\"},{n:\"天水\",g:\"105.736932,34.584319|13\"},{n:\"武威\",g:\"102.640147,37.933172|13\"},{n:\"张掖\",g:\"100.459892,38.93932|13\"}]},{n:\"广东\",g:\"113.394818,23.408004|8\",cities:[{n:\"广州\",g:\"113.30765,23.120049|12\"},{n:\"潮州\",g:\"116.630076,23.661812|13\"},{n:\"东莞\",g:\"113.763434,23.043024|12\"},{n:\"佛山\",g:\"113.134026,23.035095|13\"},{n:\"河源\",g:\"114.713721,23.757251|12\"},{n:\"惠州\",g:\"114.410658,23.11354|12\"},{n:\"江门\",g:\"113.078125,22.575117|13\"},{n:\"揭阳\",g:\"116.379501,23.547999|13\"},{n:\"茂名\",g:\"110.931245,21.668226|13\"},{n:\"梅州\",g:\"116.126403,24.304571|13\"},{n:\"清远\",g:\"113.040773,23.698469|13\"},{n:\"汕头\",g:\"116.72865,23.383908|13\"},{n:\"汕尾\",g:\"115.372924,22.778731|14\"},{n:\"韶关\",g:\"113.594461,24.80296|13\"},{n:\"深圳\",g:\"114.025974,22.546054|12\"},{n:\"阳江\",g:\"111.97701,21.871517|14\"},{n:\"云浮\",g:\"112.050946,22.937976|13\"},{n:\"湛江\",g:\"110.365067,21.257463|13\"},{n:\"肇庆\",g:\"112.479653,23.078663|13\"},{n:\"中山\",g:\"113.42206,22.545178|12\"},{n:\"珠海\",g:\"113.562447,22.256915|13\"}]},{n:\"广西\",g:\"108.924274,23.552255|7\",cities:[{n:\"南宁\",g:\"108.297234,22.806493|12\"},{n:\"百色\",g:\"106.631821,23.901512|13\"},{n:\"北海\",g:\"109.122628,21.472718|13\"},{n:\"崇左\",g:\"107.357322,22.415455|14\"},{n:\"防城港\",g:\"108.351791,21.617398|15\"},{n:\"桂林\",g:\"110.26092,25.262901|12\"},{n:\"贵港\",g:\"109.613708,23.103373|13\"},{n:\"河池\",g:\"108.069948,24.699521|14\"},{n:\"贺州\",g:\"111.552594,24.411054|14\"},{n:\"来宾\",g:\"109.231817,23.741166|14\"},{n:\"柳州\",g:\"109.422402,24.329053|12\"},{n:\"钦州\",g:\"108.638798,21.97335|13\"},{n:\"梧州\",g:\"111.305472,23.485395|13\"},{n:\"玉林\",g:\"110.151676,22.643974|14\"}]},{n:\"贵州\",g:\"106.734996,26.902826|8\",cities:[{n:\"贵阳\",g:\"106.709177,26.629907|12\"},{n:\"安顺\",g:\"105.92827,26.228595|13\"},{n:\"毕节地区\",g:\"105.300492,27.302612|14\"},{n:\"六盘水\",g:\"104.852087,26.591866|13\"},{n:\"铜仁地区\",g:\"109.196161,27.726271|14\"},{n:\"遵义\",g:\"106.93126,27.699961|13\"},{n:\"黔西南州\",g:\"104.900558,25.095148|11\"},{n:\"黔东南州\",g:\"107.985353,26.583992|11\"},{n:\"黔南州\",g:\"107.523205,26.264536|11\"}]},{n:\"海南\",g:\"109.733755,19.180501|9\",cities:[{n:\"海口\",g:\"110.330802,20.022071|13\"},{n:\"白沙\",g:\"109.358586,19.216056|12\"},{n:\"保亭\",g:\"109.656113,18.597592|12\"},{n:\"昌江\",g:\"109.0113,19.222483|12\"},{n:\"儋州\",g:\"109.413973,19.571153|13\"},{n:\"澄迈\",g:\"109.996736,19.693135|13\"},{n:\"东方\",g:\"108.85101,18.998161|13\"},{n:\"定安\",g:\"110.32009,19.490991|13\"},{n:\"琼海\",g:\"110.414359,19.21483|13\"},{n:\"琼中\",g:\"109.861849,19.039771|12\"},{n:\"乐东\",g:\"109.062698,18.658614|12\"},{n:\"临高\",g:\"109.724101,19.805922|13\"},{n:\"陵水\",g:\"109.948661,18.575985|12\"},{n:\"三亚\",g:\"109.522771,18.257776|12\"},{n:\"屯昌\",g:\"110.063364,19.347749|13\"},{n:\"万宁\",g:\"110.292505,18.839886|13\"},{n:\"文昌\",g:\"110.780909,19.750947|13\"},{n:\"五指山\",g:\"109.51775,18.831306|13\"}]},{n:\"河北\",g:\"115.661434,38.61384|7\",cities:[{n:\"石家庄\",g:\"114.522082,38.048958|12\"},{n:\"保定\",g:\"115.49481,38.886565|13\"},{n:\"沧州\",g:\"116.863806,38.297615|13\"},{n:\"承德\",g:\"117.933822,40.992521|14\"},{n:\"邯郸\",g:\"114.482694,36.609308|13\"},{n:\"衡水\",g:\"115.686229,37.746929|13\"},{n:\"廊坊\",g:\"116.703602,39.518611|13\"},{n:\"秦皇岛\",g:\"119.604368,39.945462|12\"},{n:\"唐山\",g:\"118.183451,39.650531|13\"},{n:\"邢台\",g:\"114.520487,37.069531|13\"},{n:\"张家口\",g:\"114.893782,40.811188|13\"}]},{n:\"河南\",g:\"113.486804,34.157184|7\",cities:[{n:\"郑州\",g:\"113.649644,34.75661|12\"},{n:\"安阳\",g:\"114.351807,36.110267|12\"},{n:\"鹤壁\",g:\"114.29777,35.755426|13\"},{n:\"焦作\",g:\"113.211836,35.234608|13\"},{n:\"开封\",g:\"114.351642,34.801854|13\"},{n:\"洛阳\",g:\"112.447525,34.657368|12\"},{n:\"漯河\",g:\"114.046061,33.576279|13\"},{n:\"南阳\",g:\"112.542842,33.01142|13\"},{n:\"平顶山\",g:\"113.300849,33.745301|13\"},{n:\"濮阳\",g:\"115.026627,35.753298|12\"},{n:\"三门峡\",g:\"111.181262,34.78332|13\"},{n:\"商丘\",g:\"115.641886,34.438589|13\"},{n:\"新乡\",g:\"113.91269,35.307258|13\"},{n:\"信阳\",g:\"114.085491,32.128582|13\"},{n:\"许昌\",g:\"113.835312,34.02674|13\"},{n:\"周口\",g:\"114.654102,33.623741|13\"},{n:\"驻马店\",g:\"114.049154,32.983158|13\"}]},{n:\"黑龙江\",g:\"128.047414,47.356592|6\",cities:[{n:\"哈尔滨\",g:\"126.657717,45.773225|12\"},{n:\"大庆\",g:\"125.02184,46.596709|12\"},{n:\"大兴安岭地区\",g:\"124.196104,51.991789|10\"},{n:\"鹤岗\",g:\"130.292472,47.338666|13\"},{n:\"黑河\",g:\"127.50083,50.25069|14\"},{n:\"鸡西\",g:\"130.941767,45.32154|13\"},{n:\"佳木斯\",g:\"130.284735,46.81378|12\"},{n:\"牡丹江\",g:\"129.608035,44.588521|13\"},{n:\"七台河\",g:\"131.019048,45.775005|14\"},{n:\"齐齐哈尔\",g:\"123.987289,47.3477|13\"},{n:\"双鸭山\",g:\"131.171402,46.655102|13\"},{n:\"绥化\",g:\"126.989095,46.646064|13\"},{n:\"伊春\",g:\"128.910766,47.734685|14\"}]},{n:\"湖北\",g:\"112.410562,31.209316|8\",cities:[{n:\"武汉\",g:\"114.3162,30.581084|12\"},{n:\"鄂州\",g:\"114.895594,30.384439|14\"},{n:\"恩施\",g:\"109.517433,30.308978|14\"},{n:\"黄冈\",g:\"114.906618,30.446109|14\"},{n:\"黄石\",g:\"115.050683,30.216127|13\"},{n:\"荆门\",g:\"112.21733,31.042611|13\"},{n:\"荆州\",g:\"112.241866,30.332591|12\"},{n:\"潜江\",g:\"112.768768,30.343116|13\"},{n:\"神农架林区\",g:\"110.487231,31.595768|13\"},{n:\"十堰\",g:\"110.801229,32.636994|13\"},{n:\"随州\",g:\"113.379358,31.717858|13\"},{n:\"天门\",g:\"113.12623,30.649047|13\"},{n:\"仙桃\",g:\"113.387448,30.293966|13\"},{n:\"咸宁\",g:\"114.300061,29.880657|13\"},{n:\"襄阳\",g:\"112.176326,32.094934|12\"},{n:\"孝感\",g:\"113.935734,30.927955|13\"},{n:\"宜昌\",g:\"111.310981,30.732758|13\"}]},{n:\"湖南\",g:\"111.720664,27.695864|7\",cities:[{n:\"长沙\",g:\"112.979353,28.213478|12\"},{n:\"常德\",g:\"111.653718,29.012149|12\"},{n:\"郴州\",g:\"113.037704,25.782264|13\"},{n:\"衡阳\",g:\"112.583819,26.898164|13\"},{n:\"怀化\",g:\"109.986959,27.557483|13\"},{n:\"娄底\",g:\"111.996396,27.741073|13\"},{n:\"邵阳\",g:\"111.461525,27.236811|13\"},{n:\"湘潭\",g:\"112.935556,27.835095|13\"},{n:\"湘西州\",g:\"109.745746,28.317951|14\"},{n:\"益阳\",g:\"112.366547,28.588088|13\"},{n:\"永州\",g:\"111.614648,26.435972|13\"},{n:\"岳阳\",g:\"113.146196,29.378007|13\"},{n:\"张家界\",g:\"110.48162,29.124889|13\"},{n:\"株洲\",g:\"113.131695,27.827433|13\"}]},{n:\"江苏\",g:\"119.368489,33.013797|8\",cities:[{n:\"南京\",g:\"118.778074,32.057236|12\"},{n:\"常州\",g:\"119.981861,31.771397|12\"},{n:\"淮安\",g:\"119.030186,33.606513|12\"},{n:\"连云港\",g:\"119.173872,34.601549|12\"},{n:\"南通\",g:\"120.873801,32.014665|12\"},{n:\"苏州\",g:\"120.619907,31.317987|12\"},{n:\"宿迁\",g:\"118.296893,33.95205|13\"},{n:\"泰州\",g:\"119.919606,32.476053|13\"},{n:\"无锡\",g:\"120.305456,31.570037|12\"},{n:\"徐州\",g:\"117.188107,34.271553|12\"},{n:\"盐城\",g:\"120.148872,33.379862|12\"},{n:\"扬州\",g:\"119.427778,32.408505|13\"},{n:\"镇江\",g:\"119.455835,32.204409|13\"}]},{n:\"江西\",g:\"115.676082,27.757258|7\",cities:[{n:\"南昌\",g:\"115.893528,28.689578|12\"},{n:\"抚州\",g:\"116.360919,27.954545|13\"},{n:\"赣州\",g:\"114.935909,25.845296|13\"},{n:\"吉安\",g:\"114.992039,27.113848|13\"},{n:\"景德镇\",g:\"117.186523,29.303563|12\"},{n:\"九江\",g:\"115.999848,29.71964|13\"},{n:\"萍乡\",g:\"113.859917,27.639544|13\"},{n:\"上饶\",g:\"117.955464,28.457623|13\"},{n:\"新余\",g:\"114.947117,27.822322|13\"},{n:\"宜春\",g:\"114.400039,27.81113|13\"},{n:\"鹰潭\",g:\"117.03545,28.24131|13\"}]},{n:\"吉林\",g:\"126.262876,43.678846|7\",cities:[{n:\"长春\",g:\"125.313642,43.898338|12\"},{n:\"白城\",g:\"122.840777,45.621086|13\"},{n:\"白山\",g:\"126.435798,41.945859|13\"},{n:\"吉林市\",g:\"126.564544,43.871988|12\"},{n:\"辽源\",g:\"125.133686,42.923303|13\"},{n:\"四平\",g:\"124.391382,43.175525|12\"},{n:\"松原\",g:\"124.832995,45.136049|13\"},{n:\"通化\",g:\"125.94265,41.736397|13\"},{n:\"延边\",g:\"129.485902,42.896414|13\"}]},{n:\"辽宁\",g:\"122.753592,41.6216|8\",cities:[{n:\"沈阳\",g:\"123.432791,41.808645|12\"},{n:\"鞍山\",g:\"123.007763,41.118744|13\"},{n:\"本溪\",g:\"123.778062,41.325838|12\"},{n:\"朝阳\",g:\"120.446163,41.571828|13\"},{n:\"大连\",g:\"121.593478,38.94871|12\"},{n:\"丹东\",g:\"124.338543,40.129023|12\"},{n:\"抚顺\",g:\"123.92982,41.877304|12\"},{n:\"阜新\",g:\"121.660822,42.01925|14\"},{n:\"葫芦岛\",g:\"120.860758,40.74303|13\"},{n:\"锦州\",g:\"121.147749,41.130879|13\"},{n:\"辽阳\",g:\"123.172451,41.273339|14\"},{n:\"盘锦\",g:\"122.073228,41.141248|13\"},{n:\"铁岭\",g:\"123.85485,42.299757|13\"},{n:\"营口\",g:\"122.233391,40.668651|13\"}]},{n:\"内蒙古\",g:\"114.415868,43.468238|5\",cities:[{n:\"呼和浩特\",g:\"111.660351,40.828319|12\"},{n:\"阿拉善盟\",g:\"105.695683,38.843075|14\"},{n:\"包头\",g:\"109.846239,40.647119|12\"},{n:\"巴彦淖尔\",g:\"107.423807,40.76918|12\"},{n:\"赤峰\",g:\"118.930761,42.297112|12\"},{n:\"鄂尔多斯\",g:\"109.993706,39.81649|12\"},{n:\"呼伦贝尔\",g:\"119.760822,49.201636|12\"},{n:\"通辽\",g:\"122.260363,43.633756|12\"},{n:\"乌海\",g:\"106.831999,39.683177|13\"},{n:\"乌兰察布\",g:\"113.112846,41.022363|12\"},{n:\"锡林郭勒盟\",g:\"116.02734,43.939705|11\"},{n:\"兴安盟\",g:\"122.048167,46.083757|11\"}]},{n:\"宁夏\",g:\"106.155481,37.321323|8\",cities:[{n:\"银川\",g:\"106.206479,38.502621|12\"},{n:\"固原\",g:\"106.285268,36.021523|13\"},{n:\"石嘴山\",g:\"106.379337,39.020223|13\"},{n:\"吴忠\",g:\"106.208254,37.993561|14\"},{n:\"中卫\",g:\"105.196754,37.521124|14\"}]},{n:\"青海\",g:\"96.202544,35.499761|7\",cities:[{n:\"西宁\",g:\"101.767921,36.640739|12\"},{n:\"果洛州\",g:\"100.223723,34.480485|11\"},{n:\"海东地区\",g:\"102.085207,36.51761|11\"},{n:\"海北州\",g:\"100.879802,36.960654|11\"},{n:\"海南州\",g:\"100.624066,36.284364|11\"},{n:\"海西州\",g:\"97.342625,37.373799|11\"},{n:\"黄南州\",g:\"102.0076,35.522852|11\"},{n:\"玉树州\",g:\"97.013316,33.00624|14\"}]},{n:\"山东\",g:\"118.527663,36.09929|8\",cities:[{n:\"济南\",g:\"117.024967,36.682785|12\"},{n:\"滨州\",g:\"117.968292,37.405314|12\"},{n:\"东营\",g:\"118.583926,37.487121|12\"},{n:\"德州\",g:\"116.328161,37.460826|12\"},{n:\"菏泽\",g:\"115.46336,35.26244|13\"},{n:\"济宁\",g:\"116.600798,35.402122|13\"},{n:\"莱芜\",g:\"117.684667,36.233654|13\"},{n:\"聊城\",g:\"115.986869,36.455829|12\"},{n:\"临沂\",g:\"118.340768,35.072409|12\"},{n:\"青岛\",g:\"120.384428,36.105215|12\"},{n:\"日照\",g:\"119.50718,35.420225|12\"},{n:\"泰安\",g:\"117.089415,36.188078|13\"},{n:\"威海\",g:\"122.093958,37.528787|13\"},{n:\"潍坊\",g:\"119.142634,36.716115|12\"},{n:\"烟台\",g:\"121.309555,37.536562|12\"},{n:\"枣庄\",g:\"117.279305,34.807883|13\"},{n:\"淄博\",g:\"118.059134,36.804685|12\"}]},{n:\"山西\",g:\"112.515496,37.866566|7\",cities:[{n:\"太原\",g:\"112.550864,37.890277|12\"},{n:\"长治\",g:\"113.120292,36.201664|12\"},{n:\"大同\",g:\"113.290509,40.113744|12\"},{n:\"晋城\",g:\"112.867333,35.499834|13\"},{n:\"晋中\",g:\"112.738514,37.693362|13\"},{n:\"临汾\",g:\"111.538788,36.099745|13\"},{n:\"吕梁\",g:\"111.143157,37.527316|14\"},{n:\"朔州\",g:\"112.479928,39.337672|13\"},{n:\"忻州\",g:\"112.727939,38.461031|12\"},{n:\"阳泉\",g:\"113.569238,37.869529|13\"},{n:\"运城\",g:\"111.006854,35.038859|13\"}]},{n:\"陕西\",g:\"109.503789,35.860026|7\",cities:[{n:\"西安\",g:\"108.953098,34.2778|12\"},{n:\"安康\",g:\"109.038045,32.70437|13\"},{n:\"宝鸡\",g:\"107.170645,34.364081|12\"},{n:\"汉中\",g:\"107.045478,33.081569|13\"},{n:\"商洛\",g:\"109.934208,33.873907|13\"},{n:\"铜川\",g:\"108.968067,34.908368|13\"},{n:\"渭南\",g:\"109.483933,34.502358|13\"},{n:\"咸阳\",g:\"108.707509,34.345373|13\"},{n:\"延安\",g:\"109.50051,36.60332|13\"},{n:\"榆林\",g:\"109.745926,38.279439|12\"}]},{n:\"四川\",g:\"102.89916,30.367481|7\",cities:[{n:\"成都\",g:\"104.067923,30.679943|12\"},{n:\"阿坝州\",g:\"102.228565,31.905763|15\"},{n:\"巴中\",g:\"106.757916,31.869189|14\"},{n:\"达州\",g:\"107.494973,31.214199|14\"},{n:\"德阳\",g:\"104.402398,31.13114|13\"},{n:\"甘孜州\",g:\"101.969232,30.055144|15\"},{n:\"广安\",g:\"106.63572,30.463984|13\"},{n:\"广元\",g:\"105.819687,32.44104|13\"},{n:\"乐山\",g:\"103.760824,29.600958|13\"},{n:\"凉山州\",g:\"102.259591,27.892393|14\"},{n:\"泸州\",g:\"105.44397,28.89593|14\"},{n:\"南充\",g:\"106.105554,30.800965|13\"},{n:\"眉山\",g:\"103.84143,30.061115|13\"},{n:\"绵阳\",g:\"104.705519,31.504701|12\"},{n:\"内江\",g:\"105.073056,29.599462|13\"},{n:\"攀枝花\",g:\"101.722423,26.587571|14\"},{n:\"遂宁\",g:\"105.564888,30.557491|12\"},{n:\"雅安\",g:\"103.009356,29.999716|13\"},{n:\"宜宾\",g:\"104.633019,28.769675|13\"},{n:\"资阳\",g:\"104.63593,30.132191|13\"},{n:\"自贡\",g:\"104.776071,29.359157|13\"}]},{n:\"西藏\",g:\"89.137982,31.367315|6\",cities:[{n:\"拉萨\",g:\"91.111891,29.662557|13\"},{n:\"阿里地区\",g:\"81.107669,30.404557|11\"},{n:\"昌都地区\",g:\"97.185582,31.140576|15\"},{n:\"林芝地区\",g:\"94.349985,29.666941|11\"},{n:\"那曲地区\",g:\"92.067018,31.48068|14\"},{n:\"日喀则地区\",g:\"88.891486,29.269023|14\"},{n:\"山南地区\",g:\"91.750644,29.229027|11\"}]},{n:\"新疆\",g:\"85.614899,42.127001|6\",cities:[{n:\"乌鲁木齐\",g:\"87.564988,43.84038|12\"},{n:\"阿拉尔\",g:\"81.291737,40.61568|13\"},{n:\"阿克苏地区\",g:\"80.269846,41.171731|12\"},{n:\"阿勒泰地区\",g:\"88.137915,47.839744|13\"},{n:\"巴音郭楞\",g:\"86.121688,41.771362|12\"},{n:\"博尔塔拉州\",g:\"82.052436,44.913651|11\"},{n:\"昌吉州\",g:\"87.296038,44.007058|13\"},{n:\"哈密地区\",g:\"93.528355,42.858596|13\"},{n:\"和田地区\",g:\"79.930239,37.116774|13\"},{n:\"喀什地区\",g:\"75.992973,39.470627|12\"},{n:\"克拉玛依\",g:\"84.88118,45.594331|13\"},{n:\"克孜勒苏州\",g:\"76.137564,39.750346|11\"},{n:\"石河子\",g:\"86.041865,44.308259|13\"},{n:\"塔城地区\",g:\"82.974881,46.758684|12\"},{n:\"图木舒克\",g:\"79.198155,39.889223|13\"},{n:\"吐鲁番地区\",g:\"89.181595,42.96047|13\"},{n:\"五家渠\",g:\"87.565449,44.368899|13\"},{n:\"伊犁州\",g:\"81.297854,43.922248|11\"}]},{n:\"云南\",g:\"101.592952,24.864213|7\",cities:[{n:\"昆明\",g:\"102.714601,25.049153|12\"},{n:\"保山\",g:\"99.177996,25.120489|13\"},{n:\"楚雄州\",g:\"101.529382,25.066356|13\"},{n:\"大理州\",g:\"100.223675,25.5969|14\"},{n:\"德宏州\",g:\"98.589434,24.44124|14\"},{n:\"迪庆州\",g:\"99.713682,27.831029|14\"},{n:\"红河州\",g:\"103.384065,23.367718|11\"},{n:\"丽江\",g:\"100.229628,26.875351|13\"},{n:\"临沧\",g:\"100.092613,23.887806|14\"},{n:\"怒江州\",g:\"98.859932,25.860677|14\"},{n:\"普洱\",g:\"100.980058,22.788778|14\"},{n:\"曲靖\",g:\"103.782539,25.520758|12\"},{n:\"昭通\",g:\"103.725021,27.340633|13\"},{n:\"文山\",g:\"104.089112,23.401781|14\"},{n:\"西双版纳\",g:\"100.803038,22.009433|13\"},{n:\"玉溪\",g:\"102.545068,24.370447|13\"}]},{n:\"浙江\",g:\"119.957202,29.159494|8\",cities:[{n:\"杭州\",g:\"120.219375,30.259244|12\"},{n:\"湖州\",g:\"120.137243,30.877925|12\"},{n:\"嘉兴\",g:\"120.760428,30.773992|13\"},{n:\"金华\",g:\"119.652576,29.102899|12\"},{n:\"丽水\",g:\"119.929576,28.4563|13\"},{n:\"宁波\",g:\"121.579006,29.885259|12\"},{n:\"衢州\",g:\"118.875842,28.95691|12\"},{n:\"绍兴\",g:\"120.592467,30.002365|13\"},{n:\"台州\",g:\"121.440613,28.668283|13\"},{n:\"温州\",g:\"120.690635,28.002838|12\"},{n:\"舟山\",g:\"122.169872,30.03601|13\"}]}],other:[{n:\"香港\",g:\"114.186124,22.293586|11\"},{n:\"澳门\",g:\"113.557519,22.204118|13\"},{n:\"台湾\",g:\"120.961454,23.80406|8\"}]};\n";

    /**
     * 通过省市code获取省市名称
     * zhaoman 2015-6-4
     * @param proCode 省code，类型为 Integer
     * @param cityCode 省code ，类型为Integer
     * @return 如广东省深圳市
     */
    public static String getProvCityNameByCode(Integer provCode,Integer cityCode){
    	Map<String, String> proMap = null;
    	Map<String, String> cityMap = null;
    	String proName = "";
    	String cityName = "";
    	String addressName;
    	if(null != provCode){
    		proMap = OPT_MAP_CITY.get(provCode);
    	}
		if(null != cityCode) {
			cityMap = OPT_MAP_CITY.get(cityCode);
		}
		if(null != proMap) {
			proName = proMap.get("name");
		}
		if(null != cityMap) {
			cityName = cityMap.get("name");
		}
		if(proName.length() > 0 && cityName.length() > 0 && !proName.equals(cityName)) {
			addressName = proName +"省"+ cityName+"市";
		}else {
			addressName = cityName+"市";
		}
		return addressName;
	}
    
    
}