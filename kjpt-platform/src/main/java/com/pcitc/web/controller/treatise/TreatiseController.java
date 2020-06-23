package com.pcitc.web.controller.treatise;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.Result;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.treatiseinfo.TreatiseInfo;
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
@Api(value = "treatise-api", description = "论文")
@RestController
public class TreatiseController extends RestBaseController {


    /**
     * 根据ID获取对象信息
     */
    private static final String load = "http://kjpt-zuul/stp-proxy/treatise-api/load/";
    /**
     * 查询列表
     */
    private static final String query = "http://kjpt-zuul/stp-proxy/treatise-api/query";
    /**
     * 保存
     */
    private static final String save = "http://kjpt-zuul/stp-proxy/treatise-api/save";
    /**
     * 删除
     */
    private static final String delete = "http://kjpt-zuul/stp-proxy/treatise-api/delete/";

    /**
     * 查询平台列表不分页
     */
    private static final String queryNoPage = "http://kjpt-zuul/stp-proxy/treatise-api/queryNoPage";

    /**
     * 导入模板头部所占行数
     */
    private static final Integer IMPORT_HEAD = 3;

    private static final String TREATISE_EXCEL_INPUT = "http://kjpt-zuul/stp-proxy/treatise-api/excel_input";

    //用于缓存导入时的字典数据
    private Map<String,Map<String,String>> dictMap = new HashMap<>();

    private static final String ROOT_KJPT_QKDJ = "ROOT_KJPT_QKDJ";

    private static final String GET_UNIT_ID = "http://kjpt-zuul/system-proxy/unit-provider/unit/getUnitId_by_name";


    @ApiOperation(value="读取")
    @RequestMapping(value = "/treatise-api/load/{id}", method = RequestMethod.GET)
    @ResponseBody
    public TreatiseInfo load(@PathVariable String id) {
        ResponseEntity<TreatiseInfo> responseEntity = this.restTemplate.exchange(load+id, HttpMethod.GET, new HttpEntity(this.httpHeaders), TreatiseInfo.class);
        return responseEntity.getBody();
    }




    @ApiOperation(value = "查询列表", notes = "查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "theme", value = "论文主题", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "title", value = "篇名", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "author", value = "作者", dataType = "String", paramType = "author"),
            @ApiImplicitParam(name = "unit", value = "单位", dataType = "String", paramType = "unit"),
            @ApiImplicitParam(name = "journalName", value = "期刊名", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "journalLevel", value = "期刊等级", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "publishDate", value = "发表日期", dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/treatise-api/query", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo query(
            @RequestParam(required = false,value = "pageNum") Integer pageNum,
            @RequestParam(required = false,value = "pageSize") Integer pageSize,
            @RequestParam(required = false,value = "theme") String theme,
            @RequestParam(required = false,value = "title") String title,
            @RequestParam(required = false,value = "author") String author,
            @RequestParam(required = false,value = "unit") String unit,
            @RequestParam(required = false,value = "journalName") String journalName,
            @RequestParam(required = false,value = "journalLevel")  String journalLevel,
            @RequestParam(required = false,value = "publishDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date publishDate
    ){

        Map<String, Object> condition = new HashMap<>();
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
        if (!StringUtils.isEmpty(theme)) {
            this.setParam(condition, "theme", theme);
        }
        if (!StringUtils.isEmpty(title)) {
            this.setParam(condition, "title", title);
        }
        if (!StringUtils.isEmpty(author)) {
            this.setParam(condition, "author", author);
        }
        if (!StringUtils.isEmpty(unit)) {
            this.setParam(condition, "unit", unit);
        }
        if (!StringUtils.isEmpty(journalName)) {
            this.setParam(condition, "journalName", journalName);
        }
        if (!StringUtils.isEmpty(journalLevel)) {
            this.setParam(condition, "journalLevel", journalLevel);
        }
        if (!StringUtils.isEmpty(DateUtil.format(publishDate,DateUtil.FMT_SS))) {
            this.setParam(condition, "publishDate", DateUtil.format(publishDate,DateUtil.FMT_SS));
        }

        String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(sysUserInfo.getDataScopeUnitPath(), restTemplate, httpHeaders);
        this.setParam(condition,"childUnitIds",childUnitIds);
        this.setBaseParam(condition);

        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<PageInfo> responseEntity = this.restTemplate.exchange(query, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), PageInfo.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value="保存")
    @RequestMapping(value = "/treatise-api/save", method = RequestMethod.POST)
    @ResponseBody
    public void save(@RequestBody TreatiseInfo am){
        this.setBaseData(am);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        this.restTemplate.exchange(save, HttpMethod.POST, new HttpEntity<TreatiseInfo>(am, this.httpHeaders), TreatiseInfo.class);
    }


    @ApiOperation(value="删除")
    @RequestMapping(value = "/treatise-api/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable String id) {
       this.restTemplate.exchange(delete+id, HttpMethod.DELETE, new HttpEntity(this.httpHeaders), Integer.class);
    }


    @ApiOperation(value="初始化")
    @RequestMapping(value = "/treatise-api/newInit", method = RequestMethod.GET)
    @ResponseBody
    public TreatiseInfo newInit() {
        TreatiseInfo a = new TreatiseInfo();
        a.setId(UUID.randomUUID().toString().replace("-",""));
        return a;
    }


    @ApiOperation(value="导出excel")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "theme", value = "论文主题", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "title", value = "篇名", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "author", value = "作者", dataType = "String", paramType = "author"),
            @ApiImplicitParam(name = "unit", value = "单位", dataType = "String", paramType = "unit"),
            @ApiImplicitParam(name = "journalName", value = "期刊名", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "journalLevel", value = "期刊等级", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "publishDate", value = "发表日期", dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/treatise-api/export", method = RequestMethod.GET)
    @ResponseBody
    public void export(
            @RequestParam(required = false,value = "pageNum") Integer pageNum,
            @RequestParam(required = false,value = "pageSize") Integer pageSize,
            @RequestParam(required = false,value = "theme") String theme,
            @RequestParam(required = false,value = "title") String title,
            @RequestParam(required = false,value = "author") String author,
            @RequestParam(required = false,value = "unit") String unit,
            @RequestParam(required = false,value = "journalName") String journalName,
            @RequestParam(required = false,value = "journalLevel")  String journalLevel,
            @RequestParam(required = false,value = "publishDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date publishDate
    ) throws Exception {
        Map<String, Object> condition = new HashMap<>(2);
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
        if (!StringUtils.isEmpty(theme)) {
            this.setParam(condition, "theme", theme);
        }
        if (!StringUtils.isEmpty(title)) {
            this.setParam(condition, "title", title);
        }
        if (!StringUtils.isEmpty(author)) {
            this.setParam(condition, "author", author);
        }
        if (!StringUtils.isEmpty(unit)) {
            this.setParam(condition, "unit", unit);
        }
        if (!StringUtils.isEmpty(journalName)) {
            this.setParam(condition, "journalName", journalName);
        }
        if (!StringUtils.isEmpty(journalLevel)) {
            this.setParam(condition, "journalLevel", journalLevel);
        }
        if (!StringUtils.isEmpty(DateUtil.format(publishDate,DateUtil.FMT_SS))) {
            this.setParam(condition, "publishDate", DateUtil.format(publishDate,DateUtil.FMT_SS));
        }

        String[] headers = { "论文主题",  "关键字","篇名", "作者", "单位", "摘要", "期刊名", "期刊等级", "发表日期", "影响因子"  };
        String[] cols =    {"theme","keyWord","title","author","unitText","summary","journalName","journalLevelText","publishDate","influencingFactors"};
        export(headers,cols,"论文_",condition);
    }


    private void export(String[] headers,String[] cols,String fileName,Map condition) throws Exception {
        this.setBaseParam(condition);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(queryNoPage, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), JSONArray.class);
        List list = JSONObject.parseArray(responseEntity.getBody().toJSONString(), TreatiseInfo.class);
        fileName = fileName+ DateFormatUtils.format(new Date(), "ddhhmmss");
        this.exportExcel(headers,cols,fileName,list);
    }


    @ApiOperation(value = "根据模板导入论文信息（EXCEL）", notes = "根据模板导入论文信息（EXCEL）")
    @RequestMapping(value = "/treatise-api/input_excel", method = RequestMethod.POST)
    public Object newImportData(HttpServletRequest req, HttpServletResponse resp, MultipartFile file) throws Exception
    {
        Result resultsDate = new Result();
        String type = req.getQueryString();

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
            List<TreatiseInfo> list = new ArrayList<TreatiseInfo>();
            resultsDate= getResult( listob );
            if(resultsDate.isSuccess()==true)
            {
                for (int i = IMPORT_HEAD; i < listob.size(); i++)
                {
                    List<Object> lo = listob.get(i);

                    Object col_1 = lo.get(1);   //论文主题
                    Object col_2 = lo.get(2);   //关键词
                    Object col_3 = lo.get(3);   //篇名
                    Object col_4 = lo.get(4);   //作者
                    if(checkIfBlank(col_1)&&checkIfBlank(col_2)&&checkIfBlank(col_3)&&checkIfBlank(col_4)) break;
                    Object col_5 = lo.get(5);   //单位
                    Object col_6 = lo.get(6);   //摘要
                    Object col_7 = lo.get(7);   //期刊名
                    Object col_8 = lo.get(8);   //期刊等级
                    Object col_9 = lo.get(9);   //影响因子
                    Object col_10 = lo.get(10);  //发表日期

                    //将excel导入数据转换为SciencePlan对象
                    TreatiseInfo obj = new TreatiseInfo();

                    obj.setTheme(String.valueOf(col_1));
                    obj.setKeyWord(String.valueOf(col_2));
                    obj.setTitle(String.valueOf(col_3));
                    obj.setAuthor(String.valueOf(col_4));
                    obj.setUnit(restTemplate.exchange(GET_UNIT_ID, HttpMethod.POST, new HttpEntity<Object>(col_5,this.httpHeaders), String.class).getBody());
                    obj.setSummary(String.valueOf(col_6));
                    obj.setJournalName(String.valueOf(col_7));
                    obj.setJournalLevel(getValueFromDictMap(String.valueOf(col_8),ROOT_KJPT_QKDJ));
                    obj.setJournalLevelText(String.valueOf(col_8));
                    obj.setInfluencingFactors(String.valueOf(col_9));
                    Date pulishDate = DateUtil.strToDate(String.valueOf(col_10),DateUtil.FMT_DD);
                    obj.setPublishDate(pulishDate);

                    obj.setCreateUnitId(sysUserInfo.getUnitId());
                    String dateid = UUID.randomUUID().toString().replaceAll("-", "");
                    obj.setId(dateid);
                    obj.setSecretLevel("0");
                    list.add(obj);
                }
                ResponseEntity<Result> responseEntity =  this.restTemplate.exchange(TREATISE_EXCEL_INPUT, HttpMethod.POST, new HttpEntity<Object>(list, this.httpHeaders), Result.class);
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
            Object col_1 = lo.get(1);   //论文主题
            Object col_2 = lo.get(2);   //关键词
            Object col_3 = lo.get(3);   //篇名
            Object col_4 = lo.get(4);   //作者
            if(checkIfBlank(col_1)&&checkIfBlank(col_2)&&checkIfBlank(col_3)&&checkIfBlank(col_4)) break;
            Object col_5 = lo.get(5);   //单位
            Object col_6 = lo.get(6);   //摘要
            Object col_7 = lo.get(7);   //期刊名
            Object col_8 = lo.get(8);   //期刊等级
            Object col_9 = lo.get(9);   //影响因子
            Object col_10 = lo.get(10);  //发表日期

            // 必填项和字典值校验
            if(checkIfBlank(col_1))
            {
                sb.append("第"+(i+2)+"行论文主题为空,");
                break;
            }
            if(checkIfBlank(col_3))
            {
                sb.append("第"+(i+2)+"行篇名为空,");
                break;
            }
            if(checkIfBlank(col_4))
            {
                sb.append("第"+(i+2)+"行作者为空,");
                break;
            }

            if(checkIfBlank(col_5))
            {
                sb.append("第"+(i+2)+"行单位为空,");
                break;
            }

            if(checkIfBlank(col_7))
            {
                sb.append("第"+(i+2)+"行期刊名为空,");
                break;
            }
            if(checkIfBlank(col_8))
            {
                sb.append("第"+(i+2)+"行期刊等级为空,");
                break;
            }else if(!checkIfReasonable(String.valueOf(col_8),ROOT_KJPT_QKDJ)){
                sb.append("第"+(i+2)+"行期刊等级取值非法,请参考对应sheet页取值!");
                break;
            }

            if(checkIfBlank(col_10))
            {
                sb.append("第"+(i+2)+"行是否在专家风采页面展示为空,");
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
