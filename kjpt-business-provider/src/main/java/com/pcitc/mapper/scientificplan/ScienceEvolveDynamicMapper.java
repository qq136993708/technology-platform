package com.pcitc.mapper.scientificplan;

import com.pcitc.base.scientificplan.ScienceEvolveDynamic;

import java.util.List;
import java.util.Map;

public interface ScienceEvolveDynamicMapper {


    /**
     * 根据主键获取一个平台的信息
     * @param id
     */
    ScienceEvolveDynamic load(String id);

    /**
     * 保存科技进展动态
     * @param scienceEvolveDynamic
     * @return
     */
    int add(ScienceEvolveDynamic scienceEvolveDynamic);

    /**
     * 删除科技进展动态
     * @param id
     * @return
     */
    int delete(String id);

    /**
     * 修改科技进展动态
     * @param scienceEvolveDynamic
     * @return
     */
    int update(ScienceEvolveDynamic scienceEvolveDynamic);

    /**
     * 查询科技进展动态列表
     * @param paramMap
     * @return
     */
    List<ScienceEvolveDynamic> query(Map paramMap);

}
