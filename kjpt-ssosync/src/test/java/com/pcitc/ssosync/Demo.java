package com.pcitc.ssosync;

 import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import koal.urm.client.constant.ProtocolType;
import koal.urm.client.constant.ResType;
import koal.urm.client.protocol.ClientConnFactory;
import koal.urm.client.protocol.ClientConnection;
import koal.urm.client.resource.rpc.IResRpcDao;
import koal.urm.client.resource.rpc.ResRpcDaoFactory;
import koal.urm.client.resource.rpc.RpcDaoConfig;
import koal.urm.client.util.JsonUtil;

public class Demo{

    private static String clientUrl = "http://127.0.0.1:18900/resReg";
    private static  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    static {
        /**
         * 该方法需要配置两个参数 1.type 2.pwd
         * type:通讯方式，0-明文，3、通信码；
         * pwd：通讯码（该通讯码由KIAM系统指定）
         * 若使用通信码通讯方式，则必须配置正确的通信码，否则无法通信
         */
        RpcDaoConfig.config(0, "");
    }

    public static void main(String[] args) throws ParseException{
        //用户注册
//		user("register");
        //用户更新
//		user("update");
        //用户撤销
//		user("delete");
//		user("pullOne");
//		user("pull");

        //应用注册
//		app("register");
        //应用撤销
//		app("delete");
//		app("pullOne");

        //机构注册
//		org("register");
        //机构撤销
//		org("delete");
//		org("pullOne");

        //资源注册
//      res("register");
        //资源撤销
//      res("delete");
//      res("pullOne");

        //角色注册
//      role("register");
        //角色撤销
//      role("delete");
//      role("pullOne");

        //权限注册
//		rights("register");
        //权限撤销
//		rights("delete");
		/*pullOne(ResType.RES_TYPE_USER,"user2");
		Map<String, Object> userMap = new HashMap<>();
		userMap.put("USER_NO", "user2");
		pull(ResType.RES_TYPE_USER,userMap);
*/

        //0 用户
        System.err.println("0 用户");
        pullOne(ResType.RES_TYPE_USER,"user2");

//        Map<String, Object> userMap = new HashMap<>();
//        userMap.put("cond", "ORG_ID = '"+"123'");
//        pull(ResType.RES_TYPE_USER,userMap);
//        //1 应用
//        System.err.println("1 应用");
//        pullOne(ResType.RES_TYPE_APP,"132");
//        Map<String, Object> appMap = new HashMap<>();
//        appMap.put("APP_NO", "132");
//        appMap.put("cond", "APP_NO = '"+"132'");
////		appMap.put("cond", "1<2");
//        pull(ResType.RES_TYPE_APP,appMap);
//        //2 组织机构
//        System.err.println("2 组织机构");
//        pullOne(ResType.RES_TYPE_ORG,"123");
//        Map<String, Object> orgMap = new HashMap<>();
//        orgMap.put("cond", "1<2");
//        pull(ResType.RES_TYPE_ORG,orgMap);
//        //3证书
//        System.err.println("3证书");
//        pullOne(ResType.RES_TYPE_CERT,"user2");
//        Map<String, Object> certMap = new HashMap<>();
////		userMap.put("USER_NO", "user2");
//        certMap.put("cond", "1<2");
//        pull(ResType.RES_TYPE_CERT,certMap);
//        //4 账号信息
//        System.err.println("4 账号信息");
//        pullOne(ResType.RES_TYPE_ACCOUNT,"dailiang");
//        Map<String, Object> accountMap = new HashMap<>();
//        accountMap.put("cond", "1 = 1");
////		userMap.put("USER_NO", "user2");
//        accountMap.put("cond", "1<2");
//        pull(ResType.RES_TYPE_ACCOUNT,accountMap);
//        //5 组
//        System.err.println("5 组");
//        pullOne(ResType.RES_TYPE_GROUP,"user2");
//        Map<String, Object> groupMap = new HashMap<>();
////		userMap.put("USER_NO", "user2");
//        groupMap.put("cond", "1<2");
//        pull(ResType.RES_TYPE_GROUP,groupMap);
//        //6 角色信息
//        System.err.println("6 角色信息");
//        pullOne(ResType.RES_TYPE_ROLE,"1806281110418661587423571");
//        Map<String, Object> roleMap = new HashMap<>();
////		roleMap.put("USER_NO", "user2");
//        roleMap.put("cond", "ROLE_ID = '"+"1806281110418661587423571'");
//        roleMap.put("cond", "1<2");
//        pull(ResType.RES_TYPE_ROLE,roleMap);
//        //7 资源
//        System.err.println("7 资源");
//        pullOne(ResType.RES_TYPE_RES,"a11");
//        Map<String, Object> resMap = new HashMap<>();
//        resMap.put("cond", "RES_NO = '"+"a11'");
//        resMap.put("cond", "1<2");
//        pull(ResType.RES_TYPE_RES,resMap);
//        //8 权限
//        System.err.println("8 权限");
//        pullOne(ResType.RES_TYPE_RIGHTS,"user2");
//        Map<String, Object> rightMap = new HashMap<>();
////		userMap.put("USER_NO", "user2");
//        rightMap.put("cond", "1<2");
//        pull(ResType.RES_TYPE_RIGHTS,rightMap);
//        //9 组权限
//        System.err.println("9 组权限");
//        pullOne(ResType.RES_TYPE_GROUP_ROLE,"user2");
//        Map<String, Object> groupRoleMap = new HashMap<>();
////		userMap.put("USER_NO", "user2");
//        groupRoleMap.put("cond", "1<2");
//        pull(ResType.RES_TYPE_GROUP_ROLE,groupRoleMap);
//        //10 组成员
//        System.err.println("10 组成员");
//        pullOne(ResType.RES_TYPE_GROUP_USER,"user2");
//        Map<String, Object> groupUserMap = new HashMap<>();
////		userMap.put("USER_NO", "user2");
//        groupUserMap.put("cond", "1<2");
//        pull(ResType.RES_TYPE_GROUP_USER,groupUserMap);
//        //11 角色权限
//        System.err.println("11 角色权限");
//        pullOne(ResType.RES_TYPE_ROLE_RES,"user2");
//        Map<String, Object> roleResMap = new HashMap<>();
//        roleResMap.put("cond", "RES_NAME = '"+"a11'");
//        roleResMap.put("cond", "1<2");
//        pull(ResType.RES_TYPE_ROLE_RES,roleResMap);
//        //12 用户授权
//        System.err.println("12 用户授权");
//        pullOne(ResType.RES_TYPE_USER_ROLE,"180628111050175660421677");
//        Map<String, Object> userRoleMap = new HashMap<>();
//        userRoleMap.put("cond", "USER_ID = '"+"user1'");
//        userRoleMap.put("cond", "1<2");
//        pull(ResType.RES_TYPE_USER_ROLE,userRoleMap);
//        //13 日志数据
//        System.err.println("13 日志数据");
//        pullOne(ResType.RES_TYPE_LOG,"user2");
//        Map<String, Object> logMap = new HashMap<>();
////		userMap.put("USER_NO", "user2");
//        logMap.put("cond", "1<2");
//		pull(ResType.RES_TYPE_LOG,logMap);
    }

    public static void user(String opType) throws ParseException{

        if(opType.equals("register")){
            Map<String, Object> resMap = new HashMap<String, Object>();
            resMap.put("USER_NAME", "张三1");
            resMap.put("USER_NO", "zhangsan1");
            resMap.put("USER_SEX", "男");
            resMap.put("ORG_ID", "18081409270034243");
            resMap.put("USER_POST", "001");
            resMap.put("USER_NATIONALITY", "汉族");
            resMap.put("ID_CARD_NO", "410482199303284468");
            resMap.put("USER_EMAIL", "dailiang@koal.com");
            resMap.put("USER_TELEPHONE", "021-12345678");
            resMap.put("LOGIN_NAME", "zhangsan_login_1");
            resMap.put("PASSWORD", "zhangsan_pwd_1");
            resMap.put("USER_BIRTHDAY", new Date());
            register(ResType.RES_TYPE_USER, resMap);
        }else if(opType.equals("update")){
            Map<String, Object> resMap = new HashMap<String, Object>();
            resMap.put("USER_NO", "k_user_1");
            resMap.put("PASSWORD", "12345678");
            update(ResType.RES_TYPE_USER, resMap);
        }else if(opType.equals("delete")){
            String resNo = "zhangsan_no_1";
            Map<String, Object> resMap = new HashMap<String, Object>();
            resMap.put("USER_NO",resNo);
            delete(ResType.RES_TYPE_USER, resMap);
        }else if(opType.equals("pullOne")){
            String resNo = "zhangsan_no_1";
            pullOne(ResType.RES_TYPE_USER, resNo);
        }
    }

    public static void app(String opType){
        if(opType.equals("register")){
            Map<String, Object> resMap = new HashMap<String, Object>();
            resMap.put("APP_NO", "testApp1");
            resMap.put("APP_NAME", "testApp1");
            resMap.put("APP_IP", "192.168.111.222");
            resMap.put("APP_PORT", 80);
            resMap.put("APP_URL", "http://192.168.111.222");
            resMap.put("ORG_ID", "12345678");
            resMap.put("APP_LINKMAN", "李四");
            resMap.put("APP_LINKTEL", "021-9876543");
            resMap.put("APP_TYPE", 1);
            register(ResType.RES_TYPE_APP, resMap);
        }else if(opType.equals("delete")){
            String resNo = "testApp1";
            Map<String, Object> resMap = new HashMap<String, Object>();
            resMap.put("APP_NO",resNo);
            delete(ResType.RES_TYPE_APP, resMap);
        }
    }

    public static void org(String opType){
        if(opType.equals("register")){
            Map<String, Object> resMap = new HashMap<String, Object>();
            resMap.put("ORG_ID", "testOrg1");
            resMap.put("ORG_NAME", "testOrg1");
            resMap.put("ORG_NO", "testOrg1");
            resMap.put("ORG_AREA", "31");
            resMap.put("PARENT_ORG_ID", "");
            resMap.put("ORG_LEADER", "张三");
            resMap.put("ORG_LINKMAN", "王五");
            resMap.put("ORG_TELEPHONE", "021-55555555");
            resMap.put("SHARE_LEVEL", "1");
            resMap.put("ORG_TYPE", "0");
            register(ResType.RES_TYPE_ORG, resMap);
        }else if(opType.equals("delete")){
            String resNo = "testOrg1";
            Map<String, Object> resMap = new HashMap<String, Object>();
            resMap.put("ORG_ID",resNo);
            delete(ResType.RES_TYPE_ORG, resMap);
        }else if(opType.equals("pullOne")){
            String resNo = "koal";
            pullOne(ResType.RES_TYPE_ORG, resNo);
        }
    }

    public static void res(String opType){
        if(opType.equals("register")){
            Map<String, Object> resMap = new HashMap<String, Object>();
            resMap.put("RES_NO", "01no");
            resMap.put("RES_NAME", "ceshi01");
            resMap.put("RES_DES", "ziyumiaoshu");
            resMap.put("APP_NO", "urmTest2");
            resMap.put("PARENT_RES_NO", null);
            register(ResType.RES_TYPE_RES, resMap);
        }else if(opType.equals("delete")){
            String resNo = "testOrg1";
            Map<String, Object> resMap = new HashMap<String, Object>();
            resMap.put("OBJECTID",resNo);
            delete(ResType.RES_TYPE_RES, resMap);
        }else if(opType.equals("pullOne")){
            String resNo = "01no";
            pullOne(ResType.RES_TYPE_RES, resNo);
        }
    }

    public static void role(String opType){
        if(opType.equals("register")){
            Map<String, Object> resMap = new HashMap<String, Object>();
            resMap.put("ROLE_NAME", "ceshi01");
            resMap.put("ROLE_DES", "ceshi01");
            resMap.put("APP_NO", "urmTest2");
            register(ResType.RES_TYPE_ROLE, resMap);
        }else if(opType.equals("delete")){
            String resNo = "testOrg1";
            Map<String, Object> resMap = new HashMap<String, Object>();
            resMap.put("ROLE_ID",resNo);
            delete(ResType.RES_TYPE_ROLE, resMap);
        }else if(opType.equals("pullOne")){
            String resNo = "koal";
            pullOne(ResType.RES_TYPE_ROLE, resNo);
        }
    }


    public static void rights(String opType){
        if(opType.equals("register")){
            Map<String, Object> resMap = new HashMap<String, Object>();
            resMap.put("APP_NO", "urmTest2");
            resMap.put("USER_NO", "User001");
            resMap.put("RES_NO", "01no");
            register(ResType.RES_TYPE_RIGHTS, resMap);
        }else if(opType.equals("delete")){
            String resNo = "testOrg1";
            Map<String, Object> resMap = new HashMap<String, Object>();
            resMap.put("OBJECTID",resNo);
            delete(ResType.RES_TYPE_RIGHTS, resMap);
        }
    }

    private static void register(ResType resType, Map<String, Object> resMap){
        ClientConnection conn = null;
        try {
            String urlHead = clientUrl.substring(0,5);
            ProtocolType pro = ProtocolType.HTTP;
            if(urlHead.equals("https")){
                pro = ProtocolType.SINGLE_TRACK_HTTPS;
            }
            conn = ClientConnFactory.createInstance(pro, clientUrl);
            IResRpcDao dao = ResRpcDaoFactory.createResDao(conn, resType);
            dao.register(resMap);
            System.out.println(resType.getType() + "注册成功！");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(resType.getType() + "注册失败！");
        }
    }

    private static void update(ResType resType, Map<String, Object> resMap){
        ClientConnection conn = null;
        try {
            String urlHead = clientUrl.substring(0,5);
            ProtocolType pro = ProtocolType.HTTP;
            if(urlHead.equals("https")){
                pro = ProtocolType.SINGLE_TRACK_HTTPS;
            }
            conn = ClientConnFactory.createInstance(pro, clientUrl);
            IResRpcDao dao = ResRpcDaoFactory.createResDao(conn, resType);
            dao.register(resMap);
            System.out.println(resType.getType() + "修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(resType.getType() + "修改失败！");
        }
    }

    private static void delete(ResType resType,Map<String, Object> resMap){
        ClientConnection conn = null;
        try {
            String urlHead = clientUrl.substring(0,5);
            ProtocolType pro = ProtocolType.HTTP;
            if(urlHead.equals("https")){
                pro = ProtocolType.SINGLE_TRACK_HTTPS;
            }
            conn = ClientConnFactory.createInstance(pro, clientUrl);
            IResRpcDao dao = ResRpcDaoFactory.createResDao(conn, resType);
            dao.delete(resMap);
            System.out.println(resType.getType() + "删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(resType.getType() + "删除失败！");
        }
    }

    private static void pull(ResType resType, Map<String, Object> condMap){
        ClientConnection conn = null;
        try {
            String urlHead = clientUrl.substring(0,5);
            ProtocolType pro = ProtocolType.HTTP;
            if(urlHead.equals("https")){
                pro = ProtocolType.SINGLE_TRACK_HTTPS;
            }
            conn = ClientConnFactory.createInstance(pro, clientUrl);
            IResRpcDao dao = ResRpcDaoFactory.createResDao(conn, resType);
            List<Map<String, Object>> result = dao.pull(condMap);
            System.out.println(resType.getType() + "pull成功！查询结果为：" + JsonUtil.bean2Str(result));
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(resType.getType() + "pull失败！");
        }
    }

    private static void pullOne(ResType resType, String cond){
        ClientConnection conn = null;
        try {
            conn = ClientConnFactory.createInstance(ProtocolType.HTTP, clientUrl);
            IResRpcDao dao = ResRpcDaoFactory.createResDao(conn, resType);
            Map<String, Object> result = dao.pullOne(cond);
            System.out.println(resType.getType() + "pullOne成功！查询结果为：" + JsonUtil.bean2Str(result));
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(resType.getType() + "pullOne失败！");
        }
    }


}
