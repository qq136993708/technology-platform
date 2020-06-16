package com.pcitc.web.controller.expert;

import java.io.InputStream;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcitc.base.expert.ZjkPatent;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.web.utils.EquipmentUtils;
import com.pcitc.web.utils.ImportExcelUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.RequestProcessStatusEnum;
import com.pcitc.base.expert.ZjkReward;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;


@Api(value = "ExpertReward-API",tags = {"专家库-奖励接口"})
@RestController
public class ExpertRewardController extends BaseController{
	
	
	/**
	 * 获取专家奖励（分页）
	 */
	private static final String PAGE_EXPERT_URL = "http://kjpt-zuul/stp-proxy/expert_reward/page";
	/**
	 * 根据ID获取对象信息
	 */
	public static final String ADD_EXPERT_URL = "http://kjpt-zuul/stp-proxy/expert_reward/add";

	/**
	 * 根据ID获取对象信息
	 */
	public static final String UPDATE_EXPERT_URL = "http://kjpt-zuul/stp-proxy/expert_reward/update";

	/**
	 * 根据ID逻辑删除
	 */
	//private static final String DEL_EXPERT_LOGIC_URL = "http://kjpt-zuul/stp-proxy/expert_reward/logic_delete/";
	
	
	/**
	 * 根据ID删除
	 */
	private static final String DEL_EXPERT_URL = "http://kjpt-zuul/stp-proxy/expert_reward/delete/";
	
	
	/**
	 * 根据ID获取对象信息
	 */
	public static final String GET_EXPERT_URL = "http://kjpt-zuul/stp-proxy/expert_reward/get/";

	private static final String queryNopage = "http://kjpt-zuul/stp-proxy/expertReward-api/queryNoPage";

	/**
	 * 导入模板头部所占行数
	 */
	private static final Integer IMPORT_HEAD = 3;

	private static final String EXPERT_REWARD_EXCEL_INPUT = "http://kjpt-zuul/stp-proxy/expertReward-api/excel_input";

	//用于缓存导入时的字典数据
	private Map<String,Map<String,String>> dictMap = new HashMap<>();

	private static final String ROOT_KJPT_ZLZL = "ROOT_KJPT_ZLZL";

	private static final String GET_UNIT_ID = "http://kjpt-zuul/system-proxy/unit-provider/unit/getUnitId_by_name";

	private static final String ROOT_KJPT_JLJB = "ROOT_KJPT_JLJB";




	/**
	  * 获取专家奖励（分页）
	 */
    @ApiOperation(value = "获取专家奖励列表（分页）", notes = "获取专家奖励列表（分页）") @ApiImplicitParams({
        @ApiImplicitParam(name = "page",           value = "页码", dataType = "string", paramType = "query",required=true),
        @ApiImplicitParam(name = "limit",          value = "每页显示条数", dataType = "string", paramType = "query",required=true),
        @ApiImplicitParam(name = "expertId",           value = "专家ID", dataType = "string", paramType = "query")
        
    })
    @RequestMapping(value = "/expert-reward-api/page", method = RequestMethod.POST)
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
		logger.info("=====ds=======获取专家奖励列表（分页） " + str);
		return str;
	}

    
    /**
	  * 删除专家奖励
	 */
    @ApiOperation(value = "根据ID删除专家奖励信息", notes = "根据ID删除专家奖励信息")
	@RequestMapping(value = "/expert-reward-api/delete/{id}", method = RequestMethod.GET)
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
	  *根据ID获取专家奖励信息详情
	 */
    @ApiOperation(value = "根据ID获取专家奖励信息详情", notes = "根据ID获取专家奖励信息详情")
	@RequestMapping(value = "/expert-reward-api/get/{id}", method = RequestMethod.GET)
	public JSONObject getExpert(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Result resultsDate = new Result();
    	ResponseEntity<ZjkReward> responseEntity = this.restTemplate.exchange(GET_EXPERT_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), ZjkReward.class);
		int statusCode = responseEntity.getStatusCodeValue();
		ZjkReward ZjkReward = responseEntity.getBody();
		logger.info("============远程返回  statusCode " + statusCode);
		if (statusCode == 200) {
			resultsDate = new Result(true,RequestProcessStatusEnum.OK.getStatusDesc());
			resultsDate.setData(ZjkReward);
		} else {
			resultsDate = new Result(false, "根据ID获取专家奖励信息详情失败");
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		return result.getJSONObject("data");
	}
    
    
    @ApiOperation(value = "保存、修改专家奖励信息", notes = "保存、修改专家奖励信息")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "id",              value = "主键",    dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "expertId",        value = "专家ID",  dataType = "string", paramType = "form",required=true),
        @ApiImplicitParam(name = "awardingTime",    value = "奖励时间", dataType = "string", paramType = "form",required=true),
        @ApiImplicitParam(name = "rewarkLevel",     value = "奖励级别", dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "awardingUnit",    value = "授奖单位", dataType = "string", paramType = "form",required=true),
        @ApiImplicitParam(name = "notes",           value = "奖励描述", dataType = "string", paramType = "form",required=true),
        @ApiImplicitParam(name = "seeUserIds",      value = "知悉范围-用户ID(多个逗号分)",  dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "seeUserNames",    value = "知悉范围-用户名称(多个逗号分)",  dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "secretLevel",     value = "信息密级",                 dataType = "string", paramType = "form",required=true)
    })
    @RequestMapping(method = RequestMethod.POST, value = "/expert-reward-api/save")
   	public JSONObject saveExpertpatent(@RequestBody  ZjkReward zjkReward,HttpServletRequest request, HttpServletResponse response) throws Exception {

       	Result resultsDate = new Result();
       	String id=zjkReward.getId();
       	
       	JSONObject parma = JSONObject.parseObject(JSONObject.toJSONString(zjkReward));
   		System.out.println(">>>>>>>>>> 参数: "+parma.toJSONString());
   		SysUser sysUserInfo = this.getUserProfile();
   		if (id!=null && !id.equals("")) 
   		{
   			ResponseEntity<ZjkReward> se = this.restTemplate.exchange(GET_EXPERT_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), ZjkReward.class);
   			ZjkReward oldZjkReward = se.getBody();
   			
   			Date date=DateUtil.strToDate(zjkReward.getAwardingTimeStr(), DateUtil.FMT_DD);
   			oldZjkReward.setAwardingTime(date);
   			oldZjkReward.setRewarkLevel(zjkReward.getRewarkLevel());
   			oldZjkReward.setAwardingUnit(zjkReward.getAwardingUnit());
   			oldZjkReward.setNotes(zjkReward.getNotes());
   			oldZjkReward.setSecretLevel(zjkReward.getSecretLevel());
   			
   			

			//处理知悉范围
			String userName=sysUserInfo.getUserName();
			String knowledgeScope=zjkReward.getKnowledgeScope();
			String knowledgePerson=zjkReward.getKnowledgePerson();
			if(knowledgeScope==null || "".equals(knowledgeScope))
			{
				oldZjkReward.setKnowledgeScope(userName);
				oldZjkReward.setKnowledgePerson(sysUserInfo.getUserDisp()); 
			}else 
			{
				if(!knowledgeScope.contains(userName))
				{
					oldZjkReward.setKnowledgeScope(knowledgeScope+","+userName);
					oldZjkReward.setKnowledgePerson(knowledgePerson+","+sysUserInfo.getUserDisp());
				}else
				{
					oldZjkReward.setKnowledgeScope(knowledgeScope);
					oldZjkReward.setKnowledgePerson(knowledgePerson);
				}
				 
			}
			
			
   			
   			
   			ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(UPDATE_EXPERT_URL, HttpMethod.POST, new HttpEntity<ZjkReward>(oldZjkReward, this.httpHeaders), Integer.class);
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
   			zjkReward.setCreateTime(new Date());
   			zjkReward.setDelStatus(Constant.DEL_STATUS_NOT);
   			zjkReward.setSourceType(Constant.SOURCE_TYPE_LOCATION);//数据来源（1本系统，2外系统）
   			String dateid = UUID.randomUUID().toString().replaceAll("-", "");
   			zjkReward.setId(dateid);
   			zjkReward.setCreateUser(sysUserInfo.getUserId());
   			
   			
   			

			//处理知悉范围
			String userName=sysUserInfo.getUserName();
			String knowledgeScope=zjkReward.getKnowledgeScope();
			String knowledgePerson=zjkReward.getKnowledgePerson();
			if(knowledgeScope==null || "".equals(knowledgeScope))
			{
				zjkReward.setKnowledgeScope(userName);
				zjkReward.setKnowledgePerson(sysUserInfo.getUserDisp()); 
			}else 
			{
				if(!knowledgeScope.contains(userName))
				{
					zjkReward.setKnowledgeScope(knowledgeScope+","+userName);
					zjkReward.setKnowledgePerson(knowledgePerson+","+sysUserInfo.getUserDisp());
				}else
				{
					zjkReward.setKnowledgeScope(knowledgeScope);
					zjkReward.setKnowledgePerson(knowledgePerson);
				}
			}
			
			
   			
   			Date date=DateUtil.strToDate(zjkReward.getAwardingTimeStr(), DateUtil.FMT_DD);
   			zjkReward.setAwardingTime(date);
   			ResponseEntity<String> responseEntity = this.restTemplate.exchange(ADD_EXPERT_URL, HttpMethod.POST, new HttpEntity<ZjkReward>(zjkReward, this.httpHeaders), String.class);
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
	@RequestMapping(value = "/expertReward-api/export", method = RequestMethod.GET)
	@ResponseBody
	public void export(@RequestParam String expertId) throws Exception {
		Map<String, Object> condition = new HashMap<>(2);
		this.setParam(condition, "expertId", expertId);
		String[] headers = { "奖励级别",  "奖励描述",    "授奖单位"  , "奖励时间"};
		String[] cols =    {"rewarkLevelStr","notes","awardingUnit","awardingTimeStr"};
		this.setBaseParam(condition);
		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(queryNopage, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), JSONArray.class);
		List list = JSONObject.parseArray(responseEntity.getBody().toJSONString(), ZjkReward.class);
		String fileName = "专家信息管理奖励表_"+ DateFormatUtils.format(new Date(), "ddhhmmss");
		this.exportExcel(headers,cols,fileName,list);
	}

	@ApiOperation(value = "根据模板导入专家奖励信息（EXCEL）", notes = "根据模板导入专家奖励信息（EXCEL）")
	@RequestMapping(value = "/expertReward-api/input_excel", method = RequestMethod.POST)
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
			List<ZjkReward> list = new ArrayList<ZjkReward>();
			resultsDate= getResult( listob );
			if(resultsDate.isSuccess()==true)
			{
				for (int i = IMPORT_HEAD; i < listob.size(); i++)
				{
					List<Object> lo = listob.get(i);

					if(lo.size()<4) break;
					Object col_1 = lo.get(1);   //奖励级别
					Object col_2 = lo.get(2);   //奖励描述
					Object col_3 = lo.get(3);   //获奖日期
					Object col_4 = lo.get(4);   //授奖单位

					if(checkIfBlank(col_1)&&checkIfBlank(col_2)&&checkIfBlank(col_3)&&checkIfBlank(col_4)) break;

					//将excel导入数据转换为SciencePlan对象
					ZjkReward obj = new ZjkReward();
					obj.setExpertId(expertId);
					obj.setRewarkLevel(getValueFromDictMap(String.valueOf(lo.get(1)),ROOT_KJPT_JLJB));
					obj.setRewarkLevelStr(String.valueOf(lo.get(1)));
					obj.setNotes(String.valueOf(lo.get(2)));
					Date awardTime = DateUtil.strToDate(String.valueOf(col_3),DateUtil.FMT_DD);
					obj.setAwardingTime(awardTime);
					obj.setAwardingTimeStr(String.valueOf(col_3));
					//obj.setAwardingUnit(restTemplate.exchange(GET_UNIT_ID, HttpMethod.POST, new HttpEntity<Object>(lo.get(4),this.httpHeaders), String.class).getBody());
                    obj.setAwardingUnit(String.valueOf(col_4));
					obj.setAwardingUnitStr(String.valueOf(col_4));

					String dateid = UUID.randomUUID().toString().replaceAll("-", "");
					obj.setId(dateid);
					obj.setSecretLevel("0");
					obj.setDelStatus("0");
					obj.setCreateTime(new Date());
					list.add(obj);
				}
				ResponseEntity<Result> responseEntity =  this.restTemplate.exchange(EXPERT_REWARD_EXCEL_INPUT, HttpMethod.POST, new HttpEntity<Object>(list, this.httpHeaders), Result.class);
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
			Object col_1 = lo.get(1);   //奖励级别
			Object col_2 = lo.get(2);   //奖励描述
			Object col_3 = lo.get(3);   //获奖日期
			Object col_4 = lo.get(4);   //授奖单位
			if(checkIfBlank(col_1)&&checkIfBlank(col_2)&&checkIfBlank(col_3)&&checkIfBlank(col_4)) break;

			// 必填项和字典值校验
			if(checkIfBlank(col_1))
			{
				sb.append("第"+(i+2)+"行奖励级别为空,");
				break;
			}else if(!checkIfReasonable(String.valueOf(col_1),ROOT_KJPT_JLJB)){
				sb.append("第"+(i+2)+"行奖励级别取值非法,请参考对应sheet页取值!");
				break;
			}
			if(checkIfBlank(col_2))
			{
				sb.append("第"+(i+2)+"行奖励描述为空,");
				break;
			}
			if(checkIfBlank(col_3))
			{
				sb.append("第"+(i+2)+"行授奖单位为空,");
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
