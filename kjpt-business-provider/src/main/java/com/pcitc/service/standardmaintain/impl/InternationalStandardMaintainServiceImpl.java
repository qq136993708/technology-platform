package com.pcitc.service.standardmaintain.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.standardmaintain.InternationalStandardMaintain;
import com.pcitc.base.standardmaintain.StandardMaintain;
import com.pcitc.base.util.IsEmptyUtil;
import com.pcitc.mapper.standardmaintain.InternationalStandardMaintainMapper;
import com.pcitc.mapper.standardmaintain.StandardMaintainMapper;
import com.pcitc.service.file.FileCommonService;
import com.pcitc.service.standardmaintain.InternationalStandardMaintainService;
import com.pcitc.service.standardmaintain.StandardMaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author ty
 */
@Service
public class InternationalStandardMaintainServiceImpl implements InternationalStandardMaintainService {

    @Autowired
    private InternationalStandardMaintainMapper mapper;

    @Autowired
    private FileCommonService fs;

    @Override
    public InternationalStandardMaintain load(String id) {
        return mapper.load(id);
    }

    @Override
    public void save(InternationalStandardMaintain am) {
        IsEmptyUtil.isEmpty(am.getId());
        if(load(am.getId()) ==null){
            am.setCreateDate(am.getUpdateDate());
            am.setCreator(am.getUpdator());
            fs.updateFileData(am.getFiles(),am.getId());
            mapper.add(am);
        }
        else{
            fs.updateFileData(am.getFiles(),am.getId());
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
    public List queryNoPage(Map param) {
        return mapper.query(param);
    }
}
