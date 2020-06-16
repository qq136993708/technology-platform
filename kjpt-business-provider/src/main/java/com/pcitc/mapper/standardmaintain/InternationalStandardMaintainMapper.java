package com.pcitc.mapper.standardmaintain;

import com.pcitc.base.standardmaintain.InternationalStandardMaintain;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author ty
 */
public interface InternationalStandardMaintainMapper {

    InternationalStandardMaintain load(String id);
    void add(InternationalStandardMaintain am);
    void update(InternationalStandardMaintain am);
    Integer delete(@Param("ids") String ids);
    List query(Map param);

}
