package com.pcitc.service.researchplatform;

import com.pcitc.base.researchPlatform.PlatformInfoModel;

import java.util.List;

/**
 * 科研平台的增删改查
 * @author ty
 */
public interface PlatformService {

    /**
     * 根据主键获取一个平台的信息
     */
    PlatformInfoModel load(String id);
    /**
     * 保存科研平台
     */
    PlatformInfoModel save(PlatformInfoModel platformInfoModel);
    /**
     * 查询科研平台列表
     */
    List<PlatformInfoModel> query();
}