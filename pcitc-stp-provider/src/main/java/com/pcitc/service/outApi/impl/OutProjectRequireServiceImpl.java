package com.pcitc.service.outApi.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pcitc.base.stp.out.OutProjectRequire;
import com.pcitc.mapper.outApi.OutProjectRequireItemMapper;
import com.pcitc.mapper.outApi.OutProjectRequireMapper;
import com.pcitc.service.outApi.OutProjectRequireService;

@Service("outProjectRequireService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class OutProjectRequireServiceImpl implements OutProjectRequireService {

	@Autowired
	private OutProjectRequireMapper outProjectRequireMapper;
	
	@Autowired
	private OutProjectRequireItemMapper outProjectRequireItemMapper;
	
	/**
	 * 批量插入全流程信息
	 * 
	 * @param flowProjectInfo
	 * @return
	 * @throws Exception
	 */
	@Transactional
    //@TxTransaction
	public Integer saveOutProjectRequire(OutProjectRequire outProjectRequire) {
		outProjectRequireMapper.insert(outProjectRequire);
		return 1;
	}

}
