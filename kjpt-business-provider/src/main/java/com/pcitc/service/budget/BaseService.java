package com.pcitc.service.budget;

import java.util.List;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;

public interface BaseService<Bean, PK,Example> 
{
	Bean selectByPrimaryKey(PK id);
	
	LayuiTableData selectTableData(LayuiTableParam param,Example e);
	
	List<Bean> selectListData(Example e);
	
	Boolean updateBean(Bean bean) throws Exception;
	
	Boolean deleteBean(PK id) throws Exception;
	
	Boolean saveBean(Bean bean) throws Exception;
	
	Boolean saveOrUpdBean(PK id,Bean bean) throws Exception;
	
}
