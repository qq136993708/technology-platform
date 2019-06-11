package com.pcitc.service.equipment;
import java.util.List;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.equipment.SreContract;
import com.pcitc.base.stp.equipment.SreContractExample;
public interface ContractService 
{

	public SreContract selectContract(String id) throws Exception;

	public Integer updateContract(SreContract record)throws Exception;

	public int deleteContract(String id)throws Exception;
	
	public int batchDeleteContract(List<String> list)throws Exception;
	
	public List<SreContract> getContractListByIds(List<String> list)throws Exception;

	public Integer insertContract(SreContract record)throws Exception;

	public List<SreContract> getContractList(SreContractExample example)throws Exception;
	
	public LayuiTableData getContractPage(LayuiTableParam param)throws Exception;
	
	

}
