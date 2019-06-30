package com.pcitc.mapper.equipment;


import java.util.Date;
import java.util.List;
import java.util.Map;

import com.pcitc.base.stp.equipment.SreProjectTask;

public interface SreProjectTaskMapper {
    int deleteByPrimaryKey(String taskId);

    int insert(SreProjectTask record);

    int insertSelective(SreProjectTask record);

    SreProjectTask selectByPrimaryKey(String taskId);

    int updateByPrimaryKeySelective(SreProjectTask record);

    int updateByPrimaryKeyWithBLOBs(SreProjectTask record);

    int updateByPrimaryKey(SreProjectTask record);
    
    
	public List<SreProjectTask> getSreProjectTaskListBytopicId(String topicId);
    
    
    List getList(Map map);
    
    List getListByErpnum(Map map);
    
    int getCount(Map map);

	List<SreProjectTask> getTaskClosureList(Map map);

	int updataTaskClosure(String id, String closure,Date date);

	List<SreProjectTask> getClosedList(Map map);
	
	SreProjectTask selectByTopicKey(String taskId);

	List<SreProjectTask> getSelectDate(Map map);
}