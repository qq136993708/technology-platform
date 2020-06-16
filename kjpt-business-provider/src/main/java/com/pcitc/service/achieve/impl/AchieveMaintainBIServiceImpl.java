package com.pcitc.service.achieve.impl;

import com.pcitc.base.achieve.AchieveMaintainBI;
import com.pcitc.base.achieve.AchieveRecordBI;
import com.pcitc.config.NoMockCondition;
import com.pcitc.mapper.achieve.AchieveMaintainBIMapper;
import com.pcitc.service.achieve.AchieveMaintainBIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/***
 * @Author xiaoh
 * @Description 成果管理驾驶舱
 * @Date 2020/6/4 14:39
 * @param
 * @return
 **/
@Service
@Conditional(NoMockCondition.class)
public class AchieveMaintainBIServiceImpl implements AchieveMaintainBIService {
    @Autowired
    private AchieveMaintainBIMapper mapper;

    @Override
    public List<AchieveMaintainBI> getAwardSumByQuery(Map paramMap) {
        List<AchieveMaintainBI> awardList = new ArrayList<AchieveMaintainBI>();
        awardList = mapper.getAwardSumByQuery(paramMap);
        return awardList;
    }

    @Override
    public List<AchieveMaintainBI> getAwardSumByTypePie(Map paramMap) {
        List<AchieveMaintainBI> awardList = new ArrayList<AchieveMaintainBI>();
        awardList = mapper.getAwardSumByQuery(paramMap);
        return awardList;
    }


    @Override
    public List<AchieveMaintainBI> getAwardDetailByQuery(Map paramMap) {
        List<AchieveMaintainBI> awardList = new ArrayList<AchieveMaintainBI>();
        awardList = mapper.getAwardDetailByQuery(paramMap);
        return awardList;
    }

    @Override
    public List<AchieveRecordBI> getAchieveTransferByYear(Map paramMap) {
        return null;
    }

    @Override
    public List<AchieveRecordBI> getAchieveTransferByType(Map paramMap) {
        return null;
    }

    @Override
    public List<AchieveRecordBI> getAchieveTransferByOffice(Map paramMap) {
        return null;
    }


}
