package com.pcitc.mapper.trademarkinfo;

import com.pcitc.base.patent.PatentInfo;
import com.pcitc.base.trademarkinfo.TrademarkInfo;
import com.pcitc.base.trademarkinfo.TrademarkInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TrademarkInfoMapper {
    long countByExample(TrademarkInfoExample example);

    int deleteByExample(TrademarkInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(TrademarkInfo record);

    TrademarkInfo insertSelective(TrademarkInfo record);

    List<TrademarkInfo> selectByExample(TrademarkInfoExample example);

    TrademarkInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TrademarkInfo record, @Param("example") TrademarkInfoExample example);

    int updateByExample(@Param("record") TrademarkInfo record, @Param("example") TrademarkInfoExample example);

    int updateByPrimaryKeySelective(TrademarkInfo record);

    TrademarkInfo updateByPrimaryKey(TrademarkInfo record);

    List<TrademarkInfo> queryTrademarkList(Map param);
}