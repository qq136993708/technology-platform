package com.pcitc.service.patent.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.*;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.expert.*;
import com.pcitc.base.patent.PatentInfo;
import com.pcitc.base.patent.PatentInfoExample;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.util.*;
import com.pcitc.config.SpringContextUtil;
import com.pcitc.mapper.expert.*;
import com.pcitc.mapper.patent.PatentInfoMapper;
import com.pcitc.service.expert.*;
import com.pcitc.service.feign.SystemRemoteClient;
import com.pcitc.service.patent.PatentInfoService;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

//import com.github.abel533.echarts.Label;
//import com.github.abel533.echarts.series.Graph;
//import com.github.abel533.echarts.style.ItemStyle;
//import com.github.abel533.echarts.style.itemstyle.Normal;

/**
 * <p>接口实现类</p>
 * <p>Table: patent_info - 专利信息</p>
 *
 * @since 2019-11-16 04:10:36
 */
@Service("PatentInfoService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class PatentInfoServiceImpl implements PatentInfoService {

    @Resource
    private PatentInfoMapper patentInfoMapper;

    @Override
    public PatentInfo updateOrInsertPatentInfo(PatentInfo patentInfo) {
        IsEmptyUtil.isEmpty(patentInfo.getId());
        if(this.getPatentInfo(patentInfo.getId()) != null){
            patentInfoMapper.updateByPrimaryKey(patentInfo);
        }else{
            patentInfoMapper.insertSelective(patentInfo);
        }
        return patentInfo;
    }

    @Override
    public PageInfo queryPatentList(Map param) {
        int pageNum = (int)param.get("pageNum");
        int pageSize = (int)param.get("pageSize");
        PageHelper.startPage(pageNum, pageSize);
        List dataList = patentInfoMapper.queryPatentList(param);
        PageInfo pageInfo = new PageInfo(dataList);

        return pageInfo;
    }

    public PatentInfo getPatentInfo(String id){
        return patentInfoMapper.selectByPrimaryKey(id);
    }

    public Integer deletePatent(String id) {
        return patentInfoMapper.deleteByPrimaryKey(id);
    }
}