package com.pcitc.web.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import com.pcitc.base.common.Result;
import com.pcitc.base.system.SysReqLogs;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.DateUtil;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Date;
import java.util.Map;
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
    
    private SysUser sysUserInfo;

	public void setUserProfile(SysUser sysUser) {
		this.sysUserInfo = sysUser;
	}
	
	public SysUser getUserProfile() {
		return sysUserInfo;
	}


	/**
	 * 返回当前Request对象
	 * @return
	 */
	protected HttpServletRequest getCurrentRequest()
	{
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	/**
	 * 返回当前Response对象
	 * @return
	 */
	protected HttpServletResponse getCurrentResponse()
	{
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
	}

	protected void setParam(Map<String, Object> params, String key, Object value) {
		this.setParam(params, key, value, false);
	}

	protected void setParam(Map<String, Object> params, String key, Object value, boolean like) {
		if (value != null) {
			params.put(key, like ? "?" + value : value);
		}
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
	public void addReqLog(Object obj,String data,String desc) 
	{
		try 
		{
			String uri = request.getRequestURI();
			String reqType = request.getMethod();
			String host = request.getRemoteHost();
			
			String userId = sysUserInfo == null ? null : sysUserInfo.getUserId();
			String ctime = DateUtil.format(new Date(), DateUtil.FMT_SSS);
			
			
			
			SysReqLogs bean = new SysReqLogs();
			bean.setClassName(data);
			bean.setHost(host);
			bean.setMethodName(desc);
			bean.setUri(uri);
			bean.setUserId(userId);
			bean.setLogTime(ctime);
			bean.setProcessTime(0);
			bean.setStartTime("0");
			bean.setEndTime("0");
			bean.setReqType(reqType);
			bean.setServerHost("");

			HttpEntity<SysReqLogs> entity = new HttpEntity<SysReqLogs>(bean, httpHeaders);
			String LOG_CLIENT = "http://kjpt-zuul/system-proxy/sys-provider/processlogs/process-logs-save";
			restTemplate.exchange(LOG_CLIENT, HttpMethod.POST, entity, Result.class).getBody();
		}catch(Exception e) 
		{
			
		}
		
	}
}
