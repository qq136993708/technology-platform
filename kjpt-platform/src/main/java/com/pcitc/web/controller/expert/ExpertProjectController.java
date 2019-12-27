package com.pcitc.web.controller.expert;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.RequestProcessStatusEnum;
import com.pcitc.base.expert.ZjkPatent;
import com.pcitc.base.expert.ZjkProject;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.web.common.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


@Api(value = "ExpertProject-API",tags = {"专家库-项目接口"})
@RestController
public class ExpertProjectController extends BaseController {
	
	
	/**
	 * 获取专家项目（分页）
	 */
	private static final String PAGE_EXPERT_URL = "http://kjpt-zuul/stp-proxy/expert_project/page";
	/**
	 * 根据ID获取对象信息
	 */
	public static final String ADD_EXPERT_URL = "http://kjpt-zuul/stp-proxy/expert_project/add";

	/**
	 * 根据ID获取对象信息
	 */
	public static final String UPDATE_EXPERT_URL = "http://kjpt-zuul/stp-proxy/expert_project/update";

	/**
	 * 根据ID逻辑删除
	 */
	//private static final String DEL_EXPERT_LOGIC_URL = "http://kjpt-zuul/stp-proxy/expert_project/logic_delete/";
	
	
	/**
	 * 根据ID删除
	 */
	private static final String DEL_EXPERT_URL = "http://kjpt-zuul/stp-proxy/expert_project/delete/";
	
	
	/**
	 * 根据ID获取对象信息
	 */
	public static final String GET_EXPERT_URL = "http://kjpt-zuul/stp-proxy/expert_project/get/";

    
	
	
	
	/**
	  * 获取专家项目（分页）
	 */
    @ApiOperation(value = "获取专家项目列表（分页）", notes = "获取专家项目列表（分页）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page",           value = "页码", dataType = "string", paramType = "query",required=true),
        @ApiImplicitParam(name = "limit",          value = "每页显示条数", dataType = "string", paramType = "query",required=true),
        @ApiImplicitParam(name = "expertId",           value = "专家ID", dataType = "string", paramType = "query")
        
    })
    @RequestMapping(value = "/expert-project-api/page", method = RequestMethod.POST)
	public String getExpertPage(
			
			@RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer limit,
            @RequestParam(required = false) String expertId,
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
		logger.info("============获取专家项目列表（分页） " + result.toString());
		return result.toString();
	}

    
    /**
	  * 删除专家项目
	 */
    @ApiOperation(value = "根据ID删除专家项目信息", notes = "根据ID删除专家项目信息")
	@RequestMapping(value = "/expert-project-api/delete/{id}", method = RequestMethod.GET)
	public String deleteExpert(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
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
		return ob.toString();
	}
    
    
    /**
	  *根据ID获取专家项目信息详情
	 */
    @ApiOperation(value = "根据ID获取专家项目信息详情", notes = "根据ID获取专家项目信息详情")
	@RequestMapping(value = "/expert-project-api/get/{id}", method = RequestMethod.GET)
	public String getExpert(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Result resultsDate = new Result();
    	ResponseEntity<ZjkProject> responseEntity = this.restTemplate.exchange(GET_EXPERT_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), ZjkProject.class);
		int statusCode = responseEntity.getStatusCodeValue();
		ZjkProject ZjkProject = responseEntity.getBody();
		logger.info("============远程返回  statusCode " + statusCode);
		if (statusCode == 200) {
			resultsDate = new Result(true,RequestProcessStatusEnum.OK.getStatusDesc());
			resultsDate.setData(ZjkProject);
		} else {
			resultsDate = new Result(false, "根据ID获取专家项目信息详情失败");
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		return result.toString();
	}
    
    
    
    @ApiOperation(value = "保存、修改专家项目信息", notes = "保存、修改专家项目信息")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "id",          value = "主键",    dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "expertId",    value = "专家ID",  dataType = "string", paramType = "form",required=true),
        @ApiImplicitParam(name = "projectName", value = "项目名称", dataType = "string", paramType = "form",required=true),
        @ApiImplicitParam(name = "setupYeat",   value = "立项年度", dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "chargeUnit",   value = "负责单位", dataType = "string", paramType = "form",required=true),
        @ApiImplicitParam(name = "researchTarget", value = "研究目标", dataType = "string", paramType = "form",required=true),
        @ApiImplicitParam(name = "seeUserIds",  value = "知悉范围-用户ID(多个逗号分)",  dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "seeUserNames",value = "知悉范围-用户名称(多个逗号分)",  dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "secretLevel", value = "信息密级",                 dataType = "string", paramType = "form",required=true)
        
    })
   
    @RequestMapping(method = RequestMethod.POST, value = "/expert-project-api/save")
	public String saveExpertpatent(@RequestBody  ZjkProject zjkProject,HttpServletRequest request, HttpServletResponse response) throws Exception {

    	Result resultsDate = new Result();
    	String id=zjkProject.getId();
    	
    	JSONObject parma = JSONObject.parseObject(JSONObject.toJSONString(zjkProject));
		System.out.println(">>>>>>>>>> 参数: "+parma.toJSONString());
		SysUser sysUserInfo = this.getUserProfile();
		if (id!=null && !id.equals("")) 
		{
			ResponseEntity<ZjkProject> se = this.restTemplate.exchange(GET_EXPERT_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), ZjkProject.class);
			ZjkProject oldZjkProject = se.getBody();
			oldZjkProject.setProjectName(zjkProject.getProjectName());
			oldZjkProject.setSetupYeat(zjkProject.getSetupYeat());
			oldZjkProject.setChargeUnit(zjkProject.getChargeUnit());
			oldZjkProject.setResearchTarget(zjkProject.getResearchTarget());
			oldZjkProject.setSecretLevel(zjkProject.getSecretLevel());
			oldZjkProject.setSeeUserIds(zjkProject.getSeeUserIds());
			oldZjkProject.setSeeUserNames(zjkProject.getSeeUserNames());
			
			ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(UPDATE_EXPERT_URL, HttpMethod.POST, new HttpEntity<ZjkProject>(oldZjkProject, this.httpHeaders), Integer.class);
			int statusCode = responseEntity.getStatusCodeValue();
			Integer dataId = responseEntity.getBody();
			// 返回结果代码
			if (statusCode == 200) {
				resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
			} else {
				resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
			}
		} else 
		{
			zjkProject.setCreateTime(new Date());
			zjkProject.setDelStatus(Constant.DEL_STATUS_NOT);
			zjkProject.setSourceType(Constant.SOURCE_TYPE_LOCATION);//数据来源（1本系统，2外系统）
			String dateid = UUID.randomUUID().toString().replaceAll("-", "");
			zjkProject.setId(dateid);
			zjkProject.setCreateUser(sysUserInfo.getUserId());
			zjkProject.setSeeUserIds(sysUserInfo.getUserId());
			zjkProject.setSeeUserNames(sysUserInfo.getUserDisp());
			ResponseEntity<String> responseEntity = this.restTemplate.exchange(ADD_EXPERT_URL, HttpMethod.POST, new HttpEntity<ZjkProject>(zjkProject, this.httpHeaders), String.class);
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
		return result.toString();
    }
    
    
    
    
    
    
    
    

}
