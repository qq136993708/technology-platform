package com.pcitc.web.controller.computersoftware;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.Result;
import com.pcitc.base.computersoftware.ComputerSoftware;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.trademarkinfo.TrademarkInfo;
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
import javax.ws.rs.GET;
import java.io.InputStream;
import java.util.*;


@Api(value = "computerSoftware-api", description = "计算机软件接口")
@RestController
@RequestMapping(value = "/ComputerSoftware")
public class ComputerSoftwareController extends RestBaseController {

    /**
     * 根据ID获取对象信息
     */
    private static final String load = "http://kjpt-zuul/stp-proxy/computerSoftware-api/load/";
    /**
     * 查询平台列表
     */
    private static final String query = "http://kjpt-zuul/stp-proxy/computerSoftware-api/query";
    /**
     * 保存平台
     */
    private static final String save = "http://kjpt-zuul/stp-proxy/computerSoftware-api/save";
    /**
     * 导出
     */
    private static final String queryNoPage = "http://kjpt-zuul/stp-proxy/computerSoftware-api/queryNoPage";
    /**
     * 删除
     */
    private static final String delete = "http://kjpt-zuul/stp-proxy/computerSoftware-api/delete/";
    /**
     * 统计查询
     */
    private static final String countByCopyrightGetway = "http://kjpt-zuul/stp-proxy/computerSoftware-api/countByCopyrightGetway";

    /**
     * 导入模板头部所占行数
     */
    private static final Integer IMPORT_HEAD = 3;

    private static final String COMPUTER_SOFTWARE_EXCEL_INPUT = "http://kjpt-zuul/stp-proxy/computerSoftware-api/excel_input";

    @ApiOperation(value = "读取")
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ComputerSoftware load(@PathVariable String id) {
        ResponseEntity<ComputerSoftware> responseEntity = this.restTemplate.exchange(load + id, HttpMethod.GET, new HttpEntity(this.httpHeaders), ComputerSoftware.class);
        return responseEntity.getBody();
    }


    @ApiOperation(value = "查询计算机软件列表", notes = "查询计算机软件列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "unitName", value = "单位名称", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "registerNumber", value = "登记号", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "softwareName", value = "软件名称", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "softwareIntroduce", value = "软件介绍", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "copyrightOwner", value = "著作权人", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "versionNumber", value = "版本号", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "recordDate", value = "登记日期", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "softwareIntro", value = "软件简介", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "entryPeople", value = "录入人", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "entryTime", value = "录入时间", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "notes", value = "备注", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "file", value = "附件上传", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "technicalField", value = "技术领域id", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "technicalFieldValue", value = "技术领域值", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "createUnitId", value = "创建单位id", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "createUnitName", value = "创建单位名称", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "secretLevel", value = "密级", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "registerDepartment", value = "登记部门", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "copyrightGetway", value = "权利取得方式", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "projectName", value = "项目名称", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "projectCode", value = "项目编码", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "topicDepartment", value = "立项部门", dataType = "string", paramType = "query")


    })

    @GetMapping(value = "/query")
    @ResponseBody
    public PageInfo query(

            @RequestParam(required = false) Integer pageNum,
            @RequestParam(required = false) Integer pageSize,
            @RequestParam(required = false) String unitName,
            @RequestParam(required = false) String registerNumber,
            @RequestParam(required = false) String softwareName,
            @RequestParam(required = false) String softwareIntroduce,
            @RequestParam(required = false) String copyrightOwner,
            @RequestParam(required = false) String versionNumber,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date recordDate,
            @RequestParam(required = false) String softwareIntro,
            @RequestParam(required = false) String entryPeople,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date entryTime,
            @RequestParam(required = false) String notes,
            @RequestParam(required = false) String file,
            @RequestParam(required = false) String technicalField,
            @RequestParam(required = false) String technicalFieldValue,
            @RequestParam(required = false, value = "createUnitId") String createUnitId,
            @RequestParam(required = false, value = "createUnitName") String createUnitName,
            @RequestParam(required = false, value = "secretLevel") String secretLevel,
            @RequestParam(required = false, value = "registerDepartment") String registerDepartment,
            @RequestParam(required = false, value = "copyrightGetway") String copyrightGetway,
            @RequestParam(required = false, value = "projectName") String projectName,
            @RequestParam(required = false, value = "projectCode") String projectCode,
            @RequestParam(required = false, value = "topicDepartment") String topicDepartment

    ) {
        Map<String, Object> condition = new HashMap<>(6);

        this.setParam(condition, "pageNum", pageNum);
        this.setParam(condition, "pageSize", pageSize);

        if (!StringUtils.isEmpty(unitName)) {
            this.setParam(condition, "unitName", unitName);
        }
        if (!StringUtils.isEmpty(registerNumber)) {
            this.setParam(condition, "registerNumber", registerNumber);
        }
        if (!StringUtils.isEmpty(softwareName)) {
            this.setParam(condition, "softwareName", softwareName);
        }
        if (!StringUtils.isEmpty(softwareIntroduce)) {
            this.setParam(condition, "softwareIntroduce", softwareIntroduce);
        }
        if (!StringUtils.isEmpty(copyrightOwner)) {
            this.setParam(condition, "copyrightOwner", copyrightOwner);
        }
        if (!StringUtils.isEmpty(versionNumber)) {
            this.setParam(condition, "versionNumber", versionNumber);
        }
        if (!StringUtils.isEmpty(DateUtil.format(recordDate, DateUtil.FMT_SS))) {
            this.setParam(condition, "recordDate", DateUtil.format(recordDate, DateUtil.FMT_SS));
        }
        if (!StringUtils.isEmpty(softwareIntro)) {
            this.setParam(condition, "softwareIntro", softwareIntro);
        }
        if (!StringUtils.isEmpty(entryPeople)) {
            this.setParam(condition, "entryPeople", entryPeople);
        }
        if (entryTime != null) {
            this.setParam(condition, "entryTime", entryTime);
        }
        if (!StringUtils.isEmpty(notes)) {
            this.setParam(condition, "notes", notes);
        }
        if (!StringUtils.isEmpty(file)) {
            this.setParam(condition, "file", file);
        }

        if (!StringUtils.isEmpty(technicalField)) {
            this.setParam(condition, "technicalField", technicalField);
        }

        if (!StringUtils.isEmpty(technicalFieldValue)) {
            this.setParam(condition, "technicalFieldValue", technicalFieldValue);
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

        if (registerDepartment != null) {
            this.setParam(condition, "registerDepartment", registerDepartment);
        }

        if (copyrightGetway != null) {
            this.setParam(condition, "copyrightGetway", copyrightGetway);
        }

        if (projectName != null) {
            this.setParam(condition, "projectName", projectName);
        }

        if (projectCode != null) {
            this.setParam(condition, "projectCode", projectCode);
        }

        if (topicDepartment != null) {
            this.setParam(condition, "topicDepartment", topicDepartment);
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
            @ApiImplicitParam(name = "unitName", value = "单位名称", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "registerNumber", value = "登记号", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "softwareName", value = "软件名称", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "copyrightOwner", value = "著作权人", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "versionNumber", value = "版本号", dataType = "string", paramType = "query")
    })

    @GetMapping(value = "/exportExcel")
    @ResponseBody
    public void exportExcel(
            @RequestParam(required = false) String unitName,
            @RequestParam(required = false) String registerNumber,
            @RequestParam(required = false) String softwareName,
            @RequestParam(required = false) String copyrightOwner,
            @RequestParam(required = false) String versionNumber

    ) throws Exception {
        Map<String, Object> condition = new HashMap<>(6);


        if (!StringUtils.isEmpty(unitName)) {
            this.setParam(condition, "unitName", unitName);
        }
        if (!StringUtils.isEmpty(registerNumber)) {
            this.setParam(condition, "registerNumber", registerNumber);
        }
        if (!StringUtils.isEmpty(softwareName)) {
            this.setParam(condition, "softwareName", softwareName);
        }
        if (!StringUtils.isEmpty(copyrightOwner)) {
            this.setParam(condition, "copyrightOwner", copyrightOwner);
        }
        if (!StringUtils.isEmpty(versionNumber)) {
            this.setParam(condition, "versionNumber", versionNumber);
        }
        this.setBaseParam(condition);

        String[] headers = { "单位名称",  "登记号",    "软件名称"  , "著作权人","版本号","登记日期","软件简介"};
        String[] cols =    {"unitNameText","registerNumber","softwareName","copyrightOwner","versionNumber","recordDate","softwareIntro"};
        ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(queryNoPage, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), JSONArray.class);
        List list = JSONObject.parseArray(responseEntity.getBody().toJSONString(), ComputerSoftware.class);
        String fileName = "软件著作权明细表_"+ DateFormatUtils.format(new Date(), "ddhhmmss");
        this.exportExcel(headers,cols,fileName,list);
    }

    @ApiOperation(value = "保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ComputerSoftware save(@RequestBody ComputerSoftware cs) {
        if(cs!=null){
            SysUser sysUserInfo = this.getUserProfile();
            cs.setEntryPeople(sysUserInfo.getUserId());
        }
        this.setBaseData(cs);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<ComputerSoftware> responseEntity = this.restTemplate.exchange(save, HttpMethod.POST, new HttpEntity<ComputerSoftware>(cs, this.httpHeaders), ComputerSoftware.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value = "删除")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Integer delete(@PathVariable String id) {
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(delete + id, HttpMethod.DELETE, new HttpEntity(this.httpHeaders), Integer.class);
        return responseEntity.getBody();
    }

    /**
     * 统计查询
     *
     * @return PatentInfo
     */
    @ApiOperation(value="统计查询")
    @RequestMapping(value = "/countByCopyrightGetway", method = RequestMethod.GET)
    @ResponseBody
    public List countByCopyrightGetway() {
        Map<String, Object> condition = new HashMap<>(6);
        SysUser sysUserInfo = this.getUserProfile();
        String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(sysUserInfo.getDataScopeUnitPath(), restTemplate, httpHeaders);
        this.setParam(condition,"childUnitIds",childUnitIds);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<List> responseEntity = this.restTemplate.exchange(countByCopyrightGetway, HttpMethod.POST, new HttpEntity<Map>(condition,this.httpHeaders),List.class);
        return responseEntity.getBody();

    }


    @ApiOperation(value = "初始化")
    @RequestMapping(value = "/newInit", method = RequestMethod.GET)
    @ResponseBody
    public ComputerSoftware newInit() {
        ComputerSoftware p = new ComputerSoftware();
        p.setId(UUID.randomUUID().toString().replace("_", ""));
        p.setDeleted("0");  //删除标识
        p.setCreateDate(new Date());  // 创建时间
        p.setCreator(this.getUserProfile().getUserName());
        p.setEntryTime(new Date());
        return p;
    }


    @ApiOperation(value = "根据模板导入软件著作权信息（EXCEL）", notes = "根据模板导入集团发布信息（EXCEL）")
    @RequestMapping(value = "/input_excel", method = RequestMethod.POST)
    public Object newImportData(HttpServletRequest req, HttpServletResponse resp, MultipartFile file) throws Exception
    {
        Result resultsDate = new Result();
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
            List<ComputerSoftware> list = new ArrayList<ComputerSoftware>();
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
                    ComputerSoftware obj = new ComputerSoftware();

                  /*  obj.setReportType(type);
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
                    list.add(obj);*/
                }
                ResponseEntity<Result> responseEntity =  this.restTemplate.exchange(COMPUTER_SOFTWARE_EXCEL_INPUT, HttpMethod.POST, new HttpEntity<Object>(list, this.httpHeaders), Result.class);
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

}
