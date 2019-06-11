package com.pcitc.mapper.system;

import com.pcitc.base.system.SysConfig;
import com.pcitc.base.system.SysConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysConfigMapper {
    long countByExample(SysConfigExample example);

	int deleteByExample(SysConfigExample example);

	int deleteByPrimaryKey(String configId);

	int insert(SysConfig record);

	int insertSelective(SysConfig record);

	List<SysConfig> selectByExample(SysConfigExample example);

	SysConfig selectByPrimaryKey(String configId);

	int updateByExampleSelective(@Param("record") SysConfig record, @Param("example") SysConfigExample example);

	int updateByExample(@Param("record") SysConfig record, @Param("example") SysConfigExample example);

	int updateByPrimaryKeySelective(SysConfig record);

	int updateByPrimaryKey(SysConfig record);
}