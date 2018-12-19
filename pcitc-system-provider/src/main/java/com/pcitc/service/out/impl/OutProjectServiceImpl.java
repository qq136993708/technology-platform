package com.pcitc.service.out.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.out.OutProjectErp;
import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.base.stp.out.OutProjectInfoExample;
import com.pcitc.base.util.StrUtil;
import com.pcitc.mapper.out.OutProjectErpMapper;
import com.pcitc.mapper.out.OutProjectInfoMapper;
import com.pcitc.service.out.OutProjectService;
import com.pcitc.utils.StringUtils;

@Service("outProjectService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class OutProjectServiceImpl implements OutProjectService {

	@Autowired
	private OutProjectInfoMapper outProjectInfoMapper;

	@Autowired
	private OutProjectErpMapper outProjectErpMapper;

	private final static Logger logger = LoggerFactory.getLogger(OutProjectServiceImpl.class);

	/**
	 * 获取项目数据
	 */
	public List<OutProjectInfo> getProjectList(HashMap<String, String> map) {
		
		OutProjectInfoExample example = new OutProjectInfoExample();
		
		OutProjectInfoExample.Criteria criteria = example.createCriteria();
    	
    	criteria.andDefine3EqualTo("项目管理系统");
    	List<OutProjectInfo> returnList = outProjectInfoMapper.selectByExample(example);
    	return returnList;
	}
	public int insertProjectData(List<OutProjectInfo> list, String nd) {
		// 把年度数据复制到临时表中备份
		// outProjectInfoMapper.copyData(nd);

		// 删除年度数据
		OutProjectInfoExample example = new OutProjectInfoExample();
		example.createCriteria().andNdEqualTo(nd);
		outProjectInfoMapper.deleteByExample(example);

		// 批量插入数据
		outProjectInfoMapper.insertOutProjectBatch(list);
		return 1;
	}

	public LayuiTableData getOutProjectPage(LayuiTableParam param) {
		// 每页显示条数
		int pageSize = param.getLimit();
		// 当前是第几页
		int pageNum = param.getPage();
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);

		OutProjectInfo opi = new OutProjectInfo();
		if(param.getParam().get("xmmc") !=null && !StringUtils.isBlank(param.getParam().get("xmmc")+"")){
			opi.setXmmc((String) param.getParam().get("xmmc"));
		}
		
		if(param.getParam().get("hth") !=null && !StringUtils.isBlank(param.getParam().get("hth")+"")){
			opi.setHth((String) param.getParam().get("hth"));
		}
		// 资本性、费用性
		if(param.getParam().get("define1") !=null && !StringUtils.isBlank(param.getParam().get("define1")+"")){
			opi.setDefine1((String) param.getParam().get("define1"));
		}
		
		// 8大院
		if(param.getParam().get("define2") !=null && !StringUtils.isBlank(param.getParam().get("define2")+"")){
			opi.setDefine2((String) param.getParam().get("define2"));
		}
		
		// 国家项目、重大专项、重点项目、其他项目
		if(param.getParam().get("project_property") !=null && !StringUtils.isBlank(param.getParam().get("project_property")+"")){
			opi.setProjectProperty((String) param.getParam().get("project_property"));
		}
		
		// 新开项目、续建项目、完工项目
		if(param.getParam().get("project_scope") !=null && !StringUtils.isBlank(param.getParam().get("project_scope")+"")){
			opi.setProjectScope((String) param.getParam().get("project_scope"));
		}
		
		// 直属研究院、分子公司、集团等9种类型
		if(param.getParam().get("type_flag") !=null && !StringUtils.isBlank(param.getParam().get("type_flag")+"")){
			opi.setTypeFlag((String) param.getParam().get("type_flag"));
		}
		
		// 装备的各种技术类型
		if(param.getParam().get("zylb") !=null && !StringUtils.isBlank(param.getParam().get("zylb")+"")){
			opi.setZylb((String) param.getParam().get("zylb"));
		}
		
		// 各个处室
		if(param.getParam().get("zycmc") !=null && !StringUtils.isBlank(param.getParam().get("zycmc")+"")){
			opi.setZycmc((String) param.getParam().get("zycmc"));
		}
		
		// 年度，暂时不用
		if(param.getParam().get("nd") !=null && !StringUtils.isBlank(param.getParam().get("nd")+"")){
			opi.setNd((String) param.getParam().get("nd"));
		}
		
		List<OutProjectInfo> list = outProjectInfoMapper.selectProjectByCond(opi);
		System.out.println("1>>>>>>>>>查询分页结果" + list.size());
		PageInfo<OutProjectInfo> pageInfo = new PageInfo<OutProjectInfo>(list);
		System.out.println("2>>>>>>>>>查询分页结果" + pageInfo.getList().size());

		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	public int updateOutProjectInfo(OutProjectInfo opi) {
		OutProjectInfo newOPI = outProjectInfoMapper.selectByPrimaryKey(opi.getDataId());
		if (StrUtil.isNotBlank(opi.getProjectLevel())) {
			newOPI.setProjectLevel(opi.getProjectLevel());
		}
		if (StrUtil.isNotBlank(opi.getProjectProperty())) {
			newOPI.setProjectProperty(opi.getProjectProperty());
		}
		if (StrUtil.isNotBlank(opi.getProjectAbc())) {
			newOPI.setProjectAbc(opi.getProjectAbc());
		}
		if (StrUtil.isNotBlank(opi.getProjectSource())) {
			newOPI.setProjectSource(opi.getProjectSource());
		}
		
		if (StrUtil.isNotBlank(opi.getXmlbbm())) {
			newOPI.setXmlbbm(opi.getXmlbbm());
		}
		if (StrUtil.isNotBlank(opi.getXmlbmc())) {
			newOPI.setXmlbmc(opi.getXmlbmc());
		}
		if (StrUtil.isNotBlank(opi.getZycbm())) {
			newOPI.setZycbm(opi.getZycbm());
		}
		if (StrUtil.isNotBlank(opi.getZycmc())) {
			newOPI.setZycmc(opi.getZycmc());
		}
		if (StrUtil.isNotBlank(opi.getGsbmbm())) {
			newOPI.setGsbmbm(opi.getGsbmbm());
		}
		if (StrUtil.isNotBlank(opi.getGsbmmc())) {
			newOPI.setGsbmmc(opi.getGsbmmc());
		}
		return outProjectInfoMapper.updateByPrimaryKey(newOPI);
	}

	/**
     * @param nd
     * @return
     * 首页科研项目数、装备项目数、总金额（预算）
     */
	public HashMap<String, String> getOutProjectInfoCount(HashMap<String, String> map) {
		return outProjectInfoMapper.getOutProjectInfoCount(map);
	}

	public int deleteProjectErpBatch(Map map) {
		outProjectErpMapper.deleteOutProjectErpBatch(map);
		return 0;
	}

	public int insertProjectErpBatch(List<OutProjectErp> list) {
		outProjectErpMapper.insertOutProjectErpBatch(list);
		return 0;
	}

	@Override
	public OutProjectInfo getOutProjectShowById(String dataId) {
		return outProjectInfoMapper.selectByPrimaryKey(dataId);
	}
	
	/**
     * @param nd
     * @return
     * 首页查询各单位的新开、续建、完结情况
     */
    public List getProjectTypeInfoByUnit(String nd) {
    	return outProjectInfoMapper.getProjectTypeInfoByUnit(nd);
    }
    
    /**
     * @param nd
     * @return
     * 首页、领导首页，查询新开的国家项目、重点项目、重大项目、其他项目、总计的统计
     */
    public HashMap<String, String> getProjectTotalInfoByNew(HashMap<String, String> map) {
    	return outProjectInfoMapper.getProjectTotalInfoByNew(map);
    }
    
    /**
     * @param nd
     * @return
     * 首页查询新开的国家项目、重点项目、重大项目、其他项目和去年的对比
     */
    public HashMap<String, String> getProjectTotalCountYearAndLastYear(String nd) {
    	return outProjectInfoMapper.getProjectTotalCountYearAndLastYear(nd);
    }
    
    /**
     * @param nd
     * @return
     * 科研二级页面，按照项目类型查询新建、续建项目数量、总数量
     */
	public List getProjectCountByProjectType(String nd) {
		return outProjectInfoMapper.getProjectCountByProjectType(nd);
	}
	
	/**
     * @param nd
     * @return
     * 科研二级页面，按照项目类型（新开、续建）来区分国家项目、重点项目、重大项目、其他项目数量
     */
	public List getProjectTypeCountByType(String nd) {
		return outProjectInfoMapper.getProjectTypeCountByType(nd);
	}
	
	/**
     * @param nd
     * @return
     * 科研二级页面，按照项目类型查询新建、续建项目数量、总数量
     */
	public List getZBProjectCountByProjectType(String nd) {
		return outProjectInfoMapper.getZBProjectCountByProjectType(nd);
	}
	
	/**
     * @param nd
     * @return
     * 科研二级页面，按照项目类型（新开、续建）来区分国家项目、重点项目、重大项目、其他项目数量
     */
	public List getZBProjectTypeCountByType(String nd) {
		return outProjectInfoMapper.getZBProjectTypeCountByType(nd);
	}
	
	/**
     * @param nd
     * @return
     * 科研二级页面，预算分析，新开项目、续建项目对应的费用性金额、资本性金额统计
     */
	public List getProjectMoneyByProjectType(String nd) {
		return outProjectInfoMapper.getProjectMoneyByProjectType(nd);
	}
	
	/**
     * @param nd
     * @return
     * 科研二级页面，直属院、盈科等单位的费用性金额、资本性金额统计
     */
	public List getProjectMoneyByUnit(String nd) {
		return outProjectInfoMapper.getProjectMoneyByUnit(nd);
	}
	
	/**
     * @param nd
     * @return
     * 科研二级页面，8大院的各个新开、续建情况
     */
	public List getProjectTypeCountByUnit(String nd) {
		return outProjectInfoMapper.getProjectTypeCountByUnit(nd);
	}

	/**
     * @param nd
     * @return
     * 科研二级页面，8大院的各个新开、续建情况--装备
     */
	public List getZBProjectTypeCountByUnit(String nd) {
		return outProjectInfoMapper.getZBProjectTypeCountByUnit(nd);
	}
	
	/**
     * @param nd
     * @return
     * 科研二级页面，8大院的各个新开、续建情况--树结构
     */
	public List getProjectTypeCountForTree(String nd) {
		return outProjectInfoMapper.getProjectTypeCountForTree(nd);
	}
	
	/**
     * @param nd
     * @return
     * 科研二级页面，项目类型（国家项目、重点项目、重大项目、其他项目）的各个新开、续建情况--树结构
     */
	public List getProjectCountByTypeForTree(String nd) {
		return outProjectInfoMapper.getProjectCountByTypeForTree(nd);
	}
	
	/**
     * @param nd
     * @return
     * 科研二级页面，8大院的各个新开、续建情况--装备树结构
     */
	public List getZBProjectTypeCountForTree(String nd) {
		return outProjectInfoMapper.getZBProjectTypeCountForTree(nd);
	}
	
	/**
     * @param nd
     * @return
     * 科研二级页面，项目类型（国家项目、重点项目、重大项目、其他项目）的各个新开、续建情况--装备树结构
     */
	public List getZBProjectCountByTypeForTree(String nd) {
		return outProjectInfoMapper.getZBProjectCountByTypeForTree(nd);
	}
	
	/**
     * @param nd
     * @return
     * 科研二级页面，研究院的各项目的费用性金额、资本性金额统计
     */
	public List getProjectMoneyByYJY(String nd) {
		return outProjectInfoMapper.getProjectMoneyByYJY(nd);
	}
	
	/**
     * @param nd
     * @return
     * 科研二级页面，树形结构，费用性金额、资本性金额和新开、续建情况
     */
	public List getProjectMoneyForTree(String nd) {
		return outProjectInfoMapper.getProjectMoneyForTree(nd);
	}
	
	/**
     * @param nd
     * @return
     * 科研二级页面，树形结构，费用性金额、资本性金额和各研究院情况
     */
	public List getProjectMoneyByIniAndTypeForTree(String nd) {
		return outProjectInfoMapper.getProjectMoneyByIniAndTypeForTree(nd);
	}
	
	/**
     * @param nd
     * @return
     * 首页查询9个单位的新开、续建、完结情况-装备
     */
    public List getZBProjectTypeInfoByUnit(String nd) {
    	return outProjectInfoMapper.getZBProjectTypeInfoByUnit(nd);
    }
    
    /**
     * @param nd
     * @return
     * 领导页的各类型项目的数量
     */
    public List getProjectTypeCountForLD(String nd) {
    	return outProjectInfoMapper.getProjectTypeCountForLD(nd);
    }
    
    /**
     * @param nd
     * @return
     * 领导二级页面，科研项目数量按单位分析--树结构
     */
	public List getProjectTypeCountForTreeLD(String nd) {
		return outProjectInfoMapper.getProjectTypeCountForTreeLD(nd);
	}
	
	/**
     * @param nd
     * @return
     * 领导二级页面，直属研究院、分子公司等9个单位，各单位的新开、续建、完结情况
     */
    public List getProjectTypeInfoByUnitLD(String nd) {
    	return outProjectInfoMapper.getProjectTypeInfoByUnitLD(nd);
    }
    
    /**
     * @param nd
     * @return
     * 领导二级页面，各个处室的新开、续建、完结情况
     */
    public List getProjectCountByProjectTypeLD(String nd) {
    	return outProjectInfoMapper.getProjectCountByProjectTypeLD(nd);
    }
    
    /**
     * @param nd
     * @return
     * 领导二级页面，8个院及国家级项目等性质的新开、续建、完结情况 
     */
    public List getProjectTypeCountByTypeLD(String nd) {
    	return outProjectInfoMapper.getProjectTypeCountByTypeLD(nd);
    }
    
    /**
     * @param nd
     * @return
     * 领导二级页面，8个院新开、续建情况,每一行是一个院
     */
	public List getProjectTypeCountByUnitLD(HashMap<String, String> map) {
		return outProjectInfoMapper.getProjectTypeCountByUnitLD(map);
	}
	
	/**
     * @return
     * 领导二级页面，预算数据，8个院费用性和资本性的柱状图
     */
	public List getInstituteMoneyWithYS(HashMap<String, String> map) {
		return outProjectInfoMapper.getInstituteMoneyWithYS(map);
	}
	
	/**
     * 领导二级页面，预算数据，直属研究院、分子公司等9个维度的费用统计,树形结构
     */
	public List getCompanyMoneyTreeWithYS(HashMap<String, String> map) {
		return outProjectInfoMapper.getCompanyMoneyTreeWithYS(map);
	}
	
	/**
     * 领导二级页面，预算数据，直属研究院、分子公司等9个维度的费用统计 
     */
	public List getCompanyMoneyWithYS(HashMap<String, String> map) {
		return outProjectInfoMapper.getCompanyMoneyWithYS(map);
	}
	
	/**
     * 领导二级页面，预算数据，17处室的费用统计， 树形结构 
     */
	public List getOfficeMoneyTreeWithYS(HashMap<String, String> map) {
		return outProjectInfoMapper.getOfficeMoneyTreeWithYS(map);
	}
	
	/**
     * 领导二级页面，预算数据，17处室的费用统计
     */
	public List getOfficeMoneyWithYS(HashMap<String, String> map) {
		return outProjectInfoMapper.getOfficeMoneyWithYS(map);
	}
	
	/**
     * 领导二级页面，直属研究院，8个院预算金额和实际金额的统计
     */
	public List getProjectMoneyByInstituteForLD(HashMap<String, String> map) {
		return outProjectInfoMapper.getProjectMoneyByInstituteForLD(map);
	}
	
	/**
     * 领导二级页面，重大项目和十条龙项目详情
     */
	public List getZDSTLProjectInfo(HashMap<String, String> map) {
		return outProjectInfoMapper.getZDSTLProjectInfo(map);
	}
	
	/**
     * 领导二级页面，重大项目和十条龙项目, 8个院中重大、十条龙项目的情况, 每一行是一个院
     */
	public List getZDSTLProjectCountByInstitute(HashMap<String, String> map) {
		return outProjectInfoMapper.getZDSTLProjectCountByInstitute(map);
	}
	
	/**
     * 领导二级页面，重点项目、国家项目、重大专项、十条龙、其他项目的新开、结转情况
     */
    public List getProjectNewOldInfoByType(HashMap<String, String> map) {
    	return outProjectInfoMapper.getProjectNewOldInfoByType(map);
    }
    
    /**
     * 领导二级页面，各类型技术的新开、结转情况 
     */
	public List getProjectInfoByTecTypeWithOldNew(HashMap<String, String> map) {
		return outProjectInfoMapper.getProjectInfoByTecTypeWithOldNew(map);
	}
	
	/**
     * 领导首页-十条龙，十条龙项目的类型分布
     */
	public List getDragonProjectInfoByType(HashMap<String, String> map) {
		return outProjectInfoMapper.getDragonProjectInfoByType(map);
	}
	
	/**
     * 领导首页-十条龙，十条龙项目的出入龙情况
     */
	public List getDragonProjectInfoWithOutIn(HashMap<String, String> map) {
		return outProjectInfoMapper.getDragonProjectInfoWithOutIn(map);
	}
	
	/**
     * 领导首页-十条龙，8个研究院的龙项目/重大专项项目分布
     */
	public List getDragonProjectInfoByInstitute(HashMap<String, String> map) {
		return outProjectInfoMapper.getDragonProjectInfoByInstitute(map);
	}
	
	/**
     * 领导首页-十条龙，十条龙项目的详情
     */
	public List getDragonProjectDetails(HashMap<String, String> map) {
		return outProjectInfoMapper.getDragonProjectDetails(map);
	}
	
	/**
     * @param nd
     * @return
     * 首页计算十条龙及重大专项项目的总数量
     */
	public HashMap<String, String> getOutProjectDragonInfoCount(HashMap<String, String> map) {
		return outProjectInfoMapper.getOutProjectDragonInfoCount(map);
	}
	
	
}
