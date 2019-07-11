package com.pcitc.service.budget.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.mapper.budget.BudgetBaseMapper;

public class BaseServiceImpl<Bean, PK extends Serializable,Example>
{
	@Autowired
	public BudgetBaseMapper<Bean, PK, Example> mapper;

	public Bean selectByPrimaryKey(PK id)
	{
		return mapper.selectByPrimaryKey(id);
	}
	
	public Boolean updateBean(Bean bean) throws Exception
	{
		try 
		{
			Integer rs = mapper.updateByPrimaryKey(bean);
			if(rs >0) 
			{
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Boolean deleteBean(PK id) throws Exception
	{
		Bean b = mapper.selectByPrimaryKey(id);
		try{
			if(b != null){
				Map<String,Object> map = MyBeanUtils.transBean2Map(b);
				map.put("delFlag", DelFlagEnum.STATUS_DEL.getCode());
				MyBeanUtils.transMap2Bean(map,b);
				Integer rs = mapper.updateByPrimaryKey(b);
				if(rs > 0) {
					return true;
				}else {
					return false;
				}
			}else {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Boolean saveBean(Bean bean) throws Exception
	{
		try {
			Integer rs = mapper.insert(bean);
			if(rs > 0) {
				return true;
			}else {
				return false;
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public Boolean saveOrUpdBean(PK id,Bean bean) throws Exception 
	{
		try {
			Bean old = this.selectByPrimaryKey(id);
			if(old == null) 
			{
				this.saveBean(bean);
			}else {
				MyBeanUtils.copyPropertiesIgnoreNull(bean, old);
				this.updateBean(old);
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public LayuiTableData selectTableData(LayuiTableParam param,Example e)
	{
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		System.out.println(e.getClass().getName());
		//System.out.println(mapper.getClass().getName());
		//System.out.println(mapper.getClass().getTypeName());
		List<Bean> list = mapper.selectByExample(e);
		// 3、获取分页查询后的数据
		PageInfo<Bean> pageInfo= new PageInfo<Bean>(list);
		// 3、获取分页查询后的数据
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}
	
	public List<Bean> selectListData(Example e)
	{
		return mapper.selectByExample(e);
	}
}
