package com.pcitc.mapper.system;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pcitc.base.system.SysFunctionProperty;
import com.pcitc.base.system.SysFunctionPropertyExample;

public interface SysFunctionPropertyMapper {
    int countByExample(SysFunctionPropertyExample example);

    int deleteByExample(SysFunctionPropertyExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysFunctionProperty record);

    int insertSelective(SysFunctionProperty record);

    List<SysFunctionProperty> selectByExample(SysFunctionPropertyExample example);

    SysFunctionProperty selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysFunctionProperty record, @Param("example") SysFunctionPropertyExample example);

    int updateByExample(@Param("record") SysFunctionProperty record, @Param("example") SysFunctionPropertyExample example);

    int updateByPrimaryKeySelective(SysFunctionProperty record);

    int updateByPrimaryKey(SysFunctionProperty record);
    
    /**
     * 查询已经某个菜单、某个配置项、某个岗位已经配置的研究院
     * @return
     */
    public List selectInstituteData(HashMap<String, Object> hashmap);
}