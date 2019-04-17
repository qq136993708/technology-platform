package com.pcitc.mapper.equipment;

import java.util.List;
import java.util.Map;

import com.pcitc.base.stp.equipment.SreEquipment;

public interface SreEquipmentMapper {
    int deleteByPrimaryKey(String equipmentId);

    int insert(SreEquipment record);

    int insertSelective(SreEquipment record);

    SreEquipment selectByPrimaryKey(String equipmentId);

    int updateByPrimaryKeySelective(SreEquipment record);

    int updateByPrimaryKey(SreEquipment record);
    
    List getList(Map map);
    int getCount(Map map);
    
    List getEquipmentListByIds(List list);

	List getForApplicationList(Map map);
    
    
    
}