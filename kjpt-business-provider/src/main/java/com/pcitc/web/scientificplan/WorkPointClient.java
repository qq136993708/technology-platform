package com.pcitc.web.scientificplan;


import com.github.pagehelper.PageInfo;
import com.pcitc.base.scientificplan.WorkPoint;
import com.pcitc.service.scientificplan.WorkPointService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(value = "workPoint-api", description = "工作要点接口")
@RestController
@RequestMapping(value = "/workPoint-api")
public class WorkPointClient {

    @Autowired
    private WorkPointService workPointService;


    @ApiOperation(value = "根据主键获取一个平台的信息", notes = "根据主键获取一个平台的信息")
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public WorkPoint load(@PathVariable String id) {
        return workPointService.load(id);
    }

    @ApiOperation(value = "保存工作要点信息", notes = "保存工作要点信息")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public WorkPoint save(@RequestBody WorkPoint workPoint) {
        return workPointService.save(workPoint);
    }

    @ApiOperation(value = "删除工作要点信息", notes = "删除工作要点信息")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Integer delete(@PathVariable String id) {
        return workPointService.delete(id);
    }


    @ApiOperation(value = "查询工作要点信息列表", notes = "查询工作要点信息列表")
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public PageInfo query(@RequestBody(required = false) Map panam) {
        return workPointService.query(panam);
    }

}
