package com.pcitc.web.controller.achieve;


import com.github.pagehelper.PageInfo;
import com.pcitc.base.achieve.AchieveIdentifyPlan;
import com.pcitc.base.system.SysUser;
import com.pcitc.web.common.RestBaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>服务接口</p>
 * <p>成果鉴定-计划</p>
 * @author ty
 */

@Api(value = "achieveIdentifyPlan-api", description = "成果鉴定-计划")
@RestController
public class AchieveIdentifyPlanController extends RestBaseController {
    /**
     * 加载
     */
    private static final String load = "http://kjpt-zuul/stp-proxy/achieveIdentifyPlan-api/load/";
    /**
     * 查询
     */
    private static final String query = "http://kjpt-zuul/stp-proxy/achieveIdentifyPlan-api/query";
    /**
     * 保存
     */
    private static final String save = "http://kjpt-zuul/stp-proxy/achieveIdentifyPlan-apisave";
    /**
     * 删除
     */
    private static final String delete = "http://kjpt-zuul/stp-proxy/achieveIdentifyPlan-api/delete/";


    @ApiOperation(value="读取")
    @RequestMapping(value = "/achieveIdentifyPlan-api/load/{id}", method = RequestMethod.GET)
    @ResponseBody
    public AchieveIdentifyPlan load(@PathVariable String id) {
        ResponseEntity<AchieveIdentifyPlan> responseEntity = this.restTemplate.exchange(load+id, HttpMethod.GET, new HttpEntity(this.httpHeaders), AchieveIdentifyPlan.class);
        return responseEntity.getBody();
    }


    @ApiOperation(value = "查询列表", notes = "查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "platformId", value = "平台ID", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "secretLevel", value = "秘级", dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/achieveIdentifyPlan-api/query", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo query(
            @RequestParam(required = false,value = "pageNum") Integer pageNum,
            @RequestParam(required = false,value = "pageSize") Integer pageSize,
            @RequestParam(required = false,value = "secretLevel") String secretLevel

    ) throws Exception {
        SysUser sysUserInfo = this.getUserProfile();
        Map<String, Object> condition = new HashMap<>(6);
        if (pageNum == null) {
            this.setParam(condition, "pageNum", 1);
        }else {
            this.setParam(condition, "pageNum", pageNum);
        }
        if (pageSize == null) {
            this.setParam(condition, "pageSize", 10);
        }else {
            this.setParam(condition, "pageSize", pageSize);
        }
        if(secretLevel != null){
            this.setParam(condition,"secretLevel",secretLevel);
        }
        this.setBaseParam(condition);

        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<PageInfo> responseEntity = this.restTemplate.exchange(query, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), PageInfo.class);
        return responseEntity.getBody();
    }


    @ApiOperation(value="保存")
    @RequestMapping(value = "/achieveIdentifyPlan-api/save", method = RequestMethod.POST)
    @ResponseBody
    public AchieveIdentifyPlan save(@RequestBody AchieveIdentifyPlan p) {
        this.setBaseData(p);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<AchieveIdentifyPlan> responseEntity = this.restTemplate.exchange(save, HttpMethod.POST, new HttpEntity<AchieveIdentifyPlan>(p, this.httpHeaders), AchieveIdentifyPlan.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value="删除")
    @RequestMapping(value = "/achieveIdentifyPlan-api/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Integer delete(@PathVariable String id) {
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(delete+id, HttpMethod.DELETE, new HttpEntity(this.httpHeaders), Integer.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value="初始化")
    @RequestMapping(value = "/achieveIdentifyPlan-api/newInit", method = RequestMethod.GET)
    @ResponseBody
    public AchieveIdentifyPlan newInit() {
        AchieveIdentifyPlan p = new AchieveIdentifyPlan();
        return p;
    }
}
