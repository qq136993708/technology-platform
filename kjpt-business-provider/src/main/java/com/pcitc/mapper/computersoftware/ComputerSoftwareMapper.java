package com.pcitc.mapper.computersoftware;


import com.pcitc.base.computersoftware.ComputerSoftware;

import java.util.List;
import java.util.Map;

public interface ComputerSoftwareMapper {


    /**
     * 根据主键获取一个平台的信息
     */
    ComputerSoftware load(String id);

    /**
     * 保存计算机软件
     */
    int add(ComputerSoftware computerSoftware);

    /**
     * 查询计算机软件列表
     */
    List<ComputerSoftware> query(Map paramMap);

    /**
     * 统计查询
     */
    List<Map> countByCopyrightGetway(Map paramMap);


    /**
     * 修改计算机软件
     */
    int update(ComputerSoftware computerSoftware);

    /**
     * 逻辑删
     */
    int delete(String id);


}