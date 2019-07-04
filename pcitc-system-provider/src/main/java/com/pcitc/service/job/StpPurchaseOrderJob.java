package com.pcitc.service.job;

import java.io.Serializable;
import java.text.SimpleDateFormat;
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
 * @author WSL 定时获取ERP系统的采购订单数据，并保存到本地数据
 */
@Component
public class StpPurchaseOrderJob implements Job, Serializable {

    private static final long serialVersionUID = 1L;


    public void execute(JobExecutionContext job) throws JobExecutionException {

        PurchaseOrderClient purchaseOrderClient = SpringContextUtil.getApplicationContext().getBean(PurchaseOrderClient.class);
        PurchaseOrderStpClient purchaseOrderStpClient = SpringContextUtil.getApplicationContext().getBean(PurchaseOrderStpClient.class);
        System.out.println("调用feign获取ERP采购订单数据----"+new Date()+"-----------开始"+purchaseOrderClient);

        HashMap<String, String> map = new HashMap<String, String>();

        List<SrePurchaseOrder> purchaseOrderDate = new ArrayList<SrePurchaseOrder>();

        JSONArray resultList = purchaseOrderClient.getPurchaseOrderList(map);
        if (resultList != null) {
            for (int i = 0; i < resultList.size(); i++) {
                JSONObject json = resultList.getJSONObject(i);

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM") ; //使用了默认的格式创建了一个日期格式化对象。
                String time = dateFormat.format(json.getDate("G0CALD"));//可以把日期转换转指定格式的字符串

                SrePurchaseOrder srePurchaseOrder =new SrePurchaseOrder();

                srePurchaseOrder.setCreateDate(new Date());//导入时间
                srePurchaseOrder.setG0flag(json.getString("G0FLAG"));//数据标示
                srePurchaseOrder.setG0cald(time);//年月
                srePurchaseOrder.setG0gsdm(json.getString("G0GSDM"));//公司代码
                srePurchaseOrder.setG0gsjc(json.getString("G0GSJC"));//公司简称
                srePurchaseOrder.setG0gsor(json.getString("G0GSOR"));//公司排序吗
                srePurchaseOrder.setG0gsjcl(json.getString("G0GSJCL"));//公司描述
                srePurchaseOrder.setG0gsgp(json.getString("G0GSGP"));//公司一级分类
                srePurchaseOrder.setG0gssp(json.getString("G0GSSP"));//公司二级分类
                srePurchaseOrder.setG0projcode(json.getString("G0PROJCODE"));//项目编码
                srePurchaseOrder.setG0projtxt(json.getString("G0PROJTXT"));//项目名称
                srePurchaseOrder.setG0wbscode(json.getString("G0WBSCODE"));//WBS号
                srePurchaseOrder.setG0wbstxt(json.getString("G0WBSTXT"));//WBS描述
                srePurchaseOrder.setG0xmgllx(json.getString("G0XMGLLX"));//项目类型
                srePurchaseOrder.setG0xmglly(json.getString("G0XMGLLY"));//项目来源
                srePurchaseOrder.setG0xmgljb(json.getString("G0XMGLJB"));//管理级别
                srePurchaseOrder.setG0xmlx(json.getString("G0XMLX"));//项目类别
                srePurchaseOrder.setG0xmlxms(json.getString("G0XMLXMS"));//项目类别描述
                srePurchaseOrder.setG0xmzt(json.getString("G0XMZT"));//项目状态
                srePurchaseOrder.setG0xmztms(json.getString("G0XMZTMS"));//项目状态描述
                srePurchaseOrder.setG0xmdl(json.getString("G0XMDL"));//项目大类：资本/费用
                srePurchaseOrder.setG0kypfwh(json.getString("G0KYPFWH"));//科研批复文号
                srePurchaseOrder.setG0matnr(json.getString("G0MATNR"));//物料号
                srePurchaseOrder.setG0maktx(json.getString("G0MAKTX"));//物料描述
                srePurchaseOrder.setG0ebeln(json.getString("G0EBELN"));//采购凭证号
                srePurchaseOrder.setG0ebelp(json.getString("G0EBELP"));//采购凭证的项目编号
                srePurchaseOrder.setG0txz01(json.getString("G0TXZ01"));//采购单描述
                srePurchaseOrder.setG0eindt(json.getDate("G0EINDT"));//项目交货日期
                srePurchaseOrder.setG0lifnr(json.getString("G0LIFNR"));//供应商账户号
                srePurchaseOrder.setG0name2(json.getString("G0NAME2"));//供应商名称
                srePurchaseOrder.setG0ddlx(json.getString("G0DDLX"));//标记;F服务订单，M物资订单
                srePurchaseOrder.setK0xmddsl(json.getString("K0XMDDSL"));//项目采购订单数量
                srePurchaseOrder.setK0xmddje(json.getDouble("K0XMDDJE"));//项目采购订单净值

                purchaseOrderDate.add(srePurchaseOrder);
            }

            if (purchaseOrderDate != null && purchaseOrderDate.size() > 0) {
                purchaseOrderStpClient.insertPurchaseOrder(purchaseOrderDate);
            }

        }

        System.out.println("调用feign获取ERP采购订单数据----"+new Date()+"-----------结束"+resultList);
    }

}
