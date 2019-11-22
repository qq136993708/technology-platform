package com.pcitc.base.researchplatform;


import com.pcitc.base.common.RecordModel;

/**
 * <p>平台成员</p>
 * <p>Table: kypt_member - 科研平台-成员</p>
 * @author ty
 */
public class PlatformMemberModel extends RecordModel {

    private static final long serialVersionUID = 1L;
    /**
     * 数据主键
     */
    private String id;
    /**
     * 科研平台项目ID,外键
     */
    private String platformId;
    /**
     * 项目人员表的人员主键ID,外键
     */
    private String baseId;
    /**
     * 名称
     */
    private String name;
    /**
     * 出生年月
     */
    private String birth;
    /**
     * 学历
     */
    private String education;
    /**
     * 技术职称
     */
    private String technicalTitle;
    /**
     * 毕业院校
     */
    private String graduateSchool;
    /**
     * 所学专业
     */
    private String majorStudied;
    /**
     * 岗位名称
     */
    private String postName;
    /**
     * 担任职务
     */
    private String assumeOffice;
    /**
     * 工作单位
     */
    private String workUnit;
    /**
     * 角色
     */
    private String role;

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getBaseId() {
        return baseId;
    }

    public void setBaseId(String baseId) {
        this.baseId = baseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getTechnicalTitle() {
        return technicalTitle;
    }

    public void setTechnicalTitle(String technicalTitle) {
        this.technicalTitle = technicalTitle;
    }

    public String getGraduateSchool() {
        return graduateSchool;
    }

    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool;
    }

    public String getMajorStudied() {
        return majorStudied;
    }

    public void setMajorStudied(String majorStudied) {
        this.majorStudied = majorStudied;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getAssumeOffice() {
        return assumeOffice;
    }

    public void setAssumeOffice(String assumeOffice) {
        this.assumeOffice = assumeOffice;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
