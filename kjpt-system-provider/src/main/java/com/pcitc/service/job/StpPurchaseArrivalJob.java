package com.pcitc.service.job;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.stp.equipment.SrePurchaseArrival;
import com.pcitc.base.stp.equipment.SrePurchaseOrder;
import com.pcitc.base.util.DateUtil;
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
        System.out.println("--------------调用feign获取ERP采购入库数据----"+new Date()+"-----------开始");

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("month", DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
        //从HANA取数
        JSONArray jSONArray = purchaseOrderClient.getPurchaseArrivalList(map);
        List<SrePurchaseArrival> resultList = JSONObject.parseArray(jSONArray.toJSONString(), SrePurchaseArrival.class);
        
        if (resultList != null) 
        {
            for (int i = 0; i < resultList.size() ; i++) 
            {
            	 SrePurchaseArrival json = resultList.get(i);
            	 String id = UUID.randomUUID().toString().replaceAll("-", "");
            	 json.setId(id);
            }
            //保存到本地
            purchaseOrderStpClient.insertPurchaseArrival(resultList);
        }
        System.out.println("--------------调用feign获取ERP采购入库数据----"+new Date()+"-----------结束");


    }
}
