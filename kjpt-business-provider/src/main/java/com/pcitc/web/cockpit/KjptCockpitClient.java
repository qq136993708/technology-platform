package com.pcitc.web.cockpit;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.service.cockpit.KjptCockpitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;


/**
 *功能描述  科技平台驾驶舱-科技平台接口
 * @author t-chengjia.chen
 * @date 2019/12/14
 */
@Api(value = "科技平台驾驶舱-科技平台接口")
@RequestMapping("/cockpit")
@RestController
public class KjptCockpitClient {

    @Autowired
    public KjptCockpitService kjptCockpitService;

    /**
     *功能描述 知识产权-专利数量按专利类型占比分析
     * @author t-chengjia.chen
     * @date 2019/12/14
     * @return java.util.List<java.util.Map>
     */
    @ApiOperation(value = "知识产权-专利数量按专利类型占比分析", notes = "知识产权-专利数量按专利类型占比分析")
    @RequestMapping(value = "/knowledgeRight/numOrType", method = RequestMethod.POST)
    public List<Map> knowledgeNumOrType(@RequestBody(required = false) Map param) {
        return kjptCockpitService.knowledgeNumOrType(param);
    }

    /**
     *功能描述 知识产权-专利数量年度趋势分析
     * @author t-chengjia.chen
     * @date 2019/12/14
     * @return java.util.List<java.util.Map>
     */
    @ApiOperation(value = "知识产权-专利数量年度趋势分析", notes = "知识产权-专利数量年度趋势分析")
    @RequestMapping(value = "/knowledgeRight/numYearTrend", method = RequestMethod.POST)
    public List<Map> knowledgeNumYearTrend(@RequestBody(required = false) Map param) {
        return kjptCockpitService.knowledgeNumYearTrend(param);
    }

    /**
     *功能描述 知识产权-专利数量按单位同比分析
     * @author t-chengjia.chen
     * @date 2019/12/14
     * @return java.util.List<java.util.Map>
     */
    @ApiOperation(value = "知识产权-专利数量按单位同比分析", notes = "知识产权-专利数量按单位同比分析")
    @RequestMapping(value = "/knowledgeRight/numOrUnit", method = RequestMethod.POST)
    public List<Map> knowledgeNumOrUnit(@RequestBody(required = false) Map param) {
        return kjptCockpitService.knowledgeNumOrUnit(param);
    }

    /**
     *功能描述 科研平台-4大类别
     * @author t-chengjia.chen
     * @date 2019/12/14
     * @return java.util.List<java.util.Map>
     */
    @ApiOperation(value = "科研平台-4大类别", notes = "知识产权-专利数量按单位同比分析")
    @RequestMapping(value = "/scientificResearch/numScientificType", method = RequestMethod.POST)
    public List<Map> numScientificType(@RequestBody(required = false) Map param) {
        return kjptCockpitService.numScientificType(param);
    }

    /**
     *功能描述 知识产权-专利数量按单位同比分析
     * @author t-chengjia.chen
     * @date 2019/12/14
     * @return java.util.List<java.util.Map>
     */
    @ApiOperation(value = "科研平台-科研平台数量按技术领域", notes = "知识产权-专利数量按单位同比分析")
    @RequestMapping(value = "/scientificResearch/numScientificTechnology", method = RequestMethod.POST)
    public List<Map> numScientificTechnology(@RequestBody(required = false) Map param) {
        return kjptCockpitService.numScientificTechnology(param);
    }

    /**
     *功能描述 首页-知识产权
     * @author t-chengjia.chen
     * @date 2019/12/14
     * @return java.util.List<java.util.Map>
     */
    @ApiOperation(value = "首页-知识产权", notes = "首页-知识产权")
    @RequestMapping(value = "/index/knowledgeRightCount", method = RequestMethod.POST)
    public List<Map> knowledgeRightCount(@RequestBody(required = false) Map param) {
        return kjptCockpitService.knowledgeRightCount(param);
    }

    /**
     *功能描述 首页-4大汇总
     * @author t-chengjia.chen
     * @date 2019/12/14
     * @return java.util.List<java.util.Map>
     */
    @ApiOperation(value = "首页-汇总", notes = "首页-汇总")
    @RequestMapping(value = "/index/allSummaryCount", method = RequestMethod.POST)
    public List<Map> fourSummaryCount(@RequestBody(required = false) Map param) {
        return kjptCockpitService.allSummaryCount(param);
    }

    /**
     *功能描述 科技人才-数量按年龄
     * @author t-chengjia.chen
     * @date 2019/12/14
     * @return java.util.List<java.util.Map>
     */
    @ApiOperation(value = "科技人才-数量按职称", notes = "科技人才-数量按职称")
    @RequestMapping(value = "/person/personCountAge", method = RequestMethod.POST)
    public List<Map> personCountAge(@RequestBody(required = false) Map param) {
        return kjptCockpitService.personCountAge(param);
    }

    /**
     *功能描述 科技人才-数量按职称
     * @author t-chengjia.chen
     * @date 2019/12/14
     * @return java.util.List<java.util.Map>
     */
    @ApiOperation(value = "科技人才-数量按职称", notes = "科技人才-数量按职称")
    @RequestMapping(value = "/person/personCountTitle", method = RequestMethod.POST)
    public List<Map> personCountTitle(@RequestBody(required = false) Map param) {
        return kjptCockpitService.personCountTitle(param);
    }

    /**
     *功能描述 科技人才-数量按学历
     * @author t-chengjia.chen
     * @date 2019/12/14
     * @return java.util.List<java.util.Map>
     */
    @ApiOperation(value = "科技人才-数量按学历", notes = "科技人才-数量按学历")
    @RequestMapping(value = "/person/personCountEducation", method = RequestMethod.POST)
    public List<Map> personCountEducation(@RequestBody(required = false) Map param) {
        return kjptCockpitService.personCountEducation(param);
    }

    /**
     *功能描述 科技人才-数量按技术领域
     * @author t-chengjia.chen
     * @date 2019/12/14
     * @return java.util.List<java.util.Map>
     */
    @ApiOperation(value = "科技人才-数量按技术领域", notes = "科技人才-数量按技术领域")
    @RequestMapping(value = "/person/personCountCompany", method = RequestMethod.POST)
    public List<Map> personCountCompany(@RequestBody(required = false) Map param) {
        return kjptCockpitService.personCountCompany(param);
    }

    /**
     *功能描述 成果信息-成果转化-各单位成果转化激励人数
     * @author t-chengjia.chen
     * @date 2019/12/14
     * @return java.util.List<java.util.Map>
     */
    @ApiOperation(value = "成果信息-成果转化-各单位成果转化激励人数", notes = "成果信息-成果转化-各单位成果转化激励人数")
    @RequestMapping(value = "/results/conversion/numberIncentive", method = RequestMethod.POST)
    public List<Map> numberIncentive(@RequestBody(required = false) Map param) {
        return kjptCockpitService.numberIncentive(param);
    }

    /**
     *功能描述 成果信息-成果转化-成果转化数量按成果类型分析
     * @author t-chengjia.chen
     * @date 2019/12/14
     * @return java.util.List<java.util.Map>
     */
    @ApiOperation(value = "成果信息-成果转化-成果转化数量按成果类型分析", notes = "成果信息-成果转化-成果转化数量按成果类型分析")
    @RequestMapping(value = "/results/conversion/numByResultsType", method = RequestMethod.POST)
    public List<Map> numByResultsType(@RequestBody(required = false) Map param) {
        return kjptCockpitService.numByResultsType(param);
    }

    /**
     *功能描述 成果信息-成果转化-各单位成果转化金额/激励金额
     * @author t-chengjia.chen
     * @date 2019/12/14
     * @return java.util.List<java.util.Map>
     */
    @ApiOperation(value = "成果信息-成果转化-各单位成果转化金额/激励金额", notes = "成果信息-成果转化-各单位成果转化金额/激励金额")
    @RequestMapping(value = "/results/conversion/numByIncentiveAmount", method = RequestMethod.POST)
    public List<Map> numByIncentiveAmount(@RequestBody(required = false) Map param) {
        return kjptCockpitService.numByIncentiveAmount(param);
    }

    @RequestMapping(value = "/bi-provider/dataToBi/dataToBi_excute", method = RequestMethod.GET)
    public JSONObject save() {
        JSONObject jsonObject = new JSONObject(3);
        kjptCockpitService.dataToBi();
        jsonObject.put("code","success");
        jsonObject.put("message","成功");
        jsonObject.put("data","");
        return jsonObject;
    }
}
