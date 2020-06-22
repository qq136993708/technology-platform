package com.pcitc.web.controller.expert;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.*;
import com.pcitc.base.common.enums.RequestProcessStatusEnum;
import com.pcitc.base.expert.ZjkAcademicianBase;
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
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.ParameterizedTypeReference;
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


@Api(value = "Academician-API",tags = {"院士库-院士接口"})
@RestController
public class AcademicianController extends BaseController {
	
	
	/**
	 * 获取院士（分页）
	 */
	private static final String PAGE_ACADEMICIAN_URL = "http://kjpt-zuul/stp-proxy/academician/page";
	/**
	 * 根据ID获取对象信息
	 */
	public static final String ADD_ACADEMICIAN_URL = "http://kjpt-zuul/stp-proxy/academician/add";

	/**
	 * 根据ID获取对象信息
	 */
	public static final String UPDATE_ACADEMICIAN_URL = "http://kjpt-zuul/stp-proxy/academician/update";

	/**
	 * 根据ID逻辑删除
	 */
	private static final String DEL_ACADEMICIAN_LOGIC_URL = "http://kjpt-zuul/stp-proxy/academician/logic_delete/";
	
	
	/**
	 * 根据ID删除 
	 */
	private static final String DEL_ACADEMICIAN_URL = "http://kjpt-zuul/stp-proxy/academician/delete/";
	
	
	/**
	 * 根据ID获取对象信息
	 */
	public static final String GET_ACADEMICIAN_URL = "http://kjpt-zuul/stp-proxy/academician/get/";

	private static final String ACADEMICIAN_EXCEL_OUT = "http://kjpt-zuul/stp-proxy/academician/list";
	
	private static final String ACADEMICIAN_EXCEL_INPUT = "http://kjpt-zuul/stp-proxy/academician/excel_input";
	
	/**
	 * 查询院士个数
	 */
	private static final String getZjkAcademicianBaseCount = "http://kjpt-zuul/stp-proxy/academician/getZjkAcademicianBaseCount";

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
	  * 获取院士（分页）
	 */
	
	
    @ApiOperation(value = "院士管理（分页）", notes = "院士管理（分页）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码", dataType = "string", paramType = "query",required=true),
        @ApiImplicitParam(name = "limit", value = "每页显示条数", dataType = "string", paramType = "query",required=true),
        @ApiImplicitParam(name = "name", value = "院士名称", dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "ACADEMICIANTypes",                 value = "高层次人才类别(多个用逗号分开)",     dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "customQueryConditionStr",                   value = "条件",     dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "useStatus",                 value = "是否显示",     dataType = "string", paramType = "query")
        
         
    })
    @RequestMapping(value = "/academician-api/list", method = RequestMethod.POST)
	public String getAcademicianpage(
			
			@RequestParam(required = true) Integer page,
            @RequestParam(required = true) Integer limit,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String ACADEMICIANTypes,
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
    	param.getParam().put("ACADEMICIANTypes", ACADEMICIANTypes);
    	String userName=sysUserInfo.getUserName();
    	if(!userName.equals(Constant.USER_CONFIGADMIN))
    	{
    		//默认查询小于等于用户密级的院士
        	//param.getParam().put("userSecretLevel", sysUserInfo.getSecretLevel());
    	}
    	//param.getParam().put("knowledgeScope", sysUserInfo.getUserName());
    	
    	//默认查询当前人所在机构及子机构的所有院士
    	//String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(sysUserInfo.getDataScopeUnitPath(), restTemplate, httpHeaders);
    	//param.getParam().put("childUnitIds", childUnitIds);
    	
    	
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PAGE_ACADEMICIAN_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============获取院士列表（分页） " + result.toString());
		return result.toString();
	}
    
    
    
    @ApiOperation(value = "院士查询（分页）", notes = "院士查询（分页）")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page",           value = "页码", dataType = "string", paramType = "query",required=true),
        @ApiImplicitParam(name = "limit",          value = "每页显示条数", dataType = "string", paramType = "query",required=true),
        @ApiImplicitParam(name = "name",           value = "院士名称", dataType = "string", paramType = "query"),
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
        @ApiImplicitParam(name = "groupType",                 value = "院士分组",     dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "ACADEMICIANType",                 value = "高层次人才类别",     dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "ACADEMICIANTypes",                 value = "高层次人才类别(多个用逗号分开)",     dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "customQueryConditionStr",                   value = "条件",     dataType = "string", paramType = "query")
        
    })
    @RequestMapping(value = "/academician-api/query", method = RequestMethod.POST)
	public String queryAcademicianPage(
			
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
            @RequestParam(required = false) String ACADEMICIANType,
            @RequestParam(required = false) String ACADEMICIANTypes,
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
    	param.getParam().put("ACADEMICIANType", ACADEMICIANType);
    	param.getParam().put("ACADEMICIANTypes", ACADEMICIANTypes);
		 param.getParam().put("order", ",update_time DESC ");
    	param.getParam().put("groupType", groupType);
		SysUser sysUserInfo = this.getUserProfile();
    	//默认查询小于等于用户密级的院士
    	//param.getParam().put("userSecretLevel",sysUserInfo.getSecretLevel() );
    	//param.getParam().put("knowledgeScope", sysUserInfo.getUserName());
		System.out.println("======== customQueryConditionStr: "+customQueryConditionStr);
		LayuiTableData layuiTableData = new LayuiTableData();
		HttpEntity<LayuiTableParam> entity = new HttpEntity<LayuiTableParam>(param, httpHeaders);
		ResponseEntity<LayuiTableData> responseEntity = restTemplate.exchange(PAGE_ACADEMICIAN_URL, HttpMethod.POST, entity, LayuiTableData.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			layuiTableData = responseEntity.getBody();
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(layuiTableData));
		logger.info("============获取院士列表（分页） " + result.toString());
		return result.toString();
	}
    
    
    
    
    
   
    		
    
    @ApiOperation(value = "查询院士个数", notes = "查询院士个数")
    @RequestMapping(value = "/academician-api/getCount", method = RequestMethod.GET)
	public String getZjkAcademicianBaseCount() throws Exception {
    	
    	Result resultsDate = new Result();
    	Integer count =0;
    	ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(getZjkAcademicianBaseCount, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
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
	  * 删除院士
	 */
    @ApiOperation(value = "根据ID删除院士信息", notes = "根据ID删除院士信息")
	@RequestMapping(value = "/academician-api/delete/{id}", method = RequestMethod.GET)
	public String deleteAcademician(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	RestMessage resultsDate = new RestMessage();
		ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(DEL_ACADEMICIAN_LOGIC_URL + id, HttpMethod.POST, new HttpEntity<Object>(this.httpHeaders), Integer.class);
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
	  *根据ID获取院士信息详情
	 */
    @ApiOperation(value = "根据ID获取院士信息详情", notes = "根据ID获取院士信息详情")
	@RequestMapping(value = "/academician-api/get/{id}", method = RequestMethod.GET)
	public String getAcademician(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Result resultsDate = new Result();
    	ResponseEntity<ZjkAcademicianBase> responseEntity = this.restTemplate.exchange(GET_ACADEMICIAN_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), ZjkAcademicianBase.class);
		int statusCode = responseEntity.getStatusCodeValue();
		ZjkAcademicianBase ZjkAcademicianBase = responseEntity.getBody();
		Date datev=ZjkAcademicianBase.getBirthDate();
		if(datev!=null)
		{
			ZjkAcademicianBase.setBirthDateStr(DateUtil.dateToStr(ZjkAcademicianBase.getBirthDate() , DateUtil.FMT_DD));
		}
		logger.info("============远程返回  statusCode " + statusCode);
		if (statusCode == 200) {
			resultsDate = new Result(true,RequestProcessStatusEnum.OK.getStatusDesc());
			resultsDate.setData(ZjkAcademicianBase);
		} else {
			resultsDate = new Result(false, "根据ID获取院士信息详情失败");
		}
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		return result.toString();
	}
  
    
    

    
    @ApiOperation(value = "保存、修改院士信息", notes = "保存、修改院士信息")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "id", value = "主键", dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "sex", value = "性别", dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "name", value = "姓名", dataType = "string", paramType = "form",required=true),
        @ApiImplicitParam(name = "researchPersonType", value = "科技活动人员类别", dataType = "string", paramType = "form",required=true),
        @ApiImplicitParam(name = "age", value = "年龄", dataType = "string", paramType = "form",required=true),
        @ApiImplicitParam(name = "idCardNo", value = "身份证号码", dataType = "string", paramType = "form",required=true),
        @ApiImplicitParam(name = "education", value = "学历", dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "technicalField", value = "技术领域", dataType = "string", paramType = "form",required=true),
        @ApiImplicitParam(name = "belongUnit", value = "所在单位", dataType = "string", paramType = "form",required=true),
        @ApiImplicitParam(name = "title", value = "职称", dataType = "string", paramType = "form",required=true),
        @ApiImplicitParam(name = "post", value = "职务", dataType = "string", paramType = "form",required=true),
        @ApiImplicitParam(name = "workExperience", value = "工作经历", dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "contactWay", value = "联系方式", dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "email", value = "邮箱", dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "headPic", value = "头像", dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "brief", value = "人物简介", dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "achievement", value = "人物成就", dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "groupType",            value = "分组", dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "secretLevel",          value = "信息密级", dataType = "string", paramType = "form"),
    	@ApiImplicitParam(name = "birthDateStr",         value = "出生日期", dataType = "string", paramType = "form",required=true),
    	@ApiImplicitParam(name = "orders",               value = "排序号",    dataType = "string", paramType = "form"),
    	@ApiImplicitParam(name = "expertType",               value = "院士类型",    dataType = "string", paramType = "form")
        
    })
    @RequestMapping(method = RequestMethod.POST, value = "/academician-api/save")
	public String saveAcademician(@RequestBody  ZjkAcademicianBase ZjkAcademicianBase,HttpServletRequest request, HttpServletResponse response) throws Exception {

    	Result resultsDate = new Result();
    	String id=ZjkAcademicianBase.getId();
    	
    	JSONObject parma = JSONObject.parseObject(JSONObject.toJSONString(ZjkAcademicianBase));
		System.out.println(">>>>>>>>>> 参数: "+parma.toJSONString());
    
		SysUser sysUserInfo = this.getUserProfile();
		
		
		if (id!=null && !id.equals("")) 
		{
			ResponseEntity<ZjkAcademicianBase> se = this.restTemplate.exchange(GET_ACADEMICIAN_URL + id, HttpMethod.GET, new HttpEntity<Object>(this.httpHeaders), ZjkAcademicianBase.class);
			ZjkAcademicianBase oldZjkAcademicianBase = se.getBody();
			Date date=DateUtil.strToDate(ZjkAcademicianBase.getBirthDateStr(), DateUtil.FMT_DD);
			
			oldZjkAcademicianBase.setAge(ZjkAcademicianBase.getAge());
			oldZjkAcademicianBase.setExpertType(ZjkAcademicianBase.getExpertType());
			oldZjkAcademicianBase.setAchievement(ZjkAcademicianBase.getAchievement());
			oldZjkAcademicianBase.setResearchPersonType(ZjkAcademicianBase.getResearchPersonType());
			oldZjkAcademicianBase.setResearchWay(ZjkAcademicianBase.getResearchWay());
			oldZjkAcademicianBase.setBelongUnit(ZjkAcademicianBase.getBelongUnit());
			oldZjkAcademicianBase.setBrief(ZjkAcademicianBase.getBrief());
			oldZjkAcademicianBase.setContactWay(ZjkAcademicianBase.getContactWay());
			oldZjkAcademicianBase.setEducation(ZjkAcademicianBase.getEducation());
			oldZjkAcademicianBase.setEmail(ZjkAcademicianBase.getEmail());
			Integer orders=ZjkAcademicianBase.getOrders();
			oldZjkAcademicianBase.setOrders(orders);
			oldZjkAcademicianBase.setHeadPic(ZjkAcademicianBase.getHeadPic());
			oldZjkAcademicianBase.setNum(ZjkAcademicianBase.getNum());
			oldZjkAcademicianBase.setWorkExperience(ZjkAcademicianBase.getWorkExperience());
			oldZjkAcademicianBase.setTechnicalField(ZjkAcademicianBase.getTechnicalField());
			oldZjkAcademicianBase.setTechnicalFieldName(ZjkAcademicianBase.getTechnicalFieldName());
			oldZjkAcademicianBase.setTechnicalFieldIndex(ZjkAcademicianBase.getTechnicalFieldIndex());
			oldZjkAcademicianBase.setTitle(ZjkAcademicianBase.getTitle());
			oldZjkAcademicianBase.setSex(ZjkAcademicianBase.getSex());
			oldZjkAcademicianBase.setPost(ZjkAcademicianBase.getPost());
			oldZjkAcademicianBase.setPersonnelNum(ZjkAcademicianBase.getPersonnelNum());
			oldZjkAcademicianBase.setUseStatus(ZjkAcademicianBase.getUseStatus());
			oldZjkAcademicianBase.setGroupType(ZjkAcademicianBase.getGroupType());
			oldZjkAcademicianBase.setBirthDate(date);
			oldZjkAcademicianBase.setIdCardNo(ZjkAcademicianBase.getIdCardNo());
			oldZjkAcademicianBase.setGroupType(ZjkAcademicianBase.getGroupType());
			oldZjkAcademicianBase.setSecretLevel(ZjkAcademicianBase.getSecretLevel());
			oldZjkAcademicianBase.setName(ZjkAcademicianBase.getName());
			oldZjkAcademicianBase.setUpdateTime(new Date());
			
			SysUnit sysUnit=	EquipmentUtils.getUnitByUnitId(ZjkAcademicianBase.getBelongUnit(), restTemplate, httpHeaders);
			if(sysUnit!=null)
			{
				String belongUnitName=sysUnit.getUnitName();
				oldZjkAcademicianBase.setBelongUnitName(belongUnitName);
			}
			
				
			
			//处理知悉范围
			String userName=sysUserInfo.getUserName();
			String knowledgeScope=ZjkAcademicianBase.getKnowledgeScope();
			String knowledgePerson=ZjkAcademicianBase.getKnowledgePerson();
			
			if(knowledgeScope==null || "".equals(knowledgeScope))
			{
				oldZjkAcademicianBase.setKnowledgeScope(userName);
				oldZjkAcademicianBase.setKnowledgePerson(sysUserInfo.getUserDisp()); 
			}else 
			{
				if(!knowledgeScope.contains(userName))
				{
					oldZjkAcademicianBase.setKnowledgeScope(knowledgeScope+","+userName);
					oldZjkAcademicianBase.setKnowledgePerson(knowledgePerson+","+sysUserInfo.getUserDisp());
				}else
				{
					oldZjkAcademicianBase.setKnowledgeScope(knowledgeScope);
					oldZjkAcademicianBase.setKnowledgePerson(knowledgePerson);
				}

			}
			
			
			
			ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(UPDATE_ACADEMICIAN_URL, HttpMethod.POST, new HttpEntity<ZjkAcademicianBase>(oldZjkAcademicianBase, this.httpHeaders), Integer.class);
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
			ZjkAcademicianBase.setCreateTime(new Date());
			ZjkAcademicianBase.setDelStatus(Constant.DEL_STATUS_NOT);
			ZjkAcademicianBase.setSourceType(Constant.SOURCE_TYPE_LOCATION);//数据来源（1本系统，2外系统）
			String dateid = UUID.randomUUID().toString().replaceAll("-", "");
			ZjkAcademicianBase.setId(dateid);
			ZjkAcademicianBase.setCreateUser(sysUserInfo.getUserId());
			
			String num=ZjkAcademicianBase.getNum();
			if(num==null || "".equals(num))
			{
				String str=EquipmentUtils.genRandomNum()+"1";//9位=生成8位随机数+1
				ZjkAcademicianBase.setNum(str);//院士编号-通过身份证从人事库取,如果没有，生成8位随机数
			}else
			{
				ZjkAcademicianBase.setNum(num+"0");//9位=源系统8位+0，0代表外系统
			}
			String personnelNum=ZjkAcademicianBase.getPersonnelNum();
			if(personnelNum==null || "".equals(personnelNum))
			{
				ZjkAcademicianBase.setPersonnelNum(UUID.randomUUID().toString().replaceAll("-", ""));//人事系统编号--通过身份证从人事库取
			}
			
			ZjkAcademicianBase.setUpdateTime(new Date());
			ZjkAcademicianBase.setUpdateUser("");
			ZjkAcademicianBase.setAuditStatus(Constant.AUDIT_STATUS_DRAFT);
			ZjkAcademicianBase.setCreateUnitId(sysUserInfo.getUnitId());
			ZjkAcademicianBase.setCreateUnitName(sysUserInfo.getUserUnitName());
			
			Date birthDate=DateUtil.strToDate(ZjkAcademicianBase.getBirthDateStr(), DateUtil.FMT_DD);
			ZjkAcademicianBase.setBirthDate(birthDate);
			
			//处理知悉范围
			String userName=sysUserInfo.getUserName();
			String knowledgeScope=ZjkAcademicianBase.getKnowledgeScope();
			String knowledgePerson=ZjkAcademicianBase.getKnowledgePerson();
			if(knowledgeScope==null || "".equals(knowledgeScope))
			{
				ZjkAcademicianBase.setKnowledgeScope(userName);
				ZjkAcademicianBase.setKnowledgePerson(sysUserInfo.getUserDisp()); 
			}else 
			{
				if(!knowledgeScope.contains(userName))
				{
					ZjkAcademicianBase.setKnowledgeScope(knowledgeScope+","+userName);
					ZjkAcademicianBase.setKnowledgePerson(knowledgePerson+","+sysUserInfo.getUserDisp());
				}else
				{
					ZjkAcademicianBase.setKnowledgeScope(knowledgeScope);
					ZjkAcademicianBase.setKnowledgePerson(knowledgePerson);
				}
			}
			
			
			
			
		
			ResponseEntity<String> responseEntity = this.restTemplate.exchange(ADD_ACADEMICIAN_URL, HttpMethod.POST, new HttpEntity<ZjkAcademicianBase>(ZjkAcademicianBase, this.httpHeaders), String.class);
			int statusCode = responseEntity.getStatusCodeValue();
			String dataId = responseEntity.getBody();
			// 返回结果代码
			if (statusCode == 200) {
				resultsDate = new Result(true,RequestProcessStatusEnum.OK.getStatusDesc());
			} else {
				resultsDate = new Result(false, "保存院士信息失败");
			}
			
		}
    	
		
		
	
		JSONObject result = JSONObject.parseObject(JSONObject.toJSONString(resultsDate));
		return result.toString();
    }
    
    
    
    
    
    
    
    
  	   	
  	   	
  	   	
  	    @ApiOperation(value = "导出EXCEL-院士信息", notes = "导出EXCEL-院士信息")
  	    @ApiImplicitParams({
          @ApiImplicitParam(name = "name",           value = "院士名称", dataType = "string", paramType = "query"),
          @ApiImplicitParam(name = "belongUnit",     value = "所在单位", dataType = "string", paramType = "query"),
          @ApiImplicitParam(name = "useStatus",      value = "状态", dataType = "string", paramType = "query"),
          @ApiImplicitParam(name = "post",           value = "职务", dataType = "string", paramType = "query"),
          @ApiImplicitParam(name = "title",          value = "职称", dataType = "string", paramType = "query"),
          @ApiImplicitParam(name = "technicalField", value = "技术领域", dataType = "string", paramType = "query"),
          
      })
  		@RequestMapping(value = "/academician-api/exput_excel", method = RequestMethod.POST)
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
				@RequestParam(required = false) String ACADEMICIANType,
				@RequestParam(required = false) String ACADEMICIANTypes,
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
			paramMap.put("ACADEMICIANType", ACADEMICIANType);
			paramMap.put("ACADEMICIANTypes", ACADEMICIANTypes);
			paramMap.put("customQueryConditionStr", customQueryConditionStr);
			paramMap.put("groupType", groupType);
  	   		//System.out.println(">jsgztj_data_exput_excel>>>>>>>>>>>>>>>>>>>>参数      month = "+month);


			SysUser sysUserInfo = this.getUserProfile();
			//默认查询小于等于用户密级的院士
			//paramMap.put("userSecretLevel",sysUserInfo.getSecretLevel() );
			//paramMap.put("knowledgeScope", sysUserInfo.getUserName());
  	   		
  	   		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
  	   		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(ACADEMICIAN_EXCEL_OUT, HttpMethod.POST, httpEntity, JSONArray.class);
  	   		int statusCode = responseEntity.getStatusCodeValue();
  	   		List<ZjkAcademicianBase> list =new ArrayList();
  	   		JSONArray jSONArray=null;
  	   		if (statusCode == 200)
  	   		{
  	   			jSONArray = responseEntity.getBody();
  			 
  			
  	   			list = JSONObject.parseArray(jSONArray.toJSONString(), ZjkAcademicianBase.class);
  	   			if(list!=null &&  list.size()>0)
  	   			{
  	   				for(int i=0;i<list.size();i++)
  	   				{
  	   				   ZjkAcademicianBase ZjkAcademicianBase= list.get(i);
  	   				   Date date=ZjkAcademicianBase.getBirthDate();
  	   				   if(date!=null)
  	   				   {
  	   					 ZjkAcademicianBase.setBirthDateStr(DateUtil.dateToStr(date, DateUtil.FMT_DD));
  	   				   }else
  	   				   {
  	   					ZjkAcademicianBase.setBirthDateStr("");
  	   				   }
  	   				   ZjkAcademicianBase.setIdCardNo(ZjkAcademicianBase.getIdCardNo()+" ");
  	   				}
  	   			}
  	   		}
  	   		
  	   		    String[] headers = { "院士姓名",  "身份证号码",    "性别"  ,   "出生日期"  ,  "职称"  ,  "职务", "所在单位", "联系电话" , "院士编号" , "院士分类", "科技活动人员类别" , "研究方向" };
  	   		    String[] cols =    {"name",    "idCardNo",    "sexStr",  "birthDateStr",      "titleStr",   "postStr", "belongUnitStr" ,"contactWay" ,"num" ,"ACADEMICIANTypeStr","researchPersonTypeStr","researchWay"};
  	   		   
  	   	        // 文件名默认设置为当前时间：年月日时分秒
  	   	        String fileName = "院士表__"+DateFormatUtils.format(new Date(), "ddhhmmss");
  	   	        // 设置response头信息
  	   	        response.reset();
  	   	        response.setCharacterEncoding("UTF-8");
  		        response.setContentType("application/vnd.ms-excel");
  		        response.setHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO8859-1") + ".xls");
  	   	        try {
  	   		        OutputStream os = response.getOutputStream();
  	   		        PoiExcelExportUitl<ZjkAcademicianBase>  pee = new PoiExcelExportUitl<ZjkAcademicianBase>(fileName, headers, cols, list,os);
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
  	    
  	    
  	    
  	    
  	    @ApiOperation(value = "院士风采", notes = "院士风采")
		@RequestMapping(value = "/academician-api/listACADEMICIAN", method = RequestMethod.GET)
	   	public String jsgdztj_data_exput_excel(HttpServletRequest request, HttpServletResponse response) throws Exception
	   	{
	   		
	   		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);//设置参数类型和编码
	   		Map<String ,Object> paramMap = new HashMap<String ,Object>();
			paramMap.put("delStatus", Constant.DEL_STATUS_NOT);
	   		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
	   		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(ACADEMICIAN_EXCEL_OUT, HttpMethod.POST, httpEntity, JSONArray.class);
	   		int statusCode = responseEntity.getStatusCodeValue();
	   		List<ZjkAcademicianBase> list =new ArrayList();
	   		JSONArray jSONArray=null;
	   		if (statusCode == 200)
	   		{
	   			jSONArray = responseEntity.getBody();
	   			list = JSONObject.parseArray(jSONArray.toJSONString(), ZjkAcademicianBase.class);
	   			if(list!=null &&  list.size()>0)
	   			{
	   				for(int i=0;i<list.size();i++)
	   				{
	   				   ZjkAcademicianBase ZjkAcademicianBase= list.get(i);
	   				   Integer age=Integer.valueOf(DateUtil.dateToStr(new Date(), DateUtil.FMT_YYYY))-ZjkAcademicianBase.getAge();
	   				   ZjkAcademicianBase.setAge(age);
	   				   ZjkAcademicianBase.setIdCardNo(ZjkAcademicianBase.getIdCardNo()+" ");
	   				}
	   			}
	   		}
	   	    return jSONArray.toString();
	   	}
	    
	    
  	    
  	    
  	    
  	@ApiOperation(value = "根据模板导入院士信息（EXCEL）", notes = "根据模板导入院士信息（EXCEL）")
  	@RequestMapping(value = "/academician-api/input_excel", method = RequestMethod.POST)
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
  	  		List<ZjkAcademicianBase> list = new ArrayList<ZjkAcademicianBase>();
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
		  	          
		  	  			ZjkAcademicianBase obj = new ZjkAcademicianBase();
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
		  					obj.setNum(str);//院士编号-通过身份证从人事库取,如果没有，生成8位随机数
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
                        //TODO:是否在院士页面展示
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
		  	  		ResponseEntity<Result> responseEntity =  this.restTemplate.exchange(ACADEMICIAN_EXCEL_INPUT, HttpMethod.POST, new HttpEntity<Object>(list, this.httpHeaders), Result.class);
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
	            	sb.append("第"+(i+2)+"行院士姓名为空,");
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
	            	sb.append("第"+(i+2)+"行是否在院士风采页面展示为空,");
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
     @RequestMapping(value = "/academician-api/getCustomQueryConditionList/{tableName}", method = RequestMethod.GET)
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
