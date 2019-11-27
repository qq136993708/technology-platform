package com.pcitc.service.researchplatform.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.researchplatform.PlatformAchievementModel;
import com.pcitc.base.researchplatform.PlatformProjectModel;
import com.pcitc.base.util.IsEmptyUtil;
import com.pcitc.mapper.researchplatform.PlatformAchievementMapper;
import com.pcitc.mapper.researchplatform.PlatformProjectMapper;
import com.pcitc.service.researchplatform.PlatformAchievementService;
import com.pcitc.service.researchplatform.PlatformProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author ty
 */
@Service
public class PlatformAchievementServiceImpl implements PlatformAchievementService {

    @Autowired
    private PlatformAchievementMapper platformAchievementMapper;

    @Override
    public PlatformAchievementModel load(String id) {
        return platformAchievementMapper.load(id);
    }

    @Override
    public PlatformAchievementModel save(PlatformAchievementModel platformAchievementModel) {

        IsEmptyUtil.isEmpty(platformAchievementModel.getId());
        if(load(platformAchievementModel.getId()) ==null){
            platformAchievementModel.setCreateDate(platformAchievementModel.getUpdateDate());
            platformAchievementModel.setCreator(platformAchievementModel.getUpdator());
            platformAchievementMapper.add(platformAchievementModel);
        }
        else{
            platformAchievementMapper.update(platformAchievementModel);
        }
        return platformAchievementModel;
    }

    @Override
    public PageInfo query(Map paramMap) {
        int pageNum = (int)paramMap.get("pageNum");
        int pageSize = (int)paramMap.get("pageSize");
        PageHelper.startPage(pageNum, pageSize);
        List dataList = platformAchievementMapper.query(paramMap);
        PageInfo pageInfo = new PageInfo(dataList);
        return pageInfo;
    }

    @Override
    public List<PlatformAchievementModel> queryNoPage(Map paramMap) {
        return platformAchievementMapper.query(paramMap);
    }

    @Override
    public Integer delete(String id) {
        return platformAchievementMapper.delete(id);
    }

    @Override
    public Integer batchSave(List<PlatformAchievementModel> dataList) {
        return platformAchievementMapper.batchSave(dataList);
    }
}
