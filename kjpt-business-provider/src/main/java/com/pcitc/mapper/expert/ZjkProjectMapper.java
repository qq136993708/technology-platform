package com.pcitc.mapper.expert;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.pcitc.base.expert.ZjkProject;

@Repository
public interface ZjkProjectMapper  {
	
	int deleteByPrimaryKey(String id);

    int insert(ZjkProject record);

    int insertSelective(ZjkProject record);

    ZjkProject selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ZjkProject record);

    int updateByPrimaryKey(ZjkProject record);
    List getList(Map map);
    int getCount(Map map);
    
    //根据专家ID逻辑删除项目信息
    int  deleteLogicZjkProjectByExpertId(String expertId);
    //根据专家ID删除项目信息
    int  deleteZjkProjectByExpertId(String expertId);
    
    int  deleteLogicZjkProjectById(String id);
    
    List getListByExpertId(String expertId);

    /**
     * 查询专家信息管理项目列表
     */
    List<ZjkProject> query(Map paramMap);
    
}