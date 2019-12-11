package com.pcitc.web.scientificplan;


import com.github.pagehelper.PageInfo;
import com.pcitc.service.scientificplan.YearSummaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(value = "yearSummary-api", description = "年度总结接口")
@RestController
@RequestMapping(value = "/yearSummary-api")
public class YearSummaryClient {

    @Autowired
    private YearSummaryService yearSummaryService;

    @ApiOperation(value = "根据主键获取一个平台的信息", notes = "根据主键获取一个平台的信息")
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public YearSummary load(@PathVariable String id) {
        return yearSummaryService.load(id);
    }

    @ApiOperation(value = "年度总结信息保存", notes = "年度总结信息保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public YearSummary save(@RequestBody YearSummary yearSummary) {
        return yearSummaryService.save(yearSummary);
    }

    @ApiOperation(value = "删除年度总结信息", notes = "删除年度总结信息")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Integer delete(@PathVariable String id) {
        return yearSummaryService.delete(id);
    }

    @ApiOperation(value = "查询年度总结信息列表", notes = "查询年度总结信息列表")
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public PageInfo query(@RequestBody(required = false) Map param) {
        return yearSummaryService.query(param);
    }

}
