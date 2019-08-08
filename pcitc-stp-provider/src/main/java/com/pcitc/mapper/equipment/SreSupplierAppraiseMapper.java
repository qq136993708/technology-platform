package com.pcitc.mapper.equipment;

import com.pcitc.base.stp.equipment.SrePurchase;
import com.pcitc.base.stp.equipment.SreSupplierAppraise;

import java.util.List;
import java.util.Map;

public interface SreSupplierAppraiseMapper {
    int deleteByPrimaryKey(String id);

    int insert(SreSupplierAppraise record);

    int insertSelective(SreSupplierAppraise record);

    SreSupplierAppraise selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SreSupplierAppraise record);

    int updateByPrimaryKey(SreSupplierAppraise record);


    SreSupplierAppraise selectEquipmentId(String equipmentId);

    SreSupplierAppraise selectSreSupplierDetailId(String equipmentDetailId);

    List<SreSupplierAppraise> getList(Map map);
}