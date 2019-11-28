package com.pcitc.service.researchplatform;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.researchplatform.PlatformProjectModel;
import com.pcitc.base.researchplatform.PlatformTreatiseModel;

import java.util.List;
import java.util.Map;

/**
 * 科研平台项目的增删改查
 * @author ty
 */
public interface PlatformTreatiseService {

    /**
     * 根据主键获取一个平台项目的信息
     */
    PlatformTreatiseModel load(String id);
    /**
     * 保存科研平台项目
     */
    PlatformTreatiseModel save(PlatformTreatiseModel platformTreatiseModel);

    /**
     * 保存科研平台项目
     */
    Integer batchSave(List<PlatformTreatiseModel> dataList);
    /**
     * 查询科研平台项目列表分页
     */
    PageInfo query(Map paramMap);

    /**
     * 查询科研平台论文列表
     */
    List<PlatformTreatiseModel> queryNoPage(Map paramMap);

    /**
     * 科研平台项目删除
     */
    Integer delete(String id);

}
