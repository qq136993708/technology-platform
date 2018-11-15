package com.pcitc.base.engin.qualification.machine;

import java.io.Serializable;
import java.util.List;

import com.pcitc.base.util.SearchInfo;

/**
 * qlfc_machine_report
 * 
 * @author
 */
public class QlfcMachineReportVo extends SearchInfo implements Serializable {
	/**
	 * 机具报验id
	 */
	private String dataId;

	/**
	 * 创建人
	 */
	private String createUser;

	/**
	 * 创建时间
	 */
	private String createDate;

	/**
	 * 修改人
	 */
	private String updateUser;

	/**
	 * 最后修改人
	 */
	private String updateDate;

	/**
	 * 记录状态：删除、停用、正常
	 */
	private String status;

	/**
	 * 审批状态：草稿、待审批、已审批
	 */
	private String auditStatus;

	/**
	 * 公司代码
	 */
	private String companyCode;

	/**
	 * 所属项目
	 */
	private String projectId;

	/**
	 * (审批通过后生成）记录编码
	 */
	private String formCode;

	/**
	 * 项目名称
	 */
	private String projectName;

	/**
	 * 项目编号
	 */
	private String projectCode;

	/**
	 * 所属承包商
	 */
	private String contractor;

	/**
	 * 是否合格 0不合格 1合格
	 */
	private String isQualified;

	/**
	 * 申请日期
	 */
	private String applyDate;

	/**
	 * 申请机具报验数量
	 */
	private Integer applyToolsNum;

	/**
	 * 类型 ：1入场报验 2退场
	 */
	private String reportType;

	/**
	 * 单项工程ID
	 */
	private String wbsId;
	
	/**
	 * 单项工程名称
	 */
	private String wbsName;
	
	/**
	 * 单项工程编码
	 */
	private String wbsCode;

	/**
	 * 用于多表保存信息时，页面状态：1表示新增、2表示编辑
	 */
	private String pageStatus;

	/**
	 * 机具合格数量
	 */
	private Integer qualifiedNum;

	/**
	 * 机具不合格数量
	 */
	private Integer unqualifiedNum;

	/**
	 * 报验相关联的机具
	 */
	List<QlfcMachineToolsVo> tools;
	
	/**
	 * 报验记录
	 */
	List<QlfcMachineRecordVo> records;
	 

	private static final long serialVersionUID = 1L;

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

	public String getContractor() {
		return contractor;
	}

	public void setContractor(String contractor) {
		this.contractor = contractor;
	}

	public String getIsQualified() {
		return isQualified;
	}

	public void setIsQualified(String isQualified) {
		this.isQualified = isQualified;
	}

	public String getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

	public Integer getApplyToolsNum() {
		return applyToolsNum;
	}

	public void setApplyToolsNum(Integer applyToolsNum) {
		this.applyToolsNum = applyToolsNum;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public List<QlfcMachineToolsVo> getTools() {
		return tools;
	}

	public void setTools(List<QlfcMachineToolsVo> tools) {
		this.tools = tools;
	}

	public String getPageStatus() {
		return pageStatus;
	}

	public void setPageStatus(String pageStatus) {
		this.pageStatus = pageStatus;
	}

	public Integer getQualifiedNum() {
		return qualifiedNum;
	}

	public void setQualifiedNum(Integer qualifiedNum) {
		this.qualifiedNum = qualifiedNum;
	}

	public Integer getUnqualifiedNum() {
		return unqualifiedNum;
	}

	public void setUnqualifiedNum(Integer unqualifiedNum) {
		this.unqualifiedNum = unqualifiedNum;
	}

	public String getWbsId() {
		return wbsId;
	}

	public void setWbsId(String wbsId) {
		this.wbsId = wbsId;
	}

	public List<QlfcMachineRecordVo> getRecords() {
		return records;
	}

	public void setRecords(List<QlfcMachineRecordVo> records) {
		this.records = records;
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
	
	

}