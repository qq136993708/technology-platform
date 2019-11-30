package com.pcitc.web.controller.patent;


import com.github.pagehelper.PageInfo;
import com.pcitc.base.patent.PatentInfo;
import com.pcitc.base.util.DateUtil;
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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Api(value = "patent-api", description = "专利接口")
@Controller
@RequestMapping("/patentController")
public class PatentController extends RestBaseController {

    private static final String SAVE = "http://kjpt-zuul/stp-proxy/patent-provider/patentInfo/patentInfo_save";

    private static final String QUERY = "http://kjpt-zuul/stp-proxy/patent-provider/patentInfo/patentInfo_query";

    private static final String QUERY_PATENT = "http://kjpt-zuul/stp-proxy/patent-provider/patentInfo/patentInfo_queryPatent";

    private static final String LOAD = "http://kjpt-zuul/stp-proxy/patent-provider/patentInfo/patentInfo_load/";

    private static final String DELETE = "http://kjpt-zuul/stp-proxy/patent-provider/patentInfo/patentInfo_delete/";

    /**
     * 保存-专利信息
     *
     * @param patentInfo
     * @return PatentInfo
     */
    @ApiOperation(value = "保存专利信息", notes = "保存专利信息")
    @RequestMapping(value = "/save",method=RequestMethod.POST)
    @ResponseBody
    public PatentInfo save(@RequestBody PatentInfo patentInfo) {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<PatentInfo> responseEntity = this.restTemplate.exchange(SAVE, HttpMethod.POST, new HttpEntity<PatentInfo>(patentInfo, this.httpHeaders), PatentInfo.class);
        return responseEntity.getBody();
    }

    /**
     * 专利列表-分页查询
     *
     * @return PageInfo
     */
    @ApiOperation(value = "查询专利列表", notes = "查询专利列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "unitName", value = "单位名称", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "applicationDateStart", value = "申请日期开始", dataType = "Date", paramType = "query"),
            @ApiImplicitParam(name = "applicationDateEnd", value = "申请日期结束", dataType = "Date", paramType = "query"),
            @ApiImplicitParam(name = "applicationType", value = "申请类型", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "patentType", value = "专利类型", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "applicationNumber", value = "申请号（专利号）", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "patentName", value = "专利名称", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "applicant", value = "申请人", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "inventor", value = "发明人", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "technicalFieldIndex", value = "技术领域索引", dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/query",  method = RequestMethod.GET)
    @ResponseBody
    public PageInfo query(
            @RequestParam(required = false) Integer pageNum,
            @RequestParam(required = false) Integer pageSize,
            @RequestParam(required = false) String unitName,
            @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date applicationDateStart,
            @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date applicationDateEnd,
            @RequestParam(required = false) String applicationType,
            @RequestParam(required = false) String patentType,
            @RequestParam(required = false) String applicationNumber,
            @RequestParam(required = false) String patentName,
            @RequestParam(required = false) String applicant,
            @RequestParam(required = false) String inventor,
            @RequestParam(required = false) String technicalFieldIndex

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
        if (!StringUtils.isEmpty(unitName)) {
            this.setParam(condition, "unitName", unitName);
        }
        if (!StringUtils.isEmpty(DateUtil.format(applicationDateStart,DateUtil.FMT_SS))) {
            this.setParam(condition, "applicationDateStart", DateUtil.format(applicationDateStart,DateUtil.FMT_SS));
        }
        if (!StringUtils.isEmpty(DateUtil.format(applicationDateEnd,DateUtil.FMT_SS))) {
            this.setParam(condition, "applicationDateEnd", DateUtil.format(applicationDateEnd,DateUtil.FMT_SS));
        }
        if (!StringUtils.isEmpty(applicationType)) {
            this.setParam(condition, "applicationType", applicationType);
        }
        if (!StringUtils.isEmpty(patentType)) {
            this.setParam(condition, "patentType", patentType);
        }
        if (!StringUtils.isEmpty(applicationNumber)) {
            this.setParam(condition, "applicationNumber", applicationNumber);
        }
        if (!StringUtils.isEmpty(patentName)) {
            this.setParam(condition, "patentName", patentName);
        }
        if (!StringUtils.isEmpty(applicant)) {
            this.setParam(condition, "applicant", applicant);
        }
        if (!StringUtils.isEmpty(inventor)) {
            this.setParam(condition, "inventor", inventor);
        }
        if (!StringUtils.isEmpty(technicalFieldIndex)) {
            this.setParam(condition, "technicalFieldIndex", technicalFieldIndex);
        }
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<PageInfo> responseEntity = this.restTemplate.exchange(QUERY, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), PageInfo.class);
        return responseEntity.getBody();
    }

    /**
     * 专利列表-分页查询
     *
     * @return PageInfo
     */
    @ApiOperation(value = "查询专利列表", notes = "查询专利列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "unitName", value = "单位名称", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "applicationDateStart", value = "申请日期开始", dataType = "Date", paramType = "query"),
            @ApiImplicitParam(name = "applicationDateEnd", value = "申请日期结束", dataType = "Date", paramType = "query"),
            @ApiImplicitParam(name = "applicationType", value = "申请类型", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "patentType", value = "专利类型", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "applicationNumber", value = "申请号（专利号）", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "patentName", value = "专利名称", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "applicant", value = "申请人", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "inventor", value = "发明人", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "technicalFieldIndex", value = "技术领域索引", dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/queryPatent",  method = RequestMethod.GET)
    @ResponseBody
    public List queryPatent(
            @RequestParam(required = false) Integer pageNum,
            @RequestParam(required = false) Integer pageSize,
            @RequestParam(required = false) String unitName,
            @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date applicationDateStart,
            @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date applicationDateEnd,
            @RequestParam(required = false) String applicationType,
            @RequestParam(required = false) String patentType,
            @RequestParam(required = false) String applicationNumber,
            @RequestParam(required = false) String patentName,
            @RequestParam(required = false) String applicant,
            @RequestParam(required = false) String inventor,
            @RequestParam(required = false) String technicalFieldIndex

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
        if (!StringUtils.isEmpty(unitName)) {
            this.setParam(condition, "unitName", unitName);
        }
        if (!StringUtils.isEmpty(DateUtil.format(applicationDateStart,DateUtil.FMT_SS))) {
            this.setParam(condition, "applicationDateStart", DateUtil.format(applicationDateStart,DateUtil.FMT_SS));
        }
        if (!StringUtils.isEmpty(DateUtil.format(applicationDateEnd,DateUtil.FMT_SS))) {
            this.setParam(condition, "applicationDateEnd", DateUtil.format(applicationDateEnd,DateUtil.FMT_SS));
        }
        if (!StringUtils.isEmpty(applicationType)) {
            this.setParam(condition, "applicationType", applicationType);
        }
        if (!StringUtils.isEmpty(patentType)) {
            this.setParam(condition, "patentType", patentType);
        }
        if (!StringUtils.isEmpty(applicationNumber)) {
            this.setParam(condition, "applicationNumber", applicationNumber);
        }
        if (!StringUtils.isEmpty(patentName)) {
            this.setParam(condition, "patentName", patentName);
        }
        if (!StringUtils.isEmpty(applicant)) {
            this.setParam(condition, "applicant", applicant);
        }
        if (!StringUtils.isEmpty(inventor)) {
            this.setParam(condition, "inventor", inventor);
        }
        if (!StringUtils.isEmpty(technicalFieldIndex)) {
            this.setParam(condition, "technicalFieldIndex", technicalFieldIndex);
        }
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<List> responseEntity = this.restTemplate.exchange(QUERY_PATENT, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), List.class);
        List arraylist = new ArrayList();
        Map hashMap = new HashMap<String,Object>();
        hashMap.put("total",responseEntity.getBody().size());
        hashMap.put("list",responseEntity.getBody());
        arraylist.add(hashMap);
        return arraylist;
    }

    /**
     * 根据ID查询专利信息
     *
     * @return PatentInfo
     */
    @ApiOperation(value="根据ID查询专利信息")
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    @ResponseBody
    public PatentInfo load(@PathVariable String id) {
        ResponseEntity<PatentInfo> responseEntity = this.restTemplate.exchange(LOAD+id, HttpMethod.GET, new HttpEntity(this.httpHeaders), PatentInfo.class);
        return responseEntity.getBody();
    }

    /**
     * 删除专利信息
     *
     * @return Integer
     */
    @ApiOperation(value="删除专利信息")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Integer delete(@PathVariable String id){
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(DELETE +id, HttpMethod.DELETE, new HttpEntity(this.httpHeaders), Integer.class);
        return responseEntity.getBody();
    }

    /**
     * 初始化方法
     *
     * @param request
     * @return PatentInfo
     */
    @ApiOperation(value="初始化专利信息")
    @RequestMapping(value = "/newInit",method = RequestMethod.GET)
    @ResponseBody
    public PatentInfo newInit(HttpServletRequest request) {
        PatentInfo patentInfo = new PatentInfo();
        patentInfo.setId(UUID.randomUUID().toString().replace("-",""));
        patentInfo.setCreateDate(new Date());
        patentInfo.setCreator(this.getUserProfile().getUserName());
        patentInfo.setDeleted("0");
        return patentInfo;
    }
}
