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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.stp.equipment.JoinUnitWord;
import com.pcitc.base.stp.equipment.SreDetail;
import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.stp.equipment.SreProject;
import com.pcitc.base.stp.equipment.SreProjectSetup;
import com.pcitc.base.stp.equipment.SreProjectTask;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.system.SysFunctionProperty;
import com.pcitc.base.system.SysPost;
import com.pcitc.base.system.SysUnit;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.system.SysUserProperty;
import com.pcitc.base.util.CodeUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.web.common.JwtTokenUtil;


public class EquipmentUtils {
	
	private static final String GET_URL_EQUIPMENT= "http://pcitc-zuul/stp-proxy/sre-provider/equipment/get/";
	private static final String UPDATE_URL_EQUIPMENT = "http://pcitc-zuul/stp-proxy/sre-provider/equipment/update";
	private static final String DEL_URL_EQUIPMENT = "http://pcitc-zuul/stp-proxy/sre-provider/equipment/delete/";
	
	


	private static final String GET_URL_PROJECT = "http://pcitc-zuul/stp-proxy/sre-provider/project_basic/get/";
	private static final String UPDATE_URL_PROJECT = "http://pcitc-zuul/stp-proxy/sre-provider/project_basic/update";
	private static final String DEL_URL_PROJECT =    "http://pcitc-zuul/stp-proxy/sre-provider/project_basic/delete/";
	private static final  String SEND_TASK_URL =     "http://pcitc-zuul/stp-proxy/sre-provider/project_basic/mail";
	
	private static final String GET_URL_TASK = "http://pcitc-zuul/stp-proxy/sre-provider/project_task/get/";
	private static final String UPDATE_URL_TASK = "http://pcitc-zuul/stp-proxy/sre-provider/project_task/update";
	private static final String DEL_URL_TASK = "http://pcitc-zuul/stp-proxy/sre-provider/project_task/delete/";
	
	
	private static final String GET_URL_SETUP = "http://pcitc-zuul/stp-proxy/sre-provider/project_setup/get/";
	private static final String UPDATE_URL_SETUP = "http://pcitc-zuul/stp-proxy/sre-provider/project_setup/update";
	private static final String DEL_URL_SETUP = "http://pcitc-zuul/stp-proxy/sre-provider/project_setup/delete/";
	
	
	
     private static final String GET_USERPROPERTY = "http://pcitc-zuul/system-proxy/userProperty-provider/getSysUserProperty/";
     private static final String USER_GET_URL = "http://pcitc-zuul/system-proxy/user-provider/user/get-user/";
     private static final String FUNCTION_FILTER_URL = "http://pcitc-zuul/system-proxy/userProperty-provider/function/getPostDic";
     
     //科技部代码
     private static final String KJB_UNIONPATH_NUM = "10010685";
     //hana-虚拟通用菜单
     public static final String SYS_FUNCTION_FICTITIOUS = "984b64b13cf54222bf57bd840759fabe";
     
     private static final String GET_URL_Detail = "http://pcitc-zuul/stp-proxy/sre-provider/sreDetail/get/";
     
     
     
     
	
	public static String getCurrrentYear() throws Exception {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		System.out.println(">>>>>year=" + year);
		return String.valueOf(year);
	}
	
	
	
	public static String getCurrrentYearMoth() throws Exception {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		String monthstr = String.format("%02d", month);
		String str = (year) + "年" + monthstr + "月";
		System.out.println(">>>>>str=" + str);
		return str;
	}
	
	public static String getCurrrentYearMoth2() throws Exception {
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
	
	
	public static SreEquipment getSreEquipment(String id,RestTemplate restTemplate,HttpHeaders httpHeaders)
	{
		SreEquipment	sreEquipment = null;
		ResponseEntity<SreEquipment> responseEntity = restTemplate.exchange(GET_URL_EQUIPMENT + id, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), SreEquipment.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200)
		{
			sreEquipment = responseEntity.getBody();
		}
		return sreEquipment;
	}
	
	
	public static String updateSreEquipment(SreEquipment sreEquipment,RestTemplate restTemplate,HttpHeaders httpHeaders)
	{
		String str="";
		ResponseEntity<String> responseEntity =restTemplate.exchange(UPDATE_URL_EQUIPMENT, HttpMethod.POST, new HttpEntity<SreEquipment>(sreEquipment, httpHeaders), String.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200)
		{
			str = responseEntity.getBody();
		}
		return str;
	}
	
	public static Integer deleteSreEquipment(String id ,RestTemplate restTemplate,HttpHeaders httpHeaders)
	{
		Integer str=0;
		ResponseEntity<Integer> responseEntity = restTemplate.exchange(DEL_URL_EQUIPMENT + id, HttpMethod.POST, new HttpEntity<Object>(httpHeaders), Integer.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200)
		{
			str = responseEntity.getBody();
		}
		return str;
	}
	
	
	
	
	
	
	
	
	public static SreProject getSreProject(String id,RestTemplate restTemplate,HttpHeaders httpHeaders)
	{
		SreProject	sreProjectBasic = null;
		ResponseEntity<SreProject> responseEntity = restTemplate.exchange(GET_URL_PROJECT + id, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), SreProject.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200)
		{
			sreProjectBasic = responseEntity.getBody();
		}
		return sreProjectBasic;
	}
	
	
	public static String updateSreProject(SreProject sreProject,RestTemplate restTemplate,HttpHeaders httpHeaders)
	{
		String str="";
		ResponseEntity<String> responseEntity =restTemplate.exchange(UPDATE_URL_PROJECT, HttpMethod.POST, new HttpEntity<SreProject>(sreProject, httpHeaders), String.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200)
		{
			str = responseEntity.getBody();
		}
		return str;
	}
	
	public static Integer deleteSreProject(String id ,RestTemplate restTemplate,HttpHeaders httpHeaders)
	{
		Integer str=0;
		ResponseEntity<Integer> responseEntity = restTemplate.exchange(DEL_URL_PROJECT + id, HttpMethod.POST, new HttpEntity<Object>(httpHeaders), Integer.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200)
		{
			str = responseEntity.getBody();
		}
		return str;
	}
	
	
	
	
	
	
	
	
	public static SreProjectTask getSreProjectTask(String id,RestTemplate restTemplate,HttpHeaders httpHeaders)
	{
		SreProjectTask	sreProjectBasic = null;
		ResponseEntity<SreProjectTask> responseEntity = restTemplate.exchange(GET_URL_TASK + id, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), SreProjectTask.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200)
		{
			sreProjectBasic = responseEntity.getBody();
		}
		return sreProjectBasic;
	}
	public static String updateSreProjectTask(SreProjectTask sreProjectTask,RestTemplate restTemplate,HttpHeaders httpHeaders)
	{
		String str="";
		ResponseEntity<String> responseEntity =restTemplate.exchange(UPDATE_URL_TASK, HttpMethod.POST, new HttpEntity<SreProjectTask>(sreProjectTask, httpHeaders), String.class);
		int statusCode = responseEntity.getStatusCodeValue();
		
		
		if (statusCode == 200)
		{
			str = responseEntity.getBody();
		}
		return str;
	}
	public static Integer deleteSreProjectTask(String id ,RestTemplate restTemplate,HttpHeaders httpHeaders)
	{
		Integer str=0;
		ResponseEntity<Integer> responseEntity = restTemplate.exchange(DEL_URL_TASK + id, HttpMethod.POST, new HttpEntity<Object>(httpHeaders), Integer.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200)
		{
			str = responseEntity.getBody();
		}
		return str;
	}
	
	
	public static SreProjectSetup getSreProjectSetup(String id,RestTemplate restTemplate,HttpHeaders httpHeaders)
	{
		SreProjectSetup	sreProjectSetup = null;
		ResponseEntity<SreProjectSetup> responseEntity = restTemplate.exchange(GET_URL_SETUP + id, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), SreProjectSetup.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200)
		{
			sreProjectSetup = responseEntity.getBody();
		}
		return sreProjectSetup;
	}
	public static String updateSreProjectSetup(SreProjectSetup sreProjectSetup,RestTemplate restTemplate,HttpHeaders httpHeaders)
	{
		String str="";
		ResponseEntity<String> responseEntity =restTemplate.exchange(UPDATE_URL_SETUP, HttpMethod.POST, new HttpEntity<SreProjectSetup>(sreProjectSetup, httpHeaders), String.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200)
		{
			str = responseEntity.getBody();
		}
		return str;
	}
	public static Integer deleteSreProjectSetup(String id ,RestTemplate restTemplate,HttpHeaders httpHeaders)
	{
		Integer str=0;
		ResponseEntity<Integer> responseEntity = restTemplate.exchange(DEL_URL_SETUP + id, HttpMethod.POST, new HttpEntity<Object>(httpHeaders), Integer.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200)
		{
			str = responseEntity.getBody();
		}
		return str;
	}
	
	public static Integer sentSreProjectTaskMail(String id ,SreProject sreProject ,RestTemplate restTemplate,HttpHeaders httpHeaders)
	{
		
		Integer str=0;
		ResponseEntity<Integer> responseEntity =restTemplate.exchange(SEND_TASK_URL, HttpMethod.POST, new HttpEntity<SreProject>(sreProject, httpHeaders), Integer.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200)
		{
			str = responseEntity.getBody();
		}
		return str;
	}
	
	public static List<SysDictionary>  getSysDictionaryListByParentCode(String parentCode ,RestTemplate restTemplate,HttpHeaders httpHeaders)
	{
		
		String DICTIONARY_CODE = "http://pcitc-zuul/system-proxy/dictionary-provider/dicjson/";
		JSONArray array =restTemplate.exchange(DICTIONARY_CODE + parentCode, HttpMethod.POST, new HttpEntity<Object>(httpHeaders), JSONArray.class).getBody();
		List<SysDictionary> returnlist = JSONObject.parseArray(array.toJSONString(), SysDictionary.class);
		return returnlist;
		
	}
	
	
	public static SysDictionary  getDictionaryByCode(String code ,RestTemplate restTemplate,HttpHeaders httpHeaders)
	{
		
		String DICTIONARY_CODE = "http://pcitc-zuul/system-proxy/dictionary-provider/getDictionaryByCode/";
		SysDictionary sysDictionary =restTemplate.exchange(DICTIONARY_CODE + code, HttpMethod.POST, new HttpEntity<Object>(httpHeaders), SysDictionary.class).getBody();
		return sysDictionary;
		
	}
	
	
	
	public static String  getDictionaryNameByCode(String code ,RestTemplate restTemplate,HttpHeaders httpHeaders)
	{
		String name = "";
		String DICTIONARY_CODE = "http://pcitc-zuul/system-proxy/dictionary-provider/getDictionaryByCode/";
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
		String DICTIONARY_CODE = "http://pcitc-zuul/system-proxy/dictionary-provider/getDictionaryByCode/";
		SysDictionary sysDictionary =restTemplate.exchange(DICTIONARY_CODE + code, HttpMethod.POST, new HttpEntity<Object>(httpHeaders), SysDictionary.class).getBody();
		if(sysDictionary!=null)
	    {
			name=sysDictionary.getNumValue();
	    }
		return name;
		
	}
	
	
	

	public static Map getDepartInfoBySysUser(SysUser sysUserInfo,RestTemplate restTemplate,HttpHeaders httpHeaders)throws Exception
	{
		Map<String ,String> map=new HashMap<String ,String>();
		String unitName = "";//申报单位
		String unitCode = "";//申报单位
		String applyDepartName = "";//具体部门
		String applyDepartCode = "";//具体部门
		String applyUnitId="";
		String applyUnitPath="";
		
		String unitCodes = sysUserInfo.getUnitCode();//00000,108811,108811002
		String unitNames = sysUserInfo.getUnitName();//中国石油化工集团,中国石油化工股份有限公司石油勘探开发研究院,油气勘探研究所
		System.out.println("==========unitNames="+unitNames+" unitCodes:"+unitCodes);
		//字电表八大院，匹配用户机构(如果用户机构中包含字典表中的院，说明是院所人员)
		List<SysDictionary> dicList = EquipmentUtils.getSysDictionaryListByParentCode("ROOT_UNIVERSAL_BDYJY", restTemplate,httpHeaders);
		if(dicList!=null && dicList.size()>0)
		{
			for(int i=0;i<dicList.size();i++)
			{
				SysDictionary sysDictionary=dicList.get(i);
				String value=sysDictionary.getNumValue();
				String name=sysDictionary.getName();
				String arr[]=unitCodes.split(",");
				if(arr!=null && arr.length>0)
				{
					for(int j=0;j<arr.length;j++)
					{
						String code=arr[j];
						if(code.equals(value))
						{
							unitCode=code;
							unitName=name;
						}
					}
				}
			}
		}
		//根据单位--》找出下级部门（中国石油化工集团,中国石油化工股份有限公司石油勘探开发研究院,油气勘探研究所）
		if(!unitCode.equals(""))
		{
			String arr[]=unitCodes.split(",");
			if(arr!=null && arr.length>0)
			{
				for(int j=0;j<arr.length;j++)
				{
					String code=arr[j];
					if(code.length()>6 && code.contains(unitCode))//部门：9位,且包含单位代码
					{
						applyDepartCode=code;
						SysUnit sysUnit= getUnitByUnitCode(applyDepartCode, restTemplate, httpHeaders);
						if(sysUnit!=null)
						{
							applyDepartName=sysUnit.getUnitName();
							applyUnitId=sysUnit.getUnitId();
							applyUnitPath=sysUnit.getUnitPath();
						}
					}
					
				}
			}
		}
		
		map.put("unitName", unitName);
		map.put("unitCode", unitCode);
		map.put("applyDepartName", applyDepartName);
		map.put("applyDepartCode", applyDepartCode);
		map.put("applyUnitId", applyUnitId);
		map.put("applyUnitPath", applyUnitPath);
		
		System.out.println("==========单位 unitCode="+unitCode);
		System.out.println("==========单位 unitName="+unitName);
		System.out.println("==========部门 applyDepartName="+applyDepartName);
		System.out.println("==========部门 applyDepartCode="+applyDepartCode);
		System.out.println("==========部门 applyUnitId="+applyUnitId);
		System.out.println("==========部门 applyUnitPath="+applyUnitPath);
		
		return map;
		
	}
	
	
	//取得当前人的单位代码
	public static String getEquipmentUnitCode(SysUser sysUserInfo,RestTemplate restTemplate,HttpHeaders httpHeaders)
	{
		
		
		String unitCode = "";//申报单位
		
		String unitCodes = sysUserInfo.getUnitCode();//00000,108811,108811002
		String unitNames = sysUserInfo.getUnitName();//中国石油化工集团,中国石油化工股份有限公司石油勘探开发研究院,油气勘探研究所
		System.out.println("==========unitNames="+unitNames+" unitCodes:"+unitCodes);
		//字电表八大院，匹配用户机构(如果用户机构中包含字典表中的院，说明是院所人员)
		List<SysDictionary> dicList = EquipmentUtils.getSysDictionaryListByParentCode("ROOT_UNIVERSAL_BDYJY", restTemplate,httpHeaders);
		if(dicList!=null && dicList.size()>0)
		{
			for(int i=0;i<dicList.size();i++)
			{
				SysDictionary sysDictionary=dicList.get(i);
				String value=sysDictionary.getNumValue();
				String name=sysDictionary.getName();
				String arr[]=unitCodes.split(",");
				if(arr!=null && arr.length>0)
				{
					for(int j=0;j<arr.length;j++)
					{
						String code=arr[j];
						if(code.equals(value))
						{
							unitCode=code;
						}
					}
				}
			}
		}
		return unitCode;
	}
	
	
	
	
	public static String getHanaUnitNameByUnitCode(String unitCode,RestTemplate restTemplate,HttpHeaders httpHeaders)
	{
		        System.out.println("-------根据8院UnitCode:"+unitCode+"得到HANA院所名（三个字）-----------" );
		        String g0GSJC="";
		        //装备直属院（103111->安工院）
				List<SysDictionary>  leaddicList= EquipmentUtils.getSysDictionaryListByParentCode("ROOT_UNIVERSAL_BDYJY", restTemplate, httpHeaders);
				if(leaddicList!=null) 
				{
				   for(int i=0;i<leaddicList.size();i++)
				   {
					   SysDictionary sysDictionary= leaddicList.get(i);
					   String numValue =sysDictionary.getNumValue();
					   if(numValue.equals(unitCode))
					   {
						   g0GSJC=sysDictionary.getRemark();
					   }
				   }
				}
				System.out.println("-------根据8院UnitCode: " + unitCode+"-->转换为HANA院所名（三个字）："+g0GSJC);
				return g0GSJC;
	}
	//根据8院UnitCode得到HANA code
	public static String getHanaUnitCodeByUnitCode(String unitCode,RestTemplate restTemplate,HttpHeaders httpHeaders)
	{
		        System.out.println("-------根据8院UnitCode得到HANA -----unitCode: " + unitCode);
		        String g0GSJC="";
		        String companyCode="";
		        //装备直属院（103111->安工院）
				List<SysDictionary>  leaddicList= EquipmentUtils.getSysDictionaryListByParentCode("ROOT_UNIVERSAL_BDYJY", restTemplate, httpHeaders);
				if(leaddicList!=null) 
				{
				   for(int i=0;i<leaddicList.size();i++)
				   {
					   SysDictionary sysDictionary= leaddicList.get(i);
					   String numValue =sysDictionary.getNumValue();
					   if(numValue.equals(unitCode))
					   {
						   g0GSJC=sysDictionary.getRemark();
					   }
				   }
				}
				
				//HANA直属院（安工院-》1100,1101）
				if(!g0GSJC.equals(""))
				{
					List<SysDictionary>  dicList= EquipmentUtils.getSysDictionaryListByParentCode("ROOT_ZGSHJT_GFGS_ZSYJY", restTemplate, httpHeaders);
					if(dicList!=null) 
					{
					   for(int i=0;i<dicList.size();i++)
					   {
						   SysDictionary sysDictionary= dicList.get(i);
						   String name =sysDictionary.getName();
						   if(name.equals(g0GSJC))
						   {
							   companyCode=sysDictionary.getNumValue();
						   }
					   }
					}
					
				}
				System.out.println("-------机构unitCode: " + unitCode+"-->转换为Hana："+companyCode);
				return companyCode;
	}
	
	
	   //物探院->1130
		public static String getCompanyCodeByHanaName(String companyName,RestTemplate restTemplate,HttpHeaders httpHeaders)
		{
			
			
			String companyCode = "";//申报单位
			List<SysDictionary>  dicList= EquipmentUtils.getSysDictionaryListByParentCode("ROOT_ZGSHJT_GFGS_ZSYJY", restTemplate, httpHeaders);
			if(dicList!=null) 
			{
			   for(int i=0;i<dicList.size();i++)
			   {
				   SysDictionary sysDictionary= dicList.get(i);
				   String name =sysDictionary.getName();
				   if(name.equals(companyName))
				   {
					   companyCode=sysDictionary.getNumValue();
				   }
			   }
			}
			return companyCode;
		}
	
	
	//数据控制配置（直属院）
	public static  List<String>  getPostDic(String functionId ,RestTemplate restTemplate,HttpHeaders httpHeaders)
	{
		   List<String> list_temp = httpHeaders.get("Authorization");
		   List<String> arrayList = new ArrayList<String>();
		   if(!functionId.equals(""))
		   {
			   if (list_temp != null && list_temp.get(0) != null) 
			   {
				   
				   System.out.println("========list_temp.get(0)>" + list_temp.get(0));
				   
			    SysUser userInfo = JwtTokenUtil.getUserFromTokenByValue(list_temp.get(0).split(" ")[1]);
			    
			    System.out.println("========userInfo>" + userInfo.getUserName());
			    
				HashMap<String, Object> paramMap = new HashMap<String, Object>();
				paramMap.put("functionId", functionId);
				System.out.println("========userInfo.getUserPost()>" + userInfo.getUserPost());
				
				String[] postArr = userInfo.getUserPost().split(",");
				System.out.println("========getUserPost===============" + userInfo.getUserPost()+" functionId="+functionId);
				paramMap.put("postIds", Arrays.asList(postArr));
				
				httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
				
				HttpEntity<HashMap<String, Object>> entityv = new HttpEntity<HashMap<String, Object>>(paramMap, httpHeaders);
				ResponseEntity<JSONArray> response_Entity = restTemplate.exchange(FUNCTION_FILTER_URL , HttpMethod.POST, entityv, JSONArray.class);
				JSONArray retJson = response_Entity.getBody();
				System.out.println("========retJson===============" + retJson.toString());
				if (retJson != null)
				{
					List<SysFunctionProperty> sfpList = JSONArray.parseArray(retJson.toString(), SysFunctionProperty.class);
					for (int i=0;i<sfpList.size();i++ ) 
					{
						
						SysFunctionProperty sysFunctionProperty=sfpList.get(i);
						String proCode=sysFunctionProperty.getProCode();
						String postConfigValue=sysFunctionProperty.getPostConfigValue();
						System.out.println(proCode + "======---键值对---=>" + postConfigValue);
						if(proCode.equals("G0DSM"))
						{
							String arr[]=postConfigValue.split("\\$");
							if(arr!=null)
							{
								for (int j=0;j<arr.length;j++ ) 
								{
									String str=arr[j];//1020#1040,1041#1060,1061#1080
									if(str!=null)
									{
										String arr2[]=str.split("&");
										if(arr2!=null)
										{
											for (int v=0;v<arr2.length;v++ ) 
											{
												arrayList.add(arr2[v]);
											}
											
										}
									}
								}
							}
						}
						
					}
				}
				
			   if(arrayList.size()>0)
			   {
				   arrayList = new ArrayList<>(new HashSet<String>(arrayList));//用set元素不重复性
			   }
			  }
		   }
		   return arrayList;
	}
	
	
	
	//数据控制配置（直属院）
	public static List<SysDictionary>  getDirDeparetMentList(String functionId ,RestTemplate restTemplate,HttpHeaders httpHeaders)
	{
		   List<String> arrayList = getPostDic( functionId , restTemplate, httpHeaders);
		   //与字典表匹配
		   List<SysDictionary> result=new ArrayList<SysDictionary> ();
		   List<SysDictionary>  sysDictionaryList=  EquipmentUtils.getSysDictionaryListByParentCode("ROOT_ZGSHJT_GFGS_ZSYJY",  restTemplate, httpHeaders);
		   if(sysDictionaryList!=null && sysDictionaryList.size()>0)
		   {
			    for(int v=0;v<sysDictionaryList.size();v++ ) 
				{
			    	SysDictionary sysDictionary=sysDictionaryList.get(v);
			    	String name=sysDictionary.getName();
			    	String code=sysDictionary.getCode();
			    	String value=sysDictionary.getNumValue();
			    	if(arrayList!=null && arrayList.size()>0)
			    	{
			    		for(int k=0;k<arrayList.size();k++ ) 
						{
			    			String str=arrayList.get(k);
			    			if(str.equals(value))
			    			{
			    				sysDictionary.setLevelCode(v+1);
			    				result.add(sysDictionary);
			    			}
						}
			    	}
			    	//System.out.println( "name=>" + name+" code=>" + code+"  value=>" + value);
				}
		}
		   
		if(result.size()>0)
		{
			SysDictionary sys_Dictionary=new SysDictionary();
			StringBuffer sb=new StringBuffer();
			for(int v=0;v<result.size();v++ ) 
			{
		    	SysDictionary sysDictionary=result.get(v);
		    	String name=sysDictionary.getName();
		    	String value=sysDictionary.getNumValue();
		    	if(v>0)
		    	{
		    		sb.append(",");
		    	}
		    	sb.append(value);
		    	
			}
			sys_Dictionary.setName("--全部--");
			sys_Dictionary.setNumValue(sb.toString());
			sys_Dictionary.setLevelCode(0);
			result.add(sys_Dictionary);
			
			
			
			
			  //直接在这里添加我们的排序规则
	        Collections.sort(result, new Comparator<SysDictionary>() {
	            public int compare(SysDictionary arg0, SysDictionary arg1) {
	                return arg0.getLevelCode().compareTo(arg1.getLevelCode());
	            }
	        });
	        
	        
			
			for(int v=0;v<result.size();v++ ) 
			{
		    	SysDictionary sysDictionary=result.get(v);
		    	String name=sysDictionary.getName();
		    	String value=sysDictionary.getNumValue();
		    	System.out.println( "name=>" + name+"  value=>" + value);
			}
			
		}
		//如果没有配置数据权限，则默认所有
	    if(arrayList.size()<=0)
	    {
	    	result=sysDictionaryList;
	    }
	    return result;
	}
	
	
	
	public static String  getVirtualDirDeparetCode(String functionId ,RestTemplate restTemplate,HttpHeaders httpHeaders)
	{
		   List<String> arrayList = getPostDic( functionId , restTemplate, httpHeaders);
		   //与字典表匹配
		   List<SysDictionary> result=new ArrayList<SysDictionary> ();
		   List<SysDictionary>  sysDictionaryList=  EquipmentUtils.getSysDictionaryListByParentCode("ROOT_ZGSHJT_GFGS_ZSYJY",  restTemplate, httpHeaders);
		   if(sysDictionaryList!=null && sysDictionaryList.size()>0)
		   {
			    for(int v=0;v<sysDictionaryList.size();v++ ) 
				{
			    	SysDictionary sysDictionary=sysDictionaryList.get(v);
			    	String name=sysDictionary.getName();
			    	String code=sysDictionary.getCode();
			    	String value=sysDictionary.getNumValue();
			    	if(arrayList!=null && arrayList.size()>0)
			    	{
			    		for(int k=0;k<arrayList.size();k++ ) 
						{
			    			String str=arrayList.get(k);
			    			if(str.equals(value))
			    			{
			    				sysDictionary.setLevelCode(v+1);
			    				result.add(sysDictionary);
			    			}
						}
			    	}
			    	//System.out.println( "name=>" + name+" code=>" + code+"  value=>" + value);
				}
		}
		   
		//全部   
		StringBuffer sb=new StringBuffer(); 
		if(result.size()>0)
		{
			SysDictionary sys_Dictionary=new SysDictionary();
			
			for(int v=0;v<result.size();v++ ) 
			{
		    	SysDictionary sysDictionary=result.get(v);
		    	String name=sysDictionary.getName();
		    	String value=sysDictionary.getNumValue();
		    	if(v>0)
		    	{
		    		sb.append(",");
		    	}
		    	sb.append(value);
		    	
			}
		}
	    return sb.toString();
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
	
	//是不是科技部人员
	public static boolean isKJBPerson(String unitPathIds)throws Exception
	{
		
		System.out.println("---------isKJBPerson--unitPathId="+unitPathIds);
		boolean flag=false;//默认不是
		if(!unitPathIds.equals(""))
		{
			String array[]=unitPathIds.split(",");
			for(int i=0;i<array.length;i++)
			{
				String strPath=array[i];
				if(strPath!=null && !strPath.equals(""))
				{
					if(strPath.length()>4)
					{
						String parentUnitPathId=strPath.substring(0, strPath.length()-4);
						if(parentUnitPathId.equals(EquipmentUtils.KJB_UNIONPATH_NUM))
						{
							flag=true;
							
							System.out.println("------------------isKJBPerson 是科技部人员-----------------------");
						}
					}
				}
				
			}
		}
		return flag;
	}
	
	
	
	
	
	public static LayuiTableData getHanaSupplierByIds(String supplierIds,String companyCode,HttpServletRequest request, HttpServletResponse response,RestTemplate restTemplate,HttpHeaders httpHeaders)
	{
		
		String GET_DIC_SUPPLYER_HANA_BY_IDS = "http://pcitc-zuul/hana-proxy/hana/common/dic/get_supplier_hana_by_ids";
		LayuiTableData layuiTableData = new LayuiTableData();
		ResponseEntity<List> responseEntity = null;
		List returnlist = new ArrayList();
		if (!supplierIds.equals("")) 
		{
				Map<String, Object> paramsMap = new HashMap<String, Object>();
				paramsMap.put("companyCode", companyCode);
				paramsMap.put("supplierIds", supplierIds);
				JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
				HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
				responseEntity = restTemplate.exchange(GET_DIC_SUPPLYER_HANA_BY_IDS, HttpMethod.POST, entity, List.class);
				int statusCode = responseEntity.getStatusCodeValue();
				if (statusCode == 200) 
				{
					returnlist = responseEntity.getBody();
				}
			
		}
		layuiTableData.setData(returnlist);
		layuiTableData.setCode(0);
		layuiTableData.setCount(returnlist.size());
		return layuiTableData;
		
	}
	
	
   //根据unitId获得机构下岗位列表
	public static List<SysPost>  getPostListByUnitId(String unitId,RestTemplate restTemplate,HttpHeaders httpHeaders) throws Exception
	{
	     String GET_POST_LIST_BYUNIT = "http://pcitc-zuul/system-proxy/post-provider/post/get-post-json";
	     JSONArray jSONArray = restTemplate.exchange(GET_POST_LIST_BYUNIT, HttpMethod.POST, new HttpEntity<String>(unitId, httpHeaders), JSONArray.class).getBody();
	     List<SysPost> list = JSONObject.parseArray(jSONArray.toJSONString(), SysPost.class);
	     return list;
	}
	
	
	//根据UnitPath检索机构信息
	public static SysUnit getUnitByUnitPath(String unitPath,RestTemplate restTemplate,HttpHeaders httpHeaders) throws Exception
	{
		 String UNIT_GET_UNIT = "http://pcitc-zuul/system-proxy/unit-provider/unit/getUnitByUnitPath/";
		 SysUnit unit = restTemplate.exchange(UNIT_GET_UNIT + unitPath, HttpMethod.POST, new HttpEntity<Object>(httpHeaders), SysUnit.class).getBody();
		 return unit;
	}
	
	//根据机构编码检索机构信息
	public static SysUnit getUnitByUnitCode(String unitCode,RestTemplate restTemplate,HttpHeaders httpHeaders) throws Exception
	{
		 String UNIT_GET_UNIT = "http://pcitc-zuul/system-proxy/unit-provider/unit/get-unit-bycode/";
		 SysUnit unit = restTemplate.exchange(UNIT_GET_UNIT + unitCode, HttpMethod.POST, new HttpEntity<Object>(httpHeaders), SysUnit.class).getBody();
		 return unit;
	}
	
	//根据机构ID检索机构信息
	public static SysUnit getUnitByUnitId(String unitId,RestTemplate restTemplate,HttpHeaders httpHeaders) throws Exception
	{
		 String UNIT_GET_UNIT = "http://pcitc-zuul/system-proxy/unit-provider/unit/get-unit/";
		 SysUnit unit = restTemplate.exchange(UNIT_GET_UNIT + unitId, HttpMethod.POST, new HttpEntity<Object>(httpHeaders), SysUnit.class).getBody();
		 return unit;
	}
	
	
	//得到父类的codes
	public static String getUnitParentCodesByUnitCodes(String unitCodes,RestTemplate restTemplate,HttpHeaders httpHeaders) throws Exception
	{
		StringBuffer sb_code=new StringBuffer();
		if(unitCodes!=null && !unitCodes.equals(""))
		{
			String arr[]=unitCodes.split(",");
			for(int i=0;i<arr.length;i++)
			{
				String unitCode=arr[i];
				if(unitCode!=null)
				{
					SysUnit sysUnit=getUnitByUnitCode( unitCode, restTemplate, httpHeaders);
					String unitPathId=sysUnit.getUnitPath();
					if(unitPathId.length()>4)
					{
						String	parentUnitPathId=unitPathId.substring(0, unitPathId.length()-4);
						SysUnit sysUnit_temp=EquipmentUtils.getUnitByUnitPath(parentUnitPathId, restTemplate, httpHeaders);
						String code =sysUnit_temp.getUnitCode();
						if(i>0)
						{
							sb_code.append(",");
						}
						sb_code.append(code);
					}
				}
			}
		}
		return sb_code.toString();
	}
	
	public static Map getJoinUnitParentNamesByUnitId(String joinUnitIds,RestTemplate restTemplate,HttpHeaders httpHeaders) throws Exception
	{
		Map map=new HashMap();
		StringBuffer sb_name=new StringBuffer();
		StringBuffer sb_code=new StringBuffer();
		if(joinUnitIds!=null && !joinUnitIds.equals(""))
		{
			String arr[]=joinUnitIds.split(",");
			for(int i=0;i<arr.length;i++)
			{
				String unitId=arr[i];
				if(unitId!=null)
				{
					SysUnit sysUnit=getUnitByUnitId( unitId, restTemplate, httpHeaders);
					String unitPathId=sysUnit.getUnitPath();
					if(unitPathId.length()>4)
					{
						String	parentUnitPathId=unitPathId.substring(0, unitPathId.length()-4);
						SysUnit sysUnit_temp=EquipmentUtils.getUnitByUnitPath(parentUnitPathId, restTemplate, httpHeaders);
						if(sysUnit_temp!=null)
						{
							String name = sysUnit_temp.getUnitName();
							String code =sysUnit_temp.getUnitCode();
							if(i>0)
							{
								sb_name.append(",");
							}
							sb_name.append(name);
							
							if(i>0)
							{
								sb_code.append(",");
							}
							sb_code.append(code);
						}
					}
					
				}
			}
		}
		
		String joinUnitParentCodes=sb_code.toString();
		String joinUnitParentNames=sb_name.toString();
		map.put("joinUnitParentCodes", joinUnitParentCodes);
		map.put("joinUnitParentNames", joinUnitParentNames);
		return map;
	}
	
	

	public static String  createWord_setup(String setupId,String filePath,SreProject sreProject ,SreProjectTask sreProjectTask ,SreProjectSetup sreProjectSetup,  HttpServletResponse response)
	{
		
		String  resutl="";
		// 文件名称
		String fileName;
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			/** 组装数据 */
			dataMap.put("topicName", sreProject.getName());            //项目名称
			dataMap.put("leadUnitName", sreProject.getLeadUnitName());//负责单位
			dataMap.put("projecChargeUserName", sreProjectSetup.getProjecChargeUserName());//项目负责人
			dataMap.put("projecChargeUserTitle", sreProjectSetup.getProjecChargeUserTitle());//职      称
			dataMap.put("beginProjectMonth", sreProjectTask.getBeginProjectMonth());//项目执行年限
			dataMap.put("endProjectMonth", sreProjectTask.getEndProjectMonth());//项目执行年限
			dataMap.put("setupReasons", sreProjectSetup.getSetupReasons());//立项理由
			dataMap.put("facilities", sreProjectSetup.getFacilities());//建设场地、公用工程
			dataMap.put("projectProgress", sreProjectSetup.getProjectProgress());//项目实施方案和进度
			dataMap.put("userEffect", sreProjectSetup.getUserEffect());//使用效果和效益的分析
			
			//项目内容和主要图表
			String taskContentStr=sreProjectSetup.getMainTable();
			List<Map<String, Object>> mainTableList =getEqiupmentTableList( taskContentStr);
			dataMap.put("mainTableList", mainTableList);
			int taskContentListCount=mainTableList.size();
			dataMap.put("taskContentListCount", taskContentListCount);//项目内容和主要图表-数量
			Float hj_tc=getEqiupmentTableCountMoney(taskContentStr);
			dataMap.put("hj_tc", hj_tc);//项目内容和主要图表-经费合计
			
			//项目资金安排--牵头单位
			String projectFundsTableStr=sreProjectSetup.getFundsTable();
			List<Map<String, Object>> leadUnitList =getLeadUnitNameTableList( projectFundsTableStr);
			dataMap.put("leadUnitList", leadUnitList);
			
			
			///预计资金来源表
			String fundsSourcesTableStr=sreProjectSetup.getSourcesTable();
			List<Map<String, Object>> fundsSourcesTableList = 	getSourcesTableList( fundsSourcesTableStr);
			dataMap.put("fundsSourcesTableList", fundsSourcesTableList);
			
			//项目资金安排--参与单位
			String yearFeeStrJoinUnit=sreProjectSetup.getYearFeeStrJoinUnit();
			List<JoinUnitWord> joinUnitWordlist=getJoinUnitWordList(yearFeeStrJoinUnit);
			dataMap.put("joinUnitWordlist", joinUnitWordlist);
			
			fileName =DateUtil.dateToStr(new Date(), DateUtil.FMT_SSS_02)+".doc";
			/** 生成word */
			boolean flage=WordUtil.createWord(dataMap, "setup.ftl", filePath, fileName);
			if(flage==true)
			{
				resutl=fileName;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resutl;
	}
	
	
	
	    //装备-主要图表-合计
		private  static Float  getEqiupmentTableCountMoney(String taskContentStr)
		{
			System.out.println("---------项目内容和主要图表    源: "+taskContentStr);
			String taskContent_arr[]=taskContentStr.split("\\|");
			Float hj_tc=0f;
			if(taskContent_arr!=null && taskContent_arr.length>0)
			{
			   for(int i=0;i<taskContent_arr.length;i++)
			   {
				   String str=taskContent_arr[i];
				   if(str!=null && !str.equals(""))
				   {
					   String temp[]=str.split("#");
					 
					   Map<String, Object> map = new HashMap<String, Object>();
					   String taskContent1=temp[0].trim();
					   String taskContent2=temp[1].trim();
					   String taskContent3=temp[2].trim();
					   String taskContent4=temp[3].trim();
					   hj_tc=hj_tc.floatValue()+Float.valueOf(taskContent4.trim()).floatValue();
					   
				   }
			   }
			}
			return hj_tc;
		}
	//装备-主要图表
		public  static List<Map<String, Object>>  getEqiupmentTableList(String taskContentStr)
	{
		System.out.println("---------项目内容和主要图表    源: "+taskContentStr);
		List<Map<String, Object>> mainTableList = new ArrayList<Map<String, Object>>();
		String taskContent_arr[]=taskContentStr.split("\\|");
		if(taskContent_arr!=null && taskContent_arr.length>0)
		{
			Float hj_tc=0f;
		   for(int i=0;i<taskContent_arr.length;i++)
		   {
			   String str=taskContent_arr[i];
			   if(str!=null && !str.equals(""))
			   {
				   String temp[]=str.split("#");
				 
				   Map<String, Object> map = new HashMap<String, Object>();
				   String taskContent1=temp[0].trim();
				   String taskContent2=temp[1].trim();
				   String taskContent3=temp[2].trim();
				   String taskContent4=temp[3].trim();
				   hj_tc=hj_tc.floatValue()+Float.valueOf(taskContent4.trim()).floatValue();
				   String taskContent5=temp[4];
				   
				   //System.out.println("----taskContent5--"+taskContent5);
				   if(taskContent5==null || taskContent5.equals("null"))
				   {
					   taskContent5="";
				   }
				   map.put("taskc1", taskContent1);
				   map.put("taskc2", taskContent2);
				   map.put("taskc3", taskContent3);
				   map.put("taskc4", taskContent4);
				   map.put("taskc5", taskContent5);
				   mainTableList.add(map);
				   
			   }
		   }
		}
		JSONArray taskContentList_jSONArray= JSONArray.parseArray(JSON.toJSONString(mainTableList));
		System.out.println("---------项目内容和主要图表 FTL: "+taskContentList_jSONArray.toString());
		return mainTableList;
	}
	
	
	//预计资金来源表
	public  static List<Map<String, Object>>  getSourcesTableList(String fundsSourcesTableStr)
	{
		System.out.println("---------预计资金来源表 （源）: "+fundsSourcesTableStr);
		List<Map<String, Object>> fundsSourcesTableList = new ArrayList<Map<String, Object>>();
		String fundsSourcesTableStr_arr[]=fundsSourcesTableStr.split("\\|");//多行
		if(fundsSourcesTableStr_arr!=null && fundsSourcesTableStr_arr.length>0)
		{
		   for(int i=0;i<fundsSourcesTableStr_arr.length;i++)
		   {
			   String str=fundsSourcesTableStr_arr[i];
			   if(str!=null && !str.equals(""))
			   {
				   String temp[]=str.split("#");
				   Map<String, Object> map = new HashMap<String, Object>();
				   String taskContent1=temp[0].trim();
				   String taskContent2=temp[1].trim();
				   String taskContent3=temp[2].trim();
				   String taskContent4=temp[3].trim();
				   String taskContent5=temp[4].trim();
				   
				   map.put("ft1", taskContent1);
				   map.put("ft2", taskContent2);
				   map.put("ft3", taskContent3);
				   map.put("ft4", taskContent4);
				   map.put("ft5", taskContent5);
				   Float ft6=Float.parseFloat(taskContent2)+Float.parseFloat(taskContent3)+Float.parseFloat(taskContent4)+Float.parseFloat(taskContent5);
				   map.put("ft6", ft6);
				   fundsSourcesTableList.add(map);
			   }
		   }
		}
		JSONArray fundsSourcesTableList_jSONArray= JSONArray.parseArray(JSON.toJSONString(fundsSourcesTableList));
		System.out.println("---------预计资金来源表 （FTL） : "+fundsSourcesTableList_jSONArray.toString());
		return fundsSourcesTableList;
	}
	
	
	
	//项目资金安排--牵头单位
	public  static List<Map<String, Object>>  getLeadUnitNameTableList(String projectFundsTableStr)
	{
		
		System.out.println("---------项目资金安排 （源）: "+projectFundsTableStr);
		List<Map<String, Object>> leadUnitList = new ArrayList<Map<String, Object>>();
		String projectFundsTableStr_arr[]=projectFundsTableStr.split("#");//多行
		double hj_pt2=0l;
		double hj_pt3=0l;
		double hj_pt4=0l;
		if(projectFundsTableStr_arr!=null && projectFundsTableStr_arr.length>0)
		{
		   for(int i=0;i<projectFundsTableStr_arr.length;i++)
		   {
			   String str=projectFundsTableStr_arr[i];
			   if(str!=null && !str.equals(""))
			   {
				   String temp[]=str.split(",");
				   Map<String, Object> map = new HashMap<String, Object>();
				   String pt1=temp[0];
				   String pt2=temp[1].trim();
				   double pt2_double= Double.valueOf(pt2).doubleValue();
				   hj_pt2=hj_pt2+pt2_double;
				   String pt3=temp[2].trim();
				   double pt3_double= Double.valueOf(pt3).doubleValue();
				   hj_pt3=hj_pt3+pt3_double;
				   String pt4=temp[3].trim();
				   double pt34_double= Double.valueOf(pt4).doubleValue();
				   hj_pt4=hj_pt4+pt34_double;
				   map.put("pt1", pt1);
				   map.put("pt2", pt2);
				   map.put("pt3", pt3);
				   map.put("pt4", pt4);
				   leadUnitList.add(map);
				   
			   }
		   }
		}
		
		Map<String, Object> map_temp_pt = new HashMap<String, Object>();
		map_temp_pt.put("pt1", "合  计");
		map_temp_pt.put("pt2", hj_pt2);
		map_temp_pt.put("pt3", hj_pt3);
		map_temp_pt.put("pt4", hj_pt4);
		//System.out.println("==========hj_pt2"+hj_pt2+"pt3="+hj_pt3);
		leadUnitList.add(map_temp_pt);
		
		
		JSONArray projectFundsTableList_jSONArray= JSONArray.parseArray(JSON.toJSONString(leadUnitList));
		System.out.println("---------项目资金安排（FTL） : "+projectFundsTableList_jSONArray.toString());
		return leadUnitList;
	}
	
	
	
	//项目资金安排--参与单位
	//2019-2020,苏州大学,014ef79138eb4fc49f24e4439419a5a9#2019,0,66,66.00#2020,0,666,666.00;2019-2020,中国石化上海石油化工股份有限公司,0175a09e3fac45e994e446957b714b1e#2019,0,66,66.00#2020,0,666,666.00
	public  static List<JoinUnitWord> getJoinUnitWordList(String yearFeeStrJoinUnit)
	{
		
		
		List<JoinUnitWord> joinUnitWordlist=new ArrayList<JoinUnitWord>();
		if(yearFeeStrJoinUnit!=null && !yearFeeStrJoinUnit.equals(""))
		{
			String yearFeeStrJoinUnit_arr[]=yearFeeStrJoinUnit.split(";");//多行
			if(yearFeeStrJoinUnit_arr!=null && yearFeeStrJoinUnit_arr.length>0)
			{
			   for(int i=0;i<yearFeeStrJoinUnit_arr.length;i++)
			   {
				   String str=yearFeeStrJoinUnit_arr[i];//2019-2020,中国石化上海石油化工股份有限公司,0175a09e3fac45e994e446957b714b1e#2019,0,100,100#2020,0,200,200
				   if(str!=null && !str.equals(""))
				   {
					   JoinUnitWord joinUnitWord=new JoinUnitWord();
					   String unitNamestr= str.split("#")[0].split(",")[1];//中国石化上海石油化工股份有限公司
					   joinUnitWord.setNuitName(unitNamestr);
					   String arr[]=str.split("#");
					   if(arr!=null && arr.length>0)
					   {
						   List<Map<String, Object>> nuitList = new ArrayList<Map<String, Object>>();
						   double hj_pt3=0l;
						   double hj_pt4=0l;
						   double hj_pt5=0l;
						   for(int j=1;j<arr.length;j++)
						   {
							   String str_value_str=arr[j];//2019,0,100,100
							   String [] arr_unit_str_temp=str_value_str.split(",");
							   String ept2=arr_unit_str_temp[0].trim();
							   String ept3=arr_unit_str_temp[1].trim();
							   String ept4=arr_unit_str_temp[2].trim();
							   String ept5=arr_unit_str_temp[3].trim();
							   Map<String, Object> map_value = new HashMap<String, Object>();
							   map_value.put("ept2", ept2);
							   map_value.put("ept3", ept3);
							   map_value.put("ept4", ept4);
							   map_value.put("ept5", ept5);
							   nuitList.add(map_value);
							   double pt2_double= Double.valueOf(ept3).doubleValue();
							   hj_pt3=hj_pt3+pt2_double;
							   
							   double pt3_double= Double.valueOf(ept4).doubleValue();
							   hj_pt4=hj_pt4+pt3_double;
							   
							   double pt4_double= Double.valueOf(ept5).doubleValue();
							   hj_pt5=hj_pt5+pt4_double;
						   }
						   
							Map<String, Object> map_temp_pt = new HashMap<String, Object>();
							map_temp_pt.put("ept2", "合  计");
							map_temp_pt.put("ept3", hj_pt3);
							map_temp_pt.put("ept4", hj_pt4);
							map_temp_pt.put("ept5", hj_pt5);
							nuitList.add(map_temp_pt);
							
						   joinUnitWord.setNuitList(nuitList);
					   }
					   joinUnitWordlist.add(joinUnitWord);
					   
				   }
			   }
			}
		}
		
		return joinUnitWordlist;
		
	}
	
	//资金概算表
	public  static Map getBudgetTableList(String budgetTableStr)
	{
		System.out.println("---------资金概算表----  源: "+budgetTableStr);
		Map resultMap=new HashMap();
		List<Map<String, Object>> budgetTableStrList_zb = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> budgetTableStrList_fy= new ArrayList<Map<String, Object>>();
		String budgetTableStrList_arr[]=budgetTableStr.split("\\|");//多行
		Float budgetTable_hj=0f;
		if(budgetTableStrList_arr!=null && budgetTableStrList_arr.length>0)
		{
		   for(int i=0;i<budgetTableStrList_arr.length;i++)
		   {
			   String str=budgetTableStrList_arr[i];
			   if(str!=null && !str.equals(""))
			   {
				   String temp[]=str.split("#");
				   Map<String, Object> map = new HashMap<String, Object>();
				   String content1=temp[0];
				   
				   String zj1=temp[1].trim();
				   String zj2=temp[2].trim();
				   String zj3=temp[3].trim();
				   String zj4=temp[4].trim();
				   map.put("zj1", zj1);
				   map.put("zj2", zj2);
				   map.put("zj3", zj3);
				   map.put("zj4", zj4);
				  
				   if(content1.equals("资本性支出"))
				   {
					   budgetTableStrList_zb.add(map);
				   }
				   if(content1.equals("费用性支出"))
				   {
					   budgetTableStrList_fy.add(map);
				   }
				   if(zj1.equals("小计"))
				   {
					   Float fp3faot= Float.parseFloat(zj3);
					   budgetTable_hj=budgetTable_hj.floatValue()+fp3faot.floatValue();
				   }
			   }
		   }
		}
		
		JSONArray budgetTableStrList_zb_jSONArray= JSONArray.parseArray(JSON.toJSONString(budgetTableStrList_zb));
		System.out.println("---------资金概算表--资本性  FTL: "+budgetTableStrList_zb_jSONArray.toString());
		JSONArray budgetTableStrList_fy_jSONArray= JSONArray.parseArray(JSON.toJSONString(budgetTableStrList_fy));
		System.out.println("---------资金概算表--费用性   FTL: "+budgetTableStrList_fy_jSONArray.toString());
		
		resultMap.put("budgetTable_hj", budgetTable_hj);
		resultMap.put("budgetTableStrList_zb", budgetTableStrList_zb);
		resultMap.put("budgetTableStrList_fy", budgetTableStrList_fy);
		return resultMap;
	}
	
	
	
	//根据任务书专处业--》自动到各专业领域
	public  static String getTaskSpecialAuditor0ByProfessionalDepartName(String professionalDepartName)
	{
		String specialAuditor0="";
		if(professionalDepartName.contains("勘探开发")==true)
		{
			specialAuditor0="";//关晓东
		}
		if(professionalDepartName.contains("石油工程")==true)
		{
			specialAuditor0="";//陈本池
		}
		if(professionalDepartName.contains("炼油")==true)
		{
			specialAuditor0="30130056_LYC_ZYCCZ";//潘煜
		}
		if(professionalDepartName.contains("化工")==true)
		{
			specialAuditor0="";//方志平
		}
		if(professionalDepartName.contains("合成材料")==true)
		{
			specialAuditor0="";//庄毅
		}
		if(professionalDepartName.contains("装备与储运")==true)
		{
			specialAuditor0="";//卢衍波
		}
		if(professionalDepartName.contains("知识产权")==true)
		{
			specialAuditor0="";//陈蓓艳
		}
		if(professionalDepartName.contains("三剂")==true)
		{
			specialAuditor0="30130062_SJC_ZYCCZ";//林雯
		}
		if(professionalDepartName.contains("技术监督")==true)
		{
			specialAuditor0="30130063_JSJDC_ZYCCZ";//秦士珍
		}
		return specialAuditor0;
	}
	
	
	public static SysUser getSysUserByUserId(String userId,RestTemplate restTemplate,HttpHeaders httpHeaders)
	{
		String USER_DETAILS_URL = "http://pcitc-zuul/system-proxy/user-provider/user/user-details/";
		SysUser userDetails = restTemplate.exchange(USER_DETAILS_URL + userId, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), SysUser.class).getBody();
		return userDetails;
	}
	
	/*
	public static Map getDepartInfoBySysUser(SysUser sysUserInfo,RestTemplate restTemplate,HttpHeaders httpHeaders)throws Exception
	{
		Map<String ,String> map=new HashMap<String ,String>();
		String parentUnitPathNames = "";//申报单位
		String parentUnitPathIds = "";//申报单位
		String applyDepartName = "";//申报部门
		String applyDepartCode = "";//申报部门
		
		String unitCode = sysUserInfo.getUnitCode();//00000,108811,108811002
		String unitName = sysUserInfo.getUnitName();//中国石油化工集团,中国石油化工股份有限公司石油勘探开发研究院,油气勘探研究所
		System.out.println("==========unitName="+unitName+" unitCode:"+unitCode);
		//字电表八大院，匹配用户机构(如果用户机构中包含字典表中的院，说明是院所人员)
		List<SysDictionary> dicList = EquipmentUtils.getSysDictionaryListByParentCode("ROOT_UNIVERSAL_BDYJY", restTemplate,httpHeaders);
		if(dicList!=null && dicList.size()>0)
		{
			for(int i=0;i<dicList.size();i++)
			{
				SysDictionary sysDictionary=dicList.get(i);
				String value=sysDictionary.getNumValue();
				String name=sysDictionary.getName();
				String arr[]=unitCode.split(",");
				if(arr!=null && arr.length>0)
				{
					for(int j=0;j<arr.length;j++)
					{
						String code=arr[j];
						if(code.equals(value))
						{
							parentUnitPathIds=code;
							parentUnitPathNames=name;
						}
					}
				}
			}
		}
		//根据单位--》找出下级部门（中国石油化工集团,中国石油化工股份有限公司石油勘探开发研究院,油气勘探研究所）
		if(!parentUnitPathIds.equals(""))
		{
			String arr[]=unitCode.split(",");
			if(arr!=null && arr.length>0)
			{
				for(int j=0;j<arr.length;j++)
				{
					String code=arr[j];
					if(code.length()>6 && code.contains(parentUnitPathIds))//部门：9位,且包含单位代码
					{
						applyDepartCode=code;
						applyDepartName= getParentUnitPathName(applyDepartCode, restTemplate, httpHeaders);
					}
					
				}
			}
		}
		
		map.put("parentUnitPathNames", parentUnitPathNames);
		map.put("parentUnitPathIds", parentUnitPathIds);
		map.put("applyDepartName", applyDepartName);
		map.put("applyDepartCode", applyDepartCode);
		
		return map;
		
	}
	*/
	
	
	
	public static String getParentUnitPathId(String unitPathIds)
	{
		
		System.out.println("-------------unitPathIds: " + unitPathIds);
		String parentUnitPathIds = "";
		if (unitPathIds != null && !unitPathIds.equals("")) 
		{

			String arr[] = unitPathIds.split(",");
			if (arr.length > 1) 
			{
				unitPathIds = arr[1];
				System.out.println("--------------取第一个" + unitPathIds);
			} else {
				unitPathIds = arr[0];
			}
			if (unitPathIds.length() > 4) 
			{
				parentUnitPathIds = unitPathIds.substring(0, unitPathIds.length() - 4);
				System.out.println("------------parentUnitPathIds: " + parentUnitPathIds);
			}
		}
		return parentUnitPathIds;
	}
	
	
	
	public static String getParentUnitPathName(String parentUnitPathId,RestTemplate restTemplate,HttpHeaders httpHeaders)throws Exception 
	{
		String parentUnitPathNames="";
		SysUnit sysUnit = EquipmentUtils.getUnitByUnitPath(parentUnitPathId, restTemplate, httpHeaders);
		if (sysUnit != null) {
			parentUnitPathNames = sysUnit.getUnitName();
		}
		return parentUnitPathNames;
	}
	
	
	/*	public static void main(String[] args) 
	{
			String year=DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY);
			
			year=year.substring(2);
		
		System.out.println("--------year: "+year);
		
	}*/
	
	
	public static SreDetail getSreDetail(String id,RestTemplate restTemplate,HttpHeaders httpHeaders)
	{
		SreDetail	sreDetail = null;
		ResponseEntity<SreDetail> responseEntity = restTemplate.exchange(GET_URL_Detail + id, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), SreDetail.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200)
		{
			sreDetail = responseEntity.getBody();
		}
		return sreDetail;
	}
	
	public static String createContractNum(SreProjectTask sreProjectTask,RestTemplate restTemplate,HttpHeaders httpHeaders)
	{
		
		
		
		String	str = "";
		String name=sreProjectTask.getProfessionalDepartName();
		String fieldName=sreProjectTask.getProfessionalFieldName();
		String year=DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY);
		
		year=year.substring(2);
		String endStr = CodeUtil.getCode("XTBM_0075", restTemplate, httpHeaders);
		
		if(name.contains("三剂"))//30130062
		{
			str="H"+year+endStr;
		}
		//8位
		if(name.contains("化工"))//30130057
		{
			str="4"+year+endStr;
		}
		if(name.contains("技术监督"))//30130063
		{
			str="7"+year+endStr;
		}
		if(name.contains("材料"))//30130058
		{
			str="2"+year+endStr;
		}
		//8位
		if(name.contains("炼油"))//30130056
		{
			str="8"+year+endStr;
		}
		if(name.contains("知识产权"))//30130061
		{
			str="9"+year+"";
		}
		if(name.contains("储运"))//30130059
		{
			str="3"+year+endStr;
		}
		if(name.contains("计划"))//30130054,计划处：R表示软课题、X表示基础研究、YK表示院控、5表示其他
		{
			String prix="5";
			if(fieldName.equals("软课题"))//3013005402
			{
				prix="R";
			}
			if(fieldName.equals("基础研究"))//3013005403
			{
				prix="X";
			}
			if(fieldName.equals("院控"))//
			{
				prix="YK";
			}
			str=prix+year+endStr;
		}
		if(name.contains("油气勘探"))//30130055,30130064
		{
			str="P"+year+endStr;
		}
		if(name.contains("石油工程"))//30130055,30130065
		{
			str="P"+year+endStr;
		}
		
		System.out.println("--------生成合同号: "+str);
		return str;
	}
	
	
}
