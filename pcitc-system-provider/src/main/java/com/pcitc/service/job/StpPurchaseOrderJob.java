package com.pcitc.service.job;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.pcitc.base.stp.equipment.SrePurchaseOrder;
import com.pcitc.service.feign.hana.PurchaseOrderClient;
import com.pcitc.service.feign.stp.PurchaseOrderStpClient;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.config.SpringContextUtil;

/**
 * @author zhf 定时获取项目管理系统的项目数据，并保存到本地数据
 */
@Component
public class StpPurchaseOrderJob implements Job, Serializable {

    private static final long serialVersionUID = 1L;


    public void execute(JobExecutionContext job) throws JobExecutionException {

        PurchaseOrderClient purchaseOrderClient = SpringContextUtil.getApplicationContext().getBean(PurchaseOrderClient.class);
        PurchaseOrderStpClient purchaseOrderStpClient = SpringContextUtil.getApplicationContext().getBean(PurchaseOrderStpClient.class);
        System.out.println("定时开始调用feign获取hana数据---------------"+purchaseOrderClient);

        HashMap<String, String> map = new HashMap<String, String>();

        List<SrePurchaseOrder> purchaseOrderDate = new ArrayList<SrePurchaseOrder>();

        JSONArray resultList = purchaseOrderClient.getPurchaseOrderList(map);
        if (resultList != null) {
            for (int i = 0; i < resultList.size(); i++) {
                JSONObject json = resultList.getJSONObject(i);


                SrePurchaseOrder srePurchaseOrder =new SrePurchaseOrder();

                srePurchaseOrder.setG0flag(json.getString("G0FLAG"));
                srePurchaseOrder.setG0cald(json.getDate("G0CALD"));
                srePurchaseOrder.setG0gsdm(json.getString("G0GSDM"));
                srePurchaseOrder.setG0gsjc(json.getString("G0GSJC"));
                srePurchaseOrder.setG0gsor(json.getString("G0GSOR"));
                srePurchaseOrder.setG0gsjcl(json.getString("G0GSJCL"));
                srePurchaseOrder.setG0gsgp(json.getString("G0GSGP"));
                srePurchaseOrder.setG0gssp(json.getString("G0GSSP"));
                srePurchaseOrder.setG0projcode(json.getString("G0PROJCODE"));
                srePurchaseOrder.setG0projtxt(json.getString("G0PROJTXT"));
                srePurchaseOrder.setG0wbscode(json.getString("G0WBSCODE"));
                srePurchaseOrder.setG0wbstxt(json.getString("G0WBSTXT"));
                srePurchaseOrder.setG0xmgllx(json.getString("G0XMGLLX"));
                srePurchaseOrder.setG0xmglly(json.getString("G0XMGLLY"));
                srePurchaseOrder.setG0xmgljb(json.getString("G0XMGLJB"));
                srePurchaseOrder.setG0xmlx(json.getString("G0XMLX"));
                srePurchaseOrder.setG0xmlxms(json.getString("G0XMLXMS"));
                srePurchaseOrder.setG0xmzt(json.getString("G0XMZT"));
                srePurchaseOrder.setG0xmztms(json.getString("G0XMZTMS"));
                srePurchaseOrder.setG0xmdl(json.getString("G0XMDL"));
                srePurchaseOrder.setG0kypfwh(json.getString("G0KYPFWH"));
                srePurchaseOrder.setG0matnr(json.getString("G0MATNR"));
                srePurchaseOrder.setG0maktx(json.getString("G0MAKTX"));
                srePurchaseOrder.setG0ebeln(json.getString("G0EBELN"));
                srePurchaseOrder.setG0ebelp(json.getString("G0EBELP"));
                srePurchaseOrder.setG0txz01(json.getString("G0TXZ01"));
                srePurchaseOrder.setG0eindt(json.getDate("G0EINDT"));
                srePurchaseOrder.setG0lifnr(json.getString("G0LIFNR"));
                srePurchaseOrder.setG0name2(json.getString("G0NAME2"));
                srePurchaseOrder.setG0ddlx(json.getString("G0DDLX"));
                srePurchaseOrder.setK0xmddsl(json.getString("K0XMDDSL"));
                srePurchaseOrder.setK0xmddje(json.getDouble("K0XMDDJE"));

                purchaseOrderDate.add(srePurchaseOrder);
            }

            if (purchaseOrderDate != null && purchaseOrderDate.size() > 0) {
                purchaseOrderStpClient.insertPurchaseOrder(purchaseOrderDate);
            }

        }

        System.out.println("定时结束调用feign获取hana数据---------------"+resultList);
    }

}
