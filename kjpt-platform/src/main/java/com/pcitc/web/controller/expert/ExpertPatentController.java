package com.pcitc.web.controller.expert;

import java.io.InputStream;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.pcitc.base.expert.ZjkAchievement;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.common.RestBaseController;
import com.pcitc.web.utils.EquipmentUtils;
import com.pcitc.web.utils.ImportExcelUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.RequestProcessStatusEnum;
import com.pcitc.base.expert.ZjkPatent;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.DateUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;


@Api(value = "ExpertPatent-API",tags = {"专家库-专利接口"})
@RestController
public class ExpertPatentController extends BaseController {
	
	
	/**
	 * 获取专家专利（分页）
	 */
	private static final String PAGE_EXPERT_URL = "http://kjpt-zuul/stp-proxy/expert_patent/page";
	/**
	 * 根据ID获取对象信息
	 */
	public static final String ADD_EXPERT_URL = "http://kjpt-zuul/stp-proxy/expert_patent/add";

	/**
	 * 根据ID获取对象信息
	 */
	public static final String UPDATE_EXPERT_URL = "http://kjpt-zuul/stp-proxy/expert_patent/update";

	/**
	 * 根据ID逻辑删除
	 */
	//private static final String DEL_EXPERT_LOGIC_URL = "http://kjpt-zuul/stp-proxy/expert_patent/logic_delete/";
	
	
	/**
	 * 根据ID删除
	 */
	private static final String DEL_EXPERT_URL = "http://kjpt-zuul/stp-proxy/expert_patent/delete/";
	
	
	/**
	 * 根据ID获取对象信息
	 */
	public static final String GET_EXPERT_URL = "http://kjpt-zuul/stp-proxy/expert_patent/get/";

	private static final String queryNopage = "http://kjpt-zuul/stp-proxy/expertPatent-api/queryNoPage";

	/**
	 * 导入模板头部所占行数
	 */
	private static final Integer IMPORT_HEAD = 3;

	private static final String EXPERT_PATENT_EXCEL_INPUT = "http://kjpt-zuul/stp-proxy/expertPatent-api/excel_input";

	//用于缓存导入时的字典数据
	private Map<String,Map<String,String>> dictMap = new HashMap<>();

	private static final String ROOT_KJPT_ZLZL = "ROOT_KJPT_ZLZL";

	private static final String GET_UNIT_ID = "http://kjpt-zuul/system-proxy/unit-provider/unit/getUnitId_by_name";


	/**
	  * 获取专家专利（分页）
	 */
    @ApiOperation(value = "获取专家专利列表（分页）", notes = "获取专家专利列表（分页）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page",           value = "页码", dataType = "string", paramType = "query",required=true),
        @ApiImplicitParam(name = "limit",          value = "每页显示条数", dataType = "string", paramType = "query",required=true),
        @ApiImplicitParam(name = "expertId",           value = "专家ID", dataType = "string", paramType = "query")
        
    })
    @RequestMapping(value = "/expert-patent-api/page", method = RequestMethod.POST)
	public String getExpertPage(
			

			@RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer limit,
            @RequestParam(required = false) String expertId,
			HttpServletRequest request, HttpServletResponse response)throws Exception 
     {

    	LayuiTableParam param =new LayuiTableParam();
    	param.getParam().put("expertId", expertId);
    	param.setLimit(limit);
    	param.setPage(page);
    	//默认查询小于等于用户密级的
    	SysUser sysUserInfo = this.getUserProfile();
    	param.getParam().put("userSecretLevel",sysUserInfo.getSecretLevel() );
    	param.getParam().put("knowledgeScope", sysUserInfo.getUserName());
    	
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PAGE_EXPERT_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		String str=	JSON.toJSONString(layuiTableData);
		//JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		//String str=result.toString();
		logger.info("============获取专家专利列表（分页） " + str);
		return str;
	}

    
    /**
	  * 删除专家专利
	 */
    @ApiOperation(value = "根据ID删除专家专利信息", notes = "根据ID删除专家专利信息")
	@RequestMapping(value = "/expert-patent-api/delete/{id}", method = RequestMethod.GET)
	public JSONObject deleteExpert(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result resultsDate = new Result();
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(DEL_EXPERT_URL + id, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
		int statusCode = responseEntity.getStatusCodeValue();
		int status = responseEntity.getBody();
		logger.info("============远程返回  statusCode " + statusCode + "  status=" + status);
		if (statusCode == 200) {
			resultsDate = new Result(true,RequestProcessStatusEnum.OK.getStatusDesc());
		} else {
			resultsDate = new Result(false, "删除失败");
		}
		response.setContentType("text/html;charset=UTF-8");
		JSONObject ob = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		return ob;
	}
    
    
    /**
	  *根据ID获取专家专利信息详情
	 */
    @ApiOperation(value = "根据ID获取专家专利信息详情", notes = "根据ID获取专家专利信息详情")
	@RequestMapping(value = "/expert-patent-api/get/{id}", method = RequestMethod.GET)
	public JSONObject getExpert(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Result resultsDate = new Result();
    	ResponseEntity<ZjkPatent> responseEntity = this.restTemplate.exchange(GET_EXPERT_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), ZjkPatent.class);
		int statusCode = responseEntity.getStatusCodeValue();
		ZjkPatent ZjkPatent = responseEntity.getBody();
		logger.info("============远程返回  statusCode " + statusCode);
		if (statusCode == 200) {
			resultsDate = new Result(true,RequestProcessStatusEnum.OK.getStatusDesc());
			resultsDate.setData(ZjkPatent);
		} else {
			resultsDate = new Result(false, "根据ID获取专家专利信息详情失败");
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		return result.getJSONObject("data");
	}
    
    
    
    
    
    @ApiOperation(value = "保存、修改专家专利信息", notes = "保存、修改专家专利信息")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "id",          value = "主键",    dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "expertId",    value = "专家ID",  dataType = "string", paramType = "form",required=true),
        @ApiImplicitParam(name = "patentName", value = "专利名称", dataType = "string", paramType = "form",required=true),
        @ApiImplicitParam(name = "patentType",   value = "专利类型", dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "getPatentTime",   value = "获得专利时间", dataType = "string", paramType = "form",required=true),
        @ApiImplicitParam(name = "describe", value = "专利描述", dataType = "string", paramType = "form",required=true),
        @ApiImplicitParam(name = "seeUserIds",  value = "知悉范围-用户ID(多个逗号分)",  dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "seeUserNames",value = "知悉范围-用户名称(多个逗号分)",  dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "secretLevel", value = "信息密级",                 dataType = "string", paramType = "form",required=true)
        
    })
    @RequestMapping(method = RequestMethod.POST, value = "/expert-patent-api/save")
	public JSONObject saveExpertpatent(@RequestBody  ZjkPatent zjkPatent,HttpServletRequest request, HttpServletResponse response) throws Exception {

    	Result resultsDate = new Result();
    	String id=zjkPatent.getId();
    	JSONObject parma = JSONObject.parseObject(JSONObject.toJSONString(zjkPatent));
		System.out.println(">>>>>>>>>> 参数: "+parma.toJSONString());
		SysUser sysUserInfo = this.getUserProfile();
		if (id!=null && !id.equals("")) 
		{
			ResponseEntity<ZjkPatent> se = this.restTemplate.exchange(GET_EXPERT_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), ZjkPatent.class);
			ZjkPatent oldZjkPatent = se.getBody();
			Date date=DateUtil.strToDate(zjkPatent.getGetPatentTimeStr(), DateUtil.FMT_DD);
			oldZjkPatent.setPatentType(zjkPatent.getPatentType());
			oldZjkPatent.setPatentName(zjkPatent.getPatentName());
			oldZjkPatent.setSecretLevel(zjkPatent.getSecretLevel());
			
			
			
			//处理知悉范围
			String userName=sysUserInfo.getUserName();
			String knowledgeScope=zjkPatent.getKnowledgeScope();
			String knowledgePerson=zjkPatent.getKnowledgePerson();
			
			if(knowledgeScope==null || "".equals(knowledgeScope))
			{
				oldZjkPatent.setKnowledgeScope(userName);
				oldZjkPatent.setKnowledgePerson(sysUserInfo.getUserDisp()); 
			}else 
			{
				if(!knowledgeScope.contains(userName))
				{
					oldZjkPatent.setKnowledgeScope(knowledgeScope+","+userName);
					oldZjkPatent.setKnowledgePerson(knowledgePerson+","+sysUserInfo.getUserDisp());
				}else
				{
					oldZjkPatent.setKnowledgeScope(knowledgeScope);
					oldZjkPatent.setKnowledgePerson(knowledgePerson);
				}
				 
			}
			
			
			
			
			
			
			oldZjkPatent.setGetPatentTime(date);
			oldZjkPatent.setDescribe(zjkPatent.getDescribe());
			ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(UPDATE_EXPERT_URL, HttpMethod.POST, new HttpEntity<ZjkPatent>(oldZjkPatent, this.httpHeaders), Integer.class);
			int statusCode = responseEntity.getStatusCodeValue();
			Integer dataId = responseEntity.getBody();
			// 返回结果代码
			if (statusCode == 200)
			{
				resultsDate = new Result(true, RequestProcessStatusEnum.OK.getStatusDesc());
			} else 
			{
				resultsDate = new Result(false, RequestProcessStatusEnum.SERVER_BUSY.getStatusDesc());
			}
		} else 
		{
			Date date=DateUtil.strToDate(zjkPatent.getGetPatentTimeStr(), DateUtil.FMT_DD);
			zjkPatent.setCreateTime(new Date());
			zjkPatent.setDelStatus(Constant.DEL_STATUS_NOT);
			zjkPatent.setSourceType(Constant.SOURCE_TYPE_LOCATION);//数据来源（1本系统，2外系统）
			String dateid = UUID.randomUUID().toString().replaceAll("-", "");
			zjkPatent.setId(dateid);
			zjkPatent.setGetPatentTime(date);
			zjkPatent.setCreateUser(sysUserInfo.getUserId());
			
			
			//处理知悉范围
			String userName=sysUserInfo.getUserName();
			String knowledgeScope=zjkPatent.getKnowledgeScope();
			String knowledgePerson=zjkPatent.getKnowledgePerson();
			if(knowledgeScope==null || "".equals(knowledgeScope))
			{
				zjkPatent.setKnowledgeScope(userName);
				zjkPatent.setKnowledgePerson(sysUserInfo.getUserDisp()); 
			}else 
			{
				if(!knowledgeScope.contains(userName))
				{
					zjkPatent.setKnowledgeScope(knowledgeScope+","+userName);
					zjkPatent.setKnowledgePerson(knowledgePerson+","+sysUserInfo.getUserDisp());
				}else
				{
					zjkPatent.setKnowledgeScope(knowledgeScope);
					zjkPatent.setKnowledgePerson(knowledgePerson);
				}
			}
			
			
			
			
			
			
			ResponseEntity<String> responseEntity = this.restTemplate.exchange(ADD_EXPERT_URL, HttpMethod.POST, new HttpEntity<ZjkPatent>(zjkPatent, this.httpHeaders), String.class);
			int statusCode = responseEntity.getStatusCodeValue();
			String dataId = responseEntity.getBody();
			// 返回结果代码
			if (statusCode == 200) {
				resultsDate = new Result(true,RequestProcessStatusEnum.OK.getStatusDesc());
			} else {
				resultsDate = new Result(false, "保存专家信息失败");
			}
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		return result;
    }

	@ApiOperation(value="导出excel")
	@RequestMapping(value = "/expertPatent-api/export", method = RequestMethod.GET)
	@ResponseBody
	public void export(@RequestParam String expertId) throws Exception {
		Map<String, Object> condition = new HashMap<>(2);
		this.setParam(condition, "expertId", expertId);
		String[] headers = { "专利名称",  "专利类型",    "申请日期"  , "描述"};
		String[] cols =    {"patentName","patentTypeStr","getPatentTimeStr","describe"};
		this.setBaseParam(condition);
		//默认查询当前人所在机构下所有的科研平台
		//String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(sysUserInfo.getDataScopeUnitPath(), restTemplate, httpHeaders);
		//this.setParam(condition,"childUnitIds",childUnitIds);
		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(queryNopage, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), JSONArray.class);
		List list = JSONObject.parseArray(responseEntity.getBody().toJSONString(), ZjkPatent.class);
		String fileName = "专家信息管理专利表_"+ DateFormatUtils.format(new Date(), "ddhhmmss");
		this.exportExcel(headers,cols,fileName,list);
	}

	@ApiOperation(value = "根据模板导入专家专利信息（EXCEL）", notes = "根据模板导入专家专利信息（EXCEL）")
	@RequestMapping(value = "/expertPatent-api/input_excel", method = RequestMethod.POST)
	public Object newImportData(HttpServletRequest req, HttpServletResponse resp, MultipartFile file) throws Exception
	{
		Result resultsDate = new Result();
		String expertId = req.getQueryString();
		if(StringUtils.isBlank(expertId)){
			resultsDate.setSuccess(false);
			resultsDate.setMessage("未能获取专家id，请重试");
		}else{
			expertId = getExpertIdFromQueryString(expertId);
		}
		SysUser sysUserInfo = this.getUserProfile();

		if (file.isEmpty())
		{
			resultsDate.setSuccess(false);
			resultsDate.setMessage("上传异常，请重试");
		}else
		{
			InputStream in = file.getInputStream();
			List<List<Object>> listob = new ImportExcelUtil().getBankListByExcel(in, file.getOriginalFilename());
			System.out.println(">>>>>>行数:"+listob.size());
			List<ZjkPatent> list = new ArrayList<ZjkPatent>();
			resultsDate= getResult( listob );
			if(resultsDate.isSuccess()==true)
			{
				for (int i = IMPORT_HEAD; i < listob.size(); i++)
				{
					List<Object> lo = listob.get(i);
					if(lo.size()<4) break;
					Object col_1 = lo.get(1);   //专利名称
					Object col_2 = lo.get(2);   //专利类型
					Object col_3 = lo.get(3);   //申请日期
					Object col_4 = lo.get(4);   //专利描述

					if(checkIfBlank(col_1)&&checkIfBlank(col_2)&&checkIfBlank(col_3)&&checkIfBlank(col_4)) break;

					//将excel导入数据转换为SciencePlan对象
					ZjkPatent obj = new ZjkPatent();
					obj.setExpertId(expertId);
					obj.setPatentName(String.valueOf(col_1));
					obj.setPatentType(getValueFromDictMap(String.valueOf(col_2),ROOT_KJPT_ZLZL));
					//todo:不确认getPatentTime是否是申请日期
					Date getPatentTime = DateUtil.strToDate(String.valueOf(col_3),DateUtil.FMT_DD);
					obj.setGetPatentTime(getPatentTime);
					obj.setDescribe(String.valueOf(col_4));
					String dateid = UUID.randomUUID().toString().replaceAll("-", "");
					obj.setId(dateid);
					obj.setSecretLevel("0");
					obj.setDelStatus("0");
					obj.setCreateTime(new Date());
					list.add(obj);
				}
				ResponseEntity<Result> responseEntity =  this.restTemplate.exchange(EXPERT_PATENT_EXCEL_INPUT, HttpMethod.POST, new HttpEntity<Object>(list, this.httpHeaders), Result.class);
				int statusCode = responseEntity.getStatusCodeValue();
				// 返回结果代码
				if (statusCode == 200) {
					resultsDate.setSuccess(true);
					resultsDate.setCode("0");
				} else {
					Result back = responseEntity.getBody();
					resultsDate.setSuccess(false);
					resultsDate.setMessage(back.getMessage());
				}
			}

		}
		return resultsDate;
	}




	private Result getResult(List<List<Object>> listob )
	{
		Result resultsDate = new Result();
		resultsDate.setSuccess(true);
		StringBuffer sb=new StringBuffer();
		for (int i = IMPORT_HEAD; i < listob.size(); i++)
		{
			List<Object> lo = listob.get(i);
			if(lo.size()<4) break;
			Object col_1 = lo.get(1);   //专利名称
			Object col_2 = lo.get(2);   //专利类型
			Object col_3 = lo.get(3);   //申请日期
			Object col_4 = lo.get(4);   //专利描述
			if(checkIfBlank(col_1)&&checkIfBlank(col_2)&&checkIfBlank(col_3)&&checkIfBlank(col_4)) break;

			// 必填项和字典值校验
			if(checkIfBlank(col_1))
			{
				sb.append("第"+(i+2)+"行专利名称为空,");
				break;
			}
			if(checkIfBlank(col_2))
			{
				sb.append("第"+(i+2)+"行专利类型为空,");
				break;
			}else if(!checkIfReasonable(String.valueOf(col_2),ROOT_KJPT_ZLZL)){
				sb.append("第"+(i+2)+"行专利类型取值非法,请参考对应sheet页取值!");
				break;
			}
			if(checkIfBlank(col_3))
			{
				sb.append("第"+(i+2)+"行申请日期为空,");
				break;
			}

			if(checkIfBlank(col_4))
			{
				sb.append("第"+(i+2)+"行专利描述为空,");
				break;
			}

		}
		resultsDate.setMessage(sb.toString());
		if((sb.toString()).equals(""))
		{
			resultsDate.setSuccess(true);
		}else
		{
			resultsDate.setSuccess(false);
		}
		return resultsDate;
	}

	private Boolean checkIfBlank(Object o){
		if(o==null) return true;
		if(String.valueOf(o)=="") return true;
		return false;
	}

	private String getExpertIdFromQueryString(String queryString){

		String[] querys = queryString.split("=");
		return querys[1];
	}

	private Boolean checkIfReasonable(String content,String dictCode){
		//导入的数据确认用户只输入一个字典值20200605
		//针对模板中使用到的字典数据进行缓存
		Map<String,String> detailDicMap;
		if(dictMap.containsKey(dictCode)){
			detailDicMap = dictMap.get(dictCode);
			if(detailDicMap.containsKey(content)) return  true;
		}else{
			detailDicMap = new HashMap<>();
			dictMap.put(dictCode,detailDicMap);
		}

		List<SysDictionary> sysDictionaryList=    EquipmentUtils.getSysDictionaryListByParentCode(dictCode, restTemplate, httpHeaders);
		for(SysDictionary dictionary:sysDictionaryList){
			if(content.equals(dictionary.getName())) {
				Map<String,String> temp = dictMap.get(dictCode);
				temp.put(content,dictionary.getNumValue());
				dictMap.put(dictCode,temp);
				return true;
			}
		}
		return  false;
	}

	private String getValueFromDictMap(String name,String dictCode){
		if(StringUtils.isNotBlank(name)&&StringUtils.isNotBlank(dictCode)){
			Map<String,String> detail = dictMap.get(dictCode);
			return detail.get(name);
		}
		return "null";
	}


}
