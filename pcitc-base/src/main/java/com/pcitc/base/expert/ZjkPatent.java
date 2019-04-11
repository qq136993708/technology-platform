package com.pcitc.base.expert;

import com.pcitc.base.common.DataEntity;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.io.Serializable;

/**
 * <p>实体类</p>
 * <p>Table: zjk_patent - 专家-专利信息</p>
 *
 * @since 2019-04-02 04:14:04
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ZjkPatent extends DataEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * data_id -
     */
    private String dataId;

    /**
     * user_id - 用户id
     */
    private String userId;

    /**
     * expert_id - 专家id
     */
    private String expertId;

    /**
     * patent_name - 专利名称
     */
    private String patentName;

    /**
     * patent_code - 专利号
     */
    private String patentCode;

    /**
     * patent_desc - 专利描述
     */
    private String patentDesc;

    /**
     * patent_keys - 专利关键字
     */
    private String patentKeys;

    /**
     * patente_people_name - 专利权人名称
     */
    private String patentePeopleName;

    /**
     * patente_people_id - 专利权人ID
     */
    private String patentePeopleId;

    /**
     * invent_people_id - 发明人ID
     */
    private String inventPeopleId;

    /**
     * invent_people_name - 发明人
     */
    private String inventPeopleName;

    /**
     * apply_people - 申请人
     */
    private String applyPeople;

    /**
     * public_date - 公开时间
     */
    private String publicDate;

    /**
     * apply_date - 申请日期
     */
    private String applyDate;

    /**
     * bak1 - 所属技术分类名称
     */
    private String bak1;

    /**
     * bak2 -
     */
    private String bak2;

    /**
     * bak3 -
     */
    private String bak3;

    /**
     * bak4 -
     */
    private String bak4;

    /**
     * bak5 -
     */
    private String bak5;

    /**
     * bak6 -
     */
    private String bak6;

    /**
     * modify_user_disp - 修改人姓名
     */
    private String modifyUserDisp;

    /**
     * owner_tech_type - 所属技术分类
     */
    private String ownerTechType;

    /**
     * patente_background - 专利背景
     */
    private String patenteBackground;

    /**
     * owner_project_name - 所属项目名称
     */
    private String ownerProjectName;

    /**
     * expert_nationality - 国籍
     */
    private String expertNationality;

    /**
     * owner_project_id - 所属项目ID
     */
    private String ownerProjectId;

    /**
     * company - 所属公司（机构）
     */
    private String company;

    /**
     * compan_id - 所属机构ID
     */
    private String companId;

    /**
     * sys_flag - 状态位
     */
    private String sysFlag;

    /**
     * data_order - 排序
     */
    private Integer dataOrder;

    /**
     * del_flag - 状态
     */
    private Integer delFlag;

    /**
     * create_date - 创建时间
     */
    private String createDate;

    /**
     * create_user - 创建人id
     */
    private String createUser;

    /**
     * create_user_disp - 创建人姓名
     */
    private String createUserDisp;

    /**
     * modify_date - 修改时间
     */
    private String modifyDate;

    /**
     * modify_user - 修改人id
     */
    private String modifyUser;

    @Transient
    public String getSelect_type() {
        return select_type;
    }

    public void setSelect_type(String select_type) {
        this.select_type = select_type;
    }

    private String select_type;
    /**
     * doc_id - 文档编号
     */
    private String docId;

    /**
     * nd - 年度
     */
    private String nd;

    /**
     * country - 授权国家
     */
    private String country;

    /**
     * is_result - 是否形成工业化成果
     */
    private String isResult;

    public String getDataId() {
        return this.dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getExpertId() {
        return this.expertId;
    }

    public void setExpertId(String expertId) {
        this.expertId = expertId;
    }

    public String getPatentName() {
        return this.patentName;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName;
    }

    public String getPatentCode() {
        return this.patentCode;
    }

    public void setPatentCode(String patentCode) {
        this.patentCode = patentCode;
    }

    public String getPatentDesc() {
        return this.patentDesc;
    }

    public void setPatentDesc(String patentDesc) {
        this.patentDesc = patentDesc;
    }

    public String getPatentKeys() {
        return this.patentKeys;
    }

    public void setPatentKeys(String patentKeys) {
        this.patentKeys = patentKeys;
    }

    public String getPatentePeopleName() {
        return this.patentePeopleName;
    }

    public void setPatentePeopleName(String patentePeopleName) {
        this.patentePeopleName = patentePeopleName;
    }

    public String getPatentePeopleId() {
        return this.patentePeopleId;
    }

    public void setPatentePeopleId(String patentePeopleId) {
        this.patentePeopleId = patentePeopleId;
    }

    public String getInventPeopleId() {
        return this.inventPeopleId;
    }

    public void setInventPeopleId(String inventPeopleId) {
        this.inventPeopleId = inventPeopleId;
    }

    public String getInventPeopleName() {
        return this.inventPeopleName;
    }

    public void setInventPeopleName(String inventPeopleName) {
        this.inventPeopleName = inventPeopleName;
    }

    public String getApplyPeople() {
        return this.applyPeople;
    }

    public void setApplyPeople(String applyPeople) {
        this.applyPeople = applyPeople;
    }

    public String getPublicDate() {
        return this.publicDate;
    }

    public void setPublicDate(String publicDate) {
        this.publicDate = publicDate;
    }

    public String getApplyDate() {
        return this.applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
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

    public String getModifyUserDisp() {
        return this.modifyUserDisp;
    }

    public void setModifyUserDisp(String modifyUserDisp) {
        this.modifyUserDisp = modifyUserDisp;
    }

    public String getOwnerTechType() {
        return this.ownerTechType;
    }

    public void setOwnerTechType(String ownerTechType) {
        this.ownerTechType = ownerTechType;
    }

    public String getPatenteBackground() {
        return this.patenteBackground;
    }

    public void setPatenteBackground(String patenteBackground) {
        this.patenteBackground = patenteBackground;
    }

    public String getOwnerProjectName() {
        return this.ownerProjectName;
    }

    public void setOwnerProjectName(String ownerProjectName) {
        this.ownerProjectName = ownerProjectName;
    }

    public String getExpertNationality() {
        return this.expertNationality;
    }

    public void setExpertNationality(String expertNationality) {
        this.expertNationality = expertNationality;
    }

    public String getOwnerProjectId() {
        return this.ownerProjectId;
    }

    public void setOwnerProjectId(String ownerProjectId) {
        this.ownerProjectId = ownerProjectId;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanId() {
        return this.companId;
    }

    public void setCompanId(String companId) {
        this.companId = companId;
    }

    public String getSysFlag() {
        return this.sysFlag;
    }

    public void setSysFlag(String sysFlag) {
        this.sysFlag = sysFlag;
    }

    public Integer getDataOrder() {
        return this.dataOrder;
    }

    public void setDataOrder(Integer dataOrder) {
        this.dataOrder = dataOrder;
    }

    public Integer getDelFlag() {
        return this.delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return this.createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateUserDisp() {
        return this.createUserDisp;
    }

    public void setCreateUserDisp(String createUserDisp) {
        this.createUserDisp = createUserDisp;
    }

    public String getModifyDate() {
        return this.modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getModifyUser() {
        return this.modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public String getDocId() {
        return this.docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getNd() {
        return this.nd;
    }

    public void setNd(String nd) {
        this.nd = nd;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIsResult() {
        return this.isResult;
    }

    public void setIsResult(String isResult) {
        this.isResult = isResult;
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

        ZjkPatent other = (ZjkPatent) that;

        return
                (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId())) &&

                        (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId())) &&

                        (this.getExpertId() == null ? other.getExpertId() == null : this.getExpertId().equals(other.getExpertId())) &&

                        (this.getPatentName() == null ? other.getPatentName() == null : this.getPatentName().equals(other.getPatentName())) &&

                        (this.getPatentCode() == null ? other.getPatentCode() == null : this.getPatentCode().equals(other.getPatentCode())) &&

                        (this.getPatentDesc() == null ? other.getPatentDesc() == null : this.getPatentDesc().equals(other.getPatentDesc())) &&

                        (this.getPatentKeys() == null ? other.getPatentKeys() == null : this.getPatentKeys().equals(other.getPatentKeys())) &&

                        (this.getPatentePeopleName() == null ? other.getPatentePeopleName() == null : this.getPatentePeopleName().equals(other.getPatentePeopleName())) &&

                        (this.getPatentePeopleId() == null ? other.getPatentePeopleId() == null : this.getPatentePeopleId().equals(other.getPatentePeopleId())) &&

                        (this.getInventPeopleId() == null ? other.getInventPeopleId() == null : this.getInventPeopleId().equals(other.getInventPeopleId())) &&

                        (this.getInventPeopleName() == null ? other.getInventPeopleName() == null : this.getInventPeopleName().equals(other.getInventPeopleName())) &&

                        (this.getApplyPeople() == null ? other.getApplyPeople() == null : this.getApplyPeople().equals(other.getApplyPeople())) &&

                        (this.getPublicDate() == null ? other.getPublicDate() == null : this.getPublicDate().equals(other.getPublicDate())) &&

                        (this.getApplyDate() == null ? other.getApplyDate() == null : this.getApplyDate().equals(other.getApplyDate())) &&

                        (this.getBak1() == null ? other.getBak1() == null : this.getBak1().equals(other.getBak1())) &&

                        (this.getBak2() == null ? other.getBak2() == null : this.getBak2().equals(other.getBak2())) &&

                        (this.getBak3() == null ? other.getBak3() == null : this.getBak3().equals(other.getBak3())) &&

                        (this.getBak4() == null ? other.getBak4() == null : this.getBak4().equals(other.getBak4())) &&

                        (this.getBak5() == null ? other.getBak5() == null : this.getBak5().equals(other.getBak5())) &&

                        (this.getBak6() == null ? other.getBak6() == null : this.getBak6().equals(other.getBak6())) &&

                        (this.getModifyUserDisp() == null ? other.getModifyUserDisp() == null : this.getModifyUserDisp().equals(other.getModifyUserDisp())) &&

                        (this.getOwnerTechType() == null ? other.getOwnerTechType() == null : this.getOwnerTechType().equals(other.getOwnerTechType())) &&

                        (this.getPatenteBackground() == null ? other.getPatenteBackground() == null : this.getPatenteBackground().equals(other.getPatenteBackground())) &&

                        (this.getOwnerProjectName() == null ? other.getOwnerProjectName() == null : this.getOwnerProjectName().equals(other.getOwnerProjectName())) &&

                        (this.getExpertNationality() == null ? other.getExpertNationality() == null : this.getExpertNationality().equals(other.getExpertNationality())) &&

                        (this.getOwnerProjectId() == null ? other.getOwnerProjectId() == null : this.getOwnerProjectId().equals(other.getOwnerProjectId())) &&

                        (this.getCompany() == null ? other.getCompany() == null : this.getCompany().equals(other.getCompany())) &&

                        (this.getCompanId() == null ? other.getCompanId() == null : this.getCompanId().equals(other.getCompanId())) &&

                        (this.getSysFlag() == null ? other.getSysFlag() == null : this.getSysFlag().equals(other.getSysFlag())) &&

                        (this.getDataOrder() == null ? other.getDataOrder() == null : this.getDataOrder().equals(other.getDataOrder())) &&

                        (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag())) &&

                        (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate())) &&

                        (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser())) &&

                        (this.getCreateUserDisp() == null ? other.getCreateUserDisp() == null : this.getCreateUserDisp().equals(other.getCreateUserDisp())) &&

                        (this.getModifyDate() == null ? other.getModifyDate() == null : this.getModifyDate().equals(other.getModifyDate())) &&

                        (this.getModifyUser() == null ? other.getModifyUser() == null : this.getModifyUser().equals(other.getModifyUser())) &&

                        (this.getDocId() == null ? other.getDocId() == null : this.getDocId().equals(other.getDocId())) &&

                        (this.getNd() == null ? other.getNd() == null : this.getNd().equals(other.getNd())) &&

                        (this.getCountry() == null ? other.getCountry() == null : this.getCountry().equals(other.getCountry())) &&

                        (this.getIsResult() == null ? other.getIsResult() == null : this.getIsResult().equals(other.getIsResult()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataId() == null) ? 0 : getDataId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getExpertId() == null) ? 0 : getExpertId().hashCode());
        result = prime * result + ((getPatentName() == null) ? 0 : getPatentName().hashCode());
        result = prime * result + ((getPatentCode() == null) ? 0 : getPatentCode().hashCode());
        result = prime * result + ((getPatentDesc() == null) ? 0 : getPatentDesc().hashCode());
        result = prime * result + ((getPatentKeys() == null) ? 0 : getPatentKeys().hashCode());
        result = prime * result + ((getPatentePeopleName() == null) ? 0 : getPatentePeopleName().hashCode());
        result = prime * result + ((getPatentePeopleId() == null) ? 0 : getPatentePeopleId().hashCode());
        result = prime * result + ((getInventPeopleId() == null) ? 0 : getInventPeopleId().hashCode());
        result = prime * result + ((getInventPeopleName() == null) ? 0 : getInventPeopleName().hashCode());
        result = prime * result + ((getApplyPeople() == null) ? 0 : getApplyPeople().hashCode());
        result = prime * result + ((getPublicDate() == null) ? 0 : getPublicDate().hashCode());
        result = prime * result + ((getApplyDate() == null) ? 0 : getApplyDate().hashCode());
        result = prime * result + ((getBak1() == null) ? 0 : getBak1().hashCode());
        result = prime * result + ((getBak2() == null) ? 0 : getBak2().hashCode());
        result = prime * result + ((getBak3() == null) ? 0 : getBak3().hashCode());
        result = prime * result + ((getBak4() == null) ? 0 : getBak4().hashCode());
        result = prime * result + ((getBak5() == null) ? 0 : getBak5().hashCode());
        result = prime * result + ((getBak6() == null) ? 0 : getBak6().hashCode());
        result = prime * result + ((getModifyUserDisp() == null) ? 0 : getModifyUserDisp().hashCode());
        result = prime * result + ((getOwnerTechType() == null) ? 0 : getOwnerTechType().hashCode());
        result = prime * result + ((getPatenteBackground() == null) ? 0 : getPatenteBackground().hashCode());
        result = prime * result + ((getOwnerProjectName() == null) ? 0 : getOwnerProjectName().hashCode());
        result = prime * result + ((getExpertNationality() == null) ? 0 : getExpertNationality().hashCode());
        result = prime * result + ((getOwnerProjectId() == null) ? 0 : getOwnerProjectId().hashCode());
        result = prime * result + ((getCompany() == null) ? 0 : getCompany().hashCode());
        result = prime * result + ((getCompanId() == null) ? 0 : getCompanId().hashCode());
        result = prime * result + ((getSysFlag() == null) ? 0 : getSysFlag().hashCode());
        result = prime * result + ((getDataOrder() == null) ? 0 : getDataOrder().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateUserDisp() == null) ? 0 : getCreateUserDisp().hashCode());
        result = prime * result + ((getModifyDate() == null) ? 0 : getModifyDate().hashCode());
        result = prime * result + ((getModifyUser() == null) ? 0 : getModifyUser().hashCode());
        result = prime * result + ((getDocId() == null) ? 0 : getDocId().hashCode());
        result = prime * result + ((getNd() == null) ? 0 : getNd().hashCode());
        result = prime * result + ((getCountry() == null) ? 0 : getCountry().hashCode());
        result = prime * result + ((getIsResult() == null) ? 0 : getIsResult().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dataId=").append(dataId);
        sb.append(", userId=").append(userId);
        sb.append(", expertId=").append(expertId);
        sb.append(", patentName=").append(patentName);
        sb.append(", patentCode=").append(patentCode);
        sb.append(", patentDesc=").append(patentDesc);
        sb.append(", patentKeys=").append(patentKeys);
        sb.append(", patentePeopleName=").append(patentePeopleName);
        sb.append(", patentePeopleId=").append(patentePeopleId);
        sb.append(", inventPeopleId=").append(inventPeopleId);
        sb.append(", inventPeopleName=").append(inventPeopleName);
        sb.append(", applyPeople=").append(applyPeople);
        sb.append(", publicDate=").append(publicDate);
        sb.append(", applyDate=").append(applyDate);
        sb.append(", bak1=").append(bak1);
        sb.append(", bak2=").append(bak2);
        sb.append(", bak3=").append(bak3);
        sb.append(", bak4=").append(bak4);
        sb.append(", bak5=").append(bak5);
        sb.append(", bak6=").append(bak6);
        sb.append(", modifyUserDisp=").append(modifyUserDisp);
        sb.append(", ownerTechType=").append(ownerTechType);
        sb.append(", patenteBackground=").append(patenteBackground);
        sb.append(", ownerProjectName=").append(ownerProjectName);
        sb.append(", expertNationality=").append(expertNationality);
        sb.append(", ownerProjectId=").append(ownerProjectId);
        sb.append(", company=").append(company);
        sb.append(", companId=").append(companId);
        sb.append(", sysFlag=").append(sysFlag);
        sb.append(", dataOrder=").append(dataOrder);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", createDate=").append(createDate);
        sb.append(", createUser=").append(createUser);
        sb.append(", createUserDisp=").append(createUserDisp);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", modifyUser=").append(modifyUser);
        sb.append(", docId=").append(docId);
        sb.append(", nd=").append(nd);
        sb.append(", country=").append(country);
        sb.append(", isResult=").append(isResult);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}