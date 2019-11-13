package com.pcitc.mapper.outApi;

import com.pcitc.base.stp.out.OutProjectFunds;
import com.pcitc.base.stp.out.OutProjectFundsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OutProjectFundsMapper {
    long countByExample(OutProjectFundsExample example);

    int deleteByExample(OutProjectFundsExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(OutProjectFunds record);

    int insertSelective(OutProjectFunds record);

    List<OutProjectFunds> selectByExample(OutProjectFundsExample example);

    OutProjectFunds selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") OutProjectFunds record, @Param("example") OutProjectFundsExample example);

    int updateByExample(@Param("record") OutProjectFunds record, @Param("example") OutProjectFundsExample example);

    int updateByPrimaryKeySelective(OutProjectFunds record);

    int updateByPrimaryKey(OutProjectFunds record);
}