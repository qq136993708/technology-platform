package com.pcitc.service.researchplatform.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.researchplatform.PlatformTreatiseModel;
import com.pcitc.base.util.IsEmptyUtil;
import com.pcitc.mapper.researchplatform.PlatformTreatiseMapper;
import com.pcitc.service.researchplatform.PlatformTreatiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author ty
 */
@Service
public class PlatformTreatiseServiceImpl implements PlatformTreatiseService {

    @Autowired
    private PlatformTreatiseMapper ptm;

    @Override
    public PlatformTreatiseModel load(String id) {

        return ptm.load(id);
    }

    @Override
    public PlatformTreatiseModel save(PlatformTreatiseModel platformTreatiseModel) {
        IsEmptyUtil.isEmpty(platformTreatiseModel.getId());
        if(load(platformTreatiseModel.getId()) ==null)
            ptm.add(platformTreatiseModel);
        else
            ptm.update(platformTreatiseModel);
        return platformTreatiseModel;
    }

    @Override
    public Integer batchSave(List<PlatformTreatiseModel> dataList) {
        ptm.batchSave(dataList);
        return dataList.size();
    }

    @Override
    public PageInfo query(Map paramMap) {

        int pageNum = (int)paramMap.get("pageNum");
        int pageSize = (int)paramMap.get("pageSize");
        PageHelper.startPage(pageNum, pageSize);
        List dataList = ptm.query(paramMap);
        PageInfo pageInfo = new PageInfo(dataList);
        return pageInfo;
    }

    @Override
    public Integer delete(String id) {
        return ptm.delete(id);
    }
}
