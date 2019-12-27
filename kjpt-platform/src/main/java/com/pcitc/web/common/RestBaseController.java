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
     * 查询白名单
     */
    private static final String WHITE_LIST = "http://kjpt-zuul/system-proxy/user-provider/whiteList/";

    private static final String WHITE_LIST_KEY = "isWhiteList";

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

    public void setBaseParam(Map condition){
        SysUser sysUserInfo = this.getUserProfile();
        this.setParam(condition,"userSecretLevel",sysUserInfo.getSecretLevel());
        this.setParam(condition,"userName",sysUserInfo.getUserName());
        if("1".equals(this.getCurrentRequest().getAttribute(WHITE_LIST_KEY))){
            this.setParam(condition,"skipKnowledgeScope","1");
        }
    }


    public void setIsWhiteList(){
        //是否是白名单 0否1是
        String isWhiteList = "0";
        SysUser sysUserInfo = this.getUserProfile();
        String userName = sysUserInfo.getUserName();
        Map param = new HashMap(2);
        param.put("userName",userName);
        ResponseEntity<Integer> response = restTemplate.exchange(WHITE_LIST+userName, HttpMethod.GET,new HttpEntity<>(this.httpHeaders),Integer.class);
        if(response.getBody() > 0){
            isWhiteList = "1";
        }
        this.getCurrentRequest().getSession().setAttribute(WHITE_LIST_KEY,isWhiteList);
    }


    public void exportExcel(String[] headers, String[] cols, String fileName, List dataList) throws Exception {
        HttpServletResponse response =  this.getCurrentResponse();
        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO8859-1") + ".xls");
        try {
            OutputStream os = response.getOutputStream();
            PoiExcelExportUitl<Object> pee = new PoiExcelExportUitl<Object>(fileName, headers, cols, dataList,os);
            pee.exportExcel();

        } catch (Exception e)
        {
            e.printStackTrace();
            // 如果是ExcelException,则直接抛出
            if (e instanceof ExcelException)
            {
                throw (ExcelException) e;
            } else
            {
                // 否则将其他异常包装成ExcelException再抛出
                throw new ExcelException("导出excel失败");
            }
        }
    }

}
