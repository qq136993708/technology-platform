package com.pcitc.service.expert.impl;

import com.pcitc.base.expert.ZjkReward;
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
        return  zjkRewardMapper.query(paramMap);
    }

}
