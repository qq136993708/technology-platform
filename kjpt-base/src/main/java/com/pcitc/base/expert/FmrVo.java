package com.pcitc.base.expert;

import java.io.Serializable;

/**
 * @author:Administrator
 * @date:2019/8/14
 */
public class FmrVo implements Serializable {
    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
