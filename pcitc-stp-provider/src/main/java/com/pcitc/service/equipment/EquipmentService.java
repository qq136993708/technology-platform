package com.pcitc.service.equipment;

import java.util.List;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.stp.equipment.SreEquipmentExample;
import com.pcitc.base.stp.equipment.SreProject;
import com.pcitc.base.stp.equipment.SreProjectExample;
import com.pcitc.base.stp.equipment.SreTechMeeting;
import com.pcitc.base.stp.equipment.SreTechMeetingExample;

public interface EquipmentService {
	
	
	
	/**===========================================装备==========================================*/
	
	public SreEquipment selectEquipment(String id) throws Exception;

	public Integer updateEquipment(SreEquipment record)throws Exception;

	public int deleteEquipment(String id)throws Exception;

	public Integer insertEquipment(SreEquipment record)throws Exception;

	public List<SreEquipment> getEquipmentList(SreEquipmentExample example)throws Exception;
	
	public LayuiTableData getEquipmentPage(LayuiTableParam param)throws Exception;
	
	public int batchDeleteEquipment(List<String> list)throws Exception;
	
	public List<SreEquipment> getEquipmentListByIds(List<String> list)throws Exception;
	
	
	
	/**===========================================项目==========================================*/
	
	
	public SreProject selectProjectBasic(String id) throws Exception;

	public Integer updateProjectBasic(SreProject record)throws Exception;

	public int deleteProjectBasic(String id)throws Exception;

	public Integer insertProjectBasic(SreProject record)throws Exception;

	public List<SreProject> getProjectBasicList(SreProjectExample example)throws Exception;
	
	public int batchDeleteProjectBasic(List<String> list)throws Exception;
	
	
	
	
	
	public LayuiTableData getProjectBasicPage(LayuiTableParam param)throws Exception;
	
	
   /**===========================================技术交流==========================================*/
	
	public SreTechMeeting selectMeeting(String id) throws Exception;

	public Integer updateMeeting(SreTechMeeting record)throws Exception;

	public int deleteMeeting(String id)throws Exception;

	public Integer insertMeeting(SreTechMeeting record)throws Exception;

	public List<SreTechMeeting> getMeetingList(SreTechMeetingExample example)throws Exception;
	
	
	public int batchDeleteMeeting(List<String> list)throws Exception;
	
	public List<SreTechMeeting> getMeetingListByIds(List<String> list)throws Exception;
	
	
	public LayuiTableData getMeetingPage(LayuiTableParam param)throws Exception;

}
