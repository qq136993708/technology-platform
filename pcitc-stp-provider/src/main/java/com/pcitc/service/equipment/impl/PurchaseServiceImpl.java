package com.pcitc.service.equipment.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.equipment.SreProject;
import com.pcitc.base.stp.equipment.SreProjectTask;
import com.pcitc.mapper.equipment.SreProjectMapper;
import com.pcitc.service.feign.WorkflowRemoteClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.equipment.SrePurchase;
import com.pcitc.mapper.equipment.SrePurchaseMapper;
import com.pcitc.service.equipment.PurchaseService;
@Service("purchaseService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class PurchaseServiceImpl implements PurchaseService {
	
	
	private final static Logger logger = LoggerFactory.getLogger(PurchaseServiceImpl.class); 
	@Autowired
	private SrePurchaseMapper  srePurchaseMapper;
    @Autowired
	private SreProjectMapper   sreProjectMapper;
    @Autowired
    private WorkflowRemoteClient workflowRemoteClient;
	
	
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
	
	
	public LayuiTableData getPurchasePage(LayuiTableParam param)throws Exception
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
		String createDate=getTableParam(param,"createDate","");
		if(stage.equals(Constant.PURCHASE_CONTRACT_DOCKING)){
            Map map=new HashMap();
            map.put("purchaseName", purchaseName);
            map.put("departName", departName);
            map.put("stage", stage);
            map.put("state", state);
            map.put("proposerName", proposerName);
            map.put("parentUnitPathNames", parentUnitPathNames);
            map.put("createDate", createDate);

            System.out.println(">>>>>>>>applyDepartCode="+departCode);
            StringBuffer applyUnitCodeStr=new StringBuffer(); if(!departCode.equals("")) {
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
		}else{
			if(state.equals(Constant.PURCHASE_STATUS_PASS)){
				Map map=new HashMap();
				map.put("purchaseName", purchaseName);
				map.put("departName", departName);
				map.put("stage", stage);
				map.put("state", state);
				map.put("proposerName", proposerName);
				map.put("parentUnitPathNames", parentUnitPathNames);
				map.put("createDate", createDate);

				System.out.println(">>>>>>>>applyDepartCode="+departCode);
				StringBuffer applyUnitCodeStr=new StringBuffer(); if(!departCode.equals("")) {
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


				 list = srePurchaseMapper.getPassList(map);
			}else{
                Map map=new HashMap();
                map.put("purchaseName", purchaseName);
                map.put("departName", departName);
                map.put("stage", stage);
                map.put("state", state);
                map.put("proposerName", proposerName);
                map.put("parentUnitPathNames", parentUnitPathNames);
                map.put("createDate", createDate);

                 System.out.println(">>>>>>>>applyDepartCode="+departCode);
                 StringBuffer applyUnitCodeStr=new StringBuffer(); if(!departCode.equals("")) {
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
                }
            }
		PageInfo<SrePurchase> pageInfo = new PageInfo<SrePurchase>(list);
		System.out.println(">>>>>>>>>查询分页结果"+pageInfo.getList().size());
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
	    return data;
	}


	@Override
	public List<SrePurchase> getPurchaseNameIdList() {
		
		return srePurchaseMapper.getPurchaseNameIdList();
	}

	@Override
	public SrePurchase selectSrePurchaseById(String id) {
		return srePurchaseMapper.selectByPrimaryKey(id);
	}

	@Override
	public void insertPurchase(SrePurchase srePurchase) {
		srePurchaseMapper.insertSelective(srePurchase);
	}

	@Override
	public int deletePurchase(String id) {
		return srePurchaseMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Integer updateSrePurchase(SrePurchase srePurchase) throws Exception {
		return srePurchaseMapper.updateByPrimaryKey(srePurchase);
	}

	@Override
	public SreProject selectProjectBasic(String id) {

		return sreProjectMapper.selectByPrimaryKey(id);
	}

    //内部确认流程
    public Result dealInnerPurchaseFlow(String id, Map map) throws Exception
    {


        JSONObject parmamss = JSONObject.parseObject(JSONObject.toJSONString(map));
        System.out.println(">>>>>>>>>>内部确认流程 dealInnerTaskFlow 参数: "+parmamss.toJSONString());


        SrePurchase srePurchase = srePurchaseMapper.selectByPrimaryKey(id);

        String processInstanceName=(String)map.get("processInstanceName");
        String authenticatedUserId=(String)map.get("authenticatedUserId");
        String authenticatedUserName=(String)map.get("authenticatedUserName");
        String functionId=(String)map.get("functionId");
        String auditor=(String)map.get("auditor");
        //申请者机构信息
        /*String applyUnitCode=(String)map.get("applyUnitCode");
        String parentApplyUnitCode=(String)map.get("parentApplyUnitCode");
        String applyUnitName=(String)map.get("applyUnitName");
        String applyUserId=(String)map.get("applyUserId");
        String applyUserName=(String)map.get("applyUserName");
        String applyUnitPathCode=(String)map.get("applyUnitPathCode");
        String parentApplyUnitPathCode=(String)map.get("parentApplyUnitPathCode");
        String parentApplyUnitPathName=(String)map.get("parentApplyUnitPathName");
        //指定岗位
        String specialAuditor1=(String)map.get("specialAuditor1");
        String specialAuditor2=(String)map.get("specialAuditor2");
        String specialAuditor3=(String)map.get("specialAuditor3");


        String branchFlag=(String)map.get("branchFlag");*/



        // 调用审批流程，此处调用同时实现事务
        JSONObject flowJson = new JSONObject();
        // 业务主键id
        flowJson.put("businessId", id);
        flowJson.put("processInstanceName", processInstanceName);
        // 发起者信息
        flowJson.put("authenticatedUserId", authenticatedUserId);
        flowJson.put("authenticatedUserName", authenticatedUserName);
        // 菜单id（functionId），部门/组织ID（orgId），项目id（projectId）。其中菜单id必填（和ProcessDefineId两选一）
        flowJson.put("functionId", functionId);
        // 待办业务详情、最终审批同意、最终审批不同意路径
        flowJson.put("auditDetailsPath", "/sre_purchase/get/" + id);
        flowJson.put("auditAgreeMethod", "http://pcitc-zuul/stp-proxy/sre-provider/project_task/task/agree_inner/" + id);
        flowJson.put("auditRejectMethod", "http://pcitc-zuul/stp-proxy/sre-provider/project_task/task/reject_inner/" + id);

        // 非必填选项， 菜单功能需要根据不同单位、不同项目选择不同流程图的时候使用。（也可以在单个流程图中，用判断来做）
        // flowJson.put("flowProjectId", "");
        // flowJson.put("flowUnitId", "");
        //flowJson.put("branchFlag", branchFlag);
        // 非必填选项，当下一步审批者需要本次任务执行人（启动者）手动选择的时候，需要auditUserIds属性
        flowJson.put("auditor", auditor);

        // 非必填选项, 对流程中出现的多个判断条件，比如money>100等，需要把事先把money条件输入
        // flowJson.put("money", 50); // 环节1需要用到
        // flowJson.put("departmentCode", "1005"); // 环节2需要用到
        // flowJson.put("companyCode", "2006"); // 环节n需要用到
        // 非必填选项, 会签时需要的属性，会签里所有的人，同意率（double类型）
        // flowJson.put("specialAuditor0", "ZBGL_KTY_CYDW");
        /*flowJson.put("specialAuditor1", specialAuditor1);
        flowJson.put("specialAuditor2", specialAuditor2);
        flowJson.put("specialAuditor3", specialAuditor3);
        flowJson.put("signAuditRate", 1d);*/

        // 远程调用
        System.out.println("=====远程调用开始");
        String str=workflowRemoteClient.startCommonWorkflow(flowJson.toJSONString());
        System.out.println("=====远程调用结束");
        if("true".equals(str))
        {
            srePurchase.setState(Constant.PURCHASE_STATUS_SUBMIT);
            srePurchaseMapper.updateByPrimaryKeySelective(srePurchase);
            return new Result(true,"操作成功!");
        }else
        {
            return new Result(false,"操作失败!");
        }
    }
}
