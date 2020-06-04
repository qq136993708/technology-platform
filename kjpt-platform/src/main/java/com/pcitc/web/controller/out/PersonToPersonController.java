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
import com.pcitc.base.out.OutPerson;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value = "OutPerson-API",tags = {"人才同步"})
@RestController
public class PersonToPersonController extends BaseController {
	
	
	public static final String BATCH_ADD_OUT_PERSON_URL = "http://kjpt-zuul/stp-proxy/out_person/insertBatchOutPerson";
	public static final String getZjkBaseSyncList =       "http://kjpt-zuul/stp-proxy/sync-expert-api/getZjkBaseSyncList";
	
  	
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
	   		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(getZjkBaseSyncList, HttpMethod.POST, httpEntity, JSONArray.class);
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
	    
	    
	    
	    
	    
    

}
