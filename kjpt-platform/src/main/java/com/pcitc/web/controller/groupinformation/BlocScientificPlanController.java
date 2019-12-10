package com.pcitc.web.controller.groupinformation;


import com.github.pagehelper.PageInfo;
import com.pcitc.base.groupinformation.BlocScientificPlan;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.RestBaseController;
import com.pcitc.web.utils.EquipmentUtils;
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

@Api(value = "blocScientificPlan-api", description = "集团信息发布—科技规划接口")
@RestController
@RequestMapping(value = "/blocScientificPlan")
public class BlocScientificPlanController extends RestBaseController {


    /**
     * 根据ID获取对象信息
     */
    private static final String load = "http://kjpt-zuul/stp-proxy/blocScientificPlan-api/load/";
    /**
     * 查询平台列表
     */
    private static final String query = "http://kjpt-zuul/stp-proxy/blocScientificPlan-api/query";
    /**
     * 保存平台
     */
    private static final String save = "http://kjpt-zuul/stp-proxy/blocScientificPlan-api/save";
    /**
     * 删除
     */
    private static final String delete = "http://kjpt-zuul/stp-proxy/blocScientificPlan-api/delete/";


    @ApiOperation(value = "读取")
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    @ResponseBody
    public BlocScientificPlan load(@PathVariable String id) {
        ResponseEntity<BlocScientificPlan> responseEntity = this.restTemplate.exchange(load + id, HttpMethod.GET, new HttpEntity(this.httpHeaders), BlocScientificPlan.class);
        return responseEntity.getBody();
    }


    @ApiOperation(value = "查询计算机软件列表", notes = "查询计算机软件列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "名称", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "publication", value = "发布处室", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "annual", value = "年度/月度", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "pubdate", value = "发布时间", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "accessory", value = "附件", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "reportType", value = "上报类型", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "createUnitId", value = "创建单位id", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "createUnitName", value = "创建单位名称", dataType = "string", paramType = "query")

    })

    @GetMapping(value = "/query")
    @ResponseBody
    public PageInfo query(
            @RequestParam(required = false) Integer pageNum,
            @RequestParam(required = false) Integer pageSize,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String publication,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM") Date annual,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date pubdate,
            @RequestParam(required = false) String accessory,
            @RequestParam(required = false) String reportType,
            @RequestParam(required = false, value = "createUnitId") String createUnitId,
            @RequestParam(required = false, value = "createUnitName") String createUnitName

    ) {

        Map<String, Object> condition = new HashMap<>(6);

        this.setParam(condition, "pageNum", pageNum);
        this.setParam(condition, "pageSize", pageSize);

        if (!StringUtils.isEmpty(name)) {
            this.setParam(condition, "name", name);
        }
        if (!StringUtils.isEmpty(publication)) {
            this.setParam(condition, "publication", publication);
        }
        if (!StringUtils.isEmpty(DateUtil.format(annual,DateUtil.FMT_MMM))) {
            this.setParam(condition, "annual", DateUtil.format(annual,DateUtil.FMT_MMM));
        }
        if (!StringUtils.isEmpty(DateUtil.format(pubdate,DateUtil.FMT_DD))) {
            this.setParam(condition, "pubdate", DateUtil.format(pubdate,DateUtil.FMT_DD));
        }
        if (!StringUtils.isEmpty(accessory)) {
            this.setParam(condition, "accessory", accessory);
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

        //默认查询当前人所在机构及子机构的所有专家
        String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(sysUserInfo.getUnitPath(), restTemplate, httpHeaders);
        this.setParam(condition,"childUnitIds",childUnitIds);


        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<PageInfo> responseEntity = this.restTemplate.exchange(query, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), PageInfo.class);
        return responseEntity.getBody();

    }


    @ApiOperation(value = "保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public BlocScientificPlan save(@RequestBody BlocScientificPlan bsp) {
        this.setBaseData(bsp);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<BlocScientificPlan> responseEntity = this.restTemplate.exchange(save, HttpMethod.POST, new HttpEntity<BlocScientificPlan>(bsp, this.httpHeaders), BlocScientificPlan.class);




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
    public BlocScientificPlan newInit() {
        BlocScientificPlan p = new BlocScientificPlan();
        p.setId(UUID.randomUUID().toString().replace("_", ""));
        p.setDeleted("0");  //删除标识
        p.setCreateDate(new Date());  // 创建时间
        p.setCreator(this.getUserProfile().getUserName());
        return p;
    }

}
