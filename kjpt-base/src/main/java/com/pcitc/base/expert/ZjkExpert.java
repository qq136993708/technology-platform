package com.pcitc.base.expert;

import com.pcitc.base.common.DataEntity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.beans.Transient;
import java.io.Serializable;

/**
 * <p>实体类</p>
 * <p>Table: zjk_expert - 专家-基本信息</p>
 *
 * @since 2019-04-02 03:48:48
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ZjkExpert extends DataEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Transient
    public String getSelect_type() {
        return select_type;
    }

    public void setSelect_type(String select_type) {
        this.select_type = select_type;
    }

    private String select_type;

    /**
     * data_id -
     */
    private String dataId;

    /**
     * expert_name - 姓名
     */
    private String expertName;

    /**
     * email - 邮箱
     */
    private String email;

    /**
     * company_name - 机构名称
     */
    private String companyName;

    /**
     * company - 机构ID
     */
    private String company;

    /**
     * user_desc - 简介
     */
    private String userDesc;

    /**
     * expert_professinal - 职称
     */
    private String expertProfessinal;

    /**
     * age_between - 年龄段
     */
    private String ageBetween;

    /**
     * age - 年龄
     */
    private String age;

    /**
     * birth_date - 出生日期
     */
    private String birthDate;

    /**
     * industry_name - 行业领域名称
     */
    private String industryName;

    /**
     * industry_id - 行业领域
     */
    private String industryId;

    /**
     * address - 居住地地址
     */
    private String address;

    /**
     * college - 毕业院校
     */
    private String college;

    /**
     * province - 省
     */
    private String province;

    /**
     * city - 市
     */
    private String city;

    /**
     * county - 县
     */
    private String county;

    /**
     * amount_count - 参与金额数量
     */
    private String amountCount;

    /**
     * patent_count - 专利数量
     */
    private String patentCount;

    /**
     * project_count - 参与项目数量
     */
    private String projectCount;

    /**
     * company_count - 参与机构数量
     */
    private String companyCount;

    /**
     * achievement_count - 成果数量
     */
    private String achievementCount;

    /**
     * bak1 -
     */
    private String bak1;

    /**
     * bak2 -
     */
    private String bak2;

    /**
     * bak3 - 专家等级(根据导入专家类型区分)1,技术领军人物,2首席专家,3高级专家
     */
    private String bak3;

    /**
     * bak4 - 人员编号
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
     * user_id - 用户ID
     */
    private String userId;

    /**
     * mobile - 手机
     */
    private String mobile;

    /**
     * expert_professional_field - 专业领域
     */
    private String expertProfessionalField;

    /**
     * expert_professional_field_name - 专业领域名称
     */
    private String expertProfessionalFieldName;

    /**
     * source - 来源
     */
    private String source;

    /**
     * source_id - 来源ID
     */
    private String sourceId;

    /**
     * sex - 性别
     */
    private String sex;

    /**
     * card_id - 证件号码
     */
    private String cardId;

    /**
     * card_type - 证件类型
     */
    private String cardType;

    /**
     * education - 学历
     */
    private String education;

    /**
     * header_img - 专家头像
     */
    private String headerImg;

    /**
     * join_project_name - 参与项目名称
     */
    private String joinProjectName;

    /**
     * join_project_id - 参与项目ID
     */
    private String joinProjectId;

    /**
     * expert_nationality - 国籍
     */
    private String expertNationality;

    /**
     * sys_flag - 0：正常；1：冻结
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
     * form_code - 业务编码
     */
    private String formCode;

    /**
     * data_index - 序号
     */
    private String dataIndex;

    /**
     * status - 是否删除
     */
    private String status;

    /**
     * audit_status - 审批状态
     */
    private String auditStatus;

    /**
     * company_code - 公司代码
     */
    private String companyCode;

    /**
     * update_user - 修改人
     */
    private String updateUser;

    /**
     * update_date - 修改时间
     */
    private String updateDate;

    /**
     * project_id - 所属项目
     */
    private String projectId;

    /**
     * project_name - 项目名称
     */
    private String projectName;

    /**
     * year - 年度
     */
    private String year;

    /**
     * political_face - 政治面貌
     */
    private String politicalFace;

    /**
     * nation - 民族
     */
    private String nation;

    /**
     * unit_belongs - 所属单位
     */
    private String unitBelongs;

    /**
     * professional_and_time - 从事专业和时间
     */
    private String professionalAndTime;

    /**
     * administrative_duties - 行政职务
     */
    private String administrativeDuties;

    /**
     * technical_positiion - 专业技术职务
     */
    private String technicalPositiion;

    /**
     * awards_title - 获得奖励和称号
     */
    private String awardsTitle;

    /**
     * brief_desc - 主要业绩简述
     */
    private String briefDesc;

    /**
     * place_origin - 籍贯
     */
    private String placeOrigin;

    /**
     * team_view - 团队突破
     */
    private String teamView;

    /**
     * bak7 -
     */
    private String bak7;

    /**
     * bak8 -
     */
    private String bak8;

    /**
     * bak9 -
     */
    private String bak9;

    /**
     * bak10 -
     */
    private String bak10;
    
    
    private String key;
    
    

    public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getDataId() {
        return this.dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getExpertName() {
        return this.expertName;
    }

    public void setExpertName(String expertName) {
        this.expertName = expertName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getUserDesc() {
        return this.userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }

    public String getExpertProfessinal() {
        return this.expertProfessinal;
    }

    public void setExpertProfessinal(String expertProfessinal) {
        this.expertProfessinal = expertProfessinal;
    }

    public String getAgeBetween() {
        return this.ageBetween;
    }

    public void setAgeBetween(String ageBetween) {
        this.ageBetween = ageBetween;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getIndustryName() {
        return this.industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public String getIndustryId() {
        return this.industryId;
    }

    public void setIndustryId(String industryId) {
        this.industryId = industryId;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCollege() {
        return this.college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return this.county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getAmountCount() {
        return this.amountCount;
    }

    public void setAmountCount(String amountCount) {
        this.amountCount = amountCount;
    }

    public String getPatentCount() {
        return this.patentCount;
    }

    public void setPatentCount(String patentCount) {
        this.patentCount = patentCount;
    }

    public String getProjectCount() {
        return this.projectCount;
    }

    public void setProjectCount(String projectCount) {
        this.projectCount = projectCount;
    }

    public String getCompanyCount() {
        return this.companyCount;
    }

    public void setCompanyCount(String companyCount) {
        this.companyCount = companyCount;
    }

    public String getAchievementCount() {
        return this.achievementCount;
    }

    public void setAchievementCount(String achievementCount) {
        this.achievementCount = achievementCount;
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

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getExpertProfessionalField() {
        return this.expertProfessionalField;
    }

    public void setExpertProfessionalField(String expertProfessionalField) {
        this.expertProfessionalField = expertProfessionalField;
    }

    public String getExpertProfessionalFieldName() {
        return this.expertProfessionalFieldName;
    }

    public void setExpertProfessionalFieldName(String expertProfessionalFieldName) {
        this.expertProfessionalFieldName = expertProfessionalFieldName;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCardId() {
        return this.cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCardType() {
        return this.cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getEducation() {
        return this.education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getHeaderImg() {
        return this.headerImg;
    }

    public void setHeaderImg(String headerImg) {
        this.headerImg = headerImg;
    }

    public String getJoinProjectName() {
        return this.joinProjectName;
    }

    public void setJoinProjectName(String joinProjectName) {
        this.joinProjectName = joinProjectName;
    }

    public String getJoinProjectId() {
        return this.joinProjectId;
    }

    public void setJoinProjectId(String joinProjectId) {
        this.joinProjectId = joinProjectId;
    }

    public String getExpertNationality() {
        return this.expertNationality;
    }

    public void setExpertNationality(String expertNationality) {
        this.expertNationality = expertNationality;
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

    public String getFormCode() {
        return this.formCode;
    }

    public void setFormCode(String formCode) {
        this.formCode = formCode;
    }

    public String getDataIndex() {
        return this.dataIndex;
    }

    public void setDataIndex(String dataIndex) {
        this.dataIndex = dataIndex;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAuditStatus() {
        return this.auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getCompanyCode() {
        return this.companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getUpdateUser() {
        return this.updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getProjectId() {
        return this.projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getYear() {
        return this.year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPoliticalFace() {
        return this.politicalFace;
    }

    public void setPoliticalFace(String politicalFace) {
        this.politicalFace = politicalFace;
    }

    public String getNation() {
        return this.nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getUnitBelongs() {
        return this.unitBelongs;
    }

    public void setUnitBelongs(String unitBelongs) {
        this.unitBelongs = unitBelongs;
    }

    public String getProfessionalAndTime() {
        return this.professionalAndTime;
    }

    public void setProfessionalAndTime(String professionalAndTime) {
        this.professionalAndTime = professionalAndTime;
    }

    public String getAdministrativeDuties() {
        return this.administrativeDuties;
    }

    public void setAdministrativeDuties(String administrativeDuties) {
        this.administrativeDuties = administrativeDuties;
    }

    public String getTechnicalPositiion() {
        return this.technicalPositiion;
    }

    public void setTechnicalPositiion(String technicalPositiion) {
        this.technicalPositiion = technicalPositiion;
    }

    public String getAwardsTitle() {
        return this.awardsTitle;
    }

    public void setAwardsTitle(String awardsTitle) {
        this.awardsTitle = awardsTitle;
    }

    public String getBriefDesc() {
        return this.briefDesc;
    }

    public void setBriefDesc(String briefDesc) {
        this.briefDesc = briefDesc;
    }

    public String getPlaceOrigin() {
        return this.placeOrigin;
    }

    public void setPlaceOrigin(String placeOrigin) {
        this.placeOrigin = placeOrigin;
    }

    public String getTeamView() {
        return this.teamView;
    }

    public void setTeamView(String teamView) {
        this.teamView = teamView;
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

        ZjkExpert other = (ZjkExpert) that;

        return
                (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId())) &&

                        (this.getExpertName() == null ? other.getExpertName() == null : this.getExpertName().equals(other.getExpertName())) &&

                        (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail())) &&

                        (this.getCompanyName() == null ? other.getCompanyName() == null : this.getCompanyName().equals(other.getCompanyName())) &&

                        (this.getCompany() == null ? other.getCompany() == null : this.getCompany().equals(other.getCompany())) &&

                        (this.getUserDesc() == null ? other.getUserDesc() == null : this.getUserDesc().equals(other.getUserDesc())) &&

                        (this.getExpertProfessinal() == null ? other.getExpertProfessinal() == null : this.getExpertProfessinal().equals(other.getExpertProfessinal())) &&

                        (this.getAgeBetween() == null ? other.getAgeBetween() == null : this.getAgeBetween().equals(other.getAgeBetween())) &&

                        (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge())) &&

                        (this.getBirthDate() == null ? other.getBirthDate() == null : this.getBirthDate().equals(other.getBirthDate())) &&

                        (this.getIndustryName() == null ? other.getIndustryName() == null : this.getIndustryName().equals(other.getIndustryName())) &&

                        (this.getIndustryId() == null ? other.getIndustryId() == null : this.getIndustryId().equals(other.getIndustryId())) &&

                        (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress())) &&

                        (this.getCollege() == null ? other.getCollege() == null : this.getCollege().equals(other.getCollege())) &&

                        (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince())) &&

                        (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity())) &&

                        (this.getCounty() == null ? other.getCounty() == null : this.getCounty().equals(other.getCounty())) &&

                        (this.getAmountCount() == null ? other.getAmountCount() == null : this.getAmountCount().equals(other.getAmountCount())) &&

                        (this.getPatentCount() == null ? other.getPatentCount() == null : this.getPatentCount().equals(other.getPatentCount())) &&

                        (this.getProjectCount() == null ? other.getProjectCount() == null : this.getProjectCount().equals(other.getProjectCount())) &&

                        (this.getCompanyCount() == null ? other.getCompanyCount() == null : this.getCompanyCount().equals(other.getCompanyCount())) &&

                        (this.getAchievementCount() == null ? other.getAchievementCount() == null : this.getAchievementCount().equals(other.getAchievementCount())) &&

                        (this.getBak1() == null ? other.getBak1() == null : this.getBak1().equals(other.getBak1())) &&

                        (this.getBak2() == null ? other.getBak2() == null : this.getBak2().equals(other.getBak2())) &&

                        (this.getBak3() == null ? other.getBak3() == null : this.getBak3().equals(other.getBak3())) &&

                        (this.getBak4() == null ? other.getBak4() == null : this.getBak4().equals(other.getBak4())) &&

                        (this.getBak5() == null ? other.getBak5() == null : this.getBak5().equals(other.getBak5())) &&

                        (this.getBak6() == null ? other.getBak6() == null : this.getBak6().equals(other.getBak6())) &&

                        (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId())) &&

                        (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile())) &&

                        (this.getExpertProfessionalField() == null ? other.getExpertProfessionalField() == null : this.getExpertProfessionalField().equals(other.getExpertProfessionalField())) &&

                        (this.getExpertProfessionalFieldName() == null ? other.getExpertProfessionalFieldName() == null : this.getExpertProfessionalFieldName().equals(other.getExpertProfessionalFieldName())) &&

                        (this.getSource() == null ? other.getSource() == null : this.getSource().equals(other.getSource())) &&

                        (this.getSourceId() == null ? other.getSourceId() == null : this.getSourceId().equals(other.getSourceId())) &&

                        (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex())) &&

                        (this.getCardId() == null ? other.getCardId() == null : this.getCardId().equals(other.getCardId())) &&

                        (this.getCardType() == null ? other.getCardType() == null : this.getCardType().equals(other.getCardType())) &&

                        (this.getEducation() == null ? other.getEducation() == null : this.getEducation().equals(other.getEducation())) &&

                        (this.getHeaderImg() == null ? other.getHeaderImg() == null : this.getHeaderImg().equals(other.getHeaderImg())) &&

                        (this.getJoinProjectName() == null ? other.getJoinProjectName() == null : this.getJoinProjectName().equals(other.getJoinProjectName())) &&

                        (this.getJoinProjectId() == null ? other.getJoinProjectId() == null : this.getJoinProjectId().equals(other.getJoinProjectId())) &&

                        (this.getExpertNationality() == null ? other.getExpertNationality() == null : this.getExpertNationality().equals(other.getExpertNationality())) &&

                        (this.getSysFlag() == null ? other.getSysFlag() == null : this.getSysFlag().equals(other.getSysFlag())) &&

                        (this.getDataOrder() == null ? other.getDataOrder() == null : this.getDataOrder().equals(other.getDataOrder())) &&

                        (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag())) &&

                        (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate())) &&

                        (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser())) &&

                        (this.getCreateUserDisp() == null ? other.getCreateUserDisp() == null : this.getCreateUserDisp().equals(other.getCreateUserDisp())) &&

                        (this.getModifyDate() == null ? other.getModifyDate() == null : this.getModifyDate().equals(other.getModifyDate())) &&

                        (this.getModifyUser() == null ? other.getModifyUser() == null : this.getModifyUser().equals(other.getModifyUser())) &&

                        (this.getModifyUserDisp() == null ? other.getModifyUserDisp() == null : this.getModifyUserDisp().equals(other.getModifyUserDisp())) &&

                        (this.getFormCode() == null ? other.getFormCode() == null : this.getFormCode().equals(other.getFormCode())) &&

                        (this.getDataIndex() == null ? other.getDataIndex() == null : this.getDataIndex().equals(other.getDataIndex())) &&

                        (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus())) &&

                        (this.getAuditStatus() == null ? other.getAuditStatus() == null : this.getAuditStatus().equals(other.getAuditStatus())) &&

                        (this.getCompanyCode() == null ? other.getCompanyCode() == null : this.getCompanyCode().equals(other.getCompanyCode())) &&

                        (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser())) &&

                        (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate())) &&

                        (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId())) &&

                        (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName())) &&

                        (this.getYear() == null ? other.getYear() == null : this.getYear().equals(other.getYear())) &&

                        (this.getPoliticalFace() == null ? other.getPoliticalFace() == null : this.getPoliticalFace().equals(other.getPoliticalFace())) &&

                        (this.getNation() == null ? other.getNation() == null : this.getNation().equals(other.getNation())) &&

                        (this.getUnitBelongs() == null ? other.getUnitBelongs() == null : this.getUnitBelongs().equals(other.getUnitBelongs())) &&

                        (this.getProfessionalAndTime() == null ? other.getProfessionalAndTime() == null : this.getProfessionalAndTime().equals(other.getProfessionalAndTime())) &&

                        (this.getAdministrativeDuties() == null ? other.getAdministrativeDuties() == null : this.getAdministrativeDuties().equals(other.getAdministrativeDuties())) &&

                        (this.getTechnicalPositiion() == null ? other.getTechnicalPositiion() == null : this.getTechnicalPositiion().equals(other.getTechnicalPositiion())) &&

                        (this.getAwardsTitle() == null ? other.getAwardsTitle() == null : this.getAwardsTitle().equals(other.getAwardsTitle())) &&

                        (this.getBriefDesc() == null ? other.getBriefDesc() == null : this.getBriefDesc().equals(other.getBriefDesc())) &&

                        (this.getPlaceOrigin() == null ? other.getPlaceOrigin() == null : this.getPlaceOrigin().equals(other.getPlaceOrigin())) &&

                        (this.getTeamView() == null ? other.getTeamView() == null : this.getTeamView().equals(other.getTeamView())) &&

                        (this.getBak7() == null ? other.getBak7() == null : this.getBak7().equals(other.getBak7())) &&

                        (this.getBak8() == null ? other.getBak8() == null : this.getBak8().equals(other.getBak8())) &&

                        (this.getBak9() == null ? other.getBak9() == null : this.getBak9().equals(other.getBak9())) &&

                        (this.getBak10() == null ? other.getBak10() == null : this.getBak10().equals(other.getBak10()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataId() == null) ? 0 : getDataId().hashCode());
        result = prime * result + ((getExpertName() == null) ? 0 : getExpertName().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getCompanyName() == null) ? 0 : getCompanyName().hashCode());
        result = prime * result + ((getCompany() == null) ? 0 : getCompany().hashCode());
        result = prime * result + ((getUserDesc() == null) ? 0 : getUserDesc().hashCode());
        result = prime * result + ((getExpertProfessinal() == null) ? 0 : getExpertProfessinal().hashCode());
        result = prime * result + ((getAgeBetween() == null) ? 0 : getAgeBetween().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getBirthDate() == null) ? 0 : getBirthDate().hashCode());
        result = prime * result + ((getIndustryName() == null) ? 0 : getIndustryName().hashCode());
        result = prime * result + ((getIndustryId() == null) ? 0 : getIndustryId().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getCollege() == null) ? 0 : getCollege().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getCounty() == null) ? 0 : getCounty().hashCode());
        result = prime * result + ((getAmountCount() == null) ? 0 : getAmountCount().hashCode());
        result = prime * result + ((getPatentCount() == null) ? 0 : getPatentCount().hashCode());
        result = prime * result + ((getProjectCount() == null) ? 0 : getProjectCount().hashCode());
        result = prime * result + ((getCompanyCount() == null) ? 0 : getCompanyCount().hashCode());
        result = prime * result + ((getAchievementCount() == null) ? 0 : getAchievementCount().hashCode());
        result = prime * result + ((getBak1() == null) ? 0 : getBak1().hashCode());
        result = prime * result + ((getBak2() == null) ? 0 : getBak2().hashCode());
        result = prime * result + ((getBak3() == null) ? 0 : getBak3().hashCode());
        result = prime * result + ((getBak4() == null) ? 0 : getBak4().hashCode());
        result = prime * result + ((getBak5() == null) ? 0 : getBak5().hashCode());
        result = prime * result + ((getBak6() == null) ? 0 : getBak6().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getExpertProfessionalField() == null) ? 0 : getExpertProfessionalField().hashCode());
        result = prime * result + ((getExpertProfessionalFieldName() == null) ? 0 : getExpertProfessionalFieldName().hashCode());
        result = prime * result + ((getSource() == null) ? 0 : getSource().hashCode());
        result = prime * result + ((getSourceId() == null) ? 0 : getSourceId().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getCardId() == null) ? 0 : getCardId().hashCode());
        result = prime * result + ((getCardType() == null) ? 0 : getCardType().hashCode());
        result = prime * result + ((getEducation() == null) ? 0 : getEducation().hashCode());
        result = prime * result + ((getHeaderImg() == null) ? 0 : getHeaderImg().hashCode());
        result = prime * result + ((getJoinProjectName() == null) ? 0 : getJoinProjectName().hashCode());
        result = prime * result + ((getJoinProjectId() == null) ? 0 : getJoinProjectId().hashCode());
        result = prime * result + ((getExpertNationality() == null) ? 0 : getExpertNationality().hashCode());
        result = prime * result + ((getSysFlag() == null) ? 0 : getSysFlag().hashCode());
        result = prime * result + ((getDataOrder() == null) ? 0 : getDataOrder().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateUserDisp() == null) ? 0 : getCreateUserDisp().hashCode());
        result = prime * result + ((getModifyDate() == null) ? 0 : getModifyDate().hashCode());
        result = prime * result + ((getModifyUser() == null) ? 0 : getModifyUser().hashCode());
        result = prime * result + ((getModifyUserDisp() == null) ? 0 : getModifyUserDisp().hashCode());
        result = prime * result + ((getFormCode() == null) ? 0 : getFormCode().hashCode());
        result = prime * result + ((getDataIndex() == null) ? 0 : getDataIndex().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAuditStatus() == null) ? 0 : getAuditStatus().hashCode());
        result = prime * result + ((getCompanyCode() == null) ? 0 : getCompanyCode().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getYear() == null) ? 0 : getYear().hashCode());
        result = prime * result + ((getPoliticalFace() == null) ? 0 : getPoliticalFace().hashCode());
        result = prime * result + ((getNation() == null) ? 0 : getNation().hashCode());
        result = prime * result + ((getUnitBelongs() == null) ? 0 : getUnitBelongs().hashCode());
        result = prime * result + ((getProfessionalAndTime() == null) ? 0 : getProfessionalAndTime().hashCode());
        result = prime * result + ((getAdministrativeDuties() == null) ? 0 : getAdministrativeDuties().hashCode());
        result = prime * result + ((getTechnicalPositiion() == null) ? 0 : getTechnicalPositiion().hashCode());
        result = prime * result + ((getAwardsTitle() == null) ? 0 : getAwardsTitle().hashCode());
        result = prime * result + ((getBriefDesc() == null) ? 0 : getBriefDesc().hashCode());
        result = prime * result + ((getPlaceOrigin() == null) ? 0 : getPlaceOrigin().hashCode());
        result = prime * result + ((getTeamView() == null) ? 0 : getTeamView().hashCode());
        result = prime * result + ((getBak7() == null) ? 0 : getBak7().hashCode());
        result = prime * result + ((getBak8() == null) ? 0 : getBak8().hashCode());
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
        sb.append(", dataId=").append(dataId);
        sb.append(", expertName=").append(expertName);
        sb.append(", email=").append(email);
        sb.append(", companyName=").append(companyName);
        sb.append(", company=").append(company);
        sb.append(", userDesc=").append(userDesc);
        sb.append(", expertProfessinal=").append(expertProfessinal);
        sb.append(", ageBetween=").append(ageBetween);
        sb.append(", age=").append(age);
        sb.append(", birthDate=").append(birthDate);
        sb.append(", industryName=").append(industryName);
        sb.append(", industryId=").append(industryId);
        sb.append(", address=").append(address);
        sb.append(", college=").append(college);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", county=").append(county);
        sb.append(", amountCount=").append(amountCount);
        sb.append(", patentCount=").append(patentCount);
        sb.append(", projectCount=").append(projectCount);
        sb.append(", companyCount=").append(companyCount);
        sb.append(", achievementCount=").append(achievementCount);
        sb.append(", bak1=").append(bak1);
        sb.append(", bak2=").append(bak2);
        sb.append(", bak3=").append(bak3);
        sb.append(", bak4=").append(bak4);
        sb.append(", bak5=").append(bak5);
        sb.append(", bak6=").append(bak6);
        sb.append(", userId=").append(userId);
        sb.append(", mobile=").append(mobile);
        sb.append(", expertProfessionalField=").append(expertProfessionalField);
        sb.append(", expertProfessionalFieldName=").append(expertProfessionalFieldName);
        sb.append(", source=").append(source);
        sb.append(", sourceId=").append(sourceId);
        sb.append(", sex=").append(sex);
        sb.append(", cardId=").append(cardId);
        sb.append(", cardType=").append(cardType);
        sb.append(", education=").append(education);
        sb.append(", headerImg=").append(headerImg);
        sb.append(", joinProjectName=").append(joinProjectName);
        sb.append(", joinProjectId=").append(joinProjectId);
        sb.append(", expertNationality=").append(expertNationality);
        sb.append(", sysFlag=").append(sysFlag);
        sb.append(", dataOrder=").append(dataOrder);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", createDate=").append(createDate);
        sb.append(", createUser=").append(createUser);
        sb.append(", createUserDisp=").append(createUserDisp);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", modifyUser=").append(modifyUser);
        sb.append(", modifyUserDisp=").append(modifyUserDisp);
        sb.append(", formCode=").append(formCode);
        sb.append(", dataIndex=").append(dataIndex);
        sb.append(", status=").append(status);
        sb.append(", auditStatus=").append(auditStatus);
        sb.append(", companyCode=").append(companyCode);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", projectId=").append(projectId);
        sb.append(", projectName=").append(projectName);
        sb.append(", year=").append(year);
        sb.append(", politicalFace=").append(politicalFace);
        sb.append(", nation=").append(nation);
        sb.append(", unitBelongs=").append(unitBelongs);
        sb.append(", professionalAndTime=").append(professionalAndTime);
        sb.append(", administrativeDuties=").append(administrativeDuties);
        sb.append(", technicalPositiion=").append(technicalPositiion);
        sb.append(", awardsTitle=").append(awardsTitle);
        sb.append(", briefDesc=").append(briefDesc);
        sb.append(", placeOrigin=").append(placeOrigin);
        sb.append(", teamView=").append(teamView);
        sb.append(", bak7=").append(bak7);
        sb.append(", bak8=").append(bak8);
        sb.append(", bak9=").append(bak9);
        sb.append(", bak10=").append(bak10);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}