package ${packageName};

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.pcitc.base.common.LayuiTableParam;
import ${beanPackage}.${beanName};
import com.pcitc.web.common.BaseController;

@Controller
public class ${beanName}Controller extends BaseController 
{
	private static final String ${svcPrefix}_GET = "http://pcitc-zuul/stp-proxy/stp-provider/budget/${svcPath}-get/";
	private static final String ${svcPrefix}_LIST = "http://pcitc-zuul/stp-proxy/stp-provider/budget/${svcPath}-list";
	private static final String ${svcPrefix}_TABLE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/${svcPath}-table";
	private static final String ${svcPrefix}_SAVE = "http://pcitc-zuul/stp-proxy/stp-provider/budget/${svcPath}-save";
	private static final String ${svcPrefix}_UPD = "http://pcitc-zuul/stp-proxy/stp-provider/budget/${svcPath}-upd";
	private static final String ${svcPrefix}_SAVEORUPD = "http://pcitc-zuul/stp-proxy/stp-provider/budget/${svcPath}-saveorupd";
	private static final String ${svcPrefix}_DEL = "http://pcitc-zuul/stp-proxy/stp-provider/budget/${svcPath}-del/";

	
	@RequestMapping(method = RequestMethod.GET, value = "/budget/${pageUrl}_main")
	public Object to${beanName}MainPage(HttpServletRequest request) throws IOException 
	{
		return "stp/budget/${pageUrl}_main";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/budget/${pageUrl}_edit")
	public Object to${beanName}EditPage(HttpServletRequest request) throws IOException 
	{
		return "stp/budget/${pageUrl}_edit";
	}
	
	@RequestMapping(value = "/budget/${svcPath}-get", method = RequestMethod.POST)
	@ResponseBody
	public Object get${beanName}(@RequestParam(value = "dataId", required = true) String dataId,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(${svcPrefix}_GET+dataId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/budget/${svcPath}-table", method = RequestMethod.POST)
	@ResponseBody
	public Object get${beanName}Table(@ModelAttribute("param") LayuiTableParam param,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(${svcPrefix}_TABLE, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/budget/${svcPath}-list", method = RequestMethod.POST)
	@ResponseBody
	public Object get${beanName}List(@ModelAttribute("bean") ${beanName} bean,HttpServletRequest request) throws IOException 
	{
		
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(${svcPrefix}_LIST, HttpMethod.POST, new HttpEntity<${beanName}>(bean, this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/budget/${svcPath}-del", method = RequestMethod.POST)
	@ResponseBody
	public Object del${beanName}(@RequestParam(value = "dataId", required = true) String dataId,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(${svcPrefix}_DEL+dataId, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/budget/${svcPath}-upd", method = RequestMethod.POST)
	@ResponseBody
	public Object upd${beanName}(@ModelAttribute("bean") ${beanName} bean,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(${svcPrefix}_UPD, HttpMethod.POST, new HttpEntity<${beanName}>(bean, this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/budget/${svcPath}-save", method = RequestMethod.POST)
	@ResponseBody
	public Object save${beanName}(@ModelAttribute("bean") ${beanName} bean,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(${svcPrefix}_SAVE, HttpMethod.POST, new HttpEntity<${beanName}>(bean, this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
	@RequestMapping(value = "/budget/${svcPath}-saveorupd", method = RequestMethod.POST)
	@ResponseBody
	public Object saveOrupd${beanName}(@ModelAttribute("bean") ${beanName} bean,HttpServletRequest request) throws IOException 
	{
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(${svcPrefix}_SAVEORUPD, HttpMethod.POST, new HttpEntity<${beanName}>(bean, this.httpHeaders), Object.class);
		return JSON.toJSON(responseEntity.getBody());
	}
}
