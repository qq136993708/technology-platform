package com.pcitc.service.manage;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.achieve.AchieveMaintain;
import com.pcitc.base.manage.ManageMethod;

import java.util.List;
import java.util.Map;

/**
 * @author ty
 */
public interface ManageMethodService {

    ManageMethod load(String id);
    void save(ManageMethod am);
    Integer delete(String ids);
    PageInfo query(Map param);
    List queryNoPage(Map paramMap);

}
