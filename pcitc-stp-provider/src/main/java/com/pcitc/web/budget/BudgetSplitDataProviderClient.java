package com.pcitc.web.budget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.pcitc.base.common.enums.BudgetInfoEnum;
import com.pcitc.base.common.enums.BudgetOrganEnum;
import com.pcitc.base.common.enums.BudgetOrganNdEnum;
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.base.stp.budget.vo.BudgetSplitBaseDataVo;
import com.pcitc.base.stp.out.OutProjectPlan;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.service.budget.BudgetAssetSplitService;
import com.pcitc.service.budget.BudgetGroupSplitService;
import com.pcitc.service.budget.BudgetInfoService;
import com.pcitc.service.budget.BudgetStockSplitXtwSplitService;
import com.pcitc.service.budget.BudgetStockSplitZgsSplitService;
import com.pcitc.service.budget.BudgetStockSplitZsySplitService;
import com.pcitc.service.feign.SystemRemoteClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="预算-分解表数据",tags= {"预算-数据分解业务逻辑处理"})
@RestController
public class BudgetSplitDataProviderClient 
{
	@Autowired
	private BudgetStockSplitXtwSplitService budgetStockSplitXtwSplitService;
	
	@Autowired
	private BudgetStockSplitZgsSplitService budgetStockSplitZgsSplitService;
	
	@Autowired
	private BudgetStockSplitZsySplitService budgetStockSplitZsySplitService;
	
	@Autowired
	private BudgetGroupSplitService budgetGroupSplitService;
	
	@Autowired
	private BudgetAssetSplitService budgetAssetSplitService;
	
	@Autowired
	private BudgetInfoService budgetInfoService;
	
	@Resource
	private SystemRemoteClient systemRemoteClient;
	
	@ApiOperation(value="预算分解总表-集团预算分解总表",notes="集团预算分解总表")
	@RequestMapping(value = "/stp-provider/budget/get-final-groupsplit", method = RequestMethod.POST)
	public Object selectBudgetGroupSplitDataList(@RequestBody String nd) 
	{
		List<Map<String,Object>> rsdata = new ArrayList<Map<String,Object>>();
		try
		{
			//最终预算
			BudgetInfo fInfo = budgetInfoService.selectFinalBudget(nd,BudgetInfoEnum.GROUP_SPLIT.getCode());
			if(fInfo == null) {
				fInfo = budgetInfoService.selectBudgetInfoList(nd,BudgetInfoEnum.GROUP_SPLIT.getCode()).get(0);
			}
			List<Map<String,Object>> list = budgetGroupSplitService.selectBudgetSplitDataList(fInfo == null?"xxx":fInfo.getDataId());
			
			for(int i = 0;i<list.size();i++) {
				Map<String,Object> rowmap = new HashMap<String,Object>();
				rowmap.put("no", list.get(i).get("no"));
				rowmap.put("organCode", list.get(i).get("organCode"));
				rowmap.put("organName", list.get(i).get("organName"));
				rowmap.put("group_jz", (Double)list.get(i).get("total_jz"));
				rowmap.put("group_xq", (Double)list.get(i).get("total_xq"));
				rowmap.put("group_total", (Double)list.get(i).get("total"));
			
				rsdata.add(rowmap);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rsdata;
	}
	@ApiOperation(value="预算分解总表-资产预算分解总表",notes="资产预算分解总表")
	@RequestMapping(value = "/stp-provider/budget/get-final-assetsplit", method = RequestMethod.POST)
	public Object selectBudgetAssetSplitDataList(@RequestBody String nd) 
	{
		List<Map<String,Object>> rsdata = new ArrayList<Map<String,Object>>();
		try
		{
			//最终预算
			BudgetInfo fInfo = budgetInfoService.selectFinalBudget(nd,BudgetInfoEnum.ASSET_SPLIT.getCode());
			if(fInfo == null) {
				fInfo = budgetInfoService.selectBudgetInfoList(nd,BudgetInfoEnum.ASSET_SPLIT.getCode()).get(0);
			}
			
			
			List<Map<String,Object>> list = budgetAssetSplitService.selectBudgetSplitDataList(fInfo == null?"xxx":fInfo.getDataId());
			for(int i = 0;i<list.size();i++) {
				Map<String,Object> rowmap = new HashMap<String,Object>();
				rowmap.put("no", list.get(i).get("no"));
				rowmap.put("organCode", list.get(i).get("organCode"));
				rowmap.put("organName", list.get(i).get("organName"));
				rowmap.put("asset_jz", (Double)list.get(i).get("total_jz"));
				rowmap.put("asset_xq", (Double)list.get(i).get("total_xq"));
				rowmap.put("asset_total", (Double)list.get(i).get("total"));
			
				rsdata.add(rowmap);
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rsdata;
	}
	@ApiOperation(value="预算分解总表-股份预算分解总表",notes="股份预算分解总表")
	@RequestMapping(value = "/stp-provider/budget/get-final-stocksplit", method = RequestMethod.POST)
	public Object selectBudgetStockSplitDataList(@RequestBody String nd) 
	{
		List<Map<String,Object>> rsdata = new ArrayList<Map<String,Object>>();
		try
		{
			BudgetInfo xtwInfo = budgetInfoService.selectFinalBudget(nd,BudgetInfoEnum.STOCK_XTY_SPLIT.getCode());
			BudgetInfo zgsInfo = budgetInfoService.selectFinalBudget(nd,BudgetInfoEnum.STOCK_ZGS_SPLIT.getCode());
			BudgetInfo zsyInfo = budgetInfoService.selectFinalBudget(nd,BudgetInfoEnum.STOCK_ZSY_SPLIT.getCode());
			if(xtwInfo == null) {
				xtwInfo = budgetInfoService.selectBudgetInfoList(nd,BudgetInfoEnum.STOCK_XTY_SPLIT.getCode()).get(0);
			}if(zgsInfo == null) {
				zgsInfo = budgetInfoService.selectBudgetInfoList(nd,BudgetInfoEnum.STOCK_ZGS_SPLIT.getCode()).get(0);
			}if(zsyInfo == null) {
				zsyInfo = budgetInfoService.selectBudgetInfoList(nd,BudgetInfoEnum.STOCK_ZSY_SPLIT.getCode()).get(0);
			}
			
			List<Map<String,Object>> xtw = budgetStockSplitXtwSplitService.selectBudgetSplitDataList(xtwInfo==null?"xxx":xtwInfo.getDataId());
			List<Map<String,Object>> zgs = budgetStockSplitZgsSplitService.selectBudgetSplitDataList(zgsInfo == null?"xxx":zgsInfo.getDataId());
			List<Map<String,Object>> zsy = budgetStockSplitZsySplitService.selectBudgetSplitDataList(zsyInfo == null?"xxx":zsyInfo.getDataId());
			for(int i = 0;i<xtw.size();i++) {
				Map<String,Object> rowmap = new HashMap<String,Object>();
				rowmap.put("no", xtw.get(i).get("no"));
				rowmap.put("organCode", xtw.get(i).get("organCode"));
				rowmap.put("organName", xtw.get(i).get("organName"));
				rowmap.put("stock_jz", (Double)xtw.get(i).get("total_jz")+(Double)zgs.get(i).get("total_jz")+(Double)zsy.get(i).get("total_jz"));
				rowmap.put("stock_xq", (Double)xtw.get(i).get("total_xq")+(Double)zgs.get(i).get("total_xq")+(Double)zsy.get(i).get("total_xq"));
				rowmap.put("stock_total", (Double)xtw.get(i).get("total")+(Double)zgs.get(i).get("total")+(Double)zsy.get(i).get("total"));
			
				rsdata.add(rowmap);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rsdata;
	}
	
	@ApiOperation(value="预算分解结转数据-获取预算分解结转数据",notes="按处部门和预算项获取分解数据")
	@RequestMapping(value = "/stp-provider/budget/get-split-plandata/{nd}", method = RequestMethod.POST)
	public Object selectBudgetSplitPlanData(@PathVariable("nd") String nd,@RequestBody Map<String,Set<String>> items) 
	{
		List<Map<String,Object>> rsdata = new ArrayList<Map<String,Object>>();
		try
		{
			Map<String,Map<String,Double>> itemPlanMap = new HashMap<String,Map<String,Double>>();
			for(java.util.Iterator<String> iter = items.keySet().iterator();iter.hasNext();) {
				String itemCode = iter.next();//预算项代码
				Map<String,List<OutProjectPlan>> planMap = budgetInfoService.selectBudgetPlanData(items.get(itemCode),nd);
				//按处部门名称汇总
				List<OutProjectPlan> planList = new ArrayList<OutProjectPlan>();
				for(java.util.Iterator<String> pit = planMap.keySet().iterator();pit.hasNext();) {
					planList.addAll(planMap.get(pit.next()));
				}
				
				//按出部門分組
				Map<String,Double> itemmap = new HashMap<String,Double>();
				for(OutProjectPlan plan:planList) {
					String unitName = plan.getDefine9();
					if(!itemmap.containsKey(unitName)) {
						itemmap.put(unitName, 0d);
					}
					itemmap.put(unitName, itemmap.get(unitName)+new Double(plan.getYsje()==null?"0":plan.getJssj()));
				}
				//map:Map<预算项代码,Map<处部门名称,计划金额>>;
				itemPlanMap.put(itemCode, itemmap);
			}
			//预算项数据处理
			List<BudgetOrganEnum> organs = BudgetOrganNdEnum.getByNd(nd).getOrgans();
			for(BudgetOrganEnum org:organs) {
				BudgetSplitBaseDataVo vo = new BudgetSplitBaseDataVo();
				vo.setOrganId(org.getId());
				vo.setOrganCode(org.getCode());
				vo.setOrganName(org.getName());
				Map<String,Object> map  = MyBeanUtils.transBean2Map(vo);
				
				for(java.util.Iterator<String> iter = items.keySet().iterator();iter.hasNext();) {
					String itemCode = iter.next();
					map.put(itemCode+"_jz", 0d);
					
					if(itemPlanMap.containsKey(itemCode)) {
						if(itemPlanMap.get(itemCode).containsKey(org.getName())) {
							map.put(itemCode+"_jz", itemPlanMap.get(itemCode).get(org.getName()));
						}
					}
				}
				rsdata.add(map);
			}
			System.out.println(JSON.toJSONString(rsdata));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rsdata;
	}
}
