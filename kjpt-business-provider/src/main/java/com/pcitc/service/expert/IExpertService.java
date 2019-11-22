package com.pcitc.service.expert;

import java.util.List;
import java.util.Map;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.expert.ZjkAchievement;
import com.pcitc.base.expert.ZjkBase;
import com.pcitc.base.expert.ZjkPatent;
import com.pcitc.base.expert.ZjkProject;
import com.pcitc.base.expert.ZjkReward;

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
	     *根据ID逻辑删除专家信息
	*/
	public int deleteLogicZjkBase(String id)throws Exception;
	
	 /**
     *根据ID物理删除专家信息
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
	
	
	/**
	     * 获取专家（分页）
	*/
	public List getZjkBaseList(Map param)throws Exception;

	/**
	     * 获取专家个数
	*/
	public Integer getZjkBaseCount()throws Exception;
	
	
	
	public int insertBatch(List<ZjkBase> list)throws Exception;
	
	
	
	
	/**
     * 根据ID获取专家相关项目信息详情
   */
	public ZjkProject selectZjkProject(String id) throws Exception;
	
	 /**
	     *修改专家相关项目信息
	*/
	public Integer updateZjkProject(ZjkProject record)throws Exception;
	 /**
	     *根据ID删除专家相关项目信息
	*/
	public int deleteZjkProject(String id)throws Exception;
	public int deleteLogicZjkProjectById(String id)throws Exception;
	

	 /**
	     * 增加专家相关项目信息
	 */
	public Integer insertZjkProject(ZjkProject record)throws Exception;
	
	/**
	     * 获取专家相关项目（分页）
	*/
	public LayuiTableData getZjkProjectPage(LayuiTableParam param)throws Exception;
	
	
	
	
	
	
	
	
	
	
	
	/**
     * 根据ID获取专家成果信息详情
   */
	public ZjkAchievement selectZjkAchievement(String id) throws Exception;
	
	 /**
	     *修改专家成果信息
	*/
	public Integer updateZjkAchievement(ZjkAchievement record)throws Exception;
	 /**
	     *根据ID删除专家成果信息
	*/
	public int deleteZjkAchievement(String id)throws Exception;
	public int deleteLogicZjkAchievementById(String id)throws Exception;
	 /**
	     * 增加专家成果信息
	 */
	public Integer insertZjkAchievement(ZjkAchievement record)throws Exception;
	
	/**
	     * 获取专家成果（分页）
	*/
	public LayuiTableData getZjkAchievementPage(LayuiTableParam param)throws Exception;
	
	
	
	
	
	
	
	/**
     * 根据ID获取专家专利信息详情
   */
	public ZjkPatent selectZjkPatent(String id) throws Exception;
	
	 /**
	     *修改专家专利信息
	*/
	public Integer updateZjkPatent(ZjkPatent record)throws Exception;
	 /**
	     *根据ID删除专家专利信息
	*/
	public int deleteZjkPatent(String id)throws Exception;
	
	public int deleteLogicZjkPatentById(String id)throws Exception;
	
	
	

	 /**
	     * 增加专家专利信息
	 */
	public Integer insertZjkPatent(ZjkPatent record)throws Exception;
	
	/**
	     * 获取专家专利（分页）
	*/
	public LayuiTableData getZjkPatentPage(LayuiTableParam param)throws Exception;
	
	
	
	
	
	
	

	/**
     * 根据ID获取专家奖励信息详情
   */
	public ZjkReward selectZjkReward(String id) throws Exception;
	
	 /**
	     *修改专家奖励信息
	*/
	public Integer updateZjkReward(ZjkReward record)throws Exception;
	 /**
	     *根据ID删除专家奖励信息
	*/
	public int deleteZjkReward(String id)throws Exception;
	public int deleteLogicZjkReward(String id)throws Exception;
	

	 /**
	     * 增加专家奖励信息
	 */
	public Integer insertZjkReward(ZjkReward record)throws Exception;
	
	/**
	     * 获取专家奖励（分页）
	*/
	public LayuiTableData getZjkRewardPage(LayuiTableParam param)throws Exception;
	
	
	
	
	
	
	
	
	
	
	
}
