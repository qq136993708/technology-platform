package com.pcitc.web.budget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.enums.BudgetInfoEnum;
import com.pcitc.base.common.enums.BudgetOrganEnum;
import com.pcitc.base.common.enums.BudgetOrganNdEnum;
import com.pcitc.base.common.enums.BudgetStockEnum;
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.base.stp.budget.BudgetMoneyTotal;
import com.pcitc.base.stp.budget.BudgetSplitData;
import com.pcitc.base.stp.budget.vo.BudgetItemSearchVo;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.service.budget.BudgetInfoService;
import com.pcitc.service.budget.BudgetMoneyTotalService;
import com.pcitc.service.feign.SystemRemoteClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="预算-预算数据检索",tags= {"预算-预算管理数据对外接口"})
@RestController
public class BudgetSplitManagerProviderClient 
{
	
	@Autowired
	private BudgetInfoService budgetInfoService;
	
	@Autowired
	private BudgetMoneyTotalService budgetMoneyTotalService;
	
	//@Autowired
	//private BudgetMoneyDecomposeService budgetMoneyDecomposeService;
	
	
	@Resource
	private SystemRemoteClient systemRemoteClient;
	
	@ApiOperation(value="预算管理-获取预算总数",notes="获取年度预算总数（包括资本性，费用性）")
	@RequestMapping(value = "/stp-provider/budget/out-budget-total", method = RequestMethod.POST)
	public Object selectBudgetTotal(@RequestBody BudgetItemSearchVo vo) 
	{
		BudgetMoneyTotal bean = new BudgetMoneyTotal();
		bean.setNd(vo.getNd());
		//取预算总表数据
		Double totalmoney = 0d;
		List<BudgetMoneyTotal> datas = budgetMoneyTotalService.selectListBudgetMoneyTotalByBean(bean);
		List<BudgetMoneyTotal> list = datas.stream()
				.filter(a -> a.getBudgetCode() == null)
				.collect(Collectors.toList());
		for(BudgetMoneyTotal total:list) 
		{
			totalmoney += (Double.valueOf(total.getZbxMoney())+Double.valueOf(total.getFyxMoney()));
		}
		//BigDecimal b = new BigDecimal(totalmoney);
		//totalmoney = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();	
		java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.00");  
		return df.format(totalmoney);
	}
	
	@ApiOperation(value="预算管理-获取预算项数据",notes="按年度、处部门、预算对象获取预算详情")
	@RequestMapping(value = "/stp-provider/budget/out-organ-items", method = RequestMethod.POST)
	public Object selectBudgetInfoList(@RequestBody BudgetItemSearchVo vo) 
	{
		List<Map<String,Object>> rsdata = new ArrayList<Map<String,Object>>();
		try
		{
			//检索预算项数据
			List<BudgetSplitData> datas = getFinalBudgetSplitData(vo.getNd());
			//如果不传入预算项
			if(vo.getBudgetItemCodes().size() == 0) 
			{
				vo.setBudgetItemCodes(getBudgetItemCodes(vo.getNd()));
			}
			//如果不传入预算部门
			if(vo.getUnitIds().size() == 0) 
			{
				vo.setUnitIds(getBudgetUnitIds(vo.getNd()));
			}
			
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
					}else if(BudgetStockEnum.SPLIT_GROUP_TOTAL.getUnitCode().equals(itemCode)) 
					{
						//集团单位
						List<SysDictionary> dis = systemRemoteClient.getDictionaryListByParentCode(BudgetStockEnum.SPLIT_GROUP_TOTAL.getCode()+vo.getNd());
						for(SysDictionary d:dis) 
						{
							codes.add(d.getCode());
						}
						
					}else if(BudgetStockEnum.SPLIT_ASSET_TOTAL.getUnitCode().equals(itemCode)) 
					{
						//资产单位
						List<SysDictionary> dis = systemRemoteClient.getDictionaryListByParentCode(BudgetStockEnum.SPLIT_ASSET_TOTAL.getCode()+vo.getNd());
						for(SysDictionary d:dis) 
						{
							codes.add(d.getCode());
						}
					}else {
						codes.add(BudgetStockEnum.getByUnitCode(itemCode).getCode());
					}
					BudgetOrganEnum organ = BudgetOrganEnum.getByUnitCode(unitId);
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("unitId", unitId);
					map.put("unitName", organ.getName());
					map.put("budgetItemCode", itemCode);
					map.put("budgetItemName", BudgetStockEnum.getByUnitCode(itemCode).getName());
					map.put("total", 0d);
					map.put("jz", 0d);
					map.put("xq", 0d);
					
					List<BudgetSplitData> list = datas.stream()
							.filter(a -> a.getOrganCode().equals(organ.getCode()))
							.filter(a -> codes.contains(a.getSplitCode()))
							.collect(Collectors.toList());
					if(list != null && list.size()>0) 
					{
						for(BudgetSplitData dt:list) 
						{
							map.put("total", (Double)map.get("total")+dt.getTotal());
							map.put("jz", (Double)map.get("jz")+dt.getJz());
							map.put("xq", (Double)map.get("xq")+dt.getXq());
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
	
	private List<BudgetSplitData> getFinalBudgetSplitData(String nd) 
	{
		List<String> infos = new ArrayList<String>();
		for(BudgetInfoEnum v:BudgetInfoEnum.values()) 
		{
			BudgetInfo info = budgetInfoService.selectFinalBudget(nd,v.getCode());
			if(info != null) {
				infos.add(info.getDataId());
			}
		}
		//检索预算项数据
		return budgetInfoService.selectSplitDataByNd(nd,infos);
	}
	//获得预算项及预算项下面的编码列表【直属院：下面有8个，股份下面有N个，集团下面有N个】
	private List<String> getBudgetItemCodes(String nd)
	{
		List<String> list = new ArrayList<String>();
		for(BudgetStockEnum enums:BudgetStockEnum.values()) 
		{
			if(enums.getId()<3000) {//直属院只统计“直属研究院”
				list.add(enums.getUnitCode());
			}
		}
		return list;
	}
	private List<String> getBudgetUnitIds(String nd)
	{
		List<String> list = new ArrayList<String>();
		List<BudgetOrganEnum> organs = BudgetOrganNdEnum.getByNd(nd).getOrgans();
		for(BudgetOrganEnum enums:organs) 
		{
			list.add(enums.getUnitCode());
		}
		return list;
	}
}
