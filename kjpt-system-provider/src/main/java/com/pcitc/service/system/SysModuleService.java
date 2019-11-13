package com.pcitc.service.system;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.system.SysModule;

/**
 * @author ms 功能模块管理逻辑层
 */
public interface SysModuleService {

	/**
	 * 条件查询模块列表
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	JSONObject selectSysModuleList(SysModule vo) throws Exception;
	
	/**
	 * 新增或修改模块
	 * @param function
	 * @return
	 * @throws Exception
	 */
	int updateOrInsertSysModule(SysModule function) throws Exception;
	
	/**
	 * 删除模块
	 * @param id
	 * @return
	 * @throws Exception
	 */
	int deleteSysModule(String id) throws Exception;
	
	/**
     * 根据id查询模块
     * @param id
     * @return
     */
    SysModule getSysModuleById(String id) throws Exception;

}
