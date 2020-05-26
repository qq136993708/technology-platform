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
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.PoiExcelExportUitl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value = "OutPerson-API",tags = {"外系统-人才同步接口"})
@RestController
public class HanaOutPersonController extends BaseController {
	
	
	/**
	 * 根据ID获取对象信息
	 */
	public static final String PAGE_OUTPROJECT_URL = "http://kjpt-zuul/stp-proxy/out_person/page";

	public static final String getHanaOutPersonBaseInfoList = "http://kjpt-zuul/hana-proxy/out_person/getHanaOutPersonBaseInfoList";
	public static final String getHanaPantentListByNum =      "http://kjpt-zuul/hana-proxy/out_person/getHanaPantentListByNum";
	
	
	
  	
	    @ApiOperation(value = "获取所有专家的基本信息", notes = "获取所有专家的基本信息")
		@RequestMapping(value = "/getHanaOutPersonBaseInfoList", method = RequestMethod.GET)
	    @ResponseBody
	   	public String getHanaOutPersonBaseInfoList( HttpServletRequest request, HttpServletResponse response) throws Exception
	   	{
	   		
	   		
	   		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
	   		Map<String ,Object> paramMap = new HashMap<String ,Object>();
	   	    System.out.println(">>>>>>>>>getHanaOutPersonBaseInfoList>>>>>>>>>>>>>>>>>>>");
	   		
	   		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
	   		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getHanaOutPersonBaseInfoList, HttpMethod.POST, httpEntity, JSONArray.class);
	   		int statusCode = responseEntity.getStatusCodeValue();
	   		List<OutPersonVo> list =new ArrayList();
	   		JSONArray jSONArray=null;
	   		if (statusCode == 200)
	   		{
	   			jSONArray = responseEntity.getBody();
	   			list = JSONObject.parseArray(jSONArray.toJSONString(), OutPersonVo.class);
	   			if(list!=null &&  list.size()>0)
	   			{
	   			    System.out.println(">>>>共>>>>>"+list.size()+"条");
	   				for(int i=0;i<list.size();i++)
	   				{
	   				   OutPersonVo zjkBase= list.get(i);
	   				   //System.out.println(">>>>>>人员编号，专家的主键pernr>>>>>"+zjkBase.getPernr());
	   				   //System.out.println(">>>>>单位zdwMc >>>>>"+zjkBase.getZdwmc());
	   				   //System.out.println(">>>>>姓名nachn >>>>>"+zjkBase.getNachn());
	   				  // System.out.println(">>>>>性别gesch >>>>>"+zjkBase.getGesch());
	   				  // System.out.println(">>>>>出生日期gbdat >>>>>"+zjkBase.getGbdat());
	   				  // System.out.println(">>>>>身份证号码icnum >>>>>"+zjkBase.getIcnum());
	   				}
	   			}
	   		}
	   		   return jSONArray.toString();
	   	}
	    
	    
	    
	    @ApiOperation(value = "根据专家编号查询专利信息", notes = "根据专家编号查询专利信息")
		@RequestMapping(value = "/getHanaPantentListByNum", method = RequestMethod.GET)
	    @ResponseBody
	   	public String getHanaPantentListByNum( HttpServletRequest request, HttpServletResponse response) throws Exception
	   	{
	   		
	    	String num=CommonUtil.getParameter(request, "num", "");
	   		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
	   		Map<String ,Object> paramMap = new HashMap<String ,Object>();
	   	    System.out.println(">>>>>>>>>getHanaPantentListByNum>>>>>>>>>>>>>>>>>num>>"+num);
	   	    paramMap.put("pernr", num);
	   		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
	   		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getHanaPantentListByNum, HttpMethod.POST, httpEntity, JSONArray.class);
	   		int statusCode = responseEntity.getStatusCodeValue();
	   		List<OutPersonVo> list =new ArrayList();
	   		JSONArray jSONArray=null;
	   		if (statusCode == 200)
	   		{
	   			jSONArray = responseEntity.getBody();
	   			list = JSONObject.parseArray(jSONArray.toJSONString(), OutPersonVo.class);
	   			if(list!=null &&  list.size()>0)
	   			{
	   			    System.out.println(">>>>共>>>>>"+list.size()+"条");
	   				for(int i=0;i<list.size();i++)
	   				{
	   				   OutPersonVo zjkBase= list.get(i);
	   				   System.out.println(">>>>>获得专利时间(zhdzlsj)>>>>>"+zjkBase.getZhdzlsj());
	   				   System.out.println(">>>>>序号 (seqnr) >>>>>"+zjkBase.getSeqnr9009());
	   				   System.out.println(">>>>>专利名称(zfmzlsj) >>>>>"+zjkBase.getZfmzlsj());
	   				   System.out.println(">>>>>专利号(zzlh) >>>>>"+zjkBase.getZzlh());
	   				   System.out.println(">>>>专利排名(zzlpm) >>>>>"+zjkBase.getZzlpm());
	   				}
	   			}
	   		}
	   		   return jSONArray.toString();
	   	}
	    
	    
    

}
