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
import com.pcitc.base.common.enums.BudgetOrganEnum;
import com.pcitc.base.common.enums.BudgetOrganNdEnum;
import com.pcitc.base.stp.budget.vo.BudgetSplitBaseDataVo;
import com.pcitc.base.stp.out.OutProjectPlan;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.service.budget.BudgetInfoService;
import com.pcitc.service.feign.SystemRemoteClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="预算-分解表数据",tags= {"预算-数据分解业务逻辑处理"})
@RestController
public class BudgetSplitDataProviderClient 
{
	@Autowired
	private BudgetInfoService budgetInfoService;
	
	@Resource
	private SystemRemoteClient systemRemoteClient;
	
	@ApiOperation(value="预算分解总表-集团预算分解总表",notes="集团预算分解总表")
	@RequestMapping(value = "/stp-provider/budget/get-final-groupsplit", method = RequestMethod.POST)
	public Object selectBudgetGroupSplitDataList(@RequestBody String nd) 
	{
		return budgetInfoService.selectGroupFinalSplit(nd);
	}
	@ApiOperation(value="预算分解总表-资产预算分解总表",notes="资产预算分解总表")
	@RequestMapping(value = "/stp-provider/budget/get-final-assetsplit", method = RequestMethod.POST)
	public Object selectBudgetAssetSplitDataList(@RequestBody String nd) 
	{
		return budgetInfoService.selectAssetFinalSplit(nd);
	}
	@ApiOperation(value="预算分解总表-股份预算分解总表",notes="股份预算分解总表")
	@RequestMapping(value = "/stp-provider/budget/get-final-stocksplit", method = RequestMethod.POST)
	public Object selectBudgetStockSplitDataList(@RequestBody String nd) 
	{
		return budgetInfoService.selectStockFinalSplit(nd);
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
