package com.pcitc.mapper.researchplatform;

import com.pcitc.base.researchplatform.PlatformAchievementModel;
import com.pcitc.base.researchplatform.PlatformPatentModel;

import java.util.List;
import java.util.Map;

public interface PlatformPatentMapper {

    /**
     * 根据主键获取一个平台专利的信息
     */
    PlatformPatentModel load(String id);
    /**
     * 保存平台成果
     */
    int add(PlatformPatentModel platformPatentModel);
    /**
     * 查询科研平台专利列表
     */
    List<PlatformPatentModel> query(Map paramMap);


    /**
     * 修改科研平台专利
     */
    int update(PlatformPatentModel platformPatentModel);

    /**
     * 逻辑删
     */
    int delete(String id);

    /**
     * 批量添加
     */
    int batchSave(List<PlatformPatentModel> list);


}
