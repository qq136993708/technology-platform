package com.pcitc.service.out.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;
import java.util.stream.Collectors;

import org.elasticsearch.action.admin.indices.analyze.AnalyzeRequest;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.expert.ZjkChoice;
import com.pcitc.base.expert.ZjkChoiceExample;
import com.pcitc.base.stp.out.OutProjectErp;
import com.pcitc.base.stp.out.OutProjectInfo;
import com.pcitc.base.stp.out.OutProjectInfoExample;
import com.pcitc.base.stp.out.OutProjectInfoWithBLOBs;
import com.pcitc.base.stp.out.TfcHotEs;
import com.pcitc.base.stp.techFamily.TechFamily;
import com.pcitc.base.stp.techFamily.TechFamilyEs;
import com.pcitc.base.util.MyBeanUtils;
import com.pcitc.base.util.StrUtil;
import com.pcitc.es.builder.BooleanCondtionBuilder;
import com.pcitc.es.clientmanager.ClientFactoryBuilder;
import com.pcitc.es.clientmanager.IndexHelperBuilder;
import com.pcitc.es.common.Result;
import com.pcitc.mapper.out.OutProjectErpMapper;
import com.pcitc.mapper.out.OutProjectInfoMapper;
import com.pcitc.mapper.out.OutRewardMapper;
import com.pcitc.service.doc.AccessorService;
import com.pcitc.service.doc.IndexAccessorService;
import com.pcitc.service.doc.impl.AccessorServiceImpl;
import com.pcitc.service.out.OutProjectService;
import com.pcitc.utils.StringUtils;
import com.pcitc.web.feign.TechFamilyProviderClient;
import com.pcitc.web.feign.ZjkBaseInfoServiceClient;

@Service("outProjectService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class OutProjectServiceImpl implements OutProjectService {

	@Autowired
	private OutProjectInfoMapper outProjectInfoMapper;

	@Autowired
	private OutProjectErpMapper outProjectErpMapper;

	@Autowired
	private OutRewardMapper outRewardMapper;

	private final static Logger logger = LoggerFactory.getLogger(OutProjectServiceImpl.class);

	/**
	 * 分页显示项目数据数据,统计的第三级展示
	 */
	public LayuiTableData selectCommonProjectByCond(LayuiTableParam param) {

		JSONObject parmamss = JSONObject.parseObject(JSONObject.toJSONString(param));
		System.out.println(">>>>>>>入口->参数： " + parmamss.toString());
		// 每页显示条数
		int pageSize = param.getLimit();
		// 当前是第几页
		int pageNum = param.getPage();
		// 1、设置分页信息，包括当前页数和每页显示的总计数
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

		if (param.getParam().get("fzdwflag") != null && !StringUtils.isBlank(param.getParam().get("fzdwflag") + "")) {
			hashmap.put("fzdwflag", param.getParam().get("fzdwflag"));
		}

		if (param.getParam().get("hth") != null && !StringUtils.isBlank(param.getParam().get("hth") + "")) {
			hashmap.put("hth", param.getParam().get("hth"));
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

		// 基础研究技术/油气勘探技术等技术
		if (param.getParam().get("define5") != null && !StringUtils.isBlank(param.getParam().get("define5") + "")) {
			List define5 = new ArrayList();
			String[] temS = param.getParam().get("define5").toString().split(",");
			for (int i = 0; i < temS.length; i++) {
				define5.add(temS[i]);
			}
			hashmap.put("define5", define5);
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

		if (param.getParam().get("leaderFlag") != null && !StringUtils.isBlank(param.getParam().get("leaderFlag") + "")) {
			hashmap.put("leaderFlag", String.valueOf(param.getParam().get("leaderFlag")));
		}

		if (param.getParam().get("ysnd") != null && !StringUtils.isBlank(param.getParam().get("ysnd") + "")) {
			hashmap.put("ysnd", param.getParam().get("ysnd"));
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
		System.out.println(">>>>>>>封装后->参数： " + hashmapstr.toString());

		List<OutProjectInfo> list = outProjectInfoMapper.selectCommonProjectByCond(hashmap);
		System.out.println("1>>>>>>>>>查询分页结果" + list.size());
		PageInfo<OutProjectInfo> pageInfo = new PageInfo<OutProjectInfo>(list);

		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
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
				// 综合计划处特殊，和大领导查询数据权限一致
				if (distList.get(i) != null && distList.get(i).contains("30130054")) {
					hashmap.put("leaderFlag", "2");
					break;
				}
				zycbmMap.put("zycbm", distList.get(i));
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

	/**
	 * 科研项目分析，包含项目基本信息，同时包含成果、奖励等信息
	 */
	public LayuiTableData selectProjectInfoWithAllInfoByCond(LayuiTableParam param) {
		JSONObject parmamss = JSONObject.parseObject(JSONObject.toJSONString(param));
		System.out.println(">>>>>>>入口->参数： " + parmamss.toString());
		// 每页显示条数
		int pageSize = param.getLimit();
		// 当前是第几页
		int pageNum = param.getPage();
		// 1、设置分页信息，包括当前页数和每页显示的总计数
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

		if (param.getParam().get("fzdwflag") != null && !StringUtils.isBlank(param.getParam().get("fzdwflag") + "")) {
			hashmap.put("fzdwflag", param.getParam().get("fzdwflag"));
		}

		if (param.getParam().get("hth") != null && !StringUtils.isBlank(param.getParam().get("hth") + "")) {
			hashmap.put("hth", param.getParam().get("hth"));
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

		// 基础研究技术/油气勘探技术等技术
		if (param.getParam().get("define5") != null && !StringUtils.isBlank(param.getParam().get("define5") + "")) {
			List define5 = new ArrayList();
			String[] temS = param.getParam().get("define5").toString().split(",");
			for (int i = 0; i < temS.length; i++) {
				define5.add(temS[i]);
			}
			hashmap.put("define5", define5);
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

		if (param.getParam().get("leaderFlag") != null && !StringUtils.isBlank(param.getParam().get("leaderFlag") + "")) {
			hashmap.put("leaderFlag", String.valueOf(param.getParam().get("leaderFlag")));
		}

		if (param.getParam().get("ysnd") != null && !StringUtils.isBlank(param.getParam().get("ysnd") + "")) {
			hashmap.put("ysnd", param.getParam().get("ysnd"));
		}

		// 数据控制, 专业处、专业
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
		System.out.println(">>>>>>>封装后->参数： " + hashmapstr.toString());

		// 先按照合同号分组获取当前页的15个合同号，再用这些合同号去获取对应查询条件下的所有数据
		List list = outProjectInfoMapper.selectProjectInfoWithAllInfoByCondForGroup(hashmap);
		PageInfo<HashMap<String, String>> pageInfo = new PageInfo<HashMap<String, String>>(list);

		LayuiTableData data = new LayuiTableData();

		List finalList = new ArrayList();

		// 利用合同号查询科研奖励数据，单独查询，联合查询效率太慢
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < pageInfo.getList().size(); i++) {
			HashMap<String, String> temMap = pageInfo.getList().get(i);
			String temHth = temMap.get("hth").toString();
			if (i == 0) {
				sb.append(temHth);
			} else {
				sb.append(",");
				sb.append(temHth);
			}
		}
		if (sb != null && sb.length() > 0) {
			HashMap<String, String> rewardMap = new HashMap<String, String>();
			rewardMap.put("hth", sb.toString());
			List rewardList = outRewardMapper.getRewardInfoForHth(rewardMap);
			for (int i = 0; i < pageInfo.getList().size(); i++) {
				HashMap<String, String> proMap = (HashMap<String, String>) pageInfo.getList().get(i);
				for (int j = 0; j < rewardList.size(); j++) {
					HashMap<String, String> temMap = (HashMap<String, String>) rewardList.get(j);
					if (temMap.get("hth") != null && temMap.get("hth").equals(proMap.get("hth")) && !proMap.get("nd").equals("合计")) {
						proMap.put("psdj", temMap.get("psdj"));
						proMap.put("xkfl", temMap.get("xkfl"));
						break;
					}
				}
			}

			// 查询这些合同号在当前查询条件下，对应的所有数据。为了保证同一分页下，都有15（limit）个合同号
			hashmap.put("hthFlag", sb.toString());
			finalList = outProjectInfoMapper.selectProjectInfoWithAllInfoByCond(hashmap);

			int realIndex = param.getLimit() * (param.getPage() - 1);
			String hth = "";
			for (int i = 0; i < finalList.size(); i++) {
				HashMap temMap = (HashMap) finalList.get(i);
				String temHth = temMap.get("hth").toString();
				if (!temHth.equals(hth)) {
					realIndex++;
					hth = temHth;
				}
				if (i == 0) {
					temMap.put("realIndex", "合计");
				} else {
					temMap.put("realIndex", realIndex);
				}

			}
		}

		data.setData(finalList);
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	/**
	 * 科研项目分析，包含项目基本信息，同时包含成果、奖励等信息
	 */
	public LayuiTableData selectProjectInfoWithAllInfoByCondTree(LayuiTableParam param) {
		JSONObject parmamss = JSONObject.parseObject(JSONObject.toJSONString(param));
		System.out.println("selectProjectInfoWithAllInfoByCondTree>>>>>>>入口->参数： " + parmamss.toString());
		// 每页显示条数
		int pageSize = param.getLimit();
		// 当前是第几页
		int pageNum = param.getPage();
		// 1、设置分页信息，包括当前页数和每页显示的总计数
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

		if (param.getParam().get("fzdwflag") != null && !StringUtils.isBlank(param.getParam().get("fzdwflag") + "")) {
			hashmap.put("fzdwflag", param.getParam().get("fzdwflag"));
		}

		if (param.getParam().get("hth") != null && !StringUtils.isBlank(param.getParam().get("hth") + "")) {
			hashmap.put("hth", param.getParam().get("hth"));
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

		// 基础研究技术/油气勘探技术等技术
		if (param.getParam().get("define5") != null && !StringUtils.isBlank(param.getParam().get("define5") + "")) {
			List define5 = new ArrayList();
			String[] temS = param.getParam().get("define5").toString().split(",");
			for (int i = 0; i < temS.length; i++) {
				define5.add(temS[i]);
			}
			hashmap.put("define5", define5);
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

		if (param.getParam().get("leaderFlag") != null && !StringUtils.isBlank(param.getParam().get("leaderFlag") + "")) {
			hashmap.put("leaderFlag", String.valueOf(param.getParam().get("leaderFlag")));
		}

		if (param.getParam().get("ysnd") != null && !StringUtils.isBlank(param.getParam().get("ysnd") + "")) {
			hashmap.put("ysnd", param.getParam().get("ysnd"));
		}

		// 数据控制, 专业处、专业
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
		System.out.println(">>>>>>>封装后->参数： " + hashmapstr.toString());

		// 20190807-添加dataId查询条件-开始
		if (!StrUtil.isNullEmpty(param.getParam().get("zjps")) && !StrUtil.isNullEmpty(param.getParam().get("dataIds"))) {
			hashmap.put("dataIds", param.getParam().get("dataIds"));
		}
		// 20190807-添加dataId查询条件-结束

		// 先按照合同号分组获取当前页的15个合同号，再用这些合同号去获取对应查询条件下的所有数据
		List list = outProjectInfoMapper.selectProjectInfoWithAllInfoByCondForGroup(hashmap);
		PageInfo<HashMap<String, String>> pageInfo = new PageInfo<HashMap<String, String>>(list);

		LayuiTableData data = new LayuiTableData();

		List finalList = new ArrayList();
		List resultList = new ArrayList();

		// 利用合同号查询科研奖励数据，单独查询，联合查询效率太慢
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < pageInfo.getList().size(); i++) {
			HashMap<String, String> temMap = pageInfo.getList().get(i);
			String temHth = temMap.get("hth").toString();
			if (i == 0) {
				sb.append(temHth);
			} else {
				sb.append(",");
				sb.append(temHth);
			}
		}
		if (sb != null && sb.length() > 0) {
			HashMap<String, String> rewardMap = new HashMap<String, String>();
			rewardMap.put("hth", sb.toString());
			List rewardList = outRewardMapper.getRewardInfoForHth(rewardMap);
			for (int i = 0; i < pageInfo.getList().size(); i++) {
				HashMap<String, String> proMap = (HashMap<String, String>) pageInfo.getList().get(i);
				for (int j = 0; j < rewardList.size(); j++) {
					HashMap<String, String> temMap = (HashMap<String, String>) rewardList.get(j);
					if (temMap.get("hth") != null && temMap.get("hth").equals(proMap.get("hth")) && !proMap.get("nd").equals("合计")) {
						proMap.put("psdj", temMap.get("psdj"));
						proMap.put("xkfl", temMap.get("xkfl"));
						break;
					}
				}
			}

			// 查询这些合同号在当前查询条件下，对应的所有数据。为了保证同一分页下，都有15（limit）个合同号
			hashmap.put("hthFlag", sb.toString());
			finalList = outProjectInfoMapper.selectProjectInfoWithAllInfoByCond(hashmap);

			if (finalList != null && finalList.size() > 1) {
				HashMap finalMap = (HashMap) finalList.get(0);
				finalMap.put("realIndex", "合计");
				finalMap.put("parent_id", "0");
				finalMap.put("id", UUID.randomUUID().toString());
				finalMap.put("lay_icon_open", "/layuiadmin/layui/images/treegrid1_open.png");
				finalMap.put("lay_icon", "/layuiadmin/layui/images/treegrid2.png");
				finalMap.put("lay_is_open", false);

				resultList.add(finalMap);
			}
			int realIndex = param.getLimit() * (param.getPage() - 1);
			String hth = "";
			for (int i = 0; i < pageInfo.getList().size(); i++) {
				realIndex++;
				HashMap temMap = pageInfo.getList().get(i);
				String temHth = temMap.get("hth").toString();
				temMap.put("realIndex", String.valueOf(realIndex));
				temMap.put("lay_icon_open", "/layuiadmin/layui/images/treegrid1_open.png");
				temMap.put("lay_icon", "/layuiadmin/layui/images/treegrid2.png");
				temMap.put("lay_is_open", false);
				resultList.add(temMap);

				List addList = new ArrayList();
				for (int j = 1; j < finalList.size(); j++) {
					HashMap finalMap = (HashMap) finalList.get(j);
					String finalHth = finalMap.get("hth").toString();
					if (finalHth.equals(temHth)) {
						finalMap.put("parent_id", temMap.get("id"));
						finalMap.put("id", UUID.randomUUID().toString());
						finalMap.put("realIndex", "");
						finalMap.put("lay_icon_open", "/layuiadmin/layui/images/treegrid1_open.png");
						finalMap.put("lay_icon", "/layuiadmin/layui/images/treegrid2.png");
						finalMap.put("lay_is_open", false);
						addList.add(finalMap);
					}
				}
				// 如果有多个孩子，就显示。就一个孩子，就不显示孩子了
				if (addList.size() > 1) {
					resultList.addAll(addList);
				}
			}
		}
		System.out.println("--------------" + resultList.size());
		System.out.println("2>>>>>>>>>任务书查询分页结果 " + JSON.toJSONString(resultList));
		data.setData(resultList);
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	/**
	 * 科研项目分析，包含项目基本信息，同时包含成果、奖励等信息
	 */
	public LayuiTableData selectProjectInfoWithAllInfoByCondYear(LayuiTableParam param) {
		JSONObject parmamss = JSONObject.parseObject(JSONObject.toJSONString(param));
		System.out.println(">>>>>>>入口->参数： " + parmamss.toString());
		// 每页显示条数
		int pageSize = param.getLimit();
		// 当前是第几页
		int pageNum = param.getPage();
		// 1、设置分页信息，包括当前页数和每页显示的总计数
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

		if (param.getParam().get("fzdwflag") != null && !StringUtils.isBlank(param.getParam().get("fzdwflag") + "")) {
			hashmap.put("fzdwflag", param.getParam().get("fzdwflag"));
		}

		if (param.getParam().get("hth") != null && !StringUtils.isBlank(param.getParam().get("hth") + "")) {
			hashmap.put("hth", param.getParam().get("hth"));
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

		// 基础研究技术/油气勘探技术等技术
		if (param.getParam().get("define5") != null && !StringUtils.isBlank(param.getParam().get("define5") + "")) {
			List define5 = new ArrayList();
			String[] temS = param.getParam().get("define5").toString().split(",");
			for (int i = 0; i < temS.length; i++) {
				define5.add(temS[i]);
			}
			hashmap.put("define5", define5);
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

		if (param.getParam().get("leaderFlag") != null && !StringUtils.isBlank(param.getParam().get("leaderFlag") + "")) {
			hashmap.put("leaderFlag", String.valueOf(param.getParam().get("leaderFlag")));
		}

		if (param.getParam().get("ysnd") != null && !StringUtils.isBlank(param.getParam().get("ysnd") + "")) {
			hashmap.put("ysnd", param.getParam().get("ysnd"));
		}

		// 数据控制, 专业处、专业
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
		System.out.println(">>>>>>>封装后->参数： " + hashmapstr.toString());

		// 先按照合同号分组获取当前页的15个合同号，再用这些合同号去获取对应查询条件下的所有数据
		List list = outProjectInfoMapper.selectProjectInfoWithAllInfoByCondForGroup(hashmap);
		PageInfo<HashMap<String, String>> pageInfo = new PageInfo<HashMap<String, String>>(list);

		LayuiTableData data = new LayuiTableData();

		List finalList = new ArrayList();
		List finalListOrder = new ArrayList();

		// 利用合同号查询科研奖励数据，单独查询，联合查询效率太慢
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < pageInfo.getList().size(); i++) {
			HashMap<String, String> temMap = pageInfo.getList().get(i);
			String temHth = temMap.get("hth").toString();
			if (i == 0) {
				sb.append(temHth);
			} else {
				sb.append(",");
				sb.append(temHth);
			}

			// 项目拆分为课题的特殊处理
			if (temMap.get("sjxmmc") != null) {
				temMap.put("ktmc", temMap.get("xmmc"));
				temMap.put("xmmc", temMap.get("sjxmmc"));
			} else {
				temMap.put("ktmc", "/");
			}
		}
		if (sb != null && sb.length() > 0) {
			HashMap<String, String> rewardMap = new HashMap<String, String>();
			rewardMap.put("hth", sb.toString());
			List rewardList = outRewardMapper.getRewardInfoForHth(rewardMap);
			for (int i = 0; i < pageInfo.getList().size(); i++) {
				HashMap<String, String> proMap = (HashMap<String, String>) pageInfo.getList().get(i);
				for (int j = 0; j < rewardList.size(); j++) {
					HashMap<String, String> temMap = (HashMap<String, String>) rewardList.get(j);
					if (temMap.get("hth") != null && temMap.get("hth").equals(proMap.get("hth")) && !proMap.get("nd").equals("合计")) {
						proMap.put("psdj", temMap.get("psdj"));
						proMap.put("xkfl", temMap.get("xkfl"));
						break;
					}
				}
			}

			// 查询这些合同号在当前查询条件下，对应的所有数据。为了保证同一分页下，都有15（limit）个合同号
			hashmap.put("hthFlag", sb.toString());
			finalList = outProjectInfoMapper.selectProjectInfoWithAllInfoByCondYear(hashmap);

			int realIndex = param.getLimit() * (param.getPage() - 1);
			String hth = "";
			for (int i = 0; i < finalList.size(); i++) {
				HashMap temMap = (HashMap) finalList.get(i);
				String temHth = temMap.get("hth").toString();
				String define8 = temMap.get("define8").toString();
				String fzdw = temMap.get("fzdw").toString();
				if (!temHth.equals(hth)) {
					realIndex++;
					hth = temHth;
				}
				// 同一个合同号内排序，承担单位为负责单位的放前面
				if (!fzdw.equals("") && fzdw.equals(define8)) {
					temMap.put("orderIndex", "0");
					temMap.put("define8", "*" + define8);
				} else {
					temMap.put("orderIndex", "1");
				}
				if (i == 0) {
					temMap.put("realIndex", "合计");
				} else {
					temMap.put("realIndex", realIndex);
				}

				// 处理上级项目名称问题
				for (int t = 0; t < pageInfo.getList().size(); t++) {
					HashMap pageMap = (HashMap) pageInfo.getList().get(t);
					if (pageMap.get("xmid").toString().equals(temMap.get("xmid").toString())) {
						// 项目拆分为课题的特殊处理
						temMap.put("ktmc", pageMap.get("ktmc"));
						temMap.put("xmmc", pageMap.get("xmmc"));
					}

				}
			}

			String xmidFlag = "";
			List finalListSmall = new ArrayList();
			// list内部分组排序, 同一个xmid内,承担单位有*在最前面（特殊情况没有*，不考虑排序）
			for (int i = 0; i < finalList.size(); i++) {
				HashMap temMap = (HashMap) finalList.get(i);
				Object temXmid = temMap.get("xmid");
				if (temXmid != null && !temXmid.toString().equals(xmidFlag)) {
					// 新的xmid
					finalListOrder.addAll(finalListSmall);
					xmidFlag = temXmid.toString();
					finalListSmall = new ArrayList();
					finalListSmall.add(temMap);
				} else {
					Object define8 = temMap.get("define8");
					if (define8 != null && define8.toString().contains("*")) {
						finalListSmall.add(0, temMap);
					} else {
						finalListSmall.add(temMap);
					}
				}
			}
			finalListOrder.addAll(finalListSmall);

		}

		data.setData(finalListOrder);
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	/**
	 * 分页显示项目数据数据,国拨项目统计的第三级展示
	 */
	public LayuiTableData selectCountryProjectByCond(LayuiTableParam param) {
		// 每页显示条数
		int pageSize = param.getLimit();
		// 当前是第几页
		int pageNum = param.getPage();
		// 1、设置分页信息，包括当前页数和每页显示的总计数
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

		if (param.getParam().get("hth") != null && !StringUtils.isBlank(param.getParam().get("hth") + "")) {
			hashmap.put("hth", param.getParam().get("hth"));
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

		if (param.getParam().get("nd") != null && !StringUtils.isBlank(param.getParam().get("nd") + "")) {
			hashmap.put("nd", param.getParam().get("nd"));
		}
		System.out.println("1234>>>>>>>>>define2" + param.getParam().get("define2"));

		if (param.getParam().get("ysnd") != null && !StringUtils.isBlank(param.getParam().get("ysnd") + "")) {
			hashmap.put("ysnd", param.getParam().get("ysnd"));
		}

		// 新开课题结转课题标志
		if (param.getParam().get("ktlx") != null && !StringUtils.isBlank(param.getParam().get("ktlx") + "")) {
			hashmap.put("ktlx", param.getParam().get("ktlx"));
		}

		List<OutProjectInfo> list = outProjectInfoMapper.selectCountryProjectByCond(hashmap);
		System.out.println("1>>>>>>>>>查询分页结果" + list.size());
		PageInfo<OutProjectInfo> pageInfo = new PageInfo<OutProjectInfo>(list);
		System.out.println("2>>>>>>>>>查询分页结果" + pageInfo.getList().size());

		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	/**
	 * 研究院首页计算装备和科研合同总数
	 */
	public HashMap<String, String> getOutProjectInfoCountWithKYZB(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));
		return outProjectInfoMapper.getOutProjectInfoCountWithKYZB(map);
	}

	/**
	 * 获取项目数据
	 */
	public List<OutProjectInfo> getProjectList(HashMap<String, String> map) {

		OutProjectInfoExample example = new OutProjectInfoExample();

		OutProjectInfoExample.Criteria criteria = example.createCriteria();

		criteria.andDefine3EqualTo("项目管理系统");
		List<OutProjectInfo> returnList = outProjectInfoMapper.selectByExample(example);
		return returnList;
	}

	/**
	 * 批量插入项目预算数据
	 */
	public int insertProjectItemData(List<OutProjectInfoWithBLOBs> list, String nd) {
		// 删除年度预算，重新获取
		// outProjectInfoMapper.deleteProjectItemByNd(nd);
		// outProjectInfoMapper.insertProjectItemData(list);

		// 修改本年的预算，没有的查询原项目信息后，保存
		for (int i = 0; i < list.size(); i++) {

			int temInt = this.updateOutProjectInfoForYS(list.get(i));

		}

		return 1;
	}

	/**
	 * 批量插入国家项目
	 *
	 * @param list
	 * @param nd
	 * @return
	 */
	public int insertCountryProjectData(List<OutProjectInfo> list, String nd) {
		// 删除删除国家项目数据
		OutProjectInfoExample example = new OutProjectInfoExample();
		example.createCriteria().andDefine3EqualTo("sap国家项目").andYsndEqualTo(nd);
		outProjectInfoMapper.deleteByExample(example);

		// 批量插入数据
		outProjectInfoMapper.insertOutProjectBatch(list);
		return 1;
	}

	public int insertProjectData(List<OutProjectInfoWithBLOBs> list, String nd) {
		// 存在某个数据，修改这个数据
		// OutProjectInfoExample example = new OutProjectInfoExample();
		// example.createCriteria().andNdEqualTo(nd);
		// outProjectInfoMapper.deleteByExample(example);
		/*
		 * // 先更新，没有的批量插入 for (int i = 0; i<list.size(); i++) { int temInt =
		 * this.updateOutProjectInfo(list.get(i)); if (temInt==-1) {
		 * insertData.add(list.get(i)); } }
		 */

		// System.out.println("===========新插入条数----------------"+insertData.size());

		List<OutProjectInfoWithBLOBs> insertData = new ArrayList<OutProjectInfoWithBLOBs>();
		for (int i = 0; i < list.size(); i++) {
			int temInt = this.updateOutProjectInfo(list.get(i));
			if (temInt == -1) {
				insertData.add(list.get(i));
			}
		}

		// 批量插入数据
		if (insertData.size() > 0) {
			outProjectInfoMapper.insertOutProjectWithBLOBsBatch(insertData);
		}

		return 1;
	}

	public int updateProjectData(List<OutProjectInfo> list, String nd) {

		List<OutProjectInfo> insertData = new ArrayList<OutProjectInfo>();
		for (int i = 0; i < list.size(); i++) {
			int temInt = this.updateOutProjectInfo1(list.get(i));
		}

		return 1;
	}

	public LayuiTableData getOutProjectPage(LayuiTableParam param) {
		// 每页显示条数
		int pageSize = param.getLimit();
		// 当前是第几页
		int pageNum = param.getPage();
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);

		OutProjectInfo opi = new OutProjectInfo();
		if (param.getParam().get("xmmc") != null && !StringUtils.isBlank(param.getParam().get("xmmc") + "")) {
			opi.setXmmc((String) param.getParam().get("xmmc"));
		}

		if (param.getParam().get("hth") != null && !StringUtils.isBlank(param.getParam().get("hth") + "")) {
			opi.setHth((String) param.getParam().get("hth"));
		}
		// 资本性、费用性
		if (param.getParam().get("define1") != null && !StringUtils.isBlank(param.getParam().get("define1") + "")) {
			opi.setDefine1((String) param.getParam().get("define1"));
		}

		// 8大院
		if (param.getParam().get("define2") != null && !StringUtils.isBlank(param.getParam().get("define2") + "")) {
			opi.setDefine2((String) param.getParam().get("define2"));
		}

		// 国家项目、重大专项、重点项目、其他项目
		if (param.getParam().get("project_property") != null && !StringUtils.isBlank(param.getParam().get("project_property") + "")) {
			opi.setProjectProperty((String) param.getParam().get("project_property"));
			System.out.println("project_property------------------------" + opi.getProjectProperty());
		}

		// 新开项目、续建项目、完工项目
		if (param.getParam().get("project_scope") != null && !StringUtils.isBlank(param.getParam().get("project_scope") + "")) {
			opi.setProjectScope((String) param.getParam().get("project_scope"));
		}

		// 直属研究院、分子公司、集团等9种类型
		if (param.getParam().get("type_flag") != null && !StringUtils.isBlank(param.getParam().get("type_flag") + "")) {
			opi.setTypeFlag((String) param.getParam().get("type_flag"));
		}

		// 装备的各种技术类型
		if (param.getParam().get("zylb") != null && !StringUtils.isBlank(param.getParam().get("zylb") + "")) {
			opi.setZylb((String) param.getParam().get("zylb"));
		}

		// 各个处室
		if (param.getParam().get("zycmc") != null && !StringUtils.isBlank(param.getParam().get("zycmc") + "")) {
			opi.setZycmc((String) param.getParam().get("zycmc"));
		}

		// 年度，暂时不用
		if (param.getParam().get("nd") != null && !StringUtils.isBlank(param.getParam().get("nd") + "")) {
			opi.setNd((String) param.getParam().get("nd"));
		}

		List<OutProjectInfo> list = outProjectInfoMapper.selectProjectByCond(opi);
		System.out.println("1>>>>>>>>>查询分页结果" + list.size());
		PageInfo<OutProjectInfo> pageInfo = new PageInfo<OutProjectInfo>(list);
		System.out.println("2>>>>>>>>>查询分页结果" + pageInfo.getList().size());

		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	public int updateOutProjectInfo(OutProjectInfoWithBLOBs opi) {

		OutProjectInfoExample example = new OutProjectInfoExample();
		OutProjectInfoExample.Criteria criteria = example.createCriteria();

		criteria.andXmidEqualTo(opi.getXmid());
		criteria.andDefine3EqualTo("项目管理系统");
		criteria.andYsndEqualTo(opi.getYsnd());
		List<OutProjectInfoWithBLOBs> returnList = outProjectInfoMapper.selectByExampleWithBLOBs(example);
		if (returnList != null && returnList.size() > 0) {
			for (int j = 0; j < returnList.size(); j++) {
				OutProjectInfoWithBLOBs newOPI = returnList.get(j);
				if (newOPI != null) {
					if (StrUtil.isNotBlank(opi.getProjectLevel())) {
						newOPI.setProjectLevel(opi.getProjectLevel());
					}
					if (StrUtil.isNotBlank(opi.getHth())) {
						newOPI.setHth(opi.getHth());
					}
					if (StrUtil.isNotBlank(opi.getProjectProperty())) {
						newOPI.setProjectProperty(opi.getProjectProperty());
					}
					if (StrUtil.isNotBlank(opi.getJf())) {
						newOPI.setJf(opi.getJf());
					}
					if (StrUtil.isNotBlank(opi.getYsnd())) {
						newOPI.setYsnd(opi.getYsnd());
					}
					if (StrUtil.isNotBlank(opi.getProjectAbc())) {
						newOPI.setProjectAbc(opi.getProjectAbc());
					}
					if (StrUtil.isNotBlank(opi.getProjectSource())) {
						newOPI.setProjectSource(opi.getProjectSource());
					}
					if (StrUtil.isNotBlank(opi.getFwdx())) {
						newOPI.setFwdx(opi.getFwdx());
					}
					if (StrUtil.isNotBlank(opi.getFwdxbm())) {
						newOPI.setFwdxbm(opi.getFwdxbm());
					}
					if (StrUtil.isNotBlank(opi.getFzdw())) {
						newOPI.setFzdw(opi.getFzdw());
					}
					if (StrUtil.isNotBlank(opi.getFzdwbm())) {
						newOPI.setFzdwbm(opi.getFzdwbm());
					}

					if (StrUtil.isNotBlank(opi.getXmlbbm())) {
						newOPI.setXmlbbm(opi.getXmlbbm());
					}
					if (StrUtil.isNotBlank(opi.getXmlbmc())) {
						newOPI.setXmlbmc(opi.getXmlbmc());
					}
					if (StrUtil.isNotBlank(opi.getZycbm())) {
						newOPI.setZycbm(opi.getZycbm());
					}
					if (StrUtil.isNotBlank(opi.getZycmc())) {
						newOPI.setZycmc(opi.getZycmc());
					}
					if (StrUtil.isNotBlank(opi.getGsbmbm())) {
						newOPI.setGsbmbm(opi.getGsbmbm());
					}
					if (StrUtil.isNotBlank(opi.getGsbmmc())) {
						newOPI.setGsbmmc(opi.getGsbmmc());
					}

					if (StrUtil.isNotBlank(opi.getLxrdh())) {
						newOPI.setLxrdh(opi.getLxrdh());
					}
					if (StrUtil.isNotBlank(opi.getLxryx())) {
						newOPI.setLxryx(opi.getLxryx());
					}
					if (StrUtil.isNotBlank(opi.getLxrxm())) {
						newOPI.setLxrxm(opi.getLxrxm());
					}
					if (StrUtil.isNotBlank(opi.getDefine16())) {
						newOPI.setDefine16(opi.getDefine16());
					}
					if (StrUtil.isNotBlank(opi.getLxbj())) {
						newOPI.setLxbj(opi.getLxbj());
					}
					if (StrUtil.isNotBlank(opi.getLxbj())) {
						newOPI.setLxbj(opi.getLxbj());
					}
					if (StrUtil.isNotBlank(opi.getYjmb())) {
						newOPI.setYjmb(opi.getYjmb());
					}
					outProjectInfoMapper.updateByPrimaryKeyWithBLOBs(newOPI);
				}
			}
			return 0;
		} else {
			/*
			 * List<OutProjectInfo> insertData = new
			 * ArrayList<OutProjectInfo>(); insertData.add(opi);
			 * outProjectInfoMapper.insertOutProjectBatch(insertData);
			 */
			return -1;
		}
	}

	public int updateOutProjectInfo1(OutProjectInfo opi) {

		OutProjectInfoExample example = new OutProjectInfoExample();
		OutProjectInfoExample.Criteria criteria = example.createCriteria();
		criteria.andXmidEqualTo(opi.getXmid());
		criteria.andDefine3EqualTo("项目管理系统");
		List<OutProjectInfo> returnList = outProjectInfoMapper.selectByExample(example);
		if (returnList != null && returnList.size() > 0) {
			for (int j = 0; j < returnList.size(); j++) {
				OutProjectInfo newOPI = returnList.get(j);
				if (newOPI != null) {
					if (StrUtil.isNotBlank(opi.getDefine16())) {
						newOPI.setDefine16(opi.getDefine16());
					}
					outProjectInfoMapper.updateByPrimaryKey(newOPI);
				}
			}
			return 0;
		} else {
			/*
			 * List<OutProjectInfo> insertData = new
			 * ArrayList<OutProjectInfo>(); insertData.add(opi);
			 * outProjectInfoMapper.insertOutProjectBatch(insertData);
			 */
			return -1;
		}
	}

	public int updateOutProjectInfoForYS(OutProjectInfoWithBLOBs opi) {

		OutProjectInfoExample example = new OutProjectInfoExample();
		OutProjectInfoExample.Criteria criteria = example.createCriteria();
		criteria.andXmidEqualTo(opi.getXmid());
		criteria.andYsndEqualTo(opi.getYsnd());
		criteria.andDefine8EqualTo(opi.getDefine8());
		criteria.andDefine3EqualTo("项目管理系统");
		List<OutProjectInfoWithBLOBs> returnList = outProjectInfoMapper.selectByExampleWithBLOBs(example);
		if (returnList != null && returnList.size() > 0) {
			OutProjectInfoWithBLOBs newOPI = returnList.get(0);
			if (StrUtil.isNotBlank(opi.getProjectLevel())) {
				newOPI.setProjectLevel(opi.getProjectLevel());
			}

			if (StrUtil.isNotBlank(opi.getProjectProperty())) {
				newOPI.setProjectProperty(opi.getProjectProperty());
			}
			if (StrUtil.isNotBlank(opi.getJf())) {
				newOPI.setJf(opi.getJf());
			}

			// 预算
			if (StrUtil.isNotBlank(opi.getYsje())) {
				newOPI.setYsje(opi.getYsje());
			}
			if (StrUtil.isNotBlank(opi.getYsfyxje())) {
				newOPI.setYsfyxje(opi.getYsfyxje());
			}
			if (StrUtil.isNotBlank(opi.getYszbxje())) {
				newOPI.setYszbxje(opi.getYszbxje());
			}
			if (StrUtil.isNotBlank(opi.getYsnd())) {
				newOPI.setYsnd(opi.getYsnd());
			}

			if (StrUtil.isNotBlank(opi.getProjectAbc())) {
				newOPI.setProjectAbc(opi.getProjectAbc());
			}
			if (StrUtil.isNotBlank(opi.getProjectSource())) {
				newOPI.setProjectSource(opi.getProjectSource());
			}
			if (StrUtil.isNotBlank(opi.getFwdx())) {
				newOPI.setFwdx(opi.getFwdx());
			}
			if (StrUtil.isNotBlank(opi.getFwdxbm())) {
				newOPI.setFwdxbm(opi.getFwdxbm());
			}
			if (StrUtil.isNotBlank(opi.getFzdw())) {
				newOPI.setFzdw(opi.getFzdw());
			}
			if (StrUtil.isNotBlank(opi.getFzdwbm())) {
				newOPI.setFzdwbm(opi.getFzdwbm());
			}

			if (StrUtil.isNotBlank(opi.getXmlbbm())) {
				newOPI.setXmlbbm(opi.getXmlbbm());
			}
			if (StrUtil.isNotBlank(opi.getXmlbmc())) {
				newOPI.setXmlbmc(opi.getXmlbmc());
			}
			if (StrUtil.isNotBlank(opi.getZycbm())) {
				newOPI.setZycbm(opi.getZycbm());
			}
			if (StrUtil.isNotBlank(opi.getZycmc())) {
				newOPI.setZycmc(opi.getZycmc());
			}
			if (StrUtil.isNotBlank(opi.getGsbmbm())) {
				newOPI.setGsbmbm(opi.getGsbmbm());
			}
			if (StrUtil.isNotBlank(opi.getGsbmmc())) {
				newOPI.setGsbmmc(opi.getGsbmmc());
			}

			if (StrUtil.isNotBlank(opi.getLxrdh())) {
				newOPI.setLxrdh(opi.getLxrdh());
			}
			if (StrUtil.isNotBlank(opi.getLxryx())) {
				newOPI.setLxryx(opi.getLxryx());
			}
			if (StrUtil.isNotBlank(opi.getLxrxm())) {
				newOPI.setLxrxm(opi.getLxrxm());
			}
			if (StrUtil.isNotBlank(opi.getLxbj())) {
				newOPI.setLxbj(opi.getLxbj());
			}
			if (StrUtil.isNotBlank(opi.getYjmb())) {
				newOPI.setYjmb(opi.getYjmb());
			}
			System.out.println("update .... ");
			return outProjectInfoMapper.updateByPrimaryKeyWithBLOBs(newOPI);
		} else {
			// 此项目此预算年度没有预算费用
			OutProjectInfoExample example1 = new OutProjectInfoExample();
			OutProjectInfoExample.Criteria criteria1 = example1.createCriteria();
			criteria1.andXmidEqualTo(opi.getXmid());
			List<OutProjectInfoWithBLOBs> insertList = outProjectInfoMapper.selectByExampleWithBLOBs(example1);
			if (insertList != null && insertList.size() > 0) {
				OutProjectInfoWithBLOBs insertOPI = insertList.get(0);
				if (insertOPI.getDefine8() == null) {
					// 原项目主数据，无用删除
					OutProjectInfoExample example2 = new OutProjectInfoExample();
					example2.createCriteria().andDataIdEqualTo(insertOPI.getDataId());
					outProjectInfoMapper.deleteByExample(example2);
				}
				insertOPI.setYsnd(opi.getYsnd());
				insertOPI.setYsje(opi.getYsje());
				insertOPI.setDataId(UUID.randomUUID().toString().replaceAll("-", ""));
				insertOPI.setCreateDate(new Date());
				insertOPI.setCreatePerson("newItem");
				insertOPI.setDefine8(opi.getDefine8());
				insertOPI.setDefine9(opi.getDefine9());
				insertOPI.setDefine3(opi.getDefine3());
				insertOPI.setYsfyxje(opi.getYsfyxje());
				insertOPI.setYszbxje(opi.getYszbxje());

				List<OutProjectInfoWithBLOBs> temList = new ArrayList<OutProjectInfoWithBLOBs>();
				temList.add(insertOPI);
				System.out.println("insert .... ");
				outProjectInfoMapper.insertOutProjectWithBLOBsBatch(temList);
				return 1;
			}
			System.out.println("插入异常------插入异常------插入异常---------" + opi.getDefine8() + "--------------------" + opi.getNd() + "-------------------" + opi.getXmid());
			return -1;
		}

	}

	/**
	 * @param nd
	 *            领导首页-直属研究院，8个研究院国家项目情况
	 */
	public List getCountryProjectByYJY(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));

		return outProjectInfoMapper.getCountryProjectByYJY(map);
	}

	/**
	 * 首页计算新开项目总数
	 */
	public HashMap<String, String> getOutProjectInfoCount(HashMap<String, String> map) {

		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));

		return outProjectInfoMapper.getOutProjectInfoCount(map);
	}

	/**
	 * 首页计算项目总金额, 包含结转和新开
	 */
	public HashMap<String, String> getOutProjectInfoMoney(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));
		return outProjectInfoMapper.getOutProjectInfoMoney(map);
	}

	/**
	 * 领导页，总的预算金额（费用性），按专业处
	 */
	public HashMap<String, String> getProjectBudgetFyxMoney(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));
		return outProjectInfoMapper.getProjectBudgetFyxMoney(map);
	}

	/**
	 * 领导首页，计算资本性预算金额。预算资本性金额没办法进行权限控制
	 */
	public HashMap<String, String> getBudgetZBXMoney(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));
		return outProjectInfoMapper.getBudgetZBXMoney(map);
	}

	public int deleteProjectErpBatch(Map map) {
		outProjectErpMapper.deleteOutProjectErpBatch(map);
		return 0;
	}

	public int insertProjectErpBatch(List<OutProjectErp> list) {
		outProjectErpMapper.insertOutProjectErpBatch(list);
		return 0;
	}

	@Override
	public OutProjectInfo getOutProjectShowById(String dataId) {
		return outProjectInfoMapper.selectByPrimaryKey(dataId);
	}

	/**
	 * @param nd
	 * @return 首页、领导首页，查询新开的国家项目、重点项目、重大项目、其他项目、总计的统计
	 */
	public HashMap<String, String> getProjectTotalInfoByNew(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));
		return outProjectInfoMapper.getProjectTotalInfoByNew(map);
	}

	/**
	 * @param nd
	 * @return 首页查询新开的国家项目、重点项目、重大项目、其他项目和去年的对比
	 */
	public HashMap<String, String> getProjectTotalCountYearAndLastYear(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));
		return outProjectInfoMapper.getProjectTotalCountYearAndLastYear(map);
	}

	/**
	 * @param nd
	 * @return 科研二级页面，按照项目类型查询新建、续建项目数量、总数量
	 */
	public List getProjectCountByProjectType(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));
		return outProjectInfoMapper.getProjectCountByProjectType(map);
	}

	/**
	 * @param nd
	 * @return 科研二级页面，按照项目类型查询新建、续建项目数量、总数量
	 */
	public List getZBProjectCountByProjectType(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));
		return outProjectInfoMapper.getZBProjectCountByProjectType(map);
	}

	/**
	 * @param nd
	 * @return 科研二级页面，预算分析，新开项目、续建项目对应的费用性金额、资本性金额统计
	 */
	public List getProjectMoneyByProjectType(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));
		return outProjectInfoMapper.getProjectMoneyByProjectType(map);
	}

	/**
	 * @param nd
	 * @return 科研二级页面，直属院、盈科等单位的费用性金额、资本性金额统计
	 */
	public List getProjectMoneyByUnit(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));
		return outProjectInfoMapper.getProjectMoneyByUnit(map);
	}

	/**
	 * @param nd
	 * @return 科研二级页面，8大院的各个新开、续建情况
	 */
	public List getProjectTypeCountByUnit(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));

		return outProjectInfoMapper.getProjectTypeCountByUnit(map);
	}

	/**
	 * @param nd
	 * @return 科研二级页面，8大院的各个新开、续建情况--装备
	 */
	public List getZBProjectTypeCountByUnit(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));

		return outProjectInfoMapper.getZBProjectTypeCountByUnit(map);
	}

	/**
	 * @param nd
	 * @return 科研二级页面，8大院的各个新开、续建情况--树结构
	 */
	public List getProjectTypeCountForTree(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));

		return outProjectInfoMapper.getProjectTypeCountForTree(map);
	}

	/**
	 * @param nd
	 * @return 科研二级页面，项目类型（国家项目、重点项目、重大项目、其他项目）的各个新开、续建情况--树结构
	 */
	public List getProjectCountByTypeForTree(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));

		return outProjectInfoMapper.getProjectCountByTypeForTree(map);
	}

	/**
	 * @param nd
	 * @return 科研二级页面，8大院的各个新开、续建情况--装备树结构
	 */
	public List getZBProjectTypeCountForTree(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));

		return outProjectInfoMapper.getZBProjectTypeCountForTree(map);
	}

	/**
	 * @param nd
	 * @return 科研二级页面，项目类型（国家项目、重点项目、重大项目、其他项目）的各个新开、续建情况--装备树结构
	 */
	public List getZBProjectCountByTypeForTree(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));

		return outProjectInfoMapper.getZBProjectCountByTypeForTree(map);
	}

	/**
	 * @param nd
	 * @return 科研二级页面，研究院的各项目的费用性金额、资本性金额统计
	 */
	/**
	 * @param nd
	 *            科研二级页面，研究院的各项目的费用性金额、资本性金额、国家项目新开数量、国家项目结转数量等统计
	 */
	public List getProjectMoneyByYJY(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));

		return outProjectInfoMapper.getProjectMoneyByYJY(map);
	}

	/**
	 * @param nd
	 * @return 科研二级页面，树形结构，费用性金额、资本性金额和新开、续建情况
	 */
	public List getProjectMoneyForTree(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));

		return outProjectInfoMapper.getProjectMoneyForTree(map);
	}

	/**
	 * @param nd
	 * @return 科研二级页面，树形结构，费用性金额、资本性金额和各研究院情况
	 */
	public List getProjectMoneyByIniAndTypeForTree(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));

		return outProjectInfoMapper.getProjectMoneyByIniAndTypeForTree(map);
	}

	/**
	 * @param nd
	 * @return 首页查询9个单位的新开、续建、完结情况-装备
	 */
	public List getZBProjectTypeInfoByUnit(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));

		return outProjectInfoMapper.getZBProjectTypeInfoByUnit(map);
	}

	/**
	 * @param nd
	 * @return 领导页的各类型项目的数量
	 */
	public List getProjectTypeCountForLD(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));

		return outProjectInfoMapper.getProjectTypeCountForLD(map);
	}

	/**
	 * @param nd
	 * @return 领导二级页面，科研项目数量按单位分析--树结构
	 */
	public List getProjectTypeCountForTreeLD(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));

		return outProjectInfoMapper.getProjectTypeCountForTreeLD(map);
	}

	/**
	 * @param nd
	 * @return 领导二级页面，直属研究院、分子公司等9个单位，各单位的新开、续建、完结情况
	 */
	public List getProjectTypeInfoByUnitLD(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));

		return outProjectInfoMapper.getProjectTypeInfoByUnitLD(map);
	}

	/**
	 * @param nd
	 * @return 领导二级页面，各个处室的新开、续建、完结情况
	 */
	public List getProjectCountByProjectTypeLD(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));

		return outProjectInfoMapper.getProjectCountByProjectTypeLD(map);
	}

	/**
	 * @param nd
	 * @return 领导二级页面，8个院新开、续建情况,每一行是一个院
	 */
	public List getProjectTypeCountByUnitLD(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));

		return outProjectInfoMapper.getProjectTypeCountByUnitLD(map);
	}

	/**
	 * 预算执行情况，包含股份公司、资产公司、集团公司的
	 */
	public List getAllBudgetWithAllLevel(HashMap<String, String> map) {
		return outProjectInfoMapper.getAllBudgetWithAllLevel(map);
	}

	/**
	 * 领导二级页面，预算数据，直属研究院、分子公司等9个维度的费用统计,树形结构
	 */
	public List getCompanyMoneyTreeWithYS(HashMap<String, String> map) {
		return outProjectInfoMapper.getCompanyMoneyTreeWithYS(map);
	}

	/**
	 * 领导二级页面，预算数据，直属研究院、分子公司等9个维度的费用统计
	 */
	public List getCompanyMoneyWithYS(HashMap<String, String> map) {
		return outProjectInfoMapper.getCompanyMoneyWithYS(map);
	}

	/**
	 * 领导二级页面，预算数据，17处室的费用统计， 树形结构
	 */
	public List getOfficeMoneyTreeWithYS(HashMap<String, String> map) {
		return outProjectInfoMapper.getOfficeMoneyTreeWithYS(map);
	}

	/**
	 * 领导二级页面，预算数据，17处室的费用统计
	 */
	public List getOfficeMoneyWithYS(HashMap<String, String> map) {
		return outProjectInfoMapper.getOfficeMoneyWithYS(map);
	}

	/**
	 * 领导二级页面，直属研究院，8个院预算金额和实际金额的统计
	 */
	public List getProjectMoneyByInstituteForLD(HashMap<String, String> map) {
		return outProjectInfoMapper.getProjectMoneyByInstituteForLD(map);
	}

	/**
	 * 领导二级页面，重大项目和十条龙项目详情
	 */
	public List getZDSTLProjectInfo(HashMap<String, String> map) {
		return outProjectInfoMapper.getZDSTLProjectInfo(map);
	}

	/**
	 * 领导二级页面，重点项目、国家项目、重大专项、十条龙、其他项目的新开、结转情况
	 */
	public List getProjectNewOldInfoByType(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));

		return outProjectInfoMapper.getProjectNewOldInfoByType(map);
	}

	/**
	 * 领导二级页面，各类型技术的新开、结转情况
	 */
	public List getProjectInfoByTecTypeWithOldNew(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));

		return outProjectInfoMapper.getProjectInfoByTecTypeWithOldNew(map);
	}

	/**
	 * 领导首页-十条龙，十条龙项目的类型分布
	 */
	public List getDragonProjectInfoByType(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));

		return outProjectInfoMapper.getDragonProjectInfoByType(map);
	}

	/**
	 * 领导首页-十条龙，十条龙项目的出入龙情况
	 */
	public List getDragonProjectInfoWithOutIn(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));

		return outProjectInfoMapper.getDragonProjectInfoWithOutIn(map);
	}

	/**
	 * 领导首页-十条龙，8个研究院的龙项目/重大专项项目分布
	 */
	public List getDragonProjectInfoByInstitute(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));

		return outProjectInfoMapper.getDragonProjectInfoByInstitute(map);
	}

	/**
	 * 领导首页-十条龙，十条龙项目的详情
	 */
	public List getDragonProjectDetails(HashMap<String, Object> map) {

		// 研究院
		if (map.get("define2") != null && !StringUtils.isBlank(map.get("define2") + "")) {
			List define2 = new ArrayList();
			String[] temS = map.get("define2").toString().split(",");
			for (int i = 0; i < temS.length; i++) {
				define2.add(temS[i]);
			}
			map.put("define2", define2);
		}

		// 项目类别
		if (map.get("xmlbmc") != null && !StringUtils.isBlank(map.get("xmlbmc") + "")) {
			List xmlbmc = new ArrayList();
			String[] temS = map.get("xmlbmc").toString().split(",");
			for (int i = 0; i < temS.length; i++) {
				xmlbmc.add(temS[i]);
			}
			map.put("xmlbmc", xmlbmc);
		}

		// 9个机构
		if (map.get("type_flag") != null && !StringUtils.isBlank(map.get("type_flag") + "")) {
			List type_flag = new ArrayList();
			String[] temS = map.get("type_flag").toString().split(",");
			for (int i = 0; i < temS.length; i++) {
				type_flag.add(temS[i]);
			}
			map.put("type_flag", type_flag);
		}

		// 6个状态
		if (map.get("status") != null && !StringUtils.isBlank(map.get("status") + "")) {
			List status = new ArrayList();
			String[] temS = map.get("status").toString().split(",");
			for (int i = 0; i < temS.length; i++) {
				status.add(temS[i]);
			}
			map.put("status", status);
		}
		System.out.println(map.get("zylbbm") + "==22222===" + map.get("zycbm"));
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));
		System.out.println(map.get("zylbbm") + "==22233322===" + map.get("zycbm"));
		return outProjectInfoMapper.getDragonProjectDetails(map);
	}

	/**
	 * @param nd
	 * @return 首页计算十条龙及重大专项项目的总数量
	 */
	public HashMap<String, String> getOutProjectDragonInfoCount(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));
		return outProjectInfoMapper.getOutProjectDragonInfoCount(map);
	}

	/**
	 * 获取项目详情的查询维度（条件）
	 */
	public List getProjectInfoSelectCondition(HashMap<String, String> map) {
		JSONObject parmamss = JSONObject.parseObject(JSONObject.toJSONString(map));
		System.out.println(">>>>>>>>获取项目详情的查询维度参数: " + parmamss.toString());
		return outProjectInfoMapper.getProjectInfoSelectCondition(map);
	}

	/**
	 * 获取十条龙详情的查询维度（条件）
	 */
	public List getDragonProjectInfoSelectCondition(HashMap<String, String> map) {
		return outProjectInfoMapper.getDragonProjectInfoSelectCondition(map);
	}

	@Override
	public LayuiTableData getOutProjectPageExpert(LayuiTableParam param) {
		// 每页显示条数
		int pageSize = param.getLimit();
		// 当前是第几页
		int pageNum = param.getPage();
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);

		OutProjectInfo opi = new OutProjectInfo();
		if (param.getParam().get("xmmc") != null && !StringUtils.isBlank(param.getParam().get("xmmc") + "")) {
			opi.setXmmc((String) param.getParam().get("xmmc"));
		}

		if (param.getParam().get("hth") != null && !StringUtils.isBlank(param.getParam().get("hth") + "")) {
			opi.setHth((String) param.getParam().get("hth"));
		}
		// 资本性、费用性
		if (param.getParam().get("define1") != null && !StringUtils.isBlank(param.getParam().get("define1") + "")) {
			opi.setDefine1((String) param.getParam().get("define1"));
		}

		// 8大院
		if (param.getParam().get("define2") != null && !StringUtils.isBlank(param.getParam().get("define2") + "")) {
			opi.setDefine2((String) param.getParam().get("define2"));
		}

		// 国家项目、重大专项、重点项目、其他项目
		if (param.getParam().get("project_property") != null && !StringUtils.isBlank(param.getParam().get("project_property") + "")) {
			opi.setProjectProperty((String) param.getParam().get("project_property"));
		}

		// 新开项目、续建项目、完工项目
		if (param.getParam().get("project_scope") != null && !StringUtils.isBlank(param.getParam().get("project_scope") + "")) {
			opi.setProjectScope((String) param.getParam().get("project_scope"));
		}

		// 直属研究院、分子公司、集团等9种类型
		if (param.getParam().get("type_flag") != null && !StringUtils.isBlank(param.getParam().get("type_flag") + "")) {
			opi.setTypeFlag((String) param.getParam().get("type_flag"));
		}

		// 装备的各种技术类型
		if (param.getParam().get("zylb") != null && !StringUtils.isBlank(param.getParam().get("zylb") + "")) {
			opi.setZylb((String) param.getParam().get("zylb"));
		}

		// 各个处室
		if (param.getParam().get("zycmc") != null && !StringUtils.isBlank(param.getParam().get("zycmc") + "")) {
			opi.setZycmc((String) param.getParam().get("zycmc"));
		}

		// 年度，暂时不用
		if (param.getParam().get("nd") != null && !StringUtils.isBlank(param.getParam().get("nd") + "")) {
			opi.setNd((String) param.getParam().get("nd"));
		}
		// if (param.getParam().get("leaderFlag") != null &&
		// !StringUtils.isBlank(param.getParam().get("leaderFlag") + "")) {
		// opi.setLeaderFlag(String.valueOf(param.getParam().get("leaderFlag")));
		// }
		// 项目ID
		if (param.getParam().get("xmid") != null && !StringUtils.isBlank(param.getParam().get("xmid") + "")) {
			opi.setXmid((String) param.getParam().get("xmid"));
		}

		// 数据控制
		if (!StrUtil.isNullEmpty(param.getParam().get("dataFilter"))) {
			opi.setDefine19("1");
			if (!StrUtil.isNullEmpty(param.getParam().get("zylbbm"))) {
				opi.setZylbbm(param.getParam().get("zylbbm").toString());
			}
			if (!StrUtil.isNullEmpty(param.getParam().get("zycbm"))) {
				opi.setZycbm(param.getParam().get("zycbm").toString());
			}
			if (!StrUtil.isNullEmpty(param.getParam().get("leaderFlag"))) {
				opi.setLeaderFlag(param.getParam().get("leaderFlag").toString());
			}

			HashMap hashMap = new HashMap();
			hashMap = this.getDataFilterCondition(hashMap, param.getParam().get("zycbm"), param.getParam().get("zylbbm"));

			if (hashMap.size() > 0) {
				opi.setZycbmList((List<HashMap<String, String>>) hashMap.get("zycbmList"));
			}
		}

		// 负责人
		Object name = param.getParam().get("name");
		if (!StrUtil.isNull(name)) {
			opi.setFzrxm(name.toString());
			opi.setJssxxm(name.toString());
		}

		List<OutProjectInfo> list = outProjectInfoMapper.selectProjectByCondExpert(opi);

		List<String> ids = list.stream().map(e -> e.getXmid()).collect(Collectors.toList());
		ids = ids == null || ids.size() == 0 ? new ArrayList<>() : ids;
		ZjkChoiceExample zjkChoiceExample = new ZjkChoiceExample();
		zjkChoiceExample.createCriteria().andXmIdIn(ids);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("list", ids);
		List<Map<String, Object>> objectMap = (List<Map<String, Object>>) zjkBaseInfoServiceClient.selectByExample(jsonObject).get("list");
		List<ZjkChoice> zjkChoices = new ArrayList<>();
		for (int i = 0; i < objectMap.size(); i++) {
			ZjkChoice choice = new ZjkChoice();
			MyBeanUtils.transMap2Bean((Map<String, Object>) objectMap.get(i), choice);
			zjkChoices.add(choice);
		}
		Map<String, Object> map = zjkChoices.stream().collect(Collectors.toMap(ZjkChoice::getXmId, ZjkChoice::getZjId, (entity1, entity2) -> entity1));

		System.out.println("1>>>>>>>>>查询分页结果" + list.size());
		PageInfo<OutProjectInfo> pageInfo = new PageInfo<OutProjectInfo>(list);
		System.out.println("2>>>>>>>>>查询分页结果" + pageInfo.getList().size());
		for (int i = 0, j = pageInfo.getList().size(); i < j; i++) {
			if (map.get(list.get(i).getXmid()) != null) {
				pageInfo.getList().get(i).setDefine19("1");
			}
		}

		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	@Autowired
	private ZjkBaseInfoServiceClient zjkBaseInfoServiceClient;

	@Override
	public int updateProjectInfoByKey(OutProjectInfo info) {
		return outProjectInfoMapper.updateByPrimaryKey(info);
	}

	@Override
	public List<OutProjectInfo> selectAllProjectInfo() {
		OutProjectInfoExample example = new OutProjectInfoExample();
		return outProjectInfoMapper.selectByExample(example);
	}

	@Override
	public List<OutProjectInfo> selectByExample(OutProjectInfoExample example) {
		List<OutProjectInfo> outProjectInfos = outProjectInfoMapper.selectByExample(example);
		List<OutProjectInfo> unique = outProjectInfos.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(OutProjectInfo::getXmid))), ArrayList::new));
		return unique;
	}

	@Override
	public LayuiTableData selectOutProjectInfoList(LayuiTableParam param) {
		// 每页显示条数
		int pageSize = param.getLimit();
		// 当前是第几页
		int pageNum = param.getPage();
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);

		OutProjectInfo opi = new OutProjectInfo();
		// 项目名称
		if (param.getParam().get("xmmc") != null && !StringUtils.isBlank(param.getParam().get("xmmc") + "")) {
			opi.setXmmc((String) param.getParam().get("xmmc"));
		}
		// 合同号
		if (param.getParam().get("hth") != null && !StringUtils.isBlank(param.getParam().get("hth") + "")) {
			opi.setHth((String) param.getParam().get("hth"));
		}

		// 国家项目、重大专项、重点项目、其他项目
		if (param.getParam().get("project_property") != null && !StringUtils.isBlank(param.getParam().get("project_property") + "")) {
			opi.setProjectProperty((String) param.getParam().get("project_property"));
		}
		// 年度，
		if (param.getParam().get("nd") != null && !StringUtils.isBlank(param.getParam().get("nd") + "")) {
			opi.setNd((String) param.getParam().get("nd"));
		}
		// 年度，
		if (param.getParam().get("ysnd") != null && !StringUtils.isBlank(param.getParam().get("ysnd") + "")) {
			opi.setYsnd((String) param.getParam().get("ysnd"));
		}
		

		List<OutProjectInfo> list = outProjectInfoMapper.selectProjectInfoByCond(opi);
		System.out.println("1>>>>>>>>>查询分页结果" + list.size());
		PageInfo<OutProjectInfo> pageInfo = new PageInfo<OutProjectInfo>(list);
		System.out.println("2>>>>>>>>>查询分页结果" + pageInfo.getList().size());

		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;
	}

	@Autowired
	private ClientFactoryBuilder clientFactoryBuilder;

	public OutProjectInfo getOutProjectShowByIdFc(String dataId) {
		OutProjectInfo outProjectInfo = outProjectInfoMapper.selectByPrimaryKey(dataId);
		String strName = outProjectInfo.getXmmc();
		TransportClient client = clientFactoryBuilder.getClient();

		AnalyzeRequest analyzeRequest = new AnalyzeRequest("files").text(strName).analyzer("ik_max_word");

		List<AnalyzeResponse.AnalyzeToken> tokens = client.admin().indices().analyze(analyzeRequest).actionGet().getTokens();

		String strRet = "";
		for (AnalyzeResponse.AnalyzeToken token : tokens) {
			strRet = strRet + "," + token.getTerm();
		}
		outProjectInfo.setDefine19(strRet);
		return outProjectInfo;
	}

	@Autowired
	private TechFamilyProviderClient techFamilyProviderClient;

	public void saveProjectToES() {
		// 技术族->ES
		TechFamily techFamily = new TechFamily();
		List<TechFamily> techFamilies = techFamilyProviderClient.selectTechFamilyTypeList(techFamily);
		AccessorService accessor = new AccessorServiceImpl(clientFactoryBuilder.getClient());
		IndexAccessorService indexAccessor = new IndexHelperBuilder.Builder().withClient(accessor.getClient()).creatAccessor();
		indexAccessor.deleteIndex(TechFamilyEs.class);
		indexAccessor.deleteIndex(TfcHotEs.class);

		indexAccessor.createIndexWithSettings(TechFamilyEs.class);
		indexAccessor.createMappingXContentBuilder(TechFamilyEs.class);

		indexAccessor.createIndexWithSettings(TfcHotEs.class);
		indexAccessor.createMappingXContentBuilder(TfcHotEs.class);

		for (int i = 0; i < techFamilies.size(); i++) {
			TechFamilyEs es = new TechFamilyEs();
			es.setEsId((int) (accessor.count(TechFamilyEs.class, null)));
			es.setTypeName(techFamilies.get(i).getTypeName());
			es.setTfmTypeId(techFamilies.get(i).getTfmTypeId());
			accessor.add(es);
		}
		List<TechFamilyEs> list = new ArrayList<>();
		// List<String> strings = new ArrayList<>();
		TransportClient client = clientFactoryBuilder.getClient();
		List<OutProjectInfo> outProjectInfos = this.selectAllProjectInfo();
		// AccessorService accessor = new
		// AccessorServiceImpl(clientFactoryBuilder.getClient());
		BooleanCondtionBuilder.Builder builder = new BooleanCondtionBuilder.Builder();
		Map<String, String> queryMap = new HashMap<>();
		for (int i = 0; i < outProjectInfos.size(); i++) {
			queryMap.put("typeName", outProjectInfos.get(i).getXmmc().replaceAll("[^0-9a-zA-Z\u4e00-\u9fa5.，,。？“”]+", ""));
			builder.setQueryMap(queryMap);
			Result result = accessor.searchFun(TechFamilyEs.class, builder.builder());
			list.addAll(result.getList());
		}
		Map<String, Long> map = list.stream().collect(Collectors.groupingBy(TechFamilyEs::getTypeName, Collectors.counting()));
		Map<String, Long> sortMap = new LinkedHashMap<>();
		map.entrySet().stream().sorted(Map.Entry.<String, Long> comparingByValue().reversed()).forEachOrdered(e -> sortMap.put(e.getKey(), e.getValue()));
		// 获取排序后map的key集合
		// List<String> keys = new LinkedList<>();
		// sortMap.entrySet().stream().forEachOrdered(e ->
		// keys.add(e.getKey()));
		// System.out.println(keys);
		// 获取排序后map的value集合
		// List<Long> values = new LinkedList<>();
		// sortMap.entrySet().stream().forEachOrdered(e ->
		// values.add(e.getValue()));
		// System.out.println(values);
		Iterator iterator = sortMap.entrySet().iterator();
		int i = 0;
		String values = "";
		String names = "";
		while (iterator.hasNext() && i < 10) {
			Map.Entry entry = (Map.Entry) iterator.next();
			values = entry.getValue() + (i == 0 ? "" : ("," + values));
			names = entry.getKey() + (i == 0 ? "" : ("," + names));
			i++;
		}
		TfcHotEs tfchot = new TfcHotEs();
		tfchot.setName(names);
		tfchot.setValue(values);
		tfchot.setEsId((int) (accessor.count(TfcHotEs.class, null)));
		accessor.add(tfchot);
		System.out.println("OK");
	}

	public JSONObject getOutProjectShowCount(String dataId) {
		AccessorService accessor = new AccessorServiceImpl(clientFactoryBuilder.getClient());
		BooleanCondtionBuilder.Builder builder = new BooleanCondtionBuilder.Builder();
		Map<String, String> queryMap = new HashMap<>();
		builder.setQueryMap(queryMap);
		Result result = accessor.searchFun(TfcHotEs.class, builder.builder());
		List<TfcHotEs> list = result.getList();
		JSONObject object = new JSONObject();
		if (list != null && list.size() > 0) {
			object.put("name", list.get(0).getName());
			object.put("value", list.get(0).getValue());
		} else {
			object.put("name", "");
			object.put("value", "");
		}
		return object;
	}

	@Override
	public List<OutProjectInfo> selectProjectUnit(OutProjectInfo example) {
		return outProjectInfoMapper.selectProjectUnitByCond(example);
	}

	@Override
	public List<OutProjectInfo> selectProjectInfoJzItems(OutProjectInfo example) {
		return outProjectInfoMapper.selectProjectInfoJzItems(example);
	}

	@Override
	public List<OutProjectInfo> selectProjectInfoJz(OutProjectInfo example) {
		return outProjectInfoMapper.selectProjectInfoJz(example);
	}

	public OutProjectInfoWithBLOBs selectOutProjectInfoWithBLOBs(String dataId) throws Exception {
		return outProjectInfoMapper.selectByPrimaryKey(dataId);
	}

	@Override
	public LayuiTableData selectProjectInfoWithAllInfoByCondTreeExpert(LayuiTableParam param) {

		LayuiTableData data = this.selectProjectInfoWithAllInfoByCondTree(param);
		List<Map<String, Object>> maps = (List<Map<String, Object>>) data.getData();
		int j = maps.size();

		List<String> ids = new ArrayList<>();
		for (int i = 0; i < j; i++) {
			ids.add(maps.get(i).get("xmid").toString());
		}
		if (ids == null || ids.size() == 0) {
			ids.add("");
		}
		ZjkChoiceExample zjkChoiceExample = new ZjkChoiceExample();
		zjkChoiceExample.createCriteria().andXmIdIn(ids);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("list", ids);
		List<Map<String, Object>> objectMap = (List<Map<String, Object>>) zjkBaseInfoServiceClient.selectByExample(jsonObject).get("list");
		List<ZjkChoice> zjkChoices = new ArrayList<>();
		for (int i = 0; i < objectMap.size(); i++) {
			ZjkChoice choice = new ZjkChoice();
			MyBeanUtils.transMap2Bean((Map<String, Object>) objectMap.get(i), choice);
			zjkChoices.add(choice);
		}
		Map<String, Object> map = zjkChoices.stream().collect(Collectors.toMap(ZjkChoice::getXmId, ZjkChoice::getZjId, (entity1, entity2) -> entity1));

		for (int i = 0; i < j; i++) {
			if (!StrUtil.isNullEmpty(map.get(maps.get(i).get("xmid")))) {
				maps.get(i).put("flag", "1");
			}
		}
		data.setData(maps);
		return data;
	}

	@Override
	public LayuiTableData selectProjectInfoWithAllInfoByCondYearExpert(LayuiTableParam param) {

		LayuiTableData data = this.selectProjectInfoWithAllInfoByCondYear(param);
		List<Map<String, Object>> maps = (List<Map<String, Object>>) data.getData();
		int j = maps.size();

		List<String> ids = new ArrayList<>();
		for (int i = 0; i < j; i++) {
			ids.add(maps.get(i).get("xmid").toString());
		}
		if (ids == null || ids.size() == 0) {
			ids.add("");
		}
		ZjkChoiceExample zjkChoiceExample = new ZjkChoiceExample();
		zjkChoiceExample.createCriteria().andXmIdIn(ids);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("list", ids);
		List<Map<String, Object>> objectMap = (List<Map<String, Object>>) zjkBaseInfoServiceClient.selectByExample(jsonObject).get("list");
		List<ZjkChoice> zjkChoices = new ArrayList<>();
		for (int i = 0; i < objectMap.size(); i++) {
			ZjkChoice choice = new ZjkChoice();
			MyBeanUtils.transMap2Bean((Map<String, Object>) objectMap.get(i), choice);
			zjkChoices.add(choice);
		}
		Map<String, Object> map = zjkChoices.stream().collect(Collectors.toMap(ZjkChoice::getXmId, ZjkChoice::getZjId, (entity1, entity2) -> entity1));

		for (int i = 0; i < j; i++) {
			if (!StrUtil.isNullEmpty(map.get(maps.get(i).get("xmid")))) {
				maps.get(i).put("flag", "1");
			}
		}

		data.setData(maps);
		return data;

	}

	/**
	 * 查询实际金额和实际数量， 粗组织机构分类
	 */
	public List getProjectActMoneyAndCount(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));
		return outProjectInfoMapper.getProjectActMoneyAndCount(map);
	}

	/**
	 * 查询实际金额和实际数量，细组织机构分类
	 */
	public List getProjectActMoneyAndCountThreeLevel(HashMap<String, String> map) {
		// 数据控制, 专业处、专业
		this.getDataFilterCondition(map, map.get("zycbm"), map.get("zylbbm"));
		return outProjectInfoMapper.getProjectActMoneyAndCountThreeLevel(map);
	}

	public OutProjectInfo selectOutProjectInfo(String id) throws Exception {
		return outProjectInfoMapper.selectByPrimaryKey(id);
	}

	public Integer updateOutProject_Info(OutProjectInfo record) throws Exception {
		return outProjectInfoMapper.updateByPrimaryKey(record);
	}

	public Integer updateOutProjectInfoWithBLOBs(OutProjectInfoWithBLOBs record) throws Exception {
		return outProjectInfoMapper.updateByPrimaryKeySelective(record);
	}

	public int deleteOutProjectInfo(String id) throws Exception {
		return outProjectInfoMapper.deleteByPrimaryKey(id);
	}

	public Integer insertOutProjectInfo(OutProjectInfo record) throws Exception {
		return outProjectInfoMapper.insertOutProjectInfo(record);
	}

	/*
	 * public Integer insertOutProjectInfo(OutProjectInfo outProjectInfo)throws
	 * Exception { String fzdwStr= outProjectInfo.getFzdwStr(); logger.info(
	 * "====================  add ten_dragons ========================fzdwStr: "
	 * +fzdwStr); String xmId=outProjectInfo.getXmid(); String
	 * arr[]=fzdwStr.split("\\|"); Integer count=0; if(arr!=null &&
	 * arr.length>0) { for(int i=0;i<arr.length;i++) { String lineStr=arr[i];
	 * String array[]=lineStr.split("#"); String fzdw=array[0]; String
	 * define6=array[1];
	 * 
	 * OutProjectInfo projectInfo=new OutProjectInfo();
	 * BeanUtils.copyProperties(projectInfo, outProjectInfo); String dataId =
	 * UUID.randomUUID().toString().replaceAll("-", "");
	 * projectInfo.setDataId(dataId); projectInfo.setFzdw(fzdw);
	 * projectInfo.setDefine6(define6); count=
	 * outProjectInfoMapper.insertOutProjectInfo(projectInfo); } } return count;
	 * }
	 */

	public Integer insertOutProjectInfoWithBLOBs(OutProjectInfoWithBLOBs record) throws Exception {
		return outProjectInfoMapper.insert(record);
	}

	public LayuiTableData getTenDragonsOutProjectPage(LayuiTableParam param) {

		JSONObject parmamss = JSONObject.parseObject(JSONObject.toJSONString(param));
		System.out.println(">>>>>>>>>getTenDragonsOutProjectPage 入口参数: " + parmamss.toJSONString());

		int pageSize = param.getLimit();
		// 当前是第几页
		int pageNum = param.getPage();
		// 1、设置分页信息，包括当前页数和每页显示的总计数
		PageHelper.startPage(pageNum, pageSize);

		String xmmc = getTableParam(param, "xmmc", "");
		String nd = getTableParam(param, "nd", "");
		String ysnd = getTableParam(param, "ysnd", "");
		String define3 = getTableParam(param, "define3", "");
		String status = getTableParam(param, "status", "");
		String zycmc = getTableParam(param, "zycmc", "");
		String xmlbmc = getTableParam(param, "xmlbmc", "");
		String fzdw = getTableParam(param, "fzdw", "");
		String define6 = getTableParam(param, "define6", "");

		Map map = new HashMap();
		map.put("xmmc", xmmc);
		map.put("nd", nd);
		map.put("ysnd", ysnd);
		map.put("define3", define3);
		map.put("status", status);
		map.put("zycmc", zycmc);
		map.put("xmlbmc", xmlbmc);
		map.put("fzdw", fzdw);
		map.put("define6", define6);

		JSONObject str = JSONObject.parseObject(JSONObject.toJSONString(map));
		System.out.println(">>>>>>>>>getTenDragonsOutProjectPage 封装后参数: " + str.toJSONString());

		List<OutProjectInfo> list = outProjectInfoMapper.getTenDragonsList(map);
		System.out.println("1>>>>>>>>>查询分页结果" + list.size());
		PageInfo<OutProjectInfo> pageInfo = new PageInfo<OutProjectInfo>(list);
		System.out.println("2>>>>>>>>>查询分页结果" + pageInfo.getList().size());

		LayuiTableData data = new LayuiTableData();
		data.setData(pageInfo.getList());
		Long total = pageInfo.getTotal();
		data.setCount(total.intValue());
		return data;

	}

	private String getTableParam(LayuiTableParam param, String paramName, String defaultstr) {
		String resault = "";
		Object object = param.getParam().get(paramName);
		if (object != null) {
			resault = (String) object;
		}
		return resault;
	}

}
