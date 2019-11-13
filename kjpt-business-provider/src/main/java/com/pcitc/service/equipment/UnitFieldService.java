package com.pcitc.service.equipment;

import java.util.List;
import java.util.Map;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.equipment.UnitField;

public interface UnitFieldService {
	
	
	public UnitField selectUnitField(String id) throws Exception;

	public Integer updateUnitField(UnitField record)throws Exception;

	public int deleteUnitField(String id)throws Exception;
	

	public Integer insertUnitField(UnitField record)throws Exception;
	
	public LayuiTableData getUnitFieldPage(LayuiTableParam param)throws Exception;
	
	
	
	public List<UnitField> getUnitNameList()throws Exception;
	public List<UnitField> getDepartmentNameListByUnitName(Map map)throws Exception;
	public List<UnitField> getProfessionalNameListByUnitNameAndDept(Map map)throws Exception;
	    
	    

}
