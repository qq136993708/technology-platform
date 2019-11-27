package com.pcitc.service.researchplatform;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.researchplatform.PlatformPatentModel;
import com.pcitc.base.researchplatform.PlatformProjectModel;

import java.util.List;
import java.util.Map;

/**
 * 科研平台项目的增删改查
 * @author ty
 */
public interface PlatformProjectService {

    /**
     * 根据主键获取一个平台项目的信息
     */
    PlatformProjectModel load(String id);
    /**
     * 保存科研平台项目
     */
    PlatformProjectModel save(PlatformProjectModel platformProjectModel);
    /**
     * 查询科研平台项目列表分页
     */
    PageInfo query(Map paramMap);

    /**
     * 查询科研平台成员列表
     */
    List<PlatformProjectModel> queryNoPage(Map paramMap);

    /**
     * 科研平台项目删除
     */
    Integer delete(String id);

    /**
     * 批量保存平台项目
     */
    Integer batchSave(List<PlatformProjectModel> dataList);

}
