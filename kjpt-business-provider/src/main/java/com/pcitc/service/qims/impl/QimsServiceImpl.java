package com.pcitc.service.qims.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.qims.QualityStatistics;
import com.pcitc.base.util.DateUtils;
import com.pcitc.mapper.qims.QualityStatisticsMapper;
import com.pcitc.service.qims.QimsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>接口类</p>
 * <p>Table: patent_info - 专利信息</p>
 *
 * @since 2019-11-16 04:10:36
 */
@Service("QimsService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class QimsServiceImpl implements QimsService {

    @Resource
    private QualityStatisticsMapper qualityStatisticsMapper;

    /**
     * 插入质量信息
     *
     * @param qualityStatistics
     * @return
     */
    public QualityStatistics save(QualityStatistics qualityStatistics){
        qualityStatisticsMapper.insert(qualityStatistics);
        return qualityStatistics;
    }

    @Override
    public PageInfo queryQualityStatisticsList(Map param) {
        int pageNum = (int)param.get("pageNum");
        int pageSize = (int)param.get("pageSize");
        PageHelper.startPage(pageNum, pageSize);
        List<QualityStatistics> dataList = qualityStatisticsMapper.queryQualityStatisticsList(param);
        dataList.forEach(qualityStatistics ->{
            qualityStatistics.setDateStr(DateUtils.format(qualityStatistics.getDate(),DateUtils.FMT_SS));
            System.out.println(qualityStatistics);
        });
        PageInfo pageInfo = new PageInfo(dataList);

        return pageInfo;
    }
}