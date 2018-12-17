package com.pcitc.service.out.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.pcitc.base.stp.out.OutAppraisal;
import com.pcitc.base.stp.out.OutAppraisalExample;
import com.pcitc.mapper.out.OutAppraisalMapper;
import com.pcitc.service.out.OutAppraisalService;

@Service("outAppraisalService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class OutAppraisalServiceImpl implements OutAppraisalService {

	@Autowired
	private OutAppraisalMapper outAppraisalMapper;

	private final static Logger logger = LoggerFactory.getLogger(OutAppraisalServiceImpl.class);

	public int insertAppraisalData(List<OutAppraisal> list, String nd) {
		// 删除年度数据
		//OutAppraisalExample example = new OutAppraisalExample();
		//outAppraisalMapper.deleteByExample(example);

		// 批量插入数据
		outAppraisalMapper.insertOutAppraisalBatch(list);
		return 1;
	}

	public LayuiTableData getOutAppraisalPage(LayuiTableParam param) {
		Map<String, Object> paraMap = param.getParam();

		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(param.getPage(), param.getLimit());

		OutAppraisalExample example = new OutAppraisalExample();
		OutAppraisalExample.Criteria criteria = example.createCriteria();

		if (paraMap.get("cgmc") != null && !paraMap.get("cgmc").equals("")) {
			criteria.andCgmcLike("%" + paraMap.get("cgmc").toString() + "%");
		}
		if (paraMap.get("hth") != null && !paraMap.get("hth").equals("")) {
			criteria.andHthLike("%" + paraMap.get("hth").toString() + "%");
		}
		if (paraMap.get("xmmc") != null && !paraMap.get("xmmc").equals("")) {
			criteria.andXmmcLike("%" + paraMap.get("xmmc").toString() + "%");
		}
		if (paraMap.get("nd") != null && !"".equals(paraMap.get("nd"))) {
			criteria.andNdEqualTo(paraMap.get("nd").toString());
		}
		example.setOrderByClause(" nd desc ");

		List<OutAppraisal> list = outAppraisalMapper.selectByExample(example);
		PageInfo<OutAppraisal> pageInfo = new PageInfo<OutAppraisal>(list);
		System.out.println(">>>>>>>>>查询分页结果" + pageInfo.getList().size());

		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	/*
	 * (non-Javadoc) 查询当年的总数
	 * 
	 * @see
	 * com.pcitc.service.out.OutAppraisalService#getOutAppraisalCount(java.lang
	 * .String, java.lang.String)
	 */
	public int getOutAppraisalCount(HashMap<String, String> map) {

		return outAppraisalMapper.getOutAppraisalCount(map);
	}

	@Override
	public OutAppraisal getOutAppraisalShowById(String dataId) {
		return outAppraisalMapper.selectByPrimaryKey(dataId);
	}

	/**
	 * @param nd
	 * @return 得到某个年度专利申请/授权数量按专利类型分组
	 */
	public List getResultInfo(String nd) {
		return outAppraisalMapper.getResultInfo(nd);
	}

	/**
	 * @param nd
	 * @return 得到某个年度专利申请/授权数量按专利类型分组
	 */
	public List getResultInfoByType(String nd) {
		return outAppraisalMapper.getResultInfoByType(nd);
	}

	/**
	 * @param nd
	 * @return 得到某个年度专利申请/授权数量按专利类型分组
	 */
	public List getResultInfoByZy(String nd) {
		return outAppraisalMapper.getResultInfoByZy(nd);
	}
	
	/**
     * @param nd
     * @return
     * 得到某个年度专利申请/授权数量按专利类型分组
     */
    public List getResultInfoBySix(String nd) {
    	return outAppraisalMapper.getResultInfoBySix(nd);
    }
    
    /**
     * @param nd
     * @return
     * 得到某个年度专利申请/授权数量按专利类型分组
     */
    public List getResultInfoByEight(String nd) {
    	return outAppraisalMapper.getResultInfoByEight(nd);
    }
    
    /**
     * 领导二级页面，各个研究院的成果情况, 每一行是一个院
     */
	public List getAppraisalInfoByInstitute(HashMap<String, String> map) {
		return outAppraisalMapper.getAppraisalInfoByInstitute(map);
	}
	
	/**
     * 领导二级页面，各种类型的成果情况
     */
	public List getAppraisalInfoByCglx(HashMap<String, String> map) {
		return outAppraisalMapper.getAppraisalInfoByCglx(map);
	}
	
	/**
     * 领导二级页面，各种专业的成果情况
     */
	public List getAppraisalInfoByZy(HashMap<String, String> map) {
		return outAppraisalMapper.getAppraisalInfoByZy(map);
	}
	
	/**
     * 领导首页-科研成果，直属院、分子公司等9个的成果情况
     */
	public List getAppraisalInfoByCompanyType(HashMap<String, String> map) {
		return outAppraisalMapper.getAppraisalInfoByCompanyType(map);
	}
	
	
}
