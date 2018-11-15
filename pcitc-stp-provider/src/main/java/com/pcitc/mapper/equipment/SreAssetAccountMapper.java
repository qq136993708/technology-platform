package com.pcitc.mapper.equipment;

import com.pcitc.base.stp.equipment.SreAssetAccount;
import com.pcitc.base.stp.equipment.SreAssetAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SreAssetAccountMapper {
    int countByExample(SreAssetAccountExample example);

    int deleteByExample(SreAssetAccountExample example);

    int deleteByPrimaryKey(String accountId);

    int insert(SreAssetAccount record);

    int insertSelective(SreAssetAccount record);

    List<SreAssetAccount> selectByExample(SreAssetAccountExample example);

    SreAssetAccount selectByPrimaryKey(String accountId);

    int updateByExampleSelective(@Param("record") SreAssetAccount record, @Param("example") SreAssetAccountExample example);

    int updateByExample(@Param("record") SreAssetAccount record, @Param("example") SreAssetAccountExample example);

    int updateByPrimaryKeySelective(SreAssetAccount record);

    int updateByPrimaryKey(SreAssetAccount record);
}