package com.pcitc.mapper.scientificplan;

import com.pcitc.base.scientificplan.WorkPoint;

import java.util.List;
import java.util.Map;

public interface WorkPointMapper {


    /**
     * 根据主键获取一个平台的信息
     * @param id
     */
    WorkPoint load(String id);

    /**
     * 保存工作要点
     *
     * @param workPoint
     * @return
     */
    int add(WorkPoint workPoint);

    /**
     * 删除工作要点
     *
     * @param id
     * @return
     */
    int delete(String id);

    /**
     * 修改工作要点
     *
     * @param workPoint
     * @return
     */
    int update(WorkPoint workPoint);

    /**
     * 查询工作要点列表
     *
     * @param paramMap
     * @return
     */
    List<WorkPoint> query(Map paramMap);
}
