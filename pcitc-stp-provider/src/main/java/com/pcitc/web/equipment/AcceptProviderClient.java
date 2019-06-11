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
import com.pcitc.base.stp.equipment.SreHardwareAccept;
import com.pcitc.base.stp.equipment.SreSoftwareAccept;
import com.pcitc.service.equipment.EquipmentAcceptService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Accept-API",description = "装备验收（软件、硬件）相关的服务接口")
@RestController
public class AcceptProviderClient {
	
	private final static Logger logger = LoggerFactory.getLogger(EquipmentProviderClient.class); 
	@Autowired
    private EquipmentAcceptService acceptService; 
	
	
	@ApiOperation(value = "软件装备验收分页", notes = "软件装备验收分页")
	@RequestMapping(value = "/sre-provider/software-accept/page", method = RequestMethod.POST)
	public LayuiTableData getSoftwareAcceptPage(@RequestBody LayuiTableParam param)throws Exception
	{
		logger.info("==================page sreSoftwareAccept==========================="+param);
		return acceptService.getSoftwareAcceptPage(param);
	}
	
	@ApiOperation(value = "增加软件装备验收", notes = "增加软件装备验收")
	@RequestMapping(value = "/sre-provider/software-accept/add", method = RequestMethod.POST)
	public String insertSreSoftwareAccept(@RequestBody SreSoftwareAccept sreSoftwareAccept) throws Exception{
		logger.info("====================add sreSoftwareAccept....========================");
		Integer count= acceptService.insertSoftwareAccept(sreSoftwareAccept);
		return sreSoftwareAccept.getSoftwareId();
	}
	
	
	@ApiOperation(value = "修改软件装备验收", notes = "修改软件装备验收")
	@RequestMapping(value = "/sre-provider/software-accept/update", method = RequestMethod.POST)
	public Integer updateSreSoftwareAccept(@RequestBody SreSoftwareAccept sreSoftwareAccept) throws Exception{
		logger.info("==================update sreSoftwareAccept===========================");
		return acceptService.updateSoftwareAccept(sreSoftwareAccept);
	}
	
	@ApiOperation(value = "删除软件装备验收", notes = "删除软件装备验收")
	@RequestMapping(value = "/sre-provider/software-accept/delete/{id}", method = RequestMethod.POST)
	public int deleteSreSoftwareAccept(@ApiParam(value="主键ID",required=true)@PathVariable("id") String id)throws Exception{
		logger.info("=============================delete sreSoftwareAccept=================");
		return acceptService.deleteSoftwareAccept(id);
	}
	
	
	
	@ApiOperation(value = "获取软件装备验收", notes = "获取软件装备验收")
	@RequestMapping(value = "/sre-provider/software-accept/get/{id}", method = RequestMethod.GET)
	public SreSoftwareAccept selectById(@ApiParam(value="主键ID",required=true)@PathVariable(value = "id", required = true) String id) throws Exception {
		logger.info("===============================get sreSoftwareAccept id "+id+"===========");
		return acceptService.selectSoftwareAccept(id);
	}
	
	
	

	/**
	 * 批量删除
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "批量删除软件装备验收", notes = "批量删除软件装备验收")
	@RequestMapping(value = "/sre-provider/software-accept/batch-delete", method = RequestMethod.POST)
	public int batchDeleteSoftware(@RequestBody List<String> list)throws Exception{
		logger.info("=============================batch delete SoftwareAccept=================");
		return acceptService.batchDeleteSoftwareAccept(list);
	}
	
	
	
	
	
	
	
	/**=================================================硬件===============================================*/
	
	
	
	
	@ApiOperation(value = "硬件装备验收分页", notes = "硬件装备验收分页")
	@RequestMapping(value = "/sre-provider/hardware-accept/page", method = RequestMethod.POST)
	public LayuiTableData getHardwareAcceptPage(@RequestBody LayuiTableParam param)throws Exception
	{
		
		logger.info("==================page SreHardwareAccept==========================="+param);
		return acceptService.getHardwareAcceptPage(param);
		
	}
	
	@ApiOperation(value = "增加硬件装备验收", notes = "增加硬件装备验收")
	@RequestMapping(value = "/sre-provider/hardware-accept/add", method = RequestMethod.POST)
	public String insertSreHardwareAccept(@RequestBody SreHardwareAccept sreHardwareAccept) throws Exception{
		logger.info("====================add sreHardwareAccept....========================");
		Integer count= acceptService.insertHardwareAccept(sreHardwareAccept);
		return sreHardwareAccept.getHardwareId();
	}
	
	@ApiOperation(value = "修改硬件装备验收", notes = "修改硬件装备验收")
	@RequestMapping(value = "/sre-provider/hardware-accept/update", method = RequestMethod.POST)
	public Integer updateSreHardwareAccept(@RequestBody SreHardwareAccept sreHardwareAccept) throws Exception{
		logger.info("==================update sreHardwareAccept===========================");
		return acceptService.updateHardwareAccept(sreHardwareAccept);
	}
	
	@ApiOperation(value = "删除硬件装备验收", notes = "删除硬件装备验收")
	@RequestMapping(value = "/sre-provider/hardware-accept/delete/{id}", method = RequestMethod.POST)
	public int deleteSreHardwareAccept(@ApiParam(value="主键ID",required=true)@PathVariable("id") String id)throws Exception{
		logger.info("=============================delete sreHardwareAccept=================");
		return acceptService.deleteHardwareAccept(id);
	}
	
	@ApiOperation(value = "获取硬件装备验收", notes = "获取硬件装备验收")
	@RequestMapping(value = "/sre-provider/hardware-accept/get/{id}", method = RequestMethod.GET)
	public SreHardwareAccept selectSreHardwareAcceptById(@ApiParam(value="主键ID",required=true)@PathVariable(value = "id", required = true) String id) throws Exception {
		logger.info("===============================get sreHardwareAccept id "+id+"===========");
		return acceptService.selectHardwareAccept(id);
	}
	
	/**
	 * 批量删除
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "批量删除硬件装备验收", notes = "批量删除硬件装备验收")
	@RequestMapping(value = "/sre-provider/hardware-accept/batch-delete", method = RequestMethod.POST)
	public int batchDeleteHardware(@RequestBody List<String> list)throws Exception{
		logger.info("=============================batch delete Hardware=================");
		return acceptService.batchDeleteHardwareAccept(list) ;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
