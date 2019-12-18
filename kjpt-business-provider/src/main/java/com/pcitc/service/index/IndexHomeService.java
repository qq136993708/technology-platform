package com.pcitc.service.index;

import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface IndexHomeService {

    /**
     * 查询计算机软件项目列表
     */
    PageInfo selectNummary(Map param);


}
