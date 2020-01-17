package com.pcitc.service.project;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.out.OutProject;

public interface IOutProjectService {
	
	
	

	/**
             * 根据ID获取项目信息详情
   */
	public OutProject selectOutProject(String id) throws Exception;
	
	 /**
	     *修改项目信息
	*/
	public Integer updateOutProject(OutProject record)throws Exception;
	 /**
	     *根据ID删除项目信息
	*/
	public int deleteOutProject(String id)throws Exception;

	 /**
	     * 增加项目信息
	 */
	public Integer insertOutProject(OutProject record)throws Exception;
	
	/**
	     * 获取项目（分页）
	*/
	public LayuiTableData getOutProjectPage(LayuiTableParam param)throws Exception;
	
	public List getOutProjectList(Map map)throws Exception;
	
	public JSONObject getHotByTypeIndex(JSONObject obj)throws Exception;
	
	public List fetch(Map map)throws Exception;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
