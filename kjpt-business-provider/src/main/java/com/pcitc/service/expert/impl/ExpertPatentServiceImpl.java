package com.pcitc.service.expert.impl;

import com.pcitc.base.expert.ZjkPatent;
import com.pcitc.base.util.DateUtil;
import com.pcitc.mapper.expert.ZjkPatentMapper;
import com.pcitc.service.expert.ExpertPatentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author ty
 */
@Service
public class ExpertPatentServiceImpl implements ExpertPatentService {
    @Autowired
    private ZjkPatentMapper zjkPatentMapper;

    @Override
    public List<ZjkPatent> queryNoPage(Map paramMap) {
        List<ZjkPatent> zjkPatentList = zjkPatentMapper.query(paramMap);
        zjkPatentList.forEach(zjkPatent -> {
            zjkPatent.setGetPatentTimeStr(DateUtil.format(zjkPatent.getGetPatentTime(),DateUtil.FMT_SS));
        });
        return zjkPatentList;
    }

    @Override
    public void insertBatch(List<ZjkPatent> list) throws Exception {
        if(list!=null && list.size()>0)
        {
            for(int i=0;i<list.size();i++)
            {
                ZjkPatent zjkPatent=list.get(i);
                zjkPatentMapper.insert(zjkPatent);
            }
        }
    }

}
