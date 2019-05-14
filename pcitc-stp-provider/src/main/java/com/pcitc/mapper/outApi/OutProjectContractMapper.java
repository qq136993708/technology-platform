package com.pcitc.mapper.outApi;

import com.pcitc.base.stp.out.OutProjectContract;
import com.pcitc.base.stp.out.OutProjectContractExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OutProjectContractMapper {
    long countByExample(OutProjectContractExample example);

    int deleteByExample(OutProjectContractExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(OutProjectContract record);

    int insertSelective(OutProjectContract record);

    List<OutProjectContract> selectByExample(OutProjectContractExample example);

    OutProjectContract selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") OutProjectContract record, @Param("example") OutProjectContractExample example);

    int updateByExample(@Param("record") OutProjectContract record, @Param("example") OutProjectContractExample example);

    int updateByPrimaryKeySelective(OutProjectContract record);

    int updateByPrimaryKey(OutProjectContract record);
}