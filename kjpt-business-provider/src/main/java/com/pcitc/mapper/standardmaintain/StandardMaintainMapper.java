package com.pcitc.mapper.standardmaintain;

import com.pcitc.base.standardmaintain.StandardMaintain;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author ty
 */
public interface StandardMaintainMapper {

    StandardMaintain load(String id);
    void add(StandardMaintain am);
    void update(StandardMaintain am);
    Integer delete(@Param("ids") String ids);
    List query(Map param);

}
