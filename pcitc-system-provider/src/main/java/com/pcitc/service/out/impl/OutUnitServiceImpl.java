package com.pcitc.service.out.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pcitc.base.stp.out.OutUnit;
import com.pcitc.base.stp.out.OutUnitExample;
import com.pcitc.mapper.out.OutUnitMapper;
import com.pcitc.service.out.OutUnitService;

@Service("outUnitService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class OutUnitServiceImpl implements OutUnitService {

	@Autowired
	private OutUnitMapper outUnitMapper;

	private final static Logger logger = LoggerFactory.getLogger(OutUnitServiceImpl.class);

	public int insertOutUnitBatch(List<OutUnit> list, String deleteFlag) {
		// 删除年度数据
		// OutPatentExample example = new OutPatentExample();
		// outPatentMapper.deleteByExample(example);

		// 批量插入数据
		OutUnitExample example = new OutUnitExample();
		OutUnitExample.Criteria ouc = example.createCriteria();
		ouc.andDefine1EqualTo(deleteFlag);
		outUnitMapper.deleteByExample(example);
		
		outUnitMapper.insertOutUnitBatch(list);
		return 1;
	}
	
	/**
	 * @param list
	 * 批量修改数据
	 */
	public int updateUnitDataBatch(List<OutUnit> list) {
		outUnitMapper.updateUnitDataBatch(list);
		
		return 1;
	}
}
