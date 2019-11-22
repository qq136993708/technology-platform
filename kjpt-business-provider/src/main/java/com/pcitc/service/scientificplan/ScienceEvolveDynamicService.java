package com.pcitc.service.scientificplan;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.scientificplan.ScienceEvolveDynamic;

import java.util.Map;

public interface ScienceEvolveDynamicService {


    /**
     * 根据主键获取一个平台的信息
     */
    ScienceEvolveDynamic load(String id);

    /**
     * 保存科技进展动态
     * @param scienceEvolveDynamic
     * @return
     */
    ScienceEvolveDynamic save(ScienceEvolveDynamic scienceEvolveDynamic);

    /**
     * 删除科技进展动态
     * @param id
     * @return
     */
    Integer delete(String id);

    /**
     * 查询科技进展动态
     * @param paramMap
     * @return
     */
    PageInfo query(Map paramMap);



}
