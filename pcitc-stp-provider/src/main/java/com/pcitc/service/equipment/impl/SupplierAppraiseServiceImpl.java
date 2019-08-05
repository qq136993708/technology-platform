package com.pcitc.service.equipment.impl;

import com.pcitc.base.stp.equipment.*;
import com.pcitc.mapper.equipment.*;
import com.pcitc.service.equipment.SupplierAppraiseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("appraiseService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class SupplierAppraiseServiceImpl implements SupplierAppraiseService {
	
	
	@Autowired
	private SreSupplierAppraiseMapper sreSupplierAppraiseMapper;

	@Override
	public void insertSupplierAppraise(SreSupplierAppraise sreSupplierAppraise) {
		sreSupplierAppraiseMapper.insertSelective(sreSupplierAppraise);
	}

	@Override
	public Integer updateSreSupplierAppraise(SreSupplierAppraise sreSupplierAppraise) {
		return sreSupplierAppraiseMapper.updateByPrimaryKeySelective(sreSupplierAppraise);
	}

	@Override
	public SreSupplierAppraise selectSreSupplierDetailId(String equipmentDetailId) {
		return sreSupplierAppraiseMapper.selectSreSupplierDetailId(equipmentDetailId);
	}

	@Override
	public SreSupplierAppraise selectSreSupplierById(String id) {
		return sreSupplierAppraiseMapper.selectByPrimaryKey(id);
	}


}
