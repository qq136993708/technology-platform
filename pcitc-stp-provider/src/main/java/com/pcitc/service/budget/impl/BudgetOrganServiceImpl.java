package com.pcitc.service.budget.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
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
import com.pcitc.base.stp.budget.BudgetOrgan;
import com.pcitc.base.stp.budget.BudgetOrganExample;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.mapper.budget.BudgetOrganMapper;
import com.pcitc.service.budget.BudgetOrganService;
/**
 * 
 * @author uuy
 *
 */
@Service("budgetOrganService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class BudgetOrganServiceImpl implements BudgetOrganService
{

	@Autowired
	public BudgetOrganMapper mapper;
	

	@Override
	public BudgetOrgan selectBudgetOrgan(String dataId) 
	{
		return mapper.selectByPrimaryKey(dataId);
	}
	@Override
	public Result saveBudgetOrgan(BudgetOrgan bean) throws Exception 
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
	public Result updateBudgetOrgan(BudgetOrgan budgetMoneyTotal) throws Exception 
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
	public Result deleteBudgetOrgan(String id) throws Exception 
	{
		BudgetOrgan b = mapper.selectByPrimaryKey(id);
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
	public Result deleteBudgetOrganReal(String id) throws Exception 
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
	public Result saveOrUpdBudgetOrgan(BudgetOrgan bean) throws Exception 
	{
		Boolean status =  false;
		try {
			BudgetOrganExample example = new BudgetOrganExample();
			BudgetOrganExample.Criteria c = example.createCriteria();
			c.andOrganIdEqualTo(bean.getOrganId());
			c.andNdEqualTo(bean.getNd());
			List<BudgetOrgan> organs = mapper.selectByExample(example);
			if(organs == null || organs.size()==0) 
			{
				//生成data_id
				example = new BudgetOrganExample();
				example.setOrderByClause("data_id desc");
				organs = mapper.selectByExample(example);
				String dataId = "1001";
				if(organs != null && organs.size() > 0) 
				{
					dataId = (new Integer(organs.get(0).getDataId())+1)+"";
				}
				bean.setDataId(dataId);
				bean.setDelFlag(DelFlagEnum.STATUS_NORMAL.getCode());
				return this.saveBudgetOrgan(bean);
			}else {
				BudgetOrgan old = organs.get(0);
				MyBeanUtils.copyPropertiesIgnoreNull(bean, old);
				old.setDelFlag(DelFlagEnum.STATUS_NORMAL.getCode());
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
	public List<BudgetOrgan> selectListBudgetOrgan() 
	{
		BudgetOrganExample example = new BudgetOrganExample();
		return mapper.selectByExample(example);
	}
	@Override
	public LayuiTableData selectTableBudgetOrgan(LayuiTableParam param) 
	{
		BudgetOrganExample example = new BudgetOrganExample();
		BudgetOrganExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		if(!StringUtils.isBlank(param.getParam().get("nd")+"")) 
		{
			c.andNdEqualTo(param.getParam().get("nd")+"");
		}
		example.setOrderByClause("no");
		return selectTableData(param, example);
	}
	@Override
	public List<BudgetOrgan> selectListBudgetOrganByBean(BudgetOrgan bean) 
	{
		BudgetOrganExample example = new BudgetOrganExample();
		BudgetOrganExample.Criteria c = example.createCriteria();
		if(!StringUtils.isBlank(bean.getNd())) 
		{
			c.andNdEqualTo(bean.getNd());
		}
		return mapper.selectByExample(example);
	}
	
	private LayuiTableData selectTableData(LayuiTableParam param,BudgetOrganExample example)
	{
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
		return data;
	}
	
	
}
