package com.pcitc.service.trademark.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.trademarkinfo.TrademarkInfo;
import com.pcitc.base.util.IsEmptyUtil;
import com.pcitc.mapper.trademarkinfo.TrademarkInfoMapper;
import com.pcitc.service.file.FileCommonService;
import com.pcitc.service.trademark.TrademarkInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

//import com.github.abel533.echarts.Label;
//import com.github.abel533.echarts.series.Graph;
//import com.github.abel533.echarts.style.ItemStyle;
//import com.github.abel533.echarts.style.itemstyle.Normal;

/**
 * <p>接口实现类</p>
 * <p>Table: trademark_info - 商标信息</p>
 *
 * @since 2019-11-16 04:10:36
 */
@Service("TrademarkInfoService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class TrademarkInfoServiceImpl implements TrademarkInfoService {

    @Resource
    private TrademarkInfoMapper trademarkInfoMapper;
    @Autowired
    FileCommonService fileCommonService;

    public TrademarkInfo updateOrInsertTrademarkInfo(TrademarkInfo trademarkInfo) {
        IsEmptyUtil.isEmpty(trademarkInfo.getId());
        if(Objects.nonNull(this.getTrademarkInfo(trademarkInfo.getId()))){
            trademarkInfoMapper.updateByPrimaryKey(trademarkInfo);
        }else{
            trademarkInfoMapper.insertSelective(trademarkInfo);
        }
        fileCommonService.updateFileData(trademarkInfo.getFiles(),trademarkInfo.getId(),trademarkInfo.getSecretLevel());
        return trademarkInfo;
    }

    public PageInfo queryTrademarkList(Map param) {
        int pageNum = (int)param.get("pageNum");
        int pageSize = (int)param.get("pageSize");
        PageHelper.startPage(pageNum, pageSize);
        List dataList = trademarkInfoMapper.queryTrademarkList(param);
        PageInfo pageInfo = new PageInfo(dataList);

        return pageInfo;
    }


    public TrademarkInfo getTrademarkInfo(String id){
        return trademarkInfoMapper.selectByPrimaryKey(id);
    }

    public Integer deleteTrademark(String id) {
        return trademarkInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List queryNoPage(Map param) {
        return trademarkInfoMapper.queryTrademarkList(param);
    }

    @Override
    public List countByLawType(Map param) {
        return trademarkInfoMapper.countByLawType(param);
    }

    @Override
    public void insertBatch(List<TrademarkInfo> list) throws Exception {
        if(list!=null && list.size()>0)
        {
            for(int i=0;i<list.size();i++)
            {
                TrademarkInfo trademarkInfo=list.get(i);
                trademarkInfoMapper.insertSelective(trademarkInfo);
            }
        }
    }
}