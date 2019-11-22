package com.pcitc.base.researchplatform;

import com.pcitc.base.common.RecordModel;

import java.io.Serializable;

/**
 * <p>科研平台-论文</p>
 * <p>Table: kypt_treatise - 科研平台-论文</p>
 * @author ty
 */
public class PlatformTreatiseModel extends RecordModel implements Serializable {
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
    private String baseId;
    /**
     * 论文题目
     */
    private String thesisTitle;
    /**
     * 论文级别
     */
    private String thesisLevel;
    /**
     * 期刊名称
     */
    private String journalTitle;
    /**
     * 作者
     */
    private String thesisAuthor;
    /**
     * 年度
     */
    private String thesisYear;

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

    public String getThesisTitle() {
        return thesisTitle;
    }

    public void setThesisTitle(String thesisTitle) {
        this.thesisTitle = thesisTitle;
    }

    public String getThesisLevel() {
        return thesisLevel;
    }

    public void setThesisLevel(String thesisLevel) {
        this.thesisLevel = thesisLevel;
    }

    public String getJournalTitle() {
        return journalTitle;
    }

    public void setJournalTitle(String journalTitle) {
        this.journalTitle = journalTitle;
    }

    public String getThesisAuthor() {
        return thesisAuthor;
    }

    public void setThesisAuthor(String thesisAuthor) {
        this.thesisAuthor = thesisAuthor;
    }

    public String getThesisYear() {
        return thesisYear;
    }

    public void setThesisYear(String thesisYear) {
        this.thesisYear = thesisYear;
    }
}
