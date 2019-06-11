package com.pcitc.mapper.out;

import java.util.HashMap;
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
    
    public int getOutAppraisalCount(HashMap<String, String> map);
    
    /**
	 * 分页显示项目的科研成果信息,统计的第三级展示
	 */
	public List<OutAppraisal> getAppraisalInfoByCond(HashMap<String, Object> map);
    
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
     * 领导二级页面，各个研究院的成果情况, 每一行是一个院
     */
	public List getAppraisalInfoByInstitute(HashMap<String, String> map);
	
	/**
     * 领导二级页面，各种类型的成果情况
     */
	public List getAppraisalInfoByCglx(HashMap<String, String> map);
	
	/**
     * 领导二级页面，各种专业的成果情况
     */
	public List getAppraisalInfoByZy(HashMap<String, String> map);
	
	/**
     * 领导首页-科研成果，直属院、分子公司等9个的成果情况
     */
	public List getAppraisalInfoByCompanyType(HashMap<String, String> map);
	
	/**
	 * 获取成果详细的查询条件
	 */
	public List getAppraisalInfoSelectCondition(HashMap<String, String> map);
	
	/**
	 * 辅助决策分析，成果鉴定年度分析，近三年成果各专业分布
	 */
	public List getAppraisalInfoByZyForThreeYear(HashMap<String, String> map);
    
    
}