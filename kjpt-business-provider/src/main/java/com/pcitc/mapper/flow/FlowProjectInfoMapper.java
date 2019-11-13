package com.pcitc.mapper.flow;

import com.pcitc.base.stp.flow.FlowProjectInfo;
import com.pcitc.base.stp.flow.FlowProjectInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FlowProjectInfoMapper {
    int countByExample(FlowProjectInfoExample example);

    int deleteByExample(FlowProjectInfoExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(FlowProjectInfo record);

    int insertSelective(FlowProjectInfo record);

    List<FlowProjectInfo> selectByExample(FlowProjectInfoExample example);

    FlowProjectInfo selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") FlowProjectInfo record, @Param("example") FlowProjectInfoExample example);

    int updateByExample(@Param("record") FlowProjectInfo record, @Param("example") FlowProjectInfoExample example);

    int updateByPrimaryKeySelective(FlowProjectInfo record);

    int updateByPrimaryKey(FlowProjectInfo record);
}