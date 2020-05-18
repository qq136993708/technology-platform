package com.pcitc.web.achieve;

import com.github.pagehelper.PageInfo;
import com.pcitc.base.achieve.AchieveMaintain;
import com.pcitc.service.achieve.AchieveMaintainService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * <p>成果维护</p>
 * @author ty
 */

@Api(value = "achieveMaintain-api", description = "成果维护接口")
@RestController
@RequestMapping(value = "/achieveMaintain-api")
public class AchieveMaintainClient {

    @Autowired
    private AchieveMaintainService ams;


    @ApiOperation(value = "load成果维护", notes = "load成果维护")
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public AchieveMaintain load(@PathVariable String id){
        return ams.load(id);
    }

    @ApiOperation(value = "成果维护保存", notes = "成果维护保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody AchieveMaintain am){
        ams.save(am);
    }


    @ApiOperation(value = "查询成果维护列表分页", notes = "查询成果维护列表分页")
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public PageInfo query(@RequestBody(required = false) Map param){
        return ams.query(param);
    }



    @ApiOperation(value = "成果维护删除", notes = "成果维护删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Integer delete(@PathVariable String id){
        return ams.delete(id);
    }


}
