package com.pcitc.web.common;

import com.pcitc.base.common.ExcelException;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.RecordModel;
import com.pcitc.base.expert.ZjkBase;
import com.pcitc.base.system.SysUser;
import com.pcitc.web.utils.PoiExcelExportUitl;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
