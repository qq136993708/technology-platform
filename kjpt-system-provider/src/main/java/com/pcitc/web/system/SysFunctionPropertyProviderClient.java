package com.pcitc.web.system;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.system.SysDataModel;
import com.pcitc.base.system.SysFunctionProperty;
import com.pcitc.service.system.SysDataModelService;
import com.pcitc.service.system.SysFunctionPropertyService;

@Api(value = "SysFunctionProperty-API",description = "菜单权限配置相关的接口")
@RestController
public class SysFunctionPropertyProviderClient {
	private final static Logger logger = LoggerFactory.getLogger(SysFunctionPropertyProviderClient.class);

	@Autowired
	private SysFunctionPropertyService sysFunctionPropertyService;
	
	@Autowired
	private SysDataModelService sysDataModelService;

	/**
	 * 查询菜单配置列表
	 * @param obj
	 * @return
	 */
	@ApiOperation(value = "查询菜单配置列表", notes = "传入json格式的菜单配置实体属性")
	@RequestMapping(value = "/sysFunctionProperty-provider/sysFunctionProperty_list",method = RequestMethod.POST)
	public String selectSysFunctionPropertyByPage(@RequestBody SysFunctionProperty obj) {
		JSONObject tem = null;
		try {
			tem = sysFunctionPropertyService.selectSysFunctionPropertyList(obj);
		} catch (Exception e) {
			logger.error("[系统管理-查询菜单配置列表失败：]", e);
			e.printStackTrace();
		}
		return tem.toString();
	}
	
	/**
	 * 新增或修改菜单配置
	 * @param obj
	 * @return
	 */
	@ApiOperation(value = "新增或修改菜单配置", notes = "传入json格式的菜单配置实体属性")
	@RequestMapping(value = "/sysFunctionProperty-provider/saveSysFunctionProperty", method = RequestMethod.POST)
	public int saveSysFunctionProperty(@RequestBody SysFunctionProperty obj){
		int result = 500;
		try {
			result = sysFunctionPropertyService.updateOrInsertSysFunctionProperty(obj);
		} catch (Exception e) {
			logger.error("[菜单配置管理-保存菜单配置失败：]", e);
		}
		return result;
	}
	
	/**
	 * 删除菜单配置
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "删除菜单配置", notes = "传入菜单配置实体id属性")
	@RequestMapping(value = "/sysFunctionProperty-provider/deleteSysFunctionProperty/{id}", method = RequestMethod.POST)
	public int deleteDictionary(@PathVariable(value = "id", required = true) String id){
		int result = 500;
		try {
			result = sysFunctionPropertyService.deleteSysFunctionProperty(id);
		} catch (Exception e) {
			logger.error("[菜单配置管理-删除菜单配置失败：]", e);
		}
		return result;
	}
	
	/**
	 * 根据id查询菜单配置
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "根据id查询菜单配置", notes = "传入菜单配置实体id属性")
	@RequestMapping(value = "/sysFunctionProperty-provider/getSysFunctionPropertyById/{id}", method = RequestMethod.POST)
	public SysFunctionProperty getSysFunctionPropertyById(@PathVariable(value = "id", required = true) String id){
		SysFunctionProperty sysFunctionProperty = null;
		try {
			sysFunctionProperty = sysFunctionPropertyService.getSysFunctionPropertyById(id);
		} catch (Exception e) {
			logger.error("[菜单配置管理-初始化菜单配置失败：]", e);
		}
		return sysFunctionProperty;
	}
	
	/**
	 * 查询菜单配置
	 * @param obj
	 * @return
	 */
	@ApiOperation(value = "查询菜单配置", notes = "传入json格式的菜单配置实体属性")
	@RequestMapping(value = "/sysFunctionProperty-provider/getSysFunctionProperty", method = RequestMethod.POST)
	public SysFunctionProperty getSysFunctionProperty(@RequestBody SysFunctionProperty obj){
		SysFunctionProperty sysFunctionProperty = null;
		try {
			sysFunctionProperty = sysFunctionPropertyService.getSysFunctionProperty(obj);
		} catch (Exception e) {
			logger.error("[菜单配置管理-初始化菜单配置失败：]", e);
		}
		return sysFunctionProperty;
	}
	
	/**
	 * 查询菜单配置列表
	 * @param obj
	 * @return
	 */
	@ApiOperation(value = "查询某个数据配置项的列表", notes = "查询条件为数据配配置项")
	@RequestMapping(value = "/sysFunctionProperty-provider/data/model/list",method = RequestMethod.POST)
	public JSONArray selectDataModelList(@RequestBody HashMap<String, Object> hashmap) {
		JSONArray tem = sysDataModelService.selectDataModelList(hashmap);
		return tem;
	}
	
	/**
	 * 查询菜单配置列表
	 */
	@ApiOperation(value = "查询某个数据配置项内容的列表", notes = "查询条件为数据配配置项")
	@RequestMapping(value = "/sysFunctionProperty-provider/data/model/value/list",method = RequestMethod.POST)
	public JSONArray selectDataModelValueList(@RequestBody HashMap<String, Object> hashmap) {
		JSONArray tem = sysDataModelService.selectDataModelValueList(hashmap);
		return tem;
	}

	/**
	 * 查询菜单配置列表
	 */
	@ApiOperation(value = "保存数据模板", notes = "批量保存")
	@RequestMapping(value = "/sysFunctionProperty-provider/data/model/save",method = RequestMethod.POST)
	public int batchInsertSysDataModel(@RequestBody SysDataModel sysDataModel) {
		List<SysDataModel> dmList = new ArrayList<SysDataModel>();
		String[] dataArray = sysDataModel.getModelDataId().split(",");
		sysDataModel.setDataId(UUID.randomUUID().toString().replaceAll("-", ""));
		for (int i = 0; i < dataArray.length; i++) {
			SysDataModel sdm = new SysDataModel();
			sdm.setDataId(UUID.randomUUID().toString().replaceAll("-", ""));
			sdm.setDataCode(sysDataModel.getDataId());
			sdm.setSts("1");
			sdm.setCreateDate(sysDataModel.getCreateDate());
			sdm.setCreateUser(sysDataModel.getCreateUser());
			sdm.setProCode(sysDataModel.getProCode());
			sdm.setModelDataId(dataArray[i]);
			sdm.setModelName(sysDataModel.getModelName());
			dmList.add(sdm);
		}
		int tem = sysDataModelService.batchInsertSysDataModel(dmList);
		return tem;
	}
	
	/**
	 * 查询已经某个菜单、某个配置项、某个岗位已经配置的研究院
	 */
	@ApiOperation(value = "查询已经某个菜单、某个配置项、某个岗位已经配置的研究院", notes = "菜单id、配置项id、岗位id")
	@RequestMapping(value = "/sysFunctionProperty-provider/dictionary/data/control/list",method = RequestMethod.POST)
	public JSONArray selectInstituteData(@RequestBody HashMap<String, Object> hashmap) {
		List list = sysFunctionPropertyService.selectInstituteData(hashmap);
		return JSONArray.parseArray(JSON.toJSONString(list));
	}
	
	
}
