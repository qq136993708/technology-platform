package com.pcitc.web.budget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.enums.BudgetInfoEnum;
import com.pcitc.base.common.enums.BudgetOrganEnum;
import com.pcitc.base.common.enums.BudgetStockEnum;
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.base.stp.budget.BudgetSplitData;
import com.pcitc.base.stp.budget.vo.BudgetItemSearchVo;
import com.pcitc.service.budget.BudgetInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="预算-预算数据检索",tags= {"预算-预算管理数据对外接口"})
@RestController
public class BudgetSplitManagerProviderClient 
{
	
	@Autowired
	private BudgetInfoService budgetInfoService;
	
	
	@ApiOperation(value="预算管理-获取预算项数据",notes="按年度、处部门、预算对象获取预算详情")
	@RequestMapping(value = "/stp-provider/budget/out-organ-items", method = RequestMethod.POST)
	public Object selectBudgetInfoList(@RequestBody BudgetItemSearchVo vo) 
	{
		List<Map<String,Object>> rsdata = new ArrayList<Map<String,Object>>();
		try
		{
			List<String> infos = new ArrayList<String>();
			//获得审批通过的所有预算表
			for(BudgetInfoEnum v:BudgetInfoEnum.values()) 
			{
				BudgetInfo info = budgetInfoService.selectFinalBudget(vo.getNd(),v.getCode());
				if(info != null) {
					infos.add(info.getDataId());
				}
			}
			//检索预算项数据
			List<BudgetSplitData> datas = budgetInfoService.selectSplitDataByNd(vo.getNd(),infos);
			for(java.util.Iterator<String> uiter = vo.getUnitIds().iterator();uiter.hasNext();) 
			{
				String unitId = uiter.next();//部门编码
				for(java.util.Iterator<String> biter = vo.getBudgetItemCodes().iterator();biter.hasNext();) 
				{
					String itemCode = biter.next();
					Set<String> codes = new HashSet<String>();
					//如果是研究院
					if(BudgetStockEnum.SPLIT_STOCK_YJY.getUnitCode().equals(itemCode)) 
					{
						codes.add(BudgetStockEnum.SPLIT_STOCK_YJY_KTY.getCode());
						codes.add(BudgetStockEnum.SPLIT_STOCK_YJY_GCY.getCode());
						codes.add(BudgetStockEnum.SPLIT_STOCK_YJY_WTY.getCode());
						codes.add(BudgetStockEnum.SPLIT_STOCK_YJY_SKY.getCode());
						codes.add(BudgetStockEnum.SPLIT_STOCK_YJY_FSY.getCode());
						codes.add(BudgetStockEnum.SPLIT_STOCK_YJY_BHY.getCode());
						codes.add(BudgetStockEnum.SPLIT_STOCK_YJY_SHY.getCode());
						codes.add(BudgetStockEnum.SPLIT_STOCK_YJY_AGY.getCode());
					}else {
						codes.add(BudgetStockEnum.getByUnitCode(itemCode).getCode());
					}
					BudgetOrganEnum organ = BudgetOrganEnum.getByUnitCode(unitId);
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("unitId", unitId);
					map.put("budgetItemCode", itemCode);
					map.put("total", 0d);
					map.put("jz", 0d);
					map.put("xq", 0d);
					if(organ != null) 
					{
						Optional<BudgetSplitData> dt = datas.stream()
								.filter(a -> a.getOrganCode().equals(organ.getCode()))
								.filter(a -> codes.contains(a.getSplitCode()))
								.findFirst();
						if(dt != null && dt.isPresent()) 
						{
							map.put("total", dt.get().getTotal());
							map.put("jz", dt.get().getJz());
							map.put("xq", dt.get().getXq());
							
						}
					}
					rsdata.add(map);
				}
			}
			vo.setRsItems(rsdata);
			return vo;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rsdata;
	}
	
}
