package com.pcitc.service.scientificplan.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.Page;
import com.pcitc.base.scientificplan.YearSummary;
import com.pcitc.base.util.IsEmptyUtil;
import com.pcitc.mapper.scientificplan.YearSummaryMapper;
import com.pcitc.service.scientificplan.YearSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class YearSummaryServiceImpl implements YearSummaryService {

    @Autowired
    private YearSummaryMapper yearSummaryMapper;


    @Override
    public YearSummary load(String id) {
        return yearSummaryMapper.load(id);
    }

    @Override
    public YearSummary save(YearSummary yearSummary) {
        IsEmptyUtil.isEmpty(yearSummary.getId());
        if (load(yearSummary.getId()) == null) {
            yearSummary.setCreateDate(yearSummary.getUpdateDate());
            yearSummary.setCreator(yearSummary.getUpdator());
            yearSummaryMapper.add(yearSummary);
        } else {
            yearSummaryMapper.update(yearSummary);
        }
        return yearSummary;
    }

    @Override
    public Integer delete(String id) {
        return yearSummaryMapper.delete(id);
    }

    @Override
    public PageInfo query(Map paramMap) {
        int pageNum = (int) paramMap.get("pageNum");
        int pageSize = (int) paramMap.get("pageSize");
        PageHelper.startPage(pageNum, pageSize);
        List dataList = yearSummaryMapper.query(paramMap);
        Page p = new Page();
        PageInfo pageInfo = new PageInfo(dataList);
        return pageInfo;
    }
}
