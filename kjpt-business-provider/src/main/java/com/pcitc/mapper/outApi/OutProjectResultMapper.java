package com.pcitc.mapper.outApi;

import com.pcitc.base.stp.out.OutProjectResult;
import com.pcitc.base.stp.out.OutProjectResultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OutProjectResultMapper {
    long countByExample(OutProjectResultExample example);

    int deleteByExample(OutProjectResultExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(OutProjectResult record);

    int insertSelective(OutProjectResult record);

    List<OutProjectResult> selectByExample(OutProjectResultExample example);

    OutProjectResult selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") OutProjectResult record, @Param("example") OutProjectResultExample example);

    int updateByExample(@Param("record") OutProjectResult record, @Param("example") OutProjectResultExample example);

    int updateByPrimaryKeySelective(OutProjectResult record);

    int updateByPrimaryKey(OutProjectResult record);
}