package com.pcitc.service.outApi.impl;

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
import com.pcitc.base.stp.out.OutStandardData;
import com.pcitc.base.stp.out.OutStandardDataExample;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.mapper.outApi.OutStandardDataMapper;
import com.pcitc.service.outApi.OutStandardDataService;
/**
 * 
 * @author uuy
 *
 */
@Service("outStandardDataService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class OutStandardDataServiceImpl implements OutStandardDataService
{

	@Autowired
	public OutStandardDataMapper mapper;
	

	@Override
	public OutStandardData selectOutStandardData(String dataId) 
	{
		return mapper.selectByPrimaryKey(dataId);
	}
	@Override
	public Result saveOutStandardData(OutStandardData bean) throws Exception 
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
	public Result updateOutStandardData(OutStandardData budgetMoneyTotal) throws Exception 
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
	public Result deleteOutStandardData(String id) throws Exception 
	{
		OutStandardData b = mapper.selectByPrimaryKey(id);
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
	public Result deleteOutStandardDataReal(String id) throws Exception 
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
	public Result saveOrUpdOutStandardData(OutStandardData bean) throws Exception 
	{
		Boolean status =  false;
		try {
			OutStandardDataExample example = new OutStandardDataExample();
			OutStandardDataExample.Criteria c = example.createCriteria();
			c.andDataIdEqualTo(bean.getDataId());
			List<OutStandardData> organs = mapper.selectByExample(example);
			if(organs == null || organs.size()==0) 
			{
				bean.setDelFlag(DelFlagEnum.STATUS_NORMAL.getCode());
				return this.saveOutStandardData(bean);
			}else {
				OutStandardData old = organs.get(0);
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
	public List<OutStandardData> selectListOutStandardData() 
	{
		OutStandardDataExample example = new OutStandardDataExample();
		return mapper.selectByExample(example);
	}
	@Override
	public LayuiTableData selectTableOutStandardData(LayuiTableParam param) 
	{
		OutStandardDataExample example = new OutStandardDataExample();
		if(!StringUtils.isBlank((String)param.getParam().get("criterionchname"))) 
		{
			example.createCriteria().andCriterionchnameLike("%"+param.getParam().get("criterionchname")+"%");
		}
		example.setOrderByClause("criterionchname");
		return selectTableData(param, example);
	}
	@Override
	public List<OutStandardData> selectListOutStandardDataByBean(OutStandardData bean) 
	{
		OutStandardDataExample example = new OutStandardDataExample();
		OutStandardDataExample.Criteria c = example.createCriteria();
		if(!StringUtils.isBlank(bean.getNd())) 
		{
			c.andNdEqualTo(bean.getNd());
		}
		return mapper.selectByExample(example);
	}
	
	private LayuiTableData selectTableData(LayuiTableParam param,OutStandardDataExample example)
	{
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		
		List<OutStandardData> list = mapper.selectByExample(example);
		// 3、获取分页查询后的数据
		PageInfo<OutStandardData> pageInfo= new PageInfo<OutStandardData>(list);
		// 3、获取分页查询后的数据
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}
	@Override
	public Integer selectOutStandardDataCount() {
		OutStandardDataExample example = new OutStandardDataExample();
		Long count = mapper.countByExample(example);
		System.out.println("0000:"+count);
		return count.intValue();
	}
	
	
}
