package com.pcitc.web.controller.expert;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.*;
import com.pcitc.base.expert.*;
import com.pcitc.base.hana.report.AchievementsAnalysis;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.ReverseSqlResult;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.OperationFilter;
import com.pcitc.web.utils.HanaUtil;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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


    private static final String LIST_CG_TABLE = "http://pcitc-zuul/stp-proxy/zjkchengguo-provider/zjkchengguo/zjkchengguo-page";

    private static final String LIST_ZL_TABLE = "http://pcitc-zuul/stp-proxy/zjkzhuanli-provider/zjkzhuanli/zjkzhuanli-page";


    private static final String SAVECHOICE = "http://pcitc-zuul/stp-proxy/zjkchoice-provider/zjkchoice/save_zjkchoice_update";


    //备选查询
    private static final String LISTBAK = "http://pcitc-zuul/stp-proxy/zjkchoice-provider/zjkchoice/zjkchoice_list";
    //备选移除
    private static final String DEL_BAK = "http://pcitc-zuul/stp-proxy/zjkchoice-provider/zjkchoice/del-zjkchoice-real/";

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "stp/expert/eee";
    }


    /**
     * 查询专家总数量
     *
     * @return
     */
    @RequestMapping(value = "/expertIndex", method = RequestMethod.GET)
    @OperationFilter(modelName = "专家-首页跳转", actionName = "首页跳转pageExpertIndex")
    public String pageExpertIndex() {
        //人员总数
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LIST, HttpMethod.POST, new HttpEntity<ZjkBaseInfo>(new ZjkBaseInfo(), this.httpHeaders), JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        List<ZjkBaseInfo> list = (List<ZjkBaseInfo>) retJson.get("list");
        request.setAttribute("expertCount", list.size());//人员总数

        //成果总数
        ResponseEntity<JSONObject> responseCgEntity = this.restTemplate.exchange(LISTCG, HttpMethod.POST, new HttpEntity<ZjkChengguo>(new ZjkChengguo(), this.httpHeaders), JSONObject.class);
        JSONObject retJsonCg = responseCgEntity.getBody();
        List<ZjkChengguo> listCg = (List<ZjkChengguo>) retJsonCg.get("list");
        request.setAttribute("cgCount", listCg.size());//成果总数

        //专利总数
        ResponseEntity<JSONObject> responseZlEntity = this.restTemplate.exchange(LISTZL, HttpMethod.POST, new HttpEntity<ZjkZhuanli>(new ZjkZhuanli(), this.httpHeaders), JSONObject.class);
        JSONObject retJsonZl = responseZlEntity.getBody();
        List<ZjkZhuanli> listZl = (List<ZjkZhuanli>) retJsonZl.get("list");
        request.setAttribute("zlCount", listZl.size());//专利总数

        //机构总数
        ZjkChoice zjkChoice = new ZjkChoice();
        zjkChoice.setStatus("2");//2选中数量
        ResponseEntity<JSONObject> responseEntityJG = this.restTemplate.exchange(LIST, HttpMethod.POST, new HttpEntity<ZjkChoice>(zjkChoice, this.httpHeaders), JSONObject.class);
        List<ZjkChoice> listJG = (List<ZjkChoice>) responseEntityJG.getBody().get("list");
        List<ZjkChoice> unique = listJG.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(ZjkChoice::getCompanyId))), ArrayList::new)
        );
        unique.forEach(p -> System.out.println(p));
        request.setAttribute("jlCount", unique.size());//机构总数

        return "stp/expert/pageExpertIndex";
    }

    /**
     * 跳转到查询页面
     * @return
     */
    @RequestMapping(value = "/queryExpert", method = RequestMethod.GET)
    @OperationFilter(modelName = "专家-查询跳转", actionName = "查询跳转queryExpert")
    public String queryExpert() {

        request.setAttribute("hyly",request.getParameter("hyly"));
        request.setAttribute("jg",request.getParameter("jg"));
        request.setAttribute("zjmc",request.getParameter("zjmc"));
        request.setAttribute("key",request.getParameter("key"));
        request.setAttribute("nld",request.getParameter("nld"));
        request.setAttribute("zc",request.getParameter("zc"));
        request.setAttribute("gb",request.getParameter("gb"));
        return "stp/expert/queryExpert";
    }


    /**
     * 专家信息分页查询
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "/queryIndex", method = RequestMethod.POST)
    @ResponseBody
    @OperationFilter(modelName = "首页-查询", actionName = "查询列表queryIndex")
    public Object queryIndex(@ModelAttribute("param") LayuiTableParam param) {
        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
        ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(LISTPAGEINDEX, HttpMethod.POST, entity, LayuiTableData.class);
        LayuiTableData data = responseEntity.getBody();
        return JSON.toJSON(data).toString();
    }

    /**
     * 专家详情
     *
     * @return
     */
    @RequestMapping(value = "/expertDetail", method = RequestMethod.GET)
    @OperationFilter(modelName = "专家-专家详情", actionName = "专家详情pageExpertDetail")
    public String pageExpertDetail() {
        //专家详情
        String expertId = request.getParameter("expertId");
        ResponseEntity<ZjkBaseInfo> responseEntity = this.restTemplate.exchange(GET_INFO + expertId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), ZjkBaseInfo.class);
        ZjkBaseInfo zjkBaseInfo = responseEntity.getBody();
        request.setAttribute("zjkBaseInfo", zjkBaseInfo);
        request.setAttribute("hylyName", zjkBaseInfo.getHylyName());
        request.setAttribute("hyly", zjkBaseInfo.getHyly());
        //成果
        ZjkChengguo zjkChengguo = new ZjkChengguo();
        zjkChengguo.setZjId(expertId);
        ResponseEntity<JSONObject> responseEntityCg = this.restTemplate.exchange(LISTCG, HttpMethod.POST, new HttpEntity<ZjkChengguo>(zjkChengguo, this.httpHeaders), JSONObject.class);
        JSONObject retJsonCg = responseEntityCg.getBody();
        List<ZjkChengguo> list = (List<ZjkChengguo>) retJsonCg.get("list");
        request.setAttribute("listCg", list);
        //专利
        ZjkZhuanli zjkZhuanli = new ZjkZhuanli();
        zjkZhuanli.setZjId(expertId);
        ResponseEntity<JSONObject> responseZlEntity = this.restTemplate.exchange(LISTZL, HttpMethod.POST, new HttpEntity<ZjkZhuanli>(zjkZhuanli, this.httpHeaders), JSONObject.class);
        JSONObject retJsonZl = responseZlEntity.getBody();
        List<ZjkZhuanli> listZl = (List<ZjkZhuanli>) retJsonZl.get("list");
        request.setAttribute("listZl", listZl);
        // 行业领域count
        String strHyly = zjkBaseInfo.getHyly();
        if (strHyly == null || "".equals(strHyly)) {
            request.setAttribute("hylyCount", "0");
        } else {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("strHyly",strHyly);
            ResponseEntity<JSONObject> responseEntityHyly = this.restTemplate.exchange(LIST_EXAMPLE, HttpMethod.POST, new HttpEntity<JSONObject>(jsonObject, this.httpHeaders), JSONObject.class);
            JSONObject retJson = responseEntityHyly.getBody();
            List<ZjkBaseInfo> listHyly = (List<ZjkBaseInfo>) retJson.get("list");
            request.setAttribute("hylyCount", listHyly == null ? "0" : listHyly.size());
        }
        return "stp/expert/expertDetail";
    }

    /**
     * 成果信息分页查询
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "/queryCgList", method = RequestMethod.POST)
    @ResponseBody
    @OperationFilter(modelName = "成果查询", actionName = "查询列表queryCgList")
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
    @OperationFilter(modelName = "专利查询", actionName = "查询列表queryZlList")
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
    @OperationFilter(modelName = "专家-人员选择", actionName = "保存saveRecord")
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
        record.setStatus("0");
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
    @OperationFilter(modelName = "专家-人员选择", actionName = "保存saveRecord")
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
        record.setStatus("1");
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVECHOICE, HttpMethod.POST, new HttpEntity<ZjkChoice>(record, this.httpHeaders), Integer.class);
        Integer result = responseEntity.getBody();
        return result;
    }

    /**
     * 备选查询
     *
     * @param zjkChoice
     * @return
     */
    @RequestMapping(value = "/selectBakList", method = RequestMethod.GET)
    @OperationFilter(modelName = "专家-备选人员查询", actionName = "备选查询列表selectBakList")
    public String selectBakList(@RequestBody ZjkChoice zjkChoice) {
//        zjkChoice.setStatus("1");
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LISTBAK, HttpMethod.POST, new HttpEntity<ZjkChoice>(zjkChoice, this.httpHeaders), JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        List<ZjkChoice> list = (List<ZjkChoice>) retJson.get("list");
        request.setAttribute("bakList", list);
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
    public Object delBak() throws Exception {
        Integer rs = this.restTemplate.exchange(DEL_BAK + request.getParameter("id"), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class).getBody();
        if (rs > 0) {
            return new Result(true, "操作成功！");
        } else {
            return new Result(false, "保存失败请重试！");
        }
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
    public int saveRecord(ZjkBaseInfo record) {
        if (record.getId() == null || "".equals(record.getId())) {
            record.setCreateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
            record.setCreateUser(sysUserInfo.getUserId());
            record.setCreateUserName(sysUserInfo.getUserName());
        } else {
            record.setUpdateDate(DateUtil.format(new Date(), DateUtil.FMT_SS));
            record.setUpdateUser(sysUserInfo.getUserId());
        }
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVE, HttpMethod.POST, new HttpEntity<ZjkBaseInfo>(record, this.httpHeaders), Integer.class);
        Integer result = responseEntity.getBody();
        return result;
    }

    //---------------------------------pic--------------------------
    private static final String Echart = "http://pcitc-zuul/stp-proxy/zjkbaseinfo-provider/zjkbaseinfo/echarts";
    /**
     * 首页图形展示
     * @return
     */
    @RequestMapping(value = "/picIndex", method = RequestMethod.GET)
    @ResponseBody
    @OperationFilter(modelName = "首页图形展示", actionName = "首页图形展示indexPicTwo")
    public Object indexPicTwo() {
        String type = request.getParameter("type");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("type",type);
        jsonObject.put("id",request.getParameter("id"));

//        if ("force".equals(type)){
//            //添加自定义中心字段
//            String expertId = request.getParameter("expertId");
//            ResponseEntity<ZjkBaseInfo> responseEntity = this.restTemplate.exchange(GET_INFO + expertId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), ZjkBaseInfo.class);
//            ZjkBaseInfo zjkBaseInfo = responseEntity.getBody();
//            jsonObject.put(ChartForceResultData.name,zjkBaseInfo.getName());
//            jsonObject.put(ChartForceResultData.value,zjkBaseInfo.getId());
//        }

        try {
            jsonObject.put("param",ReverseSqlResult.getParameterMap(request));
        } catch (Exception e) {
            e.printStackTrace();
        }
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(Echart, HttpMethod.POST, new HttpEntity<JSONObject>(jsonObject,this.httpHeaders), JSONObject.class);
        JSONObject object = responseEntity.getBody();
//        System.out.println(object);

        return object.get("result");
//        return JSONObject.parseObject(JSONObject.toJSONString(object.get("result"))).toString();
    }
}