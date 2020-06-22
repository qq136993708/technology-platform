package com.pcitc.web.controller.scientificplan;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;

import com.pcitc.base.common.Constant;
import com.pcitc.base.common.Result;
import com.pcitc.base.computersoftware.ComputerSoftware;
import com.pcitc.base.expert.ZjkBase;
import com.pcitc.base.scientificplan.SciencePlan;
import com.pcitc.base.stp.techFamily.TechFamily;
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
import org.apache.ibatis.annotations.Param;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
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


    private static final String SCIENCE_PLAN_EXCEL_INPUT = "http://kjpt-zuul/stp-proxy/sciencePlan-api/excel_input";

    /**
     * 导入模板头部所占行数
     */
    private static final Integer IMPORT_HEAD = 3;

    private static final String GET_UNIT_ID = "http://kjpt-zuul/system-proxy/unit-provider/unit/getUnitId_by_name";

    //用于缓存导入时的字典数据
    private Map<String,Map<String,String>> dictMap = new HashMap<>();

    private static final String ROOT_KJPT_JSLY = "ROOT_KJPT_JSLY";

    /**
     * 根据技术领域名称获取技术领域详情
     */
    private static final String getTechFamilyByName   ="http://kjpt-zuul/stp-proxy/tech-family-provider/selectTechFamilyTypeListByName";
    //用于缓存导入时的技术领域id
    private Map<String,TechFamily> techMap = new HashMap<>();



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
        String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(sysUserInfo.getDataScopeUnitPath(), restTemplate, httpHeaders);
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

        String[] headers = null;
        String[] cols = null;
        switch (reportType){
            case "1":
                  headers = new String[]{"科技规划名称", "申报单位", "技术领域", "年度/月度","发布日期"};
                  cols = new String[]{"name", "authenticateUtil", "technicalFieldName", "annual", "releaseTime"};
                break;
            case "2":
                headers = new String[]{"工作要点名称", "申报单位", "技术领域","发布日期", "年度/月度"};
                cols = new String[]{"name", "authenticateUtil", "technicalFieldName", "releaseTime", "annual"};
                break;
            case "3":
                headers = new String[]{"科技进展名称", "申报单位", "技术领域","发布日期", "年度/月度"};
                cols = new String[]{"name", "authenticateUtil", "technicalFieldName", "releaseTime", "annual"};
            case "4":
                headers = new String[]{"年度总结名称", "申报单位", "技术领域","发布日期", "年度/月度"};
                cols = new String[]{"name", "authenticateUtil", "technicalFieldName", "releaseTime", "annual"};
            case "5":
                headers = new String[]{"研究报告名称", "申报单位", "技术领域","发布日期", "年度/月度"};
                cols = new String[]{"name", "authenticateUtil", "technicalFieldName", "releaseTime", "annual"};
        }



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


    @ApiOperation(value = "根据模板导入科技材料（EXCEL）", notes = "根据模板导入科技材料（EXCEL）")
    @RequestMapping(value = "/input_excel", method = RequestMethod.POST)
    public Object newImportData(HttpServletRequest req, HttpServletResponse resp, MultipartFile file) throws Exception
    {
        Result resultsDate = new Result();
        String type = req.getQueryString();
        if(StringUtils.isBlank(type)){
            resultsDate.setSuccess(false);
            resultsDate.setMessage("未能获取科技材料类型，请重试");
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
            List<SciencePlan> list = new ArrayList<SciencePlan>();
            resultsDate= getResult( listob );
            if(resultsDate.isSuccess()==true)
            {
                for (int i = IMPORT_HEAD; i < listob.size(); i++)
                {
                    List<Object> lo = listob.get(i);

                    Object col_1 = lo.get(1);//名称
                    Object col_2 = lo.get(2);//申报单位
                    Object col_3 = lo.get(3);//技术领域
                    Object col_4 = lo.get(4);//年度/月度
                    Object col_5 = lo.get(5);//发布日期

                    if(checkIfBlank(col_1)&&checkIfBlank(col_2)&&checkIfBlank(col_3)&&checkIfBlank(col_4)&&checkIfBlank(col_5)) break;

                    //将excel导入数据转换为SciencePlan对象
                    SciencePlan obj = new SciencePlan();

                    obj.setReportType(type);
                    obj.setCreateUnitId(sysUserInfo.getUnitId());
                   // obj.setAuthenticateUtil(getAuthenticateUtilByName(String.valueOf(col_2)));

                   // obj.setAuthenticateUtil(restTemplate.exchange(GET_UNIT_ID, HttpMethod.POST, new HttpEntity<Object>(lo.get(2),this.httpHeaders), String.class).getBody());
                    obj.setAuthenticateUtil(String.valueOf(col_2));
                    obj.setAuthenticateUitlText(String.valueOf(col_2));
                    obj.setName(String.valueOf(col_1));

                    String techName = String.valueOf(col_3);
                    TechFamily techFamily = techMap.get(techName);
                    if(techFamily != null){
                        obj.setResearchField(techFamily.getTypeCode());
                        obj.setTechnicalFieldIndex(techFamily.getTypeIndex());
                        obj.setTechnicalFieldName(techFamily.getTypeName());
                    }

                    Date annual = DateUtil.strToDate(String.valueOf(col_4),DateUtil.FMT_DD);
                    Date releaseTime = DateUtil.strToDate(String.valueOf(col_5),DateUtil.FMT_DD);
                    obj.setAnnual(annual);
                    obj.setReleaseTime(releaseTime);
                    String dateid = UUID.randomUUID().toString().replaceAll("-", "");
                    obj.setId(dateid);
                    obj.setSecretLevel("0");
                    list.add(obj);
                }
                ResponseEntity<Result> responseEntity =  this.restTemplate.exchange(SCIENCE_PLAN_EXCEL_INPUT, HttpMethod.POST, new HttpEntity<Object>(list, this.httpHeaders), Result.class);
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
            }

        }
        return resultsDate;
    }


    private String getAuthenticateUtilByName(String name){

        String authenticateUtil = "";
        try {
            authenticateUtil =  EquipmentUtils.getUnitByUnitName(name,restTemplate,httpHeaders);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authenticateUtil;
    }

    private Result getResult(List<List<Object>> listob )
    {
        Result resultsDate = new Result();
        resultsDate.setSuccess(true);
        StringBuffer sb=new StringBuffer();
        for (int i = IMPORT_HEAD; i < listob.size(); i++)
        {
            List<Object> lo = listob.get(i);
            Object col_1 = lo.get(1);
            Object col_2 = lo.get(2);
            Object col_3 = lo.get(3);
            Object col_4 = lo.get(4);
            Object col_5 = lo.get(5);

            if(checkIfBlank(col_1)&&checkIfBlank(col_2)&&checkIfBlank(col_3)&&checkIfBlank(col_4)&&checkIfBlank(col_5)) break;

            if(col_1==null)
            {
                sb.append("第"+(i+1)+"行名称为空,");
                break;
            }
            if(col_2==null)
            {
                sb.append("第"+(i+1)+"行申报单位为空,");
                break;
            }
            if(col_3==null)
            {
                sb.append("第"+(i+1)+"行技术领域为空,");
                break;
            }else  if(!checkTechIfExists(String.valueOf(col_3))){
               sb.append("第"+(i+2)+"行技术领域取值非法,请参考对应sheet页取值!");
               break;
            }

            if(col_4==null)
            {
                sb.append("第"+(i+1)+"行年度/月度为空,");
                break;
            }
            if(col_5==null)
            {
                sb.append("第"+(i+1)+"行发布日期为空,");
                break;
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

    private String getValueFromDictMap(String name,String dictCode){
        if(StringUtils.isNotBlank(name)&&StringUtils.isNotBlank(dictCode)){
            Map<String,String> detail = dictMap.get(dictCode);
            return detail.get(name);
        }
        return "null";
    }

    //查看技术领域是否存在
    private Boolean checkTechIfExists(String name){

        // List<TechFamily> techFamily =  restTemplate.exchange(getTechFamilyByName, HttpMethod.POST, new HttpEntity<Object>(name,this.httpHeaders), List.class).getBody();
        ParameterizedTypeReference<List<TechFamily>> typeRef = new ParameterizedTypeReference<List<TechFamily>>() {

        };

        ResponseEntity<List<TechFamily>> responseEntity =  restTemplate.exchange(getTechFamilyByName, HttpMethod.POST, new HttpEntity<Object>(name,this.httpHeaders), typeRef);

        List<TechFamily> techFamily = responseEntity.getBody();

        if(techFamily.size()==1){
            techMap.put(name,techFamily.get(0));
            return true;
        }
        return false;
    }


}
