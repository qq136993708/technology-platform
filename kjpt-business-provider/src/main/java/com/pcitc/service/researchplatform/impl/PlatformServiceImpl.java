package com.pcitc.service.researchplatform.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.Page;
import com.pcitc.base.patent.KgjImportModel;
import com.pcitc.base.researchplatform.PlatformInfoModel;
import com.pcitc.base.util.IsEmptyUtil;
import com.pcitc.mapper.researchplatform.PlatformMapper;
import com.pcitc.service.researchplatform.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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
        PageInfo pageInfo = new PageInfo(dataList);
        return pageInfo;
    }

    @Override
    public List<PlatformInfoModel> queryNoPage(Map paramMap) {
        List dataList = platformServiceMapper.query(paramMap);
        return dataList;
    }


    @Override
    public Integer delete(String id) {
        return platformServiceMapper.delete(id);
    }

    @Override
    public List<Map> selectPaltinfoCount(String id) {
        return platformServiceMapper.selectPaltinfoCount(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List excelImport(List dataList, String currentUser) {

        String batchId = UUID.randomUUID().toString().replaceAll("-","");
        IsEmptyUtil.isEmpty(dataList);
        IsEmptyUtil.isEmpty(currentUser);
        List<PlatformInfoModel> list = new ArrayList<>();
        for (int i = 0; i < dataList.size(); i++) {
            List<Object> lo = (List<Object>) dataList.get(i);
            PlatformInfoModel pm = new PlatformInfoModel();
            pm.setId(UUID.randomUUID().toString().replace("-",""));
            pm.setCreator(currentUser);
            pm.setCreateDate(new Date());
            pm.setDeleted("0");
            pm.setBatchId(batchId);
            pm.setPlatformName(String.valueOf(lo.get(0)));
            pm.setResearchField(String.valueOf(lo.get(1)));
            pm.setSupportingInstitutions(String.valueOf(lo.get(2)));
            pm.setResearchFunds(String.valueOf(lo.get(3)));
            pm.setPlatformIntroduction(String.valueOf(lo.get(4)));
            pm.setTeamIntroduction(String.valueOf(lo.get(5)));
            pm.setOverallSituation(String.valueOf(lo.get(6)));
            pm.setPersonLiable(String.valueOf(lo.get(7)));
            pm.setPlatformScoring(String.valueOf(lo.get(8)));
            pm.setLevel(String.valueOf(lo.get(9)));
        }
        platformServiceMapper.excelData2MemoryDB(list);
        return platformServiceMapper.handlerKyptInfoImport(batchId);
    }

    @Override
    public PageInfo scienceStatistics(Map param) {
        int pageNum = (int)param.get("pageNum");
        int pageSize = (int)param.get("pageSize");
        PageHelper.startPage(pageNum, pageSize);
        List dataList = platformServiceMapper.scienceStatistics(param);
        PageInfo pageInfo = new PageInfo(dataList);
        return pageInfo;
    }
}
