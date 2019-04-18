package com.pcitc.mapper.system;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pcitc.base.system.SysDataModel;
import com.pcitc.base.system.SysDataModelExample;

public interface SysDataModelMapper {
    int countByExample(SysDataModelExample example);

    int deleteByExample(SysDataModelExample example);

    int insert(SysDataModel record);

    int insertSelective(SysDataModel record);

    List<SysDataModel> selectByExample(SysDataModelExample example);

    int updateByExampleSelective(@Param("record") SysDataModel record, @Param("example") SysDataModelExample example);

    int updateByExample(@Param("record") SysDataModel record, @Param("example") SysDataModelExample example);

    List<SysDataModel> selectDataModeWithGroup(HashMap<String, Object> paraMap);
    
    public Integer batchInsertSysDataModel(List<SysDataModel> dmList);
}