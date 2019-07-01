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
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.budget.BudgetInfo;
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

		String	parentUnitPathIds="";
		String unitPathIds =   sysUserInfo.getUnitPath();
		unitPathIds = EquipmentUtils.getParentUnitPathId(unitPathIds);
		request.setAttribute("unitPathIds", unitPathIds);
		request.setAttribute("parentUnitPathIds", parentUnitPathIds);
		return "/stp/equipment/detail/detail-list";
	}
	
	
	
}
