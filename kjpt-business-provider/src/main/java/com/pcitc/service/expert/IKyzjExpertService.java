package com.pcitc.service.expert;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.expert.KyzjExpert;

import java.util.List;
import java.util.Map;

public interface IKyzjExpertService {
	

	 /**
       * 根据ID获取专家信息详情
     */
	public KyzjExpert selectZjkBase(String id) throws Exception;
	
	 /**
	     *修改专家信息
	*/
	public Integer updateKyzjExpert(KyzjExpert record)throws Exception;
	 /**
	     *根据ID逻辑删除专家信息
	*/
	public int deleteLogicKyzjExpert(String id)throws Exception;
	
	 /**
     *根据ID物理删除专家信息
     */
	public int deleteKyzjExpert(String id)throws Exception;

	 /**
	     * 增加专家信息
	 */
	public Integer insertKyzjExpert(KyzjExpert record)throws Exception;
	
	/**
	     * 获取专家（分页）
	*/
	public LayuiTableData getKyzjExpertPage(LayuiTableParam param)throws Exception;
	
	
	/**
	     * 获取专家（分页）
	*/
	public List getKyzjExpertList(Map param)throws Exception;

	/**
	     * 获取专家个数
	*/
	public Integer getKyzjExpertCount()throws Exception;
	
	
	
	public int insertBatch(List<KyzjExpert> list)throws Exception;

	
}
