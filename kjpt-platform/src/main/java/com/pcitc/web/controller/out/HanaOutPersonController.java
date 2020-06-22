package com.pcitc.web.controller.out;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Result;
import com.pcitc.base.expert.ZjkBase;
import com.pcitc.base.expert.ZjkBaseSync;
import com.pcitc.base.expert.ZjkBookSync;
import com.pcitc.base.expert.ZjkPatent;
import com.pcitc.base.expert.ZjkPatentSync;
import com.pcitc.base.expert.ZjkRewardPunish;
import com.pcitc.base.expert.ZjkRewardPunishSync;
import com.pcitc.base.expert.ZjkRewardSync;
import com.pcitc.base.out.OutPerson;
import com.pcitc.base.out.OutPersonVo;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value = "OutPerson-API",tags = {"外系统-人才同步接口"})
@RestController
public class HanaOutPersonController extends BaseController {

    //@Value("${hanaHeadPiUrl}")
    //private static String hanaHeadPiUrl;
	
	/**
	 * 根据ID获取对象信息
	 */
	public static final String PAGE_OUTPROJECT_URL = "http://kjpt-zuul/stp-proxy/out_person/page";
	//查询所有专家
	public static final String getHanaOutPersonBaseInfoList =   "http://kjpt-zuul/hana-proxy/out_person/getHanaOutPersonBaseInfoList";
	//查询所有专家相关-专利
    public static final String getHanaOutPersonPatentList =     "http://kjpt-zuul/hana-proxy/out_person/getHanaOutPersonPatentList";
		
    //查询所有专家相关-论著
    public static final String getHanaOutPersonBookList =     "http://kjpt-zuul/hana-proxy/out_person/getHanaOutPersonBookList";
	
    //查询所有专家相关-奖励
    public static final String getHanaOutPersonAwardList =     "http://kjpt-zuul/hana-proxy/out_person/getHanaOutPersonAwardList";
	
    //查询所有专家相关-奖惩
    public static final String getHanaOutPersonPunishList =     "http://kjpt-zuul/hana-proxy/out_person/getHanaOutPersonPunishList";
	
    
    
	public static final String getHanaPantentListByNum =        "http://kjpt-zuul/hana-proxy/out_person/getHanaPantentListByNum";
	
	public static final String BATCH_ADD_JZK_BASE_URL =         "http://kjpt-zuul/stp-proxy/sync-expert-api/insertBatchZjkBaseSync";
	
	public static final String BATCH_ADD_JZK_PATENT_URL =       "http://kjpt-zuul/stp-proxy/sync-expert-api/insertBatchPatent";
	
	public static final String BATCH_ADD_JZK_BOOK_URL =       "http://kjpt-zuul/stp-proxy/sync-expert-api/insertBatchBookSync";
	
	public static final String BATCH_ADD_JZK_AWARD_URL =       "http://kjpt-zuul/stp-proxy/sync-expert-api/insertBatchReward";
	public static final String BATCH_ADD_JZK_PUNISH_URL =       "http://kjpt-zuul/stp-proxy/sync-expert-api/insertBatchPunishSync";
	
	
	
	
	
	public static final String BATCH_ADD_OUT_PERSON_URL =   "http://kjpt-zuul/stp-proxy/out_person/insertBatchOutPerson";
	public static final String getPersonToPersonList =      "http://kjpt-zuul/stp-proxy/sync-expert-api/getZjkBaseSyncList";
	public static final String head_Pic="http://10.2.11.211:8080/WEB-IMG01/PIC/";//‘icnum’.jpg
	
	//专利
	public static final String BATCH_ADD_PATENT_URL =       "http://kjpt-zuul/stp-proxy/expert_patent/insertBatchZjkPatent";
	public static final String getZjkPatentSyncList =       "http://kjpt-zuul/stp-proxy/sync-expert-api/getZjkPatentList";
	//奖惩
	public static final String BATCH_ADD_PUNISH_URL =        "http://kjpt-zuul/stp-proxy/expert_punish/insertBatchPunish";
	public static final String getZjkRewardPunishSyncList =  "http://kjpt-zuul/stp-proxy/sync-expert-api/getPunishSSyncList";
		
  	
	    @ApiOperation(value = "获取所有专家的基本信息，相关专利，相关奖惩", notes = "获取所有专家的基本信息，相关专利，相关奖惩")
		@RequestMapping(value = "/getHanaOutPersonBaseInfoList", method = RequestMethod.GET)
	    @ResponseBody
	   	public String getHanaOutPersonBaseInfoList( HttpServletRequest request, HttpServletResponse response) throws Exception
	   	{
	   		Map map=new HashMap();
	   		
	   	    //从hana取人才-》临时表
	    	Result resultsDate1=this.getPersonList(request, response, restTemplate, httpHeaders);
	   		//从hana取专利-》临时表
	    	Result resultsDate2=this.getPersonPatentList(request, response, restTemplate, httpHeaders);
	   	    //从HANAR取奖惩-》临时表
	    	Result resultsDate3=this.getPunishList(request, response, restTemplate, httpHeaders);
	   		
	   	    //从临时表取人才--》本地人才表
	    	Result resultsDate4=this.getPersonToPersonList(request, response, restTemplate, httpHeaders);
	   		
	   	    //从临时表取专利--》本地专利表
	    	//Result resultsDate5=this.getPatentToPatentList(request, response, restTemplate, httpHeaders);
	   		
	   	    //从临时表取奖惩--》本地奖惩表
	    	//Result resultsDate6=this.getPunishToPunishList(request, response, restTemplate, httpHeaders);
	    	
	    	map.put("resultsDate1", resultsDate1);
	    	map.put("resultsDate2", resultsDate2);
	    	map.put("resultsDate3", resultsDate3);
	    	map.put("resultsDate4", resultsDate4);
	    	//map.put("resultsDate5", resultsDate5);
	    	//map.put("resultsDate6", resultsDate6);
	    	
	   		JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(map));
	   		return ob.toString();
	   	}
	    
	    
	    //从hana取人才-》临时表
	    public Result getPersonList( HttpServletRequest request, HttpServletResponse response,RestTemplate restTemplate,HttpHeaders httpHeaders) throws Exception
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
	   				   String postCode=zjkBase.getZzwjbbm();//职务级别编码
	   				   String post=zjkBase.getZzwjbmc();//职务级别名称
	   				   //String title=zjkBase.getZprzyjszwjbmc();//职称名称
	   				   // String titleCode= zjkBase.getZprzyjszwjbbm();//职称编码
	   				    String titleCode=  zjkBase.getZzyjszgmcbm();
	   				    String title=   zjkBase.getZzyjszgmcmc();
	   				   
	   				   String education=zjkBase.getZjyzx();
	   				   String unitName=zjkBase.getZdwmc();
	   				   String unitId=zjkBase.getZdwbm();
	   				   String name=zjkBase.getNachn();
	   				   String sex=zjkBase.getGesch();
	   				   String idCardNo=zjkBase.getIcnum();
	   				   String birthDateStr=zjkBase.getGbdat();
	   				   String educationCode=zjkBase.getZjyxlbmn();
	   				   
	   				   
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
	   				   zjkBaseSync.setEducationCode(educationCode);
	   				   zjkBaseSync.setName(name);
	   				   zjkBaseSync.setUnitId(unitId);
	   				   zjkBaseSync.setUnitName(unitName);
	   				   zjkBaseSync.setSex(sex);
	   				   zjkBaseSync.setTitleCode(titleCode);
	   				   zjkBaseSync.setPostCode(postCode);
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
				ResponseEntity<Integer> resEntity = restTemplate.exchange(BATCH_ADD_JZK_BASE_URL, HttpMethod.POST, entity, Integer.class);
				Integer result=	resEntity.getBody();
				if(result.intValue()>0)
				{
					resultsDate.setSuccess(true);
					resultsDate.setData(jSONArray.toString());
					resultsDate.setMessage("===从hana取人才-》保存到临时表     SUCCESS==");
					
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
	   		return resultsDate;
	   		
	   	}
	    
	   //从hana取专利-》临时表
	    public static Result getPersonPatentList( HttpServletRequest request, HttpServletResponse response,RestTemplate restTemplate,HttpHeaders httpHeaders) 
	   	{
	    	Result resultsDate = new Result();
	        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
	   		Map<String ,Object> paramMap = new HashMap<String ,Object>();
	    	HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,httpHeaders);
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
	   				   

	   				   System.out.println(">>>>>patentTimeStr:"+patentTimeStr+" patentOrder="+patentOrder+" outSysId="+outSysId);
	   				   ZjkPatentSync  sync=new ZjkPatentSync();
	   				   String dateid = UUID.randomUUID().toString().replaceAll("-", "");
	   				   sync.setId(dateid);
	   				   sync.setCreateTime(new Date());
	   				   sync.setExpertNum(expertNum);
	   				   sync.setPatentNum(patentNum);
	   				   sync.setOutSysId(outSysId);
	   				   sync.setPatentName(patentName);
	   				   if(patentTimeStr!=null && !patentTimeStr.equals("") && patentTimeStr.length()>4 && !patentTimeStr.equals("null") && !patentTimeStr.equals("00000000")) 
	   				   {
	   					try {
							sync.setPatentTime(DateUtil.strToDate(patentTimeStr, DateUtil.FMT_YYYY_DD));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							//continue;
						}
	   				   }
	   				   if(patentOrder!=null && !patentOrder.equals("") && !patentOrder.equals("null") && !patentOrder.equals(" ")) 
	   				   {
	   					  try {
							sync.setPatentOrder(Integer.valueOf(patentOrder));
						} catch (Exception e) {
							//continue;
							//e.printStackTrace();
						}
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
				ResponseEntity<Integer> resEntity = restTemplate.exchange(BATCH_ADD_JZK_PATENT_URL, HttpMethod.POST, entity, Integer.class);
				Integer result=	resEntity.getBody();
				if(result.intValue()>0)
				{
					resultsDate.setSuccess(true);
					resultsDate.setData(jSONArray.toString());
					resultsDate.setMessage("===从hana取专利-》临时表==");
					
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
	   		return resultsDate;
	   	}
	    //从HANAR取奖惩
		public static Result getPunishList( HttpServletRequest request, HttpServletResponse response,RestTemplate restTemplate,HttpHeaders httpHeaders) throws Exception
	   	{
	    	Result resultsDate = new Result();
	   		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
	   		Map<String ,Object> paramMap = new HashMap<String ,Object>();
	   	    System.out.println(">>>>>>>>>getHanaOutPersonPunishList>>>>>>>>>>>>>>>>>>>");
	   		
	   		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,httpHeaders);
	   		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getHanaOutPersonPunishList, HttpMethod.POST, httpEntity, JSONArray.class);
	   		int statusCode = responseEntity.getStatusCodeValue();
	   		List<OutPersonVo> list =new ArrayList<OutPersonVo>();
	   		List<ZjkRewardPunishSync> zjkBaseSyncList =new ArrayList<ZjkRewardPunishSync>();
	   		JSONArray jSONArray=null;
	   		if (statusCode == 200)
	   		{
	   			jSONArray = responseEntity.getBody();
	   			list = JSONObject.parseArray(jSONArray.toJSONString(), OutPersonVo.class);
	   			if(list!=null &&  list.size()>0)
	   			{
	   			    System.out.println(">>>>查询奖惩信息 共>>>>>"+list.size()+"条");
	   			    resultsDate.setMessage("===HANA获取数据为: "+list.size()+"条");
	   				for(int i=0;i<list.size();i++)
	   				{
	   				   OutPersonVo vo= list.get(i);
	   				   String outSysId= vo.getSeqnr9025();//序号
	   				   String title=vo.getZjcmc();//奖励或惩罚名称
	   				   String rewardType=vo.getZjlzl();//奖励种类
	   				   String rewardTypeCode=vo.getZjlzlbm();
	   				   String rewardPunishType=vo.getZjclb();//奖惩类别
	   				   String rewardPunishTypeCode=vo.getZjclbbm();
	   				   String notes= vo.getZjcqkms();//奖惩情况描述
	   				   String rewardPunishLevel=vo.getZjcjb();//奖惩级别
	   				   String rewardPunishLevelCode=vo.getZjcjbbm();
	   				   String approveUnit=vo.getZjcpbdw();//奖惩批准单位
	   				   String expertNum=vo.getPernr();
	   				   String approveDateStr= vo.getZpzsj();

	   				   //System.out.println(">>>>>approveDateStr>>>>>"+approveDateStr);
	   				   ZjkRewardPunishSync  sync=new ZjkRewardPunishSync();
	   				   String dateid = UUID.randomUUID().toString().replaceAll("-", "");
	   				   sync.setId(dateid);
	   				   sync.setCreateTime(new Date());
	   				   sync.setExpertNum(expertNum);
	   				   sync.setOutSysId(outSysId);
		   			   sync.setNotes(notes);
		   			   sync.setRewardType(rewardType);
		   			   sync.setRewardTypeCode(rewardTypeCode);
		   			   sync.setTitle(title);
		   			   sync.setRewardPunishType(rewardPunishType);
		   			   sync.setRewardPunishTypeCode(rewardPunishTypeCode);
		   			   sync.setRewardPunishLevel(rewardPunishLevel);
		   			   sync.setRewardPunishLevelCode(rewardPunishLevelCode);
		   			   sync.setApproveUnit(approveUnit);
	   				   sync.setApproveDateStr(approveDateStr);
	   				   if(approveDateStr!=null && !approveDateStr.equals("")) 
	   				   {
	   					sync.setApproveDate(DateUtil.strToDate(approveDateStr, DateUtil.FMT_YYYY_DD));
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
				ResponseEntity<Integer> resEntity = restTemplate.exchange(BATCH_ADD_JZK_PUNISH_URL, HttpMethod.POST, entity, Integer.class);
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
	   		//JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
	   		return resultsDate;
	   	}
	    
	    
	    //专家临时同步到人才表
	 	public static Result getPersonToPersonList( HttpServletRequest request, HttpServletResponse response,RestTemplate restTemplate,HttpHeaders httpHeaders) throws Exception
	   	{
	    	Result resultsDate = new Result();
	   		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
	   		Map<String ,Object> paramMap = new HashMap<String ,Object>();
	   	    System.out.println(">>>>>>>>>getPersonToPersonList>>>>>>>>>>>>>>>>>>>");
	   		
	   		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,httpHeaders);
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
					resultsDate.setMessage("===从临时表取人才--》本地人才表 SUCCESS==");
				}else
				{
					resultsDate.setSuccess(false);
					resultsDate.setMessage("===从临时表取人才--》本地人才表 0条==");
				}
				
	   		}else
	   		{
	   			resultsDate.setSuccess(false);
				resultsDate.setMessage("===ZjkBaseSync获取数据0条==");
	   		}
	   		//JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
	   		return resultsDate;
	   	}
	    
	    
		public static Result getPatentToPatentList( HttpServletRequest request, HttpServletResponse response,RestTemplate restTemplate,HttpHeaders httpHeaders) throws Exception
	   	{
	    	Result resultsDate = new Result();
	   		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
	   		Map<String ,Object> paramMap = new HashMap<String ,Object>();
	   	    System.out.println(">>>>>>>>>getPatentToPatentList>>>>>>>>>>>>>>>>>>>");
	   		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,httpHeaders);
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
					resultsDate.setMessage("===从临时表取专利--》本地专利表 =="+zjkBaseSyncList.size());
				}else
				{
					resultsDate.setSuccess(false);
					resultsDate.setMessage("===从临时表取专利--》本地专利表 0条==");
				}
				
	   		}else
	   		{
	   			resultsDate.setSuccess(false);
				resultsDate.setMessage("===ZjkPatentSync获取数据0条==");
	   		}
	   		//JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
	   		return resultsDate;
	   	}
	    
		//从临时表取奖惩--》本地奖惩表
		public static  Result getPunishToPunishList( HttpServletRequest request, HttpServletResponse response,RestTemplate restTemplate,HttpHeaders httpHeaders) throws Exception
	   	{
	    	Result resultsDate = new Result();
	   		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
	   		Map<String ,Object> paramMap = new HashMap<String ,Object>();
	   	    System.out.println(">>>>>>>>>getPunishToPunishList>>>>>>>>>>>>>>>>>>>");
	   		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,httpHeaders);
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
					resultsDate.setMessage("===从临时表取奖惩--》本地奖惩表=="+result.intValue());
					
					
				}else
				{
					resultsDate.setSuccess(false);
					resultsDate.setMessage("===从临时表取奖惩--》本地奖惩表 0条==");
				}
				
	   		}else
	   		{
	   			resultsDate.setSuccess(false);
				resultsDate.setMessage("===ZjkRewardPunishSync获取数据0条==");
	   		}
	   		JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
	   		return resultsDate;
	   	}
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
		
		
		
		
		
		
		
		
		
		
		
		
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    

	    @ApiOperation(value = "查询专利信息", notes = "查询专利信息")
		@RequestMapping(value = "/getHanaOutPersonPatentList", method = RequestMethod.GET)
	    @ResponseBody
	   	public String getHanaOutPersonPatentList( HttpServletRequest request, HttpServletResponse response) 
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
	   				   

	   				   System.out.println(">>>>>patentTimeStr:"+patentTimeStr+" patentOrder="+patentOrder+" outSysId="+outSysId);
	   				   ZjkPatentSync  sync=new ZjkPatentSync();
	   				   String dateid = UUID.randomUUID().toString().replaceAll("-", "");
	   				   sync.setId(dateid);
	   				   sync.setCreateTime(new Date());
	   				   sync.setExpertNum(expertNum);
	   				   sync.setPatentNum(patentNum);
	   				   sync.setOutSysId(outSysId);
	   				   sync.setPatentName(patentName);
	   				   if(patentTimeStr!=null && !patentTimeStr.equals("") && patentTimeStr.length()>4 && !patentTimeStr.equals("null") && !patentTimeStr.equals("00000000")) 
	   				   {
	   					try {
							sync.setPatentTime(DateUtil.strToDate(patentTimeStr, DateUtil.FMT_YYYY_DD));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							//continue;
						}
	   				   }
	   				   if(patentOrder!=null && !patentOrder.equals("") && !patentOrder.equals("null") && !patentOrder.equals(" ")) 
	   				   {
	   					  try {
							sync.setPatentOrder(Integer.valueOf(patentOrder));
						} catch (Exception e) {
							//continue;
							//e.printStackTrace();
						}
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
	    
	    
	    
	    
	    
	    
	    @ApiOperation(value = "查询论著信息", notes = "查询论著信息")
		@RequestMapping(value = "/getHanaOutPersonBookList", method = RequestMethod.GET)
	    @ResponseBody
	   	public String getHanaOutPersonBookList( HttpServletRequest request, HttpServletResponse response) throws Exception
	   	{
	    	Result resultsDate = new Result();
	   		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
	   		Map<String ,Object> paramMap = new HashMap<String ,Object>();
	   	    System.out.println(">>>>>>>>>getHanaOutPersonPatentList>>>>>>>>>>>>>>>>>>>");
	   		
	   		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
	   		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getHanaOutPersonBookList, HttpMethod.POST, httpEntity, JSONArray.class);
	   		int statusCode = responseEntity.getStatusCodeValue();
	   		List<OutPersonVo> list =new ArrayList<OutPersonVo>();
	   		List<ZjkBookSync> zjkBaseSyncList =new ArrayList<ZjkBookSync>();
	   		JSONArray jSONArray=null;
	   		if (statusCode == 200)
	   		{
	   			jSONArray = responseEntity.getBody();
	   			list = JSONObject.parseArray(jSONArray.toJSONString(), OutPersonVo.class);
	   			if(list!=null &&  list.size()>0)
	   			{
	   			    System.out.println(">>>>查询论著信息共>>>>>"+list.size()+"条");
	   			    resultsDate.setMessage("===HANA获取数据为: "+list.size()+"条");
	   				for(int i=0;i<list.size();i++)
	   				{
	   				   OutPersonVo vo= list.get(i);
	   				   String outSysId= vo.getSeqnr9010();//序号
	   				   String bookName=vo.getZlzmc();//论文、著作名称
	   				   String bookDateStr=vo.getZfbsj();//发表时间
	   				   String publicOrg=vo.getZcbsmc();//刊物或出版社名称
	   				   String bookCountry= vo.getZcbgj();//出版国家
	   				   String notes= vo.getZlzbz();//备注
	   				   String expertNum=vo.getPernr();

	   				   //System.out.println(">>>>>bookDateStr>>>>>"+bookDateStr);
	   				   ZjkBookSync  sync=new ZjkBookSync();
	   				   String dateid = UUID.randomUUID().toString().replaceAll("-", "");
	   				   sync.setId(dateid);
	   				   sync.setCreateTime(new Date());
	   				   sync.setExpertNum(expertNum);
	   				   sync.setOutSysId(outSysId);
	   				   sync.setNotes(notes);
	   				   sync.setBookDateStr(bookDateStr);
	   				   sync.setBookName(bookName);
	   				   sync.setPublicOrg(publicOrg);
	   				   sync.setBookCountry(bookCountry);
	   				   sync.setBookDateStr(bookDateStr);
	   				   if(bookDateStr!=null && bookDateStr.equals(""))
	   				   {
	   					sync.setBookDate(DateUtil.strToDate(bookDateStr, DateUtil.FMT_YYYY_DD));
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
				ResponseEntity<Integer> resEntity = restTemplate.exchange(BATCH_ADD_JZK_BOOK_URL, HttpMethod.POST, entity, Integer.class);
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
	    
	    
	    
	    
	    
	    
	    @ApiOperation(value = "查询奖励信息", notes = "查询奖励信息")
		@RequestMapping(value = "/getHanaOutPersonAwardList", method = RequestMethod.GET)
	    @ResponseBody
	   	public String getHanaOutPersonAwardList( HttpServletRequest request, HttpServletResponse response) throws Exception
	   	{
	    	Result resultsDate = new Result();
	   		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
	   		Map<String ,Object> paramMap = new HashMap<String ,Object>();
	   	    System.out.println(">>>>>>>>>getHanaOutPersonAwardList>>>>>>>>>>>>>>>>>>>");
	   		
	   		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
	   		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getHanaOutPersonAwardList, HttpMethod.POST, httpEntity, JSONArray.class);
	   		int statusCode = responseEntity.getStatusCodeValue();
	   		List<OutPersonVo> list =new ArrayList<OutPersonVo>();
	   		List<ZjkRewardSync> zjkBaseSyncList =new ArrayList<ZjkRewardSync>();
	   		JSONArray jSONArray=null;
	   		if (statusCode == 200)
	   		{
	   			jSONArray = responseEntity.getBody();
	   			list = JSONObject.parseArray(jSONArray.toJSONString(), OutPersonVo.class);
	   			if(list!=null &&  list.size()>0)
	   			{
	   			    System.out.println(">>>>查询奖励信息 共>>>>>"+list.size()+"条");
	   			    resultsDate.setMessage("===HANA获取数据为: "+list.size()+"条");
	   				for(int i=0;i<list.size();i++)
	   				{
	   				   OutPersonVo vo= list.get(i);
	   				   String patentTimeStr= vo.getZhdzlsj();//获得专利时间
	   				   String outSysId= vo.getSeqnr9007();//序号
	   				   String heightPersonLevel=vo.getZgccrcdjbm();//高层次人才等级编码 
	   				   String heightPersonLevelName=vo.getZgccrcdjmc();//高层次人才等级名称 
	   				   
	   				   String heightPersonType=vo.getZgccrclb1bm();//高层次人才类别编码 
	   				   String heightPersonTypeName= vo.getZgccrclb1mc();//高层次人才类别名称
	   				   String rewardLevelCode=vo.getZhjjb();//获奖级别编码
	   				   String rewardLevelName=vo.getZhjjbms();//获奖级别名称
	   				   
	   				   String rewardTypeCode=vo.getZhjlb();//获奖类别编码
	   				   String rewardTypeName=vo.getZhjlbms();//获奖类别名称
	   				   String rewardDateStr= vo.getZsysjStr();
	   				   String expertNum=vo.getPernr();

	   				   //System.out.println(">>>>>rewardDateStr>>>>>"+rewardDateStr);
	   				   ZjkRewardSync  sync=new ZjkRewardSync();
	   				   String dateid = UUID.randomUUID().toString().replaceAll("-", "");
	   				   sync.setId(dateid);
	   				   sync.setCreateTime(new Date());
	   				   sync.setExpertNum(expertNum);
	   				   sync.setOutSysId(outSysId);
	   				   sync.setRewardDateStr(rewardDateStr);
	   				   
	   				  sync.setRewardLevelCode(rewardLevelCode);
	   				  sync.setRewardLevelName(rewardLevelName);
	   				  sync.setRewardTypeCode(rewardTypeCode);
	   				  sync.setRewardTypeName(rewardTypeName);
	   				  sync.setHeightPersonLevel(heightPersonLevel);
	   				  sync.setHeightPersonType(heightPersonType);
	   				  sync.setHeightPersonTypeName(heightPersonTypeName);
	   				  sync.setHeightPersonLevelName(heightPersonLevelName);
	   				   if(rewardDateStr!=null && !rewardDateStr.equals("")) 
	   				   {
	   					  sync.setRewardDate(DateUtil.strToDate(rewardDateStr, DateUtil.FMT_YYYY_DD));
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
				ResponseEntity<Integer> resEntity = restTemplate.exchange(BATCH_ADD_JZK_AWARD_URL, HttpMethod.POST, entity, Integer.class);
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
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    

	    @ApiOperation(value = "查询奖惩信息", notes = "查询奖惩信息")
		@RequestMapping(value = "/getHanaOutPersonPunishList", method = RequestMethod.GET)
	    @ResponseBody
	   	public String getHanaOutPersonPunishList( HttpServletRequest request, HttpServletResponse response) throws Exception
	   	{
	    	Result resultsDate = new Result();
	   		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
	   		Map<String ,Object> paramMap = new HashMap<String ,Object>();
	   	    System.out.println(">>>>>>>>>getHanaOutPersonPunishList>>>>>>>>>>>>>>>>>>>");
	   		
	   		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
	   		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getHanaOutPersonPunishList, HttpMethod.POST, httpEntity, JSONArray.class);
	   		int statusCode = responseEntity.getStatusCodeValue();
	   		List<OutPersonVo> list =new ArrayList<OutPersonVo>();
	   		List<ZjkRewardPunishSync> zjkBaseSyncList =new ArrayList<ZjkRewardPunishSync>();
	   		JSONArray jSONArray=null;
	   		if (statusCode == 200)
	   		{
	   			jSONArray = responseEntity.getBody();
	   			list = JSONObject.parseArray(jSONArray.toJSONString(), OutPersonVo.class);
	   			if(list!=null &&  list.size()>0)
	   			{
	   			    System.out.println(">>>>查询奖惩信息 共>>>>>"+list.size()+"条");
	   			    resultsDate.setMessage("===HANA获取数据为: "+list.size()+"条");
	   				for(int i=0;i<list.size();i++)
	   				{
	   				   OutPersonVo vo= list.get(i);
	   				   String outSysId= vo.getSeqnr9025();//序号
	   				   String title=vo.getZjcmc();//奖励或惩罚名称
	   				   String rewardType=vo.getZjlzl();//奖励种类
	   				   String rewardTypeCode=vo.getZjlzlbm();
	   				   String rewardPunishType=vo.getZjclb();//奖惩类别
	   				   String rewardPunishTypeCode=vo.getZjclbbm();
	   				   String notes= vo.getZjcqkms();//奖惩情况描述
	   				   String rewardPunishLevel=vo.getZjcjb();//奖惩级别
	   				   String rewardPunishLevelCode=vo.getZjcjbbm();
	   				   String approveUnit=vo.getZjcpbdw();//奖惩批准单位
	   				   String expertNum=vo.getPernr();
	   				   String approveDateStr= vo.getZpzsj();

	   				   //System.out.println(">>>>>approveDateStr>>>>>"+approveDateStr);
	   				   ZjkRewardPunishSync  sync=new ZjkRewardPunishSync();
	   				   String dateid = UUID.randomUUID().toString().replaceAll("-", "");
	   				   sync.setId(dateid);
	   				   sync.setCreateTime(new Date());
	   				   sync.setExpertNum(expertNum);
	   				   sync.setOutSysId(outSysId);
		   			   sync.setNotes(notes);
		   			   sync.setRewardType(rewardType);
		   			   sync.setRewardTypeCode(rewardTypeCode);
		   			   sync.setTitle(title);
		   			   sync.setRewardPunishType(rewardPunishType);
		   			   sync.setRewardPunishTypeCode(rewardPunishTypeCode);
		   			   sync.setRewardPunishLevel(rewardPunishLevel);
		   			   sync.setRewardPunishLevelCode(rewardPunishLevelCode);
		   			   sync.setApproveUnit(approveUnit);
	   				   sync.setApproveDateStr(approveDateStr);
	   				   if(approveDateStr!=null && !approveDateStr.equals("")) 
	   				   {
	   					sync.setApproveDate(DateUtil.strToDate(approveDateStr, DateUtil.FMT_YYYY_DD));
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
				ResponseEntity<Integer> resEntity = restTemplate.exchange(BATCH_ADD_JZK_PUNISH_URL, HttpMethod.POST, entity, Integer.class);
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
