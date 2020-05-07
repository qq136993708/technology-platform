package com.pcitc.service.achieve.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.achieve.AchieveIdentifyPlan;
import com.pcitc.base.util.IsEmptyUtil;
import com.pcitc.mapper.achieve.AchieveIdentifyPlanMapper;
import com.pcitc.service.achieve.AchieveIdentifyPlanService;
import com.pcitc.service.file.FileCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author ty
 */
@Service
public class AchieveIdentifyPlanServiceImpl implements AchieveIdentifyPlanService {
    @Autowired
    private AchieveIdentifyPlanMapper apm;

    @Autowired
    private FileCommonService fs;

    @Override
    public AchieveIdentifyPlan load(String id) {
        return apm.load(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer save(AchieveIdentifyPlan aip) {
        IsEmptyUtil.isEmpty(aip.getId());
        fs.updateFileData(aip.getPublicDoc(),aip.getId(),aip.getSecretLevel());
        if(load(aip.getId()) ==null){
            return apm.add(aip);
        }else{
            return apm.update(aip);
        }
    }

    @Override
    public Integer delete(String id) {
        return apm.delete(id);
    }

    @Override
    public PageInfo query(Map param) {
        int pageNum = (int)param.get("pageNum");
        int pageSize = (int)param.get("pageSize");
        PageHelper.startPage(pageNum, pageSize);
        List dataList = apm.query(param);
        PageInfo pageInfo = new PageInfo(dataList);
        return pageInfo;
    }
}
