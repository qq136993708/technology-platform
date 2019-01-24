package com.pcitc.service.search.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode2;
import com.pcitc.base.hana.report.H1AMKYSY100117;
import com.pcitc.base.report.SysReportStp;
import com.pcitc.base.report.SysReportStpExample;
import com.pcitc.base.stp.out.*;
import com.pcitc.mapper.out.OutAppraisalMapper;
import com.pcitc.mapper.out.OutProjectInfoMapper;
import com.pcitc.mapper.out.OutRewardMapper;
import com.pcitc.service.expert.TfmTypeService;
import com.pcitc.service.report.SysReportStpService;
import com.pcitc.service.search.FullSearchAsycService;
import com.pcitc.service.search.FullSearchService;
import com.pcitc.utils.StringUtils;
import com.pcitc.web.feign.HomeProviderClient;
import com.pcitc.web.feign.ZjkBaseInfoServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * @author:Administrator
 * @date:2019/1/22
 */
@Async
@Service("fullSearchAsycServiceImpl")
public class FullSearchAsycServiceImpl implements FullSearchAsycService {

    @Autowired
    FullSearchService fullSearchService;

    @Autowired
    SysReportStpService sysReportStpService;

    @Autowired
    HomeProviderClient homeProviderClient;

    @Autowired
    OutRewardMapper outRewardMapper;
    @Autowired
    TfmTypeService tfmTypeService;
    @Autowired
    ZjkBaseInfoServiceClient zjkBaseInfoServiceClient;

    private List<String> listInfo;

    @Async
    public Future<LayuiTableData> getOutRewardListPage(LayuiTableParam param) {
        Map<String, Object> paraMap = param.getParam();
        PageHelper.startPage(param.getPage(), param.getLimit());

        OutRewardExample example = new OutRewardExample();
        OutRewardExample.Criteria criteria = example.createCriteria();

        if (paraMap.get("xmbh") != null && !paraMap.get("xmbh").toString().equals("")) {
            criteria.andXmbhLike("%" + paraMap.get("xmbh").toString() + "%");
        }
        if (paraMap.get("nd") != null && !paraMap.get("nd").toString().equals("")) {
            criteria.andNdEqualTo(paraMap.get("nd").toString());
        }
        if (paraMap.get("xmmc") != null && !paraMap.get("xmmc").toString().equals("")) {
            criteria.andXmmcLike("%" + paraMap.get("xmmc").toString() + "%");
        }
        List<String> strings = FullSearchServiceImpl.getListInfo(FullSearchServiceImpl.outreward);
        Object keywords = param.getParam().get("keyword");
        if (keywords != null && !"".equals(keywords)) {
            criteria.andOrColumn(keywords.toString(), strings.toArray(new String[strings.size()]), "like");
        }

        example.setOrderByClause(" sbjz,sbdj asc ");

        List<OutReward> list = outRewardMapper.selectByExample(example);
        PageInfo<OutReward> pageInfo = new PageInfo<OutReward>(list);

        LayuiTableData data = new LayuiTableData();

        if (keywords != null && !"".equals(keywords)) {
            data.setData(fullSearchService.setKeyWordCss(pageInfo, keywords.toString()));
        } else {
            data.setData(pageInfo.getList());
        }
        Long total = pageInfo.getTotal();
        data.setCount(total.intValue());
        return new AsyncResult<LayuiTableData>(data);
    }
    @Async
    public Future<LayuiTableData> getEquipmentListPage(LayuiTableParam param_common) throws Exception {
        JSONArray jSONArray = homeProviderClient.get_home_KYZB_02(JSONObject.toJSONString(param_common.getParam()));
        Object keyword = param_common.getParam().get("keyword");
        LayuiTableData layuiTableData = new LayuiTableData();

        List<H1AMKYSY100117> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100117.class);

        List<TreeNode2> chartCircleList = new ArrayList<TreeNode2>();
        List<TreeNode2> chartCircleListRed = new ArrayList<TreeNode2>();
        String strKeyword = "";
        for (int i = 0; i < list.size(); i++) {
            H1AMKYSY100117 bean = list.get(i);

            TreeNode2 node = new TreeNode2();
            node.setExtend01(bean.getG0ZCXLMS());//设备类型
            node.setExtend02(bean.getG0GSJC());//直属研究院
            node.setExtend04(bean.getG0ZBHND());//购置年度
            node.setExtend05(bean.getG0NDJAR());//使用年限
            node.setExtend06(bean.getG0NDSYN());//剩余年限

            DecimalFormat decimalFormat = new DecimalFormat(".00");
            node.setExtend07(bean.getG0NCGZYZJE());//购置金额(万元)
            if (bean.getG0NCGZYZJE() != null) {
                node.setExtend07(decimalFormat.format(Double.valueOf(bean.getG0NCGZYZJE()) / 10000l));
            }
            node.setExtend08(bean.getG0LJZJJE());//折旧金额（万元）
            if (bean.getG0LJZJJE() != null) {
                node.setExtend08(decimalFormat.format(Double.valueOf(bean.getG0LJZJJE()) / 10000l));
            }
            node.setExtend09("0");
            if (bean.getG0NCGZYZJE() != null && bean.getG0LJZJJE() != null) {
                Double rs = Double.valueOf(node.getExtend07()) - Double.valueOf(node.getExtend08());
                node.setExtend09(decimalFormat.format(rs));
            }
            node.setExtend10(bean.getBl() + "%");//折旧率
            strKeyword = bean.getG0TXT50();
            if (keyword != null && !"".equals(keyword) && strKeyword.contains(keyword.toString())) {
                strKeyword = bean.getG0TXT50().replace(keyword.toString(), "<span style=\"color:red\">" + keyword + "</span>");
                node.setExtend03(strKeyword);//设备名称
                chartCircleListRed.add(node);
            }else {
                node.setExtend03(strKeyword);//设备名称
                chartCircleList.add(node);
            }
        }
        List<TreeNode2> resultList = new ArrayList<TreeNode2>();
        if (keyword != null && !"".equals(keyword)){
            if (chartCircleListRed.size()>0){
                resultList.add(chartCircleListRed.get(0));
            }
            layuiTableData.setData(resultList);
        }else {
            if (chartCircleList.size()>0){
                resultList.add(chartCircleList.get(0));
            }
            layuiTableData.setData(resultList);
        }
        return new AsyncResult<LayuiTableData>(layuiTableData);
    }

    @Override
    @Async
    public Future<LayuiTableData> findTfmTypeByPage(LayuiTableParam param) {
        LayuiTableData data = tfmTypeService.findTfmTypeByPage(param);
        return new AsyncResult<LayuiTableData>(data);
    }

    @Override
    public Future<LayuiTableData> selectZjkBaseInfoByPage(LayuiTableParam param) {
        LayuiTableData data =zjkBaseInfoServiceClient.selectZjkBaseInfoByPage(param);
        return new AsyncResult<LayuiTableData>(data);
    }

    @Override
    public Future<LayuiTableData> selectZjkZhuanliByPage(LayuiTableParam param) {
        LayuiTableData data =zjkBaseInfoServiceClient.selectZjkZhuanliByPage(param);
        return new AsyncResult<LayuiTableData>(data);
    }

    @Override
    @Async
    public Future<LayuiTableData> getTableDataReport(LayuiTableParam param) {
        SysReportStpExample example = new SysReportStpExample();
        SysReportStpExample.Criteria c = example.createCriteria();

        Object keywords = param.getParam().get("keyword");
        if (keywords != null && !"".equals(keywords)) {
//            String[] strings = {"report_name","report_desc","report_module"};
//            c.andOrColumn(keywords.toString(),strings,"like");
//            c.andReportNameLike("%"+keywords.toString()+"%");
            example.or().andReportNameLike("%" + keywords.toString() + "%");
            example.or().andReportModuleLike("%" + keywords.toString() + "%");
            example.or().andReportDescLike("%" + keywords.toString() + "%");
        }

        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<SysReportStp> list = sysReportStpService.selectByExample(example);

        PageInfo<SysReportStp> pageInfo = new PageInfo<SysReportStp>(list);

//        for (int i = 0; i < pageInfo.getList().size(); i++) {
//            pageInfo.getList().get(i).setBak1("report");
//        }
        // 3、获取分页查询后的数据
        LayuiTableData data = new LayuiTableData();

        if (keywords != null && !"".equals(keywords)) {
            data.setData(fullSearchService.setKeyWordCss(pageInfo, keywords.toString()));
        } else {
            data.setData(pageInfo.getList());
        }
        Long total = pageInfo.getTotal();
        data.setCount(total.intValue());
        return new AsyncResult<LayuiTableData>(data);
    }
    @Override
    @Async
    public Future<LayuiTableData> getTableDataScientific(LayuiTableParam param) {

        // 每页显示条数
        int pageSize = param.getLimit();
        // 当前是第几页
        int pageNum = param.getPage();
        // 1、设置分页信息，包括当前页数和每页显示的总计数
        PageHelper.startPage(pageNum, pageSize);

        HashMap<String, Object> hashmap = new HashMap<String, Object>();
        OutProjectInfo opi = new OutProjectInfo();

        List<OutProjectInfo> list = new ArrayList<>();
        Object keywords = param.getParam().get("keyword");
//        OutProjectInfoExample example = new OutProjectInfoExample();
//        OutProjectInfoExample.Criteria c = example.createCriteria();

//        if (keywords != null && !"".equals(keywords)) {
//            for (int i = 0; i < info.length; i++) {
//                setMethodVal(c.getClass(),c,getMethodName(info[i])+"Like","%"+keywords.toString()+"%");
//                example.or(c);
//            }
//            list = outProjectInfoMapper.selectByExample(example);
//
//        }
//        else
        {
            listInfo = FullSearchServiceImpl.getListInfo(FullSearchServiceImpl.info);
            if (param.getParam().get("xmmc") != null && !StringUtils.isBlank(param.getParam().get("xmmc") + "")) {
                opi.setXmmc((String) param.getParam().get("xmmc"));
                hashmap.put("xmmc", param.getParam().get("xmmc"));
                listInfo.removeIf(value -> value.equals("xmmc"));
//                c.andXmidLike("%" + param.getParam().get("xmmc") + "%");
            }

            if (param.getParam().get("hth") != null && !StringUtils.isBlank(param.getParam().get("hth") + "")) {
                opi.setHth((String) param.getParam().get("hth"));
                hashmap.put("hth", param.getParam().get("hth"));
//                c.andHthLike("%" + param.getParam().get("hth") + "%");
                listInfo.removeIf(value -> value.equals("hth"));
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
                listInfo.removeIf(value -> value.equals("define1"));

//                c.andDefine1In(define1);
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
                listInfo.removeIf(value -> value.equals("define2"));

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
                listInfo.removeIf(value -> value.equals("define3"));

//                c.andDefine3In(define3);
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
                listInfo.removeIf(value -> value.equals("project_property"));

//                c.andProjectPropertyIn(project_property);
            }

            // 新开项目、续建项目、完工项目
            if (param.getParam().get("project_scope") != null && !StringUtils.isBlank(param.getParam().get("project_scope") + "")) {
                opi.setProjectScope((String) param.getParam().get("project_scope"));
                listInfo.remove("project_scope");
//                c.andProjectScopeLike(param.getParam().get("project_scope").toString());
            }
            // 装备的各种技术类型
            if (param.getParam().get("zylb") != null && !StringUtils.isBlank(param.getParam().get("zylb") + "")) {
                List zylb = new ArrayList();
                String[] temS = param.getParam().get("zylb").toString().split(",");
                for (int i = 0; i < temS.length; i++) {
                    zylb.add(temS[i]);
                }
                listInfo.removeIf(value -> value.equals("zylb"));

                hashmap.put("zylb", zylb);
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
                listInfo.removeIf(value -> value.equals("zycmc"));

//                c.andZycmcLike(param.getParam().get("zycmc").toString());
            }

            // 年度，暂时不用
            if (param.getParam().get("nd") != null && !StringUtils.isBlank(param.getParam().get("nd") + "")) {
                opi.setNd((String) param.getParam().get("nd"));
                listInfo.removeIf(value -> value.equals("nd"));

//                c.andNdEqualTo(param.getParam().get("nd").toString());
            }
//            list = outProjectInfoMapper.findOutProjectInfoList(opi);

//            list = outProjectInfoMapper.selectByExample(example);

            if (keywords != null && !"".equals(keywords) && listInfo.size() > 0) {
                String sql = " and (";
                for (int i = 0; i < listInfo.size(); i++) {
//                    setMethodVal(c.getClass(),c,getMethodName(info[i])+"Like","%"+keywords.toString()+"%");
//                    example.or(c);
                    sql = sql + " " + (i == 0 ? "" : " or ") + listInfo.get(i) + " like '%" + keywords + "%'";
                }
                sql = sql + " ) ";
                hashmap.put("keyword", sql);
//                list = outProjectInfoMapper.selectByExample(example);
            }
            list = outProjectInfoMapper.selectCommonProjectByCond(hashmap);
        }

        PageInfo<OutProjectInfo> pageInfo = new PageInfo<OutProjectInfo>(list);
        LayuiTableData data = new LayuiTableData();

//        for (int i = 0; i < pageInfo.getList().size(); i++) {
//            pageInfo.getList().get(i).setDefine9("scientific");
//        }

        if (keywords != null && !"".equals(keywords) && listInfo.size() > 0) {
            data.setData(fullSearchService.setKeyWordCss(pageInfo, keywords.toString()));
        } else {
            data.setData(pageInfo.getList());
        }
        Long total = pageInfo.getTotal();
        data.setCount(total.intValue());
        return new AsyncResult<LayuiTableData>(data);
    }
    @Autowired
    OutProjectInfoMapper outProjectInfoMapper;
    @Async
    public Future<LayuiTableData> getTableDataAchivement(LayuiTableParam param) {
        Map<String, Object> paraMap = param.getParam();

        // 1、设置分页信息，包括当前页数和每页显示的总计数
        PageHelper.startPage(param.getPage(), param.getLimit());
        List<String> strings = FullSearchServiceImpl.getListInfo(FullSearchServiceImpl.achievement);
        OutAppraisalExample example = new OutAppraisalExample();
        OutAppraisalExample.Criteria criteria = example.createCriteria();

        if (paraMap.get("cgmc") != null && !paraMap.get("cgmc").equals("")) {
            strings.removeIf(value -> value.equals("cgmc"));

            criteria.andCgmcLike("%" + paraMap.get("cgmc").toString() + "%");
        }
        if (paraMap.get("hth") != null && !paraMap.get("hth").equals("")) {
            strings.removeIf(value -> value.equals("hth"));

            criteria.andHthLike("%" + paraMap.get("hth").toString() + "%");
        }
        if (paraMap.get("xmmc") != null && !paraMap.get("xmmc").equals("")) {
            strings.removeIf(value -> value.equals("xmmc"));

            criteria.andXmmcLike("%" + paraMap.get("xmmc").toString() + "%");
        }
        if (paraMap.get("nd") != null && !"".equals(paraMap.get("nd"))) {
            strings.removeIf(value -> value.equals("nd"));
            criteria.andNdEqualTo(paraMap.get("nd").toString());
        }
        Object keywords = param.getParam().get("keyword");
        if (keywords != null && !"".equals(keywords)) {
            criteria.andOrColumn(keywords.toString(), strings.toArray(new String[strings.size()]), "like");
        }
        example.setOrderByClause(" nd desc ");

        List<OutAppraisal> list = outAppraisalMapper.selectByExample(example);
        PageInfo<OutAppraisal> pageInfo = new PageInfo<OutAppraisal>(list);

        LayuiTableData data = new LayuiTableData();

//        for (int i = 0; i < pageInfo.getList().size(); i++) {
//            pageInfo.getList().get(i).setDefine6("achivement");
//        }

        if (keywords != null && !"".equals(keywords) && FullSearchServiceImpl.getListInfo(FullSearchServiceImpl.achievement).size() > 0) {
            data.setData(fullSearchService.setKeyWordCss(pageInfo, keywords.toString()));
        } else {
            data.setData(pageInfo.getList());
        }
//        data.setData(pageInfo.getList());

        Long total = pageInfo.getTotal();
        data.setCount(total.intValue());
        return new AsyncResult<LayuiTableData>(data);
    }
    @Autowired
    OutAppraisalMapper outAppraisalMapper;
}
