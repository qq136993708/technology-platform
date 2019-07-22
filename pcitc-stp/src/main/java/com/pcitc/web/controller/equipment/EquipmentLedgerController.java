package com.pcitc.web.controller.equipment;

import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.pcitc.base.util.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;

@Controller
public class EquipmentLedgerController extends BaseController{

	private static final String PAGE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/equipmentLedger/page";
	
	
	
	
	//查某院的
	@RequestMapping(value = "/sre_equipment_ledger/company_list")
	public String company_list(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String unitCode = EquipmentUtils.getEquipmentUnitCode(sysUserInfo, restTemplate, httpHeaders);
		String g0gsjc = EquipmentUtils.getHanaUnitNameByUnitCode(unitCode, restTemplate, httpHeaders);
		List<SysDictionary>  leaddicList= CommonUtil.getDictionaryByParentCode("ROOT_FZJCZX_YS", restTemplate, httpHeaders);
		request.setAttribute("leaddicList", leaddicList);
		request.setAttribute("g0gsjc", g0gsjc);
		return "/stp/equipment/ledger/company_list";
	}
	
	@RequestMapping(value = "/sre_equipment_ledger/company_list_data")
	@ResponseBody
	public String company_list_data(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {
		
		JSONObject parmamss = JSONObject.parseObject(JSONObject.toJSONString(param));
		logger.info("============参数：" + parmamss.toString());
		
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============查询结果：" + result);
		return result.toString();
	}
	
	
	
	//查所有院的
	@RequestMapping(value = "/sre_equipment_ledger/list")
	public String searchEquipment(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<SysDictionary>  leaddicList= CommonUtil.getDictionaryByParentCode("ROOT_FZJCZX_YS", restTemplate, httpHeaders);
		request.setAttribute("leaddicList", leaddicList);
		return "/stp/equipment/ledger/list";
	}
	@RequestMapping(value = "/sre_equipment_ledger/list_data")
	@ResponseBody
	public String ajaxlist(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {
		
		JSONObject parmamss = JSONObject.parseObject(JSONObject.toJSONString(param));
		logger.info("============参数：" + parmamss.toString());
		
		
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============查询结果：" + result);
		return result.toString();
	}



	/*=================================导出Excel文档 START================================*/
	@RequestMapping("sre-ledger/exportLedgerExcel")
	public void downBudgetGroupSplit(HttpServletRequest request,HttpServletResponse res) throws IOException {
		LayuiTableParam param = new LayuiTableParam();
		String g0anln1 = CommonUtil.getParameter(request, "g0anln1", "");
		String g0gsjc = CommonUtil.getParameter(request, "g0gsjc", "");
		String month = CommonUtil.getParameter(request, "month", "");
		String g0txt50 = CommonUtil.getParameter(request, "g0txt50", "");

        param.getParam().put("g0anln1", g0anln1);
		param.getParam().put("g0gsjc", g0gsjc);
		param.getParam().put("month", month);
		param.getParam().put("g0txt50", g0txt50);
		param.setLimit(100000);
		param.setPage(1);
		System.out.println(JSON.toJSONString(param));
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(PAGE_URL, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), LayuiTableData.class);
		LayuiTableData tabldata = responseEntity.getBody();

		Map<String, String> parammap = new HashMap<String, String>();

		URL path = this.getClass().getResource("/");
		File f = new File(path.getPath() + "static/template/equipmentLedger.xlsx");
		// 写入新文件采购申请单模板
		String newFilePath = path.getPath() + "static/template/装备台账Excel_" + DateUtil.dateToStr(new Date(), "yyyyMMddHHmmss") + ".xlsx";
		File outFile = new File(newFilePath);

		processDataAndDownload(f, tabldata, parammap, outFile);
		// 下载文件
		this.fileDownload(new File(newFilePath), res);
	}

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;

	private void processDataAndDownload(File template, LayuiTableData tableData, Map<String, String> param, File outFile) {
		try {
			InputStream is = new FileInputStream(template);
			workbook = new XSSFWorkbook(is);
			sheet = workbook.getSheetAt(0);

			// 从第二行开始数据
			int c_index = 0;
			for (java.util.Iterator<?> iter = tableData.getData().iterator(); iter.hasNext();) {
				c_index++;
				JSONObject json = JSON.parseObject(JSON.toJSONString(iter.next()));

                String g0cald = json.getString("g0cald");//月份
                String g0gsjc = json.getString("g0gsjc");//公司简称
                String g0anln1 = json.getString("g0anln1");//资产号
                String g0txt50 = json.getString("g0txt50");//资产描述
                String g0ndjar = json.getString("g0ndjar");//使用年度
                String g0prctr = json.getString("g0prctr");//利润中心
                String g0prctrt = json.getString("g0prctrt");//利润中心描述
                String g0kostl = json.getString("g0kostl");//成本中心
                String g0kostlt = json.getString("g0kostlt");//使作部门
                String g0zzdxzc = json.getString("g0zzdxzc");//资产类别
                String g0zdxzct = json.getString("g0zdxzct");//资产类别描述
                String g0ord43 = json.getString("g0ord43");//技术状态
                String g0ord43t = json.getString("g0ord43t");//技术状态描述
                String g0ncgzyzje = json.getString("g0ncgzyzje");//购置价
                String g0ljzjje = json.getString("g0ljzjje");//已使用
                String g0ljgzyzje = json.getString("g0ljgzyzje");//账面净额
                String equipmentName = json.getString("equipmentName");//装备名


                Row row = sheet.getRow(c_index);
				if (row == null) {
					row = sheet.createRow(c_index);
				}
				row.createCell(0).setCellValue(g0cald);
                row.createCell(1).setCellValue(g0gsjc);
                row.createCell(2).setCellValue(g0anln1);
                row.createCell(3).setCellValue(g0txt50);
                row.createCell(4).setCellValue(g0ndjar);
                row.createCell(5).setCellValue(g0prctr);
                row.createCell(6).setCellValue(g0prctrt);
                row.createCell(7).setCellValue(g0kostl);
                row.createCell(8).setCellValue(g0kostlt);
                row.createCell(9).setCellValue(g0zzdxzc);
                row.createCell(10).setCellValue(g0zdxzct);
                row.createCell(11).setCellValue(g0ord43);
                row.createCell(12).setCellValue(g0ord43t);
                row.createCell(13).setCellValue(g0ncgzyzje);
                row.createCell(14).setCellValue(g0ljzjje);
                row.createCell(15).setCellValue(g0ljgzyzje);
                row.createCell(16).setCellValue(equipmentName);
			}

			// 写入新文件
			FileOutputStream fos = new FileOutputStream(outFile);
			workbook.write(fos);
			// 关闭流
			closeIO(fos);
			closeIO(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void fileDownload(File file, HttpServletResponse res) {
		OutputStream out = null;
		InputStream in = null;
		try {

			res.setHeader("content-type", "application/octet-stream");
			res.setContentType("application/octet-stream");
			res.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(file.getName(), "UTF-8"));

			out = res.getOutputStream();
			in = new FileInputStream(file);

			byte[] b = new byte[1000];
			int len;
			while ((len = in.read(b)) > 0) {
				out.write(b, 0, len);
			}
			closeIO(in);
			closeIO(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void closeIO(Closeable io) {
		if (io != null) {
			try {
				io.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*=================================导出Excel文档 END================================*/
	
}
