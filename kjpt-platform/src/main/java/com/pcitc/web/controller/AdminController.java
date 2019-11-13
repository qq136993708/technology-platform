package com.pcitc.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
import org.springframework.web.bind.annotation.ModelAttribute;
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
import com.pcitc.base.constant.SysConstant;
import com.pcitc.base.system.SysCollect;
import com.pcitc.base.system.SysFunction;
import com.pcitc.base.system.SysModule;
import com.pcitc.base.system.SysNews;
import com.pcitc.base.system.SysNotice;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.system.SysUserShowConfig;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.HostUtil;
import com.pcitc.base.util.MD5Util;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.common.OperationFilter;
import com.pcitc.web.common.SessionShare;
import com.pcitc.web.test.OAAPIRestFul;
import com.pcitc.web.utils.EquipmentUtils;
import com.pcitc.web.utils.HanaUtil;
import com.pcitc.web.utils.OtherUtil;
import com.sinopec.siam.agent.common.SSOPrincipal;
import com.sinopec.siam.agent.sp.config.SysConfig;

/**
 * @author zhf 系统登录成功后的首页
 */
@Controller
public class AdminController extends BaseController {

	// 访问zuul中的登录方法
	private static final String LOGIN_URL = "http://kjpt-zuul/auth/login";
	private static final String GET_USER_INFO_IP = "http://kjpt-zuul/system-proxy/user-provider/user/get-user-byname/";
	private static final String USER_DETAILS_URL = "http://kjpt-zuul/system-proxy/user-provider/user/user-details/";
	private static final String GET_USER_INFO = "http://kjpt-zuul/system-proxy/user-provider/user/get-user-byname/";
	private static final String UPD_USER_INFO = "http://kjpt-zuul/system-proxy/user-provider/user/update-user";

	// 已办任务数
	private static final String DONE_TASK_COUNT = "http://kjpt-zuul/system-proxy/task-provider/done-task-count";
	// 待办任务数
	private static final String PENDING_TASK_COUNT = "http://kjpt-zuul/system-proxy/task-provider/pending-task-count";

	// 专利数量（研究院）
	private static final String PATENT_COUNT = "http://kjpt-zuul/system-proxy/out-patent-provider/patent-count";
	// 科技奖励数量（研究院）
	private static final String APPRAISAL_COUNT = "http://kjpt-zuul/system-proxy/out-provider/appraisal-count";
	// 科研项目数量、科研装备项目数量、新开项目金额、新开和结转的总金额（研究院）
	private static final String PROJECT_COUNT = "http://kjpt-zuul/system-proxy/out-provider/project-count";
	// 新开的国家项目、重点项目、重大项目、其他项目的统计
	private static final String NEW_PROJECT_COUNT = "http://kjpt-zuul/system-proxy/out-project-provider/type/new";
	// 新开的国家项目、重点项目、重大项目、其他项目和去年比
	private static final String NEW_PROJECT_RATE = "http://kjpt-zuul/system-proxy/out-project-provider/type/last-year/rate";
	// 收藏菜单
	private static final String COLLECT_FUNCTION = "http://kjpt-zuul/system-proxy/syscollect-provider/sys_collect/add";

	// 系统统计功能模块列表
	private static final String MODULE_LIST = "http://kjpt-zuul/system-proxy/sysModule-provider/sysModule_list";

	// 系统统计功能模块列表
	private static final String USER_SHOW_LIST = "http://kjpt-zuul/system-proxy/sysconfig-provider/user/show/config/";

	// 工作完成情况统计
	private static final String WORKORDER_STAT = "http://kjpt-zuul/system-proxy/planbase-provider/workorder/stat";

	// 项目管理系统通知公告
	private static final String PROJECT_NOTICE = "http://kjpt-zuul/system-proxy/out-notice/type/page";
	private static final String PROJECT_NOTICE_DETAILS = "http://kjpt-zuul/system-proxy/out-notice/type/notice/";

	// 获取项目管理系统的待办任务
	private static final String XMGL_PENDING = "http://kjpt-zuul/system-proxy/out-wait-work/xmgl/page";

	private static final String LEADER_WORK = "http://kjpt-zuul/system-proxy/planClient-provider/leader/work/list";

	private Integer TIME_OUT = 1 * 60 * 60;

	/**
	 * 科技平台统一身份认证首页
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/stpHome")
	public String indexStp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("进入indexStp....");
		SSOPrincipal ssoPrincipal = ((SSOPrincipal) request.getSession().getAttribute(SSOPrincipal.NAME_OF_SESSION_ATTR));
		System.out.println(JSON.toJSONString(ssoPrincipal));
		String uAccount = "";

		this.addReqLog(this, JSON.toJSONString(ssoPrincipal),"开始登录");
		SysUser rsUser = new SysUser();
		if (ssoPrincipal != null) {
			// 没有此系统的权限
			if (ssoPrincipal.getAppAccount() == null || "".equals(ssoPrincipal.getAppAccount())) {
				System.out.println(ssoPrincipal.getUid() + "---------" + ssoPrincipal.getAppAccount());
				this.addReqLog(this, ssoPrincipal.getUid(),"权限不足");
				// 返回权限不足页面
				return "no_access";
			}
			// 查看此账号所拥有的应用系统权限
			List<String> spRoleList = ssoPrincipal.getValueAsList("spRoleList");
			// 应用系统权限为空
			if (spRoleList == null || spRoleList.size() == 0) {
				// 返回权限不足页面
				System.out.println("spRoleList=null---------应用系统权限为空 ");
				this.addReqLog(this, "spRoleList is null","应用系统权限不足");
				return "no_access";
			} else {
				int tem = 0;
				for (int i = 0; i < spRoleList.size(); i++) {
					String spList = spRoleList.get(i);
					System.out.println(">>>>>>>>>应用系统: "+spList);
					this.addReqLog(this, spList,"进入应用系统");
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
				if (tem == 0) {
					// 返回权限不足页面
					System.out.println("tem = 0---------返回权限不足页面 ");
					this.addReqLog(this, "tem =0 ","应用系统权限不足");
					return "no_access";
				} else {
					uAccount = ssoPrincipal.getAppAccount()[0];
					System.out.println("uAccount ==========" + uAccount);
					ResponseEntity<SysUser> rsEntity = this.restTemplate.exchange(GET_USER_INFO_IP + uAccount, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), SysUser.class);
					rsUser = rsEntity.getBody();
					if (rsUser != null) {
						// 用户有哪些菜单权限
						JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(rsUser));
						System.out.println(">>>>>>>>>用户基本信息: "+jsonObject.toString());
						SysUser userDetails = this.restTemplate.exchange(USER_DETAILS_URL + rsUser.getUserId(), HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SysUser.class).getBody();
						JSONObject userDetailsObject = JSONObject.parseObject(JSONObject.toJSONString(userDetails));
						System.out.println(">>>>>>>>>用户菜单权限信息: "+userDetailsObject.toString());
						List<SysFunction> funList = userDetails.getFunList();
						List<SysFunction> upList = new ArrayList<SysFunction>();

						// 个人工作台菜单
						List<SysFunction> grgztList = new ArrayList<SysFunction>();
						HashSet authSet = new HashSet();
						if (funList != null) {
							for (SysFunction sysfun : funList) {
								if (sysfun.getParentId() != null && sysfun.getParentId().equals("10001") && !sysfun.getName().equals("个人工作台") && !sysfun.getName().contains("权限")) {
									upList.add(sysfun);
								}

								// 个人工作台的二级、三级菜单
								if (sysfun.getParentCode() != null && sysfun.getParentCode().startsWith("1027") && !sysfun.getName().equals("个人工作台")) {
									grgztList.add(sysfun);
								}
								
								if (sysfun.getUrl() != null && !sysfun.getUrl().contains("#") && sysfun.getUrl().split("/").length > 1) {
									authSet.add(sysfun.getUrl().split("/")[1]);
								}
							}
							request.getSession().setAttribute("authSet", authSet);
							System.out.println("查询菜单权限----------" + funList.size());
						} else {
							System.out.println("无菜单权限----------");
							this.addReqLog(this, "funList is null","无菜单权限");
							return "no_access";
						}

						// 收藏的菜单
						List<SysCollect> scList = userDetails.getScList();
						request.setAttribute("scList", scList);
						request.setAttribute("funList", funList);
						request.setAttribute("grgztList", grgztList);
						request.setAttribute("upList", upList);
						request.setAttribute("userInfo", rsUser);
						
						JSONArray jsonscList = JSONArray.parseArray(JSON.toJSONString(scList));
						JSONArray jsonfunList= JSONArray.parseArray(JSON.toJSONString(funList));
						JSONArray jsongrgztList = JSONArray.parseArray(JSON.toJSONString(grgztList));
						JSONArray jsonupList = JSONArray.parseArray(JSON.toJSONString(upList));
						
						
						System.out.println(">>>>>>>>>收藏信息: "+jsonscList.toString());
						System.out.println(">>>>>>>>>所有菜单信息: "+jsonfunList.toString());
						System.out.println(">>>>>>>>>一级菜单信息: "+jsonupList.toString());
						System.out.println(">>>>>>>>>个人工作台菜单信息: "+jsongrgztList.toString());
						
						
					} else {
						// 返回权限不足页面
						System.out.println("LogonController----缺少权限");
						this.addReqLog(this, "rsUser is null","缺少权限");
						return "no_access";
					}
				}
			}

		} else {
			// 登录异常
			System.out.println("LogonController----登录异常");
			this.addReqLog(this, "ssoPrincipal is null","登录异常");
			return "no_access";
		}

		// 重新登录，覆盖原cookies。cookies中信息都是后续要用的。分布式系统用户信息没放session里面
		httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
		requestBody.add("username", rsUser.getUserName());
		requestBody.add("password", rsUser.getUserPassword());
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);

		ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LOGIN_URL, HttpMethod.POST, entity, JSONObject.class);
		JSONObject retJson = responseEntity.getBody();

		Cookie cookie = new Cookie("token", retJson.getString("token"));
		cookie.setMaxAge(TIME_OUT);// 设置有效期为一小时
		cookie.setPath("/");
		response.addCookie(cookie);

		// oa系统的服务器地址, 安全问题不能直接把ip写在前端
		request.setAttribute("outOAIp", "10.1.4.10");

		// 登录成功,保存当前用户登录的sessionId, 一个用户只能一处登录
		/*String sessionID = request.getRequestedSessionId();
		String userName = rsUser.getUserName();
		if (!SessionShare.getSessionIdSave().containsKey(userName)) {
			SessionShare.getSessionIdSave().put(userName, sessionID);
		} else if (SessionShare.getSessionIdSave().containsKey(userName) && !sessionID.equals(SessionShare.getSessionIdSave().get(userName))) {
			SessionShare.getSessionIdSave().remove(userName);
			SessionShare.getSessionIdSave().put(userName, sessionID);
		}*/

		request.setAttribute("userId", rsUser.getUserId());
		if (rsUser.getUserLevel() != null && (rsUser.getUserLevel() == 1 || rsUser.getUserLevel() == 2)) {
			String companyCode = EquipmentUtils.getVirtualDirDeparetCode(EquipmentUtils.SYS_FUNCTION_FICTITIOUS, restTemplate, httpHeaders);
			request.setAttribute("companyCode", companyCode);
			
			List<SysNews> sysNewsList = OtherUtil.getSysNewsPicList(request, restTemplate, httpHeaders);
			request.setAttribute("sysNewsList", sysNewsList);
			return "/oneLevelMain";
		} else {

			List<SysNotice> list = OtherUtil.getSysNoticeTopList(request, restTemplate, httpHeaders);
			request.setAttribute("list", list);
			return "/index";
		}
	}

	/**
	 * 领导页面切换到工作页面的特殊转换，不考虑登录者身份直接切换到工作台
	 */
	@RequestMapping(value = "/work")
	public String indexStpWork(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// System.out.println("进入indexStp....");
		SSOPrincipal ssoPrincipal = ((SSOPrincipal) request.getSession().getAttribute(SSOPrincipal.NAME_OF_SESSION_ATTR));
		// System.out.println("ssoPrincipal==========" + ssoPrincipal);
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
						HashSet authSet = new HashSet();
						if (funList != null) {
							for (SysFunction sysfun : funList) {
								if (sysfun.getParentId() != null && sysfun.getParentId().equals("10001") && !sysfun.getName().equals("个人工作台") && !sysfun.getName().contains("权限")) {
									upList.add(sysfun);
								}

								// 个人工作台的二级、三级菜单
								if (sysfun.getParentCode() != null && sysfun.getParentCode().startsWith("1027") && !sysfun.getName().equals("个人工作台")) {
									// System.out.println("个人工作台================"+sysfun.getName());
									grgztList.add(sysfun);
								}
								if (sysfun.getUrl() != null && !sysfun.getUrl().contains("#") && sysfun.getUrl().split("/").length > 1) {
									authSet.add(sysfun.getUrl().split("/")[1]);
								}
							}
							request.getSession().setAttribute("authSet", authSet);
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
		cookie.setMaxAge(TIME_OUT);// 设置有效期为一小时
		cookie.setPath("/");
		response.addCookie(cookie);
		request.setAttribute("userId", rsUser.getUserId());

		List<SysNotice> list = OtherUtil.getSysNoticeTopList(request, restTemplate, httpHeaders);
		request.setAttribute("list", list);
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
		System.out.println("toIndexPage----------====....");
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
				loginCookie.setMaxAge(TIME_OUT);// 设置有效期为一小时
				loginCookie.setPath("/");
				response.addCookie(loginCookie);
				response.sendRedirect("/login");

				return null;
			}

			Cookie cookie = new Cookie("token", retJson.getString("token"));
			cookie.setMaxAge(TIME_OUT);// 设置有效期为一小时
			cookie.setPath("/");
			response.addCookie(cookie);

			// 获取用户有哪些功能权限
			tokenUser = JwtTokenUtil.getUserFromTokenByValue(retJson.get("token").toString());
			userDetails = this.restTemplate.exchange(USER_DETAILS_URL + tokenUser.getUserId(), HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SysUser.class).getBody();
			List<SysFunction> funList = userDetails.getFunList();
			List<SysFunction> upList = new ArrayList<SysFunction>();
			// 个人工作台菜单
			List<SysFunction> grgztList = new ArrayList<SysFunction>();
			HashSet authSet = new HashSet();
			for (SysFunction sysfun : funList) {
				if (sysfun.getParentId() != null && sysfun.getParentId().equals("10001") && !sysfun.getName().equals("个人工作台") && !sysfun.getName().contains("权限")) {
					upList.add(sysfun);
				}

				// 个人工作台的二级、三级菜单
				if (sysfun.getParentCode() != null && sysfun.getParentCode().startsWith("1027") && !sysfun.getName().equals("个人工作台")) {
					// System.out.println("个人工作台================"+sysfun.getName());
					grgztList.add(sysfun);
				}
				if (sysfun.getUrl() != null && !sysfun.getUrl().contains("#") && sysfun.getUrl().split("/").length > 1) {
					authSet.add(sysfun.getUrl().split("/")[1]);
				}
			}
			request.getSession().setAttribute("authSet", authSet);

			// 收藏的菜单
			List<SysCollect> scList = userDetails.getScList();
			request.setAttribute("scList", scList);

			// 重置登录次数
			if (userDetails.getLoginErrorNumber() != null && userDetails.getLoginErrorNumber() > 0) {
				userDetails.setLoginErrorNumber(0);
				this.restTemplate.exchange(UPD_USER_INFO, HttpMethod.POST, new HttpEntity<SysUser>(userDetails, this.httpHeaders), Integer.class);
			}

			request.setAttribute("funList", funList);
			request.setAttribute("grgztList", grgztList);
			request.setAttribute("upList", upList);
			request.setAttribute("userInfo", userDetails);

			Cookie loginCookie = new Cookie("loginErrorCount", null);
			loginCookie.setMaxAge(0);// 设置过期
			loginCookie.setPath("/");
			response.addCookie(loginCookie);
			System.out.println("----------====登录成功2index....");
			
			// 登录成功,保存当前用户登录的sessionId, 一个用户只能一处登录
			/*String sessionID = request.getRequestedSessionId();
			String userName = userDetails.getUserName();
			if (!SessionShare.getSessionIdSave().containsKey(userName)) {
				SessionShare.getSessionIdSave().put(userName, sessionID);
			} else if (SessionShare.getSessionIdSave().containsKey(userName) && !sessionID.equals(SessionShare.getSessionIdSave().get(userName))) {
				SessionShare.getSessionIdSave().remove(userName);
				SessionShare.getSessionIdSave().put(userName, sessionID);
			}*/

			request.setAttribute("userId", userDetails.getUserId());
			String cFlag = request.getParameter("cFlag");
			if (userDetails.getUserLevel() != null && (userDetails.getUserLevel() == 1 || userDetails.getUserLevel() == 2) && cFlag == null) {
				String companyCode = EquipmentUtils.getVirtualDirDeparetCode(EquipmentUtils.SYS_FUNCTION_FICTITIOUS, restTemplate, httpHeaders);
				request.setAttribute("companyCode", companyCode);
				String month = HanaUtil.getCurrentYearMoth();
				request.setAttribute("month", month);
				List<SysNews> sysNewsList = OtherUtil.getSysNewsPicList(request, restTemplate, httpHeaders);
				request.setAttribute("sysNewsList", sysNewsList);
				return "/oneLevelMain";// leaderIndex
			} else {
				List<SysNotice> list = OtherUtil.getSysNoticeTopList(request, restTemplate, httpHeaders);
				request.setAttribute("list", list);
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
			HashSet authSet = new HashSet();
			for (SysFunction sysfun : funList) {
				if (sysfun.getParentId() != null && sysfun.getParentId().equals("10001") && !sysfun.getName().equals("个人工作台") && !sysfun.getName().contains("权限")) {
					upList.add(sysfun);
				}

				// 个人工作台的二级、三级菜单
				if (sysfun.getParentCode() != null && sysfun.getParentCode().startsWith("1027") && !sysfun.getName().equals("个人工作台")) {
					// System.out.println("个人工作台================"+sysfun.getName());
					grgztList.add(sysfun);
				}
				if (sysfun.getUrl() != null && !sysfun.getUrl().contains("#") && sysfun.getUrl().split("/").length > 1) {
					authSet.add(sysfun.getUrl().split("/")[1]);
				}
			}
			request.getSession().setAttribute("authSet", authSet);

			// 收藏的菜单
			List<SysCollect> scList = userDetails.getScList();
			request.setAttribute("scList", scList);

			// 重新登录，覆盖原cookies。cookies中信息都是后续要用的
			httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
			requestBody.add("username", userDetails.getUserName());
			requestBody.add("password", userDetails.getUserPassword());
			HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);

			ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LOGIN_URL, HttpMethod.POST, entity, JSONObject.class);
			JSONObject retJson = responseEntity.getBody();

			Cookie cookie = new Cookie("token", retJson.getString("token"));
			cookie.setMaxAge(TIME_OUT);// 设置有效期为一小时
			cookie.setPath("/");
			response.addCookie(cookie);

			request.setAttribute("funList", funList);
			request.setAttribute("grgztList", grgztList);
			request.setAttribute("upList", upList);
			request.setAttribute("userInfo", userDetails);

			System.out.println("----------====登录成功1index....");
			Cookie loginCookie = new Cookie("loginErrorCount", null);
			loginCookie.setMaxAge(0);
			loginCookie.setPath("/");
			response.addCookie(loginCookie);
			
			// 登录成功,保存当前用户登录的sessionId, 一个用户只能一处登录
			String sessionID = request.getRequestedSessionId();
			String userName = userDetails.getUserName();
			if (!SessionShare.getSessionIdSave().containsKey(userName)) {
				SessionShare.getSessionIdSave().put(userName, sessionID);
			} else if (SessionShare.getSessionIdSave().containsKey(userName) && !sessionID.equals(SessionShare.getSessionIdSave().get(userName))) {
				SessionShare.getSessionIdSave().remove(userName);
				SessionShare.getSessionIdSave().put(userName, sessionID);
			}

			String cFlag = request.getParameter("cFlag");
			request.setAttribute("userId", userDetails.getUserId());
			if (userDetails.getUserLevel() != null && (userDetails.getUserLevel() == 1 || userDetails.getUserLevel() == 2) && cFlag == null) {
				String companyCode = EquipmentUtils.getVirtualDirDeparetCode(EquipmentUtils.SYS_FUNCTION_FICTITIOUS, restTemplate, httpHeaders);
				request.setAttribute("companyCode", companyCode);
				String month = HanaUtil.getCurrentYearMoth();
				request.setAttribute("month", month);
				List<SysNews> sysNewsList = OtherUtil.getSysNewsPicList(request, restTemplate, httpHeaders);
				request.setAttribute("sysNewsList", sysNewsList);
				return "/oneLevelMain";// leaderIndex
			} else {
				List<SysNotice> list = OtherUtil.getSysNoticeTopList(request, restTemplate, httpHeaders);
				request.setAttribute("list", list);
				return "/index";
			}
		}
	}

	@RequestMapping(value = "/instituteIndex")
	public String instituteIndex(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String url = CommonUtil.getParameter(request, "url", "");
		request.setAttribute("url", url);

		url = java.net.URLDecoder.decode(request.getParameter("url"), "UTF-8");// 名称检索条件

		SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);

		SysUser userDetails = this.restTemplate.exchange(USER_DETAILS_URL + sysUserInfo.getUserId(), HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SysUser.class).getBody();

		// 收藏的菜单
		List<SysCollect> scList = userDetails.getScList();
		request.setAttribute("scList", scList);

		List<SysFunction> funList = userDetails.getFunList();
		List<SysFunction> upList = new ArrayList<SysFunction>();
		// 个人工作台菜单
		List<SysFunction> grgztList = new ArrayList<SysFunction>();
		HashSet authSet = new HashSet();
		for (SysFunction sysfun : funList) {
			if (sysfun.getParentId() != null && sysfun.getParentId().equals("10001") && !sysfun.getName().equals("个人工作台") && !sysfun.getName().contains("权限")) {
				upList.add(sysfun);
			}

			if (sysfun.getParentCode() != null && sysfun.getParentCode().startsWith("1027") && !sysfun.getName().equals("个人工作台")) {
				// System.out.println("个人工作台================"+sysfun.getName());
				grgztList.add(sysfun);
			}
			if (sysfun.getUrl() != null && !sysfun.getUrl().contains("#") && sysfun.getUrl().split("/").length > 1) {
				authSet.add(sysfun.getUrl().split("/")[1]);
			}
		}
		request.getSession().setAttribute("authSet", authSet);
		request.setAttribute("funList", funList);
		request.setAttribute("grgztList", grgztList);
		request.setAttribute("upList", upList);
		request.setAttribute("userInfo", userDetails);

		getContractParameter(request, response);
		request.setAttribute("userId", userDetails.getUserId());
		return "/instituteIndex";
	}

	@RequestMapping(value = "/instituteRedrect")
	public String instituteRedrect(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String url = CommonUtil.getParameter(request, "url", "");
		request.setAttribute("url", url);

		url = java.net.URLDecoder.decode(request.getParameter("url"), "UTF-8");// 名称检索条件
		return url;
	}

	public void getContractParameter(HttpServletRequest request, HttpServletResponse response) {
		String nd = CommonUtil.getParameter(request, "nd", "");// 项目名
		String ysnd = CommonUtil.getParameter(request, "ysnd", "");// 项目名
		String xmmc = CommonUtil.getParameter(request, "xmmc", "");// 项目名
		String hth = CommonUtil.getParameter(request, "hth", "");// 合同号
		String define1 = CommonUtil.getParameter(request, "define1", "");// 资本性、费用性
		String define2 = CommonUtil.getParameter(request, "define2", "");// 8大院等细分结构
		String define3 = CommonUtil.getParameter(request, "define3", "");// 直属研究院、分子公司、集团等9种类型
		String project_property = CommonUtil.getParameter(request, "project_property", "");// 国家项目、重大专项、重点项目、其他项目
		String project_scope = CommonUtil.getParameter(request, "project_scope", "");// 新开项目、续建项目、完工项目
		String zylb = CommonUtil.getParameter(request, "zylb", "");// 装备的各种技术类型
		String zycmc = CommonUtil.getParameter(request, "zycmc", "");// 各个处室

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

		String projectId = CommonUtil.getParameter(request, "projectId", "");
		request.setAttribute("projectId", projectId);

	}

	private static final String MY_BOT_WORK_ORDER_LIST = "http://kjpt-zuul/system-proxy/planClient-provider/my/botWorkOrder_list";
	private static final String BOT_WORK_ORDER_LIST = "http://kjpt-zuul/system-proxy/planClient-provider/botWorkOrder_list";

	private static final String selectSonPlanBasesByCreateUserId = "http://kjpt-zuul/system-proxy/planClient-provider/selectSonPlanBasesByCreateUserId";

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
		String companyCode = EquipmentUtils.getVirtualDirDeparetCode(EquipmentUtils.SYS_FUNCTION_FICTITIOUS, restTemplate, httpHeaders);
		request.setAttribute("companyCode", companyCode);
		String nd = HanaUtil.getCurrentYear();
		request.setAttribute("nd", nd);
		String month = HanaUtil.getCurrentYearMoth();
		request.setAttribute("month", month);
		String unitCode = sysUserInfo.getUnitCode();
		request.setAttribute("unitCode", unitCode);

		// 获取任务
		LayuiTableParam param = new LayuiTableParam();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("createUserId", sysUserInfo.getUserId());
		HttpEntity<JSONObject> entity = new HttpEntity<JSONObject>(jsonObject, this.httpHeaders);
		ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(selectSonPlanBasesByCreateUserId, HttpMethod.POST, entity, JSONObject.class);
		JSONObject result = responseEntity.getBody();
		List<Map<String, Object>> planBases = (List<Map<String, Object>>) result.get("list");
		for (int i = 0, j = planBases.size(); i < j; i++) {
			Map<String, Object> base = planBases.get(i);
			String[] workOrderName = base.get("workOrderAllotUserName").toString().split(",");
			if (workOrderName.length > 1) {
				planBases.get(i).put("workOrderAllotUserName", workOrderName[0] + "等" + workOrderName.length + "人正在处理");
			}
		}
		request.setAttribute("taskList", planBases);

		param = new LayuiTableParam();
		Map<String, Object> map = param.getParam();
		map.put("workOrderAllotUserId", sysUserInfo.getUserId());
		map.put("workOrderStatus", "1");
		map.put("isSchedule", "0"); // 只显示未定时的
		map.put("isChildren", "1");
		map.put("bak7", "0");
		param.setParam(map);
		param.setLimit(10); // 首页不能过多显示
		HttpEntity<LayuiTableParam> entityMy = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntityMy = this.restTemplate.exchange(MY_BOT_WORK_ORDER_LIST, HttpMethod.POST, entityMy, LayuiTableData.class);
		LayuiTableData resultMy = responseEntityMy.getBody();
		request.setAttribute("taskListMy", resultMy.getData());

		SysUser sysUser = EquipmentUtils.getSysUserByUserId(sysUserInfo.getUserId(), restTemplate, httpHeaders);
		List<SysCollect> scList = sysUser.getScList();
		// 收藏菜单前端显示
		List<SysCollect> scShowList = new ArrayList<SysCollect>();
		for (int i = 0; i < scList.size(); i++) {
			if (i < 6) {
				scShowList.add(scList.get(i));
			}
		}
		request.setAttribute("scShowList", scShowList);
		request.setAttribute("scList", scList);

		String unitPathId = sysUserInfo.getUnitPath();
		boolean isKJBPerson = EquipmentUtils.isKJBPerson(unitPathId);
		request.setAttribute("isKJBPerson", isKJBPerson);

		// oa系统的服务器地址
		request.setAttribute("outOAIp", "10.1.4.10");

		// 获取其他系统的通知公告
		LayuiTableParam noticePara = new LayuiTableParam();
		noticePara.setLimit(10);
		HttpEntity<LayuiTableParam> noticeEntity = new HttpEntity<LayuiTableParam>(noticePara, this.httpHeaders);
		ResponseEntity<LayuiTableData> noticeRes = this.restTemplate.exchange(PROJECT_NOTICE, HttpMethod.POST, noticeEntity, LayuiTableData.class);
		LayuiTableData noticeJTD = noticeRes.getBody();
		request.setAttribute("noticeList", noticeJTD.getData());
		
		// 获取登录人员职务
		request.setAttribute("userPosition", sysUserInfo.getUserConfig2());
		
		return "/mainStp";
	}

	// 获取O信息（待办）
	@RequestMapping(value = "/getOA")
	@ResponseBody
	public String getOA(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = CommonUtil.getParameter(request, "url", "");
		String str = OAAPIRestFul.getOa(url);
		if (str != null) {
			str = str.replace("\n", "");
		}

		Result resultsDate = new Result();
		if (str != null) {
			resultsDate.setSuccess(true);
			resultsDate.setData(str);
		} else {
			resultsDate.setSuccess(false);
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));

		// 安全设置：归档文件下载
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		return result.toJSONString();
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

	/**
	 * 待办任务数量，包括科技管理平台和其他系统
	 */
	@RequestMapping(value = "/admin/pending-task-count", method = RequestMethod.POST)
	@ResponseBody
	public Object getPendingTaskCount(HttpServletRequest request) {
		System.out.println("1====/admin/pending-task-count" + sysUserInfo.getUserId());
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("userId", sysUserInfo.getUserId());
		HttpEntity<HashMap<String, String>> entity = new HttpEntity<HashMap<String, String>>(map, this.httpHeaders);

		ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(PENDING_TASK_COUNT, HttpMethod.POST, entity, JSONObject.class);
		JSONObject retJson = responseEntity.getBody();

		Long doneTaskCount = retJson.get("pendingTaskCount") != null ? Long.parseLong(retJson.get("pendingTaskCount").toString()) : 0l;

		// 获取其他系统的待办任务数量
		// 获取当前登录人信息, 统一身份名作为用户id
		LayuiTableParam param = new LayuiTableParam();
		param.getParam().put("userId", sysUserInfo.getUserName());
		param.setLimit(100);
		param.setPage(1);
		HttpEntity<LayuiTableParam> entity1 = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity1 = this.restTemplate.exchange(XMGL_PENDING, HttpMethod.POST, entity1, LayuiTableData.class);
		LayuiTableData retJson1 = responseEntity1.getBody();
		int otherCount = retJson1.getCount();

		JSONObject jsonObj = new JSONObject();
		jsonObj.put("pendingTaskCount", doneTaskCount + otherCount);

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

		//判断是生产环境还是测试环境
		Set<String> serverHosts = HostUtil.getLocalHostAddressSet();
		Set<String> stpServerHosts = new HashSet<String>(Arrays.asList(SysConstant.STP_SERVER_HOST.split(",")));
		serverHosts.retainAll(stpServerHosts);
		if(serverHosts.size()>0) {
			return new Result(true, "logout","./SSO/GLO/Redirect");
		}
		return new Result(true, "logout","/login");
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
		if (retJson != null && retJson.getStatus().equals("1")) {
			return new Result(true, JSONObject.toJSONString(retJson), "收藏成功!");
		} else if (retJson != null && retJson.getStatus().equals("0")) {
			return new Result(true, JSONObject.toJSONString(retJson), "取消收藏成功!");
		} else {
			return new Result(false, "操作失败,只能收藏系统级功能菜单!");
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
		cookie.setMaxAge(TIME_OUT);// 设置有效期为一小时
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

		System.out.println("1====/admin/patent-count" + String.valueOf(Integer.parseInt(sdf.format(date)) - 1));
		if (request.getParameter("lastYearFlag") != null && !request.getParameter("lastYearFlag").equals("")) {
			map.put("nd", String.valueOf(Integer.parseInt(sdf.format(date)) - 1));
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
	@OperationFilter(dataFlag = "true")
	public Object getAppraisalCount(HttpServletRequest request) {
		HashMap<String, String> map = new HashMap<String, String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		Date date = new Date();

		System.out.println("1====getAppraisalCount" + request.getParameter("nd"));
		if (request.getParameter("lastYearFlag") != null && !request.getParameter("lastYearFlag").equals("")) {
			map.put("nd", String.valueOf(Integer.parseInt(sdf.format(date)) - 1));
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

		map.put("leaderFlag", String.valueOf(sysUserInfo.getUserLevel()));

		String cgjszy = request.getAttribute("cgjszy") == null ? "" : request.getAttribute("cgjszy").toString();
		System.out.println("1====cgjszy" + cgjszy);

		map.put("cgjszy", cgjszy);

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

	/**
	 * 统计首页中上周、本周的工作任务情况
	 */
	@RequestMapping(value = "/admin/workorder/stat")
	@ResponseBody
	public String workorderStat(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result = new Result();
		HashMap<String, String> paramsMap = new HashMap<String, String>();
		paramsMap.put("lastWeekStart", DateUtil.dateToStr(DateUtil.getDayOfWeek(Calendar.MONDAY, 2, -1), DateUtil.FMT_DD));
		paramsMap.put("lastWeekEnd", DateUtil.dateToStr(DateUtil.getDayOfWeek(Calendar.MONDAY, 1, -1), DateUtil.FMT_DD));
		paramsMap.put("thisWeekStart", DateUtil.dateToStr(DateUtil.getDayOfWeek(Calendar.MONDAY, 2, 0), DateUtil.FMT_DD));
		paramsMap.put("thisWeekEnd", DateUtil.dateToStr(DateUtil.getDayOfWeek(Calendar.MONDAY, 1, 0), DateUtil.FMT_DD));
		paramsMap.put("workOrderAllotUserId", sysUserInfo.getUserId());
		paramsMap.put("createUserId", sysUserInfo.getUserId());
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);

		ResponseEntity<JSONObject> responseEntity = restTemplate.exchange(WORKORDER_STAT, HttpMethod.POST, entity, JSONObject.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {

			JSONObject jSONObject = responseEntity.getBody();
			result.setSuccess(true);
			result.setData(jSONObject);

		}
		return JSONObject.toJSONString(result);
	}

	/**
	 * 跳转至任务列表页，本周安排
	 */
	@RequestMapping(value = "/admin/plan/listPlanPage")
	private String pagePlanList(HttpServletRequest request) {
		request.setAttribute("startTime", DateUtil.dateToStr(DateUtil.getDayOfWeek(Calendar.MONDAY, 2, 0), DateUtil.FMT_DD));
		request.setAttribute("endTime", DateUtil.dateToStr(DateUtil.getDayOfWeek(Calendar.MONDAY, 1, 0), DateUtil.FMT_DD));
		return "/stp/plan/listPlanPage";
	}

	/**
	 * 跳转至任务列表页，上周完成
	 */
	@RequestMapping(value = "/admin/plan/my/listMyPlan")
	private String listMyPlan(HttpServletRequest request) {
		request.setAttribute("startTime", DateUtil.dateToStr(DateUtil.getDayOfWeek(Calendar.MONDAY, 2, -1), DateUtil.FMT_DD));
		request.setAttribute("endTime", DateUtil.dateToStr(DateUtil.getDayOfWeek(Calendar.MONDAY, 1, -1), DateUtil.FMT_DD));
		return "/stp/plan/my/listMyPlan";
	}

	/**
	 * 领导，统计任务督办
	 */
	@RequestMapping(value = "/admin/workorder/ld/stat")
	@ResponseBody
	public Object workorderStatLD(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request) throws Exception {
		// 只查询本人创建的
		param.getParam().put("createUser", sysUserInfo.getUserId());

		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(LEADER_WORK, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData result = responseEntity.getBody();
		JSONObject retJson = (JSONObject) JSON.toJSON(result);
		return retJson;
	}

	

}
