package com.pcitc.service.out.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

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
import com.pcitc.base.util.StrUtil;
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
    	
    	List<OutProjectPlan> insertData = new ArrayList<OutProjectPlan>();
		// 先更新，没有的批量插入
		for (int i = 0; i < list.size(); i++) {
			int temInt = this.updateOutProjectPlan(list.get(i));
			if (temInt == -1) {
				insertData.add(list.get(i));
			}
		}
		System.out.println("===========新插入条数----------------"+insertData.size());
		// 批量插入数据
		if (insertData.size() > 0) {
			outProjectPlanMapper.insertOutProjectPlanBatch(insertData);
		}
    	
    }
    
    public int updateOutProjectPlan(OutProjectPlan opp) {
		
		OutProjectPlanExample example = new OutProjectPlanExample();
		
		OutProjectPlanExample.Criteria criteria = example.createCriteria();
    	
    	criteria.andXmidEqualTo(opp.getXmid());
    	criteria.andDefine3EqualTo("项目管理系统");
    	criteria.andYsndEqualTo(opp.getYsnd());
    	List<OutProjectPlan> returnList = outProjectPlanMapper.selectByExample(example);
    	if (returnList != null && returnList.size() > 0) {
    		OutProjectPlan newOPI = returnList.get(0);
    		if (newOPI != null) {
    			if (StrUtil.isNotBlank(opp.getProjectProperty()) ) {
    				newOPI.setProjectProperty(opp.getProjectProperty());
    			}
    			if (StrUtil.isNotBlank(opp.getJf()) ) {
    				newOPI.setJf(opp.getJf());
    			}
    			
    			if (StrUtil.isNotBlank(opp.getYsje()) ) {
    				newOPI.setYsje(opp.getYsje());
    			}
    			if (StrUtil.isNotBlank(opp.getYsnd()) ) {
    				newOPI.setYsnd(opp.getYsnd());
    			}
    			if (StrUtil.isNotBlank(opp.getFwdx())) {
    				newOPI.setFwdx(opp.getFwdx());
    			}
    			if (StrUtil.isNotBlank(opp.getFwdxbm())) {
    				newOPI.setFwdxbm(opp.getFwdxbm());
    			}
    			if (StrUtil.isNotBlank(opp.getFzdw())) {
    				newOPI.setFzdw(opp.getFzdw());
    			}
    			if (StrUtil.isNotBlank(opp.getFzdwbm())) {
    				newOPI.setFzdwbm(opp.getFzdwbm());
    			}
    			
    			if (StrUtil.isNotBlank(opp.getXmlbbm())) {
    				newOPI.setXmlbbm(opp.getXmlbbm());
    			}
    			if (StrUtil.isNotBlank(opp.getXmlbmc())) {
    				newOPI.setXmlbmc(opp.getXmlbmc());
    			}
    			if (StrUtil.isNotBlank(opp.getZycbm())) {
    				newOPI.setZycbm(opp.getZycbm());
    			}
    			if (StrUtil.isNotBlank(opp.getZycmc())) {
    				newOPI.setZycmc(opp.getZycmc());
    			}
    			if (StrUtil.isNotBlank(opp.getGsbmbm())) {
    				newOPI.setGsbmbm(opp.getGsbmbm());
    			}
    			if (StrUtil.isNotBlank(opp.getGsbmmc())) {
    				newOPI.setGsbmmc(opp.getGsbmmc());
    			}
    			
    			return outProjectPlanMapper.updateByPrimaryKey(newOPI);
    		} else {
    			return 0;
    		}
    	} else {
			return -1;
		}
	}
    
    /**
     * 批量插入项目计划预算数据
     */
    public void insertOutProjectPlanForYS(List<OutProjectPlan> list) {
    	
    	// 修改本年的预算，没有的查询原项目信息后，保存
		for (int i = 0; i < list.size(); i++) {
			OutProjectPlan opp = list.get(i);
			
			OutProjectPlanExample example = new OutProjectPlanExample();
	    	OutProjectPlanExample.Criteria criteria = example.createCriteria();
	    	
	    	criteria.andDefine4EqualTo("项目管理系统");
	    	criteria.andYsndEqualTo(opp.getYsnd());
	    	criteria.andXmidEqualTo(opp.getXmid());

	    	List<OutProjectPlan> oppList = outProjectPlanMapper.selectByExample(example);
	    	
	    	if (oppList != null && oppList.size() > 0) {
	    		OutProjectPlan newOPP = oppList.get(0);
	    		if (StrUtil.isNotBlank(opp.getYsje())) {
	    			newOPP.setYsje(opp.getYsje());
				}
	    		outProjectPlanMapper.updateByPrimaryKey(newOPP);
	    	} else {
	    		// 此项目此预算年度没有预算费用
	    		OutProjectPlanExample example1 = new OutProjectPlanExample();
		    	OutProjectPlanExample.Criteria criteria1 = example1.createCriteria();
		    	
		    	criteria1.andDefine4EqualTo("项目管理系统");
		    	criteria1.andXmidEqualTo(opp.getXmid());
		    	
	        	List<OutProjectPlan> insertList = outProjectPlanMapper.selectByExample(example1);
	        	if (insertList != null && insertList.size() > 0) {
	        		OutProjectPlan insertOPP = insertList.get(0);
	        		insertOPP.setYsnd(opp.getYsnd());
	        		insertOPP.setYsje(opp.getYsje());
	        		insertOPP.setDataId(UUID.randomUUID().toString().replaceAll("-", ""));
	        		outProjectPlanMapper.insert(insertOPP);
	        	} 
	    	}
			
		}
    }
    
    /**
     * 领导首页-科研投入，按照直属研究所、分子公司等9个来分组
     */
	public List getPlanMoneyCompleteRateByCompanyType(HashMap<String, String> map) {
		return outProjectPlanMapper.getPlanMoneyCompleteRateByCompanyType(map);
	}
	
	/**
     * 直属研究院二级页面（领导），各个院的合同预算情况
     */
	public List getPlanMoneyCompleteRateByInstitute(HashMap<String, String> map) {
		return outProjectPlanMapper.getPlanMoneyCompleteRateByInstitute(map);
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

		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		OutProjectPlan opi = new OutProjectPlan();
		if(param.getParam().get("xmmc") !=null && !StringUtils.isBlank(param.getParam().get("xmmc")+"")){
			opi.setXmmc((String) param.getParam().get("xmmc"));
			hashmap.put("xmmc", param.getParam().get("xmmc"));
		}
		
		if(param.getParam().get("hth") !=null && !StringUtils.isBlank(param.getParam().get("hth")+"")){
			opi.setHth((String) param.getParam().get("hth"));
			hashmap.put("hth", param.getParam().get("hth"));
		}
		// 资本性、费用性
		if(param.getParam().get("define1") !=null && !StringUtils.isBlank(param.getParam().get("define1")+"")){
			opi.setDefine1((String) param.getParam().get("define1"));
			
			List define1 = new ArrayList();
			String[] temS = param.getParam().get("define1").toString().split(",");
			for (int i = 0; i < temS.length; i++) {
				define1.add(temS[i]);
			}
			hashmap.put("define1", define1);
		}
		
		// 8大院等细分结构
		if(param.getParam().get("define2") !=null && !StringUtils.isBlank(param.getParam().get("define2")+"")){
			opi.setDefine2((String) param.getParam().get("define2"));
			
			List define2 = new ArrayList();
			String[] temS = param.getParam().get("define2").toString().split(",");
			for (int i = 0; i < temS.length; i++) {
				define2.add(temS[i]);
			}
			hashmap.put("define2", define2);
		}
		
		// 直属研究院、分子公司、集团等9种类型
		if(param.getParam().get("define3") !=null && !StringUtils.isBlank(param.getParam().get("define3")+"")){
			opi.setDefine3((String) param.getParam().get("define3"));
			
			List define3 = new ArrayList();
			String[] temS = param.getParam().get("define3").toString().split(",");
			for (int i = 0; i < temS.length; i++) {
				define3.add(temS[i]);
			}
			hashmap.put("define3", define3);
		}
		
		// 国家项目、重大专项、重点项目、其他项目
		if(param.getParam().get("project_property") !=null && !StringUtils.isBlank(param.getParam().get("project_property")+"")){
			opi.setProjectProperty((String) param.getParam().get("project_property"));
			
			List project_property = new ArrayList();
			String[] temS = param.getParam().get("project_property").toString().split(",");
			for (int i = 0; i < temS.length; i++) {
				project_property.add(temS[i]);
			}
			hashmap.put("project_property", project_property);
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
			
			List zycmc = new ArrayList();
			String[] temS = param.getParam().get("zycmc").toString().split(",");
			for (int i = 0; i < temS.length; i++) {
				zycmc.add(temS[i]);
			}
			hashmap.put("zycmc", zycmc);
		}
		
		// 年度，暂时不用
		if(param.getParam().get("nd") !=null && !StringUtils.isBlank(param.getParam().get("nd")+"")){
			opi.setNd((String) param.getParam().get("nd"));
		}
		
		List<OutProjectPlan> list = outProjectPlanMapper.selectProjectPlanByCond(hashmap);
		System.out.println("1>>>>>>>>>查询分页结果" + list.size());
		PageInfo<OutProjectPlan> pageInfo = new PageInfo<OutProjectPlan>(list);
		System.out.println("2>>>>>>>>>查询分页结果" + pageInfo.getList().size());

		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}
	
	
	/**
     * 批量插入国家项目计划数据
     */
    public void insertCountryProjectPlanBatch(List<OutProjectPlan> list, String nd) {
    	// 先删除原国家项目计划数据
		OutProjectPlanExample example = new OutProjectPlanExample();
		example.createCriteria().andDefine4EqualTo("sap国家项目").andYsndEqualTo(nd);
		outProjectPlanMapper.deleteByExample(example);
    	outProjectPlanMapper.insertOutProjectPlanBatch(list);
    }
}
