package com.pcitc.web.interceptor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.system.SysUnit;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.system.SysUserUnit;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.sinopec.siam.provisioning.entity.Attribute;
import com.sinopec.siam.provisioning.entity.EventType;
import com.sinopec.siam.provisioning.entity.ProvisioningEvent;
import com.sinopec.siam.provisioning.entity.ProvisioningEvents;
import com.sinopec.siam.provisioning.entity.TargetEntity;
import com.sinopec.siam.provisioning.entity.TargetSubject;
import com.sinopec.siam.provisioning.listener.ProvisioningEventListener;

/**
 * @ClassName: SimpleProvisioningEventListener
 * @Description: 统一身份认证的监听服务，监听器监听到服务后，把相关修改调整到后台组织机构/用户中
 * @author zhf
 * @date 2018年8月07日 上午10:21:11
 * 
 */
@Component
public class SimpleProvisioningEventListenerService implements ProvisioningEventListener {
	private static final String	UNIT_GET_UNIT		= "http://pcitc-zuul/system-proxy/unit-provider/unit/get-unit/";
	private static final String	UNIT_ADD_UNIT		= "http://pcitc-zuul/system-proxy/unit-provider/unit/add-unit";
	private static final String	UNIT_UPDATE_UNIT	= "http://pcitc-zuul/system-proxy/unit-provider/unit/upd-unit";
	private static final String	GET_UNIT_CODE		= "http://pcitc-zuul/system-proxy/unit-provider/unit/unit-code";
	private static final String	GET_USER_INFO		= "http://pcitc-zuul/system-proxy/user-provider/user/get-user-byname/";
	private static final String	USER_ADD_URL		= "http://pcitc-zuul/system-proxy/user-provider/user/add-user";
	private static final String	USER_UNIT_ADD_URL	= "http://pcitc-zuul/system-proxy/user-provider/user/add-user_unit";
	private static final String	USER_UPDATE_URL		= "http://pcitc-zuul/system-proxy/user-provider/user/update-user";

	public SimpleProvisioningEventListenerService() {
		super();
	}

	/*
	 * public static void main(String[] args) { HttpHeaders httpHeaders = new
	 * HttpHeaders(); httpHeaders.set("Authorization",
	 * "Bearer eyJhbGciOiJIUzUxMiJ9.eyJ1c2VyVW5pdCI6IjEwMDAxLDE2NDFiM2I5MzQxXzlhM2ZkMWFhIiwidXNlckRpc3AiOiLotoXnuqfnrqHnkIblkZgiLCJ1c2VyTmFtZSI6ImFkbWluIiwicm9sZUxpc3QiOltdLCJleHAiOjE1NDA0NTA0OTYsInVzZXJJZCI6IjEyMyIsImVtYWlsIjoiNjc4MTA1NTk1OUBzaW5hLmNvbSJ9.L2ZxhelS9i-uOxl5Wzdjs2WubCMzs_NxTn4PizeVq6YjVg2FXG-6y_4B4Gun2LwOa2kXjOYcK2XBep0XAs76sA"
	 * ); RestTemplate restTemplate = new RestTemplate();
	 * httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8); SysUnit
	 * sysUnit = new SysUnit();
	 * //"http://127.0.0.1:8764/system-proxy/unit-provider/unit/unit-code"
	 * ResponseEntity<String> responseEntity = restTemplate.exchange(
	 * "http://127.0.0.1:8764/system-proxy/unit-provider/unit/unit-code" ,
	 * HttpMethod.POST, new HttpEntity<SysUnit>(sysUnit,httpHeaders),
	 * String.class); String rs = responseEntity.getBody(); }
	 */

	@Override
	public void process(ProvisioningEvents events) {
		System.out.println("统一身份认证消息接口");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		httpHeaders.set("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJ1c2VyVW5pdCI6IjEwMDAxLDE2NDFiM2I5MzQxXzlhM2ZkMWFhIiwidXNlckRpc3AiOiLotoXnuqfnrqHnkIblkZgiLCJ1c2VyTmFtZSI6ImFkbWluIiwicm9sZUxpc3QiOltdLCJleHAiOjE1NDA0NTA0OTYsInVzZXJJZCI6IjEyMyIsImVtYWlsIjoiNjc4MTA1NTk1OUBzaW5hLmNvbSJ9.L2ZxhelS9i-uOxl5Wzdjs2WubCMzs_NxTn4PizeVq6YjVg2FXG-6y_4B4Gun2LwOa2kXjOYcK2XBep0XAs76sA");
		RestTemplate restTemplate = new RestTemplate();
		List<ProvisioningEvent> list = events.getEvent();
		String vlaue;
		for (int i = 0; i<list.size(); i++) {
			ProvisioningEvent event = new ProvisioningEvent();
			event = list.get(i);
			SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println("监听到事件内容如下:");
			System.out.println("事件流水号:"+event.getEventId());
			if (event.getOccuredTimestamp()==null) {
				System.out.println("事件发生时间:null");
			} else {
				System.out.println("事件发生时间:"+time.format(event.getOccuredTimestamp().getTime()));
			}
			System.out.println("事件类型:"+event.getEventType());
			/**
			 * 组织机构创建
			 */
			if (EventType.ORGUNIT_CREATED.equals(event.getEventType())) {
				TargetEntity originalEntity = event.getTargetEntity();// getOriginalEntity();
				if (originalEntity!=null) {
					SysUnit sysUnit = new SysUnit();
					TargetSubject originalSubject = originalEntity.getSubject();
					System.out.println("组织机构主题:"+originalSubject);
					@SuppressWarnings("unchecked")
					List<Attribute> originalAttributes = originalEntity.getAttributes();
					System.out.println("组织机构属性集合:");
					System.out.println("originalEntity============="+JSONObject.toJSONString(originalEntity));
					for (Attribute attribute : originalAttributes) {
						String keyName = attribute.getName();
						List valueList = attribute.getValues();
						System.out.println("attribute============="+JSONObject.toJSONString(attribute));
						if (valueList!=null&&valueList.size()>0) {
							vlaue = attribute.getValues().get(0).toString();
						} else {
							vlaue = "";
						}
						if ("cn".equals(keyName)) {
							sysUnit.setUnitName(vlaue);// 机构名称
						}
						if ("ou".equals(keyName)) {
							sysUnit.setUnitId(vlaue);// 接口传来的编码为本系统主键ID（接口所传数据中无主键ID）
						}
						if ("spfullname".equals(keyName)) {
							sysUnit.setUnitExtend(vlaue);// 机构全路径名称,暂时存放UnitExtend
						}
						if ("spOutype".equals(keyName)) {
							sysUnit.setUnitKind(vlaue);// 机构类别
						}
						if ("spOrgLevel".equals(keyName)) {
							// sysUnit.setUnitLevel(4);//机构级别
						}
						if ("spparents".equals(keyName)) {
							// 因和上级编码重复 暂时不存储
							sysUnit.setUnitRelation(vlaue);
						}
						if ("spOrgNamePath".equals(keyName)) {
							// 暂无存储位置（机构名称全路径）
						}
						if ("spOrgCodePath".equals(keyName)) {
							sysUnit.setUnitPath(vlaue);// 机构编码全路径
						}
						if ("spSupervisoryDepartment".equals(keyName)) {
							// sysUnit.setUnitRelation(vlaue);//机构上级编码因真实数据报错
							// 暂时用0代替
						}
						if ("spEntryStatus".equals(keyName)) {
							// 因类型不符合 暂时用0
							sysUnit.setUnitDelflag(0);// 机构状态
						}
						if ("pastalAddress".equals(keyName)) {
							sysUnit.setUnitAddress(vlaue);// 机构地址
						}
					}
					System.out.println("参数循环完毕");
					sysUnit.setUnitFlag("系统标识符");
					sysUnit.setUnitCreateTime(new Date());
					sysUnit.setUnitOrder(1);
					sysUnit.setUnitPhone("95105888");
					sysUnit.setUnitManager("负责人");
					sysUnit.setUnitControl("控制者");
					sysUnit.setUnitAccount("机构账户");
					// sysUnit.setUnitCode("ABC");
					HttpEntity<Object> entit = new HttpEntity<Object>(sysUnit, httpHeaders);
					restTemplate.exchange(UNIT_ADD_UNIT, HttpMethod.POST, entit, Object.class);
				}
			}
			/**
			 * 组织机构修改
			 */
			System.out.println(EventType.ORGUNIT_MODIFIED+"====="+event.getEventType());
			if (EventType.ORGUNIT_MODIFIED.equals(event.getEventType())) {
				TargetEntity originalEntity = event.getTargetEntity();
				if (originalEntity!=null) {
					TargetSubject originalSubject = originalEntity.getSubject();
					System.out.println("组织机构主题:"+originalSubject);
					SysUnit sysUnit = restTemplate.exchange(UNIT_GET_UNIT+originalSubject.getSubject(), HttpMethod.POST, new HttpEntity<Object>(httpHeaders), SysUnit.class).getBody();
					@SuppressWarnings("unchecked")
					List<Attribute> originalAttributes = originalEntity.getAttributes();
					System.out.println("组织机构属性集合:");
					for (Attribute attribute : originalAttributes) {
						System.out.println(attribute);
						String keyName = attribute.getName();
						List valueList = attribute.getValues();
						if (valueList!=null&&valueList.size()>0) {
							vlaue = attribute.getValues().get(0).toString();
						} else {
							vlaue = "";
						}
						if ("cn".equals(keyName)) {
							sysUnit.setUnitName(vlaue);// 机构名称
						}
						/*
						 * if("ou".equals(keyName)){
						 * sysUnit.setUnitId(vlaue);//——修改时取用Subject的编码作为主键 }
						 */
						if ("spfullname".equals(keyName)) {
							sysUnit.setUnitAbbr(vlaue);// 机构全路径名称
						}
						if ("spOutype".equals(keyName)) {
							sysUnit.setUnitKind(vlaue);// 机构类别
						}
						if ("spOrgLevel".equals(keyName)) {
							sysUnit.setUnitLevel(4);// 机构级别
						}
						if ("spparents".equals(keyName)) {
							// 因和上级编码重复 暂时不存储sysUnit.setUnitRelation(vlaue);
						}
						if ("spOrgNamePath".equals(keyName)) {
							// 暂无存储位置（机构名称全路径）
						}
						if ("spOrgCodePath".equals(keyName)) {
							sysUnit.setUnitPath(vlaue);// 机构编码全路径
						}
						if ("spSupervisoryDepartment".equals(keyName)) {
							sysUnit.setUnitRelation(vlaue);// 机构上级编码
						}
						if ("spEntryStatus".equals(keyName)) {
							// 因类型不符合 暂时用0
							sysUnit.setUnitDelflag(0);// 机构状态
						}
						if ("pastalAddress".equals(keyName)) {
							sysUnit.setUnitAddress(vlaue);// 机构地址
						}
					}
					HttpEntity<Object> entit = new HttpEntity<Object>(sysUnit, httpHeaders);
					restTemplate.exchange(UNIT_UPDATE_UNIT, HttpMethod.POST, entit, Object.class);
				}
			}
			/**
			 * 组织机构删除(修改UnitDelflag为1)
			 */
			if (EventType.ORGUNIT_DELETED.equals(event.getEventType())) {
				TargetEntity originalEntity = event.getTargetEntity();
				if (originalEntity!=null) {
					TargetSubject originalSubject = originalEntity.getSubject();
					System.out.println("组织机构主题:"+originalSubject);
					SysUnit sysUnit = restTemplate.exchange(UNIT_GET_UNIT+originalSubject.getSubject(), HttpMethod.POST, new HttpEntity<Object>(httpHeaders), SysUnit.class).getBody();
					sysUnit.setUnitDelflag(1);
					HttpEntity<Object> entit = new HttpEntity<Object>(sysUnit, httpHeaders);
					restTemplate.exchange(UNIT_UPDATE_UNIT, HttpMethod.POST, entit, Object.class);
				}
			}
			/**
			 * 应用账号创建
			 */
			if (EventType.ACCOUNT_CREATED.equals(event.getEventType())) {
				TargetEntity targetEntity = event.getTargetEntity();
				if (targetEntity!=null) {
					TargetSubject targetSubject = targetEntity.getSubject();
					System.out.println("应用账号主题:"+targetSubject);
					System.out.println("应用账号属性集合:");
					@SuppressWarnings("unchecked")
					List<Attribute> attributes = targetEntity.getAttributes();
					System.out.println("targetEntity============="+JSONObject.toJSONString(targetEntity));
					SysUser sysUser = new SysUser();
					for (Attribute attribute : attributes) {
						String keyName = attribute.getName();
						List valueList = attribute.getValues();
						System.out.println("attribute============="+JSONObject.toJSONString(attribute));
						if (valueList!=null&&valueList.size()>0) {
							vlaue = attribute.getValues().get(0).toString();
						} else {
							vlaue = "";
						}
						if ("cn".equals(keyName)) {
							sysUser.setUserDisp(vlaue);// 用户姓名
						}
						/*
						 * if("account_uid".equals(keyName)){
						 * sysUser.setUserName(vlaue);//登录账号 }
						 */
						if ("employeenumber".equals(keyName)) {
							sysUser.setUserComment(vlaue);// 员工编码
						}
						if ("employeetype".equals(keyName)) {
							sysUser.setUserKind(vlaue);// 用户类型
						}
						if ("departmentnumber".equals(keyName)) {
							sysUser.setUserUnit(vlaue);// 用户所属机构

						}
						if ("mail".equals(keyName)) {
							sysUser.setUserMail(vlaue);// 用户邮箱
						}
						if ("mobile".equals(keyName)) {
							sysUser.setUserMobile(vlaue);// 用户手机号
						}
						if ("telephonenumber".equals(keyName)) {
							sysUser.setUserPhone(vlaue);// 用户座机号
						}
						if ("sptitlelevel".equals(keyName)) {
							sysUser.setUserLevel(1);// 用户姓名-类型不同存储固定值
						}
					}
					sysUser.setUserName(targetSubject.getSubject());
					sysUser.setUserPassword("2cbb78c76ed2edecca69b7d6c0e0e578");
					sysUser.setUserFlag("1");// 暂时写常量（也可在消息队列中查询）
					sysUser.setUserOrder(1);
					sysUser.setUserSign("用户签章");
					sysUser.setIsDomain(0);
					sysUser.setUserPost("1");
					sysUser.setUserRole("1");
					sysUser.setUserDelflag(0);
					sysUser.setUserRelation("用户关系");
					sysUser.setUserExtend("扩展信息");
					sysUser.setLoginErrorNumber(3);
					sysUser.setLoginCheckCode("验证码");
					sysUser.setUserCreateTime(DateUtil.dateToStr(new Date(), DateUtil.FMT_SS));
					// 获取用户所在机构部门
					SysUnit unit = restTemplate.exchange(UNIT_GET_UNIT+sysUser.getUserUnit(), HttpMethod.POST, new HttpEntity<Object>(httpHeaders), SysUnit.class).getBody();
					sysUser.setUserId(IdUtil.createIdByTime());
					// 插入用户数据
					restTemplate.exchange(USER_ADD_URL, HttpMethod.POST, new HttpEntity<SysUser>(sysUser, httpHeaders), Integer.class);
					// 插入用户机构关联表数据
					SysUserUnit sur = new SysUserUnit();
					sur.setRelId(IdUtil.createIdByTime());
					if (unit!=null) {
						sur.setUnitId(unit.getUnitId());
					} else {
						sur.setUnitId(sysUser.getUserUnit());
					}
					sur.setUserId(sysUser.getUserId());
					restTemplate.exchange(USER_UNIT_ADD_URL, HttpMethod.POST, new HttpEntity<SysUserUnit>(sur, httpHeaders), Integer.class);
					
					// 创建完人员，赋值初始的岗位权限
				}
			}
			/**
			 * 应用账号禁用
			 */
			if (EventType.ACCOUNT_DISABLED.equals(event.getEventType())) {
				String username = "";
				TargetEntity targetEntity = event.getTargetEntity();
				if (targetEntity!=null) {
					TargetSubject targetSubject = targetEntity.getSubject();
					System.out.println("应用账号主题:"+targetSubject);
					System.out.println("应用账号属性集合:");
					/*
					 * @SuppressWarnings("unchecked") List<Attribute> attributes
					 * = targetEntity.getAttributes(); for (Attribute attribute
					 * : attributes) { String keyName = attribute.getName();
					 * List valueList = attribute.getValues(); if(valueList !=
					 * null && valueList.size()>0) { vlaue =
					 * attribute.getValues().get(0).toString(); }else { vlaue =
					 * ""; } if("account_uid".equals(keyName)){ username =
					 * vlaue;//登录账号 } }
					 */
					username = targetSubject.getSubject();
					ResponseEntity<SysUser> rsEntity = restTemplate.exchange(GET_USER_INFO+username, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), SysUser.class);
					SysUser rsUser = rsEntity.getBody();
					rsUser.setUserDelflag(1);
					// 禁用用户数据（userdelfag改成1）
					restTemplate.exchange(USER_UPDATE_URL, HttpMethod.POST, new HttpEntity<SysUser>(rsUser, httpHeaders), Integer.class);
				}
			}
			/**
			 * 应用账号启用
			 */
			if (EventType.ACCOUNT_ENABLED.equals(event.getEventType())) {
				String username = "";
				TargetEntity targetEntity = event.getTargetEntity();
				if (targetEntity!=null) {
					TargetSubject targetSubject = targetEntity.getSubject();
					System.out.println("应用账号主题:"+targetSubject);
					System.out.println("应用账号属性集合:");
					/*
					 * @SuppressWarnings("unchecked") List<Attribute> attributes
					 * = targetEntity.getAttributes(); for (Attribute attribute
					 * : attributes) { String keyName = attribute.getName();
					 * List valueList = attribute.getValues(); if(valueList !=
					 * null && valueList.size()>0) { vlaue =
					 * attribute.getValues().get(0).toString(); }else { vlaue =
					 * ""; } if("uid".equals(keyName)){ username = vlaue;//登录账号
					 * } }
					 */
					username = targetSubject.getSubject();
					ResponseEntity<SysUser> rsEntity = restTemplate.exchange(GET_USER_INFO+username, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), SysUser.class);
					SysUser rsUser = rsEntity.getBody();
					rsUser.setUserDelflag(0);
					// 启用用户数据（userdelfag改成0）
					restTemplate.exchange(USER_UPDATE_URL, HttpMethod.POST, new HttpEntity<SysUser>(rsUser, httpHeaders), Integer.class);
				}
			}
			/**
			 * 应用账号删除
			 */
			if (EventType.ACCOUNT_DELETED.equals(event.getEventType())) {
				String username = "";
				TargetEntity targetEntity = event.getTargetEntity();
				if (targetEntity!=null) {
					TargetSubject targetSubject = targetEntity.getSubject();
					System.out.println("应用账号主题:"+targetSubject);
					System.out.println("应用账号属性集合:");
					/*
					 * @SuppressWarnings("unchecked") List<Attribute> attributes
					 * = targetEntity.getAttributes(); for (Attribute attribute
					 * : attributes) { String keyName = attribute.getName();
					 * List valueList = attribute.getValues(); if(valueList !=
					 * null && valueList.size()>0) { vlaue =
					 * attribute.getValues().get(0).toString(); }else { vlaue =
					 * ""; } if("uid".equals(keyName)){ username = vlaue;//登录账号
					 * } }
					 */
					username = targetSubject.getSubject();
					ResponseEntity<SysUser> rsEntity = restTemplate.exchange(GET_USER_INFO+username, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), SysUser.class);
					SysUser rsUser = rsEntity.getBody();
					rsUser.setUserDelflag(1);
					// 禁用用户数据（userdelfag改成1）
					restTemplate.exchange(USER_UPDATE_URL, HttpMethod.POST, new HttpEntity<SysUser>(rsUser, httpHeaders), Integer.class);
				}
			}
		}
	}
}
