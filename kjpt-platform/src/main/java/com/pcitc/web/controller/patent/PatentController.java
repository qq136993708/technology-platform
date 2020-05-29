package com.pcitc.web.controller.patent;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.patent.PatentInfo;
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

    private static final String queryNoPage = "http://kjpt-zuul/stp-proxy/patent-provider/patentInfo/queryNoPage";

    private static final String LOAD = "http://kjpt-zuul/stp-proxy/patent-provider/patentInfo/patentInfo_load/";

    private static final String DELETE = "http://kjpt-zuul/stp-proxy/patent-provider/patentInfo/patentInfo_delete/";

    private static final String batchRemove = "http://kjpt-zuul/stp-proxy/patent-provider/patentInfo/batchRemove/";

    private static final String countByLegalStatus = "http://kjpt-zuul/stp-proxy/patent-provider/patentInfo/countByLegalStatus";
    private static final String countByPatentType = "http://kjpt-zuul/stp-proxy/patent-provider/patentInfo/countByPatentType";

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
        this.setBaseData(patentInfo);
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
            @ApiImplicitParam(name = "technicalFieldIndex", value = "技术领域索引", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "type", value = "后专项处理", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "secretLevel", value = "密级", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "legalStatus", value = "法律状态", dataType = "string", paramType = "query")

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
            @RequestParam(required = false) String technicalFieldIndex,
            @RequestParam(required = false) String secretLevel,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String legalStatus
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
            String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(unitName, restTemplate, httpHeaders);
            this.setParam(condition,"childUnitIds",childUnitIds);
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
        if (!StringUtils.isEmpty(type)) {
            this.setParam(condition, "type", type);
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

        if(secretLevel != null){
            this.setParam(condition,"secretLevel",secretLevel);
        }
        if(legalStatus != null){
            this.setParam(condition,"legalStatus",legalStatus);
        }

        this.setBaseParam(condition);

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
        SysUser sysUserInfo = this.getUserProfile();
        String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(sysUserInfo.getUnitPath(), restTemplate, httpHeaders);
        this.setParam(condition,"childUnitIds",childUnitIds);
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
     * 专利列表-导出
     *
     * @return PageInfo
     */
    @ApiOperation(value = "导出", notes = "导出")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "unitName", value = "单位名称", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "applicationType", value = "申请类型", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "patentType", value = "专利类型", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "applicationNumber", value = "申请号（专利号）", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "patentName", value = "专利名称", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "applicant", value = "申请人", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "inventor", value = "发明人", dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/exportExcel",  method = RequestMethod.GET)
    @ResponseBody
    public void queryPatent(
            @RequestParam(required = false) String unitName,
            @RequestParam(required = false) String applicationType,
            @RequestParam(required = false) String patentType,
            @RequestParam(required = false) String applicationNumber,
            @RequestParam(required = false) String patentName,
            @RequestParam(required = false) String applicant,
            @RequestParam(required = false) String inventor

    ) throws Exception {
        Map<String, Object> condition = new HashMap<>(6);
        if (!StringUtils.isEmpty(applicationType)) {
            this.setParam(condition, "applicationType", applicationType);
        }
        if (!StringUtils.isEmpty(patentType)) {
            this.setParam(condition, "patentType", patentType);
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
        if (!StringUtils.isEmpty(unitName)) {
            this.setParam(condition, "unitName", unitName);
        }
        if (!StringUtils.isEmpty(applicationNumber)) {
            this.setParam(condition, "applicationNumber", applicationNumber);
        }
        this.setBaseParam(condition);
        String[] headers = { "专利名称",  "专利号",    "申请（专利权）人"  , "发明人","申请类型","专利类别","国别组织","申请日期","授权日期","终止日期","法律状态",
                "法律状态变更日期","应用技术领域（技术类）","项目背景","立项部门","项目编号","项目名称","应用技术领域（产品类）","应用型号产品名称","应用分系统名称","元器件及配套材料名称",
                "主分类号","副分类号","联合申请人","优先权","代理机构","公开（公告）号","说明","法人代码"};
        String[] cols =    {"patentName","applicationNumber","applicant","inventor","applicationTypeText","patentTypeText","country","applicationDate","authorizationDate",
                            "terminationDate","legalStatus","legalStatusUpdateTime","technicalFieldText","projectBackground","establishmentDepartment","projectNumber","projectName","applicationTechnologyTechnology",
                            "applicationModelProductName","applicationSubsystemName","nameOfComponentsAndSupportingMaterials","mainClassificationNumber","subCategoryNumber","jointApplicant","priorityRight","agency","publicAnnouncementNo", "explainer","legalPersonCode"};
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        SysUser sysUserInfo = this.getUserProfile();
        String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(sysUserInfo.getUnitPath(), restTemplate, httpHeaders);
        this.setParam(condition,"childUnitIds",childUnitIds);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(queryNoPage, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), JSONArray.class);
        List list = JSONObject.parseArray(responseEntity.getBody().toJSONString(), PatentInfo.class);
        String fileName = "专利明细表_"+ DateFormatUtils.format(new Date(), "ddhhmmss");
        this.exportExcel(headers,cols,fileName,list);
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
     * 后专项处理批量移除
     *
     * @return PatentInfo
     */
    @ApiOperation(value="批量移除")
    @RequestMapping(value = "/batchRemove/{ids}", method = RequestMethod.GET)
    @ResponseBody
    public void batchRemove(@PathVariable String ids) {
        Map<String, Object> condition = new HashMap<>(6);
        this.restTemplate.exchange(batchRemove+ids, HttpMethod.POST, new HttpEntity(this.httpHeaders),Integer.class);
//        return responseEntity.getBody();

    }
    /**
     * 根据法律状态查询专利数量
     *
     * @return PatentInfo
     */
    @ApiOperation(value="根据法律状态查询专利数量")
    @RequestMapping(value = "/countByLegalStatus", method = RequestMethod.GET)
    @ResponseBody
    public List countByLegalStatus() {
        Map<String, Object> condition = new HashMap<>(6);
        SysUser sysUserInfo = this.getUserProfile();
        String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(sysUserInfo.getUnitPath(), restTemplate, httpHeaders);
        this.setParam(condition,"childUnitIds",childUnitIds);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<List> responseEntity = this.restTemplate.exchange(countByLegalStatus, HttpMethod.POST, new HttpEntity<Map>(condition,this.httpHeaders),List.class);
        return responseEntity.getBody();
    }

    /**
     * 根据专利类型查询专利数量
     *
     * @return PatentInfo
     */
    @ApiOperation(value="根据专利类型查询专利数量")
    @RequestMapping(value = "/countByPatentType", method = RequestMethod.GET)
    @ResponseBody
    public List countByPatentType() {
        Map<String, Object> condition = new HashMap<>(6);
        SysUser sysUserInfo = this.getUserProfile();
        String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(sysUserInfo.getUnitPath(), restTemplate, httpHeaders);
        this.setParam(condition,"childUnitIds",childUnitIds);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<List> responseEntity = this.restTemplate.exchange(countByPatentType, HttpMethod.POST, new HttpEntity<Map>(condition,this.httpHeaders),List.class);
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
