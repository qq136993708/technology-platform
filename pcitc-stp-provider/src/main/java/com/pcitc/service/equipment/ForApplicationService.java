package com.pcitc.service.equipment;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.equipment.SreForApplication;

public interface ForApplicationService {
	
	
	
	/**===========================================转资申请==========================================*/

	//转资申请分页方法
	public LayuiTableData getForApplicationPage(LayuiTableParam param)throws Exception;
	
	//删除转资申请
	public int deleteForapplication(String id)throws Exception;

	//添加转资申请
	public Integer insertForApplication(SreForApplication sreForApplication);
	
	
	
	
	
	

}
