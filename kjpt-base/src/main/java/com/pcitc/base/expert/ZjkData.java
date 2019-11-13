package com.pcitc.base.expert;

import com.pcitc.base.common.DataEntity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * <p>实体类</p>
 * <p>Table: zjk_data - </p>
 *
 * @since 2019-03-16 11:38:42
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ZjkData extends DataEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * age -
     */
    private String age;

    /**
     * expert_name -
     */
    private String expertName;

    /**
     * sex -
     */
    private String sex;

    /**
     * birth_date -
     */
    private String birthDate;

    /**
     * political_face -
     */
    private String politicalFace;

    /**
     * place_origin -
     */
    private String placeOrigin;

    /**
     * nation -
     */
    private String nation;

    /**
     * college -
     */
    private String college;

    /**
     * education -
     */
    private String education;

    /**
     * unit_belongs -
     */
    private String unitBelongs;

    /**
     * professional_and_time -
     */
    private String professionalAndTime;

    /**
     * technical_positiion -
     */
    private String technicalPositiion;

    /**
     * administrative_duties -
     */
    private String administrativeDuties;

    /**
     * mobile -
     */
    private String mobile;

    /**
     * email -
     */
    private String email;

    /**
     * user_desc -
     */
    private String userDesc;

    /**
     * awards_title -
     */
    private String awardsTitle;

    /**
     * brief_desc -
     */
    private String briefDesc;

    /**
     * data_id -
     */
    private String dataId;

    public String getAge() {
        return this.age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getExpertName() {
        return this.expertName;
    }

    public void setExpertName(String expertName) {
        this.expertName = expertName;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPoliticalFace() {
        return this.politicalFace;
    }

    public void setPoliticalFace(String politicalFace) {
        this.politicalFace = politicalFace;
    }

    public String getPlaceOrigin() {
        return this.placeOrigin;
    }

    public void setPlaceOrigin(String placeOrigin) {
        this.placeOrigin = placeOrigin;
    }

    public String getNation() {
        return this.nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getCollege() {
        return this.college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getEducation() {
        return this.education;
    }

    public void setEducation(String education) {
        this.education = education;
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

    public String getTechnicalPositiion() {
        return this.technicalPositiion;
    }

    public void setTechnicalPositiion(String technicalPositiion) {
        this.technicalPositiion = technicalPositiion;
    }

    public String getAdministrativeDuties() {
        return this.administrativeDuties;
    }

    public void setAdministrativeDuties(String administrativeDuties) {
        this.administrativeDuties = administrativeDuties;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserDesc() {
        return this.userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
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

    public String getDataId() {
        return this.dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
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

        ZjkData other = (ZjkData) that;

        return
                (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge())) &&

                        (this.getExpertName() == null ? other.getExpertName() == null : this.getExpertName().equals(other.getExpertName())) &&

                        (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex())) &&

                        (this.getBirthDate() == null ? other.getBirthDate() == null : this.getBirthDate().equals(other.getBirthDate())) &&

                        (this.getPoliticalFace() == null ? other.getPoliticalFace() == null : this.getPoliticalFace().equals(other.getPoliticalFace())) &&

                        (this.getPlaceOrigin() == null ? other.getPlaceOrigin() == null : this.getPlaceOrigin().equals(other.getPlaceOrigin())) &&

                        (this.getNation() == null ? other.getNation() == null : this.getNation().equals(other.getNation())) &&

                        (this.getCollege() == null ? other.getCollege() == null : this.getCollege().equals(other.getCollege())) &&

                        (this.getEducation() == null ? other.getEducation() == null : this.getEducation().equals(other.getEducation())) &&

                        (this.getUnitBelongs() == null ? other.getUnitBelongs() == null : this.getUnitBelongs().equals(other.getUnitBelongs())) &&

                        (this.getProfessionalAndTime() == null ? other.getProfessionalAndTime() == null : this.getProfessionalAndTime().equals(other.getProfessionalAndTime())) &&

                        (this.getTechnicalPositiion() == null ? other.getTechnicalPositiion() == null : this.getTechnicalPositiion().equals(other.getTechnicalPositiion())) &&

                        (this.getAdministrativeDuties() == null ? other.getAdministrativeDuties() == null : this.getAdministrativeDuties().equals(other.getAdministrativeDuties())) &&

                        (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile())) &&

                        (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail())) &&

                        (this.getUserDesc() == null ? other.getUserDesc() == null : this.getUserDesc().equals(other.getUserDesc())) &&

                        (this.getAwardsTitle() == null ? other.getAwardsTitle() == null : this.getAwardsTitle().equals(other.getAwardsTitle())) &&

                        (this.getBriefDesc() == null ? other.getBriefDesc() == null : this.getBriefDesc().equals(other.getBriefDesc())) &&

                        (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getExpertName() == null) ? 0 : getExpertName().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getBirthDate() == null) ? 0 : getBirthDate().hashCode());
        result = prime * result + ((getPoliticalFace() == null) ? 0 : getPoliticalFace().hashCode());
        result = prime * result + ((getPlaceOrigin() == null) ? 0 : getPlaceOrigin().hashCode());
        result = prime * result + ((getNation() == null) ? 0 : getNation().hashCode());
        result = prime * result + ((getCollege() == null) ? 0 : getCollege().hashCode());
        result = prime * result + ((getEducation() == null) ? 0 : getEducation().hashCode());
        result = prime * result + ((getUnitBelongs() == null) ? 0 : getUnitBelongs().hashCode());
        result = prime * result + ((getProfessionalAndTime() == null) ? 0 : getProfessionalAndTime().hashCode());
        result = prime * result + ((getTechnicalPositiion() == null) ? 0 : getTechnicalPositiion().hashCode());
        result = prime * result + ((getAdministrativeDuties() == null) ? 0 : getAdministrativeDuties().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getUserDesc() == null) ? 0 : getUserDesc().hashCode());
        result = prime * result + ((getAwardsTitle() == null) ? 0 : getAwardsTitle().hashCode());
        result = prime * result + ((getBriefDesc() == null) ? 0 : getBriefDesc().hashCode());
        result = prime * result + ((getDataId() == null) ? 0 : getDataId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", age=").append(age);
        sb.append(", expertName=").append(expertName);
        sb.append(", sex=").append(sex);
        sb.append(", birthDate=").append(birthDate);
        sb.append(", politicalFace=").append(politicalFace);
        sb.append(", placeOrigin=").append(placeOrigin);
        sb.append(", nation=").append(nation);
        sb.append(", college=").append(college);
        sb.append(", education=").append(education);
        sb.append(", unitBelongs=").append(unitBelongs);
        sb.append(", professionalAndTime=").append(professionalAndTime);
        sb.append(", technicalPositiion=").append(technicalPositiion);
        sb.append(", administrativeDuties=").append(administrativeDuties);
        sb.append(", mobile=").append(mobile);
        sb.append(", email=").append(email);
        sb.append(", userDesc=").append(userDesc);
        sb.append(", awardsTitle=").append(awardsTitle);
        sb.append(", briefDesc=").append(briefDesc);
        sb.append(", dataId=").append(dataId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}