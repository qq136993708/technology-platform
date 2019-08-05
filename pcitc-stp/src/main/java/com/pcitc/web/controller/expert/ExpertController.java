package com.pcitc.web.controller.expert;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.*;
import com.pcitc.base.expert.*;
import com.pcitc.base.stp.out.OutPatent;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.system.SysUnit;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.ReverseSqlResult;
import com.pcitc.base.util.StrUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.OperationFilter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>控制类</p>
 * <p>Table: zjk_base_info - 专家-基本信息</p>
 *
 * @since 2018-12-08 04:10:36
 */

@Controller
@RequestMapping("expertController")
public class ExpertController extends BaseController {
    /**
     * 根据ID获取对象信息
     */
    private static final String GET_INFO = "http://pcitc-zuul/stp-proxy/zjkbaseinfo-provider/zjkbaseinfo/get-zjkbaseinfo/";
    /**
     * 树形
     */
    private static final String TREE_DATA = "http://pcitc-zuul/stp-proxy/zjkbaseinfo-provider/zjkbaseinfo/tree-data";
    /**
     * 逻辑删除
     */
    private static final String DEL = "http://pcitc-zuul/stp-proxy/zjkbaseinfo-provider/zjkbaseinfo/del-zjkbaseinfo/";
    /**
     * 物理删除
     */
    private static final String DEL_REAL = "http://pcitc-zuul/stp-proxy/zjkbaseinfo-provider/zjkbaseinfo/del-zjkbaseinfo-real/";

    /**
     * 查询列表
     */
    private static final String LIST = "http://pcitc-zuul/stp-proxy/zjkbaseinfo-provider/zjkbaseinfo/zjkbaseinfo_list";
    //查询所有人员列表,姓名&ID
    private static final String queryAllExpert = "http://pcitc-zuul/stp-proxy/zjkbaseinfo-provider/zjkbaseinfo/queryAllExpert";

    private static final String LIST_RANDOM = "http://pcitc-zuul/stp-proxy/zjkbaseinfo-provider/zjkbaseinfo/zjkbaseinfo_list_random";
    private static final String LIST_RANDOM_IMG = "http://pcitc-zuul/stp-proxy/zjkbaseinfo-provider/zjkbaseinfo/zjkbaseinfo_list_img";
    //首页详情专家画像
    private static final String picExpertDetail = "http://pcitc-zuul/stp-proxy/zjkbaseinfo-provider/zjkbaseinfo/picExpertDetail";

    private static final String LIST_index = "http://pcitc-zuul/stp-proxy/zjkbaseinfo-provider/zjkbaseinfo/zjkbaseinfo_list_index";

    private static final String LIST_EXAMPLE = "http://pcitc-zuul/stp-proxy/zjkbaseinfo-provider/zjkbaseinfo/zjkbaseinfo_list_example";
    /**
     * 参数查询
     */
    private static final String LISTPARAM = "http://pcitc-zuul/stp-proxy/zjkbaseinfo-provider/zjkbaseinfo/zjkbaseinfo_list_param";
    /**
     * 分页查询
     */
    private static final String LISTPAGE = "http://pcitc-zuul/stp-proxy/zjkbaseinfo-provider/zjkbaseinfo/zjkbaseinfo-page";
    //首页查询
    private static final String LISTPAGEINDEX = "http://pcitc-zuul/stp-proxy/zjkbaseinfo-provider/zjkbaseinfo/zjkbaseinfo-pageIndex";
    /**
     * 保存
     */
    private static final String SAVE = "http://pcitc-zuul/stp-proxy/zjkbaseinfo-provider/zjkbaseinfo/save_zjkbaseinfo";

    //成果列表
    private static final String LISTCG = "http://pcitc-zuul/stp-proxy/zjkchengguo-provider/zjkchengguo/zjkchengguo_list";
    //专利
    private static final String LISTZL = "http://pcitc-zuul/stp-proxy/zjkzhuanli-provider/zjkzhuanli/zjkzhuanli_list";

    private static final String LIST_OUT_PATENT = "http://pcitc-zuul/system-proxy/out-patent-provider/outpatent_list";

    private static final String LIST_CG_TABLE = "http://pcitc-zuul/stp-proxy/zjkchengguo-provider/zjkchengguo/zjkchengguo-page";

    private static final String LIST_ZL_TABLE = "http://pcitc-zuul/stp-proxy/zjkzhuanli-provider/zjkzhuanli/zjkzhuanli-page";

    private static final String SAVECHOICE = "http://pcitc-zuul/stp-proxy/zjkchoice-provider/zjkchoice/save_zjkchoice_update";

    private static final String SAVECHOICE_BAT = "http://pcitc-zuul/stp-proxy/zjkchoice-provider/zjkchoice/save_zjkchoice_bat";

    //备选查询
    private static final String LISTBAK = "http://pcitc-zuul/stp-proxy/zjkchoice-provider/zjkchoice/zjkchoice_list";
    //备选移除
    private static final String DEL_BAK = "http://pcitc-zuul/stp-proxy/zjkchoice-provider/zjkchoice/del-zjkchoice-real/";
    private static final String DEL_BAK_USERID = "http://pcitc-zuul/stp-proxy/zjkchoice-provider/zjkchoice/del-zjkchoice-zjid";

    //备选查询-table
    private static final String LISTBAKTABLE = "http://pcitc-zuul/stp-proxy/zjkchoice-provider/zjkchoice/zjkchoice-page";
    //选择专家
    private static final String select_expert = "http://pcitc-zuul/stp-proxy/zjkchoice-provider/zjkchoice/select_expert";

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "stp/expert/eee";
    }

    @RequestMapping(value = "/queryAllExpert", method = RequestMethod.GET)
    @ResponseBody
    public String queryAllExpert() {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ZjkExpert expert = new ZjkExpert();
        expert.setiSortCol("expert_name");
        expert.setsSortDir_0("asc");
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(queryAllExpert, HttpMethod.POST, new HttpEntity<ZjkExpert>(expert, this.httpHeaders), JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        List<Map<String, Object>> list = (List<Map<String, Object>>) retJson.get("expert");
        return JSON.toJSONString(list);
    }

    /**
     * 查询专家总数量
     *
     * @return
     */
    @RequestMapping(value = "/expertIndex", method = RequestMethod.GET)
    public String pageExpertIndex() {
        //人员总数
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LIST, HttpMethod.POST, new HttpEntity<ZjkExpert>(new ZjkExpert(), this.httpHeaders), JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        List<ZjkExpert> list = (List<ZjkExpert>) retJson.get("list");
        request.setAttribute("expertCount", list.size());//人员总数

        //成果总数
        ResponseEntity<JSONObject> responseCgEntity = this.restTemplate.exchange(LISTCG, HttpMethod.POST, new HttpEntity<ZjkAchievement>(new ZjkAchievement(), this.httpHeaders), JSONObject.class);
        JSONObject retJsonCg = responseCgEntity.getBody();
        List<ZjkAchievement> listCg = (List<ZjkAchievement>) retJsonCg.get("list");
        request.setAttribute("cgCount", listCg.size());//成果总数

        //专利总数
        ResponseEntity<JSONObject> responseZlEntity = this.restTemplate.exchange(LISTZL, HttpMethod.POST, new HttpEntity<ZjkPatent>(new ZjkPatent(), this.httpHeaders), JSONObject.class);
        JSONObject retJsonZl = responseZlEntity.getBody();
        List<ZjkPatent> listZl = (List<ZjkPatent>) retJsonZl.get("list");
        request.setAttribute("zlCount", listZl.size());//专利总数

        request.setAttribute("cgzlCount", listCg.size() + listZl.size());

        //机构总数
        ZjkChoice zjkChoice = new ZjkChoice();
        zjkChoice.setStatus("2");//2选中数量
        zjkChoice.setUserId("xm");
        ResponseEntity<JSONObject> responseEntityJG = this.restTemplate.exchange(LISTBAK, HttpMethod.POST, new HttpEntity<ZjkChoice>(zjkChoice, this.httpHeaders), JSONObject.class);

        JSONObject retJsonJG = responseEntityJG.getBody();
        List<ZjkChoice> listJg = JSONArray.parseArray(retJsonJG.get("list").toString(), ZjkChoice.class);
        List setjg = listJg.stream().map(ZjkChoice::getCompanyId).distinct().collect(Collectors.toList());
//        List<ZjkChoice> listJG = (List<ZjkChoice>) responseEntityJG.getBody().get("list");
//        List<ZjkChoice> unique = listJG.stream().collect(
//                Collectors.collectingAndThen(
//                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(ZjkChoice::getCompanyId))), ArrayList::new)
//        );
//        unique.forEach(p -> System.out.println(p));
        request.setAttribute("jlCount", setjg.size());//机构总数

        return "stp/expert/pageExpertIndex";
    }

    //图表
    @RequestMapping(value = "/picExpertDetail", method = RequestMethod.GET)
    @ResponseBody
    public Object picExpertDetail() {
        ZjkExpert expert = new ZjkExpert();
        expert.setDataId(request.getParameter("expertId"));
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(picExpertDetail, HttpMethod.POST, new HttpEntity<ZjkExpert>(expert, this.httpHeaders), JSONObject.class);
        return JSONArray.toJSONString(responseEntity.getBody().get("results"));
    }

    @RequestMapping(value = "/picIndexImg", method = RequestMethod.GET)
    @ResponseBody
    public Object indexPicImg() {
        ZjkExpert expert = new ZjkExpert();
        String hyly = request.getParameter("hyly");
        if (hyly != null && !"".equals(hyly)) {
            expert.setExpertProfessionalField(hyly);
        }
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LIST_RANDOM_IMG, HttpMethod.POST, new HttpEntity<ZjkExpert>(expert, this.httpHeaders), JSONObject.class);
        return JSONArray.toJSONString(responseEntity.getBody().get("results"));
    }

    /**
     * 专家画像
     *
     * @return
     */
    @RequestMapping(value = "/expertIndexNewImg", method = RequestMethod.GET)
    public String expertIndexNewImg() {
        //根据条件查询
        //调用
        //放入request
        //获取专家列表10条
        //ajax获取专家数据
//        ZjkExpert expert = new ZjkExpert();
////        expert.setSelect_type("ZJK_XYLY");
//        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LIST_RANDOM_IMG, HttpMethod.POST, new HttpEntity<ZjkExpert>(expert, this.httpHeaders), JSONObject.class);
//
//        JSONObject retJson = responseEntity.getBody();
//        Result result = (Result) retJson.get("results");
//        request.setAttribute("results", result.getData());

        //机构
        ResponseEntity<String> responseEntityJg = restTemplate.exchange(UNIT_LIST_ZTREE_DATA, HttpMethod.POST, new HttpEntity<Object>("", this.httpHeaders), String.class);
        System.out.println(responseEntityJg.getBody());
        request.setAttribute("agent", responseEntityJg.getBody());

        //行业领域
        List<SysDictionary> dictionarys = this.restTemplate.exchange(DICTIONARY_LIST + "ZJK_XYLY", HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class).getBody();

        request.setAttribute("dictionarys", dictionarys);

        return "stp/expert/expertIndexNewImg";
    }

    @RequestMapping(value = "/expertIndexNew", method = RequestMethod.GET)
    public String pageExpertIndexNew() {
        //获取专家列表10条
//        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
//        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LIST_RANDOM, HttpMethod.POST, new HttpEntity<ZjkExpert>(new ZjkExpert(), this.httpHeaders), JSONObject.class);
//        JSONObject retJson = responseEntity.getBody();
//        List<ZjkExpert> list = (List<ZjkExpert>) retJson.get("list");
//        request.setAttribute("list", list);

        //ajax获取专家数据
        ZjkExpert expert = new ZjkExpert();
        expert.setSelect_type("ZJK_XYLY");
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LIST_RANDOM, HttpMethod.POST, new HttpEntity<ZjkExpert>(expert, this.httpHeaders), JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        //List<ZjkExpert> list = (List<ZjkExpert>) retJson.get("list");
        request.setAttribute("expert", retJson.get("list"));

        //机构
        //ResponseEntity<String> responseEntityJg = restTemplate.exchange(UNIT_LIST_ZTREE_DATA, HttpMethod.POST, new HttpEntity<Object>("", this.httpHeaders), String.class);
        //System.out.println(responseEntityJg.getBody());
        //request.setAttribute("agent", responseEntityJg.getBody());

        //行业领域
        //List<?> dictionarys = this.restTemplate.exchange(DICTIONARY_LIST + "ZJK_XYLY", HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class).getBody();

        //request.setAttribute("dictionarys", dictionarys);
//        request.setAttribute("dictionarys",JSON.toJSONString(dictionarys));
        return "stp/expert/pageExpertIndexNew";
    }

    private static final String DICTIONARY_LIST = "http://pcitc-zuul/system-proxy/dictionary-provider/dictionary/";
    private static final String UNIT_LIST_ZTREE_DATA = "http://pcitc-zuul/system-proxy/unit-provider/unit/ztree-unit-list";

    @RequestMapping(value = "/expertIndexData", method = RequestMethod.POST)
    @ResponseBody
    public Object expertIndexData() {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LIST_RANDOM, HttpMethod.POST, new HttpEntity<ZjkExpert>(new ZjkExpert(), this.httpHeaders), JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        List<ZjkExpert> list = (List<ZjkExpert>) retJson.get("list");
        return list;
    }

    /**
     * 跳转到查询页面
     *
     * @return
     */
    @RequestMapping(value = "/queryExpert", method = RequestMethod.GET)
    public String queryExpert() {

        request.setAttribute("hyly", request.getParameter("hyly"));
        request.setAttribute("jg", request.getParameter("jg"));
        request.setAttribute("jgshow", request.getParameter("jgshow"));
        request.setAttribute("zjmc", request.getParameter("zjmc"));
        request.setAttribute("key", request.getParameter("key"));
        request.setAttribute("nld", request.getParameter("nld"));
        request.setAttribute("zc", request.getParameter("zc"));
        request.setAttribute("gb", request.getParameter("gb"));
        List<String> gbcode = sysUserInfo.getInstituteCodes();
        request.setAttribute("gbcode", (gbcode == null || gbcode.size() == 0) ? "" : org.apache.commons.lang3.StringUtils.join(gbcode, ","));
        System.out.println(request.getParameter("gbcode"));
        return "stp/expert/queryExpert";
    }

    /**
     * 跳转到备选
     *
     * @return
     */
    @RequestMapping(value = "/bakTablePage", method = RequestMethod.GET)
    @OperationFilter(modelName = "专家-备选跳转", actionName = "查询跳转bakTablePage")
    public String bakTablePage() {
        request.setAttribute("addUserId", sysUserInfo.getUserId());
        return "stp/expert/bakTable";
    }

    /**
     * 备选信息分页查询
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "/bakTableData", method = RequestMethod.POST)
    @ResponseBody
    public Object bakTableData(@ModelAttribute("param") LayuiTableParam param) {
        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
        ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(LISTBAKTABLE, HttpMethod.POST, entity, LayuiTableData.class);
        LayuiTableData data = responseEntity.getBody();
        return JSON.toJSON(data).toString();
    }

    /**
     * 专家信息分页查询
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "/queryIndex", method = RequestMethod.POST)
    @ResponseBody
    public Object queryIndex(@ModelAttribute("param") LayuiTableParam param) {
        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
        ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(LISTPAGEINDEX, HttpMethod.POST, entity, LayuiTableData.class);
        LayuiTableData data = responseEntity.getBody();
        return JSON.toJSON(data).toString();
    }

    /**
     * @param param
     * @return
     */
    @RequestMapping(value = "/queryOutPatentList", method = RequestMethod.POST)
    @ResponseBody
    public Object queryOutPatentList(@ModelAttribute("param") LayuiTableParam param) {

        LayuiTableData data = new LayuiTableData();
        if (StrUtil.isNullLayuiTableParam(param)) {
            data.setCount(0);
            return JSONObject.toJSONString(data);
        } else {
            HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
            ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(LIST_OUT_PATENT, HttpMethod.POST, entity, LayuiTableData.class);
            data = responseEntity.getBody();
            return JSON.toJSON(data).toString();
        }
    }

    /**
     * 专家详情
     *
     * @return
     */
    @RequestMapping(value = "/expertDetail", method = RequestMethod.GET)
    public String pageExpertDetail() {
        //专家详情
        String expertId = request.getParameter("expertId");
        ResponseEntity<ZjkExpert> responseEntity = this.restTemplate.exchange(GET_INFO + expertId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), ZjkExpert.class);
        ZjkExpert zjkBaseInfo = responseEntity.getBody();
        request.setAttribute("zjkBaseInfo", zjkBaseInfo);
        request.setAttribute("hylyName", zjkBaseInfo.getExpertProfessionalFieldName());
        request.setAttribute("hyly", zjkBaseInfo.getExpertProfessionalField());
        request.setAttribute("display", request.getParameter("display"));
        //成果
//        ZjkAchievement zjkChengguo = new ZjkAchievement();
//        zjkChengguo.setExpertId(expertId);
//        ResponseEntity<JSONObject> responseEntityCg = this.restTemplate.exchange(LISTCG, HttpMethod.POST, new HttpEntity<ZjkAchievement>(zjkChengguo, this.httpHeaders), JSONObject.class);
//        JSONObject retJsonCg = responseEntityCg.getBody();
//        List<ZjkAchievement> list = (List<ZjkAchievement>) retJsonCg.get("list");
//        request.setAttribute("listCg", list);
//        request.setAttribute("listCgCount", list.size());
        //专利
//        ZjkPatent zjkZhuanli = new ZjkPatent();
//        zjkZhuanli.setExpertId(expertId);
//        ResponseEntity<JSONObject> responseZlEntity = this.restTemplate.exchange(LISTZL, HttpMethod.POST, new HttpEntity<ZjkPatent>(zjkZhuanli, this.httpHeaders), JSONObject.class);
//        JSONObject retJsonZl = responseZlEntity.getBody();
//        List<ZjkPatent> listZl = (List<ZjkPatent>) retJsonZl.get("list");
//        request.setAttribute("listZl", listZl);
//        request.setAttribute("listZlCount", listZl.size());

        //查询OutPatent专利数量
//        OutPatent outPatent = new OutPatent();
//        outPatent.setFmr(zjkBaseInfo.getExpertName());
//        ResponseEntity<JSONObject> responseZlEntity = this.restTemplate.exchange(LIST_OUT_PATENT, HttpMethod.POST, new HttpEntity<OutPatent>(outPatent, this.httpHeaders), JSONObject.class);
//        JSONObject retJsonZl = responseZlEntity.getBody();
//        List<OutPatent> listZl = (List<OutPatent>) retJsonZl.get("list");
//        request.setAttribute("listZl", listZl);//专利总数
//        request.setAttribute("zlCount", listZl.size());//专利总数

//        request.setAttribute("cgzlCount", listCg.size() + listZl.size());

        // 行业领域count
        String strHyly = zjkBaseInfo.getExpertProfessionalField();
        if (strHyly == null || "".equals(strHyly)) {
            request.setAttribute("hylyCount", "0");
        } else {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("strHyly", strHyly);
            ResponseEntity<JSONObject> responseEntityHyly = this.restTemplate.exchange(LIST_EXAMPLE, HttpMethod.POST, new HttpEntity<JSONObject>(jsonObject, this.httpHeaders), JSONObject.class);
            JSONObject retJson = responseEntityHyly.getBody();
            List<ZjkExpert> listHyly = (List<ZjkExpert>) retJson.get("list");
            request.setAttribute("hylyCount", listHyly == null ? "0" : listHyly.size());
        }
        //评标机构
        ZjkChoice zjkChoice = new ZjkChoice();
        zjkChoice.setStatus("2");
        zjkChoice.setUserId("xm");
        zjkChoice.setZjId(expertId);
        ResponseEntity<JSONObject> expert = this.restTemplate.exchange(LISTBAK, HttpMethod.POST, new HttpEntity<ZjkChoice>(zjkChoice, this.httpHeaders), JSONObject.class);
        JSONObject retJson = expert.getBody();
        List<ZjkChoice> listJg = JSONArray.parseArray(retJson.get("list").toString(), ZjkChoice.class);
        if (listJg == null || listJg.size() == 0) {
            request.setAttribute("jgCount", 0);
            request.setAttribute("xmCount", 0);
        } else {
            List setjg = listJg.stream().map(ZjkChoice::getCompanyId).distinct().collect(Collectors.toList());
            List setxm = listJg.stream().map(ZjkChoice::getXmId).distinct().collect(Collectors.toList());
            request.setAttribute("jgCount", setjg.size());
            request.setAttribute("xmCount", setxm.size());
        }
        //项目数量

        return "stp/expert/expertDetail";
    }

    /**
     * 专家详情-领导页
     *
     * @return
     */
    @RequestMapping(value = "/expertDetailLeader", method = RequestMethod.GET)
    public String expertDetailLeader() {
        //专家详情
        String expertId = request.getParameter("expertId");
        ResponseEntity<ZjkExpert> responseEntity = this.restTemplate.exchange(GET_INFO + expertId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), ZjkExpert.class);
        ZjkExpert zjkBaseInfo = responseEntity.getBody();
        request.setAttribute("zjkBaseInfo", zjkBaseInfo);
        request.setAttribute("hylyName", zjkBaseInfo.getExpertProfessionalFieldName());
        request.setAttribute("hyly", zjkBaseInfo.getExpertProfessionalField());
        //成果
//        ZjkAchievement zjkChengguo = new ZjkAchievement();
//        zjkChengguo.setExpertId(expertId);
//        ResponseEntity<JSONObject> responseEntityCg = this.restTemplate.exchange(LISTCG, HttpMethod.POST, new HttpEntity<ZjkAchievement>(zjkChengguo, this.httpHeaders), JSONObject.class);
//        JSONObject retJsonCg = responseEntityCg.getBody();
//        List<ZjkAchievement> list = (List<ZjkAchievement>) retJsonCg.get("list");
//        request.setAttribute("listCg", list);
//        request.setAttribute("listCgCount", list.size());
        //专利
//        ZjkPatent zjkZhuanli = new ZjkPatent();
//        zjkZhuanli.setExpertId(expertId);
//        ResponseEntity<JSONObject> responseZlEntity = this.restTemplate.exchange(LISTZL, HttpMethod.POST, new HttpEntity<ZjkPatent>(zjkZhuanli, this.httpHeaders), JSONObject.class);
//        JSONObject retJsonZl = responseZlEntity.getBody();
//        List<ZjkPatent> listZl = (List<ZjkPatent>) retJsonZl.get("list");
//        request.setAttribute("listZl", listZl);
//        request.setAttribute("listZlCount", listZl.size());

        //查询OutPatent专利数量
//        OutPatent outPatent = new OutPatent();
//        outPatent.setFmr(zjkBaseInfo.getExpertName());
//        ResponseEntity<JSONObject> responseZlEntity = this.restTemplate.exchange(LIST_OUT_PATENT, HttpMethod.POST, new HttpEntity<OutPatent>(outPatent, this.httpHeaders), JSONObject.class);
//        JSONObject retJsonZl = responseZlEntity.getBody();
//        List<OutPatent> listZl = (List<OutPatent>) retJsonZl.get("list");
//        request.setAttribute("listZl", listZl);//专利总数
//        request.setAttribute("zlCount", listZl.size());//专利总数

//        request.setAttribute("cgzlCount", listCg.size() + listZl.size());

        // 行业领域count
        String strHyly = zjkBaseInfo.getExpertProfessionalField();
        if (strHyly == null || "".equals(strHyly)) {
            request.setAttribute("hylyCount", "0");
        } else {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("strHyly", strHyly);
            ResponseEntity<JSONObject> responseEntityHyly = this.restTemplate.exchange(LIST_EXAMPLE, HttpMethod.POST, new HttpEntity<JSONObject>(jsonObject, this.httpHeaders), JSONObject.class);
            JSONObject retJson = responseEntityHyly.getBody();
            List<ZjkExpert> listHyly = (List<ZjkExpert>) retJson.get("list");
            request.setAttribute("hylyCount", listHyly == null ? "0" : listHyly.size());
        }
        //评标机构
        ZjkChoice zjkChoice = new ZjkChoice();
        zjkChoice.setStatus("2");
        zjkChoice.setZjId(expertId);
        ResponseEntity<JSONObject> expert = this.restTemplate.exchange(LISTBAK, HttpMethod.POST, new HttpEntity<ZjkChoice>(zjkChoice, this.httpHeaders), JSONObject.class);
        JSONObject retJson = expert.getBody();
        List<ZjkChoice> listJg = JSONArray.parseArray(retJson.get("list").toString(), ZjkChoice.class);
        if (listJg == null || listJg.size() == 0) {
            request.setAttribute("jgCount", 0);
            request.setAttribute("xmCount", 0);
        } else {
            List setjg = listJg.stream().map(ZjkChoice::getCompanyId).distinct().collect(Collectors.toList());
            List setxm = listJg.stream().map(ZjkChoice::getXmId).distinct().collect(Collectors.toList());
            request.setAttribute("jgCount", setjg.size());
            request.setAttribute("xmCount", setxm.size());
        }
        return "stp/expert/expertDetailLeader";
    }

    /**
     * 成果信息分页查询
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "/queryCgList", method = RequestMethod.POST)
    @ResponseBody
    public Object queryCgList(@ModelAttribute("param") LayuiTableParam param) {
        param.setLimit(10000);
        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
        ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(LIST_CG_TABLE, HttpMethod.POST, entity, LayuiTableData.class);
        LayuiTableData data = responseEntity.getBody();
        return JSON.toJSON(data).toString();
    }

    /**
     * 专利信息分页查询
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "/queryZlList", method = RequestMethod.POST)
    @ResponseBody
    public Object queryZlList(@ModelAttribute("param") LayuiTableParam param) {
        param.setLimit(10000);
        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
        ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(LIST_ZL_TABLE, HttpMethod.POST, entity, LayuiTableData.class);
        LayuiTableData data = responseEntity.getBody();
        return JSON.toJSON(data).toString();
    }

    /**
     * 加入备选
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/saveBak")
    @ResponseBody
    public int saveChoice(ZjkChoice record) {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        if (record.getId() == null || "".equals(record.getId())) {
            record.setCreateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
            record.setCreateUser(sysUserInfo.getUserId());
            record.setCreateUserName(sysUserInfo.getUserName());
        } else {
            record.setUpdateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
            record.setUpdateUser(sysUserInfo.getUserId());
        }
        //添加当前人的机构,机构id
        record.setCompanyId(sysUserInfo.getUnitId());
        record.setCompanyName(sysUserInfo.getUnitName());

        record.setAddUserId(sysUserInfo.getUserId());
        record.setStatus("0");
        record.setYear(DateUtil.format(new Date(), DateUtil.FMT_YYYY));
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVECHOICE, HttpMethod.POST, new HttpEntity<ZjkChoice>(record, this.httpHeaders), Integer.class);
        Integer result = responseEntity.getBody();
        return result;
    }

    /**
     * 加入对比
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/addCompare")
    @ResponseBody
    public int addCompare(ZjkChoice record) {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        if (record.getId() == null || "".equals(record.getId())) {
            record.setCreateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
            record.setCreateUser(sysUserInfo.getUserId());
            record.setCreateUserName(sysUserInfo.getUserName());
        } else {
            record.setUpdateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
            record.setUpdateUser(sysUserInfo.getUserId());
        }

        //添加当前人的机构,机构id
        record.setCompanyId(sysUserInfo.getUnitId());
        record.setCompanyName(sysUserInfo.getUnitName());

        record.setAddUserId(sysUserInfo.getUserId());
        record.setStatus("1");
        record.setYear(DateUtil.format(new Date(), DateUtil.FMT_YYYY));
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVECHOICE, HttpMethod.POST, new HttpEntity<ZjkChoice>(record, this.httpHeaders), Integer.class);
        Integer result = responseEntity.getBody();
        return result;
    }

    @RequestMapping(value = "/addChoice")
    @ResponseBody
    @OperationFilter(modelName = "专家-人员选择", actionName = "保存addChoice")
    public int addChoice(ZjkChoice record) {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        if (record.getId() == null || "".equals(record.getId())) {
            record.setCreateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
            record.setCreateUser(sysUserInfo.getUserId());
            record.setCreateUserName(sysUserInfo.getUserName());
        } else {
            record.setUpdateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
            record.setUpdateUser(sysUserInfo.getUserId());
        }

        //添加当前人的机构,机构id
        record.setCompanyId(sysUserInfo.getUnitId());
        record.setCompanyName(sysUserInfo.getUnitName());

        record.setAddUserId(sysUserInfo.getUserId());
        record.setStatus("2");
        record.setYear(DateUtil.format(new Date(), DateUtil.FMT_YYYY));
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVECHOICE, HttpMethod.POST, new HttpEntity<ZjkChoice>(record, this.httpHeaders), Integer.class);
        Integer result = responseEntity.getBody();
        return result;
    }

    @RequestMapping(value = "/addChoiceList")
    @ResponseBody
    public int addChoiceList() {
        String param = request.getParameter("param");
        JSONArray array = JSON.parseArray(param);
        String fileIds = "";
        List<ZjkChoice> zjkChoices = new ArrayList<>();
        for (int i = 0, j = array.size(); i < j; i++) {
            ZjkChoice record = JSONObject.toJavaObject((JSON) array.get(i), ZjkChoice.class);
            record.setAddUserId(sysUserInfo.getUserId());
            record.setYear(DateUtil.format(new Date(), DateUtil.FMT_YYYY));
            record.setCreateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
            record.setCreateUser(sysUserInfo.getUserId());
            record.setCreateUserName(sysUserInfo.getUserName());
            record.setUpdateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
            record.setUpdateUser(sysUserInfo.getUserId());
            fileIds = record.getBak6();
            zjkChoices.add(record);
        }

        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        JSONObject object = new JSONObject();
        object.put("list", JSONArray.toJSONString(zjkChoices));
        //获取文件信息
        this.httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
        form.add("fileIds", fileIds);
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(form, httpHeaders);
        ResponseEntity<FileResult> responseEntityFiles = this.restTemplate.postForEntity(getFilesLayuiByFormId, httpEntity, FileResult.class);
        FileResult body = responseEntityFiles.getBody();

        object.put("files", JSONArray.toJSONString(body.getList()));
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVECHOICE_BAT, HttpMethod.POST, new HttpEntity<JSONObject>(object, this.httpHeaders), Integer.class);
        Integer result = responseEntity.getBody();
        return result;
    }

    private static final String getFilesLayuiByFormId = "http://pcitc-zuul/system-proxy/sysfile-provider/sysfile/getFilesLayuiByFormId";

    /**
     * 备选查询
     *
     * @return
     */
    @RequestMapping(value = "/selectBakList", method = RequestMethod.GET)
    public String selectBakList() {
        String status = request.getParameter("status");
        String addUserId = request.getParameter("addUserId");

        ZjkChoice zjkChoice = new ZjkChoice();
        if (status != null && !"".equals(status)) {
            zjkChoice.setStatus(status);
        }
        if (addUserId != null && !"".equals(addUserId)) {
            zjkChoice.setAddUserId(sysUserInfo.getUserId());
        }

        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LISTBAK, HttpMethod.POST, new HttpEntity<ZjkChoice>(zjkChoice, this.httpHeaders), JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        List<ZjkChoice> list = JSONArray.parseArray(retJson.get("list").toString(), ZjkChoice.class);
        List<ZjkExpert> baseList = JSONArray.parseArray(retJson.get("baseList").toString(), ZjkExpert.class);
        request.setAttribute("bakList", list);
        request.setAttribute("baseList", baseList);
        return "stp/expert/bakList";
    }

    /**
     * 备选删除
     *
     * @return
     * @throws Exception
     */
    @OperationFilter(modelName = "备选专家-删除备选", actionName = "根据ID删除专家-删除备选专家")
    @RequestMapping(value = "/delBak", method = RequestMethod.POST)
    @ResponseBody
    public Object delBak() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("addUserId", sysUserInfo.getUserId());//操作人ＩＤ
        jsonObject.put("expertId", request.getParameter("expertId"));//专家ｉｄ
        this.restTemplate.exchange(DEL_BAK_USERID, HttpMethod.POST, new HttpEntity<JSONObject>(jsonObject, this.httpHeaders), JSONObject.class);
        return new Result(true, "操作成功！");
    }

    /**
     * 修改-专家-基本信息
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/saveZjkBaseInfo")
    @ResponseBody
    @OperationFilter(modelName = "专家-基本信息", actionName = "保存saveRecord")
    public int saveRecord(ZjkExpert record) {
        if (record.getId() == null || "".equals(record.getId())) {
            record.setCreateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
            record.setCreateUser(sysUserInfo.getUserId());
            record.setCreateUserDisp(sysUserInfo.getUserName());
        } else {
            record.setUpdateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
            record.setUpdatePersonName(sysUserInfo.getUserId());
        }
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVE, HttpMethod.POST, new HttpEntity<ZjkExpert>(record, this.httpHeaders), Integer.class);
        Integer result = responseEntity.getBody();
        return result;
    }

    //---------------------------------pic--------------------------
    private static final String Echart = "http://pcitc-zuul/stp-proxy/zjkbaseinfo-provider/zjkbaseinfo/echarts";

    /**
     * 首页图形展示
     *
     * @return
     */
    @RequestMapping(value = "/picIndex", method = RequestMethod.GET)
    @ResponseBody
    @OperationFilter(modelName = "首页图形展示", actionName = "首页图形展示indexPicTwo")
    public Object indexPicTwo() {
        String type = request.getParameter("type");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("type", type);
        jsonObject.put("id", request.getParameter("id"));

//        if ("force".equals(type)){
//            //添加自定义中心字段
//            String expertId = request.getParameter("expertId");
//            ResponseEntity<ZjkExpert> responseEntity = this.restTemplate.exchange(GET_INFO + expertId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), ZjkExpert.class);
//            ZjkExpert zjkBaseInfo = responseEntity.getBody();
//            jsonObject.put(ChartForceResultData.name,zjkBaseInfo.getName());
//            jsonObject.put(ChartForceResultData.value,zjkBaseInfo.getId());
//        }

        try {
            jsonObject.put("param", ReverseSqlResult.getParameterMap(request));
        } catch (Exception e) {
            e.printStackTrace();
        }
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(Echart, HttpMethod.POST, new HttpEntity<JSONObject>(jsonObject, this.httpHeaders), JSONObject.class);
        JSONObject object = responseEntity.getBody();
//        System.out.println(object);

//        return object.get("result");
        return JSONObject.parseObject(JSONObject.toJSONString(object.get("result"))).toString();
    }

    /*--------------------------------------项目开始-----------------------------*/
    private static final String PROJECT_LIST_PAGE = "http://pcitc-zuul/system-proxy/out-provider/project-list-expert";
    //机构查询
    private static final String UNIT_GET_UNIT = "http://pcitc-zuul/system-proxy/unit-provider/unit/get-unit/";

    /**
     * 已选专家页面跳转
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/showExpertPage")
    public String showExpertPage() throws Exception {
        request.setAttribute("projectId", request.getParameter("projectId"));
        return "/stp/expert/showExpertPage";
    }

    /**
     * 项目列表
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/zjkOutProjectList")
    public String iniOutProjectList() throws Exception {
        return "/stp/expert/zjkOutProjectList";
    }

    /**
     * 成果列表-非专家关联
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/zjkAchievementList")
    public String zjkAchievementList() throws Exception {
        return "/stp/expert/zjkAchievementList";
    }

    /**
     * 成果列表-统计展示
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/zjkAchievementListCount")
    public String zjkAchievementListCount() throws Exception {
        request.setAttribute("expertName", request.getParameter("expertName"));
        return "/stp/expert/zjkAchievementList_count";
    }

    /**
     * 专利列表-专家关联
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/zjkPatentList")
    public String zjkPatentList() throws Exception {
        return "/stp/expert/zjkPatentList";
    }

    private static final String LISTPAGE_choice = "http://pcitc-zuul/stp-proxy/zjkchoice-provider/zjkchoice/zjkchoice-page-choice";

    /**
     * 项目列表-已发布
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/zjkOutProjectListPublic")
    public String iniOutProjectListPublic() throws Exception {
        //获取项目ID
        LayuiTableParam param = new LayuiTableParam();
        param.setLimit(100000000);
        param.getParam().put("status", "2");
        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
        ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(LISTPAGE_choice, HttpMethod.POST, entity, LayuiTableData.class);
        LayuiTableData data = responseEntity.getBody();
        List<ZjkChoice> zjkChoices = (List<ZjkChoice>) data.getData();
        List<String> list = new ArrayList<>();
        for (int i = 0, j = data.getData().size(); i < j; i++) {
            Map m = (Map) data.getData().get(i);
            list.add(m.get("xmId") + "");
        }
        request.setAttribute("xmid", org.apache.commons.lang.StringUtils.join(list.toArray(), ","));
        return "/stp/expert/zjkOutProjectListPublic";
    }

    /**
     * 成果列表-非专家关联-已发布
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/zjkAchievementListPublic")
    public String zjkAchievementListPublic() throws Exception {
        //获取项目ID
        LayuiTableParam param = new LayuiTableParam();
        param.setLimit(100000000);
        param.getParam().put("status", "2");
        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
        ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(LISTPAGE_choice, HttpMethod.POST, entity, LayuiTableData.class);
        LayuiTableData data = responseEntity.getBody();
        List<ZjkChoice> zjkChoices = (List<ZjkChoice>) data.getData();
        List<String> list = new ArrayList<>();
        for (int i = 0, j = data.getData().size(); i < j; i++) {
            Map m = (Map) data.getData().get(i);
            list.add(m.get("xmId") + "");
        }
        request.setAttribute("xmid", org.apache.commons.lang.StringUtils.join(list.toArray(), ","));
        return "/stp/expert/zjkAchievementListPublic";
    }

    /**
     * 专利列表-专家关联-已发布
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/zjkPatentListPublic")
    public String zjkPatentListPublic() throws Exception {
        //获取项目ID
        LayuiTableParam param = new LayuiTableParam();
        param.setLimit(100000000);
        param.getParam().put("status", "2");
        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
        ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(LISTPAGE_choice, HttpMethod.POST, entity, LayuiTableData.class);
        LayuiTableData data = responseEntity.getBody();
        List<ZjkChoice> zjkChoices = (List<ZjkChoice>) data.getData();
        List<String> list = new ArrayList<>();
        for (int i = 0, j = data.getData().size(); i < j; i++) {
            Map m = (Map) data.getData().get(i);
            list.add(m.get("xmId") + "");
        }
        request.setAttribute("xmid", org.apache.commons.lang.StringUtils.join(list.toArray(), ","));
        return "/stp/expert/zjkPatentListPublic";
    }

    /**
     * 获取专家统计-专利信息
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/zjkPatentListPublicCount")
    public String zjkPatentListPublicCount() throws Exception {
        String id = request.getParameter("expertId");
        ResponseEntity<ZjkExpert> responseEntity = this.restTemplate.exchange(GET_INFO + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), ZjkExpert.class);
        ZjkExpert news = responseEntity.getBody();
        request.setAttribute("expertName", news.getExpertName());
        return "/stp/expert/zjkPatentListPublic_count";
    }

    /**
     * 获取专家统计-课题
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/zjkOutProjectListPublicCount")
    public String zjkOutProjectListPublicCount() throws Exception {
        String id = request.getParameter("expertId");
        ResponseEntity<ZjkExpert> responseEntity = this.restTemplate.exchange(GET_INFO + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), ZjkExpert.class);
        ZjkExpert news = responseEntity.getBody();
        request.setAttribute("expertName", news.getExpertName());
        return "/stp/expert/zjkOutProjectListPublicCount";
    }

    /**
     * 获取专家统计-奖励
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/zjkOutRewardListPublicCount")
    public String zjkOutRewardListPublicCount() throws Exception {
        String id = request.getParameter("expertId");
        ResponseEntity<ZjkExpert> responseEntity = this.restTemplate.exchange(GET_INFO + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), ZjkExpert.class);
        ZjkExpert news = responseEntity.getBody();
        request.setAttribute("expertName", news.getExpertName());
        return "/stp/expert/zjkOutRewardListPublicCount";
    }

    @RequestMapping(value = "/zjkOutProjectList_tfc")
    public String zjkOutProjectList_tfc() throws Exception {
        request.setAttribute("typeName", request.getParameter("typeName"));
        request.setAttribute("pYear", request.getParameter("pYear"));
        return "/stp/expert/zjkOutProjectList_tfc";
    }

    /**
     * 项目列表-研究院
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/zjkOutProjectListOwner")
    public String zjkOutProjectListOwner() throws Exception {
        return "/stp/expert/zjkOutProjectListOwner";
    }

    @RequestMapping(value = "/outProjectList", method = RequestMethod.POST)
    @OperationFilter(dataFlag = "true")
    @ResponseBody
    public Object outProjectList(@ModelAttribute("param") LayuiTableParam param) {

        System.out.println("====expertController");
        // 数据控制属性
//        String zycbm = request.getAttribute("zycbm") == null ? "" : request.getAttribute("zycbm").toString();
//        String zylbbm = request.getAttribute("zylbbm") == null ? "" : request.getAttribute("zylbbm").toString();
//        param.getParam().put("zycbm", zycbm);
//        param.getParam().put("zylbbm", zylbbm);
        param.getParam().put("leaderFlag", sysUserInfo.getUserLevel());
        param.getParam().put("username", sysUserInfo.getUserName());
        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
        ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(PROJECT_LIST_PAGE, HttpMethod.POST, entity, LayuiTableData.class);
        LayuiTableData retJson = responseEntity.getBody();

        return JSON.toJSON(retJson).toString();
    }

    /**
     * 页面跳转
     *
     * @return
     */
    @RequestMapping(value = "/getUserChoicePage", method = RequestMethod.GET)
    public String getUserChoicePage() {
        String projectName = request.getParameter("projectName");
        try {
            projectName = java.net.URLDecoder.decode(projectName, "UTF-8");
            System.out.println("projectNameprojectNameprojectNameprojectNameprojectNameprojectNameproject" + projectName);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        request.setAttribute("projectId", request.getParameter("projectId"));
        request.setAttribute("projectName", projectName);
        request.setAttribute("unitCode", request.getParameter("unitCode"));
        request.setAttribute("flag", request.getParameter("flag"));
        request.setAttribute("bak6", UUID.randomUUID().toString().replace("-", ""));
        SysUnit unit = this.restTemplate.exchange(UNIT_GET_UNIT + request.getParameter("unitId"), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), SysUnit.class).getBody();
        String strFlag = request.getParameter("flag");
        if ("xm".equals(strFlag)) {
            return "stp/expert/expert_choice";
        } else if ("zl".equals(strFlag)) {
            return "stp/expert/expert_choice_patent";
        } else {
            return "stp/expert/expert_choice_achiement";
        }
    }

    /**
     * 专家查询：随机
     *
     * @return
     */
    @RequestMapping(value = "/getUserChoiceTableData", method = RequestMethod.POST)
    @ResponseBody
    public String getUserChoiceTableData(@ModelAttribute("param") LayuiTableParam param) {
        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
        ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(select_expert, HttpMethod.POST, entity, LayuiTableData.class);
        LayuiTableData data = responseEntity.getBody();
        return JSON.toJSON(data).toString();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/expertDetailIndex")
    public String expertDetailIndex() {
        ResponseEntity<ZjkExpert> responseEntity = this.restTemplate.exchange(GET_INFO + request.getParameter("dataId"), HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), ZjkExpert.class);
        request.setAttribute("expert", responseEntity.getBody());
        return "chart/detail";
    }

    /**
     * 科研人才页面跳转
     *
     * @return
     */
    @RequestMapping(value = "/personnel", method = RequestMethod.GET)
    public String personnel() {
        return "chart/personnel";
    }

    /**
     * 新闻跳转
     *
     * @return
     */
    @RequestMapping(value = "/leader_speech", method = RequestMethod.GET)
    public String leader_speech() {
        return "layui/leader_speech";
    }

    public static void main(String[] args) {
        for (int i = 0; i < 300; i++) {
            System.out.println(UUID.randomUUID().toString().replace("-", ""));
        }
    }
}
