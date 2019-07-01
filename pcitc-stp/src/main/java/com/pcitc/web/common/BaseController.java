package com.pcitc.web.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import com.pcitc.base.system.SysUser;

import java.util.UUID;

/**
 * @author:Administrator
 * @date:2018/5
 */
@Controller
public class BaseController implements ErrorController
{

    @Autowired
    public HttpServletRequest request;

    @Autowired
    public HttpServletResponse response;

    @Autowired
    public RestTemplate restTemplate;

    @Autowired
    public HttpHeaders httpHeaders;
    
    public Logger logger = LoggerFactory.getLogger(getClass());
    
    public SysUser sysUserInfo;

	public void setUserProfile(SysUser sysUser) {
		this.sysUserInfo = sysUser;
	}
	
	public SysUser getUserProfile() {
		return sysUserInfo;
	}

	@Override
	public String getErrorPath() 
	{
		return "global_error";
	}

//    public HttpHeaders getHttpHeaders() {
//        return httpHeaders;
//    }
//
//    public void setHttpHeaders(HttpHeaders httpHeaders) {
//        String token = request.getHeader("access-token");
//        httpHeaders.set("Authorization", "Bearer " + token);
//        System.out.println(token);
//        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
//        this.httpHeaders = httpHeaders;
//    }
    /**
     * 初始化数据绑定
     * 1. 将所有传递进来的String进行HTML编码，防止XSS攻击
     * 2. 将字段中Date类型转换为String类型
     */
//    @InitBinder
//    protected void initBinder(WebDataBinder binder) {
//        // String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击
//        binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
//            @Override
//            public void setAsText(String text) {
//                setValue(text == null ? null : StringEscapeUtils.escapeHtml4(text.trim()));
//            }
//
//            @Override
//            public String getAsText() {
//                Object value = getValue();
//                return value != null ? value.toString() : "";
//            }
//        });
    // Date 类型转换
//        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
//            @Override
//            public void setAsText(String text) {
//                setValue(DateUtils.parseDate(text));
//            }
//			@Override
//			public String getAsText() {
//				Object value = getValue();
//				return value != null ? DateUtils.formatDateTime((Date)value) : "";
//			}
//        });
//    }
}
