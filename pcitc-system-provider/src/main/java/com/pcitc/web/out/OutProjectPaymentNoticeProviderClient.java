package com.pcitc.web.out;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.base.stp.out.OutProjectPaymentplan;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.service.out.OutProjectPaymentplanService;
import com.pcitc.service.out.OutProjectService;
import com.pcitc.service.system.SysDictionaryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="报销计划-报销计划项管理",tags= {"报销计划-报销计划项管理"})
@RestController
public class OutProjectPaymentNoticeProviderClient 
{

	@Autowired
	private OutProjectPaymentplanService outProjectPaymentplanService;
	
	@Autowired
	private OutProjectService outProjectService;
	
	@Autowired
	private SysDictionaryService dictionaryService;
	
	
	@ApiOperation(value="报销批次-拨付计划批次",notes="按年度获取拨付批次号列表")
	@RequestMapping(value = "/out-provider/out/project-paymentnotice-batchs/{nd}", method = RequestMethod.POST)
	public Object selectOutProjectInfoPaymentnoticeBatchs(@PathVariable("nd") String nd) 
	{
		List<Map<String,Object>> rsdata = new ArrayList<Map<String,Object>>();
		try
		{
			List<SysDictionary> dictionarys = dictionaryService.getDictionaryListByParentCode("ROOT_YSGL_JFBXPCZD");
			for(SysDictionary dic:dictionarys) {
				Map<String,Object> map = MyBeanUtils.transBean2Map(dic);
				//map.put("auditStatusDesc", BudgetAuditStatusEnum.getStatusByCode(dt.getAuditStatus()).getDesc());
				rsdata.add(map);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rsdata;
	}
	
	
	@ApiOperation(value="报销计划项管理-报销计划项保存",notes="保存报销计划项")
	@RequestMapping(value = "/out-provider/out/project-paymentnotice-save", method = RequestMethod.POST)
	public Object saveOutProjectInfoPaymentnotice(@RequestBody OutProjectPaymentplan bean) 
	{
		Result rs = new Result(false);
		try
		{
			OutProjectPaymentplan old = outProjectPaymentplanService.selectOutProjectPaymentplan(bean.getDataId());
			if(old == null) {
				rs = outProjectPaymentplanService.saveOutProjectPaymentplan(bean);
			}else {
				rs = outProjectPaymentplanService.updateOutProjectPaymentplan(bean);
			}
			OutProjectInfo info = outProjectService.selectOutProjectInfo(bean.getProjectId());
			if(info != null) {
				info.setDefine18(bean.getPayNo());
				outProjectService.updateOutProject_Info(info);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	@ApiOperation(value = "查询公司信息", notes = "查询待发送公告公司列表")
	@RequestMapping(value = "/out-provider/out/company-list", method = RequestMethod.POST)
	public Object selectPaymentCompany(@RequestBody LayuiTableParam param,HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		LayuiTableData data = outProjectService.selectPaymentCompany(param);
		List<String> define8s = new ArrayList<String>();
		for(java.util.Iterator<?> iter = data.getData().iterator();iter.hasNext();) 
		{
			JSONObject json = JSON.parseObject(JSON.toJSONString(iter.next()));
			define8s.add(json.getString("define8"));
		}
		Map<String,Object> paramMap = param.getParam();
		paramMap.put("paymentStatus", "1");
		paramMap.put("define8s", define8s);
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		if(define8s.size()<=0) {
			return data;
		}
		List<Map<String,Object>> infos = outProjectService.selectProjectInfoByCondition(paramMap);
		int id = 1;
		for(java.util.Iterator<?> iter = data.getData().iterator();iter.hasNext();) 
		{
			JSONObject json = JSON.parseObject(JSON.toJSONString(iter.next()));
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("pId", "000");
			map.put("id", id);
			map.put("define8", json.get("define8"));
			list.add(map);
			
			List<Map<String,Object>> slist = infos.stream().filter(a -> json.get("define8").equals(a.get("define8"))).collect(Collectors.toList());
			int j = 0;
			for(Map<String,Object> mp:slist) {
				mp.put("id", id+100+j);
				mp.put("pId", id);
				j++;
				list.add(mp);
			}
			id++;
		}
		data.setData(list);
		System.out.println(JSON.toJSONString(data));
		return data;
	}
}
