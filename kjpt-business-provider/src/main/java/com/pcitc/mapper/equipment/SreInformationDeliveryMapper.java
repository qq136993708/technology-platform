package com.pcitc.mapper.equipment;

import java.util.List;
import java.util.Map;

import com.pcitc.base.stp.equipment.SreInformationDelivery;
import com.pcitc.base.stp.equipment.SrePlanImplement;

public interface SreInformationDeliveryMapper {
    int deleteByPrimaryKey(String id);

    int insert(SreInformationDelivery record);

    int insertSelective(SreInformationDelivery record);

    SreInformationDelivery selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SreInformationDelivery record);

    int updateByPrimaryKey(SreInformationDelivery record);

	List<SreInformationDelivery> getList(Map map);

	List<SreInformationDelivery> getCountset(Map map);

}