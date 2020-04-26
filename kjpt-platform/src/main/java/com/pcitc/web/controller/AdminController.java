package com.pcitc.web.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.eetrust.security.MessageConstants;
import com.eetrust.security.SIDPlugin;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.Result;
import com.pcitc.base.system.SysCollect;
import com.pcitc.base.system.SysFunction;
import com.pcitc.base.system.SysRole;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.MD5Util;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.common.OperationFilter;
import com.pcitc.web.test.OAAPIRestFul;
import com.pcitc.web.utils.EquipmentUtils;

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

    @Value("${whiteRoleId}")
    private String roleId;

    @Value("${proxy.url}")
    String proxyUrl;

    private Integer TIME_OUT = 1 * 60 * 60;



    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request) throws Exception
    {
        SysUser sysUser=(SysUser)request.getSession().getAttribute("sysUser");
        if(sysUser!=null)
        {
            boolean isWhite = is_White(sysUser);
            if(isWhite)
            {
                return "redirect:/jsc_web/index.html";
            }else
            {
                return "/login";
            }
        }else
        {
            return "/login";
        }

    }


    @RequestMapping(value = "/login_submit")
    public String login_submit(HttpServletResponse response,HttpServletRequest request,@RequestParam(value="username", required = false) String username,
                               @RequestParam(value="password", required = false) String password,
                               @RequestParam(value="error", required = false) String error) throws Exception
    {


        System.out.println("===========login_submit=password="+password+"    MD5Encode "+MD5Util.MD5Encode(password));
        SysUser sysUser= EquipmentUtils.getUserByUserNameAndPassword(username, MD5Util.MD5Encode(password), restTemplate, httpHeaders);
        if(sysUser!=null)
        {
            request.getSession().setAttribute("sysUser", sysUser);
            System.out.println("===========login_submit=getUnifyIdentityId="+sysUser.getUnifyIdentityId());
            String userName=sysUser.getUserName();
            boolean isWhite = is_White(sysUser);
            if (userName.equals(Constant.LOG_SYSTEMADMIN) || userName.equals(Constant.LOG_SECURITYADMIN) || userName.equals(Constant.LOG_AUDITADMIN)) {
                request.setAttribute("userName", userName);
                return "/adminIndex";
            } else if(isWhite)
            {
                return "redirect:/jsc_web/index.html";
            }else
            {
                return "/login";
            }
        }else
        {
            request.setAttribute("err", "用户名密码错误");
            return "/login";
        }


    }


    //判断当前是否为秘钥单点登录配置，是的话直接跳转到单点认证页面
   /* @RequestMapping(value = "/login")
    public String login(@RequestParam(value="username", required = false) String userName,
                        @RequestParam(value="password", required = false) String password,
                        @RequestParam(value="error", required = false) String error) throws Exception {

        if (loginType != null && loginType.trim().equals("1")) {
            return "redirect:" + sosPortlURL;
        }

        HttpServletRequest request = this.getCurrentRequest();
        request.setAttribute("ssoOortlUrl", sosPortlURL);

        if("ssoError1".equals(error)) {
            request.setAttribute("err", "统一身份认证失败");
        } else if("ssoError2".equals(error)){
            request.setAttribute("err", "未知用户，尚未在本系统注册");
        }

        if(userName == null) {
            return "/login";
        }

        boolean result = buildTokenByPassword(userName, MD5Util.MD5Encode(password));
        boolean isWhite = isWhite(userName, MD5Util.MD5Encode(password));
        if(isWhite){
            return "redirect:/jsc_web/index.html";
        }
        if(result) {
            return "redirect:/index";
        }else {
            request.setAttribute("err", "用户名密码错误");
            return "/login";
        }

    }*/



    @RequestMapping(value = "/loginSave")
    @ResponseBody
    public Result loginSave(HttpServletRequest request) throws Exception {

        String password=CommonUtil.getParameter(request, "password", "");
        String username=CommonUtil.getParameter(request, "username", "");

        Result resultsDate = new Result();
        if(username == null || password==null)
        {
            resultsDate.setSuccess(false);
            resultsDate.setMessage("");
        }
        return resultsDate;
    }

    private boolean isWhite(String userName, String password){
        if(userName == null) {
            return false;
        }
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> valueMap = new LinkedMultiValueMap<String, String>();
        valueMap.add("username", userName);
        valueMap.add("password", password);
        //从数据库中查到 然后返回 TOKEN
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(valueMap, this.httpHeaders);
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LOGIN_URL, HttpMethod.POST, entity, JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        // 获取的token有问题(用户名或密码不正确) 返回登录
        if (retJson == null || retJson.get("token") == null) {
            return false;
        }
        String token = retJson.getString("token");
        SysUser su = JwtTokenUtil.getUserFromTokenByValue(token);
        String role = su.getUserRole();
        if(StringUtils.isBlank(role)){
            return false;
        }
        if(role.contains(roleId)){
            return true;
        }
        return false;
    }



    private boolean is_White(SysUser su){
        String role = su.getUserRole();
        if(StringUtils.isBlank(role)){
            return false;
        }
        if(role.contains(roleId)){
            return true;
        }
        return false;
    }


    private boolean buildTokenByPassword(String userName, String password) {

        if(userName == null) {
            return false;
        }
        HttpServletResponse response = this.getCurrentResponse();

        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> valueMap = new LinkedMultiValueMap<String, String>();
        valueMap.add("username", userName);
        valueMap.add("password", password);
        //从数据库中查到 然后返回 TOKEN
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(valueMap, this.httpHeaders);
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LOGIN_URL, HttpMethod.POST, entity, JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        // 获取的token有问题(用户名或密码不正确) 返回登录
        if (retJson == null || retJson.get("token") == null) {
            return false;
        }
        //token保存到Cookie
        Cookie cookie = new Cookie("token", retJson.getString("token"));
        cookie.setMaxAge(-1);// 设置有效期为一小时
        cookie.setPath("/");
        response.addCookie(cookie);
        return true;
    }

    /**
     * 密网--通过socket协议，5556端口连接CA平台，适用于中核集团
     */
    @RequestMapping(value = {"/mw_sso"}, method = RequestMethod.GET)
    public String mw_sso(@RequestParam(value="ticket", required = false) String ticket) throws IOException {

        HttpServletResponse response = this.getCurrentResponse();

        if(StringUtils.isEmpty(ticket)) {
            // 验证失败
            // response.sendRedirect("/login?error=ssoError1");
            //return;
            return "redirect:/login?error=ssoError1";
        }

        SIDPlugin sid = new SIDPlugin(serverIp, serverPort);
        int ret = sid.SSO_VerifyTicket(licenseKey, ticket);
        if (ret != MessageConstants.SECURITY_SERVICE_SUCCESS) {
            // 验证失败
            //response.sendRedirect("/login?error=ssoError1");
            //return;
            return "redirect:/login?error=ssoError1";

        }
        // 验证成功
        String unifyIdentityId = sid.getPassport();
        SysUser userDetails = new SysUser();
        userDetails.setUnifyIdentityId(unifyIdentityId);

        ResponseEntity<SysUser> userDetailsString = this.restTemplate.exchange(USER_IDENTITY_ID, HttpMethod.POST, new HttpEntity<SysUser>(userDetails, httpHeaders), SysUser.class);
        userDetailsString.getBody();
        userDetails = userDetailsString.getBody();

        if(userDetails == null) {
            // 验证失败
            //response.sendRedirect("/login?error=ssoError2");
            return "redirect:/login?error=ssoError2";
            // return;
        }

        boolean result = this.buildTokenByPassword(userDetails.getUserName(), userDetails.getUserPassword());

        if(result) {
            //response.sendRedirect("/index");
            return "redirect:/index";
        } else {
            //response.sendRedirect("/login");
            return "redirect:/login";
        }

    }


//    @RequestMapping(value = "/")
//    public String inddex() throws IOException {
//
//    	this.getCurrentResponse().sendRedirect(proxyUrl + "index");
//    	System.out.println("redirect index");
//    	return null;
//    	//return "redirect:/index";
//    }

    /**
     *商网
     */
    @RequestMapping(value = {"/sw_sso"})
    public String sw_sso(HttpServletRequest request,HttpServletResponse response)throws Exception {

        String unifyIdentityId=EquipmentUtils.getSwSSOToken(request, response);
        System.out.println("============sw_sso unifyIdentityId: "+unifyIdentityId);
        if(unifyIdentityId!=null  &&  !unifyIdentityId.equals(""))
        {
            //JWT
            //EquipmentUtils.buildTokenByIdentityId(unifyIdentityId, restTemplate, httpHeaders,response);
            //return "redirect:/index";
            this.getCurrentResponse().sendRedirect(proxyUrl + "index");
            return null;
        }else
        {
            return "/sso_error_sw";
        }

    }




    /**
     * 商网
     */
    @RequestMapping(value = "/sso_error_sw")
    public String sso_error_sw() throws Exception
    {
        return "/sso_error_sw";
    }


    /*
     * public boolean buildTokenByIdentityId(String unifyIdentityId,RestTemplate
     * restTemplate,HttpHeaders httpHeaders) throws Exception{
     *
     * if(unifyIdentityId == null) { return false; }
     *
     * System.out.println("============name=====a=============== ");
     *
     * SysUser u= EquipmentUtils.getUserByIdentityId(unifyIdentityId, restTemplate,
     * httpHeaders); if(u!=null) {
     * System.out.println("============name: "+u.getUnifyIdentityId());
     * HttpServletResponse response = this.getCurrentResponse();
     *
     * httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
     * MultiValueMap<String, String> valueMap = new LinkedMultiValueMap<String,
     * String>(); valueMap.add("username", u.getUserName());
     * valueMap.add("password", u.getUserPassword()); //从数据库中查到 然后返回 TOKEN
     * HttpEntity<MultiValueMap<String, String>> entity = new
     * HttpEntity<MultiValueMap<String, String>>(valueMap, httpHeaders);
     * ResponseEntity<JSONObject> responseEntity = restTemplate.exchange(LOGIN_URL,
     * HttpMethod.POST, entity, JSONObject.class); JSONObject retJson =
     * responseEntity.getBody();
     * httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8); //
     * 获取的token有问题(用户名或密码不正确) 返回登录 if (retJson == null || retJson.get("token") ==
     * null) { return false; } //token保存到Cookie Cookie cookie = new Cookie("token",
     * retJson.getString("token")); cookie.setMaxAge(-1);// 设置有效期为一小时
     * cookie.setPath("/"); response.addCookie(cookie); return true; }else {
     * System.out.println("===========unifyIdentityId======== "
     * +unifyIdentityId+" 不存在--"); return false; }
     *
     * }
     *
     */





    /**
     * 功能描述 跳转首页
     *
     * @return java.lang.String
     * @author t-chengjia.chen
     * @date 2019/12/18
     */
    @RequestMapping(value = "/index")
    public String index() {

        HttpServletRequest request = this.getCurrentRequest();
        HttpServletResponse response = this.getCurrentResponse();

        SysUser userDetails = this.restTemplate.exchange(USER_DETAILS_URL + this.getUserProfile().getUserId(), HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SysUser.class).getBody();
        List<SysFunction> aLLList = userDetails.getFunList();
        aLLList= setUpList( userDetails, aLLList);
        List<SysFunction> upList = new ArrayList<SysFunction>();
        // 个人工作台菜单
        List<SysFunction> grgztList = new ArrayList<SysFunction>();
        HashSet authSet = new HashSet();
        for (SysFunction sysfun : aLLList)
        {
            if (sysfun.getParentId() != null && sysfun.getParentId().equals("10001") && !sysfun.getName().equals("个人工作台") && !sysfun.getName().contains("权限"))
            {
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
        // 收藏的菜单
        List<SysCollect> scList = userDetails.getScList();
        request.setAttribute("scList", scList);
        request.setAttribute("funList", aLLList);
        request.setAttribute("grgztList", grgztList);
        request.setAttribute("upList", upList);
        request.setAttribute("userInfo", userDetails);
        Cookie loginCookie = new Cookie("loginErrorCount", null);
        loginCookie.setMaxAge(0);// 设置过期
        loginCookie.setPath("/");
        response.addCookie(loginCookie);
        request.setAttribute("userId", userDetails.getUserId());

        String userName = userDetails.getUserName();
        if (userName.equals(Constant.LOG_SYSTEMADMIN) || userName.equals(Constant.LOG_SECURITYADMIN) || userName.equals(Constant.LOG_AUDITADMIN)) {
            request.setAttribute("userName", userName);
            return "/adminIndex";
        } else {
            return "/index";
        }

    }

    private List setUpList(SysUser userDetails, List<SysFunction>  aLLList)
    {

        List<SysFunction> relustList = new ArrayList<SysFunction>();
        List<SysRole> roleList=  userDetails.getRoleList();
        boolean isHas=false;
        if(roleList!=null)
        {

            for(int i=0;i<roleList.size();i++)
            {
                SysRole sysRole=roleList.get(i);
                String str=sysRole.getRoleFlag();
                System.out.println("--------角色:"+str);
                if(str.equals(Constant.ROLE_WHITE_USER))//知悉范围白名单
                {
                    isHas=true;//在白名单
                }

            }
        }
        //如果不在白名单，则不要 领导驾驶舱 和 辅助（人才和项目）
        if(isHas==false)
        {
            for(int i=0;i<aLLList.size();i++)
            {
                SysFunction sf=aLLList.get(i);
                String str=sf.getName();
                //看不到以上菜单
                if(!str.equals("领导驾驶舱") && !str.equals("科技人才") && !str.equals("科研项目"))
                {
                    relustList.add(sf);
                }
            }
        }else
        {
            relustList =aLLList;
        }
        return relustList;
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


        request.setAttribute("userId", sysUserInfo.getUserId());
        return "/mainStp";
    }

    /**
     * 功能描述 获取O信息（待办）
     *
     * @return java.lang.String
     * @author t-chengjia.chen
     * @date 2019/12/18
     */
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
    public Object logout(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
        //return new Result(true, "logout", "/login");
        request.getSession().removeAttribute("sysUser");
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






    public void setLastLogin(String userId) throws Exception {
        SysUser userIpAndDate = EquipmentUtils.getSysUser(userId, restTemplate, httpHeaders);
        userIpAndDate.setLastLoginIp(EquipmentUtils.getRemoteHost(this.getCurrentRequest()));
        //存储登录时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        userIpAndDate.setLastLoginDate(date);
        EquipmentUtils.updateSysUser(userIpAndDate, restTemplate, httpHeaders);
    }

    public Integer setErrorNumber(String userId) throws Exception {
        Integer errorNumber = 0;

        SysUser rsUser = EquipmentUtils.getSysUser(userId, restTemplate, httpHeaders);
        if (rsUser != null) {
            errorNumber = rsUser.getLoginErrorNumber() == null ? 1 : rsUser.getLoginErrorNumber() + 1;
            rsUser.setLoginErrorNumber(errorNumber);
            EquipmentUtils.updateSysUser(rsUser, restTemplate, httpHeaders);
        }
        return errorNumber;
    }


}
