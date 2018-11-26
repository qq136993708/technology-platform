package com.pcitc.service.system.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.system.SysModule;
import com.pcitc.base.system.SysModuleExample;
import com.pcitc.base.system.SysModuleExample.Criteria;
import com.pcitc.base.system.SysModuleVo;
import com.pcitc.mapper.system.SysModuleMapper;
import com.pcitc.service.system.SysModuleService;
import com.pcitc.utils.StringUtils;

@Service("sysModuleService")
public class SysModuleServiceImpl implements SysModuleService {
	@Autowired
	private SysModuleMapper sysModuleMapper;

	@Override
	public JSONObject selectSysModuleList(SysModuleVo vo) throws Exception {
		// 每页显示条数
		int pageSize = Integer.parseInt(vo.getLimit());
		// 当前是第几页
		int pageNum = Integer.parseInt(vo.getPage());
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		// 2、执行查询
		SysModuleExample ex = new SysModuleExample();
		Criteria or = ex.or();
		if (vo.getModuleName() != null && vo.getModuleName().length() > 0) {
			or.andModuleNameLike("%"+vo.getModuleName()+"%");
		}
		if (vo.getModuleCode() != null && vo.getModuleCode().length() > 0) {
			or.andModuleCodeLike("%"+vo.getModuleCode()+"%");
		}
		List<SysModule> list = sysModuleMapper.selectByExample(ex);
		// 3、获取分页查询后的数据
		PageInfo<SysModule> pageInfo= new PageInfo<SysModule>(list);
		// 4、封装需要返回的分页实体
		JSONObject result = new JSONObject();
		result.put("totalCount", pageInfo.getTotal());
		result.put("list", list);
		return result;
	}

	@Override
	public int updateOrInsertSysModule(SysModule obj) throws Exception {
		int result = 500;
		if(StringUtils.isNotEmpty(obj.getId())){
			sysModuleMapper.updateByPrimaryKeySelective(obj);
		}else{
			String id = UUID.randomUUID().toString().replace("-", "");
			obj.setId(id);
			sysModuleMapper.insertSelective(obj);
		}
		result = 200;
		return result;
	}

	@Override
	public int deleteSysModule(String id) throws Exception {
		int result = 500;
		if(id!=null && id!=""){
			sysModuleMapper.deleteByPrimaryKey(id);
		}
		result = 200;
		return result;
	}

	@Override
	public SysModule getSysModuleById(String id) throws Exception {
		return sysModuleMapper.selectByPrimaryKey(id);
	}

}
