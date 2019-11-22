package com.pcitc.web.controller.scientificplan;


import com.github.pagehelper.PageInfo;

import com.pcitc.base.scientificplan.WorkPoint;
import com.pcitc.web.common.RestBaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Api(value = "workPoint-api", description = "工作要点接口")
@RestController
public class WorkPointApiController extends RestBaseController {

    /**
     * 根据ID获取对象信息
     */
    private static final String load = "http://kjpt-zuul/stp-proxy/workPoint-api/load/";
    /**
     * 查询平台列表
     */
    private static final String query = "http://kjpt-zuul/stp-proxy/workPoint-api/query";
    /**
     * 保存平台
     */
    private static final String save = "http://kjpt-zuul/stp-proxy/workPoint-api/save";
    /**
     * 删除
     */
    private static final String delete = "http://kjpt-zuul/stp-proxy/workPoint-api/delete/";


    @RequestMapping(value = "/view")
    public String view() {
        return "/kjpt/workpoint/workpoint_view";
    }

    @RequestMapping(value = "/add")
    public String add() {
        return "/kjpt/workpoint/workpoint_add";
    }



    @ApiOperation(value = "查询科技规划列表", notes = "查询科技规划列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "名称", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "authenticate_util", value = "申报单位", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "research_field", value = "研究领域", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "release_time", value = "发布时间", dataType = "string", paramType = "query"),
    })
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo query(
            @RequestParam(required = false,value = "pageNum") Integer pageNum,
            @RequestParam(required = false,value = "pageSize") Integer pageSize,
            @RequestParam(required = false,value = "name") String name,
            @RequestParam(required = false,value = "authenticate_util") String authenticate_util,
            @RequestParam(required = false,value = "research_field") String research_field,
            @RequestParam(required = false,value = "release_time") String release_time
    ) {
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
        if (!StringUtils.isEmpty(name)) {
            this.setParam(condition, "name", name);
        }
        if (!StringUtils.isEmpty(authenticate_util)) {
            this.setParam(condition, "authenticate_util", authenticate_util);
        }
        if (!StringUtils.isEmpty(research_field)) {
            this.setParam(condition, "research_field", research_field);
        }

        if (!StringUtils.isEmpty(release_time)) {
            this.setParam(condition, "release_time", release_time);
        }

        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<PageInfo> responseEntity = this.restTemplate.exchange(query, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), PageInfo.class);
        return responseEntity.getBody();
    }


    @ApiOperation(value="保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public WorkPoint save(@RequestBody WorkPoint wp) {
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<WorkPoint> responseEntity = this.restTemplate.exchange(save, HttpMethod.POST, new HttpEntity<WorkPoint>(wp, this.httpHeaders), WorkPoint.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value="删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Integer delete(@PathVariable String id) {
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(delete+id, HttpMethod.DELETE, new HttpEntity(this.httpHeaders), Integer.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value="初始化")
    @RequestMapping(value = "/newInit", method = RequestMethod.GET)
    @ResponseBody
    public WorkPoint newInit() {
        WorkPoint p = new WorkPoint();
        p.setId(UUID.randomUUID().toString().replace("_",""));
        p.setDeleted("0");  //删除标识
        p.setCreateDate(new Date());  // 创建时间
        p.setCreator(this.getUserProfile().getUserName());
        return p;
    }
}
