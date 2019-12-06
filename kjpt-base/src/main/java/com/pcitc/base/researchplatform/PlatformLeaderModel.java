package com.pcitc.base.researchplatform;


import com.pcitc.base.common.RecordModel;

import java.io.Serializable;

/**
 * <p>平台领军人物</p>
 * <p>Table: kypt_leader - 科研平台-领军人物</p>
 * @author ty
 */
public class PlatformLeaderModel extends RecordModel implements Serializable {

    /**
     * 数据主键
     */
    private String id;
    /**
     * 科研平台项目ID,外键
     */
    private String platformId="";
    /**
     * 项目人员表的人员主键ID,外键
     */
    private String baseId="";
    /**
     * 名称
     */
    private String name="";
    /**
     * 担任职务
     */
    private String post="";
    /**
     * 专业
     */
    private String major="";
    /**
     * 工作单位
     */
    private String workUnit="";
    private String workUnitText="";

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

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getWorkUnitText() {
        return workUnitText;
    }

    public void setWorkUnitText(String workUnitText) {
        this.workUnitText = workUnitText;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
