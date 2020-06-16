package com.pcitc.web.controller.achieve;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.achieve.AchieveMaintain;
import com.pcitc.base.common.Result;
import com.pcitc.base.researchplatform.PlatformInfoModel;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.*;

/**
 * <p>成果维护</p>
 * @author
 */
@Api(value = "achieveMaintain-api", description = "成果维护接口")
@RestController
public class AchieveMaintainController extends RestBaseController {


    /**
     * 根据ID获取对象信息
     */
    private static final String load = "http://kjpt-zuul/stp-proxy/achieveMaintain-api/load/";
    /**
     * 查询列表
     */
    private static final String query = "http://kjpt-zuul/stp-proxy/achieveMaintain-api/query";
    /**
     * 保存
     */
    private static final String save = "http://kjpt-zuul/stp-proxy/achieveMaintain-api/save";
    /**
     * 删除
     */
    private static final String delete = "http://kjpt-zuul/stp-proxy/achieveMaintain-api/delete/";

    /**
     * 查询平台列表不分页
     */
    private static final String queryNoPage = "http://kjpt-zuul/stp-proxy/achieveMaintain-api/queryNoPage";

    private static final Integer IMPORT_HEAD = 3;

    private static final String ACHIEVE_MAINTAIN_EXCEL_INPUT = "http://kjpt-zuul/stp-proxy/achieveMaintain-api/excel_input";

    //用于缓存导入时的字典数据
    private Map<String,Map<String,String>> dictMap = new HashMap<>();

    private static final String ROOT_KJPT_CGWH_HJLX = "ROOT_KJPT_CGWH_HJLX";


    @ApiOperation(value="读取")
    @RequestMapping(value = "/achieveMaintain-api/load/{id}", method = RequestMethod.GET)
    @ResponseBody
    public AchieveMaintain load(@PathVariable String id) {
        ResponseEntity<AchieveMaintain> responseEntity = this.restTemplate.exchange(load+id, HttpMethod.GET, new HttpEntity(this.httpHeaders), AchieveMaintain.class);
        return responseEntity.getBody();
    }




    @ApiOperation(value = "查询列表", notes = "查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "startYear", value = "获奖年份开始", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "endYear", value = "获奖年份结束", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "type", value = "获奖类型", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "awardsChildType", value = "奖项子名称", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "awardsType", value = "成果奖项", dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/achieveMaintain-api/query", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo query(
            @RequestParam(required = false,value = "pageNum") Integer pageNum,
            @RequestParam(required = false,value = "pageSize") Integer pageSize,
            @RequestParam(required = false,value = "type") String type,
            @RequestParam(required = false,value = "awardsChildType") String awardsChildType,
            @RequestParam(required = false,value = "startYear") String startYear,
            @RequestParam(required = false,value = "endYear")  String endYear,
            @RequestParam(required = false,value = "awardsType") String awardsType
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
        if (!StringUtils.isEmpty(startYear)) {
            this.setParam(condition, "startYear", startYear);
        }
        if (!StringUtils.isEmpty(endYear)) {
            this.setParam(condition, "endYear", endYear);
        }
        if (!StringUtils.isEmpty(type)) {
            this.setParam(condition, "type", type);
        }
        if (!StringUtils.isEmpty(awardsChildType)) {
            this.setParam(condition, "awardsChildType", awardsChildType);
        }
        if (!StringUtils.isEmpty(awardsType)) {
            this.setParam(condition, "awardsType", awardsType);
        }

        this.setBaseParam(condition);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(sysUserInfo.getDataScopeUnitPath(), restTemplate, httpHeaders);
        this.setParam(condition,"childUnitIds",childUnitIds);
        ResponseEntity<PageInfo> responseEntity = this.restTemplate.exchange(query, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), PageInfo.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value="保存")
    @RequestMapping(value = "/achieveMaintain-api/save", method = RequestMethod.POST)
    @ResponseBody
    public void save(@RequestBody AchieveMaintain am){
        this.setBaseData(am);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        this.restTemplate.exchange(save, HttpMethod.POST, new HttpEntity<AchieveMaintain>(am, this.httpHeaders), AchieveMaintain.class);
    }


    @ApiOperation(value="删除")
    @RequestMapping(value = "/achieveMaintain-api/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable String id) {
       this.restTemplate.exchange(delete+id, HttpMethod.DELETE, new HttpEntity(this.httpHeaders), Integer.class);
    }


    @ApiOperation(value="初始化")
    @RequestMapping(value = "/achieveMaintain-api/newInit", method = RequestMethod.GET)
    @ResponseBody
    public AchieveMaintain newInit() {
        AchieveMaintain a = new AchieveMaintain();
        a.setId(UUID.randomUUID().toString().replace("-",""));
        return a;
    }


    @ApiOperation(value="导出excel")
    @RequestMapping(value = "/achieveMaintain-api/export", method = RequestMethod.GET)
    @ResponseBody
    public void export(
            @RequestParam(required = false,value = "type") String type,
            @RequestParam(required = false,value = "startYear") @DateTimeFormat(pattern="yyyy") Date startYear,
            @RequestParam(required = false,value = "endYear")  @DateTimeFormat(pattern="yyyy") Date endYear,
            @RequestParam(required = false,value = "awardsType") String awardsType
    ) throws Exception {
        Map<String, Object> condition = new HashMap<>(2);
        if (!StringUtils.isEmpty(DateUtil.format(startYear,DateUtil.FMT_YYYY))) {
            this.setParam(condition, "startYear", DateUtil.format(startYear,DateUtil.FMT_YYYY));
        }
        if (!StringUtils.isEmpty(DateUtil.format(endYear,DateUtil.FMT_YYYY))) {
            this.setParam(condition, "endYear", DateUtil.format(endYear,DateUtil.FMT_YYYY));
        }
        if (!StringUtils.isEmpty(type)) {
            this.setParam(condition, "type", type);
        }
        if (!StringUtils.isEmpty(awardsType)) {
            this.setParam(condition, "awardsType", awardsType);
        }
        String[] headers = { "获奖年份",  "奖项级别","奖项名称", "奖项子名称", "授奖等级", "奖项数量"  };
        String[] cols =    {"year","typeText","awardsTypeText","awardsChildTypeText","awardLevelText","awardsNumber"};
        export(headers,cols,"成果维护表_",condition);
    }


    private void export(String[] headers,String[] cols,String fileName,Map condition) throws Exception {
        this.setBaseParam(condition);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(queryNoPage, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), JSONArray.class);
        List list = JSONObject.parseArray(responseEntity.getBody().toJSONString(), AchieveMaintain.class);
        fileName = fileName+ DateFormatUtils.format(new Date(), "ddhhmmss");
        this.exportExcel(headers,cols,fileName,list);
    }

    @ApiOperation(value = "根据模板导入成果维护信息（EXCEL）", notes = "根据模板导入成果维护信息（EXCEL）")
    @RequestMapping(value = "/achieveMaintain-api/input_excel", method = RequestMethod.POST)
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
            List<AchieveMaintain> list = new ArrayList<AchieveMaintain>();
            resultsDate= getResult( listob );
            if(resultsDate.isSuccess()==true)
            {
                for (int i = IMPORT_HEAD; i < listob.size(); i++)
                {
                    List<Object> lo = listob.get(i);
                    if(lo.size()<7) break;
                    Object col_1 = lo.get(1);   //获奖年份
                    Object col_2 = lo.get(2);   //奖项级别
                    Object col_3 = lo.get(3);   //奖项名称
                    Object col_4 = lo.get(4);   //奖项子名称
                    if(checkIfBlank(col_1)&&checkIfBlank(col_2)&&checkIfBlank(col_3)&&checkIfBlank(col_4)) break;
                    Object col_5 = lo.get(5);   //授权等级
                    Object col_6 = lo.get(6);   //奖项数量


                    //将excel导入数据转换为SciencePlan对象
                    AchieveMaintain obj = new AchieveMaintain();

                    //通过模板导入的年度为2020.0000
                   Double year =  Double.valueOf(String.valueOf(col_1));
                    obj.setYear(String.valueOf(year.intValue()));
                    String type = getValueFromDictMap(String.valueOf(col_2),ROOT_KJPT_CGWH_HJLX);
                    obj.setType(type);
                    obj.setTypeText(String.valueOf(col_2));

                    String awardsType = getValueFromDictMap(String.valueOf(col_3),type);
                    obj.setAwardsType(awardsType);
                    obj.setAwardsTypeText(String.valueOf(col_3));

                    String awardsChildType = getValueFromDictMap(String.valueOf(col_4),awardsType);
                    obj.setAwardsChildType(awardsChildType);
                    obj.setAwardsChildTypeText(String.valueOf(col_4));

                    String awardLevel = getValueFromDictMap(String.valueOf(col_5),awardsChildType);
                    obj.setAwardLevel(awardLevel);
                    obj.setAwardLevelText(String.valueOf(col_5));

                    Double num = Double.valueOf(String.valueOf(col_6));
                    obj.setAwardsNumber(String.valueOf(num.intValue()));
                    obj.setCreateUnitId(sysUserInfo.getUnitId());
                    String dateid = UUID.randomUUID().toString().replaceAll("-", "");
                    obj.setId(dateid);
                    obj.setSecretLevel("0");
                    list.add(obj);
                }
                ResponseEntity<Result> responseEntity =  this.restTemplate.exchange(ACHIEVE_MAINTAIN_EXCEL_INPUT, HttpMethod.POST, new HttpEntity<Object>(list, this.httpHeaders), Result.class);
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
            if(lo.size()<7) break;
            Object col_1 = lo.get(1);   //获奖年份
            Object col_2 = lo.get(2);   //奖项级别
            Object col_3 = lo.get(3);   //奖项名称
            Object col_4 = lo.get(4);   //奖项子名称
            if(checkIfBlank(col_1)&&checkIfBlank(col_2)&&checkIfBlank(col_3)&&checkIfBlank(col_4)) break;
            Object col_5 = lo.get(5);   //授权等级
            Object col_6 = lo.get(6);   //奖项数量


            // 必填项和字典值校验
            if(checkIfBlank(col_1))

            {
                sb.append("第"+(i+2)+"行获奖年份为空,");
                break;
            }
            if(checkIfBlank(col_2))
            {
                sb.append("第"+(i+2)+"行奖项级别为空,");
                break;
            }else if(!checkIfReasonable(String.valueOf(col_2),ROOT_KJPT_CGWH_HJLX)){
                sb.append("第"+(i+2)+"行奖项级别取值非法,请参考对应sheet页取值!");
                break;
            }
            String reward_level_code = getValueFromDictMap(String.valueOf(col_2),ROOT_KJPT_CGWH_HJLX);
            if(checkIfBlank(col_3))
            {
                sb.append("第"+(i+2)+"行奖项名称为空,");
                break;
            }else {
                if(!checkIfReasonable(String.valueOf(col_3),reward_level_code)){
                    sb.append("第"+(i+2)+"行奖项名称取值非法,请参考对应sheet页取值!");
                    break;
                }
            }
            String  reward_name_code = getValueFromDictMap(String.valueOf(col_3),reward_level_code);
            if(checkIfBlank(col_4))
            {
                sb.append("第"+(i+2)+"行奖项子名称为空,");
                break;
            }else{

                if(!checkIfReasonable(String.valueOf(col_4),reward_name_code)){
                    sb.append("第"+(i+2)+"行奖项子名称取值非法,请参考对应sheet页取值!");
                    break;
                }
            }
            String auth_level = getValueFromDictMap(String.valueOf(col_4),reward_name_code);
            if(checkIfBlank(col_5))
            {
                sb.append("第"+(i+2)+"行授权等级为空,");
                break;
            }else{

                if(!checkIfReasonable(String.valueOf(col_5),auth_level)){
                    sb.append("第"+(i+2)+"行授权等级取值非法,请参考对应sheet页取值!");
                    break;
                }
            }

            if(checkIfBlank(col_6))
            {
                sb.append("第"+(i+2)+"行奖项数量为空,");
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
