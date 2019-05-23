package com.pcitc.web.common;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.RequestFacade;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSONArray;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysFunctionProperty;
import com.pcitc.base.system.SysLog;
import com.pcitc.base.system.SysUser;

/**
 * @author zhanghaifeng
 * @Date: 2017/10/15
 * @annotation SysLogAspect 操作日志和数据查询控制
 * 
 */
@Aspect
@Component
public class SysAspect extends BaseController {

	private static final String LOG_ADD_URL = "http://pcitc-zuul/system-proxy/log-provider/log/add";

	private static final String USER_DATA_FILTER_URL = "http://pcitc-zuul/system-proxy/userProperty-provider/data-filter/";
	
	private static final String FUNCTION_FILTER_URL = "http://pcitc-zuul/system-proxy/userProperty-provider/function/data-filter";

	/**
	 * 定义Pointcut，Pointcut的名称，此方法不能有返回值，该方法只是一个标示
	 */
	@Pointcut("@annotation(com.pcitc.web.common.OperationFilter)")
	public void controllerAspect() {
	}

	/**
	 * 前置通知（Before advice） ：在某连接点（JoinPoint）之前执行的通知，但这个通知不能阻止连接点前的执行。
	 * 
	 * @param joinPoint
	 */
	@Before("controllerAspect()")
	public void doBefore(JoinPoint joinPoint) {

	}

	/**
	 * 后通知（After advice） ：当某连接点退出的时候执行的通知（不论是正常返回还是异常退出）。
	 * 
	 * @param joinPoint
	 */
	@AfterReturning(pointcut = "controllerAspect()")
	public void doAfter(JoinPoint joinPoint) {
		handleLog(joinPoint, null);
	}

	/**
	 * 抛出异常后通知（After throwing advice） ： 在方法抛出异常退出时执行的通知。
	 * 
	 * @param joinPoint
	 * @param e
	 */
	@AfterThrowing(value = "controllerAspect()", throwing = "e")
	public void doAfter(JoinPoint joinPoint, Exception e) {
		// handleLog(joinPoint, e);
	}

	/**
	 * 环绕通知（Around advice）
	 * ：包围一个连接点的通知，类似Web中Servlet规范中的Filter的doFilter方法。可以在方法的调用前后完成自定义的行为
	 * ，也可以选择不执行。
	 * 
	 * @param joinPoint
	 */
	@Around("controllerAspect()")
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
		// 获得注解
		OperationFilter operData = giveController(joinPoint);
		if (operData == null) {
			return null;
		}

		Object[] args = joinPoint.getArgs();
		if (operData.dataFlag() != null && !operData.dataFlag().equals("")) {
			// 第一个参数为LayuiTableParam类型
			if (args != null && args.length > 0 && args[0].getClass() == LayuiTableParam.class) {

				LayuiTableParam inPro = (LayuiTableParam) args[0];
				List<String> list = httpHeaders.get("Authorization");
				
				/*if (inPro.getParam().get("functionCode") != null && !inPro.getParam().get("functionCode").toString().equals("")) {
					// 既然已经点击这个菜单，说明此人有此功能的权限。直接查询这个菜单有哪些属性的权限控制，此人的属性权限控制又有哪些内容
					// httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
					MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
					Map<String, Object> paramMap = new HashMap<String, Object>();

					paramMap.put("functionCode", inPro.getParam().get("functionCode"));

					if (list != null && list.get(0) != null) {
						SysUser userInfo = JwtTokenUtil.getUserFromTokenByValue(list.get(0).split(" ")[1]);
						paramMap.put("userId", userInfo.getUserId());
						requestBody.add("jsonStr", JsonUtil.parseMapToJson(paramMap));
						HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);
						// 59d9113d-745d-4c46-bc84-c18f132ac2c1 暂时写死
						ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(USER_DATA_FILTER_URL + userInfo.getUserId() + "/" + inPro.getParam().get("functionCode"), HttpMethod.POST, entity, JSONArray.class);
						JSONArray retJson = responseEntity.getBody();
						if (retJson != null) {
							List<SysUserProperty> supList = JSONArray.parseArray(retJson.toString(), SysUserProperty.class);

							System.out.println("此人此功能配置的控制数据 : " + inPro.getParam().get("functionCode"));
							for (SysUserProperty supVO : supList) {
								if (inPro != null && inPro.getParam().get(supVO.getDataType()) == null) {
									System.out.println(supVO.getDataType() + "========自动加入的控制数据key-value================" + supVO.getDataId());
									inPro.getParam().put(supVO.getDataType(), supVO.getDataId());
								}
							}
							args[0] = inPro;
						}
					}
				}*/
				
				if (inPro.getParam().get("functionId") != null && !inPro.getParam().get("functionId").toString().equals("")) {
					// 既然已经点击这个菜单，说明此人有此功能的权限。直接查询这个菜单有哪些属性的权限控制，此人的属性权限控制又有哪些内容
					//MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
					HashMap<String, Object> paramMap = new HashMap<String, Object>();
					paramMap.put("functionId", inPro.getParam().get("functionId"));

					if (list != null && list.get(0) != null) {
						SysUser userInfo = JwtTokenUtil.getUserFromTokenByValue(list.get(0).split(" ")[1]);
						String[] postArr = userInfo.getUserPost().split(",");
						paramMap.put("postIds", Arrays.asList(postArr));
						//HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);
						HttpEntity<HashMap<String, Object>> entity = new HttpEntity<HashMap<String, Object>>(paramMap, this.httpHeaders);

						ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(FUNCTION_FILTER_URL , HttpMethod.POST, entity, JSONArray.class);
						JSONArray retJson = responseEntity.getBody();
						if (retJson != null) {
							List<SysFunctionProperty> sfpList = JSONArray.parseArray(retJson.toString(), SysFunctionProperty.class);

							for (SysFunctionProperty sfpVO : sfpList) {
								if (inPro != null && inPro.getParam().get(sfpVO.getProCode()) == null) {
									System.out.println(sfpVO.getProCode() + "========自动加入的控制数据key-value================" + sfpVO.getPostConfigValue());
									inPro.getParam().put(sfpVO.getProCode(), sfpVO.getPostConfigValue());
								}
							}
							args[0] = inPro;
						}
					}
				}
				
			}
			
			System.out.println(args+"1========自动加入的控制数据key-value================"+args[0].getClass());
			// 第一个参数为HttpServletRequest类型
			if (args != null && args.length > 0 && args[0].getClass() == RequestFacade.class) {
				System.out.println("2========自动加入的控制数据key-value================");
				HttpServletRequest inPro = (HttpServletRequest) args[0];
				List<String> list = httpHeaders.get("Authorization");
				System.out.println("3========自动加入的控制数据key-value================");
				if (inPro.getParameter("functionId") != null && !inPro.getParameter("functionId").equals("")) {
					// 既然已经点击这个菜单，说明此人有此功能的权限。直接查询这个菜单有哪些属性的权限控制，此人的属性权限控制又有哪些内容
					HashMap<String, Object> paramMap = new HashMap<String, Object>();
					paramMap.put("functionId", inPro.getParameter("functionId"));
					System.out.println("4========自动加入的控制数据key-value================");
					if (list != null && list.get(0) != null) {
						SysUser userInfo = JwtTokenUtil.getUserFromTokenByValue(list.get(0).split(" ")[1]);
						String[] postArr = userInfo.getUserPost().split(",");
						paramMap.put("postIds", Arrays.asList(postArr));
						HttpEntity<HashMap<String, Object>> entity = new HttpEntity<HashMap<String, Object>>(paramMap, this.httpHeaders);
						System.out.println("5========自动加入的控制数据key-value================");
						ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(FUNCTION_FILTER_URL , HttpMethod.POST, entity, JSONArray.class);
						JSONArray retJson = responseEntity.getBody();
						if (retJson != null) {
							List<SysFunctionProperty> sfpList = JSONArray.parseArray(retJson.toString(), SysFunctionProperty.class);
							System.out.println("6========自动加入的控制数据key-value================");
							for (SysFunctionProperty sfpVO : sfpList) {
								if (inPro != null && inPro.getParameter(sfpVO.getProCode()) == null) {
									System.out.println(sfpVO.getProCode() + "7========自动加入的控制数据key-value================" + sfpVO.getPostConfigValue());
									inPro.setAttribute(sfpVO.getProCode(), sfpVO.getPostConfigValue());
								}
							}
							System.out.println("8========自动加入的控制数据key-value================"+inPro.getParameter("zycmc"));
							args[0] = inPro;
						}
					}
				}
				
			}
		
		}

		Object obj = joinPoint.proceed(args);
		return obj;
	}

	/**
	 * 日志处理
	 * 
	 * @param joinPoint
	 * @param e
	 */
	private void handleLog(JoinPoint joinPoint, Exception e) {
		try {
			// 获得注解
			OperationFilter logger = giveController(joinPoint);
			if (logger == null) {
				return;
			}

			// 有日志记录的才进行日志保存（一般是增删改）
			if (logger.actionName() != null && !logger.actionName().equals("")) {
				HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
				SysLog sysLog = new SysLog();
				sysLog.setLogId(UUID.randomUUID().toString().replaceAll("-", ""));
				sysLog.setLogActionName(logger.actionName());
				sysLog.setLogAction(logger.modelName());
				sysLog.setLogIp(getRemoteHost(request));
				sysLog.setLogTime(new Date());
				sysLog.setLogStatus("1");
				sysLog.setAuditStatus("1");
				List<String> list = httpHeaders.get("Authorization");
				// 第一次登录时，没有header
				if (list != null && list.get(0) != null) {
					SysUser userInfo = JwtTokenUtil.getUserFromTokenByValue(list.get(0).split(" ")[1]);
					sysLog.setLogPerson(userInfo.getUserDisp());
					sysLog.setLogPersonId(userInfo.getUserId());
				} else {
					// 登录方法的特殊日志处理
					sysLog.setLogPerson(request.getParameter("username"));
					sysLog.setLogPersonId(request.getParameter("username"));
				}
				httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
				this.restTemplate.exchange(LOG_ADD_URL, HttpMethod.POST, new HttpEntity<SysLog>(sysLog, this.httpHeaders), Integer.class);
			}
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}

	/**
	 * 获得注解
	 * 
	 * @param joinPoint
	 * @return
	 * @throws Exception
	 */
	private static OperationFilter giveController(JoinPoint joinPoint) throws Exception {
		Signature signature = joinPoint.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		Method method = methodSignature.getMethod();

		if (method != null) {
			return method.getAnnotation(OperationFilter.class);
		}
		return null;
	}

	public String getRemoteHost(javax.servlet.http.HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
	}

}
