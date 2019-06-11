package com.pcitc.service.system.impl;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.system.SysFunctionProperty;
import com.pcitc.base.system.SysFunctionPropertyExample;
import com.pcitc.base.system.SysFunctionPropertyExample.Criteria;
import com.pcitc.mapper.system.SysFunctionPropertyMapper;
import com.pcitc.service.system.SysFunctionPropertyService;

@Service("sysFunctionPropertyService")
//@CacheConfig(cacheNames = "functionPropertyCache")
public class SysFunctionPropertyServiceImpl implements SysFunctionPropertyService {
	@Autowired
	private SysFunctionPropertyMapper sysFunctionPropertyMapper;

	@Override
	public JSONObject selectSysFunctionPropertyList(SysFunctionProperty obj) throws Exception {
		// 每页显示条数
		int pageSize = Integer.parseInt(obj.getLimit());
		// 当前是第几页
		int pageNum = Integer.parseInt(obj.getPage());
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		// 2、执行查询
		SysFunctionPropertyExample ex = new SysFunctionPropertyExample();
		Criteria or = ex.createCriteria();
		if (StringUtils.isNotEmpty(obj.getiSortCol())) {
			if (StringUtils.isNotEmpty(obj.getsSortDir_0())) {
				ex.setOrderByClause(obj.getiSortCol() + " " + obj.getsSortDir_0());
			} else {
				ex.setOrderByClause(obj.getiSortCol());
			}
		}
		//拼接查询条件
		if (StringUtils.isNotEmpty(obj.getFunctionId())) {
			//or.andNoticeTitleLike("%"+obj.getNoticeTitle()+"%");
			or.andFunctionIdEqualTo(obj.getFunctionId());
		}
		or.andPostIdIsNull();
		List<SysFunctionProperty> list = sysFunctionPropertyMapper.selectByExample(ex);
		// 3、获取分页查询后的数据
		PageInfo<SysFunctionProperty> pageInfo = new PageInfo<SysFunctionProperty>(list);
		// 4、封装需要返回的分页实体
		JSONObject result = new JSONObject();
		result.put("totalCount", pageInfo.getTotal());
		result.put("list", list);
		return result;
	}

	//@CacheEvict(value="functionPropertyCache", allEntries=true, beforeInvocation=true)
	@Override
	public int updateOrInsertSysFunctionProperty(SysFunctionProperty obj) throws Exception {
		int result = 500;
		if(obj.getId()!=null && obj.getId()!=""){
			sysFunctionPropertyMapper.updateByPrimaryKeySelective(obj);
		}else{
			String id = UUID.randomUUID().toString().replace("-", "");
			obj.setId(id);
			sysFunctionPropertyMapper.insertSelective(obj);
		}
		result = 200;
		return result;
	}

	//@CacheEvict(value="functionPropertyCache", allEntries=true, beforeInvocation=true)
	@Override
	public int deleteSysFunctionProperty(String id) throws Exception {
		int result = 500;
		if(id!=null && id!=""){
			sysFunctionPropertyMapper.deleteByPrimaryKey(id);
		}
		result = 200;
		return result;
	}

	@Override
	public SysFunctionProperty getSysFunctionPropertyById(String id) throws Exception {
		return sysFunctionPropertyMapper.selectByPrimaryKey(id);
	}

	@Override
	public SysFunctionProperty getSysFunctionProperty(SysFunctionProperty obj) throws Exception {
		SysFunctionPropertyExample ex = new SysFunctionPropertyExample();
		Criteria or = ex.or();
		if (StringUtils.isNotEmpty(obj.getFunctionId())) {
			or.andFunctionIdEqualTo(obj.getFunctionId());
		}
		if (StringUtils.isNotEmpty(obj.getProName())) {
			or.andProNameEqualTo(obj.getProName());
		}
		if (StringUtils.isNotEmpty(obj.getProCode())) {
			or.andProCodeEqualTo(obj.getProCode());
		}
		List<SysFunctionProperty> list = sysFunctionPropertyMapper.selectByExample(ex);
		obj = new SysFunctionProperty();
		if(list.size() > 0) {
			obj = list.get(0);
		}
		return obj;
	}
	
	/**
     * 查询已经某个菜单、某个配置项、某个岗位已经配置的研究院
     * @return
     */
    public List selectInstituteData(HashMap<String, Object> hashmap) {
    	return sysFunctionPropertyMapper.selectInstituteData(hashmap);
    }

}
