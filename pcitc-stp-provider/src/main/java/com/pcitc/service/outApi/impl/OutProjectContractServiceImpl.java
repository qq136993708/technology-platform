package com.pcitc.service.outApi.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pcitc.base.stp.out.OutProjectContract;
import com.pcitc.base.stp.out.OutProjectContractItem;
import com.pcitc.base.util.DateUtil;
import com.pcitc.mapper.outApi.OutProjectContractItemMapper;
import com.pcitc.mapper.outApi.OutProjectContractMapper;
import com.pcitc.service.outApi.OutProjectContractService;

@Service("outProjectContractService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class OutProjectContractServiceImpl implements OutProjectContractService {

	@Autowired
	private OutProjectContractMapper outProjectContractMapper;
	
	@Autowired
	private OutProjectContractItemMapper outProjectContractItemMapper;
	
	/**
	 * 批量插入项目合同
	 */
	@Transactional
    //@TxTransaction
	public Integer saveOutProjectContract(OutProjectContract outProjectContract) {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		outProjectContract.setDataId(uuid);
		outProjectContract.setCreateDate(DateUtil.dateToStr(new Date(),DateUtil.FMT_SS));
		outProjectContract.setSts("1");
		outProjectContract.setAuditSts("1");
		outProjectContractMapper.insert(outProjectContract);
		
		// 保存行项目
		if (outProjectContract.getItemList() != null) {
			for (int i = 0; i < outProjectContract.getItemList().size(); i++) {
				OutProjectContractItem opri = (OutProjectContractItem)outProjectContract.getItemList().get(i);
				opri.setContractId(uuid);
				opri.setDataId(UUID.randomUUID().toString().replaceAll("-", ""));
				opri.setSts("1");
				outProjectContractItemMapper.insert(opri);
			}
		}
		return 1;
	}

}
