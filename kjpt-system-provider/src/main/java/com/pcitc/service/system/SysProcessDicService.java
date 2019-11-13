package com.pcitc.service.system;

import java.util.List;
import java.util.Map;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.system.SysProcessDic;
public interface SysProcessDicService {
	
	
	
	
	
	
	
	public SysProcessDic selectSysProcessDic(String id) throws Exception;

	public Integer updateSysProcessDic(SysProcessDic record)throws Exception;

	public int deleteSysProcessDic(String id)throws Exception;

	public Integer insertSysProcessDic(SysProcessDic record)throws Exception;
	
	public LayuiTableData getSysProcessDicPage(LayuiTableParam param)throws Exception;
	
	
	public List<SysProcessDic> getSysProcessDicListByMap(Map map)throws Exception;
	
	
	

}
