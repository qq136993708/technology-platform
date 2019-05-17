package com.pcitc.base.stp.out;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pcitc.base.annotations.Document;
import com.pcitc.base.annotations.Field;
import com.pcitc.base.annotations.ID;
import com.pcitc.base.common.enums.FieldType;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(index = "tfchotesindex", type = "tfchotestype", replicas = 1, shards = 5)
public class TfcHotEs {

    public Integer getEsId() {
        return esId;
    }

    public void setEsId(Integer esId) {
        this.esId = esId;
    }

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

    @Field(type = FieldType.text)
    private String name;
    @Field(type = FieldType.text)
    private String value;
    @ID
    private Integer esId;

}