package com.pcitc.base.groupinformation;

import com.pcitc.base.common.RecordModel;

import java.io.Serializable;
import java.util.Date;

public class BlocScientificPlan extends RecordModel implements Serializable {


    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 名称
     */
    private String name = "";

    /**
     * 发布处室
     */
    private String publication = "";
    /**
     * 发布人
     */
    private String publishUser = "";

    /**
     * 年度/月度
     */
    private Date annual = new Date();

    /**
     * 发布时间
     */
    private Date pubdate = new Date();

    /**
     * 附件
     */
    private String accessory = "";

    /**
     * 上报类型
     *
     * @return
     */
    private String reportType = "";


    private String nameText = "";

    /**
     * 创建单位id
     */
    private String createUnitId = "";

    /**
     * 创建单位名称
     */
    private String createUnitName = "";

    /**
     * 阅读范围
     */
    private String readRange = "";
    /**
     * 阅读范围
     */
    private String readRangeText = "";


    /**
     * 密级Text
     */
    private String secretLevelText = "";


    public BlocScientificPlan() {

    }

    public BlocScientificPlan(
            String id, String name, String publication,
            Date annual, Date pubdate, String accessory,
            String reportType, String nameText, String createUnitId,
            String createUnitName, String secretLevelText) {

        this.id = id;
        this.name = name;
        this.publication = publication;
        this.annual = annual;
        this.pubdate = pubdate;
        this.accessory = accessory;
        this.reportType = reportType;
        this.nameText = nameText;
        this.createUnitId = createUnitId;
        this.createUnitName = createUnitName;
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

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public Date getAnnual() {
        return annual;
    }

    public void setAnnual(Date annual) {
        this.annual = annual;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public String getAccessory() {
        return accessory;
    }

    public void setAccessory(String accessory) {
        this.accessory = accessory;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getNameText() {
        return nameText;
    }

    public void setNameText(String nameText) {
        this.nameText = nameText;
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

    public String getSecretLevelText() {
        return secretLevelText;
    }

    public void setSecretLevelText(String secretLevelText) {
        this.secretLevelText = secretLevelText;
    }

    public String getReadRange() {
        return readRange;
    }

    public void setReadRange(String readRange) {
        this.readRange = readRange;
    }

    public String getPublishUser() {
        return publishUser;
    }

    public void setPublishUser(String publishUser) {
        this.publishUser = publishUser;
    }

    public String getReadRangeText() {
        return readRangeText;
    }

    public void setReadRangeText(String readRangeText) {
        this.readRangeText = readRangeText;
    }
}
