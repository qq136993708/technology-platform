package com.pcitc.service.outApi.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pcitc.base.stp.out.OutProjectReport;
import com.pcitc.base.util.DateUtil;
import com.pcitc.mapper.outApi.OutProjectReportMapper;
import com.pcitc.service.outApi.OutProjectReportService;

@Service("outProjectReportService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class OutProjectReportServiceImpl implements OutProjectReportService {

	@Autowired
	private OutProjectReportMapper outProjectReportMapper;
	
	/**
	 * 批量插入项目经费
	 */
	@Transactional
    //@TxTransaction
	public Integer saveOutProjectReport(OutProjectReport outProjectReport) {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		outProjectReport.setDataId(uuid);
		outProjectReport.setCreateDate(DateUtil.dateToStr(new Date(),DateUtil.FMT_SS));
		outProjectReport.setSts("1");
		outProjectReportMapper.insert(outProjectReport);
		
		return 1;
	}

}
