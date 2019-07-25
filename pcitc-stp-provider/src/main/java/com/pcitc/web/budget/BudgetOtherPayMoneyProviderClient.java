package com.pcitc.web.budget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.BudgetOrganEnum;
import com.pcitc.base.common.enums.BudgetOrganNdEnum;
import com.pcitc.base.common.enums.BudgetStockEnum;
import com.pcitc.base.common.enums.BudgetStockNdEnum;
import com.pcitc.base.stp.budget.BudgetOtherPayMoney;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.service.budget.BudgetOtherPayMoneyService;
import com.pcitc.service.feign.SystemRemoteClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="预算-支出管理",tags= {"预算-专项机动支出管理"})
@RestController
public class BudgetOtherPayMoneyProviderClient 
{

	@Autowired
	private BudgetOtherPayMoneyService budgetOtherPayMoneyService;
	
	
	@Resource
	private SystemRemoteClient systemRemoteClient;
	
	@ApiOperation(value="支出管理-检索支出项",notes="根据ID检索支出项!")
	@RequestMapping(value = "/stp-provider/budget/budget-otherpaymoney-get/{dataId}", method = RequestMethod.POST)
	public Object selectBudgetOtherPayMoneyById(@PathVariable("dataId") String dataId) 
	{
		BudgetOtherPayMoney organ = null;
		try 
		{
			organ = budgetOtherPayMoneyService.selectBudgetOtherPayMoney(dataId);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return organ;
	}
	
	@ApiOperation(value="支出管理-支出项列表",notes="获取支出项列表。")
	@RequestMapping(value = "/stp-provider/budget/budget-otherpaymoney-list", method = RequestMethod.POST)
	public Object selectBudgetOtherPayMoneyList(@RequestBody BudgetOtherPayMoney bean) 
	{
		List<Map<String,Object>> rsdata = new ArrayList<Map<String,Object>>();
		try
		{
			List<BudgetOtherPayMoney> datalist = budgetOtherPayMoneyService.selectListBudgetOtherPayMoneyByBean(bean);
			for(BudgetOtherPayMoney dt:datalist) {
				Map<String,Object> map = MyBeanUtils.transBean2Map(dt);
				//map.put("auditStatusDesc", BudgetAuditStatusEnum.getStatusByCode(dt.getAuditStatus()).getDesc());
				rsdata.add(map);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rsdata;
	}
	@ApiOperation(value="支出管理-预算分页列表",notes="获取支出项列表（带分页）。")
	@RequestMapping(value = "/stp-provider/budget/budget-otherpaymoney-table", method = RequestMethod.POST)
	public Object selectBudgetOtherPayMoneyTable(@RequestBody LayuiTableParam param) 
	{
		LayuiTableData data = null;
		try
		{
			data = budgetOtherPayMoneyService.selectTableBudgetOtherPayMoney(param);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	@ApiOperation(value="支出管理-支出项保存",notes="保存支出项")
	@RequestMapping(value = "/stp-provider/budget/budget-otherpaymoney-save", method = RequestMethod.POST)
	public Object saveBudgetOtherPayMoney(@RequestBody BudgetOtherPayMoney bean) 
	{
		Result rs = new Result(false);
		try
		{
			rs = budgetOtherPayMoneyService.saveBudgetOtherPayMoney(bean);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	@ApiOperation(value="支出管理-支出项更新",notes="更新支出项")
	@RequestMapping(value = "/stp-provider/budget/budget-otherpaymoney-upd", method = RequestMethod.POST)
	public Object updBudgetOtherPayMoney(@RequestBody BudgetOtherPayMoney bean) 
	{
		Result rs = new Result(false);
		try
		{
			rs = budgetOtherPayMoneyService.updateBudgetOtherPayMoney(bean);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}

	@ApiOperation(value="支出管理-支出项保存或更新",notes="支出项保存或更新")
	@RequestMapping(value = "/stp-provider/budget/budget-otherpaymoney-saveorupd", method = RequestMethod.POST)
	public Object saveOrUpdBudgetOtherPayMoney(@RequestBody BudgetOtherPayMoney bean) 
	{
		Result rs = new Result(false);
		try
		{
			rs = budgetOtherPayMoneyService.saveOrUpdBudgetOtherPayMoney(bean);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
	@ApiOperation(value="支出管理-支出项删除",notes="支出项删除")
	@RequestMapping(value = "/stp-provider/budget/budget-otherpaymoney-del/{dataId}", method = RequestMethod.POST)
	public Object delBudgetOtherPayMoney(@PathVariable("dataId") String dataId) 
	{
		Result rs = new Result(false);
		try
		{
			rs = budgetOtherPayMoneyService.deleteBudgetOtherPayMoney(dataId);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	@ApiOperation(value="支出管理-支出项字典",notes="检索支出项字典!")
	@RequestMapping(value = "/stp-provider/budget/budget-otherpaymoney-organ-dic/{nd}", method = RequestMethod.POST)
	public Object selectBudgetOtherPayMoneyOrganDic(@PathVariable("nd") String nd) 
	{
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		try 
		{
			List<BudgetOrganEnum> organs = BudgetOrganNdEnum.getByNd(nd).getOrgans();
			for(BudgetOrganEnum e:organs) 
			{
				if(!e.getCode().equals(BudgetOrganEnum.ORG_ZX.getCode()) && !e.getCode().equals(BudgetOrganEnum.ORG_JD.getCode())) 
				{
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("code", e.getCode());
					map.put("name", e.getName());
					list.add(map);
				}
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return list;
	}
	@ApiOperation(value="支出管理-支出项字典",notes="检索支出项字典!")
	@RequestMapping(value = "/stp-provider/budget/budget-otherpaymoney-split-dic/{nd}", method = RequestMethod.POST)
	public Object selectBudgetOtherPayMoneySplitDic(@PathVariable("nd") String nd) 
	{
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		try 
		{
			//集团单位
			List<SysDictionary> groupDics = systemRemoteClient.getDictionaryListByParentCode(BudgetStockEnum.SPLIT_GROUP_TOTAL.getCode()+nd);
			//资产单位
			groupDics.addAll(systemRemoteClient.getDictionaryListByParentCode(BudgetStockEnum.SPLIT_ASSET_TOTAL.getCode()+nd));
			for(SysDictionary dic:groupDics) {
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("code", dic.getCode());
				map.put("name", dic.getName());
				list.add(map);
			}
			List<BudgetStockEnum> bs = new ArrayList<BudgetStockEnum>();
			//股份公司
			bs.addAll(BudgetStockNdEnum.getStockSplitZsyByNd(nd).getSplits());
			bs.addAll(BudgetStockNdEnum.getStockSplitZgsByNd(nd).getSplits());
			bs.addAll(BudgetStockNdEnum.getStockSplitXtwByNd(nd).getSplits());
			for(BudgetStockEnum b:bs) 
			{
				Map<String,Object> map = new HashMap<String,Object>();
				
				map.put("code", b.getCode());
				map.put("name", b.getName());
				list.add(map);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return list;
	}
}
