package com.pcitc.mapper.outApi;

import com.pcitc.base.stp.out.OutProjectCheckItem;
import com.pcitc.base.stp.out.OutProjectCheckItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OutProjectCheckItemMapper {
    long countByExample(OutProjectCheckItemExample example);

    int deleteByExample(OutProjectCheckItemExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(OutProjectCheckItem record);

    int insertSelective(OutProjectCheckItem record);

    List<OutProjectCheckItem> selectByExample(OutProjectCheckItemExample example);

    OutProjectCheckItem selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") OutProjectCheckItem record, @Param("example") OutProjectCheckItemExample example);

    int updateByExample(@Param("record") OutProjectCheckItem record, @Param("example") OutProjectCheckItemExample example);

    int updateByPrimaryKeySelective(OutProjectCheckItem record);

    int updateByPrimaryKey(OutProjectCheckItem record);
}