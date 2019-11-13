package com.pcitc.web.equipment;
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
import com.pcitc.base.common.PageResult;
import com.pcitc.base.stp.equipment.SreContract;
import com.pcitc.service.equipment.ContractService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value = "Contract-API",description = "合同信息相关的服务接口")
@RestController
public class ContractProviderClient {
	
	private final static Logger logger = LoggerFactory.getLogger(EquipmentProviderClient.class); 
	@Autowired
    private ContractService contractService; 
	
	
	@ApiOperation(value = "合同信息分页", notes = "合同信息分页")
	@RequestMapping(value = "/sre-provider/contract/page", method = RequestMethod.POST)
	public LayuiTableData getContractPage(@RequestBody LayuiTableParam param)throws Exception
	{
		logger.info("==================page SreContract==========================="+param);
		return contractService.getContractPage(param);
	}
	
	@ApiOperation(value = "增加合同信息", notes = "增加合同信息")
	@RequestMapping(value = "/sre-provider/contract", method = RequestMethod.POST)
	public String insertSreContract(@RequestBody SreContract sreContract) throws Exception{
		logger.info("====================add SreContract....========================");
		Integer count= contractService.insertContract(sreContract) ;
		return sreContract.getContractId();
	}
	
	
	@ApiOperation(value = "修改合同信息", notes = "修改合同信息")
	@RequestMapping(value = "/sre-provider/contract/update", method = RequestMethod.PUT)
	public Integer updateSreContract(@RequestBody SreContract record) throws Exception{
		logger.info("==================update SreContract===========================");
		return contractService.updateContract(record) ;
	}
	
	@ApiOperation(value = "删除合同信息", notes = "删除合同信息")
	@RequestMapping(value = "/sre-provider/contract/{id}", method = RequestMethod.DELETE)
	public int deleteSreContract(@PathVariable("id") String id)throws Exception{
		logger.info("=============================delete SreContract=================");
		return contractService.deleteContract(id);
	}
	
	
	
	@ApiOperation(value = "获取合同信息", notes = "获取合同信息")
	@RequestMapping(value = "/sre-provider/contract/{id}", method = RequestMethod.GET)
	public SreContract selectById(@PathVariable(value = "id", required = true) String id) throws Exception {
		logger.info("===============================get SreContract id "+id+"===========");
		return contractService.selectContract(id);
	}
	
	/**
	 * 批量删除
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "批量删除合同信息", notes = "批量删除合同信息")
	@RequestMapping(value = "/sre-provider/contract/batch-delete", method = RequestMethod.POST)
	public int batchDeleteContract(@RequestBody List<String> list)throws Exception{
		logger.info("=============================batch delete Contract=================");
		return contractService.batchDeleteContract(list);
	}
	
	
	

}
