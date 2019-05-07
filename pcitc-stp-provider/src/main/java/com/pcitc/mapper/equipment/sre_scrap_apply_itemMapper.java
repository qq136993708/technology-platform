package com.pcitc.mapper.equipment;

import java.util.List;

import com.pcitc.base.stp.equipment.FindAppltid;
import com.pcitc.base.stp.equipment.SreScrapApply;
import com.pcitc.base.stp.equipment.sre_scrap_apply_item;

public interface sre_scrap_apply_itemMapper {
    int deleteByPrimaryKey(String accountId);

    int insert(sre_scrap_apply_item record);

    int insertSelective(sre_scrap_apply_item record);

    sre_scrap_apply_item selectByPrimaryKey(String accountId);

    int updateByPrimaryKeySelective(sre_scrap_apply_item record);

    int updateByPrimaryKey(sre_scrap_apply_item record);
    
    int deleteByApplyId(String applyid);
    
    List<FindAppltid> selectByAppltidList(String id);

    sre_scrap_apply_item scrpeqdetailid(String id);
	
}