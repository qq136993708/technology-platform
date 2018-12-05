package com.pcitc.mapper.out;

import com.pcitc.base.stp.out.OutProjectPlan;
import com.pcitc.base.stp.out.OutProjectPlanExample;

import java.util.HashMap;
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
    
    /**
     * 直属研究院二级页面（领导），项目计划完成的比率，按照新开续建、资本性费用性来分组
     */
	public List getPlanCompleteRateByOldNew(HashMap<String, String> map);
	
	/**
     * 直属研究院二级页面（领导），总的签订率
     */
	public List getPlanTotalCompleteRate(HashMap<String, String> map);
	
	/**
     * 直属研究院二级页面（领导），各个院的合同签订率
     */
	public List getPlanCompleteRateByInstitute(HashMap<String, String> map);
	
	
}