package com.pcitc.web.search;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.service.out.OutAppraisalService;
import com.pcitc.service.out.OutProjectPlanService;
import com.pcitc.service.search.FullSearchService;
import com.pcitc.web.out.OutProjectPlanClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@Api(value = "FullSearchClient-API", description = "首页查询")
@RestController
public class FullSearchClient {

    @Autowired
    private FullSearchService fullSearchService;


    private final static Logger logger = LoggerFactory.getLogger(OutProjectPlanClient.class);

    @ApiOperation(value = "分页显示成果数据", notes = "分页显示成果数据")
    @RequestMapping(value = "/search/getTableDataAchivement", method = RequestMethod.POST)
    public LayuiTableData getOutAppraisalListPage(@RequestBody LayuiTableParam param) throws Exception {
        return fullSearchService.getTableDataAchivement(param);
    }

    @ApiOperation(value = "首页查询", notes = "分页显示数据")
    @RequestMapping(value = "/search/getTableDataScientific", method = RequestMethod.POST)
    public LayuiTableData getTableDataScientific(@RequestBody LayuiTableParam param) throws Exception {
//        return fullSearchService.selectProjectPlanByCond(param);
        return fullSearchService.getTableDataScientific(param);
    }

    @ApiOperation(value = "分页显示搜索数据", notes = "分页显示搜索数据")
    @RequestMapping(value = "/search/search", method = RequestMethod.POST)
    public LayuiTableData search(@RequestBody LayuiTableParam param) throws Exception {
        return fullSearchService.getTableSearch(param);
    }


    @ApiOperation(value = "首页报表查询", notes = "分页显示报表")
    @RequestMapping(value = "/search/getTableDataReport", method = RequestMethod.POST)
    public LayuiTableData getTableDataReport(@RequestBody LayuiTableParam param) throws Exception {
        return fullSearchService.getTableDataReport(param);
    }

    @ApiOperation(value = "分页显示奖励数据", notes = "分页显示奖励数据")
    @RequestMapping(value = "/search/reward-list", method = RequestMethod.POST)
    public LayuiTableData getOutRewardListPage(@RequestBody LayuiTableParam param) throws Exception {
        logger.info("==================page getOutRewardListPage==================" + param);
        return fullSearchService.getOutRewardListPage(param);
    }
}
