package com.pcitc.service.researchplatform.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.Page;
import com.pcitc.base.researchplatform.PlatformInfoModel;
import com.pcitc.base.util.IsEmptyUtil;
import com.pcitc.mapper.researchplatform.PlatformMapper;
import com.pcitc.service.researchplatform.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author ty
 */
@Service
public class PlatformServiceImpl implements PlatformService {
    @Autowired
    private PlatformMapper platformServiceMapper;


    @Override
    public PlatformInfoModel load(String id) {
        return  platformServiceMapper.load(id);
    }

    @Override
    public PlatformInfoModel save(PlatformInfoModel platformInfoModel) {
        IsEmptyUtil.isEmpty(platformInfoModel.getId());
        if(load(platformInfoModel.getId()) ==null){
            platformInfoModel.setCreateDate(platformInfoModel.getUpdateDate());
            platformInfoModel.setCreator(platformInfoModel.getUpdator());
            platformServiceMapper.add(platformInfoModel);
        }else{
            platformServiceMapper.update(platformInfoModel);
        }
        return platformInfoModel;
    }

    @Override
    public PageInfo query(Map paramMap) {
        int pageNum = (int)paramMap.get("pageNum");
        int pageSize = (int)paramMap.get("pageSize");
        PageHelper.startPage(pageNum, pageSize);
        List dataList = platformServiceMapper.query(paramMap);
        Page p = new Page();
        PageInfo pageInfo = new PageInfo(dataList);
        return pageInfo;
    }

    @Override
    public Integer delete(String id) {
        return platformServiceMapper.delete(id);
    }

    @Override
    public List<Map> selectPaltinfoCount(String id) {
        return platformServiceMapper.selectPaltinfoCount(id);
    }
}
