package com.pcitc.web.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.expert.ZjkAchievement;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.system.SysFunctionProperty;
import com.pcitc.base.system.SysPost;
import com.pcitc.base.system.SysUnit;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.system.SysUserProperty;
import com.pcitc.web.common.JwtTokenUtil;


public class EquipmentUtils {
	
	
	
	
     private static final String GET_USERPROPERTY = "http://kjpt-zuul/system-proxy/userProperty-provider/getSysUserProperty/";
     private static final String USER_GET_URL = "http://kjpt-zuul/system-proxy/user-provider/user/get-user/";
     //hana-虚拟通用菜单
     public static final String SYS_FUNCTION_FICTITIOUS = "984b64b13cf54222bf57bd840759fabe";
     
	
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
	
	
	
	public static List<SysDictionary>  getSysDictionaryListByParentCode(String parentCode ,RestTemplate restTemplate,HttpHeaders httpHeaders)
	{
		
		String DICTIONARY_CODE = "http://kjpt-zuul/system-proxy/dictionary-provider/dicjson/";
		JSONArray array =restTemplate.exchange(DICTIONARY_CODE + parentCode, HttpMethod.POST, new HttpEntity<Object>(httpHeaders), JSONArray.class).getBody();
		List<SysDictionary> returnlist = JSONObject.parseArray(array.toJSONString(), SysDictionary.class);
		return returnlist;
		
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
	
	
	//根据机构ID查询机构下所有的信息
	public static String getAllChildsByIUnitPath(String unitPath,RestTemplate restTemplate,HttpHeaders httpHeaders) throws Exception
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
	
	
	/*
	 * public static void main(String[] args) {
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
	
	
	
	
}
