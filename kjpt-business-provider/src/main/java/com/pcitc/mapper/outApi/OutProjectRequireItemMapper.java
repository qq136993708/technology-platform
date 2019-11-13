package com.pcitc.mapper.outApi;

import com.pcitc.base.stp.out.OutProjectRequireItem;
import com.pcitc.base.stp.out.OutProjectRequireItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OutProjectRequireItemMapper {
    int countByExample(OutProjectRequireItemExample example);

    int deleteByExample(OutProjectRequireItemExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(OutProjectRequireItem record);

    int insertSelective(OutProjectRequireItem record);

    List<OutProjectRequireItem> selectByExample(OutProjectRequireItemExample example);

    OutProjectRequireItem selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") OutProjectRequireItem record, @Param("example") OutProjectRequireItemExample example);

    int updateByExample(@Param("record") OutProjectRequireItem record, @Param("example") OutProjectRequireItemExample example);

    int updateByPrimaryKeySelective(OutProjectRequireItem record);

    int updateByPrimaryKey(OutProjectRequireItem record);
}