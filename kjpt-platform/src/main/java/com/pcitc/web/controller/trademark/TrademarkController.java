package com.pcitc.web.controller.trademark;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.Result;
import com.pcitc.base.patent.PatentInfo;
import com.pcitc.base.stp.techFamily.TechFamily;
import com.pcitc.base.system.SysDictionary;
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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.*;

@Api(value = "trademark-api", description = "商标接口")
@RestController
@RequestMapping("/trademarkController")
public class TrademarkController extends RestBaseController {

    private static final String SAVE = "http://kjpt-zuul/stp-proxy/trademark-provider/trademarkInfo/trademarkInfo_save";

    private static final String QUERY = "http://kjpt-zuul/stp-proxy/trademark-provider/trademarkInfo/trademarkInfo_query";

    private static final String LOAD = "http://kjpt-zuul/stp-proxy/trademark-provider/trademarkInfo/trademarkInfo_load/";

    private static final String DELETE = "http://kjpt-zuul/stp-proxy/trademark-provider/trademarkInfo/trademarkInfo_delete/";

    private static final String queryNoPage = "http://kjpt-zuul/stp-proxy/trademark-provider/trademarkInfo/queryNoPage";

    private static final String countByLawType = "http://kjpt-zuul/stp-proxy/trademark-provider/trademarkInfo/countByLawType";

    private static final String TRADE_MARK_EXCEL_INPUT = "http://kjpt-zuul/stp-proxy/trademark-provider/trademarkInfo/excel_input";

    private static final String GET_UNIT_ID = "http://kjpt-zuul/system-proxy/unit-provider/unit/getUnitId_by_name";

    /**
     * 导入模板头部所占行数
     */
    private static final Integer IMPORT_HEAD = 3;

    //用于缓存导入时的字典数据
    private Map<String,Map<String,String>> dictMap = new HashMap<>();
    //用于缓存导入时的技术领域id
    private Map<String, TechFamily> techMap = new HashMap<>();

    private static final String ROOT_KJPT_SBLX = "ROOT_KJPT_SBLX";

    private static final String ROOT_KJPT_FLZT = "ROOT_KJPT_FLZT(SB)";

    private static final String  YES =  "0";

    private static final String  NO =  "1";

    /**
     * 保存-商标信息
     *
     * @param trademarkInfo
     * @return TrademarkInfo
     */
    @ApiOperation(value="保存商标信息")
    @RequestMapping(value = "/save",method=RequestMethod.POST)
    @ResponseBody
    public TrademarkInfo save(@RequestBody TrademarkInfo trademarkInfo) {
        this.setBaseData(trademarkInfo);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<TrademarkInfo> responseEntity = this.restTemplate.exchange(SAVE, HttpMethod.POST, new HttpEntity<TrademarkInfo>(trademarkInfo, this.httpHeaders), TrademarkInfo.class);
        return responseEntity.getBody();
    }

    /**
     * 商标列表-分页查询
     *
     * @return PageInfo
     */
    @ApiOperation(value = "查询商标列表", notes = "查询商标列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "unitName", value = "单位名称", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "registerDateStart", value = "注册日期开始", dataType = "Date", paramType = "query"),
            @ApiImplicitParam(name = "registerDateEnd", value = "注册日期结束", dataType = "Date", paramType = "query"),
            @ApiImplicitParam(name = "trademarkName", value = "注册商标名称", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "lawStatus", value = "法律状态", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "applicant", value = "申请人", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "extensionPeriod", value = "延展有效期", dataType = "Date", paramType = "query"),
            @ApiImplicitParam(name = "isWellKnown", value = "是否驰名商标", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "isRegistered", value = "是否著名商标", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "countryType", value = "国别", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "secretLevel", value = "秘级", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "tradeMarkType", value = "商标类型", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "wellKnownDate", value = "驰名商标认定日期", dataType = "Date", paramType = "query"),
            @ApiImplicitParam(name = "famousDate", value = "著名商标认定日期", dataType = "Date", paramType = "query"),
            @ApiImplicitParam(name = "registerDate", value = "注册日期", dataType = "Date", paramType = "query"),
            @ApiImplicitParam(name = "effectiveDate", value = "有效期", dataType = "Date", paramType = "query"),
            @ApiImplicitParam(name = "famousOrg", value = "著名商标认定机构", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "wellKnownOrg", value = "驰名商标认定机构", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "registerOrg", value = "注册机构", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "commodityCategory", value = "商标类型", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "applicationNumber", value = "注册号", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "createUnitId", value = "创建单位ID", dataType = "String", paramType = "query")
    })

    @RequestMapping(value = "/query",  method = RequestMethod.GET)
    @ResponseBody
    public PageInfo query(@RequestParam(required = false) Integer pageNum,
                        @RequestParam(required = false) Integer pageSize,
                        @RequestParam(required = false) String unitName,
                        @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date registerDateStart,
                        @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date registerDateEnd,
                        @RequestParam(required = false) String trademarkName,
                        @RequestParam(required = false) String lawStatus,
                        @RequestParam(required = false) String applicant,

                        @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date  extensionPeriod,
                        @RequestParam(required = false) String isWellKnown,
                        @RequestParam(required = false) String isRegistered,
                        @RequestParam(required = false) String countryType,
                        @RequestParam(required = false)  @DateTimeFormat(pattern="yyyy-MM-dd") Date  registerDate,
                        @RequestParam(required = false)  @DateTimeFormat(pattern="yyyy-MM-dd") Date  effectiveDate,

                        @RequestParam(required = false) String tradeMarkType,
                        @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date wellKnownDate,
                        @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date famousDate,
                        @RequestParam(required = false) String wellKnownOrg,
                        @RequestParam(required = false) String famousOrg,
                        @RequestParam(required = false) String registerOrg,
                        @RequestParam(required = false) String commodityCategory,
                        @RequestParam(required = false) String applicationNumber,
                        @RequestParam(required = false,value = "secretLevel") String secretLevel,
                        @RequestParam(required = false,value = "createUnitId") String createUnitId

    ){
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
        if (!StringUtils.isEmpty(DateUtil.format(registerDateStart,DateUtil.FMT_DD))) {
            this.setParam(condition, "registerDateStart", DateUtil.format(registerDateStart,DateUtil.FMT_DD));
        }
        if (!StringUtils.isEmpty(DateUtil.format(registerDateEnd,DateUtil.FMT_DD))) {
            this.setParam(condition, "registerDateEnd", DateUtil.format(registerDateEnd,DateUtil.FMT_DD));
        }
        if (!StringUtils.isEmpty(trademarkName)) {
        this.setParam(condition, "trademarkName", trademarkName);
        }
        if (!StringUtils.isEmpty(createUnitId)) {
        this.setParam(condition, "createUnitId", createUnitId);
        }
        if (!StringUtils.isEmpty(lawStatus) && !"undefined".equals(lawStatus)) {
        this.setParam(condition, "lawStatus", lawStatus);
        }
        if (!StringUtils.isEmpty(applicant)) {
        this.setParam(condition, "applicant", applicant);
        }
        if (!StringUtils.isEmpty(commodityCategory)) {
        this.setParam(condition, "commodityCategory", commodityCategory);
        }
        if (!StringUtils.isEmpty(applicationNumber)) {
        this.setParam(condition, "applicationNumber", applicationNumber);
        }

        
        if (!StringUtils.isEmpty(isWellKnown)) {
            this.setParam(condition, "isWellKnown", isWellKnown);
        }
        if (!StringUtils.isEmpty(isRegistered)) {
            this.setParam(condition, "isRegistered", isRegistered);
        }
        if (!StringUtils.isEmpty(countryType)) {
            this.setParam(condition, "countryType", countryType);
        }
        if (!StringUtils.isEmpty(DateUtil.format(extensionPeriod,DateUtil.FMT_DD))) {
            this.setParam(condition, "extensionPeriod", DateUtil.format(extensionPeriod,DateUtil.FMT_DD));
        }

        if (!StringUtils.isEmpty(tradeMarkType)) {
            this.setParam(condition, "tradeMarkType", tradeMarkType);
        }
        if (!StringUtils.isEmpty(DateUtil.format(wellKnownDate,DateUtil.FMT_DD))) {
            this.setParam(condition, "wellKnownDate", DateUtil.format(wellKnownDate,DateUtil.FMT_DD));
        }
        if (!StringUtils.isEmpty(DateUtil.format(registerDate,DateUtil.FMT_DD))) {
            this.setParam(condition, "registerDate", DateUtil.format(registerDate,DateUtil.FMT_DD));
        }
        if (!StringUtils.isEmpty(DateUtil.format(effectiveDate,DateUtil.FMT_DD))) {
            this.setParam(condition, "effectiveDate", DateUtil.format(effectiveDate,DateUtil.FMT_DD));
        }
        if (!StringUtils.isEmpty(DateUtil.format(famousDate,DateUtil.FMT_DD))) {
            this.setParam(condition, "famousDate", DateUtil.format(famousDate,DateUtil.FMT_DD));
        }
        if (!StringUtils.isEmpty(wellKnownOrg)) {
            this.setParam(condition, "wellKnownOrg", wellKnownOrg);
        }
        if (!StringUtils.isEmpty(famousOrg)) {
            this.setParam(condition, "famousOrg", famousOrg);
        }
        if (!StringUtils.isEmpty(registerOrg)) {
            this.setParam(condition, "registerOrg", registerOrg);
        }

        if(secretLevel != null){
            //this.setParam(condition,"secretLevel",secretLevel);
        }
        this.setBaseParam(condition);
        SysUser sysUserInfo = this.getUserProfile();
        String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(sysUserInfo.getDataScopeUnitPath(), restTemplate, httpHeaders);
        this.setParam(condition,"childUnitIds",childUnitIds);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<PageInfo> responseEntity = this.restTemplate.exchange(QUERY, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), PageInfo.class);
        return responseEntity.getBody();
    }
    /**
     * 导出
     *
     * @return PageInfo
     */
    @ApiOperation(value = "导出", notes = "导出")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "unitName", value = "单位名称", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "trademarkName", value = "注册商标名称", dataType = "String", paramType = "query")
    })

    @RequestMapping(value = "/export",  method = RequestMethod.GET)
    @ResponseBody
    public void query(
                        @RequestParam(required = false) String unitName,
                        @RequestParam(required = false) String trademarkName,
                          @RequestParam(required = false,value = "secretLevel") String secretLevel
    ) throws Exception {
        Map<String, Object> condition = new HashMap<>(6);
            if (!StringUtils.isEmpty(unitName)) {
            this.setParam(condition, "unitName", unitName);
        }
        if (!StringUtils.isEmpty(trademarkName)) {
        this.setParam(condition, "trademarkName", trademarkName);
        }

        if(secretLevel != null){
            this.setParam(condition,"secretLevel",secretLevel);
        }
        this.setBaseParam(condition);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        //String[] headers = { "单位名称",  "注册商标名称",    "商标申请号"  , "注册日期","注册公告日","核定使用商品大类","申请人/注册人","有效日期","法律状态"};
        String[] headers = { "单位名称",  "商标名称",    "注册号"  , "申请人","国际分类号","注册单位","注册日期","有效日期","延展有效期","商标类型"};
        String[] cols =    {"createUnitName","trademarkName","applicationNumber","applicant","countryType","registerOrg","registerDate","effectiveDate","extensionPeriod","tradeMarkTypeText"};
        ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(queryNoPage, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), JSONArray.class);
        List list = JSONObject.parseArray(responseEntity.getBody().toJSONString(), TrademarkInfo.class);
        String fileName = "商标明细表_"+ DateFormatUtils.format(new Date(), "ddhhmmss");
        this.exportExcel(headers,cols,fileName,list);
    }


    /**
     * 根据ID查询商标信息
     *
     * @return TrademarkInfo
     */
    @ApiOperation(value="根据ID查询商标信息")
    @RequestMapping(value = "/load/{id}",method = RequestMethod.GET)
    @ResponseBody
    public TrademarkInfo load(@PathVariable String id) {
        ResponseEntity<TrademarkInfo> responseEntity = this.restTemplate.exchange(LOAD+id, HttpMethod.GET, new HttpEntity(this.httpHeaders), TrademarkInfo.class);
        return responseEntity.getBody();
    }

    /**
     * 删除方法
     *
     * @return Integer
     */
    @ApiOperation(value="删除商标信息")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Integer delete(@PathVariable String id) {
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(DELETE+id, HttpMethod.DELETE, new HttpEntity(this.httpHeaders), Integer.class);
        return responseEntity.getBody();
    }

    /**
     * 初始化方法
     *
     * @return TrademarkInfo
     */
    @ApiOperation(value="初始化商标信息")
    @RequestMapping(value = "/newInit", method = RequestMethod.GET)
    @ResponseBody
    public TrademarkInfo newInit() {
        TrademarkInfo trademarkInfo = new TrademarkInfo();
        trademarkInfo.setId(UUID.randomUUID().toString().replace("-",""));
        trademarkInfo.setDeleted("0");
        return trademarkInfo;
    }


    /**
     * 根据专法律状态查询商标数量
     *
     */
    @ApiOperation(value="根据法律状态查询商标数量")
    @RequestMapping(value = "/countByLawType", method = RequestMethod.GET)
    @ResponseBody
    public List countByPatentType() {
        Map<String, Object> condition = new HashMap<>(6);
        SysUser sysUserInfo = this.getUserProfile();
        String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(sysUserInfo.getDataScopeUnitPath(), restTemplate, httpHeaders);
        this.setParam(condition,"childUnitIds",childUnitIds);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<List> responseEntity = this.restTemplate.exchange(countByLawType, HttpMethod.POST, new HttpEntity<Map>(condition,this.httpHeaders),List.class);
        return responseEntity.getBody();

    }

    @ApiOperation(value = "根据模板导入商标管理信息（EXCEL）", notes = "根据模板导入商标管理信息（EXCEL）")
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
            List<TrademarkInfo> list = new ArrayList<TrademarkInfo>();
            resultsDate= getResult( listob );
            if(resultsDate.isSuccess()==true)
            {
                for (int i = IMPORT_HEAD; i < listob.size(); i++)
                {
                    List<Object> lo = listob.get(i);
                    if(lo.size()<18) break;

                    Object col_1 = lo.get(1);   //单位名称
                    Object col_2 = lo.get(2);   // 商标名称
                    Object col_3 = lo.get(3);   // 注册号
                    if(checkIfBlank(col_1)&&checkIfBlank(col_2)&&checkIfBlank(col_3)) break;
                    Object col_4 = lo.get(4);   // 国际分类号
                    Object col_5 = lo.get(5);   // 申请人
                    Object col_6 = lo.get(6);   // 注册单位
                    Object col_7 = lo.get(7);   // 注册日期
                    Object col_8 = lo.get(8);   // 有效期
                    Object col_9 = lo.get(9);   // 延展有效期
                    Object col_10 = lo.get(10); // 商标类型
                    Object col_11 = lo.get(11); // 法律状态
                    Object col_12 = lo.get(12); // 驰名商标
                    Object col_13 = lo.get(13); // 驰名商标认定日期
                    Object col_14 = lo.get(14); // 驰名商标认定机构
                    Object col_15 = lo.get(15); // 著名商标
                    Object col_16 = lo.get(16); // 著名商标认定日期
                    Object col_17 = lo.get(17); // 著名商标认定机构

                    //将excel导入数据转换为SciencePlan对象
                    TrademarkInfo obj = new TrademarkInfo();
                    //TODO:后台存储的是单位名称，不是单位id
                  // obj.setUnitName(String.valueOf(col_1));
                    obj.setUnitName(restTemplate.exchange(GET_UNIT_ID, HttpMethod.POST, new HttpEntity<Object>(lo.get(1),this.httpHeaders), String.class).getBody());
                    obj.setCreateUnitId(obj.getUnitName());
                    // obj.setCreateUnitId(sysUserInfo.getUnitId());
                    obj.setCreateUnitName(String.valueOf(col_1));

                    obj.setTrademarkName(String.valueOf(col_2));
                    obj.setApplicationNumber(String.valueOf(col_3));
                    obj.setCountryType(String.valueOf(col_4));
                    obj.setApplicant(String.valueOf(col_5));
                    obj.setRegisterOrg(String.valueOf(col_6));
                    Date registerDate = DateUtil.strToDate(String.valueOf(col_7),DateUtil.FMT_DD);
                    obj.setRegisterDate(registerDate);
                    Date effectiveDate =DateUtil.strToDate(String.valueOf(col_8),DateUtil.FMT_DD);
                    obj.setEffectiveDate(effectiveDate);
                    if(!checkIfBlank(col_9)){
                        Date extensionPeriod = DateUtil.strToDate(String.valueOf(col_8),DateUtil.FMT_DD);
                        obj.setExtensionPeriod(extensionPeriod);
                    }
                    if(!checkIfBlank(col_10)){
                        obj.setTradeMarkType(getValueFromDictMap(String.valueOf(lo.get(10)),ROOT_KJPT_SBLX));
                    }

                    obj.setLawStatus(getValueFromDictMap(String.valueOf(lo.get(11)),ROOT_KJPT_FLZT));
                    String isWellKonwn = String.valueOf(col_12);
                    if(StringUtils.isNotBlank(isWellKonwn)){ //ROOT_UNIVERSAL_WEHTHER 否:1  是:0
                        obj.setIsWellKnown("是".equals(isWellKonwn)?YES:NO);
                    }
                    //TODO:存入字典值前台无法显示,先直接存入
                    //obj.setIsWellKnown(isWellKonwn);

                    if(col_13 != null && !"".equals(col_13)){
                        Date wellKnownDate = DateUtil.strToDate(String.valueOf(col_13),DateUtil.FMT_DD);
                        obj.setWellKnownDate(wellKnownDate);
                    }
                    obj.setWellKnownOrg(String.valueOf(col_14));
                    String isRegistered = String.valueOf(col_15);
                   if(StringUtils.isNotBlank(isRegistered)){
                        obj.setIsRegistered("是".equals(isRegistered)?YES:NO);
                    }
                    //TODO:存入字典值前台无法显示,先直接存入
                   // obj.setIsRegistered(isRegistered);

                    if(col_16 != null && !"".equals(col_16)){
                        Date famousDate = DateUtil.strToDate(String.valueOf(col_16),DateUtil.FMT_DD);
                        obj.setFamousDate(famousDate);
                    }
                    obj.setFamousOrg(String.valueOf(col_17));
                    String dateid = UUID.randomUUID().toString().replaceAll("-", "");
                    obj.setId(dateid);
                    obj.setDeleted("0");
                    obj.setSecretLevel("0");
                    list.add(obj);
                }
                ResponseEntity<Result> responseEntity =  this.restTemplate.exchange(TRADE_MARK_EXCEL_INPUT, HttpMethod.POST, new HttpEntity<Object>(list, this.httpHeaders), Result.class);
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
            if(lo.size()<18) break;
            Object col_1 = lo.get(1);   //单位名称
            Object col_2 = lo.get(2);   // 商标名称
            Object col_3 = lo.get(3);   // 注册号
            if(checkIfBlank(col_1)&&checkIfBlank(col_2)&&checkIfBlank(col_3)) break;
            Object col_4 = lo.get(4);   // 国际分类号
            Object col_5 = lo.get(5);   // 申请人
            Object col_6 = lo.get(6);   // 注册单位
            Object col_7 = lo.get(7);   // 注册日期
            Object col_8 = lo.get(8);   // 有效期
            Object col_9 = lo.get(9);   // 延展有效期
            Object col_10 = lo.get(10); // 商标类型
            Object col_11 = lo.get(11); // 法律状态
            Object col_12 = lo.get(12); // 驰名商标
            Object col_13 = lo.get(13); // 驰名商标认定日期
            Object col_14 = lo.get(14); // 驰名商标认定机构
            Object col_15 = lo.get(15); // 著名商标
            Object col_16 = lo.get(16); // 著名商标认定日期
            Object col_17 = lo.get(17); // 著名商标认定机构


            //必填值和字典值校验
            if(checkIfBlank(col_1))
            {
                sb.append("第"+(i+2)+"行单位名称为空,");
                break;
            }

            if(checkIfBlank(col_2))
            {
                sb.append("第"+(i+2)+"行商标名称为空,");
                break;
            }
            if(checkIfBlank(col_3))
            {
                sb.append("第"+(i+2)+"行注册号为空,");
                break;
            }
            if(checkIfBlank(col_5))
            {
                sb.append("第"+(i+2)+"行申请人为空,");
                break;
            }
            if(checkIfBlank(col_6))
            {
                sb.append("第"+(i+1)+"行注册单位为空,");
                break;
            }
            if(checkIfBlank(col_7))
            {
                sb.append("第"+(i+1)+"行注册日期为空,");
                break;
            }
            if(checkIfBlank(col_8))
            {
                sb.append("第"+(i+1)+"行有效期为空,");
                break;
            }

            if(checkIfBlank(col_11))
            {
                sb.append("第"+(i+1)+"行法律状态为空,");
                break;
            }else if(!checkIfReasonable(String.valueOf(col_11),ROOT_KJPT_FLZT)){
               sb.append("第"+(i+2)+"行法律状态取值非法,请参考对应sheet页取值!");
               break;
            }

            if(checkIfBlank(col_12))
            {
                sb.append("第"+(i+1)+"行驰名商标为空,");
                break;
            }

            if(checkIfBlank(col_15))
            {
                sb.append("第"+(i+1)+"行著名商标为空,");
                break;
            }

            if(!checkIfBlank(col_10)){
                if(!checkIfReasonable(String.valueOf(col_10),ROOT_KJPT_SBLX)){
                    sb.append("第"+(i+2)+"行商标类型取值非法,请参考对应sheet页取值!");
                    break;
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

}
