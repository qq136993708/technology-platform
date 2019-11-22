package com.pcitc.web.controller.scientificplan;

import com.github.pagehelper.PageInfo;

import com.pcitc.base.scientificplan.SciencePlan;
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

@Api(value = "sciencePlan-api", description = "科技规划接口")
@RestController
@RequestMapping(value = "/SciencePlan")
public class SciencePlanApiController extends RestBaseController {

    /**
     * 根据ID获取对象信息
     */
    private static final String load = "http://kjpt-zuul/stp-proxy/sciencePlan-api/load/";
    /**
     * 查询平台列表
     */
    private static final String query = "http://kjpt-zuul/stp-proxy/sciencePlan-api/query";
    /**
     * 保存平台
     */
    private static final String save = "http://kjpt-zuul/stp-proxy/sciencePlan-api/save";
    /**
     * 删除
     */
    private static final String delete = "http://kjpt-zuul/stp-proxy/sciencePlan-api/delete/";


    @RequestMapping(value = "/view")
    public String view() {
        return "/kjpt/scienceplan/scienceplan_view";
    }

    @RequestMapping(value = "/addadd")
    public String add() {
        return "/kjpt/scienceplan/scienceplan_add";
    }


    @ApiOperation(value = "读取")
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    @ResponseBody
    public SciencePlan load(@PathVariable String id) {
        ResponseEntity<SciencePlan> responseEntity =
                this.restTemplate.exchange(load + id, HttpMethod.GET, new HttpEntity(this.httpHeaders), SciencePlan.class);
        return responseEntity.getBody();
    }


    @ApiOperation(value = "查询科技规划列表", notes = "查询科技规划列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "名称", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "authenticate_util", value = "申报单位", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "research_field", value = "研究领域", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "professional_field", value = "专业领域", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "specialty_category", value = "专业类别", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "release_time", value = "发布时间", dataType = "string", paramType = "query"),
    })
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo query(
            @RequestParam(required = false, value = "pageNum") Integer pageNum,
            @RequestParam(required = false, value = "pageSize") Integer pageSize,
            @RequestParam(required = false, value = "name") String name,
            @RequestParam(required = false, value = "authenticate_util") String authenticate_util,
            @RequestParam(required = false, value = "research_field") String research_field,
            @RequestParam(required = false, value = "professional_field") String professional_field,
            @RequestParam(required = false, value = "specialty_category") String specialty_category,
            @RequestParam(required = false, value = "release_time") String release_time
    ) {
        Map<String, Object> condition = new HashMap<>(6);
        if (pageNum == null) {
            this.setParam(condition, "pageNum", 1);
        } else {
            this.setParam(condition, "pageNum", pageNum);
        }
        if (pageSize == null) {
            this.setParam(condition, "pageSize", 10);
        } else {
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
        if (!StringUtils.isEmpty(professional_field)) {
            this.setParam(condition, "professional_field", professional_field);
        }
        if (!StringUtils.isEmpty(specialty_category)) {
            this.setParam(condition, "specialty_category", specialty_category);
        }
        if (!StringUtils.isEmpty(release_time)) {
            this.setParam(condition, "release_time", release_time);
        }

        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<PageInfo> responseEntity = this.restTemplate.exchange(query, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), PageInfo.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value = "保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public SciencePlan save(@RequestBody SciencePlan sp) {
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<SciencePlan> responseEntity = this.restTemplate.exchange(save, HttpMethod.POST, new HttpEntity<SciencePlan>(sp, this.httpHeaders), SciencePlan.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value = "删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Integer delete(@PathVariable String id) {
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(delete + id, HttpMethod.DELETE, new HttpEntity(this.httpHeaders), Integer.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value = "初始化")
    @RequestMapping(value = "/newInit", method = RequestMethod.GET)
    @ResponseBody
    public SciencePlan newInit() {
        SciencePlan p = new SciencePlan();
        p.setId(UUID.randomUUID().toString().replace("_", ""));
//        p.setName();
//        p.setAuthenticate_util();
//        p.setResearch_field();
//        p.setSpecialty_category();
//        p.setRelease_time(new Date());

        p.setDeleted("0");  //删除标识
        p.setCreateDate(new Date());  // 创建时间
        p.setCreator(this.getUserProfile().getUserName());
        return p;

    }
}
