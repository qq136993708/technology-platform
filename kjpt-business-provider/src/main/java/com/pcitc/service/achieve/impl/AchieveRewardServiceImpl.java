package com.pcitc.service.achieve.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.achieve.AchieveReward;
import com.pcitc.base.util.IsEmptyUtil;
import com.pcitc.mapper.achieve.AchieveRewardMapper;
import com.pcitc.service.achieve.AchieveRewardService;
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
public class AchieveRewardServiceImpl implements AchieveRewardService {
    @Autowired
    private AchieveRewardMapper arm;

    @Autowired
    private FileCommonService fs;

    @Override
    public AchieveReward load(String id) {
        return arm.load(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(AchieveReward ab) {
        IsEmptyUtil.isEmpty(ab.getId());

        if(ab.getBudgetPerson()!=null){
            ab.setTeamPersonCount(ab.getBudgetPerson().split("$").length);
        }

        if(load(ab.getId()) ==null){
            ab.setCreateDate(ab.getUpdateDate());
            ab.setCreator(ab.getUpdator());
            handlerFile(ab.getFiles(),ab.getSecretLevel());
            arm.add(ab);
        }
        else{
            handlerFile(ab.getFiles(),ab.getSecretLevel());
            arm.update(ab);

        }
        arm.updateRewardMoney(ab.getAchieveId());
    }

    private void handlerFile(String files,String secretLevel){
        if(files != null) {
            JSONObject fileDoc = JSONObject.parseObject(files);
            for (String key : fileDoc.keySet()) {
                fs.updateFileData(fileDoc.get(key) == null ? "" : fileDoc.get(key).toString(),key,secretLevel);
            }
        }
    }

    @Override
    public Integer delete(String id) {
        return  arm.delete(id);
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
