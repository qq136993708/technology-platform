package com.pcitc.web.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.eetrust.security.MessageConstants;
import com.eetrust.security.SIDPlugin;
import com.pcitc.base.system.SysLog;
import com.pcitc.base.util.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.Result;
import com.pcitc.base.system.SysCollect;
import com.pcitc.base.system.SysFunction;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.system.SysUserProperty;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.MD5Util;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.common.OperationFilter;
import com.pcitc.web.common.SessionShare;
import com.pcitc.web.test.OAAPIRestFul;
import com.pcitc.web.utils.EquipmentUtils;
import com.pcitc.web.utils.HanaUtil;

/**
 * @author zhf 系统登录成功后的首页
 */
@Controller
public class AdminController extends BaseController {

    // 访问zuul中的登录方法
    private static final String LOGIN_URL = "http://kjpt-zuul/auth/login";
    private static final String USER_DETAILS_URL = "http://kjpt-zuul/system-proxy/user-provider/user/user-details/";
    private static final String USER_IDENTITY_ID = "http://kjpt-zuul/system-proxy/user-provider/user/user-identityid/";
    private static final String GET_USER_INFO = "http://kjpt-zuul/system-proxy/user-provider/user/get-user-byname/";

    // 已办任务数
    private static final String DONE_TASK_COUNT = "http://kjpt-zuul/system-proxy/task-provider/done-task-count";
    // 待办任务数
    private static final String PENDING_TASK_COUNT = "http://kjpt-zuul/system-proxy/task-provider/pending-task-count";


    // 收藏菜单
    private static final String COLLECT_FUNCTION = "http://kjpt-zuul/system-proxy/syscollect-provider/sys_collect/add";


    @Value("${serverIp}")
    private String serverIp;

    @Value("${serverPort}")
    private int serverPort;

    @Value("${licenseKey}")
    private String licenseKey;

    @Value("${loginType}")
    private String loginType;

    @Value("${sosPortlURL}")
    private String sosPortlURL;


    private Integer TIME_OUT = 1 * 60 * 60;


    @RequestMapping(value = "/login")
    public String pcitcToIndexPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //判断当前是否为秘钥单点登录配置，是的话直接跳转到单点认证页面
        if (loginType != null && loginType.trim().equals("1")) {
            return "redirect:" + sosPortlURL;
        }
        request.setAttribute("ssoOortlUrl", sosPortlURL);
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


    /**
     * 通过socket协议，5556端口连接CA平台，适用于中核集团
     *
     * @param ticket
     * @param model
     * @return
     */
    @RequestMapping(value = {"/sso"}, method = RequestMethod.GET)
    public String sso(String ticket, Model model) {
        if (ticket != null && !ticket.isEmpty()) {
            SIDPlugin sid = new SIDPlugin(serverIp, serverPort);
            int ret = sid.SSO_VerifyTicket(licenseKey, ticket);
            if (ret != MessageConstants.SECURITY_SERVICE_SUCCESS) {
                // 验证失败
                return null;
            } else {
                // 验证成功
                String unifyIdentityId = sid.getPassport();
                SysUser userDetails = new SysUser();
                userDetails.setUnifyIdentityId(unifyIdentityId);
                ResponseEntity<String> userDetailsString = restTemplate.exchange(USER_IDENTITY_ID, HttpMethod.POST, new HttpEntity<SysUser>(userDetails, httpHeaders), String.class);
                userDetailsString.getBody();
                String sysuserString = userDetailsString.getBody();

                JSONObject strJson = JSONObject.parseObject(sysuserString);
                String userId = strJson.getString("userId");

                // 用户有哪些菜单权限
                userDetails = this.restTemplate.exchange(USER_DETAILS_URL + userId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SysUser.class).getBody();
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

                request.setAttribute("userId", userDetails.getUserId());

                if (userName.equals(Constant.LOG_SYSTEMADMIN) || userName.equals(Constant.LOG_SECURITYADMIN) || userName.equals(Constant.LOG_AUDITADMIN)) {
                    request.setAttribute("userName", userName);
                    return "/adminIndex";
                } else {
                    return "/index";
                }
            }
        }
        return "index";
    }

    @RequestMapping(value = "/index")
    public String toIndexPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SysUser sysUserInfo = getUserProfile();
        SysUser userDetails = new SysUser(); // 用户信息，包含此人拥有的菜单权限等。token中放不下这些信息
        SysUser tokenUser = new SysUser();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //如果是从登录过来的
        if (username != null && password != null) {
            System.out.println("\n\n\n------从登录过来的用户名：" + username + "\n\n\n");
            httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            MultiValueMap<String, String> valueMap = new LinkedMultiValueMap<String, String>();
            valueMap.add("username", username);
            valueMap.add("password", MD5Util.MD5Encode(password));
            //从数据库中查到 然后返回 TOKEN
            HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(valueMap, this.httpHeaders);
            ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LOGIN_URL, HttpMethod.POST, entity, JSONObject.class);
            JSONObject retJson = responseEntity.getBody();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
            // 获取的token有问题(用户名或密码不正确) 返回登录
            if (retJson == null || retJson.get("token") == null) {
            	Integer errorNumber=setErrorNumber(username);
                // 登录错误次数
                Cookie loginCookie = new Cookie("loginErrorCount", String.valueOf(errorNumber));
                loginCookie.setMaxAge(TIME_OUT);// 设置有效期为一小时
                loginCookie.setPath("/");
                response.addCookie(loginCookie);
                response.sendRedirect("/login");
                return null;
            }
            //token保存到Cookie
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
			/*
			 * if (userDetails.getLoginErrorNumber() != null &&
			 * userDetails.getLoginErrorNumber() > 0) { userDetails.setLoginErrorNumber(0);
			 * this.restTemplate.exchange(UPD_USER_INFO, HttpMethod.POST, new
			 * HttpEntity<SysUser>(userDetails, this.httpHeaders), Integer.class); }
			 */

            request.setAttribute("funList", funList);
            request.setAttribute("grgztList", grgztList);
            request.setAttribute("upList", upList);
            request.setAttribute("userInfo", userDetails);

            Cookie loginCookie = new Cookie("loginErrorCount", null);
            loginCookie.setMaxAge(0);// 设置过期
            loginCookie.setPath("/");
            response.addCookie(loginCookie);


            // 登录成功,保存当前用户登录的sessionId, 一个用户只能一处登录
			/*String sessionID = request.getRequestedSessionId();
			String userName = userDetails.getUserName();
			if (!SessionShare.getSessionIdSave().containsKey(userName)) {
				SessionShare.getSessionIdSave().put(userName, sessionID);
			} else if (SessionShare.getSessionIdSave().containsKey(userName) && !sessionID.equals(SessionShare.getSessionIdSave().get(userName))) {
				SessionShare.getSessionIdSave().remove(userName);
				SessionShare.getSessionIdSave().put(userName, sessionID);
			}*/
            setLastLogin(tokenUser.getUserId());
            request.setAttribute("userId", userDetails.getUserId());
            if (username.equals(Constant.LOG_SYSTEMADMIN) || username.equals(Constant.LOG_SECURITYADMIN) || username.equals(Constant.LOG_AUDITADMIN)) {
                request.setAttribute("userName", username);
                return "/adminIndex";
            } else {
                return "/index";
            }
        } else {

            if (sysUserInfo == null || sysUserInfo.getUserId() == null) {
                System.out.println("未登录！");
                response.sendRedirect("/login");
                return null;
            }

            System.out.println("\n\n\n------从TOKEN过来的用户名：" + sysUserInfo.getUserDisp() + "\n\n\n");
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

            request.setAttribute("userId", userDetails.getUserId());

            if (userName.equals(Constant.LOG_SYSTEMADMIN) || userName.equals(Constant.LOG_SECURITYADMIN) || userName.equals(Constant.LOG_AUDITADMIN)) {
                request.setAttribute("userName", userName);
                return "/adminIndex";
            } else {
                return "/index";
            }
        }
    }


    @RequestMapping(value = "/instituteRedrect")
    public String instituteRedrect(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String url = CommonUtil.getParameter(request, "url", "");
        request.setAttribute("url", url);

        url = java.net.URLDecoder.decode(request.getParameter("url"), "UTF-8");// 名称检索条件
        return url;
    }


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
        SysUser sysUserInfo = getUserProfile();
        // 获取通知
        request.setAttribute("taskCount", request.getParameter("taskCount"));

        String nd = HanaUtil.getCurrentYear();
        request.setAttribute("nd", nd);
        String month = HanaUtil.getCurrentYearMoth();
        request.setAttribute("month", month);
        String unitCode = sysUserInfo.getUnitCode();
        request.setAttribute("unitCode", unitCode);


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
        SysUser sysUserInfo = getUserProfile();
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
        SysUser sysUserInfo = getUserProfile();
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


    @RequestMapping(value = "/logout")
    @ResponseBody
    @OperationFilter(modelName = "系统管理", actionName = "登出操作")
    public Object sysLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Cookie cookie = new Cookie("token", null);
        cookie.setMaxAge(0);// 立即失效
        cookie.setPath("/");
        response.addCookie(cookie);

		/*//判断是生产环境还是测试环境
		Set<String> serverHosts = HostUtil.getLocalHostAddressSet();
		Set<String> stpServerHosts = new HashSet<String>(Arrays.asList(SysConstant.STP_SERVER_HOST.split(",")));
		serverHosts.retainAll(stpServerHosts);
		if(serverHosts.size()>0) {
			return new Result(true, "logout","./SSO/GLO/Redirect");
		}*/
        return new Result(true, "logout", "/login");
    }

    @RequestMapping(value = "/admin/collect")
    @ResponseBody
    @OperationFilter(modelName = "系统管理", actionName = "收藏操作")
    public Object saveCollectFunction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SysUser sysUserInfo = getUserProfile();
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
    
    

    
    
    
   public void setLastLogin(String  userId)throws Exception 
   {
	   SysUser userIpAndDate= EquipmentUtils.getSysUser(userId, restTemplate, httpHeaders);
       userIpAndDate.setLastLoginIp(EquipmentUtils.getRemoteHost(request));
       //存储登录时间
       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
       String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
       userIpAndDate.setLastLoginDate(date);
       EquipmentUtils.updateSysUser(userIpAndDate, restTemplate, httpHeaders);
   }
    
   public Integer setErrorNumber(String  userId)throws Exception 
   {
	      Integer  errorNumber =0;
	   
	       SysUser rsUser= EquipmentUtils.getSysUser(userId, restTemplate, httpHeaders);
	       if(rsUser!=null)
	       {
	    	   errorNumber = rsUser.getLoginErrorNumber() == null ? 1 : rsUser.getLoginErrorNumber() + 1;
		       rsUser.setLoginErrorNumber(errorNumber);
		       EquipmentUtils.updateSysUser(rsUser, restTemplate, httpHeaders);
	       }
	       return errorNumber;
   }
	
  


}
