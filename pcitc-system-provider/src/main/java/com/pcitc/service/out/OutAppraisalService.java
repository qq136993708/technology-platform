package com.pcitc.service.out;

import java.util.HashMap;
import java.util.List;

import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.out.OutAppraisal;
import com.pcitc.base.stp.out.OutProjectInfo;

public interface OutAppraisalService {

	public int insertAppraisalData(List<OutAppraisal> list, String nd);
	
	public LayuiTableData getOutAppraisalPage(LayuiTableParam param);
	
	public int getOutAppraisalCount(HashMap<String, String> map);
	
	OutAppraisal getOutAppraisalShowById(String dataId) throws Exception;
	
	/**
	 * 分页显示项目的科研成果信息,统计的第三级展示
	 */
	public LayuiTableData getAppraisalInfoByCond(LayuiTableParam param);
	
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
     * 领导二级页面，各个研究院的成果情况, 每一行是一个院
     */
	public List getAppraisalInfoByInstitute(HashMap<String, String> map);
	
	/**
     * 领导二级页面，各种类型的成果情况
     */
	public List getAppraisalInfoByCglx(HashMap<String, String> map);
	
	/**
     * 领导二级页面，各种专业的成果情况
     */
	public List getAppraisalInfoByZy(HashMap<String, String> map);
    
	/**
     * 领导首页-科研成果，直属院、分子公司等9个的成果情况
     */
	public List getAppraisalInfoByCompanyType(HashMap<String, String> map);
	
	/**
	 * 获取成果详细的查询条件
	 */
	public List getAppraisalInfoSelectCondition(HashMap<String, String> map);
	
	/**
	 * 辅助决策分析，成果鉴定年度分析，近三年成果各专业分布
	 */
	public List getAppraisalInfoByZyForThreeYear(HashMap<String, String> map);
	
}
