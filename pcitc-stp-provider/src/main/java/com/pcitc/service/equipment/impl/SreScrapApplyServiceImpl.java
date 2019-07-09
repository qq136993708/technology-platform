package com.pcitc.service.equipment.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.internal.compiler.ast.ArrayAllocationExpression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.Constant;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.equipment.SreDetail;
import com.pcitc.base.stp.equipment.SreEquipmentLedger;
import com.pcitc.base.stp.equipment.SreForApplication;
import com.pcitc.base.stp.equipment.SreProjectAudit;
import com.pcitc.base.stp.equipment.SreProjectTask;
import com.pcitc.base.stp.equipment.SrePurchase;
import com.pcitc.base.stp.equipment.SreScrapApply;
import com.pcitc.mapper.equipment.SreDetailMapper;
import com.pcitc.mapper.equipment.SreEquipmentLedgerMapper;
import com.pcitc.mapper.equipment.SreForApplicationMapper;
import com.pcitc.mapper.equipment.SreProjectAuditMapper;
import com.pcitc.mapper.equipment.SreProjectTaskMapper;
import com.pcitc.mapper.equipment.SreScrapApplyMapper;
import com.pcitc.service.equipment.SreScrapApplyService;
import com.pcitc.service.feign.WorkflowRemoteClient;
@Service("sreScrapApplyService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class SreScrapApplyServiceImpl implements SreScrapApplyService {
	
	private final static Logger logger = LoggerFactory.getLogger(SreScrapApplyServiceImpl.class); 
	@Autowired
	private SreScrapApplyMapper sreScrapApplyMapper;
	
	@Autowired
	private SreProjectTaskMapper sreProjectTaskMapper;
	@Autowired
	private SreProjectAuditMapper sreProjectAuditMapper;
    @Autowired
	private WorkflowRemoteClient workflowRemoteClient;
    @Autowired
	private SreDetailMapper detailMapper;
    @Autowired
	private SreEquipmentLedgerMapper sreEquipmentLedgerMapper;
    
	public LayuiTableData getSreScrapApplyPage(LayuiTableParam param)throws Exception
	{
		
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		String ApplyName=getTableParam(param,"name","");
//		String applicationId=getTableParam(param,"applicationId","");
//		String applicationName=getTableParam(param,"applicationName","");
//		String applicationUserName=getTableParam(param,"applicationUserName","");
//		String applicationTime=getTableParam(param,"applicationTime","");
//		String applicationMoney=getTableParam(param,"applicationMoney","");
//		
		Map map=new HashMap();
		map.put("ApplyName", ApplyName);
//		map.put("applicationState", applicationState);
//		map.put("applicationName", applicationName);
//		map.put("applicationUserName", applicationUserName);
//		map.put("applicationTime", applicationTime);
//		map.put("applicationMoney", applicationMoney);
//		
//		System.out.println(">>>>>>>>applicationState="+applicationState);
		
		List<SreScrapApply> list = sreScrapApplyMapper.getlist(map);
		PageInfo<SreScrapApply> pageInfo = new PageInfo<SreScrapApply>(list);
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
	    return data;
	}
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
	public int insert(SreScrapApply record)throws Exception
	{
		return sreScrapApplyMapper.insert(record);
	}
	
	public SreScrapApply selectByPrimaryKey(String id)throws Exception
	{
		return  sreScrapApplyMapper.selectByPrimaryKey(id);
	}
	
	
	public LayuiTableData scrApplyByPrimaryKey(LayuiTableParam param)
	{
		
		//每页显示条数
		int pageSize = param.getLimit();
		//从第多少条开始
		int pageStart = (param.getPage()-1)*pageSize;
		//当前是第几页
		int pageNum = pageStart/pageSize + 1;
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		String id=getTableParam(param,"id","");
		Map map=new HashMap();
		map.put("id", id);
		List<SreScrapApply> sreScrapApply = sreScrapApplyMapper.getlist(map);
		SreScrapApply sreScrapply =  new SreScrapApply();
		List<SreScrapApply> listsre = new ArrayList<SreScrapApply>();
		if(sreScrapApply.size()!=0) {
			for(SreScrapApply apply : sreScrapApply) {
			if(apply.getCreateUserId()!=null) {
				String[] str = apply.getCreateUserId().split(",");
				for(int i = 0; i<str.length; i++) {
					SreScrapApply sserApply = new SreScrapApply();
					SreDetail sredetail = detailMapper.selectaRchaseidKey(str[i]);
					if(sredetail!=null) {
						Date dBefore = new Date();
						Calendar   calendar= Calendar.getInstance();
				        calendar.setTime(dBefore);
				        calendar.set(Calendar.MONTH,calendar.get(Calendar.MONTH)-1);
				        System.out.println(calendar.getTime());
						SimpleDateFormat df = new SimpleDateFormat("yyyyMM");//设置日期格式
						map.put("g0cald", df.format(calendar.getTime()));
						map.put("g0anln1", sredetail.getAssetNumber());
						map.put("g0gsdm", sredetail.getSupplier());
						sserApply.setName(apply.getName());//获取报废名称
						sserApply.setCreateUser(sredetail.getEquipmentName());//获取装备名称
						sserApply.setApplicationNumber(sredetail.getAssetNumber());//资产编号
						sserApply.setUpdateUser(sredetail.getSupplier());//公司代码
						sserApply.setRemarks(apply.getRemarks());//申请部门
						List<SreEquipmentLedger> sreequin  = sreEquipmentLedgerMapper.getSreDetailId(map);
						if(sreequin.size()!=0) {
						for(SreEquipmentLedger ledasd : sreequin) {
							if(ledasd!=null) {
								String string = ledasd.getG0ndjar().toString().substring(1,2);
								if(string.equals("0")) {
									sserApply.setG0NDURJ(ledasd.getG0ndjar().toString().substring(2)+"年");//使用年限
								}else {
									sserApply.setG0NDURJ(ledasd.getG0ndjar().toString().substring(1)+"年");//使用年限
								}
								sserApply.setG0SCHRW(ledasd.getG0schrw().toString());//资产残值
								sserApply.setG0LJGZYZJE(ledasd.getG0ljgzyzje().toString());//账面净额
								sserApply.setG0LJDJZJJE(ledasd.getG0ljdjzjje().toString());//预付定金
								sserApply.setG0NCGZYZJE(ledasd.getG0ncgzyzje().toString());//年初购置价值
								sserApply.setG0LJZJJE(ledasd.getG0ljzjje().toString());//累计折旧
							}
							listsre.add(sserApply);
						  }
					}
				}
			}
		  }
		}
	}
		PageInfo<SreScrapApply> pageInfo = new PageInfo<SreScrapApply>(listsre);
		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
	    return data;
	}
	//报废详情
	
	public int updateByPrimaryKeySelective(SreScrapApply record)throws Exception
	{
		return sreScrapApplyMapper.updateByPrimaryKeySelective(record);
	}
	
	public String addAudit(SreProjectAudit sreProjectAudit)throws Exception
	{
		try {
			if (sreProjectAudit != null && sreProjectAudit.getProjecttaskid() != null) {
			sreProjectAuditMapper.insert(sreProjectAudit);
			} 
			return "success";
		} catch (Exception e) {
			return "error";
		}
	
	}
	
	 //内部确认流程
    public Result dealInnerPurchaseFlow(String id, Map map) throws Exception
    {


        JSONObject parmamss = JSONObject.parseObject(JSONObject.toJSONString(map));
        System.out.println(">>>>>>>>>>内部确认流程 dealInnerTaskFlow 参数: "+parmamss.toJSONString());


        SreScrapApply sreScrapApply = sreScrapApplyMapper.selectByPrimaryKey(id);
        String equipmentIds = sreScrapApply.getId();
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

        flowJson.put("auditDetailsPath", "/sre-sreScrapApply/view/" + id);
        flowJson.put("auditAgreeMethod", "http://pcitc-zuul/stp-proxy/sre-provider/sreScrapApply/agree_purchase/" + id);
        flowJson.put("auditRejectMethod", "http://pcitc-zuul/stp-proxy/sre-provider/sreScrapApply/reject_purchase/" + id);

        // 非必填选项，当下一步审批者需要本次任务执行人（启动者）手动选择的时候，需要auditUserIds属性
        //flowJson.put("specialAuditor0", "post--30130054_JHCBSY");
        //flowJson.put("specialAuditor1", "role--ZBGL_KJB_ZYCCZ");
		flowJson.put("specialAuditor0", "role--CGGL_BMLD");
		flowJson.put("specialAuditor1", "role--CGGL_YLD");




     
        // 远程调用
        System.out.println("=====远程调用开始");
        String str=workflowRemoteClient.startCommonWorkflow(flowJson.toJSONString());
        System.out.println("=====远程调用结束");
        if("true".equals(str))
        {
        	sreScrapApply.setStatus(Constant.SRE_SCARP_APPLY_STATUS);
        	sreScrapApplyMapper.updateByPrimaryKeySelective(sreScrapApply);
            return new Result(true,"操作成功!");
        }else
        {
            return new Result(false,"操作失败!");
        }
    }
	@Override
	public int deleteByApplyId(String id) {
		// TODO Auto-generated method stub
		return sreScrapApplyMapper.deleteByPrimaryKey(id);
	}
	
	//2019/7/8修改报废添加功能
	@Override
	public Integer insertSreScrapApply(SreScrapApply srescrapply) {
		// TODO Auto-generated method stub
		return sreScrapApplyMapper.insert(srescrapply);
	}
	@Override
	public List<SreScrapApply> selectSreScrapApplyy(String id) {
		Map map=new HashMap();
		map.put("id", id);
		List<SreScrapApply> sreScrapApply = sreScrapApplyMapper.getlist(map);
		SreScrapApply sreScrapply =  new SreScrapApply();
		List<SreScrapApply> listsre = new ArrayList<SreScrapApply>();
		if(sreScrapApply.size()!=0) {
			for(SreScrapApply apply : sreScrapApply) {
			if(apply.getCreateUserId()!=null) {
				String[] str = apply.getCreateUserId().split(",");
				for(int i = 0; i<str.length; i++) {
					SreScrapApply sserApply = new SreScrapApply();
					SreDetail sredetail = detailMapper.selectaRchaseidKey(str[i]);
					if(sredetail!=null) {
						Date dBefore = new Date();
						Calendar   calendar= Calendar.getInstance();
				        calendar.setTime(dBefore);
				        calendar.set(Calendar.MONTH,calendar.get(Calendar.MONTH)-1);
				        System.out.println(calendar.getTime());
						SimpleDateFormat df = new SimpleDateFormat("yyyyMM");//设置日期格式
						map.put("g0cald", df.format(calendar.getTime()));
						map.put("g0anln1", sredetail.getAssetNumber());
						map.put("g0gsdm", sredetail.getSupplier());
						sserApply.setName(apply.getName());//获取报废名称
						sserApply.setCreateUser(sredetail.getEquipmentName());//获取装备名称
						sserApply.setApplicationNumber(sredetail.getAssetNumber());//资产编号
						sserApply.setUpdateUser(sredetail.getSupplier());//公司代码
						sserApply.setRemarks(apply.getRemarks());//申请部门
						List<SreEquipmentLedger> sreequin  = sreEquipmentLedgerMapper.getSreDetailId(map);
						if(sreequin.size()!=0) {
						for(SreEquipmentLedger ledasd : sreequin) {
							if(ledasd!=null) {
								String string = ledasd.getG0ndjar().toString().substring(1,2);
								if(string.equals("0")) {
									sserApply.setG0NDURJ(ledasd.getG0ndjar().toString().substring(2)+"年");//使用年限
								}else {
									sserApply.setG0NDURJ(ledasd.getG0ndjar().toString().substring(1)+"年");//使用年限
								}
								sserApply.setG0SCHRW(ledasd.getG0schrw().toString());//资产残值
								sserApply.setG0LJGZYZJE(ledasd.getG0ljgzyzje().toString());//账面净额
								sserApply.setG0LJDJZJJE(ledasd.getG0ljdjzjje().toString());//预付定金
								sserApply.setG0NCGZYZJE(ledasd.getG0ncgzyzje().toString());//年初购置价值
								sserApply.setG0LJZJJE(ledasd.getG0ljzjje().toString());//累计折旧
							}
							listsre.add(sserApply);
						  }
					}
				}
			}
		  }
		}
	}
		return listsre;
	}
}
