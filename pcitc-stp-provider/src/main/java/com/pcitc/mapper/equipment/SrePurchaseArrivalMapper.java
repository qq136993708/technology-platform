package com.pcitc.mapper.equipment;


import com.pcitc.base.stp.equipment.SrePurchaseArrival;

import java.util.List;
import java.util.Map;

public interface SrePurchaseArrivalMapper {
    int deleteByPrimaryKey(String id);

    int insert(SrePurchaseArrival record);

    int insertSelective(SrePurchaseArrival record);

    SrePurchaseArrival selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SrePurchaseArrival record);

    int updateByPrimaryKey(SrePurchaseArrival record);

    int deletePurchaseArrival();

    void insertPurchaseArrivalList(List<SrePurchaseArrival> srePurchaseArrivals);

	List<SrePurchaseArrival> selectErpnum(Map map);
	
}