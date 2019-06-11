package com.pcitc.service.equipment;

import java.util.List;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.PageResult;
import com.pcitc.base.stp.equipment.SreAssetAccount;
import com.pcitc.base.stp.equipment.SreAssetAccountExample;

public interface AssetAccountService {
	
	
	public SreAssetAccount selectAssetAccount(String id) throws Exception;

	public Integer updateAssetAccount(SreAssetAccount record)throws Exception;

	public int deleteAssetAccount(String id)throws Exception;
	
	public int batchDeleteAssetAccount(List<String> list)throws Exception;
	
	public List<SreAssetAccount> getAssetAccountListByIds(List<String> list)throws Exception;

	public Integer insertAssetAccount(SreAssetAccount record)throws Exception;

	public List<SreAssetAccount> getAssetAccountList(SreAssetAccountExample example)throws Exception;
	
	public LayuiTableData getAssetAccountPage(LayuiTableParam param)throws Exception;
	
	

}
