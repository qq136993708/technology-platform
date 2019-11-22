package com.pcitc.mapper.researchplatform;

import com.pcitc.base.researchplatform.PlatformTreatiseModel;

import java.util.List;
import java.util.Map;

public interface PlatformTreatiseMapper {

    /**
     * 根据主键获取一个平台论文的信息
     */
    PlatformTreatiseModel load(String id);
    /**
     * 保存科研平台
     */
    int add(PlatformTreatiseModel platformTreatiseModel);
    /**
     * 查询科研平台列表
     */
    List<PlatformTreatiseModel> query(Map paramMap);


    /**
     * 修改科研平台
     */
    int update(PlatformTreatiseModel platformTreatiseModel);

    /**
     * 逻辑删
     */
    int delete(String id);

    /**
     * 批量添加
     */
    int batchSave(List<PlatformTreatiseModel> list);

}
