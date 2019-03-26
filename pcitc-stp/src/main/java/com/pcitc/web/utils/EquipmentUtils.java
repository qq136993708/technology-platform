package com.pcitc.web.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.stp.equipment.SreProject;
import com.pcitc.base.stp.equipment.SreProjectSetup;
import com.pcitc.base.stp.equipment.SreProjectTask;
import com.pcitc.base.system.SysUnit;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.system.SysUserProperty;
import com.pcitc.base.util.DateUtil;

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
	
	
	
	public static SysUnit getUnitByUnitPath(String unitPath,RestTemplate restTemplate,HttpHeaders httpHeaders) throws Exception
	{
		 String UNIT_GET_UNIT = "http://pcitc-zuul/system-proxy/unit-provider/unit/getUnitByUnitPath/";
		 SysUnit unit = restTemplate.exchange(UNIT_GET_UNIT + unitPath, HttpMethod.POST, new HttpEntity<Object>(httpHeaders), SysUnit.class).getBody();
		 return unit;
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
			Float hj_tc=0f;
			List<Map<String, Object>> mainTableList = new ArrayList<Map<String, Object>>();
			String taskContentStr=sreProjectSetup.getMainTable();
			String taskContent_arr[]=taskContentStr.split("\\|");
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
					   String taskContent5=temp[4];
					   
					   System.out.println("----taskContent5--"+taskContent5);
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
			dataMap.put("mainTableList", mainTableList);
			int taskContentListCount=mainTableList.size();
			dataMap.put("taskContentListCount", taskContentListCount);//项目内容和主要图表-数量
			dataMap.put("hj_tc", hj_tc);//项目内容和主要图表-经费合计
			JSONArray taskContentList_jSONArray= JSONArray.parseArray(JSON.toJSONString(mainTableList));
			System.out.println("---------项目内容和主要图表    源: "+taskContentStr);
			System.out.println("---------项目内容和主要图表 FTL: "+taskContentList_jSONArray.toString());
			
			
			//项目资金安排--牵头单位
			List<Map<String, Object>> leadUnitList = new ArrayList<Map<String, Object>>();
			String projectFundsTableStr=sreProjectSetup.getFundsTable();
			String projectFundsTableStr_arr[]=projectFundsTableStr.split("#");//多行
			double hj_pt2=0l;
			double hj_pt3=0l;
			double hj_pt4=0l;
			if(projectFundsTableStr_arr!=null && projectFundsTableStr_arr.length>0)
			{
			   for(int i=0;i<projectFundsTableStr_arr.length;i++)
			   {
				   String str=projectFundsTableStr_arr[i];
				   System.out.println("----------项目资金安排--str: "+str);
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
			System.out.println("==========hj_pt2"+hj_pt2+"pt3="+hj_pt3);
			leadUnitList.add(map_temp_pt);
			dataMap.put("leadUnitList", leadUnitList);
			
			System.out.println("---------项目资金安排 （源）: "+projectFundsTableStr);
			JSONArray projectFundsTableList_jSONArray= JSONArray.parseArray(JSON.toJSONString(leadUnitList));
			System.out.println("---------项目资金安排（FTL） : "+projectFundsTableList_jSONArray.toString());
			
			
			///预计资金来源表
			List<Map<String, Object>> fundsSourcesTableList = new ArrayList<Map<String, Object>>();
			String fundsSourcesTableStr=sreProjectSetup.getSourcesTable();
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
					  // String taskContent6=temp[5];
					   
					   map.put("ft1", taskContent1);
					   map.put("ft2", taskContent2);
					   map.put("ft3", taskContent3);
					   map.put("ft4", taskContent4);
					   map.put("ft5", taskContent5);
					  // map.put("ft6", taskContent6);
					   Float ft6=Float.parseFloat(taskContent2)+Float.parseFloat(taskContent3)+Float.parseFloat(taskContent4)+Float.parseFloat(taskContent5);
					   map.put("ft6", ft6);
					   fundsSourcesTableList.add(map);
					   
				   }
			   }
			}
			dataMap.put("fundsSourcesTableList", fundsSourcesTableList);
			System.out.println("---------预计资金来源表 （源）: "+fundsSourcesTableStr);
			JSONArray fundsSourcesTableList_jSONArray= JSONArray.parseArray(JSON.toJSONString(fundsSourcesTableList));
			System.out.println("---------预计资金来源表 （FTL） : "+fundsSourcesTableList_jSONArray.toString());
			
			
			//项目资金安排--参与单位
			//2019-2020,苏州大学,014ef79138eb4fc49f24e4439419a5a9#2019,0,66,66.00#2020,0,666,666.00;
			//2019-2020,中国石化上海石油化工股份有限公司,0175a09e3fac45e994e446957b714b1e#2019,0,66,66.00#2020,0,666,666.00
			List<Map<String, Object>> yearFeeStrJoinUnitTable_title_List = new ArrayList<Map<String, Object>>();
			List<Map<String, Object>> yearFeeStrJoinUnitTable_value_List = new ArrayList<Map<String, Object>>();
			String yearFeeStrJoinUnit=sreProjectSetup.getYearFeeStrJoinUnit();
			String yearFeeStrJoinUnit_arr[]=yearFeeStrJoinUnit.split(";");//多行
			
			if(yearFeeStrJoinUnit_arr!=null && yearFeeStrJoinUnit_arr.length>0)
			{
			   for(int i=0;i<yearFeeStrJoinUnit_arr.length;i++)
			   {
				   String str=yearFeeStrJoinUnit_arr[i];
				   if(str!=null && !str.equals("#"))
				   {
					  String arr_unit[]= str.split("#");
					  if(arr_unit!=null && arr_unit.length>0)
						{
						   for(int j=0;j<arr_unit.length;j++)
						   {
							   Map<String, Object> map_title = new HashMap<String, Object>();
							   Map<String, Object> map_value = new HashMap<String, Object>();
							   String arr_unit_str=arr_unit[j];
							   if(arr_unit_str!=null && !arr_unit_str.equals(""))
							   {
								   String unitName="";
								   String ept1="";
								   if(j==0)
								   {
									   unitName=arr_unit_str.split(",")[1];
									   map_title.put("ept1", unitName);
									   yearFeeStrJoinUnitTable_title_List.add(map_title);
								   }else
								   {
									  String [] arr_unit_str_temp=arr_unit_str.split(",");//2019,0,66,66.00
									  String ept2=arr_unit_str_temp[0].trim();
									  String ept3=arr_unit_str_temp[1].trim();
									  String ept4=arr_unit_str_temp[2].trim();
									  String ept5=arr_unit_str_temp[3].trim();
									  
									  
									  map_value.put("ept2", ept2);
									  map_value.put("ept3", ept3);
									  map_value.put("ept4", ept4);
									  map_value.put("ept5", ept5);
									  yearFeeStrJoinUnitTable_value_List.add(map_value);
								   }
							   }
							  
							   
							   
						   }
						}
					  
				   }
			   }
			}
			dataMap.put("yearFeeStrJoinUnitTable_title_List", yearFeeStrJoinUnitTable_title_List);
			dataMap.put("yearFeeStrJoinUnitTable_value_List", yearFeeStrJoinUnitTable_value_List);
			System.out.println("---------yearFeeStrJoinUnitTableList : "+yearFeeStrJoinUnitTable_value_List.size());
			
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
	
	
	
	
	
	
	
	/*public static void main(String[] args) {
		String ssr="02140001";
		ssr=ssr.substring(0, ssr.length()-4);
		System.out.println("ssr="+ssr);
	}*/
	

}
