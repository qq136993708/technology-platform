package com.pcitc.web.controller.equipment;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.equipment.UnitField;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
public class StatisticalQueryController extends BaseController {

    private static final String PURCHASE_EQUIPMENT_PAGE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/statisticalQuery/purchaseEquipmentPage";
    private static final String PROJECT_EQUIPMENT_PAGE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/statisticalQuery/projectEquipmentPage";
    //跳转到  科研装备采购查询
    @RequestMapping(value = "/sre-statisticalQuery/to-purchaseEquipment-list")
    public String purchaseEquipmentList(HttpServletRequest request, HttpServletResponse response)throws Exception {
        Map<String, String> map = EquipmentUtils.getDepartInfoBySysUser(sysUserInfo, restTemplate, httpHeaders);
        String parentUnitPathNames = map.get("unitName");// 申报单位
        String parentUnitPathIds = map.get("unitCode");// 申报单位
        String applyDepartName = map.get("applyDepartName");// 申报部门
        String applyDepartCode = map.get("applyDepartCode");// 申报部门

        //获取数据字典八大院的院所名称
        List<SysDictionary>  leaddicList= CommonUtil.getDictionaryByParentCode("ROOT_FZJCZX_YS", restTemplate, httpHeaders);
        request.setAttribute("leaddicList", leaddicList);
        //判断当前登录人是否为科技部人员
        String unitPathIds = sysUserInfo.getUnitPath();
        boolean isKJBPerson = EquipmentUtils.isKJBPerson(unitPathIds);
        request.setAttribute("isKJBPerson", isKJBPerson);

        request.setAttribute("departCode", applyDepartCode);
        request.setAttribute("parentUnitPathIds", parentUnitPathIds);

        return "/stp/equipment/statisticalQuery/purchaseEquipment-list";
    }
    /**
     * 科研装备采购列表
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/sre-statisticalQuery/purchaseEquipmentList")
    @ResponseBody
    public String purchaseEquipmentList(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {

        LayuiTableData layuiTableData = new LayuiTableData();
        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
        ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PURCHASE_EQUIPMENT_PAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
        int statusCode = responseEntity.getStatusCodeValue();
        if (statusCode == 200) {
            layuiTableData = responseEntity.getBody();
        }
        JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
        logger.info("============result" + result);
        return result.toString();
    }
    //跳转到  科研装备计划查询
    @RequestMapping(value = "/sre-statisticalQuery/to-projectEquipment-list")
    public String projectEquipmentList(HttpServletRequest request, HttpServletResponse response)throws Exception {

        String unitPathId=sysUserInfo.getUnitPath();
        String departCode=sysUserInfo.getUnitCode();
        List<UnitField> unitFieldList= CommonUtil.getUnitNameList(restTemplate, httpHeaders);
        String	parentUnitPathIds="";
        String unitPathIds =   sysUserInfo.getUnitPath();
        parentUnitPathIds = EquipmentUtils.getParentUnitPathId(unitPathIds);

        boolean isKJBPerson = EquipmentUtils.isKJBPerson(unitPathId);/*"100106851234"*/
        request.setAttribute("isKJBPerson", isKJBPerson);
        request.setAttribute("departCode", departCode);
        request.setAttribute("parentUnitPathIds", parentUnitPathIds);
        request.setAttribute("unitFieldList", unitFieldList);

        return "/stp/equipment/statisticalQuery/projectEquipment-list";
    }
    /**
     * 科研装备计划列表
     * @param param
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/sre-statisticalQuery/projectEquipmentList")
    @ResponseBody
    public String projectEquipmentList(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {

        LayuiTableData layuiTableData = new LayuiTableData();
        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
        ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PROJECT_EQUIPMENT_PAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
        int statusCode = responseEntity.getStatusCodeValue();
        if (statusCode == 200) {
            layuiTableData = responseEntity.getBody();
        }
        JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
        logger.info("============result" + result);
        return result.toString();
    }
}
