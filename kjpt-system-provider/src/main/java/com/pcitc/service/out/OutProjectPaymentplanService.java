package com.pcitc.service.out;

import java.util.List;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Result;
import com.pcitc.base.stp.out.OutProjectPaymentplan;

public interface OutProjectPaymentplanService
{
	
	public OutProjectPaymentplan selectOutProjectPaymentplan(String dataId);
	
	public Result saveOutProjectPaymentplan(OutProjectPaymentplan bean) throws Exception;

	public Result updateOutProjectPaymentplan(OutProjectPaymentplan bean) throws Exception;
	
	public Result saveOrUpdOutProjectPaymentplan(OutProjectPaymentplan bean) throws Exception;
	
	public Result deleteOutProjectPaymentplan(String dataId) throws Exception;
	
	public Result deleteOutProjectPaymentplanReal(String id) throws Exception;
	
	public List<OutProjectPaymentplan> selectListOutProjectPaymentplan();
	
	public List<OutProjectPaymentplan> selectListOutProjectPaymentplanByBean(OutProjectPaymentplan bean);
	
	public LayuiTableData selectTableOutProjectPaymentplan(LayuiTableParam param);
	
	/**
	 * 根据项目dataID查询
	 * @param dataId
	 * @return
	 */
	public OutProjectPaymentplan selectOutProjectPaymentplanByInfoId(String dataId);
}
