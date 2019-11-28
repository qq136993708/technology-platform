package com.pcitc.service.researchplatform.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.researchplatform.PlatformMemberModel;
import com.pcitc.base.researchplatform.PlatformPatentModel;
import com.pcitc.base.util.IsEmptyUtil;
import com.pcitc.mapper.researchplatform.PlatformPatentMapper;
import com.pcitc.service.researchplatform.PlatformPatentService;
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
public class PlatformPatentServiceImpl implements PlatformPatentService {
    @Autowired
    private PlatformPatentMapper platformPatentMapper;


    @Override
    public PlatformPatentModel load(String id) {
        return platformPatentMapper.load(id);
    }

    @Override
    public PlatformPatentModel save(PlatformPatentModel platformPatentModel) {
        IsEmptyUtil.isEmpty(platformPatentModel.getId());
        if(load(platformPatentModel.getId()) ==null){
            platformPatentModel.setCreateDate(platformPatentModel.getUpdateDate());
            platformPatentModel.setCreator(platformPatentModel.getUpdator());
            platformPatentMapper.add(platformPatentModel);
        }else{
            platformPatentMapper.update(platformPatentModel);
        }
        return platformPatentModel;
    }

    @Override
    public PageInfo query(Map paramMap) {
        int pageNum = (int)paramMap.get("pageNum");
        int pageSize = (int)paramMap.get("pageSize");
        PageHelper.startPage(pageNum, pageSize);
        List dataList = platformPatentMapper.query(paramMap);
        PageInfo pageInfo = new PageInfo(dataList);
        return pageInfo;
    }

    @Override
    public List<PlatformPatentModel> queryNoPage(Map paramMap) {
        return platformPatentMapper.query(paramMap);
    }

    @Override
    public Integer delete(String id) {
        return platformPatentMapper.delete(id);
    }

    @Override
    public Integer batchSave(List<PlatformPatentModel> dataList) {
        return platformPatentMapper.batchSave(dataList);
    }
}
