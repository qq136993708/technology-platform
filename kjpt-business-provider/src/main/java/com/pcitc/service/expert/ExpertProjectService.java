package com.pcitc.service.expert;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.expert.ZjkProject;
import com.pcitc.base.researchplatform.PlatformProjectModel;

import java.util.List;
import java.util.Map;

/**
 * 科研平台项目的增删改查
 * @author ty
 */
public interface ExpertProjectService {


    /**
     * 查询专家信息管理项目列表
     */
    List<ZjkProject> queryNoPage(Map paramMap);

}
