package com.pcitc.web.equipment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.equipment.FindAppltid;
import com.pcitc.base.stp.equipment.FindView;
import com.pcitc.base.stp.equipment.SreScrapApply;
import com.pcitc.base.stp.equipment.sre_scrap_apply_item;
import com.pcitc.base.util.CommonUtil;
import com.pcitc.service.equipment.ForApplicationService;
import com.pcitc.service.equipment.SreScrapApplyItemService;
import com.pcitc.service.equipment.SreScrapApplyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "SreScrapApply-API",tags = {"报废申请"})
@RestController
public class SreScrapApplyClient {
	private final static Logger logger = LoggerFactory.getLogger(SreScrapApplyClient.class); 
	@Autowired
    private SreScrapApplyService sreScrapApplyService; 
	@Autowired
	private SreScrapApplyItemService sreScrapApplyItemService;
	@ApiOperation(value = "报废分页", notes = "报废分页")
	@RequestMapping(value = "/sre-provider/sreScrapApply/page", method = RequestMethod.POST)
	public LayuiTableData getForApplicationList(@RequestBody LayuiTableParam param)throws Exception
	{
		
		LayuiTableData rageResult=sreScrapApplyService.getSreScrapApplyPage(param);
		
		
		return rageResult;
	}


	@RequestMapping(value = "/sre-provider/sreScrapApply/getapplybyid/{id}", method = RequestMethod.GET)
	public SreScrapApply getapplybyid(@PathVariable(value = "id", required = true) String id)throws Exception{
		return sreScrapApplyService.selectByPrimaryKey(id);
	}
	
	@RequestMapping(value = "/sre-provider/sreScrapApply/selectByAppltidList/{id}", method = RequestMethod.GET)
	public List<FindAppltid> selectByAppltidList(@PathVariable(value = "id", required = true) String id)throws Exception{
		System.out.println("===================================================");
		
		return sreScrapApplyItemService.selectByAppltidList(id);
	}
	
	
	
	@RequestMapping(value = "/sre-provider/sreScrapApply/addApplyAndItem")
	@ResponseBody
	public String addApplyAndItem(@RequestBody FindView findview)throws Exception{
		String str="";
		if(findview.getAddorupdate()=="")
		{
		SreScrapApply sreScrapApply=new  SreScrapApply();
		String id = UUID.randomUUID().toString().replaceAll("-", "");
		sreScrapApply.setId(id);
		sreScrapApply.setName(findview.getName());
		sreScrapApply.setAuditStatus("0");
		sreScrapApply.setCreateUserId(findview.getUserId());
		sreScrapApply.setCreateUser(findview.getUserName());
		sreScrapApply.setCreateDate(new Date());
		int k=sreScrapApplyService.insert(sreScrapApply);
		
		if(k>0)
		{
			String[] detailid=findview.getIds().split(",");
			if(detailid.length>0)
			{
				for(int i=1;i<detailid.length;i++)
				{
					sre_scrap_apply_item s=new sre_scrap_apply_item();
					s.setAccountId(UUID.randomUUID().toString().replaceAll("-", ""));
					s.setApplyid(id);
					String did=detailid[i];
					s.setEqdetailid(did);
					s.setCreateDate(new Date());
					String Userid=findview.getUserId();
					s.setCreateUserId(Userid);
					s.setUpdateDate(new Date());
					s.setCreateUserId("1");
					System.out.println(s);
					sreScrapApplyItemService.insert(s);
				}
				
			}
			str="success";
		}
		}
		else
		{
			SreScrapApply sreScrapApply=new  SreScrapApply();
            sreScrapApply.setId(findview.getAddorupdate());
            sreScrapApply.setName(findview.getName());
            sreScrapApply.setAuditStatus("0");
            sreScrapApply.setUpdateUser(findview.getUserId());
            sreScrapApply.setUpdateTime(new Date());
            int i= sreScrapApplyService.updateByPrimaryKeySelective(sreScrapApply);
            if(i>0)
            {
            	int k = sreScrapApplyItemService.deleteByApplyId(findview.getAddorupdate());
         
            		String[] detailid=findview.getIds().split(",");
        			if(detailid.length>0)
        			{
        				for(int h=1;h<detailid.length;h++)
        				{
        					sre_scrap_apply_item s=new sre_scrap_apply_item();
        					s.setAccountId(UUID.randomUUID().toString().replaceAll("-", ""));
        					s.setApplyid(findview.getAddorupdate());
        					String did=detailid[h];
        					s.setEqdetailid(did);
        					s.setCreateDate(new Date());
        					String Userid=findview.getUserId();
        					s.setCreateUserId(Userid);
        					s.setUpdateDate(new Date());
        					s.setCreateUserId("1");
        					System.out.println(s);
        					sreScrapApplyItemService.insert(s);
        				}
        				
        			}
        			str="success"; 
	         	}
	  }
		return str;
	 }
}
