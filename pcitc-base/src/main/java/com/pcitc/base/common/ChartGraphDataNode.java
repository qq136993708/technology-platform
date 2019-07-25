package com.pcitc.base.common;

import com.alibaba.fastjson.annotation.JSONField;

public class ChartGraphDataNode {

//    {id: "0", name: "Myriel", itemStyle: null, symbolSize: 19.12381, x: -266.82776, …}
//public ChartForceDataNode(int category, String name, Object value, String label) {

//    public ChartGraphDataNode(int category, String name, Object value, String id) {
//{id: "10",category: 0,name: "张0000000000",value:28.685715},

    /**
     *
     * @param category
     * @param name
     * @param value
     * @param id
     */
    public ChartGraphDataNode(int category, String name, Object value, String id,Object label,double x,double y) {
        this.category = category;
        this.name = name;
        this.value = value;
        this.id = id;
        this.label = label;
        this.x = x;
        this.y = y;
    }

    @JSONField(ordinal = 1)
    private int category;

    @JSONField(ordinal = 1)
    private String id;

    @JSONField(ordinal = 3)
    private String itemStyle;

    @JSONField(ordinal = 4)
    private Object label;

    @JSONField(ordinal = 2)
    private String name;

    @JSONField(ordinal = 4)
    private Object symbolSize;

    @JSONField(ordinal = 5)
    private Object value;

    @JSONField(ordinal = 5)
    private Object x;

    @JSONField(ordinal = 6)
    private Object y;

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemStyle() {
        return itemStyle;
    }

    public void setItemStyle(String itemStyle) {
        this.itemStyle = itemStyle;
    }

    public Object getLabel() {
        return label;
    }

    public void setLabel(Object label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getSymbolSize() {
        return symbolSize;
    }

    public void setSymbolSize(Object symbolSize) {
        this.symbolSize = symbolSize;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getX() {
        return x;
    }

    public void setX(Object x) {
        this.x = x;
    }

    public Object getY() {
        return y;
    }

    public void setY(Object y) {
        this.y = y;
    }

}
