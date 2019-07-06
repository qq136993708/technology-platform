package com.pcitc.service.equipment;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.equipment.SreDetail;
import com.pcitc.base.stp.equipment.SreForApplication;

public interface DetailService {
	
	
	
	/**===========================================装备台账=========================================*/

	//装备台账分页方法
	public LayuiTableData getDetailPage(LayuiTableParam param)throws Exception;
	
	
	//添加转资申请
	public Integer insertForApplication(SreDetail sreDetail);


	public Integer insertDetail(SreDetail sreDetail);

	//详情
	public LayuiTableData getForApplicationView(LayuiTableParam param);


	public Integer deleteDetail(String id);
	
	
	public int updateByid(String id)throws Exception;


	public SreDetail selectSreDetailId(String id);


	LayuiTableData getLedgerPage(LayuiTableParam param);
}
