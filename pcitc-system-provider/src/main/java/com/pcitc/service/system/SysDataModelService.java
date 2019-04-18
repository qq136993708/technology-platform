package com.pcitc.service.system;

import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysDataModel;

public interface SysDataModelService {

	/** 
	 * @author zhf
	 * 查询数据模板列表，分页
	 */
	public LayuiTableData selectDataModelByPage(LayuiTableParam param);
	
	/** 
	 * @author zhf
	 * 查询数据模板列表
	 */
	public JSONArray selectDataModelList(HashMap<String, Object> hashMap);
	
	/** 
	 * @author zhf
	 * 查询数据模板列表
	 */
	public JSONArray selectDataModelValueList(HashMap<String, Object> hashMap);
	
	/** 
	 * @author zhf
	 * 批量新增数据模板
	 */
	public Integer batchInsertSysDataModel(List<SysDataModel> dmList);
	
}
