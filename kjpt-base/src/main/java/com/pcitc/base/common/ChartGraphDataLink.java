package com.pcitc.base.common;

import com.alibaba.fastjson.annotation.JSONField;

public class ChartGraphDataLink {

    @JSONField(ordinal = 1)
    private String id;

    @JSONField(ordinal = 2)
    private String name;

    @JSONField(ordinal = 3)
    private String source;

    @JSONField(ordinal = 4)
    private String target;

    @JSONField(ordinal = 5)
    private Object lineStyle;

    //    public ChartForceDataLink(String source, String target, int weight, String name) {
    //{id: "2", name: null, source: "3", target: "0", lineStyle: {…}}
    public ChartGraphDataLink(String source, String target, String id, String name) {
        this.id = id;
        this.source = source;
        this.target = target;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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

    public Object getLineStyle() {
        return lineStyle;
    }

    public void setLineStyle(Object lineStyle) {
        this.lineStyle = lineStyle;
    }

}
