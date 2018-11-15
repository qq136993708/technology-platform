package com.pcitc.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pcitc.base.system.SysTableEncode;
import com.pcitc.base.system.SysTableEncodeExample;

public interface SysTableEncodeMapper {
    long countByExample(SysTableEncodeExample example);

    int deleteByExample(SysTableEncodeExample example);

    int deleteByPrimaryKey(String dataId);

    int insert(SysTableEncode record);

    int insertSelective(SysTableEncode record);

    List<SysTableEncode> selectByExample(SysTableEncodeExample example);

    SysTableEncode selectByPrimaryKey(String dataId);

    int updateByExampleSelective(@Param("record") SysTableEncode record, @Param("example") SysTableEncodeExample example);

    int updateByExample(@Param("record") SysTableEncode record, @Param("example") SysTableEncodeExample example);

    int updateByPrimaryKeySelective(SysTableEncode record);

    int updateByPrimaryKey(SysTableEncode record);
    
	List<SysTableEncode> querySysTableEncodeListByPage(SysTableEncode vo);

	Long countBySysTableEncode(SysTableEncode vo);
    
}