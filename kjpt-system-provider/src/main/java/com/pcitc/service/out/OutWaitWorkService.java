package com.pcitc.service.out;

import java.util.List;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.out.OutAppraisal;
import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.base.stp.out.OutWaitWork;

public interface OutWaitWorkService {

	public LayuiTableData getOutWaitWorkPage(LayuiTableParam param) throws Exception;

	public List getOutWaitWorkList(OutWaitWork outWaitWork) throws Exception;

	public OutWaitWork selectOutWaitWork(Long id) throws Exception;

	public Integer updateOutWaitWork(OutWaitWork record) throws Exception;

	public int deleteOutWaitWork(Long id) throws Exception;

	public Integer insertOutWaitWork(OutWaitWork record) throws Exception;

	public int deleteOutWaitWorkByType(String type) throws Exception;

	public int insertProjectData(List<OutProjectInfo> list, String nd);
	
	public int insertAppraisalData(List<OutAppraisal> list, String nd);
	
	/**
     * 批量插入待办任务数据
     */
    public Integer insertOutWaitWorkBatch(List<OutWaitWork> workList);

}
