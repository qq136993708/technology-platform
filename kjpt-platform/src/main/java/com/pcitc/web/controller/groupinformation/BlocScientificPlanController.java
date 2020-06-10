package com.pcitc.web.controller.groupinformation;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.Result;
import com.pcitc.base.computersoftware.ComputerSoftware;
import com.pcitc.base.groupinformation.BlocScientificPlan;
import com.pcitc.base.scientificplan.SciencePlan;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.*;

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

    /**
     * 导出
     */
    private static final String queryNoPage = "http://kjpt-zuul/stp-proxy/blocScientificPlan-api/queryNoPage";

    private static final String BLOC_SCIENTIFIC_PLAN_EXCEL_INPUT = "http://kjpt-zuul/stp-proxy/blocScientificPlan-api/excel_input";

    /**
     * 导入模板头部所占行数
     */
    private static final Integer IMPORT_HEAD = 3;

    private static final String GET_UNIT_ID = "http://kjpt-zuul/system-proxy/unit-provider/unit/getUnitId_by_name";

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
            @ApiImplicitParam(name = "createUnitName", value = "创建单位名称", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "secretLevel", value = "密级", dataType = "string", paramType = "query")

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
            @RequestParam(required = false, value = "createUnitName") String createUnitName,

            @RequestParam(required = false, value = "secretLevel") String secretLevel

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

        if (secretLevel != null) {
            this.setParam(condition, "secretLevel", secretLevel);
        }

        this.setBaseParam(condition);
        SysUser sysUserInfo = this.getUserProfile();
//        String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(sysUserInfo.getDataScopeUnitPath(), restTemplate, httpHeaders);
        this.setParam(condition,"userUnitId",sysUserInfo.getUnitId());

        //userUnitId


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
        SysUser user = this.getUserProfile();
        p.setId(UUID.randomUUID().toString().replace("_", ""));
        p.setDeleted("0");  //删除标识
        p.setCreateDate(new Date());  // 创建时间
        p.setCreator(user.getUserName());
        p.setPublishUser(user.getUserName());
        return p;
    }

    @ApiOperation(value = "导出", notes = "导出")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "名称", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "publication", value = "发布处室", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "annual", value = "年度/月度", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "releaseTime", value = "发布日期", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "reportType", value = "类型", dataType = "string", paramType = "query")
    })

    @GetMapping(value = "/exportExcel")
    @ResponseBody
    public void exportExcel(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String publication,
            @RequestParam(required = false) String annual,
            @RequestParam(required = false) String releaseTime,
            @RequestParam(required = false) String reportType

    ) throws Exception {
        Map<String, Object> condition = new HashMap<>(6);
        if (!StringUtils.isEmpty(reportType)) {
            this.setParam(condition, "reportType", reportType);
        }

        if (!StringUtils.isEmpty(name)) {
            this.setParam(condition, "name", name);
        }
        if (!StringUtils.isEmpty(publication)) {
            this.setParam(condition, "publication", publication);
        }
        if (!StringUtils.isEmpty(annual)) {
            this.setParam(condition, "annual", annual);
        }
        if (!StringUtils.isEmpty(releaseTime)) {
            this.setParam(condition, "releaseTime", releaseTime);
        }

        this.setBaseParam(condition);
        String[] headers = { "名称","发布处室","发布日期","年度/月度"};
        String[] cols =    {"name","publication","releaseTime","annual"};
        ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(queryNoPage, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), JSONArray.class);
        List list = JSONObject.parseArray(responseEntity.getBody().toJSONString(), BlocScientificPlan.class);
        String fileName = "集团信息发布_"+reportType+"_明细表_"+ DateFormatUtils.format(new Date(), "ddhhmmss");
        this.exportExcel(headers,cols,fileName,list);
    }


    @ApiOperation(value = "根据模板导入集团发布信息（EXCEL）", notes = "根据模板导入集团发布信息（EXCEL）")
    @RequestMapping(value = "/input_excel", method = RequestMethod.POST)
    public Object newImportData(HttpServletRequest req, HttpServletResponse resp, MultipartFile file) throws Exception
    {
        Result resultsDate = new Result();
        String type = req.getQueryString();
        if(StringUtils.isBlank(type)){
            resultsDate.setSuccess(false);
            resultsDate.setMessage("未能获取集团发布信息类型，请重试");
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
            List<BlocScientificPlan> list = new ArrayList<BlocScientificPlan>();
            resultsDate= getResult( listob );
            if(resultsDate.isSuccess()==true)
            {
                for (int i = IMPORT_HEAD; i < listob.size(); i++)
                {
                    List<Object> lo = listob.get(i);

                    Object col_1 = lo.get(1);//名称
                    Object col_2 = lo.get(2);//发布处室
                    Object col_3 = lo.get(3);//年度/月度
                    Object col_4 = lo.get(4);//发布日期

                    if(checkIfBlank(col_1)&&checkIfBlank(col_2)&&checkIfBlank(col_3)&&checkIfBlank(col_4)) break;

                    //将excel导入数据转换为SciencePlan对象
                    BlocScientificPlan obj = new BlocScientificPlan();

                    obj.setReportType(type);
                    obj.setCreateUnitId(sysUserInfo.getUnitId());
                    obj.setName(String.valueOf(col_1));
                   obj.setPublication(String.valueOf(col_2));
                    Date annual = DateUtil.strToDate(String.valueOf(col_3),DateUtil.FMT_DD);
                    Date releaseTime = DateUtil.strToDate(String.valueOf(col_4),DateUtil.FMT_DD);
                    obj.setAnnual(annual);
                    obj.setPubdate(releaseTime);
                    String dateid = UUID.randomUUID().toString().replaceAll("-", "");
                    obj.setId(dateid);
                    obj.setSecretLevel("0");
                    list.add(obj);
                }
                ResponseEntity<Result> responseEntity =  this.restTemplate.exchange(BLOC_SCIENTIFIC_PLAN_EXCEL_INPUT, HttpMethod.POST, new HttpEntity<Object>(list, this.httpHeaders), Result.class);
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

            if(checkIfBlank(col_1)&&checkIfBlank(col_2)&&checkIfBlank(col_3)&&checkIfBlank(col_4)) break;

            if(col_1==null)
            {
                sb.append("第"+(i+1)+"行名称为空,");
            }else if(col_2==null)
            {
                sb.append("第"+(i+1)+"行发布处室为空,");
            }else if(col_3==null)
            {
                sb.append("第"+(i+1)+"行年度/月度为空,");
            }else if(col_4==null)
            {
                sb.append("第"+(i+1)+"行发布日期为空,");
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




}
