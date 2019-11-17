package com.pcitc.service.researchplatform.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.Page;
import com.pcitc.base.researchPlatform.PlatformInfoModel;
import com.pcitc.base.util.IsEmptyUtil;
import com.pcitc.mapper.researchplatform.PlatformMapper;
import com.pcitc.service.researchplatform.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        platformServiceMapper.save(platformInfoModel);
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
        //从第多少条开始
        //int pageStart = (param.getPage()-1)*pageSize;
        //当前是第几页
        //int pageNum = pageStart/pageSize + 1;
        // 1、设置分页信息，包括当前页数和每页显示的总计数
        //PageHelper.startPage(pageNum, pageSize);

        return pageInfo;
    }

    @Override
    public void delete(String id) {

    }
}
