package com.pcitc.service.job;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.stp.equipment.SreEquipmentLedger;
import com.pcitc.base.stp.equipment.SrePurchaseOrder;
import com.pcitc.base.util.DateUtil;
import com.pcitc.config.SpringContextUtil;
import com.pcitc.service.feign.hana.EquipmentLedgerSysClient;
import com.pcitc.service.feign.hana.PurchaseOrderClient;
import com.pcitc.service.feign.stp.EquipmentLedgerStpClient;
import com.pcitc.service.feign.stp.PurchaseOrderStpClient;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author WSL 定时获取ERP系统的装备台账数据，并保存到本地数据
 */
@Component
public class StpEquipmentLedgerJob implements Job, Serializable {

    private static final long serialVersionUID = 1L;


    public void execute(JobExecutionContext job) throws JobExecutionException {

        EquipmentLedgerSysClient equipmentLedgerSysClient = SpringContextUtil.getApplicationContext().getBean(EquipmentLedgerSysClient.class);
        EquipmentLedgerStpClient equipmentLedgerStpClient = SpringContextUtil.getApplicationContext().getBean(EquipmentLedgerStpClient.class);

        String  month="";
        for (int i = 0; i < 6; i++) {
        System.out.println("调用feign获取ERP装备台账数据----"+new Date()+"-----------开始"+equipmentLedgerSysClient);

        HashMap<String, String> map = new HashMap<String, String>();

        /*SimpleDateFormat format = new SimpleDateFormat();
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -1);
        Date m = c.getTime();
        String mon = format.format(m);
        Date date = DateUtil.strToDate(mon, DateUtil.FMT_MM);*/

            if(i==0){
                month="201901";
            }else if(i==1){
                month="201902";
            }else if(i==2){
                month="201903";
            }else if(i==3){
                month="201904";
            }else if(i==4){
                month="201905";
            }else if(i==5){
                month="201906";
            }



        map.put("month", month/*DateUtil.dateToStr(date, DateUtil.FMT_MM)*/);

        JSONArray jSONArray= equipmentLedgerSysClient.getEquipmentLedgerList(map);
        List<SreEquipmentLedger> resultList = JSONObject.parseArray(jSONArray.toJSONString(), SreEquipmentLedger.class);

        if (resultList != null&&resultList.size()!=0)
        {
            equipmentLedgerStpClient.insertEquipmentLedger(resultList);
        }

        System.out.println("调用feign获取ERP装备台账数据----"+new Date()+"-----------结束"+resultList);
    }


    }

}
