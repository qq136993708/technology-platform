package com.pcitc.base.out;

import java.io.Serializable;
import java.util.Date;

/**
 * out_person
 * @author 
 */
public class OutPerson implements Serializable {
    private String id;

    /**
     * 性别
     */
    private String sex;

    /**
     * 名称
     */
    private String name;

    /**
     * 生出年(yyyy)
     */
    private String birthYear;

    /**
     * 学历(字典)
     */
    private String education;

    /**
     * 所在单位名称
     */
    private String belongUnitName;

    /**
     * 所在单位ID
     */
    private String belongUnitId;

    /**
     * 技术族领域（多选）
     */
    private String techType;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 技术领域名称
     */
    private String techTypeName;

    /**
     * 身份证号码
     */
    private String idCard;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 联系方式
     */
    private String contactWay;

    /**
     * 工作经历
     */
    private String workExperience;
    
    private String post;
    private String title;
    
    
    


    public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getBelongUnitName() {
        return belongUnitName;
    }

    public void setBelongUnitName(String belongUnitName) {
        this.belongUnitName = belongUnitName;
    }

    public String getBelongUnitId() {
        return belongUnitId;
    }

    public void setBelongUnitId(String belongUnitId) {
        this.belongUnitId = belongUnitId;
    }

    public String getTechType() {
        return techType;
    }

    public void setTechType(String techType) {
        this.techType = techType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getTechTypeName() {
        return techTypeName;
    }

    public void setTechTypeName(String techTypeName) {
        this.techTypeName = techTypeName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactWay() {
        return contactWay;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }
}