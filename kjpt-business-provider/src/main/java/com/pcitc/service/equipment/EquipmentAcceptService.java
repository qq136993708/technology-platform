package com.pcitc.service.equipment;

import java.util.List;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.PageResult;
import com.pcitc.base.stp.equipment.SreHardwareAccept;
import com.pcitc.base.stp.equipment.SreHardwareAcceptExample;
import com.pcitc.base.stp.equipment.SreSoftwareAccept;
import com.pcitc.base.stp.equipment.SreSoftwareAcceptExample;

public interface EquipmentAcceptService {
	
	
	/**===========================================软件 装备==========================================*/
	
	public SreSoftwareAccept selectSoftwareAccept(String id) throws Exception;

	public Integer updateSoftwareAccept(SreSoftwareAccept record)throws Exception;

	public int deleteSoftwareAccept(String id)throws Exception;

	public Integer insertSoftwareAccept(SreSoftwareAccept record)throws Exception;

	public List<SreSoftwareAccept> getSoftwareAcceptList(SreSoftwareAcceptExample example)throws Exception;
	
	public LayuiTableData getSoftwareAcceptPage(LayuiTableParam param)throws Exception;
	
	public int batchDeleteSoftwareAccept(List<String> list)throws Exception;
	
	
   /**===========================================硬件 装备==========================================*/
	
	public SreHardwareAccept selectHardwareAccept(String id) throws Exception;

	public Integer updateHardwareAccept(SreHardwareAccept record)throws Exception;

	public int deleteHardwareAccept(String id)throws Exception;

	public Integer insertHardwareAccept(SreHardwareAccept record)throws Exception;

	public List<SreHardwareAccept> getHardwareAcceptList(SreHardwareAcceptExample example)throws Exception;
	
	public LayuiTableData getHardwareAcceptPage(LayuiTableParam param)throws Exception;
	
	public int batchDeleteHardwareAccept(List<String> list)throws Exception;
	
	
}
