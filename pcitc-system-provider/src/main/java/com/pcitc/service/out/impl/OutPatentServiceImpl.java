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
import com.pcitc.base.stp.out.OutPatent;
import com.pcitc.base.stp.out.OutPatentExample;
import com.pcitc.base.stp.out.OutPatentWithBLOBs;
import com.pcitc.mapper.out.OutPatentMapper;
import com.pcitc.service.out.OutPatentService;

@Service("outPatentService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class OutPatentServiceImpl implements OutPatentService {

	@Autowired
	private OutPatentMapper outPatentMapper;

	private final static Logger logger = LoggerFactory.getLogger(OutPatentServiceImpl.class);

	public int insertPatentData(List<OutPatentWithBLOBs> list) {
		// 删除年度数据
		// OutPatentExample example = new OutPatentExample();
		// outPatentMapper.deleteByExample(example);
		List<OutPatentWithBLOBs> insertData = new ArrayList<OutPatentWithBLOBs>();
		for (int i = 0; i < list.size(); i++) {
			//已经存在的专利，更新一下状态
			OutPatentWithBLOBs op = list.get(i);
			OutPatentExample example = new OutPatentExample();
			OutPatentExample.Criteria criteria = example.createCriteria();

			if (op.getSqh() != null && !op.getSqh().equals("")) {
				criteria.andSqhEqualTo(op.getSqh());
			}
			if (op.getWxlx() != null && !op.getWxlx().equals("")) {
				criteria.andWxlxEqualTo(op.getWxlx());
			}

			List<OutPatent> temList = outPatentMapper.selectByExample(example);
			if (temList != null && temList.size() > 0) {
				//修改状态
				OutPatent temOP = temList.get(0);
				
				temOP.setFlztyj(op.getFlztyj());
				temOP.setFlztej(op.getFlztej());
				outPatentMapper.updateByPrimaryKey(temOP);
			} else {
				insertData.add(op);
			}
		}

		// 批量插入数据
		if (insertData.size() > 0) {
			outPatentMapper.insertOutPatentBatch(insertData);
		}
		
		return 1;
	}

	public LayuiTableData getOutPatentPage(LayuiTableParam param) {
		Map<String, Object> paraMap = param.getParam();

		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(param.getPage(), param.getLimit());

		OutPatentExample example = new OutPatentExample();
		OutPatentExample.Criteria criteria = example.createCriteria();

		if (paraMap.get("fmmc") != null && !paraMap.get("fmmc").equals("")) {
			criteria.andFmmcLike("%" + paraMap.get("fmmc").toString() + "%");
		}
		if (paraMap.get("zlh") != null && !paraMap.get("zlh").equals("")) {
			criteria.andZlhLike("%" + paraMap.get("zlh").toString() + "%");
		}
		example.setOrderByClause(" zlh desc ");

		List<OutPatent> list = outPatentMapper.selectByExample(example);
		PageInfo<OutPatent> pageInfo = new PageInfo<OutPatent>(list);
		System.out.println(">>>>>>>>>查询分页结果" + pageInfo.getList().size());

		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	/**
	 * 查询年份的专利数量
	 */
	public int getOutPatentCount(HashMap<String, String> map) {

		OutPatentExample example = new OutPatentExample();
		OutPatentExample.Criteria criteria = example.createCriteria();
		criteria.andShouqrLike("%" + map.get("nd") + "%");
		criteria.andFlztyjEqualTo("有效");
		
		if (map.get("define2") != null && !map.get("define2").equals("")) {
			criteria.andDefine3Like("%" + map.get("define2") + "%");
		}
		if (map.get("define3") != null && !map.get("define3").equals("")) {
			criteria.andDefine3Like("%" + map.get("define3") + "%");
		}
		return outPatentMapper.countByExample(example);
	}

	/**
	 * 查询最大的导入日期，从这个日期开始导入
	 * 
	 * @return
	 */
	public String getMaxImportDate(String remarks) {
		return outPatentMapper.getMaxImportDate(remarks);
	}

	public List getWXLXInfo(String nd) {
		return outPatentMapper.getWXLXInfo(nd);
	}

	/**
	 * @param nd
	 * @return 得到某个年度各专利类型在各个研究院的分布
	 */
	public List getTypeInfoByUnit(String nd) {
		return outPatentMapper.getTypeInfoByUnit(nd);
	}

	/**
	 * @param nd
	 * @return 得到某个年度各专利类型在各个研究院、分公司、集团、外部单位、研发中心的分布
	 */
	public List getApplyAgreeCountBySix(String nd) {
		return outPatentMapper.getApplyAgreeCountBySix(nd);
	}

	@Override
	public LayuiTableData getWXLXDetailsInfo(LayuiTableParam param) {
		// 每页显示条数
		int pageSize = param.getLimit();
		// 当前是第几页
		int pageNum = param.getPage();
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		List list = outPatentMapper.getWXLXDetailsInfo(param.getParam());

		// 2、获取分页查询后的数据
		LayuiTableData data = new LayuiTableData();
		data.setData(list);
		data.setCount(list.size());

		return data;
	}

	/**
	 * @param nd
	 * @return 得到某个年度各专利类型在各个研究院的分布 详情页面
	 */
	public LayuiTableData getTypeInfoByUnitDetails(LayuiTableParam param) {
		// 每页显示条数
		int pageSize = param.getLimit();
		// 当前是第几页
		int pageNum = param.getPage();
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);
		List list = outPatentMapper.getTypeInfoByUnitDetails(param.getParam());

		// 2、获取分页查询后的数据
		LayuiTableData data = new LayuiTableData();
		data.setData(list);
		data.setCount(list.size());

		return data;
	}
	
	/**
     * @return
     * 领导二级页面，直属研究院，8个院专利申请、授权、发明专利数量
     */
    public List getPatentTypeCountByInstituteForLD(Map hashmap) {
    	return outPatentMapper.getPatentTypeCountByInstituteForLD(hashmap);
    }
    
    /**
     * @return
     * 领导二级页面，直属研究院，8个院发明专利、实用新型的申请和授权，2018数据申请数有问题，暂时用2015年
     */
    public List getPatentInfoByLXForInstitute(Map hashmap) {
    	return outPatentMapper.getPatentInfoByLXForInstitute(hashmap);
    }
    
    /**
     * @return
     * 领导二级页面，直属研究院，专利类型的申请、授权数量
     */
    public List getPatentInfoForLX(Map hashmap) {
    	return outPatentMapper.getPatentInfoForLX(hashmap);
    }
    
    /**
     * 领导二级页面，重点项目、国家项目、重大专项、十条龙、其他项目的新开、结转情况
     */
    public List getProjectNewOldInfoByType(Map hashmap) {
    	return outPatentMapper.getProjectNewOldInfoByType(hashmap);
    }
    
    /**
     * 领导首页-知识产权，直属研究院、分子公司等9个类型公司的发明专利、实用新型的申请和授权
     */
    public List getPatentInfoByCompanyType(Map hashmap) {
    	return outPatentMapper.getPatentInfoByCompanyType(hashmap);
    }
}
