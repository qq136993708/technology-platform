package com.pcitc.service.patent;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.patent.PatentInfo;

import java.util.List;
import java.util.Map;

/**
 * <p>接口类</p>
 * <p>Table: patent_info - 专利信息</p>
 *
 * @since 2019-11-16 04:10:36
 */
public interface PatentInfoService {

    /**
     * 插入专利信息
     *
     * @param patentInfo
     * @return
     */
    PatentInfo updateOrInsertPatentInfo(PatentInfo patentInfo);

    /**
     * 专利列表分页查询
     * @param param
     * @return
     */
    PageInfo queryPatentList(Map param);

    /**
     * 专利列表分页查询
     * @param param
     * @return
     */
    List queryPatent(Map param);

    /**
     * 根据id查询专利信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    PatentInfo getPatentInfo(String id);

    /**
     * 根据id删除专利
     *
     * @param id
     * @return
     */
    Integer deletePatent(String id);
}