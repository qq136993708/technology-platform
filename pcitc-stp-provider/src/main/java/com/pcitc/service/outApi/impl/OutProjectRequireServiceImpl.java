package com.pcitc.service.outApi.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pcitc.base.stp.out.OutProjectRequire;
import com.pcitc.base.stp.out.OutProjectRequireItem;
import com.pcitc.base.util.DateUtil;
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
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		outProjectRequire.setDataId(uuid);
		outProjectRequire.setCreateDate(DateUtil.dateToStr(new Date(),DateUtil.FMT_SS));
		outProjectRequire.setSts("1");
		outProjectRequire.setAuditSts("1");
		outProjectRequireMapper.insert(outProjectRequire);
		
		// 保存行项目
		if (outProjectRequire.getItemList() != null) {
			for (int i = 0; i < outProjectRequire.getItemList().size(); i++) {
				OutProjectRequireItem opri = (OutProjectRequireItem)outProjectRequire.getItemList().get(i);
				opri.setRequireId(uuid);
				opri.setDataId(UUID.randomUUID().toString().replaceAll("-", ""));
				opri.setSts("1");
				outProjectRequireItemMapper.insert(opri);
			}
		}
		return 1;
	}

}
