package com.pcitc.web.common;

import com.pcitc.base.common.ExcelException;
import com.pcitc.base.common.Result;
import com.pcitc.base.system.SysReqLogs;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.controller.scientificplan.SciencePlanApiController;
import com.pcitc.web.utils.PoiExcelExportUitl;
import com.pcitc.web.utils.SciencePlanPoiExcelUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author:Administrator
 * @date:2018/5
 */
@Controller
public class BaseController implements ErrorController
{
	/**
	 * 查询白名单
	 */
	private static final String WHITE_LIST = "http://kjpt-zuul/system-proxy/user-provider/whiteList/";

	private static final String WHITE_LIST_KEY = "isWhiteList";

	@Value("${whiteRoleId}")
	private String roleId;
//    @Autowired
//    public HttpServletRequest request;
//
//    @Autowired
//    public HttpServletResponse response;

	@Autowired
	protected RestTemplate restTemplate;

	@Autowired
	public HttpHeaders httpHeaders;

	public Logger logger = LoggerFactory.getLogger(getClass());

	//public SysUser sysUserInfo;

//	public void setUserProfile(SysUser sysUser) {
//		this.sysUserInfo = sysUser;
//	}

	public SysUser getUserProfile() {
		SysUser sysUser=(SysUser)this.getCurrentRequest().getSession().getAttribute("sysUser");
		/*
		 * String token = ""; Cookie[] cookies = getCurrentRequest().getCookies();
		 * if(cookies!=null) { for (Cookie c : cookies) { c.setHttpOnly(true); if
		 * ("token".equalsIgnoreCase(c.getName()) && !StringUtils.isBlank(c.getValue()))
		 * { token = c.getValue(); break; } }
		 * sysUser=JwtTokenUtil.getUserFromTokenByValue(token); }
		 */

		return sysUser;
	}


	public void setBaseParam(Map condition){
		SysUser sysUserInfo = this.getUserProfile();
		this.setParam(condition,"userSecretLevel",sysUserInfo.getSecretLevel());
		this.setParam(condition,"userName",sysUserInfo.getUserName());


		if(this.getCurrentRequest().getSession().getAttribute(sysUserInfo.getUserName()) == null){
			setIsWhiteList();
		}

		this.setParam(condition,"skipKnowledgeScope",this.getCurrentRequest().getSession().getAttribute(sysUserInfo.getUserName()));
	}

	public void setIsWhiteList(){
		//是否是白名单 0否1是
		String isWhiteList = "0";
		SysUser sysUserInfo = this.getUserProfile();
		String role = sysUserInfo.getUserRole();
		if(StringUtils.isBlank(role)){
			return;
		}
		String userName = sysUserInfo.getUserName();
		//Map param = new HashMap(2);
		//param.put("userName",userName);
		//ResponseEntity<Integer> response = restTemplate.exchange(WHITE_LIST+userName, HttpMethod.GET,new HttpEntity<>(this.httpHeaders),Integer.class);
		if(role.contains(roleId)){
			isWhiteList = "1";
		}
		this.getCurrentRequest().getSession().setAttribute(userName,isWhiteList);
	}

	public void checkIsWhiteList(Map param){
		/*
		if(!"1".equals(param.get("skipKnowledgeScope"))){
			SysException sys = new SysException("非白名单账号，无权查看数据！");
			sys.setCode("-1");
			throw sys;
		}
		*/
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
			HttpServletRequest request = getCurrentRequest();
			String uri = request.getRequestURI();
			String reqType = request.getMethod();
			String host = request.getRemoteHost();

			SysUser su = getUserProfile();
			String userId = su == null ? null : su.getUserId();
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

	public void exportExcel(String[] headers, String[] cols, String fileName, List dataList) throws Exception {
		HttpServletResponse response =  this.getCurrentResponse();
		response.reset();
//		response.setCharacterEncoding("ISO8859-1");
		response.setContentType("application/vnd.ms-excel");
		fileName = URLEncoder.encode(fileName + ".xls", "UTF-8");
		//response.setHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO8859-1") + ".xls");
		response.setHeader("Content-disposition", "attachment;filename=" + fileName);
		try {
			OutputStream os = response.getOutputStream();

			if( this instanceof SciencePlanApiController){
				SciencePlanPoiExcelUtil scienpee = new SciencePlanPoiExcelUtil<Object>(fileName, headers, cols, dataList,3,os);
				scienpee.exportExcel();
			}else{
				PoiExcelExportUitl<Object> pee = new PoiExcelExportUitl<Object>(fileName, headers, cols, dataList,os);
				pee.exportExcel();
			}



		} catch (Exception e)
		{
			e.printStackTrace();
			// 如果是ExcelException,则直接抛出
			if (e instanceof ExcelException)
			{
				throw (ExcelException) e;
			} else
			{
				// 否则将其他异常包装成ExcelException再抛出
				throw new ExcelException("导出excel失败");
			}
		}
	}
}
