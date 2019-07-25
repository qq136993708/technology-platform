package com.pcitc.service.budget.impl;

import java.util.Date;
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
import com.pcitc.base.stp.budget.BudgetOtherPayMoney;
import com.pcitc.base.stp.budget.BudgetOtherPayMoneyExample;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.mapper.budget.BudgetOtherPayMoneyMapper;
import com.pcitc.service.budget.BudgetOtherPayMoneyService;
/**
 * 
 * @author fb
 *
 */
@Service("budgetOtherPayMoneyService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class BudgetOtherPayMoneyServiceImpl  implements BudgetOtherPayMoneyService
{
	@Autowired
	public BudgetOtherPayMoneyMapper mapper;
	

	@Override
	public BudgetOtherPayMoney selectBudgetOtherPayMoney(String dataId) 
	{
		return mapper.selectByPrimaryKey(dataId);
	}
	@Override
	public Result saveBudgetOtherPayMoney(BudgetOtherPayMoney bean) throws Exception 
	{
		Boolean status = false;
		try 
		{
			bean.setDelFlag(DelFlagEnum.STATUS_NORMAL.getCode());
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
	public Result updateBudgetOtherPayMoney(BudgetOtherPayMoney budgetOtherPayMoney) throws Exception 
	{
		Boolean status = false;
		try 
		{
			Integer rs = mapper.updateByPrimaryKey(budgetOtherPayMoney);
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
	public Result deleteBudgetOtherPayMoney(String id) throws Exception 
	{
		BudgetOtherPayMoney b = mapper.selectByPrimaryKey(id);
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
	public Result deleteBudgetOtherPayMoneyReal(String id) throws Exception 
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
	public Result saveOrUpdBudgetOtherPayMoney(BudgetOtherPayMoney bean) throws Exception 
	{
		Boolean status =  false;
		try {
			BudgetOtherPayMoney old = mapper.selectByPrimaryKey(bean.getDataId());
			bean.setDelFlag(DelFlagEnum.STATUS_NORMAL.getCode());
			bean.setUpdateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
			if(old == null) 
			{
				bean.setCreateTime(DateUtil.format(new Date(), DateUtil.FMT_SS));
				return this.saveBudgetOtherPayMoney(bean);
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
	public List<BudgetOtherPayMoney> selectListBudgetOtherPayMoney() 
	{
		BudgetOtherPayMoneyExample example = new BudgetOtherPayMoneyExample();
		return mapper.selectByExample(example);
	}
	@Override
	public LayuiTableData selectTableBudgetOtherPayMoney(LayuiTableParam param) 
	{
		BudgetOtherPayMoneyExample example = new BudgetOtherPayMoneyExample();
		BudgetOtherPayMoneyExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		
		return selectTableData(param, example);
	}
	@Override
	public List<BudgetOtherPayMoney> selectListBudgetOtherPayMoneyByBean(BudgetOtherPayMoney bean) 
	{
		BudgetOtherPayMoneyExample example = new BudgetOtherPayMoneyExample();
		BudgetOtherPayMoneyExample.Criteria c = example.createCriteria();
		if(bean.getNd() != null) 
		{
			c.andNdEqualTo(bean.getNd());
		} 
		example.setOrderByClause("nd DESC,create_time DESC");
		return mapper.selectByExample(example);
	}
	
	private LayuiTableData selectTableData(LayuiTableParam param,BudgetOtherPayMoneyExample e)
	{
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		
		List<BudgetOtherPayMoney> list = mapper.selectByExample(e);
		// 3、获取分页查询后的数据
		PageInfo<BudgetOtherPayMoney> pageInfo= new PageInfo<BudgetOtherPayMoney>(list);
		// 3、获取分页查询后的数据
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}
	
}
