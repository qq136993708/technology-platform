package com.pcitc.service.achieve.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.achieve.AchieveRecord;
import com.pcitc.base.util.IsEmptyUtil;
import com.pcitc.mapper.achieve.AchieveRecordMapper;
import com.pcitc.service.achieve.AchieveRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author
 */
@Service
public class AchieveRecordServiceImpl implements AchieveRecordService {

    @Autowired
    private AchieveRecordMapper arm;

    @Override
    public AchieveRecord load(String id) {
        return arm.load(id);
    }

    @Override
    public void save(AchieveRecord ab) {

        IsEmptyUtil.isEmpty(ab.getId());
        if(load(ab.getId()) ==null){
            ab.setCreateDate(ab.getUpdateDate());
            ab.setCreator(ab.getUpdator());
            arm.add(ab);
        }
        else{
            arm.update(ab);
        }
    }

    @Override
    public void delete(String id) {
        arm.delete(id);
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
