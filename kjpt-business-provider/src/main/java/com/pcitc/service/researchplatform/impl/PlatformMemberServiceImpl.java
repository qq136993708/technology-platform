package com.pcitc.service.researchplatform.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.researchplatform.PlatformMemberModel;
import com.pcitc.base.util.IsEmptyUtil;
import com.pcitc.mapper.researchplatform.PlatformMemberMapper;
import com.pcitc.service.researchplatform.PlatformMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author ty
 */
@Service
public class PlatformMemberServiceImpl implements PlatformMemberService {
    @Autowired
    private  PlatformMemberMapper platformMemberMapper;

    @Override
    public PlatformMemberModel load(String id) {
        return platformMemberMapper.load(id);
    }

    @Override
    public PlatformMemberModel save(PlatformMemberModel platformMemberModel) {
        IsEmptyUtil.isEmpty(platformMemberModel.getId());
        if(load(platformMemberModel.getId()) ==null){
            platformMemberModel.setCreateDate(platformMemberModel.getUpdateDate());
            platformMemberModel.setCreator(platformMemberModel.getUpdator());
            platformMemberMapper.add(platformMemberModel);
        }else{
            platformMemberMapper.update(platformMemberModel);
        }
        return platformMemberModel;
    }

    @Override
    public PageInfo query(Map paramMap) {
        int pageNum = (int)paramMap.get("pageNum");
        int pageSize = (int)paramMap.get("pageSize");
        PageHelper.startPage(pageNum, pageSize);
        List dataList = platformMemberMapper.query(paramMap);
        PageInfo pageInfo = new PageInfo(dataList);
        return pageInfo;
    }

    @Override
    public Integer delete(String id) {
        return platformMemberMapper.delete(id);
    }

    @Override
    public Integer batchSave(List<PlatformMemberModel> dataList) {
        return platformMemberMapper.batchSave(dataList);
    }

    @Override
    public Integer updateMemberRole(String ids, String role) {
        IsEmptyUtil.isEmpty(ids);
        IsEmptyUtil.isEmpty(role);
        return platformMemberMapper.updateMemberRole(ids.split(","),role);
    }
}
