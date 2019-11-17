package com.pcitc.service.expert;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.expert.ZjkBase;

public interface IExpertService {
	
	
	 /**
                   * 根据ID获取专家信息详情
     */
	public ZjkBase selectZjkBase(String id) throws Exception;
	
	 /**
	     *修改专家信息
	*/
	public Integer updateZjkBase(ZjkBase record)throws Exception;
	 /**
	     *根据ID删除专家信息
	*/
	public int deleteZjkBase(String id)throws Exception;

	 /**
	     * 增加专家信息
	 */
	public Integer insertZjkBase(ZjkBase record)throws Exception;
	
	/**
	     * 获取专家（分页）
	*/
	public LayuiTableData getZjkBasePage(LayuiTableParam param)throws Exception;
	
}
