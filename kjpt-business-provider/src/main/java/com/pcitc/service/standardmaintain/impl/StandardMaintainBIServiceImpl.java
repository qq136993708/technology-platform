package com.pcitc.service.standardmaintain.impl;

import com.pcitc.base.standardmaintain.StandardMaintainBI;
import com.pcitc.config.NoMockCondition;
import com.pcitc.mapper.standardmaintain.StandardMaintainBIMapper;
import com.pcitc.service.standardmaintain.StandardMaintainBIService;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/***
 * @Author xiaoh
 * @Description 质量标准-领导驾驶舱
 * @Date 2020/6/8 17:25
 * @param
 * @return
 **/
@Service
@Conditional(NoMockCondition.class)
public class StandardMaintainBIServiceImpl implements StandardMaintainBIService {
    private StandardMaintainBIMapper mapper;

    @Override
    public List<StandardMaintainBI> getInternalResearchList(Map param) {
        List<StandardMaintainBI> awardList = new ArrayList<StandardMaintainBI>();
        awardList = mapper.getInternalResearchList(param);
        return awardList;
    }

    @Override
    public List<StandardMaintainBI> getInternalPublishList(Map param) {
        List<StandardMaintainBI> awardList = new ArrayList<StandardMaintainBI>();
        awardList = mapper.getInternalPublishList(param);
        return awardList;
    }

    @Override
    public List<StandardMaintainBI> getInternationalAllList(Map param) {
        List<StandardMaintainBI> awardList = new ArrayList<StandardMaintainBI>();
        awardList = mapper.getInternationalAllList(param);
        return awardList;
    }
}
