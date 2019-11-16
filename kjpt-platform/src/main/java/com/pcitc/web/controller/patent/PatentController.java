package com.pcitc.web.controller.patent;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.expert.ZjkExpert;
import com.pcitc.base.patent.PatentInfo;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.OperationFilter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("patentController")
public class PatentController extends BaseController {

    private static final String SAVE = "http://kjpt-zuul/stp-proxy/patent-provider/patentInfo/patentInfo_save";

    private static final String QUERY = "http://kjpt-zuul/stp-proxy/patent-provider/patentInfo/patentInfo_query";

    private static final String LOAD = "http://kjpt-zuul/stp-proxy/patent-provider/patentInfo/patentInfo_load";

    private static final String DELETE = "http://kjpt-zuul/stp-proxy/patent-provider/patentInfo/patentInfo_delete";

    //private static final String NEW = "http://kjpt-zuul/stp-proxy/patent-provider/patentInfo/patentInfo_new";

    /**
     * 保存-专利信息
     *
     * @param patentInfo
     * @return
     */
    @RequestMapping(value = "/save",method=RequestMethod.POST)
    @ResponseBody
    @OperationFilter(modelName = "专利信息", actionName = "保存专利信息")
    public int save(PatentInfo patentInfo) {
        SysUser sysUserInfo = getUserProfile();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        if (patentInfo.getId() == null || "".equals(patentInfo.getId())) {
            patentInfo.setCreateDate(new Date());
            patentInfo.setCreator(sysUserInfo.getUserName());
        } else {
            patentInfo.setUpdateDate(new Date());
            patentInfo.setUpdator(sysUserInfo.getUserName());
        }
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVE, HttpMethod.POST, new HttpEntity<PatentInfo>(patentInfo, this.httpHeaders), Integer.class);
        Integer result = responseEntity.getBody();
        return result;
    }

    /**
     * 专利列表-分页查询
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    @ResponseBody
    public Object query(@ModelAttribute("param") LayuiTableParam param) {
        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
        ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(QUERY, HttpMethod.POST, entity, LayuiTableData.class);
        LayuiTableData data = responseEntity.getBody();
        System.out.println(JSON.toJSON(data).toString());
        return JSON.toJSON(data).toString();
    }


    /**
     * 根据ID查询专利信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/load")
    @ResponseBody
    @OperationFilter(modelName = "专利信息", actionName = "根据ID查询专利信息")
    public Object load(HttpServletRequest request) {
        String id = request.getParameter("id");
        ResponseEntity<PatentInfo> responseEntity = this.restTemplate.exchange(LOAD + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), PatentInfo.class);
        PatentInfo patentInfo = responseEntity.getBody();
        return patentInfo;
    }

    @OperationFilter(modelName = "删除专利信息", actionName = "根据ID删除专利信息")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Object delete() throws Exception {
        System.out.println("伪删除:" + request.getParameter("id"));
        Integer rs = this.restTemplate.exchange(DELETE + request.getParameter("id"), HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class).getBody();
        if (rs > 0) {
            return new Result(true, "操作成功！");
        } else {
            return new Result(false, "保存失败请重试！");
        }
    }

    /**
     * 初始化方法
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/newInit")
    @ResponseBody
    @OperationFilter(modelName = "专利信息", actionName = "初始化专利信息")
    public JSONObject newInit(HttpServletRequest request) {
        JSONObject map = new JSONObject(1);
        PatentInfo patentInfo = new PatentInfo();
        patentInfo.setCreator("");
        patentInfo.setCreateDate(new Date());
        map.put("model",patentInfo);
        return map;
    }
}
