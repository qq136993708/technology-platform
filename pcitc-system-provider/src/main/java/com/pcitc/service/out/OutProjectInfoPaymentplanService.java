package com.pcitc.service.out;

import java.util.List;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.out.OutProjectInfoPaymentplan;

public interface OutProjectInfoPaymentplanService
{
	
	public OutProjectInfoPaymentplan selectOutProjectInfoPaymentplan(String dataId);
	
	public Result saveOutProjectInfoPaymentplan(OutProjectInfoPaymentplan bean) throws Exception;

	public Result updateOutProjectInfoPaymentplan(OutProjectInfoPaymentplan bean) throws Exception;
	
	public Result saveOrUpdOutProjectInfoPaymentplan(OutProjectInfoPaymentplan bean) throws Exception;
	
	public Result deleteOutProjectInfoPaymentplan(String dataId) throws Exception;
	
	public Result deleteOutProjectInfoPaymentplanReal(String id) throws Exception;
	
	public List<OutProjectInfoPaymentplan> selectListOutProjectInfoPaymentplan();
	
	public List<OutProjectInfoPaymentplan> selectListOutProjectInfoPaymentplanByBean(OutProjectInfoPaymentplan bean);
	
	public LayuiTableData selectTableOutProjectInfoPaymentplan(LayuiTableParam param);
}
