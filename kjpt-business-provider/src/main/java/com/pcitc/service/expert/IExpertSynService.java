package com.pcitc.service.expert;

import java.util.List;
import java.util.Map;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.expert.ZjkBaseSync;
import com.pcitc.base.expert.ZjkBookSync;
import com.pcitc.base.expert.ZjkPatentSync;
import com.pcitc.base.expert.ZjkRewardPunishSync;
import com.pcitc.base.expert.ZjkRewardSync;

public interface IExpertSynService {
	
	
	

	/**
     * 根据ID获奖励详情
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
     * 根据ID获奖励详情
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
	
	
	
	
	
	
	
	
	
	
	/**
     * 根据ID获奖励详情
    */
	public ZjkRewardSync selectZjkRewardSync(String id) throws Exception;
	public Integer updateZjkRewardSync(ZjkRewardSync record)throws Exception;
	public int deleteZjkRewardSync(String id)throws Exception;
	public Integer insertZjkRewardSync(ZjkRewardSync record)throws Exception;
	public LayuiTableData getZjkRewardSyncPage(LayuiTableParam param)throws Exception;
	public List getZjkRewardSyncList(Map map)throws Exception;
	public int deleteAllReward()throws Exception;
	public Integer insertBatchRewardSync(List<ZjkRewardSync> list)throws Exception;
	
	
	
	
	
	
	public ZjkBookSync selectZjkBookSync(String id) throws Exception;
	public Integer updateZjkBookSync(ZjkBookSync record)throws Exception;
	public int deleteZjkBookSync(String id)throws Exception;
	public Integer insertZjkBookSync(ZjkBookSync record)throws Exception;
	public LayuiTableData getZjkBookSyncPage(LayuiTableParam param)throws Exception;
	public List getZjkBookSyncList(Map map)throws Exception;
	public int deleteAllBookSync()throws Exception;
	public Integer insertBatchBookSync(List<ZjkBookSync> list)throws Exception;
	
	
	
	
	public ZjkRewardPunishSync selectZjkRewardPunishSync(String id) throws Exception;
	public Integer updateZjkRewardPunishSync(ZjkRewardPunishSync record)throws Exception;
	public int deleteZjkRewardPunishSync(String id)throws Exception;
	public Integer insertZjkRewardPunishSync(ZjkRewardPunishSync record)throws Exception;
	public LayuiTableData getZjkRewardPunishSyncPage(LayuiTableParam param)throws Exception;
	public List getZjkRewardPunishSyncList(Map map)throws Exception;
	public int deleteAllPunishSync()throws Exception;
	public Integer insertBatchPunishSync(List<ZjkRewardPunishSync> list)throws Exception;
	
	
	
	
	
	
	
	

}
