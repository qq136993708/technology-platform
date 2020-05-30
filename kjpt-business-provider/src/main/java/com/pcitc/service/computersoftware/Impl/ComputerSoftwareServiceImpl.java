package com.pcitc.service.computersoftware.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.Page;

import com.pcitc.base.computersoftware.ComputerSoftware;
import com.pcitc.base.util.IsEmptyUtil;
import com.pcitc.mapper.computersoftware.ComputerSoftwareMapper;
import com.pcitc.service.computersoftware.ComputerSoftwareService;
import com.pcitc.service.file.FileCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ComputerSoftwareServiceImpl implements ComputerSoftwareService {

    @Autowired
    private ComputerSoftwareMapper computerSoftwareMapper;

    @Autowired
    private FileCommonService fileCommonService;

    @Override
    public ComputerSoftware load(String id) {
        return computerSoftwareMapper.load(id);
    }

    @Override
    public ComputerSoftware save(ComputerSoftware computerSoftware) {
        IsEmptyUtil.isEmpty(computerSoftware.getId());

        fileCommonService.updateFileData(computerSoftware.getFiles(),computerSoftware.getId(),computerSoftware.getSecretLevel());

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
        int pageNum = paramMap.get("pageNum") !=null? (int)paramMap.get("pageNum"):1;
        int pageSize = paramMap.get("pageSize") !=null? (int)paramMap.get("pageSize"):10;
        //         int pageNum = (int) paramMap.get("pageNum");
        //        int pageSize = (int) paramMap.get("pageSize");
        PageHelper.startPage(pageNum, pageSize);
        List dataList = computerSoftwareMapper.query(paramMap);
        PageInfo pageInfo = new PageInfo(dataList);
        return pageInfo;
    }


    @Override
    public Integer delete(String id) {
        return computerSoftwareMapper.delete(id);
    }

    @Override
    public List queryNoPage(Map paramMap) {
        return computerSoftwareMapper.query(paramMap);
    }

    @Override
    public List countByCopyrightGetway(Map paramMap) {
        return computerSoftwareMapper.countByCopyrightGetway(paramMap);
    }
}
