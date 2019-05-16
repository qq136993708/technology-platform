package com.pcitc.mapper.equipment;

import java.util.List;
import java.util.Map;

import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.stp.equipment.SrePurchase;

public interface SrePurchaseMapper {
    int deleteByPrimaryKey(String id);

    int insert(SrePurchase record);

    int insertSelective(SrePurchase record);

    SrePurchase selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SrePurchase record);

    int updateByPrimaryKey(SrePurchase record);

	List<SrePurchase> getList(Map map);

	List<SrePurchase> getPurchaseNameIdList();


    List<SrePurchase> getPassList(Map map);

    List<SrePurchase> getContractClosedList(Map map);
}