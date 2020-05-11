package com.pcitc.mapper.financial;

import java.util.List;
import java.util.Map;

import com.pcitc.base.hana.report.Financial;
import com.pcitc.base.hana.report.ScientificBaseBuildFee01;
import com.pcitc.base.hana.report.ScientificBaseBuildFee02;
import com.pcitc.base.hana.report.ScientificBaseBuildFee03;
import com.pcitc.base.hana.report.ScientificBaseBuildFee04;

public interface ScientificBaseBuildFeeMapper {
	
	
	 public List<ScientificBaseBuildFee01> getScientificBaseBuildFee01Report(Map map);
	 public List<ScientificBaseBuildFee02> getScientificBaseBuildFee02Report(Map map);
	 public List<ScientificBaseBuildFee03> getScientificBaseBuildFee03Report(Map map);
	 
	 public List<ScientificBaseBuildFee04> getList(Map map);
	 public Integer getCount(Map map);
	 
	 
	 
	 
	 public List<Financial> getYfftjData(Map map);
	 public List<Financial> getYfftjDetailData(Map map);
	 public Integer getYfftjDetailDataCount(Map map);
	 
	 
	 
	 
	 public List<Financial> getJsgztjData(Map map);
	 public List<Financial> getJsgztjDetailData(Map map);
	 public Integer getJsgztjDetailDataCount(Map map);
	 
	 

}
