package com.pcitc.service.expert.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.expert.KyzjExpert;
import com.pcitc.base.expert.ZjkBase;
import com.pcitc.mapper.expert.KyzjExpertMapper;
import com.pcitc.service.expert.IKyzjExpertService;
import com.pcitc.util.BusinessUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class KyzjExpertServiceImpl implements IKyzjExpertService {
	
	@Autowired
	private KyzjExpertMapper kyzjExpertMapper;

	@Override
	public KyzjExpert selectZjkBase(String id) throws Exception {
		return kyzjExpertMapper.selectByPrimaryKey(id);
	}

	@Override
	public Integer updateKyzjExpert(KyzjExpert record) throws Exception {
		return kyzjExpertMapper.updateByPrimaryKey(record);
	}

	@Override
	public int deleteLogicKyzjExpert(String id) throws Exception {
		KyzjExpert expert =kyzjExpertMapper.selectByPrimaryKey(id);
		expert.setDeleted("1");
		return kyzjExpertMapper.updateByPrimaryKey(expert);
	}

	@Override
	public int deleteKyzjExpert(String id) throws Exception {
		return kyzjExpertMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Integer insertKyzjExpert(KyzjExpert record) throws Exception {
		return kyzjExpertMapper.insert(record);
	}

	@Override
	public LayuiTableData getKyzjExpertPage(LayuiTableParam param) throws Exception {
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		String yearStr = getTableParam(param,"yearStr","");
		String expertType = getTableParam(param,"expertType","");
		String deleted = getTableParam(param,"deleted","");
		String childUnitIds=getTableParam(param,"childUnitIds","");
		String secretLevel=getTableParam(param,"secretLevel","");
		String userSecretLevel=getTableParam(param,"userSecretLevel","");
		String createUnitId=getTableParam(param,"createUnitId","");
		String createUnitName=getTableParam(param,"createUnitName","");
		String customQueryConditionStr=getTableParam(param,"customQueryConditionStr","");
		String knowledgeScope=getTableParam(param,"knowledgeScope","");

		Map map=new HashMap();
		map.put("yearStr", yearStr);
		map.put("expertType", expertType);
		map.put("deleted", deleted);
		map.put("childUnitIds", childUnitIds);
		map.put("secretLevel", secretLevel);
		map.put("userSecretLevel", userSecretLevel);
		map.put("createUnitId", createUnitId);
		map.put("createUnitName", createUnitName);
		map.put("knowledgeScope", knowledgeScope);

		String condition=BusinessUtil.getSqlQueryCondition(customQueryConditionStr);
		map.put("condition", condition);

		JSONObject obj = JSONObject.parseObject(JSONObject.toJSONString(map));
		System.out.println(">>>>>>>>>科研专家查询参数:  "+obj.toString());

		List<KyzjExpert> list = kyzjExpertMapper.getList(map);
		PageInfo<KyzjExpert> pageInfo = new PageInfo<KyzjExpert>(list);
		System.out.println(">>>>>>>>>科研专家查询分页结果:  "+pageInfo.getList().size());

		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	@Override
	public List getKyzjExpertList(Map param) throws Exception {
		String customQueryConditionStr=(String)param.get("customQueryConditionStr");
		if(customQueryConditionStr!=null)
		{
			String condition=BusinessUtil.getSqlQueryCondition(customQueryConditionStr);
			param.put("condition", condition);
		}
		List<ZjkBase> list = kyzjExpertMapper.getList(param);
		System.out.println(">>>>>>>>>科研专家查询结果 "+list.size());
		return list;
	}

	@Override
	public Integer getKyzjExpertCount() throws Exception {
		Map map=new HashMap();
		map.put("deleted", "0");
		List<ZjkBase> list = kyzjExpertMapper.getList(map);
		int count=0;
		if(list!=null && list.size()>0)
		{
			count=list.size();
		}
		return count;
	}

	@Override
	public int insertBatch(List<KyzjExpert> list) throws Exception {
		int count=0;
		if(list!=null && list.size()>0)
		{
			for(int i=0;i<list.size();i++)
			{
				KyzjExpert kyzjExpert = list.get(i);
				count=kyzjExpertMapper.insert(kyzjExpert);
			}
		}
		return count;
	}


	private String getTableParam(LayuiTableParam param,String paramName,String defaultstr)
	{
		String resault="";
		Object object=param.getParam().get(paramName);
		if(object!=null)
		{
			resault=(String)object;
		}
		return resault;
	}

}
