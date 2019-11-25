package com.pcitc.base.scientificplan;

import com.pcitc.base.common.RecordModel;

import java.io.Serializable;
import java.util.Date;

/**
 * 科技进展动态实体
 */
public class ScienceEvolveDynamic extends RecordModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id; //id
    private String name = ""; //名称
    private String authenticate_util = "";//申报单位
    private String research_field = "";//研究领域
    private Date release_time = new Date();//发布时间

    public ScienceEvolveDynamic() {
    }

    public ScienceEvolveDynamic(String id, String name,
                                String authenticate_util, String research_field, Date release_time) {
        this.id = id;
        this.name = name;
        this.authenticate_util = authenticate_util;
        this.research_field = research_field;
        this.release_time = release_time;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthenticate_util() {
        return authenticate_util;
    }

    public void setAuthenticate_util(String authenticate_util) {
        this.authenticate_util = authenticate_util;
    }

    public String getResearch_field() {
        return research_field;
    }

    public void setResearch_field(String research_field) {
        this.research_field = research_field;
    }

    public Date getRelease_time() {
        return release_time;
    }

    public void setRelease_time(Date release_time) {
        this.release_time = release_time;
    }

    public void setId(String replace) {
    }
}
