package com.pcitc.service.system;

import java.util.List;
import java.util.Map;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.system.SysMeeting;

public interface SysMeetingService {
	public SysMeeting selectSysMeeting(String id) throws Exception;

	public Integer updateSysMeeting(SysMeeting record)throws Exception;

	public int deleteSysMeeting(String id)throws Exception;

	public Integer insertSysMeeting(SysMeeting record)throws Exception;
	
	public LayuiTableData getSysMeetingPage(LayuiTableParam param)throws Exception;
	
	
	public List<SysMeeting> getSysMeetingListByMap(Map map)throws Exception;
}
