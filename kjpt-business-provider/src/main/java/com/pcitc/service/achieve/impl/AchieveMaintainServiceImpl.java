package com.pcitc.service.achieve.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.achieve.AchieveMaintain;
import com.pcitc.base.util.IsEmptyUtil;
import com.pcitc.mapper.achieve.AchieveMaintainMapper;
import com.pcitc.service.achieve.AchieveMaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author ty
 */
@Service
public class AchieveMaintainServiceImpl implements AchieveMaintainService {

    @Autowired
    private AchieveMaintainMapper mapper;

    @Override
    public AchieveMaintain load(String id) {
        return mapper.load(id);
    }

    @Override
    public void save(AchieveMaintain am) {

        IsEmptyUtil.isEmpty(am.getId());
        if(load(am.getId()) ==null){
            am.setCreateDate(am.getUpdateDate());
            am.setCreator(am.getUpdator());
             mapper.add(am);
        }
        else{
            mapper.update(am);
        }
    }

    @Override
    public Integer delete(String ids) {
        return mapper.delete(ids);
    }

    @Override
    public PageInfo query(Map param) {

        int pageNum = (int)param.get("pageNum");
        int pageSize = (int)param.get("pageSize");
        PageHelper.startPage(pageNum, pageSize);
        List dataList = mapper.query(param);
        PageInfo pageInfo = new PageInfo(dataList);
        return pageInfo;
    }

    @Override
    public List<AchieveMaintain> queryNoPage(Map paramMap) {
        return mapper.query(paramMap);
    }
}
