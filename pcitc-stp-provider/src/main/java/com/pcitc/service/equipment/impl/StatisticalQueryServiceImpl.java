package com.pcitc.service.equipment.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.equipment.SrePurchase;
import com.pcitc.mapper.equipment.SrePurchaseMapper;
import com.pcitc.service.equipment.StatisticalQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("statisticalQueryService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)

public class StatisticalQueryServiceImpl implements StatisticalQueryService {
    private final static Logger logger = LoggerFactory.getLogger(PurchaseServiceImpl.class);
    @Autowired
    private SrePurchaseMapper srePurchaseMapper;

    private String getTableParam(LayuiTableParam param,String paramName,String defaultstr)
    {
        String resault="";
        Object object=param.getParam().get(paramName);
        if(object!=null)
        {
            resault=(String)object;
        }
        return resault;
    }


    public LayuiTableData getPurchaseEquipmenList(LayuiTableParam param)throws Exception
    {
        List<SrePurchase> list = new ArrayList<SrePurchase>();
        //每页显示条数
        int pageSize = param.getLimit();
        //从第多少条开始
        int pageStart = (param.getPage()-1)*pageSize;
        //当前是第几页
        int pageNum = pageStart/pageSize + 1;
        // 1、设置分页信息，包括当前页数和每页显示的总计数
        PageHelper.startPage(pageNum, pageSize);
        String purchaseName=getTableParam(param,"purchaseName","");
        String departName=getTableParam(param,"departName","");
        String departCode = getTableParam(param, "departCode", "");
        String stage=getTableParam(param,"stage","");
        String state=getTableParam(param,"state","");
        String proposerName=getTableParam(param,"proposerName","");
        String parentUnitPathNames=getTableParam(param,"parentUnitPathNames","");
        String parentUnitPathIds=getTableParam(param,"parentUnitPathIds","");
        String createDate=getTableParam(param,"createDate","");
        String isKJBPerson = getTableParam(param, "isKJBPerson", "");
        Map map=new HashMap();
        PageInfo<SrePurchase> pageInfo = null;
        map.put("purchaseName", purchaseName);
        map.put("departName", departName);
        map.put("stage", stage);
        map.put("state", state);
        map.put("proposerName", proposerName);
        map.put("parentUnitPathNames", parentUnitPathNames);
        map.put("parentUnitPathIds", parentUnitPathIds);
        map.put("createDate", createDate);

        System.out.println(">>>>>>>>applyDepartCode="+departCode);
        StringBuffer applyUnitCodeStr=new StringBuffer();
        if(!departCode.equals("")) {
            applyUnitCodeStr.append(" ("); String arr[]=departCode.split(",");
            for(int i=0;i<arr.length;i++) {
                if(i>0) {
                    applyUnitCodeStr.append(" OR FIND_IN_SET('"+arr[i]
                            +"', t.`depart_code`)");
                }else {
                    applyUnitCodeStr.append("FIND_IN_SET('"+arr[i]+"', t.`depart_code`)");
                }
            }
            applyUnitCodeStr.append(" )");
        }

        map.put("sqlStr", applyUnitCodeStr.toString());
        list = srePurchaseMapper.getList(map);
        if(isKJBPerson!=null && isKJBPerson!=""){
            pageInfo = new PageInfo<SrePurchase>(list);
        }else{
             list = new ArrayList<SrePurchase>();
            pageInfo = new PageInfo<SrePurchase>(list);
            System.err.println("此用户不是科技部人员");
        }
        System.out.println(">>>>>>>>>查询分页结果"+pageInfo.getList().size());
        LayuiTableData data = new LayuiTableData();
        data.setData(pageInfo.getList());
        Long total = pageInfo.getTotal();
        data.setCount(total.intValue());
        return data;
    }
}
