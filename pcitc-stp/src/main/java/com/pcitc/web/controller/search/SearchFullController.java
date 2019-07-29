package com.pcitc.web.controller.search;

import java.text.DecimalFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcitc.base.common.*;
import com.pcitc.base.search.ZjkSearchLog;
import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.base.system.SearchLog;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.util.StrUtil;
import com.pcitc.web.utils.EquipmentUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.hana.report.H1AMKYSY100117;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.utils.HanaUtil;

@Controller
public class SearchFullController extends BaseController {

    private static final String common_table = "http://pcitc-zuul/system-proxy/search/getTableDataScientific";
    private static final String contract_dic = "http://pcitc-zuul/system-proxy/out-project-provider/select-condition/list";

    private static final String getAwardTable = "http://pcitc-zuul/system-proxy/search/getTableDataAchivement";
    private static final String getTableSearchEquipment = "http://pcitc-zuul/system-proxy/search/getTableSearchEquipment";
    private static final String getTableDataReport = "http://pcitc-zuul/system-proxy/search/getTableDataReport";
    private static final String getOutRewardTable = "http://pcitc-zuul/system-proxy/search/reward-list";

    private static final String search = "http://pcitc-zuul/system-proxy/search/search";

    private static final String equipment_02 = "http://pcitc-zuul/hana-proxy/hana/home/get_home_KYZB_02";

    private static final String[] tabString = {"科研", "成果"};

    @RequestMapping(method = RequestMethod.GET, value = "/fullSearch/searchEquipment")
    public String searchEquipment(HttpServletRequest request) throws Exception {
        request.setAttribute("keyword", request.getParameter("keyword"));
        String hotKeyWord = request.getParameter("hotKeyWord");
        request.setAttribute("hotKeyWord", (hotKeyWord == null || "".equals(hotKeyWord)) ? "" : java.net.URLDecoder.decode(hotKeyWord, "utf-8"));
        System.out.println(request.getAttribute("hotKeyWord"));
        SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
        HanaUtil.setSearchParaForUser(userInfo, restTemplate, httpHeaders, request);
        String unitCode = userInfo.getUnitCode();
        request.setAttribute("unitCode", unitCode);

        String year = HanaUtil.getCurrentYear();
        request.setAttribute("year", year);

        String leadUnitCode = EquipmentUtils.getEquipmentUnitCode(sysUserInfo, restTemplate, httpHeaders);
        request.setAttribute("leadUnitCode", leadUnitCode);
        request.setAttribute("userLevel", sysUserInfo.getUserLevel());

        request.setAttribute("YJY_CODE_NOT_YINGKE", HanaUtil.YJY_CODE_NOT_YINGKE);
        return "stp/hana/home/search/query_equipment";
    }

    //保存搜索日志
    private static final String SAVE_SEARCH_LOG = "http://pcitc-zuul/system-proxy/zjksearchlog-provider/zjksearchlog/save_zjksearchlog";

    @RequestMapping(method = RequestMethod.GET, value = "/fullSearch/searchIndex")
    public String searchIndex(HttpServletRequest request) throws Exception {
        String keyword = request.getParameter("keyword");
        request.setAttribute("keyword", keyword);
        String hotKeyWord = request.getParameter("hotKeyWord");
        request.setAttribute("hotKeyWord", (hotKeyWord == null || "".equals(hotKeyWord)) ? "" : java.net.URLDecoder.decode(hotKeyWord, "utf-8"));
        System.out.println(request.getAttribute("hotKeyWord"));
        return "stp/hana/home/search/search_index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/fullSearch/searchExpert")
    public String searchExpert(HttpServletRequest request) throws Exception {
        request.setAttribute("keyword", request.getParameter("keyword"));
        String hotKeyWord = request.getParameter("hotKeyWord");
        request.setAttribute("hotKeyWord", (hotKeyWord == null || "".equals(hotKeyWord)) ? "" : java.net.URLDecoder.decode(hotKeyWord, "utf-8"));
        System.out.println(request.getAttribute("hotKeyWord"));
        return "stp/hana/home/search/query_expert";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/fullSearch/searchPatent")
    public String searchPatent(HttpServletRequest request) throws Exception {
        request.setAttribute("keyword", request.getParameter("keyword"));
        String hotKeyWord = request.getParameter("hotKeyWord");
        request.setAttribute("hotKeyWord", (hotKeyWord == null || "".equals(hotKeyWord)) ? "" : java.net.URLDecoder.decode(hotKeyWord, "utf-8"));
        System.out.println(request.getAttribute("hotKeyWord"));
        return "stp/hana/home/search/query_patent";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/fullSearch/searchFile")
    public String searchFile(HttpServletRequest request) throws Exception {
        String keyword = request.getParameter("keyword");
        request.setAttribute("keyword", (keyword == null || "undefined".equals(keyword)) ? "" : keyword);
        String hotKeyWord = request.getParameter("hotKeyWord");
        String userid = sysUserInfo.getUserId();
        request.setAttribute("hotKeyWord", (hotKeyWord == null || "".equals(hotKeyWord)) ? "" : java.net.URLDecoder.decode(hotKeyWord, "utf-8"));
        request.setAttribute("userid", userid);

        return "stp/hana/home/search/query_file";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/fullSearch/searchOutreward")
    public String searchOutreward(HttpServletRequest request) throws Exception {
        request.setAttribute("keyword", request.getParameter("keyword"));
        String hotKeyWord = request.getParameter("hotKeyWord");
        request.setAttribute("hotKeyWord", (hotKeyWord == null || "".equals(hotKeyWord)) ? "" : java.net.URLDecoder.decode(hotKeyWord, "utf-8"));
        System.out.println(request.getAttribute("hotKeyWord"));
        return "stp/hana/home/search/query_outreward";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/fullSearch/searchTfmType")
    public String searchTfmType(HttpServletRequest request) throws Exception {
        request.setAttribute("keyword", request.getParameter("keyword"));
        String hotKeyWord = request.getParameter("hotKeyWord");
        request.setAttribute("hotKeyWord", (hotKeyWord == null || "".equals(hotKeyWord)) ? "" : java.net.URLDecoder.decode(hotKeyWord, "utf-8"));
        System.out.println(request.getAttribute("hotKeyWord"));
        return "stp/hana/home/search/query_tfmType";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/fullSearch/searchReport")
    public String searchReport(HttpServletRequest request) throws Exception {
        request.setAttribute("keyword", request.getParameter("keyword"));
        String hotKeyWord = request.getParameter("hotKeyWord");
        request.setAttribute("hotKeyWord", (hotKeyWord == null || "".equals(hotKeyWord)) ? "" : java.net.URLDecoder.decode(hotKeyWord, "utf-8"));
        System.out.println(request.getAttribute("hotKeyWord"));
        return "stp/hana/home/search/query_report";
    }

    private static final String getListEs = "http://pcitc-zuul/system-proxy/zjksearchlog-provider/zjksearchlog/getListEs";

    @RequestMapping(method = RequestMethod.GET, value = "/fullSearch/search")
    public String search(HttpServletRequest request) {
        try {
            String keyword = request.getParameter("keyword");
            String hotKeyWord = "";
            if (keyword != null && !"".equals(keyword)) {
                //插入搜索
                ZjkSearchLog record = new ZjkSearchLog();
                record.setKeyword(keyword);
                record.setKeywordIk(keyword);
                if (record.getDataId() == null || "".equals(record.getDataId())) {
                    record.setCreateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
                    record.setCreateUser(sysUserInfo.getUserId());
                    record.setCreateUserDisp(sysUserInfo.getUserName());
                } else {
                    record.setUpdateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
                    record.setUpdatePersonId(sysUserInfo.getUserId());
                    record.setUpdatePersonName(sysUserInfo.getUserName());
                }
                record.setStatus("0");
                this.restTemplate.exchange(SAVE_SEARCH_LOG, HttpMethod.POST, new HttpEntity<ZjkSearchLog>(record, this.httpHeaders), Integer.class);
            }
            request.setAttribute("keyword", keyword);

            //查询热点
            HotWord hotWord = new HotWord();
            hotWord.setField("keywordIk");//keywordIk  keyword
            hotWord.setIndices("search");
            hotWord.setSize(10);
            hotWord.setTerms("hotWord");
            hotWord.setTypes("searchlog");
            ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(getListEs, HttpMethod.POST, new HttpEntity<HotWord>(hotWord, this.httpHeaders), JSONObject.class);
            JSONObject retJson = responseEntity.getBody();
            List<String> list = (List<String>) retJson.get("list");
            request.setAttribute("hotKeyWord", org.apache.commons.lang3.StringUtils.join(list, ","));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "stp/hana/home/search/search";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/fullSearch/getTableSearchEquipment")
    @ResponseBody
    public String getTableSearchEquipment(@ModelAttribute("param") LayuiTableParam param) throws Exception {

        JSONObject tt = JSONObject.parseObject(JSONObject.toJSONString(param));
        LayuiTableData layuiTableData = new LayuiTableData();
        if (StrUtil.isNullLayuiTableParam(param)) {
            layuiTableData.setCount(0);
            return JSONObject.toJSONString(layuiTableData);
        } else {
        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
        ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(getTableSearchEquipment, HttpMethod.POST, entity, LayuiTableData.class);
        int statusCode = responseEntity.getStatusCodeValue();
        if (statusCode == 200) {
            layuiTableData = responseEntity.getBody();
        }
        JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
        return result.toString();
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/fullSearch/getTableSearch")
    @ResponseBody
    public String getTableSearch(@ModelAttribute("param") LayuiTableParam param) {

        PageResult pageResult = new PageResult();
        String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
        String companyCode = CommonUtil.getParameter(request, "companyCode", "");
        param.getParam().put("month", month);
        param.getParam().put("companyCode", companyCode);
        param.getParam().put("fileCount", request.getParameter("fileCount"));

        LayuiTableData layuiTableData = new LayuiTableData();
        if (StrUtil.isNullLayuiTableParam(param)){
            layuiTableData.setCount(0);
            return JSONObject.toJSONString(layuiTableData);
        }else {
            HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
            ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(search, HttpMethod.POST, entity, LayuiTableData.class);
            layuiTableData = responseEntity.getBody();
            return JSONObject.toJSONString(layuiTableData);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/fullSearch/getTableDataReport")
    @ResponseBody
    public String getTableDataReport(@ModelAttribute("param") LayuiTableParam param) {
        LayuiTableData layuiTableData = new LayuiTableData();
        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
        ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(getTableDataReport, HttpMethod.POST, entity, LayuiTableData.class);
        layuiTableData = responseEntity.getBody();
        return JSONObject.toJSONString(layuiTableData);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/fullSearch/getEquipmentIsShow")
    @ResponseBody
    public String getEquipmentIsShow(HttpServletRequest request) {
        String flag = "0";
        if (sysUserInfo.getUserLevel()!=2) {
            //同一个院
            String leadUnitCode = EquipmentUtils.getEquipmentUnitCode(sysUserInfo, restTemplate, httpHeaders);
            if (leadUnitCode.equals(request.getParameter("leadUnitCode"))){
                flag="1";
            }
            //判断科技处
            if (Arrays.asList(sysUserInfo.getUnitCode().split(",")).contains("30130054")){
                flag = "1";
            }
        }else {
            flag="1";
        }
        return flag;
    }

    /**
     * -------------------------------------------------成果----------------------
     * ---------------
     */

    @RequestMapping(method = RequestMethod.POST, value = "/fullSearch/getTableDataAchivement")
    @ResponseBody
    public String getTableDataAchivement(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {

        LayuiTableData layuiTableData = new LayuiTableData();

        if (StrUtil.isNullLayuiTableParam(param)){
            layuiTableData.setCount(0);
            return JSONObject.toJSONString(layuiTableData);
        }else {
//            JSONObject tt = JSONObject.parseObject(JSONObject.toJSONString(param));
            HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
            ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(getAwardTable, HttpMethod.POST, entity, LayuiTableData.class);
            int statusCode = responseEntity.getStatusCodeValue();
            if (statusCode == 200) {
                layuiTableData = responseEntity.getBody();
            }
            JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
            return result.toString();
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/fullSearch/getTableDataOutReward")
    @ResponseBody
    public String getTableDataOutReward(@ModelAttribute("param") LayuiTableParam param) {

        JSONObject tt = JSONObject.parseObject(JSONObject.toJSONString(param));
        LayuiTableData layuiTableData = new LayuiTableData();

        if (StrUtil.isNullLayuiTableParam(param)){
            layuiTableData.setCount(0);
            return JSONObject.toJSONString(layuiTableData);
        }else {
            HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
            ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(getOutRewardTable, HttpMethod.POST, entity, LayuiTableData.class);
            int statusCode = responseEntity.getStatusCodeValue();
            if (statusCode == 200) {
                layuiTableData = responseEntity.getBody();
            }
            JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
            return result.toString();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/fullSearch/query_achievement")
    public String achievement(HttpServletRequest request) throws Exception {
        request.setAttribute("keyword", request.getParameter("keyword"));
        //归属部门
        List<SysDictionary> departmentList = EquipmentUtils.getSysDictionaryListByParentCode("ROOT_ZGSHJT_ZBJG", restTemplate, httpHeaders);
        request.setAttribute("departmentList", departmentList);
        //专业领域
        List<SysDictionary> fieldList = EquipmentUtils.getSysDictionaryListByParentCode("ROOT_ZBGL_ZYLY", restTemplate, httpHeaders);
        request.setAttribute("fieldList", fieldList);
        //流程状态
        List<SysDictionary> auditStatusList = EquipmentUtils.getSysDictionaryListByParentCode("ROOT_UNIVERSAL_LCZT", restTemplate, httpHeaders);
        request.setAttribute("auditStatusList", auditStatusList);
        List<SysDictionary> dicList = CommonUtil.getDictionaryByParentCode("ROOT_UNIVERSAL_BDYJY", restTemplate,
                httpHeaders);
        request.setAttribute("dicList", dicList);
        String hotKeyWord = request.getParameter("hotKeyWord");
        request.setAttribute("hotKeyWord", (hotKeyWord == null || "".equals(hotKeyWord)) ? "" : java.net.URLDecoder.decode(hotKeyWord, "utf-8"));
        System.out.println(request.getAttribute("hotKeyWord"));
        return "stp/hana/home/search/query_achievement";
    }

    /**
     * -------------------------------------------------科研----------------------
     * ---------------
     */
    /**
     * 科研查询
     *
     * @param param
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/fullSearch/getTableDataScientific")
    @ResponseBody
    public String getTableData(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {

        LayuiTableData layuiTableData = new LayuiTableData();
        if (StrUtil.isNullLayuiTableParam(param)){
            layuiTableData.setCount(0);
            return JSONObject.toJSONString(layuiTableData);
        }else {
            HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
            ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(common_table, HttpMethod.POST, entity, LayuiTableData.class);
            layuiTableData = responseEntity.getBody();
            return JSONObject.toJSONString(layuiTableData);
        }

    }


    @RequestMapping(method = RequestMethod.GET, value = "/fullSearch/query_scientific")
    public String query_scientific(HttpServletRequest request) throws Exception {
        request.setAttribute("keyword", request.getParameter("keyword"));
//
//        String nd = CommonUtil.getParameter(request, "nd", "");// 项目名
//        String ysnd = CommonUtil.getParameter(request, "ysnd", "");// 项目名
//        String xmmc = CommonUtil.getParameter(request, "xmmc", "");// 项目名
//        String hth = CommonUtil.getParameter(request, "hth", "");// 合同号
//        String define1 = CommonUtil.getParameter(request, "define1", "");// 资本性、费用性
//        String define2 = CommonUtil.getParameter(request, "define2", "");// 8大院等细分结构
//        String define3 = CommonUtil.getParameter(request, "define3", "");// 直属研究院、分子公司、集团等9种类型
//        String project_property = CommonUtil.getParameter(request, "project_property", "");// 国家项目、重大专项、重点项目、其他项目
//        String project_scope = CommonUtil.getParameter(request, "project_scope", "");// 新开项目、续建项目、完工项目
//        String zylb = CommonUtil.getParameter(request, "zylb", "");// 装备的各种技术类型
//        String define10 = CommonUtil.getParameter(request, "define10", "");// 各个处室
//        String qdbz = CommonUtil.getParameter(request, "qdbz", "");// 签订标识
//        String define11 = CommonUtil.getParameter(request, "define11", "");// 费用来源
//        String define12 = CommonUtil.getParameter(request, "define12", "");// 单位类别
//
//        request.setAttribute("define12", define12);
//        request.setAttribute("define11", define11);
//        request.setAttribute("qdbz", qdbz);
//        request.setAttribute("nd", nd);
//        request.setAttribute("ysnd", ysnd);
//        request.setAttribute("define10", define10);
//        request.setAttribute("xmmc", xmmc);
//        request.setAttribute("hth", hth);
//        request.setAttribute("define1", define1);
//        request.setAttribute("define2", define2);
//        request.setAttribute("define3", define3);
//        request.setAttribute("project_property", project_property);
//        request.setAttribute("project_scope", project_scope);
//        request.setAttribute("zylb", zylb);
//        String projectId = CommonUtil.getParameter(request, "projectId", "");
//        request.setAttribute("projectId", projectId);
//
//        Map<String, Object> paramsMap = new HashMap<String, Object>();
//        paramsMap.put("nd", nd);
//        JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
//        HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
//
//        ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(contract_dic, HttpMethod.POST, entity, JSONArray.class);
//        int statusCode = responseEntity.getStatusCodeValue();
//        if (statusCode == 200) {
//            JSONArray jSONArray = responseEntity.getBody();
//            System.out.println(">>>>>>>>>>>>>common_table jSONArray " + jSONArray.toString());
//
//            List<String> define1List = new ArrayList<String>();
//            List<String> define21List = new ArrayList<String>();// 8大研究院
//            List<String> type_flagList = new ArrayList<String>();
//            List<String> zylbList = new ArrayList<String>();
//            List<String> zycmcList = new ArrayList<String>();
//            List<String> define11List = new ArrayList<String>();
//            List<String> define12List = new ArrayList<String>();
//            for (int i = 0; i < jSONArray.size(); i++) {
//                Map object = (Map) jSONArray.get(i);
//                String showCode = (String) object.get("showCode");
//                String showName = (String) object.get("showName");
//                if (showCode.equals("define1")) {
//                    if (showName != null && !showName.equals("")) {
//                        define1List.add(showName);
//                    }
//
//                }
//                if (showCode.equals("define2")) {
//                    define21List.add(showName);
//                }
//                if (showCode.equals("type_flag")) {
//                    type_flagList.add(showName);
//                }
//                if (showCode.equals("zylb")) {
//                    zylbList.add(showName);
//                }
//                if (showCode.equals("define10")) {
//
//                    if (showName != null && !showName.equals("")) {
//                        zycmcList.add(showName);
//                    }
//                }
//                if (showCode.equals("define11")) {
//
//                    if (showName != null && !showName.equals("")) {
//                        define11List.add(showName);
//                    }
//                }
//
//                if (showCode.equals("define12")) {
//
//                    if (showName != null && !showName.equals("")) {
//                        define12List.add(showName);
//                    }
//                }
//
//            }
//            request.setAttribute("define1List", define1List);
//            request.setAttribute("define21List", define21List);
//            request.setAttribute("type_flagList", type_flagList);
//            request.setAttribute("zylbList", zylbList);
//            request.setAttribute("zycmcList", zycmcList);
//            request.setAttribute("define11List", define11List);
//            request.setAttribute("define12List", define12List);
//            List<String> qdbzList = new ArrayList<String>();
//            qdbzList.add("已签订");
//            qdbzList.add("未签订");
//            request.setAttribute("qdbzList", qdbzList);
//        }
        String hotKeyWord = request.getParameter("hotKeyWord");
        request.setAttribute("hotKeyWord", (hotKeyWord == null || "".equals(hotKeyWord)) ? "" : java.net.URLDecoder.decode(hotKeyWord, "utf-8"));
        System.out.println(request.getAttribute("hotKeyWord"));
        return "stp/hana/home/search/query_scientific";
    }
}
