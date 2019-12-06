package com.pcitc.service.researchplatform.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.researchplatform.PlatformLeaderModel;
import com.pcitc.base.util.IsEmptyUtil;
import com.pcitc.mapper.researchplatform.PlatformLeaderMapper;
import com.pcitc.service.researchplatform.PlatformLeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author ty
 */
@Service
public class PlatformLeaderServiceImpl implements PlatformLeaderService {

    @Autowired
    private PlatformLeaderMapper pflm;
    @Override
    public Integer delete(String id) {
        return pflm.delete(id);
    }

    @Override
    public void save(PlatformLeaderModel pfm) {
        IsEmptyUtil.isEmpty(pfm.getId());
        if(load(pfm.getId()) ==null){
            pfm.setCreateDate(pfm.getUpdateDate());
            pfm.setCreator(pfm.getUpdator());
            pflm.add(pfm);
        }else{
            pflm.update(pfm);
        }
    }

    @Override
    public PageInfo query(Map paramMap) {
        int pageNum = (int)paramMap.get("pageNum");
        int pageSize = (int)paramMap.get("pageSize");
        PageHelper.startPage(pageNum, pageSize);
        List dataList = pflm.query(paramMap);
        PageInfo pageInfo = new PageInfo(dataList);
        return pageInfo;
    }

    @Override
    public Integer batchSave(List<PlatformLeaderModel> dataList) {
        return pflm.batchSave(dataList);
    }

    @Override
    public PlatformLeaderModel load(String id) {
        return pflm.load(id);
    }

    @Override
    public List<PlatformLeaderModel> queryNoPage(Map paramMap) {
        return pflm.query(paramMap);
    }
}
