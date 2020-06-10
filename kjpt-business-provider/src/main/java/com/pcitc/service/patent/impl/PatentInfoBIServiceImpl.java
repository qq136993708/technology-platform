package com.pcitc.service.patent.impl;

import com.pcitc.base.indexHome.calResult;
import com.pcitc.config.NoMockCondition;
import com.pcitc.mapper.patent.PatentInfoBIMapper;
import com.pcitc.service.patent.PatentInfoBIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/***
 * @Author xiaoh
 * @Description 知识产权-领导驾驶舱
 * @Date 2020/6/9 16:35
 * @param
 * @return
 **/
@Service
@Conditional(NoMockCondition.class)
public class PatentInfoBIServiceImpl implements PatentInfoBIService {
    @Autowired
    private PatentInfoBIMapper mapper;

    @Override
    public List<calResult> getPatentCountByYear(Map param) {
        List<calResult> cList = new ArrayList<calResult>();
        cList = mapper.getPatentCountByYear(param);
        return cList;
    }

    @Override
    public List<calResult> getPatentCountByLegelStatus(Map param) {
        List<calResult> cList = new ArrayList<calResult>();
        cList = mapper.getPatentCountByLegelStatus(param);
        return cList;
    }

    @Override
    public List<calResult> getPatentCountByOffice(Map param) {
        List<calResult> cList = new ArrayList<calResult>();
        cList = mapper.getPatentCountByOffice(param);
        return cList;
    }
}