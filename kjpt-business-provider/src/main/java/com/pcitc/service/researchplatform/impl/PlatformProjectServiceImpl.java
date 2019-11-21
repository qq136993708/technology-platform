package com.pcitc.service.researchplatform.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.Page;
import com.pcitc.base.researchPlatform.PlatformInfoModel;
import com.pcitc.base.researchPlatform.PlatformProjectModel;
import com.pcitc.base.util.IsEmptyUtil;
import com.pcitc.mapper.researchplatform.PlatformMapper;
import com.pcitc.mapper.researchplatform.PlatformProjectMapper;
import com.pcitc.service.researchplatform.PlatformProjectService;
import com.pcitc.service.researchplatform.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author ty
 */
@Service
public class PlatformProjectServiceImpl implements PlatformProjectService {
    @Autowired
    private PlatformProjectMapper platformProjectMapper;


    @Override
    public PlatformProjectModel load(String id) {
        return platformProjectMapper.load(id);
    }

    @Override
    public PlatformProjectModel save(PlatformProjectModel platformProjectModel) {

        IsEmptyUtil.isEmpty(platformProjectModel.getId());
        if(load(platformProjectModel.getId()) ==null)
            platformProjectMapper.add(platformProjectModel);
        else
            platformProjectMapper.update(platformProjectModel);
        return platformProjectModel;
    }

    @Override
    public PageInfo query(Map paramMap) {
        int pageNum = (int)paramMap.get("pageNum");
        int pageSize = (int)paramMap.get("pageSize");
        PageHelper.startPage(pageNum, pageSize);
        List dataList = platformProjectMapper.query(paramMap);
        Page p = new Page();

        PageInfo pageInfo = new PageInfo(dataList);
        return pageInfo;
    }

    @Override
    public Integer delete(String id) {
        return platformProjectMapper.delete(id);
    }
}
