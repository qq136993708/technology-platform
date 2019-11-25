package com.pcitc.base.system;

import com.pcitc.base.util.DataTableInfoVo;

import java.io.Serializable;
import java.util.List;

/**
 * sys_file
 * @author
 */
public class SysFileVo implements Serializable {


    private List<String> values;

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    private DataTableInfoVo dataTableInfoVo;

    public DataTableInfoVo getDataTableInfoVo() {
        return dataTableInfoVo;
    }

    public void setDataTableInfoVo(DataTableInfoVo dataTableInfoVo) {
        this.dataTableInfoVo = dataTableInfoVo;
    }

    private static final long serialVersionUID = 1L;
    private String id;

    /**
     * 创建时间
     */
    private String createDateTime;

    /**
     * 删除标志
     */
    private String deleted;

    /**
     * 更新时间
     */
    private String updateDateTime;

    /**
     * 版本
     */
    private String version;

    /**
     * 创建人
     */
    private String createUserId;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 存储路径
     */
    private String filePath;

    /**
     * 文件大小
     */
    private String fileSize;

    /**
     * 表单ID
     */
    private String formId;

    /**
     * 保存名称
     */
    private String savedName;

    /**
     * 文件MD5标志
     */
    private String fileMd;

    /**
     * 文件后缀
     */
    private String fileSuffix;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 发布人
     */
    private String filePublish;

    /**
     * 密码
     */
    private String filePwd;

    private String bak1;

    private String bak2;

    private String bak3;

    private String bak4;

    /**
     * 文件种类
     */
    private String fileKind;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(String updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getSavedName() {
        return savedName;
    }

    public void setSavedName(String savedName) {
        this.savedName = savedName;
    }

    public String getFileMd() {
        return fileMd;
    }

    public void setFileMd(String fileMd) {
        this.fileMd = fileMd;
    }

    public String getFileSuffix() {
        return fileSuffix;
    }

    public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getFilePublish() {
        return filePublish;
    }

    public void setFilePublish(String filePublish) {
        this.filePublish = filePublish;
    }

    public String getFilePwd() {
        return filePwd;
    }

    public void setFilePwd(String filePwd) {
        this.filePwd = filePwd;
    }

    public String getBak1() {
        return bak1;
    }

    public void setBak1(String bak1) {
        this.bak1 = bak1;
    }

    public String getBak2() {
        return bak2;
    }

    public void setBak2(String bak2) {
        this.bak2 = bak2;
    }

    public String getBak3() {
        return bak3;
    }

    public void setBak3(String bak3) {
        this.bak3 = bak3;
    }

    public String getBak4() {
        return bak4;
    }

    public void setBak4(String bak4) {
        this.bak4 = bak4;
    }

    public String getFileKind() {
        return fileKind;
    }

    public void setFileKind(String fileKind) {
        this.fileKind = fileKind;
    }

    
}