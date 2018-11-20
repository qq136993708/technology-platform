package com.pcitc.web.controller.hana;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.PageResult;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.utils.HanaUtil;

//预算分配
@Controller
public class BudgetAllocationController {
	@Autowired
	private HttpHeaders httpHeaders;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static final String jtgszbkjjfys_data = "http://pcitc-zuul/system-proxy/out-project-provider/budget-proposals/group-company/stp-money";
	
	  
	    //集团公司总部科技经费预算----（建议稿）
	    @RequestMapping(method = RequestMethod.POST, value = "/ba/jtgszbkjjfys_data")
		@ResponseBody
		public String jtgszbkjjfys_data(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {

	    	PageResult pageResult = new PageResult();
	    	String month = CommonUtil.getParameter(request, "month", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_MM));
			String companyCode = CommonUtil.getParameter(request, "companyCode", "");
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("month", month);
			paramsMap.put("companyCode", companyCode);
			JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
			HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
			
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(jtgszbkjjfys_data, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200)
			{
				
				JSONArray	jSONArray = responseEntity.getBody();
				pageResult.setData(jSONArray);
				pageResult.setCode(0);
				pageResult.setCount(Long.valueOf(jSONArray.size()));
				pageResult.setLimit(1000);
				pageResult.setPage(1l);
				
			}
			JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(pageResult));
			System.out.println(">>>>>>>>>>>>>jtgszbkjjfys_data:" + result.toString());
			return result.toString();
		}
	  
	  //集团公司总部科技经费预算（建议稿）
	  @RequestMapping(method = RequestMethod.GET, value = "/ba/jtgszbkjjfys")
	  public String jtgszbkjjfys(HttpServletRequest request) throws Exception
	  {
		    
		  
		  String year= HanaUtil.getCurrrentYear();
		    request.setAttribute("year", year);
	        return "stp/hana/budgetAllocation/jtgszbkjjfys";
	  }
	  
	  
	  
	//资产公司总部科技项目经费预算（建议稿）
	  @RequestMapping(method = RequestMethod.GET, value = "/ba/zcgszbkjxmjfys")
	  public String zcgszbkjxmjfys(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/budgetAllocation/zcgszbkjxmjfys";
	  }
	//股份公司总部科技经费预算（调整稿）
	  @RequestMapping(method = RequestMethod.GET, value = "/ba/gfgszbkjjfystzg")
	  public String gfgszbkjjfystzg(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/budgetAllocation/gfgszbkjjfystzg";
	  }
	//股份公司总部科技经费预算（建议稿）
	  @RequestMapping(method = RequestMethod.GET, value = "/ba/gfgszbkjjfysjyg")
	  public String gfgszbkjjfysjyg(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/budgetAllocation/gfgszbkjjfysjyg";
	  }
	//处部门科技经费预算总表
	  @RequestMapping(method = RequestMethod.GET, value = "/ba/cbmkjjfyszb")
	  public String cbmkjjfyszb(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/budgetAllocation/cbmkjjfyszb";
	  }
	//集团经费预算明细表
	  @RequestMapping(method = RequestMethod.GET, value = "/ba/jtjfysmxb")
	  public String jtjfysmxb(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/budgetAllocation/jtjfysmxb";
	  }
	//资产经费预算明细表
	  @RequestMapping(method = RequestMethod.GET, value = "/ba/zcjfysmxb")
	  public String zcjfysmxb(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/budgetAllocation/zcjfysmxb";
	  }
	
	//股份（直属院）经费预算明细表
	  @RequestMapping(method = RequestMethod.GET, value = "/ba/gfzsyjfysmxb")
	  public String gfzsyjfysmxb(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/budgetAllocation/gfzsyjfysmxb";
	  }
	//股份（系统外及集团）经费预算明细表
	  @RequestMapping(method = RequestMethod.GET, value = "/ba/gfxtwjjtjfysmxb")
	  public String gfxtwjjtjfysmxb(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/budgetAllocation/gfxtwjjtjfysmxb";
	  }
	//股份（分子公司）预算
	  @RequestMapping(method = RequestMethod.GET, value = "/ba/gffzgsys")
	  public String gffzgsys(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/budgetAllocation/gffzgsys";
	  }
	//股份炼油事业部、化工事业部B2、C类科技经费预算表
	  @RequestMapping(method = RequestMethod.GET, value = "/ba/gflysybhgsybB2Clkjjfysb")
	  public String gflysybhgsybB2Clkjjfysb(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/budgetAllocation/gflysybhgsybB2Clkjjfysb";
	  }
	//股份公司科技专项经费预算表
	  @RequestMapping(method = RequestMethod.GET, value = "/ba/gfgskjzxjfysb")
	  public String gfgskjzxjfysb(HttpServletRequest request) throws Exception
	  {
		    
	        return "stp/hana/budgetAllocation/gfgskjzxjfysb";
	  }
	
}
