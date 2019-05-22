package com.pcitc.web.controller.equipment;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.equipment.UnitField;
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

@Controller
public class StatisticalQueryController extends BaseController {

    private static final String PURCHASE_EQUIPMENT_PAGE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/statisticalQuery/purchaseEquipmentPage";
    private static final String PROJECT_EQUIPMENT_PAGE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/statisticalQuery/projectEquipmentPage";
    //跳转到  科研装备采购查询
    @RequestMapping(value = "/sre-statisticalQuery/to-purchaseEquipment-list")
    public String purchaseEquipmentList(HttpServletRequest request, HttpServletResponse response)throws Exception {

        String unitPathId=sysUserInfo.getUnitPath();
        String departCode=sysUserInfo.getUnitCode();
        String	parentUnitPathIds="";
        String unitPathIds =   sysUserInfo.getUnitPath();
        if(!unitPathIds.equals(""))
        {
            if(unitPathIds.length()>4)
            {
                parentUnitPathIds=unitPathIds.substring(0, unitPathIds.length()-4);

            }
        }
        boolean isKJBPerson = EquipmentUtils.isKJBPerson(unitPathId);
        request.setAttribute("isKJBPerson", isKJBPerson);
        request.setAttribute("departCode", departCode);
        request.setAttribute("parentUnitPathIds", parentUnitPathIds);

        return "/stp/equipment/statisticalQuery/purchaseEquipment-list";
    }
    //跳转到  科研装备计划查询
    @RequestMapping(value = "/sre-statisticalQuery/to-projectEquipment-list")
    public String projectEquipmentList(HttpServletRequest request, HttpServletResponse response)throws Exception {

        String unitPathId=sysUserInfo.getUnitPath();
        String departCode=sysUserInfo.getUnitCode();
        List<UnitField> unitFieldList= CommonUtil.getUnitNameList(restTemplate, httpHeaders);
        String	parentUnitPathIds="";
        String unitPathIds =   sysUserInfo.getUnitPath();
        if(!unitPathIds.equals(""))
        {
            if(unitPathIds.length()>4)
            {
                parentUnitPathIds=unitPathIds.substring(0, unitPathIds.length()-4);

            }
        }


        boolean isKJBPerson = EquipmentUtils.isKJBPerson(unitPathId);
        request.setAttribute("isKJBPerson", isKJBPerson);
        request.setAttribute("departCode", departCode);
        request.setAttribute("parentUnitPathIds", parentUnitPathIds);
        request.setAttribute("unitFieldList", unitFieldList);

        return "/stp/equipment/statisticalQuery/projectEquipment-list";
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