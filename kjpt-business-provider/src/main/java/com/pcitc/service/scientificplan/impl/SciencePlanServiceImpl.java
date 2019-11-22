package com.pcitc.service.scientificplan.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.Page;
import com.pcitc.base.scientificplan.SciencePlan;
import com.pcitc.base.util.IsEmptyUtil;
import com.pcitc.mapper.scientificplan.SciencePlanMapper;
import com.pcitc.service.scientificplan.SciencePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SciencePlanServiceImpl implements SciencePlanService {


    @Autowired
    private SciencePlanMapper sciencePlanMapper;

    @Override
    public SciencePlan load(String id) {
        return sciencePlanMapper.load(id);
    }

    @Override
    public SciencePlan save(SciencePlan sciencePlan) {
        IsEmptyUtil.isEmpty(sciencePlan.getId());
        if (load(sciencePlan.getId()) == null) {
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
        int pageNum = (int) paramMap.get("pageNum");
        int pageSize = (int) paramMap.get("pageSize");
        PageHelper.startPage(pageNum, pageSize);
        List dataList = sciencePlanMapper.query(paramMap);
        Page p = new Page();

        PageInfo pageInfo = new PageInfo(dataList);

        return pageInfo;
    }
}
