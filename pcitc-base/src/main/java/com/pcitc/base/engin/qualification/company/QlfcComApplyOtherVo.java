package com.pcitc.base.engin.qualification.company;

import java.io.Serializable;

/**
 * qlfc_com_apply_other
 * @author 
 */
public class QlfcComApplyOtherVo implements Serializable {
    /**
     * 承包商资质申报其他材料id
     */
    private String qlfcComApplyOtherId;

    /**
     * 承包商资质申报id
     */
    private String qlfcComApplyId;

    /**
     * 材料名称
     */
    private String materialsName;

    /**
     * 材料说明
     */
    private String materialsDesc;

    /**
     * 材料附件
     */
    private String materialsAttachment;

    private static final long serialVersionUID = 1L;

    public String getQlfcComApplyOtherId() {
        return qlfcComApplyOtherId;
    }

    public void setQlfcComApplyOtherId(String qlfcComApplyOtherId) {
        this.qlfcComApplyOtherId = qlfcComApplyOtherId;
    }

    public String getQlfcComApplyId() {
        return qlfcComApplyId;
    }

    public void setQlfcComApplyId(String qlfcComApplyId) {
        this.qlfcComApplyId = qlfcComApplyId;
    }

    public String getMaterialsName() {
        return materialsName;
    }

    public void setMaterialsName(String materialsName) {
        this.materialsName = materialsName;
    }

    public String getMaterialsDesc() {
        return materialsDesc;
    }

    public void setMaterialsDesc(String materialsDesc) {
        this.materialsDesc = materialsDesc;
    }

    public String getMaterialsAttachment() {
        return materialsAttachment;
    }

    public void setMaterialsAttachment(String materialsAttachment) {
        this.materialsAttachment = materialsAttachment;
    }
}