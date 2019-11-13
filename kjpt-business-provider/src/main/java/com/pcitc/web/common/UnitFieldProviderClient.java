package com.pcitc.web.common;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.pcitc.base.stp.equipment.UnitField;
import com.pcitc.service.equipment.UnitFieldService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value = "unitField-API",description = "专业领域信息相关的服务接口")
@RestController
public class UnitFieldProviderClient {
	
	private final static Logger logger = LoggerFactory.getLogger(UnitFieldProviderClient.class); 
	@Autowired
    private UnitFieldService unitFieldService; 
	
	
	@ApiOperation(value = "专业领域信息分页", notes = "专业领域信息分页")
	@RequestMapping(value = "/stp_unitField/unitField/page", method = RequestMethod.POST)
	public LayuiTableData getUnitFieldPage(@RequestBody LayuiTableParam param)throws Exception
	{
		logger.info("==================page unitField==========================="+param);
		return unitFieldService.getUnitFieldPage(param);
	}
	
	@ApiOperation(value = "增加专业领域信息", notes = "增加专业领域信息")
	@RequestMapping(value = "/stp_unitField/unitField", method = RequestMethod.POST)
	public String insertUnitField(@RequestBody UnitField unitField) throws Exception{
		logger.info("====================add unitField....========================");
		Integer count= unitFieldService.insertUnitField(unitField) ;
		return unitField.getDataId();
	}
	
	
	@ApiOperation(value = "修改专业领域信息", notes = "修改专业领域信息")
	@RequestMapping(value = "/stp_unitField/unitField/update", method = RequestMethod.PUT)
	public Integer updateUnitField(@RequestBody UnitField record) throws Exception{
		logger.info("==================update unitField===========================");
		return unitFieldService.updateUnitField(record) ;
	}
	
	@ApiOperation(value = "删除专业领域信息", notes = "删除专业领域信息")
	@RequestMapping(value = "/stp_unitField/unitField/{id}", method = RequestMethod.DELETE)
	public int deleteUnitField(@PathVariable("id") String id)throws Exception{
		logger.info("=============================delete unitField=================");
		return unitFieldService.deleteUnitField(id);
	}
	
	
	
	@ApiOperation(value = "获取专业领域信息", notes = "获取专业领域信息")
	@RequestMapping(value = "/stp_unitField/unitField/{id}", method = RequestMethod.GET)
	public UnitField selectById(@PathVariable(value = "id", required = true) String id) throws Exception {
		logger.info("===============================get unitField id "+id+"===========");
		return unitFieldService.selectUnitField(id);
	}
	
	
	
	
	@ApiOperation(value = "部门", notes = "部门")
	@RequestMapping(value = "/stp_unitField/getUnitNameList", method = RequestMethod.GET)
	public List<UnitField> getUnitNameList()throws Exception
	{
		return unitFieldService.getUnitNameList();
	}
	
	
	
	@ApiOperation(value = "专业领域", notes = "专业领域门")
	@RequestMapping(value = "/stp_unitField/getDepartmentNameListByUnitName", method = RequestMethod.POST)
	public List<UnitField> getDepartmentNameListByUnitName(@RequestBody UnitField unitField)throws Exception
	{
		Map map=new HashMap();
		map.put("unitName", unitField.getUnitName());
		return unitFieldService.getDepartmentNameListByUnitName(map);
	}
	
	
	@ApiOperation(value = "专业处", notes = "专业处")
	@RequestMapping(value = "/stp_unitField/getProfessionalNameListByUnitNameAndDept", method = RequestMethod.POST)
	public List<UnitField> getProfessionalNameListByUnitNameAndDept(@RequestBody UnitField unitField)throws Exception
	{
		
		Map map=new HashMap();
		map.put("unitName", unitField.getUnitName());
		map.put("departmentName", unitField.getDepartmentName());
		return unitFieldService.getProfessionalNameListByUnitNameAndDept(map);
	}
	
	
	

}
