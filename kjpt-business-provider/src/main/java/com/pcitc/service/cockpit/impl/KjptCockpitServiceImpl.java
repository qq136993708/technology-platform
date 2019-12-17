package com.pcitc.service.cockpit.impl;

import com.pcitc.mapper.cockpit.KjptCockpitMapper;
import com.pcitc.service.cockpit.KjptCockpitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class KjptCockpitServiceImpl implements KjptCockpitService {

    @Autowired
    private KjptCockpitMapper kjptCockpitMapper;

    /**
     * 知识产权-专利数量按专利类型占比分析
     */
    @Override
    public List<Map> knowledgeNumOrType(Map<String, Object> param) {
        return kjptCockpitMapper.knowledgeNumOrType(param);
    }

    /**
     * 知识产权-专利数量年度趋势分析
     */
    @Override
    public List<Map> knowledgeNumYearTrend(Map<String, Object> param) {
        return kjptCockpitMapper.knowledgeNumYearTrend(param);
    }

    /**
     * 知识产权-专利数量按单位同比分析
     */
    @Override
    public List<Map> knowledgeNumOrUnit(Map<String, Object> param) {
        return kjptCockpitMapper.knowledgeNumOrUnit(param);
    }

    /**
     * 科研平台-4大类别
     */
    @Override
    public List<Map> numScientificType(Map<String, Object> param) {
        return kjptCockpitMapper.numScientificType(param);
    }

    /**
     * 知科研平台-科研平台数量按技术领域
     */
    @Override
    public List<Map> numScientificTechnology(Map<String, Object> param) {
        return kjptCockpitMapper.numScientificTechnology(param);
    }

    /**
     * 首页-知识产权
     */
    @Override
    public List<Map> knowledgeRightCount(Map<String, Object> param) {
        return kjptCockpitMapper.knowledgeRightCount(param);
    }

    /**
     * 科技人才-数量按年龄
     */
    @Override
    public List<Map> personCountAge(Map<String, Object> param) {
        return kjptCockpitMapper.personCountAge(param);
    }

    /**
     * 科技人才-数量按职称
     */
    @Override
    public List<Map> personCountTitle(Map<String, Object> param) {
        return kjptCockpitMapper.personCountTitle(param);
    }

    /**
     * 科技人才-数量按学历
     */
    @Override
    public List<Map> personCountEducation(Map<String, Object> param) {
        return kjptCockpitMapper.personCountEducation(param);
    }

    /**
     * 科技人才-数量按技术领域
     */
    @Override
    public List<Map> personCountCompany(Map<String, Object> param) {
        return kjptCockpitMapper.personCountCompany(param);
    }

}
