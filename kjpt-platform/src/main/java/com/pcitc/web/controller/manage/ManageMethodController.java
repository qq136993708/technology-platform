package com.pcitc.web.controller.manage;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.Result;
import com.pcitc.base.groupinformation.BlocScientificPlan;
import com.pcitc.base.manage.ManageMethod;
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

/**
 * <p>管理办法</p>
 * @author
 */
@Api(value = "manageMethod-api", description = "管理办法")
@RestController
public class ManageMethodController extends RestBaseController {


    /**
     * 根据ID获取对象信息
     */
    private static final String load = "http://kjpt-zuul/stp-proxy/manageMethod-api/load/";
    /**
     * 查询列表
     */
    private static final String query = "http://kjpt-zuul/stp-proxy/manageMethod-api/query";
    /**
     * 保存
     */
    private static final String save = "http://kjpt-zuul/stp-proxy/manageMethod-api/save";
    /**
     * 删除
     */
    private static final String delete = "http://kjpt-zuul/stp-proxy/manageMethod-api/delete/";
    /**
     * 导出
     */
    private static final String queryNoPage = "http://kjpt-zuul/stp-proxy/manageMethod-api/queryNoPage";

    /**
     * 导入模板头部所占行数
     */
    private static final Integer IMPORT_HEAD = 3;

    private static final String MANAGE_METHOD_EXCEL_INPUT = "http://kjpt-zuul/stp-proxy/manageMethod-api/excel_input";




    @ApiOperation(value="读取")
    @RequestMapping(value = "/manageMethod-api/load/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ManageMethod load(@PathVariable String id) {
        ResponseEntity<ManageMethod> responseEntity = this.restTemplate.exchange(load+id, HttpMethod.GET, new HttpEntity(this.httpHeaders), ManageMethod.class);
        return responseEntity.getBody();
    }




    @ApiOperation(value = "查询列表", notes = "查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "publishDate", value = "发布日期", dataType = "Date", paramType = "query"),
            @ApiImplicitParam(name = "methodName", value = "名称", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "edition", value = "版次", dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/manageMethod-api/query", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo query(
            @RequestParam(required = false,value = "pageNum") Integer pageNum,
            @RequestParam(required = false,value = "pageSize") Integer pageSize,
            @RequestParam(required = false,value = "methodName") String methodName,
            @RequestParam(required = false,value = "publishDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date publishDate,
            @RequestParam(required = false,value = "edition") String edition
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
        if (!StringUtils.isEmpty(DateUtil.format(publishDate,DateUtil.FMT_SS))) {
            this.setParam(condition, "publishDate", DateUtil.format(publishDate,DateUtil.FMT_SS));
        }
        if (!StringUtils.isEmpty(methodName)) {
            this.setParam(condition, "methodName", methodName);
        }
        if (!StringUtils.isEmpty(edition)) {
            this.setParam(condition, "edition", edition);
        }

        String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(sysUserInfo.getDataScopeUnitPath(), restTemplate, httpHeaders);
        this.setParam(condition,"childUnitIds",childUnitIds);
        this.setBaseParam(condition);

        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<PageInfo> responseEntity = this.restTemplate.exchange(query, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), PageInfo.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value="保存")
    @RequestMapping(value = "/manageMethod-api/save", method = RequestMethod.POST)
    @ResponseBody
    public void save(@RequestBody ManageMethod am){
        this.setBaseData(am);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        this.restTemplate.exchange(save, HttpMethod.POST, new HttpEntity<ManageMethod>(am, this.httpHeaders), ManageMethod.class);
    }


    @ApiOperation(value="删除")
    @RequestMapping(value = "/manageMethod-api/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable String id) {
        this.restTemplate.exchange(delete+id, HttpMethod.DELETE, new HttpEntity(this.httpHeaders), Integer.class);
    }


    @ApiOperation(value="初始化")
    @RequestMapping(value = "/manageMethod-api/newInit", method = RequestMethod.GET)
    @ResponseBody
    public ManageMethod newInit() {
        ManageMethod a = new ManageMethod();
        a.setId(UUID.randomUUID().toString().replace("-",""));
        return a;
    }



    @ApiOperation(value = "导出", notes = "导出")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "methodName", value = "管理办法名称", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "edition", value = "版次", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "publishDate", value = "发布日期", dataType = "string", paramType = "query")
    })

    @GetMapping(value = "/manageMethod-api/exportExcel")
    @ResponseBody
    public void exportExcel(
            @RequestParam(required = false) String methodName,
            @RequestParam(required = false) String edition,
            @RequestParam(required = false) String publishDate

    ) throws Exception {
        Map<String, Object> condition = new HashMap<>(6);
        if (!StringUtils.isEmpty(methodName)) {
            this.setParam(condition, "methodName", methodName);
        }

        if (!StringUtils.isEmpty(edition)) {
            this.setParam(condition, "edition", edition);
        }
        if (!StringUtils.isEmpty(publishDate)) {
            this.setParam(condition, "publishDate", publishDate);
        }

        this.setBaseParam(condition);
        String[] headers = { "管理办法名称","版次","发布日期"};
        String[] cols =    {"methodName","edition","publishDate","annual"};
        ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(queryNoPage, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), JSONArray.class);
        List list = JSONObject.parseArray(responseEntity.getBody().toJSONString(), ManageMethod.class);
        String fileName = "管理办法明细表_"+ DateFormatUtils.format(new Date(), "ddhhmmss");
        this.exportExcel(headers,cols,fileName,list);
    }

    @ApiOperation(value = "根据模板导入集团发布信息-管理辦法（EXCEL）", notes = "根据模板导入集团发布信息（EXCEL）")
    @RequestMapping(value = "/manageMethod-api/input_excel", method = RequestMethod.POST)
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
            List<ManageMethod> list = new ArrayList<ManageMethod>();
            resultsDate= getResult( listob );
            if(resultsDate.isSuccess()==true)
            {
                for (int i = IMPORT_HEAD; i < listob.size(); i++)
                {
                    List<Object> lo = listob.get(i);

                    Object col_1 = lo.get(1);//名称
                    Object col_2 = lo.get(2);//版次
                    Object col_3 = lo.get(3);//发布日期


                    if(checkIfBlank(col_1)&&checkIfBlank(col_2)&&checkIfBlank(col_3)) break;

                    //将excel导入数据转换为SciencePlan对象
                    ManageMethod obj = new ManageMethod();

                    obj.setMethodName(String.valueOf(col_1));
                    obj.setEdition(String.valueOf(col_2));
                    Date releaseTime = DateUtil.strToDate(String.valueOf(col_3),DateUtil.FMT_DD);
                    obj.setPublishDate(releaseTime);
                    obj.setCreateUnitId(sysUserInfo.getUnitId());
                    String dateid = UUID.randomUUID().toString().replaceAll("-", "");
                    obj.setId(dateid);
                    obj.setSecretLevel("0");
                    list.add(obj);
                }
                ResponseEntity<Result> responseEntity =  this.restTemplate.exchange(MANAGE_METHOD_EXCEL_INPUT, HttpMethod.POST, new HttpEntity<Object>(list, this.httpHeaders), Result.class);
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

            if(checkIfBlank(col_1)&&checkIfBlank(col_2)&&checkIfBlank(col_3)) break;

            if(col_1==null)
            {
                sb.append("第"+(i+1)+"行名称为空,");
            }else if(col_2==null)
            {
                sb.append("第"+(i+1)+"行发布处室为空,");
            }else if(col_3==null)
            {
                sb.append("第"+(i+1)+"行年度/月度为空,");
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
