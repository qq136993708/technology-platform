package com.pcitc.service.qims;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.patent.PatentInfo;
import com.pcitc.base.qims.QualityStatistics;

import java.util.List;
import java.util.Map;

/**
 * <p>接口类</p>
 * <p>Table: Quality statistics - 质量信息</p>
 *
 * @since 2019-12-27 14:56:36
 */
public interface QimsService {

    /**
     * 插入质量信息
     *
     * @param qualityStatistics
     * @return
     */
    QualityStatistics save(QualityStatistics qualityStatistics);

    /**
     * 质量列表分页查询
     * @param param
     * @return
     */
    PageInfo queryQualityStatisticsList(Map param);
}