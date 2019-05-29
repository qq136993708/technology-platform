package com.pcitc.web.controller;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.system.SysUser;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.utils.DES3Utils;
import com.pcitc.web.utils.EquipmentUtils;
import com.pcitc.web.utils.HanaUtil;

/**
 * @author zhf 系统登录成功后的首页
 */
@Controller
public class AdminMobileController extends BaseController {

	// 访问zuul中的登录方法
	private static final String	LOGIN_URL			= "http://pcitc-zuul/auth/login";
	private static final String	GET_USER_INFO_IP	= "http://pcitc-zuul/system-proxy/user-provider/user/get-user-byname/";

	/**
	 * 移动本地测试方法
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mobile/indexTest")
	public String indexMobile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String year = HanaUtil.getCurrrentYear();
		request.setAttribute("year", year);

		String unitPathId = sysUserInfo.getUnitPath();
		boolean isKJBPerson = EquipmentUtils.isKJBPerson(unitPathId);
		request.setAttribute("isKJBPerson", isKJBPerson);

		return "/mobile/index";
	}

	/**
	 * 科技平台统一身份认证移动首页
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/mobile/index")
	public String indexMobileStp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("1进入indexMobileStp....");
		System.out.println("2进入indexMobileStp...."+request.getParameter("Identity_Key"));
		String token = request.getParameter("Identity_Token");
		DES3Utils desUtils = new DES3Utils("01qaz2wsx3edc4rfv5tgb6yhn");
		
		String key1 = desUtils.des3Decode0(token);
		Map keymap = desUtils.getAcountByToken0(key1);
		String username = keymap.get("username").toString();
		System.out.println("username =========="+username);
		
		String jsonString = JSON.toJSONString(keymap);
		System.out.println("jsonString =========="+jsonString);
		// 重新登录，覆盖原cookies。cookies中信息都是后续要用的
		httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();

		// 直接登录，默认密码
		requestBody.add("username", username);
		requestBody.add("password", "2cbb78c76ed2edecca69b7d6c0e0e578");
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);

		ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LOGIN_URL, HttpMethod.POST, entity, JSONObject.class);
		JSONObject retJson = responseEntity.getBody();
		if (retJson==null||retJson.get("token")==null) {
			// 返回权限不足页面
			System.out.println("indexMobileStp----缺少权限");
			return "no_access";
		}
		System.out.println("-----indexStp----------login token:"+retJson.get("token"));

		Cookie cookie = new Cookie("token", retJson.getString("token"));
		cookie.setMaxAge(1*60*60);// 设置有效期为1天
		cookie.setPath("/");
		response.addCookie(cookie);

		// 获取用户基本信息（token）
		SysUser tokenUser = JwtTokenUtil.getUserFromTokenByValue(retJson.get("token").toString());

		String unitPathId = tokenUser.getUnitPath();
		boolean isKJBPerson = EquipmentUtils.isKJBPerson(unitPathId);
		request.setAttribute("isKJBPerson", isKJBPerson);

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
		System.out.println("1-----adToken----------:"+param.isEmpty());
		System.out.println("2-----adToken----------:"+request.getParameterNames());
		Enumeration paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			String[] paramValues = request.getParameterValues(paramName);
			System.out.println("3-----adToken----------:"+paramName);
			if (paramValues!=null) {
				System.out.println("4-----adToken----------:"+paramValues.length);
				for (int i = 0; i<paramValues.length; i++) {
					System.out.println("5-----adToken----------:"+i+"=============="+paramValues[i]);
				}
			}
		}
		System.out.println("6都小写-----adToken-identity_token---------:"+request.getParameter("identity_token"));
		System.out.println("7都小写-----adToken-identity_key---------:"+request.getParameter("identity_key"));
		System.out.println("8都大写-----adToken-Identity_Key---------:"+request.getParameter("Identity_Key"));
		System.out.println("9都大写-----adToken-Identity_Token---------:"+request.getParameter("Identity_Token"));
		System.out.println("10开头大写-----adToken-Identity_key---------:"+request.getParameter("Identity_key"));
		System.out.println("11开头大写-----adToken-Identity_token---------:"+request.getParameter("Identity_token"));
		DES3Utils desUtils = new DES3Utils(request.getParameter("Identity_Key"));
		String pKey = desUtils.des3Decode(request.getParameter("Identity_Token"));
		Map<String, String> keymap = desUtils.getAcountByToken(pKey);
		name = keymap.get("username");
		pwd = keymap.get("password");

		System.out.println("12-----adToken----------:"+name+"===="+pwd);
		Cookie c = new Cookie("userInfo", name);
		c.setPath("/");
		response.addCookie(c);
		return "true";
	}
}
