package com.pcitc.web.controller.search;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.*;
import com.pcitc.base.hana.report.*;
import com.pcitc.base.system.SysNews;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.utils.HanaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

@Controller
@RequestMapping(value = "/fullSearch")
public class SearchFullController extends BaseController {

    private static final String common_table = "http://pcitc-zuul/system-proxy/search/getTableDataScientific";
    private static final String contract_dic = "http://pcitc-zuul/system-proxy/out-project-provider/select-condition/list";

    private static final String getAwardTable = "http://pcitc-zuul/system-proxy/search/getTableDataAchivement";

    private static final String search = "http://pcitc-zuul/system-proxy/search/search";





    private static final String[] tabString = {"科研","成果"};

    @RequestMapping(method = RequestMethod.GET, value = "/searchIndex")
    public String searchIndex(HttpServletRequest request) throws Exception {
        request.setAttribute("keyword", request.getParameter("keyword"));
        return "stp/hana/home/search/search_index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public String search(HttpServletRequest request) throws Exception {
        request.setAttribute("keyword", request.getParameter("keyword"));
        return "stp/hana/home/search/search";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/getTableSearch")
    @ResponseBody
    public String getTableSearch(@ModelAttribute("param") LayuiTableParam param) {
        LayuiTableData layuiTableData = new LayuiTableData();
        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
        ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(search, HttpMethod.POST, entity, LayuiTableData.class);
        layuiTableData = responseEntity.getBody();
        return JSONObject.toJSONString(layuiTableData);
    }


    /**
     * -------------------------------------------------成果-------------------------------------
     */


    @RequestMapping(method = RequestMethod.POST, value = "/getTableDataAchivement")
    @ResponseBody
    public String getTableDataAchivement(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {

        JSONObject tt = JSONObject.parseObject(JSONObject.toJSONString(param));
        LayuiTableData layuiTableData = new LayuiTableData();
        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
        ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(getAwardTable, HttpMethod.POST, entity, LayuiTableData.class);
        int statusCode = responseEntity.getStatusCodeValue();
        if (statusCode == 200) {
            layuiTableData = responseEntity.getBody();
        }
        JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
        return result.toString();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/query_achievement")
    public String achievement(HttpServletRequest request) throws Exception {

        SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
        HanaUtil.setSearchParaForUser(userInfo, restTemplate, httpHeaders, request);
        String unitCode = userInfo.getUnitCode();
        request.setAttribute("unitCode", unitCode);

        String year = HanaUtil.getCurrrentYear();
        request.setAttribute("year", year);
        request.setAttribute("keyword", request.getParameter("keyword"));
        return "stp/hana/home/search/query_achievement";
    }

    /**-------------------------------------------------科研-------------------------------------*/
    /**
     * 科研查询
     *
     * @param param
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/getTableDataScientific")
    @ResponseBody
    public String getTableData(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {

        LayuiTableData layuiTableData = new LayuiTableData();
        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
        ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(common_table, HttpMethod.POST, entity, LayuiTableData.class);
        int statusCode = responseEntity.getStatusCodeValue();
        if (statusCode == 200) {
            layuiTableData = responseEntity.getBody();
        }
//        JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
        return JSONObject.toJSONString(layuiTableData);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/query_scientific")
    public String query_scientific(HttpServletRequest request) throws Exception {

        //成果

        //科技
        String nd = HanaUtil.getCurrrentYear();
        request.setAttribute("nd", nd);
        String xmmc = CommonUtil.getParameter(request, "xmmc", "");//项目名
        String hth = CommonUtil.getParameter(request, "hth", "");//合同号
        String define1 = CommonUtil.getParameter(request, "define1", "");//资本性、费用性
        String define2 = CommonUtil.getParameter(request, "define2", "");//8大院等细分结构
        String define3 = CommonUtil.getParameter(request, "define3", "");//直属研究院、分子公司、集团等9种类型
        String project_property = CommonUtil.getParameter(request, "project_property", "");//国家项目、重大专项、重点项目、其他项目
        String project_scope = CommonUtil.getParameter(request, "project_scope", "");//新开项目、续建项目、完工项目
        String zylb = CommonUtil.getParameter(request, "zylb", "");//装备的各种技术类型
        String zycmc = CommonUtil.getParameter(request, "zycmc", "");//各个处室

        request.setAttribute("zycmc", zycmc);
        request.setAttribute("xmmc", xmmc);
        request.setAttribute("hth", hth);
        request.setAttribute("define1", define1);
        request.setAttribute("define2", define2);
        request.setAttribute("define3", define3);
        request.setAttribute("project_property", project_property);
        request.setAttribute("project_scope", project_scope);
        request.setAttribute("zylb", zylb);
        request.setAttribute("keyword", request.getParameter("keyword"));

        String projectId = CommonUtil.getParameter(request, "projectId", "");
        request.setAttribute("projectId", projectId);

        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("nd", nd);
        JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
        HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);

        ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(contract_dic, HttpMethod.POST, entity, JSONArray.class);
        int statusCode = responseEntity.getStatusCodeValue();
        if (statusCode == 200) {
            JSONArray jSONArray = responseEntity.getBody();
            List<String> define1List = new ArrayList<String>();
            List<String> define21List = new ArrayList<String>();//8大研究院
            List<String> type_flagList = new ArrayList<String>();
            List<String> zylbList = new ArrayList<String>();
            for (int i = 0; i < jSONArray.size(); i++) {
                Map object = (Map) jSONArray.get(i);
                String showCode = (String) object.get("showCode");
                String showName = (String) object.get("showName");
                if (showCode.equals("define1")) {
                    define1List.add(showName);
                }
                if (showCode.equals("define2")) {
                    define21List.add(showName);
                }
                if (showCode.equals("type_flag")) {
                    type_flagList.add(showName);
                }
                if (showCode.equals("zylb")) {
                    zylbList.add(showName);
                }
            }
            request.setAttribute("define1List", define1List);
            request.setAttribute("define21List", define21List);
            request.setAttribute("type_flagList", type_flagList);
            request.setAttribute("zylbList", zylbList);
        }
        return "stp/hana/home/search/query_scientific";
    }
}
