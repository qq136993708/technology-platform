package com.pcitc.service.system;

import java.util.List;

import com.pcitc.base.system.SysCollect;

/**
 * @author zhf
 * 2018-10-11
 * 菜单收藏
 */
public interface SysCollectService {

	/**
	 * @param sysCollect
	 * @return
	 * 插入收藏，判断是否已经插入，已存在更新日期
	 */
	public int insertSysCollect(SysCollect sysCollect);
	
	public List<SysCollect> getSysCollectByCond(String functionId, String userId);
	
	public int updateSysCollect(SysCollect sysCollect);
	
	public List<SysCollect> getSysCollectByUser(String userId);
	
}
