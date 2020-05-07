package com.pcitc.ssosync.rpcdao;

import com.pcitc.ssosync.common.JsonUtil;
import koal.urm.client.resource.recv.IResRecvDao;
import koal.urm.client.action.IpHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResRecvDaoImp implements IResRecvDao {

    Logger logger = LoggerFactory.getLogger(ResRecvDaoImp.class);

    static{
        System.out.println("发送方ip:" + IpHolder.getIp());
    }

    @Override
    public void beginTrans() throws Exception {
        System.out.println("beginTrans");
    }

    @Override
    public void commit() throws Exception {
        System.out.println("commit");
    }

    @Override
    public void rollback() throws Exception {
        System.out.println("rollback");
    }

    @Override
    public void saveUser(Map<String, Object> resourceMap) throws Exception {
        System.out.println();
        String ip = IpHolder.getIp();
        System.err.println(ip);
        Object pushSourceType = resourceMap.get("pushSourceType");
        if("Cert".equals(pushSourceType)){
            System.out.println("保存 证书");
        }else {
            System.out.println("保存 用户");
        }
        System.out.println("推送时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\nsaveUser:" + resourceMap);
        System.out.println(resourceMap.get("USER_STATUS"));
        logger.info(resourceMap.get("USER_NO").toString() + "," + resourceMap.get("USER_EMAIL"));
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
        for(String key : resourceMap.keySet()){
            System.out.println("key = " + key + " ; value = " + resourceMap.get(key));
        }
    }

    @Override
    public void deleteOrg(Map<String, Object> map) {
        System.out.println();
        System.out.println("删除 机构信息");
        System.out.println("推送时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\ndeleteOrg:" + map);
        for(String key : map.keySet()){
            System.out.println("key = " + key + " ; value = " + map.get(key));
        }
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
        String condStr = JsonUtil.ObjectToString(cond);
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
}
