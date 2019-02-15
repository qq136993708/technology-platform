package com.pcitc.web.budget;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.budget.BudgetGroupTotal;
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.base.stp.out.OutUnit;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.common.BudgetInfoEnum;
import com.pcitc.service.budget.BudgetGroupTotalService;
import com.pcitc.service.budget.BudgetInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="预算-年度预算（集团）总表",tags= {"预算-年度集团预算总表"})
@RestController
public class BudgetGroupTotalProviderClient 
{
	
	private final static Logger logger = LoggerFactory.getLogger(BudgetGroupTotalProviderClient.class);

	
	@Autowired
	private BudgetGroupTotalService budgetGroupTotalService;
	
	@Autowired
	private BudgetInfoService budgetInfoService;
	
	@ApiOperation(value="预算管理-预算列表",notes="按年检索年度集团预算表信息。")
	@RequestMapping(value = "/stp-provider/budget/budget-grouptotal-info-list", method = RequestMethod.POST)
	public Object selectBudgetGroupTotalInfoList(@RequestBody BudgetInfo info) 
	{
		logger.info("budget-info-list...");
		List<BudgetInfo> data = null;
		try
		{
			System.out.println(JSON.toJSONString(info.getNd()));
			data = budgetInfoService.selectBudgetInfoList(info.getNd(),BudgetInfoEnum.GROUP_TOTAL.getCode());
			System.out.println(JSON.toJSONString(data));
			return data;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	@ApiOperation(value="预算管理-预算列表",notes="按年检索年度集团预算表信息。")
	@RequestMapping(value = "/stp-provider/budget/budget-grouptotal-info-table", method = RequestMethod.POST)
	public Object selectBudgetGroupTotalInfoTable(@RequestBody LayuiTableParam param) 
	{
		logger.info("budget-grouptotal-info-list...");
		LayuiTableData data = null;
		try
		{
			System.out.println(JSON.toJSONString(param));
			param.getParam().put("budget_type", BudgetInfoEnum.GROUP_TOTAL.getCode());
			data = budgetInfoService.selectBudgetInfoPage(param);
			System.out.println(JSON.toJSONString(data));
			return data;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	@ApiOperation(value="预算明细列表检索",notes="按年检索年度集团预算总表明细。")
	@RequestMapping(value = "/stp-provider/budget/budget-grouptotal-items", method = RequestMethod.POST)
	public Object selectGroupTotalItemList(@RequestBody LayuiTableParam param) 
	{
		logger.info("select-budget-grouptotal-items...");
		LayuiTableData data = null;
		try
		{
			System.out.println(JSON.toJSONString(param));
			data = budgetGroupTotalService.selectBudgetGroupTotalPage(param);
			System.out.println(JSON.toJSONString(data));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	@ApiOperation(value="添加预算项",notes="添加集团预算总表项目明细。")
	@RequestMapping(value = "/stp-provider/budget/budget-persistence-grouptotal-item", method = RequestMethod.POST)
	public Object addOrUpdateGroupTotalItem(@RequestBody BudgetGroupTotal budgetGroupTotal) 
	{
		logger.info("add-budget-grouptotal-item...");
		Integer rs = 0;
		try
		{
			System.out.println(JSON.toJSONString(budgetGroupTotal));
			rs = budgetGroupTotalService.saveOrUpdateBudgetGroupTotal(budgetGroupTotal);
			System.out.println(JSON.toJSONString(rs));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	@ApiOperation(value="预算管理-创建集团年度预算表",notes="创建集团年度预算空白表")
	@RequestMapping(value = "/stp-provider/budget/budget-create-blank-grouptotal", method = RequestMethod.POST)
	public Object createOrUpdateBudgetInfo(@RequestBody BudgetInfo info) 
	{
		logger.info("budget-create-blank-grouptotal...");
		BudgetInfo rsbean = null;
		try
		{
			System.out.println(JSON.toJSONString(info.getNd()));
			rsbean = budgetInfoService.createBlankBudgetInfo(info.getNd(), BudgetInfoEnum.GROUP_TOTAL.getCode());
			System.out.println(JSON.toJSONString(rsbean));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rsbean;
	}
	@ApiOperation(value="预算管理-创建集团年度预算表",notes="根据模板创建集团年度预算表")
	@RequestMapping(value = "/stp-provider/budget/budget-create-template-grouptotal", method = RequestMethod.POST)
	public Object createOrUpdateBudgetInfoByHis(@RequestBody BudgetInfo info) 
	{
		logger.info("budget-create-blank-grouptotal...");
		BudgetInfo newInfo = null;
		try
		{
			System.out.println(JSON.toJSONString(info.getNd()));
			BudgetInfo oldInfo = budgetInfoService.selectBudgetInfo(info.getDataId());
			
			newInfo = budgetInfoService.createBlankBudgetInfo(info.getNd(),BudgetInfoEnum.GROUP_TOTAL.getCode());
			//获取模板数据
			List<BudgetGroupTotal> templates = budgetGroupTotalService.selectBudgetInfoId(info.getDataId());
			Map<String,String> idRel = new HashMap<String,String>();//新老ID对照
			for(BudgetGroupTotal total:templates) 
			{
				String newId = IdUtil.createIdByTime();
				idRel.put(total.getDataId(), newId);
				
				total.setBudgetInfoId(newInfo.getDataId());
				total.setDataVersion(newInfo.getDataVersion());
				total.setDataId(newId);
				total.setUpdateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
				total.setCreateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
				budgetGroupTotalService.saveOrUpdateBudgetGroupTotal(total);
			}
			//处理二级预算单位
			for(BudgetGroupTotal total:templates) 
			{
				if(total.getLevel()>0 && total.getParentDataId() != null) {
					total.setParentDataId(idRel.get(total.getParentDataId()));
					budgetGroupTotalService.updateBudgetGroupTotal(total);
				}
			}
			newInfo.setBudgetMoney(oldInfo.getBudgetMoney());
			budgetInfoService.updateBudgetInfo(newInfo);
			System.out.println(JSON.toJSONString(newInfo));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return newInfo;
	}
	@ApiOperation(value="预算管理-创建集团年度预算表",notes="删除集团年度预算空白表")
	@RequestMapping(value = "/stp-provider/budget/budget-grouptotal-del", method = RequestMethod.POST)
	public Object deleteBudgetGroupTotalInfo(@RequestBody BudgetInfo info) 
	{
		logger.info("budget-delete-grouptotal...");
		Integer rs = 0;
		try
		{
			System.out.println(JSON.toJSONString(info.getNd()));
			rs += budgetInfoService.deleteBudgetInfo(info.getDataId());
			rs += budgetGroupTotalService.deleteBudgetGroupTotalByInfo(info.getDataId());
			System.out.println(JSON.toJSONString(rs));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	@ApiOperation(value="预算管理-检索年度预算项详情",notes="检索预算项包括子项详情")
	@RequestMapping(value = "/stp-provider/budget/get-grouptotal-item/{itemId}", method = RequestMethod.POST)
	public Object selectBudgetGroupTotalInfo(@PathVariable("itemId") String itemId) 
	{
		logger.info("budget-select-grouptotal...");
		Map<String,Object> map = new HashMap<String,Object>();
		try
		{
			System.out.println(JSON.toJSONString(itemId));
			BudgetGroupTotal groupTotal = budgetGroupTotalService.selectBudgetGroupTotal(itemId);
			if(groupTotal != null) {
				List<BudgetGroupTotal> childGroups = budgetGroupTotalService.selectChildBudgetGroupTotal(itemId);
				map  = MyBeanUtils.transBean2Map(groupTotal);
				map.put("groups", childGroups);
				System.out.println(JSON.toJSONString(map));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return map;
	}
	@ApiOperation(value="预算管理-保存年度预算项详情",notes="保存预算项包括子项详情")
	@RequestMapping(value = "/stp-provider/budget/save-grouptotal-item", method = RequestMethod.POST)
	public Object saveBudgetGroupTotalInfo(@RequestBody BudgetGroupTotal item) 
	{
		logger.info("budget-save-grouptotal...");
		Integer rs = 0;
		try
		{
			BudgetInfo info = budgetInfoService.selectBudgetInfo(item.getBudgetInfoId());
			System.out.println(JSON.toJSONString(item));
			BudgetGroupTotal groupTotal = budgetGroupTotalService.selectBudgetGroupTotal(item.getDataId());
			if(groupTotal != null) {
				MyBeanUtils.copyPropertiesIgnoreNull(item, groupTotal);
				groupTotal.setUpdateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
				rs += budgetGroupTotalService.updateBudgetGroupTotal(groupTotal);
			}else {
				item.setLevel(0);
				item.setNd(info.getNd());
				item.setCreateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
				item.setUpdateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
				item.setDataVersion(info.getDataVersion());
				rs += budgetGroupTotalService.saveOrUpdateBudgetGroupTotal(item);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	@ApiOperation(value="预算管理-检索集团公司",notes="检索集团公司列表")
	@RequestMapping(value = "/stp-provider/budget/search-group-company-items", method = RequestMethod.POST)
	public Object selectBudgetGroupItems() 
	{
		logger.info("search-group-items...");
		List<OutUnit> units = null;
		try
		{
			units = budgetGroupTotalService.selectJtUnits();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return units;
	}
}
