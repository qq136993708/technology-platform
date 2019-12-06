package com.pcitc.service.achieve.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.achieve.AchieveRecord;
import com.pcitc.base.achieve.AchieveReward;
import com.pcitc.base.achieve.AchieveSubmit;
import com.pcitc.base.util.IsEmptyUtil;
import com.pcitc.mapper.achieve.AchieveRecordMapper;
import com.pcitc.mapper.achieve.AchieveRewardMapper;
import com.pcitc.service.achieve.AchieveRecordService;
import com.pcitc.service.file.FileCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author
 */
@Service
public class AchieveRecordServiceImpl implements AchieveRecordService {

    @Autowired
    private AchieveRecordMapper arm;

    @Autowired
    private AchieveRewardMapper arw;

    @Autowired
    private FileCommonService fs;

    @Override
    public AchieveRecord load(String id) {
        return arm.load(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(AchieveSubmit as) {

        AchieveRecord aRecord = as.getAchieveRecord();
        AchieveReward aReward = as.getAchieveReward();
        IsEmptyUtil.isEmpty(aRecord);
        if(load(aRecord.getId()) ==null){
            aRecord.setCreateDate(as.getUpdateDate());
            aRecord.setCreator(as.getUpdator());
            arm.add(aRecord);
            if(aReward != null){
                aReward.setCreateDate(as.getUpdateDate());
                aReward.setCreator(as.getUpdator());
                arw.add(aReward);
                arw.updateRewardMoney(aRecord.getId());
            }
        }
        else{
            arm.update(aRecord);
            if(aReward != null) {
                arw.update(aReward);
                arw.updateRewardMoney(aRecord.getId());
            }
        }

    }

    @Override
    public Integer delete(String ids) {
        String[] idArr = ids.split(",");
        return arm.delete(idArr);
    }

    @Override
    public PageInfo query(Map param) {
        int pageNum = (int)param.get("pageNum");
        int pageSize = (int)param.get("pageSize");
        PageHelper.startPage(pageNum, pageSize);
        List dataList = arm.query(param);
        PageInfo pageInfo = new PageInfo(dataList);
        return pageInfo;
    }
}
