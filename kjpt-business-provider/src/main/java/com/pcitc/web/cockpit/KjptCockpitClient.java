package com.pcitc.web.cockpit;

import com.pcitc.service.cockpit.KjptCockpitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
