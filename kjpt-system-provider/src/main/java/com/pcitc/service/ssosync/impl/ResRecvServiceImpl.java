package com.pcitc.service.ssosync.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.system.SysUnit;
import com.pcitc.base.system.SysUnitExample;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.system.SysUserUnit;
import com.pcitc.base.util.DateUtil;
import com.pcitc.mapper.system.SysUnitMapper;
import com.pcitc.mapper.system.SysUserMapper;
import com.pcitc.mapper.system.SysUserUnitMapper;
import com.pcitc.service.system.UserService;
import com.pcitc.utils.SpringContextUtil;

import koal.urm.client.action.IpHolder;
import koal.urm.client.resource.recv.IResRecvDao;
public class ResRecvServiceImpl implements IResRecvDao {

    Logger logger = LoggerFactory.getLogger(ResRecvServiceImpl.class);
    
   //private ApplicationContext applicationContext=SpringUtil.getApplicationContext(); 
    //private UserServiceImpl userService=applicationContext.getBean(UserServiceImpl.class);
    //private UserService userService=(UserService)SpringUtil.getObject(UserService.class);
   /* 
	private static  SysUserMapper sysUserMapper;
	@Autowired
    private static ApplicationContext applicationContext;
    
    static{
        if( sysUserMapper==null){
        	  System.out.println("--------1--applicationContext------------"+applicationContext);
        	 sysUserMapper = (SysUserMapper)SpringContextUtil.getBean("sysUserMapper");

        }
    }
	
	@Autowired
	private SysUserUnitMapper sysUserUnitMapper;
	
	
	@Autowired
	private SysUnitMapper sysUnitMapper;
	
	*/
	

    static{
        System.out.println("发送方ip:" + IpHolder.getIp());
    }

    @Override
    public void beginTrans() throws Exception {
        System.out.println("----------beginTrans------------");
    }

    @Override
    public void commit() throws Exception {
        System.out.println("------------commit------------");
    }

    @Override
    public void rollback() throws Exception {
        System.out.println("---------rollback----------");
    }

    @Override
    public void saveUser(Map<String, Object> resourceMap) throws Exception {
        System.out.println();
        String ip = IpHolder.getIp();
        System.err.println(ip);
        Object pushSourceType = resourceMap.get("pushSourceType");
        if("Cert".equals(pushSourceType))
        {
            System.out.println("保存 证书");
        }else {
            System.out.println("保存 用户");
        }
    	JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resourceMap));
    	System.out.println("推送时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) );
    	System.out.println("用户信息：\n"+result);
    	 
         SysUser user=new SysUser();
         String  userDisp=(String)resourceMap.get("USER_NAME");
         String  sex=(String)resourceMap.get("USER_SEX");
         String  orgid=(String)resourceMap.get("ORG_ID");//组织机构ID
         String  idCard=(String)resourceMap.get("ID_CARD_NO");//身份证号
         String  userNo=(String)resourceMap.get("USER_NO");//用户名
         String  userId=(String)resourceMap.get("USER_ID");
         String  post=(String)resourceMap.get("USER_POST");
         String  nationallty=(String)resourceMap.get("USER_NATIONALITY");//汉族
         String  userMail=(String)resourceMap.get("USER_EMAIL");
         String  userPhone=(String)resourceMap.get("USER_TELEPHONE");
         String  loginName=(String)resourceMap.get("LOGIN_NAME"); 
         String  birthday=(String)resourceMap.get("USER_BIRTHDAY"); 
         String  userMobile=(String)resourceMap.get("USER_MOBILE");
         String  status=(String)resourceMap.get("USER_STATUS");//USER_STATUS为9000时，表示用户注销
         String  level=(String)resourceMap.get("USER_POST_LEVEL");
         
         /*
          SysUser u= userService.getUserByUnifyIdentityId(idCard);
         System.out.println("---------sysUserMapper----------"+sysUserMapper);
         SysUser u= sysUserMapper.getUserByUnifyIdentityId(idCard);
         if(u==null) 
         {
        	 String dateid = UUID.randomUUID().toString().replaceAll("-", "");
             user.setUserId(dateid);
             user.setUserName(userNo);
             user.setUserDisp(userDisp);
             user.setUserPhone(userPhone);
             user.setUnifyIdentityId(idCard);
             user.setUserUnit(orgid);
             user.setUserMail(userMail);
             user.setUserMobile(userMobile);
             user.setUserCreateTime(DateUtil.dateToStr(new Date(), DateUtil.FMT_SS));
             user.setUserDelflag(0);
             user.setUserPassword("670b14728ad9902aecba32e22fa4f6bd");//默认：000000
             sysUserMapper.insert(user);
             String dateid2 = UUID.randomUUID().toString().replaceAll("-", "");
             
             SysUserUnit su=new SysUserUnit();
             su.setUserId(dateid);
             su.setUnitId(orgid);
             su.setRelId(dateid2);
             sysUserUnitMapper.insert(su);
         }
        */
      
        
    }


    @Override
    public void deleteUser(Map<String, Object> resourceMap) {
        System.out.println();
        Object pushSourceType = resourceMap.get("pushSourceType");
        if("Cert".equals(pushSourceType)){
            System.out.println("删除 证书");
        }else {
            System.out.println("删除 用户");
        }
        System.out.println("推送时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\ndeleteUser:" + resourceMap);
        for(String key : resourceMap.keySet()){
            System.out.println("key = " + key + " ; value = " + resourceMap.get(key));
        }
    }

    @Override
    public void saveOrgUser(Map<String, Object> resourceMap) throws Exception {
        System.out.println();
        System.out.println("保存 机构用户信息");
        System.out.println("推送时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\nsaveOrgUser:" + resourceMap);
        for(String key : resourceMap.keySet()){
            System.out.println("key = " + key + " ; value = " + resourceMap.get(key));
        }
    }

    @Override
    public void deleteOrgUser(Map<String, Object> map) {
        System.out.println();
        System.out.println("删除 机构用户信息");
        System.err.println(map.get("pushSourceType"));
        System.out.println("推送时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\ndeleteOrgUser:" + map);
        for(String key : map.keySet()){
            System.out.println("key = " + key + " ; value = " + map.get(key));
        }
    }

    @Override
    public void saveApp(Map<String, Object> resourceMap) throws Exception {
        System.out.println();
        System.out.println("保存 应用信息");
        System.out.println("推送时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\nsaveApp:" + resourceMap);
        for(String key : resourceMap.keySet()){
            System.out.println("key = " + key + " ; value = " + resourceMap.get(key));
        }
    }

    @Override
    public void deleteApp(Map<String, Object> map) {
        System.out.println();
        System.out.println("删除 应用信息");
        System.out.println("推送时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\ndeleteApp:" + map);
        for(String key : map.keySet()){
            System.out.println("key = " + key + " ; value = " + map.get(key));
        }
    }

    @Override
    public void saveAuthority(Map<String, Object> resourceMap) throws Exception {
        System.out.println();
        System.out.println("保存 权限信息");
        System.out.println("推送时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\nsaveAuthority:" + resourceMap);
        for(String key : resourceMap.keySet()){
            System.out.println("key = " + key + " ; value = " + resourceMap.get(key));
        }
    }

    @Override
    public void deleteAuthority(Map<String, Object> map) {
        System.out.println();
        System.out.println("删除 权限信息");
        System.out.println("推送时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\ndeleteAuthority:" + map);
        for(String key : map.keySet()){
            System.out.println("key = " + key + " ; value = " + map.get(key));
        }
    }

    @Override
    public void saveOrg(Map<String, Object> resourceMap) throws Exception {
        System.out.println();
        System.out.println("保存 机构信息");
        System.out.println("推送时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\nsaveOrg:" + resourceMap);
        for(String key : resourceMap.keySet())
        {
            System.out.println("key = " + key + " ; value = " + resourceMap.get(key));
        }
        /*
        String  parentOrgId=(String)resourceMap.get("PARENT_ORG_ID");
        String  unitId=(String)resourceMap.get("ORG_ID");
        String  unitName=(String)resourceMap.get("ORG_NAME");
        String  unitCode=(String)resourceMap.get("ORG_NO"); 
        String  orgType=(String)resourceMap.get("ORG_TYPE");
        String  status=(String)resourceMap.get("ORG_STATUS");
        SysUnit su=  sysUnitMapper.selectByPrimaryKey(unitId);
        if(su==null)
        {
        	 SysUnit sysUnit=new SysUnit();
             sysUnit.setUnitId(unitId);
             sysUnit.setUnitName(unitName);
             sysUnit.setUnitCode(unitCode);
             sysUnit.setUnitRelation(parentOrgId);
             sysUnit.setUnitCreateTime(new Date());
             sysUnit.setUnitDelflag(0);
             String unitRelation="";
             if(parentOrgId==null || parentOrgId.equals(""))
             {
            	 unitRelation= "10";
            	 sysUnit.setUnitRelation(unitRelation);
            	 sysUnit.setUnitPath("1001");
             }else
             {
            	
            	 SysUnit parentSysUnit= sysUnitMapper.selectByPrimaryKey(parentOrgId);
            	 unitRelation= createUnitPath(parentSysUnit.getUnitRelation());
            	 sysUnit.setUnitPath(unitRelation);
             }
             sysUnitMapper.insert(sysUnit);
        }
        */
        
    }

    @Override
    public void deleteOrg(Map<String, Object> map) {
        System.out.println();
        System.out.println("删除 机构信息");
        System.out.println("推送时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\ndeleteOrg:" + map);
        for(String key : map.keySet()){
            System.out.println("key = " + key + " ; value = " + map.get(key));
        }
        /*
        String  unitId=(String)map.get("ORG_ID");
        String  status=(String)map.get("ORG_STATUS");
        SysUnit su=  sysUnitMapper.selectByPrimaryKey(unitId);
        su.setUnitDelflag(1);
        sysUnitMapper.updateByPrimaryKey(su);
        */
    }

    @Override
    public void saveAccount(Map<String, Object> resourceMap) throws Exception {
        System.out.println();
        System.out.println("保存 账号信息");
        System.out.println("推送时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\nsaveAccount:" + resourceMap);
        for(String key : resourceMap.keySet()){
            System.out.println("key = " + key + " ; value = " + resourceMap.get(key));
        }
    }


    @Override
    public void deleteAccount(Map<String, Object> map) {
        System.out.println();
        System.out.println("删除 账号信息");
        System.out.println("推送时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\ndeleteAccount:" + map);
        for(String key : map.keySet()){
            System.out.println("key = " + key + " ; value = " + map.get(key));
        }
    }

    @Override
    public void saveGroup(Map<String, Object> resourceMap) throws Exception {
        System.out.println();
        System.out.println("保存 组信息");
        System.out.println("推送时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\nsaveGroup:" + resourceMap);
        for(String key : resourceMap.keySet()){
            System.out.println("key = " + key + " ; value = " + resourceMap.get(key));
        }
    }


    @Override
    public void deleteGroup(Map<String, Object> map) {
        System.out.println();
        System.out.println("删除 组信息");
        System.out.println("推送时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\ndeleteGroup:" + map);
        for(String key : map.keySet()){
            System.out.println("key = " + key + " ; value = " + map.get(key));
        }
    }

    @Override
    public void saveRole(Map<String, Object> resourceMap) throws Exception {
        System.out.println();
        System.out.println("保存 角色信息");
        System.out.println("推送时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\nsaveRole:" + resourceMap);
        for(String key : resourceMap.keySet()){
            System.out.println("key = " + key + " ; value = " + resourceMap.get(key));
        }
    }

    @Override
    public void deleteRole(Map<String, Object> map) {
        System.out.println();
        System.out.println("删除 角色信息");
        System.out.println("推送时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\ndeleteRole:" + map);
        for(String key : map.keySet()){
            System.out.println("key = " + key + " ; value = " + map.get(key));
        }
    }

    @Override
    public void saveUserAuthority(Map<String, Object> resourceMap) throws Exception {
        System.out.println();
        System.out.println("保存 用户权限信息");
        System.out.println("推送时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\nsaveUserAuthority:" + resourceMap);
        for(String key : resourceMap.keySet()){
            System.out.println("key = " + key + " ; value = " + resourceMap.get(key));
        }

    }

    @Override
    public void deleteUserAuthority(Map<String, Object> map) {
        System.out.println();
        System.out.println("删除 用户权限信息");
        System.out.println("推送时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\ndeleteUserAuthority:" + map);
        for(String key : map.keySet()){
            System.out.println("key = " + key + " ; value = " + map.get(key));
        }
    }

    @Override
    public void saveGroupRole(Map<String, Object> resourceMap) throws Exception {
        System.out.println();
        System.out.println("保存 组角色信息");
        System.out.println("推送时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\nsaveGroupRole:" + resourceMap);
        for(String key : resourceMap.keySet()){
            System.out.println("key = " + key + " ; value = " + resourceMap.get(key));
        }
    }

    @Override
    public void deleteGroupRole(Map<String, Object> map) {
        System.out.println();
        System.out.println("删除 组角色信息");
        System.out.println("推送时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\ndeleteGroupRole:" + map);
        for(String key : map.keySet()){
            System.out.println("key = " + key + " ; value = " + map.get(key));
        }
    }

    @Override
    public void saveGroupMember(Map<String, Object> resourceMap) throws Exception {
        System.out.println();
        System.out.println("保存 组成员信息");
        System.out.println("推送时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\nsaveGroupMember:" + resourceMap);
        for(String key : resourceMap.keySet()){
            System.out.println("key = " + key + " ; value = " + resourceMap.get(key));
        }
    }


    @Override
    public void deleteGroupMember(Map<String, Object> map) {
        System.out.println();
        System.out.println("删除 组成员信息");
        System.out.println("推送时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\ndeleteGroupMember:" + map);
        for(String key : map.keySet()){
            System.out.println("key = " + key + " ; value = " + map.get(key));
        }
    }

    @Override
    public void saveRoleAuthority(Map<String, Object> resourceMap) throws Exception {
        System.out.println();
        System.out.println("保存 角色权限信息");
        System.out.println("推送时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\nsaveRoleAuthority:" + resourceMap);
        for(String key : resourceMap.keySet()){
            System.out.println("key = " + key + " ; value = " + resourceMap.get(key));
        }
    }

    @Override
    public void deleteRoleAuthority(Map<String, Object> map) {
        System.out.println();
        System.out.println("删除 角色权限信息");
        System.out.println("推送时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\ndeleteRoleAuthority:" + map);
        for(String key : map.keySet()){
            System.out.println("key = " + key + " ; value = " + map.get(key));
        }
    }

    @Override
    public void saveUserRole(Map<String, Object> resourceMap) throws Exception {
        System.out.println();
        System.out.println("保存 用户角色信息");
        System.out.println("推送时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\nsaveUserRole:" + resourceMap);
        for(String key : resourceMap.keySet()){
            System.out.println("key = " + key + " ; value = " + resourceMap.get(key));
        }
    }

    @Override
    public void saveUserRole(List<Map<String, Object>> list) throws Exception {
        System.out.println();
        System.out.println("保存 多个用户角色信息" + ",数量为:"+list.size());
        for(Map<String, Object> resourceMap : list){
            System.out.println("保存 用户角色信息");
            System.out.println("推送时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\nsaveUserRole:" + resourceMap);
            for(String key : resourceMap.keySet()){
                System.out.println("key = " + key + " ; value = " + resourceMap.get(key));
            }
        }
    }

    @Override
    public void deleteUserRole(Map<String, Object> map) {
        System.out.println();
        System.out.println("删除 用户角色信息");
        System.out.println("推送时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\ndeleteUserRole:" + map);
        for(String key : map.keySet()){
            System.out.println("key = " + key + " ; value = " + map.get(key));
        }
    }

    @Override
    public List<Map<String, Object>> pull(Map<String, Object> cond) throws Exception {
        System.out.println();
        System.out.println("拉取 数据");
        String condStr = JSON.toJSONString(cond);
      //  String condStr = JSONObject.PAR JsonUtil.ObjectToString(cond);
        System.out.println("推送时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\npull:  cond:" + condStr);
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("USER_ID1", 233333333);
        map1.put("USER_NAME1", "张三1");
        map1.put("date1", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        map1.put("ID_CARD_TYPE1", "1");
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("USER_ID2", 233333333);
        map2.put("USER_NAME2", "张三2");
        map2.put("date2", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        map2.put("ID_CARD_TYPE2", "2");
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list.add(map1);
        list.add(map2);
        return list;
    }

    @Override
    public Map<String, Object> pullOne(String resNo) throws Exception {
        System.out.println();
        System.out.println("拉取 单条数据");
        System.out.println("推送时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\npullOne:  resNo为  " + resNo);
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("key1", "value1");
        return map1;
    }


    @Override
    public void deleteResource(Map<String, Object> map) {
        System.out.println();
        System.out.println("删除 资源数据");
        System.out.println("推送时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\ndeleteResource:" + map);
        for(String key : map.keySet()){
            System.out.println("key = " + key + " ; value = " + map.get(key));
        }
    }

    @Override
    public void saveResource(Map<String, Object> resourceMap) throws Exception {
        System.out.println();
        System.out.println("保存 资源数据");
        System.out.println("推送时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\nsaveResource:" + resourceMap);
        for(String key : resourceMap.keySet()){
            System.out.println("key = " + key + " ; value = " + resourceMap.get(key));
        }
    }
    
    
    
    
    
    /*
    private String createUnitPath(String  unitRelation) {
		SysUnitExample example = new SysUnitExample();
		SysUnitExample.Criteria c = example.createCriteria();
		c.andUnitRelationEqualTo(unitRelation);
		example.setOrderByClause("unit_path desc");
		Integer number;
		List<SysUnit> units = sysUnitMapper.selectByExample(example);
		if (units == null || units.size() == 0) {
			SysUnit parentUnit = sysUnitMapper.selectByPrimaryKey(unitRelation);
			return parentUnit.getUnitPath() + "0001";
		} else {
			String path = units.get(0).getUnitPath();
			if (path.length() < 4) {
				number = new Integer("1" + path.substring(path.length() - 3)) + 1;
				return path.substring(0, path.length() - 3) + number.toString().substring(1);
			} else {
				number = new Integer("1" + path.substring(path.length() - 4)) + 1;
				return path.substring(0, path.length() - 4) + number.toString().substring(1);
			}
		}
	}*/
}
