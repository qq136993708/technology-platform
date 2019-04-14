package com.pcitc.base.system;

import com.pcitc.base.common.DataEntity;

import com.pcitc.base.annotations.Document;
import com.pcitc.base.annotations.Field;
import com.pcitc.base.annotations.ID;
import com.pcitc.base.common.enums.FieldType;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * <p>实体类</p>
 * <p>Table: sys_file - </p>
 *
 * @since 2018-08-22 02:10:20
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(index = "files", type = "sysfiletype", replicas = 1, shards = 5)
public class SysFile extends DataEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 创建时间
     */
    @Field(type = FieldType.text)
    private String createDateTime;

    /**
     * 删除标志
     */
    @Field(type = FieldType.text)
    private String deleted;

    /**
     * 更新时间
     */
    @Field(type = FieldType.text)
    private String updateDateTime;

    /**
     * 版本
     */
    @Field(type = FieldType.text)
    private String version;

    /**
     * 创建人
     */
    @Field(type = FieldType.text)
    private String createUserId;

    /**
     * 文件名称
     */
    //@Field(type = FieldType.text)
    //@Field(type = FieldType.text, analyzer = "ik_max_word", fieldsName = {"ik", "pinyin", "first_py"}, fieldsAnalyzer = {"ik_max_word", "full_pinyin_letter_analyzer", "first_py_letter_analyzer"})
    private String fileName;

    /**
     * 存储路径
     */
    @Field(type = FieldType.text)
    private String filePath;
    @Field(type = FieldType.text)
    private String fileSize;

    @Field(type = FieldType.text)
    private String formId;
    @Field(type = FieldType.text)
    private String savedName;

    @Field(type = FieldType.text)
    private String fileMd;


    @Field(type = FieldType.text)
    private String fileSuffix;


    @Field(type = FieldType.text)
    private String startTime;


    @Field(type = FieldType.text)
    private String endTime;


    @Field(type = FieldType.text)
    private String filePublish;

    /**
     * 密码
     */
    @Field(type = FieldType.text)
    private String filePwd;
    @Field(type = FieldType.text)
    private String bak1;
    @Field(type = FieldType.text)
    private String bak2;
    @Field(type = FieldType.text)
    private String bak3;
    @Field(type = FieldType.text, analyzer = "ik_max_word", fieldsName = {"ik", "pinyin", "first_py"}, fieldsAnalyzer = {"ik_max_word", "full_pinyin_letter_analyzer", "first_py_letter_analyzer"})
    private String bak4;

    /**
     * 文件种类
     */
    @Field(type = FieldType.text)
    private String fileKind;


    @ID
    private Integer esId;

    /**
     * is_del - 是否删除0否1是
     */
    private String isDel;

    /**
     * exp_date - 删除日期
     */
    private String expDate;

    /**
     * dataId - 表单ID
     */
    private String dataid;

    /**
     * flag - 是否已经关联表单
     */
    private String flag;

    /**
     * -
     */
    private String bak5;

    /**
     * 文件实际创建时间 -
     */
    private String bak6;

    /**
     * 文件经纬度 -
     */
    private String bak7;

    /**
     * bak8 -
     */
    private String bak8;

    /**
     * part_img_path - 缩略图片地址
     */
    private String partImgPath;

    /**
     * bak9 -
     */
    private String bak9;

    /**
     * bak10 -
     */
    private String bak10;


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateDateTime() {
        return this.createDateTime;
    }

    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getDeleted() {
        return this.deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getUpdateDateTime() {
        return this.updateDateTime;
    }

    public void setUpdateDateTime(String updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCreateUserId() {
        return this.createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileSize() {
        return this.fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFormId() {
        return this.formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getSavedName() {
        return this.savedName;
    }

    public void setSavedName(String savedName) {
        this.savedName = savedName;
    }

    public String getFileMd() {
        return this.fileMd;
    }

    public void setFileMd(String fileMd) {
        this.fileMd = fileMd;
    }

    public String getFileSuffix() {
        return this.fileSuffix;
    }

    public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getFilePublish() {
        return this.filePublish;
    }

    public void setFilePublish(String filePublish) {
        this.filePublish = filePublish;
    }

    public String getFilePwd() {
        return this.filePwd;
    }

    public void setFilePwd(String filePwd) {
        this.filePwd = filePwd;
    }

    public String getBak1() {
        return this.bak1;
    }

    public void setBak1(String bak1) {
        this.bak1 = bak1;
    }

    public String getBak2() {
        return this.bak2;
    }

    public void setBak2(String bak2) {
        this.bak2 = bak2;
    }

    public String getBak3() {
        return this.bak3;
    }

    public void setBak3(String bak3) {
        this.bak3 = bak3;
    }

    public String getBak4() {
        return this.bak4;
    }

    public void setBak4(String bak4) {
        this.bak4 = bak4;
    }

    public String getFileKind() {
        return this.fileKind;
    }

    public void setFileKind(String fileKind) {
        this.fileKind = fileKind;
    }

    public Integer getEsId() {
        return this.esId;
    }

    public void setEsId(Integer esId) {
        this.esId = esId;
    }

    public String getIsDel() {
        return this.isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    public String getExpDate() {
        return this.expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getDataid() {
        return this.dataid;
    }

    public void setDataid(String dataid) {
        this.dataid = dataid;
    }

    public String getFlag() {
        return this.flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getBak5() {
        return this.bak5;
    }

    public void setBak5(String bak5) {
        this.bak5 = bak5;
    }

    public String getBak6() {
        return this.bak6;
    }

    public void setBak6(String bak6) {
        this.bak6 = bak6;
    }

    public String getBak7() {
        return this.bak7;
    }

    public void setBak7(String bak7) {
        this.bak7 = bak7;
    }

    public String getBak8() {
        return this.bak8;
    }

    public void setBak8(String bak8) {
        this.bak8 = bak8;
    }

    public String getPartImgPath() {
        return this.partImgPath;
    }

    public void setPartImgPath(String partImgPath) {
        this.partImgPath = partImgPath;
    }

    public String getBak9() {
        return this.bak9;
    }

    public void setBak9(String bak9) {
        this.bak9 = bak9;
    }

    public String getBak10() {
        return this.bak10;
    }

    public void setBak10(String bak10) {
        this.bak10 = bak10;
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


        return
                (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId())) &&

                        (this.getCreateDateTime() == null ? other.getCreateDateTime() == null : this.getCreateDateTime().equals(other.getCreateDateTime())) &&

                        (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted())) &&

                        (this.getUpdateDateTime() == null ? other.getUpdateDateTime() == null : this.getUpdateDateTime().equals(other.getUpdateDateTime())) &&

                        (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion())) &&

                        (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId())) &&

                        (this.getFileName() == null ? other.getFileName() == null : this.getFileName().equals(other.getFileName())) &&

                        (this.getFilePath() == null ? other.getFilePath() == null : this.getFilePath().equals(other.getFilePath())) &&

                        (this.getFileSize() == null ? other.getFileSize() == null : this.getFileSize().equals(other.getFileSize())) &&

                        (this.getFormId() == null ? other.getFormId() == null : this.getFormId().equals(other.getFormId())) &&

                        (this.getSavedName() == null ? other.getSavedName() == null : this.getSavedName().equals(other.getSavedName())) &&

                        (this.getFileMd() == null ? other.getFileMd() == null : this.getFileMd().equals(other.getFileMd())) &&

                        (this.getFileSuffix() == null ? other.getFileSuffix() == null : this.getFileSuffix().equals(other.getFileSuffix())) &&

                        (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime())) &&

                        (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime())) &&

                        (this.getFilePublish() == null ? other.getFilePublish() == null : this.getFilePublish().equals(other.getFilePublish())) &&

                        (this.getFilePwd() == null ? other.getFilePwd() == null : this.getFilePwd().equals(other.getFilePwd())) &&

                        (this.getBak1() == null ? other.getBak1() == null : this.getBak1().equals(other.getBak1())) &&

                        (this.getBak2() == null ? other.getBak2() == null : this.getBak2().equals(other.getBak2())) &&

                        (this.getBak3() == null ? other.getBak3() == null : this.getBak3().equals(other.getBak3())) &&

                        (this.getBak4() == null ? other.getBak4() == null : this.getBak4().equals(other.getBak4())) &&

                        (this.getFileKind() == null ? other.getFileKind() == null : this.getFileKind().equals(other.getFileKind())) &&

                        (this.getEsId() == null ? other.getEsId() == null : this.getEsId().equals(other.getEsId())) &&

                        (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel())) &&

                        (this.getExpDate() == null ? other.getExpDate() == null : this.getExpDate().equals(other.getExpDate())) &&

                        (this.getDataid() == null ? other.getDataid() == null : this.getDataid().equals(other.getDataid())) &&

                        (this.getFlag() == null ? other.getFlag() == null : this.getFlag().equals(other.getFlag())) &&

                        (this.getBak5() == null ? other.getBak5() == null : this.getBak5().equals(other.getBak5())) &&

                        (this.getBak6() == null ? other.getBak6() == null : this.getBak6().equals(other.getBak6())) &&

                        (this.getBak7() == null ? other.getBak7() == null : this.getBak7().equals(other.getBak7())) &&

                        (this.getBak8() == null ? other.getBak8() == null : this.getBak8().equals(other.getBak8())) &&

                        (this.getPartImgPath() == null ? other.getPartImgPath() == null : this.getPartImgPath().equals(other.getPartImgPath())) &&

                        (this.getBak9() == null ? other.getBak9() == null : this.getBak9().equals(other.getBak9())) &&

                        (this.getBak10() == null ? other.getBak10() == null : this.getBak10().equals(other.getBak10()));
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
        result = prime * result + ((getEsId() == null) ? 0 : getEsId().hashCode());
        result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
        result = prime * result + ((getExpDate() == null) ? 0 : getExpDate().hashCode());
        result = prime * result + ((getDataid() == null) ? 0 : getDataid().hashCode());
        result = prime * result + ((getFlag() == null) ? 0 : getFlag().hashCode());
        result = prime * result + ((getBak5() == null) ? 0 : getBak5().hashCode());
        result = prime * result + ((getBak6() == null) ? 0 : getBak6().hashCode());
        result = prime * result + ((getBak7() == null) ? 0 : getBak7().hashCode());
        result = prime * result + ((getBak8() == null) ? 0 : getBak8().hashCode());
        result = prime * result + ((getPartImgPath() == null) ? 0 : getPartImgPath().hashCode());
        result = prime * result + ((getBak9() == null) ? 0 : getBak9().hashCode());
        result = prime * result + ((getBak10() == null) ? 0 : getBak10().hashCode());
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
        sb.append(", esId=").append(esId);
        sb.append(", isDel=").append(isDel);
        sb.append(", expDate=").append(expDate);
        sb.append(", dataid=").append(dataid);
        sb.append(", flag=").append(flag);
        sb.append(", bak5=").append(bak5);
        sb.append(", bak6=").append(bak6);
        sb.append(", bak7=").append(bak7);
        sb.append(", bak8=").append(bak8);
        sb.append(", partImgPath=").append(partImgPath);
        sb.append(", bak9=").append(bak9);
        sb.append(", bak10=").append(bak10);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}