package com.pcitc.web.controller.expert;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.RequestProcessStatusEnum;
import com.pcitc.base.expert.ZjkAchievement;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.web.common.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


@Api(value = "ExpertAchievement-API",tags = {"专家库-成果接口"})
@RestController
public class ExpertAchievementController extends BaseController {
	
	
	/**
	 * 获取专家成果（分页）
	 */
	private static final String PAGE_EXPERT_URL = "http://kjpt-zuul/stp-proxy/expert_achievement/page";
	/**
	 * 根据ID获取对象信息
	 */
	public static final String ADD_EXPERT_URL = "http://kjpt-zuul/stp-proxy/expert_achievement/add";

	/**
	 * 根据ID获取对象信息
	 */
	public static final String UPDATE_EXPERT_URL = "http://kjpt-zuul/stp-proxy/expert_achievement/update";

	/**
	 * 根据ID逻辑删除
	 */
	private static final String DEL_EXPERT_LOGIC_URL = "http://kjpt-zuul/stp-proxy/expert_achievement/logic_delete/";
	
	
	/**
	 * 根据ID删除
	 */
	private static final String DEL_EXPERT_URL = "http://kjpt-zuul/stp-proxy/expert_achievement/delete/";
	
	
	/**
	 * 根据ID获取对象信息
	 */
	public static final String GET_EXPERT_URL = "http://kjpt-zuul/stp-proxy/expert_achievement/get/";

    
	
	
	
	/**
	  * 获取专家成果（分页）
	 */
    @ApiOperation(value = "获取专家成果列表（分页）", notes = "获取专家成果列表（分页）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page",           value = "页码", dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "limit",          value = "每页显示条数", dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "expertId",           value = "专家ID", dataType = "string", paramType = "query")
        
    })
    
    @RequestMapping(value = "/expert-achievement-api/list", method = RequestMethod.POST)
	public String getExpertPage(
			
			@RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer limit,
            @RequestParam(required = false,value="专家ID") String expertId,
			HttpServletRequest request, HttpServletResponse response)throws Exception 
     {

    	LayuiTableParam param =new LayuiTableParam();
    	param.getParam().put("expertId", expertId);
    	param.setLimit(limit);
    	param.setPage(page);
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PAGE_EXPERT_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============获取专家成果列表（分页） " + result.toString());
		return result.toString();
	}

    
    /**
	  * 删除专家成果
	 */
    @ApiOperation(value = "根据ID删除专家成果信息", notes = "根据ID删除专家成果信息")
	@RequestMapping(value = "/expert-achievement-api/delete/{id}", method = RequestMethod.GET)
	public String deleteExpert(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(DEL_EXPERT_LOGIC_URL + id, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
		int statusCode = responseEntity.getStatusCodeValue();
		int status = responseEntity.getBody();
		logger.info("============远程返回  statusCode " + statusCode + "  status=" + status);
		if (statusCode == 200) {
			resultsDate = new Result(true,RequestProcessStatusEnum.OK.getStatusDesc());
		} else {
			resultsDate = new Result(false, "删除失败");
		}
		response.setContentType("text/html;charset=UTF-8");
		JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		return ob.toString();
	}
    
    
    /**
	  *根据ID获取专家成果信息详情
	 */
    @ApiOperation(value = "根据ID获取专家成果信息详情", notes = "根据ID获取专家成果信息详情")
	@RequestMapping(value = "/expert-achievement-api/get/{id}", method = RequestMethod.GET)
	public String getExpert(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Result resultsDate = new Result();
    	ResponseEntity<ZjkAchievement> responseEntity = this.restTemplate.exchange(GET_EXPERT_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), ZjkAchievement.class);
		int statusCode = responseEntity.getStatusCodeValue();
		ZjkAchievement ZjkAchievement = responseEntity.getBody();
		logger.info("============远程返回  statusCode " + statusCode);
		if (statusCode == 200) {
			resultsDate = new Result(true,RequestProcessStatusEnum.OK.getStatusDesc());
			resultsDate.setData(ZjkAchievement);
		} else {
			resultsDate = new Result(false, "根据ID获取专家成果信息详情失败");
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		return result.toString();
	}
    
    
    @ApiOperation(value = "保存专家成果信息", notes = "保存专家成果信息")
    @RequestMapping(method = RequestMethod.POST, value = "/expert-achievement-api/save")
	public String saveExpert(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	Result resultsDate = new Result();
    	ZjkAchievement zjkAchievement = new ZjkAchievement();
    	String id = UUID.randomUUID().toString().replaceAll("-", "");
		String achieveName = CommonUtil.getParameter(request, "achieveName", "");
		zjkAchievement.setAchieveName(achieveName);
		zjkAchievement.setId(id);
		
		ResponseEntity<String> responseEntity = this.restTemplate.exchange(ADD_EXPERT_URL, HttpMethod.POST, new HttpEntity<ZjkAchievement>(zjkAchievement, this.httpHeaders), String.class);
		int statusCode = responseEntity.getStatusCodeValue();
		String dataId = responseEntity.getBody();
		// 返回结果代码
		if (statusCode == 200) {
			resultsDate = new Result(true,RequestProcessStatusEnum.OK.getStatusDesc());
		} else {
			resultsDate = new Result(false, "保存专家成果信息失败");
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		return result.toString();
    }
    
    
    @ApiOperation(value = "修改专家成果信息", notes = "修改专家成果信息")
    @RequestMapping(method = RequestMethod.POST, value = "/expert-achievement-api/update")
	public String updateExpert(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	
    	Result resultsDate = new Result();
    	String id = CommonUtil.getParameter(request, "id", "");
    	String achieveName = CommonUtil.getParameter(request, "achieveName", "");
    	//根据ID获取详情
    	ResponseEntity<ZjkAchievement> responseEntity = this.restTemplate.exchange(GET_EXPERT_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), ZjkAchievement.class);
    	int statusCode = responseEntity.getStatusCodeValue();
    	if (statusCode == 200)
    	{
    		ZjkAchievement zjkAchievement = responseEntity.getBody();
    		//修改相应信息
    		zjkAchievement.setAchieveName(achieveName);
    		ResponseEntity<Integer> response_entity = this.restTemplate.exchange(UPDATE_EXPERT_URL, HttpMethod.POST, new HttpEntity<ZjkAchievement>(zjkAchievement, this.httpHeaders), Integer.class);
			int status_code = response_entity.getStatusCodeValue();
			Integer dataId = response_entity.getBody();
			// 返回结果代码
			if (status_code == 200)
			{
				resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
			} else 
			{
				resultsDate = new Result(false, "修改专家成果信息失败");
			}
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		return result.toString();
    }
    
    
    
    

}
