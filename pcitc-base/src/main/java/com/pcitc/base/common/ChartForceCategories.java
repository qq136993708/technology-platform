package com.pcitc.base.common;

import com.alibaba.fastjson.annotation.JSONField;

public class ChartForceCategories {


    @JSONField(ordinal = 1)
    private String name;

    public ChartForceCategories(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
