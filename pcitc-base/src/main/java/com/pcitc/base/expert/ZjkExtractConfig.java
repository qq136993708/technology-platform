package com.pcitc.base.expert;

import com.pcitc.base.common.DataEntity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * <p>实体类</p>
 * <p>Table: zjk_extract_config - 专家抽取逻辑配置</p>
 *
 * @since 2019-01-29 04:04:35
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ZjkExtractConfig extends DataEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * data_id -
     */
    private String dataId;

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

    /**
     * project_stage_id - 项目阶段ID
     */
    private String projectStageId;

    /**
     * project_stage_name - 项目阶段名称
     */
    private String projectStageName;

    /**
     * expert_professional - 专家职称
     */
    private String expertProfessional;

    /**
     * expert_count - 一年内允许被抽取的次数
     */
    private String expertCount;

    /**
     * expert_area - 区域范围
     */
    private String expertArea;

    /**
     * interval_time - 间隔时间
     */
    private String intervalTime;

    /**
     * extract_weight_in - 在职抽取权重
     */
    private String extractWeightIn;

    /**
     * extract_weight_out - 离职抽取权重
     */
    private String extractWeightOut;

    /**
     * company_avoid - 单位回避
     */
    private String companyAvoid;

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

    public String getDataId() {
        return this.dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
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

    public String getProjectStageId() {
        return this.projectStageId;
    }

    public void setProjectStageId(String projectStageId) {
        this.projectStageId = projectStageId;
    }

    public String getProjectStageName() {
        return this.projectStageName;
    }

    public void setProjectStageName(String projectStageName) {
        this.projectStageName = projectStageName;
    }

    public String getExpertProfessional() {
        return this.expertProfessional;
    }

    public void setExpertProfessional(String expertProfessional) {
        this.expertProfessional = expertProfessional;
    }

    public String getExpertCount() {
        return this.expertCount;
    }

    public void setExpertCount(String expertCount) {
        this.expertCount = expertCount;
    }

    public String getExpertArea() {
        return this.expertArea;
    }

    public void setExpertArea(String expertArea) {
        this.expertArea = expertArea;
    }

    public String getIntervalTime() {
        return this.intervalTime;
    }

    public void setIntervalTime(String intervalTime) {
        this.intervalTime = intervalTime;
    }

    public String getExtractWeightIn() {
        return this.extractWeightIn;
    }

    public void setExtractWeightIn(String extractWeightIn) {
        this.extractWeightIn = extractWeightIn;
    }

    public String getExtractWeightOut() {
        return this.extractWeightOut;
    }

    public void setExtractWeightOut(String extractWeightOut) {
        this.extractWeightOut = extractWeightOut;
    }

    public String getCompanyAvoid() {
        return this.companyAvoid;
    }

    public void setCompanyAvoid(String companyAvoid) {
        this.companyAvoid = companyAvoid;
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

        ZjkExtractConfig other = (ZjkExtractConfig) that;

        return
                (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId())) &&

                        (this.getSysFlag() == null ? other.getSysFlag() == null : this.getSysFlag().equals(other.getSysFlag())) &&

                        (this.getDataOrder() == null ? other.getDataOrder() == null : this.getDataOrder().equals(other.getDataOrder())) &&

                        (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag())) &&

                        (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate())) &&

                        (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser())) &&

                        (this.getCreateUserDisp() == null ? other.getCreateUserDisp() == null : this.getCreateUserDisp().equals(other.getCreateUserDisp())) &&

                        (this.getModifyDate() == null ? other.getModifyDate() == null : this.getModifyDate().equals(other.getModifyDate())) &&

                        (this.getModifyUser() == null ? other.getModifyUser() == null : this.getModifyUser().equals(other.getModifyUser())) &&

                        (this.getModifyUserDisp() == null ? other.getModifyUserDisp() == null : this.getModifyUserDisp().equals(other.getModifyUserDisp())) &&

                        (this.getProjectStageId() == null ? other.getProjectStageId() == null : this.getProjectStageId().equals(other.getProjectStageId())) &&

                        (this.getProjectStageName() == null ? other.getProjectStageName() == null : this.getProjectStageName().equals(other.getProjectStageName())) &&

                        (this.getExpertProfessional() == null ? other.getExpertProfessional() == null : this.getExpertProfessional().equals(other.getExpertProfessional())) &&

                        (this.getExpertCount() == null ? other.getExpertCount() == null : this.getExpertCount().equals(other.getExpertCount())) &&

                        (this.getExpertArea() == null ? other.getExpertArea() == null : this.getExpertArea().equals(other.getExpertArea())) &&

                        (this.getIntervalTime() == null ? other.getIntervalTime() == null : this.getIntervalTime().equals(other.getIntervalTime())) &&

                        (this.getExtractWeightIn() == null ? other.getExtractWeightIn() == null : this.getExtractWeightIn().equals(other.getExtractWeightIn())) &&

                        (this.getExtractWeightOut() == null ? other.getExtractWeightOut() == null : this.getExtractWeightOut().equals(other.getExtractWeightOut())) &&

                        (this.getCompanyAvoid() == null ? other.getCompanyAvoid() == null : this.getCompanyAvoid().equals(other.getCompanyAvoid())) &&

                        (this.getBak1() == null ? other.getBak1() == null : this.getBak1().equals(other.getBak1())) &&

                        (this.getBak2() == null ? other.getBak2() == null : this.getBak2().equals(other.getBak2())) &&

                        (this.getBak3() == null ? other.getBak3() == null : this.getBak3().equals(other.getBak3())) &&

                        (this.getBak4() == null ? other.getBak4() == null : this.getBak4().equals(other.getBak4())) &&

                        (this.getBak5() == null ? other.getBak5() == null : this.getBak5().equals(other.getBak5())) &&

                        (this.getBak6() == null ? other.getBak6() == null : this.getBak6().equals(other.getBak6()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataId() == null) ? 0 : getDataId().hashCode());
        result = prime * result + ((getSysFlag() == null) ? 0 : getSysFlag().hashCode());
        result = prime * result + ((getDataOrder() == null) ? 0 : getDataOrder().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateUserDisp() == null) ? 0 : getCreateUserDisp().hashCode());
        result = prime * result + ((getModifyDate() == null) ? 0 : getModifyDate().hashCode());
        result = prime * result + ((getModifyUser() == null) ? 0 : getModifyUser().hashCode());
        result = prime * result + ((getModifyUserDisp() == null) ? 0 : getModifyUserDisp().hashCode());
        result = prime * result + ((getProjectStageId() == null) ? 0 : getProjectStageId().hashCode());
        result = prime * result + ((getProjectStageName() == null) ? 0 : getProjectStageName().hashCode());
        result = prime * result + ((getExpertProfessional() == null) ? 0 : getExpertProfessional().hashCode());
        result = prime * result + ((getExpertCount() == null) ? 0 : getExpertCount().hashCode());
        result = prime * result + ((getExpertArea() == null) ? 0 : getExpertArea().hashCode());
        result = prime * result + ((getIntervalTime() == null) ? 0 : getIntervalTime().hashCode());
        result = prime * result + ((getExtractWeightIn() == null) ? 0 : getExtractWeightIn().hashCode());
        result = prime * result + ((getExtractWeightOut() == null) ? 0 : getExtractWeightOut().hashCode());
        result = prime * result + ((getCompanyAvoid() == null) ? 0 : getCompanyAvoid().hashCode());
        result = prime * result + ((getBak1() == null) ? 0 : getBak1().hashCode());
        result = prime * result + ((getBak2() == null) ? 0 : getBak2().hashCode());
        result = prime * result + ((getBak3() == null) ? 0 : getBak3().hashCode());
        result = prime * result + ((getBak4() == null) ? 0 : getBak4().hashCode());
        result = prime * result + ((getBak5() == null) ? 0 : getBak5().hashCode());
        result = prime * result + ((getBak6() == null) ? 0 : getBak6().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dataId=").append(dataId);
        sb.append(", sysFlag=").append(sysFlag);
        sb.append(", dataOrder=").append(dataOrder);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", createDate=").append(createDate);
        sb.append(", createUser=").append(createUser);
        sb.append(", createUserDisp=").append(createUserDisp);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", modifyUser=").append(modifyUser);
        sb.append(", modifyUserDisp=").append(modifyUserDisp);
        sb.append(", projectStageId=").append(projectStageId);
        sb.append(", projectStageName=").append(projectStageName);
        sb.append(", expertProfessional=").append(expertProfessional);
        sb.append(", expertCount=").append(expertCount);
        sb.append(", expertArea=").append(expertArea);
        sb.append(", intervalTime=").append(intervalTime);
        sb.append(", extractWeightIn=").append(extractWeightIn);
        sb.append(", extractWeightOut=").append(extractWeightOut);
        sb.append(", companyAvoid=").append(companyAvoid);
        sb.append(", bak1=").append(bak1);
        sb.append(", bak2=").append(bak2);
        sb.append(", bak3=").append(bak3);
        sb.append(", bak4=").append(bak4);
        sb.append(", bak5=").append(bak5);
        sb.append(", bak6=").append(bak6);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}