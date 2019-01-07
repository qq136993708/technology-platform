package com.pcitc.service.out.impl;

import java.util.ArrayList;
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
import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.mapper.out.OutAppraisalMapper;
import com.pcitc.service.out.OutAppraisalService;
import com.pcitc.utils.StringUtils;

@Service("outAppraisalService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class OutAppraisalServiceImpl implements OutAppraisalService {

	@Autowired
	private OutAppraisalMapper outAppraisalMapper;

	private final static Logger logger = LoggerFactory.getLogger(OutAppraisalServiceImpl.class);
	
	/**
	 * 分页显示项目的科研成果信息,统计的第三级展示
	 */
	public LayuiTableData getAppraisalInfoByCond(LayuiTableParam param) {
		
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(param.getPage(), param.getLimit());
		
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		
		if(param.getParam().get("xmmc") !=null && !StringUtils.isBlank(param.getParam().get("xmmc")+"")){
			hashmap.put("xmmc", param.getParam().get("xmmc"));
		}
		
		if(param.getParam().get("hth") !=null && !StringUtils.isBlank(param.getParam().get("hth")+"")){
			hashmap.put("hth", param.getParam().get("hth"));
		}
		// 8大院等细分结构
		if(param.getParam().get("define1") !=null && !StringUtils.isBlank(param.getParam().get("define1")+"")){
			List define1 = new ArrayList();
			String[] temS = param.getParam().get("define1").toString().split(",");
			for (int i = 0; i < temS.length; i++) {
				define1.add(temS[i]);
			}
			hashmap.put("define1", define1);
		}
		
		// 9个机构分类
		if(param.getParam().get("define3") !=null && !StringUtils.isBlank(param.getParam().get("define3")+"")){
			List define3 = new ArrayList();
			String[] temS = param.getParam().get("define3").toString().split(",");
			for (int i = 0; i < temS.length; i++) {
				define3.add(temS[i]);
			}
			hashmap.put("define3", define3);
		}
		
		// 国家项目、重大专项、重点项目、其他项目
		if(param.getParam().get("project_property") !=null && !StringUtils.isBlank(param.getParam().get("project_property")+"")){
			List project_property = new ArrayList();
			String[] temS = param.getParam().get("project_property").toString().split(",");
			for (int i = 0; i < temS.length; i++) {
				project_property.add(temS[i]);
			}
			hashmap.put("project_property", project_property);
		}
		
		// A.工业化   B.工业试验等
		if(param.getParam().get("cglx") !=null && !StringUtils.isBlank(param.getParam().get("cglx")+"")){
			
			List cglx = new ArrayList();
			String[] temS = param.getParam().get("cglx").toString().split(",");
			for (int i = 0; i < temS.length; i++) {
				cglx.add(temS[i]);
			}
			hashmap.put("cglx", cglx);
		}
		
		// 装备的各种技术类型
		if(param.getParam().get("zy") !=null && !StringUtils.isBlank(param.getParam().get("zy")+"")){
			List zy = new ArrayList();
			String[] temS = param.getParam().get("zy").toString().split(",");
			for (int i = 0; i < temS.length; i++) {
				zy.add(temS[i]);
			}
			hashmap.put("zy", zy);
		}
		
		
		if(param.getParam().get("nd") !=null && !StringUtils.isBlank(param.getParam().get("nd")+"")){
			hashmap.put("nd", param.getParam().get("nd"));
		}
		System.out.println("1234>>>>>>>>>ysnd" + param.getParam().get("ysnd"));
		System.out.println("1234>>>>>>>>>zycmc" + param.getParam().get("zycmc"));
		System.out.println("1234>>>>>>>>>zylb" + param.getParam().get("zylb"));
		System.out.println("1234>>>>>>>>>type_flag" + param.getParam().get("type_flag"));
		System.out.println("1234>>>>>>>>>define1" + param.getParam().get("define1"));
		System.out.println("1234>>>>>>>>>define2" + param.getParam().get("define2"));
		
		if(param.getParam().get("ysnd") !=null && !StringUtils.isBlank(param.getParam().get("ysnd")+"")){
			hashmap.put("ysnd", param.getParam().get("ysnd"));
		}
		
		List<OutAppraisal> list = outAppraisalMapper.getAppraisalInfoByCond(hashmap);
		System.out.println("1>>>>>>>>>查询分页结果" + list.size());
		PageInfo<OutAppraisal> pageInfo = new PageInfo<OutAppraisal>(list);
		System.out.println("2>>>>>>>>>查询分页结果" + pageInfo.getList().size());

		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	public int insertAppraisalData(List<OutAppraisal> list, String nd) {
		// 删除数据
		OutAppraisalExample example = new OutAppraisalExample();
		outAppraisalMapper.deleteByExample(example);

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
	
	/**
	 * 获取成果详细的查询条件
	 */
	public List getAppraisalInfoSelectCondition(HashMap<String, String> map) {
		return outAppraisalMapper.getAppraisalInfoSelectCondition(map);
	}
	
	
}
