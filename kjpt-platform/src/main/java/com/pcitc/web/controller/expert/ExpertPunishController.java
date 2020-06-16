package com.pcitc.web.controller.expert;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.RestBaseController;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.RequestProcessStatusEnum;
import com.pcitc.base.expert.ZjkRewardPunish;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.DateUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


@Api(value = "ExpertPatent-API",tags = {"专家库-奖惩接口"})
@RestController
public class ExpertPunishController extends BaseController {
	
	
	/**
	 * 获取专家奖惩（分页）
	 */
	private static final String PAGE_EXPERT_URL = "http://kjpt-zuul/stp-proxy/expert_punish/page";
	/**
	 * 根据ID获取对象信息
	 */
	public static final String ADD_EXPERT_URL = "http://kjpt-zuul/stp-proxy/expert_punish/add";

	/**
	 * 根据ID获取对象信息
	 */
	public static final String UPDATE_EXPERT_URL = "http://kjpt-zuul/stp-proxy/expert_punish/update";
	
	/**
	 * 根据ID删除
	 */
	private static final String DEL_EXPERT_URL = "http://kjpt-zuul/stp-proxy/expert_punish/delete/";
	
	
	/**
	 * 根据ID获取对象信息
	 */
	public static final String GET_EXPERT_URL = "http://kjpt-zuul/stp-proxy/expert_punish/get/";

	private static final String queryNopage = "http://kjpt-zuul/stp-proxy/expertPatent-api/queryNoPage";




	/**
	  * 获取专家奖惩（分页）
	 */
    @ApiOperation(value = "获取专家奖惩列表（分页）", notes = "获取专家奖惩列表（分页）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page",           value = "页码",         dataType = "string", paramType = "query",required=true),
        @ApiImplicitParam(name = "limit",          value = "每页显示条数",   dataType = "string", paramType = "query",required=true),
        @ApiImplicitParam(name = "expertId",       value = "专家有键",      dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "expertNum",      value = "专家编号",      dataType = "string", paramType = "query")
        
    })
    @RequestMapping(value = "/expert-punish-api/page", method = RequestMethod.POST)
	public String getExpertPage(
			

			@RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer limit,
            @RequestParam(required = false) String expertId,
            @RequestParam(required = false) String expertNum,
			HttpServletRequest request, HttpServletResponse response)throws Exception 
     {

    	LayuiTableParam param =new LayuiTableParam();
    	param.getParam().put("expertNum", expertNum);
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
		String str=	JSON.toJSONString(layuiTableData);
		//JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		//String str=result.toString();
		logger.info("============获取专家奖惩列表（分页） " + str);
		return str;
	}

    
    /**
	  * 删除专家奖惩
	 */
    @ApiOperation(value = "根据ID删除专家奖惩信息", notes = "根据ID删除专家奖惩信息")
	@RequestMapping(value = "/expert-punish-api/delete/{id}", method = RequestMethod.GET)
	public JSONObject deleteExpert(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(DEL_EXPERT_URL + id, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
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
		return ob;
	}
    
    
    /**
	  *根据ID获取专家奖惩信息详情
	 */
    @ApiOperation(value = "根据ID获取专家奖惩信息详情", notes = "根据ID获取专家奖惩信息详情")
	@RequestMapping(value = "/expert-punish-api/get/{id}", method = RequestMethod.GET)
	public JSONObject getExpert(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Result resultsDate = new Result();
    	ResponseEntity<ZjkRewardPunish> responseEntity = this.restTemplate.exchange(GET_EXPERT_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), ZjkRewardPunish.class);
		int statusCode = responseEntity.getStatusCodeValue();
		ZjkRewardPunish ZjkRewardPunish = responseEntity.getBody();
		logger.info("============远程返回  statusCode " + statusCode);
		if (statusCode == 200) {
			resultsDate = new Result(true,RequestProcessStatusEnum.OK.getStatusDesc());
			resultsDate.setData(ZjkRewardPunish);
		} else {
			resultsDate = new Result(false, "根据ID获取专家奖惩信息详情失败");
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		return result.getJSONObject("data");
	}
    
    
    
    
    
    @ApiOperation(value = "保存、修改专家奖惩信息", notes = "保存、修改专家奖惩信息")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "id",          value = "主键",    dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "expertId",    value = "专家ID",  dataType = "string", paramType = "form",required=true),
        @ApiImplicitParam(name = "title", value = "奖惩名称", dataType = "string", paramType = "form",required=true),
        @ApiImplicitParam(name = "approveDateStr",   value = "奖惩时间", dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "describe", value = "奖惩描述", dataType = "string", paramType = "form",required=true),
        @ApiImplicitParam(name = "seeUserIds",  value = "知悉范围-用户ID(多个逗号分)",  dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "seeUserNames",value = "知悉范围-用户名称(多个逗号分)",  dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "secretLevel", value = "信息密级",                 dataType = "string", paramType = "form",required=true)
        
    })
    @RequestMapping(method = RequestMethod.POST, value = "/expert-punish-api/save")
	public JSONObject saveExpertZjkRewardPunish(@RequestBody  ZjkRewardPunish zjkRewardPunish,HttpServletRequest request, HttpServletResponse response) throws Exception 
    {

    	Result resultsDate = new Result();
    	String id=zjkRewardPunish.getId();
    	JSONObject parma = JSONObject.parseObject(JSONObject.toJSONString(zjkRewardPunish));
		System.out.println(">>>>>>>>>> 参数: "+parma.toJSONString());
		SysUser sysUserInfo = this.getUserProfile();
		if (id!=null && !id.equals("")) 
		{
			ResponseEntity<ZjkRewardPunish> se = this.restTemplate.exchange(GET_EXPERT_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), ZjkRewardPunish.class);
			ZjkRewardPunish oldPunish = se.getBody();
			String approveDateStr=zjkRewardPunish.getApproveDateStr();
			if(approveDateStr!=null)
			{
				oldPunish.setApproveDate(DateUtil.strToDate(approveDateStr, DateUtil.FMT_DD));
			}
			oldPunish.setTitle(zjkRewardPunish.getTitle());
			oldPunish.setNotes(zjkRewardPunish.getNotes());
			
			
			
			ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(UPDATE_EXPERT_URL, HttpMethod.POST, new HttpEntity<ZjkRewardPunish>(oldPunish, this.httpHeaders), Integer.class);
			int statusCode = responseEntity.getStatusCodeValue();
			Integer dataId = responseEntity.getBody();
			// 返回结果代码
			if (statusCode == 200)
			{
				resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
			} else 
			{
				resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
			}
		} else 
		{
			Date approveDate=DateUtil.strToDate(zjkRewardPunish.getApproveDateStr(), DateUtil.FMT_DD);
			zjkRewardPunish.setCreateTime(new Date());
			String dateid = UUID.randomUUID().toString().replaceAll("-", "");
			zjkRewardPunish.setId(dateid);
			zjkRewardPunish.setApproveDate(approveDate);
			
			ResponseEntity<String> responseEntity = this.restTemplate.exchange(ADD_EXPERT_URL, HttpMethod.POST, new HttpEntity<ZjkRewardPunish>(zjkRewardPunish, this.httpHeaders), String.class);
			int statusCode = responseEntity.getStatusCodeValue();
			String dataId = responseEntity.getBody();
			// 返回结果代码
			if (statusCode == 200) {
				resultsDate = new Result(true,RequestProcessStatusEnum.OK.getStatusDesc());
			} else {
				resultsDate = new Result(false, "保存专家信息失败");
			}
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		return result;
    }

	
}
