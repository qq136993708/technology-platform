package com.pcitc.service.outApi.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pcitc.base.stp.out.OutProjectResult;
import com.pcitc.base.util.DateUtil;
import com.pcitc.mapper.outApi.OutProjectResultMapper;
import com.pcitc.service.outApi.OutProjectResultService;

@Service("outProjectResultService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class OutProjectResultServiceImpl implements OutProjectResultService {

	@Autowired
	private OutProjectResultMapper outProjectResultMapper;
	
	/**
	 * 批量插入项目检查结果
	 */
	@Transactional
    //@TxTransaction
	public Integer saveOutProjectResult(OutProjectResult outProjectResult) {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		outProjectResult.setDataId(uuid);
		outProjectResult.setCreateDate(DateUtil.dateToStr(new Date(),DateUtil.FMT_SS));
		outProjectResult.setSts("1");
		outProjectResultMapper.insert(outProjectResult);
		
		return 1;
	}

}
