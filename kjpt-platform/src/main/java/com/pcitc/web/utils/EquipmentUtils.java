package com.pcitc.web.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.RequestProcessStatusEnum;
import com.pcitc.base.expert.ZjkBase;
import com.pcitc.base.system.*;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;

import io.swagger.annotations.ApiOperation;

import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.*;


public class EquipmentUtils {



	public static final String GET_EXPERT_ByNum_URL = "http://kjpt-zuul/stp-proxy/expert/getByNum/";
	private static final String GET_USERPROPERTY = "http://kjpt-zuul/system-proxy/userProperty-provider/getSysUserProperty/";
	public static final String USER_GET_URL = "http://kjpt-zuul/system-proxy/user-provider/user/get-user/";
	public static final String GET_USER_URL = "http://kjpt-zuul/system-proxy/user_provider/selectUserByIdentityId/";
	public static final String getUserByUnifyIdentityId = "http://kjpt-zuul/system-proxy/user_provider/user/getUserByUnifyIdentityId/";
	private static final String getUserByUserNameAndPasswordByMap = "http://kjpt-zuul/system-proxy/user-provider/getUserByUserNameAndPasswordByMap";

	private static final String getUserByUnitIds = "http://kjpt-zuul/system-proxy/user-provider/getAllUserList";

	public static final String UPDATE_USER_URL = "http://kjpt-zuul/system-proxy/user-provider/updateSysUser";
	//hana-虚拟通用菜单
	public static final String SYS_FUNCTION_FICTITIOUS = "984b64b13cf54222bf57bd840759fabe";

	private static final String USER_IDENTITY_ID = "http://kjpt-zuul/system-proxy/user-provider/user/user-identityid/";
	
	private static final String getCustomQueryConditionList = "http://kjpt-zuul/stp-proxy/customQueryCondition_provider/getList";
	
	
	private static final String USER_DETAILS_URL = "http://kjpt-zuul/system-proxy/user-provider/user/user-details/";


	public static List<SysUser> getUserByUnitIds(String unitIds,RestTemplate restTemplate,HttpHeaders httpHeaders)throws Exception
	{
		Map  map = new HashMap();
		map.put("unitId", unitIds.split(","));
		HttpEntity<Map> entity = new HttpEntity<Map>(map, httpHeaders);
		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getUserByUnitIds, HttpMethod.POST, entity, JSONArray.class);
		JSONArray result = responseEntity.getBody();
		String jsonStr = JSONObject.toJSONString(result);
		List<SysUser> list = JSONObject.parseArray(jsonStr,  SysUser.class);
		return list;
	}


	public static SysUser getUserByUserNameAndPassword(String username,String password,RestTemplate restTemplate,HttpHeaders httpHeaders)throws Exception
	{
		
		 Map  map = new HashMap();
 	     map.put("password", password);
 	    map.put("username", username);
 	    ResponseEntity<SysUser> responseEntity = restTemplate.exchange(getUserByUserNameAndPasswordByMap, HttpMethod.POST,new HttpEntity<Map>(map, httpHeaders), SysUser.class);
 	    SysUser retJson = null;
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200)
		{
			retJson = responseEntity.getBody();
		}
		return retJson;
	}
	
	
	public static ZjkBase getZjkBaseByNum(String num, HttpServletRequest request, HttpServletResponse response,RestTemplate restTemplate,HttpHeaders httpHeaders) throws Exception 
	{
    	ResponseEntity<ZjkBase> responseEntity = restTemplate.exchange(GET_EXPERT_ByNum_URL + num, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), ZjkBase.class);
		int statusCode = responseEntity.getStatusCodeValue();
		ZjkBase zjkBase = responseEntity.getBody();
		return zjkBase;
	}
  
	
	
	
	// 访问zuul中的登录方法
	private static final String LOGIN_URL = "http://kjpt-zuul/auth/login";
	public static String getCurrentYear() throws Exception {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		System.out.println(">>>>>year=" + year);
		return String.valueOf(year);
	}



	public static String getCurrentYearMoth() throws Exception {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		String monthstr = String.format("%02d", month);
		String str = (year) + "年" + monthstr + "月";
		System.out.println(">>>>>str=" + str);
		return str;
	}

	public static String getCurrentYearMoth2() throws Exception {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		String monthstr = String.format("%02d", month);
		String str = (year) + monthstr;
		System.out.println(">>>>>str=" + str);
		return str;
	}


	public  static boolean buildTokenByIdentityId(String unifyIdentityId,RestTemplate restTemplate,HttpHeaders httpHeaders,HttpServletResponse response ) throws Exception{

		if(unifyIdentityId == null) {
			return false;
		}
		SysUser u=   EquipmentUtils.getUserByIdentityId(unifyIdentityId, restTemplate, httpHeaders);
		if(u!=null)
		{

			httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			MultiValueMap<String, String> valueMap = new LinkedMultiValueMap<String, String>();
			valueMap.add("username", u.getUserName());
			valueMap.add("password", u.getUserPassword());
			//从数据库中查到 然后返回 TOKEN
			HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(valueMap, httpHeaders);
			ResponseEntity<JSONObject> responseEntity = restTemplate.exchange(LOGIN_URL, HttpMethod.POST, entity, JSONObject.class);
			JSONObject retJson = responseEntity.getBody();

			httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);


			JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(retJson));
			System.out.println("=======111=====："+result.toString());

			// 获取的token有问题(用户名或密码不正确) 返回登录
			if (retJson == null || retJson.get("token") == null) {
				return false;
			}
			System.out.println("=======222====retJson.token："+retJson.getString("token"));
			//token保存到Cookie
			Cookie cookie = new Cookie("token", retJson.getString("token"));
			cookie.setMaxAge(-1);// 设置有效期为一小时
			cookie.setPath("/");
			response.addCookie(cookie);
			return true;
		}else
		{
			System.out.println("===========系统unifyIdentityId："+unifyIdentityId+" 不存在  ");
			return false;
		}

	}


	public  static String buildToken_ByIdentityId(String unifyIdentityId,RestTemplate restTemplate,HttpHeaders httpHeaders,HttpServletResponse response ) throws Exception{

		if(unifyIdentityId == null) {
			return "";
		}
		SysUser u=   EquipmentUtils.getUserByIdentityId(unifyIdentityId, restTemplate, httpHeaders);
		if(u!=null)
		{

			httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			MultiValueMap<String, String> valueMap = new LinkedMultiValueMap<String, String>();
			valueMap.add("username", u.getUserName());
			valueMap.add("password", u.getUserPassword());
			//从数据库中查到 然后返回 TOKEN
			HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(valueMap, httpHeaders);
			ResponseEntity<JSONObject> responseEntity = restTemplate.exchange(LOGIN_URL, HttpMethod.POST, entity, JSONObject.class);
			JSONObject retJson = responseEntity.getBody();

			httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);


			JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(retJson));
			System.out.println("=======111=====："+result.toString());

			// 获取的token有问题(用户名或密码不正确) 返回登录
			if (retJson == null || retJson.get("token") == null) {
				return "";
			}
			String token=retJson.getString("token");
			System.out.println("=======222====retJson.token："+retJson.getString("token"));
			//token保存到Cookie
			Cookie cookie = new Cookie("token", retJson.getString("token"));
			cookie.setMaxAge(-1);// 设置有效期为一小时
			cookie.setPath("/");
			response.addCookie(cookie);
			return token;
		}else
		{
			System.out.println("===========系统unifyIdentityId："+unifyIdentityId+" 不存在  ");
			return "";
		}

	}





	public static SysUserProperty getSysUserProperty(String userId,String dataType,RestTemplate restTemplate,HttpHeaders httpHeaders)
	{
		SysUserProperty	SysUserProperty = null;
		ResponseEntity<SysUserProperty> responseEntity = restTemplate.exchange(GET_USERPROPERTY + userId+"/"+dataType, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), SysUserProperty.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200)
		{
			SysUserProperty = responseEntity.getBody();
		}
		return SysUserProperty;
	}





	public  static SysUser getSysUserByUnifyIdentityId(String unifyIdentityId,HttpServletResponse response,HttpHeaders httpHeaders,RestTemplate restTemplate)
	{



		SysUser u = new SysUser();
		u.setUnifyIdentityId(unifyIdentityId);
		ResponseEntity<SysUser> userDetailsString =restTemplate.exchange(USER_IDENTITY_ID, HttpMethod.POST, new HttpEntity<SysUser>(u, httpHeaders), SysUser.class);
		userDetailsString.getBody();
		SysUser user = userDetailsString.getBody();
		return user;
	}

	public static List<SysDictionary>  getSysDictionaryListByParentCode(String parentCode ,RestTemplate restTemplate,HttpHeaders httpHeaders)
	{

		String DICTIONARY_CODE = "http://kjpt-zuul/system-proxy/dictionary-provider/dicjson/";
		JSONArray array =restTemplate.exchange(DICTIONARY_CODE + parentCode, HttpMethod.POST, new HttpEntity<Object>(httpHeaders), JSONArray.class).getBody();
		List<SysDictionary> returnlist = JSONObject.parseArray(array.toJSONString(), SysDictionary.class);
		return returnlist;

	}

	public static List<SysDictionary>  getSysDictionaryListLikeParentCode(String parentCode ,RestTemplate restTemplate,HttpHeaders httpHeaders)
	{

		String DICTIONARY_CODE = "http://kjpt-zuul/system-proxy/dictionary-provider/dicjsonLikeParentCode/";
		JSONArray array =restTemplate.exchange(DICTIONARY_CODE + parentCode, HttpMethod.POST, new HttpEntity<Object>(httpHeaders), JSONArray.class).getBody();
		List<SysDictionary> returnlist = JSONObject.parseArray(array.toJSONString(), SysDictionary.class);
		return returnlist;

	}



	public static String  getDicNameByParentCodeAndValue(String parentCode ,String value,RestTemplate restTemplate,HttpHeaders httpHeaders)
	{
		String resutlt="";
		String DICTIONARY_CODE = "http://kjpt-zuul/system-proxy/dictionary-provider/dicjson/";
		JSONArray array =restTemplate.exchange(DICTIONARY_CODE + parentCode, HttpMethod.POST, new HttpEntity<Object>(httpHeaders), JSONArray.class).getBody();
		List<SysDictionary> returnlist = JSONObject.parseArray(array.toJSONString(), SysDictionary.class);
		if(returnlist!=null)
		{
			for(int i=0;i<returnlist.size();i++)
			{
				SysDictionary sd=returnlist.get(i);
				String numValue=sd.getNumValue();
				if(numValue.equals(value))
				{
					resutlt=sd.getName();
				}
			}
		}

		return resutlt;

	}



	public static SysDictionary  getDictionaryByCode(String code ,RestTemplate restTemplate,HttpHeaders httpHeaders)
	{

		String DICTIONARY_CODE = "http://kjpt-zuul/system-proxy/dictionary-provider/getDictionaryByCode/";
		SysDictionary sysDictionary =restTemplate.exchange(DICTIONARY_CODE + code, HttpMethod.POST, new HttpEntity<Object>(httpHeaders), SysDictionary.class).getBody();
		return sysDictionary;

	}

	public static SysDictionary  getDictionaryById(String id ,RestTemplate restTemplate,HttpHeaders httpHeaders)
	{

		String DICTIONARY_CODE = "http://kjpt-zuul/system-proxy/dictionary-provider/getDictionary/";
		SysDictionary sysDictionary =restTemplate.exchange(DICTIONARY_CODE + id, HttpMethod.POST, new HttpEntity<Object>(httpHeaders), SysDictionary.class).getBody();
		return sysDictionary;

	}

	public static String  getDictionaryNameByCode(String code ,RestTemplate restTemplate,HttpHeaders httpHeaders)
	{
		String name = "";
		String DICTIONARY_CODE = "http://kjpt-zuul/system-proxy/dictionary-provider/getDictionaryByCode/";
		SysDictionary sysDictionary =restTemplate.exchange(DICTIONARY_CODE + code, HttpMethod.POST, new HttpEntity<Object>(httpHeaders), SysDictionary.class).getBody();
		if(sysDictionary!=null)
		{
			name=sysDictionary.getName();
		}
		return name;

	}


	public static String  getDictionaryValueByCode(String code ,RestTemplate restTemplate,HttpHeaders httpHeaders)
	{
		String name = "";
		String DICTIONARY_CODE = "http://kjpt-zuul/system-proxy/dictionary-provider/getDictionaryByCode/";
		SysDictionary sysDictionary =restTemplate.exchange(DICTIONARY_CODE + code, HttpMethod.POST, new HttpEntity<Object>(httpHeaders), SysDictionary.class).getBody();
		if(sysDictionary!=null)
		{
			name=sysDictionary.getNumValue();
		}
		return name;

	}

	//获取用户信息
	public static SysUser getSysUser(String userId,RestTemplate restTemplate,HttpHeaders httpHeaders)throws Exception
	{

		SysUser sysUser = null;
		ResponseEntity<SysUser> responseEntity = restTemplate.exchange(USER_GET_URL + userId, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), SysUser.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200)
		{
			sysUser = responseEntity.getBody();
		}
		return sysUser;
	}

	//获取用户信息
	public static SysUser getUserByIdentityId(String unifyIdentityId,RestTemplate restTemplate,HttpHeaders httpHeaders)throws Exception
	{
		SysUser sysUser = null;
		ResponseEntity<SysUser> responseEntity = restTemplate.exchange(GET_USER_URL + unifyIdentityId, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), SysUser.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200)
		{
			sysUser = responseEntity.getBody();
		}
		return sysUser;
	}



	public static SysUser getUserByUnifyIdentityId(String unifyIdentityId,RestTemplate restTemplate,HttpHeaders httpHeaders)throws Exception
	{
		SysUser sysUser = null;
		ResponseEntity<SysUser> responseEntity = restTemplate.exchange(getUserByUnifyIdentityId + unifyIdentityId, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), SysUser.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200)
		{
			sysUser = responseEntity.getBody();
		}
		return sysUser;
	}



	//修改用户基本信息
	public static  Integer updateSysUser(SysUser user,RestTemplate restTemplate,HttpHeaders httpHeaders)
	{

		Integer dataId = 0;
		ResponseEntity<Integer> responseEntity =restTemplate.exchange(UPDATE_USER_URL, HttpMethod.POST, new HttpEntity<SysUser>(user, httpHeaders), Integer.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200)
		{
			dataId = responseEntity.getBody();
		}
		return dataId;
	}







	//根据unitId获得机构下岗位列表
	public static List<SysPost>  getPostListByUnitId(String unitId,RestTemplate restTemplate,HttpHeaders httpHeaders) throws Exception
	{
		String GET_POST_LIST_BYUNIT = "http://kjpt-zuul/system-proxy/post-provider/post/get-post-json";
		JSONArray jSONArray = restTemplate.exchange(GET_POST_LIST_BYUNIT, HttpMethod.POST, new HttpEntity<String>(unitId, httpHeaders), JSONArray.class).getBody();
		List<SysPost> list = JSONObject.parseArray(jSONArray.toJSONString(), SysPost.class);
		return list;
	}


	//根据UnitPath检索机构信息
	public static SysUnit getUnitByUnitPath(String unitPath,RestTemplate restTemplate,HttpHeaders httpHeaders) throws Exception
	{
		String UNIT_GET_UNIT = "http://kjpt-zuul/system-proxy/unit-provider/unit/getUnitByUnitPath/";
		SysUnit unit = restTemplate.exchange(UNIT_GET_UNIT + unitPath, HttpMethod.POST, new HttpEntity<Object>(httpHeaders), SysUnit.class).getBody();
		return unit;
	}

	//根据机构编码检索机构信息
	public static SysUnit getUnitByUnitCode(String unitCode,RestTemplate restTemplate,HttpHeaders httpHeaders) throws Exception
	{
		String UNIT_GET_UNIT = "http://kjpt-zuul/system-proxy/unit-provider/unit/get-unit-bycode/";
		SysUnit unit = restTemplate.exchange(UNIT_GET_UNIT + unitCode, HttpMethod.POST, new HttpEntity<Object>(httpHeaders), SysUnit.class).getBody();
		return unit;
	}


	//根据机构名称检索机构信息
	public static String getUnitByUnitName(String unitName,RestTemplate restTemplate,HttpHeaders httpHeaders) throws Exception
	{
		String UNIT_GET_UNIT = "http://kjpt-zuul/system-proxy/unit-provider/unit/getUnitId_by_name/";
		String unit = restTemplate.exchange(UNIT_GET_UNIT + unitName, HttpMethod.POST, new HttpEntity<Object>(httpHeaders), String.class).getBody();
		return unit;
	}


	//根据机构ID检索机构信息
	public static SysUnit getUnitByUnitId(String unitId,RestTemplate restTemplate,HttpHeaders httpHeaders) throws Exception
	{
		String UNIT_GET_UNIT = "http://kjpt-zuul/system-proxy/unit-provider/unit/get-unit/";
		SysUnit unit = restTemplate.exchange(UNIT_GET_UNIT + unitId, HttpMethod.POST, new HttpEntity<Object>(httpHeaders), SysUnit.class).getBody();
		return unit;
	}


	public static SysUser getSysUserByUserId(String userId,RestTemplate restTemplate,HttpHeaders httpHeaders)
	{
		String USER_DETAILS_URL = "http://kjpt-zuul/system-proxy/user-provider/user/user-details/";
		SysUser userDetails = restTemplate.exchange(USER_DETAILS_URL + userId, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), SysUser.class).getBody();
		return userDetails;
	}



	public static  String getInfoLevelsByUserSecretLevel2(String userSecretLevel)
	{
		//核心->绝密
		//重要->机密
		//一般->秘密
		//非密->内部

		StringBuffer sb=new StringBuffer();
		if(userSecretLevel.equals(Constant.USER_SECRET_LEVEL_CORE))//用户 -核心、重要、一般、非密,//信息--机密、秘密、内部 公开
		{
			sb.append(Constant.INFO_SECRET_LEVEL_HEIGHT).append(",")
					.append(Constant.INFO_SECRET_LEVEL_SECRET).append(",")
					.append(Constant.INFO_SECRET_LEVEL_INNER).append(",")
					.append(Constant.INFO_SECRET_LEVEL_PUBLIC);
		}else if(userSecretLevel.equals(Constant.USER_SECRET_LEVEL_IMPORTANT))
		{
			sb.append(Constant.INFO_SECRET_LEVEL_HEIGHT).append(",")
					.append(Constant.INFO_SECRET_LEVEL_SECRET).append(",")
					.append(Constant.INFO_SECRET_LEVEL_INNER).append(",")
					.append(Constant.INFO_SECRET_LEVEL_PUBLIC);
		}
		else if(userSecretLevel.equals(Constant.USER_SECRET_LEVEL_JUST))
		{
			sb.append(Constant.INFO_SECRET_LEVEL_SECRET).append(",")
					.append(Constant.INFO_SECRET_LEVEL_INNER).append(",")
					.append(Constant.INFO_SECRET_LEVEL_PUBLIC);
		}
		else if(userSecretLevel.equals(Constant.USER_SECRET_LEVEL_NOT))
		{
			sb.append(Constant.INFO_SECRET_LEVEL_INNER).append(",")
					.append(Constant.INFO_SECRET_LEVEL_PUBLIC);
		}else
		{
			sb.append(Constant.INFO_SECRET_LEVEL_INNER).append(",")
					.append(Constant.INFO_SECRET_LEVEL_PUBLIC);
		}
		return sb.toString();
	}


	//根据机构ID查询机构下所有的信息
	public static String getAllChildsByIUnitPath(String unitPath,RestTemplate restTemplate,HttpHeaders httpHeaders)
	{
		StringBuffer sb=new StringBuffer();
		if(unitPath!=null)
		{
			String UNIT_PATH = "http://kjpt-zuul/system-proxy/unit-provider/unit/getAllChildsByIUnitPath/";
			JSONArray jSONArray  = restTemplate.exchange(UNIT_PATH + unitPath, HttpMethod.POST, new HttpEntity<Object>(httpHeaders), JSONArray.class).getBody();
			if(jSONArray!=null)
			{
				List<SysUnit> returnlist = JSONObject.parseArray(jSONArray.toJSONString(), SysUnit.class);
				for(int i=0;i<returnlist.size();i++)
				{
					SysUnit sysUnit=returnlist.get(i);
					String unit_Id=sysUnit.getUnitId();
					if(i>0)
					{
						sb.append(",");
					}
					sb.append(unit_Id);
				}

			}
		}
		return sb.toString();
	}


	
	    //获得查询条件接口
		public static JSONArray getCustomQueryConditionList(RestTemplate restTemplate,HttpHeaders httpHeaders,HttpServletRequest request, HttpServletResponse response,String tableName)throws Exception
	    {
	    	    
	           
	    	    httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		   		Map<String ,String> paramMap = new HashMap<String ,String>();
		   		paramMap.put("tableName", tableName);
		   		HttpEntity<Map<String, String>> httpEntity = new HttpEntity<Map<String, String>>(paramMap,httpHeaders);
		   		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getCustomQueryConditionList, HttpMethod.POST, httpEntity, JSONArray.class);
		   		int statusCode = responseEntity.getStatusCodeValue();
		   		
	  	   		JSONArray jSONArray=null;
	  	   		if (statusCode == 200)
	  	   		{
	  	   			jSONArray = responseEntity.getBody();
	  	   		    System.out.println(">>>>>>>>>>获得查询条件接口: "+jSONArray.toJSONString());
	  	   		}
	  	   		return jSONArray;
		   		
		}
	    
	 

		    public static Map  setUserDetailSession(RestTemplate restTemplate,HttpHeaders httpHeaders,HttpServletRequest request,String userId)
		    {
		    	
		    	
		    	 System.out.println("----userId---"+userId);
		    	SysUser userDetails = restTemplate.exchange(USER_DETAILS_URL + userId, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), SysUser.class).getBody();
		        System.out.println("----setUserDetailSession---"+userDetails.getUserId());
		    	List<SysFunction> aLLList = userDetails.getFunList();
		        JSONArray array= JSONArray.parseArray(JSON.toJSONString(aLLList));
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
		        
		        
		        JSONArray array2= JSONArray.parseArray(JSON.toJSONString(grgztList));
		        System.out.println("-------grgztList:"+array2.toString());
		        // 收藏的菜单
		        List<SysCollect> scList = userDetails.getScList();
		        Map map=new HashMap();
		        map.put("authSet", authSet);
		        map.put("scList", scList);
		        map.put("funList", aLLList);
		        map.put("grgztList", grgztList);
		        map.put("upList", upList);
		        map.put("userInfo", userDetails);
		        
		        
		        request.getSession().setAttribute("sysUser", userDetails);
		        
		        request.getSession().setAttribute("authSet", authSet);
		        request.getSession().setAttribute("scList", scList);
		        request.getSession().setAttribute("funList", aLLList);
		        request.getSession().setAttribute("grgztList", grgztList);
		        //request.getSession().setAttribute("userInfo", userDetails);
		        request.getSession().setAttribute("upList", upList);
		        
		        
		        request.setAttribute("userInfo", userDetails);
		        
		        return map;
		        
		    }
		    
		    
		    private static List setUpList(SysUser userDetails, List<SysFunction>  aLLList)
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



	//生成8位随机数
	public static String genRandomNum() {
		int maxNum = 36;
		int i;
		int count = 0;
		char[] str = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
				'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		StringBuffer pwd = new StringBuffer("");
		Random r = new Random();
		while (count < 8) {
			i = Math.abs(r.nextInt(maxNum));
			if (i >= 0 && i < str.length) {
				pwd.append(str[i]);
				count++;
			}
		}
		return pwd.toString();
	}




	public static String getRemoteHost(javax.servlet.http.HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
	}
	// 获取HttpServletRequest请求Body中的内容
	public static String readBody(HttpServletRequest request)
	{

		StringBuilder sb = new StringBuilder();
		InputStream is = null;
		try {
			is = request.getInputStream();
			byte[] b = new byte[4096];
			for (int n; (n = is.read(b)) != -1;)
			{
				sb.append(new String(b, 0, n));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally
		{

		}
		return sb.toString();
	}



	public static  String getSwSSOToken(HttpServletRequest request,HttpServletResponse response)throws Exception
	{


		Cookie[] cookies = request.getCookies();
		String value = "";
		if(cookies!=null)
		{
			for(int i = 0; i < cookies.length; i ++)
			{
				Cookie cookie = cookies[i];
				String utf8=  new String(URLDecoder.decode(cookie.getValue()).getBytes("ISO-8859-1"), "utf-8");
				// System.out.println("  "+cookie.getName()+" utf-> "+utf8);
				if("KOAL_CERT_GN".equals(cookie.getName()))
				{
					if(utf8!=null)
					{
						String arr[]=utf8.split("\\|");
						if(arr!=null)
						{
							String temp=arr[0];
							if(temp!=null)
							{
								value=temp.trim();
							}
						}
					}
				}
			}
		}
		//System.out.println("==========getSwSSOToken KOAL_CERT_CN=  "+value);
		return  value;//"110223198603270593";
	}


	/*
	 * public static void main(String[] args) { String atr="xxxx|aa"; String
	 * arr[]=atr.split("\\|"); System.out.println(arr[0]); }
	 */


}
