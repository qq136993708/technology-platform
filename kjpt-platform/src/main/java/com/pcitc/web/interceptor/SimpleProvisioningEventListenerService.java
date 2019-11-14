package com.pcitc.web.interceptor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Result;
import com.pcitc.base.system.SysCurrencyLog;
import com.pcitc.base.system.SysUnit;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.web.config.SpringContextUtil;
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
 */
@Component
public class SimpleProvisioningEventListenerService implements ProvisioningEventListener {

	private RestTemplate		restTemplate;
	private HttpHeaders			httpHeaders;

	private static final String	UNIT_GET_UNIT		= "http://kjpt-zuul/system-proxy/unit-provider/unit/get-unit/";
	private static final String	UNIT_ADD_UNIT		= "http://kjpt-zuul/system-proxy/unit-provider/unit/add-unit";
	private static final String	UNIT_UPDATE_UNIT	= "http://kjpt-zuul/system-proxy/unit-provider/unit/upd-unit";
	//private static final String	GET_UNIT_CODE		= "http://kjpt-zuul/system-proxy/unit-provider/unit/unit-code";
	private static final String	GET_USER_INFO		= "http://kjpt-zuul/system-proxy/user-provider/user/get-user-byname/";
	private static final String	USER_ADD_URL		= "http://kjpt-zuul/system-proxy/user-provider/user/add-user";
	private static final String	USER_UPDATE_URL		= "http://kjpt-zuul/system-proxy/user-provider/user/update-user";

	private static final String	UNIT_CODE_GET_UNIT		= "http://kjpt-zuul/system-proxy/unit-provider/unit/get-unit-bycode/";
	
	private static final String	ADD_POST_FUNCTION	= "http://kjpt-zuul/system-proxy/post-provider/post/unified-identity/add-post-function";
	
	//测试用日志记录
	private static final String LOGTEST = "http://kjpt-zuul/system-proxy/sys-provider/currencylog/process-logs-save";

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
		Long uid = System.currentTimeMillis();
		try
		{
			
			System.out.println("统一身份认证消息接口");
			System.out.println("统一身份认证消息接口=========="+httpHeaders);
			if (httpHeaders==null) {
				httpHeaders = SpringContextUtil.getApplicationContext().getBean(HttpHeaders.class);
			}
			// HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
			// 初始化时没有token
			httpHeaders.set("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJpbnN0aXR1dGVOYW1lcyI6WyLli5jmjqLpmaIiLCLnianmjqLpmaIiLCLlt6XnqIvpmaIiLCLnn7Pnp5HpmaIiLCLlpKfov57pmaIiLCLljJfljJbpmaIiLCLkuIrmtbfpmaIiLCLlronlt6XpmaIiXSwidW5pdE5hbWUiOiLkuK3lm73nn7PmsrnljJblt6Xpm4blm6Is5YuY5o6i5byA5Y-R56CU56m26ZmiLOenkeaKgOmDqOe7vOWQiOiuoeWIkuWkhCIsInVuaXRDb2RlIjoiMDAwMDAsMTAwNDAxMDAxLDMwMTMwMDU0IiwidW5pdElkIjoiNDZiN2U0NTc1NmVmNGRiODhiNmFjYjcxMWY5MTZlNDMsNDVkYjJkZDNlMTQyNDk1YzkxYmM5NGYyMGVmNDk5ZTgsYTgyMjNjY2EyYjkwNDczOWJmMjhhN2Y0MGQ3MzJjNzMiLCJ1c2VyRGlzcCI6IuiSi-a2myIsInVzZXJOYW1lIjoiYWFhYWEiLCJyb2xlTGlzdCI6W10sImV4cCI6MTU2MjYzOTMwOSwidXNlcklkIjoiMTY1NTUzNDM2ZWRfZGZkNWUxMzciLCJlbWFpbCI6IjEyMzQ1NjY2NjZAeHh4LmNvbSIsImluc3RpdHV0ZUNvZGVzIjpbIjExMjAsMTEyMywxMTI0LDExMjciLCIxMTMwIiwiNDM2MCIsIjEwMjAiLCIxMDYwLDEwNjEiLCIxMDQwLDEwNDEiLCIxMDgwIiwiMTEwMCwxMTAxIl19.2crRnr6GlN1BjFnVKW76Kd5BDyF1zg7MZ1rZzNZG_Oa3BFtny3X9bSTRGr9zcxHpPMsBTnoTx_rNYVT39EVmog");
	
			if (restTemplate==null) {
				restTemplate = SpringContextUtil.getApplicationContext().getBean(RestTemplate.class);
			}
			addSysCurrencyLog("统一身份认证消息接口",uid);
			List<ProvisioningEvent> list = events.getEvent();
			addSysCurrencyLog("统一身份认证消息接口",uid,list);
			String vlaue;
			for (int i = 0; i<list.size(); i++) {
				ProvisioningEvent event = list.get(i);
				SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
				System.out.println("监听到事件内容如下:");
				System.out.println("事件流水号:"+event.getEventId());
				if (event.getOccuredTimestamp()==null) {
					System.out.println("事件发生时间:null");
				} else {
					System.out.println("事件发生时间:"+time.format(event.getOccuredTimestamp().getTime()));
				}
				System.out.println("事件类型:"+event.getEventType());
				
				addSysCurrencyLog("统一身份认证消息接口 ",uid,event);
				/**
				 * 组织机构创建
				 */
				if (EventType.ORGUNIT_CREATED.equals(event.getEventType())) {
					TargetEntity originalEntity = event.getTargetEntity();// getOriginalEntity();
					addSysCurrencyLog("统一身份认证消息接口 ",uid,"创建组织机构",originalEntity);
					
					if (originalEntity!=null) {
						SysUnit sysUnit = new SysUnit();
						TargetSubject originalSubject = originalEntity.getSubject();
						System.out.println("组织机构主题:"+originalSubject);
						@SuppressWarnings("unchecked")
						List<Attribute> originalAttributes = originalEntity.getAttributes();
						System.out.println("组织机构属性集合:");
						System.out.println("originalEntity============="+JSONObject.toJSONString(originalEntity));
						
						addSysCurrencyLog("统一身份认证消息接口 ",uid,"创建组织机构",originalAttributes);
						for (Attribute attribute : originalAttributes) {
							String keyName = attribute.getName();
							List<?> valueList = attribute.getValues();
							//System.out.println("attribute============="+JSONObject.toJSONString(attribute));
							//addLog("统一身份认证消息接口 attribute ",attribute);
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
						
						addSysCurrencyLog("统一身份认证消息接口 ",uid,"创建组织机构",sysUnit);
						this.restTemplate.exchange(UNIT_ADD_UNIT, HttpMethod.POST, entit, Object.class);
					}
				}
				/**
				 * 组织机构修改
				 */
				System.out.println(EventType.ORGUNIT_MODIFIED+"====="+event.getEventType());
				if (EventType.ORGUNIT_MODIFIED.equals(event.getEventType())) {
					TargetEntity originalEntity = event.getTargetEntity();
					addSysCurrencyLog("统一身份认证消息接口 ",uid,"修改组织机构",originalEntity);
					if (originalEntity!=null) {
						TargetSubject originalSubject = originalEntity.getSubject();
						System.out.println("组织机构主题:"+originalSubject);
						SysUnit sysUnit = this.restTemplate.exchange(UNIT_GET_UNIT+originalSubject.getSubject(), HttpMethod.POST, new HttpEntity<Object>(httpHeaders), SysUnit.class).getBody();
						@SuppressWarnings("unchecked")
						List<Attribute> originalAttributes = originalEntity.getAttributes();
						System.out.println("组织机构属性集合:");
						
						addSysCurrencyLog("统一身份认证消息接口 ",uid,"修改组织机构",originalAttributes);
						for (Attribute attribute : originalAttributes) {
							System.out.println(attribute);
							String keyName = attribute.getName();
							List<?> valueList = attribute.getValues();
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
						
						addSysCurrencyLog("统一身份认证消息接口 ",uid,"修改组织机构",sysUnit);
						this.restTemplate.exchange(UNIT_UPDATE_UNIT, HttpMethod.POST, entit, Object.class);
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
						addSysCurrencyLog("统一身份认证消息接口 ",uid,"删除组织机构",originalSubject);
						
						SysUnit sysUnit = this.restTemplate.exchange(UNIT_GET_UNIT+originalSubject.getSubject(), HttpMethod.POST, new HttpEntity<Object>(httpHeaders), SysUnit.class).getBody();
						sysUnit.setUnitDelflag(1);
						HttpEntity<Object> entit = new HttpEntity<Object>(sysUnit, httpHeaders);
						this.restTemplate.exchange(UNIT_UPDATE_UNIT, HttpMethod.POST, entit, Object.class);
					}
				}
				/**
				 * 应用账号创建
				 */
				if (EventType.ACCOUNT_CREATED.equals(event.getEventType())) {
					TargetEntity targetEntity = event.getTargetEntity();
					addSysCurrencyLog("统一身份认证消息接口 ",uid,"应用账号创建",targetEntity);
					if (targetEntity!=null) {
						TargetSubject targetSubject = targetEntity.getSubject();
						System.out.println("应用账号主题:"+targetSubject);
						System.out.println("应用账号属性集合:");
						
						@SuppressWarnings("unchecked")
						List<Attribute> attributes = targetEntity.getAttributes();
						System.out.println("targetEntity============="+JSONObject.toJSONString(targetEntity));
						addSysCurrencyLog("统一身份认证消息接口 ",uid,"应用账号创建",attributes);
						
						SysUser sysUser = new SysUser();
						for (Attribute attribute : attributes) {
							String keyName = attribute.getName();
							List<?> valueList = attribute.getValues();
							System.out.println("attribute============="+JSONObject.toJSONString(attribute));
							//addLog("统一身份认证消息接口 创建账号attribute ",attribute);
							if (valueList!=null&&valueList.size()>0) {
								vlaue = attribute.getValues().get(0).toString();
							} else {
								vlaue = "";
							}
							if ("cn".equals(keyName.toLowerCase())) {
								sysUser.setUserDisp(vlaue);// 用户姓名
							}
							if ("uid".equals(keyName.toLowerCase())) {
								sysUser.setUserExtend(vlaue);// 统一身份账号，暂存
							}
							if ("employeenumber".equals(keyName.toLowerCase())) {
								sysUser.setUserComment(vlaue);// 员工编码
							}
							if ("employeetype".equals(keyName.toLowerCase())) {
								sysUser.setUserKind(vlaue);// 用户类型
							}
							if ("departmentnumber".equals(keyName.toLowerCase())) {
								// sysUser.setUserUnit(vlaue);// 用户所属机构
								// 初始给他默认的机构和岗位
								// sysUser.setUserUnit(vlaue);
							}
							if ("mail".equals(keyName.toLowerCase())) {
								sysUser.setUserMail(vlaue);// 用户邮箱
							}
							if ("mobile".equals(keyName.toLowerCase())) {
								sysUser.setUserMobile(vlaue);// 用户手机号
							}
							if ("telephonenumber".equals(keyName.toLowerCase())) {
								sysUser.setUserPhone(vlaue);// 用户座机号
							}
							if ("sptitlelevel".equals(keyName.toLowerCase())) {
								sysUser.setUserLevel(0);// 用户姓名-类型不同存储固定值
							}
	
							if ("sporgcodepath".equals(keyName.toLowerCase())) {
								sysUser.setUserRelation(vlaue);// 临时存组织机构路径
							}
							if ("sporgnamepath".equals(keyName.toLowerCase())) {
								// 科技部及八大院的特殊处理
								System.out.println("sporgnamepath==========="+vlaue);
								if (vlaue.contains("化工处")) {
									sysUser.setUserUnit("30130057");
								}
								if (vlaue.contains("装备与储运处")) {
									sysUser.setUserUnit("30130059");
								}
								if (vlaue.contains("三剂处")) {
									sysUser.setUserUnit("30130062");
								}
								if (vlaue.contains("知识产权处")) {
									sysUser.setUserUnit("30130061");
								}
								if (vlaue.contains("油田处")) {
									sysUser.setUserUnit("30130055");
								}
								if (vlaue.contains("计划处")) {
									sysUser.setUserUnit("30130054");
								}
								if (vlaue.contains("炼油处")) {
									sysUser.setUserUnit("30130056");
								}
								if (vlaue.contains("科技部办公室")) {
									sysUser.setUserUnit("30130053");
								}
								if (vlaue.contains("材料处")) {
									sysUser.setUserUnit("30130058");
								}
								if (vlaue.contains("科技部国际合作处")) {
									sysUser.setUserUnit("30130060");
								}
								if (vlaue.contains("技术监督处")) {
									sysUser.setUserUnit("30130063");
								}
								if (vlaue.contains("油田企业经营管理部")) {
									sysUser.setUserUnit("118801");
								}
								if (vlaue.contains("北京化工研究院")) {
									sysUser.setUserUnit("109011");
								}
								if (vlaue.contains("石油勘探开发研究院")) {
									sysUser.setUserUnit("108811");
								}
								if (vlaue.contains("上海石油化工研究院")) {
									sysUser.setUserUnit("109211");
								}
								if (vlaue.contains("石油化工科学研究院")) {
									sysUser.setUserUnit("108911");
								}
								if (vlaue.contains("大连石油化工研究院")) {
									sysUser.setUserUnit("109112");
								}
								if (vlaue.contains("抚顺石油化工研究院")) {
									sysUser.setUserUnit("109111");
								}
								if (vlaue.contains("青岛安全工程研究院")) {
									sysUser.setUserUnit("109311");
								}
								if (vlaue.contains("石油物探技术研究院")) {
									sysUser.setUserUnit("126211");
								}
								
								if (vlaue.contains("盈科")) {
									sysUser.setUserUnit("109511002");
								}
							}
	
						}
						
						sysUser.setUserName(targetSubject.getSubject());// 应用账号
						sysUser.setUserPassword("96e79218965eb72c92a549dd5a330112");
						if (sysUser.getUserKind()==null || sysUser.getUserKind().equals("")) {
							sysUser.setUserKind("ROOT_XTGL_YHLX_ZZNYH");// 用户类型
						}
	
						if (sysUser.getUserUnit()==null || sysUser.getUserUnit().equals("")) {
							if (sysUser.getUserRelation() != null && sysUser.getUserRelation().contains("30130006")) {
								sysUser.setUserUnit("30130006");
							} else {
								// 盈科
								sysUser.setUserUnit("109511002");
							}
							
						}
						sysUser.setUserFlag("1");// 暂时写常量（也可在消息队列中查询）
						sysUser.setUserOrder(1);
						sysUser.setUserSign("用户签章");
						sysUser.setIsDomain(0);
						// 盈科下的普通岗位
						sysUser.setUserPost("7be1f23905c1446881b757b550fc7a71");
						sysUser.setUserRole(null);
						sysUser.setUserDelflag(0);
						sysUser.setLoginErrorNumber(3);
						sysUser.setUserConfig2("职员");
						sysUser.setLoginCheckCode(UUID.randomUUID().toString().substring(0, 4));
						sysUser.setUserCreateTime(DateUtil.dateToStr(new Date(), DateUtil.FMT_SS));
						// 获取用户所在机构部门
						System.out.println(targetSubject.getSubject()+"---targetSubject.getSubject()======");
						System.out.println(sysUser.getUserUnit()+"---getUserUnit======");
						SysUnit unit = this.restTemplate.exchange(UNIT_CODE_GET_UNIT+sysUser.getUserUnit(), HttpMethod.POST, new HttpEntity<Object>(httpHeaders), SysUnit.class).getBody();
						String unitId = "";
						String unitCode = "";
						if (unit==null) {
							unitId = "fc1c18a6b5ac461a82c0ecaf09722e17";
							unitCode = "30130006";
						} else {
							unitId = unit.getUnitId();
							unitCode = unit.getUnitCode();
						}
						JSONObject json = new JSONObject();
						json.put("unitId", unitId);
						json.put("unitCode", unitCode);
						json.put("postId", UUID.randomUUID().toString().replaceAll("-", ""));
						json.put("postName", "部门通用岗位");
						
						// 判断默认的部门通用岗位是否存在，不存在，在本组织机构节点中保存，并给此岗位配置基本功能
						// 存在此岗位的话，不用再配置基本菜单功能，一般第一次都需要配置岗位菜单
						
						String realPostId = this.restTemplate.exchange(ADD_POST_FUNCTION, HttpMethod.POST, new HttpEntity<String>(json.toString(), this.httpHeaders), String.class).getBody();
						
						
						sysUser.setUserUnit(unitId); //用户的组织机构信息，保存用户时会直接保存关系表
						sysUser.setUserPost(realPostId); //用户的岗位信息，保存用户时会直接保存关系表
						String userID = UUID.randomUUID().toString().replaceAll("-", "");
						sysUser.setUserId(userID);
						
						System.out.println("用户保存前信息==========="+JSONObject.toJSONString(sysUser));
						// 插入用户数据
						
						addSysCurrencyLog("统一身份认证消息接口 ",uid,"应用账号创建",sysUser);
						this.restTemplate.exchange(USER_ADD_URL, HttpMethod.POST, new HttpEntity<SysUser>(sysUser, httpHeaders), Integer.class);
						
					}
				}
				/**
				 * 应用账号禁用
				 */
				if (EventType.ACCOUNT_DISABLED.equals(event.getEventType())) {
					String username = "";
					TargetEntity targetEntity = event.getTargetEntity();
					addSysCurrencyLog("统一身份认证消息接口 ",uid,"应用账号禁用",targetEntity);
					if (targetEntity!=null) {
						TargetSubject targetSubject = targetEntity.getSubject();
						System.out.println("应用账号主题:"+targetSubject);
						System.out.println("应用账号属性集合:");
						addSysCurrencyLog("统一身份认证消息接口 ",uid,"应用账号禁用",targetSubject);
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
						ResponseEntity<SysUser> rsEntity = this.restTemplate.exchange(GET_USER_INFO+username, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), SysUser.class);
						SysUser rsUser = rsEntity.getBody();
						if (rsUser != null) {
							rsUser.setUserDelflag(1);
							// 禁用用户数据（userdelfag改成1）
							this.restTemplate.exchange(USER_UPDATE_URL, HttpMethod.POST, new HttpEntity<SysUser>(rsUser, httpHeaders), Integer.class);
						}
						
					}
				}
				/**
				 * 应用账号启用
				 */
				if (EventType.ACCOUNT_ENABLED.equals(event.getEventType())) {
					String username = "";
					TargetEntity targetEntity = event.getTargetEntity();
					addSysCurrencyLog("统一身份认证消息接口 ",uid,"应用账号启用",targetEntity);
					if (targetEntity!=null) {
						TargetSubject targetSubject = targetEntity.getSubject();
						System.out.println("应用账号主题:"+targetSubject);
						System.out.println("应用账号属性集合:");
						
						addSysCurrencyLog("统一身份认证消息接口 ",uid,"应用账号启用",targetSubject);
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
						ResponseEntity<SysUser> rsEntity = this.restTemplate.exchange(GET_USER_INFO+username, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), SysUser.class);
						SysUser rsUser = rsEntity.getBody();
						
						if (rsUser != null) {
							rsUser.setUserDelflag(0);
							// 启用用户数据（userdelfag改成0）
							this.restTemplate.exchange(USER_UPDATE_URL, HttpMethod.POST, new HttpEntity<SysUser>(rsUser, httpHeaders), Integer.class);
						}
						
					}
				}
				/**
				 * 应用账号删除
				 */
				if (EventType.ACCOUNT_DELETED.equals(event.getEventType())) {
					String username = "";
					TargetEntity targetEntity = event.getTargetEntity();
					addSysCurrencyLog("统一身份认证消息接口 ",uid,"应用账号删除",targetEntity);
					if (targetEntity!=null) {
						TargetSubject targetSubject = targetEntity.getSubject();
						System.out.println("应用账号主题:"+targetSubject);
						System.out.println("应用账号属性集合:");
						
						addSysCurrencyLog("统一身份认证消息接口 ",uid,"应用账号删除",targetSubject);
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
						ResponseEntity<SysUser> rsEntity = this.restTemplate.exchange(GET_USER_INFO+username, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), SysUser.class);
						SysUser rsUser = rsEntity.getBody();
						if (rsUser != null) {
							rsUser.setUserDelflag(1);
							// 禁用用户数据（userdelfag改成1）
							this.restTemplate.exchange(USER_UPDATE_URL, HttpMethod.POST, new HttpEntity<SysUser>(rsUser, httpHeaders), Integer.class);
						}
						
					}
				}
			}
			
		}catch(Exception e) {
			addSysCurrencyLog("统一身份认证消息接口 ",uid,"操作异常");
		}
	}
	
	private void addSysCurrencyLog(String logName,Object ... datas) 
	{
		try 
		{
			Map<String,Object> map = new HashMap<String,Object>();
			if(datas != null && datas.length>0) {
				for(int i= 0;i<datas.length;i++) 
				{
					map.put("dataT"+(i+1), JSON.toJSONString(datas[i]));
				}
			}
			map.put("dataId", IdUtil.createIdByTime());
			map.put("logName", logName);
			map.put("logTime", DateUtil.dateToStr(new Date(),DateUtil.FMT_SS));
			SysCurrencyLog log = new SysCurrencyLog();
			MyBeanUtils.transMap2Bean(map, log);
			
			this.restTemplate.exchange(LOGTEST, HttpMethod.POST, new HttpEntity<SysCurrencyLog>(log, this.httpHeaders), Result.class).getBody();
		}
		catch(Exception e) 
		{
			System.out.println("add log error..............");
		}
	}
}