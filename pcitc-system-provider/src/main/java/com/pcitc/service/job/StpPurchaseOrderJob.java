package com.pcitc.service.job;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.stp.equipment.SrePurchaseOrder;
import com.pcitc.base.util.DateUtil;
import com.pcitc.config.SpringContextUtil;
import com.pcitc.service.feign.hana.PurchaseOrderClient;
import com.pcitc.service.feign.stp.PurchaseOrderStpClient;

/**
 * @author WSL 定时获取ERP系统的采购订单数据，并保存到本地数据
 */
@Component
public class StpPurchaseOrderJob implements Job, Serializable {

    private static final long serialVersionUID = 1L;


    public void execute(JobExecutionContext job) throws JobExecutionException {

        PurchaseOrderClient purchaseOrderClient = SpringContextUtil.getApplicationContext().getBean(PurchaseOrderClient.class);
        PurchaseOrderStpClient purchaseOrderStpClient = SpringContextUtil.getApplicationContext().getBean(PurchaseOrderStpClient.class);
        System.out.println("-----调用feign获取ERP采购订单数据----"+new Date()+"-----------开始----");
        HashMap<String, String> map = new HashMap<String, String>();
        
        map.put("month", DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
        JSONArray jSONArray= purchaseOrderClient.getPurchaseOrderList(map);
        List<SrePurchaseOrder> resultList = JSONObject.parseArray(jSONArray.toJSONString(), SrePurchaseOrder.class);
        
        if (resultList != null) 
        {
        	purchaseOrderStpClient.insertPurchaseOrder(resultList);
        }
        System.out.println("调用feign获取ERP采购订单数据----"+new Date()+"-----------结束----------------");
    }

}
