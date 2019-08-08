package com.pcitc.web.controller.mobile;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.expert.ZjkChoice;
import com.pcitc.base.expert.ZjkExpert;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;
import com.pcitc.web.utils.HanaUtil;

@Controller
public class MobileController extends BaseController {
	 /**
     * 根据ID获取对象信息
     */
    private static final String GET_INFO = "http://pcitc-zuul/stp-proxy/zjkbaseinfo-provider/zjkbaseinfo/get-zjkbaseinfo/";
	
    private static final String LIST_EXAMPLE = "http://pcitc-zuul/stp-proxy/zjkbaseinfo-provider/zjkbaseinfo/zjkbaseinfo_list_example";
    //备选查询
    private static final String LISTBAK = "http://pcitc-zuul/stp-proxy/zjkchoice-provider/zjkchoice/zjkchoice_list";
    /**
	 * 院士
	 */
	private static final String ZJK_YS_LIST = "http://pcitc-zuul/stp-proxy/zjkbaseinfo-provider/zjkbaseinfo/zjkYsList";

    //查询所有人员列表,姓名&ID
    private static final String queryAllExpert = "http://pcitc-zuul/stp-proxy/zjkbaseinfo-provider/zjkbaseinfo/queryAllExpert";
    /**
	 * 分页查询
	 */
	private static final String LISTPAGE = "http://pcitc-zuul/stp-proxy/zjkbaseinfo-provider/zjkbaseinfo/zjkbaseinfo-page";
	@RequestMapping(value = "/mobile/budget")
	public String budget(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String nd = HanaUtil.getCurrentYear();
		request.setAttribute("nd", nd);
		return "/mobile/budget";
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
		
		
		
		
		return "/mobile/project";
	}
	
	
	
	
	/**
	 * ================================================现金流
	 */
	@RequestMapping(value = "/mobile/cash")
	public String cash(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String month = HanaUtil.getCurrentYearMoth();
		request.setAttribute("month", month);
		String companyCode = EquipmentUtils.getVirtualDirDeparetCode(EquipmentUtils.SYS_FUNCTION_FICTITIOUS, restTemplate, httpHeaders);
		request.setAttribute("companyCode", companyCode);
		
		return "/mobile/cash";
	}
	

	/**
	 * ================================================科研人才
	 */
	@RequestMapping(value = "/mobile/personnel")
	public String kytr(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String nd = HanaUtil.getCurrentYear();
		request.setAttribute("nd", nd);
		return "/mobile/personnel";
	}
	
	@RequestMapping(value = "/mobile/personnel_details")
	public String personnel_details(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//专家详情
        String expertId = request.getParameter("expertId");
        ResponseEntity<ZjkExpert> responseEntity = this.restTemplate.exchange(GET_INFO + expertId, HttpMethod.POST, new HttpEntity<String>(this.httpHeaders), ZjkExpert.class);
        ZjkExpert zjkBaseInfo = responseEntity.getBody();
        request.setAttribute("zjkBaseInfo", zjkBaseInfo);
        request.setAttribute("hylyName", zjkBaseInfo.getExpertProfessionalFieldName());
        request.setAttribute("hyly", zjkBaseInfo.getExpertProfessionalField());
        request.setAttribute("display", request.getParameter("display"));
		
		return "/mobile/personnel_details";
	}
	
	
	@RequestMapping(value = "/mobile/zjk-ys-list", method = RequestMethod.POST)
	@ResponseBody
	public Object getmobileYsList(HttpServletRequest request) {
		ZjkExpert zjk = new ZjkExpert();
		ResponseEntity<Object> responseEntity = this.restTemplate.exchange(ZJK_YS_LIST, HttpMethod.POST, new HttpEntity<ZjkExpert>(zjk, this.httpHeaders), Object.class);
		return responseEntity.getBody();
	}
	
	
	@RequestMapping(value = "/mobile/queryAllExpert", method = RequestMethod.GET)
    @ResponseBody
    public String querymobileAllExpert() {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ZjkExpert expert = new ZjkExpert();
        expert.setiSortCol("expert_name");
        expert.setsSortDir_0("asc");
        ResponseEntity<JSONObject> responseEntity = this.restTemplate.exchange(queryAllExpert, HttpMethod.POST, new HttpEntity<ZjkExpert>(expert, this.httpHeaders), JSONObject.class);
        JSONObject retJson = responseEntity.getBody();
        List<Map<String, Object>> list = (List<Map<String, Object>>) retJson.get("expert");
        return JSON.toJSONString(list);
    }
	
	
	//所有专家
	@RequestMapping(value = "/mobile/getAllExpertTableData", method = RequestMethod.POST)
	@ResponseBody
	public Object getTableData(HttpServletRequest request, HttpServletResponse response) 
	{
		

		LayuiTableParam param = new LayuiTableParam();
		String nd = CommonUtil.getParameter(request, "nd", "" + DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY));
		String limit = CommonUtil.getParameter(request, "limit", "15");
		String page = CommonUtil.getParameter(request, "page", "1");


		param.setLimit(Integer.valueOf(limit));
		param.setPage(Integer.valueOf(page));
		param.getParam().put("nd", nd);
		System.out.println(">>>>>>>>>>>>nd:" + nd + "page=" + page);
		
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, this.httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = this.restTemplate.exchange(LISTPAGE, HttpMethod.POST, entity, LayuiTableData.class);
		LayuiTableData data = responseEntity.getBody();
		System.out.println(JSON.toJSON(data).toString());
		return JSON.toJSON(data).toString();
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
	@RequestMapping(value = "/mobile/kyzb")
	public String kyzb(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String nd = HanaUtil.getCurrentYear();
		request.setAttribute("nd", nd);

		String month = HanaUtil.getCurrentYear_Moth();
		request.setAttribute("month", month);

		String companyCode = HanaUtil.YJY_CODE_NOT_YINGKE;
		request.setAttribute("companyCode", companyCode);
		return "/mobile/kyzb";
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
	

}
