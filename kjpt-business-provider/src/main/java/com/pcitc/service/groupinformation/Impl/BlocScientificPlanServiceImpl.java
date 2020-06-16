package com.pcitc.service.groupinformation.Impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.groupinformation.BlocScientificPlan;
import com.pcitc.base.scientificplan.SciencePlan;
import com.pcitc.base.util.IsEmptyUtil;
import com.pcitc.mapper.groupinformation.BlocScientificPlanMapper;
import com.pcitc.service.file.FileCommonService;
import com.pcitc.service.groupinformation.BlocScientificPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BlocScientificPlanServiceImpl implements BlocScientificPlanService {

    @Autowired
    private BlocScientificPlanMapper blocScientificPlanMapper;

    @Autowired
    private FileCommonService fileCommonService;


    @Override
    public BlocScientificPlan load(String id) {
        return blocScientificPlanMapper.load(id);
    }

    @Override
    public BlocScientificPlan save(BlocScientificPlan blocScientificPlan) {

        IsEmptyUtil.isEmpty(blocScientificPlan.getId());


        fileCommonService.updateFileData(blocScientificPlan.getAccessory(), blocScientificPlan.getId(),blocScientificPlan.getSecretLevel());


        if (load(blocScientificPlan.getId()) == null) {
            blocScientificPlan.setUpdateDate(blocScientificPlan.getUpdateDate());
            blocScientificPlan.setCreator(blocScientificPlan.getUpdator());
            blocScientificPlanMapper.add(blocScientificPlan);
        } else {
            blocScientificPlanMapper.update(blocScientificPlan);
        }
        return blocScientificPlan;
    }

    @Override
    public PageInfo query(Map paramMap) {
        int pageNum = paramMap.get("pageNum") != null ? (int) paramMap.get("pageNum") : 1;
        int pageSize = paramMap.get("pageSize") != null ? (int) paramMap.get("pageSize") : 10;
        PageHelper.startPage(pageNum, pageSize);
        List dataList = blocScientificPlanMapper.query(paramMap);
        PageInfo pageInfo = new PageInfo(dataList);
        return pageInfo;
    }

    @Override
    public Integer delete(String id) {
        return blocScientificPlanMapper.delete(id);
    }

    @Override
    public List queryNoPage(Map paramMap) {
        return blocScientificPlanMapper.query(paramMap);
    }

    @Override
    public int insertBatch(List<BlocScientificPlan> list) throws Exception {
        int count=0;
        if(list!=null && list.size()>0)
        {
            for(int i=0;i<list.size();i++)
            {
                BlocScientificPlan blocScientificPlan=list.get(i);
                count=blocScientificPlanMapper.add(blocScientificPlan);
            }
        }
        return count;
    }
}
