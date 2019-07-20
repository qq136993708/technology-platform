package com.pcitc.service.budget.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.stp.budget.BudgetOrganItems;
import com.pcitc.base.stp.budget.BudgetOrganItemsExample;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.mapper.budget.BudgetOrganItemsMapper;
import com.pcitc.service.budget.BudgetOrganItemsService;
/**
 * 
 * @author fb
 *
 */
@Service("budgetOrganItemsService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class BudgetOrganItemsServiceImpl  implements BudgetOrganItemsService
{

	@Autowired
	public BudgetOrganItemsMapper mapper;
	

	@Override
	public BudgetOrganItems selectBudgetOrganItems(String dataId) 
	{
		return mapper.selectByPrimaryKey(dataId);
	}
	@Override
	public Result saveBudgetOrganItems(BudgetOrganItems bean) throws Exception 
	{
		Boolean status = false;
		try 
		{
			Integer rs = mapper.insert(bean);
			if(rs > 0) {
				status = true;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return new Result(status);
	}
	@Override
	public Result updateBudgetOrganItems(BudgetOrganItems budgetMoneyTotal) throws Exception 
	{
		Boolean status = false;
		try 
		{
			Integer rs = mapper.updateByPrimaryKey(budgetMoneyTotal);
			if(rs > 0) 
			{
				status = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new Result(status);
	}
	@Override
	public Result deleteBudgetOrganItems(String id) throws Exception 
	{
		BudgetOrganItems b = mapper.selectByPrimaryKey(id);
		Boolean status = false;
		try{
			if(b != null){
				Map<String,Object> map = MyBeanUtils.transBean2Map(b);
				map.put("delFlag", DelFlagEnum.STATUS_DEL.getCode());
				MyBeanUtils.transMap2Bean(map,b);
				Integer rs = mapper.updateByPrimaryKey(b);
				if(rs > 0) {
					status = true;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new Result(status);
	}
	@Override
	public Result deleteBudgetOrganItemsReal(String id) throws Exception 
	{
		Boolean status = false;
		try
		{
			Integer rs = mapper.deleteByPrimaryKey(id);
			if(rs > 0) {
				status = true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new Result(status);
	}
	@Override
	public Result saveOrUpdBudgetOrganItems(BudgetOrganItems bean) throws Exception 
	{
		Boolean status =  false;
		try {
			BudgetOrganItems old = mapper.selectByPrimaryKey(bean.getDataId());
			if(old == null) 
			{
				bean.setDelFlag(DelFlagEnum.STATUS_NORMAL.getCode());
				bean.setDataId((bean.getOrganId()+1000)+"");
				return this.saveBudgetOrganItems(bean);
			}else {
				MyBeanUtils.copyPropertiesIgnoreNull(bean, old);
				Integer rs = mapper.updateByPrimaryKey(old);
				if(rs > 0) {
					status = true;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return new Result(status);
	}
	@Override
	public List<BudgetOrganItems> selectListBudgetOrganItems() 
	{
		BudgetOrganItemsExample example = new BudgetOrganItemsExample();
		return mapper.selectByExample(example);
	}
	@Override
	public LayuiTableData selectTableBudgetOrganItems(LayuiTableParam param) 
	{
		BudgetOrganItemsExample example = new BudgetOrganItemsExample();
		BudgetOrganItemsExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		
		example.setOrderByClause("organ_id");
		return selectTableData(param, example);
	}
	@Override
	public List<BudgetOrganItems> selectListBudgetOrganItemsByBean(BudgetOrganItems bean) 
	{
		BudgetOrganItemsExample example = new BudgetOrganItemsExample();
		
		
		return mapper.selectByExample(example);
	}
	
	private LayuiTableData selectTableData(LayuiTableParam param,BudgetOrganItemsExample example)
	{
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		
		List<BudgetOrganItems> list = mapper.selectByExample(example);
		// 3、获取分页查询后的数据
		PageInfo<BudgetOrganItems> pageInfo= new PageInfo<BudgetOrganItems>(list);
		// 3、获取分页查询后的数据
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}
	
}
