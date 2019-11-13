package com.pcitc.mapper.doc;

import com.pcitc.base.doc.SysFileCollect;
import com.pcitc.base.doc.SysFileCollectExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SysFileCollectMapper {
    long countByExample(SysFileCollectExample example);

    int deleteByExample(SysFileCollectExample example);

    int deleteByPrimaryKey(String menuId);

    int insert(SysFileCollect record);

    int insertSelective(SysFileCollect record);

    List<SysFileCollect> selectByExample(SysFileCollectExample example);

    SysFileCollect selectByPrimaryKey(String menuId);

    int updateByExampleSelective(@Param("record") SysFileCollect record, @Param("example") SysFileCollectExample example);

    int updateByExample(@Param("record") SysFileCollect record, @Param("example") SysFileCollectExample example);

    int updateByPrimaryKeySelective(SysFileCollect record);

    int updateByPrimaryKey(SysFileCollect record);

    int updateByPrimaryKeyWithBLOBs(SysFileCollect record);

    List<SysFileCollect> findSysFileCollectByPage(Map<String, Object> map);

    List<SysFileCollect> findSysFileCollectList(SysFileCollect record);

    /**
     * 根据文件
     * @param fileId
     */
    void deleteObjByParam(String fileId);

}