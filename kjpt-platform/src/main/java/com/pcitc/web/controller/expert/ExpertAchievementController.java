package com.pcitc.web.controller.expert;

import java.io.InputStream;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.web.common.RestBaseController;
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
import com.pcitc.base.expert.ZjkAchievement;
import com.pcitc.base.expert.ZjkBase;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.utils.EquipmentUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;


@Api(value = "ExpertAchievement-API",tags = {"专家库-成果接口"})
@RestController
public class ExpertAchievementController extends BaseController {
	
	
	/**
	 * 获取专家成果（分页）
	 */
	private static final String PAGE_EXPERT_URL = "http://kjpt-zuul/stp-proxy/expert_achievement/page";
	/**
	 * 根据ID获取对象信息
	 */
	public static final String ADD_EXPERT_URL = "http://kjpt-zuul/stp-proxy/expert_achievement/add";

	/**
	 * 根据ID获取对象信息
	 */
	public static final String UPDATE_EXPERT_URL = "http://kjpt-zuul/stp-proxy/expert_achievement/update";

	/**
	 * 根据ID逻辑删除
	 */
	//private static final String DEL_EXPERT_LOGIC_URL = "http://kjpt-zuul/stp-proxy/expert_achievement/logic_delete/";
	
	
	/**
	 * 根据ID删除
	 */
	private static final String DEL_EXPERT_URL = "http://kjpt-zuul/stp-proxy/expert_achievement/delete/";
	
	
	/**
	 * 根据ID获取对象信息
	 */
	public static final String GET_EXPERT_URL = "http://kjpt-zuul/stp-proxy/expert_achievement/get/";



	/**
	 * 查询专家信息管理成果列表不分页
	 */
	private static final String queryNopage = "http://kjpt-zuul/stp-proxy/expertAchievement-api/queryNoPage";

	/**
	 * 导入模板头部所占行数
	 */
	private static final Integer IMPORT_HEAD = 3;

	private static final String EXPERT_ACHIEVEMENT_EXCEL_INPUT = "http://kjpt-zuul/stp-proxy/expertAchievement-api/excel_input";

	//用于缓存导入时的字典数据
	private Map<String,Map<String,String>> dictMap = new HashMap<>();

	private static final String  ROOT_KJPT_CGLB = "ROOT_KJPT_CGLB";

	private static final String GET_UNIT_ID = "http://kjpt-zuul/system-proxy/unit-provider/unit/getUnitId_by_name";
	
	
	/**
	  * 获取专家成果（分页）
	 */
    @ApiOperation(value = "获取专家成果列表（分页）", notes = "获取专家成果列表（分页）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page",           value = "页码", dataType = "string", paramType = "query",required=true),
        @ApiImplicitParam(name = "limit",          value = "每页显示条数", dataType = "string", paramType = "query",required=true),
        @ApiImplicitParam(name = "expertId",           value = "专家ID", dataType = "string", paramType = "query")
        
    })
    
    @RequestMapping(value = "/expert-achievement-api/page", method = RequestMethod.POST)
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
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		String str=result.toString();
		logger.info("========aaa====获取专家成果列表（分页） " + str);
		return str;
	}

    
    /**
	  * 删除专家成果
	 */
    @ApiOperation(value = "根据ID删除专家成果信息", notes = "根据ID删除专家成果信息")
	@RequestMapping(value = "/expert-achievement-api/delete/{id}", method = RequestMethod.GET)
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
	  *根据ID获取专家成果信息详情
	 */
    @ApiOperation(value = "根据ID获取专家成果信息详情", notes = "根据ID获取专家成果信息详情")
	@RequestMapping(value = "/expert-achievement-api/get/{id}", method = RequestMethod.GET)
	public JSONObject getExpert(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Result resultsDate = new Result();
    	ResponseEntity<ZjkAchievement> responseEntity = this.restTemplate.exchange(GET_EXPERT_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), ZjkAchievement.class);
		int statusCode = responseEntity.getStatusCodeValue();
		ZjkAchievement ZjkAchievement = responseEntity.getBody();
		logger.info("============远程返回  statusCode " + statusCode);
		if (statusCode == 200) {
			resultsDate = new Result(true,RequestProcessStatusEnum.OK.getStatusDesc());
			resultsDate.setData(ZjkAchievement);
		} else {
			resultsDate = new Result(false, "根据ID获取专家成果信息详情失败");
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		return result.getJSONObject("data");
	}
    
    
    
    
    
    
    
    @ApiOperation(value = "保存、修改专家成果信息", notes = "保存、修改专家成果信息")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "id",          value = "主键",    dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "expertId",    value = "专家ID",  dataType = "string", paramType = "form",required=true),
        @ApiImplicitParam(name = "achieveName", value = "成果名称", dataType = "string", paramType = "form",required=true),
        @ApiImplicitParam(name = "applyYear",   value = "申请年度", dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "applyUnit",   value = "申请单位", dataType = "string", paramType = "form",required=true),
        @ApiImplicitParam(name = "achieveType", value = "成果类别", dataType = "string", paramType = "form",required=true),
        @ApiImplicitParam(name = "seeUserIds",  value = "知悉范围-用户ID(多个逗号分)",  dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "seeUserNames",value = "知悉范围-用户名称(多个逗号分)",  dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "secretLevel", value = "信息密级",                 dataType = "string", paramType = "form",required=true)
        
    })
   
    @RequestMapping(method = RequestMethod.POST, value = "/expert-achievement-api/save")
	public JSONObject saveExpert(@RequestBody  ZjkAchievement zjkAchievement,HttpServletRequest request, HttpServletResponse response) throws Exception {

    	Result resultsDate = new Result();
    	String id=zjkAchievement.getId();
    	
    	JSONObject parma = JSONObject.parseObject(JSONObject.toJSONString(zjkAchievement));
		System.out.println(">>>>>>>>>> 参数: "+parma.toJSONString());
		SysUser sysUserInfo = this.getUserProfile();
		if (id!=null && !id.equals("")) 
		{
			ResponseEntity<ZjkAchievement> se = this.restTemplate.exchange(GET_EXPERT_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), ZjkAchievement.class);
			ZjkAchievement oldZjkAchievement = se.getBody();
			oldZjkAchievement.setAchieveName(zjkAchievement.getAchieveName());
			oldZjkAchievement.setAchieveType(zjkAchievement.getAchieveType());
			oldZjkAchievement.setSecretLevel(zjkAchievement.getSecretLevel());
			oldZjkAchievement.setApplyUnit(zjkAchievement.getApplyUnit());
			oldZjkAchievement.setApplyYear(zjkAchievement.getApplyYear());
			
			

			//处理知悉范围
			String userName=sysUserInfo.getUserName();
			String knowledgeScope=zjkAchievement.getKnowledgeScope();
			String knowledgePerson=zjkAchievement.getKnowledgePerson();
			if(knowledgeScope==null || "".equals(knowledgeScope))
			{
				oldZjkAchievement.setKnowledgeScope(userName);
				oldZjkAchievement.setKnowledgePerson(sysUserInfo.getUserDisp()); 
			}else 
			{
				if(!knowledgeScope.contains(userName))
				{
					oldZjkAchievement.setKnowledgeScope(knowledgeScope+","+userName);
					oldZjkAchievement.setKnowledgePerson(knowledgePerson+","+sysUserInfo.getUserDisp());
				}else
				{
					oldZjkAchievement.setKnowledgeScope(knowledgeScope);
					oldZjkAchievement.setKnowledgePerson(knowledgePerson);
				}
				 
			}
			
			
			
			
		
			ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(UPDATE_EXPERT_URL, HttpMethod.POST, new HttpEntity<ZjkAchievement>(oldZjkAchievement, this.httpHeaders), Integer.class);
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
			zjkAchievement.setCreateTime(new Date());
			zjkAchievement.setDelStatus(Constant.DEL_STATUS_NOT);
			zjkAchievement.setSourceType(Constant.SOURCE_TYPE_LOCATION);//数据来源（1本系统，2外系统）
			String dateid = UUID.randomUUID().toString().replaceAll("-", "");
			zjkAchievement.setId(dateid);
			zjkAchievement.setCreateUser(sysUserInfo.getUserId());
			
			//处理知悉范围
			String userName=sysUserInfo.getUserName();
			String knowledgeScope=zjkAchievement.getKnowledgeScope();
			String knowledgePerson=zjkAchievement.getKnowledgePerson();
			if(knowledgeScope==null || "".equals(knowledgeScope))
			{
				zjkAchievement.setKnowledgeScope(userName);
				zjkAchievement.setKnowledgePerson(sysUserInfo.getUserDisp()); 
			}else 
			{
				if(!knowledgeScope.contains(userName))
				{
					zjkAchievement.setKnowledgeScope(knowledgeScope+","+userName);
					zjkAchievement.setKnowledgePerson(knowledgePerson+","+sysUserInfo.getUserDisp());
				}else
				{
					zjkAchievement.setKnowledgeScope(knowledgeScope);
					zjkAchievement.setKnowledgePerson(knowledgePerson);
				}
			}
			
			
			ResponseEntity<String> responseEntity = this.restTemplate.exchange(ADD_EXPERT_URL, HttpMethod.POST, new HttpEntity<ZjkAchievement>(zjkAchievement, this.httpHeaders), String.class);
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
	@RequestMapping(value = "/expertAchievement-api/export", method = RequestMethod.GET)
	@ResponseBody
	public void export(@RequestParam String expertId) throws Exception {
		Map<String, Object> condition = new HashMap<>(2);
		this.setParam(condition, "expertId", expertId);
		String[] headers = { "成果名称",  "申请单位",    "成果类型"  , "申请年度"};
		String[] cols =    {"achieveName","applyUnitStr","achieveTypeStr","applyYear"};
		this.setBaseParam(condition);
		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(queryNopage, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), JSONArray.class);
		List list = JSONObject.parseArray(responseEntity.getBody().toJSONString(), ZjkAchievement.class);
		String fileName = "专家信息管理成果表_"+ DateFormatUtils.format(new Date(), "ddhhmmss");
		this.exportExcel(headers,cols,fileName,list);
	}

	/*@ApiOperation(value = "根据模板导入专家成果信息（EXCEL）", notes = "根据模板导入专家成果信息（EXCEL）")
	@RequestMapping(value = "/input_excel", method = RequestMethod.POST)
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
			List<ZjkAchievement> list = new ArrayList<ZjkAchievement>();
			resultsDate= getResult( listob );
			if(resultsDate.isSuccess()==true)
			{
				for (int i = IMPORT_HEAD; i < listob.size(); i++)
				{
					List<Object> lo = listob.get(i);

					Object col_1 = lo.get(1);   //成果信息
					Object col_2 = lo.get(2);   //申请单位
					Object col_3 = lo.get(3);   //成果类别
					Object col_4 = lo.get(4);   //申请年度

					if(checkIfBlank(col_1)&&checkIfBlank(col_2)&&checkIfBlank(col_3)&&checkIfBlank(col_4)) break;

					//将excel导入数据转换为SciencePlan对象
					ZjkAchievement obj = new ZjkAchievement();
					obj.setExpertId(expertId);
					obj.setAchieveName(String.valueOf(col_1));
					obj.setApplyUnitStr(String.valueOf(col_2));
					obj.setApplyUnit(restTemplate.exchange(GET_UNIT_ID, HttpMethod.POST, new HttpEntity<Object>(lo.get(4),this.httpHeaders), String.class).getBody());
                    obj.setAchieveType(getValueFromDictMap(String.valueOf(col_3),ROOT_KJPT_CGLB));
                    obj.setApplyYear(String.valueOf(col_4));
					String dateid = UUID.randomUUID().toString().replaceAll("-", "");
					obj.setId(dateid);
					obj.setSecretLevel("0");
					list.add(obj);
				}
				ResponseEntity<Result> responseEntity =  this.restTemplate.exchange(EXPERT_ACHIEVEMENT_EXCEL_INPUT, HttpMethod.POST, new HttpEntity<Object>(list, this.httpHeaders), Result.class);
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
			Object col_1 = lo.get(1);   //成果信息
			Object col_2 = lo.get(2);   //申请单位
			Object col_3 = lo.get(3);   //成果类别
			Object col_4 = lo.get(4);   //申请年度
			if(checkIfBlank(col_1)&&checkIfBlank(col_2)&&checkIfBlank(col_3)&&checkIfBlank(col_4)) break;

			// 必填项和字典值校验
			if(checkIfBlank(col_1))
			{
				sb.append("第"+(i+2)+"行成果信息为空,");
				break;
			}
			if(checkIfBlank(col_2))
			{
				sb.append("第"+(i+2)+"行申请单位为空,");
				break;
			}
			if(checkIfBlank(col_3))
			{
				sb.append("第"+(i+2)+"行成果类别为空,");
				break;
			}else if(!checkIfReasonable(String.valueOf(col_3),ROOT_KJPT_CGLB)){
				sb.append("第"+(i+2)+"行成果类别取值非法,请参考对应sheet页取值!");
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


*/
}
