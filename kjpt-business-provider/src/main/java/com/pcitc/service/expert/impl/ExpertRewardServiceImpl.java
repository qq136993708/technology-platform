package com.pcitc.service.expert.impl;

import com.pcitc.base.expert.ZjkReward;
import com.pcitc.base.util.DateUtil;
import com.pcitc.mapper.expert.ZjkRewardMapper;
import com.pcitc.service.expert.ExpertRewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author ty
 */
@Service
public class ExpertRewardServiceImpl implements ExpertRewardService {
    @Autowired
    private ZjkRewardMapper zjkRewardMapper;

    @Override
    public List<ZjkReward> queryNoPage(Map paramMap) {
        List<ZjkReward> zjkRewardList = zjkRewardMapper.query(paramMap);
        zjkRewardList.forEach( zjkReward -> {
           zjkReward.setAwardingTimeStr(DateUtil.format(zjkReward.getAwardingTime(),DateUtil.FMT_SS));
        });
        return  zjkRewardList;
    }

    @Override
    public void insertBatch(List<ZjkReward> list) throws Exception {
        if(list!=null && list.size()>0)
        {
            for(int i=0;i<list.size();i++)
            {
                ZjkReward zjkReward=list.get(i);
                zjkRewardMapper.insert(zjkReward);
            }
        }
    }

}
