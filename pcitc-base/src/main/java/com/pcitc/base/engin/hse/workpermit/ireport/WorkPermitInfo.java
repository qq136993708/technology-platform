package com.pcitc.base.engin.hse.workpermit.ireport;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.pcitc.base.engin.hse.workpermit.HseWorkPermitVo;

/**
 * hse_work_permit
 * @author 
 */
public class WorkPermitInfo  {
    /**
     * 作业许可证id
     */
    public String dataId;

    /**
     * 创建人
     */
    public String createUser;

    /**
     * 创建时间
     */
    public String createDate;

    /**
     * 修改人
     */
    public String updateUser;

    /**
     * 最后修改时间
     */
    public String updateDate;

    /**
     * 许可证状态：删除、停用、正常
     */
    public String status;

    /**
     * 审批状态  ：草稿 、待审批、已审批
     */
    public String auditStatus;

    /**
     * 公司代码
     */
    public String companyCode;

    /**
     * 所属项目
     */
    public String projectId;

    /**
     * 许可证编码
     */
    public String formCode;

    /**
     * 项目名称
     */
    public String projectName;

    /**
     * 项目编号
     */
    public String projectCode;

    /**
     * WBS ID
     */
    public String wbsId;

    /**
     * WBS名称
     */
    public String wbsName;

    /**
     * WBS编码
     */
    public String wbsCode;

    /**
     * 申请单位
     */
    public String applicationUnit;

    /**
     * 施工单位
     */
    public String constructionUnit;

    /**
     * 作业开始时间
     */
    public String workTimeStart;

    /**
     * 作业结束时间
     */
    public String workTimeEnd;

    /**
     * 作业区域
     */
    public String workArea;

    /**
     * 作业内容
     */
    public String workContent;

    /**
     * 作业范围
     */
    public String workScope;

    /**
     * 作业方式
     */
    public String workWay;

    /**
     * 坑基深度
     */
    public String pitBaseDepth;

    /**
     * 坑基面积
     */
    public String pitBaseArea;

    /**
     * 附件ids
     */
    public String attachIds;

    /**
     * 放射源活度（放射性）
     */
    public String radiationSources;

    /**
     * 探伤机类型（放射性）
     */
    public String defectoscopeType;

    /**
     * 原有介质（受限空间作业）
     */
    public String originalMedium;

    /**
     * 主要危害因素（受限空间作业）
     */
    public String hazardFactor;

    /**
     * 分包商
     */
    public String subContractor;

    /**
     * 许可证类型：1夜间加班作业许可证、2土方开挖作业许可证、3用火作业许可证、4射线探伤作业许可证、
     * 5高处作业许可给证、6受限空间作业许可证、7用电作业许可证、8吊装操作作业许可证
     */
    public String type;
    
   /* *//**
     * 安全措施列表
     *//*
    private List<HseSecurityMeasuresVo> securities;
    
    *//**
     * 作业人员列表
     *//*
    private List<HsePermitWorkerVo> workers;*/
    
    /**
     * 用于多表保存信息时，页面状态：1表示新增、2表示编辑
     */
    private String pageStatus;

    
    private static final String GET = "http://pcitc-zuul/epms-proxy/work-permit-provider/get/";

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAuditStatus() {
    	
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
   
        this.auditStatus = auditStatus;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getFormCode() {
        return formCode;
    }

    public void setFormCode(String formCode) {
        this.formCode = formCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getWbsId() {
        return wbsId;
    }

    public void setWbsId(String wbsId) {
        this.wbsId = wbsId;
    }

    public String getWbsName() {
        return wbsName;
    }

    public void setWbsName(String wbsName) {
        this.wbsName = wbsName;
    }

    public String getWbsCode() {
        return wbsCode;
    }

    public void setWbsCode(String wbsCode) {
        this.wbsCode = wbsCode;
    }

    public String getApplicationUnit() {
        return applicationUnit;
    }

    public void setApplicationUnit(String applicationUnit) {
        this.applicationUnit = applicationUnit;
    }

    public String getConstructionUnit() {
        return constructionUnit;
    }

    public void setConstructionUnit(String constructionUnit) {
        this.constructionUnit = constructionUnit;
    }

    public String getWorkTimeStart() {
        return workTimeStart;
    }

    public void setWorkTimeStart(String workTimeStart) {
        this.workTimeStart = workTimeStart;
    }

    public String getWorkTimeEnd() {
        return workTimeEnd;
    }

    public void setWorkTimeEnd(String workTimeEnd) {
        this.workTimeEnd = workTimeEnd;
    }

    public String getWorkArea() {
        return workArea;
    }

    public void setWorkArea(String workArea) {
        this.workArea = workArea;
    }

    public String getWorkContent() {
        return workContent;
    }

    public void setWorkContent(String workContent) {
        this.workContent = workContent;
    }

    public String getWorkScope() {
        return workScope;
    }

    public void setWorkScope(String workScope) {
        this.workScope = workScope;
    }

    public String getWorkWay() {
        return workWay;
    }

    public void setWorkWay(String workWay) {
        this.workWay = workWay;
    }

    public String getPitBaseDepth() {
        return pitBaseDepth;
    }

    public void setPitBaseDepth(String pitBaseDepth) {
        this.pitBaseDepth = pitBaseDepth;
    }

    public String getPitBaseArea() {
        return pitBaseArea;
    }

    public void setPitBaseArea(String pitBaseArea) {
        this.pitBaseArea = pitBaseArea;
    }

    public String getAttachIds() {
        return attachIds;
    }

    public void setAttachIds(String attachIds) {
        this.attachIds = attachIds;
    }

    public String getRadiationSources() {
        return radiationSources;
    }

    public void setRadiationSources(String radiationSources) {
        this.radiationSources = radiationSources;
    }

    public String getDefectoscopeType() {
        return defectoscopeType;
    }

    public void setDefectoscopeType(String defectoscopeType) {
        this.defectoscopeType = defectoscopeType;
    }

    public String getOriginalMedium() {
        return originalMedium;
    }

    public void setOriginalMedium(String originalMedium) {
        this.originalMedium = originalMedium;
    }

    public String getHazardFactor() {
        return hazardFactor;
    }

    public void setHazardFactor(String hazardFactor) {
        this.hazardFactor = hazardFactor;
    }

    public String getSubContractor() {
        return subContractor;
    }

    public void setSubContractor(String subContractor) {
        this.subContractor = subContractor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
/*    public List<HseSecurityMeasuresVo> getSecurities() {
		return securities;
	}

	public void setSecurities(List<HseSecurityMeasuresVo> securities) {
		this.securities = securities;
	}*/

	public String getPageStatus() {
		return pageStatus;
	}

	public void setPageStatus(String pageStatus) {
		this.pageStatus = pageStatus;
	}



/*	public List<HsePermitWorkerVo> getWorkers() {
		return workers;
	}

	public void setWorkers(List<HsePermitWorkerVo> workers) {
		this.workers = workers;
	}*/
	

	/**
	 * ireport获取数据
	 * @param orgs 前台页面传递参数
	 * @param request
	 * @param restTemplate
	 * @param httpHeaders
	 * @return
	 */
	public List getData(String[] orgs, HttpServletRequest request,RestTemplate restTemplate, HttpHeaders httpHeaders){
		List data  = new ArrayList();
		String dataId = orgs[0];
		
		//数据库查询结果  or 前台页面传递数据
		HseWorkPermitVo permit = restTemplate.exchange(GET + dataId, HttpMethod.POST, new HttpEntity<Object>(httpHeaders), HseWorkPermitVo.class).getBody();
	    try {
			if(permit != null) {
				WorkPermitInfo info = new WorkPermitInfo();
				info.setApplicationUnit(permit.getApplicationUnit());
				info.setConstructionUnit(permit.getConstructionUnit());
				info.setWorkContent(permit.getWorkContent());
				data.add(info);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		//处理无数据情况
		if(data.size() == 0){
			WorkPermitInfo info = new WorkPermitInfo();
			data.add(info);
		}
		return data;
	}


}