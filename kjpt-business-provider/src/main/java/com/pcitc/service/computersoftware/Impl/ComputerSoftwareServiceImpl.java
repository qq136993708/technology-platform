package com.pcitc.service.computersoftware.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.Page;

import com.pcitc.base.computersoftware.ComputerSoftware;
import com.pcitc.base.util.IsEmptyUtil;
import com.pcitc.mapper.computersoftware.ComputerSoftwareMapper;
import com.pcitc.service.computersoftware.ComputerSoftwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ComputerSoftwareServiceImpl implements ComputerSoftwareService {

    @Autowired
    private ComputerSoftwareMapper computerSoftwareMapper;

    @Override
    public ComputerSoftware load(String id) {
        return computerSoftwareMapper.load(id);
    }

    @Override
    public ComputerSoftware save(ComputerSoftware computerSoftware) {
        IsEmptyUtil.isEmpty(computerSoftware.getId());

        if (load(computerSoftware.getId()) == null) {
            computerSoftware.setCreateDate(computerSoftware.getUpdateDate());
            computerSoftware.setCreator(computerSoftware.getUpdator());
            computerSoftwareMapper.add(computerSoftware);
        } else {
            computerSoftwareMapper.update(computerSoftware);
        }

        return computerSoftware;
    }

    @Override
    public PageInfo query(Map paramMap) {
        int pageNum = (int) paramMap.get("pageNum");
        int pageSize = (int) paramMap.get("pageSize");
        PageHelper.startPage(pageNum, pageSize);
        List dataList = computerSoftwareMapper.query(paramMap);
        Page p = new Page();

        PageInfo pageInfo = new PageInfo(dataList);
        return pageInfo;
    }

    @Override
    public Integer delete(String id) {
        return computerSoftwareMapper.delete(id);
    }
}
