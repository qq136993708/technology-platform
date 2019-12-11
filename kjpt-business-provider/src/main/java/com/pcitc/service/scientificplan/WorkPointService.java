package com.pcitc.service.scientificplan;

import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface WorkPointService {

    /**
     * 根据主键获取一个平台的信息
     */
    WorkPoint load(String id);

    /**
     * 保存工作要点
     *
     * @param workPoint
     * @return
     */
    WorkPoint save(WorkPoint workPoint);

    /**
     * 删除工作要点
     *
     * @param id
     * @return
     */
    Integer delete(String id);

    /**
     * 查询工作要点
     *
     * @param paramMap
     * @return
     */
    PageInfo query(Map paramMap);

}
