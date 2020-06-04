package com.pcitc.mapper.achieve;

import com.pcitc.base.achieve.AchieveMaintain;
import com.pcitc.base.achieve.AchieveMaintainBI;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/***
 * @Author xiaoh
 * @Description 成果维护领导驾驶舱
 * @Date 2020/6/4 16:29
 * @param
 * @return
 **/
public interface AchieveMaintainBIMapper {

    /**
     * 获奖按年份统计--年份，获奖类型
     */
    List<AchieveMaintainBI> getAwardSumByQuery(Map paramMap);


}
