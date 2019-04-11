package com.pcitc.service.budget.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.BudgetAuditStatusEnum;
import com.pcitc.base.common.enums.BudgetInfoEnum;
import com.pcitc.base.common.enums.BudgetOrganEnum;
import com.pcitc.base.common.enums.BudgetOrganNdEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.base.stp.budget.BudgetInfoExample;
import com.pcitc.base.stp.budget.BudgetSplitData;
import com.pcitc.base.stp.budget.BudgetSplitDataExample;
import com.pcitc.base.stp.budget.vo.BudgetSplitBaseDataVo;
import com.pcitc.base.stp.budget.vo.SplitItemVo;
import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.base.stp.out.OutProjectPlan;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.mapper.budget.BudgetInfoMapper;
import com.pcitc.mapper.budget.BudgetSplitDataMapper;
import com.pcitc.service.budget.BudgetGroupSplitService;
import com.pcitc.service.feign.SystemRemoteClient;


@Service("budgetGroupSplitService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class BudgetGroupSplitServiceImpl implements BudgetGroupSplitService
{

	@Autowired
	private BudgetSplitDataMapper budgetSplitDataMapper;
	
	@Autowired
	private BudgetInfoMapper budgetInfoMapper;
	
	@Resource
	private SystemRemoteClient systemRemoteClient;
	
	
	@Override
	public BudgetSplitData selectBudgetSplitData(String dataId)
	{
		return budgetSplitDataMapper.selectByPrimaryKey(dataId);
	}

	@Override
	public BudgetSplitData selectBudgetSplitItemData(String splitCode,String organCode,String budgetInfoId)
	{
		BudgetSplitDataExample example = new BudgetSplitDataExample();
		BudgetSplitDataExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andBudgetInfoIdEqualTo(budgetInfoId);
		c.andOrganCodeEqualTo(organCode);
		c.andSplitCodeEqualTo(splitCode);
		List<BudgetSplitData> ds = budgetSplitDataMapper.selectByExample(example);
		if(ds != null && ds.size() >0) {
			return ds.get(0);
		}else {
			return null;
		}
	}

	/*@Override
	public int deleteBudgetSplitData(String id) throws Exception
	{
		BudgetSplitData group = budgetSplitDataMapper.selectByPrimaryKey(id);
		if(group != null) 
		{
			group.setDelFlag(DelFlagEnum.STATUS_DEL.getCode());
			return budgetSplitDataMapper.updateByPrimaryKey(group);
		}
		return 0;
	}*/

	@Override
	public List<BudgetSplitData> selectBudgetSplitDataListByIds(List<String> list) throws Exception
	{
		BudgetSplitDataExample example = new BudgetSplitDataExample();
		BudgetSplitDataExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andDataIdIn(list);
		return budgetSplitDataMapper.selectByExample(example);
	}

	@Override
	public Integer saveOrUpdateBudgetSplitData(BudgetSplitData budgetGroupTotal) throws Exception
	{
		BudgetSplitData old = budgetSplitDataMapper.selectByPrimaryKey(budgetGroupTotal.getDataId());
		if(old == null) {
			return budgetSplitDataMapper.insert(budgetGroupTotal);
		}else {
			MyBeanUtils.copyProperties(budgetGroupTotal, old);
			return budgetSplitDataMapper.updateByPrimaryKey(old);
		}
	}

	@Override
	public List<BudgetSplitData> selectItemsByBudgetId(String budgetInfoId) throws Exception
	{
		BudgetSplitDataExample example = new BudgetSplitDataExample();
		BudgetSplitDataExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andBudgetInfoIdEqualTo(budgetInfoId);
		example.setOrderByClause("no");
		List<BudgetSplitData> list =  budgetSplitDataMapper.selectByExample(example);
		return list;
	}

	@Override
	public LayuiTableData selectBudgetSplitDataPage(LayuiTableParam param) throws Exception
	{
		BudgetSplitDataExample example = new BudgetSplitDataExample();
		BudgetSplitDataExample.Criteria c = example.createCriteria();
		c.andBudgetInfoIdEqualTo(param.getParam().get("budget_info_id").toString());
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		example.setOrderByClause("no");
		LayuiTableData tabledata = this.findByExample(param, example);
		return tabledata;
	}
	private LayuiTableData findByExample(LayuiTableParam param,BudgetSplitDataExample example) 
	{
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		
		List<BudgetSplitData> list = budgetSplitDataMapper.selectByExample(example);
		// 3、获取分页查询后的数据
		PageInfo<BudgetSplitData> pageInfo= new PageInfo<BudgetSplitData>(list);
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	@Override
	public int deleteBudgetSplitDataByInfo(String budgetInfoId) throws Exception
	{
		BudgetSplitDataExample example = new BudgetSplitDataExample();
		BudgetSplitDataExample.Criteria c = example.createCriteria();
		c.andBudgetInfoIdEqualTo(budgetInfoId);
		List<BudgetSplitData> list = budgetSplitDataMapper.selectByExample(example);
		
		Integer rs = 0;
		for(BudgetSplitData group:list) 
		{
			group.setDelFlag(DelFlagEnum.STATUS_DEL.getCode());
			rs += budgetSplitDataMapper.updateByPrimaryKey(group);
		}
		return rs;
	}

	/*@Override
	public List<BudgetSplitData> selectChildBudgetSplitData(String dataId)
	{
		BudgetSplitDataExample example = new BudgetSplitDataExample();
		BudgetSplitDataExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		example.setOrderByClause("no");
		return budgetSplitDataMapper.selectByExample(example);
	}*/
	@Override
	public List<Map<String,Object>> selectBudgetSplitDataList(String budgetInfoId)
	{
		BudgetInfo info = budgetInfoMapper.selectByPrimaryKey(budgetInfoId);
		List<Map<String,Object>> rsdata = new ArrayList<Map<String,Object>>();
		//检索数据
		BudgetSplitDataExample example = new BudgetSplitDataExample();
		BudgetSplitDataExample.Criteria c = example.createCriteria();
		c.andBudgetInfoIdEqualTo(info.getDataId());
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		List<BudgetSplitData> datas =  budgetSplitDataMapper.selectByExample(example);
		//检索分类
		List<SysDictionary> dis = this.selectTitleDic(info.getNd());
		//有多少項就有多少條記錄
		List<BudgetOrganEnum> organs = BudgetOrganNdEnum.getByNd(info.getNd()).getOrgans();
		for(BudgetOrganEnum org:organs) {
			Map<String,Object> map = getRowData(info,org,dis,datas);
			rsdata.add(map);
		}
		return rsdata;
	}
	/**
	 * 封装行记录
	 * @return
	 */
	private Map<String,Object> getRowData(BudgetInfo info,BudgetOrganEnum org,List<SysDictionary> dis,List<BudgetSplitData> datas)
	{
		BudgetSplitBaseDataVo vo = new BudgetSplitBaseDataVo();
		vo.setBudgetInfoId(info.getDataId());
		vo.setNd(info.getNd());
		vo.setOrganId(org.getId());
		vo.setOrganCode(org.getCode());
		vo.setOrganName(org.getName());
		vo.setBudgetType(info.getBudgetType());
		vo.setBudgetTypeName(BudgetInfoEnum.getByCode(info.getBudgetType()).getDesc());
		vo.setDataVersion(info.getDataVersion());
		vo.setNo(org.getId());
		
		Map<String,Object> map  = MyBeanUtils.transBean2Map(vo);
		//按字典拼接数据
		Double total_jz = 0d;
		Double total_xq = 0d;
		for(SysDictionary d:dis) {
			//搜索数据
			List<BudgetSplitData> lsData = datas.stream().filter(a -> a.getOrganCode().equals(org.getCode())).filter(a -> a.getOrganId().equals(org.getId()))
					.filter(a -> a.getSplitCode().equals(d.getCode())).collect(Collectors.toList());
			BudgetSplitData dt = lsData.size()>0?lsData.get(0):new BudgetSplitData();
			map.putAll(new SplitItemVo(d.getCode(),dt.getTotal(),dt.getJz(),dt.getXq()));
			//计算合计
			total_jz += dt.getJz()==null?0:dt.getJz();
			total_xq += dt.getXq()==null?0:dt.getXq();
		}
		List<BudgetSplitData> lsData = datas.stream().filter(a -> a.getOrganCode().equals(org.getCode())).filter(a -> a.getOrganId().equals(org.getId()))
				.filter(a -> a.getSplitCode().equals("plan")).collect(Collectors.toList());
		//计划数据（结转、新签）
		map.put("plan_jz", lsData.size()>0?lsData.get(0).getJz():0);
		map.put("plan_xq", lsData.size()>0?lsData.get(0).getXq():0);
		map.put("plan_total", new Double(map.get("plan_jz").toString())+new Double(map.get("plan_xq").toString()));
		
		map.put("total_jz", total_jz);
		map.put("total_xq", total_xq);
		map.put("total", total_jz+total_xq);
		
		return map;
	}
	/**
	 * 获得标题
	 * @param nd
	 * @return
	 */
	private List<SysDictionary> selectTitleDic(String nd)
	{
		List<SysDictionary> dis = systemRemoteClient.getDictionaryListByParentCode("ROOT_JFYS_JTDWFL"+nd);
		if(dis.size()==0) {
			dis = systemRemoteClient.getDictionaryListByParentCode("ROOT_JFYS_JTDWFL");
		}
		return dis;
	}
	@Override
	public Map<String,List<SplitItemVo>> selectBudgetSplitHistoryTableTitles(String nd) 
	{
		BudgetInfoExample infoExample = new BudgetInfoExample();
		BudgetInfoExample.Criteria infoc = infoExample.createCriteria();
		infoc.andAuditStatusEqualTo(BudgetAuditStatusEnum.AUDIT_STATUS_FINAL.getCode());
		infoc.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		infoc.andBudgetTypeEqualTo(BudgetInfoEnum.GROUP_SPLIT.getCode());
		infoc.andNdNotEqualTo(nd);
		infoExample.setOrderByClause("nd desc");
		
		List<BudgetInfo> infos = budgetInfoMapper.selectByExample(infoExample);
		Map<String,List<SplitItemVo>> maps = new LinkedHashMap<String,List<SplitItemVo>>();
		for(BudgetInfo info:infos) 
		{
			List<SplitItemVo> titles = new ArrayList<SplitItemVo>();
			List<SysDictionary> dis = selectTitleDic(nd);
			for(SysDictionary d:dis) {
				//计划项特殊处理，不计入总数,列：序号，处部门，合计，结转[合计，油服..机械..其他，计划]，新签[合计，油服..机械..其他，计划]，
				titles.add(new SplitItemVo(d.getCode(),d.getName()));
			}
			maps.put(info.getNd(), titles);
		}
		return maps;
	}
	
	@Override
	public List<Map<String,Object>> selectBudgetSplitTableTitles(String nd) 
	{
		List<Map<String,Object>> titles = new ArrayList<Map<String,Object>>();
		List<SysDictionary> dis = selectTitleDic(nd);
		for(SysDictionary d:dis) {
			//计划项特殊处理，不计入总数,列：序号，处部门，合计，结转[合计，油服..机械..其他，计划]，新签[合计，油服..机械..其他，计划]，
			titles.add(new SplitItemVo(d.getCode(),d.getName()));
		}
		return titles;
	}
	
	@Override
	public List<BudgetSplitData> saveBudgetSplitData(String items) {
		List<BudgetSplitData> rs = new ArrayList<BudgetSplitData>();
		try
		{
			JSONArray array = JSON.parseArray(items);
			for(java.util.Iterator<?> iter = array.iterator();iter.hasNext();) 
			{
				Map<?, ?> map = JSON.toJavaObject(JSON.parseObject(iter.next().toString()), Map.class);
				//System.out.println(JSON.toJSONString(map));
				String budgetInfoId = map.get("budgetInfoId").toString();
				Integer organId = new Integer(map.get("organId").toString());
				String organCode = map.get("organCode").toString();
				String nd = map.get("nd").toString();
				Integer budgetType = new Integer(map.get("budgetType").toString());
				String dataVersion = map.get("dataVersion").toString();
				String budgetTypeName = map.get("budgetTypeName").toString();
				
				List<SysDictionary> dis = selectTitleDic(nd);
				for(SysDictionary d:dis) 
				{
					String splitCode = d.getCode();
					Double jz = new Double(map.get(splitCode+"_jz").toString());
					Double xq = new Double(map.get(splitCode+"_xq").toString());
					Double total = jz+xq;
					BudgetSplitData split = selectBudgetSplitItemData(splitCode,organCode,budgetInfoId);
					if(split == null) {
						split = (BudgetSplitData)MyBeanUtils.createDefaultModel(BudgetSplitData.class);
					}
					split.setSplitName(d.getName());
					split.setNd(nd);
					split.setDataVersion(dataVersion);
					split.setBudgetType(budgetType);
					split.setBudgetTypeName(budgetTypeName);
					split.setBudgetInfoId(budgetInfoId);
					split.setOrganCode(organCode);
					split.setSplitCode(splitCode);
					split.setOrganId(organId);
					split.setPaymentType(1);//1拨款
					split.setJz(jz);
					split.setXq(xq);
					split.setTotal(total);
					saveOrUpdateBudgetSplitData(split);
					rs.add(split);
				}
				//计划数据
				BudgetSplitData split = selectBudgetSplitItemData("plan",organCode,budgetInfoId);
				if(split == null) {
					split = (BudgetSplitData)MyBeanUtils.createDefaultModel(BudgetSplitData.class);
				}
				Double jz = new Double(map.get("plan_jz").toString());
				Double xq = new Double(map.get("plan_xq").toString());
				Double total = jz+xq;
				
				split.setSplitName("计划");
				split.setBudgetType(budgetType);
				split.setNd(nd);
				split.setDataVersion(dataVersion);
				split.setBudgetType(budgetType);
				split.setBudgetTypeName(budgetTypeName);
				split.setBudgetInfoId(budgetInfoId);
				split.setOrganCode(organCode);
				split.setSplitCode("plan");
				split.setOrganId(organId);
				split.setPaymentType(0);//部门自筹
				split.setJz(jz);
				split.setXq(xq);
				split.setTotal(total);
				saveOrUpdateBudgetSplitData(split);
				rs.add(split);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public Map<String,Object> selectGroupSplitFinalItem(String nd,String organCode) {
		//检索已通过审核的预算
		BudgetInfoExample infoExample = new BudgetInfoExample();
		BudgetInfoExample.Criteria infoc = infoExample.createCriteria();
		infoc.andAuditStatusEqualTo(BudgetAuditStatusEnum.AUDIT_STATUS_FINAL.getCode());
		infoc.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		infoc.andBudgetTypeEqualTo(BudgetInfoEnum.GROUP_SPLIT.getCode());
		infoc.andNdEqualTo(nd);
		
		List<BudgetInfo> infos = budgetInfoMapper.selectByExample(infoExample);
		if(infos !=null && infos.size()>0) {
			BudgetInfo info = infos.get(0);
		
			BudgetSplitDataExample example = new BudgetSplitDataExample();
			BudgetSplitDataExample.Criteria c = example.createCriteria();
			c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
			c.andBudgetInfoIdEqualTo(info.getDataId());
			List<BudgetSplitData> datas = budgetSplitDataMapper.selectByExample(example);
			BudgetOrganEnum org = BudgetOrganEnum.getByCode(organCode);
			List<SysDictionary> dis = this.selectTitleDic(nd);
			
			return getRowData(info,org,dis,datas);
		}else {
			return new HashMap<String,Object>();
		}
	}
	@Override
	public Map<String,Object> selectGroupSplitItem(String budgetInfoId,String organCode) {
		
		BudgetInfo info = budgetInfoMapper.selectByPrimaryKey(budgetInfoId);
		
		BudgetSplitDataExample example = new BudgetSplitDataExample();
		BudgetSplitDataExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andBudgetInfoIdEqualTo(info.getDataId());
		List<BudgetSplitData> datas = budgetSplitDataMapper.selectByExample(example);
		BudgetOrganEnum org = BudgetOrganEnum.getByCode(organCode);
		List<SysDictionary> dis = this.selectTitleDic(info.getNd());
		
		return getRowData(info,org,dis,datas);
	}
	

	@Override
	public List<BudgetSplitData> selectBudgetSplitDataByInfoId(String budgetId) throws Exception 
	{
		BudgetSplitDataExample example = new BudgetSplitDataExample();
		BudgetSplitDataExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		c.andBudgetInfoIdEqualTo(budgetId);
		example.setOrderByClause("no");
		return budgetSplitDataMapper.selectByExample(example);
	}
	@Override
	public Map<String, List<OutProjectPlan>> selectComparePlanData(Set<String> codes, String nd) {
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

	@Override
	public Map<String, List<OutProjectInfo>> selectCompareProjectInfoData(Set<String> codes, String nd) {
		if(codes == null || codes.size() == 0) {
			return new HashMap<String,List<OutProjectInfo>>();
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

		LayuiTableData dt = systemRemoteClient.selectCommonProjectByCond(layuiParam);
		Map<String, List<OutProjectInfo>> rs = new HashMap<String,List<OutProjectInfo>>();
		for (java.util.Iterator<?> iter = dt.getData().iterator(); iter.hasNext();) {
			String planStr = JSON.toJSON(iter.next()).toString();
			OutProjectInfo plan = JSON.toJavaObject(JSON.parseObject(planStr), OutProjectInfo.class);

			if(!rs.containsKey(plan.getDefine9())) {
				rs.put(plan.getDefine9(), new ArrayList<OutProjectInfo>());
			}
			rs.get(plan.getDefine9()).add(plan);
		}
		return rs;
	}

	

}
