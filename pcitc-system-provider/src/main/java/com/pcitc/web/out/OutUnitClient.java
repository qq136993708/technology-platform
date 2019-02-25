package com.pcitc.web.out;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.pcitc.base.stp.out.OutUnit;
import com.pcitc.service.out.OutUnitService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "OUTUNIT-API", description = "项目单位数据，从项目管理系统中获取")
@RestController
public class OutUnitClient {

	@Autowired
	private OutUnitService outUnitService;
	
	private final static Logger logger = LoggerFactory.getLogger(OutUnitClient.class);
	
	@ApiOperation(value = "获取项目单位数据", notes = "不分页")
	@RequestMapping(value = "/out-unit-provider/project-unit/list-bydefine2/{define2}", method = RequestMethod.POST)
	public List<OutUnit> selectProjectUnits(@PathVariable("define2") String define2) throws Exception {
		logger.info("==================page selectProjectPlanByCond===========================");
		return outUnitService.selectByDefine2(define2);
	}

	
}
