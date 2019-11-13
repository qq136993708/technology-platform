package com.pcitc.base.stp.techFamily;

import com.pcitc.base.annotations.Document;
import com.pcitc.base.annotations.Field;
import com.pcitc.base.annotations.ID;
import com.pcitc.base.common.enums.FieldType;

import java.util.List;
@Document(index = "techfamilyes", type = "techfamilyestype", replicas = 1, shards = 5)
public class TechFamilyEs {

    @Field(type = FieldType.text, analyzer = "ik_max_word", fieldsName = {"ik", "pinyin", "first_py"}, fieldsAnalyzer = {"ik_max_word", "full_pinyin_letter_analyzer", "first_py_letter_analyzer"})
    private String typeName;
    @ID
    private Integer esId;
    @Field(type = FieldType.text)
    private String tfmTypeId;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getEsId() {
        return esId;
    }

    public void setEsId(Integer esId) {
        this.esId = esId;
    }

    public String getTfmTypeId() {
        return tfmTypeId;
    }

    public void setTfmTypeId(String tfmTypeId) {
        this.tfmTypeId = tfmTypeId;
    }



}