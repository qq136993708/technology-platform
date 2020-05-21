package com.pcitc.base.manage;

import com.pcitc.base.common.RecordModel;

import java.util.Date;

/**
 * @author ty
 */
public class ManageMethod  extends RecordModel {

    private String id;

    /**
     * 管理办法名称
     */
    private String methodName;
    /**
     * 版次字典表
     */
    private String edition;
    /**
     * 版次中文名称
     */
    private String editionText;
    /**
     * 发布日期
     */
    private Date publishDate;
    /**
     * 附件
     */
    private String files;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEditionText() {
        return editionText;
    }

    public void setEditionText(String editionText) {
        this.editionText = editionText;
    }
}
