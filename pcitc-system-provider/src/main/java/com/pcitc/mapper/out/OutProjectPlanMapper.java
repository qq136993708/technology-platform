package com.pcitc.mapper.out;

import com.pcitc.base.stp.out.OutProjectPlan;
import com.pcitc.base.stp.out.OutProjectPlanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OutProjectPlanMapper {
    int countByExample(OutProjectPlanExample example);

    int deleteByExample(OutProjectPlanExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(OutProjectPlan record);

    int insertSelective(OutProjectPlan record);

    List<OutProjectPlan> selectByExample(OutProjectPlanExample example);

    OutProjectPlan selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") OutProjectPlan record, @Param("example") OutProjectPlanExample example);

    int updateByExample(@Param("record") OutProjectPlan record, @Param("example") OutProjectPlanExample example);

    int updateByPrimaryKeySelective(OutProjectPlan record);

    int updateByPrimaryKey(OutProjectPlan record);
    
    /**
     * 批量插入项目计划数据
     */
    public void insertOutProjectPlanBatch(List<OutProjectPlan> list);
}