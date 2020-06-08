package com.pcitc.service.achieve.impl;

import com.pcitc.base.achieve.AchieveMaintainBI;
import com.pcitc.base.achieve.AchieveRecordBI;
import com.pcitc.config.NoMockCondition;
import com.pcitc.mapper.achieve.AchieveMaintainBIMapper;
import com.pcitc.mapper.achieve.AchieveMaintainMapper;
import com.pcitc.service.achieve.AchieveMaintainBIService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
    @Autowired
    private AchieveMaintainMapper amapper;

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
        awardList = amapper.query(paramMap);
        return awardList;
    }

    @Override
    public List<AchieveRecordBI> getAchieveTransferByYear(Map paramMap) {
        List<AchieveRecordBI> recorddList = new ArrayList<AchieveRecordBI>();
        String[] years = {"2016","2017","2018","2019","2020"};
        int[] amont = {10,21,48,64,78};
        int[] money = {400,899,1678,5123,9878};
        for(int i=0;i<years.length;i++){
            AchieveRecordBI temp = new AchieveRecordBI();
            temp.setYear(years[i]);
            temp.setTransMoneySum(BigDecimal.valueOf(money[i]));
            temp.setTransAmount(amont[i]);
            recorddList.add(temp);
        }
        return recorddList;
    }

    @Override
    public List<AchieveRecordBI> getAchieveTransferByType(Map paramMap) {
        List<AchieveRecordBI> recorddList = new ArrayList<AchieveRecordBI>();
        String[] types = {"技术许可","技术转让","作价投资","自行实施"};
        int[] amont = {28,63,63,46};
        int[] money = {2600,2000,1680,1200};
        for(int i=0;i<types.length;i++){
            AchieveRecordBI temp = new AchieveRecordBI();
            temp.setAchieveTransTypeText(types[i]);
            temp.setTransMoneySum(BigDecimal.valueOf(money[i]));
            temp.setTransAmount(amont[i]);
            recorddList.add(temp);
        }
        return recorddList;
    }

    @Override
    public List<AchieveRecordBI> getAchieveTransferByOffice(Map paramMap) {
        List<AchieveRecordBI> recorddList = new ArrayList<AchieveRecordBI>();
        String[] affiliatedUnitText = {"中国核电","中国原子能","中国铀业","中国核建","中核环保","中核中原","中核浦原","中核宝原","中核资本","核动力院","中核工程","原子能院","西物院","战略规划总院","中和咨询","中核能源","新华发电"};
        int[] amont = {80,75,70,63,55,50,45,40,40,35,35,35,30,30,30,30,30};
        int[] money = {6012,5980,5500,5400,5100,5000,4500,4300,4000,3500,3200,3200,3200,3200,3200,3200,3200};
        for(int i=0;i<affiliatedUnitText.length;i++){
            AchieveRecordBI temp = new AchieveRecordBI();
            temp.setAffiliatedUnitText(affiliatedUnitText[i]);
            temp.setTransMoneySum(BigDecimal.valueOf(money[i]));
            temp.setTransAmount(amont[i]);
            recorddList.add(temp);
        }
        return recorddList;
    }
}
