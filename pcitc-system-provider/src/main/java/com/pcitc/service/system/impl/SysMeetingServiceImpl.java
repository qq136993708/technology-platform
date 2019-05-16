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
import com.pcitc.base.stp.system.SysMeeting;
import com.pcitc.mapper.system.SysMeetingMapper;
import com.pcitc.service.system.SysMeetingService;



@Service("sysMeetingService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class SysMeetingServiceImpl implements SysMeetingService {


	@Autowired
	private SysMeetingMapper sysMeetingMapper;
	public SysMeeting selectSysMeeting(String id) throws Exception
	{
		return sysMeetingMapper.selectByPrimaryKey(id);
	}

	public Integer updateSysMeeting(SysMeeting record)throws Exception
	{
		return sysMeetingMapper.updateByPrimaryKey(record);
	}

	public int deleteSysMeeting(String id)throws Exception
	{
		return sysMeetingMapper.deleteByPrimaryKey(id);
	}
	
	public List<SysMeeting> getSysMeetingListByMap(Map map)throws Exception
	{
		
		Map map_para=new HashMap();
		JSONObject parmamss = JSONObject.parseObject(JSONObject.toJSONString(map));
		System.out.println(">>>>>>>>>> getSysMeetingListByMap 参数: "+parmamss.toJSONString());
		String type=(String)map.get("type");
		String name=(String)map.get("name");
		String parentId=(String)map.get("parentId");
		
    	List<SysMeeting> list = sysMeetingMapper.getList(map_para);
    	return list;
	}

	public Integer insertSysMeeting(SysMeeting record)throws Exception
	{
		return sysMeetingMapper.insert(record);
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
	
	
	public LayuiTableData getSysMeetingPage(LayuiTableParam param)throws Exception
	{
		
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		
		String title=getTableParam(param,"title","");
		String name=getTableParam(param,"name","");
		
		Map map=new HashMap();
		map.put("name", name);
		map.put("title", title);
		System.out.println(">>>>>>>>name="+name);
		
		
		
		List<SysMeeting> list = sysMeetingMapper.getList(map);
		PageInfo<SysMeeting> pageInfo = new PageInfo<SysMeeting>(list);
		System.out.println(">>>>>>>>>查询分页结果"+pageInfo.getList().size());
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
	    return data;
	}


}
