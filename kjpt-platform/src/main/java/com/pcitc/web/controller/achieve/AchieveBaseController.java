package com.pcitc.web.controller.achieve;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.achieve.AchieveBase;
import com.pcitc.base.achieve.AchieveMaintain;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.Result;
import com.pcitc.base.system.SysPost;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.system.ireport.SysUserInfo;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.base.util.DateUtil;
import com.pcitc.web.common.RestBaseController;
import com.pcitc.web.utils.EquipmentUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * <p>成果转换</p>
 * <p>Table:  achieve_base 成果转换</p>
 * @author
 */
@Api(value = "researchPlatform-api", description = "成果转换接口")
@RestController
public class AchieveBaseController extends RestBaseController {
    /**
     * 根据ID获取对象信息
     */
    private static final String load = "http://kjpt-zuul/stp-proxy/achieve-api/load/";
    /**
     * 查询列表
     */
    private static final String query = "http://kjpt-zuul/stp-proxy/achieve-api/query";
    /**
     * 保存
     */
    private static final String save = "http://kjpt-zuul/stp-proxy/achieve-api/save";
    /**
     * 删除
     */
    private static final String delete = "http://kjpt-zuul/stp-proxy/achieve-api/delete/";
    /**
     * 删除
     */
    private static final String updatePublic = "http://kjpt-zuul/stp-proxy/achieve-api/updatePublic";

    /**
     * 流程
     */
    private static final String WORKFLOW_URL = "http://kjpt-zuul/stp-proxy/achieve-api/task/start_activity/";


    /**
     * 查询成果列表不分页
     */
    private static final String queryNoPage = "http://kjpt-zuul/stp-proxy/achieve-api/queryNoPage";
	

    @ApiOperation(value="读取")
    @RequestMapping(value = "/achieve-api/load/{id}", method = RequestMethod.GET)
    @ResponseBody
    public AchieveBase load(@PathVariable String id) {
        ResponseEntity<AchieveBase> responseEntity = this.restTemplate.exchange(load+id, HttpMethod.GET, new HttpEntity(this.httpHeaders), AchieveBase.class);
        return responseEntity.getBody();
    }




    @ApiOperation(value = "查询列表", notes = "查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "achieveName", value = "成果名称", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "finishUnitName", value = "成果持有单位", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "auditStatus", value = "申请状态", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "startDate", value = "录入开始时间", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "录入结束时间", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "secretLevel", value = "密级", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "isPublic", value = "是否公示", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "achieveTransType", value = "拟转化方式", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "affiliatedUnit", value = "成果所属单位", dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/achieve-api/query", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo query(
            @RequestParam(required = false,value = "pageNum") Integer pageNum,
            @RequestParam(required = false,value = "pageSize") Integer pageSize,
            @RequestParam(required = false,value = "achieveName") String achieveName,
            @RequestParam(required = false,value = "finishUnitName") String finishUnitName,
            @RequestParam(required = false,value = "auditStatus") String auditStatus,
            @RequestParam(required = false,value = "startDate") String startDate,
            @RequestParam(required = false,value = "endDate") String endDate,
            @RequestParam(required = false,value = "secretLevel") String secretLevel,
            @RequestParam(required = false,value = "isPublic") String isPublic,
            @RequestParam(required = false,value = "achieveTransType") String achieveTransType,
            @RequestParam(required = false,value = "affiliatedUnit") String affiliatedUnit
    ){
        Map<String, Object> condition = new HashMap<>(6);
        SysUser sysUserInfo = this.getUserProfile();
        if (pageNum == null) {
            this.setParam(condition, "pageNum", 1);
        }else {
            this.setParam(condition, "pageNum", pageNum);
        }
        if (pageSize == null) {
            this.setParam(condition, "pageSize", 10);
        }else {
            this.setParam(condition, "pageSize", pageSize);
        }
        if (!StringUtils.isEmpty(startDate)) {
            this.setParam(condition, "startDate",startDate);
        }
        if (!StringUtils.isEmpty(endDate)) {
            this.setParam(condition, "endDate", endDate);
        }

        if (!StringUtils.isEmpty(achieveName)) {
            this.setParam(condition, "achieveName", achieveName);
        }
        if (!StringUtils.isEmpty(finishUnitName)) {
            this.setParam(condition, "finishUnitName", finishUnitName);
        }
        if (!StringUtils.isEmpty(auditStatus)) {
            this.setParam(condition, "auditStatus", auditStatus);
        }


        if(secretLevel != null){
            this.setParam(condition,"secretLevel",secretLevel);
        }

        if(isPublic != null){
            this.setParam(condition,"isPublic",isPublic);
        }

        if(achieveTransType != null){
            this.setParam(condition,"achieveTransType",achieveTransType);
        }

        if(affiliatedUnit != null){
            this.setParam(condition,"affiliatedUnit",affiliatedUnit);
        }

        this.setBaseParam(condition);

        String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(sysUserInfo.getDataScopeUnitPath(), restTemplate, httpHeaders);
        this.setParam(condition,"childUnitIds",childUnitIds);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<PageInfo> responseEntity = this.restTemplate.exchange(query, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), PageInfo.class);
        return responseEntity.getBody();
    }


    @ApiOperation(value="导出excel")
    @RequestMapping(value = "/achieve-api/export", method = RequestMethod.GET)
    @ResponseBody
    public void export(
                @RequestParam(required = false,value = "achieveName") String achieveName,
                @RequestParam(required = false,value = "finishUnitName") String finishUnitName,
                @RequestParam(required = false,value = "auditStatus") String auditStatus,
                @RequestParam(required = false,value = "startDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate,
                @RequestParam(required = false,value = "endDate")  @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate,
                @RequestParam(required = false,value = "secretLevel") String secretLevel,
                @RequestParam(required = false,value = "isPublic") String isPublic
    ) throws Exception {
        Map<String, Object> condition = new HashMap<>(2);
            SysUser sysUserInfo = this.getUserProfile();
            if (!StringUtils.isEmpty(DateUtil.format(startDate,DateUtil.FMT_SS))) {
                this.setParam(condition, "startDate", DateUtil.format(startDate,DateUtil.FMT_SS));
            }
            if (!StringUtils.isEmpty(DateUtil.format(endDate,DateUtil.FMT_SS))) {
                this.setParam(condition, "endDate", DateUtil.format(endDate,DateUtil.FMT_SS));
            }

            if (!StringUtils.isEmpty(achieveName)) {
                this.setParam(condition, "achieveName", achieveName);
            }
            if (!StringUtils.isEmpty(finishUnitName)) {
                this.setParam(condition, "finishUnitName", finishUnitName);
            }
            if (!StringUtils.isEmpty(auditStatus)) {
                this.setParam(condition, "auditStatus", auditStatus);
            }


            if(secretLevel != null){
                this.setParam(condition,"secretLevel",secretLevel);
            }

            if(isPublic != null){
                this.setParam(condition,"isPublic",isPublic);
            }
            String childUnitIds= EquipmentUtils.getAllChildsByIUnitPath(sysUserInfo.getDataScopeUnitPath(), restTemplate, httpHeaders);
            this.setParam(condition,"childUnitIds",childUnitIds);
//            this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
//        String[] headers = { "科技成果名称",  "所属《核心成果目录》技术方向","成果持有单位", "成果所属单位（专业化公司/直属单位)", "项目来源及经费渠道", "成果完成时间", "拟转化方式",
//                "集团内部已开展的科技成果转化工作情况","科技成果简介","科技成果完成团队情况（按贡献度排序）", "科技成果完成单位意见","单位联系人和联系方式" };
//        String[] cols =    {"achieveName","techTypeText","finishUnitNameText","affiliatedUnitText","projectChannel","finishDate","achieveTransTypeText","workInfo","brief","teamPerson","unitAdvice","contactInfo"};
            this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        String[] headers = { "科技成果名称",  "所属《核心成果目录》技术方向","成果持有单位", "成果所属单位（专业化公司/直属单位)", "项目来源及经费渠道", "成果完成时间", "拟转化方式",
                "集团内部已开展的科技成果转化工作情况","科技成果简介", "科技成果完成单位意见","单位联系人和联系方式" };
        String[] cols =    {"achieveName","techTypeText","finishUnitNameText","affiliatedUnitText","projectChannel","finishDate","achieveTransTypeText","workInfo","brief","unitAdvice","contactInfo"};
        export(headers,cols,"成果申请表_",condition);
    }


    private void export(String[] headers,String[] cols,String fileName,Map condition) throws Exception {
        this.setBaseParam(condition);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<JSONArray> responseEntity = this.restTemplate.exchange(queryNoPage, HttpMethod.POST, new HttpEntity<Map>(condition, this.httpHeaders), JSONArray.class);
        List list = JSONObject.parseArray(responseEntity.getBody().toJSONString(), AchieveBase.class);
        fileName = fileName+ DateFormatUtils.format(new Date(), "ddhhmmss");
        this.exportExcel(headers,cols,fileName,list);
    }

    @ApiOperation(value="保存")
    @RequestMapping(value = "/achieve-api/save", method = RequestMethod.POST)
    @ResponseBody
    public AchieveBase save(@RequestBody AchieveBase ab){
        this.setBaseData(ab);
        checkAuditStatus(ab);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<AchieveBase> responseEntity = this.restTemplate.exchange(save, HttpMethod.POST, new HttpEntity<AchieveBase>(ab, this.httpHeaders), AchieveBase.class);
        return responseEntity.getBody();
    }

    private void checkAuditStatus(AchieveBase ab){
        //直接保存就不是补录
        ab.setIsSupplementaryRecord("02");
//        if("1".equals(ab.getAchieveType())){
        ab.setAuditStatus(Constant.NO_SUBMIT);
//        }else{
//            ab.setAuditStatus(Constant.SUBMIT);
//        }

        if(ab.getConversionAmount() != null){
           ab.setAuditStatus(Constant.COMPLETED);
        }

    }

    @ApiOperation(value="驳回")
    @RequestMapping(value = "/achieve-api/reject", method = RequestMethod.POST)
    @ResponseBody
    public AchieveBase reject(@RequestBody AchieveBase ab){
        this.setBaseData(ab);
        ab.setAuditStatus(Constant.NO_SUBMIT);
        ab.setConversionAmount(null);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<AchieveBase> responseEntity = this.restTemplate.exchange(save, HttpMethod.POST, new HttpEntity<AchieveBase>(ab, this.httpHeaders), AchieveBase.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value="补录")
    @RequestMapping(value = "/achieve-api/supplementaryRecord", method = RequestMethod.POST)
    @ResponseBody
    public AchieveBase supplementaryRecord(@RequestBody AchieveBase ab){
        this.setBaseData(ab);
        ab.setIsSupplementaryRecord("01");
        ab.setAuditStatus(Constant.COMPLETED);
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<AchieveBase> responseEntity = this.restTemplate.exchange(save, HttpMethod.POST, new HttpEntity<AchieveBase>(ab, this.httpHeaders), AchieveBase.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value="提交")
    @RequestMapping(value = "/achieve-api/submit", method = RequestMethod.POST)
    @ResponseBody
    public AchieveBase submit(@RequestBody AchieveBase ab){
        this.setBaseData(ab);
        ab.setAuditStatus("1");
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<AchieveBase> responseEntity = this.restTemplate.exchange(save, HttpMethod.POST, new HttpEntity<AchieveBase>(ab, this.httpHeaders), AchieveBase.class);
        return responseEntity.getBody();
    }

    @ApiOperation(value="删除")
    @RequestMapping(value = "/achieve-api/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Integer delete(@PathVariable String id) {
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(delete+id, HttpMethod.DELETE, new HttpEntity(this.httpHeaders), Integer.class);
        return responseEntity.getBody();
    }


    @ApiOperation(value="初始化")
    @RequestMapping(value = "/achieve-api/newInit", method = RequestMethod.GET)
    @ResponseBody
    public AchieveBase newInit() {
        AchieveBase a = new AchieveBase();
        a.setId(UUID.randomUUID().toString().replace("-",""));
        a.setApprovalDoc(UUID.randomUUID().toString().replace("-",""));
        a.setPublicDoc(UUID.randomUUID().toString().replace("-",""));
//        a.setIsPublic("0");
//        a.setCreateDate(new Date());
//        a.setCreator(this.getUserProfile().getUserName());
        return a;
    }
    @ApiOperation(value="已公示")
    @RequestMapping(value = "/achieve-api/public", method = RequestMethod.POST)
    @ResponseBody
    public AchieveBase handlerPublic(@RequestBody AchieveBase ab) {
        this.setBaseData(ab);
        ab.setIsPublic("2");
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        this.restTemplate.exchange(save, HttpMethod.POST, new HttpEntity<AchieveBase>(ab, this.httpHeaders),AchieveBase.class);
        return ab;
    }

    @ApiOperation(value="公示结束")
    @RequestMapping(value = "/achieve-api/publicEnd/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Integer publicEnd(@PathVariable String id) {
        Map param = new HashMap();
        param.put("id",id);
        param.put("status","3");
        this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<Integer> responseEntity = this.restTemplate.exchange(updatePublic, HttpMethod.POST, new HttpEntity<Map>(param, this.httpHeaders), Integer.class);
        return responseEntity.getBody();
    }



    
    @ApiOperation(value="核心成果转化流程")
    @RequestMapping(value = "/achieve-api/start_workflow",method = RequestMethod.POST)
	public Object start_workflow(HttpServletRequest request, HttpServletResponse response ) throws Exception
	{

		this.httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);//设置参数类型和编码
		String id = CommonUtil.getParameter(request, "id", "");
		String functionId = CommonUtil.getParameter(request, "functionId", "");
		String userIds = CommonUtil.getParameter(request, "userIds", "");
		System.out.println("============start_workflow userIds="+userIds+" functionId="+functionId+" id="+id);
		
		
		ResponseEntity<AchieveBase> responseEntity = this.restTemplate.exchange(load+id, HttpMethod.GET, new HttpEntity(this.httpHeaders), AchieveBase.class);
		AchieveBase achieveBase=  responseEntity.getBody();
        SysUser sysUserInfo = this.getUserProfile();
		String branchFlag="0";
		Map<String ,Object> paramMap = new HashMap<String ,Object>();
		paramMap.put("id", id);
		paramMap.put("functionId", functionId);
		paramMap.put("processInstanceName", "核心成果转化->"+achieveBase.getAchieveName());
		paramMap.put("authenticatedUserId", sysUserInfo.getUserId());
		paramMap.put("authenticatedUserName", sysUserInfo.getUserDisp());
		paramMap.put("auditor", userIds);
		paramMap.put("branchFlag", branchFlag);
		
		
		
		//指定岗位
		String specialAuditor1 = "";//xxx_核心成果转化-岗位代码
		StringBuffer specialAuditor1_sb = new StringBuffer();
		String unitIds=sysUserInfo.getUnitId();
		System.out.println("============unitIds ="+unitIds+" applyUnitName="+sysUserInfo.getUnitName());
		if(unitIds!=null && !unitIds.equals(""))
		{
			String arr[]=unitIds.split(",");
			if(arr!=null && arr.length>0)
			{
				for(int i=0;i<arr.length;i++)
				{
					 String unitId=arr[i];
					
					 List<SysPost> list = EquipmentUtils.getPostListByUnitId(unitId, restTemplate, httpHeaders);
					 if(list!=null && list.size()>0)
					 {
						    for(int j=0;j<list.size();j++)
							{
						    	SysPost sysPost=list.get(j);
						    	String postCode=sysPost.getPostCode();
						    	String postName=sysPost.getPostName();
						    	System.out.println("============ postName ="+ postName);
						    	if(postName.contains("核心成果转化"))
						    	{
						    		specialAuditor1_sb.append(postCode).append("-");
						    	}
						    	
							}
					 }
				}
				
			}
			specialAuditor1=specialAuditor1_sb.toString();
			if(!specialAuditor1.equals(""))
			{
				specialAuditor1= specialAuditor1.substring(0,specialAuditor1.length() - 1);
			}
			
		}
		paramMap.put("specialAuditor1", specialAuditor1);
		System.out.println("============specialAuditor1 ="+specialAuditor1);
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(paramMap,this.httpHeaders);
		//return null;
		Result rs = this.restTemplate.exchange(WORKFLOW_URL + id, HttpMethod.POST, httpEntity, Result.class).getBody();
		return rs;
	}
  	
  	
    
    
    
}
