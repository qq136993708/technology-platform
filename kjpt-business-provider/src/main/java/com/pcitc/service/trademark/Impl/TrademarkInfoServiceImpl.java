package com.pcitc.service.trademark.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.patent.PatentInfo;
import com.pcitc.base.patent.PatentInfoExample;
import com.pcitc.base.trademarkinfo.TrademarkInfo;
import com.pcitc.base.trademarkinfo.TrademarkInfoExample;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.base.util.StrUtil;
import com.pcitc.mapper.patent.PatentInfoMapper;
import com.pcitc.mapper.trademarkinfo.TrademarkInfoMapper;
import com.pcitc.service.patent.PatentInfoService;
import com.pcitc.service.trademark.TrademarkInfoService;
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

    public int updateOrInsertTrademarkInfo(TrademarkInfo trademarkInfo) {
        if(Objects.nonNull(trademarkInfo.getId())&&!"".equals(trademarkInfo.getId())){
            return trademarkInfoMapper.updateByPrimaryKey(trademarkInfo);
        }else{
            return trademarkInfoMapper.insertSelective(trademarkInfo);
        }
    }

    public LayuiTableData queryTrademarkList(LayuiTableParam param) {
        TrademarkInfoExample example = new TrademarkInfoExample();
        TrademarkInfoExample.Criteria c = example.createCriteria();

        //条件查询设置条件
/*        c.andStatusEqualTo("0");
        c.andDelFlagEqualTo("0");
        Object expertName = param.getParam().get("expertName");
        if (!StrUtil.isObjectEmpty(expertName)) {
            c.andExpertNameLike("%" + expertName + "%");
        }

        Object auditStatus = param.getParam().get("auditStatus");
        if (!StrUtil.isObjectEmpty(auditStatus)) {
            c.andAuditStatusEqualTo(auditStatus.toString());
        }

        Object sysFlag = param.getParam().get("sysFlag");
        if (!StrUtil.isObjectEmpty(sysFlag)) {
            c.andSysFlagEqualTo(sysFlag.toString());
        } else {
            c.andSysFlagEqualTo("0");
        }
        Object email = param.getParam().get("email");
        if (!StrUtil.isObjectEmpty(email)) {
            c.andEmailLike("%" + email + "%");
        }
        Object company = param.getParam().get("company");
        if (!StrUtil.isObjectEmpty(company)) {
            c.andCompanyEqualTo(company.toString());
        }

        LayuiTableData data = new LayuiTableData();
        Object keywords = param.getParam().get("keyword");
        if (keywords != null && !"".equals(keywords)) {
            c.andExpertNameLike("%" + keywords + "%");
        }


        Object key = param.getParam().get("key");
        if (key != null && !"".equals(key)) {
            example.setKey(key.toString());
        }


        Object expertProfessinal = param.getParam().get("expertProfessinal");
        if (expertProfessinal != null && !"".equals(expertProfessinal)) {
            c.andExpertProfessinalEqualTo(expertProfessinal.toString());
        }
        Object expertProfessionalField = param.getParam().get("expertProfessionalField");
        if (expertProfessionalField != null && !"".equals(expertProfessionalField)) {
            c.andExpertProfessionalFieldEqualTo(expertProfessionalField.toString());
        }
        Object bak3 = param.getParam().get("bak3");
        if (bak3 != null && !"".equals(bak3)) {
            c.andBak3EqualTo(bak3.toString());
        }*/


        example.setOrderByClause("create_date desc");
        return this.findByExample(param, example);

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
    public LayuiTableData findByExample(LayuiTableParam param, TrademarkInfoExample example) {
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
        List<TrademarkInfo> list = trademarkInfoMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<TrademarkInfo> pageInfo = new PageInfo<TrademarkInfo>(list);
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

    public TrademarkInfo getTrademarkInfo(String id) throws Exception {
        return trademarkInfoMapper.selectByPrimaryKey(id);
    }

    public Integer deleteTrademark(String id) {
        return trademarkInfoMapper.deleteByPrimaryKey(id);
    }
}