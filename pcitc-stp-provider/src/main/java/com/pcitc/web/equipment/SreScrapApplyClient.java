package com.pcitc.web.equipment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.service.equipment.ForApplicationService;
import com.pcitc.service.equipment.SreScrapApplyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "SreScrapApply-API",tags = {"报废申请"})
@RestController
public class SreScrapApplyClient {
	private final static Logger logger = LoggerFactory.getLogger(SreScrapApplyClient.class); 
	@Autowired
    private SreScrapApplyService sreScrapApplyService; 
	
	@ApiOperation(value = "报废分页", notes = "报废分页")
	@RequestMapping(value = "/sre-provider/sreScrapApply/page", method = RequestMethod.POST)
	public LayuiTableData getForApplicationList(@RequestBody LayuiTableParam param)throws Exception
	{
		
		LayuiTableData rageResult=sreScrapApplyService.getSreScrapApplyPage(param);
		
		
		return rageResult;
	}
}
