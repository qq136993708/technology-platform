package com.pcitc.service.equipment;

import java.util.List;

import com.pcitc.base.stp.equipment.FindAppltid;
import com.pcitc.base.stp.equipment.sre_scrap_apply_item;

public interface SreScrapApplyItemService {
	
public int insert(sre_scrap_apply_item record)throws Exception;

public List<FindAppltid> selectByAppltidList(String id)throws Exception;

public int deleteByApplyId(String applyid)throws Exception;
}
