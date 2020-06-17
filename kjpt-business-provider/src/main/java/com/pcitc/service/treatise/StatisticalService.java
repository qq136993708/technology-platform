package com.pcitc.service.treatise;

import java.util.List;
import java.util.Map;

import com.pcitc.base.common.ChartData;
import com.pcitc.base.researchplatform.PlatformInfoModel;

public interface StatisticalService {
	
	 public Map getRightsMap();//知识产权
	 
	 public List getAchieveMaintainGrupCountList();
	 
	 public List<ChartData> getTongjiList();
	 
	 
	 public List<PlatformInfoModel> getPlatFormList(Map param);
	 public List<ChartData> getZjkTongjiList();
	 

}
