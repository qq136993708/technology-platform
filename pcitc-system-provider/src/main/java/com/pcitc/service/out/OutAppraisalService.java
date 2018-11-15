package com.pcitc.service.out;

import java.util.List;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.out.OutAppraisal;

public interface OutAppraisalService {

	public int insertAppraisalData(List<OutAppraisal> list, String nd);
	
	public LayuiTableData getOutAppraisalPage(LayuiTableParam param);
	
	public int getOutAppraisalCount(String nd, String userId);
	
	OutAppraisal getOutAppraisalShowById(String dataId) throws Exception;
	
	/**
     * @param nd
     * @return
     * 得到某个年度专利申请/授权数量按专利类型分组
     */
    public List getResultInfo(String nd);
    
    /**
     * @param nd
     * @return
     * 得到某个年度专利申请/授权数量按专利类型分组
     */
    public List getResultInfoByType(String nd);
    
    /**
     * @param nd
     * @return
     * 得到某个年度专利申请/授权数量按专利类型分组
     */
    public List getResultInfoByZy(String nd);
    
    /**
     * @param nd
     * @return
     * 得到某个年度专利申请/授权数量按专利类型分组
     */
    public List getResultInfoBySix(String nd);
    
    /**
     * @param nd
     * @return
     * 得到某个年度专利申请/授权数量按专利类型分组
     */
    public List getResultInfoByEight(String nd);
}
