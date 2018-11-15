package com.pcitc.mapper.equipment;

import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.stp.equipment.SreEquipmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SreEquipmentMapper {
    int countByExample(SreEquipmentExample example);

    int deleteByExample(SreEquipmentExample example);

    int deleteByPrimaryKey(String equipmentId);

    int insert(SreEquipment record);

    int insertSelective(SreEquipment record);

    List<SreEquipment> selectByExample(SreEquipmentExample example);

    SreEquipment selectByPrimaryKey(String equipmentId);

    int updateByExampleSelective(@Param("record") SreEquipment record, @Param("example") SreEquipmentExample example);

    int updateByExample(@Param("record") SreEquipment record, @Param("example") SreEquipmentExample example);

    int updateByPrimaryKeySelective(SreEquipment record);

    int updateByPrimaryKey(SreEquipment record);
}