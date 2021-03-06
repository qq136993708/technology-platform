package com.pcitc.service.patent.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.FileModel;
import com.pcitc.base.patent.PatentInfo;
import com.pcitc.base.util.DateUtils;
import com.pcitc.base.util.IsEmptyUtil;
import com.pcitc.mapper.patent.PatentInfoMapper;
import com.pcitc.service.file.FileCommonService;
import com.pcitc.service.patent.PatentInfoService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * <p>接口实现类</p>
 * <p>Table: patent_info - 专利信息</p>
 *
 * @since 2019-11-16 04:10:36
 */
@Service("PatentInfoService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class PatentInfoServiceImpl implements PatentInfoService {

    @Resource
    private PatentInfoMapper patentInfoMapper;
    @Autowired
    FileCommonService fileCommonService;

    @Override
    public PatentInfo updateOrInsertPatentInfo(PatentInfo patentInfo) {
        IsEmptyUtil.isEmpty(patentInfo.getId());
        if(Objects.nonNull(this.getPatentInfo(patentInfo.getId()))){
            patentInfoMapper.updateByPrimaryKey(patentInfo);
        }else{
            patentInfoMapper.insertSelective(patentInfo);
        }
        fileCommonService.updateFileData(patentInfo.getFiles(),patentInfo.getId(),patentInfo.getSecretLevel());
        return patentInfo;
    }

    @Override
    public PageInfo queryPatentList(Map param) {
        int pageNum = (int)param.get("pageNum");
        int pageSize = (int)param.get("pageSize");
        PageHelper.startPage(pageNum, pageSize);
        List<PatentInfo> dataList = patentInfoMapper.queryPatentList(param);
        dataList.forEach(patentInfo ->{
            patentInfo.setApplicationDateStr(DateUtils.format(patentInfo.getApplicationDate(),DateUtils.FMT_SS));
            patentInfo.setExpirationDateStr(DateUtils.format(patentInfo.getExpirationDate(),DateUtils.FMT_SS));
            System.out.println(patentInfo);
        });
        PageInfo pageInfo = new PageInfo(dataList);

        return pageInfo;
    }

    @Override
    public List queryPatent(Map param) {
        int pageNum = (int)param.get("pageNum");
        int pageSize = (int)param.get("pageSize");
        PageHelper.startPage(pageNum, pageSize);
        List<PatentInfo> dataList = patentInfoMapper.queryPatentList(param);
        dataList.forEach((PatentInfo patentInfo)->{
            patentInfo.setApplicationDateStr(DateUtils.format(patentInfo.getApplicationDate(),DateUtils.FMT_SS));
        });
        //PageInfo pageInfo = new PageInfo(dataList);

        return dataList;
    }

    @Override
    public List queryNoPage(Map param) {
        return patentInfoMapper.queryPatentList(param);
    }

    @Override
    public Integer batchRemove(String ids) {
        return patentInfoMapper.batchRemove(ids);
    }

    @Override
    public Integer postTreatment(String ids) {
        return patentInfoMapper.postTreatment(ids);
    }

    @Override
    public List<Map> countByLegalStatus(Map param) {
        return patentInfoMapper.countByLegalStatus(param);
    }

    @Override
    public List<Map> countByPatentType(Map param) {
        return patentInfoMapper.countByPatentType(param);
    }

    @Override
    public void insertBatch(List<PatentInfo> list) throws Exception {
        if(list!=null && list.size()>0)
        {
            for(int i=0;i<list.size();i++)
            {
                PatentInfo patentInfo=list.get(i);
                patentInfoMapper.insertSelective(patentInfo);
            }
        }
    }

    public PatentInfo getPatentInfo(String id){
        return patentInfoMapper.selectByPrimaryKey(id);
    }

    public Integer deletePatent(String id) {
        return patentInfoMapper.deleteByPrimaryKey(id);
    }
}