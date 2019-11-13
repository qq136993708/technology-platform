package com.pcitc.web.out;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.out.OutNotice;
import com.pcitc.base.stp.out.OutReward;
import com.pcitc.service.out.OutNoticeService;

@Api(value = "Accept-API", description = "其他系统的通知公告服务接口")
@RestController
public class OutNoticeClient {

	@Autowired
	private OutNoticeService outNoticeService;
	private final static Logger logger = LoggerFactory.getLogger(OutNoticeClient.class);

	@ApiOperation(value = "项目管理系统的通知公告", notes = "分页查询")
	@RequestMapping(value = "/out-notice/type/page", method = RequestMethod.POST)
	public LayuiTableData getOutNoticePage(@RequestBody LayuiTableParam param) throws Exception {
		logger.info("==================page OutNotice===========================" + param);
		return outNoticeService.getOutNoticePage(param);
	}
	
	@ApiOperation(value = "根据id查询详情", notes = "根据id查询详情")
	@RequestMapping(value = "/out-notice/type/notice/{dataId}", method = RequestMethod.POST)
	public OutNotice getOutNoticeDetails(@PathVariable(value = "dataId", required = true) String dataId) throws Exception{
		return outNoticeService.getOutNoticeDetails(dataId);
	}

}
