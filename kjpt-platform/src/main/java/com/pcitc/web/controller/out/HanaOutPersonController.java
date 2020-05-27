package com.pcitc.web.controller.out;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Result;
import com.pcitc.base.expert.ZjkBaseSync;
import com.pcitc.base.expert.ZjkPatentSync;
import com.pcitc.base.out.OutPersonVo;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value = "OutPerson-API",tags = {"外系统-人才同步接口"})
@RestController
public class HanaOutPersonController extends BaseController {
	
	
	/**
	 * 根据ID获取对象信息
	 */
	public static final String PAGE_OUTPROJECT_URL = "http://kjpt-zuul/stp-proxy/out_person/page";
	//查询所有专家
	public static final String getHanaOutPersonBaseInfoList =   "http://kjpt-zuul/hana-proxy/out_person/getHanaOutPersonBaseInfoList";
	//查询所有专家相关专利
    public static final String getHanaOutPersonPatentList =     "http://kjpt-zuul/hana-proxy/out_person/getHanaOutPersonPatentList";
		
	public static final String getHanaPantentListByNum =        "http://kjpt-zuul/hana-proxy/out_person/getHanaPantentListByNum";
	
	public static final String BATCH_ADD_JZK_BASE_URL =         "http://kjpt-zuul/stp-proxy/sync-expert-api/insertBatchZjkBaseSync";
	
	public static final String BATCH_ADD_JZK_PATENT_URL =       "http://kjpt-zuul/stp-proxy/sync-expert-api/insertBatchPatent";
	
	
	
  	
	    @ApiOperation(value = "获取所有专家的基本信息", notes = "获取所有专家的基本信息")
		@RequestMapping(value = "/getHanaOutPersonBaseInfoList", method = RequestMethod.GET)
	    @ResponseBody
	   	public String getHanaOutPersonBaseInfoList( HttpServletRequest request, HttpServletResponse response) throws Exception
	   	{
	    	Result resultsDate = new Result();
	   		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
	   		Map<String ,Object> paramMap = new HashMap<String ,Object>();
	   	    System.out.println(">>>>>>>>>getHanaOutPersonBaseInfoList>>>>>>>>>>>>>>>>>>>");
	   		
	   		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
	   		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getHanaOutPersonBaseInfoList, HttpMethod.POST, httpEntity, JSONArray.class);
	   		int statusCode = responseEntity.getStatusCodeValue();
	   		List<OutPersonVo> list =new ArrayList();
	   		List<ZjkBaseSync> zjkBaseSyncList =new ArrayList();
	   		JSONArray jSONArray=null;
	   		if (statusCode == 200)
	   		{
	   			jSONArray = responseEntity.getBody();
	   			list = JSONObject.parseArray(jSONArray.toJSONString(), OutPersonVo.class);
	   			if(list!=null &&  list.size()>0)
	   			{
	   			    System.out.println(">>>>共>>>>>"+list.size()+"条");
	   			    resultsDate.setMessage("===HANA获取数据为: "+list.size()+"条");
	   				for(int i=0;i<list.size();i++)
	   				{
	   				   OutPersonVo zjkBase= list.get(i);
	   				   String expertNum=zjkBase.getPernr();
	   				   String postBm=zjkBase.getZzwjbbm();//职务级别编码
	   				   String post=zjkBase.getZzwjbmc();//职务级别名称
	   				   String title=zjkBase.getZprzyjszwjbmc();//职称名称
	   				   String education=zjkBase.getZjyzx();
	   				   String unitName=zjkBase.getZdwqc();
	   				   String unitId=zjkBase.getZdwbm();
	   				   String name=zjkBase.getNachn();
	   				   String sex=zjkBase.getGesch();
	   				   String idCardNo=zjkBase.getIcnum();
	   				   String birthDateStr=zjkBase.getGbdat();
	   				   
	   				    System.out.println(">>>>>职务 >>>>>"+post);
	   				    System.out.println(">>>>>职称 >>>>>"+title);
	   				    System.out.println(">>>>>birthDateStr >>>>>"+birthDateStr);
	   				   
	   				   ZjkBaseSync  zjkBaseSync=new ZjkBaseSync();
	   				   String dateid = UUID.randomUUID().toString().replaceAll("-", "");
	   				   zjkBaseSync.setId(dateid);
	   				   zjkBaseSync.setCreateTime(new Date());
	   				   zjkBaseSync.setBirthDateStr(birthDateStr);
	   				   zjkBaseSync.setPost(post);
	   				   zjkBaseSync.setTitle(title);
	   				   zjkBaseSync.setIdCardNo(idCardNo);
	   				   zjkBaseSync.setExpertNum(expertNum);
	   				   zjkBaseSync.setEducation(education);
	   				   zjkBaseSync.setName(name);
	   				   zjkBaseSync.setUnitId(unitId);
	   				   zjkBaseSync.setUnitName(unitName);
	   				   zjkBaseSync.setSex(sex);
	   				   if(birthDateStr!=null && !birthDateStr.equals(""))
	   				   {
	   					zjkBaseSync.setBirthDate(DateUtil.strToDate(birthDateStr, DateUtil.FMT_YYYY_DD));
	   				   }
	   				   zjkBaseSyncList.add(zjkBaseSync);
	   				}
	   			}
	   		}else
	   		{
	   			resultsDate.setSuccess(false);
	   			resultsDate.setMessage("===HANA获取数据为: "+list.size()+"条,但保存到本地失败===");
	   		}
	   		if(zjkBaseSyncList.size()>0)
	   		{
	   			JSONArray jsonObject = JSONArray.parseArray(JSON.toJSONString(zjkBaseSyncList));
				HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
				ResponseEntity<Integer> resEntity = restTemplate.exchange(BATCH_ADD_JZK_PATENT_URL, HttpMethod.POST, entity, Integer.class);
				Integer result=	resEntity.getBody();
				if(result.intValue()>0)
				{
					resultsDate.setSuccess(true);
					resultsDate.setData(jSONArray.toString());
				}else
				{
					resultsDate.setSuccess(false);
					resultsDate.setMessage("===HANA获取数据0条==");
				}
				
	   		}else
	   		{
	   			resultsDate.setSuccess(false);
				resultsDate.setMessage("===HANA获取数据0条==");
	   		}
	   		JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
	   		return ob.toString();
	   	}
	    
	    
	    
	    

	    @ApiOperation(value = "查询专利信息", notes = "查询专利信息")
		@RequestMapping(value = "/getHanaOutPersonPatentList", method = RequestMethod.GET)
	    @ResponseBody
	   	public String getHanaOutPersonPatentList( HttpServletRequest request, HttpServletResponse response) throws Exception
	   	{
	    	Result resultsDate = new Result();
	   		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
	   		Map<String ,Object> paramMap = new HashMap<String ,Object>();
	   	    System.out.println(">>>>>>>>>getHanaOutPersonPatentList>>>>>>>>>>>>>>>>>>>");
	   		
	   		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
	   		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getHanaOutPersonPatentList, HttpMethod.POST, httpEntity, JSONArray.class);
	   		int statusCode = responseEntity.getStatusCodeValue();
	   		List<OutPersonVo> list =new ArrayList<OutPersonVo>();
	   		List<ZjkPatentSync> zjkBaseSyncList =new ArrayList<ZjkPatentSync>();
	   		JSONArray jSONArray=null;
	   		if (statusCode == 200)
	   		{
	   			jSONArray = responseEntity.getBody();
	   			list = JSONObject.parseArray(jSONArray.toJSONString(), OutPersonVo.class);
	   			if(list!=null &&  list.size()>0)
	   			{
	   			    System.out.println(">>>>共>>>>>"+list.size()+"条");
	   			    resultsDate.setMessage("===HANA获取数据为: "+list.size()+"条");
	   				for(int i=0;i<list.size();i++)
	   				{
	   				   OutPersonVo vo= list.get(i);
	   				   String patentTimeStr= vo.getZhdzlsj();//获得专利时间
	   				   String outSysId= vo.getSeqnr9009();//序号
	   				   String patentName=vo.getZfmzlsj();//专利名称
	   				   String patentNum=vo.getZzlh();//专利号
	   				   String patentOrder=vo.getZzlpm();//专利排名
	   				   String expertNum= vo.getPernr();
	   				   

	   				   System.out.println(">>>>>patentTimeStr>>>>>"+patentTimeStr);
	   				   ZjkPatentSync  sync=new ZjkPatentSync();
	   				   String dateid = UUID.randomUUID().toString().replaceAll("-", "");
	   				   sync.setId(dateid);
	   				   sync.setCreateTime(new Date());
	   				   sync.setExpertNum(expertNum);
	   				   sync.setPatentNum(patentNum);
	   				   sync.setOutSysId(outSysId);
	   				   sync.setPatentName(patentName);
	   				   if(patentTimeStr!=null && !patentTimeStr.equals("")) 
	   				   {
	   					  sync.setPatentTime(DateUtil.strToDate(patentTimeStr, DateUtil.FMT_YYYY_DD));
	   				   }
	   				   if(patentOrder!=null && !patentOrder.equals("")) 
	   				   {
	   					sync.setPatentOrder(Integer.valueOf(patentOrder));
	   				   }
	   				   zjkBaseSyncList.add(sync);
	   				}
	   			}
	   		}else
	   		{
	   			resultsDate.setSuccess(false);
	   			resultsDate.setMessage("===HANA获取数据为: "+list.size()+"条,但保存到本地失败===");
	   		}
	   		if(zjkBaseSyncList.size()>0)
	   		{
	   			JSONArray jsonObject = JSONArray.parseArray(JSON.toJSONString(zjkBaseSyncList));
				HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
				ResponseEntity<Integer> resEntity = restTemplate.exchange(BATCH_ADD_JZK_BASE_URL, HttpMethod.POST, entity, Integer.class);
				Integer result=	resEntity.getBody();
				if(result.intValue()>0)
				{
					resultsDate.setSuccess(true);
					resultsDate.setData(jSONArray.toString());
				}else
				{
					resultsDate.setSuccess(false);
					resultsDate.setMessage("===HANA获取数据0条==");
				}
				
	   		}else
	   		{
	   			resultsDate.setSuccess(false);
				resultsDate.setMessage("===HANA获取数据0条==");
	   		}
	   		JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
	   		return ob.toString();
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
