package com.pcitc.web.controller.system;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.ExcelException;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.system.SysLog;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.ExcelUtils;
import com.pcitc.web.utils.ImportExcelUtil;
import com.pcitc.web.utils.PoiExcelExportUitl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "SysLog-API",tags = {"系统日志-接口"})
@RestController
public class SysLogController extends BaseController {

	private static final String PAGE_SYSLOG_URL = "http://kjpt-zuul/system-proxy/log-provider/page";

	private static final String SYSLOG_EXCEL_OUT = "http://kjpt-zuul/system-proxy/log-provider/list";

	
	
	
	
	
	
	
	
	
	
	@ApiOperation(value = "系统日志查询（分页）", notes = "系统日志查询（分页）")
	@ApiImplicitParams({ 
		    @ApiImplicitParam(name = "page", value = "页码", dataType = "string", paramType = "query",required=true),
			@ApiImplicitParam(name = "limit", value = "每页显示条数", dataType = "string", paramType = "query",required=true),
			@ApiImplicitParam(name = "optDescribe", value = "操作描述", dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "optResult", value = "操作结果", dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "logName", value = "登陆名", dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "logIp", value = "登陆IP", dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "beginTime", value = "开始时间", dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "endTime",  value = "截止时间", dataType = "string", paramType = "query") ,
			@ApiImplicitParam(name = "logType",  value = "日志类型：1登陆日志，2操作日志，3错误日志",       dataType = "string", paramType = "query") ,
			@ApiImplicitParam(name = "userType", value = "用户类型：1普通用户，2系统管理员，2安全员，3审计员", dataType = "string", paramType = "query")
	
	    })
	@RequestMapping(value = "/sysLog-api/query", method = RequestMethod.POST)
	public String querySysLogPage(

			@RequestParam(required = true) Integer page, 
			@RequestParam(required = true) Integer limit,
			@RequestParam(required = false) String optDescribe,
			@RequestParam(required = false) String optResult,
			@RequestParam(required = false) String logName,
			@RequestParam(required = false) String logIp,
			@RequestParam(required = false) String beginTime, 
			@RequestParam(required = false) String endTime,
			@RequestParam(required = false) String logType,
			@RequestParam(required = false) String userType,
			
			
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		LayuiTableParam param = new LayuiTableParam();
		param.getParam().put("optDescribe", optDescribe);
		param.getParam().put("optResult", optResult);
		param.getParam().put("logName", logName);
		param.getParam().put("logIp", logIp);
		param.setLimit(limit);
		param.setPage(page);
		param.getParam().put("beginTime", beginTime);
		param.getParam().put("endTime", endTime);
		param.getParam().put("logType", logType);
		param.getParam().put("userType", userType);
		
		JSONObject json = JSONObject.parseObject(JSONObject.toJSONString(param));
        System.out.print(">>>>>>>>>>>系统日志查询（分页）参数："+json.toString());
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PAGE_SYSLOG_URL, HttpMethod.POST, entity,
				LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============获取系统日志列表（分页） " + result.toString());
		return result.toString();
	}
	
	
	
	
	
	
	
	     @ApiOperation(value = "导出登陆日志信息", notes = "导出登陆日志信息")
	     @ApiImplicitParams({ 
	        @ApiImplicitParam(name = "optDescribe", value = "操作描述", dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "logIp", value = "登陆IP", dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "beginTime", value = "开始时间", dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "endTime",  value = "截止时间", dataType = "string", paramType = "query") ,
			@ApiImplicitParam(name = "logType",  value = "日志类型：1登陆日志，2操作日志，3错误日志",       dataType = "string", paramType = "query",required=true) ,
			@ApiImplicitParam(name = "userType", value = "用户类型：1普通用户，2系统管理员，2安全员，3审计员", dataType = "string", paramType = "query",required=true)
           })
	    @RequestMapping(value = "/sysLog-api/log_exput_excel", method = RequestMethod.GET)
	   	public String jsgztj_data_exput_excel(
	   			
	   			@RequestParam(required = false) String optDescribe, 
				@RequestParam(required = false) String logIp,
				@RequestParam(required = false) String beginTime, 
				@RequestParam(required = false) String endTime,
				@RequestParam(required = false) String logType,
				@RequestParam(required = false) String userType,
	   		 HttpServletRequest request, HttpServletResponse response) throws Exception
	   	{
	   		
	   		
	   		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);//设置参数类型和编码
	   		Map<String ,Object> paramMap = new HashMap<String ,Object>();
	   		paramMap.put("optDescribe", optDescribe);
	   	    paramMap.put("logIp", logIp);
	        paramMap.put("beginTime", beginTime);
	        paramMap.put("endTime", endTime);
	        paramMap.put("logType", logType);
	        paramMap.put("userType", userType);
	        
	        JSONObject json = JSONObject.parseObject(JSONObject.toJSONString(paramMap));
	        System.out.print(">>>>>>>>>>>导出登陆日志信息参数："+json.toString());
	        
	        
	   		
	   		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
	   		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(SYSLOG_EXCEL_OUT, HttpMethod.POST, httpEntity, JSONArray.class);
	   		int statusCode = responseEntity.getStatusCodeValue();
	   		List<SysLog> list =new ArrayList();
	   		JSONArray jSONArray=null;
	   		if (statusCode == 200)
	   		{
	   			jSONArray = responseEntity.getBody();
	   			list = JSONObject.parseArray(jSONArray.toJSONString(), SysLog.class);
	   			if(list!=null &&  list.size()>0)
	   			{
	   				for(int i=0;i<list.size();i++)
	   				{
	   					SysLog zjkBase= list.get(i);
	   					zjkBase.setLogTimeStr(DateUtil.dateToStr(zjkBase.getLogTime(), DateUtil.FMT_SS));
	   				}
	   			}
	   		}
	   		
	   		
         
	   		    String[] headers = { "登录结果",  "登录名",    "登录IP"  , "操作方式"  ,         "操作时间" };
	   		    String[] cols =    {"optResult","userName","logIp",  "requestType",      "logTimeStr"};
	   		   
	   	        // 文件名默认设置为当前时间：年月日时分秒
	   	        String fileName = "登陆日志信息__"+DateFormatUtils.format(new Date(), "ddhhmmss");
	   	        // 设置response头信息
	   	        response.reset();
	   	        response.setCharacterEncoding("UTF-8");
		        response.setContentType("application/vnd.ms-excel");
		        response.setHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO8859-1") + ".xls");
	   	        try {
	   		        OutputStream os = response.getOutputStream();
	   		        PoiExcelExportUitl<SysLog>  pee = new PoiExcelExportUitl<SysLog>(fileName, headers, cols, list,os);
	   		        pee.exportExcel();
	   	            
	   	        } catch (Exception e)
	   	        {
	   	            e.printStackTrace();
	   	            // 如果是ExcelException,则直接抛出
	   	            if (e instanceof ExcelException) 
	   	            {
	   	                throw (ExcelException) e;
	   	            } else 
	   	            {
	   	                // 否则将其他异常包装成ExcelException再抛出
	   	                throw new ExcelException("导出excel失败");
	   	            }
	   	        }
	   		   return null;
	   	}
	    
	    
	    
	
	
	
	
	
	     @ApiOperation(value = "导出操作日志信息", notes = "导出操作日志信息")
	     @ApiImplicitParams({ 
		        @ApiImplicitParam(name = "optDescribe", value = "操作描述", dataType = "string", paramType = "query"),
				@ApiImplicitParam(name = "logIp", value = "登陆IP", dataType = "string", paramType = "query"),
				@ApiImplicitParam(name = "beginTime", value = "开始时间", dataType = "string", paramType = "query"),
				@ApiImplicitParam(name = "endTime",  value = "截止时间", dataType = "string", paramType = "query") ,
				@ApiImplicitParam(name = "logType",  value = "日志类型：1登陆日志，2操作日志，3错误日志",       dataType = "string", paramType = "query",required=true) ,
				@ApiImplicitParam(name = "userType", value = "用户类型：1普通用户，2系统管理员，2安全员，3审计员", dataType = "string", paramType = "query",required=true)
	           })
	    @RequestMapping(value = "/sysLog-api/opt_exput_excel", method = RequestMethod.GET)
	   	public String opt_exput_excel(
	   			
	   			@RequestParam(required = false) String optDescribe, 
				@RequestParam(required = false) String logIp,
				@RequestParam(required = false) String beginTime, 
				@RequestParam(required = false) String endTime,
				@RequestParam(required = false) String logType,
				@RequestParam(required = false) String userType,
	   		 HttpServletRequest request, HttpServletResponse response) throws Exception
	   	{
	   		
	   		
	    	
	    	
	   		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);//设置参数类型和编码
	   		Map<String ,Object> paramMap = new HashMap<String ,Object>();
	   		paramMap.put("optDescribe", optDescribe);
	   	    paramMap.put("logIp", logIp);
	        paramMap.put("beginTime", beginTime);
	        paramMap.put("endTime", endTime);
	        paramMap.put("logType", logType);
	        paramMap.put("userType", userType);
	        
	        JSONObject json = JSONObject.parseObject(JSONObject.toJSONString(paramMap));
	        System.out.print(">>>>>>>>>>>导出操作日志信息参数："+json.toString());
	        
	   		
	   		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
	   		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(SYSLOG_EXCEL_OUT, HttpMethod.POST, httpEntity, JSONArray.class);
	   		int statusCode = responseEntity.getStatusCodeValue();
	   		List<SysLog> list =new ArrayList();
	   		JSONArray jSONArray=null;
	   		if (statusCode == 200)
	   		{
	   			jSONArray = responseEntity.getBody();
	   			list = JSONObject.parseArray(jSONArray.toJSONString(), SysLog.class);
	   			if(list!=null &&  list.size()>0)
	   			{
	   				for(int i=0;i<list.size();i++)
	   				{
	   					SysLog zjkBase= list.get(i);
	   					zjkBase.setLogTimeStr(DateUtil.dateToStr(zjkBase.getLogTime(), DateUtil.FMT_YYYY));
	   				}
	   			}
	   		}
	   		
	   		
         
	   		    String[] headers = { "登录结果",  "操作名称",      "操作者",    "URL" ,    "登录IP"  , "操作方式"  ,         "操作时间" };
	   		    String[] cols =    {"optResult","optDescribe","userName","logUrl",  "logIp",  "requestType",      "logTimeStr"};
	   		   
	   	        // 文件名默认设置为当前时间：年月日时分秒
	   	        String fileName = "操作日志信息__"+DateFormatUtils.format(new Date(), "ddhhmmss");
	   	        // 设置response头信息
	   	        response.reset();
	   	        response.setCharacterEncoding("UTF-8");
		        response.setContentType("application/vnd.ms-excel");
		        response.setHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO8859-1") + ".xls");
	   	        try {
	   		        OutputStream os = response.getOutputStream();
	   		        PoiExcelExportUitl<SysLog>  pee = new PoiExcelExportUitl<SysLog>(fileName, headers, cols, list,os);
	   		        pee.exportExcel();
	   	            
	   	        } catch (Exception e)
	   	        {
	   	            e.printStackTrace();
	   	            // 如果是ExcelException,则直接抛出
	   	            if (e instanceof ExcelException) 
	   	            {
	   	                throw (ExcelException) e;
	   	            } else 
	   	            {
	   	                // 否则将其他异常包装成ExcelException再抛出
	   	                throw new ExcelException("导出excel失败");
	   	            }
	   	        }
	   		   return null;
	   	}
	    
	    
	    
	
	
	
	
	
	
	
        //导出错语日志
	     @ApiOperation(value = "导出错误日志信息", notes = "导出错误日志信息")
	     @ApiImplicitParams({ 
		        @ApiImplicitParam(name = "optDescribe", value = "操作描述", dataType = "string", paramType = "query"),
				@ApiImplicitParam(name = "logIp", value = "登陆IP", dataType = "string", paramType = "query"),
				@ApiImplicitParam(name = "beginTime", value = "开始时间", dataType = "string", paramType = "query"),
				@ApiImplicitParam(name = "endTime",  value = "截止时间", dataType = "string", paramType = "query") ,
				@ApiImplicitParam(name = "logType",  value = "日志类型：1登陆日志，2操作日志，3错误日志",       dataType = "string", paramType = "query",required=true) ,
				@ApiImplicitParam(name = "userType", value = "用户类型：1普通用户，2系统管理员，2安全员，3审计员", dataType = "string", paramType = "query",required=true)
	           })
	    @RequestMapping(value = "/sysLog-api/error_exput_excel", method = RequestMethod.GET)
	   	public String error_exput_excel(
	   			
	   			@RequestParam(required = false) String optDescribe, 
				@RequestParam(required = false) String logIp,
				@RequestParam(required = false) String beginTime, 
				@RequestParam(required = false) String endTime,
				@RequestParam(required = false) String logType,
				@RequestParam(required = false) String userType,
	   		 HttpServletRequest request, HttpServletResponse response) throws Exception
	   	{
	   		
	   		
	    	
	    	
	   		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);//设置参数类型和编码
	   		Map<String ,Object> paramMap = new HashMap<String ,Object>();
	   		paramMap.put("optDescribe", optDescribe);
	   	    paramMap.put("logIp", logIp);
	        paramMap.put("beginTime", beginTime);
	        paramMap.put("endTime", endTime);
	        paramMap.put("logType", logType);
	        paramMap.put("userType", userType);
	        
	        JSONObject json = JSONObject.parseObject(JSONObject.toJSONString(paramMap));
	        System.out.print(">>>>>>>>>>>导出错误日志信息参数："+json.toString());
	        
	   		
	   		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
	   		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(SYSLOG_EXCEL_OUT, HttpMethod.POST, httpEntity, JSONArray.class);
	   		int statusCode = responseEntity.getStatusCodeValue();
	   		List<SysLog> list =new ArrayList();
	   		JSONArray jSONArray=null;
	   		if (statusCode == 200)
	   		{
	   			jSONArray = responseEntity.getBody();
	   			list = JSONObject.parseArray(jSONArray.toJSONString(), SysLog.class);
	   			if(list!=null &&  list.size()>0)
	   			{
	   				for(int i=0;i<list.size();i++)
	   				{
	   					SysLog zjkBase= list.get(i);
	   					zjkBase.setLogTimeStr(DateUtil.dateToStr(zjkBase.getLogTime(), DateUtil.FMT_YYYY));
	   				}
	   			}
	   		}
	   		
	   		
	   		
            
            
         
	   		    String[] headers = {  "操作名称",      "操作者",      "所在公司",      "所在部门",    "URL" ,    "登录IP"  , "操作方式"  ,         "操作时间",         "操作错误" };
	   		    String[] cols =    {"optDescribe","userName",  "userCompany",   "unitName","logUrl",  "logIp",  "requestType",      "logTimeStr",      "optError"};
	   		   
	   	        // 文件名默认设置为当前时间：年月日时分秒
	   	        String fileName = "错误日志信息__"+DateFormatUtils.format(new Date(), "ddhhmmss");
	   	        // 设置response头信息
	   	        response.reset();
	   	        response.setCharacterEncoding("UTF-8");
		        response.setContentType("application/vnd.ms-excel");
		        response.setHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO8859-1") + ".xls");
	   	        try {
	   		        OutputStream os = response.getOutputStream();
	   		        PoiExcelExportUitl<SysLog>  pee = new PoiExcelExportUitl<SysLog>(fileName, headers, cols, list,os);
	   		        pee.exportExcel();
	   	            
	   	        } catch (Exception e)
	   	        {
	   	            e.printStackTrace();
	   	            // 如果是ExcelException,则直接抛出
	   	            if (e instanceof ExcelException) 
	   	            {
	   	                throw (ExcelException) e;
	   	            } else 
	   	            {
	   	                // 否则将其他异常包装成ExcelException再抛出
	   	                throw new ExcelException("导出excel失败");
	   	            }
	   	        }
	   		   return null;
	   	}
	    
	    
	    
	
	
	
	
	
	
	

	/*
	
	
	
	
	
	
	
	
	
	*//**
		 * 跳转到系统日志列表页
		 */
	/*
	 * @RequestMapping(value = "/sysLog_list") public String
	 * toList(HttpServletRequest request, HttpServletResponse response) throws
	 * Exception { return "/base/system/sysLog_list"; }
	 * 
	 *//**
		 * 根据条件获取系统日志列表
		 * 
		 * @param request
		 * @return
		 */
	/*
	 * @RequestMapping(value = "/getLogList", method = RequestMethod.POST)
	 * 
	 * @ResponseBody public Object getLogList(HttpServletRequest request,
	 * HttpServletResponse response) throws IOException { SysLog sysLog = new
	 * SysLog(); String page = request.getParameter("page"); // 起始索引 String limit =
	 * request.getParameter("limit"); // 每页显示的行数 String logAction =
	 * request.getParameter("logAction"); String logActionName =
	 * request.getParameter("logActionName"); String logsTime =
	 * request.getParameter("logTime"); String logPerson =
	 * request.getParameter("logPerson"); sysLog.setPage(page);
	 * sysLog.setLimit(limit); sysLog.setLogAction(logAction);
	 * sysLog.setLogActionName(logActionName); sysLog.setLogsTime(logsTime);
	 * sysLog.setLogPerson(logPerson); HttpEntity<SysLog> entity = new
	 * HttpEntity<SysLog>(sysLog, this.httpHeaders); ResponseEntity<String>
	 * responseEntity = this.restTemplate.exchange(FUNCTION_LIST, HttpMethod.POST,
	 * entity, String.class); String result = responseEntity.getBody(); JSONObject
	 * retJson = JSONObject.parseObject(result); if (retJson != null) { Long
	 * totalCount = retJson.get("totalCount") != null ?
	 * Long.parseLong(retJson.get("totalCount").toString()) : 0l; List<SysLog>
	 * resultList = JSON.parseArray(retJson.getJSONArray("list").toJSONString(),
	 * SysLog.class); JSONObject jsonObj = new JSONObject(); jsonObj.put("code",
	 * "0"); jsonObj.put("msg", "提示"); jsonObj.put("count", totalCount);
	 * jsonObj.put("data", resultList); return jsonObj.toString(); } return null; }
	 * 
	 *//**
		 * 保存系统日志
		 * 
		 * @param SysLog
		 * @return
		 */
	/*
	 * @RequestMapping(value = "/saveData")
	 * 
	 * @ResponseBody public int saveData(SysLog SysLog) { HttpEntity<SysLog> entity
	 * = new HttpEntity<SysLog>(SysLog, this.httpHeaders); ResponseEntity<Integer>
	 * responseEntity = this.restTemplate.exchange(SAVE_FUNCTION, HttpMethod.POST,
	 * entity, Integer.class); int result = responseEntity.getBody(); return result;
	 * }
	 * 
	 *//**
		 * 删除系统日志
		 * 
		 * @param request
		 * @return
		 */
	/*
	 * @RequestMapping(value = "/deleteData")
	 * 
	 * @ResponseBody public int deleteData(HttpServletRequest request) { String ids
	 * = request.getParameter("ids"); ResponseEntity<Integer> responseEntity =
	 * this.restTemplate.exchange(DELETE_FUNCTION + ids, HttpMethod.POST, new
	 * HttpEntity<String>(this.httpHeaders), Integer.class); int result =
	 * responseEntity.getBody(); return result; }
	 * 
	 *//**
		 * 导出系统日志
		 * 
		 * @param response
		 * @return
		 */
	/*
	 * @RequestMapping(value = "/exportData") public void
	 * exportData(HttpServletRequest request, HttpServletResponse response) { SysLog
	 * sysLog = new SysLog(); sysLog.setLimit("-1"); // String page =
	 * request.getParameter("page"); // 起始索引 // String limit =
	 * request.getParameter("limit"); // 每页显示的行数 String logAction =
	 * request.getParameter("logAction"); String logActionName =
	 * request.getParameter("logActionName"); String logsTime =
	 * request.getParameter("logTime"); // sysLog.setPage(page); //
	 * sysLog.setLimit(limit); sysLog.setLogAction(logAction);
	 * sysLog.setLogActionName(logActionName); sysLog.setLogsTime(logsTime);
	 * HttpEntity<SysLog> entity = new HttpEntity<SysLog>(sysLog, this.httpHeaders);
	 * ResponseEntity<String> responseEntity =
	 * this.restTemplate.exchange(FUNCTION_LIST, HttpMethod.POST, entity,
	 * String.class); String result = responseEntity.getBody(); JSONObject retJson =
	 * JSON.parseObject(result); if (retJson != null) { List<SysLog> list =
	 * JSON.parseArray(retJson.getJSONArray("list").toJSONString(), SysLog.class);
	 * // 处理list数据 List<String> listKey = new ArrayList<String>();
	 * 
	 * listKey.add(0, "logId"); listKey.add(1, "logActionName"); listKey.add(2,
	 * "logAction"); listKey.add(3, "logType"); listKey.add(4, "logPersonId");
	 * listKey.add(5, "logPerson"); listKey.add(6, "logTime"); listKey.add(7,
	 * "logStatus"); listKey.add(8, "logIp"); listKey.add(9, "auditStatus");
	 * listKey.add(10, "logRemarks");
	 * 
	 * List<String> listName = new ArrayList<String>(); listName.add(0, "日志id");
	 * listName.add(1, "日志名称"); listName.add(2, "模块名称"); listName.add(3, "日志类型");
	 * listName.add(4, "操作人id"); listName.add(5, "操作人"); listName.add(6, "操作时间");
	 * listName.add(7, "日志状态"); listName.add(8, "ip地址"); listName.add(9, "审核状态");
	 * listName.add(10, "日志备注");
	 * 
	 * HSSFWorkbook wb = new HSSFWorkbook(); String filename = "日志列表" +
	 * DateUtil.dateToStr(new Date(), DateUtil.FMT_DD);
	 * 
	 * String beanName = "com.pcitc.base.system.SysLog"; HSSFSheet sheet =
	 * wb.createSheet("Sheet1"); sheet.setDefaultColumnWidth((short) 12); ExcelUtils
	 * excel = new ExcelUtils(wb, sheet); excel.insertExcelData(beanName, listKey,
	 * listName, list, 0);
	 * 
	 * try { ExcelUtils.responseDownload(response, wb, filename); } catch
	 * (IOException e) { e.printStackTrace(); } } }
	 * 
	 *//**
		 * 下载日志模板
		 * 
		 * @return
		 * @throws Exception
		 */
	/*
	 * 
	 * @RequestMapping(value = "/downloadTem") public ResponseEntity<?>
	 * downloadTem(HttpServletRequest request) throws Exception { HttpHeaders
	 * headers = new HttpHeaders(); String filePath = null; String path =
	 * request.getServletContext().getRealPath("/").replace("webapp\\", "");
	 * filePath = path + "resources/tem/logs.xls";
	 * headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	 * headers.setContentDispositionFormData("attachment", new
	 * String("日志模板.xls".getBytes("UTF-8"), "iso-8859-1")); return new
	 * ResponseEntity<byte[]>(FileUtils.readFileToByteArray(new File(filePath)),
	 * headers, HttpStatus.CREATED); }
	 * 
	 * 
	 * @RequestMapping(value = "/downloadTem") public void
	 * downloadTem(HttpServletRequest req, HttpServletResponse resp) throws
	 * Exception { req.setCharacterEncoding("UTF-8"); // 第一步：设置响应类型
	 * resp.setContentType("application/force-download");// 应用程序强制下载 // 第二读取文件
	 * String path =
	 * req.getServletContext().getRealPath("/").replace("webapp\\", ""); path +=
	 * "resources/tem/logs.xls"; InputStream in = new FileInputStream(path); //
	 * 设置响应头，对文件进行url编码 resp.setHeader("Content-Disposition", "attachment;filename="
	 * + URLEncoder.encode("日志模板.xls", "UTF-8"));
	 * resp.setContentLength(in.available()); // 第三步：开始copy OutputStream out =
	 * resp.getOutputStream(); byte[] b = new byte[1024]; int len = 0; while ((len =
	 * in.read(b)) != -1) { out.write(b, 0, len); } out.flush(); out.close();
	 * in.close(); }
	 * 
	 * @RequestMapping(value = "/newImportData")
	 * 
	 * @ResponseBody public Object newImportData(HttpServletRequest req,
	 * HttpServletResponse resp,MultipartFile file) throws Exception { if
	 * (file.isEmpty()) { return new Result(false,"上传异常，请重试!"); } InputStream in =
	 * file.getInputStream(); List<List<Object>> listob = new
	 * ImportExcelUtil().getBankListByExcel(in, file.getOriginalFilename());
	 * List<SysLog> list = new ArrayList<SysLog>(); for (int i = 0; i <
	 * listob.size(); i++) { List<Object> lo = listob.get(i); SysLog obj = new
	 * SysLog(); obj.setLogId(String.valueOf(lo.get(0)));
	 * obj.setLogActionName(String.valueOf(lo.get(1)));
	 * obj.setLogAction(String.valueOf(lo.get(2)));
	 * obj.setLogType(String.valueOf(lo.get(3)));
	 * obj.setLogPersonId(String.valueOf(lo.get(4)));
	 * obj.setLogPerson(String.valueOf(lo.get(5)));
	 * obj.setLogTime(DateUtil.strToDate(String.valueOf(lo.get(6)),
	 * DateUtil.FMT_SS)); obj.setLogStatus(String.valueOf(lo.get(7)));
	 * obj.setLogIp(String.valueOf(lo.get(8)));
	 * obj.setAuditStatus(String.valueOf(lo.get(9)));
	 * obj.setLogRemarks(String.valueOf(lo.get(10))); list.add(obj); } Integer
	 * rscount = this.restTemplate.exchange(IMPORT_FUNCTION, HttpMethod.POST, new
	 * HttpEntity<Object>(list, this.httpHeaders), Integer.class).getBody(); return
	 * new Result(true,rscount); }
	 *//**
		 * 导入excel数据
		 * 
		 * @param request
		 * @throws Exception
		 *//*
			 * @RequestMapping(value = "/importData") public ResponseEntity<?>
			 * importData(HttpServletRequest request) throws Exception { HttpHeaders header
			 * = new HttpHeaders(); MediaType mediaType = new MediaType("text", "html",
			 * Charset.forName("utf-8")); header.setContentType(mediaType);
			 * MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)
			 * request; InputStream in = null; List<List<Object>> listob = null;
			 * MultipartFile file = multipartRequest.getMultiFileMap().get("file").get(0);
			 * if (file.isEmpty()) { return new ResponseEntity<Integer>(404, header,
			 * HttpStatus.OK); } in = file.getInputStream(); listob = new
			 * ImportExcelUtil().getBankListByExcel(in, file.getOriginalFilename());
			 * in.close(); // 数据保存到数据库中 List<SysLog> list = new ArrayList<SysLog>(); for
			 * (int i = 0; i < listob.size(); i++) { List<Object> lo = listob.get(i); SysLog
			 * obj = new SysLog(); obj.setLogId(String.valueOf(lo.get(0)));
			 * obj.setLogActionName(String.valueOf(lo.get(1)));
			 * obj.setLogAction(String.valueOf(lo.get(2)));
			 * obj.setLogType(String.valueOf(lo.get(3)));
			 * obj.setLogPersonId(String.valueOf(lo.get(4)));
			 * obj.setLogPerson(String.valueOf(lo.get(5)));
			 * obj.setLogTime(DateUtil.strToDate(String.valueOf(lo.get(6)),
			 * DateUtil.FMT_SS)); obj.setLogStatus(String.valueOf(lo.get(7)));
			 * obj.setLogIp(String.valueOf(lo.get(8)));
			 * obj.setAuditStatus(String.valueOf(lo.get(9)));
			 * obj.setLogRemarks(String.valueOf(lo.get(10))); list.add(obj); }
			 * HttpEntity<List<SysLog>> entity = new HttpEntity<List<SysLog>>(list,
			 * this.httpHeaders); ResponseEntity<Integer> responseEntity =
			 * this.restTemplate.exchange(IMPORT_FUNCTION, HttpMethod.POST, entity,
			 * Integer.class); int result = responseEntity.getBody(); return new
			 * ResponseEntity<Integer>(result, header, HttpStatus.OK); }
			 */
}
