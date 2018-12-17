package com.pcitc.base.common;

import com.alibaba.fastjson.annotation.JSONField;

public class ChartForceDataNode {

    @JSONField(ordinal = 1)
    private int category;

    @JSONField(ordinal = 2)
    private Object value;

    @JSONField(ordinal = 3)
    private String name;

    @JSONField(ordinal = 4)
    private String label;

    public ChartForceDataNode(int category, String name, Object value, String label) {
        this.value = value;
        this.name = name;
        this.category = category;
        this.label = label;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
