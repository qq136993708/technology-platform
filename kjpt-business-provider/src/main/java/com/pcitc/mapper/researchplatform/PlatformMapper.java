package com.pcitc.mapper.researchplatform;

import com.pcitc.base.researchPlatform.PlatformInfoModel;

import java.util.List;
import java.util.Map;

public interface PlatformMapper {

    /**
     * 根据主键获取一个平台的信息
     */
    PlatformInfoModel load(String id);
    /**
     * 保存科研平台
     */
    int add(PlatformInfoModel platformInfoModel);
    /**
     * 查询科研平台列表
     */
    List<PlatformInfoModel> query(Map paramMap);


    /**
     * 修改科研平台
     */
    int update(PlatformInfoModel platformInfoModel);

    /**
     * 逻辑删
     */
    int delete(String id);

}
