package com.pcitc.mapper.treatise;

import com.pcitc.base.treatiseinfo.TreatiseInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author ty
 */
public interface TreatiseInfoMapper {

    TreatiseInfo load(String id);
    void add(TreatiseInfo am);
    void update(TreatiseInfo am);
    Integer delete(@Param("ids") String ids);
    List query(Map param);

}
