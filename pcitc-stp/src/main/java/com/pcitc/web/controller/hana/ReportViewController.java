package com.pcitc.web.controller.hana;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.hana.report.ReportViewVo;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.DataTableLayui;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/report")
public class ReportViewController extends BaseController {

    private static final String GET_LIST = "http://pcitc-zuul/hana-proxy/hana/report/getReport";
    private static final String GET_LIST_TREE = "http://pcitc-zuul/hana-proxy/hana/report/getReportTree";
    private static final String LIST_REPORT = "http://pcitc-zuul/system-proxy/reportcolumn-provider/reportcolumn/reportcolumn_list_config";

    /**
     * 页面跳转
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/reportPage")
    public String researchanalysis() {
        String strId = request.getParameter("name");
        if (strId == null) {
            strId = "164f98a6b8c_c4effcc1";
        }
        request.setAttribute("name", strId);
        //获取配置信息，拼装标准json字符串，放入request
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
        requestBody.add("id", strId);
        System.out.println("strId = " + strId);
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);

        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LIST_REPORT, HttpMethod.POST, entity, JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        request.setAttribute("wd_obj_array", JSON.toJSONString(retJson.get("wd_obj_array")));
        request.setAttribute("zb_obj_array", JSON.toJSONString(retJson.get("zb_obj_array")));
        request.setAttribute("wd_show_obj_array", JSON.toJSONString(retJson.get("wd_show_obj_array")));
        request.setAttribute("wd_hide_obj_array", JSON.toJSONString(retJson.get("wd_hide_obj_array")));
        request.setAttribute("zb_show_obj_array", JSON.toJSONString(retJson.get("zb_show_obj_array")));
        request.setAttribute("zb_hide_obj_array", JSON.toJSONString(retJson.get("zb_hide_obj_array")));
        request.setAttribute("default_wd_zb_obj_array", JSON.toJSONString(retJson.get("default_wd_zb_obj_array")));
        request.setAttribute("default_x_obj_array", JSON.toJSONString(retJson.get("default_x_obj_array")));
        request.setAttribute("default_column_obj_array", JSON.toJSONString(retJson.get("default_column_obj_array")));
        return "layui/tree_tableDemo";
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

        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
        String str = JSONObject.toJSONString(this.getParameterMap(request));
        System.out.println("getTableReport = " + str);
        requestBody.add("paramsJson", str);

        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);
        ResponseEntity<com.alibaba.fastjson.JSONArray> responseEntity = restTemplate.exchange(GET_LIST, HttpMethod.POST, entity, com.alibaba.fastjson.JSONArray.class);
        com.alibaba.fastjson.JSONArray json = responseEntity.getBody();
        List<ReportViewVo> reportViewVos = JSONObject.parseArray(json.toJSONString(), ReportViewVo.class);
        System.out.println("getTableReport-reportViewVos= " + reportViewVos);
        DataTableLayui data = new DataTableLayui();
        data.setData(reportViewVos);
        data.setMsg("");
        data.setCode("0");
        System.out.println("data = " + JSON.toJSONString(data));
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

        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
        String str = JSONObject.toJSONString(this.getParameterMap(request));
        System.out.println("getTableReportTree = " + str);
        requestBody.add("paramsJson", str);

        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);
        ResponseEntity<com.alibaba.fastjson.JSONArray> responseEntity = restTemplate.exchange(GET_LIST_TREE, HttpMethod.POST, entity, com.alibaba.fastjson.JSONArray.class);
        com.alibaba.fastjson.JSONArray json = responseEntity.getBody();
        System.out.println("json = " + json);
//        List<ReportViewVo> reportViewVos = com.alibaba.fastjson.JSONObject.parseArray(json.toJSONString(), ReportViewVo.class);
        DataTableLayui data = new DataTableLayui();
        data.setData(json);
        data.setMsg("");
        data.setCode("0");
        System.out.println("getTableReportTree-data = " + JSON.toJSONString(data));
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

        System.out.println("column = " + column);
        System.out.println("gsdm = " + gsdm);
        System.out.println("name = " + name);
        System.out.println("where = " + where);
        System.out.println("group = " + group);
        System.out.println("date = " + date);
        System.out.println("columnko = " + columnko);

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
}
