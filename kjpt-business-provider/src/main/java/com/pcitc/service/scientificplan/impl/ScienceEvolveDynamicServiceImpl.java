package com.pcitc.service.scientificplan.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.pcitc.base.scientificplan.ScienceEvolveDynamic;
import com.pcitc.base.util.IsEmptyUtil;
import com.pcitc.mapper.scientificplan.ScienceEvolveDynamicMapper;
import com.pcitc.service.file.FileCommonService;
import com.pcitc.service.scientificplan.ScienceEvolveDynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pcitc.base.common.Page;

import java.util.List;
import java.util.Map;

@Service
public class ScienceEvolveDynamicServiceImpl implements ScienceEvolveDynamicService {


    @Autowired
    private ScienceEvolveDynamicMapper scienceEvolveDynamicMapper;


    @Autowired
    private FileCommonService fileCommonService;

    @Override
    public ScienceEvolveDynamic load(String id) {
        return scienceEvolveDynamicMapper.load(id);
    }

    @Override
    public ScienceEvolveDynamic save(ScienceEvolveDynamic scienceEvolveDynamic) {
        IsEmptyUtil.isEmpty(scienceEvolveDynamic.getId());

        fileCommonService.updateFileData(scienceEvolveDynamic.getAccessory(), scienceEvolveDynamic.getId());
        if (load(scienceEvolveDynamic.getId()) == null) {
            scienceEvolveDynamic.setCreateDate(scienceEvolveDynamic.getUpdateDate());
            scienceEvolveDynamic.setCreator(scienceEvolveDynamic.getUpdator());
            scienceEvolveDynamicMapper.add(scienceEvolveDynamic);
        } else {
            scienceEvolveDynamicMapper.update(scienceEvolveDynamic);
        }

        return scienceEvolveDynamic;
    }

    @Override
    public Integer delete(String id) {
        return scienceEvolveDynamicMapper.delete(id);
    }

    @Override
    public PageInfo query(Map paramMap) {
        int pageNum = paramMap.get("pageNum") != null ? (int) paramMap.get("pageNum") : 1;
        int pageSize = paramMap.get("pageSize") != null ? (int) paramMap.get("pageSize") : 1;
//        int pageNum = (int) paramMap.get("pageNum");
//        int pageSize = (int) paramMap.get("pageSize");
        PageHelper.startPage(pageNum, pageSize);
        List dataList = scienceEvolveDynamicMapper.query(paramMap);
        Page p = new Page();

        PageInfo pageInfo = new PageInfo(dataList);

        return pageInfo;
    }
}
