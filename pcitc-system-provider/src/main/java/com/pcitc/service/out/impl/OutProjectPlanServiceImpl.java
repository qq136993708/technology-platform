package com.pcitc.service.out.impl;

import java.util.HashMap;
import java.util.List;

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
import com.pcitc.base.stp.out.OutProjectPlan;
import com.pcitc.base.stp.out.OutProjectPlanExample;
import com.pcitc.mapper.out.OutProjectPlanMapper;
import com.pcitc.service.out.OutProjectPlanService;
import com.pcitc.utils.StringUtils;

@Service("outProjectPlanService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class OutProjectPlanServiceImpl implements OutProjectPlanService {

	@Autowired
	private OutProjectPlanMapper outProjectPlanMapper;

	private final static Logger logger = LoggerFactory.getLogger(OutProjectPlanServiceImpl.class);
	
	/**
     * 批量插入项目计划数据
     */
    public void insertOutProjectPlanBatch(List<OutProjectPlan> list) {
    	outProjectPlanMapper.insertOutProjectPlanBatch(list);
    }
    
    /**
     * 直属研究院二级页面（领导），项目计划完成的比率，按照新开续建、资本性费用性来分组
     */
	public List getPlanCompleteRateByOldNew(HashMap<String, String> map) {
		return outProjectPlanMapper.getPlanCompleteRateByOldNew(map);
	}
	
	/**
     * 直属研究院二级页面（领导），总的签订率
     */
	public List getPlanTotalCompleteRate(HashMap<String, String> map) {
		return outProjectPlanMapper.getPlanTotalCompleteRate(map);
	}
    
	/**
     * 直属研究院二级页面（领导），各个院的合同签订率
     */
	public List getPlanCompleteRateByInstitute(HashMap<String, String> map) {
		return outProjectPlanMapper.getPlanCompleteRateByInstitute(map);
	}
	
	/**
     * 首页-直属研究院，项目计划完成的比率，按照资本性费用性来分组
     */
	public List getPlanCompleteRateByPlanType(HashMap<String, String> map) {
		return outProjectPlanMapper.getPlanCompleteRateByPlanType(map);
	}
	
	/**
     * 领导首页-科研合同，项目计划完成的比率，按照直属研究所、分子公司等9个来分组
     */
	public List getPlanCompleteRateByCompanyType(HashMap<String, String> map) {
		return outProjectPlanMapper.getPlanCompleteRateByCompanyType(map);
	}
	
	/**
     * 领导首页-科研合同，科研合同签订率清单
     */
	public List getPlanCompleteRateDetails(HashMap<String, String> map) {
		return outProjectPlanMapper.getPlanCompleteRateDetails(map);
	}
	
	
	/**
     * 获取所有的项目计划数据
     */
    public List getProjectPlanList(HashMap<String, String> map) {
    	OutProjectPlanExample example = new OutProjectPlanExample();
    	OutProjectPlanExample.Criteria criteria = example.createCriteria();
    	
    	criteria.andDefine4EqualTo("项目管理系统");

    	List<OutProjectPlan> returnList = outProjectPlanMapper.selectByExample(example);
    	return returnList;
    }
	
    /**
     * 项目计划数据，涉及项目预算、项目计划详情等相关的查询时调用
     */
	public LayuiTableData selectProjectPlanByCond(LayuiTableParam param) {
		// 每页显示条数
		int pageSize = param.getLimit();
		// 当前是第几页
		int pageNum = param.getPage();
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);

		OutProjectPlan opi = new OutProjectPlan();
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
		
		// 8大院等细分结构
		if(param.getParam().get("define2") !=null && !StringUtils.isBlank(param.getParam().get("define2")+"")){
			opi.setDefine2((String) param.getParam().get("define2"));
		}
		
		// 直属研究院、分子公司、集团等9种类型
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
		
		List<OutProjectPlan> list = outProjectPlanMapper.selectProjectPlanByCond(opi);
		System.out.println("1>>>>>>>>>查询分页结果" + list.size());
		PageInfo<OutProjectPlan> pageInfo = new PageInfo<OutProjectPlan>(list);
		System.out.println("2>>>>>>>>>查询分页结果" + pageInfo.getList().size());

		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}
	
}
