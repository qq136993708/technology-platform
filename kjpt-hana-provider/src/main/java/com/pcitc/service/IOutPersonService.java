package com.pcitc.service;

import java.util.List;
import java.util.Map;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.out.OutPerson;
import com.pcitc.base.out.OutPersonVo;

public interface IOutPersonService {

	
	

	
	public List getHanaPantentListByNum(String num)throws Exception;
	
	
	public List getHanaOutPersonBaseInfoList(Map map)throws Exception;
	
	
	public List getHanaOutPersonPatentList(Map map)throws Exception;
	
	
	public List getHanaOutPersonBookList(Map map)throws Exception;
	
	public List getHanaOutPersonAwardList(Map map)throws Exception;
	public List getHanaOutPersonPunishList(Map map)throws Exception;
	
	
	
}
