package com.pcitc.web.utils;

import java.util.Calendar;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.stp.equipment.SreProject;
import com.pcitc.base.stp.equipment.SreProjectSetup;
import com.pcitc.base.stp.equipment.SreProjectTask;

public class EquipmentUtils {
	
	private static final String GET_URL_EQUIPMENT= "http://pcitc-zuul/stp-proxy/sre-provider/equipment/get/";
	private static final String UPDATE_URL_EQUIPMENT = "http://pcitc-zuul/stp-proxy/sre-provider/equipment/update";
	private static final String DEL_URL_EQUIPMENT = "http://pcitc-zuul/stp-proxy/sre-provider/equipment/delete/";
	
	


	private static final String GET_URL_PROJECT = "http://pcitc-zuul/stp-proxy/sre-provider/project_basic/get/";
	private static final String UPDATE_URL_PROJECT = "http://pcitc-zuul/stp-proxy/sre-provider/project_basic/update";
	private static final String DEL_URL_PROJECT = "http://pcitc-zuul/stp-proxy/sre-provider/project_basic/delete/";
	
	
	private static final String GET_URL_TASK = "http://pcitc-zuul/stp-proxy/sre-provider/project_task/get/";
	private static final String UPDATE_URL_TASK = "http://pcitc-zuul/stp-proxy/sre-provider/project_task/update";
	private static final String DEL_URL_TASK = "http://pcitc-zuul/stp-proxy/sre-provider/project_task/delete/";
	
	
	private static final String GET_URL_SETUP = "http://pcitc-zuul/stp-proxy/sre-provider/project_setup/get/";
	private static final String UPDATE_URL_SETUP = "http://pcitc-zuul/stp-proxy/sre-provider/project_setup/update";
	private static final String DEL_URL_SETUP = "http://pcitc-zuul/stp-proxy/sre-provider/project_setup/delete/";
	
	
	
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
	
	
	
	

}
