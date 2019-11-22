package com.pcitc.web.scientificplan;


import com.github.pagehelper.PageInfo;
import com.pcitc.base.scientificplan.ScienceEvolveDynamic;
import com.pcitc.base.scientificplan.SciencePlan;
import com.pcitc.service.scientificplan.ScienceEvolveDynamicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(value = "scienceEvolveDynamic-api", description = "科技进展动态接口")
@RestController
@RequestMapping(value = "/scienceEvolveDynamic-api")
public class ScienceEvolveDynamicClient {


    @Autowired
    private ScienceEvolveDynamicService scienceEvolveDynamicService;


    @ApiOperation(value = "根据主键获取一个平台的信息", notes = "根据主键获取一个平台的信息")
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public ScienceEvolveDynamic load(@PathVariable String id) {
        return scienceEvolveDynamicService.load(id);
    }

    @ApiOperation(value = "科技进展动态信息保存", notes = "科技进展动态信息保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ScienceEvolveDynamic save(@RequestBody ScienceEvolveDynamic scienceEvolveDynamic) {
        return scienceEvolveDynamicService.save(scienceEvolveDynamic);
    }

    @ApiOperation(value = "删除科技进展动态", notes = "删除科技进展动态接")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Integer delete(@PathVariable String id) {
        return scienceEvolveDynamicService.delete(id);
    }

    @ApiOperation(value = "查询科技进展动态列表", notes = "查询科技进展动态列表")
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public PageInfo query(@RequestBody(required = false) Map param) {
        return scienceEvolveDynamicService.query(param);
    }


}
