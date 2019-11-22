package com.pcitc.service.computersoftware;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.computersoftware.ComputerSoftware;


import java.util.Map;


public interface ComputerSoftwareService {

    /**
     * 根据主键获取一个平台项目的信息
     */
    ComputerSoftware load(String id);

    /**
     * 保存计算机软件
     */
    ComputerSoftware save(ComputerSoftware computerSoftware);

    /**
     * 查询计算机软件项目列表
     */
    PageInfo query(Map paramMap);

    /**
     * 计算机软件项目删除
     */
    Integer delete(String id);


}
