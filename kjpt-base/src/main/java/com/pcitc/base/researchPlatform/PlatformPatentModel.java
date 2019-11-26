package com.pcitc.base.researchplatform;

import com.pcitc.base.common.RecordModel;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>科研平台-专利</p>
 * <p>Table: kypt_project - 科研平台-专利</p>
 * @author ty
 */
public class PlatformPatentModel extends RecordModel implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 数据主键
     */
    private String id;
    /**
     * 对应的平台ID
     */
    private String platformId;
    /**
     * 系统中的项目表的主键ID
     */
    private String baseId="";
    /**
     * 专利名称
     */
    private String patentName="";
    /**
     * 专利类型
     */
    private String patentType="";
    private String patentTypeText="";

    /**
     * 申请日期
     */
    private Date applicationDate=new Date();
    /**
     * 描述
     */
    private String remark="";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getBaseId() {
        return baseId;
    }

    public void setBaseId(String baseId) {
        this.baseId = baseId;
    }

    public String getPatentName() {
        return patentName;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName;
    }

    public String getPatentType() {
        return patentType;
    }

    public void setPatentType(String patentType) {
        this.patentType = patentType;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPatentTypeText() {
        return patentTypeText;
    }

    public void setPatentTypeText(String patentTypeText) {
        this.patentTypeText = patentTypeText;
    }
}
