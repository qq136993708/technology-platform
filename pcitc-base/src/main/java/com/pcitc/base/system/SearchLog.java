package com.pcitc.base.system;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pcitc.base.annotations.Document;
import com.pcitc.base.annotations.Field;
import com.pcitc.base.annotations.ID;
import com.pcitc.base.common.DataEntity;
import com.pcitc.base.common.enums.FieldType;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(index = "search", type = "searchlog", replicas = 1, shards = 5)
public class SearchLog implements Serializable {
    private static final long serialVersionUID = 1L;

    public Integer getEsId() {
        return esId;
    }

    public void setEsId(Integer esId) {
        this.esId = esId;
    }

    @ID
    private Integer esId;

    @Field(type = FieldType.text, fielddata = true, analyzer = "ik_max_word", fieldsName = {"ik", "pinyin", "first_py"}, fieldsAnalyzer = {"ik_max_word", "full_pinyin_letter_analyzer", "first_py_letter_analyzer"})
    private String name;

//    @Field(type = FieldType.text,fielddata=true)
//    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}