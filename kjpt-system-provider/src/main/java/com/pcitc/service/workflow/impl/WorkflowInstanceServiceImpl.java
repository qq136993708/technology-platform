package com.pcitc.service.workflow.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.util.JsonUtil;
import com.pcitc.base.workflow.SysFunctionProdef;
import com.pcitc.base.workflow.SysFunctionProdefExample;
import com.pcitc.base.workflow.SysFunctionProdefExample.Criteria;
import com.pcitc.base.workflow.WorkflowVo;
import com.pcitc.mapper.system.SysFunctionProdefMapper;
import com.pcitc.service.workflow.WorkflowInstanceService;

@Service("workflowInstanceService")
@CacheConfig(cacheNames = "workflowCache")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class WorkflowInstanceServiceImpl implements WorkflowInstanceService {

	@Autowired
	private SysFunctionProdefMapper sysFunctionProdefMapper;
	
	/**
     * 获取菜单的已经配置的工作流定义、项目、部门等信息
     * @param functionId
     * @return
     */
    public JSONObject selectFunctionProcessDefineList(String jsonStr) {
    	int pageLength = 10;
		int startPage = 0;
		System.out.println("========"+jsonStr);
		Map<String,Object> paramMap = JsonUtil.parseJsonToMap(jsonStr);
		if (paramMap.get("iDisplayLength") != null) {
			pageLength = Integer.parseInt(paramMap.get("iDisplayLength").toString());
		}
		if (paramMap.get("iDisplayStart") != null) {
			startPage = Integer.parseInt(paramMap.get("iDisplayStart").toString());
		}
		startPage = startPage/pageLength+1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(startPage, pageLength);
		
		// 2、执行查询
		SysFunctionProdefExample example = new SysFunctionProdefExample();
		Criteria cri = example.createCriteria();
		cri.andStatusEqualTo("1");
		if (paramMap.get("functionId") != null && !paramMap.get("functionId").equals("")) {
			cri.andFunctionIdEqualTo(paramMap.get("functionId").toString());
			System.out.println("========"+paramMap.get("functionId").toString());
		}
		if (paramMap.get("functionName") != null && !paramMap.get("functionName").equals("")) {
			cri.andFunctionNameLike("%"+paramMap.get("functionName").toString()+"%");
			System.out.println("========"+paramMap.get("functionName"));
		}
		
		List<SysFunctionProdef> list = sysFunctionProdefMapper.selectByExample(example);
		
		// 3、获取分页查询后的数据
		PageInfo<SysFunctionProdef> pageInfo = new PageInfo<SysFunctionProdef>(list);
		
		// 4、封装需要返回的分页实体
		JSONObject retJson = new JSONObject();
		retJson.put("totalCount", pageInfo.getTotal());
		retJson.put("list", list);
		return retJson;
    }
    
    /**
     * 保存菜单配置的项目、部门
     * @param prodef
     * @return
     */
    public Integer insertFunctionProdef(SysFunctionProdef prodef) {
    	int returnInt = sysFunctionProdefMapper.insert(prodef);
    	return returnInt;
    }
    
    /**
     * @param prodef
     * @return
     * 查询已有的工作流定义，通过functionid、projectId、orgId
     */
    public SysFunctionProdef queryFunctionProdef(WorkflowVo workflowVo) {
    	SysFunctionProdefExample example = new SysFunctionProdefExample();
		
		Criteria cri = example.createCriteria();
		cri.andStatusEqualTo("1");
		if (workflowVo.getFunctionId() != null && !workflowVo.getFunctionId().equals("")) {
			cri.andFunctionIdEqualTo(workflowVo.getFunctionId());
		}
		if (workflowVo.getProjectId() != null && !workflowVo.getProjectId().equals("")) {
			cri.andProjectIdEqualTo(workflowVo.getProjectId());
		} else {
			cri.andProjectIdIsNull();
		}
		if (workflowVo.getUnitId() != null && !workflowVo.getUnitId().equals("")) {
			cri.andUnitIdEqualTo(workflowVo.getUnitId());
		} else {
			cri.andUnitIdIsNull();
		}
		
		List<SysFunctionProdef> list = sysFunctionProdefMapper.selectByExample(example);
		
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
		
    }
    
    
    /**
     * 删除菜单的工作流配置
     * @param prodef
     * @return
     */
    public Integer deleteFunctionProdef(String funProIds) {
    	String[] fids = funProIds.split(",");
    	int retInt = 0;
    	for (int i = 0; i < fids.length; i++) {
    		int del = sysFunctionProdefMapper.deleteByPrimaryKey(fids[i]);
    		retInt = retInt + del;
    	}
    	return retInt;
    }
    
}
