package com.pcitc.web.controller.patent;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.Result;
import com.pcitc.base.patent.PatentInfo;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.RestBaseController;
import com.pcitc.web.utils.EquipmentUtils;
import com.pcitc.web.utils.ImportExcelUtil;
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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.*;

@Api(value = "patent-api", description = "专利接口")
@RestController
@RequestMapping("/patentController")
public class PatentController extends RestBaseController {

    private static final String SAVE = "http://kjpt-zuul/stp-proxy/patent-provider/patentInfo/patentInfo_save";

    private static final String QUERY = "http://kjpt-zuul/stp-proxy/patent-provider/patentInfo/patentInfo_query";

    private static final String QUERY_PATENT = "http://kjpt-zuul/stp-proxy/patent-provider/patentInfo/patentInfo_queryPatent";

    private static final String queryNoPage = "http://kjpt-zuul/stp-proxy/patent-provider/patentInfo/queryNoPage";

    private static final String LOAD = "http://kjpt-zuul/stp-proxy/patent-provider/patentInfo/patentInfo_load/";

    private static final String DELETE = "http://kjpt-zuul/stp-proxy/patent-provider/patentInfo/patentInfo_delete/";

    private static final String batchRemove = "http://kjpt-zuul/stp-proxy/patent-provider/patentInfo/batchRemove/";
    private static final String postTreatment = "http://kjpt-zuul/stp-proxy/patent-provider/patentInfo/postTreatment/";

    private static final String countByLegalStatus = "http://kjpt-zuul/stp-proxy/patent-provider/patentInfo/countByLegalStatus";
    private static final String countByPatentType = "http://kjpt-zuul/stp-proxy/patent-provider/patentInfo/countByPatentType";

    private static final String GET_UNIT_ID = "http://kjpt-zuul/system-proxy/unit-provider/unit/getUnitId_by_name";

    private static final String ROOT_KJPT_ZLZL = "ROOT_KJPT_ZLZL";


    /**
     * 导入模板头部所占行数
     */
    private static final Integer IMPORT_HEAD = 3;

    private static final String PATENT_INFO_EXCEL_INPUT = "http://kjpt-zuul/stp-proxy/patent-provider/patentInfo/excel_input";

    //用于缓存导入时的字典数据
    private Map<String,Map<String,String>> dictMap = new HashMap<>();

    private static final String ROOT_KJPT_FLZT = "ROOT_KJPT_FLZT(ZL)";

    private static final String ROOT_KJPT_SQLX = "ROOT_KJPT_SQLX";

    private static final String ROOT_KJPT_GJ = "ROOT_KJPT_GJ";
    //用于缓存项目背景数据字典
    private Map<String,String> projectbckMap = new HashMap<>();

    private static final String ROOT_KJPT_XMBJ = "ROOT_KJPT_XMBJ";

    private static final String ROOT_KJPT_YYJSLYJSLJSL = "ROOT_KJPT_YYJSLYJSLJSL";

    private static final String ROOT_KJPT_YYJSLYCPL = "ROOT_KJPT_YYJSLYCPL";

    private static final String ROOT_KJPT_YYJSLYJSL_HKXJS = "ROOT_KJPT_YYJSLYJSL_HKXJS";

    private static final String ROOT_KJPT_YYJSLYCPL_HNYHJSYY = "ROOT_KJPT_YYJSLYCPL_HNYHJSYY";
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
            @ApiImplicitParam(name = "projectBackground", value = "项目背景", dataType = "String", paramType = "query"),
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
            @RequestParam(required = false) String projectBackground,
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
        if (!StringUtils.isEmpty(projectBackground)) {
            this.setParam(condition, "projectBackground", projectBackground);
        }

        if(secretLevel != null){
            this.setParam(condition,"secretLevel",secretLevel);
        }
        if(legalStatus != null){
            this.setParam(condition,"legalStatus",legalStatus);
        }

        this.setBaseParam(condition);

        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        SysUser sysUserInfo = this.getUserProfile();
        String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(sysUserInfo.getDataScopeUnitPath(), restTemplate, httpHeaders);
        this.setParam(condition,"childUnitIds",childUnitIds);
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
        String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(sysUserInfo.getDataScopeUnitPath(), restTemplate, httpHeaders);
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
            @ApiImplicitParam(name = "inventor", value = "发明人", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "type", value = "类型", dataType = "String", paramType = "query")
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
            @RequestParam(required = false) String inventor,
            @RequestParam(required = false) String type

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
        if (!StringUtils.isEmpty(type)) {
            this.setParam(condition, "type", type);
        }
        if (!StringUtils.isEmpty(applicationNumber)) {
            this.setParam(condition, "applicationNumber", applicationNumber);
        }
        this.setBaseParam(condition);
        String[] headers = { "专利名称",  "专利号",    "申请（专利权）人"  , "发明人","申请类型","专利类别","国别组织","申请日期","授权日期","终止日期","法律状态",
                "法律状态变更日期","应用技术领域（技术类）","项目背景","立项部门","项目编号","项目名称","应用技术领域（产品类）","应用型号产品名称","应用分系统名称","元器件及配套材料名称",
                "主分类号","副分类号","联合申请人","优先权","代理机构","公开（公告）号","说明","法人代码"};
        String[] cols =    {"patentName","applicationNumber","applicant","inventor","applicationTypeText","patentTypeText","countryText","applicationDate","authorizationDate",
                            "terminationDate","legalStatusText","legalStatusUpdateTime","technicalFieldText","projectBackgroundText","establishmentDepartment","projectNumber","projectName","applicationTechnologyTechnologyText",
                            "applicationModelProductName","applicationSubsystemName","nameOfComponentsAndSupportingMaterials","mainClassificationNumber","subCategoryNumber","jointApplicant","priorityRight","agency","publicAnnouncementNo", "explainer","legalPersonCode"};
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        SysUser sysUserInfo = this.getUserProfile();
        String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(sysUserInfo.getDataScopeUnitPath(), restTemplate, httpHeaders);
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
     * 批量后处理
     *
     * @return PatentInfo
     */
    @ApiOperation(value="批量后处理")
    @RequestMapping(value = "/postTreatment/{ids}", method = RequestMethod.GET)
    @ResponseBody
    public void postTreatment(@PathVariable String ids) {
        Map<String, Object> condition = new HashMap<>(6);
        this.restTemplate.exchange(postTreatment+ids, HttpMethod.POST, new HttpEntity(this.httpHeaders),Integer.class);
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
    public List countByLegalStatus(@RequestParam(required = false) String type) {
        Map<String, Object> condition = new HashMap<>(6);
        SysUser sysUserInfo = this.getUserProfile();
        String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(sysUserInfo.getDataScopeUnitPath(), restTemplate, httpHeaders);
        this.setParam(condition,"childUnitIds",childUnitIds);
        if (!StringUtils.isEmpty(type)) {
            this.setParam(condition, "type", type);
        }
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
    public List countByPatentType(@RequestParam(required = false) String type) {
        Map<String, Object> condition = new HashMap<>(6);
        SysUser sysUserInfo = this.getUserProfile();
        String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(sysUserInfo.getDataScopeUnitPath(), restTemplate, httpHeaders);
        this.setParam(condition,"childUnitIds",childUnitIds);
        if (!StringUtils.isEmpty(type)) {
            this.setParam(condition, "type", type);
        }
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


    @ApiOperation(value = "根据模板导入专利管理信息（EXCEL）", notes = "根据模板导入专利管理信息（EXCEL）")
    @RequestMapping(value = "/input_excel", method = RequestMethod.POST)
    public Object newImportData(HttpServletRequest req, HttpServletResponse resp, MultipartFile file) throws Exception
    {
        Result resultsDate = new Result();
        String type = req.getQueryString();
        if(StringUtils.isBlank(type)){
            resultsDate.setSuccess(false);
            resultsDate.setMessage("未能获取专利管理信息类型，请重试");
        }else{
            type = getReportTypeFromQueryString(type);
        }
        SysUser sysUserInfo = this.getUserProfile();

        if (file.isEmpty())
        {
            resultsDate.setSuccess(false);
            resultsDate.setMessage("上传异常，请重试");
        }else
        {
            InputStream in = file.getInputStream();
            List<List<Object>> listob = new ImportExcelUtil().getBankListByExcel(in, file.getOriginalFilename());
            System.out.println(">>>>>>行数:"+listob.size());
            List<PatentInfo> list = new ArrayList<PatentInfo>();
            resultsDate= getResult( listob );
            if(resultsDate.isSuccess()==true)
            {
                for (int i = IMPORT_HEAD; i < listob.size(); i++)
                {
                    List<Object> lo = listob.get(i);
                    if(lo.size()<34) break;
                    Object col_1 = lo.get(1);    //单位名称
                    Object col_2 = lo.get(2);    //专利名称
                    Object col_3 = lo.get(3);    //专利号
                    Object col_4 = lo.get(4);    //申请类型
                    if(checkIfBlank(col_1)&&checkIfBlank(col_2)&&checkIfBlank(col_3)&&checkIfBlank(col_4)) break;
                    Object col_5 = lo.get(5);    //专利类别
                    Object col_7 = lo.get(7);    //申请日期
                    Object col_10 = lo.get(10);  //申请人
                    Object col_11 = lo.get(11);  //发明人
                    Object col_12 = lo.get(12);  //项目背景
                    Object col_16 = lo.get(16);  //应用技术领域
                    Object col_22 = lo.get(22);  //法律状态
                    Object col_23 = lo.get(23);  //变更日期
                    Object col_33 = lo.get(33);  //专业转化应用

                    //将excel导入数据转换为SciencePlan对象
                    PatentInfo obj = new PatentInfo();

                    obj.setType(type);
                   obj.setUnitName(restTemplate.exchange(GET_UNIT_ID, HttpMethod.POST, new HttpEntity<Object>(lo.get(1),this.httpHeaders), String.class).getBody());
                   // obj.setUnitName(String.valueOf(col_1));
                    obj.setUnitNameText(String.valueOf(col_1));
                    obj.setPatentName(String.valueOf(col_2));
                    obj.setApplicationNumber(String.valueOf(col_3));
                    obj.setApplicationType(getValueFromDictMap(String.valueOf(col_4),ROOT_KJPT_SQLX));
                    obj.setApplicationTypeText(String.valueOf(col_4));

                    obj.setPatentType(getValueFromDictMap(String.valueOf(col_5),ROOT_KJPT_ZLZL));
                    obj.setPatentTypeText(String.valueOf(col_5));

                    obj.setCountry(getValueFromDictMap(String.valueOf(lo.get(6)),ROOT_KJPT_GJ));
                    obj.setCountryText(String.valueOf(lo.get(6)));

                    Date applicationDate = DateUtil.strToDate(String.valueOf(col_7),DateUtil.FMT_DD);
                    obj.setApplicationDate(applicationDate);
                    obj.setApplicationDateStr(String.valueOf(col_7));
                    if(!checkIfBlank(lo.get(8))){
                        Date authDate = DateUtil.strToDate(String.valueOf(lo.get(8)),DateUtil.FMT_DD);
                        obj.setAuthorizationDate(authDate);
                    }
                    if(!checkIfBlank(lo.get(9))){
                        Date temDate = DateUtil.strToDate(String.valueOf(lo.get(9)),DateUtil.FMT_DD);
                        obj.setTerminationDate(temDate);
                    }
                    obj.setApplicant(String.valueOf(col_10));
                    obj.setInventor(String.valueOf(col_11));
                    obj.setProjectBackground(projectbckMap.get(String.valueOf(col_12)));
                    obj.setProjectBackgroundText(String.valueOf(col_12));

                    obj.setEstablishmentDepartment(String.valueOf(lo.get(13)));
                    obj.setProjectNumber(String.valueOf(lo.get(14)));
                    obj.setProjectName(String.valueOf(lo.get(15)));
                    //todo:领用领域技术
                    //先从领域技术里获取，如果没有，再从核科学技术中获取
                    String tech = getValueFromDictMap(String.valueOf(lo.get(16)),ROOT_KJPT_YYJSLYJSLJSL);
                    if(!StringUtils.isNotBlank(tech)){
                        tech = getValueFromDictMap(String.valueOf(lo.get(16)),ROOT_KJPT_YYJSLYJSL_HKXJS);
                    }
                    obj.setApplicationTechnologyTechnology(tech);
                    obj.setTechnicalFieldText(String.valueOf(lo.get(16)));

                    if(!checkIfBlank(lo.get(17))){
                        String techProduct = getValueFromDictMap(String.valueOf(lo.get(17)),ROOT_KJPT_YYJSLYCPL);
                        if(!StringUtils.isNotBlank(techProduct)){
                            techProduct = getValueFromDictMap(String.valueOf(lo.get(17)),ROOT_KJPT_YYJSLYCPL_HNYHJSYY);

                        }
                        obj.setApplicationTechnologyProducts(techProduct);
                    }
                    obj.setApplicationModelProductName(String.valueOf(lo.get(18)));
                    obj.setApplicationSubsystemName(String.valueOf(lo.get(19)));
                    obj.setNameOfComponentsAndSupportingMaterials(String.valueOf(lo.get(20)));
                    obj.setCustomClassification(String.valueOf(lo.get(21)));
                    obj.setLegalStatus(getValueFromDictMap(String.valueOf(lo.get(22)),ROOT_KJPT_FLZT));
                    obj.setLegalStatusText(String.valueOf(lo.get(22)));
                    Date legalStatusUpdateTime = DateUtil.strToDate(String.valueOf(lo.get(23)),DateUtil.FMT_DD);
                    obj.setLegalStatusUpdateTime(legalStatusUpdateTime);
                    obj.setMainClassificationNumber(String.valueOf(lo.get(24)));
                    obj.setSubCategoryNumber(String.valueOf(lo.get(25)));
                    obj.setJointApplicant(String.valueOf(lo.get(26)));
                    obj.setPriorityRight(String.valueOf(lo.get(27)));
                    obj.setAgency(String.valueOf(lo.get(28)));
                    obj.setPublicAnnouncementNo(String.valueOf(lo.get(29)));
                    //todo:数据库中的字段是explainer，可能会导入失败
                    obj.setExplain(String.valueOf(lo.get(30)));
                    obj.setPatentRange(String.valueOf(lo.get(31)));
                    obj.setRemark(String.valueOf(lo.get(32)));
                    //todo:专业转化应用
                    obj.setApplicationOfPatentTransformation(String.valueOf(lo.get(33)));
                    obj.setApplicationOfPatentTransformationText(String.valueOf(lo.get(33)));
                    obj.setUnenforcedReason(String.valueOf(lo.get(34)));
                    obj.setLicensee(String.valueOf(lo.get(35)));
                    //todo:需要修改字段类型为Double
                   /* if(!checkIfBlank(lo.get(36))){
                        String profit  = String.valueOf(lo.get(36));
                        obj.setLicenseeProfit(Long.parseLong(profit));
                    }*/
                    obj.setAssignor(String.valueOf(lo.get(37)));
                    /*if(!checkIfBlank(lo.get(38))){
                        String profit  = String.valueOf(lo.get(38));
                        obj.setAssignProfit(Long.parseLong(profit));
                    }*/

                    obj.setCreateUnitId(sysUserInfo.getUnitId());
                    obj.setDeleted("0");
                    String dateid = UUID.randomUUID().toString().replaceAll("-", "");
                    obj.setId(dateid);
                    obj.setSecretLevel("0");
                    list.add(obj);
                }
                ResponseEntity<Result> responseEntity =  this.restTemplate.exchange(PATENT_INFO_EXCEL_INPUT, HttpMethod.POST, new HttpEntity<Object>(list, this.httpHeaders), Result.class);
                int statusCode = responseEntity.getStatusCodeValue();
                // 返回结果代码
                if (statusCode == 200) {
                    resultsDate.setSuccess(true);

                    resultsDate.setCode("0");
                } else {
                    Result back = responseEntity.getBody();
                    resultsDate.setSuccess(false);
                    resultsDate.setMessage(back.getMessage());
                }
            }else{
                resultsDate.setSuccess(false);
                resultsDate.setCode("1");
            }

        }

        return resultsDate;
    }

    private Result getResult(List<List<Object>> listob )
    {
        Result resultsDate = new Result();
        resultsDate.setSuccess(true);
        StringBuffer sb=new StringBuffer();
        for (int i = IMPORT_HEAD; i < listob.size(); i++)
        {
            List<Object> lo = listob.get(i);
            if(lo.size()<34) break;
            Object col_1 = lo.get(1);    //单位名称
            Object col_2 = lo.get(2);    //专利名称
            Object col_3 = lo.get(3);    //专利号
            Object col_4 = lo.get(4);    //申请类型
            if(checkIfBlank(col_1)&&checkIfBlank(col_2)&&checkIfBlank(col_3)&&checkIfBlank(col_4)) break;
            Object col_5 = lo.get(5);    //专利类别
            Object col_7 = lo.get(7);    //申请日期
            Object col_10 = lo.get(10);  //申请人
            Object col_11 = lo.get(11);  //发明人
            Object col_12 = lo.get(12);  //项目背景
            Object col_16 = lo.get(16);  //应用技术领域
            Object col_22 = lo.get(22);  //法律状态
            Object col_23 = lo.get(23);  //变更日期
            Object col_33 = lo.get(33);  //专业转化应用

            // 必填项和字典值校验
            if(checkIfBlank(col_1))
            {
                sb.append("第"+(i+2)+"行单位名称为空,");
                break;
            }
            if(checkIfBlank(col_2))
            {
                sb.append("第"+(i+2)+"行专利名称为空,");
                break;
            }
            if(checkIfBlank(col_3))
            {
                sb.append("第"+(i+2)+"行专利号为空,");
                break;
            }

            if(checkIfBlank(col_4))
            {
                sb.append("第"+(i+2)+"行申请类型为空,");
                break;
            }else if(!checkIfReasonable(String.valueOf(col_4),ROOT_KJPT_SQLX)){
                sb.append("第"+(i+2)+"行申请类型取值非法,请参考对应sheet页取值!");
                break;
            }

            if(checkIfBlank(col_5))
            {
                sb.append("第"+(i+2)+"行专利类别为空,");
                break;

            }else if(!checkIfReasonable(String.valueOf(col_5),ROOT_KJPT_ZLZL)){
                sb.append("第"+(i+2)+"行专利类别取值非法,请参考对应sheet页取值!");
                break;
            }

            if(checkIfBlank(col_7))
            {
                sb.append("第"+(i+2)+"行申请日期为空,");
                break;
            }

            if(checkIfBlank(col_10))
            {
                sb.append("第"+(i+2)+"行申请人为空,");
                break;
            }

            if(checkIfBlank(col_11))
            {
                sb.append("第"+(i+2)+"行发明人为空,");
                break;
            }

            if(checkIfBlank(col_12))
            {
                sb.append("第"+(i+2)+"行项目背景为空,");
                break;
            }else if(!checkProjectBackgroundIfExists(String.valueOf(col_12))){
                sb.append("第"+(i+2)+"行项目背景取值非法,请参考对应sheet页取值!");
                break;
            }

            if(checkIfBlank(col_16))
            {
                sb.append("第"+(i+2)+"行应用技术领域为空,");
                break;
            } else if(!checkIfReasonable(String.valueOf(col_16),ROOT_KJPT_YYJSLYJSLJSL)){
                if(!checkIfReasonable(String.valueOf(col_16),ROOT_KJPT_YYJSLYJSL_HKXJS)){
                    sb.append("第"+(i+2)+"行应用技术领域取值非法,请参考对应sheet页取值!");
                    break;
                }
            }

            if(checkIfBlank(col_22))
            {
                sb.append("第"+(i+2)+"行法律状态为空,");
                break;
            }else if(!checkIfReasonable(String.valueOf(col_22),ROOT_KJPT_FLZT)){
                sb.append("第"+(i+2)+"行法律状态取值非法,请参考对应sheet页取值!");
                break;
            }

            if(checkIfBlank(col_23))
            {
                sb.append("第"+(i+2)+"行变更日期为空,");
                break;
            }

            if(checkIfBlank(col_33))
            {
                sb.append("第"+(i+2)+"行专业转化应用为空,");
                break;
            }

            if(!checkIfBlank(lo.get(6))){
                if(!checkIfReasonable(String.valueOf(lo.get(6)),ROOT_KJPT_GJ)){
                    sb.append("第"+(i+2)+"行国别组织取值非法,请参考对应sheet页取值!");
                    break;
                }
            }

            if(!checkIfBlank(lo.get(17))){
                if(!checkIfReasonable(String.valueOf(lo.get(17)),ROOT_KJPT_YYJSLYCPL)){
                    if(!checkIfReasonable(String.valueOf(lo.get(17)),ROOT_KJPT_YYJSLYCPL_HNYHJSYY)){
                        sb.append("第"+(i+2)+"行应用技术领域（产品类）取值非法,请参考对应sheet页取值!");
                        break;
                    }

                }
            }



        }
        resultsDate.setMessage(sb.toString());
        if((sb.toString()).equals(""))
        {
            resultsDate.setSuccess(true);
        }else
        {
            resultsDate.setSuccess(false);
        }
        return resultsDate;
    }

    private Boolean checkIfBlank(Object o){
        if(o==null) return true;
        if(String.valueOf(o)=="") return true;
        return false;
    }

    private String getReportTypeFromQueryString(String queryString){
        String[] querys = queryString.split("=");
        return querys[1];
    }

    private Boolean checkIfReasonable(String content,String dictCode){
        //导入的数据确认用户只输入一个字典值20200605
        //针对模板中使用到的字典数据进行缓存
        Map<String,String> detailDicMap;
        if(dictMap.containsKey(dictCode)){
            detailDicMap = dictMap.get(dictCode);
            if(detailDicMap.containsKey(content)) return  true;
        }else{
            detailDicMap = new HashMap<>();
            dictMap.put(dictCode,detailDicMap);
        }

        List<SysDictionary> sysDictionaryList=    EquipmentUtils.getSysDictionaryListByParentCode(dictCode, restTemplate, httpHeaders);
        for(SysDictionary dictionary:sysDictionaryList){
            if(content.equals(dictionary.getName())) {
                Map<String,String> temp = dictMap.get(dictCode);
                temp.put(content,dictionary.getNumValue());
                dictMap.put(dictCode,temp);
                return true;
            }
        }
        return  false;
    }

    public String getDictNumValueByDictCodeAndName(String dictCode,String name){
        List<SysDictionary> sysDictionaryList = EquipmentUtils.getSysDictionaryListByParentCode(dictCode, restTemplate, httpHeaders);
        for(SysDictionary dictionary:sysDictionaryList){
            if(name.equals(dictionary.getName())) {
                return dictionary.getNumValue();
            }
        }
        return "";
    }

    private String getValueFromDictMap(String name,String dictCode){
        if(StringUtils.isNotBlank(name)&&StringUtils.isNotBlank(dictCode)){
            Map<String,String> detail = dictMap.get(dictCode);
            return detail.get(name);
        }
        return "null";
    }


    //查看项目背景是否存在
    private Boolean checkProjectBackgroundIfExists(String name){

        List<SysDictionary> sysDictionaryList=    EquipmentUtils.getSysDictionaryListLikeParentCode(ROOT_KJPT_XMBJ, restTemplate, httpHeaders);
        for(SysDictionary dictionary:sysDictionaryList){
            if(name.equals(dictionary.getName())) {
                projectbckMap.put(name,dictionary.getNumValue());
                return true;
            }
        }
        return false;
    }

}
