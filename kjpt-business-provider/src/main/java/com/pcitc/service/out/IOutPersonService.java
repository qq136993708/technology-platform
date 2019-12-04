package com.pcitc.service.out;

import java.util.List;
import java.util.Map;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.out.OutPerson;

public interface IOutPersonService {

	
	

	
	
	
	/**
	     * 根据ID获取人事系统人员信息详情
	*/
	public OutPerson selectOutPerson(String id) throws Exception;
	
	/**
	 *修改人事系统人员信息
	*/
	public Integer updateOutPerson(OutPerson record)throws Exception;
	/**
	 *根据ID删除人事系统人员信息
	*/
	public int deleteOutPerson(String id)throws Exception;
	
	/**
	 * 增加人事系统人员信息
	*/
	public Integer insertOutPerson(OutPerson record)throws Exception;
	
	/**
	 * 获取人事系统人员（分页）
	*/
	public LayuiTableData getOutPersonPage(LayuiTableParam param)throws Exception;
	
	
	public List getOutPersonList(Map map)throws Exception;
	
    
	
	
}
