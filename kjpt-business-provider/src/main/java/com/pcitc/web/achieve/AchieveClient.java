package com.pcitc.web.achieve;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.achieve.AchieveBase;
import com.pcitc.service.achieve.AchieveBaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>成果转化</p>
 * @author ty
 */

@Api(value = "achieve-api", description = "成果转化接口")
@RestController
@RequestMapping(value = "/achieve-api")
public class AchieveClient {
    @Autowired
    private AchieveBaseService abs;
    @ApiOperation(value = "load成果转换", notes = "load成果转换")
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public AchieveBase load(@PathVariable String id){
        return abs.load(id);
    }

    @ApiOperation(value = "成果转换保存", notes = "成果转换保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody AchieveBase achieveBase){
         abs.save(achieveBase);
    }


    @ApiOperation(value = "查询成果转换列表分页", notes = "查询成果转换列表分页")
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public PageInfo query(@RequestBody(required = false) Map param){
        return abs.query(param);
    }



    @ApiOperation(value = "成果转换删除", notes = "成果转换删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id){
         abs.delete(id);
    }

}
