package com.pcitc.mapper.expert;

import com.pcitc.base.expert.ZjkMsg;
import com.pcitc.base.expert.ZjkMsgExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ZjkMsgMapper {
    long countByExample(ZjkMsgExample example);

    int deleteByExample(ZjkMsgExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(ZjkMsg record);

    int insertSelective(ZjkMsg record);

    List<ZjkMsg> selectByExample(ZjkMsgExample example);

    ZjkMsg selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") ZjkMsg record, @Param("example") ZjkMsgExample example);

    int updateByExample(@Param("record") ZjkMsg record, @Param("example") ZjkMsgExample example);

    int updateByPrimaryKeySelective(ZjkMsg record);

    int updateByPrimaryKey(ZjkMsg record);

    int updateByPrimaryKeyWithBLOBs(ZjkMsg record);

    List<ZjkMsg> findZjkMsgByPage(Map<String, Object> map);

    List<ZjkMsg> findZjkMsgList(ZjkMsg record);

}