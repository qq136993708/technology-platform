package com.pcitc.service.out.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pcitc.base.stp.out.OutUnit;
import com.pcitc.base.stp.out.OutUnitExample;
import com.pcitc.base.util.DateUtil;
import com.pcitc.mapper.out.OutUnitMapper;
import com.pcitc.service.out.OutUnitService;

@Service("outUnitService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class OutUnitServiceImpl implements OutUnitService {

	@Autowired
	private OutUnitMapper outUnitMapper;

	private final static Logger logger = LoggerFactory.getLogger(OutUnitServiceImpl.class);

	public int insertOutUnitBatch(List<OutUnit> list, String deleteFlag) {
		List<OutUnit> updateList = new ArrayList<OutUnit>();

		// 批量插入数据
		for(int i =0;i < list.size(); i++) {
			OutUnit temUnit = list.get(i);
			
			OutUnitExample example = new OutUnitExample();
			OutUnitExample.Criteria ouc = example.createCriteria();
			ouc.andDefine1EqualTo(deleteFlag);
			ouc.andUnitCodeEqualTo(temUnit.getUnitCode());
			List<OutUnit> temList = outUnitMapper.selectByExample(example);
			if (temList != null && temList.size() > 0) {
				OutUnit updateUnit = temList.get(0);
				updateUnit.setUnitName(temUnit.getUnitName());
				updateUnit.setUnitAli(temUnit.getUnitAli());
				updateUnit.setParentCode(temUnit.getParentCode());
				updateUnit.setDefine2(temUnit.getDefine2());
				if (temUnit.getDefine3() != null && !temUnit.getDefine3().equals("")) {
					updateUnit.setDefine3(temUnit.getDefine3());
				}
				updateUnit.setUnitType(DateUtil.dateToStr(new Date(), DateUtil.FMT_SS));
				outUnitMapper.updateByPrimaryKey(updateUnit);
			} else {
				updateList.add(temUnit);
			}
		}
		if (updateList.size() > 0) {
			outUnitMapper.insertOutUnitBatch(updateList);
		}
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

	@Override
	public List<OutUnit> selectByDefine1(String define1)
	{
		OutUnitExample example = new OutUnitExample();
		OutUnitExample.Criteria c = example.createCriteria();
		c.andDefine1EqualTo(define1);
		
		return outUnitMapper.selectByExample(example);
	}

	@Override
	public List<OutUnit> selectByDefine2(String define2)
	{
		OutUnitExample example = new OutUnitExample();
		OutUnitExample.Criteria c = example.createCriteria();
		c.andDefine2EqualTo(define2);
		example.setOrderByClause("unit_name");
		return outUnitMapper.selectByExample(example);
	}

	@Override
	public List<OutUnit> selectByDefine3(String define3)
	{
		OutUnitExample example = new OutUnitExample();
		OutUnitExample.Criteria c = example.createCriteria();
		c.andDefine3EqualTo(define3);
		
		return outUnitMapper.selectByExample(example);
	}
}
