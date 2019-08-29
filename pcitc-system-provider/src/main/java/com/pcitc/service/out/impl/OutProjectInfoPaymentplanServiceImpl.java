package com.pcitc.service.out.impl;

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
import com.pcitc.base.stp.out.OutProjectInfoPaymentplan;
import com.pcitc.base.stp.out.OutProjectInfoPaymentplanExample;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.mapper.out.OutProjectInfoPaymentplanMapper;
import com.pcitc.service.out.OutProjectInfoPaymentplanService;
/**
 * 
 * @author uuy
 *
 */
@Service("outProjectInfoPaymentplanService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class OutProjectInfoPaymentplanServiceImpl implements OutProjectInfoPaymentplanService
{

	@Autowired
	public OutProjectInfoPaymentplanMapper mapper;
	

	@Override
	public OutProjectInfoPaymentplan selectOutProjectInfoPaymentplan(String dataId) 
	{
		return mapper.selectByPrimaryKey(dataId);
	}
	@Override
	public Result saveOutProjectInfoPaymentplan(OutProjectInfoPaymentplan bean) throws Exception 
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
	public Result updateOutProjectInfoPaymentplan(OutProjectInfoPaymentplan budgetMoneyTotal) throws Exception 
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
	public Result deleteOutProjectInfoPaymentplan(String id) throws Exception 
	{
		OutProjectInfoPaymentplan b = mapper.selectByPrimaryKey(id);
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
	public Result deleteOutProjectInfoPaymentplanReal(String id) throws Exception 
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
	public Result saveOrUpdOutProjectInfoPaymentplan(OutProjectInfoPaymentplan bean) throws Exception 
	{
		Boolean status =  false;
		try {
			OutProjectInfoPaymentplanExample example = new OutProjectInfoPaymentplanExample();
			OutProjectInfoPaymentplanExample.Criteria c = example.createCriteria();
		
			c.andNdEqualTo(bean.getNd());
			List<OutProjectInfoPaymentplan> organs = mapper.selectByExample(example);
			if(organs == null || organs.size()==0) 
			{
				bean.setDelFlag(DelFlagEnum.STATUS_NORMAL.getCode());
				return this.saveOutProjectInfoPaymentplan(bean);
			}else {
				OutProjectInfoPaymentplan old = organs.get(0);
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
	public List<OutProjectInfoPaymentplan> selectListOutProjectInfoPaymentplan() 
	{
		OutProjectInfoPaymentplanExample example = new OutProjectInfoPaymentplanExample();
		return mapper.selectByExample(example);
	}
	@Override
	public LayuiTableData selectTableOutProjectInfoPaymentplan(LayuiTableParam param) 
	{
		OutProjectInfoPaymentplanExample example = new OutProjectInfoPaymentplanExample();
		OutProjectInfoPaymentplanExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		if(!StringUtils.isBlank(param.getParam().get("nd")+"")) 
		{
			c.andNdEqualTo(param.getParam().get("nd")+"");
		}
		example.setOrderByClause("no");
		return selectTableData(param, example);
	}
	@Override
	public List<OutProjectInfoPaymentplan> selectListOutProjectInfoPaymentplanByBean(OutProjectInfoPaymentplan bean) 
	{
		OutProjectInfoPaymentplanExample example = new OutProjectInfoPaymentplanExample();
		OutProjectInfoPaymentplanExample.Criteria c = example.createCriteria();
		if(!StringUtils.isBlank(bean.getNd())) 
		{
			c.andNdEqualTo(bean.getNd());
		}
		return mapper.selectByExample(example);
	}
	
	private LayuiTableData selectTableData(LayuiTableParam param,OutProjectInfoPaymentplanExample example)
	{
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		
		List<OutProjectInfoPaymentplan> list = mapper.selectByExample(example);
		// 3、获取分页查询后的数据
		PageInfo<OutProjectInfoPaymentplan> pageInfo= new PageInfo<OutProjectInfoPaymentplan>(list);
		// 3、获取分页查询后的数据
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}
	
	
}
