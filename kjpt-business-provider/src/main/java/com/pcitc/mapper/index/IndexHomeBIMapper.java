package com.pcitc.mapper.index;


import com.pcitc.base.indexHome.calResult;

import java.util.List;
import java.util.Map;

/***
 * @Author xiaoh
 * @Description 领导驾驶舱 首页
 * @Date 2020/6/9 13:50
 * @param
 * @return
 **/
public interface IndexHomeBIMapper {

   /***
    *科技专家
    **/
    List<calResult> getTechnologyExpert(Map param);

    /***
     *科研平台
     **/
    List<calResult> getTechnologyPlatform(Map param);

    /***
     *成果获奖（累计）
     **/
    List<calResult> getAchieveAward(Map param);

    /***
     *知识产权（累计）
     **/
    List<calResult> getIntellectualProperty(Map param);

    /***
     *专利数量（累计）
     **/
    List<calResult> getPatent(Map param);

    /***
     *成果转化（累计）
     **/
    List<calResult> getAchieveTransfer(Map param);

    /***
     *科研项目（累计）
     **/
    List<calResult> getTechnologyProject(Map param);

    /***
     *项目投资（累计）
     **/
    List<calResult> getProjectInvest(Map param);

    /***
     *质量信息（累计）
     **/
    List<calResult> getQualityInfo(Map param);
}
