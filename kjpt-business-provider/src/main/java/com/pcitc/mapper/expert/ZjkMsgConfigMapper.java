package com.pcitc.mapper.expert;

import com.pcitc.base.expert.ZjkMsgConfig;
import com.pcitc.base.expert.ZjkMsgConfigExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ZjkMsgConfigMapper {
    long countByExample(ZjkMsgConfigExample example);

    int deleteByExample(ZjkMsgConfigExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(ZjkMsgConfig record);

    int insertSelective(ZjkMsgConfig record);

    List<ZjkMsgConfig> selectByExample(ZjkMsgConfigExample example);

    ZjkMsgConfig selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") ZjkMsgConfig record, @Param("example") ZjkMsgConfigExample example);

    int updateByExample(@Param("record") ZjkMsgConfig record, @Param("example") ZjkMsgConfigExample example);

    int updateByPrimaryKeySelective(ZjkMsgConfig record);

    int updateByPrimaryKey(ZjkMsgConfig record);

    int updateByPrimaryKeyWithBLOBs(ZjkMsgConfig record);

    List<ZjkMsgConfig> findZjkMsgConfigByPage(Map<String, Object> map);

    List<ZjkMsgConfig> findZjkMsgConfigList(ZjkMsgConfig record);

}