package com.pcitc.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.ChartBarLineResultData;
import com.pcitc.base.common.ChartBarLineSeries;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.hana.report.HanaConstant;
import com.pcitc.base.system.SysCollect;
import com.pcitc.base.system.SysFunction;
import com.pcitc.base.system.SysModule;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.system.SysUserShowConfig;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.MD5Util;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.common.OperationFilter;
import com.pcitc.web.utils.EquipmentUtils;
import com.pcitc.web.utils.HanaUtil;
import com.sinopec.siam.agent.common.SSOPrincipal;
import com.sinopec.siam.agent.sp.config.SysConfig;

/**
 * @author zhf 系统登录成功后的首页
 */
@Controller
public class AdminController extends BaseController {

	// 访问zuul中的登录方法
	private static final String LOGIN_URL = "http://pcitc-zuul/auth/login";
	private static final String GET_USER_INFO_IP = "http://pcitc-zuul/system-proxy/user-provider/user/get-user-byname/";
	private static final String USER_DETAILS_URL = "http://pcitc-zuul/system-proxy/user-provider/user/user-details/";
	private static final String GET_USER_INFO = "http://pcitc-zuul/system-proxy/user-provider/user/get-user-byname/";
	private static final String UPD_USER_INFO = "http://pcitc-zuul/system-proxy/user-provider/user/update-user";

	// 已办任务数
	private static final String DONE_TASK_COUNT = "http://pcitc-zuul/system-proxy/task-provider/done-task-count";
	// 待办任务数
	private static final String PENDING_TASK_COUNT = "http://pcitc-zuul/system-proxy/task-provider/pending-task-count";
	// 专利数量（研究院）
	private static final String PATENT_COUNT = "http://pcitc-zuul/system-proxy/out-patent-provider/patent-count";
	// 科技奖励数量（研究院）
	private static final String APPRAISAL_COUNT = "http://pcitc-zuul/system-proxy/out-provider/appraisal-count";
	// 科研项目数量、科研装备项目数量、新开项目金额、新开和结转的总金额（研究院）
	private static final String PROJECT_COUNT = "http://pcitc-zuul/system-proxy/out-provider/project-count";
	// 新开的国家项目、重点项目、重大项目、其他项目的统计
	private static final String NEW_PROJECT_COUNT = "http://pcitc-zuul/system-proxy/out-project-provider/type/new";
	// 新开的国家项目、重点项目、重大项目、其他项目和去年比
	private static final String NEW_PROJECT_RATE = "http://pcitc-zuul/system-proxy/out-project-provider/type/last-year/rate";
	// 年度科研项目总览
	private static final String PROJECT_TOTAL_YEAR = "http://pcitc-zuul/system-proxy/out-project-provider/type/unit/list";
		
	// 收藏菜单
	private static final String COLLECT_FUNCTION = "http://pcitc-zuul/system-proxy/syscollect-provider/sys_collect/add";

	// 系统统计功能模块列表
	private static final String MODULE_LIST = "http://pcitc-zuul/system-proxy/sysModule-provider/sysModule_list";
	
	// 系统统计功能模块列表
	private static final String USER_SHOW_LIST = "http://pcitc-zuul/system-proxy/sysconfig-provider/user/show/config/";
	/**
	 * 科技平台统一身份认证首页
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/stpHome")
	public String indexStp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//System.out.println("进入indexStp....");
		SSOPrincipal ssoPrincipal = ((SSOPrincipal) request.getSession().getAttribute(SSOPrincipal.NAME_OF_SESSION_ATTR));
		System.out.println("ssoPrincipal==========");
		System.out.println(JSON.toJSONString(ssoPrincipal));
		String uAccount = "";

		SysUser rsUser = new SysUser();
		if (ssoPrincipal != null) {
			System.out.println(SysConfig.sp_login_tsysaccount + "----LogonController2----访问login方法" + ssoPrincipal);
			// 没有此系统的权限
			if (ssoPrincipal.getAppAccount() == null || "".equals(ssoPrincipal.getAppAccount())) {
				System.out.println(ssoPrincipal.getUid() + "---------" + ssoPrincipal.getAppAccount());
				// 返回权限不足页面
				return "no_access";
			}
			// 查看此账号所拥有的应用系统权限
			List<String> spRoleList = ssoPrincipal.getValueAsList("spRoleList");
			// 应用系统权限为空
			if (spRoleList == null || spRoleList.size() == 0) {
				// 返回权限不足页面
				System.out.println("spRoleList=null---------return no_access ");
				return "no_access";
			} else {
				int tem = 0;
				for (int i = 0; i < spRoleList.size(); i++) {
					String spList = spRoleList.get(i);
					System.out.println("spRoleList 第 " + i + "个=====" + spList);
					boolean status = spList.contains(",");
					if (status == false) {
						// 只返回一个spRole
						String[] sRoleArray = spList.split("@");
						if (sRoleArray[1].equals(SysConfig.sp_login_tsysaccount)) {
							tem = 1;
							break;
						}
					} else {
						// 返回多个spRole
						String[] spRole = spList.split(",");
						// 循环spRole，并判断userid是否属于
						for (int j = 0; j < spRole.length; j++) {
							String sRole = spRole[j];
							String[] sRoleArray = sRole.split("@");
							if (sRoleArray[1].equals(SysConfig.sp_login_tsysaccount)) {
								tem = 1;
								break;
							}
						}
					}
				}
				System.out.println("校验tem值--------------" + tem);
				if (tem == 0) {
					// 返回权限不足页面
					System.out.println("tem = 0---------return no_access ");
					return "no_access";
				} else {
					System.out.println("获取uAccount----------");
					uAccount = ssoPrincipal.getAppAccount()[0];
					System.out.println("uAccount ==========" + uAccount);
					System.out.println("获取rsUser----------");
					System.out.println("0httpHeaders-----------"+httpHeaders);
					System.out.println("0httpHeaders-----------"+httpHeaders.size());
					ResponseEntity<SysUser> rsEntity = this.restTemplate.exchange(GET_USER_INFO_IP + uAccount, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), SysUser.class);
					rsUser = rsEntity.getBody();
					if (rsUser != null) {
						// 用户有哪些菜单权限
						SysUser userDetails = this.restTemplate.exchange(USER_DETAILS_URL + rsUser.getUserId(), HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SysUser.class).getBody();
						List<SysFunction> funList = userDetails.getFunList();
						List<SysFunction> upList = new ArrayList<SysFunction>();
						
						// 个人工作台菜单
						List<SysFunction> grgztList = new ArrayList<SysFunction>();
						
						if (funList != null) {
							for (SysFunction sysfun : funList) {
								if (sysfun.getParentId() != null && sysfun.getParentId().equals("10001") && !sysfun.getName().equals("个人工作台")) {
									upList.add(sysfun);
								}
								
								if (sysfun.getParentId() != null && sysfun.getParentId().equals("e5c1006277a845f0b8a9d3674b6fc7e1")) {
									grgztList.add(sysfun);
								}
							}
							System.out.println("查询菜单权限----------" + funList.size());
						} else {
							System.out.println("无菜单权限----------");
							return "no_access";
						}

						// 收藏的菜单
						List<SysCollect> scList = userDetails.getScList();
						request.setAttribute("scList", scList);
						request.setAttribute("funList", funList);
						request.setAttribute("grgztList", grgztList);
						request.setAttribute("upList", upList);
						request.setAttribute("userInfo", rsUser);
					} else {
						// 返回权限不足页面
						System.out.println("LogonController----缺少权限");
						return "no_access";
					}
				}
			}

		} else {
			// 登录异常
			System.out.println("LogonController----登录异常");
			return "no_access";
		}

		// 重新登录，覆盖原cookies。cookies中信息都是后续要用的
		httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
		requestBody.add("username", rsUser.getUserName());
		requestBody.add("password", rsUser.getUserPassword());
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);
		
		System.out.println("1httpHeaders-----------"+this.httpHeaders);
		System.out.println("2httpHeaders-----------"+this.httpHeaders.size());
		System.out.println("3httpHeaders-----------"+rsUser);
		System.out.println("4httpHeaders-----------"+rsUser.getUserName());
		System.out.println("5httpHeaders-----------"+rsUser.getUserPassword());
		ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LOGIN_URL, HttpMethod.POST, entity, JSONObject.class);
		JSONObject retJson = responseEntity.getBody();

		System.out.println("-----indexStp----------login token:" + retJson.get("token"));

		Cookie cookie = new Cookie("token", retJson.getString("token"));
		cookie.setMaxAge(24 * 60 * 60);// 设置有效期为1天
		cookie.setPath("/");
		response.addCookie(cookie);

		String cFlag = request.getParameter("cFlag");
		if (rsUser.getUserLevel() != null && rsUser.getUserLevel() == 1 && cFlag == null) {
			request.setAttribute("companyCode", HanaUtil.YJY_CODE_ALL);
			String month = HanaUtil.getCurrrentYearMoth();
			request.setAttribute("month", month);
			return "/oneLevelMain";
		} else {
			return "/index";
		}
	}
	
	/**
	 * 领导页面切换到工作页面的特殊转换，不考虑登录者身份直接切换到工作台
	 */
	@RequestMapping(value = "/work")
	public String indexStpWork(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//System.out.println("进入indexStp....");
		SSOPrincipal ssoPrincipal = ((SSOPrincipal) request.getSession().getAttribute(SSOPrincipal.NAME_OF_SESSION_ATTR));
		//System.out.println("ssoPrincipal==========" + ssoPrincipal);
		String uAccount = "";

		SysUser rsUser = new SysUser();
		if (ssoPrincipal != null) {
			System.out.println(SysConfig.sp_login_tsysaccount + "----LogonController2----访问login方法" + ssoPrincipal);
			// 没有此系统的权限
			if (ssoPrincipal.getAppAccount() == null || "".equals(ssoPrincipal.getAppAccount())) {
				System.out.println(ssoPrincipal.getUid() + "---------" + ssoPrincipal.getAppAccount());
				// 返回权限不足页面
				return "no_access";
			}
			// 查看此账号所拥有的应用系统权限
			List<String> spRoleList = ssoPrincipal.getValueAsList("spRoleList");
			// 应用系统权限为空
			if (spRoleList == null || spRoleList.size() == 0) {
				// 返回权限不足页面
				System.out.println("spRoleList=null---------return no_access ");
				return "no_access";
			} else {
				int tem = 0;
				for (int i = 0; i < spRoleList.size(); i++) {
					String spList = spRoleList.get(i);
					System.out.println("spRoleList 第 " + i + "个=====" + spList);
					boolean status = spList.contains(",");
					if (status == false) {
						// 只返回一个spRole
						String[] sRoleArray = spList.split("@");
						if (sRoleArray[1].equals(SysConfig.sp_login_tsysaccount)) {
							tem = 1;
							break;
						}
					} else {
						// 返回多个spRole
						String[] spRole = spList.split(",");
						// 循环spRole，并判断userid是否属于
						for (int j = 0; j < spRole.length; j++) {
							String sRole = spRole[j];
							String[] sRoleArray = sRole.split("@");
							if (sRoleArray[1].equals(SysConfig.sp_login_tsysaccount)) {
								tem = 1;
								break;
							}
						}
					}
				}
				System.out.println("校验tem值--------------" + tem);
				if (tem == 0) {
					// 返回权限不足页面
					System.out.println("tem = 0---------return no_access ");
					return "no_access";
				} else {
					System.out.println("获取uAccount----------");
					uAccount = ssoPrincipal.getAppAccount()[0];
					System.out.println("uAccount ==========" + uAccount);
					System.out.println("获取rsUser----------");
					ResponseEntity<SysUser> rsEntity = this.restTemplate.exchange(GET_USER_INFO_IP + uAccount, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), SysUser.class);
					rsUser = rsEntity.getBody();
					if (rsUser != null) {
						// 用户有哪些菜单权限
						SysUser userDetails = this.restTemplate.exchange(USER_DETAILS_URL + rsUser.getUserId(), HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SysUser.class).getBody();
						List<SysFunction> funList = userDetails.getFunList();
						List<SysFunction> upList = new ArrayList<SysFunction>();
						
						// 个人工作台菜单
						List<SysFunction> grgztList = new ArrayList<SysFunction>();
						
						if (funList != null) {
							for (SysFunction sysfun : funList) {
								if (sysfun.getParentId() != null && sysfun.getParentId().equals("10001") && !sysfun.getName().equals("个人工作台")) {
									upList.add(sysfun);
								}
								
								if (sysfun.getParentId() != null && sysfun.getParentId().equals("e5c1006277a845f0b8a9d3674b6fc7e1")) {
									grgztList.add(sysfun);
								}
							}
							System.out.println("查询菜单权限----------" + funList.size());
						} else {
							System.out.println("无菜单权限----------");
							return "no_access";
						}

						// 收藏的菜单
						List<SysCollect> scList = userDetails.getScList();
						request.setAttribute("scList", scList);
						request.setAttribute("funList", funList);
						request.setAttribute("grgztList", grgztList);
						request.setAttribute("upList", upList);
						request.setAttribute("userInfo", rsUser);
					} else {
						// 返回权限不足页面
						System.out.println("LogonController----缺少权限");
						return "no_access";
					}
				}
			}

		} else {
			// 登录异常
			System.out.println("LogonController----登录异常");
			return "no_access";
		}

		// 重新登录，覆盖原cookies。cookies中信息都是后续要用的
		httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
		requestBody.add("username", rsUser.getUserName());
		requestBody.add("password", rsUser.getUserPassword());
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);

		ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LOGIN_URL, HttpMethod.POST, entity, JSONObject.class);
		JSONObject retJson = responseEntity.getBody();

		System.out.println("-----indexStp----------login token:" + retJson.get("token"));

		Cookie cookie = new Cookie("token", retJson.getString("token"));
		cookie.setMaxAge(24 * 60 * 60);// 设置有效期为1天
		cookie.setPath("/");
		response.addCookie(cookie);

		return "/index";
	}

	@RequestMapping(value = "/login")
	public String pcitcToIndexPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("----------====进入login....");
		Cookie[] cookies = request.getCookies();
		if (cookies == null || cookies.length == 0) {
			System.out.println("not find cookies! ");

		} else {
			for (Cookie c : cookies) {
				if ("loginErrorCount".equalsIgnoreCase(c.getName()) && !StringUtils.isBlank(c.getValue())) {
					System.out.println("----------====进入login....loginErrorCount======");
					request.setAttribute("loginErrorCount", c.getValue());
					break;
				}
			}
		}
		return "/login";
	}

	@RequestMapping(value = "/index")
	public String toIndexPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String unitPathId=sysUserInfo.getUnitPath();
		boolean isKJBPerson=EquipmentUtils.isKJBPerson(unitPathId);
		request.setAttribute("isKJBPerson", isKJBPerson);
		
		
		
		SysUser userDetails = new SysUser(); // 用户信息，包含此人拥有的菜单权限等。token中放不下这些信息
		SysUser tokenUser = new SysUser();
		if (request.getParameter("username") != null && request.getParameter("password") != null) {
			// 模拟登录时的用户Id密码
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
			requestBody.add("username", username);
			requestBody.add("password", MD5Util.MD5Encode(password));

			HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);

			ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LOGIN_URL, HttpMethod.POST, entity, JSONObject.class);
			JSONObject retJson = responseEntity.getBody();

			httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
			if (retJson == null || retJson.get("token") == null) {
				// 获取的token有问题(用户名或密码不正确)
				Integer errorNumber = 0;
				ResponseEntity<SysUser> rsEntity = this.restTemplate.exchange(GET_USER_INFO + username, HttpMethod.GET, entity, SysUser.class);
				SysUser rsUser = rsEntity.getBody();
				if (rsUser != null) {
					errorNumber = rsUser.getLoginErrorNumber() == null ? 1 : rsUser.getLoginErrorNumber() + 1;
					rsUser.setLoginErrorNumber(errorNumber);
					this.restTemplate.exchange(UPD_USER_INFO, HttpMethod.POST, new HttpEntity<SysUser>(rsUser, this.httpHeaders), Integer.class);
				}

				// 登录错误次数
				Cookie loginCookie = new Cookie("loginErrorCount", String.valueOf(errorNumber));
				loginCookie.setMaxAge(24 * 60 * 60);// 设置有效期为1天
				loginCookie.setPath("/");
				response.addCookie(loginCookie);
				response.sendRedirect("/login");

				return null;
			}

			Cookie cookie = new Cookie("token", retJson.getString("token"));
			cookie.setMaxAge(24 * 60 * 60);// 设置有效期为1天
			cookie.setPath("/");
			response.addCookie(cookie);

			// 获取用户有哪些功能权限
			tokenUser = JwtTokenUtil.getUserFromTokenByValue(retJson.get("token").toString());
			userDetails = this.restTemplate.exchange(USER_DETAILS_URL + tokenUser.getUserId(), HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SysUser.class).getBody();
			List<SysFunction> funList = userDetails.getFunList();
			List<SysFunction> upList = new ArrayList<SysFunction>();
			// 个人工作台菜单
			List<SysFunction> grgztList = new ArrayList<SysFunction>();
			for (SysFunction sysfun : funList) {
				if (sysfun.getParentId() != null && sysfun.getParentId().equals("10001") && !sysfun.getName().equals("个人工作台")) {
					upList.add(sysfun);
				}
				
				if (sysfun.getParentId() != null && sysfun.getParentId().equals("e5c1006277a845f0b8a9d3674b6fc7e1")) {
					grgztList.add(sysfun);
				}
			}

			// 收藏的菜单
			List<SysCollect> scList = userDetails.getScList();

			// 重置登录次数
			if (userDetails.getLoginErrorNumber() != null && userDetails.getLoginErrorNumber() > 0) {
				userDetails.setLoginErrorNumber(0);
				this.restTemplate.exchange(UPD_USER_INFO, HttpMethod.POST, new HttpEntity<SysUser>(userDetails, this.httpHeaders), Integer.class);
			}

			request.setAttribute("scList", scList);
			request.setAttribute("funList", funList);
			request.setAttribute("grgztList", grgztList);
			request.setAttribute("upList", upList);
			request.setAttribute("userInfo", userDetails);

			Cookie loginCookie = new Cookie("loginErrorCount", null);
			loginCookie.setMaxAge(0);// 设置有效期为1天
			loginCookie.setPath("/");
			response.addCookie(loginCookie);
			System.out.println("----------====登录成功2index....");

			String cFlag = request.getParameter("cFlag");
			if (userDetails.getUserLevel() != null && userDetails.getUserLevel() == 1 && cFlag == null) {
				request.setAttribute("companyCode", HanaUtil.YJY_CODE_ALL);
				String month = HanaUtil.getCurrrentYearMoth();
				request.setAttribute("month", month);
				return "/oneLevelMain";//leaderIndex
			} else {
				return "/index";
			}
		} else {
			if (sysUserInfo == null || sysUserInfo.getUserId() == null) {
				System.out.println("未登录！");
				response.sendRedirect("/login");

				return null;
			}

			// 用户有哪些菜单权限
			userDetails = this.restTemplate.exchange(USER_DETAILS_URL + sysUserInfo.getUserId(), HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SysUser.class).getBody();
			List<SysFunction> funList = userDetails.getFunList();
			List<SysFunction> upList = new ArrayList<SysFunction>();
			// 个人工作台菜单
			List<SysFunction> grgztList = new ArrayList<SysFunction>();
			for (SysFunction sysfun : funList) {
				if (sysfun.getParentId() != null && sysfun.getParentId().equals("10001") && !sysfun.getName().equals("个人工作台")) {
					upList.add(sysfun);
				}
				
				if (sysfun.getParentId() != null && sysfun.getParentId().equals("e5c1006277a845f0b8a9d3674b6fc7e1")) {
					grgztList.add(sysfun);
				}
			}

			// 收藏的菜单
			List<SysCollect> scList = userDetails.getScList();

			// 重新登录，覆盖原cookies。cookies中信息都是后续要用的
			httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
			requestBody.add("username", userDetails.getUserName());
			requestBody.add("password", userDetails.getUserPassword());
			HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);

			ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LOGIN_URL, HttpMethod.POST, entity, JSONObject.class);
			JSONObject retJson = responseEntity.getBody();

			Cookie cookie = new Cookie("token", retJson.getString("token"));
			cookie.setMaxAge(24 * 60 * 60);// 设置有效期为1天
			cookie.setPath("/");
			response.addCookie(cookie);

			request.setAttribute("scList", scList);
			request.setAttribute("funList", funList);
			request.setAttribute("grgztList", grgztList);
			request.setAttribute("upList", upList);
			request.setAttribute("userInfo", userDetails);

			System.out.println("----------====登录成功1index....");
			Cookie loginCookie = new Cookie("loginErrorCount", null);
			loginCookie.setMaxAge(0);// 设置有效期为1天
			loginCookie.setPath("/");
			response.addCookie(loginCookie);

			String cFlag = request.getParameter("cFlag");
			
			if (userDetails.getUserLevel() != null && userDetails.getUserLevel() == 1 && cFlag == null) {
				request.setAttribute("companyCode", HanaUtil.YJY_CODE_ALL);
				String month = HanaUtil.getCurrrentYearMoth();
				request.setAttribute("month", month);
				return "/oneLevelMain";//leaderIndex
			} else {
				
				
				return "/index";
			}
		}
	}
	
	
	
	
	@RequestMapping(value = "/instituteIndex")
	public String instituteIndex(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String url=CommonUtil.getParameter(request, "url", "");
		request.setAttribute("url", url);
		
		url = java.net.URLDecoder.decode(request.getParameter("url"),"UTF-8");//名称检索条件
		
		
	    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
	    
	    SysUser  userDetails = this.restTemplate.exchange(USER_DETAILS_URL + sysUserInfo.getUserId(), HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SysUser.class).getBody();
	    
	    
		// 收藏的菜单
		List<SysCollect> scList = userInfo.getScList();
		List<SysFunction> funList = userDetails.getFunList();
		List<SysFunction> upList = new ArrayList<SysFunction>();
		// 个人工作台菜单
		List<SysFunction> grgztList = new ArrayList<SysFunction>();
		for (SysFunction sysfun : funList) {
			if (sysfun.getParentId() != null && sysfun.getParentId().equals("10001") && !sysfun.getName().equals("个人工作台")) {
				upList.add(sysfun);
			}
			
			if (sysfun.getParentId() != null && sysfun.getParentId().equals("e5c1006277a845f0b8a9d3674b6fc7e1")) {
				grgztList.add(sysfun);
			}
		}
		request.setAttribute("scList", scList);
		request.setAttribute("funList", funList);
		request.setAttribute("grgztList", grgztList);
		request.setAttribute("upList", upList);
		request.setAttribute("userInfo", userDetails);
		
		getContractParameter( request,  response);
		return "/instituteIndex";
	}

	
	public void getContractParameter(HttpServletRequest request, HttpServletResponse response)
	{
		String nd=CommonUtil.getParameter(request, "nd", "");//项目名
		String ysnd=CommonUtil.getParameter(request, "ysnd", "");//项目名
		String xmmc=CommonUtil.getParameter(request, "xmmc", "");//项目名
		String hth=CommonUtil.getParameter(request, "hth", "");//合同号
		String define1=CommonUtil.getParameter(request, "define1", "");//资本性、费用性
		String define2=CommonUtil.getParameter(request, "define2", "");//8大院等细分结构
		String define3=CommonUtil.getParameter(request, "define3", "");//直属研究院、分子公司、集团等9种类型
		String project_property=CommonUtil.getParameter(request, "project_property", "");//国家项目、重大专项、重点项目、其他项目
		String project_scope=CommonUtil.getParameter(request, "project_scope", "");//新开项目、续建项目、完工项目
		String zylb=CommonUtil.getParameter(request, "zylb", "");//装备的各种技术类型
		String zycmc=CommonUtil.getParameter(request, "zycmc", "");//各个处室
		
		
		request.setAttribute("nd", nd);
		request.setAttribute("ysnd", ysnd);
		
		
		request.setAttribute("zycmc", zycmc);
		request.setAttribute("xmmc", xmmc);
		request.setAttribute("hth", hth);
		request.setAttribute("define1", define1);
		request.setAttribute("define2", define2);
		request.setAttribute("define3", define3);
		request.setAttribute("project_property", project_property);
		request.setAttribute("project_scope", project_scope);
		request.setAttribute("zylb", zylb);
		
		String projectId=CommonUtil.getParameter(request, "projectId", "");
		request.setAttribute("projectId", projectId);
		
		
		
			
		
	}



    private static final String MY_BOT_WORK_ORDER_LIST = "http://pcitc-zuul/system-proxy/PlanClient-provider/my/botWorkOrder_list";
    private static final String BOT_WORK_ORDER_LIST = "http://pcitc-zuul/system-proxy/PlanClient-provider/botWorkOrder_list";

    private static final String selectSonPlanBasesByCreateUserId = "http://pcitc-zuul/system-proxy/PlanClient-provider/selectSonPlanBasesByCreateUserId";

    /**
	 * 首页的具体内容
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mainStp")
	public String toMainStp(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 获取通知
		request.setAttribute("taskCount", request.getParameter("taskCount"));

		HanaUtil.setSearchParaForUser(sysUserInfo, restTemplate, httpHeaders, request);

		String unitCode = sysUserInfo.getUnitCode();
		request.setAttribute("unitCode", unitCode);

		//获取任务
        LayuiTableParam param = new LayuiTableParam();
//        param.getParam().put("createUser", sysUserInfo.getUserId());
//        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
//        ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(BOT_WORK_ORDER_LIST, HttpMethod.POST, entity, LayuiTableData.class);
//        LayuiTableData result = responseEntity.getBody();
//        request.setAttribute("taskList",result.getData());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("createUserId", sysUserInfo.getUserId());
        HttpEntity<JSONObject> entity = new HttpEntity<JSONObject>(jsonObject, this.httpHeaders);
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(selectSonPlanBasesByCreateUserId, HttpMethod.POST, entity, JSONObject.class);
        JSONObject result = responseEntity.getBody();
        request.setAttribute("taskList",result.get("list"));

        param = new LayuiTableParam();
        Map<String, Object> map = param.getParam();
        map.put("workOrderAllotUserId", sysUserInfo.getUserId());
        map.put("workOrderStatus", "1");
        param.setParam(map);
        HttpEntity<LayuiTableParam> entityMy = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
        ResponseEntity<LayuiTableData> responseEntityMy = this.restTemplate.exchange(MY_BOT_WORK_ORDER_LIST, HttpMethod.POST, entityMy, LayuiTableData.class);
        LayuiTableData resultMy = responseEntityMy.getBody();
        request.setAttribute("taskListMy",resultMy.getData());
        
        SysUser  sysUser=   EquipmentUtils.getSysUserByUserId(sysUserInfo.getUserId(), restTemplate, httpHeaders);
        List scList= sysUser.getScList();
        request.setAttribute("scList",scList);
        String unitPathId=sysUserInfo.getUnitPath();
		boolean isKJBPerson=EquipmentUtils.isKJBPerson(unitPathId);
		request.setAttribute("isKJBPerson", isKJBPerson);
		
		
        return "/mainStp";
	}
	
	//获取O信息（待办）
	@RequestMapping(value = "/getOA")
	@ResponseBody
	public String getOA(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String url = CommonUtil.getParameter(request, "url", "");
		/*String str=Httpclient4Util.get(url);
		Result resultsDate = new Result();
		if(str!=null)
		{
			resultsDate.setSuccess(true);
			resultsDate.setData(str);
		}else
		{
			resultsDate.setSuccess(false);
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));*/
		return "0";
	}
	

	/**
	 * 首页的具体内容
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mainLeader")
	public String toMainLeader(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 获取通知
		request.setAttribute("taskCount", request.getParameter("taskCount"));

		HanaUtil.setSearchParaForUser(sysUserInfo, restTemplate, httpHeaders, request);

		String unitCode = sysUserInfo.getUnitCode();
		request.setAttribute("unitCode", unitCode);

		return "/mainLeader";
	}

	/**
	 * @author zhf
	 * @date 2018年9月1日 下午4:31:47 获取当前人最近一周已办事项
	 */
	@RequestMapping(value = "/admin/done-task-count", method = RequestMethod.POST)
	@ResponseBody
	public synchronized Object getDoneTaskCount(HttpServletRequest request) {
		System.out.println("1====/admin/done-task-count" + sysUserInfo.getUserId());
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("userId", sysUserInfo.getUserId());
		HttpEntity<HashMap<String, String>> entity = new HttpEntity<HashMap<String, String>>(map, this.httpHeaders);

		ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(DONE_TASK_COUNT, HttpMethod.POST, entity, JSONObject.class);
		JSONObject retJson = responseEntity.getBody();

		Long doneTaskCount = retJson.get("doneTaskCount") != null ? Long.parseLong(retJson.get("doneTaskCount").toString()) : 0l;

		JSONObject jsonObj = new JSONObject();
		jsonObj.put("doneTaskCount", doneTaskCount);

		return jsonObj.toString();
	}

	@RequestMapping(value = "/admin/pending-task-count", method = RequestMethod.POST)
	@ResponseBody
	public synchronized Object getPendingTaskCount(HttpServletRequest request) {
		System.out.println("1====/admin/pending-task-count" + sysUserInfo.getUserId());
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("userId", sysUserInfo.getUserId());
		HttpEntity<HashMap<String, String>> entity = new HttpEntity<HashMap<String, String>>(map, this.httpHeaders);

		ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(PENDING_TASK_COUNT, HttpMethod.POST, entity, JSONObject.class);
		JSONObject retJson = responseEntity.getBody();

		Long doneTaskCount = retJson.get("pendingTaskCount") != null ? Long.parseLong(retJson.get("pendingTaskCount").toString()) : 0l;

		JSONObject jsonObj = new JSONObject();
		jsonObj.put("pendingTaskCount", doneTaskCount);

		return jsonObj.toString();
	}

	@RequestMapping(value = "/logout")
	@ResponseBody
	@OperationFilter(modelName = "系统管理", actionName = "登出操作")
	public Object sysLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Cookie cookie = new Cookie("token", null);
		cookie.setMaxAge(0);// 立即失效
		cookie.setPath("/");
		response.addCookie(cookie);

		return new Result(true, "");
	}

	@RequestMapping(value = "/admin/collect")
	@ResponseBody
	@OperationFilter(modelName = "系统管理", actionName = "收藏操作")
	public Object saveCollectFunction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		SysCollect sysCollect = new SysCollect();
		sysCollect.setDataId(UUID.randomUUID().toString().replaceAll("-", ""));
		sysCollect.setCollectUrl(request.getParameter("functionCode"));
		sysCollect.setCollectName(request.getParameter("functionName"));
		sysCollect.setFunctionCode(request.getParameter("functionCode"));
		sysCollect.setFunctionId(request.getParameter("functionId"));

		sysCollect.setStatus("1");
		sysCollect.setIsDefault("0");
		sysCollect.setCreateDate(new Date());
		sysCollect.setUpdateDate(new Date());
		sysCollect.setCreatePersonId(sysUserInfo.getUserId());
		sysCollect.setUserId(sysUserInfo.getUserId());
		sysCollect.setUserName(sysUserInfo.getUserName());

		ResponseEntity<SysCollect> responseEntity = this.restTemplate.exchange(COLLECT_FUNCTION, HttpMethod.POST, new HttpEntity<SysCollect>(sysCollect, this.httpHeaders), SysCollect.class);
		SysCollect retJson = responseEntity.getBody();
		System.out.println("retJson.getStatus()=====" + retJson.getStatus());
		if (retJson != null && retJson.getStatus().equals("1")) {
			return new Result(true, JSONObject.toJSONString(retJson), "收藏成功!");
		} else if (retJson != null && retJson.getStatus().equals("0")) {
			return new Result(true, JSONObject.toJSONString(retJson), "取消收藏成功!");
		} else {
			return new Result(false, "操作失败!");
		}
	}

	@RequestMapping(value = "/common-login")
	@ResponseBody
	@OperationFilter(modelName = "系统管理", actionName = "登录操作")
	public Object pcitcIndex(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("common-login....");
		// 模拟登录时的用户Id密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
		requestBody.add("username", username);
		requestBody.add("password", MD5Util.MD5Encode(password));
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);

		ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LOGIN_URL, HttpMethod.POST, entity, JSONObject.class);
		JSONObject retJson = responseEntity.getBody();

		System.out.println("login token:" + retJson.get("token"));

		if (retJson == null || retJson.get("token") == null) {
			// 获取的token有问题(用户名或密码不正确)
			Integer errorNumber = 0;
			ResponseEntity<SysUser> rsEntity = this.restTemplate.exchange(GET_USER_INFO + username, HttpMethod.GET, entity, SysUser.class);
			SysUser rsUser = rsEntity.getBody();
			if (rsUser != null) {
				errorNumber = rsUser.getLoginErrorNumber() == null ? 1 : rsUser.getLoginErrorNumber() + 1;
				rsUser.setLoginErrorNumber(errorNumber);
				this.restTemplate.exchange(UPD_USER_INFO, HttpMethod.POST, new HttpEntity<SysUser>(rsUser, this.httpHeaders), Integer.class);
			}
			return new Result(false, errorNumber);
		} else {
			// 重置登录次数
			ResponseEntity<SysUser> rsEntity = this.restTemplate.exchange(GET_USER_INFO + username, HttpMethod.GET, entity, SysUser.class);
			SysUser rsUser = rsEntity.getBody();
			if (rsUser.getLoginErrorNumber() != null && rsUser.getLoginErrorNumber() > 0) {
				rsUser.setLoginErrorNumber(0);
				this.restTemplate.exchange(UPD_USER_INFO, HttpMethod.POST, new HttpEntity<SysUser>(rsUser, this.httpHeaders), Integer.class);
			}
		}

		Cookie cookie = new Cookie("token", retJson.getString("token"));
		cookie.setMaxAge(24 * 60 * 60);// 设置有效期为1天
		cookie.setPath("/");
		response.addCookie(cookie);
		return new Result(true, retJson.get("token"));
	}

	/**
	 * @param request
	 * @return 查询专利数量
	 */
	@RequestMapping(value = "/admin/patent-count", method = RequestMethod.POST)
	@ResponseBody
	public synchronized Object getPatentCount(HttpServletRequest request) {
		HashMap<String, String> map = new HashMap<String, String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        map.put("nd", sdf.format(date));
        
		System.out.println("1====/admin/patent-count" + String.valueOf(Integer.parseInt(sdf.format(date))-1));
		if (request.getParameter("lastYearFlag") != null && !request.getParameter("lastYearFlag").equals("")) {
			map.put("nd", String.valueOf(Integer.parseInt(sdf.format(date))-1));
		}
		if (request.getParameter("nd") != null && !request.getParameter("nd").equals("")) {
			map.put("nd", request.getParameter("nd"));
		}
		if (request.getParameter("define3") != null && !request.getParameter("define3").equals("")) {
			map.put("define3", request.getParameter("define3"));
		}
		HttpEntity<HashMap<String, String>> entity = new HttpEntity<HashMap<String, String>>(map, this.httpHeaders);

		ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(PATENT_COUNT, HttpMethod.POST, entity, JSONObject.class);
		JSONObject retJson = responseEntity.getBody();

		Long patentCount = retJson.get("patentCount") != null ? Long.parseLong(retJson.get("patentCount").toString()) : 0l;

		JSONObject jsonObj = new JSONObject();
		jsonObj.put("patentCount", patentCount);

		return jsonObj.toString();
	}

	/**
	 * @param request
	 * @return 查询科技成果
	 */
	@RequestMapping(value = "/admin/appraisal-count", method = RequestMethod.POST)
	@ResponseBody
	public synchronized Object getAppraisalCount(HttpServletRequest request) {
		HashMap<String, String> map = new HashMap<String, String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        
		System.out.println("1====getAppraisalCount" + request.getParameter("nd"));
		if (request.getParameter("lastYearFlag") != null && !request.getParameter("lastYearFlag").equals("")) {
			map.put("nd", String.valueOf(Integer.parseInt(sdf.format(date))-1));
		}
		if (request.getParameter("nd") != null && !request.getParameter("nd").equals("")) {
			map.put("nd", request.getParameter("nd"));
		}
		if (request.getParameter("define3") != null && !request.getParameter("define3").equals("")) {
			map.put("define3", request.getParameter("define3"));
		}
		if (request.getParameter("define1") != null && !request.getParameter("define1").equals("")) {
			map.put("define1", request.getParameter("define1"));
		}
		
		HttpEntity<HashMap<String, String>> entity = new HttpEntity<HashMap<String, String>>(map, this.httpHeaders);

		ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(APPRAISAL_COUNT, HttpMethod.POST, entity, JSONObject.class);
		JSONObject retJson = responseEntity.getBody();

		Long appraisalCount = retJson.get("appraisalCount") != null ? Long.parseLong(retJson.get("appraisalCount").toString()) : 0l;

		JSONObject jsonObj = new JSONObject();
		jsonObj.put("appraisalCount", appraisalCount);

		return jsonObj.toString();
	}

	/**
	 * @param request
	 * @return 查询项目数量
	 */
	@RequestMapping(value = "/admin/project-count", method = RequestMethod.POST)
	@ResponseBody
	public Object getProjectCount(HttpServletRequest request) {
		System.out.println("1====/admin/project-count" + sysUserInfo.getUserId());
		HashMap<String, String> map = new HashMap<String, String>();
		if (request.getParameter("define2") != null && !request.getParameter("define2").equals("")) {
			map.put("define2", request.getParameter("define2"));
		}
		if (request.getParameter("typeFlag") != null && !request.getParameter("typeFlag").equals("")) {
			map.put("typeFlag", request.getParameter("typeFlag"));
		}
		map.put("nd", "2018");
		HttpEntity<HashMap<String, String>> entity = new HttpEntity<HashMap<String, String>>(map, this.httpHeaders);

		ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(PROJECT_COUNT, HttpMethod.POST, entity, JSONObject.class);
		JSONObject retJson = responseEntity.getBody();
		System.out.println("2====/admin/project-count" + retJson);
		return retJson.toString();
	}
	
	/**
	 * @param request
	 * @return 首页查询新开的国家项目、重点项目、重大项目、其他项目的统计
	 */
	@RequestMapping(value = "/admin/project/type/new", method = RequestMethod.POST)
	@ResponseBody
	public Object getProjectTotalInfoByNew(HttpServletRequest request) {
		System.out.println("1====/admin/project/type/new");
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("nd", "2018");
		map.put("typeFlag", "研究院");
		HttpEntity<HashMap<String, String>> entity = new HttpEntity<HashMap<String, String>>(map, this.httpHeaders);

		ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(NEW_PROJECT_COUNT, HttpMethod.POST, entity, JSONObject.class);
		JSONObject retJson = responseEntity.getBody();

		return retJson.toString();
	}
	
	/**
	 * @param request
	 * @return 首页查询新开的国家项目、重点项目、重大项目、其他项目和去年比
	 */
	@RequestMapping(value = "/admin/project/last-year/rate", method = RequestMethod.POST)
	@ResponseBody
	public Object getProjectTotalCountYearAndLastYear(HttpServletRequest request) {
		System.out.println("1====/admin/project/type/new");
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("nd", "2017");
		HttpEntity<HashMap<String, String>> entity = new HttpEntity<HashMap<String, String>>(map, this.httpHeaders);

		ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(NEW_PROJECT_RATE, HttpMethod.POST, entity, JSONObject.class);
		JSONObject retJson = responseEntity.getBody();

		return retJson.toString();
	}
	
	/**
	 * @param request
	 * @return 年度科研项目总览
	 */
	@RequestMapping(value = "/admin/project/type/unit/list")
	@ResponseBody
	public String getProjectTypeInfoByUnit(HttpServletRequest request) {
		System.out.println("1====/admin/project/type/unit/list");
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("nd", "2017");
		HttpEntity<HashMap<String, String>> entity = new HttpEntity<HashMap<String, String>>(map, this.httpHeaders);

		ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(PROJECT_TOTAL_YEAR, HttpMethod.POST, entity, JSONArray.class);
		JSONArray retJson = responseEntity.getBody();
		
		Result result = new Result();
		ChartBarLineResultData barLine=new ChartBarLineResultData();
		List<String> legendDataList = new ArrayList<String>();
		legendDataList.add("新开课题");
		legendDataList.add("结转课题");
		barLine.setLegendDataList(legendDataList);
		
		// Y轴各个柱体显示的数值
		List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
		
		ChartBarLineSeries xkBar = new ChartBarLineSeries();
		ChartBarLineSeries xjBar = new ChartBarLineSeries();
		List<Object> xkDataBar = new ArrayList<Object>();//新开
		List<Object> xjDataBar = new ArrayList<Object>();//续建
		
		// x轴显示的汉字
		List<String> xAxisDataList=new ArrayList<String>();
		for (int i =0; i < retJson.size(); i++) {
			JSONObject temJson = retJson.getJSONObject(i);
			xAxisDataList.add(temJson.getString("type_flag"));
			
			xkDataBar.add(temJson.getString("xksl"));
			xjDataBar.add(temJson.getString("xjsl"));
		}
		xkBar.setName("新开课题");
		xkBar.setType(HanaConstant.ECHARTS_TYPE_BAR);
		xkBar.setData(xkDataBar);
		
		xjBar.setName("结转课题");
		xjBar.setType(HanaConstant.ECHARTS_TYPE_BAR);
		xjBar.setData(xjDataBar);
		
		seriesList.add(xkBar);
		seriesList.add(xjBar);
		
		barLine.setxAxisDataList(xAxisDataList);
		barLine.setSeriesList(seriesList);
		
		result.setSuccess(true);
		result.setData(barLine);

		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
		System.out.println(">>>>>>>>>>>>>>>年度科研项目总览 " + resultObj.toString());
		return resultObj.toString();
	}
	
	
	/**
	 * 领导页面初始化配置功能
	 */
	@RequestMapping(value = "/user/show/config")
	public String iniUserShowConfig(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("进入iniUserShowConfig....");
		// 查询已配置的显示功能模块，空的时候，默认给所有的统计模块
		ResponseEntity<JSONArray> showEntity = this.restTemplate.exchange(USER_SHOW_LIST + sysUserInfo.getUserId(), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), JSONArray.class);
		JSONArray showJson = showEntity.getBody();
		List<SysUserShowConfig> showList = JSONObject.parseArray(showJson.toJSONString(), SysUserShowConfig.class);
		
		List<SysUserShowConfig> show1List = new ArrayList<SysUserShowConfig>();
		List<SysUserShowConfig> show2List = new ArrayList<SysUserShowConfig>();
		
		for (SysUserShowConfig sysUserShowConfig : showList) {
			if (sysUserShowConfig.getModuleId() != null && !sysUserShowConfig.getModuleId().equals("")) {
				show1List.add(sysUserShowConfig);
			}
			
			if (sysUserShowConfig.getFunctionId() != null && !sysUserShowConfig.getFunctionId().equals("")) {
				show2List.add(sysUserShowConfig);
			}
		}
		
		// 查询本人已有的统计模块(系统级原有)
		SysModule vo = new SysModule();
		vo.setPage("1");
		vo.setLimit("100");
		HttpEntity<SysModule> entity = new HttpEntity<SysModule>(vo, this.httpHeaders);
		ResponseEntity<String> responseEntity = this.restTemplate.exchange(MODULE_LIST, HttpMethod.POST, entity, String.class);
		String result = responseEntity.getBody();
		JSONObject config1Json = JSONObject.parseObject(result);
		List<SysModule> config1List = new ArrayList<SysModule>();
		if (config1Json != null) {
			config1List = JSONObject.parseArray(config1Json.getJSONArray("list").toJSONString(), SysModule.class);
			// 去除已经配置统计模块
			for (int i = 0; i < config1List.size(); i++) {
				for (SysUserShowConfig sysUserShowConfig : show1List) {
					if (sysUserShowConfig.getModuleId() != null && sysUserShowConfig.getModuleId().equals(config1List.get(i).getId())) {
						config1List.remove(i);
						i--;
						break;
					}
				}
			}
		}
		
		// 查询本人已有的业务功能模块
		SysUser userDetails = this.restTemplate.exchange(USER_DETAILS_URL + sysUserInfo.getUserId(), HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SysUser.class).getBody();
		List<SysFunction> funList = userDetails.getFunList();
		
		List<SysFunction> config2List = new ArrayList<SysFunction>();
		if (funList != null) {
			for (SysFunction sysfun : funList) {
				if (sysfun.getUrl() != null && !sysfun.getUrl().equals("#")) {
					config2List.add(sysfun);
				}
			}
		}
		// 去除已经配置业务功能模块
		for (int i = 0; i < config2List.size(); i++) {
			for (SysUserShowConfig sysUserShowConfig : show2List) {
				if (sysUserShowConfig.getFunctionId() != null && sysUserShowConfig.getFunctionId().equals(config2List.get(i).getId())) {
					config2List.remove(i);
					i--;
					break;
				}
			}
		}
		
		request.setAttribute("show1List", show1List);
		request.setAttribute("show2List", show2List);
		
		request.setAttribute("config1List", config1List);
		request.setAttribute("config2List", config2List);

		return "/base/system/user_show_config";
	}

}
