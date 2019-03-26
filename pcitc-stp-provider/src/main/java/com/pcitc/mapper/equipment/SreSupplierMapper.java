package com.pcitc.mapper.equipment;

import java.util.List;
import java.util.Map;

import com.pcitc.base.stp.equipment.SreSupplier;

public interface SreSupplierMapper {
    int deleteByPrimaryKey(String id);

    int insert(SreSupplier record);

    int insertSelective(SreSupplier record);

    SreSupplier selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SreSupplier record);

    int updateByPrimaryKey(SreSupplier record);
    
    
    
    List getList(Map map);
    int getCount(Map map);
    
    List getListByIds(List list);
}