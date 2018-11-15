package com.pcitc.service.specialist.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.pcitc.base.stp.specialist.SpeBaseinfoMaintain;
import com.pcitc.mapper.specialist.SpeBaseinfoMaintainMapper;
import com.pcitc.service.specialist.SpeBaseinfoMaintainService;
@Service("speBaseinfoMaintainService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class SpeBaseinfoMaintainServiceImpl implements SpeBaseinfoMaintainService {

	@Autowired
	private SpeBaseinfoMaintainMapper speBaseinfoMaintainMapper;

	@Override
	public JSONObject queryBaseinfoMaintainListByPage(SpeBaseinfoMaintain tableInfo) {
		//每页显示条数
		int pageSize = Integer.parseInt(tableInfo.getLimit());
		//从第多少条开始
		int pageStart = Integer.parseInt(tableInfo.getPage());
		//当前是第几页
		//int pageNum = pageStart/pageSize + 1;
				
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageStart, pageSize);
		// 2、执行查询
		List<SpeBaseinfoMaintain> list = speBaseinfoMaintainMapper.queryBaseinfoMaintainListByPage(tableInfo);
		// 4、封装需要返回的分页实体
		JSONObject result = new JSONObject();
		result.put("count", speBaseinfoMaintainMapper.countByBaseinfoMaintain(tableInfo));
		result.put("data", list);
		result.put("code", "0");
		result.put("msg", "-");
		return result;
	}

	@Override
	public int deleteBaseinfoMaintain(String id) throws Exception {
		int result = 500;
		if (id != null && id != "") {
			speBaseinfoMaintainMapper.deleteByPrimaryKey(id);
		}
		result = 200;
		return result;
	}

	@Override
	public SpeBaseinfoMaintain updateOrInsertBaseinfoMaintain(SpeBaseinfoMaintain obj) throws Exception {
		if (obj.getBaseId() != null && obj.getBaseId() != "") {
			speBaseinfoMaintainMapper.updateByPrimaryKeySelective(obj);
		} else {
			String id = UUID.randomUUID().toString().replace("-", "");
			obj.setBaseId(id);
			speBaseinfoMaintainMapper.insertSelective(obj);
		}
		return obj;
	}

	@Override
	public SpeBaseinfoMaintain getBaseinfoMaintainById(String id) throws Exception {
		return speBaseinfoMaintainMapper.selectByPrimaryKey(id);
	}
	
}
