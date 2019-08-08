package com.pcitc.service.equipment.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.equipment.*;
import com.pcitc.mapper.equipment.*;
import com.pcitc.service.equipment.SupplierAppraiseService;
import lombok.val;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("appraiseService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class SupplierAppraiseServiceImpl implements SupplierAppraiseService {
	
	
	@Autowired
	private SreSupplierAppraiseMapper sreSupplierAppraiseMapper;
	@Autowired
    private SrePurchaseMapper srePurchaseMapper;
	@Autowired
    private SreEquipmentMapper sreEquipmentMapper;


	@Override
	public void insertSupplierAppraise(SreSupplierAppraise sreSupplierAppraise) {
		sreSupplierAppraiseMapper.insertSelective(sreSupplierAppraise);
	}

	@Override
	public Integer updateSreSupplierAppraise(SreSupplierAppraise sreSupplierAppraise) {
		return sreSupplierAppraiseMapper.updateByPrimaryKeySelective(sreSupplierAppraise);
	}

	@Override
	public SreSupplierAppraise selectSreSupplierDetailId(String equipmentDetailId) {
		return sreSupplierAppraiseMapper.selectSreSupplierDetailId(equipmentDetailId);
	}

	@Override
	public SreSupplierAppraise selectSreSupplierById(String id) {
		return sreSupplierAppraiseMapper.selectByPrimaryKey(id);
	}

	public LayuiTableData getSreSupplierAppraisePage(LayuiTableParam param)throws Exception
    {
        /*List<SreSupplierAppraise> list = new ArrayList<SreSupplierAppraise>();*/
        //每页显示条数
        int pageSize = param.getLimit();
        //从第多少条开始
        int pageStart = (param.getPage()-1)*pageSize;
        //当前是第几页
        int pageNum = pageStart/pageSize + 1;
        // 1、设置分页信息，包括当前页数和每页显示的总计数
        PageHelper.startPage(pageNum, pageSize);

        /*Map map =new HashMap();
		list = sreSupplierAppraiseMapper.getList(map);*/

        Map map1 =new HashMap();
        //1.创建返回前台数据对象-----
        //2.创建数据对象集合用于存放当前供应商 名称,订单总数
        List<SupplierAppraiseResults> list = new ArrayList<SupplierAppraiseResults>();

        List<SrePurchase> purchaseList = new ArrayList<SrePurchase>();
        purchaseList = srePurchaseMapper.getList(map1);//获取所有采购信息
        //遍历每一条采购信息数据,拿到装备ID
        for(SrePurchase  srePurchase : purchaseList) {
            String[] equipmentIds = srePurchase.getEquipmentId().split(",");//获取所有装备ID用,号分割
            for(int i=0;i<equipmentIds.length;i++){
                String equipmentId = equipmentIds[i];
                //通过equipmentId获取装备数据拿到当前供应商,拿到装备金额
                SreEquipment sreEquipment = sreEquipmentMapper.selectByPrimaryKey(equipmentId);
                SreSupplierAppraise sreSupplierAppraise = sreSupplierAppraiseMapper.selectEquipmentId(equipmentId);//根据装备ID获取供应商评价信息
                String supplierAppraise ="";//供应商评价
                if (sreSupplierAppraise!=null){
                    supplierAppraise = sreSupplierAppraise.getSupplierAppraise();//供应商评价
                }

                //2.获取供应商名称,订单数放入创建的对象集合中
                String supplierName ="";
                if(StringUtils.isNotBlank(sreEquipment.getSupplierStr())){
                    supplierName = sreEquipment.getSupplierStr().substring(0, sreEquipment.getSupplierStr().indexOf("#"));
                }


                BigDecimal allPrice = sreEquipment.getAllPrice();//装备总金额
                //3.遍历创建的对象集合,为了过滤采购订单,存在同一个供应商,如果一个采购订单是同一个供应商提供的,只为此供应商几数一次
                if(list.size()!=0){
                    int count =0;//用于判断list集合中没有匹配的数据，如果count大于0走新增
                    int number =0;//用于判断count值是否大于0,如果number大于0代表list集合中存在数据，那么count赋值为0
                    for (SupplierAppraiseResults supplierAppraiseResults : list) {
                        SupplierAppraiseResults appraiseResults = new SupplierAppraiseResults();
                        String supplierNameResults = supplierAppraiseResults.getSupplierName();
                        if (supplierNameResults.equals(supplierName)){//如果该供应商之前就存在,那么就在之前的信息追加
                            supplierAppraiseResults.setPurchaseSum(supplierAppraiseResults.getPurchaseSum()+1);//如果供应商相同,采购订单数量+1
                            supplierAppraiseResults.setPurchaseMoneySum(supplierAppraiseResults.getPurchaseMoneySum().add(allPrice));//如果供应商相同,该供应商下的所有装备金额相加
                            if (supplierAppraise.equals("A")){//判断评价等级来给对应的等级数量+1
                                supplierAppraiseResults.set_A(supplierAppraiseResults.get_A()+1);
                            }else if (supplierAppraise.equals("B")){
                                supplierAppraiseResults.set_B(supplierAppraiseResults.get_B()+1);
                            }else if (supplierAppraise.equals("C")){
                                supplierAppraiseResults.set_C(supplierAppraiseResults.get_C()+1);
                            }else if (supplierAppraise.equals("D")){
                                supplierAppraiseResults.set_D(supplierAppraiseResults.get_D()+1);
                            }
                            number++;
                        }else {
                            if(number>0) {
                                count=0;
                            }else {
                                count++;
                            }
                        }
                    }
                    if(count>0) {
                        SupplierAppraiseResults appraiseResults = new SupplierAppraiseResults();
                        appraiseResults.setSupplierName(supplierName);
                        appraiseResults.setPurchaseSum(1);
                        appraiseResults.setPurchaseMoneySum(allPrice);
                        if (supplierAppraise.equals("A")){
                            appraiseResults.set_A(1);
                            appraiseResults.set_B(0);
                            appraiseResults.set_C(0);
                            appraiseResults.set_D(0);
                        }else if (supplierAppraise.equals("B")){
                            appraiseResults.set_A(0);
                            appraiseResults.set_B(1);
                            appraiseResults.set_C(0);
                            appraiseResults.set_D(0);
                        }else if (supplierAppraise.equals("C")){
                            appraiseResults.set_A(0);
                            appraiseResults.set_B(0);
                            appraiseResults.set_C(1);
                            appraiseResults.set_D(0);
                        }else if (supplierAppraise.equals("D")){
                            appraiseResults.set_A(0);
                            appraiseResults.set_B(0);
                            appraiseResults.set_C(0);
                            appraiseResults.set_D(1);
                        }else if (supplierAppraise.equals("")){
                            appraiseResults.set_A(0);
                            appraiseResults.set_B(0);
                            appraiseResults.set_C(0);
                            appraiseResults.set_D(0);
                        }
                        list.add(appraiseResults);
                    }
                }else{
                    SupplierAppraiseResults appraiseResults = new SupplierAppraiseResults();
                    appraiseResults.setSupplierName(supplierName);
                    appraiseResults.setPurchaseSum(1);
                    appraiseResults.setPurchaseMoneySum(allPrice);
                    if (supplierAppraise.equals("A")){
                        appraiseResults.set_A(1);
                        appraiseResults.set_B(0);
                        appraiseResults.set_C(0);
                        appraiseResults.set_D(0);
                    }else if (supplierAppraise.equals("B")){
                        appraiseResults.set_A(0);
                        appraiseResults.set_B(1);
                        appraiseResults.set_C(0);
                        appraiseResults.set_D(0);
                    }else if (supplierAppraise.equals("C")){
                        appraiseResults.set_A(0);
                        appraiseResults.set_B(0);
                        appraiseResults.set_C(1);
                        appraiseResults.set_D(0);
                    }else if (supplierAppraise.equals("D")){
                        appraiseResults.set_A(0);
                        appraiseResults.set_B(0);
                        appraiseResults.set_C(0);
                        appraiseResults.set_D(1);
                    }else if (supplierAppraise.equals("")){
                        appraiseResults.set_A(0);
                        appraiseResults.set_B(0);
                        appraiseResults.set_C(0);
                        appraiseResults.set_D(0);
                    }
                    list.add(appraiseResults);
                }
            }
        }

        PageInfo<SupplierAppraiseResults> pageInfo = new PageInfo<SupplierAppraiseResults>(list);
        System.out.println(">>>>>>>>>查询分页结果"+pageInfo.getList().size());
        LayuiTableData data = new LayuiTableData();
        data.setData(pageInfo.getList());
        Long total = pageInfo.getTotal();
        data.setCount(total.intValue());
        return data;
    }

}
