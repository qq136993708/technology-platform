package com.pcitc.mapper.system;

import java.util.List;

import com.pcitc.base.system.SysNews;

public interface SysNewsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysNews record);

    int insertSelective(SysNews record);

    SysNews selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysNews record);

    int updateByPrimaryKeyWithBLOBs(SysNews record);

    int updateByPrimaryKey(SysNews record);
    
    /**
     * 获取所有新闻列表
     * @param news
     * @return
     */
    List<SysNews> selectNews(SysNews news);

    /**
     * 首页:查询新闻信息
     * @param news
     * @return
     */
    List<SysNews> selectNewsMain(SysNews news);
}