package com.pcitc.service.outApi.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pcitc.base.stp.out.OutProjectCheck;
import com.pcitc.base.stp.out.OutProjectCheckItem;
import com.pcitc.base.util.DateUtil;
import com.pcitc.mapper.outApi.OutProjectCheckItemMapper;
import com.pcitc.mapper.outApi.OutProjectCheckMapper;
import com.pcitc.service.outApi.OutProjectCheckService;

@Service("outProjectCheckService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class OutProjectCheckServiceImpl implements OutProjectCheckService {

	@Autowired
	private OutProjectCheckMapper outProjectCheckMapper;
	
	@Autowired
	private OutProjectCheckItemMapper outProjectCheckItemMapper;
	
	/**
	 * 批量插入项目验收
	 */
	@Transactional
    //@TxTransaction
	public Integer saveOutProjectCheck(OutProjectCheck outProjectCheck) {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		outProjectCheck.setDataId(uuid);
		outProjectCheck.setCreateDate(DateUtil.dateToStr(new Date(),DateUtil.FMT_SS));
		outProjectCheck.setSts("1");
		outProjectCheckMapper.insert(outProjectCheck);
		
		// 保存行项目
		if (outProjectCheck.getItemList() != null) {
			for (int i = 0; i < outProjectCheck.getItemList().size(); i++) {
				OutProjectCheckItem opri = (OutProjectCheckItem)outProjectCheck.getItemList().get(i);
				opri.setDataId(UUID.randomUUID().toString().replaceAll("-", ""));
				opri.setCheckDataId(uuid);
				opri.setSts("1");
				outProjectCheckItemMapper.insert(opri);
			}
		}
		return 1;
	}

}
