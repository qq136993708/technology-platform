package com.pcitc.service.equipment.impl;

import com.pcitc.service.equipment.SreScrapApplyItemService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pcitc.base.stp.equipment.FindAppltid;
import com.pcitc.base.stp.equipment.SreEquipmentLedger;
import com.pcitc.base.stp.equipment.sre_scrap_apply_item;
import com.pcitc.mapper.equipment.SreDetailMapper;
import com.pcitc.mapper.equipment.SreEquipmentLedgerMapper;
import com.pcitc.mapper.equipment.sre_scrap_apply_itemMapper;

@Service("sreScrapApplyItemService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class SreScrapApplyItemServiceImpl implements SreScrapApplyItemService{
	@Autowired
	private sre_scrap_apply_itemMapper srescrapapplyitemMapper;
	@Autowired
	private SreDetailMapper detailMapper;
	@Autowired
	private SreEquipmentLedgerMapper sreEquipmentLedgerMapper;
	
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
		   return srescrapapplyitemMapper.deleteapplyid(applyid);
	   }

	@Override
	public List<FindAppltid> seListview(String id) {
		 List<FindAppltid> list=srescrapapplyitemMapper.selectByAppltidList(id);
		 List<FindAppltid> tidlist= new ArrayList<FindAppltid>();
		 Map map=new HashMap();
		 for(FindAppltid findapplti : list) {
			 	map.put("g0anln1", findapplti.getAssetnumber());
				map.put("g0gsdm", findapplti.getSupplier());
				List<SreEquipmentLedger> sreequin  = sreEquipmentLedgerMapper.getSreDetailId(map);
				if(sreequin.size()!=0) {
				for(SreEquipmentLedger ledasd : sreequin) {
					if(ledasd!=null) {
						findapplti.setG0NDURJ(ledasd.getG0ndurj().toString());//使用年限
						findapplti.setG0SCHRW(ledasd.getG0schrw().toString());//资产残值
						findapplti.setG0LJGZYZJE(ledasd.getG0ljgzyzje().toString());//账面净额
						findapplti.setG0LJDJZJJE(ledasd.getG0ljdjzjje().toString());//预付定金
						findapplti.setG0NCGZYZJE(ledasd.getG0ncgzyzje().toString());//年初购置价值
						findapplti.setG0LJZJJE(ledasd.getG0ljzjje().toString());//累计折旧
						tidlist.add(findapplti);
					}
				  }
				}
		 }
		return tidlist;
	}
	   
}
