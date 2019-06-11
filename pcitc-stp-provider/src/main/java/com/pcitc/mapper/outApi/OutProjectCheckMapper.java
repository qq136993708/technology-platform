package com.pcitc.mapper.outApi;

import com.pcitc.base.stp.out.OutProjectCheck;
import com.pcitc.base.stp.out.OutProjectCheckExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OutProjectCheckMapper {
    long countByExample(OutProjectCheckExample example);

    int deleteByExample(OutProjectCheckExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(OutProjectCheck record);

    int insertSelective(OutProjectCheck record);

    List<OutProjectCheck> selectByExample(OutProjectCheckExample example);

    OutProjectCheck selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") OutProjectCheck record, @Param("example") OutProjectCheckExample example);

    int updateByExample(@Param("record") OutProjectCheck record, @Param("example") OutProjectCheckExample example);

    int updateByPrimaryKeySelective(OutProjectCheck record);

    int updateByPrimaryKey(OutProjectCheck record);
}