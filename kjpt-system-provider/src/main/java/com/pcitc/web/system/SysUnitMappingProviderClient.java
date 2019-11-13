package com.pcitc.web.system;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
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
import com.pcitc.base.system.SysUnitMapping;
import com.pcitc.service.system.SysUnitMappingService;

@Api(value="单位映射关系",tags= {"单位映射关系服务接口"})
@RestController
public class SysUnitMappingProviderClient 
{
	private final static Logger logger = LoggerFactory.getLogger(SysUnitMappingProviderClient.class);
	
	@Autowired
	SysUnitMappingService service; 
	
	/**
	 * 查看单位映射关系列表
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "查看单位映射关系列表")
	@RequestMapping(value = "/engin/preparation/sysUnitMapping-provider/list",method = RequestMethod.POST)
	public Object querySysUnitMappingListByPage(@RequestBody LayuiTableParam param) {
		LayuiTableData data = null;
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			data = service.querySysUnitMappingListByPage(param);
			if(data.getData() != null && data.getData().size()>0) {
				List<?> retLists = data.getData();
				if(retLists != null && retLists.size()>0) {
					for(int i=0; i<retLists.size(); i++) {
						SysUnitMapping sysUnitMapping =  (SysUnitMapping)retLists.get(i);
						String unitId = sysUnitMapping.getUnitMappingUnitId();
						Map<String,Object> map = new HashMap<String,Object>();
						map.put("id", unitId);
						list.add(map);
					}
				}
			}
		} catch (Exception e) {
			logger.error("[实施项目信息-查询单位映射关系列表失败：]", e);
		}
		return list;
	}
	
	/**
	 * 新增单位映射关系
	 * @param vo
	 * @return
	 */
	@ApiOperation(value = "新增单位映射关系保存", notes = "新增单位映射关系保存")
	@RequestMapping(value = "/engin/preparation/sysUnitMapping-provider/add", method = RequestMethod.POST)
	public int saveSysUnitMapping(@RequestBody List<SysUnitMapping> sysUnitMappings){
		int result = 500;
		try {
			result = service.saveSysUnitMapping(sysUnitMappings);
		} catch (Exception e) {
			logger.error("[实施项目信息-保存单位映射关系失败]", e);
		}
		return result;
	}
	
	/**
	 * 删除单位映射关系
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "删除单位映射关系-key", notes = "根据ID删除单位映射关系信息")
	@RequestMapping(value = "/engin/preparation/sysUnitMapping-provider/delete/{id}", method = RequestMethod.POST)
	public int deleteSysUnitMapping(@PathVariable(value = "id", required = true) String id){
		int result = 500;
		try {
			result = service.deleteSysUnitMapping(id);
		} catch (Exception e) {
			logger.error("[实施项目信息-删除单位映射关系失败]", e);
		}
		return result;
	}
}
