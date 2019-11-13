package com.pcitc.service.outApi.impl;

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
import com.pcitc.base.stp.out.OutProjectInfoNoticeTemplate;
import com.pcitc.base.stp.out.OutProjectInfoNoticeTemplateExample;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.mapper.outApi.OutProjectInfoNoticeTemplateMapper;
import com.pcitc.service.outApi.OutProjectInfoNoticeTemplateService;
/**
 * 
 * @author uuy
 *
 */
@Service("outProjectInfoNoticeTemplateService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class OutProjectInfoNoticeTemplateServiceImpl implements OutProjectInfoNoticeTemplateService
{

	@Autowired
	public OutProjectInfoNoticeTemplateMapper mapper;
	

	@Override
	public OutProjectInfoNoticeTemplate selectOutProjectInfoNoticeTemplate(String dataId) 
	{
		return mapper.selectByPrimaryKey(dataId);
	}
	@Override
	public Result saveOutProjectInfoNoticeTemplate(OutProjectInfoNoticeTemplate bean) throws Exception 
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
	public Result updateOutProjectInfoNoticeTemplate(OutProjectInfoNoticeTemplate budgetMoneyTotal) throws Exception 
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
	public Result deleteOutProjectInfoNoticeTemplate(String id) throws Exception 
	{
		OutProjectInfoNoticeTemplate b = mapper.selectByPrimaryKey(id);
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
	public Result deleteOutProjectInfoNoticeTemplateReal(String id) throws Exception 
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
	public Result saveOrUpdOutProjectInfoNoticeTemplate(OutProjectInfoNoticeTemplate bean) throws Exception 
	{
		Boolean status =  false;
		try {
			OutProjectInfoNoticeTemplateExample example = new OutProjectInfoNoticeTemplateExample();
			OutProjectInfoNoticeTemplateExample.Criteria c = example.createCriteria();
			c.andDataIdEqualTo(bean.getDataId());
			List<OutProjectInfoNoticeTemplate> organs = mapper.selectByExample(example);
			if(organs == null || organs.size()==0) 
			{
				bean.setDelFlag(DelFlagEnum.STATUS_NORMAL.getCode());
				return this.saveOutProjectInfoNoticeTemplate(bean);
			}else {
				OutProjectInfoNoticeTemplate old = organs.get(0);
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
	public List<OutProjectInfoNoticeTemplate> selectListOutProjectInfoNoticeTemplate() 
	{
		OutProjectInfoNoticeTemplateExample example = new OutProjectInfoNoticeTemplateExample();
		return mapper.selectByExample(example);
	}
	@Override
	public LayuiTableData selectTableOutProjectInfoNoticeTemplate(LayuiTableParam param) 
	{
		OutProjectInfoNoticeTemplateExample example = new OutProjectInfoNoticeTemplateExample();
		/*if(!StringUtils.isBlank((String)param.getParam().get("criterionchname"))) 
		{
			example.createCriteria().andCriterionchnameLike("%"+param.getParam().get("criterionchname")+"%");
		}
		example.setOrderByClause("criterionchname");*/
		return selectTableData(param, example);
	}
	@Override
	public List<OutProjectInfoNoticeTemplate> selectListOutProjectInfoNoticeTemplateByBean(OutProjectInfoNoticeTemplate bean) 
	{
		OutProjectInfoNoticeTemplateExample example = new OutProjectInfoNoticeTemplateExample();
		/*OutProjectInfoNoticeTemplateExample.Criteria c = example.createCriteria();
		if(!StringUtils.isBlank(bean.getNd())) 
		{
			c.andNdEqualTo(bean.getNd());
		}*/
		return mapper.selectByExample(example);
	}
	
	private LayuiTableData selectTableData(LayuiTableParam param,OutProjectInfoNoticeTemplateExample example)
	{
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		
		List<OutProjectInfoNoticeTemplate> list = mapper.selectByExample(example);
		// 3、获取分页查询后的数据
		PageInfo<OutProjectInfoNoticeTemplate> pageInfo= new PageInfo<OutProjectInfoNoticeTemplate>(list);
		// 3、获取分页查询后的数据
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}
	
}
