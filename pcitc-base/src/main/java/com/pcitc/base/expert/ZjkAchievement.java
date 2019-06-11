package com.pcitc.base.expert;

import com.pcitc.base.common.DataEntity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * <p>实体类</p>
 * <p>Table: zjk_achievement - 专家-成果信息</p>
 *
 * @since 2018-12-28 09:30:43
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ZjkAchievement extends DataEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * data_id - 主键
     */
    private String dataId;

    /**
     * expert_id - 专家id
     */
    private String expertId;

    /**
     * user_id - 用户ID
     */
    private String userId;

    /**
     * achievement_name - 成果名称
     */
    private String achievementName;

    /**
     * finish_people - 负责人
     */
    private String finishPeople;

    /**
     * industry_id - 行业领域
     */
    private String industryId;

    /**
     * industry_name - 行业领域名称
     */
    private String industryName;

    /**
     * achievement_keys - 关键字（标签）
     */
    private String achievementKeys;

    /**
     * publish_date - 完成年度
     */
    private String publishDate;

    /**
     * achievement_desc - 成果描述
     */
    private String achievementDesc;

    /**
     * achievement_level - 成果级别（国内领先，国际领先）
     */
    private String achievementLevel;

    /**
     * achievement_type - 成果类型
     */
    private String achievementType;

    /**
     * owner_contract_name - 所属合同名称
     */
    private String ownerContractName;

    /**
     * owner_contract_id - 所属项目ID
     */
    private String ownerContractId;

    /**
     * owner_project_id - 所属项目ID
     */
    private String ownerProjectId;

    /**
     * owner_project_name - 所属项目名称
     */
    private String ownerProjectName;

    /**
     * compan_id - 所属机构ID
     */
    private String companId;

    /**
     * company - 所属公司（机构）
     */
    private String company;

    /**
     * bak1 -
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

    /**
     * modify_user_disp - 修改人姓名
     */
    private String modifyUserDisp;

    public String getDataId() {
        return this.dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getExpertId() {
        return this.expertId;
    }

    public void setExpertId(String expertId) {
        this.expertId = expertId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAchievementName() {
        return this.achievementName;
    }

    public void setAchievementName(String achievementName) {
        this.achievementName = achievementName;
    }

    public String getFinishPeople() {
        return this.finishPeople;
    }

    public void setFinishPeople(String finishPeople) {
        this.finishPeople = finishPeople;
    }

    public String getIndustryId() {
        return this.industryId;
    }

    public void setIndustryId(String industryId) {
        this.industryId = industryId;
    }

    public String getIndustryName() {
        return this.industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public String getAchievementKeys() {
        return this.achievementKeys;
    }

    public void setAchievementKeys(String achievementKeys) {
        this.achievementKeys = achievementKeys;
    }

    public String getPublishDate() {
        return this.publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getAchievementDesc() {
        return this.achievementDesc;
    }

    public void setAchievementDesc(String achievementDesc) {
        this.achievementDesc = achievementDesc;
    }

    public String getAchievementLevel() {
        return this.achievementLevel;
    }

    public void setAchievementLevel(String achievementLevel) {
        this.achievementLevel = achievementLevel;
    }

    public String getAchievementType() {
        return this.achievementType;
    }

    public void setAchievementType(String achievementType) {
        this.achievementType = achievementType;
    }

    public String getOwnerContractName() {
        return this.ownerContractName;
    }

    public void setOwnerContractName(String ownerContractName) {
        this.ownerContractName = ownerContractName;
    }

    public String getOwnerContractId() {
        return this.ownerContractId;
    }

    public void setOwnerContractId(String ownerContractId) {
        this.ownerContractId = ownerContractId;
    }

    public String getOwnerProjectId() {
        return this.ownerProjectId;
    }

    public void setOwnerProjectId(String ownerProjectId) {
        this.ownerProjectId = ownerProjectId;
    }

    public String getOwnerProjectName() {
        return this.ownerProjectName;
    }

    public void setOwnerProjectName(String ownerProjectName) {
        this.ownerProjectName = ownerProjectName;
    }

    public String getCompanId() {
        return this.companId;
    }

    public void setCompanId(String companId) {
        this.companId = companId;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    public String getModifyUserDisp() {
        return this.modifyUserDisp;
    }

    public void setModifyUserDisp(String modifyUserDisp) {
        this.modifyUserDisp = modifyUserDisp;
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

        ZjkAchievement other = (ZjkAchievement) that;

        return
                (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId())) &&

                        (this.getExpertId() == null ? other.getExpertId() == null : this.getExpertId().equals(other.getExpertId())) &&

                        (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId())) &&

                        (this.getAchievementName() == null ? other.getAchievementName() == null : this.getAchievementName().equals(other.getAchievementName())) &&

                        (this.getFinishPeople() == null ? other.getFinishPeople() == null : this.getFinishPeople().equals(other.getFinishPeople())) &&

                        (this.getIndustryId() == null ? other.getIndustryId() == null : this.getIndustryId().equals(other.getIndustryId())) &&

                        (this.getIndustryName() == null ? other.getIndustryName() == null : this.getIndustryName().equals(other.getIndustryName())) &&

                        (this.getAchievementKeys() == null ? other.getAchievementKeys() == null : this.getAchievementKeys().equals(other.getAchievementKeys())) &&

                        (this.getPublishDate() == null ? other.getPublishDate() == null : this.getPublishDate().equals(other.getPublishDate())) &&

                        (this.getAchievementDesc() == null ? other.getAchievementDesc() == null : this.getAchievementDesc().equals(other.getAchievementDesc())) &&

                        (this.getAchievementLevel() == null ? other.getAchievementLevel() == null : this.getAchievementLevel().equals(other.getAchievementLevel())) &&

                        (this.getAchievementType() == null ? other.getAchievementType() == null : this.getAchievementType().equals(other.getAchievementType())) &&

                        (this.getOwnerContractName() == null ? other.getOwnerContractName() == null : this.getOwnerContractName().equals(other.getOwnerContractName())) &&

                        (this.getOwnerContractId() == null ? other.getOwnerContractId() == null : this.getOwnerContractId().equals(other.getOwnerContractId())) &&

                        (this.getOwnerProjectId() == null ? other.getOwnerProjectId() == null : this.getOwnerProjectId().equals(other.getOwnerProjectId())) &&

                        (this.getOwnerProjectName() == null ? other.getOwnerProjectName() == null : this.getOwnerProjectName().equals(other.getOwnerProjectName())) &&

                        (this.getCompanId() == null ? other.getCompanId() == null : this.getCompanId().equals(other.getCompanId())) &&

                        (this.getCompany() == null ? other.getCompany() == null : this.getCompany().equals(other.getCompany())) &&

                        (this.getBak1() == null ? other.getBak1() == null : this.getBak1().equals(other.getBak1())) &&

                        (this.getBak2() == null ? other.getBak2() == null : this.getBak2().equals(other.getBak2())) &&

                        (this.getBak3() == null ? other.getBak3() == null : this.getBak3().equals(other.getBak3())) &&

                        (this.getBak4() == null ? other.getBak4() == null : this.getBak4().equals(other.getBak4())) &&

                        (this.getBak5() == null ? other.getBak5() == null : this.getBak5().equals(other.getBak5())) &&

                        (this.getBak6() == null ? other.getBak6() == null : this.getBak6().equals(other.getBak6())) &&

                        (this.getSysFlag() == null ? other.getSysFlag() == null : this.getSysFlag().equals(other.getSysFlag())) &&

                        (this.getDataOrder() == null ? other.getDataOrder() == null : this.getDataOrder().equals(other.getDataOrder())) &&

                        (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag())) &&

                        (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate())) &&

                        (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser())) &&

                        (this.getCreateUserDisp() == null ? other.getCreateUserDisp() == null : this.getCreateUserDisp().equals(other.getCreateUserDisp())) &&

                        (this.getModifyDate() == null ? other.getModifyDate() == null : this.getModifyDate().equals(other.getModifyDate())) &&

                        (this.getModifyUser() == null ? other.getModifyUser() == null : this.getModifyUser().equals(other.getModifyUser())) &&

                        (this.getModifyUserDisp() == null ? other.getModifyUserDisp() == null : this.getModifyUserDisp().equals(other.getModifyUserDisp()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataId() == null) ? 0 : getDataId().hashCode());
        result = prime * result + ((getExpertId() == null) ? 0 : getExpertId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getAchievementName() == null) ? 0 : getAchievementName().hashCode());
        result = prime * result + ((getFinishPeople() == null) ? 0 : getFinishPeople().hashCode());
        result = prime * result + ((getIndustryId() == null) ? 0 : getIndustryId().hashCode());
        result = prime * result + ((getIndustryName() == null) ? 0 : getIndustryName().hashCode());
        result = prime * result + ((getAchievementKeys() == null) ? 0 : getAchievementKeys().hashCode());
        result = prime * result + ((getPublishDate() == null) ? 0 : getPublishDate().hashCode());
        result = prime * result + ((getAchievementDesc() == null) ? 0 : getAchievementDesc().hashCode());
        result = prime * result + ((getAchievementLevel() == null) ? 0 : getAchievementLevel().hashCode());
        result = prime * result + ((getAchievementType() == null) ? 0 : getAchievementType().hashCode());
        result = prime * result + ((getOwnerContractName() == null) ? 0 : getOwnerContractName().hashCode());
        result = prime * result + ((getOwnerContractId() == null) ? 0 : getOwnerContractId().hashCode());
        result = prime * result + ((getOwnerProjectId() == null) ? 0 : getOwnerProjectId().hashCode());
        result = prime * result + ((getOwnerProjectName() == null) ? 0 : getOwnerProjectName().hashCode());
        result = prime * result + ((getCompanId() == null) ? 0 : getCompanId().hashCode());
        result = prime * result + ((getCompany() == null) ? 0 : getCompany().hashCode());
        result = prime * result + ((getBak1() == null) ? 0 : getBak1().hashCode());
        result = prime * result + ((getBak2() == null) ? 0 : getBak2().hashCode());
        result = prime * result + ((getBak3() == null) ? 0 : getBak3().hashCode());
        result = prime * result + ((getBak4() == null) ? 0 : getBak4().hashCode());
        result = prime * result + ((getBak5() == null) ? 0 : getBak5().hashCode());
        result = prime * result + ((getBak6() == null) ? 0 : getBak6().hashCode());
        result = prime * result + ((getSysFlag() == null) ? 0 : getSysFlag().hashCode());
        result = prime * result + ((getDataOrder() == null) ? 0 : getDataOrder().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateUserDisp() == null) ? 0 : getCreateUserDisp().hashCode());
        result = prime * result + ((getModifyDate() == null) ? 0 : getModifyDate().hashCode());
        result = prime * result + ((getModifyUser() == null) ? 0 : getModifyUser().hashCode());
        result = prime * result + ((getModifyUserDisp() == null) ? 0 : getModifyUserDisp().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dataId=").append(dataId);
        sb.append(", expertId=").append(expertId);
        sb.append(", userId=").append(userId);
        sb.append(", achievementName=").append(achievementName);
        sb.append(", finishPeople=").append(finishPeople);
        sb.append(", industryId=").append(industryId);
        sb.append(", industryName=").append(industryName);
        sb.append(", achievementKeys=").append(achievementKeys);
        sb.append(", publishDate=").append(publishDate);
        sb.append(", achievementDesc=").append(achievementDesc);
        sb.append(", achievementLevel=").append(achievementLevel);
        sb.append(", achievementType=").append(achievementType);
        sb.append(", ownerContractName=").append(ownerContractName);
        sb.append(", ownerContractId=").append(ownerContractId);
        sb.append(", ownerProjectId=").append(ownerProjectId);
        sb.append(", ownerProjectName=").append(ownerProjectName);
        sb.append(", companId=").append(companId);
        sb.append(", company=").append(company);
        sb.append(", bak1=").append(bak1);
        sb.append(", bak2=").append(bak2);
        sb.append(", bak3=").append(bak3);
        sb.append(", bak4=").append(bak4);
        sb.append(", bak5=").append(bak5);
        sb.append(", bak6=").append(bak6);
        sb.append(", sysFlag=").append(sysFlag);
        sb.append(", dataOrder=").append(dataOrder);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", createDate=").append(createDate);
        sb.append(", createUser=").append(createUser);
        sb.append(", createUserDisp=").append(createUserDisp);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", modifyUser=").append(modifyUser);
        sb.append(", modifyUserDisp=").append(modifyUserDisp);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}