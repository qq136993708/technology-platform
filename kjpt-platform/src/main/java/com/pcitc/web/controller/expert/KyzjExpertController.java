package com.pcitc.web.controller.expert;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.*;
import com.pcitc.base.common.enums.RequestProcessStatusEnum;
import com.pcitc.base.expert.KyzjExpert;
import com.pcitc.base.expert.ZjkBase;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;
import com.pcitc.web.utils.ImportExcelUtil;
import com.pcitc.web.utils.PoiExcelExportUitl;
import com.pcitc.web.utils.RestMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;


@Api(value = "KyzjExpert-API",tags = {"科研专家维护-科研专家接口"})
@RestController
public class KyzjExpertController extends BaseController {
	
	/**
	 * 获取专家（分页）
	 */
	private static final String PAGE_EXPERT_URL = "http://kjpt-zuul/stp-proxy/kyzjExpert/page";
	/**
	 * 根据ID获取对象信息
	 */
	public static final String ADD_EXPERT_URL = "http://kjpt-zuul/stp-proxy/kyzjExpert/add";

	/**
	 * 根据ID获取对象信息
	 */
	public static final String UPDATE_EXPERT_URL = "http://kjpt-zuul/stp-proxy/kyzjExpert/update";

	/**
	 * 根据ID逻辑删除
	 */
	private static final String DEL_EXPERT_LOGIC_URL = "http://kjpt-zuul/stp-proxy/kyzjExpert/logic_delete/";
	
	/**
	 * 根据ID删除 
	 */
	private static final String DEL_EXPERT_URL = "http://kjpt-zuul/stp-proxy/kyzjExpert/delete/";
	
	/**
	 * 根据ID获取对象信息
	 */
	public static final String GET_EXPERT_URL = "http://kjpt-zuul/stp-proxy/kyzjExpert/get/";

	/**
	 * 查询专家个数
	 */
	private static final String getKyzjExpertCount = "http://kjpt-zuul/stp-proxy/kyzjExpert/getKyzjExpertCount";

	private static final String GET_UNIT_ID = "http://kjpt-zuul/system-proxy/unit-provider/unit/getUnitId_by_name";
	
	/**
	  * 获取专家（分页）
	 */
	
	
    @ApiOperation(value = "科研专家管理（分页）", notes = "科研专家管理（分页）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码", dataType = "string", paramType = "query",required=true),
        @ApiImplicitParam(name = "limit", value = "每页显示条数", dataType = "string", paramType = "query",required=true),
        @ApiImplicitParam(name = "yearStr", value = "年份", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "expertType", value = "科研专家类型", dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "customQueryConditionStr",                   value = "条件",     dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/KyzjExpert-api/list", method = RequestMethod.POST)
	public String getExpertPage(
			@RequestParam(required = true) Integer page,
            @RequestParam(required = true) Integer limit,
            @RequestParam(required = false) String yearStr,
            @RequestParam(required = false) String expertType,
            @RequestParam(required = false) String customQueryConditionStr,
			HttpServletRequest request, HttpServletResponse response)throws Exception 
     {
     	SysUser sysUserInfo = this.getUserProfile();
    	LayuiTableParam param =new LayuiTableParam();
    	param.getParam().put("yearStr", yearStr);
    	param.getParam().put("expertType",expertType);
    	param.getParam().put("customQueryConditionStr", customQueryConditionStr);
    	param.getParam().put("deleted", Constant.DEL_STATUS_NOT);
    	param.setLimit(limit);
    	param.setPage(page);
    	String userName=sysUserInfo.getUserName();
    	//默认查询当前人所在机构及子机构的所有专家
    	//String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(sysUserInfo.getUnitPath(), restTemplate, httpHeaders);
    	//param.getParam().put("childUnitIds", childUnitIds);
    	
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PAGE_EXPERT_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============获取科研专家列表（分页） " + result.toString());
		return result.toString();
	}
    
    @ApiOperation(value = "科研专家查询（分页）", notes = "科研专家查询（分页）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page",           value = "页码", dataType = "string", paramType = "query",required=true),
        @ApiImplicitParam(name = "limit",          value = "每页显示条数", dataType = "string", paramType = "query",required=true),
        @ApiImplicitParam(name = "yearStr",           value = "年份", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "expertType",     value = "科研专家分类", dataType = "string", paramType = "query"),
		@ApiImplicitParam(name = "customQueryConditionStr",                   value = "条件",     dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/KyzjExpert-api/query", method = RequestMethod.POST)
	public String queryExpertPage(
			@RequestParam(required = true) Integer page,
            @RequestParam(required = true) Integer limit,
            @RequestParam(required = false) String yearStr,
			@RequestParam(required = false) String expertType,
            @RequestParam(required = false) String customQueryConditionStr,
			HttpServletRequest request, HttpServletResponse response)throws Exception 
     {
    	LayuiTableParam param =new LayuiTableParam();
    	param.getParam().put("yearStr", yearStr);
		param.getParam().put("expertType", expertType);
    	param.getParam().put("deleted", Constant.DEL_STATUS_NOT);
    	param.setLimit(limit);
    	param.setPage(page);
    	param.getParam().put("customQueryConditionStr", customQueryConditionStr);
		SysUser sysUserInfo = this.getUserProfile();
    	//默认查询小于等于用户密级的专家
    	//param.getParam().put("userSecretLevel",sysUserInfo.getSecretLevel() );
    	//param.getParam().put("knowledgeScope", sysUserInfo.getUserName());
		System.out.println("======== customQueryConditionStr: "+customQueryConditionStr);
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PAGE_EXPERT_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============获取科研专家列表（分页） " + result.toString());
		return result.toString();
	}
    
    @ApiOperation(value = "查询科研专家个数", notes = "查询科研专家个数")
    @RequestMapping(value = "/KyzjExpert-api/getCount", method = RequestMethod.GET)
	public String getKyzjExpertCount() throws Exception {
    	Result resultsDate = new Result();
    	Integer count =0;
    	ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(getKyzjExpertCount, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) 
		{
			count = responseEntity.getBody();
		}
		resultsDate.setData(count);
		JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		return ob.toString();
    }

    /**
	  * 删除专家
	 */
    @ApiOperation(value = "根据ID删除科研专家信息", notes = "根据ID删除科研专家信息")
	@RequestMapping(value = "/KyzjExpert-api/delete/{id}", method = RequestMethod.GET)
	public String deleteExpert(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	RestMessage resultsDate = new RestMessage();
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(DEL_EXPERT_LOGIC_URL + id, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
		int statusCode = responseEntity.getStatusCodeValue();
		int status = responseEntity.getBody();
		logger.info("============远程返回  statusCode " + statusCode + "  status=" + status);
		if (statusCode == 200) {
			resultsDate = new RestMessage(true,RequestProcessStatusEnum.OK.getStatusDesc());
		} else {
			resultsDate = new RestMessage(false, "删除失败");
		}
		response.setContentType("text/html;charset=UTF-8");
		JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		return ob.toString();
	}
    
    
    /**
	  *根据ID获取专家信息详情
	 */
    @ApiOperation(value = "根据ID获取科研专家信息详情", notes = "根据ID获取科研专家信息详情")
	@RequestMapping(value = "/KyzjExpert-api/get/{id}", method = RequestMethod.GET)
	public String getExpert(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Result resultsDate = new Result();
    	ResponseEntity<KyzjExpert> responseEntity = this.restTemplate.exchange(GET_EXPERT_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), KyzjExpert.class);
		int statusCode = responseEntity.getStatusCodeValue();
		KyzjExpert kyzjExpert = responseEntity.getBody();
		logger.info("============远程返回  statusCode " + statusCode);
		if (statusCode == 200) {
			resultsDate = new Result(true,RequestProcessStatusEnum.OK.getStatusDesc());
			resultsDate.setData(kyzjExpert);
		} else {
			resultsDate = new Result(false, "根据ID获取科研专家信息详情失败");
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		return result.toString();
	}

    @ApiOperation(value = "保存、修改科研专家信息", notes = "保存、修改科研专家信息")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "id", value = "主键", dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "yearStr", value = "年份", dataType = "string", paramType = "form",required=true),
        @ApiImplicitParam(name = "expertType", value = "科研专家类别", dataType = "string", paramType = "form",required=true),
        @ApiImplicitParam(name = "num", value = "数量", dataType = "Integer", paramType = "form")
    })
    @RequestMapping(method = RequestMethod.POST, value = "/KyzjExpert-api/save")
	public String saveExpert(@RequestBody  KyzjExpert kyzjExpert,HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Result resultsDate = new Result();
    	String id=kyzjExpert.getId();
    	JSONObject parma = JSONObject.parseObject(JSONObject.toJSONString(kyzjExpert));
		System.out.println(">>>>>>>>>> 参数: "+parma.toJSONString());
		SysUser sysUserInfo = this.getUserProfile();
		if (id!=null && !id.equals(""))
		{
			ResponseEntity<KyzjExpert> se = this.restTemplate.exchange(GET_EXPERT_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), KyzjExpert.class);
			KyzjExpert oldKyzjExpert = se.getBody();

			oldKyzjExpert.setYearStr(kyzjExpert.getYearStr());
			oldKyzjExpert.setNum(kyzjExpert.getNum());
			oldKyzjExpert.setExpertType(kyzjExpert.getExpertType());
			oldKyzjExpert.setUpdateUser(sysUserInfo.getUserId());
			oldKyzjExpert.setUpdateDate(new Date());
			ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(UPDATE_EXPERT_URL, HttpMethod.POST, new HttpEntity<KyzjExpert>(oldKyzjExpert, this.httpHeaders), Integer.class);
			int statusCode = responseEntity.getStatusCodeValue();
			Integer dataId = responseEntity.getBody();
			// 返回结果代码
			if (statusCode == 200) {
				resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
			} else {
				resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
			}
		} else 
		{
			kyzjExpert.setCreateDate(new Date());
			kyzjExpert.setDeleted(Constant.DEL_STATUS_NOT);
			String dateid = UUID.randomUUID().toString().replaceAll("-", "");
			kyzjExpert.setId(dateid);
			kyzjExpert.setCreateUser(sysUserInfo.getUserId());
			kyzjExpert.setUpdateDate(new Date());
			kyzjExpert.setUpdateUser("");
			kyzjExpert.setCreateUnitId(sysUserInfo.getUnitId());
			kyzjExpert.setCreateUnitName(sysUserInfo.getUserUnitName());

			ResponseEntity<String> responseEntity = this.restTemplate.exchange(ADD_EXPERT_URL, HttpMethod.POST, new HttpEntity<KyzjExpert>(kyzjExpert, this.httpHeaders), String.class);
			int statusCode = responseEntity.getStatusCodeValue();
			String dataId = responseEntity.getBody();
			// 返回结果代码
			if (statusCode == 200) {
				resultsDate = new Result(true,RequestProcessStatusEnum.OK.getStatusDesc());
			} else {
				resultsDate = new Result(false, "保存科研专家信息失败");
			}
		}

		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		return result.toString();
    }

}
