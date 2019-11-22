package com.pcitc.web.common;

import com.pcitc.base.common.RecordModel;

import java.util.Date;

/**
 * @author ty
 */
public class RestBaseController extends BaseController{

    /**
     * 操作数据添加记录
     */
    public void setBaseData(RecordModel rm){
        rm.setUpdateDate(new Date());
        rm.setUpdator(this.getUserProfile().getUserName());
        rm.setDeleted("0");
    }

}
