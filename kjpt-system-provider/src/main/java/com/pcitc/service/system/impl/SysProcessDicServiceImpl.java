package com.pcitc.service.system.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.system.SysProcessDic;
import com.pcitc.mapper.system.SysProcessDicMapper;
import com.pcitc.service.system.SysProcessDicService;


@Service("sysProcessDicService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class SysProcessDicServiceImpl implements SysProcessDicService {
	
	@Autowired
	private SysProcessDicMapper sysProcessDicMapper;
	
	
	
	public SysProcessDic selectSysProcessDic(String id) throws Exception
	{
		return sysProcessDicMapper.selectByPrimaryKey(id);
	}

	public Integer updateSysProcessDic(SysProcessDic record)throws Exception
	{
		return sysProcessDicMapper.updateByPrimaryKey(record);
	}

	public int deleteSysProcessDic(String id)throws Exception
	{
		return sysProcessDicMapper.deleteByPrimaryKey(id);
	}
	
	
	
	public List<SysProcessDic> getSysProcessDicListByMap(Map map)throws Exception
	{
		
		Map map_para=new HashMap();
		JSONObject parmamss = JSONObject.parseObject(JSONObject.toJSONString(map));
		System.out.println(">>>>>>>>>> getSysProcessDicListByMap 参数: "+parmamss.toJSONString());
		String type=(String)map.get("type");
		String name=(String)map.get("name");
		String parentId=(String)map.get("parentId");
		
    	List<SysProcessDic> list = sysProcessDicMapper.getList(map_para);
    	return list;
	}

	public Integer insertSysProcessDic(SysProcessDic record)throws Exception
	{
		return sysProcessDicMapper.insert(record);
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
	
	
	public LayuiTableData getSysProcessDicPage(LayuiTableParam param)throws Exception
	{
		
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		
		String type=getTableParam(param,"type","");
		String name=getTableParam(param,"name","");
		String parentId=getTableParam(param,"parentId","");
		
		Map map=new HashMap();
		map.put("name", name);
		map.put("type", type);
		map.put("name", name);
		map.put("parentId", parentId);
		System.out.println(">>>>>>>>name="+name);
		StringBuffer applyUnitCodeStr=new StringBuffer();
		
		//map.put("sqlStr", applyUnitCodeStr.toString());
		
		
		List<SysProcessDic> list = sysProcessDicMapper.getList(map);
		PageInfo<SysProcessDic> pageInfo = new PageInfo<SysProcessDic>(list);
		System.out.println(">>>>>>>>>查询分页结果"+pageInfo.getList().size());
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
	    return data;
	}

}
