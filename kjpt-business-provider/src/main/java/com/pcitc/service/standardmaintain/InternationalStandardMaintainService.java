package com.pcitc.service.standardmaintain;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.standardmaintain.InternationalStandardMaintain;
import com.pcitc.base.standardmaintain.StandardMaintain;

import java.util.List;
import java.util.Map;

/**
 * @author ty
 */
public interface InternationalStandardMaintainService {

    InternationalStandardMaintain load(String id);
    void save(InternationalStandardMaintain am);
    Integer delete(String ids);
    PageInfo query(Map param);

    List queryNoPage(Map param);

}
