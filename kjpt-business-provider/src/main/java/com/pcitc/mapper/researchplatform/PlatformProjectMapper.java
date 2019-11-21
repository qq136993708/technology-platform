package com.pcitc.mapper.researchplatform;

import com.pcitc.base.researchPlatform.PlatformProjectModel;

import java.util.List;
import java.util.Map;

public interface PlatformProjectMapper {

    /**
     * 根据主键获取一个平台项目的信息
     */
    PlatformProjectModel load(String id);
    /**
     * 保存平台项目
     */
    int add(PlatformProjectModel platformProjectModel);
    /**
     * 查询科研平台项目列表
     */
    List<PlatformProjectModel> query(Map paramMap);


    /**
     * 修改科研平台项目
     */
    int update(PlatformProjectModel platformProjectModel);

    /**
     * 逻辑删
     */
    int delete(String id);

}
