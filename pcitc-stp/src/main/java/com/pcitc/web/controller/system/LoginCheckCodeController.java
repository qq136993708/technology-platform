package com.pcitc.web.controller.system;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.pcitc.base.common.Result;
import com.pcitc.base.system.SysUser;
import com.pcitc.web.common.BaseController;

@Controller
public class LoginCheckCodeController extends BaseController {

	private static final String GET_USER_INFO = "http://pcitc-zuul/system-proxy/user-provider/user/get-user-byname/";
	private static final String UPD_USER_INFO = "http://pcitc-zuul/system-proxy/user-provider/user/update-user";
	
	@Autowired
	DefaultKaptcha defaultKaptcha;
	
	@ResponseBody
	@RequestMapping("/check_login_code")
	public Object checkLoginCode(
			@RequestParam(value="username", required=true)String username,
			@RequestParam(value="vercode", required=true)String vercode,
			HttpServletRequest httpServletRequest, 
			HttpServletResponse httpServletResponse)throws Exception {
		ResponseEntity<SysUser> rsEntity = this.restTemplate.exchange(GET_USER_INFO+username, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SysUser.class);
    	SysUser rsUser = rsEntity.getBody();
    	if(rsUser == null) {
    		return new Result(false,"验证码不正确！"); 
    	}
    	if(rsUser.getLoginCheckCode().equalsIgnoreCase(vercode)) {
    		return new Result(true,"");
    	}else {
    		return new Result(false,"");
    	}
	}
	@RequestMapping("/create_login_check_code")
	public void defaultKaptcha(@RequestParam(value="username", required=false)String username,HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {
		
		byte[] captchaChallengeAsJpeg = null;
		ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
		try {
			
			ResponseEntity<SysUser> rsEntity = this.restTemplate.exchange(GET_USER_INFO+username, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SysUser.class);
	    	SysUser rsUser = rsEntity.getBody();
	    	// 生产验证码字符串并保存到数据库中
	    	String createText = defaultKaptcha.createText();
	    	rsUser.setLoginCheckCode(createText);
	    	httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
    		this.restTemplate.exchange(UPD_USER_INFO, HttpMethod.POST, new HttpEntity<SysUser>(rsUser, this.httpHeaders), Integer.class);
			//httpServletRequest.getSession().setAttribute("vrifyCode", createText);
			// 使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
			BufferedImage challenge = defaultKaptcha.createImage(createText);
			ImageIO.write(challenge, "jpg", jpegOutputStream);
		} catch (IllegalArgumentException e) {
			httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		// 定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
		captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
		httpServletResponse.setHeader("Cache-Control", "no-store");
		httpServletResponse.setHeader("Pragma", "no-cache");
		httpServletResponse.setDateHeader("Expires", 0);
		httpServletResponse.setContentType("image/jpeg");
		ServletOutputStream responseOutputStream = httpServletResponse.getOutputStream();
		responseOutputStream.write(captchaChallengeAsJpeg);
		responseOutputStream.flush();
		responseOutputStream.close();
	}

}
