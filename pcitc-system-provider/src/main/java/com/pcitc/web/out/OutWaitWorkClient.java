package com.pcitc.web.out;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.out.OutWaitWork;
import com.pcitc.service.out.OutWaitWorkService;

@Api(value = "Accept-API", description = "待办相关的服务接口")
@RestController
public class OutWaitWorkClient {

	@Autowired
	private OutWaitWorkService outWaitWorkService;
	private final static Logger logger = LoggerFactory.getLogger(OutWaitWorkClient.class);

	@ApiOperation(value = "待办分页", notes = "待办分页")
	@RequestMapping(value = "/out-wait-work/page", method = RequestMethod.POST)
	public LayuiTableData getOutWaitWorkPage(@RequestBody LayuiTableParam param) throws Exception {
		logger.info("==================page OutWaitWork===========================" + param);
		return outWaitWorkService.getOutWaitWorkPage(param);
	}

	@ApiOperation(value = "待办列表", notes = "待办列表")
	@RequestMapping(value = "/out-wait-work/list", method = RequestMethod.POST)
	public List getOutWaitWorkList(@RequestBody OutWaitWork outWaitWork) throws Exception {
		logger.info("====================get list OutWaitWork....========================");
		List list = outWaitWorkService.getOutWaitWorkList(outWaitWork);
		return list;
	}

}
