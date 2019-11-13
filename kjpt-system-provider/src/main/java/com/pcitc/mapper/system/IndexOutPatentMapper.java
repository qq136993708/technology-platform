package com.pcitc.mapper.system;

import com.pcitc.base.system.IndexOutPatent;
import com.pcitc.base.system.IndexOutPatentExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface IndexOutPatentMapper {
    long countByExample(IndexOutPatentExample example);

    int deleteByExample(IndexOutPatentExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(IndexOutPatent record);

    int insertSelective(IndexOutPatent record);

    List<IndexOutPatent> selectByExample(IndexOutPatentExample example);

    IndexOutPatent selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") IndexOutPatent record, @Param("example") IndexOutPatentExample example);

    int updateByExample(@Param("record") IndexOutPatent record, @Param("example") IndexOutPatentExample example);

    int updateByPrimaryKeySelective(IndexOutPatent record);

    int updateByPrimaryKey(IndexOutPatent record);

    int updateByPrimaryKeyWithBLOBs(IndexOutPatent record);

    List<IndexOutPatent> findIndexOutPatentByPage(Map<String, Object> map);

    List<IndexOutPatent> findIndexOutPatentList(IndexOutPatent record);

}