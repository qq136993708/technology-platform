package com.pcitc.service.index.impl;

import com.pcitc.base.indexHome.calResult;
import com.pcitc.config.NoMockCondition;
import com.pcitc.mapper.index.IndexHomeBIMapper;
import com.pcitc.service.index.IndexHomeBIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Conditional(NoMockCondition.class)
public class IndexHomeBIServiceImpl implements IndexHomeBIService {
    @Autowired
    private IndexHomeBIMapper mapper;

    @Override
    public List<calResult> getTechnologyExpert(Map param) {
        List<calResult> cList = new ArrayList<calResult>();
        cList = mapper.getTechnologyExpert(param);
        return cList;
    }

    @Override
    public List<calResult> getTechnologyPlatform(Map param) {
        List<calResult> cList = new ArrayList<calResult>();
        cList = mapper.getTechnologyPlatform(param);
        return cList;
    }

    @Override
    public List<calResult> getAchieveAward(Map param) {
        List<calResult> cList = new ArrayList<calResult>();
        cList = mapper.getAchieveAward(param);
        return cList;
    }

    @Override
    public List<calResult> getIntellectualProperty(Map param) {
        List<calResult> cList = new ArrayList<calResult>();
        cList = mapper.getIntellectualProperty(param);
        return cList;
    }

    @Override
    public List<calResult> getPatent(Map param) {
        List<calResult> cList = new ArrayList<calResult>();
        cList = mapper.getPatent(param);
        return cList;
    }

    @Override
    public List<calResult> getAchieveTransfer(Map param) {
        List<calResult> cList = new ArrayList<calResult>();
        cList = mapper.getAchieveTransfer(param);
        return cList;
    }

    @Override
    public List<calResult> getTechnologyProject(Map param) {
        List<calResult> cList = new ArrayList<calResult>();
        cList = mapper.getTechnologyProject(param);
        return cList;
    }

    @Override
    public List<calResult> getProjectInvest(Map param) {
        List<calResult> cList = new ArrayList<calResult>();
        cList = mapper.getProjectInvest(param);
        return cList;
    }

    @Override
    public List<calResult> getQualityInfo(Map param) {
        List<calResult> cList = new ArrayList<calResult>();
        cList = mapper.getQualityInfo(param);
        return cList;
    }

    @Override
    public List distribution(Map param) {
        return mapper.distribution(param);
    }
}
