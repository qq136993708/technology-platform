package com.pcitc.mapper.manage;

import com.pcitc.base.manage.ManageMethod;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author ty
 */
public interface ManageMethodMapper {

    ManageMethod load(String id);
    void add(ManageMethod am);
    void update(ManageMethod am);
    Integer delete(@Param("ids") String ids);
    List query(Map param);

}
