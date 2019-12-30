package com.pcitc.mapper.qims;

import com.pcitc.base.qims.QualityStatistics;

import java.util.List;
import java.util.Map;


/**
 * @author ty
 */
public interface QualityStatisticsMapper {
    int insert(QualityStatistics qualityStatistics);
    List<QualityStatistics> queryQualityStatisticsList(Map param);
}
