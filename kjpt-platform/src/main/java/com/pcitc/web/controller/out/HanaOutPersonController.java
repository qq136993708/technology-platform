package com.pcitc.web.controller.out;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.ExcelException;
import com.pcitc.base.expert.ZjkBase;
import com.pcitc.base.out.OutPersonVo;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.PoiExcelExportUitl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value = "OutPerson-API",tags = {"外系统-人员接口"})
@RestController
public class HanaOutPersonController extends BaseController {
	
	
	/**
	 * 根据ID获取对象信息
	 */
	public static final String PAGE_OUTPROJECT_URL = "http://kjpt-zuul/stp-proxy/out_person/page";

	public static final String list = "http://kjpt-zuul/hana-proxy/out_person/test";
	
	
	
	
	
	
	
	
	
	
  	
	    @ApiOperation(value = "人才同步", notes = "人才同步")
		@RequestMapping(value = "/hana-api/out_person_list", method = RequestMethod.GET)
	    @ResponseBody
	   	public String out_person_list( HttpServletRequest request, HttpServletResponse response) throws Exception
	   	{
	   		
	   		
	   		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
	   		Map<String ,Object> paramMap = new HashMap<String ,Object>();
	   	    System.out.println(">>>>>>>>>jsgztj_data_exput_excel>>>>>>>>>>>>>>>>>>>");
	   		
	   		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
	   		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(list, HttpMethod.POST, httpEntity, JSONArray.class);
	   		int statusCode = responseEntity.getStatusCodeValue();
	   		List<OutPersonVo> list =new ArrayList();
	   		JSONArray jSONArray=null;
	   		if (statusCode == 200)
	   		{
	   			jSONArray = responseEntity.getBody();
	   			list = JSONObject.parseArray(jSONArray.toJSONString(), OutPersonVo.class);
	   			if(list!=null &&  list.size()>0)
	   			{
	   				for(int i=0;i<list.size();i++)
	   				{
	   				   OutPersonVo zjkBase= list.get(i);
	   				   System.out.println(">>>>>>getZjyxlmc>>>>>"+zjkBase.getZjyxlmc());
	   				   System.out.println(">>>>>>getZjy xwmc>>>>>"+zjkBase.getZjyxwmc());
	   				}
	   			}
	   		}
	   		   return jSONArray.toString();
	   	}
	    
	    
	    
	
    

}
