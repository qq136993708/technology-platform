package com.pcitc.web.equipment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.service.equipment.PlanImplementService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value = "PlanImplement-API",tags = {"规划管理 相关的服务接口"})
@RestController
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class PlanImplementProviderClient {
	
	private final static Logger logger = LoggerFactory.getLogger(PlanImplementProviderClient.class); 
	@Autowired
    private PlanImplementService planImplementService; 
	
	
	/**规划管理
	 * @param paramsJson
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "规划发布分页", notes = "规划发布分页")
	@RequestMapping(value = "/sre-provider/planImplement/page")
	public LayuiTableData getPlanImplementPage(@RequestBody LayuiTableParam param)throws Exception
	{
		logger.info("==================page getPlanningManagementPage==========================="+param);
		
		return planImplementService.getPlanImplementPage(param);
	}
	
	
	
	

}
