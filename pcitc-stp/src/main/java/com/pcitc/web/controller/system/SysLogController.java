package com.pcitc.web.controller.system;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Result;
import com.pcitc.base.system.SysLog;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.ExcelUtils;
import com.pcitc.web.utils.ImportExcelUtil;

@Controller
@RequestMapping("sysLog")
public class SysLogController extends BaseController {

	private static final String FUNCTION_LIST = "http://pcitc-zuul/system-proxy/sysLog-provider/sysLog_list";

	private static final String SAVE_FUNCTION = "http://pcitc-zuul/system-proxy/sysLog-provider/saveSysLog";

	private static final String DELETE_FUNCTION = "http://pcitc-zuul/system-proxy/sysLog-provider/deleteSysLog/";

	private static final String IMPORT_FUNCTION = "http://pcitc-zuul/system-proxy/sysLog-provider/importSysLog/";

	/**
	 * 跳转到系统日志列表页
	 */
	@RequestMapping(value = "/sysLog_list")
	public String toList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/base/system/sysLog_list";
	}

	/**
	 * 根据条件获取系统日志列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getLogList", method = RequestMethod.POST)
	@ResponseBody
	public Object getLogList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		SysLog sysLog = new SysLog();
		String page = request.getParameter("page"); // 起始索引
		String limit = request.getParameter("limit"); // 每页显示的行数
		String logAction = request.getParameter("logAction");
		String logActionName = request.getParameter("logActionName");
		String logsTime = request.getParameter("logTime");
		sysLog.setPage(page);
		sysLog.setLimit(limit);
		sysLog.setLogAction(logAction);
		sysLog.setLogActionName(logActionName);
		sysLog.setLogsTime(logsTime);
		HttpEntity<SysLog> entity = new HttpEntity<SysLog>(sysLog, this.httpHeaders);
		ResponseEntity<String> responseEntity = this.restTemplate.exchange(FUNCTION_LIST, HttpMethod.POST, entity, String.class);
		String result = responseEntity.getBody();
		JSONObject retJson = JSONObject.parseObject(result);
		if (retJson != null) {
			Long totalCount = retJson.get("totalCount") != null ? Long.parseLong(retJson.get("totalCount").toString()) : 0l;
			List<SysLog> resultList = JSON.parseArray(retJson.getJSONArray("list").toJSONString(), SysLog.class);
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("code", "0");
			jsonObj.put("msg", "提示");
			jsonObj.put("count", totalCount);
			jsonObj.put("data", resultList);
			return jsonObj.toString();
		}
		return null;
	}

	/**
	 * 保存系统日志
	 * 
	 * @param SysLog
	 * @return
	 */
	@RequestMapping(value = "/saveData")
	@ResponseBody
	public int saveData(SysLog SysLog) {
		HttpEntity<SysLog> entity = new HttpEntity<SysLog>(SysLog, this.httpHeaders);
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(SAVE_FUNCTION, HttpMethod.POST, entity, Integer.class);
		int result = responseEntity.getBody();
		return result;
	}

	/**
	 * 删除系统日志
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/deleteData")
	@ResponseBody
	public int deleteData(HttpServletRequest request) {
		String ids = request.getParameter("ids");
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(DELETE_FUNCTION + ids, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), Integer.class);
		int result = responseEntity.getBody();
		return result;
	}

	/**
	 * 导出系统日志
	 * 
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/exportData")
	public void exportData(HttpServletRequest request, HttpServletResponse response) {
		SysLog sysLog = new SysLog();
		sysLog.setLimit("-1");
		// String page = request.getParameter("page"); // 起始索引
		// String limit = request.getParameter("limit"); // 每页显示的行数
		String logAction = request.getParameter("logAction");
		String logActionName = request.getParameter("logActionName");
		String logsTime = request.getParameter("logTime");
		// sysLog.setPage(page);
		// sysLog.setLimit(limit);
		sysLog.setLogAction(logAction);
		sysLog.setLogActionName(logActionName);
		sysLog.setLogsTime(logsTime);
		HttpEntity<SysLog> entity = new HttpEntity<SysLog>(sysLog, this.httpHeaders);
		ResponseEntity<String> responseEntity = this.restTemplate.exchange(FUNCTION_LIST, HttpMethod.POST, entity, String.class);
		String result = responseEntity.getBody();
		JSONObject retJson = JSON.parseObject(result);
		if (retJson != null) {
			List<SysLog> list = JSON.parseArray(retJson.getJSONArray("list").toJSONString(), SysLog.class);
			// 处理list数据
			List<String> listKey = new ArrayList<String>();

			listKey.add(0, "logId");
			listKey.add(1, "logActionName");
			listKey.add(2, "logAction");
			listKey.add(3, "logType");
			listKey.add(4, "logPersonId");
			listKey.add(5, "logPerson");
			listKey.add(6, "logTime");
			listKey.add(7, "logStatus");
			listKey.add(8, "logIp");
			listKey.add(9, "auditStatus");
			listKey.add(10, "logRemarks");

			List<String> listName = new ArrayList<String>();
			listName.add(0, "日志id");
			listName.add(1, "日志名称");
			listName.add(2, "模块名称");
			listName.add(3, "日志类型");
			listName.add(4, "操作人id");
			listName.add(5, "操作人");
			listName.add(6, "操作时间");
			listName.add(7, "日志状态");
			listName.add(8, "ip地址");
			listName.add(9, "审核状态");
			listName.add(10, "日志备注");

			HSSFWorkbook wb = new HSSFWorkbook();
			String filename = "日志列表" + DateUtil.dateToStr(new Date(), DateUtil.FMT_DD);

			String beanName = "com.pcitc.base.system.SysLog";
			HSSFSheet sheet = wb.createSheet("Sheet1");
			sheet.setDefaultColumnWidth((short) 12);
			ExcelUtils excel = new ExcelUtils(wb, sheet);
			excel.insertExcelData(beanName, listKey, listName, list, 0);

			try {
				ExcelUtils.responseDownload(response, wb, filename);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 下载日志模板
	 * 
	 * @return
	 * @throws Exception
	 */
	/*
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
	 */

	@RequestMapping(value = "/downloadTem")
	public void downloadTem(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		// 第一步：设置响应类型
		resp.setContentType("application/force-download");// 应用程序强制下载
		// 第二读取文件
		String path = req.getServletContext().getRealPath("/").replace("webapp\\", "");
		path += "resources/tem/logs.xls";
		InputStream in = new FileInputStream(path);
		// 设置响应头，对文件进行url编码
		resp.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("日志模板.xls", "UTF-8"));
		resp.setContentLength(in.available());
		// 第三步：开始copy
		OutputStream out = resp.getOutputStream();
		byte[] b = new byte[1024];
		int len = 0;
		while ((len = in.read(b)) != -1) {
			out.write(b, 0, len);
		}
		out.flush();
		out.close();
		in.close();
	}
	@RequestMapping(value = "/newImportData")
	@ResponseBody
	public Object newImportData(HttpServletRequest req, HttpServletResponse resp,MultipartFile file) throws Exception 
	{
		if (file.isEmpty()) {
			return new Result(false,"上传异常，请重试!");
		}
		InputStream in = file.getInputStream();
		List<List<Object>> listob = new ImportExcelUtil().getBankListByExcel(in, file.getOriginalFilename());
		List<SysLog> list = new ArrayList<SysLog>();
		for (int i = 0; i < listob.size(); i++) {
			List<Object> lo = listob.get(i);
			SysLog obj = new SysLog();
			obj.setLogId(String.valueOf(lo.get(0)));
			obj.setLogActionName(String.valueOf(lo.get(1)));
			obj.setLogAction(String.valueOf(lo.get(2)));
			obj.setLogType(String.valueOf(lo.get(3)));
			obj.setLogPersonId(String.valueOf(lo.get(4)));
			obj.setLogPerson(String.valueOf(lo.get(5)));
			obj.setLogTime(DateUtil.strToDate(String.valueOf(lo.get(6)), DateUtil.FMT_SS));
			obj.setLogStatus(String.valueOf(lo.get(7)));
			obj.setLogIp(String.valueOf(lo.get(8)));
			obj.setAuditStatus(String.valueOf(lo.get(9)));
			obj.setLogRemarks(String.valueOf(lo.get(10)));
			list.add(obj);
		}
		Integer rscount = this.restTemplate.exchange(IMPORT_FUNCTION, HttpMethod.POST, new HttpEntity<Object>(list, this.httpHeaders), Integer.class).getBody();
		return new Result(true,rscount);
	}
	/**
	 * 导入excel数据
	 * 
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping(value = "/importData")
	public ResponseEntity<?> importData(HttpServletRequest request) throws Exception {
		HttpHeaders header = new HttpHeaders();
		MediaType mediaType = new MediaType("text", "html", Charset.forName("utf-8"));
		header.setContentType(mediaType);
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		InputStream in = null;
		List<List<Object>> listob = null;
		MultipartFile file = multipartRequest.getMultiFileMap().get("file").get(0);
		if (file.isEmpty()) {
			return new ResponseEntity<Integer>(404, header, HttpStatus.OK);
		}
		in = file.getInputStream();
		listob = new ImportExcelUtil().getBankListByExcel(in, file.getOriginalFilename());
		in.close();
		// 数据保存到数据库中
		List<SysLog> list = new ArrayList<SysLog>();
		for (int i = 0; i < listob.size(); i++) {
			List<Object> lo = listob.get(i);
			SysLog obj = new SysLog();
			obj.setLogId(String.valueOf(lo.get(0)));
			obj.setLogActionName(String.valueOf(lo.get(1)));
			obj.setLogAction(String.valueOf(lo.get(2)));
			obj.setLogType(String.valueOf(lo.get(3)));
			obj.setLogPersonId(String.valueOf(lo.get(4)));
			obj.setLogPerson(String.valueOf(lo.get(5)));
			obj.setLogTime(DateUtil.strToDate(String.valueOf(lo.get(6)), DateUtil.FMT_SS));
			obj.setLogStatus(String.valueOf(lo.get(7)));
			obj.setLogIp(String.valueOf(lo.get(8)));
			obj.setAuditStatus(String.valueOf(lo.get(9)));
			obj.setLogRemarks(String.valueOf(lo.get(10)));
			list.add(obj);
		}
		HttpEntity<List<SysLog>> entity = new HttpEntity<List<SysLog>>(list, this.httpHeaders);
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(IMPORT_FUNCTION, HttpMethod.POST, entity, Integer.class);
		int result = responseEntity.getBody();
		return new ResponseEntity<Integer>(result, header, HttpStatus.OK);
	}
}
