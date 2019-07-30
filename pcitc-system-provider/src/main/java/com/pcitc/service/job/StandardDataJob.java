package com.pcitc.service.job;

import java.io.Serializable;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.stp.out.OutStandardData;
import com.pcitc.base.util.IdUtil;
import com.pcitc.config.SpringContextUtil;
import com.pcitc.service.feign.stp.OutStandardRemoteClient;

public class StandardDataJob implements Job , Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3031430687697877949L;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {

		OutStandardRemoteClient outStandard = SpringContextUtil.getApplicationContext().getBean(OutStandardRemoteClient.class);
		try {
			JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
			dcf.setAllowElementReferences(true);
			Client client = dcf.createClient("http://10.1.19.218/ProjectService.asmx?WSDL");
			Object[] result = client.invoke("GetList", "");
			for (Object obj : result) {
				JSONArray array = JSON.parseArray(obj.toString());
				for (java.util.Iterator<?> iter = array.iterator(); iter.hasNext();) {
					JSONObject json = JSON.parseObject(iter.next().toString());
					System.out.println("process id .... "+json.getString("Id"));
					if(outStandard.selectOutStandardDataById(json.getString("Id"))==null) 
					{
						OutStandardData bean = new OutStandardData();
						bean.setId(json.getString("Id"));
						bean.setDataId(IdUtil.createIdByTime());
						bean.setCriterionchname(json.getString("Criterionchname"));
						//保存
						outStandard.saveOutStandardData(bean);
						
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
