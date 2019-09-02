package com.pcitc.mapper.out;

import com.pcitc.base.stp.out.OutProjectInfoPaymentplan;
import com.pcitc.base.stp.out.OutProjectInfoPaymentplanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OutProjectInfoPaymentplanMapper {
    long countByExample(OutProjectInfoPaymentplanExample example);

    int deleteByExample(OutProjectInfoPaymentplanExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(OutProjectInfoPaymentplan record);

    int insertSelective(OutProjectInfoPaymentplan record);

    List<OutProjectInfoPaymentplan> selectByExample(OutProjectInfoPaymentplanExample example);

    OutProjectInfoPaymentplan selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") OutProjectInfoPaymentplan record, @Param("example") OutProjectInfoPaymentplanExample example);

    int updateByExample(@Param("record") OutProjectInfoPaymentplan record, @Param("example") OutProjectInfoPaymentplanExample example);

    int updateByPrimaryKeySelective(OutProjectInfoPaymentplan record);

    int updateByPrimaryKey(OutProjectInfoPaymentplan record);
}