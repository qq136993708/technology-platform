package com.pcitc.service.researchplatform;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.researchplatform.PlatformMemberModel;
import com.pcitc.base.researchplatform.PlatformProjectModel;

import java.util.List;
import java.util.Map;

/**
 * 科研平台项目的增删改查
 * @author ty
 */
public interface PlatformMemberService {

    /**
     * 根据主键获取一个平台成员的信息
     */
    PlatformMemberModel load(String id);
    /**
     * 保存科研平台成员
     */
    PlatformMemberModel save(PlatformMemberModel platformMemberModel);
    /**
     * 查询科研平台成员列表
     */
    PageInfo query(Map paramMap);

    /**
     * 科研平台项目删除
     */
    Integer delete(String id);

    /**
     * 批量保存平台成员
     */
    Integer batchSave(List<PlatformMemberModel> dataList);

}
