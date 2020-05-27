package com.pcitc.service.treatise;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.achieve.AchieveMaintain;
import com.pcitc.base.treatiseinfo.TreatiseInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TreatiseService {
    TreatiseInfo load(String id);
    void save(TreatiseInfo am);
    Integer delete(@Param("ids") String ids);
    PageInfo query(Map param);

    /**
     * 查询
     */
    List<TreatiseInfo> queryNoPage(Map paramMap);
}
