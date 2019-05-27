package com.pcitc.service.intlproject.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.stp.IntlProject.IntlProjectInfo;
import com.pcitc.base.stp.IntlProject.IntlProjectRemark;
import com.pcitc.base.stp.IntlProject.IntlProjectRemarkExample;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.mapper.IntlProject.IntlProjectInfoMapper;
import com.pcitc.mapper.IntlProject.IntlProjectRemarkMapper;
import com.pcitc.service.intlproject.IntlProjectRemarkService;

@Service("intlProjectRemarkService")
public class IntlProjectRemarkServiceImpl implements IntlProjectRemarkService {

	@Autowired
	private IntlProjectRemarkMapper intlProjectRemarkMapper;
	
	//@Autowired
	//private IntlProjectApplyMapper intlProjectApplyMapper;
	
	@Autowired
	private IntlProjectInfoMapper intlProjectInfoMapper;
	
	@Override
	public LayuiTableData selectProjectRemarkByPage(LayuiTableParam param) 
	{
		IntlProjectRemarkExample example = new IntlProjectRemarkExample();
		IntlProjectRemarkExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		if(param.getParam().get("remarkTitle") !=null && !StringUtils.isBlank(param.getParam().get("remarkTitle").toString())) 
		{
			c.andRemarkTitleLike("%"+param.getParam().get("remarkTitle")+"%");
		}
		LayuiTableData data =  this.findByExample(param, example);
		//数据处理，分组转换
		List<Object> datalist = new ArrayList<Object>();
		Map<String,IntlProjectInfo> projectMap = new HashMap<String,IntlProjectInfo>();
		for(java.util.Iterator<?> iter = data.getData().iterator();iter.hasNext();) 
		{
			Map<String,Object> map = MyBeanUtils.transBean2Map(iter.next());
			if(!projectMap.containsKey(map.get("projectId"))) 
			{
				//IntlProjectApply apply = intlProjectApplyMapper.selectByPrimaryKey(map.get("projectId").toString());
				IntlProjectInfo info =  intlProjectInfoMapper.selectByPrimaryKey(map.get("projectId").toString());
				projectMap.put(map.get("projectId").toString(),info);
				Map<String,Object> titleMap = new HashMap<String,Object>();
				titleMap.put("id", map.get("projectId").toString());
				titleMap.put("pId", "1001");
				
				
				titleMap.put("authorPhone", "联系电话"); 
            	titleMap.put("remarkTitle", "---纪要标题--"); 
            	titleMap.put("remarkContent", "--纪要内容--"); 
            	titleMap.put("createTime", "纪要日期"); 
            	titleMap.put("projectId", "项目纪要-"+info.getProjectName()); 
            	titleMap.put("remarkPeople", "负责人"); 
            	titleMap.put("remarkType", "纪要类别");
            	titleMap.put("lay_che_disabled", true); 

				
				
				datalist.add(titleMap);
			}
			map.put("pId", map.get("projectId").toString());
			map.put("id", map.get("remarkId").toString());
			map.put("projectId", projectMap.get(map.get("projectId").toString()).getProjectName());
			
			
			datalist.add(map);
		}
		data.setData(datalist);
		return data;
	}

	@Override
	public IntlProjectRemark findProjectRemark(String remarkId) 
	{
		IntlProjectRemarkExample example = new IntlProjectRemarkExample();
		IntlProjectRemarkExample.Criteria c = example.createCriteria();
		c.andRemarkIdEqualTo(remarkId);
		List<IntlProjectRemark> remarks = intlProjectRemarkMapper.selectByExample(example);
		if(remarks != null && remarks.size() >0) 
		{
			return remarks.get(0);
		}
		return null; 
	}

	@Override
	public Integer saveProjectRemark(IntlProjectRemark remark) 
	{
		return intlProjectRemarkMapper.insert(remark);
	}

	@Override
	public Integer updProjectRemark(IntlProjectRemark remark) 
	{
		IntlProjectRemarkExample example = new IntlProjectRemarkExample();
		IntlProjectRemarkExample.Criteria c = example.createCriteria();
		c.andRemarkIdEqualTo(remark.getRemarkId());
		
		return intlProjectRemarkMapper.updateByExample(remark, example);
	}

	@Override
	public Integer delProjectRemark(String remarkId) 
	{
		IntlProjectRemark remark = this.findProjectRemark(remarkId);
		remark.setDelFlag(DelFlagEnum.STATUS_DEL.getCode());
		
		
		IntlProjectRemarkExample example = new IntlProjectRemarkExample();
		IntlProjectRemarkExample.Criteria c = example.createCriteria();
		c.andRemarkIdEqualTo(remark.getRemarkId());
		
		return intlProjectRemarkMapper.updateByExample(remark, example);
	}

	@Override
	public Integer delProjectRemarkReal(String remarkId) 
	{
		IntlProjectRemarkExample example = new IntlProjectRemarkExample();
		IntlProjectRemarkExample.Criteria c = example.createCriteria();
		c.andRemarkIdEqualTo(remarkId);
		
		return intlProjectRemarkMapper.deleteByExample(example);
	}
	private LayuiTableData findByExample(LayuiTableParam param,IntlProjectRemarkExample example) 
	{
		int pageSize = param.getLimit();
		int pageStart = (param.getPage()-1)*pageSize;
		int pageNum = pageStart/pageSize + 1;
		PageHelper.startPage(pageNum, pageSize);
		List<IntlProjectRemark> list = intlProjectRemarkMapper.selectByExample(example);
		PageInfo<IntlProjectRemark> pageInfo= new PageInfo<IntlProjectRemark>(list);
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}
}
