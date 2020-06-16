package com.pcitc.service.achieve.impl;

import com.pcitc.base.achieve.AchieveMaintainBI;
import com.pcitc.base.achieve.AchieveRecordBI;
import com.pcitc.config.MockCondition;
import com.pcitc.service.achieve.AchieveMaintainBIService;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Conditional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/***
 * @Author xiaoh
 * @Description 成果管理驾驶舱模拟数据
 * @Date 2020/6/4 14:39
 * @param
 * @return
 **/

@Conditional(MockCondition.class)
@Service("AchieveMaintainBIServiceImpl")
public class AchieveMaintainBIMockServiceImpl extends AchieveMaintainBIServiceImpl {
   /* @Autowired
    private AchieveMaintainBIMapper xmapper;*/

    @Override
    public List<AchieveMaintainBI> getAwardSumByQuery(Map paramMap) {
        List<AchieveMaintainBI> awardList = new ArrayList<AchieveMaintainBI>();
        String[] years = {"2016","2017","2018","2019","2020"};
        String[] types = {"模拟国家级奖","省部级奖","集团奖","社会奖项"};

        int[][] sums = {{4,24,30,16},{16,40,56,22},{4,24,30,18},{4,24,30,16},{16,40,56,22}};
        for(int i=0;i<years.length;i++){
            for(int j=0;j<types.length;j++){
                AchieveMaintainBI temp = new AchieveMaintainBI();
                temp.setYear(years[i]);
                temp.setType(""+i);
                temp.setTypeText(types[j]);
                temp.setAwardsNumberSum(sums[i][j]);
                awardList.add(temp);
            }
        }
        return awardList;
    }

    @Override
    public List<AchieveMaintainBI> getAwardSumByTypePie(Map paramMap) {
        List<AchieveMaintainBI> awardList = new ArrayList<AchieveMaintainBI>();
        String[] awardChildType = {"国家科学技术奖","国防科学技术奖","军队科技进步奖","其他省部级科技奖","中核集团科技奖","社会奖项"};
        int[] nums = {36,63,24,24,16,12};
        for(int i=0;i<awardChildType.length;i++){
            AchieveMaintainBI temp = new AchieveMaintainBI();
            temp.setAwardsChildTypeText(awardChildType[i]);
            temp.setAwardsNumberSum(nums[i]);
            awardList.add(temp);
        }
        return awardList;
    }


    @Override
    public List<AchieveMaintainBI> getAwardDetailByQuery(Map paramMap) {
        List<AchieveMaintainBI> awardList = new ArrayList<AchieveMaintainBI>();
        AchieveMaintainBI temp = new AchieveMaintainBI();
        temp.setYear("2019");
        temp.setTypeText("国家级奖");
        temp.setAwardsTypeText("国防科技技术奖");
        temp.setAwardsChildTypeText("国家科学技术进步奖");
        temp.setAwardLevel("一等奖");
        temp.setAwardsNumber("3");
        awardList.add(temp);
        AchieveMaintainBI temp1 = new AchieveMaintainBI();
        temp1.setYear("2019");
        temp1.setTypeText("集团级奖");
        temp1.setAwardsTypeText("军队科技进步奖");
        temp1.setAwardsChildTypeText("国家技术发明奖");
        temp1.setAwardLevel("一等奖");
        temp1.setAwardsNumber("3");
        awardList.add(temp1);
        AchieveMaintainBI temp2 = new AchieveMaintainBI();
        temp2.setYear("2019");
        temp2.setTypeText("省部级奖");
        temp2.setAwardsTypeText("军队科技进步奖");
        temp2.setAwardsChildTypeText("军队创新发明奖");
        temp2.setAwardLevel("一等奖");
        temp2.setAwardsNumber("5");
        awardList.add(temp2);
        AchieveMaintainBI temp3 = new AchieveMaintainBI();
        temp3.setYear("2019");
        temp3.setTypeText("省部级奖");
        temp3.setAwardsTypeText("各省科技奖");
        temp3.setAwardsChildTypeText("某科技项目");
        temp3.setAwardLevel("二等奖");
        temp3.setAwardsNumber("8");
        awardList.add(temp3);
        AchieveMaintainBI temp4 = new AchieveMaintainBI();
        temp4.setYear("2019");
        temp4.setTypeText("省部级奖");
        temp4.setAwardsTypeText("国土资源部科学技术奖");
        temp4.setAwardsChildTypeText("国土资源部科学技术奖");
        temp4.setAwardLevel("三等奖");
        temp4.setAwardsNumber("8");
        awardList.add(temp4);
        AchieveMaintainBI temp5 = new AchieveMaintainBI();
        temp5.setYear("2019");
        temp5.setTypeText("社会奖项");
        temp5.setAwardsTypeText("中电连电力创新奖");
        temp5.setAwardsChildTypeText("电力科技创新奖");
        temp5.setAwardLevel("三等奖");
        temp5.setAwardsNumber("8");
        awardList.add(temp5);
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
