package com.pcitc.mapper.out;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.base.stp.out.OutProjectInfoExample;
import com.pcitc.base.stp.out.OutProjectInfoWithBLOBs;

public interface OutProjectInfoMapper {
    int countByExample(OutProjectInfoExample example);

    int deleteByExample(OutProjectInfoExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(OutProjectInfoWithBLOBs record);

    int insertSelective(OutProjectInfoWithBLOBs record);

    List<OutProjectInfoWithBLOBs> selectByExampleWithBLOBs(OutProjectInfoExample example);

    List<OutProjectInfo> selectByExample(OutProjectInfoExample example);

    OutProjectInfoWithBLOBs selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") OutProjectInfoWithBLOBs record, @Param("example") OutProjectInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") OutProjectInfoWithBLOBs record, @Param("example") OutProjectInfoExample example);

    int updateByExample(@Param("record") OutProjectInfo record, @Param("example") OutProjectInfoExample example);

    int updateByPrimaryKeySelective(OutProjectInfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(OutProjectInfoWithBLOBs record);

    int updateByPrimaryKey(OutProjectInfo record);
    
    public void insertOutProjectBatch(List<OutProjectInfo> list);

	public List<OutProjectInfo> selectProjectByCond(OutProjectInfo opi);

	public List<OutProjectInfo> selectProjectByCondExpert(OutProjectInfo opi);

	public List<OutProjectInfo> selectProjectInfoByCond(OutProjectInfo opi);
	
	/**
     * 分页显示项目数据数据,统计的第三级展示
     */
	public List<OutProjectInfo> selectCommonProjectByCond(HashMap<String, Object> map);
	
	/**
     * 分页显示项目数据数据,国拨项目统计的第三级展示
     */
	public List<OutProjectInfo> selectCountryProjectByCond(HashMap<String, Object> map);

	/**
     * 首页科研项目数、装备项目数、总金额（预算）
     */
	public HashMap<String, String> getOutProjectInfoCount(HashMap<String, String> map);
	
	/**
     * 研究院首页计算装备和科研合同总数 
     */
	public HashMap<String, String> getOutProjectInfoCountWithKYZB(HashMap<String, String> map);
	
	/**
     * 首页计算项目总金额, 包含结转和新开
     */
	public HashMap<String, String> getOutProjectInfoMoney(HashMap<String, String> map);
	
	/**
     * @param nd
     * @return
     * 首页计算十条龙及重大专项项目的总数量
     */
	public HashMap<String, String> getOutProjectDragonInfoCount(HashMap<String, String> map);

	public List getOutProjectScopeInfo(String nd);
	
	/**
     * @param nd
     * 首页查询，直属研究院、分子公司等9个单位，各单位的新开、续建、完结情况
     */
    public List getProjectTypeInfoByUnit(HashMap<String, String> map);
    
    /**
     * @param nd
     * 首页、领导首页，查询新开的国家项目、重点项目、重大项目、其他项目、总计的统计
     */
    public HashMap<String, String> getProjectTotalInfoByNew(HashMap<String, String> map);
    
    /**
     * @param nd
     * 首页查询新开的国家项目、重点项目、重大项目、其他项目和去年的对比
     */
    public HashMap<String, String> getProjectTotalCountYearAndLastYear(HashMap<String, String> map);
    
    /**
     * @param nd
     * 科研二级页面，按照项目类型查询新建、续建项目数量、总数量
     */
	public List getProjectCountByProjectType(HashMap<String, String> map);
	
	/**
     * @param nd
     * 科研二级页面，按照项目类型（新开、续建）来区分国家项目、重点项目、重大项目、其他项目数量
     */
	public List getProjectTypeCountByType(String nd);
	
	/**
     * @param nd
     * 科研二级页面，按照项目类型查询新建、续建项目数量、总数量
     */
	public List getZBProjectCountByProjectType(HashMap<String, String> map);
	
	/**
     * @param nd
     * 科研二级页面，按照项目类型（新开、续建）来区分国家项目、重点项目、重大项目、其他项目数量
     */
	public List getZBProjectTypeCountByType(String nd);
	
	/**
     * @param nd
     * 科研二级页面，预算分析，新开项目、续建项目对应的费用性金额、资本性金额统计
     */
	public List getProjectMoneyByProjectType(HashMap<String, String> map);
	
	/**
     * @param nd
     * 科研二级页面，直属院、盈科等单位的费用性金额、资本性金额统计
     */
	public List getProjectMoneyByUnit(HashMap<String, String> map);
	
	/**
     * @param nd
     * 科研二级页面，8大院的各个新开、续建情况
     */
	public List getProjectTypeCountByUnit(HashMap<String, String> map);
	
	/**
     * @param nd
     * 科研二级页面，8大院的各个新开、续建情况--装备
     */
	public List getZBProjectTypeCountByUnit(HashMap<String, String> map);
	
	/**
     * @param nd
     * 科研二级页面，8大院的各个新开、续建情况--树结构
     */
	public List getProjectTypeCountForTree(HashMap<String, String> map);
	
	/**
     * @param nd
     * 科研二级页面，项目类型（国家项目、重点项目、重大项目、其他项目）的各个新开、续建情况--树结构
     */
	public List getProjectCountByTypeForTree(HashMap<String, String> map);
	
	/**
     * @param nd
     * 科研二级页面，8大院的各个新开、续建情况--装备树结构
     */
	public List getZBProjectTypeCountForTree(HashMap<String, String> map);
	
	/**
     * @param nd
     * 科研二级页面，项目类型（国家项目、重点项目、重大项目、其他项目）的各个新开、续建情况--装备树结构
     */
	public List getZBProjectCountByTypeForTree(HashMap<String, String> map);
	
	/**
     * @param nd
     * 科研二级页面，研究院的各项目的费用性金额、资本性金额、结转数量等统计
     */
	public List getProjectMoneyByYJY(HashMap<String, String> map);
	
	/**
     * @param nd
     * 领导首页-直属研究院，8个研究院国家项目情况
     */
	public List getCountryProjectByYJY(HashMap<String, String> map);
	
	/**
     * @param nd
     * 科研二级页面，树形结构，费用性金额、资本性金额和新开、续建情况
     */
	public List getProjectMoneyForTree(HashMap<String, String> map);
	
	/**
     * @param nd
     * 科研二级页面，树形结构，费用性金额、资本性金额和各研究院情况
     */
	public List getProjectMoneyByIniAndTypeForTree(HashMap<String, String> map);
	
	/**
     * @param nd
     * 首页查询9个单位的新开、续建、完结情况-装备
     */
    public List getZBProjectTypeInfoByUnit(HashMap<String, String> map);
    
    /**
     * @param nd
     * 领导页的各类型项目的数量
     */
    public List getProjectTypeCountForLD(HashMap<String, String> map);
    
    /**
     * @param nd
     * 领导页,科研项目数量按单位分析--树结构
     */
	public List getProjectTypeCountForTreeLD(HashMap<String, String> map);
	
	/**
     * @param nd
     * @return
     * 领导二级页面，直属研究院、分子公司等9个单位，各单位的新开、续建、完结情况
     */
    public List getProjectTypeInfoByUnitLD(HashMap<String, String> map);
    
    /**
     * @param nd
     * 领导二级页面，各个处室的新开、续建、完结情况
     */
    public List getProjectCountByProjectTypeLD(HashMap<String, String> map);
    
    /**
     * @param nd
     * 领导二级页面，8个院新开、续建情况,每一行是一个院
     */
	public List getProjectTypeCountByUnitLD(HashMap<String, String> map);
	
	/**
     * 领导二级页面，预算数据，8个院费用性和资本性的柱状图
     */
	public List getInstituteMoneyWithYS(HashMap<String, String> map);
	
	/**
     * 领导二级页面，预算数据，直属研究院、分子公司等9个维度的费用统计,树形结构
     */
	public List getCompanyMoneyTreeWithYS(HashMap<String, String> map);
	
	/**
     * 领导二级页面，预算数据，直属研究院、分子公司等9个维度的费用统计 
     */
	public List getCompanyMoneyWithYS(HashMap<String, String> map);
	
	/**
     * 领导二级页面，预算数据，17处室的费用统计， 树形结构 
     */
	public List getOfficeMoneyTreeWithYS(HashMap<String, String> map);
	
	/**
     * 领导二级页面，预算数据，17处室的费用统计
     */
	public List getOfficeMoneyWithYS(HashMap<String, String> map);
	
	/**
     * 领导二级页面，直属研究院，8个院预算金额和实际金额的统计
     */
	public List getProjectMoneyByInstituteForLD(HashMap<String, String> map);
	
	/**
     * 领导二级页面，重大项目和十条龙项目详情
     */
	public List getZDSTLProjectInfo(HashMap<String, String> map);
	
	/**
     * 领导二级页面，重大项目和十条龙项目, 8个院中重大、十条龙项目的情况, 每一行是一个院
     */
	public List getZDSTLProjectCountByInstitute(HashMap<String, String> map);
	
	/**
     * 领导二级页面，重点项目、国家项目、重大专项、十条龙、其他项目的新开、结转情况
     */
    public List getProjectNewOldInfoByType(Map hashmap);
	
	/**
     * 领导二级页面，各类型技术的新开、结转情况 
     */
	public List getProjectInfoByTecTypeWithOldNew(HashMap<String, String> map);
	
	/**
     * 领导首页-十条龙，十条龙项目的类型分布
     */
	public List getDragonProjectInfoByType(HashMap<String, String> map);
	
	/**
     * 领导首页-十条龙，十条龙项目的出入龙情况
     */
	public List getDragonProjectInfoWithOutIn(HashMap<String, String> map);
	
	/**
     * 领导首页-十条龙，8个研究院的龙项目/重大专项项目分布
     */
	public List getDragonProjectInfoByInstitute(HashMap<String, String> map);
	
	/**
     * 领导首页-十条龙，十条龙项目的详情
     */
	public List getDragonProjectDetails(HashMap<String, Object> map);
	
	/**
	 * 获取项目详情的查询维度（条件）
	 */
	public List getProjectInfoSelectCondition(HashMap<String, String> map);
	
	/**
	 * 获取十条龙详情的查询维度（条件）
	 */
	public List getDragonProjectInfoSelectCondition(HashMap<String, String> map);

	//首页查询 end
	public List<OutProjectInfo> findOutProjectInfoList(OutProjectInfo outProjectInfo);
	public List<OutProjectInfo> findOutProjectInfoListOr(OutProjectInfo outProjectInfo);
	//首页查询 start
}