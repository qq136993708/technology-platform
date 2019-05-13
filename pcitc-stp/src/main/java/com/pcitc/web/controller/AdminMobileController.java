package com.pcitc.web.controller;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pcitc.base.system.SysUser;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.DES3Utils;
import com.pcitc.web.utils.HanaUtil;

/**
 * @author zhf 系统登录成功后的首页
 */
@Controller
public class AdminMobileController extends BaseController {

	// 访问zuul中的登录方法
	private static final String LOGIN_URL = "http://pcitc-zuul/auth/login";
	private static final String GET_USER_INFO_IP = "http://pcitc-zuul/system-proxy/user-provider/user/get-user-byname/";

	/**
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mobile/indexTest")
	public String indexMobile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String year= HanaUtil.getCurrrentYear();
	    request.setAttribute("year", year);

		return "/mobile/index";
	}
	
	/**
	 * 科技平台统一身份认证移动首页
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/mobile/index")
	public String indexMobileStp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("进入indexMobileStp....");
		
		SysUser rsUser = new SysUser();
		String token = request.getParameter("Identity_Token");
		DES3Utils desUtils = new DES3Utils("01qaz2wsx3edc4rfv5tgb6yhn");
		System.out.println("indexMobileStp==========" + token);
		String key1 = desUtils.des3Decode0(token);
		Map keymap = desUtils.getAcountByToken0(key1);
		String username = keymap.get("username").toString();
		
		System.out.println("username ==========" + username);
		/*ResponseEntity<SysUser> rsEntity = this.restTemplate.exchange(GET_USER_INFO_IP + username, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), SysUser.class);
		rsUser = rsEntity.getBody();
		if (rsUser != null) {
			// 用户有哪些菜单权限
			request.setAttribute("userInfo", rsUser);
		} else {
			// 返回权限不足页面
			System.out.println("LogonController----缺少权限");
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
		response.addCookie(cookie);*/

		return "/mobile/index";
	}

	@RequestMapping(value = "/mobile/adToken", method = RequestMethod.POST)
	public String adToken(HttpServletRequest request, HttpServletResponse response) {
		String name = "";
		String pwd = "";
		System.out.println("1-----adToken----------:" + request + "====" + response);
		Map param = request.getParameterMap();
		System.out.println("2-----adToken----------:" + param.isEmpty());
		System.out.println("3-----adToken----------:" + request.getParameterNames());
		System.out.println("4-----adToken----------:" + request.getParameter("identity_token"));
		System.out.println("5-----adToken----------:" + request.getParameter("identity_key"));
		Enumeration paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			StringBuffer sb = new StringBuffer();
			sb.append("adToken :---->").append(paramName);
			String[] paramValues = request.getParameterValues(paramName);
			System.out.println("5-----adToken----------:" + paramName);
			if (paramValues != null) {
				System.out.println("6-----adToken----------:" + paramValues.length);
				for (int i = 0; i < paramValues.length; i++) {
					System.out.println("7-----adToken----------:" + i + "==============" + paramValues[i]);
				}
			}
			System.out.println("5-----adToken----------:" + sb);
		}
		System.out.println("8-----adToken----------:" + request.getParameter("Identity_Key"));
		System.out.println("9-----adToken----------:" + request.getParameter("Identity_Token"));
		DES3Utils desUtils = new DES3Utils(request.getParameter("Identity_Key"));
		String pKey = desUtils.des3Decode(request.getParameter("Identity_Token"));
		Map<String, String> keymap = desUtils.getAcountByToken(pKey);
		name = keymap.get("username");
		pwd = keymap.get("password");
		
		System.out.println("2-----adToken----------:" + name + "====" + pwd);
		Cookie c = new Cookie("userInfo", name);
		c.setPath("/");
		response.addCookie(c);
		return "true";
	}
}
