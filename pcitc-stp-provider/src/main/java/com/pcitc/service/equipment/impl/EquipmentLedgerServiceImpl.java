package com.pcitc.service.equipment.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.equipment.SreDetail;
import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.stp.equipment.SreEquipmentLedger;
import com.pcitc.base.stp.equipment.SrePurchaseOrder;
import com.pcitc.mapper.equipment.SreEquipmentLedgerMapper;
import com.pcitc.mapper.equipment.SrePurchaseArrivalMapper;
import com.pcitc.mapper.equipment.SrePurchaseOrderMapper;
import com.pcitc.service.equipment.EquipmentLedgerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("equipmentLedgerService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class EquipmentLedgerServiceImpl implements EquipmentLedgerService {
	
	
	private final static Logger logger = LoggerFactory.getLogger(EquipmentLedgerServiceImpl.class);
	@Autowired
    private SreEquipmentLedgerMapper sreEquipmentLedgerMapper;

    @Override
    public void insertEquipmentLedger(List<SreEquipmentLedger> sreEquipmentLedgerList) {
        sreEquipmentLedgerMapper.insertEquipmentLedgerList(sreEquipmentLedgerList);
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

	public LayuiTableData getEquipmentLedgerPage(LayuiTableParam param)throws Exception
	{
		JSONObject parmamss = JSONObject.parseObject(JSONObject.toJSONString(param));
		System.out.println(">>>>>>>>>参数："+parmamss.toString());
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		PageHelper.startPage(pageNum, pageSize);
		String g0anln1=getTableParam(param,"g0anln1","");
		String g0txt50=getTableParam(param,"g0txt50","");
		String month=getTableParam(param,"month","");
		String g0gsdm=getTableParam(param,"g0gsdm","");
		String g0gsjc=getTableParam(param,"g0gsjc","");
		Map map=new HashMap();
		map.put("g0txt50", g0txt50);
		map.put("g0anln1", g0anln1);
		map.put("g0cald", month);
		map.put("g0gsdm", g0gsdm);
		map.put("g0gsjc", g0gsjc);
		List<SreEquipmentLedger> list=sreEquipmentLedgerMapper.getList(map);
		
		
		PageInfo<SreEquipmentLedger> pageInfo = new PageInfo<SreEquipmentLedger>(list);
		System.out.println(">>>>>>>>>查询分页结果"+pageInfo.getList().size());
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
	    return data;
	    
	}

    
    
    
}
