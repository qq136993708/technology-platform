package com.pcitc.service.achieve;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.achieve.AchieveMaintain;

import java.util.List;
import java.util.Map;

/**
 * @author ty
 */
public interface AchieveMaintainService {

    AchieveMaintain load(String id);
    void save(AchieveMaintain am);
    Integer delete(String ids);
    PageInfo query(Map param);

    /**
     * 查询成果维护列表
     */
    List<AchieveMaintain> queryNoPage(Map paramMap);
}
