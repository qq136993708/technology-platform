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
import com.pcitc.base.stp.IntlProject.IntlProjectResult;
import com.pcitc.base.stp.IntlProject.IntlProjectResultExample;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.mapper.IntlProject.IntlProjectInfoMapper;
import com.pcitc.mapper.IntlProject.IntlProjectResultMapper;
import com.pcitc.service.intlproject.IntlProjectResultService;

@Service("intlProjectResultService")
public class IntlProjectResultServiceImpl implements IntlProjectResultService {

	@Autowired
	private IntlProjectResultMapper intlProjectResultMapper;
	
	
	
	@Autowired
	private IntlProjectInfoMapper intlProjectInfoMapper;
	
	@Override
	public LayuiTableData selectProjectReultByPage(LayuiTableParam param) {
		IntlProjectResultExample example = new IntlProjectResultExample();
		IntlProjectResultExample.Criteria c = example.createCriteria();
		c.andDelFlagEqualTo(DelFlagEnum.STATUS_NORMAL.getCode());
		if(param.getParam().get("resultName") != null && !StringUtils.isBlank(param.getParam().get("resultName").toString())) 
		{
			c.andResultTitleLike("%"+param.getParam().get("resultName")+"%");
		}
		example.setOrderByClause("create_time desc");
		LayuiTableData data =  this.findByExample(param, example);
		
		//数据处理，分组转换
		List<Object> datalist = new ArrayList<Object>();
		Map<String,IntlProjectInfo> projectMap = new HashMap<String,IntlProjectInfo>();
		for(java.util.Iterator<?> iter = data.getData().iterator();iter.hasNext();) 
		{
			Map<String,Object> map = MyBeanUtils.transBean2Map(iter.next());
			if(!projectMap.containsKey(map.get("projectId"))) 
			{
				//IntlProjectApply apply = intlProjectInfoMapper.selectByPrimaryKey(map.get("projectId").toString());
				IntlProjectInfo info = intlProjectInfoMapper.selectByPrimaryKey(map.get("projectId").toString());
				
				projectMap.put(map.get("projectId").toString(),info);
				Map<String,Object> titleMap = new HashMap<String,Object>();
				titleMap.put("id", map.get("projectId").toString());
				titleMap.put("pId", "1001");
				
				
				/*,{field:'resultTitle',   title:'名称',	width: '12%',  style:'cursor: pointer;'}
                ,{field:'resultContent',   title:'主要内容',	width: '20%',  style:'cursor: pointer;'}	                
                ,{field:'resultCode',title:'项目编码',	width: '10%',   style:'cursor: pointer;'}
                ,{field:'resultType',   title:'成果类型',	width: '10%',  style:'cursor: pointer;'}
                ,{field:'resultAuthor',title:'负责人',	width: '10%', style:'cursor: pointer;'}
                ,{field:'authorPhone',title:'负责人联系电话',	style:'cursor: pointer;'}	 */
				
				titleMap.put("projectId", "项目成果-"+info.getProjectName()); 
				titleMap.put("resultTitle", ""); //----
            	titleMap.put("resultContent", "");//---- 
            	titleMap.put("resultCode", ""); //项目编码
            	titleMap.put("resultType", ""); //成果类型
            	titleMap.put("resultAuthor", ""); //负责人
            	titleMap.put("authorPhone", ""); //负责人联系电话
            	titleMap.put("lay_che_disabled", true); 
            	
            	
				datalist.add(titleMap);
			}
			map.put("pId", map.get("projectId").toString());
			map.put("id", "0");
			map.put("projectId", projectMap.get(map.get("projectId").toString()).getProjectName());
			
			datalist.add(map);
		}
		data.setData(datalist);
		return data;
	}

	@Override
	public IntlProjectResult findProjectResult(String resultId) 
	{
		IntlProjectResultExample example = new IntlProjectResultExample();
		IntlProjectResultExample.Criteria c = example.createCriteria();
		c.andResultIdEqualTo(resultId);
		
		List<IntlProjectResult> resultlist = intlProjectResultMapper.selectByExample(example);
		return resultlist.get(0);
	}

	@Override
	public Integer saveProjectResult(IntlProjectResult result) 
	{
		return intlProjectResultMapper.insert(result);
	}

	@Override
	public Integer updProjectResult(IntlProjectResult result) 
	{
		IntlProjectResultExample example = new IntlProjectResultExample();
		IntlProjectResultExample.Criteria c = example.createCriteria();
		c.andResultIdEqualTo(result.getResultId());
		
		return intlProjectResultMapper.updateByExample(result, example);
	}

	@Override
	public Integer delProjectResult(String resultId) 
	{
		IntlProjectResult result = this.findProjectResult(resultId);
		result.setDelFlag(DelFlagEnum.STATUS_DEL.getCode());
		
		return updProjectResult(result);
	}

	@Override
	public Integer delProjectResultReal(String resultId) 
	{
		IntlProjectResultExample example = new IntlProjectResultExample();
		IntlProjectResultExample.Criteria c = example.createCriteria();
		c.andResultIdEqualTo(resultId);
		
		return intlProjectResultMapper.deleteByExample(example);
	}

	private LayuiTableData findByExample(LayuiTableParam param,IntlProjectResultExample example) 
	{
		int pageSize = param.getLimit();
		int pageStart = (param.getPage()-1)*pageSize;
		int pageNum = pageStart/pageSize + 1;
		PageHelper.startPage(pageNum, pageSize);
		List<IntlProjectResult> list = intlProjectResultMapper.selectByExample(example);
		PageInfo<IntlProjectResult> pageInfo= new PageInfo<IntlProjectResult>(list);
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}
}
