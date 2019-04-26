package com.pcitc.service.budget.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.BudgetAuditStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.base.stp.budget.BudgetInfoExample;
import com.pcitc.base.stp.out.OutProjectPlan;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.mapper.budget.BudgetInfoMapper;
import com.pcitc.service.budget.BudgetInfoService;
import com.pcitc.service.feign.SystemRemoteClient;

@Service("budGetInfoService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class BudgetInfoServiceImpl implements BudgetInfoService
{

	@Autowired
	private BudgetInfoMapper budgetInfoMapper;
	
	@Resource
	private SystemRemoteClient systemRemoteClient;
	
	
	@Override
	public BudgetInfo selectBudgetInfo(String dataId) throws Exception
	{
		return budgetInfoMapper.selectByPrimaryKey(dataId);
	}

	@Override
	public Integer updateBudgetInfo(BudgetInfo groupTotal) throws Exception
	{
		groupTotal.setUpdateTime(DateUtil.dateToStr(new Date(),DateUtil.FMT_SS));
		return budgetInfoMapper.updateByPrimaryKey(groupTotal);
	}

	@Override
	public int deleteBudgetInfo(String id) throws Exception
	{
		BudgetInfo info = budgetInfoMapper.selectByPrimaryKey(id);
		if(info != null) 
		{
			info.setDelFlag(DelFlagEnum.STATUS_DEL.getCode());
			return budgetInfoMapper.updateByPrimaryKey(info);
		}
		return 0;
	}

	@Override
	public List<BudgetInfo> selectBudgetInfoListByIds(List<String> list) throws Exception
	{
		BudgetInfoExample example = new BudgetInfoExample();
		BudgetInfoExample.Criteria c = example.createCriteria();
		c.andDataIdIn(list);
		return budgetInfoMapper.selectByExample(example);
	}

	@Override
	public Integer insertBudgetInfo(BudgetInfo BudgetInfo) throws Exception
	{
		return budgetInfoMapper.insert(BudgetInfo);
	}

	@Override
	public List<BudgetInfo> selectBudgetInfoList(String nd,Integer budgetType) throws Exception
	{
		BudgetInfoExample example = new BudgetInfoExample();
		BudgetInfoExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andNdEqualTo(nd);
		c.andBudgetTypeEqualTo(budgetType);
		example.setOrderByClause("data_version DESC");
		return budgetInfoMapper.selectByExample(example);
	}

	@Override
	public LayuiTableData selectBudgetInfoPage(LayuiTableParam param) throws Exception
	{
		if(param.getParam().get("nd")==null || param.getParam().get("budget_type") == null) 
		{
			return null;
		}
		BudgetInfoExample example = new BudgetInfoExample();
		BudgetInfoExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andBudgetTypeEqualTo(new Integer(param.getParam().get("budget_type").toString()));
		c.andNdEqualTo(param.getParam().get("nd").toString());
		example.setOrderByClause("data_version");
		LayuiTableData data = this.findByExample(param, example);
		List<Map<String,Object>> mapdata = new ArrayList<Map<String,Object>>();
		for(java.util.Iterator<?> iter = data.getData().iterator();iter.hasNext();) {
			Map<String,Object> map = MyBeanUtils.transBean2Map(iter.next());
			map.put("status", BudgetAuditStatusEnum.getStatusByCode((Integer)map.get("auditStatus")).getDesc());
			mapdata.add(map);
		}
		data.setData(mapdata);
		return data;
	}
	private LayuiTableData findByExample(LayuiTableParam param,BudgetInfoExample example) 
	{
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		
		List<BudgetInfo> list = budgetInfoMapper.selectByExample(example);
		// 3、获取分页查询后的数据
		PageInfo<BudgetInfo> pageInfo= new PageInfo<BudgetInfo>(list);
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	@Override
	public BudgetInfo createBlankBudgetInfo(String nd,BudgetInfo info)
	{
		BudgetInfo params = (BudgetInfo) MyBeanUtils.createDefaultModel(BudgetInfo.class);
		params.setAuditStatus(BudgetAuditStatusEnum.AUDIT_STATUS_NO_START.getCode());
		params.setBudgetType(info.getBudgetType());
		params.setNd(nd);
		params.setBudgetMoney(0d);
		params.setCreaterId(info.getCreaterId());
		params.setDelFlag(DelFlagEnum.STATUS_NORMAL.getCode());
		params.setCreaterName(info.getCreaterName());
		
		//检索已创建
		BudgetInfoExample example = new BudgetInfoExample();
		BudgetInfoExample.Criteria c = example.createCriteria();
		c.andBudgetTypeEqualTo(info.getBudgetType());
		c.andNdEqualTo(nd);
		Integer size = budgetInfoMapper.selectByExample(example).size();
		
		
		params.setDataVersion("vs-"+nd+"-"+info.getBudgetType()+"-"+((1001+size)+"").substring(1));
		budgetInfoMapper.insert(params);
		return params;
	}

	@Override
	public List<BudgetInfo> selectFinalBudgetInfoList(Integer budgetType) throws Exception {
		BudgetInfoExample example = new BudgetInfoExample();
		BudgetInfoExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andAuditStatusEqualTo(BudgetAuditStatusEnum.AUDIT_STATUS_FINAL.getCode());
		c.andBudgetTypeEqualTo(budgetType);
		example.setOrderByClause("nd DESC");
		return budgetInfoMapper.selectByExample(example);
	}

	@Override
	public BudgetInfo selectFinalBudget(String nd, Integer budgetType) {
		BudgetInfoExample example = new BudgetInfoExample();
		BudgetInfoExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andAuditStatusEqualTo(BudgetAuditStatusEnum.AUDIT_STATUS_FINAL.getCode());
		c.andBudgetTypeEqualTo(budgetType);
		c.andNdEqualTo(nd);
		List<BudgetInfo> infos = budgetInfoMapper.selectByExample(example);
		if(infos != null && infos.size()>0) {
			return infos.get(0);
		}
		return null;
	}
	@Override
	public Map<String, List<OutProjectPlan>> selectBudgetPlanData(Set<String> codes, String nd) {
		if(codes == null || codes.size() == 0) {
			return new HashMap<String,List<OutProjectPlan>>();
		}
		
		StringBuffer sb = new StringBuffer();
		for (String code : codes) {
			sb.append(code + ",");
		}
		LayuiTableParam layuiParam = new LayuiTableParam();
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("ysnd", nd);
		p.put("define9", sb.toString().substring(0, sb.length() - 1));
		layuiParam.setLimit(1000);
		layuiParam.setPage(1);
		layuiParam.setParam(p);

		LayuiTableData dt = systemRemoteClient.selectProjectPlanByCond(layuiParam);
		Map<String, List<OutProjectPlan>> rs = new HashMap<String,List<OutProjectPlan>>();
		for (java.util.Iterator<?> iter = dt.getData().iterator(); iter.hasNext();) {
			String planStr = JSON.toJSON(iter.next()).toString();
			OutProjectPlan plan = JSON.toJavaObject(JSON.parseObject(planStr), OutProjectPlan.class);

			if(!rs.containsKey(plan.getDefine9())) {
				rs.put(plan.getDefine9(), new ArrayList<OutProjectPlan>());
			}
			rs.get(plan.getDefine9()).add(plan);
		}
		return rs;
	}
}
