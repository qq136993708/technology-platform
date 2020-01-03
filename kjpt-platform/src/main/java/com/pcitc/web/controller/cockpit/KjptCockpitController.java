package com.pcitc.web.controller.cockpit;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.exception.SysException;
import com.pcitc.web.common.RestBaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 功能描述  科技平台驾驶舱-科技平台接口
 *
 * @author t-chengjia.chen
 * @date 2019/12/14
 */
@Api(value = "sciencePlan-api", description = "科技平台驾驶舱-科技平台接口")
@RequestMapping("/cockpit")
@RestController
public class KjptCockpitController extends RestBaseController {

    /**
     * 知识产权-专利数量按专利类型占比分析
     */
    private static final String KNOWLEDGENUMTYPE = "http://kjpt-zuul/stp-proxy/cockpit/knowledgeRight/numOrType";
    /**
     * 知识产权-专利数量按专利类型占比分析
     */
    private static final String KNOWLEDGENUMTREND = "http://kjpt-zuul/stp-proxy/cockpit/knowledgeRight/numYearTrend";
    /**
     * 知识产权-专利数量按专利类型占比分析
     */
    private static final String KNOWLEDGENUMUNIT = "http://kjpt-zuul/stp-proxy/cockpit/knowledgeRight/numOrUnit";

    /**
     * 科研平台-4大类别
     */
    private static final String NUMSCIENTIFICTYPE = "http://kjpt-zuul/stp-proxy/cockpit/scientificResearch/numScientificType";

    /**
     * 科研平台-科研平台数量按技术领域
     */
    private static final String NUMSCIENTIFICTECHNOLOGY = "http://kjpt-zuul/stp-proxy/cockpit/scientificResearch/numScientificTechnology";

    /**
     * 首页-知识产权
     */
    private static final String KNOWLEDGERIGHTCOUNT = "http://kjpt-zuul/stp-proxy/cockpit/index/knowledgeRightCount";

    /**
     * 首页-知识产权
     */
    private static final String PERSONCOUNTTITLE = "http://kjpt-zuul/stp-proxy/cockpit/person/personCountTitle";

    /**
     * 首页-知识产权
     */
    private static final String PERSONCOUNTEDUCATION = "http://kjpt-zuul/stp-proxy/cockpit/person/personCountEducation";

    /**
     * 科技人才-数量按年龄段
     */
    private static final String PERSONCOUNTAGE = "http://kjpt-zuul/stp-proxy/cockpit/person/personCountAge";

    /**
     * 科技人才-数量按年龄段
     */
    private static final String PERSONCOUNTCOMPANY = "http://kjpt-zuul/stp-proxy/cockpit/person/personCountCompany";

    /**
     * 成果信息-成果转化-各单位成果转化激励人数
     */
    private static final String NUMBERINCENTIVE = "http://kjpt-zuul/stp-proxy/cockpit/results/conversion/numberIncentive";

    /**
     * 成果信息-成果转化-成果转化数量按成果类型分析
     */
    private static final String NUMBYRESULTSTYPE = "http://kjpt-zuul/stp-proxy/cockpit/results/conversion/numByResultsType";

    /**
     * 成果信息-成果转化-各单位成果转化金额/激励金额
     */
    private static final String NUMBYINCENTIVEAMOUNT = "http://kjpt-zuul/stp-proxy/cockpit/results/conversion/numByIncentiveAmount";

    /**
     * 首页-4大汇总
     */
    private static final String FOURSUMMARYCOUNT = "http://kjpt-zuul/stp-proxy/cockpit/index/allSummaryCount";

    /**
<<<<<<< HEAD
     * 查询BI数据
     */
    private static final String QUERY_BI_DATA = "http://kjpt-zuul/stp-proxy/cockpit/results/queryBiData";

    private static final String DATATOBI = "http://localhost:8765/cockpit/bi-provider/dataToBi/dataToBi_excute";

    @ApiOperation(value = "知识产权-专利数量按专利类型占比分析")
    @RequestMapping(value = "/knowledgeRight/numOrType", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")

    public List<Map> knowledgeNumOrType() {
        Map<String, Object> condition = new HashMap<>(6);
        this.setBaseParam(condition);
        checkIsWhiteList(condition);
        String userSecretLevel = this.getUserProfile().getSecretLevel();
        this.setParam(condition, "param_secret_level", userSecretLevel);
        ResponseEntity<List> responseEntity = this.restTemplate.exchange(KNOWLEDGENUMTYPE, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), List.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value = "知识产权-专利数量年度趋势分析")
    @RequestMapping(value = "/knowledgeRight/numYearTrend", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public List<Map> knowledgeNumYearTrend() {
        Map<String, Object> condition = new HashMap<>(6);
        this.setBaseParam(condition);
        checkIsWhiteList(condition);
        String userSecretLevel = this.getUserProfile().getSecretLevel();
        this.setParam(condition, "param_secret_level", userSecretLevel);
        ResponseEntity<List> responseEntity = this.restTemplate.exchange(KNOWLEDGENUMTREND, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), List.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value = "知识产权-专利数量按单位同比分析")
    @RequestMapping(value = "/knowledgeRight/numOrUnit", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public List<Map> knowledgeNumOrUnit() {
        Map<String, Object> condition = new HashMap<>(6);
        this.setBaseParam(condition);
        checkIsWhiteList(condition);
        String userSecretLevel = this.getUserProfile().getSecretLevel();
        this.setParam(condition, "param_secret_level", userSecretLevel);
        ResponseEntity<List> responseEntity = this.restTemplate.exchange(KNOWLEDGENUMUNIT, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), List.class);
        return responseEntity.getBody();
    }

    /**
     * 功能描述
     *
     * @return java.util.List<java.util.Map>
     * @author t-chengjia.chen
     * @date 2019/12/16
     * 分类：
     * achievement -- 成果
     * patent -- 专利
     * project -- 项目
     * treatise -- 论文
     * level的级别：
     * 01国家级科研平台
     * 02部位级科研瓶体
     * 03省市级科研平台
     * 04集团级科研平台
     * 05板块级科研平台
     */
    @ApiOperation(value = "科研平台-4大类别")
    @RequestMapping(value = "/scientificResearch/numScientificType", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public List<Map> numScientificType() {
        Map<String, Object> condition = new HashMap<>(6);
        this.setBaseParam(condition);
        checkIsWhiteList(condition);
        String userSecretLevel = this.getUserProfile().getSecretLevel();
        this.setParam(condition, "param_secret_level", userSecretLevel);
        ResponseEntity<List> responseEntity = this.restTemplate.exchange(NUMSCIENTIFICTYPE, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), List.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value = "科研平台-科研平台数量按技术领域")
    @RequestMapping(value = "/scientificResearch/numScientificTechnology", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public List<Map> numScientificTechnology() {
        Map<String, Object> condition = new HashMap<>(6);
        this.setBaseParam(condition);
        checkIsWhiteList(condition);
        String userSecretLevel = this.getUserProfile().getSecretLevel();
        this.setParam(condition, "param_secret_level", userSecretLevel);
        ResponseEntity<List> responseEntity = this.restTemplate.exchange(NUMSCIENTIFICTECHNOLOGY, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), List.class);
        return responseEntity.getBody();
    }


    @ApiOperation(value = "首页- 数据汇总")
    @RequestMapping(value = "/index/allSummaryCount", method = RequestMethod.POST)
    public List<Map> fourSummaryCount(@RequestParam(value="inType", required = false) String inType) {
        Map<String, Object> condition = new HashMap<>(6);
        this.setBaseParam(condition);
        checkIsWhiteList(condition);
        condition.put("inType",inType);
        ResponseEntity<List> responseEntity = this.restTemplate.exchange(FOURSUMMARYCOUNT, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), List.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value = "首页-知识产权")
    @RequestMapping(value = "/index/knowledgeRightCount", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public List<Map> knowledgeRightCount() {
        Map<String, Object> condition = new HashMap<>(6);
        this.setBaseParam(condition);
        checkIsWhiteList(condition);
        String userSecretLevel = this.getUserProfile().getSecretLevel();
        this.setParam(condition, "param_secret_level", userSecretLevel);
        ResponseEntity<List> responseEntity = this.restTemplate.exchange(KNOWLEDGERIGHTCOUNT, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), List.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value = "科技人才-数量按年龄段")
    @RequestMapping(value = "/person/personCountAge", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public List<Map> personCountAge() {
        Map<String, Object> condition = new HashMap<>(6);
        this.setBaseParam(condition);
        checkIsWhiteList(condition);
        String userSecretLevel = this.getUserProfile().getSecretLevel();
        this.setParam(condition, "param_secret_level", userSecretLevel);
        ResponseEntity<List> responseEntity = this.restTemplate.exchange(PERSONCOUNTAGE, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), List.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value = "科技人才-数量按职称")
    @RequestMapping(value = "/person/personCountTitle", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public List<Map> personCountTitle() {
        Map<String, Object> condition = new HashMap<>(6);
        this.setBaseParam(condition);
        checkIsWhiteList(condition);
        String userSecretLevel = this.getUserProfile().getSecretLevel();
        this.setParam(condition, "param_secret_level", userSecretLevel);
        ResponseEntity<List> responseEntity = this.restTemplate.exchange(PERSONCOUNTTITLE, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), List.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value = "科技人才-数量按学历")
    @RequestMapping(value = "/person/personCountEducation", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public List<Map> personCountEducation() {
        Map<String, Object> condition = new HashMap<>(6);
        this.setBaseParam(condition);
        checkIsWhiteList(condition);
        String userSecretLevel = this.getUserProfile().getSecretLevel();
        this.setParam(condition, "param_secret_level", userSecretLevel);
        ResponseEntity<List> responseEntity = this.restTemplate.exchange(PERSONCOUNTEDUCATION, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), List.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value = "科技人才-数量按技术领域")
    @RequestMapping(value = "/person/personCountCompany", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public List<Map> personCountCompany() {
        Map<String, Object> condition = new HashMap<>(6);
        this.setBaseParam(condition);
        checkIsWhiteList(condition);
        String userSecretLevel = this.getUserProfile().getSecretLevel();
        this.setParam(condition, "param_secret_level", userSecretLevel);
        ResponseEntity<List> responseEntity = this.restTemplate.exchange(PERSONCOUNTCOMPANY, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), List.class);
        return responseEntity.getBody();
    }


    @ApiOperation(value = "成果信息-成果转化-各单位成果转化激励人数")
    @RequestMapping(value = "/results/conversion/numberIncentive", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public List<Map> numberIncentive() {
        Map<String, Object> condition = new HashMap<>(6);
        this.setBaseParam(condition);
        checkIsWhiteList(condition);
        String userSecretLevel = this.getUserProfile().getSecretLevel();
        this.setParam(condition, "param_secret_level", userSecretLevel);
        ResponseEntity<List> responseEntity = this.restTemplate.exchange(NUMBERINCENTIVE, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), List.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value = "成果信息-成果转化-成果转化数量按成果类型分析")
    @RequestMapping(value = "/results/conversion/numByResultsType", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public List<Map> numByResultsType() {
        Map<String, Object> condition = new HashMap<>(6);
        this.setBaseParam(condition);
        checkIsWhiteList(condition);
        String userSecretLevel = this.getUserProfile().getSecretLevel();
        this.setParam(condition, "param_secret_level", userSecretLevel);
        ResponseEntity<List> responseEntity = this.restTemplate.exchange(NUMBYRESULTSTYPE, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), List.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value = "成果信息-成果转化-各单位成果转化金额/激励金额")
    @RequestMapping(value = "/results/conversion/numByIncentiveAmount", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public List<Map> numByIncentiveAmount() {
        Map<String, Object> condition = new HashMap<>(6);
        this.setBaseParam(condition);
        checkIsWhiteList(condition);
        String userSecretLevel = this.getUserProfile().getSecretLevel();
        this.setParam(condition, "param_secret_level", userSecretLevel);
        ResponseEntity<List> responseEntity = this.restTemplate.exchange(NUMBYINCENTIVEAMOUNT, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), List.class);
        return responseEntity.getBody();
    }


    @ApiOperation(value = "查询BI数据")
    @RequestMapping(value = "/results/queryBIData/{type}", method = RequestMethod.GET)
    public List<Map> queryBIData(@PathVariable String type) {
        Map<String, Object> condition = new HashMap<>(6);
        this.setBaseParam(condition);
        checkIsWhiteList(condition);
        this.setParam(condition,"type",type);
        ResponseEntity<List> responseEntity = this.restTemplate.exchange(QUERY_BI_DATA, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), List.class);
        return responseEntity.getBody();
    }

    /**
     *BI数据灌入
     */
    @ApiOperation(value = "BI数据灌入", notes = "请求外系统-质量接口BI数据灌入")
    @RequestMapping(value = "/bi-api/dataToBi", method = RequestMethod.GET)
    public JSONObject DATATOBI(HttpServletRequest request, HttpServletResponse response) throws Exception {
        RestTemplate restTemplate_req = new RestTemplate();
        ResponseEntity<JSONObject> responseEntity = restTemplate_req.exchange(DATATOBI, HttpMethod.GET, new HttpEntity<String>(new HttpHeaders()), JSONObject.class);
        return responseEntity.getBody();
    }
}
