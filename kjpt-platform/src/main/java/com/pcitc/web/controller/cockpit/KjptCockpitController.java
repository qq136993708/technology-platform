package com.pcitc.web.controller.cockpit;

import com.pcitc.web.common.RestBaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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


    @ApiOperation(value = "知识产权-专利数量按专利类型占比分析")
    @RequestMapping(value = "/knowledgeRight/numOrType", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public List<Map> knowledgeNumOrType() {
        Map<String, Object> condition = new HashMap<>(6);
        String userSecretLevel = this.getUserProfile().getSecretLevel();
        this.setParam(condition, "userSecretLevel", userSecretLevel);
        ResponseEntity<List> responseEntity = this.restTemplate.exchange(KNOWLEDGENUMTYPE, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), List.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value = "知识产权-专利数量年度趋势分析")
    @RequestMapping(value = "/knowledgeRight/numYearTrend", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public List<Map> knowledgeNumYearTrend() {
        Map<String, Object> condition = new HashMap<>(6);
        String userSecretLevel = this.getUserProfile().getSecretLevel();
        this.setParam(condition, "param_secret_level", userSecretLevel);
        ResponseEntity<List> responseEntity = this.restTemplate.exchange(KNOWLEDGENUMTREND, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), List.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value = "知识产权-专利数量按单位同比分析")
    @RequestMapping(value = "/knowledgeRight/numOrUnit", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public List<Map> knowledgeNumOrUnit() {
        Map<String, Object> condition = new HashMap<>(6);
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
        String userSecretLevel = this.getUserProfile().getSecretLevel();
        this.setParam(condition, "userSecretLevel", userSecretLevel);
        ResponseEntity<List> responseEntity = this.restTemplate.exchange(NUMSCIENTIFICTYPE, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), List.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value = "科研平台-科研平台数量按技术领域")
    @RequestMapping(value = "/scientificResearch/numScientificTechnology", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public List<Map> numScientificTechnology() {
        Map<String, Object> condition = new HashMap<>(6);
        String userSecretLevel = this.getUserProfile().getSecretLevel();
        this.setParam(condition, "userSecretLevel", userSecretLevel);
        ResponseEntity<List> responseEntity = this.restTemplate.exchange(NUMSCIENTIFICTECHNOLOGY, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), List.class);
        return responseEntity.getBody();
    }
}
