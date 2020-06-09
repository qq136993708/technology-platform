package com.pcitc.web.controller.standardmaintain;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.achieve.AchieveMaintain;
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
 * <p>标准维护</p>
 * @author
 */
@Api(value = "standardMaintain-api", description = "标准维护接口")
@RestController
public class StandardMaintainController extends RestBaseController {


    /**
     * 根据ID获取对象信息
     */
    private static final String load = "http://kjpt-zuul/stp-proxy/standardMaintain-api/load/";
    /**
     * 查询列表
     */
    private static final String query = "http://kjpt-zuul/stp-proxy/standardMaintain-api/query";
    /**
     * 保存
     */
    private static final String save = "http://kjpt-zuul/stp-proxy/standardMaintain-api/save";
    /**
     * 删除
     */
    private static final String delete = "http://kjpt-zuul/stp-proxy/standardMaintain-api/delete/";

    /**
     * 查询列表不分页
     */
    private static final String queryNoPage = "http://kjpt-zuul/stp-proxy/standardMaintain-api/queryNoPage";



    @ApiOperation(value="读取")
    @RequestMapping(value = "/standardMaintain-api/load/{id}", method = RequestMethod.GET)
    @ResponseBody
    public StandardMaintain load(@PathVariable String id) {
        ResponseEntity<StandardMaintain> responseEntity = this.restTemplate.exchange(load+id, HttpMethod.GET, new HttpEntity(this.httpHeaders), StandardMaintain.class);
        return responseEntity.getBody();
    }




    @ApiOperation(value = "查询列表", notes = "查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "planNum", value = "计划号", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "planChineseName", value = "计划名称", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "standardNum", value = "标准号", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "standardName", value = "标准名称", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "isPublish", value = "是否已发布", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "chiefEditorUnit", value = "主编单位", dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/standardMaintain-api/query", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo query(
            @RequestParam(required = false,value = "pageNum") Integer pageNum,
            @RequestParam(required = false,value = "pageSize") Integer pageSize,
            @RequestParam(required = false,value = "planNum") String planNum,
            @RequestParam(required = false,value = "planChineseName") String planChineseName,
            @RequestParam(required = false,value = "standardNum") String standardNum,
            @RequestParam(required = false,value = "standardName")  String standardName,
            @RequestParam(required = false,value = "isPublish")  String isPublish,
            @RequestParam(required = false,value = "chiefEditorUnit")  String chiefEditorUnit
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
        if (!StringUtils.isEmpty(planNum)) {
            this.setParam(condition, "planNum", planNum);
        }
        if (!StringUtils.isEmpty(planChineseName)) {
            this.setParam(condition, "planChineseName", planChineseName);
        }
        if (!StringUtils.isEmpty(standardNum)) {
            this.setParam(condition, "standardNum", standardNum);
        }
        if (!StringUtils.isEmpty(standardName)) {
            this.setParam(condition, "standardName", standardName);
        }
        if (!StringUtils.isEmpty(isPublish)) {
            this.setParam(condition, "isPublish", isPublish);
        }
        if (!StringUtils.isEmpty(chiefEditorUnit)) {
            this.setParam(condition, "chiefEditorUnit", chiefEditorUnit);
        }
        String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(sysUserInfo.getDataScopeUnitPath(), restTemplate, httpHeaders);
        this.setParam(condition,"childUnitIds",childUnitIds);
        this.setBaseParam(condition);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<PageInfo> responseEntity = this.restTemplate.exchange(query, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), PageInfo.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value="保存")
    @RequestMapping(value = "/standardMaintain-api/save", method = RequestMethod.POST)
    @ResponseBody
    public void save(@RequestBody StandardMaintain am){
        this.setBaseData(am);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        this.restTemplate.exchange(save, HttpMethod.POST, new HttpEntity<StandardMaintain>(am, this.httpHeaders), StandardMaintain.class);
    }


    @ApiOperation(value="删除")
    @RequestMapping(value = "/standardMaintain-api/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable String id) {
       this.restTemplate.exchange(delete+id, HttpMethod.DELETE, new HttpEntity(this.httpHeaders), Integer.class);
    }


    @ApiOperation(value="初始化")
    @RequestMapping(value = "/standardMaintain-api/newInit", method = RequestMethod.GET)
    @ResponseBody
    public StandardMaintain newInit() {
        StandardMaintain a = new StandardMaintain();
        a.setId(UUID.randomUUID().toString().replace("-",""));
        return a;
    }


    @ApiOperation(value="导出excel")
    @RequestMapping(value = "/standardMaintain-api/export", method = RequestMethod.GET)
    @ResponseBody
    public void export(
            @RequestParam(required = false,value = "planNum") String planNum,
            @RequestParam(required = false,value = "planChineseName") String planChineseName,
            @RequestParam(required = false,value = "standardNum") String standardNum,
            @RequestParam(required = false,value = "standardName")  String standardName,
            @RequestParam(required = false,value = "isPublish")  String isPublish
    ) throws Exception {
        Map<String, Object> condition = new HashMap<>(2);
        if (!StringUtils.isEmpty(planNum)) {
            this.setParam(condition, "planNum", planNum);
        }
        if (!StringUtils.isEmpty(planChineseName)) {
            this.setParam(condition, "planChineseName", planChineseName);
        }
        if (!StringUtils.isEmpty(standardNum)) {
            this.setParam(condition, "standardNum", standardNum);
        }
        if (!StringUtils.isEmpty(standardName)) {
            this.setParam(condition, "standardName", standardName);
        }
        if (!StringUtils.isEmpty(isPublish)) {
            this.setParam(condition, "isPublish", isPublish);
        }
        String[] headers = { "计划号",  "计划中文名称","计划英文名称", "下达年度", "标准类型",
                "主编单位", "参编单位", "密级", "修改状态", "文件状态", "是否已发布", "主管部门", "技术委员会", "归口单位", "参照标准", "一致性程度","拟替代标准",
                "标准号", "标准名称", "英文名称", "发布时间", "实施时间","是否已发布英文版"};
        String[] cols =    {"planNum","planChineseName","planEnglishName","releaseYear","standardTypeText",
                "chiefEditorUnit","partakeEditorUnit","levelText","updateStatusText","fileStatusText","isPublishText","manageOrg"
                ,"technicalCommittee","putUnderUnitText","consultStandard","uniformityDegree"
                ,"toReplacedStandard","standardNum","standardName","englishName","publishDate","effectiveDate","isPublishEnglishEditionText"};
        export(headers,cols,"国内标准表_",condition);
    }


    private void export(String[] headers,String[] cols,String fileName,Map condition) throws Exception {
        this.setBaseParam(condition);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        SysUser sysUserInfo = this.getUserProfile();
        String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(sysUserInfo.getDataScopeUnitPath(), restTemplate, httpHeaders);
        this.setParam(condition,"childUnitIds",childUnitIds);
        ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(queryNoPage, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), JSONArray.class);
        List list = JSONObject.parseArray(responseEntity.getBody().toJSONString(), StandardMaintain.class);
        fileName = fileName+ DateFormatUtils.format(new Date(), "ddhhmmss");
        this.exportExcel(headers,cols,fileName,list);
    }



}
