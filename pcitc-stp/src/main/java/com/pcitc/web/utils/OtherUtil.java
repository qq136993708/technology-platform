package com.pcitc.web.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.hana.report.ScientificInvestment;
import com.pcitc.base.stp.equipment.SreProjectTask;
import com.pcitc.base.system.SysNews;
import com.pcitc.base.system.SysNotice;
import com.pcitc.base.util.CommonUtil;

public class OtherUtil {
	
	
	private static final String TOP_NOTICE_LIST = "http://pcitc-zuul/system-proxy/sysNotice-provider/sysNotice_top_list";
	
	
	private static final String TOP_NEW_LIST = "http://pcitc-zuul/stp-proxy/sysnews-provider/list";
	
	
	public static List<SysNotice> getSysNoticeTopList(HttpServletRequest request,RestTemplate restTemplate,HttpHeaders httpHeaders)
	{
		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);//设置参数类型和编码
		String isTopRoll = CommonUtil.getParameter(request, "isTopRoll", "1" );
		String isPublished = CommonUtil.getParameter(request, "isPublished", "1" );
		Map<String ,Object> paramMap = new HashMap<String ,Object>();
		paramMap.put("isTopRoll", isTopRoll);
		paramMap.put("isPublished", isPublished);
		paramMap.put("isVariable", "1");
		
		System.out.println(">getSysNoticeTopList>>>>>>>>>>>>>>>>>>>>参数      isTopRoll = "+isTopRoll);
		
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,httpHeaders);
		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(TOP_NOTICE_LIST, HttpMethod.POST, httpEntity, JSONArray.class);
		int statusCode = responseEntity.getStatusCodeValue();
		List<SysNotice> list =new ArrayList();
		JSONArray jSONArray=null;
		if (statusCode == 200)
		{
			jSONArray = responseEntity.getBody();
			list = JSONObject.parseArray(jSONArray.toJSONString(), SysNotice.class);
			for(int i=0;i<list.size();i++)
			{
				SysNotice scientificInvestment=list.get(i);
				System.out.println(">>>>>>>>>>>>>>>>>>>>>参数      getG0GSJC = "+scientificInvestment.getNoticeTitle());
			}
		}
		return list;
	}
	
	
	public static List<SysNews> getSysNewsPicList(HttpServletRequest request,RestTemplate restTemplate,HttpHeaders httpHeaders)
	{
		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);//设置参数类型和编码
		Map<String ,Object> paramMap = new HashMap<String ,Object>();
		paramMap.put("stype", "ROOT_XTGL_XWLX_XWTP");
		paramMap.put("sysFlag", "ROOT_UNIVERSAL_WEHTHER_YES");
		System.out.println(">getSysNewsPicList>>>>>>>>>>>>>>>>>>>>参数      stype = "+"ROOT_XTGL_XWLX_XWTP");
		
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,httpHeaders);
		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(TOP_NEW_LIST, HttpMethod.POST, httpEntity, JSONArray.class);
		int statusCode = responseEntity.getStatusCodeValue();
		List<SysNews> list =new ArrayList();
		JSONArray jSONArray=null;
		if (statusCode == 200)
		{
			jSONArray = responseEntity.getBody();
			list = JSONObject.parseArray(jSONArray.toJSONString(), SysNews.class);
			for(int i=0;i<list.size();i++)
			{
				SysNews scientificInvestment=list.get(i);
				System.out.println(">>>>>>>>>>>>>>>>>>>> "+scientificInvestment.getTitle());
			}
		}
		return list;
	}
	
	
	
	
	
	
	

}
