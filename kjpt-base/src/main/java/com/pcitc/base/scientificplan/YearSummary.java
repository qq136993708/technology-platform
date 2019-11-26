package com.pcitc.base.scientificplan;

import com.pcitc.base.common.RecordModel;

import java.io.Serializable;
import java.util.Date;

/**
 * 年度总结实体
 */
public class YearSummary extends RecordModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id; //id
    private String name = "";   //名称
    private String authenticateUtil = "";//申报单位
    private String researchField = "";//研究领域
    private Date releaseTime = new Date();//发布时间
    private  String authenticateUitlText; //文档


    public YearSummary() {
    }

    public YearSummary(String id, String name, String authenticateUtil, String researchField, Date releaseTime) {
        this.id = id;
        this.name = name;
        this.authenticateUtil = authenticateUtil;
        this.researchField = researchField;
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
}
