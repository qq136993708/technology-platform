package com.pcitc.base.common;

import com.alibaba.fastjson.annotation.JSONField;

public class ChartForceDataLink {


    @JSONField(ordinal = 1)
    private String source;

    @JSONField(ordinal = 2)
    private String target;

    @JSONField(ordinal = 3)
    private int weight;

    @JSONField(ordinal = 4)
    private String name;

    public ChartForceDataLink(String source, String target, int weight, String name) {
        this.source = source;
        this.target = target;
        this.weight = weight;
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
