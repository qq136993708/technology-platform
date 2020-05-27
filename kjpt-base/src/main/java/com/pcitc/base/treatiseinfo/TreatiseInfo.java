package com.pcitc.base.treatiseinfo;

import com.pcitc.base.common.RecordModel;

import java.util.Date;

public class TreatiseInfo extends RecordModel {
    /**
     * 主键
     */
    private String id;

    /**
     * 论文主题
     */
    private String theme;
    /**
     * 关键词
     */
    private String keyWord;
    /**
     * 篇名
     */
    private String title;
    /**
     * 作者
     */
    private String author;
    /**
     * 单位
     */
    private String unit;
    /**
     * 单位翻译
     */
    private String unitText;
    /**
     * 期刊名
     */
    private String journalName;
    /**
     * 摘要
     */
    private String summary;
    /**
     * 期刊等级
     */
    private String journalLevel;
    /**
     * 期刊等级字典翻译
     */
    private String journalLevelText;
    /**
     * 影响因子
     */
    private String influencingFactors;
    /**
     * 发表日期
     */
    private Date publishDate;
    /**
     * 附件
     */
    private String files;

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnitText() {
        return unitText;
    }

    public void setUnitText(String unitText) {
        this.unitText = unitText;
    }

    public String getJournalName() {
        return journalName;
    }

    public void setJournalName(String journalName) {
        this.journalName = journalName;
    }

    public String getJournalLevel() {
        return journalLevel;
    }

    public void setJournalLevel(String journalLevel) {
        this.journalLevel = journalLevel;
    }

    public String getInfluencingFactors() {
        return influencingFactors;
    }

    public void setInfluencingFactors(String influencingFactors) {
        this.influencingFactors = influencingFactors;
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
    }

    public String getJournalLevelText() {
        return journalLevelText;
    }

    public void setJournalLevelText(String journalLevelText) {
        this.journalLevelText = journalLevelText;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
}
