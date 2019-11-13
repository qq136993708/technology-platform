package com.pcitc.mapper.expert;

import com.pcitc.base.expert.ZjkComplaint;
import com.pcitc.base.expert.ZjkComplaintExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ZjkComplaintMapper {
    long countByExample(ZjkComplaintExample example);

    int deleteByExample(ZjkComplaintExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(ZjkComplaint record);

    int insertSelective(ZjkComplaint record);

    List<ZjkComplaint> selectByExample(ZjkComplaintExample example);

    ZjkComplaint selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") ZjkComplaint record, @Param("example") ZjkComplaintExample example);

    int updateByExample(@Param("record") ZjkComplaint record, @Param("example") ZjkComplaintExample example);

    int updateByPrimaryKeySelective(ZjkComplaint record);

    int updateByPrimaryKey(ZjkComplaint record);

    int updateByPrimaryKeyWithBLOBs(ZjkComplaint record);

    List<ZjkComplaint> findZjkComplaintByPage(Map<String, Object> map);

    List<ZjkComplaint> findZjkComplaintList(ZjkComplaint record);

}