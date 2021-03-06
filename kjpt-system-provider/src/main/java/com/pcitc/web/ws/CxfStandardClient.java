package com.pcitc.web.ws;



import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.util.IdUtil;
/**
 * @ClassName:CxfClient
 * @Description:webservice客户端：
 *                 该类提供两种不同的方式来调用webservice服务
 *              1：代理工厂方式
 *              2：动态调用webservice
 * @author Jerry
 * @date:2018年4月10日下午4:14:07
 */
public class CxfStandardClient {


    public static void main(String[] args) {
    	//CxfStandardClient.main1();
    	CxfStandardClient.main2();
    }

    /**
     * 1.代理类工厂的方式,需要拿到对方的接口地址
     */
    public static void main1() {
        try {
            // 接口地址
            String address = "http://10.1.19.218/ProjectService.asmx?WSDL";
            // 代理工厂
            JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
            // 设置代理地址
            jaxWsProxyFactoryBean.setAddress(address);
            // 设置接口类型
            jaxWsProxyFactoryBean.setServiceClass(WsService.class);
            // 创建一个代理接口实现
            WsService us = (WsService) jaxWsProxyFactoryBean.create();
            // 数据准备
            String nd = "2019";
            // 调用代理接口的方法调用并返回结果
            String rs = us.GetList(nd);
            System.out.println(rs);
            
            String result = us.GetItem(nd);
            System.out.println("返回结果:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 2：动态调用
     */
    public static void main2() {
        // 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        dcf.setAllowElementReferences(true);
        Client client = dcf.createClient("http://10.1.19.218/ProjectService.asmx?WSDL");
        // 需要密码的情况需要加上用户名和密码
        // client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME, PASS_WORD));
        Object[] result = null;
        try {
            // invoke("方法名",参数1,参数2,参数3....);
        	result = client.invoke("GetList","");
        	//System.out.println("返回数据:" +result[0].toString());
        	for(Object obj:result) {
        		JSONArray array = JSON.parseArray(obj.toString());
        		for(java.util.Iterator<?> iter = array.iterator();iter.hasNext();) 
        		{
        			JSONObject json = JSON.parseObject(iter.next().toString());
        			System.out.println("INSERT INTO out_standard_data(data_id,id,criterionchname) values('"+IdUtil.createIdByTime()+"','"+json.getString("Id")+"','"+json.getString("Criterionchname")+"');");
        		}
        	}
           result = client.invoke("GetItem", "F8DFE8969EC704A6DDDD432176230001");
            //System.out.println("返回数据:" +result[0].toString());
            for(Object obj:result) {
        		System.out.println(obj.toString());
        	}
            result = client.invoke("GetListByYear", "2019");
            //System.out.println("返回数据:" +result[0].toString());
            for(Object obj:result) {
            	System.out.println(obj.toString());
        		System.out.println(JSON.parseArray(obj.toString()).size());
        	}
        } catch (java.lang.Exception e) {
        	//System.out.println("返回数据:Exception");
            e.printStackTrace();
        }
    }
}