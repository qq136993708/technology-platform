package com.pcitc.service.index.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.computersoftware.ComputerSoftware;
import com.pcitc.base.util.IsEmptyUtil;
import com.pcitc.mapper.computersoftware.ComputerSoftwareMapper;
import com.pcitc.mapper.index.IndexHomeMapper;
import com.pcitc.service.file.FileCommonService;
import com.pcitc.service.index.IndexHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class IndexHomeServiceImpl implements IndexHomeService {

    @Autowired
    private IndexHomeMapper indexHomeMapper;

    /**
     *功能描述 首页数据汇总查询
     * @author t-chengjia.chen
     * @date 2019/11/28
     * @return com.github.pagehelper.PageInfo
     */
    @Override
    public PageInfo selectNummary(Map param) {
        List dataList = indexHomeMapper.selectNummary(param);
        PageInfo pageInfo = new PageInfo(dataList);
        return pageInfo;
    }
}
