package com.pcitc.service.achieve;

import com.pcitc.base.achieve.AchieveMaintainBI;
import com.pcitc.base.achieve.AchieveRecordBI;

import java.util.List;
import java.util.Map;

/***
 * @Author xiaoh
 * @Description 成果管理驾驶舱
 * @Date 2020/6/4 14:31
 * @param
 * @return
 **/
public interface AchieveMaintainBIService {

    /**
     * 获奖按年份统计--年份，获奖类型
     */
    List<AchieveMaintainBI> getAwardSumByQuery(Map paramMap);

    /***
     * 获奖按年份统计 - 饼图
     **/
    List<AchieveMaintainBI> getAwardSumByTypePie(Map paramMap);

    /***
     * 获奖明细
     **/
    List<AchieveMaintainBI> getAwardDetailByQuery(Map paramMap);

    /***
     * 历年成果转化完成情况
     **/
    List<AchieveRecordBI> getAchieveTransferByYear(Map paramMap);

    /***
     * 成果转化方式
     **/
    List<AchieveRecordBI> getAchieveTransferByType(Map paramMap);

    /***
     * 二级单位成果转化情况
     **/
    List<AchieveRecordBI> getAchieveTransferByOffice(Map paramMap);
}
