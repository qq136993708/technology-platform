package com.pcitc.base.out;

import java.io.Serializable;
import java.util.Date;

/**
 * out_project
 * @author 
 */
public class OutProject implements Serializable {
    private String id;

    private String setupYear;

    /**
     * 项目周期
     */
    private String projectCycle;

    /**
     * 项目类型
     */
    private String projectType;

    /**
     * 项目名称
     */
    private String projectName;

    private Date createTime;

    /**
     * 技术分类
     */
    private String techType;
    
    private String   techTypeIndex;
    
    

    public String getTechTypeIndex() {
		return techTypeIndex;
	}

	public void setTechTypeIndex(String techTypeIndex) {
		this.techTypeIndex = techTypeIndex;
	}


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSetupYear() {
        return setupYear;
    }

    public void setSetupYear(String setupYear) {
        this.setupYear = setupYear;
    }

    public String getProjectCycle() {
        return projectCycle;
    }

    public void setProjectCycle(String projectCycle) {
        this.projectCycle = projectCycle;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTechType() {
        return techType;
    }

    public void setTechType(String techType) {
        this.techType = techType;
    }
}