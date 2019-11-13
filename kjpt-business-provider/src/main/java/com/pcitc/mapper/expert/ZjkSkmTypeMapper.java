package com.pcitc.mapper.expert;

import com.pcitc.base.expert.ZjkSkmType;
import com.pcitc.base.expert.ZjkSkmTypeExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ZjkSkmTypeMapper {
    long countByExample(ZjkSkmTypeExample example);

    int deleteByExample(ZjkSkmTypeExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(ZjkSkmType record);

    int insertSelective(ZjkSkmType record);

    List<ZjkSkmType> selectByExample(ZjkSkmTypeExample example);

    ZjkSkmType selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") ZjkSkmType record, @Param("example") ZjkSkmTypeExample example);

    int updateByExample(@Param("record") ZjkSkmType record, @Param("example") ZjkSkmTypeExample example);

    int updateByPrimaryKeySelective(ZjkSkmType record);

    int updateByPrimaryKey(ZjkSkmType record);

    int updateByPrimaryKeyWithBLOBs(ZjkSkmType record);

    List<ZjkSkmType> findZjkSkmTypeByPage(Map<String, Object> map);

    List<ZjkSkmType> findZjkSkmTypeList(ZjkSkmType record);

}