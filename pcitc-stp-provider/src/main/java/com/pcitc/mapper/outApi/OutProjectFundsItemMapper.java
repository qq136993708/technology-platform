package com.pcitc.mapper.outApi;

import com.pcitc.base.stp.out.OutProjectFundsItem;
import com.pcitc.base.stp.out.OutProjectFundsItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OutProjectFundsItemMapper {
    long countByExample(OutProjectFundsItemExample example);

    int deleteByExample(OutProjectFundsItemExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(OutProjectFundsItem record);

    int insertSelective(OutProjectFundsItem record);

    List<OutProjectFundsItem> selectByExample(OutProjectFundsItemExample example);

    OutProjectFundsItem selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") OutProjectFundsItem record, @Param("example") OutProjectFundsItemExample example);

    int updateByExample(@Param("record") OutProjectFundsItem record, @Param("example") OutProjectFundsItemExample example);

    int updateByPrimaryKeySelective(OutProjectFundsItem record);

    int updateByPrimaryKey(OutProjectFundsItem record);
}