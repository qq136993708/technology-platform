package com.pcitc.service.out.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pcitc.base.stp.out.OutUnit;
import com.pcitc.mapper.out.OutUnitMapper;
import com.pcitc.service.out.OutUnitService;

@Service("outUnitService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class OutUnitServiceImpl implements OutUnitService {

	@Autowired
	private OutUnitMapper outUnitMapper;

	private final static Logger logger = LoggerFactory.getLogger(OutUnitServiceImpl.class);

	public int insertUnitData(List<OutUnit> list) {
		// 删除年度数据
		// OutPatentExample example = new OutPatentExample();
		// outPatentMapper.deleteByExample(example);

		// 批量插入数据
		outUnitMapper.insertOutUnitBatch(list);
		return 1;
	}

}
