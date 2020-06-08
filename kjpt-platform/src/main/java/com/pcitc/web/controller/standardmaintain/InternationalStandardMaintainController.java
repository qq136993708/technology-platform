package com.pcitc.web.controller.standardmaintain;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.standardmaintain.InternationalStandardMaintain;
import com.pcitc.base.standardmaintain.StandardMaintain;
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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * <p>国际标准</p>
 * @author
 */
@Api(value = "internationalStandardMaintain-api", description = "国际标准")
@RestController
public class InternationalStandardMaintainController extends RestBaseController {


    /**
     * 根据ID获取对象信息
     */
    private static final String load = "http://kjpt-zuul/stp-proxy/internationalStandardMaintain-api/load/";
    /**
     * 查询列表
     */
    private static final String query = "http://kjpt-zuul/stp-proxy/internationalStandardMaintain-api/query";
    /**
     * 保存
     */
    private static final String save = "http://kjpt-zuul/stp-proxy/internationalStandardMaintain-api/save";
    /**
     * 删除
     */
    private static final String delete = "http://kjpt-zuul/stp-proxy/internationalStandardMaintain-api/delete/";

    /**
     * 查询列表不分页
     */
    private static final String queryNoPage = "http://kjpt-zuul/stp-proxy/internationalStandardMaintain-api/queryNoPage";



    @ApiOperation(value="读取")
    @RequestMapping(value = "/internationalStandardMaintain-api/load/{id}", method = RequestMethod.GET)
    @ResponseBody
    public InternationalStandardMaintain load(@PathVariable String id) {
        ResponseEntity<InternationalStandardMaintain> responseEntity = this.restTemplate.exchange(load+id, HttpMethod.GET, new HttpEntity(this.httpHeaders), InternationalStandardMaintain.class);
        return responseEntity.getBody();
    }




    @ApiOperation(value = "查询列表", notes = "查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "planNum", value = "计划号", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "standardChineseName", value = "标准中文名称", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "standardNum", value = "标准号", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "domesticProposalUnit", value = "国内提案单位", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "standardStatus", value = "标准状态", dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/internationalStandardMaintain-api/query", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo query(
            @RequestParam(required = false,value = "pageNum") Integer pageNum,
            @RequestParam(required = false,value = "pageSize") Integer pageSize,
            @RequestParam(required = false,value = "standardChineseName") String standardChineseName,
            @RequestParam(required = false,value = "standardNum") String standardNum,
            @RequestParam(required = false,value = "domesticProposalUnit") String domesticProposalUnit,
            @RequestParam(required = false,value = "standardStatus")  String standardStatus
    ){

        Map<String, Object> condition = new HashMap<>(6);
        SysUser sysUserInfo = this.getUserProfile();
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
        if (!StringUtils.isEmpty(standardChineseName)) {
            this.setParam(condition, "standardChineseName", standardChineseName);
        }
        if (!StringUtils.isEmpty(standardNum)) {
            this.setParam(condition, "standardNum", standardNum);
        }
        if (!StringUtils.isEmpty(domesticProposalUnit)) {
            this.setParam(condition, "domesticProposalUnit", domesticProposalUnit);
        }
        if (!StringUtils.isEmpty(standardStatus)) {
            this.setParam(condition, "standardStatus", standardStatus);
        }
        String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(sysUserInfo.getDataScopeUnitPath(), restTemplate, httpHeaders);
        this.setParam(condition,"childUnitIds",childUnitIds);
        this.setBaseParam(condition);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<PageInfo> responseEntity = this.restTemplate.exchange(query, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), PageInfo.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value="保存")
    @RequestMapping(value = "/internationalStandardMaintain-api/save", method = RequestMethod.POST)
    @ResponseBody
    public void save(@RequestBody InternationalStandardMaintain am){
        this.setBaseData(am);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        this.restTemplate.exchange(save, HttpMethod.POST, new HttpEntity<InternationalStandardMaintain>(am, this.httpHeaders), InternationalStandardMaintain.class);
    }


    @ApiOperation(value="删除")
    @RequestMapping(value = "/internationalStandardMaintain-api/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable String id) {
       this.restTemplate.exchange(delete+id, HttpMethod.DELETE, new HttpEntity(this.httpHeaders), Integer.class);
    }


    @ApiOperation(value="初始化")
    @RequestMapping(value = "/internationalStandardMaintain-api/newInit", method = RequestMethod.GET)
    @ResponseBody
    public InternationalStandardMaintain newInit() {
        InternationalStandardMaintain a = new InternationalStandardMaintain();
        a.setId(UUID.randomUUID().toString().replace("-",""));
        return a;
    }


    @ApiOperation(value="导出excel")
    @RequestMapping(value = "/internationalStandardMaintain-api/export", method = RequestMethod.GET)
    @ResponseBody
    public void export(
            @RequestParam(required = false,value = "standardChineseName") String standardChineseName,
            @RequestParam(required = false,value = "standardNum") String standardNum,
            @RequestParam(required = false,value = "domesticProposalUnit") String domesticProposalUnit,
            @RequestParam(required = false,value = "standardStatus")  String standardStatus
    ) throws Exception {
        Map<String, Object> condition = new HashMap<>(2);
        if (!StringUtils.isEmpty(standardChineseName)) {
            this.setParam(condition, "standardChineseName", standardChineseName);
        }
        if (!StringUtils.isEmpty(standardNum)) {
            this.setParam(condition, "standardNum", standardNum);
        }
        if (!StringUtils.isEmpty(domesticProposalUnit)) {
            this.setParam(condition, "domesticProposalUnit", domesticProposalUnit);
        }
        if (!StringUtils.isEmpty(standardStatus)) {
            this.setParam(condition, "standardStatus", standardStatus);
        }
        String[] headers = { "对应的国际标准化组织",  "对应的国际标准工作组","标准编号", "标准中文名称", "标准英文名称",
                "国内提案单位", "参与国家", "标准状态", "管理状态", "立项时间", "发布时间"};
        String[] cols =    {"internationalStandardOrg","internationalStandardWorkGroup","standardNum","standardChineseName","standardEnglishName",
                "domesticProposalUnit","partakeCountryText","standardStatusText","manageStatus","projectApprovalDate","publishDate"};
        export(headers,cols,"国际标准表_",condition);
    }


    private void export(String[] headers,String[] cols,String fileName,Map condition) throws Exception {
        this.setBaseParam(condition);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        SysUser sysUserInfo = this.getUserProfile();
        String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(sysUserInfo.getDataScopeUnitPath(), restTemplate, httpHeaders);
        this.setParam(condition,"childUnitIds",childUnitIds);
        ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(queryNoPage, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), JSONArray.class);
        List list = JSONObject.parseArray(responseEntity.getBody().toJSONString(), InternationalStandardMaintain.class);
        fileName = fileName+ DateFormatUtils.format(new Date(), "ddhhmmss");
        this.exportExcel(headers,cols,fileName,list);
    }



}
