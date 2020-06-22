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
import com.pcitc.base.expert.ZjkBase;
import com.pcitc.base.expert.ZjkBaseSync;
import com.pcitc.base.expert.ZjkPatent;
import com.pcitc.base.expert.ZjkPatentSync;
import com.pcitc.base.expert.ZjkRewardPunish;
import com.pcitc.base.expert.ZjkRewardPunishSync;
import com.pcitc.base.out.OutPerson;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value = "OutPerson-API",tags = {"人才同步"})
@RestController
public class PersonToPersonController extends BaseController {
	
	
	public static final String BATCH_ADD_OUT_PERSON_URL =   "http://kjpt-zuul/stp-proxy/out_person/insertBatchOutPerson";
	public static final String getPersonToPersonList =      "http://kjpt-zuul/stp-proxy/sync-expert-api/getZjkBaseSyncList";
	//专利
	public static final String BATCH_ADD_PATENT_URL =       "http://kjpt-zuul/stp-proxy/expert_patent/insertBatchZjkPatent";
	public static final String getZjkPatentSyncList =       "http://kjpt-zuul/stp-proxy/sync-expert-api/getZjkPatentList";
	//奖惩
	public static final String BATCH_ADD_PUNISH_URL =        "http://kjpt-zuul/stp-proxy/expert_punish/insertBatchPunish";
	public static final String getZjkRewardPunishSyncList =  "http://kjpt-zuul/stp-proxy/sync-expert-api/getPunishSSyncList";
	
	public static final String head_Pic="http://10.2.11.211:8080/WEB-IMG01/PIC/";//‘icnum’.jpg
	
  	
	    @ApiOperation(value = "专家临时同步到人才表", notes = "专家临时同步到人才表")
		@RequestMapping(value = "/getPersonToPersonList", method = RequestMethod.GET)
	    @ResponseBody
	   	public String getPersonToPersonList( HttpServletRequest request, HttpServletResponse response) throws Exception
	   	{
	    	Result resultsDate = new Result();
	   		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
	   		Map<String ,Object> paramMap = new HashMap<String ,Object>();
	   	    System.out.println(">>>>>>>>>getPersonToPersonList>>>>>>>>>>>>>>>>>>>");
	   		
	   		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
	   		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getPersonToPersonList, HttpMethod.POST, httpEntity, JSONArray.class);
	   		int statusCode = responseEntity.getStatusCodeValue();
	   		List<ZjkBaseSync> list =new ArrayList();
	   		List<OutPerson> zjkBaseSyncList =new ArrayList();
	   		JSONArray jSONArray=null;
	   		if (statusCode == 200)
	   		{
	   			jSONArray = responseEntity.getBody();
	   			list = JSONObject.parseArray(jSONArray.toJSONString(), ZjkBaseSync.class);
	   			if(list!=null &&  list.size()>0)
	   			{
	   			    System.out.println(">>>>共>>>>>"+list.size()+"条");
	   				for(int i=0;i<list.size();i++)
	   				{
	   				   ZjkBaseSync sync= list.get(i);
	   				   Date birthDate=sync.getBirthDate();
	   				   String title=sync.getTitleCode();
	   				   String post=sync.getPostCode();
	   				   String idCard=sync.getIdCardNo();
	   				   String name=sync.getName();
	   				   String belongUnitName=sync.getUnitName();
	   				   String belongUnitCode=sync.getUnitId();
	   				   String sexStr=sync.getSex();
	   				   String educationStr=sync.getEducation();
	   				   String educationCode=sync.getEducationCode();
	   				   String postStr=sync.getPost();
	   				   String titleStr=sync.getTitle();
	   				   
	   				   
	   				    OutPerson  outPerson=new OutPerson();
	   				    String dateid = UUID.randomUUID().toString().replaceAll("-", "");
		   				outPerson.setId(dateid);
		   				outPerson.setCreateTime(new Date());
		   				if(birthDate!=null)
		   				{
		   					outPerson.setBirthDate(birthDate);
		   					
		   					String year=DateUtil.dateToStr(birthDate, DateUtil.FMT_YYYY);
		   					String currentYear=DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY);
		   					outPerson.setAge(Integer.valueOf(currentYear).intValue()-Integer.valueOf(year).intValue());
		   					outPerson.setBirthYear(year);
		   				}else
		   				{
		   					outPerson.setAge(50);
		   				}
		   				outPerson.setTitle(title);
		   				outPerson.setTitleStr(titleStr);
		   				outPerson.setIsExpert("0");
		   				outPerson.setPost(post);
		   				outPerson.setHeadPic(head_Pic+idCard+".jpg");
		   				outPerson.setUserNo(sync.getExpertNum());
		   				outPerson.setIdCard(idCard); 
		   				outPerson.setPostStr(postStr);
		   				outPerson.setName(name);
		   				outPerson.setBelongUnitName(belongUnitName);
		   				outPerson.setBelongUnitCode(belongUnitCode);
		   				outPerson.setSexStr(sexStr);
		   				if(sexStr!=null)
		   				{
		   					if(sexStr.equals("男"))
			   				{
			   					outPerson.setSex("1");
			   				}else
			   				{
			   					outPerson.setSex("2");
			   				}
		   				}
		   				
		   				outPerson.setEducation(educationCode);
		   				outPerson.setEducationStr(educationStr);
	   				    zjkBaseSyncList.add(outPerson);
	   				}
	   			}
	   		}else
	   		{
	   			System.out.println(">>>ZjkBaseSync获取数据为0条----");
	   			resultsDate.setSuccess(false);
	   			resultsDate.setMessage("===ZjkBaseSync获取数据为: "+list.size()+"条,但保存到本地失败===");
	   		}
	   		if(zjkBaseSyncList.size()>0)
	   		{
	   			JSONArray jsonObject = JSONArray.parseArray(JSON.toJSONString(zjkBaseSyncList));
				HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
				ResponseEntity<Integer> resEntity = restTemplate.exchange(BATCH_ADD_OUT_PERSON_URL, HttpMethod.POST, entity, Integer.class);
				Integer result=	resEntity.getBody();
				if(result.intValue()>0)
				{
					resultsDate.setSuccess(true);
					resultsDate.setData(jSONArray.toString());
				}else
				{
					resultsDate.setSuccess(false);
					resultsDate.setMessage("===ZjkBaseSync获取数据0条==");
				}
				
	   		}else
	   		{
	   			resultsDate.setSuccess(false);
				resultsDate.setMessage("===ZjkBaseSync获取数据0条==");
	   		}
	   		JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
	   		return ob.toString();
	   	}
	    
	    
	    
	    
	    
	    
	    
	    @ApiOperation(value = "专利临时同步", notes = "专利临时同步")
		@RequestMapping(value = "/getPatentToPatentList", method = RequestMethod.GET)
	    @ResponseBody
	   	public String getPatentToPatentList( HttpServletRequest request, HttpServletResponse response) throws Exception
	   	{
	    	Result resultsDate = new Result();
	   		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
	   		Map<String ,Object> paramMap = new HashMap<String ,Object>();
	   	    System.out.println(">>>>>>>>>getPatentToPatentList>>>>>>>>>>>>>>>>>>>");
	   		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
	   		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getZjkPatentSyncList, HttpMethod.POST, httpEntity, JSONArray.class);
	   		int statusCode = responseEntity.getStatusCodeValue();
	   		List<ZjkPatentSync> list =new ArrayList<ZjkPatentSync>();
	   		List<ZjkPatent> zjkBaseSyncList =new ArrayList<ZjkPatent>();
	   		JSONArray jSONArray=null;
	   		if (statusCode == 200)
	   		{
	   			jSONArray = responseEntity.getBody();
	   			list = JSONObject.parseArray(jSONArray.toJSONString(), ZjkPatentSync.class);
	   			if(list!=null &&  list.size()>0)
	   			{
	   			    System.out.println(">>>>共>>>>>"+list.size()+"条");
	   				for(int i=0;i<list.size();i++)
	   				{
	   				    ZjkPatentSync sync= list.get(i);
	   				    String expertNum=sync.getExpertNum();//专家号
	   				    String notes=sync.getNotes();
	   				    String patentName=sync.getPatentName();
	   				    String patentNum=sync.getPatentNum();
	   				    Date patentTime=sync.getPatentTime();
	   				    String patentType=sync.getPatentType();
	   				    //
	   				    ZjkPatent  patent=new ZjkPatent();
	   				    String dateid = UUID.randomUUID().toString().replaceAll("-", "");
	   				    patent.setId(dateid);
	   				    patent.setCreateTime(new Date());
	   				    patent.setCreateTime(new Date());
	   				    patent.setDescriber(notes);
	   				    patent.setPatentName(patentName);
	   				    patent.setPatentType(patentType);
	   				    patent.setPatentNo(patentNum);
	   				    ZjkBase zz =EquipmentUtils.getZjkBaseByNum(expertNum, request, response, restTemplate, httpHeaders);
	   				    if(zz!=null)
	   				    {
	   				    	String expertId =zz.getId();
		   				    patent.setExpertId(expertId);
	   				    }
	   				    patent.setExpertNum(expertNum);
		   				if(patentTime!=null)
		   				{
		   					patent.setGetPatentTime(patentTime);
		   					
		   				}
	   				    zjkBaseSyncList.add(patent);
	   				}
	   			}
	   		}else
	   		{
	   			System.out.println(">>>ZjkPatentSync获取数据为0条----");
	   			resultsDate.setSuccess(false);
	   			resultsDate.setMessage("===ZjkPatentSync获取数据为: "+list.size()+"条,但保存到本地失败===");
	   		}
	   		if(zjkBaseSyncList.size()>0)
	   		{
	   			JSONArray jsonObject = JSONArray.parseArray(JSON.toJSONString(zjkBaseSyncList));
				HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
				ResponseEntity<Integer> resEntity = restTemplate.exchange(BATCH_ADD_PATENT_URL, HttpMethod.POST, entity, Integer.class);
				Integer result=	resEntity.getBody();
				if(result.intValue()>0)
				{
					resultsDate.setSuccess(true);
					resultsDate.setData(jSONArray.toString());
				}else
				{
					resultsDate.setSuccess(false);
					resultsDate.setMessage("===ZjkPatentSync获取数据0条==");
				}
				
	   		}else
	   		{
	   			resultsDate.setSuccess(false);
				resultsDate.setMessage("===ZjkPatentSync获取数据0条==");
	   		}
	   		JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
	   		return ob.toString();
	   	}
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    @ApiOperation(value = "奖惩临时同步", notes = "奖惩临时同步")
		@RequestMapping(value = "/getPunishToPunishList", method = RequestMethod.GET)
	    @ResponseBody
	   	public String getPunishToPunishList( HttpServletRequest request, HttpServletResponse response) throws Exception
	   	{
	    	Result resultsDate = new Result();
	   		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
	   		Map<String ,Object> paramMap = new HashMap<String ,Object>();
	   	    System.out.println(">>>>>>>>>getPunishToPunishList>>>>>>>>>>>>>>>>>>>");
	   		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
	   		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getZjkRewardPunishSyncList, HttpMethod.POST, httpEntity, JSONArray.class);
	   		int statusCode = responseEntity.getStatusCodeValue();
	   		List<ZjkRewardPunishSync> list =new ArrayList<ZjkRewardPunishSync>();
	   		List<ZjkRewardPunish> zjkBaseSyncList =new ArrayList<ZjkRewardPunish>();
	   		JSONArray jSONArray=null;
	   		if (statusCode == 200)
	   		{
	   			jSONArray = responseEntity.getBody();
	   			list = JSONObject.parseArray(jSONArray.toJSONString(), ZjkRewardPunishSync.class);
	   			if(list!=null &&  list.size()>0)
	   			{
	   			    System.out.println(">>>>共>>>>>"+list.size()+"条");
	   				for(int i=0;i<list.size();i++)
	   				{
	   					ZjkRewardPunishSync sync= list.get(i);
	   				    String expertNum=sync.getExpertNum();//专家号
	   				    String notes=sync.getNotes();
	   				    Date approveDate=  sync.getApproveDate();
	   				    String approveUnit=sync.getApproveUnit();
	   				    String expertId=sync.getExpertId();
		   				String outSysId=sync.getOutSysId();
		   				String rewardPunishLevel=sync.getRewardPunishLevel();
		   				String rewardPunishLevelCode=sync.getRewardPunishLevelCode();
		   				String rewardPunishType=sync.getRewardPunishType();
		   				String rewardPunishTypeCode=sync.getRewardPunishTypeCode();
		   				String rewardType=sync.getRewardType();
		   				String rewardTypeCode=sync.getRewardTypeCode();
		   				String title=sync.getTitle();
	   				    //
	   				    ZjkRewardPunish  patent=new ZjkRewardPunish();
	   				    String dateid = UUID.randomUUID().toString().replaceAll("-", "");
	   				    patent.setId(dateid);
	   				    patent.setCreateTime(new Date());
		   				patent.setApproveDate(approveDate);
		   				patent.setApproveUnit(approveUnit);
		   				patent.setExpertId(expertId);
		   				patent.setExpertNum(expertNum);
		   				patent.setNotes(notes);
		   				patent.setOutSysId(outSysId);
		   				patent.setRewardPunishLevel(rewardPunishLevel);
		   				patent.setRewardPunishLevelCode(rewardPunishLevelCode);
		   				patent.setRewardPunishType(rewardPunishType);
		   				patent.setRewardPunishTypeCode(rewardPunishTypeCode);
		   				patent.setTitle(title);
		   				patent.setRewardType(rewardType);
		   				patent.setRewardTypeCode(rewardTypeCode);
		   				patent.setNotes(notes);
	   				    zjkBaseSyncList.add(patent);
	   				}
	   			}
	   		}else
	   		{
	   			System.out.println(">>>ZjkRewardPunishSync获取数据为0条----");
	   			resultsDate.setSuccess(false);
	   			resultsDate.setMessage("===ZjkRewardPunishSync获取数据为: "+list.size()+"条,但保存到本地失败===");
	   		}
	   		if(zjkBaseSyncList.size()>0)
	   		{
	   			JSONArray jsonObject = JSONArray.parseArray(JSON.toJSONString(zjkBaseSyncList));
				HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
				ResponseEntity<Integer> resEntity = restTemplate.exchange(BATCH_ADD_PUNISH_URL, HttpMethod.POST, entity, Integer.class);
				Integer result=	resEntity.getBody();
				if(result.intValue()>0)
				{
					resultsDate.setSuccess(true);
					resultsDate.setData(jSONArray.toString());
				}else
				{
					resultsDate.setSuccess(false);
					resultsDate.setMessage("===ZjkRewardPunishSync获取数据0条==");
				}
				
	   		}else
	   		{
	   			resultsDate.setSuccess(false);
				resultsDate.setMessage("===ZjkRewardPunishSync获取数据0条==");
	   		}
	   		JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
	   		return ob.toString();
	   	}
	    
    

}
