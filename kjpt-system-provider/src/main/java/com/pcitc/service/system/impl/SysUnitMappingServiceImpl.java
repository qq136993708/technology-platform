package com.pcitc.service.system.impl;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysUnitMapping;
import com.pcitc.base.system.SysUnitMappingExample;
import com.pcitc.mapper.system.SysUnitMappingMapper;
import com.pcitc.service.system.SysUnitMappingService;


@Service("SysUnitMappingService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class SysUnitMappingServiceImpl implements SysUnitMappingService {

	@Autowired
	private SysUnitMappingMapper mapper;

	@Override
	public LayuiTableData querySysUnitMappingListByPage(LayuiTableParam param) {
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		
		String nodeId = (String) param.getParam().get("nodeId");
				
		// 2、执行查询
		SysUnitMappingExample example = new SysUnitMappingExample();
		SysUnitMappingExample.Criteria criteria = example.or();
	    //项目ID
		if(StringUtils.isNotEmpty(nodeId)) {
			criteria.andUnitMappingNodeIdEqualTo(nodeId);
		}
		// 3、排序
		example.setOrderByClause(" create_date desc");
		List<SysUnitMapping> list = mapper.selectByExample(example);
		PageInfo<SysUnitMapping> pageInfo= new PageInfo<SysUnitMapping>(list);
		// 4、封装需要返回的分页实体
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	@Override
	public int saveSysUnitMapping(List<SysUnitMapping> sysUnitMappings) {
		int result = 500;
		int delRet = 0;
		//删除
		if(sysUnitMappings!=null && sysUnitMappings.size()>0){
			SysUnitMapping sysUnitMapping = sysUnitMappings.get(0);
			String nodeId = sysUnitMapping.getUnitMappingNodeId();
			delRet = deleteSysUnitMapping(nodeId);
		}
		//保存
		if(delRet>0) {
			if(sysUnitMappings!=null && sysUnitMappings.size()>0){
				for(int i=0; i<sysUnitMappings.size(); i++) {
					SysUnitMapping sysUnitMapping = sysUnitMappings.get(i);
					sysUnitMapping.setDataId(UUID.randomUUID().toString().replace("-", ""));
					mapper.insertSelective(sysUnitMapping);
					result = 200;
				}
			}
		}
		return result;
	}

	@Override
	public int deleteSysUnitMapping(String id) {
		SysUnitMappingExample example = new SysUnitMappingExample();
		SysUnitMappingExample.Criteria criteria = example.or(); 
		String nodeId = "";
		if(StringUtils.isNotEmpty(id)) {
			nodeId = id;
		}
		criteria.andUnitMappingNodeIdEqualTo(nodeId);
		return mapper.deleteByExample(example);
	}
}
