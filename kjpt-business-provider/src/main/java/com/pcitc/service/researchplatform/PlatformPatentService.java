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
public interface PlatformPatentService {

    /**
     * 根据主键获取一个平台专利的信息
     */
    PlatformPatentModel load(String id);
    /**
     * 保存科研平台专利
     */
    PlatformPatentModel save(PlatformPatentModel platformPatentModel);
    /**
     * 查询科研平台专利列表
     */
    PageInfo query(Map paramMap);

    /**
     * 科研平台专利删除
     */
    Integer delete(String id);

    /**
     * 批量保存平台专利
     */
    Integer batchSave(List<PlatformPatentModel> dataList);

}
