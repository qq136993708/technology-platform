package com.pcitc.service.search.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.base.stp.out.OutProjectPlan;
import com.pcitc.mapper.out.OutProjectInfoMapper;
import com.pcitc.service.search.FullSearchService;
import com.pcitc.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service("fullSearchServiceImpl")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class FullSearchServiceImpl implements FullSearchService {


    @Autowired
    OutProjectInfoMapper outProjectInfoMapper;

    @Override
    public LayuiTableData getTableDataScientific(LayuiTableParam param) {
        // 每页显示条数
        int pageSize = param.getLimit();
        // 当前是第几页
        int pageNum = param.getPage();
        // 1、设置分页信息，包括当前页数和每页显示的总计数
        PageHelper.startPage(pageNum, pageSize);

        HashMap<String, Object> hashmap = new HashMap<String, Object>();
        OutProjectInfo opi = new OutProjectInfo();

        if (param.getParam().get("xmmc") != null && !StringUtils.isBlank(param.getParam().get("xmmc") + "")) {
            opi.setXmmc((String) param.getParam().get("xmmc"));
            hashmap.put("xmmc", param.getParam().get("xmmc"));
        }

        if (param.getParam().get("hth") != null && !StringUtils.isBlank(param.getParam().get("hth") + "")) {
            opi.setHth((String) param.getParam().get("hth"));
            hashmap.put("hth", param.getParam().get("hth"));
        }
        // 资本性、费用性
        if (param.getParam().get("define1") != null && !StringUtils.isBlank(param.getParam().get("define1") + "")) {
            opi.setDefine1((String) param.getParam().get("define1"));

            List define1 = new ArrayList();
            String[] temS = param.getParam().get("define1").toString().split(",");
            for (int i = 0; i < temS.length; i++) {
                define1.add(temS[i]);
            }
            hashmap.put("define1", define1);
        }

        // 8大院等细分结构
        if (param.getParam().get("define2") != null && !StringUtils.isBlank(param.getParam().get("define2") + "")) {
            opi.setDefine2((String) param.getParam().get("define2"));

            List define2 = new ArrayList();
            String[] temS = param.getParam().get("define2").toString().split(",");
            for (int i = 0; i < temS.length; i++) {
                define2.add(temS[i]);
            }
            hashmap.put("define2", define2);
        }

        // 直属研究院、分子公司、集团等9种类型
        if (param.getParam().get("define3") != null && !StringUtils.isBlank(param.getParam().get("define3") + "")) {
            opi.setDefine3((String) param.getParam().get("define3"));

            List define3 = new ArrayList();
            String[] temS = param.getParam().get("define3").toString().split(",");
            for (int i = 0; i < temS.length; i++) {
                define3.add(temS[i]);
            }
            hashmap.put("define3", define3);
        }

        // 国家项目、重大专项、重点项目、其他项目
        if (param.getParam().get("project_property") != null && !StringUtils.isBlank(param.getParam().get("project_property") + "")) {
            opi.setProjectProperty((String) param.getParam().get("project_property"));

            List project_property = new ArrayList();
            String[] temS = param.getParam().get("project_property").toString().split(",");
            for (int i = 0; i < temS.length; i++) {
                project_property.add(temS[i]);
            }
            hashmap.put("project_property", project_property);
        }

        // 新开项目、续建项目、完工项目
        if (param.getParam().get("project_scope") != null && !StringUtils.isBlank(param.getParam().get("project_scope") + "")) {
            opi.setProjectScope((String) param.getParam().get("project_scope"));
        }

        // 装备的各种技术类型
        if (param.getParam().get("zylb") != null && !StringUtils.isBlank(param.getParam().get("zylb") + "")) {
            opi.setZylb((String) param.getParam().get("zylb"));
        }

        // 各个处室
        if (param.getParam().get("zycmc") != null && !StringUtils.isBlank(param.getParam().get("zycmc") + "")) {
            opi.setZycmc((String) param.getParam().get("zycmc"));

            List zycmc = new ArrayList();
            String[] temS = param.getParam().get("zycmc").toString().split(",");
            for (int i = 0; i < temS.length; i++) {
                zycmc.add(temS[i]);
            }
            hashmap.put("zycmc", zycmc);
        }

        // 年度，暂时不用
        if (param.getParam().get("nd") != null && !StringUtils.isBlank(param.getParam().get("nd") + "")) {
            opi.setNd((String) param.getParam().get("nd"));
        }

        Object keywords = param.getParam().get("keyword");
        System.out.println("keywords = " + keywords);
        if (keywords == null || "".equals(keywords)) {
            //查询添加添加keyords
            setMethodVal(opi, keywords.toString());
        }

        List<OutProjectInfo> list = outProjectInfoMapper.findOutProjectInfoList(opi);
        System.out.println("1>>>>>>>>>查询分页结果" + list.size());
        PageInfo<OutProjectInfo> pageInfo = new PageInfo<OutProjectInfo>(list);
        System.out.println("2>>>>>>>>>查询分页结果" + pageInfo.getList().size());

        LayuiTableData data = new LayuiTableData();
        data.setData(pageInfo.getList());
        Long total = pageInfo.getTotal();
        data.setCount(total.intValue());
        return data;
    }

    public static void setMethodVal(Object obj, String setVal) {
        try {
            Class clazz = obj.getClass();//获得实体类名
            Field[] fields = obj.getClass().getDeclaredFields();//获得属性
            //获得Object对象中的所有方法
            for (Field field : fields) {
                if ("java.lang.String".equals(field.getType().getName())) {
                    PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
                    Method getMethod = pd.getReadMethod();//获得get方法
                    Object obj_get = getMethod.invoke(obj);//此处为执行该Object对象的get方法
                    if (obj_get == null || "".equals(obj_get)) {
                        Method setMethod = pd.getWriteMethod();//获得set方法
                        setMethod.invoke(obj, setVal);//此处为执行该Object对象的set方法
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
