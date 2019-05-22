package com.pcitc.service.job;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.stp.equipment.SrePurchaseArrival;
import com.pcitc.base.stp.equipment.SrePurchaseOrder;
import com.pcitc.config.SpringContextUtil;
import com.pcitc.service.feign.hana.PurchaseOrderClient;
import com.pcitc.service.feign.stp.PurchaseOrderStpClient;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.*;

/**
 * @author WSL 定时获取ERP系统的采购入库数据，并保存到本地数据
 */
@Component
public class StpPurchaseArrivalJob implements Job, Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {


        PurchaseOrderClient purchaseOrderClient = SpringContextUtil.getApplicationContext().getBean(PurchaseOrderClient.class);
        PurchaseOrderStpClient purchaseOrderStpClient = SpringContextUtil.getApplicationContext().getBean(PurchaseOrderStpClient.class);
        System.out.println("定时开始调用feign获取hana数据---------------"+purchaseOrderClient);

        HashMap<String, String> map = new HashMap<String, String>();

        List<SrePurchaseArrival> purchaseArrivalDate = new ArrayList<SrePurchaseArrival>();

        JSONArray resultList = purchaseOrderClient.getPurchaseArrivalList(map);
        if (resultList != null) {
            for (int i = 0; i < resultList.size() ; i++) {
                JSONObject json = resultList.getJSONObject(i);


                SrePurchaseArrival  srePurchaseArrival =new SrePurchaseArrival();

                String id = UUID.randomUUID().toString().replaceAll("-", "");
                srePurchaseArrival.setId(id);
                srePurchaseArrival.setCreateDate(new Date());//导入时间
                srePurchaseArrival.setG0flag(json.getString("G0FLAG"));//数据标示
                srePurchaseArrival.setG0cald(json.getDate("G0CALD"));//年月
                srePurchaseArrival.setG0gsdm(json.getString("G0GSDM"));//公司代码
                srePurchaseArrival.setG0gsjc(json.getString("G0GSJC"));//公司简称
                srePurchaseArrival.setG0gsor(json.getString("G0GSOR"));//公司排序吗
                srePurchaseArrival.setG0gsjcl(json.getString("G0GSJCL"));//公司描述
                srePurchaseArrival.setG0gsgp(json.getString("G0GSGP"));//公司一级分类
                srePurchaseArrival.setG0gssp(json.getString("G0GSSP"));//公司二级分类
                srePurchaseArrival.setG0projcode(json.getString("G0PROJCODE"));//项目编码
                srePurchaseArrival.setG0projtxt(json.getString("G0PROJTXT"));//项目名称
                srePurchaseArrival.setG0wbscode(json.getString("G0WBSCODE"));//WBS号
                srePurchaseArrival.setG0wbstxt(json.getString("G0WBSTXT"));//WBS描述
                srePurchaseArrival.setG0xmgllx(json.getString("G0XMGLLX"));//项目类型
                srePurchaseArrival.setG0xmglly(json.getString("G0XMGLLY"));//项目来源
                srePurchaseArrival.setG0xmgljb(json.getString("G0XMGLJB"));//管理级别
                srePurchaseArrival.setG0xmlx(json.getString("G0XMLX"));//项目类别
                srePurchaseArrival.setG0xmlxms(json.getString("G0XMLXMS"));//项目类别描述
                srePurchaseArrival.setG0xmzt(json.getString("G0XMZT"));//项目状态
                srePurchaseArrival.setG0xmztms(json.getString("G0XMZTMS"));//项目状态描述
                srePurchaseArrival.setG0xmdl(json.getString("G0XMDL"));//项目大类：资本/费用
                srePurchaseArrival.setG0kypfwh(json.getString("G0KYPFWH"));//科研批复文号
                srePurchaseArrival.setG0matnr(json.getString("G0MATNR"));//物料号
                srePurchaseArrival.setG0maktx(json.getString("G0MAKTX"));//物料描述
                srePurchaseArrival.setG0ebeln(json.getString("G0EBELN"));//采购凭证号
                srePurchaseArrival.setG0ebelp(json.getString("G0EBELP"));//采购凭证的项目编号


                srePurchaseArrival.setG0vgabe(json.getString("G0VGABE"));//业务处理/时间类型，采购订单
                srePurchaseArrival.setG0gjahr(json.getDate("G0GJAHR"));//物料/财务凭证年度
                srePurchaseArrival.setG0belnr(json.getString("G0BELNR"));//物料/财务凭证编号
                srePurchaseArrival.setG0buzei(json.getString("G0BUZEI"));//凭证项目
                srePurchaseArrival.setG0budat(json.getDate("G0VGABE"));//凭证中的过账日期
                srePurchaseArrival.setK0xmrksl(json.getString("K0XMRKSL"));//项目采购入库数量
                srePurchaseArrival.setK0xmrkje(json.getDouble("K0XMRKJE"));//项目采购入库金额
                srePurchaseArrival.setK0xmlysl(json.getString("K0XMLYSL"));//项目采购领用数量
                srePurchaseArrival.setK0xmlyje(json.getDouble("K0XMLYJE"));//项目采购领用金额


                purchaseArrivalDate.add(srePurchaseArrival);
            }

            if (purchaseArrivalDate != null && purchaseArrivalDate.size() > 0) {
               purchaseOrderStpClient.insertPurchaseArrival(purchaseArrivalDate);
            }
        }
        System.out.println("定时结束调用feign获取hana数据---------------"+resultList);


    }
}
