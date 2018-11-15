package com.pcitc.service.out;

import java.util.List;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.out.OutReward;

public interface OutRewardService {

	public LayuiTableData getOutRewardPage(LayuiTableParam param);

	public LayuiTableData getOutRewardListPage(LayuiTableParam param);

	OutReward getOutRewardShowById(String dataId) throws Exception;
	
	public int insertRewardData(List<OutReward> list);
	
}
