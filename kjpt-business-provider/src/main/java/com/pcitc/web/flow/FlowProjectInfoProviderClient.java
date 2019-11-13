package com.pcitc.web.flow;

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
import com.pcitc.service.flow.FlowProjectInfoService;

@Api(value = "全流程接口", tags = { "维护管理全流程相关信息等" })
@RestController
public class FlowProjectInfoProviderClient {
	private final static Logger logger = LoggerFactory.getLogger(FlowProjectInfoProviderClient.class);

	@Autowired
	private FlowProjectInfoService flowProjectInfoService;

	@ApiOperation(value = "保存科研项目数据", notes = "包含费用性和资本性课题")
	@RequestMapping(value = "/flow-project-provider/out-project-info/batch-insert", method = RequestMethod.POST)
	public Integer insertFlowProjectInfo(@RequestBody FlowProjectInfo flowProjectInfo) throws Exception {
		System.out.println("insertFlowProjectInfo==================" + flowProjectInfo);
		flowProjectInfoService.batchInsertFlowProjectInfo(flowProjectInfo);
		return 1;

	}

}
