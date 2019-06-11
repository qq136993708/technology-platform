package com.pcitc.service.system;

import java.util.List;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysConfig;

public interface SysConfigService {

	/** 
	 * @author Nishikino
	 * 查询配置列表
	 */
	public LayuiTableData selectConfigByPage(LayuiTableParam param);
	
	/** 
	 * @author Nishikino
	 * 新增配置
	 */
	Integer insertSysConfig(SysConfig sysconfig);
	
	/**
	 * @author Nishikino
     * 根据id查询配置
     */
    SysConfig getSysConfigById(String configId) throws Exception;
    
    /**
     * @author Nishikino
     * 根据id查询配置
     */
    Integer updateSysConfig(SysConfig sysconfig);
    
    /**
     * @author Nishikino
     * 删除配置
     */
    public Integer deleteSysConfig(SysConfig sysconfig);
    
    /** 
	 * @author zhf
	 * 领导的显示配置功能
	 */
	public List selectUserShowConfigList(String userId);
}
