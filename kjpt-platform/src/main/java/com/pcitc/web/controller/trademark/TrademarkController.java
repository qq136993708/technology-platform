package com.pcitc.web.controller.trademark;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.patent.PatentInfo;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.trademarkinfo.TrademarkInfo;
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


@Controller
@RequestMapping("trademarkController")
public class TrademarkController extends BaseController{

    private static final String SAVE = "http://kjpt-zuul/stp-proxy/trademark-provider/trademarkInfo/trademarkInfo_save";

    private static final String QUERY = "http://kjpt-zuul/stp-proxy/trademark-provider/trademarkInfo/trademarkInfo_query";

    private static final String LOAD = "http://kjpt-zuul/stp-proxy/trademark-provider/trademarkInfo/trademarkInfo_load";

    private static final String DELETE = "http://kjpt-zuul/stp-proxy/trademark-provider/trademarkInfo/trademarkInfo_delete";

    //private static final String NEW = "http://kjpt-zuul/stp-proxy/trademark-provider/trademarkInfo/trademarkInfo_new";

    /**
     * 保存-商标信息
     *
     * @param trademarkInfo
     * @return
     */
    @RequestMapping(value = "/save",method=RequestMethod.POST)
    @ResponseBody
    @OperationFilter(modelName = "商标信息", actionName = "保存商标信息")
    public int save(TrademarkInfo trademarkInfo) {
        SysUser sysUserInfo = getUserProfile();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        if (trademarkInfo.getId() == null || "".equals(trademarkInfo.getId())) {
           //创建人和创建时间
        } else {
            //更新人和更新时间
        }
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVE, HttpMethod.POST, new HttpEntity<TrademarkInfo>(trademarkInfo, this.httpHeaders), Integer.class);
        Integer result = responseEntity.getBody();
        return result;
    }

    /**
     * 商标列表-分页查询
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
     * 根据ID查询商标信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/load")
    @ResponseBody
    @OperationFilter(modelName = "商标信息", actionName = "根据ID查询商标信息")
    public Object load(HttpServletRequest request) {
        String id = request.getParameter("id");
        ResponseEntity<TrademarkInfo> responseEntity = this.restTemplate.exchange(LOAD + id, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), TrademarkInfo.class);
        TrademarkInfo trademarkInfo = responseEntity.getBody();
        return trademarkInfo;
    }

    @OperationFilter(modelName = "删除商标信息", actionName = "根据ID删除商标信息")
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
    @OperationFilter(modelName = "商标信息", actionName = "初始化商标信息")
    public JSONObject newInit(HttpServletRequest request) {
        JSONObject map = new JSONObject(1);
        TrademarkInfo trademarkInfo = new TrademarkInfo();
        map.put("model",trademarkInfo);
        return map;
    }
}
