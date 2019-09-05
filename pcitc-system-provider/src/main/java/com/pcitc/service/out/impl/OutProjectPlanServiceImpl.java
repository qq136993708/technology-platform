package com.pcitc.service.out.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.stp.out.OutProjectPlan;
import com.pcitc.base.stp.out.OutProjectPlanExample;
import com.pcitc.base.util.StrUtil;
import com.pcitc.mapper.out.OutProjectPlanMapper;
import com.pcitc.service.out.OutProjectPlanService;
import com.pcitc.utils.StringUtils;

@Service("outProjectPlanService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class OutProjectPlanServiceImpl implements OutProjectPlanService {

	@Autowired
	private OutProjectPlanMapper outProjectPlanMapper;

	private final static Logger logger = LoggerFactory.getLogger(OutProjectPlanServiceImpl.class);

	/**
	 * 领导首页--科研投入--各个处室的新开结转情况
	 */
	public List getPlanMoneyByDepartment(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));
		return outProjectPlanMapper.getPlanMoneyByDepartment(map);
	}

	/**
	 * 领导首页-科研投入-各个处室的新开结转情况, 专业处没做预算的情况下, 以数据字典中的为准
	 */
	public List getPlanMoneyByDepartmentSpecial(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));
		return outProjectPlanMapper.getPlanMoneyByDepartmentSpecial(map);
	}

	/**
	 * 批量插入项目计划数据
	 */
	public void insertOutProjectPlanBatch(List<OutProjectPlan> list) {

		List<OutProjectPlan> insertData = new ArrayList<OutProjectPlan>();
		// 先更新，没有的批量插入
		for (int i = 0; i < list.size(); i++) {
			int temInt = this.updateOutProjectPlan(list.get(i));
			if (temInt == -1) {
				insertData.add(list.get(i));
			}
		}
		System.out.println("===========新插入条数----------------" + insertData.size());
		// 批量插入新数据
		if (insertData.size() > 0) {
			outProjectPlanMapper.insertOutProjectPlanBatch(insertData);
		}

	}

	/**
	 * 判断是否有此项目计划
	 * 如果有的话，修改部分属性
	 * 如果没有的话，返回-1
	 */
	public int updateOutProjectPlan(OutProjectPlan opp) {

		OutProjectPlanExample example = new OutProjectPlanExample();
		OutProjectPlanExample.Criteria criteria = example.createCriteria();

		criteria.andXmidEqualTo(opp.getXmid());
		criteria.andDefine4EqualTo("项目管理系统");
		criteria.andYsndEqualTo(opp.getYsnd());
		List<OutProjectPlan> returnList = outProjectPlanMapper.selectByExample(example);
		if (returnList != null && returnList.size() > 0) {
			OutProjectPlan newOPI = returnList.get(0);
			if (newOPI != null) {
				if (StrUtil.isNotBlank(opp.getProjectProperty())) {
					newOPI.setProjectProperty(opp.getProjectProperty());
				}
				if (StrUtil.isNotBlank(opp.getJf())) {
					newOPI.setJf(opp.getJf());
				}

				if (StrUtil.isNotBlank(opp.getHth())) {
					newOPI.setHth(opp.getHth());
				}

				if (StrUtil.isNotBlank(opp.getYsje())) {
					newOPI.setYsje(opp.getYsje());
				}
				if (StrUtil.isNotBlank(opp.getFwdx())) {
					newOPI.setFwdx(opp.getFwdx());
				}
				if (StrUtil.isNotBlank(opp.getFwdxbm())) {
					newOPI.setFwdxbm(opp.getFwdxbm());
				}
				if (StrUtil.isNotBlank(opp.getFzdw())) {
					newOPI.setFzdw(opp.getFzdw());
				}
				if (StrUtil.isNotBlank(opp.getFzdwbm())) {
					newOPI.setFzdwbm(opp.getFzdwbm());
				}

				if (StrUtil.isNotBlank(opp.getXmlbbm())) {
					newOPI.setXmlbbm(opp.getXmlbbm());
				}
				if (StrUtil.isNotBlank(opp.getXmlbmc())) {
					newOPI.setXmlbmc(opp.getXmlbmc());
				}
				if (StrUtil.isNotBlank(opp.getZycbm())) {
					newOPI.setZycbm(opp.getZycbm());
				}
				if (StrUtil.isNotBlank(opp.getZycmc())) {
					newOPI.setZycmc(opp.getZycmc());
				}
				if (StrUtil.isNotBlank(opp.getGsbmbm())) {
					newOPI.setGsbmbm(opp.getGsbmbm());
				}
				if (StrUtil.isNotBlank(opp.getGsbmmc())) {
					newOPI.setGsbmmc(opp.getGsbmmc());
				}

				newOPI.setUpdateDate(new Date());
				return outProjectPlanMapper.updateByPrimaryKey(newOPI);
			} else {
				return 0;
			}
		} else {
			return -1;
		}
	}

	/**
	 * 批量插入项目计划预算数据
	 */
	public void insertOutProjectPlanForYS(List<OutProjectPlan> list) {

		// 修改本年的预算，没有的查询原项目信息后，保存
		for (int i = 0; i < list.size(); i++) {
			OutProjectPlan opp = list.get(i);

			OutProjectPlanExample example = new OutProjectPlanExample();
			OutProjectPlanExample.Criteria criteria = example.createCriteria();

			criteria.andDefine4EqualTo("项目管理系统");
			criteria.andYsndEqualTo(opp.getYsnd());
			criteria.andXmidEqualTo(opp.getXmid());
			criteria.andDefine9EqualTo(opp.getDefine9());

			List<OutProjectPlan> oppList = outProjectPlanMapper.selectByExample(example);

			if (oppList != null && oppList.size() > 0) {
				OutProjectPlan newOPP = oppList.get(0);
				if (StrUtil.isNotBlank(opp.getYsje())) {
					newOPP.setYsje(opp.getYsje());
				}
				if (StrUtil.isNotBlank(opp.getYsfyxje())) {
					newOPP.setYsfyxje(opp.getYsfyxje());
				}
				if (StrUtil.isNotBlank(opp.getYszbxje())) {
					newOPP.setYszbxje(opp.getYszbxje());
				}
				outProjectPlanMapper.updateByPrimaryKey(newOPP);
			} else {
				// 此项目此预算年度没有预算费用
				OutProjectPlanExample example1 = new OutProjectPlanExample();
				OutProjectPlanExample.Criteria criteria1 = example1.createCriteria();

				criteria1.andDefine4EqualTo("项目管理系统");
				criteria1.andXmidEqualTo(opp.getXmid());

				List<OutProjectPlan> insertList = outProjectPlanMapper.selectByExample(example1);
				if (insertList != null && insertList.size() > 0) {
					OutProjectPlan insertOPP = insertList.get(0);

					if (insertOPP.getDefine9() == null) {
						// 原项目主数据，无用删除
						OutProjectPlanExample example2 = new OutProjectPlanExample();
						example2.createCriteria().andDataIdEqualTo(insertOPP.getDataId());
						outProjectPlanMapper.deleteByExample(example2);
					}

					insertOPP.setYsnd(opp.getYsnd());
					insertOPP.setYsje(opp.getYsje());
					insertOPP.setDefine8(opp.getDefine8());
					insertOPP.setDefine9(opp.getDefine9());
					insertOPP.setYsfyxje(opp.getYsfyxje());
					insertOPP.setYszbxje(opp.getYszbxje());
					insertOPP.setDataId(UUID.randomUUID().toString().replaceAll("-", ""));
					outProjectPlanMapper.insert(insertOPP);
				}
			}

		}
	}

	/**
	 * 领导首页-科研投入，按照直属研究所、分子公司等9个来分组
	 */
	public List getPlanMoneyCompleteRateByCompanyType(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));
		return outProjectPlanMapper.getPlanMoneyCompleteRateByCompanyType(map);
	}

	/**
	 * 直属研究院二级页面（领导），各个院的合同预算情况
	 */
	public List getPlanMoneyCompleteRateByInstitute(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));
		return outProjectPlanMapper.getPlanMoneyCompleteRateByInstitute(map);
	}

	/**
	 * 直属研究院二级页面（领导），项目计划完成的比率，按照新开续建、资本性费用性来分组
	 */
	public List getPlanCompleteRateByOldNew(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));
		return outProjectPlanMapper.getPlanCompleteRateByOldNew(map);
	}

	/**
	 * 按照专业处分组，来统计各个专业处计划签订合同数量，实际签订合同数量
	 */
	public List getPlanCountForZYC(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));
		return outProjectPlanMapper.getPlanCountForZYC(map);
	}

	/**
	 * 直属研究院二级页面（领导），总的签订率
	 */
	public List getPlanTotalCompleteRate(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));
		return outProjectPlanMapper.getPlanTotalCompleteRate(map);
	}

	/**
	 * 直属研究院二级页面（领导），各个院的合同签订率
	 */
	public List getPlanCompleteRateByInstitute(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));
		return outProjectPlanMapper.getPlanCompleteRateByInstitute(map);
	}

	/**
	 * 首页-直属研究院，项目计划完成的比率，按照资本性费用性来分组
	 */
	public List getPlanCompleteRateByPlanType(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));
		return outProjectPlanMapper.getPlanCompleteRateByPlanType(map);
	}

	/**
	 * 首页-直属研究院，项目计划完成的比率，+ hana支付的费用，按照研究院来分组
	 */
	public List getPlanCompleteRateByPlanTypeForHana(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));
		return outProjectPlanMapper.getPlanCompleteRateByPlanTypeForHana(map);
	}

	/**
	 * 首页-直属研究院，项目计划完成的比率，+ hana支付的费用，按照月份分组
	 */
	public List getPlanCompleteRateByPlanTypeForHanaMonth(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));

		return outProjectPlanMapper.getPlanCompleteRateByPlanTypeForHanaMonth(map);
	}

	/**
	 * 领导首页-科研合同，项目计划完成的比率，按照直属研究所、分子公司等9个来分组
	 */
	public List getPlanCompleteRateByCompanyType(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));
		return outProjectPlanMapper.getPlanCompleteRateByCompanyType(map);
	}

	/**
	 * 领导首页-科研合同，科研合同签订率清单
	 */
	public List getPlanCompleteRateDetails(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));
		return outProjectPlanMapper.getPlanCompleteRateDetails(map);
	}

	/**
	 * 获取所有的项目计划数据
	 */
	public List getProjectPlanList(HashMap<String, String> map) {
		OutProjectPlanExample example = new OutProjectPlanExample();
		OutProjectPlanExample.Criteria criteria = example.createCriteria();

		criteria.andDefine4EqualTo("项目管理系统");

		List<OutProjectPlan> returnList = outProjectPlanMapper.selectByExample(example);
		return returnList;
	}

	/**
	 * 项目计划数据，涉及项目预算、项目计划详情等相关的查询时调用
	 */
	public LayuiTableData selectProjectPlanByCond(LayuiTableParam param) {
		JSONObject paramstr = JSONObject.parseObject(JSONObject.toJSONString(param));
		System.out.println(">>>>>>>>>入口-》参数：" + paramstr.toString());
		int pageSize = param.getLimit();
		int pageNum = param.getPage();
		PageHelper.startPage(pageNum, pageSize);

		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		if (param.getOrderKey() != null && !StrUtil.isBlankOrNull(param.getOrderKey().toString())) {
			// 排序，因为select后有关键字，自己手动在sql中调整。否则直接PageHelper.orderBy(param.getOrderKey().toString()
			// + " " + param.getOrderType());
			hashmap.put("orderKey", param.getOrderKey());
			hashmap.put("orderType", param.getOrderType());
		}

		if (param.getParam().get("xmmc") != null && !StringUtils.isBlank(param.getParam().get("xmmc") + "")) {
			hashmap.put("xmmc", param.getParam().get("xmmc"));
		}
		if (param.getParam().get("key") != null && !StringUtils.isBlank(param.getParam().get("key") + "")) {
			hashmap.put("key", param.getParam().get("key"));
		}

		if (param.getParam().get("fzdwflag") != null && !StringUtils.isBlank(param.getParam().get("fzdwflag") + "")) {
			hashmap.put("fzdwflag", param.getParam().get("fzdwflag"));
		}

		if (param.getParam().get("hth") != null && !StringUtils.isBlank(param.getParam().get("hth") + "")) {
			hashmap.put("hth", param.getParam().get("hth"));
		}
		if (param.getParam().get("qdbz") != null && !StringUtils.isBlank(param.getParam().get("qdbz") + "")) {
			hashmap.put("qdbz", param.getParam().get("qdbz"));
		}
		// 资本性、费用性
		if (param.getParam().get("define1") != null && !StringUtils.isBlank(param.getParam().get("define1") + "")) {
			List define1 = new ArrayList();
			String[] temS = param.getParam().get("define1").toString().split(",");
			for (int i = 0; i < temS.length; i++) {
				define1.add(temS[i]);
			}
			hashmap.put("define1", define1);
		}

		// 8大院等细分结构
		if (param.getParam().get("define2") != null && !StringUtils.isBlank(param.getParam().get("define2") + "")) {
			List define2 = new ArrayList();
			String[] temS = param.getParam().get("define2").toString().split(",");
			for (int i = 0; i < temS.length; i++) {
				define2.add(temS[i]);
			}
			hashmap.put("define2", define2);
		}
		// 承担单位的code
		if (param.getParam().get("define9") != null && !StringUtils.isBlank(param.getParam().get("define9") + "")) {
			List define9 = new ArrayList();
			String[] temS = param.getParam().get("define9").toString().split(",");
			for (int i = 0; i < temS.length; i++) {
				define9.add(temS[i]);
			}
			hashmap.put("define9", define9);
		}
		// 各个专业处
		if (param.getParam().get("define10") != null && !StringUtils.isBlank(param.getParam().get("define10") + "")) {
			List define10 = new ArrayList();
			String[] temS = param.getParam().get("define10").toString().split(",");
			for (int i = 0; i < temS.length; i++) {
				define10.add(temS[i]);
			}
			hashmap.put("define10", define10);
		}

		// 费用来源
		if (param.getParam().get("define11") != null && !StringUtils.isBlank(param.getParam().get("define11") + "")) {
			List define11 = new ArrayList();
			String[] temS = param.getParam().get("define11").toString().split(",");
			for (int i = 0; i < temS.length; i++) {
				define11.add(temS[i]);
			}
			hashmap.put("define11", define11);
		}

		// 公司性质，和out_unit本质一致，公司本质的属性，和合同没关系
		if (param.getParam().get("define12") != null && !StringUtils.isBlank(param.getParam().get("define12") + "")) {
			List define12 = new ArrayList();
			String[] temS = param.getParam().get("define12").toString().replaceAll("休斯顿研发中心", "休斯顿").replaceAll("中东研发中心", "中东").split(",");
			for (int i = 0; i < temS.length; i++) {
				define12.add(temS[i]);
			}
			hashmap.put("define12", define12);
		}

		// 国家项目、重大专项、重点项目、其他项目
		if (param.getParam().get("project_property") != null && !StringUtils.isBlank(param.getParam().get("project_property") + "")) {
			List project_property = new ArrayList();
			String[] temS = param.getParam().get("project_property").toString().split(",");
			for (int i = 0; i < temS.length; i++) {
				project_property.add(temS[i]);
			}
			hashmap.put("project_property", project_property);
		}

		// 一级单位（直属院、分子公司等）
		if (param.getParam().get("type_flag") != null && !StringUtils.isBlank(param.getParam().get("type_flag") + "")) {

			List type_flag = new ArrayList();
			String[] temS = param.getParam().get("type_flag").toString().split(",");
			for (int i = 0; i < temS.length; i++) {
				type_flag.add(temS[i]);
			}
			hashmap.put("type_flag", type_flag);
		}

		// 装备的各种技术类型
		if (param.getParam().get("zylb") != null && !StringUtils.isBlank(param.getParam().get("zylb") + "")) {
			List zylb = new ArrayList();
			String[] temS = param.getParam().get("zylb").toString().split(",");
			for (int i = 0; i < temS.length; i++) {
				zylb.add(temS[i]);
			}
			hashmap.put("zylb", zylb);
		}

		// 各个处室
		if (param.getParam().get("zycmc") != null && !StringUtils.isBlank(param.getParam().get("zycmc") + "")) {
			List zycmc = new ArrayList();
			String[] temS = param.getParam().get("zycmc").toString().split(",");
			for (int i = 0; i < temS.length; i++) {
				zycmc.add(temS[i]);
			}
			hashmap.put("zycmc", zycmc);
		}

		if (param.getParam().get("nd") != null && !StringUtils.isBlank(param.getParam().get("nd") + "")) {
			hashmap.put("nd", param.getParam().get("nd"));
		}

		if (param.getParam().get("ysnd") != null && !StringUtils.isBlank(param.getParam().get("ysnd") + "")) {
			hashmap.put("ysnd", param.getParam().get("ysnd"));
		}

		// 新开课题结转课题标志
		if (param.getParam().get("ktlx") != null && !StringUtils.isBlank(param.getParam().get("ktlx") + "")) {
			hashmap.put("ktlx", param.getParam().get("ktlx"));
		}

		if (param.getParam().get("leaderFlag") != null && !StringUtils.isBlank(param.getParam().get("leaderFlag") + "")) {
			hashmap.put("leaderFlag", String.valueOf(param.getParam().get("leaderFlag")));
		}

		// 数据控制
		this.getDataFilterCondition(hashmap, param.getParam().get("zycbm"), param.getParam().get("zylbbm"));

		// 部门-处室--专业类别, 加Flag和数据控制的字段区分出来
		if (param.getParam().get("gsbmbmFlag") != null && !StringUtils.isBlank(param.getParam().get("gsbmbmFlag") + "")) {
			hashmap.put("gsbmbmFlag", param.getParam().get("gsbmbmFlag"));
		}

		if (param.getParam().get("zylbbmFlag") != null && !StringUtils.isBlank(param.getParam().get("zylbbmFlag") + "")) {
			hashmap.put("zylbbmFlag", param.getParam().get("zylbbmFlag"));
		}

		if (param.getParam().get("zycbmFlag") != null && !StringUtils.isBlank(param.getParam().get("zycbmFlag") + "")) {
			hashmap.put("zycbmFlag", param.getParam().get("zycbmFlag"));
		}

		if (param.getParam().get("groupFlag") != null && !StringUtils.isBlank(param.getParam().get("groupFlag") + "")) {
			hashmap.put("groupFlag", param.getParam().get("groupFlag"));
		}

		if (param.getParam().get("unitName") != null && !StringUtils.isBlank(param.getParam().get("unitName") + "")) {
			hashmap.put("unitName", param.getParam().get("unitName"));
		}

		JSONObject hashmapstr = JSONObject.parseObject(JSONObject.toJSONString(hashmap));
		System.out.println(">>>>>>>>>封装后-》参数：" + hashmapstr.toString());

		List<OutProjectPlan> list = outProjectPlanMapper.selectProjectPlanByCond(hashmap);
		System.out.println("1>>>>>>>>>查询分页结果" + list.size());
		PageInfo<OutProjectPlan> pageInfo = new PageInfo<OutProjectPlan>(list);
		System.out.println("2>>>>>>>>>查询分页结果" + pageInfo.getList().size());

		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	/**
	 * 全生命周期查询，计划为起点
	 */
	public LayuiTableData selectProjectCycleByCondition(LayuiTableParam param) {
		int pageSize = param.getLimit();
		int pageNum = param.getPage();
		PageHelper.startPage(pageNum, pageSize);

		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		if (param.getOrderKey() != null && !StrUtil.isBlankOrNull(param.getOrderKey().toString())) {
			// 排序，因为select后有关键字，自己手动在sql中调整。否则直接PageHelper.orderBy(param.getOrderKey().toString()
			// + " " + param.getOrderType());
			hashmap.put("orderKey", param.getOrderKey());
			hashmap.put("orderType", param.getOrderType());
		}

		if (param.getParam().get("showType") != null && !StringUtils.isBlank(param.getParam().get("showType") + "")) {
			hashmap.put("showType", param.getParam().get("showType"));
		}

		if (param.getParam().get("xmlb") != null && !StringUtils.isBlank(param.getParam().get("xmlb") + "")) {
			hashmap.put("xmlb", param.getParam().get("xmlb"));
		}

		if (param.getParam().get("startDate") != null && !StringUtils.isBlank(param.getParam().get("startDate") + "")) {
			hashmap.put("startDate", param.getParam().get("startDate"));
		}

		if (param.getParam().get("endDate") != null && !StringUtils.isBlank(param.getParam().get("endDate") + "")) {
			hashmap.put("endDate", param.getParam().get("endDate"));
		}

		if (param.getParam().get("xmmc") != null && !StringUtils.isBlank(param.getParam().get("xmmc") + "")) {
			hashmap.put("xmmc", param.getParam().get("xmmc"));
		}

		if (param.getParam().get("leaderFlag") != null && !StringUtils.isBlank(param.getParam().get("leaderFlag") + "")) {
			hashmap.put("leaderFlag", String.valueOf(param.getParam().get("leaderFlag")));
		}

		// 数据控制
		this.getDataFilterCondition(hashmap, param.getParam().get("zycbm"), param.getParam().get("zylbbm"));

		List list = outProjectPlanMapper.selectProjectCycleByCondition(hashmap);
		PageInfo<HashMap> pageInfo = new PageInfo<HashMap>(list);

		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	/**
	 * 项目的详情：合同信息
	 */
	public LayuiTableData getScienceProcessDetails(LayuiTableParam param) {

		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		if (param.getOrderKey() != null && !StrUtil.isBlankOrNull(param.getOrderKey().toString())) {
			// 排序，因为select后有关键字，自己手动在sql中调整。否则直接PageHelper.orderBy(param.getOrderKey().toString()
			// + " " + param.getOrderType());
			hashmap.put("orderKey", param.getOrderKey());
			hashmap.put("orderType", param.getOrderType());
		}

		hashmap.put("xmid", param.getParam().get("xmid"));

		List list = outProjectPlanMapper.getScienceProcessDetails(hashmap);
		System.out.println("1>>>>>>>>>查询分页结果" + list.size());

		LayuiTableData data = new LayuiTableData();
		data.setData(list);
		data.setCount(list.size());
		return data;
	}

	/**
	 * 合同付款详情
	 */
	public LayuiTableData getContractPayDetails(LayuiTableParam param) {
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		if (param.getOrderKey() != null && !StrUtil.isBlankOrNull(param.getOrderKey().toString())) {
			// 排序，因为select后有关键字，自己手动在sql中调整。否则直接PageHelper.orderBy(param.getOrderKey().toString()
			// + " " + param.getOrderType());
			hashmap.put("orderKey", param.getOrderKey());
			hashmap.put("orderType", param.getOrderType());
		}

		if (param.getParam().get("hth") != null && !StringUtils.isBlank(param.getParam().get("hth") + "")) {
			List hth = new ArrayList();
			String[] temS = param.getParam().get("hth").toString().split(",");
			for (int i = 0; i < temS.length; i++) {
				if (temS[i] != null && !temS[i].equals("")) {
					hth.add(temS[i]);
				}
			}
			hashmap.put("hth", hth);
		}
		List list = outProjectPlanMapper.getContractPayDetails(hashmap);
		System.out.println("1>>>>>>>>>查询分页结果" + list.size());

		LayuiTableData data = new LayuiTableData();
		data.setData(list);
		data.setCount(list.size());
		return data;
	}

	/**
	 * 合同成果详情
	 */
	public LayuiTableData getContractAppraisalDetails(LayuiTableParam param) {
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		if (param.getOrderKey() != null && !StrUtil.isBlankOrNull(param.getOrderKey().toString())) {
			// 排序，因为select后有关键字，自己手动在sql中调整。否则直接PageHelper.orderBy(param.getOrderKey().toString()
			// + " " + param.getOrderType());
			hashmap.put("orderKey", param.getOrderKey());
			hashmap.put("orderType", param.getOrderType());
		}

		if (param.getParam().get("hth") != null && !StringUtils.isBlank(param.getParam().get("hth") + "")) {
			List hth = new ArrayList();
			String[] temS = param.getParam().get("hth").toString().split(",");
			for (int i = 0; i < temS.length; i++) {
				if (temS[i] != null && !temS[i].equals("")) {
					hth.add(temS[i]);
				}
			}
			hashmap.put("hth", hth);
		}
		List list = outProjectPlanMapper.getContractAppraisalDetails(hashmap);
		System.out.println("1>>>>>>>>>查询分页结果" + list.size());

		LayuiTableData data = new LayuiTableData();
		data.setData(list);
		data.setCount(list.size());
		return data;
	}

	/**
	 * 项目奖励信息
	 */
	public LayuiTableData getProjectRewardDetails(LayuiTableParam param) {
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		if (param.getOrderKey() != null && !StrUtil.isBlankOrNull(param.getOrderKey().toString())) {
			// 排序，因为select后有关键字，自己手动在sql中调整。否则直接PageHelper.orderBy(param.getOrderKey().toString()
			// + " " + param.getOrderType());
			hashmap.put("orderKey", param.getOrderKey());
			hashmap.put("orderType", param.getOrderType());
		}

		hashmap.put("xmid", param.getParam().get("xmid"));

		List list = outProjectPlanMapper.getProjectRewardDetails(hashmap);
		System.out.println("1>>>>>>>>>查询分页结果" + list.size());

		LayuiTableData data = new LayuiTableData();
		data.setData(list);
		data.setCount(list.size());
		return data;
	}

	/**
	 * 批量插入国家项目计划数据
	 */
	public void insertCountryProjectPlanBatch(List<OutProjectPlan> list, String nd) {
		// 先删除原国家项目计划数据
		OutProjectPlanExample example = new OutProjectPlanExample();
		example.createCriteria().andDefine4EqualTo("sap国家项目").andYsndEqualTo(nd);
		outProjectPlanMapper.deleteByExample(example);
		outProjectPlanMapper.insertOutProjectPlanBatch(list);
	}

	/**
	 * 直属研究院二级页面（领导），总的科研投入，数据来源于hana
	 */
	public List getTotalInvestMoneyWithHana(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));
		return outProjectPlanMapper.getTotalInvestMoneyWithHana(map);
	}

	/**
	 * 修改out_project_info、out_project_plan里面的统计属性
	 */
	public void updateProjectPropertyInfo() {
		System.out.println("====执行存储过程updateOutProjectInfo------------------------");
		outProjectPlanMapper.updateOutProjectInfo();
		System.out.println("====执行存储过程结束------------------------");

		System.out.println("====执行存储过程updateOutProjectPlan------------------------");
		outProjectPlanMapper.updateOutProjectPlan();
		System.out.println("====执行存储过程结束------------------------");
	}

	/**
	 * 领导首页-预算投入 资本性预算分组,资本性不按照专业处权限控制
	 */
	public List getOutTemMoneyTotalInfo(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));
		return outProjectPlanMapper.getOutTemMoneyTotalInfo(map);
	}

	/**
	 * 领导首页-预算投入 资本性预算分组,资本性不按照专业处权限控制
	 */
	public List getOutTemMoneyTotalInfoWithCondition(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));
		return outProjectPlanMapper.getOutTemMoneyTotalInfoWithCondition(map);
	}

	/**
	 * 领导首页-获取专项、机动的预算费用，专项和机动特殊，不按照专业处进行权限控制
	 */
	public List getOutTemMoneyDecomposeInfo(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));
		return outProjectPlanMapper.getOutTemMoneyDecomposeInfo(map);
	}

	/**
	 * 查询条件过滤处理，专业处、专业
	 * 
	 * @return
	 */
	public HashMap getDataFilterCondition(HashMap hashmap, Object zycbmPara, Object zylbbmPara) {
		if (zycbmPara != null && zycbmPara != null && !StringUtils.isBlank(zycbmPara + "")) {
			Set<String> set = new HashSet<>(Arrays.asList(zycbmPara.toString().split(",")));
			// 去重的list
			List<String> distList = new ArrayList<>(set);

			List<HashMap<String, String>> zycbmList = new ArrayList<HashMap<String, String>>();
			for (int i = 0; i < distList.size(); i++) {
				HashMap<String, String> zycbmMap = new HashMap<String, String>();
				zycbmMap.put("zycbm", distList.get(i));
				// 综合计划处特殊，和大领导查询数据权限一致
				if (distList.get(i) != null && distList.get(i).contains("30130054")) {
					if (hashmap.get("username") != null && hashmap.get("username").toString().equals("wanglj")) {
						// 特殊，只能看到综合计划处的实际，不能看到总的
					} else {
						hashmap.put("leaderFlag", "2");
						break;
					}
				}
				if (zylbbmPara != null && !StringUtils.isBlank(zylbbmPara + "") && zylbbmPara.toString().contains(distList.get(i))) {
					Set<String> zylbbmSet = new HashSet<>(Arrays.asList(zylbbmPara.toString().split(",")));
					String zylbbm = "";
					for (String str : zylbbmSet) {
						if (str.contains(distList.get(i))) {
							zylbbm = zylbbm + "," + str;
						}
					}
					if (!zylbbm.equals("")) {
						zycbmMap.put("zylbbm", zylbbm);
					}
				}
				zycbmList.add(zycbmMap);
			}
			hashmap.put("zycbmList", zycbmList);
		}
		return hashmap;
	}

	public OutProjectPlan getOutProjectPlanByXmId(String xmid) {
		return outProjectPlanMapper.getOutProjectPlanByXmId(xmid);
	}
}
