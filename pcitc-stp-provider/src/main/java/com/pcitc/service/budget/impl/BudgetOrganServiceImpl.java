package com.pcitc.service.budget.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.budget.BudgetOrgan;
import com.pcitc.base.stp.budget.BudgetOrganExample;
import com.pcitc.service.budget.BudgetOrganService;
/**
 * 
 * @author uuy
 *
 */
@Service("budgetOrganService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class BudgetOrganServiceImpl  extends BaseServiceImpl<BudgetOrgan,String,BudgetOrganExample>  implements BudgetOrganService
{

	@Override
	public BudgetOrgan selectBudgetOrgan(String dataId) 
	{
		return this.selectByPrimaryKey(dataId);
	}
	@Override
	public Result saveBudgetOrgan(BudgetOrgan bean) throws Exception 
	{
		Boolean status = this.saveBean(bean);
		
		return new Result(status);
	}
	@Override
	public Result updateBudgetOrgan(BudgetOrgan budgetOrgan) throws Exception 
	{
		Boolean status =  this.updateBean(budgetOrgan);
		
		return new Result(status);
	}
	@Override
	public Result deleteBudgetOrgan(String id) throws Exception 
	{
		Boolean status =  this.deleteBean(id);
		
		return new Result(status);
	}
	@Override
	public Result saveOrUpdBudgetOrgan(BudgetOrgan bean) throws Exception 
	{
		Boolean status =  this.saveOrUpdBean(bean.getDataId(),bean);
		
		return new Result(status);
	}
	@Override
	public List<BudgetOrgan> selectListBudgetOrgan() 
	{
		BudgetOrganExample example = new BudgetOrganExample();
		return this.selectListData(example);
	}
	@Override
	public LayuiTableData selectTableBudgetOrgan(LayuiTableParam param) 
	{
		/*BudgetOrganExample example = new BudgetOrganExample();
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		
		List<BudgetOrgan> list = mapper.selectByExample(example);
		// 3、获取分页查询后的数据
		PageInfo<BudgetOrgan> pageInfo= new PageInfo<BudgetOrgan>(list);
		// 3、获取分页查询后的数据
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;*/
		
		
		BudgetOrganExample example = new BudgetOrganExample();
		return this.selectTableData(param, example);
	}
	@Override
	public List<BudgetOrgan> selectListBudgetOrganByBean(BudgetOrgan bean) 
	{
		BudgetOrganExample example = new BudgetOrganExample();
		return this.selectListData(example);
	}
	
	
}
