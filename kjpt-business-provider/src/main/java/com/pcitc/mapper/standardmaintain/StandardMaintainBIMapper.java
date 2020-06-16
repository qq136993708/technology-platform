package com.pcitc.mapper.standardmaintain;

import com.pcitc.base.standardmaintain.StandardMaintain;
import com.pcitc.base.standardmaintain.StandardMaintainBI;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/***
 * @Author xiaoh
 * @Description 质量标准领导驾驶舱
 * @Date 2020/6/9 9:27
 * @param
 * @return
 **/
public interface StandardMaintainBIMapper {

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
