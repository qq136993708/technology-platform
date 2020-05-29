package com.pcitc.service.standardmaintain;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.manage.ManageMethod;
import com.pcitc.base.standardmaintain.StandardMaintain;

import java.util.List;
import java.util.Map;

/**
 * @author ty
 */
public interface StandardMaintainService {

    StandardMaintain load(String id);
    void save(StandardMaintain am);
    Integer delete(String ids);
    PageInfo query(Map param);

    List queryNoPage(Map param);

}
