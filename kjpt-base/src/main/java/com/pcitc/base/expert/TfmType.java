package com.pcitc.base.expert;

import com.pcitc.base.common.DataEntity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * <p>实体类</p>
 * <p>Table: tfm_type - </p>
 *
 * @since 2019-01-16 02:47:24
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TfmType extends DataEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * tfm_type_id - 分类id
     */
    private String tfmTypeId;

    /**
     * type_code - 分类编码
     */
    private String typeCode;

    /**
     * type_name - 分类名称
     */
    private String typeName;

    /**
     * parent_id - 父节点id
     */
    private String parentId;

    /**
     * parent_code - 父节点编码
     */
    private String parentCode;

    /**
     * is_parent - 是否是父亲节点
     */
    private String isParent;

    /**
     * type_index - 检索辅助字段
     */
    private String typeIndex;

    /**
     * status - 状态位
     */
    private String status;

    /**
     * level_code - 层级
     */
    private String levelCode;

    /**
     * data_order - 数据排序字段
     */
    private String dataOrder;

    /**
     * remarks - 分类说明
     */
    private String remarks;

    /**
     * type_scope - 分类的范畴（五大分类）
     */
    private String typeScope;

    /**
     * create_user - 创建人名称
     */
    private String createUser;

    /**
     * create_user_id - 创建人id
     */
    private String createUserId;

    /**
     * create_date - 创建时间
     */
    private String createDate;

    /**
     * update_date - 修改时间
     */
    private String updateDate;

    /**
     * update_user - 修改人
     */
    private String updateUser;

    /**
     * audit_status - 审批状态，默认不审批
     */
    private String auditStatus;

    /**
     * is_hot - 是否是热点技术
     */
    private String isHot;

    /**
     * develop_info - 未来发展情况
     */
    private String developInfo;

    /**
     * direction_info - 发展情况
     */
    private String directionInfo;

    public String getTfmTypeId() {
        return this.tfmTypeId;
    }

    public void setTfmTypeId(String tfmTypeId) {
        this.tfmTypeId = tfmTypeId;
    }

    public String getTypeCode() {
        return this.typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getParentId() {
        return this.parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentCode() {
        return this.parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getIsParent() {
        return this.isParent;
    }

    public void setIsParent(String isParent) {
        this.isParent = isParent;
    }

    public String getTypeIndex() {
        return this.typeIndex;
    }

    public void setTypeIndex(String typeIndex) {
        this.typeIndex = typeIndex;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLevelCode() {
        return this.levelCode;
    }

    public void setLevelCode(String levelCode) {
        this.levelCode = levelCode;
    }

    public String getDataOrder() {
        return this.dataOrder;
    }

    public void setDataOrder(String dataOrder) {
        this.dataOrder = dataOrder;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTypeScope() {
        return this.typeScope;
    }

    public void setTypeScope(String typeScope) {
        this.typeScope = typeScope;
    }

    public String getCreateUser() {
        return this.createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateUserId() {
        return this.createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateUser() {
        return this.updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getAuditStatus() {
        return this.auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getIsHot() {
        return this.isHot;
    }

    public void setIsHot(String isHot) {
        this.isHot = isHot;
    }

    public String getDevelopInfo() {
        return this.developInfo;
    }

    public void setDevelopInfo(String developInfo) {
        this.developInfo = developInfo;
    }

    public String getDirectionInfo() {
        return this.directionInfo;
    }

    public void setDirectionInfo(String directionInfo) {
        this.directionInfo = directionInfo;
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

        TfmType other = (TfmType) that;

        return
                (this.getTfmTypeId() == null ? other.getTfmTypeId() == null : this.getTfmTypeId().equals(other.getTfmTypeId())) &&

                        (this.getTypeCode() == null ? other.getTypeCode() == null : this.getTypeCode().equals(other.getTypeCode())) &&

                        (this.getTypeName() == null ? other.getTypeName() == null : this.getTypeName().equals(other.getTypeName())) &&

                        (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId())) &&

                        (this.getParentCode() == null ? other.getParentCode() == null : this.getParentCode().equals(other.getParentCode())) &&

                        (this.getIsParent() == null ? other.getIsParent() == null : this.getIsParent().equals(other.getIsParent())) &&

                        (this.getTypeIndex() == null ? other.getTypeIndex() == null : this.getTypeIndex().equals(other.getTypeIndex())) &&

                        (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus())) &&

                        (this.getLevelCode() == null ? other.getLevelCode() == null : this.getLevelCode().equals(other.getLevelCode())) &&

                        (this.getDataOrder() == null ? other.getDataOrder() == null : this.getDataOrder().equals(other.getDataOrder())) &&

                        (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks())) &&

                        (this.getTypeScope() == null ? other.getTypeScope() == null : this.getTypeScope().equals(other.getTypeScope())) &&

                        (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser())) &&

                        (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId())) &&

                        (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate())) &&

                        (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate())) &&

                        (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser())) &&

                        (this.getAuditStatus() == null ? other.getAuditStatus() == null : this.getAuditStatus().equals(other.getAuditStatus())) &&

                        (this.getIsHot() == null ? other.getIsHot() == null : this.getIsHot().equals(other.getIsHot())) &&

                        (this.getDevelopInfo() == null ? other.getDevelopInfo() == null : this.getDevelopInfo().equals(other.getDevelopInfo())) &&

                        (this.getDirectionInfo() == null ? other.getDirectionInfo() == null : this.getDirectionInfo().equals(other.getDirectionInfo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTfmTypeId() == null) ? 0 : getTfmTypeId().hashCode());
        result = prime * result + ((getTypeCode() == null) ? 0 : getTypeCode().hashCode());
        result = prime * result + ((getTypeName() == null) ? 0 : getTypeName().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getParentCode() == null) ? 0 : getParentCode().hashCode());
        result = prime * result + ((getIsParent() == null) ? 0 : getIsParent().hashCode());
        result = prime * result + ((getTypeIndex() == null) ? 0 : getTypeIndex().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getLevelCode() == null) ? 0 : getLevelCode().hashCode());
        result = prime * result + ((getDataOrder() == null) ? 0 : getDataOrder().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getTypeScope() == null) ? 0 : getTypeScope().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getAuditStatus() == null) ? 0 : getAuditStatus().hashCode());
        result = prime * result + ((getIsHot() == null) ? 0 : getIsHot().hashCode());
        result = prime * result + ((getDevelopInfo() == null) ? 0 : getDevelopInfo().hashCode());
        result = prime * result + ((getDirectionInfo() == null) ? 0 : getDirectionInfo().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tfmTypeId=").append(tfmTypeId);
        sb.append(", typeCode=").append(typeCode);
        sb.append(", typeName=").append(typeName);
        sb.append(", parentId=").append(parentId);
        sb.append(", parentCode=").append(parentCode);
        sb.append(", isParent=").append(isParent);
        sb.append(", typeIndex=").append(typeIndex);
        sb.append(", status=").append(status);
        sb.append(", levelCode=").append(levelCode);
        sb.append(", dataOrder=").append(dataOrder);
        sb.append(", remarks=").append(remarks);
        sb.append(", typeScope=").append(typeScope);
        sb.append(", createUser=").append(createUser);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", auditStatus=").append(auditStatus);
        sb.append(", isHot=").append(isHot);
        sb.append(", developInfo=").append(developInfo);
        sb.append(", directionInfo=").append(directionInfo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}