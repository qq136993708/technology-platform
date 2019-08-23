package com.pcitc.web.controller.mobile;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.ChartPieDataValue;
import com.pcitc.base.common.ChartPieResultData;
import com.pcitc.base.common.ChartSingleLineResultData;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.hana.report.Contract;
import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.stp.out.OutAppraisal;
import com.pcitc.base.stp.out.OutProjectPlan;
import com.pcitc.base.system.Department;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.OperationFilter;
import com.pcitc.web.utils.EquipmentUtils;
import com.pcitc.web.utils.HanaUtil;

@Controller
public class MobileController extends BaseController {
	
	
    private static final String LIST_EXAMPLE = "http://pcitc-zuul/stp-proxy/zjkbaseinfo-provider/zjkbaseinfo/zjkbaseinfo_list_example";
    //备选查询
    private static final String LISTBAK = "http://pcitc-zuul/stp-proxy/zjkchoice-provider/zjkchoice/zjkchoice_list";
    // 科技奖励数量（研究院）
 	private static final String APPRAISAL_COUNT = "http://pcitc-zuul/system-proxy/out-provider/appraisal-count";
	
	private static final String contract_01 = "http://pcitc-zuul/system-proxy/out-project-plan-provider/complete-rate/total";
	// 数量--知识
    private static final String achievement_table_data = "http://pcitc-zuul/system-proxy/out-provider/project/appraisal-list";

		
    private static final String GET_OUT_APPRAISAL = "http://pcitc-zuul/system-proxy/out-appraisal-provider/getAppraisalInfoByjdh/";
    
    private static final String getOutProjectPlanByXmId = "http://pcitc-zuul/system-proxy/out-project-plan-provider/getOutProjectPlanByXmId/";
    private static final String GET_URL    = "http://pcitc-zuul/system-proxy/department-provider/department/get/";
		
	@RequestMapping(value = "/mobile/budget")
	public String budget(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String nd = HanaUtil.getCurrentYear();
		request.setAttribute("nd", nd);
		return "/mobile/budget";
	}
	
	
	@RequestMapping(value = "/mobile/appraisal")
	public String appraisal(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String nd = HanaUtil.getCurrentYear();
		request.setAttribute("nd", nd);
		return "/mobile/appraisal";
	}
	
	
	
	
	
	@RequestMapping(value = "/mobile/institute")
	public String institute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		
		return "/mobile/institute";
	}

	@RequestMapping(value = "/mobile/institute_new")
	public String institute_new(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String id = CommonUtil.getParameter(request, "id", "");
		ResponseEntity<Department> responseEntity = this.restTemplate.exchange(GET_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), Department.class);
		int statusCode = responseEntity.getStatusCodeValue();
		logger.info("============远程返回  statusCode " + statusCode);
		Department department = responseEntity.getBody();
		request.setAttribute("department", department);
		return "/mobile/institute_new";
	}
	
	
	
	/**
	 * @param request
	 * @return 查询科技成果
	 */
	@RequestMapping(value = "/mobile/admin/appraisal-count", method = RequestMethod.POST)
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public Object getAppraisalCount(HttpServletRequest request) {
		HashMap<String, String> map = new HashMap<String, String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		Date date = new Date();

		System.out.println("1====getAppraisalCount" + request.getParameter("nd"));
		if (request.getParameter("lastYearFlag") != null && !request.getParameter("lastYearFlag").equals("")) {
			map.put("nd", String.valueOf(Integer.parseInt(sdf.format(date)) - 1));
		}
		if (request.getParameter("nd") != null && !request.getParameter("nd").equals("")) {
			map.put("nd", request.getParameter("nd"));
		}
		if (request.getParameter("define3") != null && !request.getParameter("define3").equals("")) {
			map.put("define3", request.getParameter("define3"));
		}
		if (request.getParameter("define1") != null && !request.getParameter("define1").equals("")) {
			map.put("define1", request.getParameter("define1"));
		}

		map.put("leaderFlag", String.valueOf(sysUserInfo.getUserLevel()));

		String cgjszy = request.getAttribute("cgjszy") == null ? "" : request.getAttribute("cgjszy").toString();
		System.out.println("1====cgjszy" + cgjszy);

		map.put("cgjszy", cgjszy);

		HttpEntity<HashMap<String, String>> entity = new HttpEntity<HashMap<String, String>>(map, this.httpHeaders);

		ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(APPRAISAL_COUNT, HttpMethod.POST, entity, JSONObject.class);
		JSONObject retJson = responseEntity.getBody();

		Long appraisalCount = retJson.get("appraisalCount") != null ? Long.parseLong(retJson.get("appraisalCount").toString()) : 0l;

		JSONObject jsonObj = new JSONObject();
		jsonObj.put("appraisalCount", appraisalCount);

		return jsonObj.toString();
	}
	
	
	
	
	/**
	 * 全口径新开课题合同（任务书）签订率
	 */
	@RequestMapping(value = "/mobile/index_contract")
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public String index_contract(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String resault = "";
		Result result = new Result();
		String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
		String type = CommonUtil.getParameter(request, "type", "");
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("nd", nd);
		// 数据控制属性
		String zycbm = request.getAttribute("zycbm") == null ? "" : request.getAttribute("zycbm").toString();
		String zylbbm = request.getAttribute("zylbbm") == null ? "" : request.getAttribute("zylbbm").toString();
		paramsMap.put("zycbm", zycbm);
		paramsMap.put("zylbbm", zylbbm);
		// 领导标识
		paramsMap.put("leaderFlag", sysUserInfo.getUserLevel());

		ChartPieResultData pie = new ChartPieResultData();
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));

		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		if (!nd.equals("")) {
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(contract_01, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {

				JSONArray jSONArray = responseEntity.getBody();
				System.out.println(">>>>>>>>>>>>>>index_contract jSONArray-> " + jSONArray.toString());
				List<Contract> list = JSONObject.parseArray(jSONArray.toJSONString(), Contract.class);
				Contract contract = list.get(0);
				Integer yqht = (Integer) contract.getYqht();
				Integer wqht = (Integer) contract.getWqht();
				Integer zsl = (Integer) contract.getZsl();
				Object o = contract.getQdl();
				String qdl = "0";
				if (o != null) {
					qdl = ((BigDecimal) contract.getQdl()).toString();
				}
				if (type.equals("1")) {

					Map map = new HashMap();
					map.put("yqht", yqht);
					map.put("zsl", zsl);
					map.put("qdl", Double.valueOf(qdl));
					result.setSuccess(true);
					result.setData(map);
				}
				if (type.equals("2")) {

					Map map2 = new HashMap();
					map2.put("name", "签订率");
					map2.put("value", Double.valueOf(qdl));
					result.setSuccess(true);
					result.setData(map2);
				}
			}

		} else {
			result.setSuccess(false);
			result.setMessage("参数为空");
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
		resault = resultObj.toString();
		// 安全设置：归档文件下载
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		return resault;
	}

	
	
	
	
	/**
	 * 合同签订率
	 */
	@RequestMapping(value = "/mobile/index_contract_rate")
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public String index_contract_rate(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String resault = "";
		Result result = new Result();
		String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
		String type = CommonUtil.getParameter(request, "type", "");
		String xmlbbm = CommonUtil.getParameter(request, "xmlbbm", "");
		String define3 = CommonUtil.getParameter(request, "define3", "");
		String zycbm = request.getAttribute("zycbm") == null ? "" : request.getAttribute("zycbm").toString();
		String zylbbm = request.getAttribute("zylbbm") == null ? "" : request.getAttribute("zylbbm").toString();

		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("nd", nd);
		paramsMap.put("define3", define3);
		paramsMap.put("xmlbbm", xmlbbm);
		paramsMap.put("zycbm", zycbm);
		paramsMap.put("zylbbm", zylbbm);
		paramsMap.put("leaderFlag", sysUserInfo.getUserLevel()); // 领导标识

		ChartPieResultData pie = new ChartPieResultData();
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		if (!nd.equals("")) {
			ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(contract_01, HttpMethod.POST, entity, JSONArray.class);
			int statusCode = responseEntity.getStatusCodeValue();
			if (statusCode == 200) {

				JSONArray jSONArray = responseEntity.getBody();
				System.out.println(">>>>>>>>>>>>>>index_contract_rate jSONArray-> " + jSONArray.toString());
				List<Contract> list = JSONObject.parseArray(jSONArray.toJSONString(), Contract.class);
				if (type.equals("1")) {
					Contract contract = list.get(0);
					Integer yqht = (Integer) contract.getYqht();
					Integer wqht = (Integer) contract.getWqht();

					ChartSingleLineResultData chartSingleLineResultData = new ChartSingleLineResultData();
					List<String> xAxisDataList = new ArrayList<String>();
					xAxisDataList.add("已签");
					xAxisDataList.add("未签");
					List<Object> seriesDataList = new ArrayList<Object>();
					seriesDataList.add(yqht);
					seriesDataList.add(wqht);

					chartSingleLineResultData.setSeriesDataList(seriesDataList);
					chartSingleLineResultData.setxAxisDataList(xAxisDataList);

					result.setSuccess(true);
					result.setData(chartSingleLineResultData);
				}
				if (type.equals("2")) {

					List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
					List<String> legendDataList = new ArrayList<String>();
					Contract contract = list.get(0);
					Integer yqht = (Integer) contract.getYqht();
					Integer wqht = (Integer) contract.getWqht();
					legendDataList.add("已签");
					legendDataList.add("未签");

					dataList.add(new ChartPieDataValue(yqht, "已签"));
					dataList.add(new ChartPieDataValue(wqht, "未签"));

					pie.setDataList(dataList);
					pie.setLegendDataList(legendDataList);
					result.setSuccess(true);
					result.setData(pie);
				}

				if (type.equals("3")) {

					Contract contract = list.get(0);
					result.setSuccess(true);
					result.setData(contract);

				}
			}

		} else {
			result.setSuccess(false);
			result.setMessage("参数为空");
		}
		JSONObject resultObj = JSONObject.parseObject(JSONObject.toJSONString(result));
		resault = resultObj.toString();
		// 安全设置：归档文件下载
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		return resault;
	}
	
	
	
   
	
	
	/**
	 * ================================================科研合同 begin
	 * =====================================
	 */

	@RequestMapping(value = "/mobile/contract")
	public String contract(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String nd = HanaUtil.getCurrentYear();
		request.setAttribute("nd", nd);
		return "/mobile/contract";
	}
	
	/**
	 * ================================================科研投入 begin
	 * =====================================
	 */
	@RequestMapping(value = "/mobile/project")
	public String project(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		String nd = CommonUtil.getParameter(request, "nd",HanaUtil.getCurrentYear());// 项目名
		String ysnd = CommonUtil.getParameter(request, "ysnd", "");// 项目名
		String xmmc = CommonUtil.getParameter(request, "xmmc", "");// 项目名
		String hth = CommonUtil.getParameter(request, "hth", "");// 合同号
		String define1 = CommonUtil.getParameter(request, "define1", "");// 资本性、费用性
		String define2 = CommonUtil.getParameter(request, "define2", "");// 8大院等细分结构
		String define3 = CommonUtil.getParameter(request, "define3", "");// 直属研究院、分子公司、集团等9种类型
		String project_property = CommonUtil.getParameter(request, "project_property", "");// 国家项目、重大专项、重点项目、其他项目
		String project_scope = CommonUtil.getParameter(request, "project_scope", "");// 新开项目、续建项目、完工项目
		String zylb = CommonUtil.getParameter(request, "zylb", "");// 装备的各种技术类型
		String define10 = CommonUtil.getParameter(request, "define10", "");// 各个处室
		String qdbz = CommonUtil.getParameter(request, "qdbz", "");// 签订标识
		String define11 = CommonUtil.getParameter(request, "define11", "");// 费用来源
		String define12 = CommonUtil.getParameter(request, "define12", "");// 单位类别
		String fzdwflag = CommonUtil.getParameter(request, "fzdwflag", "承担单位");
		String groupFlag = CommonUtil.getParameter(request, "groupFlag", "");// 查询分组条件
		request.setAttribute("fzdwflag", fzdwflag);
		request.setAttribute("define12", define12);
		request.setAttribute("define11", define11);
		request.setAttribute("qdbz", qdbz);
		request.setAttribute("nd", nd);
		request.setAttribute("ysnd", ysnd);
		request.setAttribute("define10", define10);
		request.setAttribute("xmmc", xmmc);
		request.setAttribute("hth", hth);
		request.setAttribute("define1", define1);
		request.setAttribute("define2", define2);
		request.setAttribute("define3", define3);
		request.setAttribute("project_property", project_property);
		request.setAttribute("project_scope", project_scope);
		request.setAttribute("zylb", zylb);
		request.setAttribute("groupFlag", groupFlag);
		String projectId = CommonUtil.getParameter(request, "projectId", "");
		request.setAttribute("projectId", projectId);
		
		
        // 部门
		List<SysDictionary> gsbmbmList = CommonUtil.getDictionaryByParentCode("ROOT_ZGSHJT_ZBJG", restTemplate, httpHeaders);
		request.setAttribute("gsbmbmList", gsbmbmList);
		// 科技部二级级联： 专业处->专业类别
		List<SysDictionary> zycList = CommonUtil.getDictionaryByParentCode("ROOT_ZGSHJT_ZBJG_KJB", restTemplate, httpHeaders);
		request.setAttribute("zycList", zycList);
		// 直属研究院
		List<SysDictionary> yjyList = CommonUtil.getDictionaryByParentCode("ROOT_ZGSHJT_GFGS_ZSYJY", restTemplate, httpHeaders);
		request.setAttribute("yjyList", yjyList);
				
		return "/mobile/project";
	}
	
	
	@RequestMapping(value = "/mobile/project_details")
	public String project_details(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{

		String month = HanaUtil.getCurrentYearMoth();
		request.setAttribute("month", month);
		String companyCode = EquipmentUtils.getVirtualDirDeparetCode(EquipmentUtils.SYS_FUNCTION_FICTITIOUS, restTemplate, httpHeaders);
		request.setAttribute("companyCode", companyCode);
		
		String xmid = CommonUtil.getParameter(request, "xmid", "");
		request.setAttribute("xmid", xmid);
		
		ResponseEntity<OutProjectPlan> responseEntity = this.restTemplate.exchange(getOutProjectPlanByXmId + xmid, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), OutProjectPlan.class);
		int statusCode = responseEntity.getStatusCodeValue();
		logger.info("============远程返回  statusCode " + statusCode);
		OutProjectPlan outProjectPlan = responseEntity.getBody();
		    
		List<OutProjectPlan> companyMoneryList=new ArrayList<OutProjectPlan>();  
		String companyMoneryStr=outProjectPlan.getCompanyMoneryStr();
		if(companyMoneryStr!=null)
		{
			String arr[]=companyMoneryStr.split("#");
			if(arr!=null)
			{
				for(int i=0;i<arr.length;i++)
				{
					String str=arr[i];
					
					if(str!=null)
					{
						OutProjectPlan opp=new OutProjectPlan();
						String arr2[]=str.split(",");
						opp.setDefine8(arr2[0]);
						opp.setYsnd(arr2[1]);
						opp.setYsfyxje(arr2[2]);
						opp.setYszbxje(arr2[3]);
						opp.setYsje(arr2[4]);
						companyMoneryList.add(opp);
					}
				}
			}
			outProjectPlan.setCompanyMoneryList(companyMoneryList);
		}
		request.setAttribute("outProjectPlan", outProjectPlan);
		
		
		return "/mobile/project_details";
	}
	
	
	
	
	
	
	
	/**
	 * ================================================现金流
	 */
	@RequestMapping(value = "/mobile/cash")
	public String cash(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String month = HanaUtil.getCurrentYear_Moth();
		request.setAttribute("month", month);
		String companyCode = EquipmentUtils.getVirtualDirDeparetCode(EquipmentUtils.SYS_FUNCTION_FICTITIOUS, restTemplate, httpHeaders);
		request.setAttribute("companyCode", companyCode);
		
		return "/mobile/cash";
	}
	

	

	/**
	 * ================================================科研投入 end
	 * =====================================
	 */

	

	/**
	 * ===============================================科研合同 end
	 * =====================================
	 */

	/**
	 * ================================================科研装备 begin
	 * =====================================
	 */
	@RequestMapping(value = "/mobile/appropriation")
	public String kyzb(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String nd = HanaUtil.getCurrentYear();
		request.setAttribute("nd", nd);

		String month = HanaUtil.getCurrentYear_Moth();
		request.setAttribute("month", month);

		String companyCode = HanaUtil.YJY_CODE_NOT_YINGKE;
		request.setAttribute("companyCode", companyCode);
		return "/mobile/appropriation";
	}

	/**
	 * ================================================科研装备 end
	 * =====================================
	 */

	/**
	 * ================================================科研支出 begin
	 * =====================================
	 */
	@RequestMapping(value = "/mobile/kyzc")
	public String kyzc(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nd = HanaUtil.getCurrentYear();
		request.setAttribute("nd", nd);

		String month = HanaUtil.getCurrentYear_Moth();
		request.setAttribute("month", month);

		return "/mobile/kyzc";
	}
	
	

	/**
	 * ================================================科研支出 end
	 * =====================================
	 */

	/**
	 * ================================================现金流量 begin
	 * =====================================
	 */
	@RequestMapping(value = "/mobile/xjll")
	public String xjll(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String nd = HanaUtil.getCurrentYear();
		request.setAttribute("nd", nd);
		String month = HanaUtil.getCurrentYear_Moth();
		request.setAttribute("month", month);

		return "/mobile/xjll";
	}

	/**
	 * ================================================现金流量 end
	 * =====================================
	 */

	/**
	 * ================================================成果专利 begin
	 * =====================================
	 */
	@RequestMapping(value = "/mobile/cgzl")
	public String cgzl(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String nd = HanaUtil.getCurrentYear();
		request.setAttribute("nd", nd);

		return "/mobile/cgzl";
	}
	
	@RequestMapping(value = "/mobile/zhfxChart")
	public String zhfxChart(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String nd = HanaUtil.getCurrentYear();
		request.setAttribute("nd", nd);

		return "/mobile/zhfxChart";
	}
	
	@RequestMapping(value = "/mobile/zhfxTable")
	public String zhfxTable(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String year = HanaUtil.getCurrentYear();
		request.setAttribute("year", year);

		return "/mobile/zhfxTable";
	}
	
	@RequestMapping(value = "/mobile/index2")
	public String index2(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String year = HanaUtil.getCurrentYear();
		request.setAttribute("year", year);

		return "/mobile/index2";
	}

	
	
	@RequestMapping(value = "/mobile/zhfxTable3")
	public String zhfxTable3(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String year = HanaUtil.getCurrentYear();
		request.setAttribute("year", year);

		return "/mobile/zhfxTable3";
	}
	
	
	
	
	
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/mobile/one_level_main/achievement_table_data")
	@ResponseBody
	@OperationFilter(dataFlag = "true")
	public String achievement_table_data(HttpServletRequest request, HttpServletResponse response) {

		
		
		String key = CommonUtil.getParameter(request, "key", "");
		String page = CommonUtil.getParameter(request, "page", "1");
		LayuiTableParam param = new LayuiTableParam();
		String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
		String limit = CommonUtil.getParameter(request, "limit", "15");

		param.setLimit(Integer.valueOf(limit));
		param.setPage(Integer.valueOf(page));
		param.getParam().put("nd", nd);
		param.getParam().put("key", key);
		param.getParam().put("leaderFlag", sysUserInfo.getUserLevel());
		System.out.println(">>>>>>>>>>>>achievement_table_data>param:" + JSONObject.toJSONString(param));
		
		
		
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(achievement_table_data, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		return result.toString();
	}
	
	
	
	
	
	@RequestMapping(value = "/mobile/getAppraisalInfoByjdh/{jdh}", method = RequestMethod.POST)
	@ResponseBody
	public OutAppraisal  getAppraisalInfoByjdh(@PathVariable("jdh") String jdh, HttpServletRequest request) {
		System.out.println("-------------------------getAppraisalInfoByjdh --------------------------------");
		ResponseEntity<OutAppraisal> responseEntity = this.restTemplate.exchange(GET_OUT_APPRAISAL + jdh, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), OutAppraisal.class);
		OutAppraisal  outAppraisal = responseEntity.getBody();
		return outAppraisal;
	}
	
	
	
	@RequestMapping(value = "/mobile/appraisal_detail/{jdh}", method = RequestMethod.GET)
	public String get(@PathVariable("jdh") String jdh, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponseEntity<OutAppraisal> responseEntity = this.restTemplate.exchange(GET_OUT_APPRAISAL + jdh, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), OutAppraisal.class);
		int statusCode = responseEntity.getStatusCodeValue();
		logger.info("============远程返回  statusCode " + statusCode);
		OutAppraisal outAppraisal = responseEntity.getBody();
		request.setAttribute("outAppraisal", outAppraisal);
		return "/mobile/appraisal_detail";
	}
	

	
	

}
