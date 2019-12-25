package com.pcitc.web.controller.out;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.RequestProcessStatusEnum;
import com.pcitc.base.expert.ZjkBase;
import com.pcitc.base.out.OutPerson;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


@Api(value = "OutPerson-API",tags = {"外系统-人员接口"})
@RestController
public class OutPersonController extends BaseController {
	
	
	/**
	 * 根据ID获取对象信息
	 */
	public static final String PAGE_OUTPROJECT_URL = "http://kjpt-zuul/stp-proxy/out_person/page";

	public static final String PAGE_OUTPROJECT_COUNT_URL = "http://kjpt-zuul/stp-proxy/out_person/getOutPersonCount";
	
	
	/**
	 * 根据ID获取对象信息
	 */
	public static final String ADD_EXPERT_URL = "http://kjpt-zuul/stp-proxy/expert/outPersonToZjkBase";

	/**
	 * 根据ID获取对象信息
	 */
	public static final String UPDATE_EXPERT_URL = "http://kjpt-zuul/stp-proxy/out_person/update";

	
	/**
	 * 根据ID获取对象信息
	 */
	public static final String GET_EXPERT_URL = "http://kjpt-zuul/stp-proxy/out_person/get/";
	
	
	
	
	
	
	
	
	
	
	/**
	  * 获取人员（分页）
	 */
    @ApiOperation(value = "查询外系统-人员列表（分页）", notes = "查询外系统-人员列表（分页）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page",           value = "页码",        dataType = "string", paramType = "query",required=true),
        @ApiImplicitParam(name = "limit",          value = "每页显示条数",  dataType = "string", paramType = "query",required=true),
        @ApiImplicitParam(name = "name",           value = "名称",        dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "education",      value = "学历(字典)",    dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "belongUnitId",   value = "所在单位ID",   dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "post",           value = "职务",        dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "title",          value = "职称",        dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "beginAage",      value = "开始年龄",     dataType = "int", paramType = "query"),
        @ApiImplicitParam(name = "endAage",        value = "截止年龄",     dataType = "int", paramType = "query"),
        @ApiImplicitParam(name = "sex",            value = "性别",        dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "techType",       value = "技术领域",     dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/outPerson-api/page", method = RequestMethod.GET)
	public String getExpertPage(
			

			@RequestParam(required = true) Integer page,
            @RequestParam(required = true) Integer limit,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String education,
            @RequestParam(required = false) String belongUnitId,
            @RequestParam(required = false) String post,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Integer beginAage,
            @RequestParam(required = false) Integer endAage,
            @RequestParam(required = false) String sex,
            @RequestParam(required = false) String techType,
			HttpServletRequest request, HttpServletResponse response)throws Exception 
     {

    	LayuiTableParam param =new LayuiTableParam();
    	param.getParam().put("name", name);
    	param.getParam().put("education", education);
    	param.getParam().put("belongUnitId", belongUnitId);
    	param.getParam().put("post", post);
    	param.getParam().put("title", title);
    	param.getParam().put("beginAage", beginAage);
    	param.getParam().put("endAage", endAage);
    	param.getParam().put("sex", sex);
    	param.getParam().put("techType", techType);
    	param.setLimit(limit);
    	param.setPage(page);
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PAGE_OUTPROJECT_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============查询外系统- " + result.toString());
		return result.toString();
	}


   
	
    
    
    
    /**
	  * 获取人员（分页）
	 */
   @ApiOperation(value = "查询外系统-人员数", notes = "查询外系统-人员数")
   @RequestMapping(value = "/outPerson-api/getOutPersonCount", method = RequestMethod.GET)
	public String getOutPersonCount(
			HttpServletRequest request, HttpServletResponse response)throws Exception 
    {
		Result resultsDate = new Result();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap, this.httpHeaders);
		ResponseEntity<JSONObject> responseEntity = restTemplate.exchange(PAGE_OUTPROJECT_URL, HttpMethod.POST, httpEntity,
				JSONObject.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			JSONObject jSONObject = responseEntity.getBody();
			long  count =jSONObject.getLongValue("count");
			System.out.println("============count外系统数- " + count);
			resultsDate.setData(count);
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		logger.info("============result" + result.toString());
		return result.toString();
	}


   
   
   
   

   
   
   
   /**
	  *根据ID获取人才信息详情
	 */
   @ApiOperation(value = "根据ID获取人才信息详情", notes = "根据ID获取人才信息详情")
	@RequestMapping(value = "/outPerson-api/get/{id}", method = RequestMethod.GET)
	public String getExpert(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
   	Result resultsDate = new Result();
   	ResponseEntity<OutPerson> responseEntity = this.restTemplate.exchange(GET_EXPERT_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), OutPerson.class);
		int statusCode = responseEntity.getStatusCodeValue();
		OutPerson zjkBase = responseEntity.getBody();
		logger.info("============远程返回  statusCode " + statusCode);
		if (statusCode == 200) {
			resultsDate = new Result(true,RequestProcessStatusEnum.OK.getStatusDesc());
			resultsDate.setData(zjkBase);
		} else {
			resultsDate = new Result(false, "根据ID获取人才信息详情失败");
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		return result.toString();
	}
   
   
   
 
   
   

   
   @ApiOperation(value = "人才转为专家", notes = "人才转为专家")
   @ApiImplicitParams({
   	   @ApiImplicitParam(name = "id", value = "主键", dataType = "string", paramType = "form"),
       
   })
   @RequestMapping(method = RequestMethod.GET, value = "/outPerson-api/outPersonToZjkBase")
	public String outPersonToZjkBase(HttpServletRequest request, HttpServletResponse response) throws Exception {

	String ids=CommonUtil.getParameter(request, "ids", "");
	String groups=CommonUtil.getParameter(request, "groups", "");
   	Result resultsDate = new Result();
   	
   	this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);//设置参数类型和编码
 	Map<String ,Object> paramMap = new HashMap<String ,Object>();
 	paramMap.put("groups", groups);
 	paramMap.put("ids", ids);
 	HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
	ResponseEntity<Integer> responseEntity = restTemplate.exchange(ADD_EXPERT_URL, HttpMethod.POST, httpEntity, Integer.class);
	int statusCode = responseEntity.getStatusCodeValue();
	int dataId = responseEntity.getBody();
	// 返回结果代码
	if (statusCode == 200) 
	{
		resultsDate = new Result(true,RequestProcessStatusEnum.OK.getStatusDesc());
	} else 
	{
		resultsDate = new Result(false, "同步专家信息失败");
	}
	JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
	return result.toString();
   }
   
  
	
    

}
