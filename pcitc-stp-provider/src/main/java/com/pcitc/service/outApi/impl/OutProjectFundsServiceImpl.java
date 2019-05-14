package com.pcitc.service.outApi.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pcitc.base.stp.out.OutProjectFunds;
import com.pcitc.base.stp.out.OutProjectFundsItem;
import com.pcitc.base.util.DateUtil;
import com.pcitc.mapper.outApi.OutProjectFundsItemMapper;
import com.pcitc.mapper.outApi.OutProjectFundsMapper;
import com.pcitc.service.outApi.OutProjectFundsService;

@Service("outProjectFundsService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class OutProjectFundsServiceImpl implements OutProjectFundsService {

	@Autowired
	private OutProjectFundsMapper outProjectFundsMapper;
	
	@Autowired
	private OutProjectFundsItemMapper outProjectFundsItemMapper;
	
	/**
	 * 批量插入项目经费
	 */
	@Transactional
    //@TxTransaction
	public Integer saveOutProjectFunds(OutProjectFunds outProjectFunds) {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		outProjectFunds.setDataId(uuid);
		outProjectFunds.setCreateDate(DateUtil.dateToStr(new Date(),DateUtil.FMT_SS));
		outProjectFunds.setSts("1");
		outProjectFundsMapper.insert(outProjectFunds);
		
		// 保存行项目
		if (outProjectFunds.getItemList() != null) {
			for (int i = 0; i < outProjectFunds.getItemList().size(); i++) {
				OutProjectFundsItem opri = (OutProjectFundsItem)outProjectFunds.getItemList().get(i);
				opri.setFundsId(uuid);
				opri.setDataId(UUID.randomUUID().toString().replaceAll("-", ""));
				opri.setSts("1");
				outProjectFundsItemMapper.insert(opri);
			}
		}
		return 1;
	}

}
