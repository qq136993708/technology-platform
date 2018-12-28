package com.pcitc.mapper.expert;

import com.pcitc.base.expert.ZjkPatent;
import com.pcitc.base.expert.ZjkPatentExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ZjkPatentMapper {
    long countByExample(ZjkPatentExample example);

    int deleteByExample(ZjkPatentExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(ZjkPatent record);

    int insertSelective(ZjkPatent record);

    List<ZjkPatent> selectByExample(ZjkPatentExample example);

    ZjkPatent selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") ZjkPatent record, @Param("example") ZjkPatentExample example);

    int updateByExample(@Param("record") ZjkPatent record, @Param("example") ZjkPatentExample example);

    int updateByPrimaryKeySelective(ZjkPatent record);

    int updateByPrimaryKey(ZjkPatent record);

    int updateByPrimaryKeyWithBLOBs(ZjkPatent record);

    List<ZjkPatent> findZjkPatentByPage(Map<String, Object> map);

    List<ZjkPatent> findZjkPatentList(ZjkPatent record);

}