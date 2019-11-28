package com.pcitc.service.scientificplan.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.Page;
import com.pcitc.base.scientificplan.SciencePlan;
import com.pcitc.base.util.IsEmptyUtil;
import com.pcitc.mapper.scientificplan.SciencePlanMapper;
import com.pcitc.service.file.FileCommonService;
import com.pcitc.service.scientificplan.SciencePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SciencePlanServiceImpl implements SciencePlanService {


    @Autowired
    private SciencePlanMapper sciencePlanMapper;

    @Autowired
    private FileCommonService fileCommonService;

    @Override
    public SciencePlan load(String id) {
        return sciencePlanMapper.load(id);
    }

    @Override
    public SciencePlan save(SciencePlan sciencePlan) {
        IsEmptyUtil.isEmpty(sciencePlan.getId());

        fileCommonService.updateFileData(sciencePlan.getAccessory(),sciencePlan.getId());

        if (load(sciencePlan.getId()) == null) {
            sciencePlan.setCreateDate(sciencePlan.getUpdateDate());
            sciencePlan.setCreator(sciencePlan.getUpdator());
            sciencePlanMapper.add(sciencePlan);
        } else {
            sciencePlanMapper.update(sciencePlan);
        }
        return sciencePlan;
    }

    @Override
    public Integer delete(String id) {
        return sciencePlanMapper.delete(id);
    }

    @Override
    public PageInfo query(Map paramMap) {
        int pageNum = paramMap.get("pageNum") !=null? (int)paramMap.get("pageNum"):1;
        int pageSize = paramMap.get("pageSize") !=null? (int)paramMap.get("pageSize"):1;
//        int pageNum = (int) paramMap.get("pageNum");
//        int pageSize = (int) paramMap.get("pageSize");
        PageHelper.startPage(pageNum, pageSize);
        List dataList = sciencePlanMapper.query(paramMap);

        PageInfo pageInfo = new PageInfo(dataList);

        return pageInfo;
    }
}
