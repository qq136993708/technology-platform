package com.pcitc.web.controller.scientificplan;


import com.github.pagehelper.PageInfo;
import com.pcitc.base.scientificplan.YearSummary;
import com.pcitc.web.common.RestBaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Api(value = "yearSummary-api", description = "年度总结接口")
@RestController
@RequestMapping(value = "/YearSummary")
public class YearSummaryApiController extends RestBaseController {


    /**
     * 根据ID获取对象信息
     */
    private static final String load = "http://kjpt-zuul/stp-proxy/yearSummary-api/load/";
    /**
     * 查询平台列表
     */
    private static final String query = "http://kjpt-zuul/stp-proxy/yearSummary-api/query";
    /**
     * 保存平台
     */
    private static final String save = "http://kjpt-zuul/stp-proxy/yearSummary-api/save";
    /**
     * 删除
     */
    private static final String delete = "http://kjpt-zuul/stp-proxy/yearSummary-api/delete/";


    @RequestMapping(value = "/view")
    public String view() {
        return "/kjpt/yearsummary/yearsummary_view";
    }

    @RequestMapping(value = "/add")
    public String add() {
        return "/kjpt/yearsummary/yearsummary_add";
    }


    @ApiOperation(value = "读取")
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    @ResponseBody
    public YearSummary load(@PathVariable String id) {
        ResponseEntity<YearSummary> responseEntity = this.restTemplate.exchange(load + id, HttpMethod.GET, new HttpEntity(this.httpHeaders), YearSummary.class);
        return responseEntity.getBody();
    }


    @ApiOperation(value = "查询科研平台列表", notes = "查询科研平台列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "名称", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "authenticateUtil", value = "申报单位", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "researchField", value = "研究领域", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "releaseTime", value = "发布时间", dataType = "string", paramType = "query"),

            @ApiImplicitParam(name = "accessory", value = "附件", dataType = "string", paramType = "query"),


            @ApiImplicitParam(name = "annual", value = "发布时间", dataType = "string", paramType = "query")


    })
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo query(
            @RequestParam(required = false, value = "pageNum") Integer pageNum,
            @RequestParam(required = false, value = "pageSize") Integer pageSize,
            @RequestParam(required = false, value = "name") String name,
            @RequestParam(required = false, value = "authenticateUtil") String authenticateUtil,
            @RequestParam(required = false, value = "researchField") String researchField,
            @RequestParam(required = false, value = "releaseTime") String releaseTime,

            @RequestParam(required = false, value = "accessory") String accessory,



            @RequestParam(required = false, value = "annual") @DateTimeFormat(pattern = "yyyy-MM-dd") Date annual



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
        if (!StringUtils.isEmpty(authenticateUtil)) {
            this.setParam(condition, "authenticateUtil", authenticateUtil);
        }
        if (!StringUtils.isEmpty(researchField)) {
            this.setParam(condition, "researchField", researchField);
        }
        if (!StringUtils.isEmpty(releaseTime)) {
            this.setParam(condition, "releaseTime", releaseTime);
        }


        if (!StringUtils.isEmpty(accessory)) {
            this.setParam(condition, "accessory", accessory);
        }


        if (annual != null) {
            this.setParam(condition, "annual", annual);
        }

        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<PageInfo> responseEntity = this.restTemplate.exchange(query, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), PageInfo.class);
        return responseEntity.getBody();
    }


    @ApiOperation(value = "保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public YearSummary save(@RequestBody YearSummary ys) {
        this.setBaseData(ys);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<YearSummary> responseEntity = this.restTemplate.exchange(save, HttpMethod.POST, new HttpEntity<YearSummary>(ys, this.httpHeaders), YearSummary.class);
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
    public YearSummary newInit() {
        YearSummary p = new YearSummary();
        p.setId(UUID.randomUUID().toString().replace("-", ""));
        p.setCreateDate(new Date());
        p.setCreator(this.getUserProfile().getUserName());
        p.setDeleted("0");
        return p;
    }

}
