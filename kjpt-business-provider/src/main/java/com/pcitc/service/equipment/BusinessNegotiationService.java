package com.pcitc.service.equipment;

import java.util.List;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.equipment.SreBusinessTalk;
import com.pcitc.base.stp.equipment.SreBusinessTalkExample;

public interface BusinessNegotiationService {
	
	
	public SreBusinessTalk selectBusinessTalk(String id) throws Exception;

	public Integer updateBusinessTalk(SreBusinessTalk record)throws Exception;
	
	public int deleteBusinessTalk(String id)throws Exception;
	
	public int batchDeleteBusinessTalk(List<String> list)throws Exception;
	
	public List<SreBusinessTalk> getBusinessTalkListByIds(List<String> list)throws Exception;

	public Integer insertBusinessTalk(SreBusinessTalk record)throws Exception;

	public List<SreBusinessTalk> getBusinessTalkList(SreBusinessTalkExample example)throws Exception;
	
	public LayuiTableData getBusinessTalkPage(LayuiTableParam param)throws Exception;
	
	

}
