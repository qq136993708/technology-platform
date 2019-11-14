package com.pcitc.mapper.researchplatform;

import com.pcitc.base.researchPlatform.PlatformInfoModel;

import java.util.List;

public interface PlatformServiceMapper {

    /**
     * 根据主键获取一个平台的信息
     */
    PlatformInfoModel load(String id);
    /**
     * 保存科研平台
     */
    int save(PlatformInfoModel platformInfoModel);
    /**
     * 查询科研平台列表
     */
    List<PlatformInfoModel> query();

}
