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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysFile other = (SysFile) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getCreateDateTime() == null ? other.getCreateDateTime() == null : this.getCreateDateTime().equals(other.getCreateDateTime()))
                && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()))
                && (this.getUpdateDateTime() == null ? other.getUpdateDateTime() == null : this.getUpdateDateTime().equals(other.getUpdateDateTime()))
                && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
                && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
                && (this.getFileName() == null ? other.getFileName() == null : this.getFileName().equals(other.getFileName()))
                && (this.getFilePath() == null ? other.getFilePath() == null : this.getFilePath().equals(other.getFilePath()))
                && (this.getFileSize() == null ? other.getFileSize() == null : this.getFileSize().equals(other.getFileSize()))
                && (this.getFormId() == null ? other.getFormId() == null : this.getFormId().equals(other.getFormId()))
                && (this.getSavedName() == null ? other.getSavedName() == null : this.getSavedName().equals(other.getSavedName()))
                && (this.getFileMd() == null ? other.getFileMd() == null : this.getFileMd().equals(other.getFileMd()))
                && (this.getFileSuffix() == null ? other.getFileSuffix() == null : this.getFileSuffix().equals(other.getFileSuffix()))
                && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
                && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
                && (this.getFilePublish() == null ? other.getFilePublish() == null : this.getFilePublish().equals(other.getFilePublish()))
                && (this.getFilePwd() == null ? other.getFilePwd() == null : this.getFilePwd().equals(other.getFilePwd()))
                && (this.getBak1() == null ? other.getBak1() == null : this.getBak1().equals(other.getBak1()))
                && (this.getBak2() == null ? other.getBak2() == null : this.getBak2().equals(other.getBak2()))
                && (this.getBak3() == null ? other.getBak3() == null : this.getBak3().equals(other.getBak3()))
                && (this.getBak4() == null ? other.getBak4() == null : this.getBak4().equals(other.getBak4()))
                && (this.getFileKind() == null ? other.getFileKind() == null : this.getFileKind().equals(other.getFileKind()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateDateTime() == null) ? 0 : getCreateDateTime().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        result = prime * result + ((getUpdateDateTime() == null) ? 0 : getUpdateDateTime().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getFileName() == null) ? 0 : getFileName().hashCode());
        result = prime * result + ((getFilePath() == null) ? 0 : getFilePath().hashCode());
        result = prime * result + ((getFileSize() == null) ? 0 : getFileSize().hashCode());
        result = prime * result + ((getFormId() == null) ? 0 : getFormId().hashCode());
        result = prime * result + ((getSavedName() == null) ? 0 : getSavedName().hashCode());
        result = prime * result + ((getFileMd() == null) ? 0 : getFileMd().hashCode());
        result = prime * result + ((getFileSuffix() == null) ? 0 : getFileSuffix().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getFilePublish() == null) ? 0 : getFilePublish().hashCode());
        result = prime * result + ((getFilePwd() == null) ? 0 : getFilePwd().hashCode());
        result = prime * result + ((getBak1() == null) ? 0 : getBak1().hashCode());
        result = prime * result + ((getBak2() == null) ? 0 : getBak2().hashCode());
        result = prime * result + ((getBak3() == null) ? 0 : getBak3().hashCode());
        result = prime * result + ((getBak4() == null) ? 0 : getBak4().hashCode());
        result = prime * result + ((getFileKind() == null) ? 0 : getFileKind().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createDateTime=").append(createDateTime);
        sb.append(", deleted=").append(deleted);
        sb.append(", updateDateTime=").append(updateDateTime);
        sb.append(", version=").append(version);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", fileName=").append(fileName);
        sb.append(", filePath=").append(filePath);
        sb.append(", fileSize=").append(fileSize);
        sb.append(", formId=").append(formId);
        sb.append(", savedName=").append(savedName);
        sb.append(", fileMd=").append(fileMd);
        sb.append(", fileSuffix=").append(fileSuffix);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", filePublish=").append(filePublish);
        sb.append(", filePwd=").append(filePwd);
        sb.append(", bak1=").append(bak1);
        sb.append(", bak2=").append(bak2);
        sb.append(", bak3=").append(bak3);
        sb.append(", bak4=").append(bak4);
        sb.append(", fileKind=").append(fileKind);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}