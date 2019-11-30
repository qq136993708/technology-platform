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

    public BlocScientificPlan() {
    }

    public BlocScientificPlan(String id, String name, String publication,
                              Date annual, Date pubdate, String accessory, String reportType, String nameText) {
        this.id = id;
        this.name = name;
        this.publication = publication;
        this.annual = annual;
        this.pubdate = pubdate;
        this.accessory = accessory;
        this.reportType = reportType;
        this.nameText = nameText;
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
}
