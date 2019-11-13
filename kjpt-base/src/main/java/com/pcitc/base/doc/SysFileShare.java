package com.pcitc.base.doc;

import com.pcitc.base.common.DataEntity;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
/**
 * <p>实体类</p>
 * <p>Table: sys_file_share - 文件分享信息</p>
 *
 * @since 2018-06-19 03:58:11
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SysFileShare  extends DataEntity implements Serializable  {

    private static final long serialVersionUID = 1L;

    /** id -  */
    private String id;

    /** file_id - 文件ID */
    private String fileId;

    /** user_id - 用户ID */
    private String userId;

    /** stype - 类型 */
    private String stype;

    /** area - 分享范围 */
    private String area;

    /** create_person_id - 创建人ID */
    private String createPersonId;

    /** create_date - 创建时间 */
    private String createDate;

    /** ramarks - 备注 */
    private String ramarks;

    /** status - 0代表作废（禁用）、1代表生效（启用） */
    private String status;

    /** audit_status - 0：未审批   1：审批中    2：审批通过    3：审批不通过 */
    private String auditStatus;

    /** update_person_id - 修改人ID */
    private String updatePersonId;

    /** update_date - 修改时间 */
    private String updateDate;

    /** update_person_name - 修改人名称 */
    private String updatePersonName;

    /** create_person_name - 创建人名称 */
    private String createPersonName;

    /** bak1 -  */
    private String bak1;

    /** bak2 -  */
    private String bak2;

    /** bak3 -  */
    private String bak3;

    /** bak4 -  */
    private String bak4;


    public String getId(){
        return this.id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getFileId(){
        return this.fileId;
    }
    public void setFileId(String fileId){
        this.fileId = fileId;
    }

    public String getUserId(){
        return this.userId;
    }
    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getStype(){
        return this.stype;
    }
    public void setStype(String stype){
        this.stype = stype;
    }

    public String getArea(){
        return this.area;
    }
    public void setArea(String area){
        this.area = area;
    }

    public String getCreatePersonId(){
        return this.createPersonId;
    }
    public void setCreatePersonId(String createPersonId){
        this.createPersonId = createPersonId;
    }

    public String getCreateDate(){
        return this.createDate;
    }
    public void setCreateDate(String createDate){
        this.createDate = createDate;
    }

    public String getRamarks(){
        return this.ramarks;
    }
    public void setRamarks(String ramarks){
        this.ramarks = ramarks;
    }

    public String getStatus(){
        return this.status;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public String getAuditStatus(){
        return this.auditStatus;
    }
    public void setAuditStatus(String auditStatus){
        this.auditStatus = auditStatus;
    }

    public String getUpdatePersonId(){
        return this.updatePersonId;
    }
    public void setUpdatePersonId(String updatePersonId){
        this.updatePersonId = updatePersonId;
    }

    public String getUpdateDate(){
        return this.updateDate;
    }
    public void setUpdateDate(String updateDate){
        this.updateDate = updateDate;
    }

    public String getUpdatePersonName(){
        return this.updatePersonName;
    }
    public void setUpdatePersonName(String updatePersonName){
        this.updatePersonName = updatePersonName;
    }

    public String getCreatePersonName(){
        return this.createPersonName;
    }
    public void setCreatePersonName(String createPersonName){
        this.createPersonName = createPersonName;
    }

    public String getBak1(){
        return this.bak1;
    }
    public void setBak1(String bak1){
        this.bak1 = bak1;
    }

    public String getBak2(){
        return this.bak2;
    }
    public void setBak2(String bak2){
        this.bak2 = bak2;
    }

    public String getBak3(){
        return this.bak3;
    }
    public void setBak3(String bak3){
        this.bak3 = bak3;
    }

    public String getBak4(){
        return this.bak4;
    }
    public void setBak4(String bak4){
        this.bak4 = bak4;
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

SysFileShare other = (SysFileShare) that;


return
    (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))&&
    
    (this.getFileId() == null ? other.getFileId() == null : this.getFileId().equals(other.getFileId()))&&
    
    (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))&&
    
    (this.getStype() == null ? other.getStype() == null : this.getStype().equals(other.getStype()))&&
    
    (this.getArea() == null ? other.getArea() == null : this.getArea().equals(other.getArea()))&&
    
    (this.getCreatePersonId() == null ? other.getCreatePersonId() == null : this.getCreatePersonId().equals(other.getCreatePersonId()))&&
    
    (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))&&
    
    (this.getRamarks() == null ? other.getRamarks() == null : this.getRamarks().equals(other.getRamarks()))&&
    
    (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))&&
    
    (this.getAuditStatus() == null ? other.getAuditStatus() == null : this.getAuditStatus().equals(other.getAuditStatus()))&&
    
    (this.getUpdatePersonId() == null ? other.getUpdatePersonId() == null : this.getUpdatePersonId().equals(other.getUpdatePersonId()))&&
    
    (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))&&
    
    (this.getUpdatePersonName() == null ? other.getUpdatePersonName() == null : this.getUpdatePersonName().equals(other.getUpdatePersonName()))&&
    
    (this.getCreatePersonName() == null ? other.getCreatePersonName() == null : this.getCreatePersonName().equals(other.getCreatePersonName()))&&
    
    (this.getBak1() == null ? other.getBak1() == null : this.getBak1().equals(other.getBak1()))&&
    
    (this.getBak2() == null ? other.getBak2() == null : this.getBak2().equals(other.getBak2()))&&
    
    (this.getBak3() == null ? other.getBak3() == null : this.getBak3().equals(other.getBak3()))&&
    
    (this.getBak4() == null ? other.getBak4() == null : this.getBak4().equals(other.getBak4()));
}

@Override
public int hashCode() {
final int prime = 31;
int result = 1;
result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
result = prime * result + ((getFileId() == null) ? 0 : getFileId().hashCode());
result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
result = prime * result + ((getStype() == null) ? 0 : getStype().hashCode());
result = prime * result + ((getArea() == null) ? 0 : getArea().hashCode());
result = prime * result + ((getCreatePersonId() == null) ? 0 : getCreatePersonId().hashCode());
result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
result = prime * result + ((getRamarks() == null) ? 0 : getRamarks().hashCode());
result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
result = prime * result + ((getAuditStatus() == null) ? 0 : getAuditStatus().hashCode());
result = prime * result + ((getUpdatePersonId() == null) ? 0 : getUpdatePersonId().hashCode());
result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
result = prime * result + ((getUpdatePersonName() == null) ? 0 : getUpdatePersonName().hashCode());
result = prime * result + ((getCreatePersonName() == null) ? 0 : getCreatePersonName().hashCode());
result = prime * result + ((getBak1() == null) ? 0 : getBak1().hashCode());
result = prime * result + ((getBak2() == null) ? 0 : getBak2().hashCode());
result = prime * result + ((getBak3() == null) ? 0 : getBak3().hashCode());
result = prime * result + ((getBak4() == null) ? 0 : getBak4().hashCode());
return result;
}

@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append(getClass().getSimpleName());
sb.append(" [");
sb.append("Hash = ").append(hashCode());
sb.append(", id=").append(id);
sb.append(", fileId=").append(fileId);
sb.append(", userId=").append(userId);
sb.append(", stype=").append(stype);
sb.append(", area=").append(area);
sb.append(", createPersonId=").append(createPersonId);
sb.append(", createDate=").append(createDate);
sb.append(", ramarks=").append(ramarks);
sb.append(", status=").append(status);
sb.append(", auditStatus=").append(auditStatus);
sb.append(", updatePersonId=").append(updatePersonId);
sb.append(", updateDate=").append(updateDate);
sb.append(", updatePersonName=").append(updatePersonName);
sb.append(", createPersonName=").append(createPersonName);
sb.append(", bak1=").append(bak1);
sb.append(", bak2=").append(bak2);
sb.append(", bak3=").append(bak3);
sb.append(", bak4=").append(bak4);
sb.append(", serialVersionUID=").append(serialVersionUID);
sb.append("]");
return sb.toString();
}
}