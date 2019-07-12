package com.pcitc.service.hana;

import java.util.Map;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.report.TechCost;
import com.pcitc.base.stp.report.TechOrgCount;

public interface ITechStatisticsService {
	
	
	
	
	
	public TechCost selectTechCost(String id) throws Exception;

	public Integer updateTechCost(TechCost record)throws Exception;

	public int deleteTechCost(String id)throws Exception;

	public Integer insertTechCost(TechCost record)throws Exception;
	
	public LayuiTableData getTechCostPage(LayuiTableParam param)throws Exception;
	
	public Result dealTechCostWorkFlow(String id, Map map) throws Exception;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public TechOrgCount selectTechOrgCount(String id) throws Exception;

	public Integer updateTechOrgCount(TechOrgCount record)throws Exception;

	public int deleteTechOrgCount(String id)throws Exception;

	public Integer insertTechOrgCount(TechOrgCount record)throws Exception;
	
	public LayuiTableData getTechOrgCountPage(LayuiTableParam param)throws Exception;
	public Result dealTechOrgCountWorkFlow(String id, Map map) throws Exception;
	public LayuiTableData getTechOrgCountStatisticsPage(LayuiTableParam param)throws Exception;
	

}
