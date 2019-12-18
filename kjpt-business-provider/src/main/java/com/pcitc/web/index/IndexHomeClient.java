package com.pcitc.web.index;


import com.github.pagehelper.PageInfo;
import com.pcitc.base.computersoftware.ComputerSoftware;
import com.pcitc.service.computersoftware.ComputerSoftwareService;
import com.pcitc.service.index.IndexHomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(value = "首页数据", description = "首页数据")
@RestController
@RequestMapping(value = "/indexHome")
public class IndexHomeClient {

    @Autowired
    private IndexHomeService indexHomeService;

    @ApiOperation(value = "首页数据汇总查询", notes = "首页数据汇总查询")
    @RequestMapping(value = "/homeNummary", method = RequestMethod.POST)
    public PageInfo selectNummary(@RequestBody(required = false) Map param) {
        return indexHomeService.selectNummary(param);
    }
}
