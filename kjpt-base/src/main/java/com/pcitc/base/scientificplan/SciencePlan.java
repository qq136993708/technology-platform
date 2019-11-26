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

    public SciencePlan() {

    }

    public SciencePlan(String id, String name, String authenticateUtil, String researchField,
                       String professionalField, String specialtyCategory, Date releaseTime) {
        this.id = id;
        this.name = name;
        this.authenticateUtil = authenticateUtil;
        this.researchField = researchField;
        this.professionalField = professionalField;
        this.specialtyCategory = specialtyCategory;
        this.releaseTime = releaseTime;
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
}


