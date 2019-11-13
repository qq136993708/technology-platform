package com.pcitc.mapper.outApi;

import com.pcitc.base.stp.out.OutProjectContractItem;
import com.pcitc.base.stp.out.OutProjectContractItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OutProjectContractItemMapper {
    long countByExample(OutProjectContractItemExample example);

    int deleteByExample(OutProjectContractItemExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(OutProjectContractItem record);

    int insertSelective(OutProjectContractItem record);

    List<OutProjectContractItem> selectByExample(OutProjectContractItemExample example);

    OutProjectContractItem selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") OutProjectContractItem record, @Param("example") OutProjectContractItemExample example);

    int updateByExample(@Param("record") OutProjectContractItem record, @Param("example") OutProjectContractItemExample example);

    int updateByPrimaryKeySelective(OutProjectContractItem record);

    int updateByPrimaryKey(OutProjectContractItem record);
}