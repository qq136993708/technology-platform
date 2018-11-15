package com.pcitc.mapper.equipment;

import com.pcitc.base.stp.equipment.SreHardwareAccept;
import com.pcitc.base.stp.equipment.SreHardwareAcceptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SreHardwareAcceptMapper {
    int countByExample(SreHardwareAcceptExample example);

    int deleteByExample(SreHardwareAcceptExample example);

    int deleteByPrimaryKey(String hardwareId);

    int insert(SreHardwareAccept record);

    int insertSelective(SreHardwareAccept record);

    List<SreHardwareAccept> selectByExample(SreHardwareAcceptExample example);

    SreHardwareAccept selectByPrimaryKey(String hardwareId);

    int updateByExampleSelective(@Param("record") SreHardwareAccept record, @Param("example") SreHardwareAcceptExample example);

    int updateByExample(@Param("record") SreHardwareAccept record, @Param("example") SreHardwareAcceptExample example);

    int updateByPrimaryKeySelective(SreHardwareAccept record);

    int updateByPrimaryKey(SreHardwareAccept record);
}