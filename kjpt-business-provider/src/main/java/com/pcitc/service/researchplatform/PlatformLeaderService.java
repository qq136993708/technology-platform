package com.pcitc.service.researchplatform;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.researchplatform.PlatformLeaderModel;
import com.pcitc.base.researchplatform.PlatformMemberModel;

import java.util.List;
import java.util.Map;

/**
 * @author ty
 */
public interface PlatformLeaderService {
    /**
     * 删除平台领军人物
     * @param id
     * @return
     */
    Integer delete(String id);

    /**
     * 保存
     * @param pfm
     */
    void save(PlatformLeaderModel pfm);

    PageInfo query(Map paramMap);

    /**
     * 批量保存平台领军人物
     * @param dataList
     * @return
     */
    Integer batchSave(List<PlatformLeaderModel> dataList);

    /**
     * 根据主键加载领军人物实体
     * @param id
     * @return
     */
    PlatformLeaderModel load(String id);


    /**
     * 查询列表不分页
     * @param paramMap
     * @return
     */
    List<PlatformLeaderModel> queryNoPage(Map paramMap);
}
