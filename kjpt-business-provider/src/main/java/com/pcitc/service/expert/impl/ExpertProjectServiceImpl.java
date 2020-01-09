package com.pcitc.service.expert.impl;

import com.pcitc.base.expert.ZjkProject;
import com.pcitc.mapper.expert.ZjkProjectMapper;
import com.pcitc.service.expert.ExpertProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author ty
 */
@Service
public class ExpertProjectServiceImpl implements ExpertProjectService {
    @Autowired
    private ZjkProjectMapper zjkProjectMapper;

    @Override
    public List<ZjkProject> queryNoPage(Map paramMap) {
        return  zjkProjectMapper.query(paramMap);
    }

}
