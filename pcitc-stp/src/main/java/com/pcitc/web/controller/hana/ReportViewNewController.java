package com.pcitc.web.controller.hana;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonArray;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.hana.report.ReportViewNewVo;
import com.pcitc.base.report.ReportColumn;
import com.pcitc.base.report.ReportConfig;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.DataTableLayui;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/reportNew")
//@Scope("prototype")
public class ReportViewNewController extends BaseController {

    private static final String GET_LIST = "http://pcitc-zuul/hana-proxy/hana/report/getReportNew";
    private static final String GET_LIST_TREE = "http://pcitc-zuul/hana-proxy/hana/report/getReportTreeNew";
    private static final String LIST_REPORT = "http://pcitc-zuul/system-proxy/reportcolumn-provider/reportcolumn/reportcolumn_list_config";
    private static final String LIST_Catalog = "http://pcitc-zuul/hana-proxy/hana/report/selectCatalog";
    private static final String LIST_CubeName = "http://pcitc-zuul/hana-proxy/hana/report/selectCubeName";
    /**
     * 根据ID获取对象信息
     */
    private static final String GET_INFO = "http://pcitc-zuul/system-proxy/reportconfig-provider/reportconfig/get-reportconfig/";
    /**
     * STP连接地址
     */
    private static final String LIST_REPORT_STP = "http://pcitc-zuul/hana-proxy/hana/report/getReportListStp";
    /**
     * 根据ID获取对象信息
     */
    private static final String GET_INFO_REPORT_CONFIG = "http://pcitc-zuul/system-proxy/reportconfig-provider/reportconfig/get-reportconfig/";

    private static final String LISTPARAM_COLUMN = "http://pcitc-zuul/system-proxy/reportcolumn-provider/reportcolumn/reportcolumn_list";

    /**
     * 页面查询
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/reportPageQuery")
    public String reportPageQuery() {
        String strUrl = "";
        try {
            String strId = request.getParameter("name");
            if (strId == null) {
                return "";
            }
            ResponseEntity<ReportConfig> responseEntityConfig = this.restTemplate.exchange(GET_INFO_REPORT_CONFIG + strId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), ReportConfig.class);
            ReportConfig config = responseEntityConfig.getBody();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("config",config);
//            if ("0".equals(config.getBak2())){
                strUrl = "stp/hana/reportconfig/table_query";
//            }else {
//                strUrl = "stp/hana/reportconfig/stp_report_listcount";
//            }

            request.setAttribute("name", strId);
            //获取配置信息，拼装标准json字符串，放入request
            httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
            requestBody.add("id", strId);
            HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);

            ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LIST_REPORT, HttpMethod.POST, entity, JSONObject.class);
            JSONObject retJson = responseEntity.getBody();

            request.setAttribute("jsonObject",JSON.toJSONString(jsonObject));
            request.setAttribute("wd_obj_array", JSON.toJSONString(retJson.getJSONArray("wd_obj_array")));
            request.setAttribute("zb_obj_array", JSON.toJSONString(retJson.getJSONArray("zb_obj_array")));
            request.setAttribute("wd_show_obj_array", JSON.toJSONString(retJson.getJSONArray("wd_show_obj_array")));
            request.setAttribute("wd_hide_obj_array", JSON.toJSONString(retJson.getJSONArray("wd_hide_obj_array")));
            request.setAttribute("zb_show_obj_array", JSON.toJSONString(retJson.getJSONArray("zb_show_obj_array")));
            request.setAttribute("zb_hide_obj_array", JSON.toJSONString(retJson.getJSONArray("zb_hide_obj_array")));
            request.setAttribute("default_wd_zb_obj_array", JSON.toJSONString(retJson.getJSONArray("default_wd_zb_obj_array")));
            request.setAttribute("default_x_obj_array", JSON.toJSONString(retJson.getJSONArray("default_x_obj_array")));
            request.setAttribute("default_column_obj_array", JSON.toJSONString(retJson.getJSONArray("default_column_obj_array")));
            //select
            request.setAttribute("query_obj_array", JSON.toJSONString(retJson.getJSONArray("query_obj_array")));

            request.setAttribute("gsdmcode",JSON.toJSONString(sysUserInfo.getInstituteCodes()));
            request.setAttribute("gsdmname",JSON.toJSONString(sysUserInfo.getInstituteNames()));

            //store
            String strStoreId = request.getParameter("storeId");
            request.setAttribute("storeId",strStoreId==null?"":strStoreId);
            request.setAttribute("strUrl",config.getBak2());
            System.out.println(config.getBak2());

            //url param
            String jsonparam = request.getParameter("jsonparam");
            request.setAttribute("jsonparam",(jsonparam==null||"".equals(jsonparam))?"":JSON.toJSONString(jsonparam.toUpperCase()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return strUrl;
    }

    /**
     * Catalog查询
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.POST, value = "/selectCatalogAndCubeName")
    @ResponseBody
    public String selectCatalog(HttpServletRequest request) throws Exception {

//        String strmodelIndex = request.getParameter("modelIndex");
//        String strModelDesc = request.getParameter("modelDesc");
        String modelIndex = request.getParameter("modelIndex");
        String modelDesc = request.getParameter("modelDesc");
        Map<String, String> map = new HashMap<>();
        //获取配置信息
        map.put("modelName", request.getParameter("modelName"));
        map.put("modelIndex", modelIndex);
        map.put("modelDesc", (modelDesc==null||"".equals(modelDesc))?"-1-1-1-1-1-1-1-1-1-1-":modelDesc);
        map.put("limit", request.getParameter("limit"));
        map.put("offset", request.getParameter("offset"));

        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
        String str = JSONObject.toJSONString(map);
        requestBody.add("paramsJson", str);

        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);
        ResponseEntity<List> responseEntity = restTemplate.exchange((modelIndex == null || "".equals(modelIndex)) ? LIST_Catalog : LIST_CubeName, HttpMethod.POST, entity, List.class);
        List<Map<String,Object>> list = responseEntity.getBody();
        LayuiTableData data = new LayuiTableData();
        data.setCount((list.size()==0)?0: Integer.parseInt(list.get(0).get("acount").toString()));
        data.setData(list);

        return JSON.toJSONString(data);
    }

    /**
     * STP页面跳转
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/reportPageStp")
    public String reportPageStp() {
        //新建一个模型，改变此处的strId值
        //将新模型字段复制到本地系统
        //修改本地系统字段配置
        //修改模型配置
        String strUrl = "";
        try {
            String strId = request.getParameter("name");
            if (strId == null) {
                return "";
            }
            ResponseEntity<ReportConfig> responseEntityConfig = this.restTemplate.exchange(GET_INFO_REPORT_CONFIG + strId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), ReportConfig.class);
            ReportConfig config = responseEntityConfig.getBody();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("config",config);
            if ("0".equals(config.getBak2())){
                strUrl = "stp/hana/reportconfig/stp_report_list";
            }else {
                strUrl = "stp/hana/reportconfig/stp_report_listcount";
            }

            request.setAttribute("name", strId);
            //获取配置信息，拼装标准json字符串，放入request
            httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
            requestBody.add("id", strId);
            HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);

            ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LIST_REPORT, HttpMethod.POST, entity, JSONObject.class);
            JSONObject retJson = responseEntity.getBody();

            request.setAttribute("jsonObject",JSON.toJSONString(jsonObject));
            request.setAttribute("wd_obj_array", JSON.toJSONString(retJson.getJSONArray("wd_obj_array")));
            request.setAttribute("zb_obj_array", JSON.toJSONString(retJson.getJSONArray("zb_obj_array")));
            request.setAttribute("wd_show_obj_array", JSON.toJSONString(retJson.getJSONArray("wd_show_obj_array")));
            request.setAttribute("wd_hide_obj_array", JSON.toJSONString(retJson.getJSONArray("wd_hide_obj_array")));
            request.setAttribute("zb_show_obj_array", JSON.toJSONString(retJson.getJSONArray("zb_show_obj_array")));
            request.setAttribute("zb_hide_obj_array", JSON.toJSONString(retJson.getJSONArray("zb_hide_obj_array")));
            request.setAttribute("default_wd_zb_obj_array", JSON.toJSONString(retJson.getJSONArray("default_wd_zb_obj_array")));
            request.setAttribute("default_x_obj_array", JSON.toJSONString(retJson.getJSONArray("default_x_obj_array")));
            request.setAttribute("default_column_obj_array", JSON.toJSONString(retJson.getJSONArray("default_column_obj_array")));
            //select
            request.setAttribute("gsdmcode",JSON.toJSONString(sysUserInfo.getInstituteCodes()));
            request.setAttribute("gsdmname",JSON.toJSONString(sysUserInfo.getInstituteNames()));

            //store
            String strStoreId = request.getParameter("storeId");
            request.setAttribute("storeId",strStoreId==null?"":strStoreId);
            request.setAttribute("strUrl",config.getBak2());
            System.out.println(config.getBak2());

            //url param
            String jsonparam = request.getParameter("jsonparam");
            request.setAttribute("jsonparam",(jsonparam==null||"".equals(jsonparam))?"":JSON.toJSONString(jsonparam.toUpperCase()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return strUrl;
    }

    /**
     * 页面跳转
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/reportPage")
    public String researchanalysis() {
        String strId = request.getParameter("name");
        if (strId == null) {
            strId = "16546941e66_5d17a418";
        }
        request.setAttribute("name", strId);
        //获取配置信息，拼装标准json字符串，放入request
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
        requestBody.add("id", strId);
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);

        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LIST_REPORT, HttpMethod.POST, entity, JSONObject.class);
        JSONObject retJson = responseEntity.getBody();

        request.setAttribute("wd_obj_array", JSON.toJSONString(retJson.getJSONArray("wd_obj_array")));
        request.setAttribute("zb_obj_array", JSON.toJSONString(retJson.getJSONArray("zb_obj_array")));
        request.setAttribute("wd_show_obj_array", JSON.toJSONString(retJson.getJSONArray("wd_show_obj_array")));
        request.setAttribute("wd_hide_obj_array", JSON.toJSONString(retJson.getJSONArray("wd_hide_obj_array")));
        request.setAttribute("zb_show_obj_array", JSON.toJSONString(retJson.getJSONArray("zb_show_obj_array")));
        request.setAttribute("zb_hide_obj_array", JSON.toJSONString(retJson.getJSONArray("zb_hide_obj_array")));
        request.setAttribute("default_wd_zb_obj_array", JSON.toJSONString(retJson.getJSONArray("default_wd_zb_obj_array")));
        request.setAttribute("default_x_obj_array", JSON.toJSONString(retJson.getJSONArray("default_x_obj_array")));
        request.setAttribute("default_column_obj_array", JSON.toJSONString(retJson.getJSONArray("default_column_obj_array")));
        return "layui/tree_tableDemoNew";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/reportPageIndex")
    public String researchanalysisindex() {
        //新建一个模型，改变此处的strId值
        //将新模型字段复制到本地系统
        //修改本地系统字段配置
        //修改模型配置
        String strId = request.getParameter("name");
        if (strId == null) {
            strId = "16546941e66_5d17a418";
        }
        request.setAttribute("name", strId);
        //获取配置信息，拼装标准json字符串，放入request
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
        requestBody.add("id", strId);
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);

        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LIST_REPORT, HttpMethod.POST, entity, JSONObject.class);
        JSONObject retJson = responseEntity.getBody();

        request.setAttribute("wd_obj_array", JSON.toJSONString(retJson.getJSONArray("wd_obj_array")));
        request.setAttribute("zb_obj_array", JSON.toJSONString(retJson.getJSONArray("zb_obj_array")));
        request.setAttribute("wd_show_obj_array", JSON.toJSONString(retJson.getJSONArray("wd_show_obj_array")));
        request.setAttribute("wd_hide_obj_array", JSON.toJSONString(retJson.getJSONArray("wd_hide_obj_array")));
        request.setAttribute("zb_show_obj_array", JSON.toJSONString(retJson.getJSONArray("zb_show_obj_array")));
        request.setAttribute("zb_hide_obj_array", JSON.toJSONString(retJson.getJSONArray("zb_hide_obj_array")));
        request.setAttribute("default_wd_zb_obj_array", JSON.toJSONString(retJson.getJSONArray("default_wd_zb_obj_array")));
        request.setAttribute("default_x_obj_array", JSON.toJSONString(retJson.getJSONArray("default_x_obj_array")));
        request.setAttribute("default_column_obj_array", JSON.toJSONString(retJson.getJSONArray("default_column_obj_array")));
        return "layui/tree_tableDemoNewIndex";
    }

    /**
     * 报表查询
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.POST, value = "/getTableReport")
    @ResponseBody
    public String getTableReport(HttpServletRequest request) throws Exception {

        Map<String, String> map = this.getParameterMap(request);
        //获取配置信息
        ResponseEntity<ReportConfig> responseEntityConfig = this.restTemplate.exchange(GET_INFO + request.getParameter("name"), HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), ReportConfig.class);
        ReportConfig record = responseEntityConfig.getBody();
        map.put("modelName", record.getModelName());
        map.put("modelIndex", record.getModelIndex());

        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
        String str = JSONObject.toJSONString(map);
        requestBody.add("paramsJson", str);

        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);
        ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_LIST, HttpMethod.POST, entity, JSONArray.class);
        JSONArray json = responseEntity.getBody();
        List<ReportViewNewVo> reportViewVos = JSONObject.parseArray(json.toJSONString(), ReportViewNewVo.class);
        DataTableLayui data = new DataTableLayui();
        data.setData(reportViewVos);
        data.setMsg("");
        data.setCode("0");
        return JSON.toJSONString(data);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/getTableReportTemp")
    @ResponseBody
    public String getTableReportTemp(HttpServletRequest request) throws Exception {
        DataTableLayui data = new DataTableLayui();
//        String strTemp="[{G0GSDM: '1750', K0QMYE: '0.0'}]";
//        data.setData(com.alibaba.fastjson.JSONArray.parseArray(strTemp));
        data.setData(null);
        data.setMsg("");
        data.setCode("0");
        return JSON.toJSONString(data);
    }

    /**
     * 报表树查询
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.POST, value = "/getTableReportTree")
    @ResponseBody
    public String getTableReportTree(HttpServletRequest request) throws Exception {

        Map<String, String> map = this.getParameterMap(request);
        //获取配置信息
        ResponseEntity<ReportConfig> responseEntityConfig = this.restTemplate.exchange(GET_INFO + request.getParameter("name"), HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), ReportConfig.class);
        ReportConfig record = responseEntityConfig.getBody();
        map.put("modelName", record.getModelName());
        map.put("modelIndex", record.getModelIndex());


        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
        String str = JSONObject.toJSONString(map);
        requestBody.add("paramsJson", str);

        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);
        ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_LIST_TREE, HttpMethod.POST, entity, JSONArray.class);
        JSONArray json = responseEntity.getBody();
//        List<ReportViewVo> reportViewVos = com.alibaba.fastjson.JSONObject.parseArray(json.toJSONString(), ReportViewVo.class);
        DataTableLayui data = new DataTableLayui();
        data.setData(json);
        data.setMsg("");
        data.setCode("0");
        return JSON.toJSONString(data);
    }

    /**
     * STp报表查询
     * @param param
     * @return
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.POST, value = "/getTableReportStp")
    @ResponseBody
    public String getTableReportStp(@ModelAttribute("param") LayuiTableParam param) throws Exception {
        long start_getReportList = System.currentTimeMillis();

        LayuiTableData data = new LayuiTableData();
        try {
            //获取配置信息
            ResponseEntity<ReportConfig> responseEntityConfig = this.restTemplate.exchange(GET_INFO + param.getParam().get("name"), HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), ReportConfig.class);
            ReportConfig record = responseEntityConfig.getBody();
            param.getParam().put("modelName", record.getModelName());
            param.getParam().put("modelFlag", record.getBak1());
            param.getParam().put("tableType", record.getBak2());
            param.getParam().put("modelIndex", record.getModelIndex());
            param.getParam().put("Authorization", this.httpHeaders.get("Authorization"));
//            param.getParam().put("date","201703");
            param.getParam().put("date",param.getParam().get("date").toString().replace("-", ""));
//            param.getParam().put("gsdm","1020,1040,1041,1060,1061,1080,1100,1101,1120,1123,1124,1127,1130,4360");

            ReportColumn reportColumn = new ReportColumn();
            reportColumn.setReportConfigId(param.getParam().get("name").toString());
            ResponseEntity<JSONObject> responseEntityColumn = this.restTemplate.exchange(LISTPARAM_COLUMN, HttpMethod.POST, new HttpEntity<ReportColumn>(reportColumn, this.httpHeaders), JSONObject.class);
            JSONObject retJson = responseEntityColumn.getBody();
            List<ReportColumn> list = (List<ReportColumn>) retJson.get("list");
            param.getParam().put("column_cal",list);

            HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
            ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(LIST_REPORT_STP, HttpMethod.POST, entity, LayuiTableData.class);
            data = responseEntity.getBody();
            long end_getReportList = System.currentTimeMillis();
            System.out.println("getTableReportStp用时: " + (end_getReportList - start_getReportList));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(data);
    }

    /**
     * 参数组装
     *
     * @param request
     * @return
     */
    private Map<String, String> getParameterMap(HttpServletRequest request) {
        Map<String, String> paramsMap = new HashMap<String, String>();
        String iDisplayStart = request.getParameter("page"); // 起始索引
        String iDisplayLength = request.getParameter("limit"); // 每页显示的行数

        String column = request.getParameter("column");
        String columnko = request.getParameter("columnko");
        String gsdm = request.getParameter("gsdm");
        String where = request.getParameter("where");
        String group = request.getParameter("group");
        String date = request.getParameter("date");
        String xfield = request.getParameter("xfield");
        String name = request.getParameter("name");
        column = (column == null) ? "" : column;

        gsdm = (gsdm == null) ? "" : gsdm;
        where = (where == null) ? "" : where;
        group = (group == null) ? "" : group;
        date = (date == null) ? "" : date.replace("-", "");
        xfield = (xfield == null) ? "" : xfield;
        name = (name == null) ? "" : name;

        paramsMap.put("column", column);
        paramsMap.put("group", group);
        paramsMap.put("gsdm", gsdm);
        paramsMap.put("where", where);
        paramsMap.put("date", date);
        paramsMap.put("columnko", columnko);
        paramsMap.put("xfield", xfield);
        paramsMap.put("name", name);
        return paramsMap;
    }

    /**
     * 图表获取数据
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.POST, value = "/getTableReportPic")
    @ResponseBody
    public String getTableReportPic(String param, HttpServletRequest request) throws Exception {

        Map<String, Object> map = JSON.parseObject(param);
        //获取配置信息
        ResponseEntity<ReportConfig> responseEntityConfig = this.restTemplate.exchange(GET_INFO + map.get("name").toString(), HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), ReportConfig.class);
        ReportConfig record = responseEntityConfig.getBody();
        Map<String, String> mapParam = this.getParameterMapPic(map);
        mapParam.put("modelName", record.getModelName());
        mapParam.put("modelIndex", record.getModelIndex());


        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
        String str = JSONObject.toJSONString(mapParam);
        requestBody.add("paramsJson", str);

        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);
        ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_LIST, HttpMethod.POST, entity, JSONArray.class);
        JSONArray json = responseEntity.getBody();
        DataTableLayui dataTableLayui = new DataTableLayui();
        dataTableLayui.setData(json);
        dataTableLayui.setMsg("");
        dataTableLayui.setCode("0");
        return JSON.toJSONString(dataTableLayui);
    }

    /**
     * 图表拼装数据
     *
     * @param map
     * @return
     */
    private Map<String, String> getParameterMapPic(Map<String, Object> map) {
        Map<String, String> paramsMap = new HashMap<String, String>();
        Object column = map.get("column");
        Object columnko = map.get("columnko");
        Object gsdm = map.get("gsdm");
        Object where = map.get("where");
        Object group = map.get("group");
        Object date = map.get("date");
        Object xfield = map.get("xfield");
        Object name = map.get("name");
        column = (column == null) ? "" : column;
        gsdm = (gsdm == null) ? "" : gsdm;
        where = (where == null) ? "" : where;
        group = (group == null) ? "" : group;
        date = (date == null) ? "" : date.toString().replace("-", "");
        xfield = (xfield == null) ? "" : xfield;
        name = (name == null) ? "" : name;
        columnko = (columnko == null) ? "" : columnko;

        paramsMap.put("column", column.toString());
        paramsMap.put("group", group.toString());
        paramsMap.put("gsdm", gsdm.toString());
        paramsMap.put("where", where.toString());
        paramsMap.put("date", date.toString());
        paramsMap.put("columnko", columnko.toString());
        paramsMap.put("xfield", xfield.toString());
        return paramsMap;
    }
}
