package com.pcitc.web.outApi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.stp.flow.FlowProjectInfo;
import com.pcitc.service.outApi.OutProjectRequireService;

@Api(value = "对外提供的项目需求接收接口", tags = { "项目需求接收" })
@RestController
public class OutProjectRequireProviderClient {
	private final static Logger logger = LoggerFactory.getLogger(OutProjectRequireProviderClient.class);

	@Autowired
	private OutProjectRequireService outProjectRequireService;

	@ApiOperation(value = "保存科研项目数据", notes = "包含费用性和资本性课题")
	@RequestMapping(value = "/project-require-provider/out/add", method = RequestMethod.POST)
	public String saveOutProjectRequire(@RequestBody FlowProjectInfo flowProjectInfo) throws Exception {
		System.out.println("insertFlowProjectInfo==================" + flowProjectInfo);
		//flowProjectInfoService.batchInsertFlowProjectInfo(flowProjectInfo);
		return "";

	}

}
