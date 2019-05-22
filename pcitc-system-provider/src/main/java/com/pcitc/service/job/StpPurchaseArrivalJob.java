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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

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
            for (int i = 0; i < 100; i++) {
                JSONObject json = resultList.getJSONObject(i);


                SrePurchaseArrival  srePurchaseArrival =new SrePurchaseArrival();

                String id = UUID.randomUUID().toString().replaceAll("-", "");
                srePurchaseArrival.setId(id);
                srePurchaseArrival.setG0flag(json.getString("G0FLAG") ) ;
                /*srePurchaseOrder.setG0cald(json.getDate("G0CALD"));
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
                srePurchaseOrder.setK0xmddje(json.getDouble("K0XMDDJE"));*/

                purchaseArrivalDate.add(srePurchaseArrival);
            }

            if (purchaseArrivalDate != null && purchaseArrivalDate.size() > 0) {
               purchaseOrderStpClient.insertPurchaseArrival(purchaseArrivalDate);
            }
        }
        System.out.println("定时结束调用feign获取hana数据---------------"+resultList);


    }
}
