package com.pcitc.service.standardmaintain;

import com.pcitc.base.standardmaintain.StandardMaintainBI;

import java.util.List;
import java.util.Map;

/***
 * @Author xiaoh
 * @Description 质量标准-领导驾驶舱
 * @Date 2020/6/8 17:21
 * @param
 * @return
 **/
public interface StandardMaintainBIService {

    /**
     * 国内标准在研数
     */
    List<StandardMaintainBI> getInternalResearchList(Map param);

    /**
     * 国内累计发布数
     */
    List<StandardMaintainBI> getInternalPublishList(Map param);

    /**
     * 国际标准在研、累计发布数
     */
    List<StandardMaintainBI> getInternationalAllList(Map param);

}
