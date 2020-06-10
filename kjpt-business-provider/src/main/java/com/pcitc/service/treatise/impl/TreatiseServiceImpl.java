package com.pcitc.service.treatise.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.treatiseinfo.TreatiseInfo;
import com.pcitc.base.util.IsEmptyUtil;
import com.pcitc.mapper.treatise.TreatiseInfoMapper;
import com.pcitc.service.file.FileCommonService;
import com.pcitc.service.treatise.TreatiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author ty
 */
@Service
public class TreatiseServiceImpl implements TreatiseService {

    @Autowired
    private TreatiseInfoMapper tm;

    @Autowired
    private FileCommonService fs;

    @Override
    public TreatiseInfo load(String id) {
        return tm.load(id);
    }

    @Override
    public void save(TreatiseInfo ti) {
        IsEmptyUtil.isEmpty(ti.getId());
        if(load(ti.getId()) ==null){
            ti.setCreateDate(ti.getUpdateDate());
            ti.setCreator(ti.getUpdator());
            fs.updateFileData(ti.getFiles(),ti.getId());
            tm.add(ti);
        }
        else{
            fs.updateFileData(ti.getFiles(),ti.getId());
            tm.update(ti);
        }
    }


    @Override
    public Integer delete(String ids) {
        return tm.delete(ids);
    }

    @Override
    public PageInfo query(Map param) {
        int pageNum = (int)param.get("pageNum");
        int pageSize = (int)param.get("pageSize");
        PageHelper.startPage(pageNum, pageSize);
        List dataList = tm.query(param);
        PageInfo pageInfo = new PageInfo(dataList);
        return pageInfo;
    }

    @Override
    public List<TreatiseInfo> queryNoPage(Map paramMap) {
        return tm.query(paramMap);
    }

    @Override
    public void insertBatch(List<TreatiseInfo> list) throws Exception {
        if(list!=null && list.size()>0)
        {
            for(int i=0;i<list.size();i++)
            {
                TreatiseInfo treatiseInfo=list.get(i);
                tm.add(treatiseInfo);
            }
        }
    }
}
