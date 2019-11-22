package com.pcitc.mapper.researchplatform;

import com.pcitc.base.researchplatform.PlatformAchievementModel;
import com.pcitc.base.researchplatform.PlatformMemberModel;

import java.util.List;
import java.util.Map;

public interface PlatformMemberMapper {

    /**
     * 根据主键获取一个平台成员的信息
     */
    PlatformMemberModel load(String id);
    /**
     * 保存平台成员
     */
    int add(PlatformMemberModel PlatformMemberModel);
    /**
     * 查询科研平台成员列表
     */
    List<PlatformMemberModel> query(Map paramMap);


    /**
     * 修改科研平台成员
     */
    int update(PlatformMemberModel platformMemberModel);

    /**
     * 逻辑删
     */
    int delete(String id);

    /**
     * 批量添加
     */
    int batchSave(List<PlatformMemberModel> list);


}
