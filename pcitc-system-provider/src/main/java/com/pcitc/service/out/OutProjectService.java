package com.pcitc.service.out;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.out.OutProjectErp;
import com.pcitc.base.stp.out.OutProjectInfo;

public interface OutProjectService {

	/**
	 * 批量插入项目
	 * @param list
	 * @param nd
	 * @return
	 */
	public int insertProjectData(List<OutProjectInfo> list, String nd);
	
	/**
	 * 批量插入项目预算数据
	 */
	public int insertProjectItemDataTest(List<OutProjectInfo> list, String nd);
	
	/**
     * 研究院首页计算装备和科研合同总数 
     */
	public HashMap<String, String> getOutProjectInfoCountWithKYZB(HashMap<String, String> map);
	
	/**
	 * 批量插入国家项目
	 * @param list
	 * @param nd
	 * @return
	 */
	public int insertCountryProjectData(List<OutProjectInfo> list, String nd);
	
	/**
	 * 批量插入项目预算数据
	 */
	public int insertProjectItemData(List<OutProjectInfo> list, String nd);
	
	/**
	 * 批量插入国家项目预算数据
	 */
	public int insertCountryProjectItemData(List<OutProjectInfo> list, String nd);
	
	/**
	 * 获取项目数据
	 */
	public List<OutProjectInfo> getProjectList(HashMap<String, String> map);
	
	/**
	 * 获取项目预算数据
	 */
	public List getProjectItemList(HashMap<String, String> map);
	
	/**
	 * 分页显示项目
	 * @param param
	 * @return
	 */
	public LayuiTableData getOutProjectPage(LayuiTableParam param);
	
	/**
	 * 批量删除erp关系
	 * @param map
	 * @return
	 */
	public int deleteProjectErpBatch(Map map);
	
	/**
	 * 批量插入项目和erp关系
	 * @param list
	 * @return
	 */
	public int insertProjectErpBatch(List<OutProjectErp> list);
	
	/**
     * 首页计算新开项目总数 
     */
	public HashMap<String, String> getOutProjectInfoCount(HashMap<String, String> map);
	
	/**
     * 首页计算项目总金额, 包含结转和新开
     */
	public HashMap<String, String> getOutProjectInfoMoney(HashMap<String, String> map);
	
	/**
	 * 修改项目属性
	 * @param opi
	 * @return
	 */
	public int updateOutProjectInfo(OutProjectInfo opi);


	OutProjectInfo getOutProjectShowById(String dataId) throws Exception;
	
	/**
     * @param nd
     * @return
     * 首页查询各单位的新开、续建、完结情况
     */
    public List getProjectTypeInfoByUnit(String nd);
    
    /**
     * @param nd
     * @return
     * 首页查询9个单位的新开、续建、完结情况-装备
     */
    public List getZBProjectTypeInfoByUnit(String nd);
    
    /**
     * @param nd
     * @return
     * 首页、领导首页，查询新开的国家项目、重点项目、重大项目、其他项目、总计的统计
     */
    public HashMap<String, String> getProjectTotalInfoByNew(HashMap<String, String> map);
    
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
     * 科研二级页面，研究院的各项目的费用性金额、资本性金额、国家项目新开数量、国家项目结转数量等统计
     */
	public List getProjectMoneyByYJY(HashMap<String, String> map);
	
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
     * 领导页的各类型项目的数量
     */
    public List getProjectTypeCountForLD(String nd);
    
    /**
     * @param nd
     * @return
     * 领导二级页面,科研项目数量按单位分析--树结构
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
	public List getProjectTypeCountByUnitLD(HashMap<String, String> map);
	
	/**
     * @return
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
    public List getProjectNewOldInfoByType(HashMap<String, String> map);
    
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
	public List getDragonProjectDetails(HashMap<String, String> map);
	
	/**
     * @param nd
     * @return
     * 首页计算十条龙及重大专项项目的总数量
     */
	public HashMap<String, String> getOutProjectDragonInfoCount(HashMap<String, String> map);
	
	
	/**
	 * 获取详细的查询条件
	 */
	public List getProjectInfoSelectCondition(HashMap<String, String> map);
	
}
