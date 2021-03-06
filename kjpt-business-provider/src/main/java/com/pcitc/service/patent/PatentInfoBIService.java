package com.pcitc.service.patent;

import com.pcitc.base.indexHome.calResult;

import java.util.List;
import java.util.Map;

/***
 * @Author xiaoh
 * @Description 知识产权-领导驾驶舱
 * @Date 2020/6/9 16:30
 * @param
 * @return
 **/
public interface PatentInfoBIService {

    /**
     * 历年申请/授权专利数量统计
     */
    List<calResult> getPatentCountByYear(Map param);

    /**
     * 法律状态
     */
    List<calResult> getPatentCountByLegelStatus(Map param);

    /**
     * 二级单位专利数量统计
     */
    List<calResult> getPatentCountByOffice(Map param);

}