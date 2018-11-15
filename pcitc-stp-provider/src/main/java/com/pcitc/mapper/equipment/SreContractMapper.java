package com.pcitc.mapper.equipment;

import com.pcitc.base.stp.equipment.SreContract;
import com.pcitc.base.stp.equipment.SreContractExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SreContractMapper {
    int countByExample(SreContractExample example);

    int deleteByExample(SreContractExample example);

    int deleteByPrimaryKey(String contractId);

    int insert(SreContract record);

    int insertSelective(SreContract record);

    List<SreContract> selectByExample(SreContractExample example);

    SreContract selectByPrimaryKey(String contractId);

    int updateByExampleSelective(@Param("record") SreContract record, @Param("example") SreContractExample example);

    int updateByExample(@Param("record") SreContract record, @Param("example") SreContractExample example);

    int updateByPrimaryKeySelective(SreContract record);

    int updateByPrimaryKey(SreContract record);
}