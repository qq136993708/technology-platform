package com.pcitc.mapper.outApi;

import com.pcitc.base.stp.out.OutProjectRequire;
import com.pcitc.base.stp.out.OutProjectRequireExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OutProjectRequireMapper {
    int countByExample(OutProjectRequireExample example);

    int deleteByExample(OutProjectRequireExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(OutProjectRequire record);

    int insertSelective(OutProjectRequire record);

    List<OutProjectRequire> selectByExample(OutProjectRequireExample example);

    OutProjectRequire selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") OutProjectRequire record, @Param("example") OutProjectRequireExample example);

    int updateByExample(@Param("record") OutProjectRequire record, @Param("example") OutProjectRequireExample example);

    int updateByPrimaryKeySelective(OutProjectRequire record);

    int updateByPrimaryKey(OutProjectRequire record);
}