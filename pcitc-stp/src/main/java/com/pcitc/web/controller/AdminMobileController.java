package com.pcitc.web.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.system.SysNotice;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.MD5Util;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.utils.DES3Utils;
import com.pcitc.web.utils.EquipmentUtils;
import com.pcitc.web.utils.HanaUtil;
import com.pcitc.web.utils.OtherUtil;
import com.pcitc.web.utils.RestfulHttpClient;
import com.sinopec.siam.agent.sp.config.SysConfig;

/**
 * @author zhf 系统登录成功后的首页
 */
@Controller
public class AdminMobileController extends BaseController {

	// 访问zuul中的登录方法
	private static final String LOGIN_URL = "http://pcitc-zuul/auth/login";
	private static final String GET_USER_INFO = "http://pcitc-zuul/system-proxy/user-provider/user/info";

	private static final String USER_DETAILS_URL = "http://pcitc-zuul/system-proxy/user-provider/user/user-details/";

	private Integer TIME_OUT = 1 * 60 * 60;

	/**
	 * 科技平台统一身份认证移动首页 作废方法，短token方式
	 * 短token方式，测试用pc页面的时候，没问题
	 * 手机端登录后，识别认为当前用户没认证登录
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/mobile-tem/index")
	public String indexMobileStpTem(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("1进入indexMobileStp....");
		String token = request.getParameter("Identity_Token");
		DES3Utils desUtils = new DES3Utils("01qaz2wsx3edc4rfv5tgb6yhn");
		String key1 = desUtils.des3Decode0(token);
		Map keymap = desUtils.getAcountByToken0(key1);
		String username = keymap.get("username").toString();
		System.out.println("username ==========" + username);

		String jsonString = JSON.toJSONString(keymap);
		System.out.println("jsonString ==========" + jsonString);

		// 通过统一身份账号，查询是否有这个用户
		JSONObject userPara = new JSONObject();
		userPara.put("userExtend", username);
		JSONArray jSONArray = restTemplate.exchange(GET_USER_INFO, HttpMethod.POST, new HttpEntity<String>(userPara.toString(), httpHeaders), JSONArray.class).getBody();
		List<SysUser> userList = JSONObject.parseArray(jSONArray.toJSONString(), SysUser.class);

		SysUser extUser = new SysUser();
		if (userList != null && userList.size() > 0) {
			extUser = userList.get(0);
		} else {
			System.out.println("indexMobileStp----没有此用户");
			return "no_access";
		}
		// 重新登录，覆盖原cookies。cookies中信息都是后续要用的
		httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();

		// 直接登录，默认密码
		requestBody.add("username", extUser.getUserName());
		requestBody.add("password", extUser.getUserPassword());
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);

		ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LOGIN_URL, HttpMethod.POST, entity, JSONObject.class);
		JSONObject retJson = responseEntity.getBody();
		if (retJson == null || retJson.get("token") == null) {
			// 返回权限不足页面
			System.out.println("indexMobileStp----缺少权限");
			return "no_access";
		}
		System.out.println("-----indexStp----------login token:" + retJson.get("token"));

		Cookie cookie = new Cookie("token", retJson.getString("token"));
		cookie.setMaxAge(1 * 60 * 60);// 设置有效期为1天
		cookie.setPath("/");
		response.addCookie(cookie);

		// 获取用户基本信息（token）
		SysUser tokenUser = JwtTokenUtil.getUserFromTokenByValue(retJson.get("token").toString());

		String unitPathId = tokenUser.getUnitPath();

		// 科技部综合计划处
		boolean isZHJHCPerson=EquipmentUtils.getZycbmDic(EquipmentUtils.SYS_FUNCTION_FICTITIOUS, restTemplate, httpHeaders);
		request.setAttribute("isZHJHCPerson", isZHJHCPerson);
		request.setAttribute("sysUserInfo", sysUserInfo);
		
		if (isZHJHCPerson || sysUserInfo.getUserLevel() == 2) {
			request.getSession().setAttribute("mobileLeader", "true");
		}
		
		List<SysNotice> list = OtherUtil.getSysNoticeTopList(request, restTemplate, httpHeaders);
		request.setAttribute("list", list);
		String nd = HanaUtil.getCurrentYear();
		String month = HanaUtil.getCurrentYearMoth();
		request.setAttribute("nd", nd);
		request.setAttribute("month", month);
		String companyCode = EquipmentUtils.getVirtualDirDeparetCode(EquipmentUtils.SYS_FUNCTION_FICTITIOUS, restTemplate, httpHeaders);
		request.setAttribute("companyCode", companyCode);
		return "/mobile/index";
	}

	/**
	 * 科技平台统一身份认证移动首页
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/mobile/index")
	public String indexMobileStp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//System.out.println("1进入indexMobileStp....");
		System.out.println("2进入indexMobileStp...." + request.getParameter("oauth_token"));
		// 获取移动组统一身份的oauthToken值
		String oauthToken = request.getParameter("oauth_token");
		System.out.println("3进入indexMobileStp....SysConfig=========" + SysConfig.sp_login_tsysaccount);
		// 调用统一身份认证组的刷新oauth码的接口（此接口返回值可以继续调用统一身份的接口来获取人员信息）
		Map<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");
		RestfulHttpClient.setDefaultHeaders(headerMap);

		String refreshOauthUrl = "https://oauth.siam.sinopec.com/oauth/interface/token";
		RestfulHttpClient.HttpClient client = RestfulHttpClient.getClient(refreshOauthUrl);
		client.post();

		// 添加多个参数请求头
		client.addHeaders(headerMap);
		client.addQueryParam("client_id", "YWlvYmdjbWJjcGpibmhra2FwZG1lcGdvYmRnbmRtbWdmbm1vZW1sYWdtcGdtamZjamFobGRnY2lwaGFpZGtrcA==");
		client.addQueryParam("client_secret", "b25ibGFrY2hoZGxsZ2VmaWxtZmdiaGRobG9mZmNvbWlvaWdobGJoYWdub2NmbmVlb21qbG5qZmhja2JlcHBlbw==");
		client.addQueryParam("refresh_token", oauthToken);
		client.addQueryParam("grant_type", "refresh_token");
		client.addQueryParam("client_ip", getRemoteHost(request));
		RestfulHttpClient.HttpResponse authResponse = client.request();

		// 是否获取人员信息成功标识
		boolean testFlag = false;
		String uid = "";
		System.out.println("authResponse--------" + authResponse);
		System.out.println("authResponse--------" + authResponse.getCode());
		//System.out.println("authResponse--------" + authResponse.getContent());
		// 根据状态码判断请求是否成功
		if (authResponse.getCode() == 200) {
			// 获取响应内容
			String result = authResponse.getContent();
			System.out.println("refreshOauth返回--------" + result);
			JSONObject json = JSONObject.parseObject(result);
			if (json != null && json.get("access_token") != null) {
				String access_token = json.getString("access_token");
				String refresh_token = json.getString("refresh_token");
				String expires_in = json.getString("expires_in");

				// 获取用户信息
				String userUrl = "https://oauth.siam.sinopec.com/oauth/interface/getUserInfo";
				// 创建一个请求客户端
				RestfulHttpClient.HttpClient userClient = RestfulHttpClient.getClient(userUrl);
				userClient.post();
				// 添加多个参数请求头
				userClient.addHeaders(headerMap);

				userClient.addQueryParam("access_token", access_token);
				userClient.addQueryParam("client_id", "YWlvYmdjbWJjcGpibmhra2FwZG1lcGdvYmRnbmRtbWdmbm1vZW1sYWdtcGdtamZjamFobGRnY2lwaGFpZGtrcA==");
				userClient.addQueryParam("client_secret", "b25ibGFrY2hoZGxsZ2VmaWxtZmdiaGRobG9mZmNvbWlvaWdobGJoYWdub2NmbmVlb21qbG5qZmhja2JlcHBlbw==");

				RestfulHttpClient.HttpResponse userResponse = userClient.request();
				System.out.println("userResponse--------" + userResponse);
				System.out.println("userResponse--------" + userResponse.getCode());
				if (userResponse.getCode() == 200) {
					// 获取响应内容
					String userResult = userResponse.getContent();
					System.out.println("userOauth返回--------" + userResult);
					JSONObject userJson = JSONObject.parseObject(userResult);
					if (userJson != null && userJson.getString("uid") != null) {
						uid = userJson.getString("uid");
						System.out.println("uid返回--------" + uid);

						// sprolelist 判断此人是否有《科技管理平台》的权限，没有的话，直接返回
						testFlag = true;
					}
				}
			}
		}

		if (!testFlag) {
			// 没有权限，或者错误
			System.out.println("indexMobileStp----没有此用户");
			return "no_access";
		}

		// 通过统一身份账号，查询是否有这个用户
		JSONObject userPara = new JSONObject();
		userPara.put("userExtend", uid);
		JSONArray jSONArray = restTemplate.exchange(GET_USER_INFO, HttpMethod.POST, new HttpEntity<String>(userPara.toString(), httpHeaders), JSONArray.class).getBody();
		List<SysUser> userList = JSONObject.parseArray(jSONArray.toJSONString(), SysUser.class);

		SysUser extUser = new SysUser();
		if (userList != null && userList.size() > 0) {
			extUser = userList.get(0);
		} else {
			System.out.println("indexMobileStp----没有此用户");
			return "no_access";
		}

		// 重新登录，覆盖原cookies。cookies中信息都是后续要用的
		httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();

		// 直接登录，默认密码
		requestBody.add("username", extUser.getUserName());
		requestBody.add("password", extUser.getUserPassword());
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);

		ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LOGIN_URL, HttpMethod.POST, entity, JSONObject.class);
		JSONObject retJson = responseEntity.getBody();
		if (retJson == null || retJson.get("token") == null) {
			// 返回权限不足页面
			System.out.println("indexMobileStp----缺少权限");
			return "no_access";
		}
		System.out.println("-----indexStp----------login token:" + retJson.get("token"));

		Cookie cookie = new Cookie("token", retJson.getString("token"));
		cookie.setMaxAge(1 * 60 * 60);// 设置有效期为1天
		cookie.setPath("/");
		response.addCookie(cookie);

		// 获取用户基本信息（token）
		SysUser tokenUser = JwtTokenUtil.getUserFromTokenByValue(retJson.get("token").toString());

		String unitPathId = tokenUser.getUnitPath();

		// 科技部综合计划处
		boolean isZHJHCPerson=EquipmentUtils.getZycbmDic(EquipmentUtils.SYS_FUNCTION_FICTITIOUS, restTemplate, httpHeaders);
		request.setAttribute("isZHJHCPerson", isZHJHCPerson);
		request.setAttribute("sysUserInfo", tokenUser); // tokenUser中有userLevel等基本属性
		
		if (isZHJHCPerson || tokenUser.getUserLevel() == 2) {
			request.getSession().setAttribute("mobileLeader", "true");
		}
		
		List<SysNotice> list = OtherUtil.getSysNoticeTopList(request, restTemplate, httpHeaders);
		request.setAttribute("list", list);
		String nd = HanaUtil.getCurrentYear();
		String month = HanaUtil.getCurrentYearMoth();
		request.setAttribute("nd", nd);
		request.setAttribute("month", month);
		String companyCode = EquipmentUtils.getVirtualDirDeparetCode(EquipmentUtils.SYS_FUNCTION_FICTITIOUS, restTemplate, httpHeaders);
		request.setAttribute("companyCode", companyCode);
		return "/mobile/index";
	}

	/**
	 * 登录认证的接口地址
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/mobile/adToken", method = RequestMethod.POST)
	public String adToken(HttpServletRequest request, HttpServletResponse response) {
		String name = "";
		String pwd = "";
		Map param = request.getParameterMap();
		Enumeration paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			String[] paramValues = request.getParameterValues(paramName);
			//System.out.println("3-----adToken----------:" + paramName);
			if (paramValues != null) {
				//System.out.println("4-----adToken----------:" + paramValues.length);
				for (int i = 0; i < paramValues.length; i++) {
					//System.out.println("5-----adToken----------:" + i + "==============" + paramValues[i]);
				}
			}
		}
		//System.out.println("8都大写-----adToken-Identity_Key---------:" + request.getParameter("Identity_Key"));
		//System.out.println("9都大写-----adToken-Identity_Token---------:" + request.getParameter("Identity_Token"));
		DES3Utils desUtils = new DES3Utils(request.getParameter("Identity_Key"));
		String pKey = desUtils.des3Decode(request.getParameter("Identity_Token"));
		Map<String, String> keymap = desUtils.getAcountByToken(pKey);
		name = keymap.get("username");
		pwd = keymap.get("password");
		String jsonString = JSON.toJSONString(keymap);
		//System.out.println("adToken--------jsonString ==========" + jsonString);
		//System.out.println("12-----adToken----------:" + name + "====" + pwd);
		Cookie c = new Cookie("userInfo", name);
		c.setPath("/");
		response.addCookie(c);
		return "true";
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

	/**
	 * 移动登录界面，测试专用
	 */
	@RequestMapping(value = "/mobile/login")
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
		return "/mobile-login";
	}

	@RequestMapping(value = "/mobile/temIndex")
	public String toIndexPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
				// 登录错误次数
				Cookie loginCookie = new Cookie("loginErrorCount", "0");
				loginCookie.setMaxAge(TIME_OUT);// 设置有效期为一小时
				loginCookie.setPath("/");
				response.addCookie(loginCookie);
				response.sendRedirect("/mobile/login");

				return null;
			}

			Cookie cookie = new Cookie("token", retJson.getString("token"));
			cookie.setMaxAge(TIME_OUT);// 设置有效期为一小时
			cookie.setPath("/");
			response.addCookie(cookie);

			String year = HanaUtil.getCurrentYear();
			request.setAttribute("year", year);

			tokenUser = JwtTokenUtil.getUserFromTokenByValue(retJson.get("token").toString());
			//boolean isZHJHCPerson = EquipmentUtils.isHasUnitCode(unitPathId, EquipmentUtils.KJB_ZHJHC_NUM);
			boolean isZHJHCPerson=EquipmentUtils.getZycbmDic(EquipmentUtils.SYS_FUNCTION_FICTITIOUS, restTemplate, httpHeaders);
			request.setAttribute("isZHJHCPerson", isZHJHCPerson);
			request.setAttribute("sysUserInfo", tokenUser); // tokenUser中有userLevel等基本属性

			if (isZHJHCPerson || tokenUser.getUserLevel() == 2) {
				request.getSession().setAttribute("mobileLeader", "true");
			}
			
			List<SysNotice> list = OtherUtil.getSysNoticeTopList(request, restTemplate, httpHeaders);
			request.setAttribute("list", list);
			String nd = HanaUtil.getCurrentYear();
			String month = HanaUtil.getCurrentYearMoth();
			request.setAttribute("nd", nd);
			request.setAttribute("month", month);
			String companyCode = EquipmentUtils.getVirtualDirDeparetCode(EquipmentUtils.SYS_FUNCTION_FICTITIOUS, restTemplate, httpHeaders);
			request.setAttribute("companyCode", companyCode);
			return "/mobile/index";
		} else {
			if (sysUserInfo == null || sysUserInfo.getUserId() == null) {
				System.out.println("未登录！");
				response.sendRedirect("/mobile-login");

				return null;
			}

			// 用户有哪些菜单权限
			userDetails = this.restTemplate.exchange(USER_DETAILS_URL + sysUserInfo.getUserId(), HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SysUser.class).getBody();

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

			String year = HanaUtil.getCurrentYear();
			request.setAttribute("year", year);

			String unitPathId = sysUserInfo.getUnitPath();
			//boolean isZHJHCPerson = EquipmentUtils.isHasUnitCode(unitPathId, EquipmentUtils.KJB_ZHJHC_NUM);
			boolean isZHJHCPerson=EquipmentUtils.getZycbmDic(EquipmentUtils.SYS_FUNCTION_FICTITIOUS, restTemplate, httpHeaders);
			
			
			request.setAttribute("isZHJHCPerson", isZHJHCPerson);
			request.setAttribute("sysUserInfo", sysUserInfo);
			
			if (isZHJHCPerson || sysUserInfo.getUserLevel() == 2) {
				request.getSession().setAttribute("mobileLeader", "true");
			}
			
			List<SysNotice> list = OtherUtil.getSysNoticeTopList(request, restTemplate, httpHeaders);
			request.setAttribute("list", list);
			String nd = HanaUtil.getCurrentYear();
			String month = HanaUtil.getCurrentYearMoth();
			request.setAttribute("nd", nd);
			request.setAttribute("month", month);
			String companyCode = EquipmentUtils.getVirtualDirDeparetCode(EquipmentUtils.SYS_FUNCTION_FICTITIOUS, restTemplate, httpHeaders);
			request.setAttribute("companyCode", companyCode);
			return "/mobile/index";
		}
	}
}
