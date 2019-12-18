package com.pcitc.mapper.index;


import com.pcitc.base.computersoftware.ComputerSoftware;

import java.util.List;
import java.util.Map;

public interface IndexHomeMapper {

    /**
     *功能描述 首页数据汇总查询
     * @author t-chengjia.chen
     * @date 2019/11/28
     * @return com.github.pagehelper.PageInfo
     */
    List<Map<String,Object>> selectNummary(Map param);
}
