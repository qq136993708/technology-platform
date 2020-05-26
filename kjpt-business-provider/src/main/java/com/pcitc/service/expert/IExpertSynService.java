package com.pcitc.service.expert;

import java.util.List;
import java.util.Map;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.expert.ZjkBaseSync;
import com.pcitc.base.expert.ZjkPatentSync;

public interface IExpertSynService {
	
	
	

	/**
     * 根据ID获专利详情
    */
	public ZjkBaseSync selectZjkBaseSync(String id) throws Exception;
	
	 /**
	  *修改外系统专家信息
	*/
	public Integer updateZjkBaseSync(ZjkBaseSync record)throws Exception;
	 /**
	  *根据ID删除外系统专家信息
	 */
	public int deleteZjkBaseSync(String id)throws Exception;
	

	 /**
	     * 增加外系统专家信息
	 */
	public Integer insertZjkBaseSync(ZjkBaseSync record)throws Exception;
	
	/**
	     * 获取外系统专家（分页）
	*/
	public LayuiTableData getZjkBaseSyncPage(LayuiTableParam param)throws Exception;
	
	
	public List getZjkBaseSyncList(Map map)throws Exception;
	
	
	
	
	
	
	
	
	
	
	
	
	/**
     * 根据ID获专利详情
    */
	public ZjkPatentSync selectZjkPatentSync(String id) throws Exception;
	
	 /**
	  *修改外系统专家信息
	*/
	public Integer updateZjkPatentSync(ZjkPatentSync record)throws Exception;
	 /**
	  *根据ID删除外系统专家信息
	 */
	public int deleteZjkPatentSync(String id)throws Exception;
	

	 /**
	     * 增加外系统专家信息
	 */
	public Integer insertZjkPatentSync(ZjkPatentSync record)throws Exception;
	
	/**
	     * 获取外系统专家（分页）
	*/
	public LayuiTableData getZjkPatentSyncPage(LayuiTableParam param)throws Exception;
	
	
	public List getZjkPatentSyncList(Map map)throws Exception;
	
	
	public int deleteAllPatentSync()throws Exception;
	public int deleteAllZjkSync()throws Exception;
	
	
	
	public Integer insertBatchPatent(List<ZjkPatentSync> list)throws Exception;
	
	
	public Integer insertBatchZjkBaseSync(List<ZjkBaseSync> list)throws Exception;
	
	
	

}
