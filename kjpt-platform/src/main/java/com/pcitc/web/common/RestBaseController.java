package com.pcitc.web.common;

import com.pcitc.base.common.RecordModel;
import com.pcitc.base.system.SysUser;

import java.util.Date;

/**
 * @author ty
 */
public class RestBaseController extends BaseController{


    /**
     * 操作数据添加记录
     */
    public void setBaseData(RecordModel rm){
        SysUser sysUser = this.getUserProfile();
        rm.setUpdateDate(new Date());
        rm.setUpdator(sysUser.getUserName());
        rm.setCreateUnitName(sysUser.getUserUnitName());
        rm.setCreateUnitId(sysUser.getUnitId());
        rm.setDeleted("0");
        String userName = sysUser.getUserName();
        if(!rm.getKnowledgeScope().contains(userName)){
            rm.setKnowledgeScope(rm.getKnowledgeScope()+","+userName);
            rm.setKnowledgePerson(rm.getKnowledgePerson()+","+sysUser.getUserDisp());
        }
    }

}
