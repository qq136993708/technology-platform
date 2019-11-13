package com.pcitc.mapper.equipment;

import java.util.List;
import java.util.Map;

import com.pcitc.base.stp.equipment.UnitField;

public interface UnitFieldMapper {
    int deleteByPrimaryKey(String dataId);

    int insert(UnitField record);

    int insertSelective(UnitField record);

    UnitField selectByPrimaryKey(String dataId);

    int updateByPrimaryKeySelective(UnitField record);

    int updateByPrimaryKey(UnitField record);
    List<UnitField> getList(Map map);
    int getCount(Map map);
    
    
    List<UnitField> getUnitNameList();
    List<UnitField> getDepartmentNameListByUnitName(Map map);
    List<UnitField> getProfessionalNameListByUnitNameAndDept(Map map);
    
    
}