package com.pcitc.mapper.out;

import com.pcitc.base.stp.out.OutProjectPaymentplan;
import com.pcitc.base.stp.out.OutProjectPaymentplanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OutProjectPaymentplanMapper {
    long countByExample(OutProjectPaymentplanExample example);

    int deleteByExample(OutProjectPaymentplanExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(OutProjectPaymentplan record);

    int insertSelective(OutProjectPaymentplan record);

    List<OutProjectPaymentplan> selectByExample(OutProjectPaymentplanExample example);

    OutProjectPaymentplan selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") OutProjectPaymentplan record, @Param("example") OutProjectPaymentplanExample example);

    int updateByExample(@Param("record") OutProjectPaymentplan record, @Param("example") OutProjectPaymentplanExample example);

    int updateByPrimaryKeySelective(OutProjectPaymentplan record);

    int updateByPrimaryKey(OutProjectPaymentplan record);
}