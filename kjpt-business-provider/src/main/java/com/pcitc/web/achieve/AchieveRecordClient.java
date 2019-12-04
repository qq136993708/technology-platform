package com.pcitc.web.achieve;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.achieve.AchieveBase;
import com.pcitc.base.achieve.AchieveRecord;
import com.pcitc.service.achieve.AchieveBaseService;
import com.pcitc.service.achieve.AchieveRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>成果转化</p>
 * @author ty
 */

@Api(value = "achieveRecord-api", description = "成果转化备案接口")
@RestController
@RequestMapping(value = "/achieveRecord-api")
public class AchieveRecordClient {
    @Autowired
    private AchieveRecordService ars;
    @ApiOperation(value = "load成果转化备案接口", notes = "load成果转化备案接口")
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public AchieveRecord load(@PathVariable String id){
        return ars.load(id);
    }

    @ApiOperation(value = "成果转换备案保存", notes = "成果转换备案保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody AchieveRecord achieveRecord){
         ars.save(achieveRecord);
    }


    @ApiOperation(value = "查询成果转换备案列表分页", notes = "查询成果转换备案列表分页")
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public PageInfo query(@RequestBody(required = false) Map param){
        return ars.query(param);
    }



    @ApiOperation(value = "成果转换备案删除", notes = "成果转换备案删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id){
         ars.delete(id);
    }

}
