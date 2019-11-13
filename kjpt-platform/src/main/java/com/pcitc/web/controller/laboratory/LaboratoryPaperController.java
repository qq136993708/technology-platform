package com.pcitc.web.controller.laboratory;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Result;
import com.pcitc.base.laboratory.LaboratoryPaper;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.web.utils.UserProfileAware;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.base.doc.SysFileKind;
import com.pcitc.web.common.OperationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.pcitc.web.common.BaseController;
import com.pcitc.base.util.DataTableInfoVo;
import com.pcitc.base.util.DateTableUtil;
import com.pcitc.web.common.DataTableParameter;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * <p>控制类</p>
 * <p>Table: laboratory_paper - 实验室-知识产权-论文</p>
 *
 * @since 2019-07-01 09:12:52
 */

@Controller
public class LaboratoryPaperController extends BaseController {
    /**
     * 根据ID获取对象信息
     */
    private static final String GET_INFO = "http://pcitc-zuul/stp-proxy/laboratorypaper-provider/laboratorypaper/get-laboratorypaper/";
    /**
     * 树形
     */
    private static final String TREE_DATA = "http://pcitc-zuul/stp-proxy/laboratorypaper-provider/laboratorypaper/tree-data";
    /**
     * 逻辑删除
     */
    private static final String DEL = "http://pcitc-zuul/stp-proxy/laboratorypaper-provider/laboratorypaper/del-laboratorypaper/";
    /**
     * 物理删除
     */
    private static final String DEL_REAL = "http://pcitc-zuul/stp-proxy/laboratorypaper-provider/laboratorypaper/del-laboratorypaper-real/";

    /**
     * 查询列表
     */
    private static final String LIST = "http://pcitc-zuul/stp-proxy/laboratorypaper-provider/laboratorypaper/laboratorypaper_list";
    /**
     * 参数查询
     */
    private static final String LISTPARAM = "http://pcitc-zuul/stp-proxy/laboratorypaper-provider/laboratorypaper/laboratorypaper_list_param";
    /**
     * 分页查询
     */
    private static final String LISTPAGE = "http://pcitc-zuul/stp-proxy/laboratorypaper-provider/laboratorypaper/laboratorypaper-page";
    /**
     * 保存
     */
    private static final String SAVE = "http://pcitc-zuul/stp-proxy/laboratorypaper-provider/laboratorypaper/save_laboratorypaper";

    /**
     * 实验室-知识产权-论文-查询列表
     *
     * @param laboratoryPaper
     * @return
     */
    @RequestMapping(value = "/laboratoryPaper/list", method = RequestMethod.POST)
    @ResponseBody
    public Object getList(@RequestBody LaboratoryPaper laboratoryPaper) {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LIST, HttpMethod.POST, new HttpEntity<LaboratoryPaper>(laboratoryPaper, this.httpHeaders), JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        List<LaboratoryPaper> list = (List<LaboratoryPaper>) retJson.get("list");
        return list;
    }

    @RequestMapping(value = "/laboratoryPaper/listParam", method = RequestMethod.POST)
    @ResponseBody
    public Object getListParam(@RequestParam String id) {
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
        requestBody.add("id", request.getParameter("id") + "");
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(requestBody, this.httpHeaders);
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(LISTPARAM, HttpMethod.POST, entity, JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        List<LaboratoryPaper> list = (List<LaboratoryPaper>) retJson.get("list");
        return list;
    }

    /**
     * 实验室-知识产权-论文-分页查询
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "/laboratoryPaper/getTableData", method = RequestMethod.POST)
    @ResponseBody
    public Object getTableData(@ModelAttribute("param") LayuiTableParam param) {
        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
        ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(LISTPAGE, HttpMethod.POST, entity, LayuiTableData.class);
        LayuiTableData data = responseEntity.getBody();
        return JSON.toJSON(data).toString();
    }

    /**
     * 保存-实验室-知识产权-论文
     *
     * @param record
     * @return
     */
    @RequestMapping(value = "/laboratoryPaper/saveLaboratoryPaper")
    @ResponseBody
    @OperationFilter(modelName = "实验室-知识产权-论文", actionName = "保存saveRecord")
    public int saveRecord(LaboratoryPaper record) {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
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
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVE, HttpMethod.POST, new HttpEntity<LaboratoryPaper>(record, this.httpHeaders), Integer.class);
        Integer result = responseEntity.getBody();
        return result;
    }

    /**
     * 编辑页面-实验室-知识产权-论文
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/laboratoryPaper/edit")
    @OperationFilter(modelName = "实验室-知识产权-论文", actionName = "跳转编辑页面pageEdit")
    public String pageEdit(String id, Model model, String opt) {
        model.addAttribute("id", id);
        model.addAttribute("opt", opt);
        return "stp/laboratory/laboratoryPaper_edit";
    }

    /**
     * 详情页面-实验室-知识产权-论文
     *
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/laboratoryPaper/view/{dataId}")
    @OperationFilter(modelName = "实验室-知识产权-论文", actionName = "跳转详情页面pageView")
    public String pageView(@PathVariable("dataId") String dataId, Model model) {
        model.addAttribute("id", dataId);
        model.addAttribute("opt", "");
        model.addAttribute("dataId", (dataId == null || "".equals(dataId)) ? UUID.randomUUID().toString().replace("-", "") : dataId);
        return "stp/laboratory/laboratoryPaper_view";
    }

    /**
     * 跳转至实验室-知识产权-论文列表页面
     *
     * @return
     */
    @RequestMapping(value = "/laboratoryPaper/toListPage", method = {RequestMethod.GET})
    @OperationFilter(modelName = "实验室-知识产权-论文", actionName = "跳转列表页toListPage")
    public String toListPage() {
        return "stp/laboratory/laboratoryPaper_list";
    }

    /**
     * 根据ID查询对象信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/laboratoryPaper/getLaboratoryPaperInfo")
    @OperationFilter(modelName = "实验室-知识产权-论文", actionName = "根据ID查询对象信息getlaboratoryPaperInfo")
    @ResponseBody
    public Object getlaboratoryPaperInfo(HttpServletRequest request) {
        String id = request.getParameter("id");
        ResponseEntity<LaboratoryPaper> responseEntity = this.restTemplate.exchange(GET_INFO + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), LaboratoryPaper.class);
        LaboratoryPaper news = responseEntity.getBody();
        return news;
    }

    @RequestMapping(value = "/laboratoryPaper/tree-data")
    @ResponseBody
    @OperationFilter(modelName = "实验室-知识产权-论文", actionName = "树形查询getLaboratoryPaperTreeData()")
    public Object getLaboratoryPaperTreeData() throws Exception {
        TreeNode node = this.restTemplate.exchange(TREE_DATA, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), TreeNode.class).getBody();
        return node;
    }

    @RequestMapping(value = "/laboratoryPaper/tree-datas")
    @OperationFilter(modelName = "实验室-知识产权-论文", actionName = "树形查询getLaboratoryPaperTreeData()")
    @ResponseBody
    public String getLaboratoryPaperTreeDatas(HttpServletRequest request) throws Exception {
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        List list = this.restTemplate.exchange(TREE_DATA, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), List.class).getBody();
        return JSONUtils.toJSONString(list);
    }

    @OperationFilter(modelName = "删除实验室-知识产权-论文", actionName = "根据ID删除实验室-知识产权-论文")
    @RequestMapping(value = "/laboratoryPaper/del", method = RequestMethod.POST)
    @ResponseBody
    public Object delLaboratoryPaper() throws Exception {
        Integer rs = this.restTemplate.exchange(DEL + request.getParameter("id"), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class).getBody();
        if (rs > 0) {
            return new Result(true, "操作成功！");
        } else {
            return new Result(false, "保存失败请重试！");
        }
    }

    @OperationFilter(modelName = "物理删除实验室-知识产权-论文", actionName = "根据ID物理删除实验室-知识产权-论文")
    @RequestMapping(value = "/laboratoryPaper/del-real", method = RequestMethod.POST)
    @ResponseBody
    public Object delLaboratoryPaperReal() throws Exception {
        Integer rs = this.restTemplate.exchange(DEL_REAL + request.getParameter("id"), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class).getBody();
        if (rs > 0) {
            return new Result(true, "操作成功！");
        } else {
            return new Result(false, "保存失败请重试！");
        }
    }

}