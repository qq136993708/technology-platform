package com.pcitc.mapper.expert;

import com.pcitc.base.expert.ZjkExtractConfig;
import com.pcitc.base.expert.ZjkExtractConfigExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ZjkExtractConfigMapper {
    long countByExample(ZjkExtractConfigExample example);

    int deleteByExample(ZjkExtractConfigExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(ZjkExtractConfig record);

    int insertSelective(ZjkExtractConfig record);

    List<ZjkExtractConfig> selectByExample(ZjkExtractConfigExample example);

    ZjkExtractConfig selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") ZjkExtractConfig record, @Param("example") ZjkExtractConfigExample example);

    int updateByExample(@Param("record") ZjkExtractConfig record, @Param("example") ZjkExtractConfigExample example);

    int updateByPrimaryKeySelective(ZjkExtractConfig record);

    int updateByPrimaryKey(ZjkExtractConfig record);

    int updateByPrimaryKeyWithBLOBs(ZjkExtractConfig record);

    List<ZjkExtractConfig> findZjkExtractConfigByPage(Map<String, Object> map);

    List<ZjkExtractConfig> findZjkExtractConfigList(ZjkExtractConfig record);

}