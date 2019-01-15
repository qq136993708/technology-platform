package com.pcitc.web.controller.hana;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysUser;
import com.pcitc.web.common.JwtTokenUtil;
import com.pcitc.web.utils.HanaUtil;

//科技经费
@Controller
public class ScientificFundsContrller {
	
	@Autowired
	private HttpHeaders httpHeaders;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static final String ktzjjfytjb_data = "http://pcitc-zuul/hana-proxy/hana/scientificFunds/ktzjjfytjb";
	private static final String rgcbzctjb_data = "http://pcitc-zuul/hana-proxy/hana/scientificFunds/rgcbzctjb";
	private static final String yclzctjb_data = "http://pcitc-zuul/hana-proxy/hana/scientificFunds/yclzctjb";
	private static final String nhzctjb_data = "http://pcitc-zuul/hana-proxy/hana/scientificFunds/nhzctjb";
	private static final String xmzjlxfx_data = "http://pcitc-zuul/hana-proxy/hana/scientificFunds/xmzjlxfx";
	
	
	
	
	  //年度经费预算合同签订进度分析
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/ndjfyshtqdjdfx")
	  public String ndjfyshtqdjdfx(HttpServletRequest request) throws Exception
	  {
		    SysUser userInfo = JwtTokenUtil.getUserFromToken(this.httpHeaders);
		    HanaUtil.setSearchParaForUser(userInfo,restTemplate,httpHeaders,request);
	        return "stp/hana/scientificFunds/ndjfyshtqdjdfx";
	  }
	  
	  //年度预算合同签订差异多维分析
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/ndyshtqdcydwfx")
	  public String ndyshtqdcydwfx(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/scientificFunds/ndyshtqdcydwfx";
	  }
	  //科研经费综合多维分析
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/kyjfzhdwfx")
	  public String kyjfzhdwfx(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/scientificFunds/kyjfzhdwfx";
	  }
	  
	  //课题科研资金使用多维分析
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/ktkyzjsydwfx")
	  public String ktkyzjsydwfx(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/scientificFunds/ktkyzjsydwfx";
	  }
	  
	  //课题直间接费用统计表
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/ktzjjfytjb")
	  public String ktzjjfytjb(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/scientificFunds/ktzjjfytjb";
	  }
	  
	@RequestMapping(method = RequestMethod.POST, value = "/ktzjjfytjb_data")
	@ResponseBody
	public String ktzjjfytjb_data(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response)
	{

		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(ktzjjfytjb_data, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200)
		{
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		System.out.println(">>>>>>>>>>>>>ktzjjfytjb_data:" + result.toString());
		return result.toString();
	}
				
				
	  //人工成本支出统计表
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/rgcbzctjb")
	  public String rgcbzctjb(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/scientificFunds/rgcbzctjb";
	  }
	  
		@RequestMapping(method = RequestMethod.POST, value = "/rgcbzctjb_data")
		@ResponseBody
		public String rgcbzctjb_data(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response)
		{

			LayuiTableData layuiTableData = new LayuiTableData();
			HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
			ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(rgcbzctjb_data, HttpMethod.POST, entity, LayuiTableData.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200)
			{
				layuiTableData = responseEntity.getBody();
			}
			JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
			System.out.println(">>>>>>>>>>>>>rgcbzctjb_data:" + result.toString());
			return result.toString();
		}
		
	  
	  //原材料支出统计表
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/yclzctjb")
	  public String yclzctjb(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/scientificFunds/yclzctjb";
	  }
	  @RequestMapping(method = RequestMethod.POST, value = "/yclzctjb_data")
		@ResponseBody
		public String yclzctjb_data(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response)
		{

			LayuiTableData layuiTableData = new LayuiTableData();
			HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
			ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(yclzctjb_data, HttpMethod.POST, entity, LayuiTableData.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200)
			{
				layuiTableData = responseEntity.getBody();
			}
			JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
			System.out.println(">>>>>>>>>>>>>yclzctjb_data:" + result.toString());
			return result.toString();
		}
	  
	  
	  //能耗支出统计表
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/nhzctjb")
	  public String nhzctjb(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/scientificFunds/nhzctjb";
	  }
	  @RequestMapping(method = RequestMethod.POST, value = "/nhzctjb_data")
		@ResponseBody
		public String nhzctjb_data(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response)
		{

			LayuiTableData layuiTableData = new LayuiTableData();
			HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
			ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(nhzctjb_data, HttpMethod.POST, entity, LayuiTableData.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200)
			{
				layuiTableData = responseEntity.getBody();
			}
			JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
			System.out.println(">>>>>>>>>>>>>nhzctjb_data:" + result.toString());
			return result.toString();
		}
	  
	  
	  
	  //项目资金流向分析
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/xmzjlxfx")
	  public String xmzjlxfx(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/scientificFunds/xmzjlxfx";
	  }
	  
	  
	  @RequestMapping(method = RequestMethod.POST, value = "/xmzjlxfx_data")
		@ResponseBody
		public String xmzjlxfx_data(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response)
		{

			LayuiTableData layuiTableData = new LayuiTableData();
			HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
			ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(xmzjlxfx_data, HttpMethod.POST, entity, LayuiTableData.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200)
			{
				layuiTableData = responseEntity.getBody();
			}
			JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
			System.out.println(">>>>>>>>>>>>>xmzjlxfx_data:" + result.toString());
			return result.toString();
		}
	  
	  
	  //加计扣除模拟分析
	  @RequestMapping(method = RequestMethod.GET, value = "/sf/jjkcmnfx")
	  public String jjkcmnfx(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/scientificFunds/jjkcmnfx";
	  }
	  
	  
}
