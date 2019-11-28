package com.pcitc.service.scientificplan.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.Page;
import com.pcitc.base.scientificplan.WorkPoint;
import com.pcitc.base.util.IsEmptyUtil;
import com.pcitc.mapper.scientificplan.WorkPointMapper;
import com.pcitc.service.file.FileCommonService;
import com.pcitc.service.scientificplan.WorkPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WorkPointServiceImpl implements WorkPointService {

    @Autowired
    private WorkPointMapper workPointMapper;

    @Autowired
    private FileCommonService fileCommonService;


    @Override
    public WorkPoint load(String id) {
        return workPointMapper.load(id);
    }

    @Override
    public WorkPoint save(WorkPoint workPoint) {
        IsEmptyUtil.isEmpty(workPoint.getId());

        fileCommonService.updateFileData(workPoint.getAccessory(),workPoint.getId());


        if (load(workPoint.getId()) == null) {
            workPoint.setCreateDate(workPoint.getUpdateDate());
            workPoint.setCreator(workPoint.getUpdator());
            workPointMapper.add(workPoint);
        } else {
            workPointMapper.update(workPoint);
        }
        return workPoint;
    }

    @Override
    public Integer delete(String id) {
        return workPointMapper.delete(id);
    }

    @Override
    public PageInfo query(Map paramMap) {

        int pageNum = paramMap.get("pageNum") !=null? (int)paramMap.get("pageNum"):1;
        int pageSize = paramMap.get("pageSize") !=null? (int)paramMap.get("pageSize"):1;
//        int pageNum = (int) paramMap.get("pageNum");
//        int pageSize = (int) paramMap.get("pageSize");
        PageHelper.startPage(pageNum, pageSize);
        List dataList = workPointMapper.query(paramMap);

        PageInfo pageInfo = new PageInfo(dataList);

        return pageInfo;

    }
}
