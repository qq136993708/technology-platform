package com.pcitc.web.controller.scientificplan;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;

import com.pcitc.base.computersoftware.ComputerSoftware;
import com.pcitc.base.scientificplan.SciencePlan;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.RestBaseController;
import com.pcitc.web.utils.EquipmentUtils;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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

    /**
     * 导出
     */
    private static final String queryNoPage = "http://kjpt-zuul/stp-proxy/sciencePlan-api/queryNoPage";



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
            @ApiImplicitParam(name = "authenticateUtil", value = "申报单位", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "researchField", value = "研究领域", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "professionalField", value = "专业领域", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "specialtyCategory", value = "专业类别", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "releaseTime", value = "发布时间", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "accessory", value = "附件", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "annual", value = "年度/月度", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "reportType", value = "上报类型", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "createUnitId", value = "创建单位id", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "createUnitName", value = "创建单位名称", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "technicalFieldName", value = "技术领域名称", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "technicalFieldIndex", value = "技术领域索引", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "secretLevel", value = "密级", dataType = "string", paramType = "query")

    })
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo query(
            @RequestParam(required = false, value = "pageNum") Integer pageNum,
            @RequestParam(required = false, value = "pageSize") Integer pageSize,
            @RequestParam(required = false, value = "name") String name,
            @RequestParam(required = false, value = "authenticateUtil") String authenticateUtil,
            @RequestParam(required = false, value = "researchField") String researchField,
            @RequestParam(required = false, value = "professionalField") String professionalField,
            @RequestParam(required = false, value = "specialtyCategory") String specialtyCategory,
            @RequestParam(required = false, value = "releaseTime")@DateTimeFormat(pattern = "yyyy-MM-dd") Date releaseTime,
            @RequestParam(required = false, value = "accessory") String accessory,
            @RequestParam(required = false, value = "annual")@DateTimeFormat(pattern = "yyyy-MM") Date annual,
            @RequestParam(required = false, value = "reportType") String reportType,
            @RequestParam(required = false, value = "createUnitId") String createUnitId,
            @RequestParam(required = false, value = "createUnitName") String createUnitName,
            @RequestParam(required = false, value = "technicalFieldName") String technicalFieldName,
            @RequestParam(required = false, value = "technicalFieldIndex") String technicalFieldIndex,
            @RequestParam(required = false, value = "secretLevel") String secretLevel


    ) throws Exception {
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
        if (!StringUtils.isEmpty(professionalField)) {
            this.setParam(condition, "professionalField", professionalField);
        }
        if (!StringUtils.isEmpty(specialtyCategory)) {
            this.setParam(condition, "specialtyCategory", specialtyCategory);
        }

        if (!StringUtils.isEmpty(DateUtil.format(releaseTime,DateUtil.FMT_SS))) {
            this.setParam(condition, "releaseTime", DateUtil.format(releaseTime,DateUtil.FMT_SS));
        }
        if (!StringUtils.isEmpty(accessory)) {
            this.setParam(condition, "accessory", accessory);
        }

        if (!StringUtils.isEmpty(DateUtil.format(annual,DateUtil.FMT_MMM))) {
            this.setParam(condition, "annual", DateUtil.format(annual,DateUtil.FMT_MMM));
        }
        if (!StringUtils.isEmpty(reportType)) {
            this.setParam(condition, "reportType", reportType);
        }

        if (!StringUtils.isEmpty(createUnitId)) {
            this.setParam(condition, "createUnitId", createUnitId);
        }

        if (!StringUtils.isEmpty(createUnitName)) {
            this.setParam(condition, "createUnitName", createUnitName);
        }

        if (!StringUtils.isEmpty(technicalFieldName)) {
            this.setParam(condition, "technicalFieldName", technicalFieldName);
        }

        if (!StringUtils.isEmpty(technicalFieldIndex)) {
            this.setParam(condition, "technicalFieldIndex", technicalFieldIndex);
        }

        if (secretLevel != null) {
            this.setParam(condition, "secretLevel", secretLevel);
        }
        this.setBaseParam(condition);

        SysUser sysUserInfo = this.getUserProfile();
        String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(sysUserInfo.getUnitPath(), restTemplate, httpHeaders);
        this.setParam(condition,"childUnitIds",childUnitIds);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<PageInfo> responseEntity = this.restTemplate.exchange(query, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), PageInfo.class);
        return responseEntity.getBody();
    }


    @ApiOperation(value = "导出", notes = "导出")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authenticateUtil", value = "申报单位", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "researchField", value = "技术领域", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "professionalField", value = "专业领域", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "specialtyCategory", value = "专业类别", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "annual", value = "年度/月度", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "reportType", value = "类型", dataType = "string", paramType = "query")
    })

    @GetMapping(value = "/exportExcel")
    @ResponseBody
    public void exportExcel(
            @RequestParam(required = false) String authenticateUtil,
            @RequestParam(required = false) String researchField,
            @RequestParam(required = false) String professionalField,
            @RequestParam(required = false) String specialtyCategory,
            @RequestParam(required = false) String annual,
            @RequestParam(required = false) String reportType

    ) throws Exception {
        Map<String, Object> condition = new HashMap<>(6);
        if (!StringUtils.isEmpty(reportType)) {
            this.setParam(condition, "reportType", reportType);
        }

        if (!StringUtils.isEmpty(authenticateUtil)) {
            this.setParam(condition, "authenticateUtil", authenticateUtil);
        }
        if (!StringUtils.isEmpty(researchField)) {
            this.setParam(condition, "researchField", researchField);
        }
        if (!StringUtils.isEmpty(professionalField)) {
            this.setParam(condition, "professionalField", professionalField);
        }
        if (!StringUtils.isEmpty(specialtyCategory)) {
            this.setParam(condition, "specialtyCategory", specialtyCategory);
        }
        if (!StringUtils.isEmpty(annual)) {
            this.setParam(condition, "annual", annual);
        }
        this.setBaseParam(condition);

        String[] headers = { "创建单位", "技术领域", "专业领域", "专业类别","年度/月度"};
        String[] cols =    {"createUnitName","researchField","professionalField","specialtyCategory","annual"};
        ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(queryNoPage, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), JSONArray.class);
        List list = JSONObject.parseArray(responseEntity.getBody().toJSONString(), SciencePlan.class);
        String fileName = "科技材料_"+reportType+"明细表_"+ DateFormatUtils.format(new Date(), "ddhhmmss");
        this.exportExcel(headers,cols,fileName,list);
    }

    @ApiOperation(value = "保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public SciencePlan save(@RequestBody SciencePlan sp) {
        this.setBaseData(sp);
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
