package com.pcitc.mapper.expert;

import com.pcitc.base.expert.ZjkBaseInfo;
import com.pcitc.base.expert.ZjkBaseInfoExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ZjkBaseInfoMapper {
    long countByExample(ZjkBaseInfoExample example);

    int deleteByExample(ZjkBaseInfoExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(ZjkBaseInfo record);

    int insertSelective(ZjkBaseInfo record);

    List<ZjkBaseInfo> selectByExample(ZjkBaseInfoExample example);

    ZjkBaseInfo selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") ZjkBaseInfo record, @Param("example") ZjkBaseInfoExample example);

    int updateByExample(@Param("record") ZjkBaseInfo record, @Param("example") ZjkBaseInfoExample example);

    int updateByPrimaryKeySelective(ZjkBaseInfo record);

    int updateByPrimaryKey(ZjkBaseInfo record);

    int updateByPrimaryKeyWithBLOBs(ZjkBaseInfo record);

    List<ZjkBaseInfo> findZjkBaseInfoByPage(Map<String, Object> map);

    List<ZjkBaseInfo> findZjkBaseInfoList(ZjkBaseInfo record);

    List<Map<String,Object>> listSqlResult(Map<String,Object> map);

}