package com.pcitc.service.system.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.system.SysRestfulapi;
import com.pcitc.base.system.SysRestfulapiExample;
import com.pcitc.base.system.SysRestfulapiExample.Criteria;
import com.pcitc.base.util.JsonUtil;
import com.pcitc.mapper.system.SysRestfulapiMapper;
import com.pcitc.service.system.SysRestfulapiService;

@Service("sysRestfulapiService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class SysRestfulapiServiceImpl implements SysRestfulapiService {

	@Autowired
	private SysRestfulapiMapper sysRestfulapiMapper;
	
	@Override
	public JSONObject findWarehousing(String jsonStr) {
		int pageLength = 10;
		int startPage = 0;
		String modelName = null;
		Map<String,Object> paramMap = JsonUtil.parseJsonToMap(jsonStr);
		if (paramMap.get("iDisplayLength") != null) {
			pageLength = Integer.parseInt(paramMap.get("iDisplayLength").toString());
		}
		if (paramMap.get("iDisplayStart") != null) {
			startPage = Integer.parseInt(paramMap.get("iDisplayStart").toString());
		}
		if (paramMap.get("modelName") != null && !paramMap.get("modelName").equals("")) {
			modelName = paramMap.get("modelName").toString();
		}
		SysRestfulapiExample example = new SysRestfulapiExample();
		
		startPage = (startPage-1)*pageLength-1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(startPage, pageLength);
		
		// 2、执行查询
		Criteria cri = example.createCriteria();
		if (modelName != null) {
			cri.andRestfulapiUserLike("%" + modelName.toString()  + "%");
		}
		List<SysRestfulapi> list = sysRestfulapiMapper.selectByExample(example);
		
		// 3、获取分页查询后的数据
		PageInfo<SysRestfulapi> pageInfo = new PageInfo<SysRestfulapi>(list);
		
		// 4、封装需要返回的分页实体
		JSONObject retJson = new JSONObject();
		retJson.put("totalCount", pageInfo.getTotal());
		retJson.put("list", list);
		return retJson;
	}

	@Override
	public Integer insertSysRestfulapi(SysRestfulapi srf) {
		return sysRestfulapiMapper.insert(srf);
	}

	@Override
	public Integer updateSysRestfulapi(SysRestfulapi srf) {
		return sysRestfulapiMapper.updateByPrimaryKey(srf);
	}

	@Override
	public SysRestfulapi getSysRestfulapiById(String restfulapiId) {
		return sysRestfulapiMapper.selectByPrimaryKey(restfulapiId);
	}

	@Override
	public Integer deleteRestfulapiById(String restfulapiId) {
		return sysRestfulapiMapper.deleteByPrimaryKey(restfulapiId);
	}

}
