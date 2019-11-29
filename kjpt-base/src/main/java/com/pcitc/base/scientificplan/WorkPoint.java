package com.pcitc.base.scientificplan;

import com.pcitc.base.common.RecordModel;

import java.io.Serializable;
import java.util.Date;

/**
 * 工作要点实体
 */
public class WorkPoint extends RecordModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;//id
    private String name = "";//名称
    private String authenticateUtil = "";//申报单位
    private String researchField = "";//研究领域
    private Date releaseTime = new Date();//发布时间
    private String authenticateUitlText; //文档
    private Date annual = new Date();//年度/月度

    private  String accessory; //附件


    private  String nameText;


    private  String reportType; //上报类型


    public WorkPoint() {

    }

    public WorkPoint(String id, String name, String authenticateUtil, String researchField, Date releaseTime, String authenticateUitlText, Date annual, String accessory, String nameText, String reportType) {
        this.id = id;
        this.name = name;
        this.authenticateUtil = authenticateUtil;
        this.researchField = researchField;
        this.releaseTime = releaseTime;
        this.authenticateUitlText = authenticateUitlText;
        this.annual = annual;
        this.accessory = accessory;
        this.nameText = nameText;
        this.reportType = reportType;
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

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
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
}
