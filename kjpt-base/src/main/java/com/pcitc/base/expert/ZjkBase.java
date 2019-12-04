package com.pcitc.base.expert;

import java.io.Serializable;
import java.util.Date;

/**
 * zjk_base
 * @author 
 */
public class ZjkBase  {
    private String id="";

    /**
     * 删除状态（0未删除，1删除）
     */
    private String delStatus="";
    private String delStatusStr;

    /**
     * 专家编号
     */
    private String num="";

    /**
     * 人事系统编号
     */
    private String personnelNum="";

    /**
     * 数据来源（1本系统，2外系统）
     */
    private String sourceType="";

    /**
     * 姓名
     */
    private String name="";

    /**
     * 性别
     */
    private String sex="1";
    private String sexStr;

    /**
     * 年龄
     */
    private Integer age=0;

    /**
     * 身份证号码
     */
    private String idCardNo="";

    /**
     * 学历
     */
    private String education="";
    private String educationStr;

    /**
     * 技术领域
     */
    private String technicalField="";
    private String technicalFieldStr;

    /**
     * 所在单位
     */
    private String belongUnit="";
    private String belongUnitStr;

    /**
     * 职称
     */
    private String title="";
    private String titleStr;

    /**
     * 职务
     */
    private String post="";

    /**
     * 工作经历
     */
    private String workExperience="";

    /**
     * 联系方式
     */
    private String contactWay="";

    /**
     * 邮箱
     */
    private String email="";

    /**
     * 人物简介
     */
    private String brief="";

    /**
     * 人物成就
     */
    private String achievement="";

    /**
     * 头像
     */
    private String headPic="";

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createUser="";

    /**
     * 修改时间
     */
    private Date updateTime=new Date();

    /**
     * 修改人
     */
    private String updateUser="";

    /**
     * 外系统ID
     */
    private String outSystemId="";
    
    
    /**
              * 启用状态（1启用，0未启用）
     */
    private String useStatus="";
    private String useStatusStr;
    
    private String zjkAchievementJsonList;
    private String zjkPatentJsonList;
    private String zjkProjectJsonList;
    private String zjkRewardJsonList;
    private String technicalFieldName="";
    private String technicalFieldIndex="";
    //专家分组
    private String groupType="";
    private String groupTypeStr="";
    private String auditStatus="";
    
    
    
	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getGroupType() {
		return groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	public String getGroupTypeStr() {
		return groupTypeStr;
	}

	public void setGroupTypeStr(String groupTypeStr) {
		this.groupTypeStr = groupTypeStr;
	}

	public String getTechnicalFieldIndex() {
		return technicalFieldIndex;
	}

	public void setTechnicalFieldIndex(String technicalFieldIndex) {
		this.technicalFieldIndex = technicalFieldIndex;
	}

	public String getTechnicalFieldName() {
		return technicalFieldName;
	}

	public void setTechnicalFieldName(String technicalFieldName) {
		this.technicalFieldName = technicalFieldName;
	}

	public String getDelStatusStr() {
		return delStatusStr;
	}

	public void setDelStatusStr(String delStatusStr) {
		this.delStatusStr = delStatusStr;
	}

	public String getSexStr() {
		return sexStr;
	}

	public void setSexStr(String sexStr) {
		this.sexStr = sexStr;
	}

	public String getEducationStr() {
		return educationStr;
	}

	public void setEducationStr(String educationStr) {
		this.educationStr = educationStr;
	}

	public String getTechnicalFieldStr() {
		return technicalFieldStr;
	}

	public void setTechnicalFieldStr(String technicalFieldStr) {
		this.technicalFieldStr = technicalFieldStr;
	}

	public String getBelongUnitStr() {
		return belongUnitStr;
	}

	public void setBelongUnitStr(String belongUnitStr) {
		this.belongUnitStr = belongUnitStr;
	}

	public String getTitleStr() {
		return titleStr;
	}

	public void setTitleStr(String titleStr) {
		this.titleStr = titleStr;
	}

	public String getUseStatusStr() {
		return useStatusStr;
	}

	public void setUseStatusStr(String useStatusStr) {
		this.useStatusStr = useStatusStr;
	}

	public String getZjkAchievementJsonList() {
		return zjkAchievementJsonList;
	}

	public void setZjkAchievementJsonList(String zjkAchievementJsonList) {
		this.zjkAchievementJsonList = zjkAchievementJsonList;
	}

	public String getZjkPatentJsonList() {
		return zjkPatentJsonList;
	}

	public void setZjkPatentJsonList(String zjkPatentJsonList) {
		this.zjkPatentJsonList = zjkPatentJsonList;
	}

	public String getZjkProjectJsonList() {
		return zjkProjectJsonList;
	}

	public void setZjkProjectJsonList(String zjkProjectJsonList) {
		this.zjkProjectJsonList = zjkProjectJsonList;
	}

	public String getZjkRewardJsonList() {
		return zjkRewardJsonList;
	}

	public void setZjkRewardJsonList(String zjkRewardJsonList) {
		this.zjkRewardJsonList = zjkRewardJsonList;
	}

	public String getUseStatus() {
		return useStatus;
	}

	public void setUseStatus(String useStatus) {
		this.useStatus = useStatus;
	}


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(String delStatus) {
        this.delStatus = delStatus;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPersonnelNum() {
        return personnelNum;
    }

    public void setPersonnelNum(String personnelNum) {
        this.personnelNum = personnelNum;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getTechnicalField() {
        return technicalField;
    }

    public void setTechnicalField(String technicalField) {
        this.technicalField = technicalField;
    }

    public String getBelongUnit() {
        return belongUnit;
    }

    public void setBelongUnit(String belongUnit) {
        this.belongUnit = belongUnit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public String getContactWay() {
        return contactWay;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getOutSystemId() {
        return outSystemId;
    }

    public void setOutSystemId(String outSystemId) {
        this.outSystemId = outSystemId;
    }
}