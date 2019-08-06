package com.pcitc.web.controller.equipment;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.RequestProcessStatusEnum;
import com.pcitc.base.stp.equipment.*;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/*/
 * Created by WSL in 2019/8/1
 */

@Controller
public class SupplierAppraiseController extends BaseController {

    private static final String ADD_URL = "http://pcitc-zuul/stp-proxy/sre-provider/supplierAppraise/add";

    private static final String UPDATE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/supplierAppraise/update";

	private static final String GET_URL = "http://pcitc-zuul/stp-proxy/sre-provider/supplierAppraise/get/";

    private static final String GET_BY_DETAIL_ID = "http://pcitc-zuul/stp-proxy/sre-provider/supplierAppraise/getByDetailId/";
    //根据装备台账ID获取装备台账信息
    private static final String GET_DETAIL_URL = "http://pcitc-zuul/stp-proxy/sre-provider/detail/getById/";
    /**
     * 跳转页面
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/sre-supplierAppraise/add")
    public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {


        String specification = CommonUtil.getParameter(request, "specification", "");
        String equipmentDetailId = CommonUtil.getParameter(request, "equipmentDetailId", "");
        String flag = CommonUtil.getParameter(request, "flag", "");
        request.setAttribute("equipmentDetailId", equipmentDetailId);
        request.setAttribute("flag", flag);//等于1的时候代表是统计查询

        if (StringUtils.isNotBlank(equipmentDetailId)) {

            SreDetail sreDetail = restTemplate.exchange(GET_DETAIL_URL + equipmentDetailId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreDetail.class).getBody();
            if (sreDetail != null) {
                String equipmentId = sreDetail.getEquipmentId();
                request.setAttribute("sreDetail", sreDetail);

                SreEquipment sreEquipment = EquipmentUtils.getSreEquipment(equipmentId, restTemplate, httpHeaders);
                SreProject sreProject = EquipmentUtils.getSreProject(specification, restTemplate, httpHeaders);

                request.setAttribute("sreEquipment", sreEquipment);
                request.setAttribute("sreProject", sreProject);
            }

            SreSupplierAppraise sreSupplierAppraise = this.restTemplate.exchange(GET_BY_DETAIL_ID + equipmentDetailId, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreSupplierAppraise.class).getBody();
            if (sreSupplierAppraise != null) {

                request.setAttribute("sreSupplierAppraise", sreSupplierAppraise);

            }
        }
        return "/stp/equipment/supplierAppraise/supplierAppraise-add";
    }


    /**
     * 保存-更新操作
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.POST, value = "/sre-supplierAppraise/save")
    @ResponseBody
    public String saveOrUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Result resultsDate = dealSaveUpdate(request);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
        out.println(ob.toString());
        out.flush();
        out.close();
        return null;
    }

    private Result dealSaveUpdate(HttpServletRequest request) throws Exception {
        Result resultsDate = new Result();
        // 业务ID
        String id = CommonUtil.getParameter(request, "id", "");
        String sreDetailId = CommonUtil.getParameter(request, "sreDetailId", "");
        String supplierAppraise = CommonUtil.getParameter(request, "supplierAppraise", "");//供应商评价
        String applicationsSituation = CommonUtil.getParameter(request, "applicationsSituation", "");//应用情况
        String maintenanceSituation = CommonUtil.getParameter(request, "maintenanceSituation", "");//维修情况
        String equipmentOverallAppraise = CommonUtil.getParameter(request, "equipmentOverallAppraise", "");//装备整体评价

        // 判断是新增还是修改
        SreSupplierAppraise sreSupplierAppraise =null;
        ResponseEntity<String> responseEntity = null;
        if (id.equals("")) {
            sreSupplierAppraise = new SreSupplierAppraise();
            sreSupplierAppraise.setCreateDate(new Date());

            String idv = UUID.randomUUID().toString().replaceAll("-", "");
            sreSupplierAppraise.setId(idv);

        } else {
            ResponseEntity<SreSupplierAppraise> exchange = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreSupplierAppraise.class);
            sreSupplierAppraise = exchange.getBody();
            sreSupplierAppraise.setUpdateDate(new Date());
        }
        // 流程状态
        sreSupplierAppraise.setSupplierAppraise(supplierAppraise);                  //供应商评价
        sreSupplierAppraise.setApplicationsSituation(applicationsSituation);        //应用情况
        sreSupplierAppraise.setMaintenanceSituation(maintenanceSituation);          //维修情况
        sreSupplierAppraise.setEquipmentOverallAppraise(equipmentOverallAppraise);  //装备整体评价
        sreSupplierAppraise.setEquipmentDetailId(sreDetailId);                      //装备台账ID
        // 判断是新增还是修改
        if (id.equals("")) {
            responseEntity = this.restTemplate.exchange(ADD_URL, HttpMethod.POST, new HttpEntity<SreSupplierAppraise>(sreSupplierAppraise, this.httpHeaders), String.class);

        } else {
            responseEntity = this.restTemplate.exchange(UPDATE_URL, HttpMethod.POST, new HttpEntity<SreSupplierAppraise>(sreSupplierAppraise, this.httpHeaders), String.class);
        }
        // 返回结果代码
        int statusCode = responseEntity.getStatusCodeValue();
        if (statusCode == 200) {
            resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
        } else {
            resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
        }

        return resultsDate;
    }
}
