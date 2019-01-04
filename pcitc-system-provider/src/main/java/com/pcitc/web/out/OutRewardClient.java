package com.pcitc.web.out;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
import com.pcitc.base.stp.out.OutReward;
import com.pcitc.service.out.OutRewardService;

@Api(value = "REWARD-API", description = "奖励数据，从项目管理系统中获取")
@RestController
public class OutRewardClient {
	
	@Autowired
	private OutRewardService outRewardService;

	private final static Logger logger = LoggerFactory.getLogger(OutRewardClient.class);

	@ApiOperation(value = "分页显示奖励数据", notes = "分页显示奖励数据")
	@RequestMapping(value = "/out-provider/reward-list", method = RequestMethod.POST)
	public LayuiTableData getOutRewardListPage(@RequestBody LayuiTableParam param) throws Exception {
		logger.info("==================page getOutRewardListPage==================" + param);
		return outRewardService.getOutRewardListPage(param);
	}

	@ApiOperation(value = "科技成果年份列表", notes = "获取拥有科技成果历史记录的年份")
	@RequestMapping(value = "/out-provider/reward-year-list", method = RequestMethod.POST)
	public Object getOutRewardYearList() throws Exception {
		logger.info("==================nopage selectOutRewardYearList==================");
		return outRewardService.selectOutRewardYearList();
	}

	/**
	 * @author Nishikino
	 * 查询id
	 */
	@ApiOperation(value = "根据id查询详情", notes = "根据id查询详情")
	@RequestMapping(value = "/out-provider/get-reward-list/{dataId}", method = RequestMethod.POST)
	public OutReward getOutAppraisalShow(@PathVariable(value = "dataId", required = true) String dataId) throws Exception{
		return outRewardService.getOutRewardShowById(dataId);
	}
	
}
