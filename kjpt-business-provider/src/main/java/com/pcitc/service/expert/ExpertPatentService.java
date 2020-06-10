package com.pcitc.service.expert;

import com.pcitc.base.expert.ZjkPatent;

import java.util.List;
import java.util.Map;

/**
 * 科研平台项目的增删改查
 * @author ty
 */
public interface ExpertPatentService {


    /**
     * 查询专家信息管理项目列表
     */
    List<ZjkPatent> queryNoPage(Map paramMap);

    public void insertBatch(List<ZjkPatent> list)throws Exception;

}
