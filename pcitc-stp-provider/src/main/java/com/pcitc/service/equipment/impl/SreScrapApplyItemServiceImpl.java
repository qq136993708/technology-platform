package com.pcitc.service.equipment.impl;

import com.pcitc.service.equipment.SreScrapApplyItemService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pcitc.base.stp.equipment.FindAppltid;
import com.pcitc.base.stp.equipment.sre_scrap_apply_item;
import com.pcitc.mapper.equipment.sre_scrap_apply_itemMapper;

@Service("sreScrapApplyItemService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class SreScrapApplyItemServiceImpl implements SreScrapApplyItemService{
	@Autowired
	private sre_scrap_apply_itemMapper srescrapapplyitemMapper;
	
	   public int insert(sre_scrap_apply_item record)throws Exception
	   {
		   return srescrapapplyitemMapper.insert(record);
	   }
	   
	   public List<FindAppltid> selectByAppltidList(String id)throws Exception
	   {
		   List<FindAppltid> list=srescrapapplyitemMapper.selectByAppltidList(id);
		   return list;
	   }
	   public int deleteByApplyId(String applyid)throws Exception
	   {
		   return srescrapapplyitemMapper.deleteByApplyId(applyid);
	   }
}
