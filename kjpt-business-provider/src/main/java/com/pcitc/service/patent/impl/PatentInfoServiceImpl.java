package com.pcitc.service.patent.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.*;
import com.pcitc.base.patent.PatentInfo;
import com.pcitc.base.patent.PatentInfoExample;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.base.util.StrUtil;
import com.pcitc.mapper.patent.PatentInfoMapper;
import com.pcitc.service.patent.PatentInfoService;
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
        if(Objects.nonNull(patentInfo.getId())&&!"".equals(patentInfo.getId())){
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

    public List<Map<String, Object>> setKeyWordCss(PageInfo<?> pageInfo, String keywords) {
        List<Map<String, Object>> maps = new ArrayList<>();
        for (int i = 0; i < pageInfo.getSize(); i++) {
            Object obj = pageInfo.getList().get(i);
            Map<String, Object> map = MyBeanUtils.transBean2Map(obj);
            Set<Map.Entry<String, Object>> entrys = map.entrySet();  //此行可省略，直接将map.entrySet()写在for-each循环的条件中

            Map<String, Object> objectMap = new HashMap<>();
            for (Map.Entry<String, Object> entry : entrys) {
                Object val = entry.getValue();
                if (val != null && !"".equals(val) && val.toString().contains(keywords.toString())) {
                    objectMap.put(entry.getKey(), val.toString().replace(keywords.toString(), "<span style=\"color:red\">" + keywords.toString() + "</span>"));
                } else {
                    objectMap.put(entry.getKey(), entry.getValue());
                }
            }
            maps.add(objectMap);

        }
        return maps;
    }

    /**
     * 根据条件分页搜索
     *
     * @param param
     * @param example
     * @return
     */
    public LayuiTableData findByExample(LayuiTableParam param, PatentInfoExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        if (!StrUtil.isNullEmpty(param.getOrderKey())) {
            String key = param.getOrderKey();
            if ("expertName".equals(key)) {
                key = "expert_name";
            } else if ("birthDate".equals(key)) {
                key = "birth_date";
            }
            PageHelper.orderBy(key + " " + param.getOrderType().toString());
        }
        List<PatentInfo> list = patentInfoMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<PatentInfo> pageInfo = new PageInfo<PatentInfo>(list);
        LayuiTableData data = new LayuiTableData();
        Object keywords = param.getParam().get("keyword");
        if (keywords != null && !"".equals(keywords)) {
            data.setData(setKeyWordCss(pageInfo, keywords.toString()));
        } else {
            data.setData(pageInfo.getList());
        }
        Long total = pageInfo.getTotal();
        data.setCount(total.intValue());
        return data;
    }

    public PatentInfo getPatentInfo(String id){
        return patentInfoMapper.selectByPrimaryKey(id);
    }

    public Integer deletePatent(String id) {
        return patentInfoMapper.deleteByPrimaryKey(id);
    }
}