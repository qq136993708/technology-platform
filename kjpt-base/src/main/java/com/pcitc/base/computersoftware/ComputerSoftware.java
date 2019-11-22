package com.pcitc.base.computersoftware;

import com.pcitc.base.common.RecordModel;

import java.io.Serializable;
import java.util.Date;

/**
 * computer_software
 *
 * @author
 */
public class ComputerSoftware extends RecordModel implements Serializable {


    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private String id;

    /**
     * 单位名称
     */
    private String unitName="";

    /**
     * 登记号
     */
    private String registerNumber="";

    /**
     * 软件名称
     */
    private String softwareName="";

    /**
     * 著作权人
     */
    private String copyrightOwner="";

    /**
     * 版本号
     */
    private String versionNumber="";

    /**
     * 登记日期
     */
    private Date recordDate=new Date();

    /**
     * 开发完成日期
     */
    private Date developFinishDate=new Date();

    /**
     * 软件简介
     */
    private String softwareIntro="";

    /**
     * 录入人
     */
    private String entryPeople="";

    /**
     * 录入时间
     */
    private Date entryTime=new Date();

    /**
     * 备注
     */
    private String notes="";

    /**
     * 附件上传
     */
    private String accessoryUpload="";


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public String getSoftwareName() {
        return softwareName;
    }

    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName;
    }

    public String getCopyrightOwner() {
        return copyrightOwner;
    }

    public void setCopyrightOwner(String copyrightOwner) {
        this.copyrightOwner = copyrightOwner;
    }

    public String getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public Date getDevelopFinishDate() {
        return developFinishDate;
    }

    public void setDevelopFinishDate(Date developFinishDate) {
        this.developFinishDate = developFinishDate;
    }

    public String getSoftwareIntro() {
        return softwareIntro;
    }

    public void setSoftwareIntro(String softwareIntro) {
        this.softwareIntro = softwareIntro;
    }

    public String getEntryPeople() {
        return entryPeople;
    }

    public void setEntryPeople(String entryPeople) {
        this.entryPeople = entryPeople;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getAccessoryUpload() {
        return accessoryUpload;
    }

    public void setAccessoryUpload(String accessoryUpload) {
        this.accessoryUpload = accessoryUpload;
    }

}