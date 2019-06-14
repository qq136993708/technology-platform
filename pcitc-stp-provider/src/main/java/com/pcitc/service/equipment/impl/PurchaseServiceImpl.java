package com.pcitc.service.equipment.impl;

import java.util.*;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.equipment.SreEquipment;
import com.pcitc.base.stp.equipment.SreProject;
import com.pcitc.base.stp.equipment.SreProjectTask;
import com.pcitc.mapper.equipment.SreEquipmentMapper;
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
    private SreEquipmentMapper  sreEquipmentMapper;
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
        String parentUnitPathIds=getTableParam(param,"parentUnitPathIds","");
		String createDate=getTableParam(param,"createDate","");
        String purchaseCode = getTableParam(param, "purchaseCode", "");
        if(stage.equals(Constant.PURCHASE_CONTRACT_DOCKING)){
            Map map=new HashMap();
            map.put("purchaseName", purchaseName);
            map.put("departName", departName);
            map.put("stage", stage);
            map.put("state", state);
            map.put("proposerName", proposerName);
            map.put("parentUnitPathNames", parentUnitPathNames);
            map.put("parentUnitPathIds", parentUnitPathIds);
            map.put("createDate", createDate);
            map.put("purchaseCode", purchaseCode);



            System.out.println(">>>>>>>>applyDepartCode="+departCode);
            StringBuffer applyUnitCodeStr=new StringBuffer();
            if(!departCode.equals("")) {
                applyUnitCodeStr.append(" (");
                String arr[]=departCode.split(",");
                for(int i=0;i<arr.length;i++) {
                    if(i>0) {
                        applyUnitCodeStr.append(" OR FIND_IN_SET('"+arr[i]+"', t.`depart_code`)");
                    }else {
                        applyUnitCodeStr.append("FIND_IN_SET('"+arr[i]+"', t.`depart_code`)");
                    }
                }
                applyUnitCodeStr.append(" )");
            }

            map.put("sqlStr", applyUnitCodeStr.toString());


            list = srePurchaseMapper.getList(map);
		}else if(stage.equals(Constant.PURCHASE_CONTRACT_CLOSE)){//合同关闭列表展示的数据
            Map map=new HashMap();
            map.put("purchaseName", purchaseName);
            map.put("departName", departName);
            map.put("stage", stage);
            map.put("state", state);
            map.put("proposerName", proposerName);
            map.put("parentUnitPathNames", parentUnitPathNames);
            map.put("parentUnitPathIds", parentUnitPathIds);
            map.put("createDate", createDate);
            map.put("purchaseCode", purchaseCode);


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


            list = srePurchaseMapper.getContractClosedList(map);
        }else{
			if(state.equals(Constant.PURCHASE_STATUS_PASS)){//采购申请成功的数据
				Map map=new HashMap();
				map.put("purchaseName", purchaseName);
				map.put("departName", departName);
				map.put("stage", stage);
				map.put("state", state);
				map.put("proposerName", proposerName);
				map.put("parentUnitPathNames", parentUnitPathNames);
                map.put("parentUnitPathIds", parentUnitPathIds);
				map.put("createDate", createDate);
                map.put("purchaseCode", purchaseCode);

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
                map.put("parentUnitPathIds", parentUnitPathIds);
                map.put("createDate", createDate);
                map.put("purchaseCode", purchaseCode);

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
    public Result dealPurchaseFlow(String id, Map map) throws Exception
    {


        JSONObject parmamss = JSONObject.parseObject(JSONObject.toJSONString(map));
        System.out.println(">>>>>>>>>>内部确认流程 dealPurchaseFlow 参数: "+parmamss.toJSONString());


        SrePurchase srePurchase = srePurchaseMapper.selectByPrimaryKey(id);
        String equipmentIds = srePurchase.getEquipmentId();
        String processInstanceName=(String)map.get("processInstanceName");
        String authenticatedUserId=(String)map.get("authenticatedUserId");
        String authenticatedUserName=(String)map.get("authenticatedUserName");
        String functionId=(String)map.get("functionId");
        String auditor=(String)map.get("auditor");
        //申请者机构信息
        String applyUnitCode=(String)map.get("applyUnitCode");
        String parentApplyUnitCode=(String)map.get("parentApplyUnitCode");
        String applyUnitName=(String)map.get("applyUnitName");

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

        // 发起人之后的审批环节，如果是需要选择审批人的话，此处获取选择的userIds赋值给auditor变量
        if (auditor != null && !auditor.equals("")) {
            String[] userIdsArr = auditor.split(",");
            flowJson.put("auditor", Arrays.asList(userIdsArr));
        }

        // 待办业务详情、最终审批同意、最终审批不同意路径
        flowJson.put("auditDetailsPath", "/sre-purchase/getParticulars/" + id);
        flowJson.put("auditAgreeMethod", "http://pcitc-zuul/stp-proxy/sre-provider/purchase/agree_purchase/" + id);
        flowJson.put("auditRejectMethod", "http://pcitc-zuul/stp-proxy/sre-provider/purchase/reject_purchase/" + id);

        // 非必填选项，当下一步审批者需要本次任务执行人（启动者）手动选择的时候，需要auditUserIds属性
        flowJson.put("specialAuditor0", "role--CGGL_BMLD");
        flowJson.put("specialAuditor1", "role--CGGL_YLD");

        // 远程调用
        System.out.println("=====远程调用开始");
        String str=workflowRemoteClient.startCommonWorkflow(flowJson.toJSONString());
        System.out.println("=====远程调用结束");
        if("true".equals(str))
        {
            String[] arr = equipmentIds.split(",");
            for (int i = 0; i < arr.length; i++) {
                SreEquipment sreEquipment = sreEquipmentMapper.selectByPrimaryKey(arr[i]);
                sreEquipment.setPurchaseStatus(Constant.EQUIPMENT_PURCHASE_SUBMIT);
                sreEquipmentMapper.updateByPrimaryKeySelective(sreEquipment);
            }
            srePurchase.setState(Constant.PURCHASE_STATUS_SUBMIT);
            srePurchaseMapper.updateByPrimaryKeySelective(srePurchase);
            return new Result(true,"操作成功!");
        }else
        {
            return new Result(false,"操作失败!");
        }
    }

    @Override
    public LayuiTableData getProjectPage(LayuiTableParam param) {
        JSONObject parmamss = JSONObject.parseObject(JSONObject.toJSONString(param));
        logger.info("============参数：" + parmamss.toString());
        //每页显示条数
        int pageSize = param.getLimit();
        //从第多少条开始
        int pageStart = (param.getPage()-1)*pageSize;
        //当前是第几页
        int pageNum = pageStart/pageSize + 1;
        // 1、设置分页信息，包括当前页数和每页显示的总计数
        PageHelper.startPage(pageNum, pageSize);

        String name=getTableParam(param,"name","");
        String equipmentIds=getTableParam(param,"equipmentIds","");
        String auditStatus=getTableParam(param,"auditStatus","");
        String setupYear=getTableParam(param,"setupYear","");
        String keyWord=getTableParam(param,"keyWord","");
        String leadUnitName=getTableParam(param,"leadUnitName","");
        String leadUnitCode=getTableParam(param,"leadUnitCode","");
        String applyUnitName=getTableParam(param,"applyUnitName","");
        String applyUnitCode=getTableParam(param,"applyUnitCode","");
        String joinUnitName=getTableParam(param,"joinUnitName","");
        String joinUnitCode=getTableParam(param,"joinUnitCode","");
        String taskWriteUsersIds=getTableParam(param,"taskWriteUsersIds","");


        String createUserId=getTableParam(param,"createUserId","");
        String createUserName=getTableParam(param,"createUserName","");
        String professionalFieldCode=getTableParam(param,"professionalFieldCode","");
        String professionalFieldName=getTableParam(param,"professionalFieldName","");
        String setupId=getTableParam(param,"setupId","");
        String taskId=getTableParam(param,"taskId","");

        String belongDepartmentName=getTableParam(param,"belongDepartmentName","");
        String professionalDepartName=getTableParam(param,"professionalDepartName","");

        String unitPathIds=getTableParam(param,"unitPathIds","");
        String parentUnitPathIds=getTableParam(param,"parentUnitPathIds","");

        Map map=new HashMap();
        map.put("belongDepartmentName", belongDepartmentName);
        map.put("professionalDepartName", professionalDepartName);
        map.put("name", name);
        map.put("equipmentIds", equipmentIds);
        map.put("auditStatus", auditStatus);
        map.put("setupYear", setupYear);
        map.put("keyWord", keyWord);
        map.put("leadUnitName", leadUnitName);
        map.put("leadUnitCode", leadUnitCode);
        map.put("applyUnitName", applyUnitName);
        map.put("joinUnitName", joinUnitName);
        map.put("joinUnitCode", joinUnitCode);
        map.put("taskWriteUsersIds", taskWriteUsersIds);

        map.put("createUserId", createUserId);
        map.put("createUserName", createUserName);
        map.put("professionalFieldCode", professionalFieldCode);
        map.put("professionalFieldName", professionalFieldName);
        map.put("setupId", setupId);
        map.put("taskId", taskId);
        map.put("unitPathIds", unitPathIds);
        map.put("parentUnitPathIds", parentUnitPathIds);
        System.out.println(">>>>>>>>applyUnitCode="+applyUnitCode);
        StringBuffer applyUnitCodeStr=new StringBuffer();
        if(!applyUnitCode.equals(""))
        {
            applyUnitCodeStr.append(" (");
            String arr[]=applyUnitCode.split(",");
            for(int i=0;i<arr.length;i++)
            {
                if(i>0)
                {
                    applyUnitCodeStr.append(" OR FIND_IN_SET('"+arr[i]+"', t.`apply_unit_code`)");
                }else
                {
                    applyUnitCodeStr.append("FIND_IN_SET('"+arr[i]+"', t.`apply_unit_code`)");
                }

            }
            applyUnitCodeStr.append(" )");
        }

        map.put("sqlStr", applyUnitCodeStr.toString());

        System.out.println(">>>>>>>>sqlstr"+applyUnitCodeStr.toString());
        List<SreProject> list = sreProjectMapper.getList(map);//获取所有课题ID
        List<SreProject> prolist = new ArrayList<SreProject>();
        //遍历获取所有课题ID
        for (SreProject sreProject : list) {
            int count = 0;
            if(sreProject.getEquipmentIds()!=null&&sreProject.getEquipmentIds()!=""){
                String[] equipmentId = sreProject.getEquipmentIds().split(",");//获取课题绑定的装备ID
                for (int i = 0; i < equipmentId.length; i++) {
                    //遍历装备ID,进行查询,获取装备采购状态
                    SreEquipment sreEquipment = sreEquipmentMapper.selectByPrimaryKey(equipmentId[i]);
                    if(sreEquipment!=null){
                        String purchaseStatus = sreEquipment.getPurchaseStatus();
                        if(purchaseStatus.equals("0")){
                        //如果当前装备采购状态等于0,代表此课题下有未采购的装备,跳出此循环
                        count++;//记录当前装备采购标示
                        break;
                        }
                    }
                }
                //如果count大于0,代表此课题下有未采购的装备,将此课题信息放到新prolist集合返回前台
                if(count>0){
                    prolist.add(sreProject);
                }
            }
        }
        PageInfo<SreProject> pageInfo = new PageInfo<SreProject>(prolist);
        System.out.println(">>>>>>>>>查询分页结果"+pageInfo.getList().size());

        LayuiTableData data = new LayuiTableData();
        data.setData(pageInfo.getList());
        Long total = pageInfo.getTotal();
        data.setCount(total.intValue());
        return data;
    }
}
