package com.pcitc.web.controller.index;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.indexHome.calResult;
import com.pcitc.base.standardmaintain.StandardMaintainBI;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.RestBaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * @Author xiaoh
 * @Description 领导驾驶舱首页查询
 * @Date 2020/6/9 14:54
 * @param
 * @return
 **/
@Api(value = "领导驾驶舱首页查询",tags = {"领导驾驶舱首页查询"})
@RestController
public class IndexHomeBIController extends RestBaseController {

	// 科技专家
	private static final String getTechnologyExpert = "http://kjpt-zuul/stp-proxy/indexHomeBI/getTechnologyExpert";

	// 科研平台
	private static final String getTechnologyPlatform = "http://kjpt-zuul/stp-proxy/indexHomeBI/getTechnologyPlatform";

	// 成果获奖（累计）
	private static final String getAchieveAward = "http://kjpt-zuul/stp-proxy/indexHomeBI/getAchieveAward";

	// 知识产权（累计）
	private static final String getIntellectualProperty = "http://kjpt-zuul/stp-proxy/indexHomeBI/getIntellectualProperty";

	// 专利数量（累计）
	private static final String getPatent = "http://kjpt-zuul/stp-proxy/indexHomeBI/getPatent";

	// 成果转化（累计）
	private static final String getAchieveTransfer = "http://kjpt-zuul/stp-proxy/indexHomeBI/getAchieveTransfer";

	// 科研项目（累计）
	private static final String getTechnologyProject = "http://kjpt-zuul/stp-proxy/indexHomeBI/getTechnologyProject";

	// 项目投资（累计）
	private static final String getProjectInvest = "http://kjpt-zuul/stp-proxy/indexHomeBI/getProjectInvest";

	// 质量信息（累计）
	private static final String getQualityInfo = "http://kjpt-zuul/stp-proxy/indexHomeBI/getQualityInfo";
	// 二级单位科研平台分布情况
	private static final String distribution = "http://kjpt-zuul/stp-proxy/indexHomeBI/distribution";

	@ApiOperation(value="科技专家")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "year", value = "年份", dataType = "String", paramType = "query")
	})
	@RequestMapping(value = "/indexHomeBI-api/getTechnologyExpert", method = RequestMethod.GET)
	public List<calResult> getTechnologyExpert(
			@RequestParam(required = false,value = "year") String year
	) {
		Map<String, Object> condition = new HashMap<>(2);
		if (!StringUtils.isEmpty(year)) {
			this.setParam(condition, "year", year);
		}
		this.setBaseParam(condition);
		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(getTechnologyExpert, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), JSONArray.class);
		List list = JSONObject.parseArray(responseEntity.getBody().toJSONString(), calResult.class);
		return list;
	}


	@ApiOperation(value="科研平台")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "year", value = "年份", dataType = "String", paramType = "query")
	})
	@RequestMapping(value = "/indexHomeBI-api/getTechnologyPlatform", method = RequestMethod.GET)
	public List<calResult> getTechnologyPlatform(
			@RequestParam(required = false,value = "year") String year
	) {
		Map<String, Object> condition = new HashMap<>(2);
		if (!StringUtils.isEmpty(year)) {
			this.setParam(condition, "year", year);
		}
		this.setBaseParam(condition);
		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(getTechnologyPlatform, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), JSONArray.class);
		List list = JSONObject.parseArray(responseEntity.getBody().toJSONString(), calResult.class);
		return list;
	}

	@ApiOperation(value="成果获奖（累计）")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "year", value = "年份", dataType = "String", paramType = "query")
	})
	@RequestMapping(value = "/indexHomeBI-api/getAchieveAward", method = RequestMethod.GET)
	public List<calResult> getAchieveAward(
			@RequestParam(required = false,value = "year") String year
	) {
		Map<String, Object> condition = new HashMap<>(2);
		if (!StringUtils.isEmpty(year)) {
			this.setParam(condition, "year", year);
		}
		this.setBaseParam(condition);
		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(getAchieveAward, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), JSONArray.class);
		List list = JSONObject.parseArray(responseEntity.getBody().toJSONString(), calResult.class);
		return list;
	}

	@ApiOperation(value="知识产权（累计）")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "year", value = "年份", dataType = "String", paramType = "query")
	})
	@RequestMapping(value = "/indexHomeBI-api/getIntellectualProperty", method = RequestMethod.GET)
	public List<calResult> getIntellectualProperty(
			@RequestParam(required = false,value = "year") String year
	) {
		Map<String, Object> condition = new HashMap<>(2);
		if (!StringUtils.isEmpty(year)) {
			this.setParam(condition, "year", year);
		}
		this.setBaseParam(condition);
		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(getIntellectualProperty, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), JSONArray.class);
		List list = JSONObject.parseArray(responseEntity.getBody().toJSONString(), calResult.class);
		return list;
	}

	@ApiOperation(value="专利数量（累计）")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "year", value = "年份", dataType = "String", paramType = "query")
	})
	@RequestMapping(value = "/indexHomeBI-api/getPatent", method = RequestMethod.GET)
	public List<calResult> getPatent(
			@RequestParam(required = false,value = "year") String year
	) {
		Map<String, Object> condition = new HashMap<>(2);
		if (!StringUtils.isEmpty(year)) {
			this.setParam(condition, "year", year);
		}
		this.setBaseParam(condition);
		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(getPatent, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), JSONArray.class);
		List list = JSONObject.parseArray(responseEntity.getBody().toJSONString(), calResult.class);
		return list;
	}

	@ApiOperation(value="成果转化（累计）")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "year", value = "年份", dataType = "String", paramType = "query")
	})
	@RequestMapping(value = "/indexHomeBI-api/getAchieveTransfer", method = RequestMethod.GET)
	public List<calResult> getAchieveTransfer(
			@RequestParam(required = false,value = "year") String year
	) {
		Map<String, Object> condition = new HashMap<>(2);
		if (!StringUtils.isEmpty(year)) {
			this.setParam(condition, "year", year);
		}
		this.setBaseParam(condition);
		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(getAchieveTransfer, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), JSONArray.class);
		List list = JSONObject.parseArray(responseEntity.getBody().toJSONString(), calResult.class);
		return list;
	}

	@ApiOperation(value="科研项目（累计）")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "year", value = "年份", dataType = "String", paramType = "query")
	})
	@RequestMapping(value = "/indexHomeBI-api/getTechnologyProject", method = RequestMethod.GET)
	public List<calResult> getTechnologyProject(
			@RequestParam(required = false,value = "year") String year
	) {
		Map<String, Object> condition = new HashMap<>(2);
		if (!StringUtils.isEmpty(year)) {
			this.setParam(condition, "year", year);
		}
		this.setBaseParam(condition);
		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(getTechnologyProject, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), JSONArray.class);
		List list = JSONObject.parseArray(responseEntity.getBody().toJSONString(), calResult.class);
		return list;
	}

	@ApiOperation(value="项目投资（累计）")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "year", value = "年份", dataType = "String", paramType = "query")
	})
	@RequestMapping(value = "/indexHomeBI-api/getProjectInvest", method = RequestMethod.GET)
	public List<calResult> getProjectInvest(
			@RequestParam(required = false,value = "year") String year
	) {
		Map<String, Object> condition = new HashMap<>(2);
		if (!StringUtils.isEmpty(year)) {
			this.setParam(condition, "year", year);
		}
		this.setBaseParam(condition);
		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(getProjectInvest, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), JSONArray.class);
		List list = JSONObject.parseArray(responseEntity.getBody().toJSONString(), calResult.class);
		return list;
	}

	@ApiOperation(value="质量信息（累计）")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "year", value = "年份", dataType = "String", paramType = "query")
	})
	@RequestMapping(value = "/indexHomeBI-api/getQualityInfo", method = RequestMethod.GET)
	public List<calResult> getQualityInfo(
			@RequestParam(required = false,value = "year") String year
	) {
		Map<String, Object> condition = new HashMap<>(2);
		if (!StringUtils.isEmpty(year)) {
			this.setParam(condition, "year", year);
		}
		this.setBaseParam(condition);
		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(getQualityInfo, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), JSONArray.class);
		List list = JSONObject.parseArray(responseEntity.getBody().toJSONString(), calResult.class);
		return list;
	}
	@ApiOperation(value="科研平台二级单位分布情况")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "level", value = "平台等级", dataType = "String", paramType = "query")
	})
	@RequestMapping(value = "/indexHomeBI-api/distribution", method = RequestMethod.GET)
	public List<calResult> distribution(
			@RequestParam(required = false,value = "level") String level
	) {
		Map<String, Object> condition = new HashMap<>(2);
		if (!StringUtils.isEmpty(level)) {
			this.setParam(condition, "year", level);
		}
		this.setBaseParam(condition);
		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(distribution, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), JSONArray.class);
		List list = JSONObject.parseArray(responseEntity.getBody().toJSONString(), calResult.class);
		return list;
	}

}
