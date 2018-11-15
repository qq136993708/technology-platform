package com.pcitc.mapper.out;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pcitc.base.stp.out.OutAppraisal;
import com.pcitc.base.stp.out.OutAppraisalExample;

public interface OutAppraisalMapper {
    int countByExample(OutAppraisalExample example);

    int deleteByExample(OutAppraisalExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(OutAppraisal record);

    int insertSelective(OutAppraisal record);

    List<OutAppraisal> selectByExample(OutAppraisalExample example);

    OutAppraisal selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") OutAppraisal record, @Param("example") OutAppraisalExample example);

    int updateByExample(@Param("record") OutAppraisal record, @Param("example") OutAppraisalExample example);

    int updateByPrimaryKeySelective(OutAppraisal record);

    int updateByPrimaryKey(OutAppraisal record);
    
    public void insertOutAppraisalBatch(List<OutAppraisal> list);
    
    public int getOutAppraisalCount(String nd);
    
    /**
     * @param nd
     * @return
     * 得到某个年度专利申请/授权数量按专利类型分组
     */
    public List getResultInfo(String nd);
    
    /**
     * @param nd
     * @return
     * 得到某个年度专利申请/授权数量按专利类型分组
     */
    public List getResultInfoByType(String nd);
    
    /**
     * @param nd
     * @return
     * 得到某个年度专利申请/授权数量按专利类型分组
     */
    public List getResultInfoByZy(String nd);
    
    /**
     * @param nd
     * @return
     * 得到某个年度专利申请/授权数量按专利类型分组
     */
    public List getResultInfoBySix(String nd);
    
    /**
     * @param nd
     * @return
     * 得到某个年度专利申请/授权数量按专利类型分组
     */
    public List getResultInfoByEight(String nd);
}