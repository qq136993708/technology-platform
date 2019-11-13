package com.pcitc.web.controller.mobile;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.hana.report.ScientificCashFlow01;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;
@Controller
public class MobileCashController extends BaseController{
	
	// 手机端月报表
		private static final String GET_Mobile_Month_Cash_Flow = "http://pcitc-zuul/hana-proxy/hana/decision/funds/cash-flow/getMobileMonthCashFlow";
		private static final String GET_DECISION_FUNDS_CHSH_FLOW_01 = "http://pcitc-zuul/hana-proxy/hana/decision/funds/cash-flow/01";
	
	//手机端月报表
		@RequestMapping(method = RequestMethod.GET, value = "/kjptmobile/get_Mobile_Month_Cash_Flow")
		@ResponseBody
		public String GET_Mobile_Month_Cash_Flow(HttpServletRequest request, HttpServletResponse response) throws Exception {

			String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
			String companyCode = CommonUtil.getParameter(request, "companyCode", "1020");
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_Mobile_Month_Cash_Flow, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			JSONArray array =new JSONArray();
			if (statusCode == 200) 
			{
				 array = responseEntity.getBody();
				//array= JSONArray.parseArray(JSON.toJSONString(list));
				
				//System.out.println(">>>>>>>>>>>>>>>>>>>>>get_Mobile_Month_Cash_Flow result = " + array.toString());
			}
			
			return array.toString();

		}
		
		@RequestMapping(value = "/kjptmobile/cash_details")
		public String budget(HttpServletRequest request, HttpServletResponse response) throws Exception {

			String g0GSJC = CommonUtil.getParameter(request, "g0GSJC", "");
			String month = CommonUtil.getParameter(request, "month", "");
			request.setAttribute("month", month);
			String companyCode=EquipmentUtils.getCompanyCodeByHanaName(g0GSJC, restTemplate, httpHeaders);
			request.setAttribute("g0GSJC", g0GSJC);
			request.setAttribute("companyCode", companyCode);
			return "/kjptmobile/cash_details";
		}
		
		
		
		
		
		/**
		 * @param request
		 * @param 报表名称
		 *            : 科技资金现金流分析 报表编码: H1AM_KY_ZH_1003_01
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(method = RequestMethod.GET, value = "/kjptmobile/cash-flow-01")
		@ResponseBody
		public synchronized String cashFlowAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
			JSONArray array=new JSONArray();
			String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
			String companyCode = CommonUtil.getParameter(request, "companyCode", "");
			//System.out.println(">>>>>>>>>>>>>>>>>>>>>参数      month = " + month + " companyCode=" + companyCode);
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_DECISION_FUNDS_CHSH_FLOW_01, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) 
			{
				JSONArray jSONArray = responseEntity.getBody();
				List<ScientificCashFlow01> list = JSONObject.parseArray(jSONArray.toJSONString(), ScientificCashFlow01.class);
				
			    Collections.sort(list, new Comparator<ScientificCashFlow01>() 
				{
			    	 public int compare(ScientificCashFlow01 u1, ScientificCashFlow01 u2) 
					  {
							int diff = Integer.valueOf(u1.getG0CWNY()).intValue()-Integer.valueOf(u2.getG0CWNY()).intValue() ;
							//System.out.println(">>>>>>>>>>>>>>>>>>>>  getG0CWNY = " + u1.getG0CWNY() );
							if (diff > 0) 
							{
								return -1;
							}else if (diff < 0) 
							{
							    return 1;
							}else
							{
								 return 0;
							}
						    
					}
				}); 
			    
				array= JSONArray.parseArray(JSON.toJSONString(list));
				
			} 
			return array.toString();

		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

}
