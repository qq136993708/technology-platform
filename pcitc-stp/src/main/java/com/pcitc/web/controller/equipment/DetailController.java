package com.pcitc.web.controller.equipment;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.budget.BudgetInfo;
import com.pcitc.base.stp.equipment.SreDetail;
import com.pcitc.base.stp.equipment.SrePurchase;
import com.pcitc.base.stp.equipment.UnitField;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;

@Controller
public class DetailController extends BaseController {
	
	private static final String PAGE_URL = "http://pcitc-zuul/stp-proxy/sre-provider/detail/page";
//	private static final String BUDGET_ASSETSPLIT_TITLES = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-assetsplit-titles";
//	private static final String BUDGET_ASSETSPLIT_INFO = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-assetsplit-info";	
//	private static final String BUDGET_ASSETSPLIT_ITEMS = "http://pcitc-zuul/stp-proxy/stp-provider/budget/budget-assetsplit-items";

    private static final String PAGE_LEDGER_URL = "http://pcitc-zuul/stp-proxy/sre-provider/ledger/page";
    
    
    private static final String GET_URL = "http://pcitc-zuul/stp-proxy/sre-provider/detail/get/";
    
    private static final String DETAIL = "http://pcitc-zuul/stp-proxy/sre-provider/detailLIVRW/page";
	
	/**
	 * 列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sre-detail/list")
	@ResponseBody
	public String ajaxlist(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {
		
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PAGE_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============result" + result);
		return result.toString();
	}

	@RequestMapping(value = "/sre-detail/to-list")
	public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> map = EquipmentUtils.getDepartInfoBySysUser(sysUserInfo, restTemplate, httpHeaders);
		String parentUnitPathNames = map.get("unitName");// 申报单位
		String parentUnitPathIds = map.get("unitCode");// 申报单位
		String applyDepartName = map.get("applyDepartName");// 申报部门
		String applyDepartCode = map.get("applyDepartCode");// 申报部门
		String unitPathIds= map.get("applyDepartCode");
		String unitPathNames= map.get("applyDepartName");
		
		request.setAttribute("unitPathIds", unitPathIds);
		request.setAttribute("parentUnitPathIds", parentUnitPathIds);
		return "/stp/equipment/detail/detail-list";
	}


	@RequestMapping(value = "/sre-detail/to-equipmentLedger-list")
	public String equipmentLedgerList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Map<String, String> map = EquipmentUtils.getDepartInfoBySysUser(sysUserInfo, restTemplate, httpHeaders);
		String parentUnitPathNames = map.get("unitName");// 申报单位
		String parentUnitPathIds = map.get("unitCode");// 申报单位
		String applyDepartName = map.get("applyDepartName");// 申报部门
		String applyDepartCode = map.get("applyDepartCode");// 申报部门
		String unitPathIds= map.get("applyDepartCode");
		String unitPathNames= map.get("applyDepartName");

		request.setAttribute("unitPathIds", unitPathIds);
		request.setAttribute("parentUnitPathIds", parentUnitPathIds);

		return "/stp/equipment/detail/ledger-list";
	}

    /**
     * 查询ERP装备台账
     * @param param
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/sre-ledger/list")
    @ResponseBody
    public String ajaxLedgerList(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {

        LayuiTableData layuiTableData = new LayuiTableData();
        HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
        ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PAGE_LEDGER_URL, HttpMethod.POST, entity, LayuiTableData.class);
        int statusCode = responseEntity.getStatusCodeValue();
        if (statusCode == 200) {
            layuiTableData = responseEntity.getBody();
        }
        JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
        logger.info("============result" + result);
        return result.toString();
    }

     /*=================================导出Excel文档 START================================*/
    @RequestMapping("sre-ledger/exportExcel")
    public void downBudgetGroupSplit(HttpServletResponse res) throws IOException {
        LayuiTableParam param = new LayuiTableParam();
        param.setLimit(100);
        param.setPage(1);
        System.out.println(JSON.toJSONString(param));
        ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(PAGE_LEDGER_URL, HttpMethod.POST, new HttpEntity<LayuiTableParam>(param, this.httpHeaders), LayuiTableData.class);
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

                String equipmentName = json.getString("equipmentName");
                String equipmentPrice = json.getString("equipmentPrice");
                String equipmenNumber = json.getString("equipmenNumber");
                String declareUnit = json.getString("declareUnit");
                String declareDepartment = json.getString("declareDepartment");
                String declarePeople = json.getString("declarePeople");
                String assetNumber = json.getString("assetNumber");
                String g0txt50 = json.getString("g0txt50");
                String g0naprz = json.getString("g0naprz");
                String g0saprz = json.getString("g0saprz");
                String g0schrw = json.getString("g0schrw");
                String g0ncgzyzje = json.getString("g0ncgzyzje");



                Row row = sheet.getRow(c_index);
                if (row == null) {
                    row = sheet.createRow(c_index);
                }

                row.createCell(0).setCellValue(equipmentName);
                row.createCell(1).setCellValue(equipmentPrice);
                row.createCell(2).setCellValue(equipmenNumber);
                row.createCell(3).setCellValue(declareUnit);
                row.createCell(4).setCellValue(declareDepartment);
                row.createCell(5).setCellValue(declarePeople);
                row.createCell(6).setCellValue(assetNumber);
                row.createCell(7).setCellValue(g0txt50);
                row.createCell(8).setCellValue(g0naprz);
                row.createCell(9).setCellValue(g0saprz);
                row.createCell(10).setCellValue(g0schrw);
                row.createCell(11).setCellValue(g0ncgzyzje);
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
    
    /**
	 * 详情
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sre-detail/get/{id}", method = RequestMethod.GET)
	public String get(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseEntity<SreDetail> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), SreDetail.class);
		int statusCode = responseEntity.getStatusCodeValue();
		logger.info("============远程返回  statusCode " + statusCode);
		SreDetail pplication =  responseEntity.getBody();
		request.setAttribute("pplication", pplication);
		return "/stp/equipment/detail/detail-view";
	}
	
	/**
	 * 详情列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sre-detail/listView")
	@ResponseBody
	public String listView(@ModelAttribute("param") LayuiTableParam param, HttpServletRequest request, HttpServletResponse response) {
		
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(DETAIL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============result" + result);
		return result.toString();
	}
}
