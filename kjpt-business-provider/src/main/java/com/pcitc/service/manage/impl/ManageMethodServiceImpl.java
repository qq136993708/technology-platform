package com.pcitc.service.manage.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.groupinformation.BlocScientificPlan;
import com.pcitc.base.manage.ManageMethod;
import com.pcitc.base.util.IsEmptyUtil;
import com.pcitc.mapper.manage.ManageMethodMapper;
import com.pcitc.service.file.FileCommonService;
import com.pcitc.service.manage.ManageMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author ty
 */
@Service
public class ManageMethodServiceImpl implements ManageMethodService {
    @Autowired
    private ManageMethodMapper mapper;

    @Autowired
    private FileCommonService fs;

    @Override
    public ManageMethod load(String id) {
        return mapper.load(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(ManageMethod mm) {
        IsEmptyUtil.isEmpty(mm.getId());
        if(load(mm.getId()) ==null){
            mm.setCreateDate(mm.getUpdateDate());
            mm.setCreator(mm.getUpdator());
            fs.updateFileData(mm.getFiles(),mm.getId());
            mapper.add(mm);
        }
        else{
            fs.updateFileData(mm.getFiles(),mm.getId());
            mapper.update(mm);
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
    public List queryNoPage(Map paramMap) {
        return mapper.query(paramMap);
    }

    @Override
    public void insertBatch(List<ManageMethod> list) throws Exception {

        if(list!=null && list.size()>0)
        {
            for(int i=0;i<list.size();i++)
            {
                ManageMethod manageMethod=list.get(i);
                mapper.add(manageMethod);
            }
        }

    }
}
