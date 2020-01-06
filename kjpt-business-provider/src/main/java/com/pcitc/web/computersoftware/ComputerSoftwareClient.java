package com.pcitc.web.computersoftware;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.computersoftware.ComputerSoftware;
import com.pcitc.service.computersoftware.ComputerSoftwareService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(value = "computerSoftware-api", description = "计算机软件接口")
@RestController
@RequestMapping(value = "/computerSoftware-api")
public class ComputerSoftwareClient {

    @Autowired
    private ComputerSoftwareService computerSoftwareService;

    @ApiOperation(value = "根据主键获取一个平台的信息", notes = "根据主键获取一个平台的信息")
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public ComputerSoftware load(@PathVariable String id) {
        return computerSoftwareService.load(id);

    }


    @ApiOperation(value = "计算机软件信息保存", notes = "计算机软件信息保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ComputerSoftware save(@RequestBody ComputerSoftware computerSoftware) {
        return computerSoftwareService.save(computerSoftware);

    }


    @ApiOperation(value = "计算机软件平台信息查询", notes = "计算机软件平台的信息查询")
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public PageInfo query(@RequestBody(required = false) Map param) {
        return computerSoftwareService.query(param);
    }

    @ApiOperation(value = "计算机软件平台信息查询列表", notes = "计算机软件平台信息查询列表")
    @RequestMapping(value = "/queryNoPage", method = RequestMethod.POST)
    public JSONArray queryNoPage(@RequestBody(required = false) Map param) {
        List list = computerSoftwareService.queryNoPage(param);
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
        return json;
    }


    @ApiOperation(value = "计算机软件平台信息删除", notes = "计算机软件平台的信息删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Integer delete(@PathVariable String id) {
        return computerSoftwareService.delete(id);
    }


}
