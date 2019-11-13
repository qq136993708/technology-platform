package com.pcitc.web.controller.expert;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.ResultSKM;
import com.pcitc.base.expert.ZjkAchievement;
import com.pcitc.base.expert.ZjkChoice;
import com.pcitc.base.expert.ZjkExpert;
import com.pcitc.base.expert.ZjkPatent;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.ReverseSqlResult;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.OperationFilter;
import com.pcitc.web.utils.RestfulHttpClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.xmlbeans.XmlErrorCodes.LIST;

@Controller
@RequestMapping("skmController")
public class SKMController extends BaseController {

    //专家接口
    private static final String SKM_expert = "http://10.225.14.211/expertFind.php";
    // 成果接口
    private static final String SKM_achievement = "http://ip:port/项目名称/kmsearch/cgFind";
    // 成果总量接口
    private static final String SKM_achievement_count = "http://ip:port/项目名称/kmsearch/cgTotals?keyword=";
    //专利总量接口
    private static final String SKM_patent_count = "http://ip:port/项目名称/kmsearch/zlTotals?keyword=";
    //专利接口
    private static final String SKM_patent = "http://ip:port/项目名称/kmsearch/zlFind";
    //知识分类接口
    private static final String SKM_type = "http://ip:port/kmsystem/kmClassifyFind.php";

    //专家保存
    private static final String save_Expert = "http://kjpt-zuul/stp-proxy/dataSKM-provider/dataSKM/saveExpert";
    //成果保存
    private static final String save_achievement = "http://kjpt-zuul/stp-proxy/dataSKM-provider/dataSKM/saveAchievement";
    //专利保存
    private static final String save_patent = "http://kjpt-zuul/stp-proxy/dataSKM-provider/dataSKM/savePatent";
    //知识分类
    private static final String save_type = "http://kjpt-zuul/stp-proxy/dataSKM-provider/dataSKM/saveType";

    private static final int limit = 2000;
    /**
     * 知识分类接口
     *
     * @return
     */
    @RequestMapping("/SKM_type")
    public Result SKM_type() {
        Result result = new Result();
        try {
            ResponseEntity<ResultSKM> forEntity = restTemplate.getForEntity(SKM_type, ResultSKM.class);
            ResultSKM result_obj = forEntity.getBody();
            if ("200".equals(result_obj.getStatus())) {
                result.setSuccess(false);
                result.setMessage("调用知识分类接口异常");
            } else {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("rs", JSONObject.toJSONString(result_obj));
                ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(save_type, HttpMethod.POST, new HttpEntity<JSONObject>(jsonObject, this.httpHeaders), JSONObject.class);
            }
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("调用知识分类接口异常");
            e.printStackTrace();
        } finally {
            return result;
        }
    }

    /**
     * 专利接口
     *
     * @return
     */
    @RequestMapping("/SKM_patent")
    public Result SKM_patent() {
        Result result = new Result();
        try {
            //TO DO 1，keyword为空时，代表什么意思；2，from代表什么意思；3，项目名称代表什么意思
            String keyword = request.getParameter("keyword");
            ResponseEntity<ResultSKM> entity_count = restTemplate.getForEntity(SKM_patent_count + keyword, ResultSKM.class);
            //返回数量
            ResultSKM result_count = entity_count.getBody();
            int count = 0;
            if (!"200".equals(result_count.getStatus())) {
                result.setSuccess(false);
                result.setMessage("调用专利总数量接口异常");
            } else {
                count = (int) result_count.data;
                int page = count % limit > 0 ? (count / limit + 1) : count / limit;
                for (int i = 0; i < page; i++) {
                    ResponseEntity<ResultSKM> forEntity = restTemplate.getForEntity(SKM_patent + "?Keyword=" + ((keyword==null||"".equals(keyword))?"":keyword) + "&from="+i, ResultSKM.class);
                    ResultSKM result_obj = forEntity.getBody();
                    if (!"200".equals(result_obj.getStatus())) {
                        result.setSuccess(false);
                        result.setMessage("调用专利接口异常");
                    } else {
                        JSONObject jsonObject = new JSONObject();
                        jsonObject.put("rs", JSONObject.toJSONString(result_obj));
                        jsonObject.put("from", "SKM");
                        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(save_patent, HttpMethod.POST, new HttpEntity<JSONObject>(jsonObject, this.httpHeaders), JSONObject.class);
                    }
                }
            }
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("调用专利接口异常");
            e.printStackTrace();
        } finally {
            return result;
        }
    }

    /**
     * 成果接口
     *
     * @return
     */
    @RequestMapping("/SKM_achievement")
    public Result SKM_achievement() {
        Result result = new Result();
        try {
            //TO DO 1，keyword为空时，代表什么意思；2，from代表什么意思；3，项目名称代表什么意思
            String keyword = request.getParameter("keyword");
            ResponseEntity<ResultSKM> entity_count = restTemplate.getForEntity(SKM_achievement_count + keyword, ResultSKM.class);
            //返回数量
            ResultSKM result_count = entity_count.getBody();
            int count = 0;
            if (!"200".equals(result_count.getStatus())) {
                result.setSuccess(false);
                result.setMessage("调用成果总数量接口异常");
            } else {
                count = (int) result_count.data;
                int page = count % limit > 0 ? (count / limit + 1) : count / limit;
                for (int i = 0; i < page; i++) {
                    ResponseEntity<ResultSKM> forEntity = restTemplate.getForEntity(SKM_achievement + "?Keyword=" + ((keyword==null||"".equals(keyword))?"":keyword) + "&from="+i, ResultSKM.class);
                    ResultSKM result_obj = forEntity.getBody();
                    if (!"200".equals(result_obj.getStatus())) {
                        result.setSuccess(false);
                        result.setMessage("调用成果接口异常");
                    } else {
                        JSONObject jsonObject = new JSONObject();
                        jsonObject.put("rs", JSONObject.toJSONString(result_obj));
                        jsonObject.put("from", "SKM");
                        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(save_achievement, HttpMethod.POST, new HttpEntity<JSONObject>(jsonObject, this.httpHeaders), JSONObject.class);
                    }
                }
          }
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("调用成果接口异常");
            e.printStackTrace();
        } finally {
            return result;
        }
    }

    /**
     * 专家调用
     *
     * @return
     */
    @RequestMapping(value = "/SKM_expert", method = RequestMethod.GET)
    public Result SKM_expert() {
        Result result = new Result();
        try {
            ResultSKM resultSKM = new ResultSKM();
            try {
                List<String> authorization = this.httpHeaders.get("Authorization");
                System.out.println(authorization.get(0));
                RestfulHttpClient.HttpResponse response = RestfulHttpClient.getClient(SKM_expert).get().addHeader("token", authorization.get(0)) .request();
                resultSKM = JSON.parseObject(response.getContent(),ResultSKM.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 根据状态码判断请求是否成功
            if (!"200".equals(resultSKM.getCode())) {
                result.setSuccess(false);
                result.setMessage("调用专家接口异常");
            } else {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("rs", JSONObject.toJSONString(resultSKM));
                jsonObject.put("from", "SKM");
                ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(save_Expert, HttpMethod.POST, new HttpEntity<JSONObject>(jsonObject, this.httpHeaders), JSONObject.class);
            }
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("调用专家接口异常");
            e.printStackTrace();
        } finally {
            return result;
        }
    }
}