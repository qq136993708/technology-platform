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
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.base.util.StrUtil;
import com.pcitc.base.util.TreeNodeUtil;
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
    public int updateOrInsertPatentInfo(PatentInfo patentInfo) {
        if(Objects.nonNull(patentInfo.getId())&&!"".equals(patentInfo.getId())){
            return patentInfoMapper.updateByPrimaryKey(patentInfo);
        }else{
            return patentInfoMapper.insertSelective(patentInfo);
        }
    }

    @Override
    public LayuiTableData queryPatentList(LayuiTableParam param) {
        PatentInfoExample example = new PatentInfoExample();
        PatentInfoExample.Criteria c = example.createCriteria();

        //条件查询设置条件
       /* c.andStatusEqualTo("0");
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

    public PatentInfo getPatentInfo(String id) throws Exception {
        return patentInfoMapper.selectByPrimaryKey(id);
    }

    public Integer deletePatent(String id) {
        return patentInfoMapper.deleteByPrimaryKey(id);
    }
}