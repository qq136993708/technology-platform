package com.pcitc.mapper.equipment;

import com.pcitc.base.stp.equipment.SreSupplierAppraise;

public interface SreSupplierAppraiseMapper {
    int deleteByPrimaryKey(String id);

    int insert(SreSupplierAppraise record);

    int insertSelective(SreSupplierAppraise record);

    SreSupplierAppraise selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SreSupplierAppraise record);

    int updateByPrimaryKey(SreSupplierAppraise record);


    SreSupplierAppraise selectSreSupplierDetailId(String equipmentDetailId);
}