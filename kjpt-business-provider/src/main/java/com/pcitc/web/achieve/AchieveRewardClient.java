package com.pcitc.web.achieve;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.achieve.AchieveBase;
import com.pcitc.base.achieve.AchieveReward;
import com.pcitc.service.achieve.AchieveBaseService;
import com.pcitc.service.achieve.AchieveRewardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>成果转化-激励</p>
 * @author ty
 */

@Api(value = "achieveReward-api", description = "成果转化激励接口")
@RestController
@RequestMapping(value = "/achieveReward-api")
public class AchieveRewardClient {
    @Autowired
    private AchieveRewardService ars;
    @ApiOperation(value = "load成果转换激励", notes = "load成果转换激励")
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public AchieveReward load(@PathVariable String id){
        return ars.load(id);
    }

    @ApiOperation(value = "成果转换激励保存", notes = "成果转换激励保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody AchieveReward achieveReward){
         ars.save(achieveReward);
    }


    @ApiOperation(value = "查询成果转换激励列表分页", notes = "查询成果转换列激励表分页")
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public PageInfo query(@RequestBody(required = false) Map param){
        return ars.query(param);
    }



    @ApiOperation(value = "成果转换激励删除", notes = "成果转换激励删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Integer delete(@PathVariable String id){
         return ars.delete(id);
    }

}
