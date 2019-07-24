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
import com.pcitc.base.stp.budget.BudgetRealPayMoney;
import com.pcitc.base.stp.budget.BudgetRealPayMoneyExample;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.mapper.budget.BudgetRealPayMoneyMapper;
import com.pcitc.service.budget.BudgetRealPayMoneyService;
/**
 * 
 * @author fb
 *
 */
@Service("budgetRealPayMoneyService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class BudgetRealPayMoneyServiceImpl  implements BudgetRealPayMoneyService
{
	@Autowired
	public BudgetRealPayMoneyMapper mapper;
	

	@Override
	public BudgetRealPayMoney selectBudgetRealPayMoney(String dataId) 
	{
		return mapper.selectByPrimaryKey(dataId);
	}
	@Override
	public Result saveBudgetRealPayMoney(BudgetRealPayMoney bean) throws Exception 
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
	public Result updateBudgetRealPayMoney(BudgetRealPayMoney budgetRealPayMoney) throws Exception 
	{
		Boolean status = false;
		try 
		{
			Integer rs = mapper.updateByPrimaryKey(budgetRealPayMoney);
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
	public Result deleteBudgetRealPayMoney(String id) throws Exception 
	{
		BudgetRealPayMoney b = mapper.selectByPrimaryKey(id);
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
	public Result deleteBudgetRealPayMoneyReal(String id) throws Exception 
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
	public Result saveOrUpdBudgetRealPayMoney(BudgetRealPayMoney bean) throws Exception 
	{
		Boolean status =  false;
		try {
			BudgetRealPayMoney old = mapper.selectByPrimaryKey(bean.getDataId());
			if(old == null) 
			{
				return this.saveBudgetRealPayMoney(bean);
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
	public List<BudgetRealPayMoney> selectListBudgetRealPayMoney() 
	{
		BudgetRealPayMoneyExample example = new BudgetRealPayMoneyExample();
		return mapper.selectByExample(example);
	}
	@Override
	public LayuiTableData selectTableBudgetRealPayMoney(LayuiTableParam param) 
	{
		BudgetRealPayMoneyExample example = new BudgetRealPayMoneyExample();
		return selectTableData(param, example);
	}
	@Override
	public List<BudgetRealPayMoney> selectListBudgetRealPayMoneyByBean(BudgetRealPayMoney bean) 
	{
		BudgetRealPayMoneyExample example = new BudgetRealPayMoneyExample();
		BudgetRealPayMoneyExample.Criteria c = example.createCriteria();
		if(bean.getNd() != null) 
		{
			c.andNdEqualTo(bean.getNd());
		} 
		example.setOrderByClause("create_time desc");
		return mapper.selectByExample(example);
	}
	
	private LayuiTableData selectTableData(LayuiTableParam param,BudgetRealPayMoneyExample e)
	{
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		
		List<BudgetRealPayMoney> list = mapper.selectByExample(e);
		// 3、获取分页查询后的数据
		PageInfo<BudgetRealPayMoney> pageInfo= new PageInfo<BudgetRealPayMoney>(list);
		// 3、获取分页查询后的数据
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}
	
}
