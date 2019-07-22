package com.pcitc.mapper.out;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pcitc.base.stp.out.OutWaitWork;
import com.pcitc.base.stp.out.OutWaitWorkExample;

public interface OutWaitWorkMapper {
    int countByExample(OutWaitWorkExample example);

    int deleteByExample(OutWaitWorkExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OutWaitWork record);

    int insertSelective(OutWaitWork record);

    List<OutWaitWork> selectByExample(OutWaitWorkExample example);

    OutWaitWork selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OutWaitWork record, @Param("example") OutWaitWorkExample example);

    int updateByExample(@Param("record") OutWaitWork record, @Param("example") OutWaitWorkExample example);

    int updateByPrimaryKeySelective(OutWaitWork record);

    int updateByPrimaryKey(OutWaitWork record);
    
    /**
     * 批量插入待办任务数据
     */
    public Integer insertOutWaitWorkBatch(List<OutWaitWork> workList);
}