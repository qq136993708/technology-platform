package com.pcitc.base.common;

import java.util.ArrayList;
import java.util.List;

public class HotWord {
    public String getIndices() {
        return indices;
    }

    public void setIndices(String indices) {
        this.indices = indices;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getTerms() {
        if ("".equals(this.terms)||"".equals(this.terms)){
            terms = "hotWord";
        }
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private String indices;
    private String types;
    private String terms;
    private String field;
    private int size;
}
