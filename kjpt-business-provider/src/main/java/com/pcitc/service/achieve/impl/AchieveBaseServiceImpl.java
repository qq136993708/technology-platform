package com.pcitc.service.achieve.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.achieve.AchieveBase;
import com.pcitc.base.util.IsEmptyUtil;
import com.pcitc.mapper.achieve.AchieveBaseMapper;
import com.pcitc.service.achieve.AchieveBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author
 */
@Service
public class AchieveBaseServiceImpl implements AchieveBaseService {

    @Autowired
    private AchieveBaseMapper abm;

    @Override
    public AchieveBase load(String id) {
        return abm.load(id);
    }

    @Override
    public void save(AchieveBase ab) {

        IsEmptyUtil.isEmpty(ab.getId());
        if(load(ab.getId()) ==null){
            ab.setCreateDate(ab.getUpdateDate());
            ab.setCreator(ab.getUpdator());
            abm.add(ab);
        }
        else{
            abm.update(ab);
        }

    }

    @Override
    public void delete(String id) {
        abm.delete(id);
    }

    @Override
    public PageInfo query(Map param) {
        int pageNum = (int)param.get("pageNum");
        int pageSize = (int)param.get("pageSize");
        PageHelper.startPage(pageNum, pageSize);
        List dataList = abm.query(param);
        PageInfo pageInfo = new PageInfo(dataList);
        return pageInfo;
    }
}
