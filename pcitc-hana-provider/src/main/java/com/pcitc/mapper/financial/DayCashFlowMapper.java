package com.pcitc.mapper.financial;

import java.util.List;
import java.util.Map;

import com.pcitc.base.hana.report.DayCashFlow;

public interface DayCashFlowMapper {
	
	public List<DayCashFlow> getDayCashFlowReport(Map map);

}
