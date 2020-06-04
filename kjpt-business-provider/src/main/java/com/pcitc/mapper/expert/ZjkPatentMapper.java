package com.pcitc.mapper.expert;

import com.pcitc.base.expert.ZjkPatent;
import com.pcitc.base.out.OutPerson;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface ZjkPatentMapper {
    int deleteByPrimaryKey(String id);

    int insert(ZjkPatent record);

    int insertSelective(ZjkPatent record);

    ZjkPatent selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ZjkPatent record);

    int updateByPrimaryKey(ZjkPatent record);
    
    List getList(Map map);
    
    int getCount(Map map);
    
    
    
    //根据专家ID逻辑删除成果信息
    int  deleteLogicZjkPatentByExpertId(String expertId);
    
    //根据专家ID删除成果信息
    int  deleteZjkPatentByExpertId(String expertId);
    
    
    
    int  deleteLogicZjkPatentById(String expertId);
    
    List getListByExpertId(String expertId);


    /**
     * 查询专家信息管理项目列表
     */
    List<ZjkPatent> query(Map paramMap);
    
    

    public int deleteAll()throws Exception;
    public Integer insertBatch(List<ZjkPatent> list);
    
}