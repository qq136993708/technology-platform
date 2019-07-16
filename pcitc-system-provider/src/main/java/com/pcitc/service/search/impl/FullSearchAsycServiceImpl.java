package com.pcitc.service.search.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.TreeNode2;
import com.pcitc.base.hana.report.H1AMKYSY100117;
import com.pcitc.base.stp.out.*;
import com.pcitc.base.system.SysFunction;
import com.pcitc.base.system.SysFunctionExample;
import com.pcitc.base.util.StrUtil;
import com.pcitc.mapper.out.OutAppraisalMapper;
import com.pcitc.mapper.out.OutProjectInfoMapper;
import com.pcitc.mapper.out.OutRewardMapper;
import com.pcitc.service.expert.TfmTypeService;
import com.pcitc.service.report.SysReportStpService;
import com.pcitc.service.search.FullSearchAsycService;
import com.pcitc.service.search.FullSearchService;
import com.pcitc.service.system.SysFunctionService;
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
//        JSONArray jSONArray = homeProviderClient.get_home_KYZB_02(JSONObject.toJSONString(param_common.getParam()));
//        Object keyword = param_common.getParam().get("keyword");
        LayuiTableData layuiTableData = new LayuiTableData();

//
//        List<H1AMKYSY100117> list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYSY100117.class);
//
//        List<TreeNode2> chartCircleList = new ArrayList<TreeNode2>();
//        List<TreeNode2> chartCircleListRed = new ArrayList<TreeNode2>();
//        String strKeyword = "";
//        for (int i = 0; i < list.size(); i++) {
//            H1AMKYSY100117 bean = list.get(i);
//
//            TreeNode2 node = new TreeNode2();
//            node.setExtend01(bean.getG0ZCXLMS());//设备类型
//            node.setExtend02(bean.getG0GSJC());//直属研究院
//            node.setExtend04(bean.getG0ZBHND());//购置年度
//            node.setExtend05(bean.getG0NDJAR());//使用年限
//            node.setExtend06(bean.getG0NDSYN());//剩余年限
//
//            DecimalFormat decimalFormat = new DecimalFormat(".00");
//            node.setExtend07(bean.getG0NCGZYZJE());//购置金额(万元)
//            if (bean.getG0NCGZYZJE() != null) {
//                node.setExtend07(decimalFormat.format(Double.valueOf(bean.getG0NCGZYZJE()) / 10000l));
//            }
//            node.setExtend08(bean.getG0LJZJJE());//折旧金额（万元）
//            if (bean.getG0LJZJJE() != null) {
//                node.setExtend08(decimalFormat.format(Double.valueOf(bean.getG0LJZJJE()) / 10000l));
//            }
//            node.setExtend09("0");
//            if (bean.getG0NCGZYZJE() != null && bean.getG0LJZJJE() != null) {
//                Double rs = Double.valueOf(node.getExtend07()) - Double.valueOf(node.getExtend08());
//                node.setExtend09(decimalFormat.format(rs));
//            }
//            node.setExtend10(bean.getBl() + "%");//折旧率
//            strKeyword = bean.getG0TXT50();
//            if (keyword != null && !"".equals(keyword) && strKeyword.contains(keyword.toString())) {
//                strKeyword = bean.getG0TXT50().replace(keyword.toString(), "<span style=\"color:red\">" + keyword + "</span>");
//                node.setExtend03(strKeyword);//设备名称
//                chartCircleListRed.add(node);
//            } else {
//                node.setExtend03(strKeyword);//设备名称
//                chartCircleList.add(node);
//            }
//        }
//        List<TreeNode2> resultList = new ArrayList<TreeNode2>();
//        if (keyword != null && !"".equals(keyword)) {
//            if (chartCircleListRed.size() > 0) {
//                resultList.add(chartCircleListRed.get(0));
//            }
//            layuiTableData.setData(resultList);
//        } else {
//            if (chartCircleList.size() > 0) {
//                resultList.add(chartCircleList.get(0));
//            }
//            layuiTableData.setData(resultList);
//        }
        layuiTableData = zjkBaseInfoServiceClient.getSreProjectBasicListSearch(param_common);
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
        LayuiTableData data = zjkBaseInfoServiceClient.selectZjkBaseInfoByPage(param);
        return new AsyncResult<LayuiTableData>(data);
    }

    @Override
    public Future<LayuiTableData> selectZjkZhuanliByPage(LayuiTableParam param) {
        LayuiTableData data = zjkBaseInfoServiceClient.selectZjkZhuanliByPage(param);
        return new AsyncResult<LayuiTableData>(data);
    }

    @Autowired
    private SysFunctionService sysFunctionService;

    @Override
    @Async
    public Future<LayuiTableData> getTableDataReport(LayuiTableParam param) {
//        SysFunctionExample example = new SysFunctionExample();
//        SysFunctionExample.Criteria c = example.createCriteria();
//
//        Object keywords = param.getParam().get("keyword");
//        if (keywords != null && !"".equals(keywords)) {
//            c.andNameLike("%" + keywords.toString() + "%");
//        }
//        c.andCodeLike("1004%");
//        c.andUrlNotEqualTo("#");
//
//        int pageSize = param.getLimit();
//        int pageStart = (param.getPage() - 1) * pageSize;
//        int pageNum = pageStart / pageSize + 1;
//        PageHelper.startPage(pageNum, pageSize);
//        List<SysFunction> list = sysFunctionService.selectByExample(example);
//
//        PageInfo<SysFunction> pageInfo = new PageInfo<SysFunction>(list);
//        // 3、获取分页查询后的数据
//        LayuiTableData data = new LayuiTableData();
//
//        if (keywords != null && !"".equals(keywords)) {
//            data.setData(fullSearchService.setKeyWordCss(pageInfo, keywords.toString()));
//        } else {
//            data.setData(pageInfo.getList());
//        }
//        Long total = pageInfo.getTotal();
//        data.setCount(total.intValue());
        return new AsyncResult<LayuiTableData>(new LayuiTableData());
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
        OutProjectInfo opi = new OutProjectInfo();
        //关键字
        Object keywords = param.getParam().get("keywords");
        if (!StrUtil.isNullEmpty(keywords)) {
            opi.setXmmc(keywords.toString());
        }
        List<OutProjectInfo> list = outProjectInfoMapper.selectProjectByCondExpert(opi);
        PageInfo<OutProjectInfo> pageInfo = new PageInfo<OutProjectInfo>(list);
        LayuiTableData data = new LayuiTableData();
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
