package com.pcitc.web.controller.qims;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Api(value = "Qims-API",tags = {"外系统-质量接口"})
@RestController
public class QimsController extends BaseController {

	private static final String QualityStatistics = "http://localhost:8765/qims-provider/qualityStatistics/qualityStatistics_excute/";
	private static final String QUERY = "http://kjpt-zuul/stp-proxy/qims-provider/qualityStatistics/qualityStatistics_query";

	@Value("${keyStr}")
	private String keyStr;

	/**
	 *查询外系统-项目
	 */
	@ApiOperation(value = "请求外系统-质量接口", notes = "请求外系统-质量接口")
	@RequestMapping(value = "/qims-api/qualityStatistics", method = RequestMethod.GET)
	public JSONObject qualityStatistics(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RestTemplate restTemplate_req = new RestTemplate();
		ResponseEntity<JSONObject> responseEntity = restTemplate_req.exchange(QualityStatistics+keyStr, HttpMethod.GET, new HttpEntity<String>(new HttpHeaders()), JSONObject.class);
		return responseEntity.getBody();
	}


	/**
	 *查询外系统-项目
	 */
	/**
	 * 根据条件查询质量接口列表-分页查询
	 *
	 * @return PageInfo
	 */
	@ApiOperation(value = "查询质量接口", notes = "查询质量接口")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "key", value = "键值", dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "date", value = "日期", dataType = "Date", paramType = "query")
	})
	@ResponseBody
	@RequestMapping(value = "/qims-api/qualityStatistics/query", method = RequestMethod.GET)
	public String query( @RequestParam(required = true) String key,
						   @RequestParam(required = true) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date date) throws Exception {
		Map<String, Object> condition = new HashMap<>(6);
		if (!StringUtils.isEmpty(key)) {
			this.setParam(condition, "key", key);
		}
		if (!StringUtils.isEmpty(DateUtil.format(date,DateUtil.FMT_SS))) {
			this.setParam(condition, "date", DateUtil.format(date,DateUtil.FMT_SS));
		}
		ResponseEntity<String> responseEntity = this.restTemplate.exchange(QUERY, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), String.class);
		return responseEntity.getBody();
	}
}
