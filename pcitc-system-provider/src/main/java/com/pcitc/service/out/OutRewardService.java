package com.pcitc.service.out;

import java.util.HashMap;
import java.util.List;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.out.OutReward;

public interface OutRewardService {

	public LayuiTableData getOutRewardPage(LayuiTableParam param);

	public LayuiTableData getOutRewardListPage(LayuiTableParam param);

	OutReward getOutRewardShowById(String dataId) throws Exception;
	
	public int insertRewardData(List<OutReward> list);
	/**
	 *  获取成果年度列表
	 * @return
	 */
	public List<String> selectOutRewardYearList();
	
	/**
	 * 辅助决策中心，科技奖励年度趋势分析, 近5年各类奖励类型的数量情况
	 */
	public List getRewardBySbjzWithFiveYear(HashMap<String, String> map);
	
	/**
	 * 辅助决策中心，科技奖励年度趋势分析, 各个研究院的奖励情况
	 */
	public List getRewardInfoByYjy(HashMap<String, String> map);
}
