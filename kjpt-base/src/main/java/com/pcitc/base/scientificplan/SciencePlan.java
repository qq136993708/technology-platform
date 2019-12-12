package com.pcitc.base.scientificplan;

import com.pcitc.base.common.RecordModel;

import java.io.Serializable;
import java.util.Date;


/**
 * 科技规划实体
 */
public class SciencePlan extends RecordModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;//id
    private String name = "";  //名称
    private String authenticateUtil = "";//申报单位
    private String researchField = "";//研究领域
    private String professionalField;//专业领域 PROFESSIONAL_FIELD
    private String specialtyCategory = "";//专业类别
    private Date releaseTime = new Date();//发布时间
    private String authenticateUitlText; //文档
    private Date annual = new Date();//年度/月度
    private String accessory; //附件


    private String nameText;


    private String reportType; //上报类型


    private String researchFieldText = "";


    /**
     * 创建单位id
     */
    private String createUnitId="";

    /**
     *创建单位名称
     */
    private String createUnitName="";


    /**
     *技术领域名称
     */
    private  String  technicalFieldName="";

    /**
     *技术领域索引
     */
    private  String  technicalFieldIndex="";


    private  String secretLevelText="";


    public SciencePlan() {

    }

    public SciencePlan(String id, String name, String authenticateUtil, String researchField, String professionalField, String specialtyCategory, Date releaseTime, String authenticateUitlText, Date annual, String accessory, String nameText, String reportType, String researchFieldText, String createUnitId, String createUnitName,
                       String technicalFieldName, String technicalFieldIndex, String secretLevelText) {
        this.id = id;
        this.name = name;
        this.authenticateUtil = authenticateUtil;
        this.researchField = researchField;
        this.professionalField = professionalField;
        this.specialtyCategory = specialtyCategory;
        this.releaseTime = releaseTime;
        this.authenticateUitlText = authenticateUitlText;
        this.annual = annual;
        this.accessory = accessory;
        this.nameText = nameText;
        this.reportType = reportType;
        this.researchFieldText = researchFieldText;
        this.createUnitId = createUnitId;
        this.createUnitName = createUnitName;
        this.technicalFieldName = technicalFieldName;
        this.technicalFieldIndex = technicalFieldIndex;
        this.secretLevelText = secretLevelText;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthenticateUtil() {
        return authenticateUtil;
    }

    public void setAuthenticateUtil(String authenticateUtil) {
        this.authenticateUtil = authenticateUtil;
    }

    public String getResearchField() {
        return researchField;
    }

    public void setResearchField(String researchField) {
        this.researchField = researchField;
    }

    public String getSpecialtyCategory() {
        return specialtyCategory;
    }

    public void setSpecialtyCategory(String specialtyCategory) {
        this.specialtyCategory = specialtyCategory;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getProfessionalField() {
        return professionalField;
    }

    public void setProfessionalField(String professionalField) {
        this.professionalField = professionalField;
    }

    public String getAuthenticateUitlText() {
        return authenticateUitlText;
    }

    public void setAuthenticateUitlText(String authenticateUitlText) {
        this.authenticateUitlText = authenticateUitlText;
    }

    public Date getAnnual() {
        return annual;
    }

    public void setAnnual(Date annual) {
        this.annual = annual;
    }


    public String getAccessory() {
        return accessory;
    }

    public void setAccessory(String accessory) {
        this.accessory = accessory;
    }


    public String getNameText() {
        return nameText;
    }

    public void setNameText(String nameText) {
        this.nameText = nameText;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }


    public String getResearchFieldText() {
        return researchFieldText;
    }

    public void setResearchFieldText(String researchFieldText) {
        this.researchFieldText = researchFieldText;
    }


    public String getCreateUnitId() {
        return createUnitId;
    }

    public void setCreateUnitId(String createUnitId) {
        this.createUnitId = createUnitId;
    }


    public String getCreateUnitName() {
        return createUnitName;
    }

    public void setCreateUnitName(String createUnitName) {
        this.createUnitName = createUnitName;
    }


    public String getTechnicalFieldIndex() {
        return technicalFieldIndex;
    }

    public void setTechnicalFieldIndex(String technicalFieldIndex) {
        this.technicalFieldIndex = technicalFieldIndex;
    }

    public String getTechnicalFieldName() {
        return technicalFieldName;
    }

    public void setTechnicalFieldName(String technicalFieldName) {
        this.technicalFieldName = technicalFieldName;
    }


    public String getSecretLevelText() {
        return secretLevelText;
    }

    public void setSecretLevelText(String secretLevelText) {
        this.secretLevelText = secretLevelText;
    }
}


