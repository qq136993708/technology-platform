package com.pcitc.service.outApi;

import java.util.List;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.out.OutProjectInfoNoticeTemplate;

public interface OutProjectInfoNoticeTemplateService
{
	
	public OutProjectInfoNoticeTemplate selectOutProjectInfoNoticeTemplate(String dataId);
	
	public Result saveOutProjectInfoNoticeTemplate(OutProjectInfoNoticeTemplate bean) throws Exception;

	public Result updateOutProjectInfoNoticeTemplate(OutProjectInfoNoticeTemplate bean) throws Exception;
	
	public Result saveOrUpdOutProjectInfoNoticeTemplate(OutProjectInfoNoticeTemplate bean) throws Exception;
	
	public Result deleteOutProjectInfoNoticeTemplate(String dataId) throws Exception;
	
	public Result deleteOutProjectInfoNoticeTemplateReal(String id) throws Exception;
	
	public List<OutProjectInfoNoticeTemplate> selectListOutProjectInfoNoticeTemplate();
	
	public List<OutProjectInfoNoticeTemplate> selectListOutProjectInfoNoticeTemplateByBean(OutProjectInfoNoticeTemplate bean);
	
	public LayuiTableData selectTableOutProjectInfoNoticeTemplate(LayuiTableParam param);
}
