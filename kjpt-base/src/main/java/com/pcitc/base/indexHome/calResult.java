package com.pcitc.base.indexHome;

import java.math.BigDecimal;

/***
 * @Author xiaoh
 * @Description 领导驾驶舱首页统计实体
 * @Date 2020/6/9 13:55
 * @param
 * @return
 **/
public class calResult {
    /***
     * 字典值
     **/
    private String dicValue;

    /***
     * 字典值2
     **/
    private String dicValueSub;

    /***
     * 字典值3
     **/
    private String dicValueTitle;

    /***
     * 文本说明
     **/
    private String text;

    /***
     * 文本说明2
     **/
    private String textSub;

    /***
     * 文本说明3
     **/
    private String textTitle;

    /***
     * 统计值
     **/
    private BigDecimal calValue;

    /***
     * 统计值2
     **/
    private BigDecimal calValueSub;

    public String getDicValueSub() {
        return dicValueSub;
    }

    public void setDicValueSub(String dicValueSub) {
        this.dicValueSub = dicValueSub;
    }

    public String getTextSub() {
        return textSub;
    }

    public void setTextSub(String textSub) {
        this.textSub = textSub;
    }

    public String getDicValue() {
        return dicValue;
    }

    public void setDicValue(String dicValue) {
        this.dicValue = dicValue;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public BigDecimal getCalValue() {
        return calValue;
    }

    public void setCalValue(BigDecimal calValue) {
        this.calValue = calValue;
    }

    public BigDecimal getCalValueSub() {
        return calValueSub;
    }

    public void setCalValueSub(BigDecimal calValueSub) {
        this.calValueSub = calValueSub;
    }

    public String getDicValueTitle() {
        return dicValueTitle;
    }

    public void setDicValueTitle(String dicValueTitle) {
        this.dicValueTitle = dicValueTitle;
    }

    public String getTextTitle() {
        return textTitle;
    }

    public void setTextTitle(String textTitle) {
        this.textTitle = textTitle;
    }
}
