package com.pcitc.mapper.out;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import com.pcitc.base.stp.out.OutReward;
import com.pcitc.base.stp.out.OutRewardExample;

public interface OutRewardMapper {
    int countByExample(OutRewardExample example);

    int deleteByExample(OutRewardExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(OutReward record);

    int insertSelective(OutReward record);

    List<OutReward> selectByExample(OutRewardExample example);

    OutReward selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") OutReward record, @Param("example") OutRewardExample example);

    int updateByExample(@Param("record") OutReward record, @Param("example") OutRewardExample example);

    int updateByPrimaryKeySelective(OutReward record);

    int updateByPrimaryKey(OutReward record);
    
    public void insertOutRewardBatch(List<OutReward> list);
    
    List<String> selectOutRewardYearList();
    
    /**
	 * 辅助决策中心，科技奖励年度趋势分析, 近5年各类奖励类型的数量情况
	 */
	public List getRewardBySbjzWithFiveYear(HashMap<String, String> map);
	
	/**
	 * 辅助决策中心，科技奖励年度趋势分析, 各个研究院的奖励情况
	 */
	public List getRewardInfoByYjy(HashMap<String, String> map);
	
	/**
	 * 修改out_reward数据
	 * 调用存储过程统一处理，无参数
	 */
	@SuppressWarnings("rawtypes")
	@Select("call updateOutReward()")
	@Options(statementType= StatementType.CALLABLE )
	public HashMap updateOutReward();
}