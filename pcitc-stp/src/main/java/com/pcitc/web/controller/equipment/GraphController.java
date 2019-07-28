package com.pcitc.web.controller.equipment;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.*;
import com.pcitc.base.hana.report.BudgetMysql;
import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.OperationFilter;
import com.pcitc.web.utils.EquipmentUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.HanaUtil;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class GraphController extends BaseController {

    //获取每一年的装备总金额
    private static final String GET_MONEY_YEAR= "http://pcitc-zuul/stp-proxy/sre-provider/equipment/get_money_year";
    @RequestMapping(value = "/graph/to-investment-trend")
    public String toInvestmentTrend(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String nd = HanaUtil.getCurrentYear();
        request.setAttribute("nd", nd);
        String userLevel = CommonUtil.getParameter(request, "userLevel", "");
        request.setAttribute("userLevel", userLevel);
        return "stp/equipment/graph/investment-trend";
    }



    @RequestMapping(method = RequestMethod.GET, value = "/graph/investment_data")
    @ResponseBody
    @OperationFilter(dataFlag = "true")
    public String investment_data_02(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String resault = "";
        PageResult pageResult = new PageResult();
        Result result = new Result();

        String type = CommonUtil.getParameter(request, "type", "");


        LayuiTableParam param = new LayuiTableParam();
        LayuiTableData layuiTableData = new LayuiTableData();
        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
        ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(GET_MONEY_YEAR, HttpMethod.POST, entity, LayuiTableData.class);
        LayuiTableData entityBody = responseEntity.getBody();

        if (type.equals("line")) {
                /*ArrayList<Object> list1 = new ArrayList<>();
                list1.add();*/
                result.setData(entityBody.getData());
                result.setSuccess(true);
                    /*ArrayList<Object> list = new ArrayList<>();
                    ChartBarLineResultData barLine = new ChartBarLineResultData();
                    List<String> xAxisDataList = HanaUtil.getduplicatexAxisByList(list, "yearMonth");
                    barLine.setxAxisDataList(xAxisDataList);

                    List<String> legendDataList = new ArrayList<String>();
                    legendDataList.add("预算金额");
                    legendDataList.add("合同金额");
                    legendDataList.add("拨款金额");
                    barLine.setLegendDataList(legendDataList);

                    // X轴数据
                    List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
                    ChartBarLineSeries s1 = HanaUtil.getInvestmentBarLineSeries02(list1, "zysje");
                    seriesList.add(s1);

                    ChartBarLineSeries s12 = HanaUtil.getInvestmentBarLineSeries02(list2, "zsjje");
                    seriesList.add(s12);

                    ChartBarLineSeries s2 = HanaUtil.getInvestmentBarLineSeries02(list2, "hanaMoney");
                    seriesList.add(s2);
                    barLine.setSeriesList(seriesList);
                    result.setSuccess(true);
                    result.setData(barLine);*/
            }else if (type.equals("date")) {

                    pageResult.setData(entityBody.getData());
                    pageResult.setCode(0);
                    pageResult.setCount(Long.valueOf(entityBody.getCount()));
                    pageResult.setLimit(1000);
                    pageResult.setPage(1l);
            } else {
            result.setSuccess(false);
            result.setMessage("参数为空");
            }
            if (type.equals("line")) {
                JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
                resault = resultObj.toString();
                System.out.println(">>>>>>>>>>>11>>>>investment_data_02 " + resultObj.toString());
            } else {
                JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
                resault = resultObj.toString();
                System.out.println(">>>>>>>>>>>>22>>>investment_data_02 " + resultObj.toString());
            }

        return resault;
    }
}
