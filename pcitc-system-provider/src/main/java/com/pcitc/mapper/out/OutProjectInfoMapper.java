package com.pcitc.mapper.out;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.base.stp.out.OutProjectInfoExample;

public interface OutProjectInfoMapper {
    int countByExample(OutProjectInfoExample example);

    int deleteByExample(OutProjectInfoExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(OutProjectInfo record);

    int insertSelective(OutProjectInfo record);

    List<OutProjectInfo> selectByExample(OutProjectInfoExample example);

    OutProjectInfo selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") OutProjectInfo record, @Param("example") OutProjectInfoExample example);

    int updateByExample(@Param("record") OutProjectInfo record, @Param("example") OutProjectInfoExample example);

    int updateByPrimaryKeySelective(OutProjectInfo record);

    int updateByPrimaryKey(OutProjectInfo record);
    
    public void copyData(String nd);

	public void insertOutProjectBatch(List<OutProjectInfo> list);

	public List<OutProjectInfo> selectProjectByCond(OutProjectInfo opi);

	/**
     * @param nd
     * @return
     * 首页科研项目数、装备项目数、总金额（预算）
     */
	public HashMap<String, String> getOutProjectInfoCount(String nd);

	public List getOutProjectScopeInfo(String nd);
	
	/**
     * @param nd
     * @return
     * 首页查询，直属研究院、分子公司等9个单位，各单位的新开、续建、完结情况
     */
    public List getProjectTypeInfoByUnit(String nd);
    
    /**
     * @param nd
     * @return
     * 首页查询新开的国家项目、重点项目、重大项目、其他项目的统计
     */
    public HashMap<String, String> getProjectTotalInfoByNew(String nd);
    
    /**
     * @param nd
     * @return
     * 首页查询新开的国家项目、重点项目、重大项目、其他项目和去年的对比
     */
    public HashMap<String, String> getProjectTotalCountYearAndLastYear(String nd);
    
    /**
     * @param nd
     * @return
     * 科研二级页面，按照项目类型查询新建、续建项目数量、总数量
     */
	public List getProjectCountByProjectType(String nd);
	
	/**
     * @param nd
     * @return
     * 科研二级页面，按照项目类型（新开、续建）来区分国家项目、重点项目、重大项目、其他项目数量
     */
	public List getProjectTypeCountByType(String nd);
	
	/**
     * @param nd
     * @return
     * 科研二级页面，按照项目类型查询新建、续建项目数量、总数量
     */
	public List getZBProjectCountByProjectType(String nd);
	
	/**
     * @param nd
     * @return
     * 科研二级页面，按照项目类型（新开、续建）来区分国家项目、重点项目、重大项目、其他项目数量
     */
	public List getZBProjectTypeCountByType(String nd);
	
	/**
     * @param nd
     * @return
     * 科研二级页面，预算分析，新开项目、续建项目对应的费用性金额、资本性金额统计
     */
	public List getProjectMoneyByProjectType(String nd);
	
	/**
     * @param nd
     * @return
     * 科研二级页面，直属院、盈科等单位的费用性金额、资本性金额统计
     */
	public List getProjectMoneyByUnit(String nd);
	
	/**
     * @param nd
     * @return
     * 科研二级页面，8大院的各个新开、续建情况
     */
	public List getProjectTypeCountByUnit(String nd);
	
	/**
     * @param nd
     * @return
     * 科研二级页面，8大院的各个新开、续建情况--装备
     */
	public List getZBProjectTypeCountByUnit(String nd);
	
	/**
     * @param nd
     * @return
     * 科研二级页面，8大院的各个新开、续建情况--树结构
     */
	public List getProjectTypeCountForTree(String nd);
	
	/**
     * @param nd
     * @return
     * 科研二级页面，项目类型（国家项目、重点项目、重大项目、其他项目）的各个新开、续建情况--树结构
     */
	public List getProjectCountByTypeForTree(String nd);
	
	/**
     * @param nd
     * @return
     * 科研二级页面，8大院的各个新开、续建情况--装备树结构
     */
	public List getZBProjectTypeCountForTree(String nd);
	
	/**
     * @param nd
     * @return
     * 科研二级页面，项目类型（国家项目、重点项目、重大项目、其他项目）的各个新开、续建情况--装备树结构
     */
	public List getZBProjectCountByTypeForTree(String nd);
	
	/**
     * @param nd
     * @return
     * 科研二级页面，研究院的各项目的费用性金额、资本性金额统计
     */
	public List getProjectMoneyByYJY(String nd);
	
	/**
     * @param nd
     * @return
     * 科研二级页面，树形结构，费用性金额、资本性金额和新开、续建情况
     */
	public List getProjectMoneyForTree(String nd);
	
	/**
     * @param nd
     * @return
     * 科研二级页面，树形结构，费用性金额、资本性金额和各研究院情况
     */
	public List getProjectMoneyByIniAndTypeForTree(String nd);
	
	/**
     * @param nd
     * @return
     * 首页查询9个单位的新开、续建、完结情况-装备
     */
    public List getZBProjectTypeInfoByUnit(String nd);
    
    
    /**
     * @param nd
     * @return
     * 经费预算建议--集团公司总部科技经费预算（建议稿）
     */
    public List getGroupCompanyStpMoneyForBudgetProposals(String nd);
    
    /**
     * @param nd
     * @return
     * 领导页的各类型项目的数量
     */
    public List getProjectTypeCountForLD(String nd);
    
    /**
     * @param nd
     * @return
     * 领导页,科研项目数量按单位分析--树结构
     */
	public List getProjectTypeCountForTreeLD(String nd);
	
	/**
     * @param nd
     * @return
     * 领导二级页面，直属研究院、分子公司等9个单位，各单位的新开、续建、完结情况
     */
    public List getProjectTypeInfoByUnitLD(String nd);
    
    /**
     * @param nd
     * @return
     * 领导二级页面，各个处室的新开、续建、完结情况
     */
    public List getProjectCountByProjectTypeLD(String nd);
    
    /**
     * @param nd
     * @return
     * 领导二级页面，8个院及国家级项目等性质的新开、续建、完结情况 
     */
    public List getProjectTypeCountByTypeLD(String nd);
    
    /**
     * @param nd
     * @return
     * 领导二级页面，8个院新开、续建情况,每一行是一个院
     */
	public List getProjectTypeCountByUnitLD(String nd);
}