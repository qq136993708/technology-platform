package com.pcitc.service.system.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysDataModel;
import com.pcitc.base.system.SysDataModelExample;
import com.pcitc.base.system.SysDataModelExample.Criteria;
import com.pcitc.mapper.system.SysDataModelMapper;
import com.pcitc.service.system.SysDataModelService;

@Service("sysDataModelService")
@CacheConfig(cacheNames = "sysDataModelService")
public class SysDataModelServiceImpl implements SysDataModelService {

	@Autowired
	private SysDataModelMapper sysDataModelMapper;

	/** 
	 * @author zhf
	 * 查询数据模板列表，分页
	 */
	public LayuiTableData selectDataModelByPage(LayuiTableParam param) {
		Map<String, Object> paraMap = param.getParam();

		SysDataModelExample sdmExample = new SysDataModelExample();
		Criteria cri = sdmExample.createCriteria();
		if (paraMap.get("sts") != null && !paraMap.get("sts").equals("")) {
			cri.andStsEqualTo(paraMap.get("sts").toString());
		}
		if (paraMap.get("modelName") != null && !paraMap.get("modelName").equals("")) {
			cri.andModelNameLike("%" + paraMap.get("modelName").toString() + "%");
		}
		if (paraMap.get("dataId") != null && !paraMap.get("dataId").equals("")) {
			cri.andDataIdEqualTo(paraMap.get("dataId").toString());
		}
		if (paraMap.get("dataCode") != null && !paraMap.get("dataCode").equals("")) {
			cri.andDataCodeEqualTo(paraMap.get("dataCode").toString());
		}
		if (paraMap.get("proCode") != null && !paraMap.get("proCode").equals("")) {
			cri.andProCodeEqualTo(paraMap.get("proCode").toString());
		}

		sdmExample.setOrderByClause(" create_date desc ");

		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(param.getPage(), param.getLimit());

		List<SysDataModel> list = sysDataModelMapper.selectByExample(sdmExample);
		// 3、获取分页查询后的数据
		PageInfo<SysDataModel> pageInfo = new PageInfo<SysDataModel>(list);
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	/** 
	 * @author zhf
	 * 查询数据模板列表
	 */
	public JSONArray selectDataModelList(HashMap<String, Object> paraMap) {

		List<SysDataModel> list = sysDataModelMapper.selectDataModeWithGroup(paraMap);
		
		return JSONArray.parseArray(JSON.toJSONString(list));
	}
	
	/** 
	 * @author zhf
	 * 查询数据模板列表
	 */
	public JSONArray selectDataModelValueList(HashMap<String, Object> paraMap) {
		SysDataModelExample sdmExample = new SysDataModelExample();
		Criteria cri = sdmExample.createCriteria();
		if (paraMap.get("sts") != null && !paraMap.get("sts").equals("")) {
			cri.andStsEqualTo(paraMap.get("sts").toString());
		}
		if (paraMap.get("modelName") != null && !paraMap.get("modelName").equals("")) {
			cri.andModelNameLike("%" + paraMap.get("modelName").toString() + "%");
		}
		if (paraMap.get("dataId") != null && !paraMap.get("dataId").equals("")) {
			cri.andDataIdEqualTo(paraMap.get("dataId").toString());
		}
		if (paraMap.get("dataCode") != null && !paraMap.get("dataCode").equals("")) {
			cri.andDataCodeEqualTo(paraMap.get("dataCode").toString());
		}
		if (paraMap.get("proCode") != null && !paraMap.get("proCode").equals("")) {
			cri.andProCodeEqualTo(paraMap.get("proCode").toString());
		}

		sdmExample.setOrderByClause(" create_date desc ");

		List<SysDataModel> list = sysDataModelMapper.selectByExample(sdmExample);
		return JSONArray.parseArray(JSON.toJSONString(list));
	}

	/** 
	 * @author zhf
	 * 批量新增数据模板
	 */
	public Integer batchInsertSysDataModel(List<SysDataModel> dmList) {
		sysDataModelMapper.batchInsertSysDataModel(dmList);
		return 1;
	}

	
}
