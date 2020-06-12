package com.pcitc.web.controller.expert;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.ExcelException;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.common.enums.RequestProcessStatusEnum;
import com.pcitc.base.expert.ZjkBase;
import com.pcitc.base.stp.techFamily.TechFamily;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.system.SysUnit;
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


@Api(value = "Expert-API",tags = {"专家库-专家接口"})
@RestController
public class ExpertController extends BaseController {
	
	
	/**
	 * 获取专家（分页）
	 */
	private static final String PAGE_EXPERT_URL = "http://kjpt-zuul/stp-proxy/expert/page";
	/**
	 * 根据ID获取对象信息
	 */
	public static final String ADD_EXPERT_URL = "http://kjpt-zuul/stp-proxy/expert/add";

	/**
	 * 根据ID获取对象信息
	 */
	public static final String UPDATE_EXPERT_URL = "http://kjpt-zuul/stp-proxy/expert/update";

	/**
	 * 根据ID逻辑删除
	 */
	private static final String DEL_EXPERT_LOGIC_URL = "http://kjpt-zuul/stp-proxy/expert/logic_delete/";
	
	
	/**
	 * 根据ID删除 
	 */
	private static final String DEL_EXPERT_URL = "http://kjpt-zuul/stp-proxy/expert/delete/";
	
	
	/**
	 * 根据ID获取对象信息
	 */
	public static final String GET_EXPERT_URL = "http://kjpt-zuul/stp-proxy/expert/get/";

	private static final String EXPERT_EXCEL_OUT = "http://kjpt-zuul/stp-proxy/expert/list";
	
	private static final String EXPERT_EXCEL_INPUT = "http://kjpt-zuul/stp-proxy/expert/excel_input";
	
	/**
	 * 查询专家个数
	 */
	private static final String getZjkBaseCount = "http://kjpt-zuul/stp-proxy/expert/getZjkBaseCount";

	private static final String GET_UNIT_ID = "http://kjpt-zuul/system-proxy/unit-provider/unit/getUnitId_by_name";

    /**
     * 根据技术领域名称获取技术领域详情
     */
    private static final String getTechFamilyByName   ="http://kjpt-zuul/stp-proxy/tech-family-provider/selectTechFamilyTypeListByName";

	private static final String  ROOT_KJPT_XB = "ROOT_KJPT_XB";
    private static final String  ROOT_KJPT_JSZC = "ROOT_KJPT_JSZC";
    private static final String  ROOT_KJPT_XL = "ROOT_KJPT_XL";
    private static final String  ROOT_KJPT_YYJSLYJSLJSL = "ROOT_KJPT_YYJSLYJSLJSL";
    private static final String  ROOT_KJPT_GCCRCLB = "ROOT_KJPT_GCCRCLB";
    //用于缓存导入时的字典数据
    private Map<String,Map<String,String>> dictMap = new HashMap<>();
    //用于缓存导入时的技术领域id
    private Map<String,TechFamily> techMap = new HashMap<>();
    /**
     * 导入模板头部所占行数
     */
    private static final Integer IMPORT_HEAD = 3;

    private static final String  YES =  "1";

    private static final String  NO =  "0";

	
	/**
	  * 获取专家（分页）
	 */
	
	
    @ApiOperation(value = "专家管理（分页）", notes = "专家管理（分页）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码", dataType = "string", paramType = "query",required=true),
        @ApiImplicitParam(name = "limit", value = "每页显示条数", dataType = "string", paramType = "query",required=true),
        @ApiImplicitParam(name = "name", value = "专家名称", dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "expertTypes",                 value = "高层次人才类别(多个用逗号分开)",     dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "customQueryConditionStr",                   value = "条件",     dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "useStatus",                 value = "是否显示",     dataType = "string", paramType = "query")
        
         
    })
    @RequestMapping(value = "/expert-api/list", method = RequestMethod.POST)
	public String getExpertPage(
			
			@RequestParam(required = true) Integer page,
            @RequestParam(required = true) Integer limit,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String expertTypes,
            @RequestParam(required = false) String customQueryConditionStr,
            @RequestParam(required = false) String useStatus,
			HttpServletRequest request, HttpServletResponse response)throws Exception 
     {
     	SysUser sysUserInfo = this.getUserProfile();
    	LayuiTableParam param =new LayuiTableParam();
    	param.getParam().put("name", name);
    	param.getParam().put("customQueryConditionStr", customQueryConditionStr);
    	param.getParam().put("delStatus", Constant.DEL_STATUS_NOT);
    	param.getParam().put("orderBySql", " ORDER BY orders asc ");
    	param.getParam().put("useStatus", useStatus);
    	param.setLimit(limit);
    	param.setPage(page);
    	param.getParam().put("expertTypes", expertTypes);
    	String userName=sysUserInfo.getUserName();
    	if(!userName.equals(Constant.USER_CONFIGADMIN))
    	{
    		//默认查询小于等于用户密级的专家
        	//param.getParam().put("userSecretLevel", sysUserInfo.getSecretLevel());
    	}
    	//param.getParam().put("knowledgeScope", sysUserInfo.getUserName());
    	
    	//默认查询当前人所在机构及子机构的所有专家
    	//String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(sysUserInfo.getDataScopeUnitPath(), restTemplate, httpHeaders);
    	//param.getParam().put("childUnitIds", childUnitIds);
    	
    	
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PAGE_EXPERT_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============获取专家列表（分页） " + result.toString());
		return result.toString();
	}
    
    
    
    @ApiOperation(value = "专家查询（分页）", notes = "专家查询（分页）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page",           value = "页码", dataType = "string", paramType = "query",required=true),
        @ApiImplicitParam(name = "limit",          value = "每页显示条数", dataType = "string", paramType = "query",required=true),
        @ApiImplicitParam(name = "name",           value = "专家名称", dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "belongUnit",     value = "所在单位", dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "useStatus",      value = "状态",    dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "post",           value = "职务",    dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "title",          value = "职称",    dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "technicalField", value = "技术领域",  dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "sex",            value = "性别",     dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "education",      value = "学历",     dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "technicalFieldIndex",       value = "技术索引",     dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "technicalFieldName",        value = "技术名称",     dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "secretLevel",               value = "信息密级",     dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "groupType",                 value = "专家分组",     dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "expertType",                 value = "高层次人才类别",     dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "expertTypes",                 value = "高层次人才类别(多个用逗号分开)",     dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "customQueryConditionStr",                   value = "条件",     dataType = "string", paramType = "query")
        
    })
    @RequestMapping(value = "/expert-api/query", method = RequestMethod.POST)
	public String queryExpertPage(
			
			@RequestParam(required = true) Integer page,
            @RequestParam(required = true) Integer limit,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String belongUnit,
            @RequestParam(required = false) String useStatus,
            @RequestParam(required = false) String post,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String technicalField,
            @RequestParam(required = false) String sex,
            @RequestParam(required = false) String education,
            @RequestParam(required = false) String technicalFieldIndex,
            @RequestParam(required = false) String technicalFieldName,
            @RequestParam(required = false) String secretLevel,
            @RequestParam(required = false) String groupType,
            @RequestParam(required = false) String expertType,
            @RequestParam(required = false) String expertTypes,
            @RequestParam(required = false) String customQueryConditionStr,
			HttpServletRequest request, HttpServletResponse response)throws Exception 
     {

    	LayuiTableParam param =new LayuiTableParam();
    	param.getParam().put("name", name);
    	param.getParam().put("delStatus", Constant.DEL_STATUS_NOT);
    	param.setLimit(limit);
    	param.setPage(page);
    	param.getParam().put("customQueryConditionStr", customQueryConditionStr);
    	param.getParam().put("belongUnit", belongUnit);
    	param.getParam().put("useStatus", useStatus);
    	param.getParam().put("post", post);
    	param.getParam().put("title", title);
    	param.getParam().put("technicalField", technicalField);
    	param.getParam().put("sex", sex);
    	param.getParam().put("education", education);
    	param.getParam().put("secretLevel", secretLevel);
    	param.getParam().put("expertType", expertType);
    	param.getParam().put("expertTypes", expertTypes);
		 param.getParam().put("order", ",update_time DESC ");
    	param.getParam().put("groupType", groupType);
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
		logger.info("============获取专家列表（分页） " + result.toString());
		return result.toString();
	}
    
    
    
    
    
   
    		
    
    @ApiOperation(value = "查询专家个数", notes = "查询专家个数")
    @RequestMapping(value = "/expert-api/getCount", method = RequestMethod.GET)
	public String getZjkBaseCount() throws Exception {
    	
    	Result resultsDate = new Result();
    	Integer count =0;
    	ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(getZjkBaseCount, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
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
    @ApiOperation(value = "根据ID删除专家信息", notes = "根据ID删除专家信息")
	@RequestMapping(value = "/expert-api/delete/{id}", method = RequestMethod.GET)
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
    @ApiOperation(value = "根据ID获取专家信息详情", notes = "根据ID获取专家信息详情")
	@RequestMapping(value = "/expert-api/get/{id}", method = RequestMethod.GET)
	public String getExpert(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Result resultsDate = new Result();
    	ResponseEntity<ZjkBase> responseEntity = this.restTemplate.exchange(GET_EXPERT_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), ZjkBase.class);
		int statusCode = responseEntity.getStatusCodeValue();
		ZjkBase zjkBase = responseEntity.getBody();
		Date datev=zjkBase.getBirthDate();
		if(datev!=null)
		{
			zjkBase.setBirthDateStr(DateUtil.dateToStr(zjkBase.getBirthDate() , DateUtil.FMT_DD));
		}
		logger.info("============远程返回  statusCode " + statusCode);
		if (statusCode == 200) {
			resultsDate = new Result(true,RequestProcessStatusEnum.OK.getStatusDesc());
			resultsDate.setData(zjkBase);
		} else {
			resultsDate = new Result(false, "根据ID获取专家信息详情失败");
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		return result.toString();
	}
  
    
    

    
    @ApiOperation(value = "保存、修改专家信息", notes = "保存、修改专家信息")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "id", value = "主键", dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "sex", value = "性别", dataType = "string", paramType = "form",required=true),
        @ApiImplicitParam(name = "name", value = "姓名", dataType = "string", paramType = "form",required=true),
        @ApiImplicitParam(name = "useStatus", value = "是否显示专家（1显示，0未显示）", dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "age", value = "年龄", dataType = "string", paramType = "form",required=true),
        @ApiImplicitParam(name = "idCardNo", value = "身份证号码", dataType = "string", paramType = "form",required=true),
        @ApiImplicitParam(name = "education", value = "学历", dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "technicalField", value = "技术领域", dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "belongUnit", value = "所在单位", dataType = "string", paramType = "form",required=true),
        @ApiImplicitParam(name = "title", value = "职称", dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "post", value = "职务", dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "workExperience", value = "工作经历", dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "contactWay", value = "联系方式", dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "email", value = "邮箱", dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "headPic", value = "头像", dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "brief", value = "人物简介", dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "achievement", value = "人物成就", dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "groupType",            value = "分组", dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "secretLevel",          value = "信息密级", dataType = "string", paramType = "form"),
    	@ApiImplicitParam(name = "birthDateStr",         value = "出生日期", dataType = "string", paramType = "form"),
    	@ApiImplicitParam(name = "orders",               value = "排序号",    dataType = "string", paramType = "form"),
    	@ApiImplicitParam(name = "expertType",               value = "专家类型",    dataType = "string", paramType = "form")
        
    })
    @RequestMapping(method = RequestMethod.POST, value = "/expert-api/save")
	public String saveExpert(@RequestBody  ZjkBase zjkBase,HttpServletRequest request, HttpServletResponse response) throws Exception {

    	Result resultsDate = new Result();
    	String id=zjkBase.getId();
    	
    	JSONObject parma = JSONObject.parseObject(JSONObject.toJSONString(zjkBase));
		System.out.println(">>>>>>>>>> 参数: "+parma.toJSONString());
    
		SysUser sysUserInfo = this.getUserProfile();
		
		
		if (id!=null && !id.equals("")) 
		{
			ResponseEntity<ZjkBase> se = this.restTemplate.exchange(GET_EXPERT_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), ZjkBase.class);
			ZjkBase oldZjkBase = se.getBody();
			Date date=DateUtil.strToDate(zjkBase.getBirthDateStr(), DateUtil.FMT_DD);
			
			oldZjkBase.setAge(zjkBase.getAge());
			oldZjkBase.setExpertType(zjkBase.getExpertType());
			oldZjkBase.setAchievement(zjkBase.getAchievement());
			oldZjkBase.setResearchPersonType(zjkBase.getResearchPersonType());
			oldZjkBase.setResearchWay(zjkBase.getResearchWay());
			oldZjkBase.setBelongUnit(zjkBase.getBelongUnit());
			oldZjkBase.setBrief(zjkBase.getBrief());
			oldZjkBase.setContactWay(zjkBase.getContactWay());
			oldZjkBase.setEducation(zjkBase.getEducation());
			oldZjkBase.setEmail(zjkBase.getEmail());
			Integer orders=zjkBase.getOrders();
			oldZjkBase.setOrders(orders);
			oldZjkBase.setHeadPic(zjkBase.getHeadPic());
			oldZjkBase.setNum(zjkBase.getNum());
			oldZjkBase.setWorkExperience(zjkBase.getWorkExperience());
			oldZjkBase.setTechnicalField(zjkBase.getTechnicalField());
			oldZjkBase.setTechnicalFieldName(zjkBase.getTechnicalFieldName());
			oldZjkBase.setTechnicalFieldIndex(zjkBase.getTechnicalFieldIndex());
			oldZjkBase.setTitle(zjkBase.getTitle());
			oldZjkBase.setSex(zjkBase.getSex());
			oldZjkBase.setPost(zjkBase.getPost());
			oldZjkBase.setPersonnelNum(zjkBase.getPersonnelNum());
			oldZjkBase.setUseStatus(zjkBase.getUseStatus());
			oldZjkBase.setGroupType(zjkBase.getGroupType());
			oldZjkBase.setBirthDate(date);
			oldZjkBase.setIdCardNo(zjkBase.getIdCardNo());
			oldZjkBase.setGroupType(zjkBase.getGroupType());
			oldZjkBase.setSecretLevel(zjkBase.getSecretLevel());
			oldZjkBase.setName(zjkBase.getName());
			oldZjkBase.setUpdateTime(new Date());
			
			SysUnit sysUnit=	EquipmentUtils.getUnitByUnitId(zjkBase.getBelongUnit(), restTemplate, httpHeaders);
			if(sysUnit!=null)
			{
				String belongUnitName=sysUnit.getUnitName();
				oldZjkBase.setBelongUnitName(belongUnitName);
			}
			
				
			
			//处理知悉范围
			String userName=sysUserInfo.getUserName();
			String knowledgeScope=zjkBase.getKnowledgeScope();
			String knowledgePerson=zjkBase.getKnowledgePerson();
			
			if(knowledgeScope==null || "".equals(knowledgeScope))
			{
				oldZjkBase.setKnowledgeScope(userName);
				oldZjkBase.setKnowledgePerson(sysUserInfo.getUserDisp()); 
			}else 
			{
				if(!knowledgeScope.contains(userName))
				{
					oldZjkBase.setKnowledgeScope(knowledgeScope+","+userName);
					oldZjkBase.setKnowledgePerson(knowledgePerson+","+sysUserInfo.getUserDisp());
				}else
				{
					oldZjkBase.setKnowledgeScope(knowledgeScope);
					oldZjkBase.setKnowledgePerson(knowledgePerson);
				}

			}
			
			
			
			ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(UPDATE_EXPERT_URL, HttpMethod.POST, new HttpEntity<ZjkBase>(oldZjkBase, this.httpHeaders), Integer.class);
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
			zjkBase.setCreateTime(new Date());
			zjkBase.setDelStatus(Constant.DEL_STATUS_NOT);
			zjkBase.setSourceType(Constant.SOURCE_TYPE_LOCATION);//数据来源（1本系统，2外系统）
			String dateid = UUID.randomUUID().toString().replaceAll("-", "");
			zjkBase.setId(dateid);
			zjkBase.setCreateUser(sysUserInfo.getUserId());
			
			String num=zjkBase.getNum();
			if(num==null || "".equals(num))
			{
				String str=EquipmentUtils.genRandomNum()+"1";//9位=生成8位随机数+1
				zjkBase.setNum(str);//专家编号-通过身份证从人事库取,如果没有，生成8位随机数
			}else
			{
				zjkBase.setNum(num+"0");//9位=源系统8位+0，0代表外系统
			}
			String personnelNum=zjkBase.getPersonnelNum();
			if(personnelNum==null || "".equals(personnelNum))
			{
				zjkBase.setPersonnelNum(UUID.randomUUID().toString().replaceAll("-", ""));//人事系统编号--通过身份证从人事库取
			}
			
			zjkBase.setUpdateTime(new Date());
			zjkBase.setUpdateUser("");
			zjkBase.setAuditStatus(Constant.AUDIT_STATUS_DRAFT);
			zjkBase.setCreateUnitId(sysUserInfo.getUnitId());
			zjkBase.setCreateUnitName(sysUserInfo.getUserUnitName());
			
			Date birthDate=DateUtil.strToDate(zjkBase.getBirthDateStr(), DateUtil.FMT_DD);
			zjkBase.setBirthDate(birthDate);
			
			//处理知悉范围
			String userName=sysUserInfo.getUserName();
			String knowledgeScope=zjkBase.getKnowledgeScope();
			String knowledgePerson=zjkBase.getKnowledgePerson();
			if(knowledgeScope==null || "".equals(knowledgeScope))
			{
				zjkBase.setKnowledgeScope(userName);
				zjkBase.setKnowledgePerson(sysUserInfo.getUserDisp()); 
			}else 
			{
				if(!knowledgeScope.contains(userName))
				{
					zjkBase.setKnowledgeScope(knowledgeScope+","+userName);
					zjkBase.setKnowledgePerson(knowledgePerson+","+sysUserInfo.getUserDisp());
				}else
				{
					zjkBase.setKnowledgeScope(knowledgeScope);
					zjkBase.setKnowledgePerson(knowledgePerson);
				}
			}
			
			
			
			
		
			ResponseEntity<String> responseEntity = this.restTemplate.exchange(ADD_EXPERT_URL, HttpMethod.POST, new HttpEntity<ZjkBase>(zjkBase, this.httpHeaders), String.class);
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
		return result.toString();
    }
    
    
    
    
    
    
    
    
  	   	
  	   	
  	   	
  	    @ApiOperation(value = "导出EXCEL-专家信息", notes = "导出EXCEL-专家信息")
  	    @ApiImplicitParams({
          @ApiImplicitParam(name = "name",           value = "专家名称", dataType = "string", paramType = "query"),
          @ApiImplicitParam(name = "belongUnit",     value = "所在单位", dataType = "string", paramType = "query"),
          @ApiImplicitParam(name = "useStatus",      value = "状态", dataType = "string", paramType = "query"),
          @ApiImplicitParam(name = "post",           value = "职务", dataType = "string", paramType = "query"),
          @ApiImplicitParam(name = "title",          value = "职称", dataType = "string", paramType = "query"),
          @ApiImplicitParam(name = "technicalField", value = "技术领域", dataType = "string", paramType = "query"),
          
      })
  		@RequestMapping(value = "/expert-api/exput_excel", method = RequestMethod.GET)
  	   	public String jsgztj_data_exput_excel(
				@RequestParam(required = false) String name,
				@RequestParam(required = false) String belongUnit,
				@RequestParam(required = false) String useStatus,
				@RequestParam(required = false) String post,
				@RequestParam(required = false) String title,
				@RequestParam(required = false) String technicalField,
				@RequestParam(required = false) String sex,
				@RequestParam(required = false) String education,
				@RequestParam(required = false) String technicalFieldIndex,
				@RequestParam(required = false) String technicalFieldName,
				@RequestParam(required = false) String secretLevel,
				@RequestParam(required = false) String groupType,
				@RequestParam(required = false) String expertType,
				@RequestParam(required = false) String expertTypes,
				@RequestParam(required = false) String customQueryConditionStr,
				HttpServletRequest request, HttpServletResponse response
		) throws Exception
  	   	{
  	   		
  	   		
  	   		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);//设置参数类型和编码
  	   		Map<String ,Object> paramMap = new HashMap<String ,Object>();

			paramMap.put("name", name);
			paramMap.put("delStatus", Constant.DEL_STATUS_NOT);

			paramMap.put("belongUnit", belongUnit);
			paramMap.put("useStatus", useStatus);
			paramMap.put("post", post);
			paramMap.put("title", title);
			paramMap.put("technicalField", technicalField);
			paramMap.put("sex", sex);
			paramMap.put("education", education);
			paramMap.put("secretLevel", secretLevel);
			paramMap.put("expertType", expertType);
			paramMap.put("expertTypes", expertTypes);
			paramMap.put("customQueryConditionStr", customQueryConditionStr);
			paramMap.put("groupType", groupType);
  	   		//System.out.println(">jsgztj_data_exput_excel>>>>>>>>>>>>>>>>>>>>参数      month = "+month);


			SysUser sysUserInfo = this.getUserProfile();
			//默认查询小于等于用户密级的专家
			//paramMap.put("userSecretLevel",sysUserInfo.getSecretLevel() );
			//paramMap.put("knowledgeScope", sysUserInfo.getUserName());
  	   		
  	   		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
  	   		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(EXPERT_EXCEL_OUT, HttpMethod.POST, httpEntity, JSONArray.class);
  	   		int statusCode = responseEntity.getStatusCodeValue();
  	   		List<ZjkBase> list =new ArrayList();
  	   		JSONArray jSONArray=null;
  	   		if (statusCode == 200)
  	   		{
  	   			jSONArray = responseEntity.getBody();
  	   			list = JSONObject.parseArray(jSONArray.toJSONString(), ZjkBase.class);
  	   			if(list!=null &&  list.size()>0)
  	   			{
  	   				for(int i=0;i<list.size();i++)
  	   				{
  	   				   ZjkBase zjkBase= list.get(i);
  	   				   Date date=zjkBase.getBirthDate();
  	   				   if(date!=null)
  	   				   {
  	   					 zjkBase.setBirthDateStr(DateUtil.dateToStr(date, DateUtil.FMT_DD));
  	   				   }else
  	   				   {
  	   					zjkBase.setBirthDateStr("");
  	   				   }
  	   				   zjkBase.setIdCardNo(zjkBase.getIdCardNo()+" ");
  	   				}
  	   			}
  	   		}
  	   		
  	   		    String[] headers = { "专家姓名",  "身份证号码",    "性别"  ,   "出生日期"  ,  "职称"  ,  "职务", "所在单位", "联系电话" , "专家编号" , "专家分类", "科技活动人员类别" , "研究方向" };
  	   		    String[] cols =    {"name",    "idCardNo",    "sexStr",  "birthDateStr",      "titleStr",   "postStr", "belongUnitStr" ,"contactWay" ,"num" ,"expertTypeStr","researchPersonTypeStr","researchWay"};
  	   		   
  	   	        // 文件名默认设置为当前时间：年月日时分秒
  	   	        String fileName = "专家表__"+DateFormatUtils.format(new Date(), "ddhhmmss");
  	   	        // 设置response头信息
  	   	        response.reset();
  	   	        response.setCharacterEncoding("UTF-8");
  		        response.setContentType("application/vnd.ms-excel");
  		        response.setHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO8859-1") + ".xls");
  	   	        try {
  	   		        OutputStream os = response.getOutputStream();
  	   		        PoiExcelExportUitl<ZjkBase>  pee = new PoiExcelExportUitl<ZjkBase>(fileName, headers, cols, list,os);
  	   		        pee.exportExcel();
  	   	            
  	   	        } catch (Exception e)
  	   	        {
  	   	            e.printStackTrace();
  	   	            // 如果是ExcelException,则直接抛出
  	   	            if (e instanceof ExcelException) 
  	   	            {
  	   	                throw (ExcelException) e;
  	   	            } else 
  	   	            {
  	   	                // 否则将其他异常包装成ExcelException再抛出
  	   	                throw new ExcelException("导出excel失败");
  	   	            }
  	   	        }
  	   		   return null;
  	   	}
  	    
  	    
  	    
  	    
  	    @ApiOperation(value = "专家风采", notes = "专家风采")
		@RequestMapping(value = "/expert-api/listexpert", method = RequestMethod.GET)
	   	public String jsgdztj_data_exput_excel(HttpServletRequest request, HttpServletResponse response) throws Exception
	   	{
	   		
	   		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);//设置参数类型和编码
	   		Map<String ,Object> paramMap = new HashMap<String ,Object>();
			paramMap.put("delStatus", Constant.DEL_STATUS_NOT);
	   		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
	   		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(EXPERT_EXCEL_OUT, HttpMethod.POST, httpEntity, JSONArray.class);
	   		int statusCode = responseEntity.getStatusCodeValue();
	   		List<ZjkBase> list =new ArrayList();
	   		JSONArray jSONArray=null;
	   		if (statusCode == 200)
	   		{
	   			jSONArray = responseEntity.getBody();
	   			list = JSONObject.parseArray(jSONArray.toJSONString(), ZjkBase.class);
	   			if(list!=null &&  list.size()>0)
	   			{
	   				for(int i=0;i<list.size();i++)
	   				{
	   				   ZjkBase zjkBase= list.get(i);
	   				   Integer age=Integer.valueOf(DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY))-zjkBase.getAge();
	   				   zjkBase.setAge(age);
	   				   zjkBase.setIdCardNo(zjkBase.getIdCardNo()+" ");
	   				}
	   			}
	   		}
	   	    return jSONArray.toString();
	   	}
	    
	    
  	    
  	    
  	    
  	@ApiOperation(value = "根据模板导入专家信息（EXCEL）", notes = "根据模板导入专家信息（EXCEL）")
  	@RequestMapping(value = "/expert-api/input_excel", method = RequestMethod.POST)
  	public Object newImportData(HttpServletRequest req, HttpServletResponse resp,MultipartFile file) throws Exception 
  	{
		SysUser sysUserInfo = this.getUserProfile();
  		Result resultsDate = new Result();
  		if (file.isEmpty())
  		{
  			resultsDate.setSuccess(false);
		    resultsDate.setMessage("上传异常，请重试");
  		}else
  		{
  			InputStream in = file.getInputStream();
  	  		List<List<Object>> listob = new ImportExcelUtil().getBankListByExcel(in, file.getOriginalFilename());
  	  	    System.out.println(">>>>>>行数:"+listob.size());
  	  		List<ZjkBase> list = new ArrayList<ZjkBase>();
  	  	    resultsDate= getResult( listob );
  	  	    if(resultsDate.isSuccess()==true)
  	  	    {
		  	  	    for (int i = IMPORT_HEAD; i < listob.size(); i++)
		  	  		{
		  	  			List<Object> lo = listob.get(i);

		  	  		    Object col_1 = lo.get(1);
		  	  	        Object col_2 = lo.get(2);
		  	            Object col_3 = lo.get(3);
		  	            Object col_4 = lo.get(4);
                        if(checkIfBlank(col_1)&&checkIfBlank(col_2)&&checkIfBlank(col_3)&&checkIfBlank(col_4)) break;
		  	            Object col_5 = lo.get(5);
		  	            Object col_6 = lo.get(6);
		  	            Object col_7 = lo.get(7);
		  	            Object col_8 = lo.get(8);
                        Object col_9 = lo.get(9);
                        Object col_10 = lo.get(10);
                        Object col_11 = lo.get(11);
                        Object col_12 = lo.get(12);
                        Object col_13 = lo.get(13);
                        Object col_14 = lo.get(14);
                        Object col_15 = lo.get(15);
                        Object col_16 = lo.get(16);

		  	            String aname=String.valueOf(lo.get(1));
		  	            String datestr=String.valueOf(lo.get(7));
		  	          
		  	  			ZjkBase obj = new ZjkBase();
		  	  			obj.setCreateTime(new Date());
		  	  			obj.setDelStatus(Constant.DEL_STATUS_NOT);
		  	  			obj.setSourceType(Constant.SOURCE_TYPE_OUTER);//数据来源（1本系统，2外系统）
		  	  			String dateid = UUID.randomUUID().toString().replaceAll("-", "");
		  	  			obj.setId(dateid);
		  	  			obj.setCreateUser(sysUserInfo.getUserId());
		  				
		  				String num=obj.getNum();
		  				if(num==null || "".equals(num))
		  				{
		  					String str=EquipmentUtils.genRandomNum()+"1";//9位=生成8位随机数+1
		  					obj.setNum(str);//专家编号-通过身份证从人事库取,如果没有，生成8位随机数
		  				}else
		  				{
		  					obj.setNum(num+"0");//9位=源系统8位+0，0代表外系统
		  				}
		  				String personnelNum=obj.getPersonnelNum();
		  				if(personnelNum==null || "".equals(personnelNum))
		  				{
		  					obj.setPersonnelNum(UUID.randomUUID().toString().replaceAll("-", ""));//人事系统编号--通过身份证从人事库取
		  				}
		  				
		  	  			obj.setName(aname);
		  	  			obj.setIdCardNo(String.valueOf(lo.get(2)));
                        obj.setPost(String.valueOf(lo.get(3)));
                        obj.setBelongUnit(String.valueOf(col_4));
                        obj.setSex(getValueFromDictMap(String.valueOf(col_5),ROOT_KJPT_XB));

                        String techName = String.valueOf(lo.get(6));
                        TechFamily techFamily = techMap.get(techName);
                        if(techFamily != null){
                            obj.setTechnicalField(techFamily.getTypeCode());
                            obj.setTechnicalFieldIndex(techFamily.getTypeIndex());
                            obj.setTechnicalFieldName(techFamily.getTypeName());

                        }
                        obj.setBirthDate(DateUtil.strToDate(datestr, DateUtil.FMT_DD));
                        obj.setWorkExperience(String.valueOf(lo.get(8)));
                        obj.setTitle(getValueFromDictMap(String.valueOf(lo.get(9)),ROOT_KJPT_JSZC));
                        //TODO:是否在专家页面展示
                        String state = String.valueOf(lo.get(10));
                        obj.setUseStatus("是".equals(state)?YES:NO);
                        obj.setEducation(getValueFromDictMap(String.valueOf(lo.get(11)),ROOT_KJPT_XL));
                        obj.setBrief(String.valueOf(lo.get(12)));
                        obj.setEmail(String.valueOf(lo.get(13)));
                        obj.setContactWay(String.valueOf(lo.get(14)));
                        obj.setAchievement(String.valueOf(lo.get(15)));
                        obj.setExpertType(getValueFromDictMap(String.valueOf(lo.get(16)),ROOT_KJPT_GCCRCLB));
						obj.setSecretLevel("0");
		  	  			obj.setBelongUnit(restTemplate.exchange(GET_UNIT_ID, HttpMethod.POST, new HttpEntity<Object>(lo.get(4),this.httpHeaders), String.class).getBody());
		  	  			list.add(obj);
		  	  		}
		  	  		ResponseEntity<Result> responseEntity =  this.restTemplate.exchange(EXPERT_EXCEL_INPUT, HttpMethod.POST, new HttpEntity<Object>(list, this.httpHeaders), Result.class);
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
  		dictMap.clear();
  		techMap.clear();
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
	  		    Object col_1 = lo.get(1);
	  	        Object col_2 = lo.get(2);
	            Object col_3 = lo.get(3);
	            Object col_4 = lo.get(4);
            if(checkIfBlank(col_1)&&checkIfBlank(col_2)&&checkIfBlank(col_3)&&checkIfBlank(col_4)) break;

                Object col_5 = lo.get(5);
	            Object col_6 = lo.get(6);
	            Object col_7 = lo.get(7);
	            Object col_8 = lo.get(8);
                Object col_9 = lo.get(9);
                Object col_10 = lo.get(10);
                Object col_11 = lo.get(11);
                Object col_12 = lo.get(12);
                Object col_13 = lo.get(13);
                Object col_14 = lo.get(14);
                Object col_15 = lo.get(15);
                Object col_16 = lo.get(16);

            // 必填项和字典值校验
	            if(checkIfBlank(col_1))
	            {
	            	sb.append("第"+(i+2)+"行专家姓名为空,");
	            	break;
	            }
	            if(checkIfBlank(col_4))
	            {
	            	sb.append("第"+(i+2)+"行所在单位为空,");
                    break;
	            }
	            if(checkIfBlank(col_5))
	            {
	            	sb.append("第"+(i+2)+"行性别为空,");
                    break;
	            }else if(!checkIfReasonable(String.valueOf(col_5),ROOT_KJPT_XB)){
                    sb.append("第"+(i+2)+"行性别取值非法,请参考对应sheet页取值!");
                    break;
                }
	            if(checkIfBlank(col_6))
	            {
	  				sb.append("第"+(i+2)+"行技术领域为空,");
                    break;
	            }else if(!checkTechIfExists(String.valueOf(col_6))){
                    sb.append("第"+(i+2)+"行技术领域取值非法,请参考对应sheet页取值!");
                    break;
                }

	            if(checkIfBlank(col_7))
	            {
	  				sb.append("第"+(i+2)+"行出生日期为空,");
                    break;
	            }
	            if(checkIfBlank(col_9))
	            {
	            	sb.append("第"+(i+2)+"行职称为空,");
                    break;
	            }else if(!checkIfReasonable(String.valueOf(col_9),ROOT_KJPT_JSZC)){
                    sb.append("第"+(i+2)+"行职称取值非法,请参考对应sheet页取值!");
                    break;
                }

	            if(checkIfBlank(col_10))
	            {
	            	sb.append("第"+(i+2)+"行是否在专家风采页面展示为空,");
                    break;
	            }
	            if(checkIfBlank(col_14))
	            {
	            	sb.append("第"+(i+2)+"行联系电话为空,");
                    break;
	            }

	            if(!checkIfBlank(col_11)){
                    if(!checkIfReasonable(String.valueOf(col_11),ROOT_KJPT_XL)){
                        sb.append("第"+(i+2)+"行学历取值非法,请参考对应sheet页取值!");
                        break;
                    }
                }

            if(!checkIfBlank(col_16)){
                if(!checkIfReasonable(String.valueOf(col_16),ROOT_KJPT_GCCRCLB)){
                    sb.append("第"+(i+2)+"行高层次人才类别取值非法,请参考对应sheet页取值!");
                    break;
                }
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

  	//查看技术领域是否存在
  	private Boolean checkTechIfExists(String name){

       // List<TechFamily> techFamily =  restTemplate.exchange(getTechFamilyByName, HttpMethod.POST, new HttpEntity<Object>(name,this.httpHeaders), List.class).getBody();
        ParameterizedTypeReference<List<TechFamily>> typeRef = new ParameterizedTypeReference<List<TechFamily>>() {

        };

        ResponseEntity<List<TechFamily>> responseEntity =  restTemplate.exchange(getTechFamilyByName, HttpMethod.POST, new HttpEntity<Object>(name,this.httpHeaders), typeRef);

        List<TechFamily> techFamily = responseEntity.getBody();

        if(techFamily.size()==1){
            techMap.put(name,techFamily.get(0));
            return true;
        }
        return false;
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

  	 @ApiOperation(value = "获得查询条件接口", notes = "获得查询条件接口")
     @RequestMapping(value = "/expert-api/getCustomQueryConditionList/{tableName}", method = RequestMethod.GET)
 	 public String getFamilyList(@PathVariable("tableName") String tableName,HttpServletRequest request, HttpServletResponse response)throws Exception
     {
     	    Result resultsDate = new Result();
     	    this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);//设置参数类型和编码
     	    JSONArray jSONArray= EquipmentUtils.getCustomQueryConditionList(restTemplate, httpHeaders, request, response, tableName);
   	   		if (jSONArray !=null)
   	   		{
   	   		    resultsDate.setData(jSONArray);
   	   		}
   	      	JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
   	   		return result.toString();
 	   		
 	}

    private Boolean checkIfBlank(Object o){
        if(o==null) return true;
        if(String.valueOf(o)=="") return true;
        return false;
    }

}
