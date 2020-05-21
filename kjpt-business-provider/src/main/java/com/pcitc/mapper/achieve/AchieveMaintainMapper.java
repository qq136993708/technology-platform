package com.pcitc.mapper.achieve;

import com.pcitc.base.achieve.AchieveMaintain;
import com.pcitc.base.system.SysSerial;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author ty
 */
public interface AchieveMaintainMapper {

    AchieveMaintain load(String id);
    void add(AchieveMaintain am);
    void update(AchieveMaintain am);
    Integer delete(@Param("ids") String ids);
    List query(Map param);

}
