package com.pcitc.mapper.expert;

import com.pcitc.base.expert.ZjkExpertProject;
import com.pcitc.base.expert.ZjkExpertProjectExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ZjkExpertProjectMapper {
    long countByExample(ZjkExpertProjectExample example);

    int deleteByExample(ZjkExpertProjectExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(ZjkExpertProject record);

    int insertSelective(ZjkExpertProject record);

    List<ZjkExpertProject> selectByExample(ZjkExpertProjectExample example);

    ZjkExpertProject selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") ZjkExpertProject record, @Param("example") ZjkExpertProjectExample example);

    int updateByExample(@Param("record") ZjkExpertProject record, @Param("example") ZjkExpertProjectExample example);

    int updateByPrimaryKeySelective(ZjkExpertProject record);

    int updateByPrimaryKey(ZjkExpertProject record);

    int updateByPrimaryKeyWithBLOBs(ZjkExpertProject record);

    List<ZjkExpertProject> findZjkExpertProjectByPage(Map<String, Object> map);

    List<ZjkExpertProject> findZjkExpertProjectList(ZjkExpertProject record);

}