package com.pcitc.web.utils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.ChartBarLineSeries;
import com.pcitc.base.common.ChartCircle;
import com.pcitc.base.common.ChartCircle2;
import com.pcitc.base.common.ChartCircleItemStyle;
import com.pcitc.base.common.Child;
import com.pcitc.base.common.Child2;
import com.pcitc.base.common.NameValue;
import com.pcitc.base.common.TreeNode2;
import com.pcitc.base.hana.report.Award;
import com.pcitc.base.hana.report.BrandConstructionPay;
import com.pcitc.base.hana.report.BudgetMysql;
import com.pcitc.base.hana.report.CompanyCode;
import com.pcitc.base.hana.report.FundsComprehensiveAnalysis01;
import com.pcitc.base.hana.report.FundsComprehensiveAnalysis03;
import com.pcitc.base.hana.report.H1AMKYSY100104;
import com.pcitc.base.hana.report.H1AMKYSY100109;
import com.pcitc.base.hana.report.H1AMKYZH100006;
import com.pcitc.base.hana.report.HanaConstant;
import com.pcitc.base.hana.report.InvisibleCapitalDevelop;
import com.pcitc.base.hana.report.Knowledge;
import com.pcitc.base.hana.report.ProjectCode;
import com.pcitc.base.hana.report.ProjectForMysql;
import com.pcitc.base.hana.report.ScientificBaseBuildFee01;
import com.pcitc.base.hana.report.ScientificBaseBuildFee02;
import com.pcitc.base.hana.report.ScientificBaseBuildFee03;
import com.pcitc.base.hana.report.ScientificInstrumentPay;
import com.pcitc.base.hana.report.TotalCostProjectPay01;
import com.pcitc.base.hana.report.TotalCostProjectPay02;
import com.pcitc.base.hana.report.TotalCostProjectPay03;
import com.pcitc.base.system.SysUser;
import com.pcitc.base.util.DateUtil;

public class HanaUtil {

	// 公司代码
	private static final String GET_COMPANY_DIC_LIST = "http://pcitc-zuul/hana-proxy/hana/common/dic/company-code";
	// 项目代码
	private static final String GET_PROJECT_DIC_LIST = "http://pcitc-zuul/hana-proxy/hana/common/dic/porject-code";
	
	private static final String GET_BASE_DIC_LIST = "http://pcitc-zuul/hana-proxy/hana/common/dic/BASE_DIC_LIST";
	private static final String GET_BASE_DIC_LIST_ALL = "http://pcitc-zuul/hana-proxy/hana/common/dic/getBaseCodeDic";
	
	public static final String YJY_CODE_ALL = "1020,1040,1041,1060,1061,1080,1100,1101,1120,1123,1124,1127,1130,4360,1016,1019,101G,101I,1018,4270,101H,101F,101A,4370,8280";
	
	public static final String YJY_CODE_NOT_YINGKE = "1120,1123,1124,1127,1130,4360,1020,1060,1061,1040,1041,1080,1100,1101";
	
	

	public static <T> List<String> getxAxisByList(List<T> list, String fieldName) throws Exception {
		List<String> newList = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			T entity = list.get(i);
			Field[] arr = entity.getClass().getDeclaredFields();
			for (int j = 0; j < arr.length; j++) {
				String reult = "";
				Field field = arr[j];
				String str = field.getName();
				if (str.equals(fieldName)) {
					// 获取原来的访问控制权限
					boolean accessFlag = field.isAccessible();
					if (!field.isAccessible())
						field.setAccessible(true);
					reult = (String) field.get(entity);
					// System.out.println(">>>>>>>>>>>xAxis="+reult);
					field.setAccessible(accessFlag);
					newList.add(reult);
				}

			}

		}
		return newList;
	}

	public static <T> List<String> duplicateListVlue(List<T> list, String fieldName) throws Exception {
		List<String> newList = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			T entity = list.get(i);
			Field[] arr = entity.getClass().getDeclaredFields();
			for (int j = 0; j < arr.length; j++) {
				String reult = "";
				Field field = arr[j];
				String str = field.getName();
				if (str.equals(fieldName)) {
					// 获取原来的访问控制权限
					boolean accessFlag = field.isAccessible();
					if (!field.isAccessible())
						field.setAccessible(true);
					reult = (String) field.get(entity);
					// System.out.println(">>>>>>>>>>>xAxis="+reult);
					field.setAccessible(accessFlag);

					if (!newList.contains(reult)) {
						newList.add(reult);
					}

				}

			}

		}
		return newList;
	}

	// 科研基建投资支出分析--研究院基建支出同比分析
	public static List<ChartBarLineSeries> getSeriesListByScientificBaseBuildFee03(
			List<ScientificBaseBuildFee03> list) {

		List<ChartBarLineSeries> newList = new ArrayList<ChartBarLineSeries>();
		ChartBarLineSeries chartBarLineSeries_JCB = new ChartBarLineSeries();
		ChartBarLineSeries chartBarLineSeries_RJXM = new ChartBarLineSeries();
		ChartBarLineSeries chartBarLineSeries_RJZL = new ChartBarLineSeries();

		List<Object> data_JCB = new ArrayList<Object>();
		List<Object> data_RJXM = new ArrayList<Object>();
		List<Object> data_RJZL = new ArrayList<Object>();
		for (int i = 0; i < list.size(); i++) {
			ScientificBaseBuildFee03 f = list.get(i);
			String bn = f.getK0BNFWRJMJ();// 本年人均房屋面积
			String tq = f.getK0BNBGRJMJ();// 本年人均办公室面积
			String bl = f.getK0BNSYRJMJ();// 本年人均实验室面积
			
			bn=String.format("%.2f", Double.valueOf(bn));
			tq=String.format("%.2f", Double.valueOf(tq));
			bl=String.format("%.2f", Double.valueOf(bl));

			// System.out.println(">>>>>>>>>>>人均成本="+JCB+" 本年人均项目="+RJXM+" 本年人均专利="+RJZL);

			data_JCB.add(bn);
			data_RJXM.add(tq);
			data_RJZL.add(bl);

		}

		chartBarLineSeries_JCB.setData(data_JCB);
		chartBarLineSeries_JCB.setType(HanaConstant.ECHARTS_TYPE_LINE);
		chartBarLineSeries_JCB.setName("人均房屋面积");

		newList.add(chartBarLineSeries_JCB);

		chartBarLineSeries_RJXM.setData(data_RJXM);
		chartBarLineSeries_RJXM.setType(HanaConstant.ECHARTS_TYPE_LINE);
		chartBarLineSeries_RJXM.setName("人均办公室面积");

		newList.add(chartBarLineSeries_RJXM);

		chartBarLineSeries_RJZL.setData(data_RJZL);
		chartBarLineSeries_RJZL.setType(HanaConstant.ECHARTS_TYPE_LINE);
		chartBarLineSeries_RJZL.setName("人均实验室面积");

		newList.add(chartBarLineSeries_RJZL);

		return newList;
	}

	// 科研基建投资支出分析--研究院基建支出同比分析
	public static List<ChartBarLineSeries> getSeriesListByScientificBaseBuildFee02(
			List<ScientificBaseBuildFee02> list) {

		List<ChartBarLineSeries> newList = new ArrayList<ChartBarLineSeries>();
		ChartBarLineSeries chartBarLineSeries_JCB = new ChartBarLineSeries();
		ChartBarLineSeries chartBarLineSeries_RJXM = new ChartBarLineSeries();
		ChartBarLineSeries chartBarLineSeries_RJZL = new ChartBarLineSeries();

		List<Object> data_JCB = new ArrayList<Object>();
		List<Object> data_RJXM = new ArrayList<Object>();
		List<Object> data_RJZL = new ArrayList<Object>();
		for (int i = 0; i < list.size(); i++) {
			ScientificBaseBuildFee02 f = list.get(i);
			String bn = f.getK0BNZCJE();// 本期基建支出
			String tq = f.getK0SNZCJE();// 同期基建支出
			String bl = f.getK0TBZCBL();// 基建支出同比
			
			bn=String.format("%.2f", Double.valueOf(bn));
			tq=String.format("%.2f", Double.valueOf(tq));

			// System.out.println(">>>>>>>>>>>人均成本="+JCB+" 本年人均项目="+RJXM+" 本年人均专利="+RJZL);

			data_JCB.add(bn);
			data_RJXM.add(tq);
			data_RJZL.add(bl);

		}

		chartBarLineSeries_JCB.setData(data_JCB);
		chartBarLineSeries_JCB.setType(HanaConstant.ECHARTS_TYPE_BAR);
		chartBarLineSeries_JCB.setName("本期基建支出");
		chartBarLineSeries_JCB.setyAxisIndex(0);

		newList.add(chartBarLineSeries_JCB);

		chartBarLineSeries_RJXM.setData(data_RJXM);
		chartBarLineSeries_RJXM.setType(HanaConstant.ECHARTS_TYPE_BAR);
		chartBarLineSeries_RJXM.setName("同期基建支出");
		chartBarLineSeries_RJXM.setyAxisIndex(0);

		newList.add(chartBarLineSeries_RJXM);

		chartBarLineSeries_RJZL.setData(data_RJZL);
		chartBarLineSeries_RJZL.setType(HanaConstant.ECHARTS_TYPE_LINE);
		chartBarLineSeries_RJZL.setName("基建支出同比");
		chartBarLineSeries_RJZL.setyAxisIndex(1);

		newList.add(chartBarLineSeries_RJZL);

		return newList;
	}

	public static List<ChartBarLineSeries> getSeriesListByTotalCostProjectPay03(List<TotalCostProjectPay03> list) {

		List<ChartBarLineSeries> newList = new ArrayList<ChartBarLineSeries>();
		ChartBarLineSeries chartBarLineSeries_JCB = new ChartBarLineSeries();
		ChartBarLineSeries chartBarLineSeries_RJXM = new ChartBarLineSeries();
		ChartBarLineSeries chartBarLineSeries_RJZL = new ChartBarLineSeries();

		List<Object> data_JCB = new ArrayList<Object>();
		List<Object> data_RJXM = new ArrayList<Object>();
		List<Object> data_RJZL = new ArrayList<Object>();
		for (int i = 0; i < list.size(); i++) {
			TotalCostProjectPay03 f = list.get(i);
			String JCB = f.getK0BNRJCB();// 人均成本
			String RJXM = f.getK0BNRJXM();// 本年人均项目
			String RJZL = f.getK0BNRJZL();// 本年人均专利
			
			JCB=String.format("%.2f", Double.valueOf(JCB));
			RJXM=String.format("%.2f", Double.valueOf(RJXM));
			RJZL=String.format("%.2f", Double.valueOf(RJZL));

			// System.out.println(">>>>>>>>>>>人均成本="+JCB+" 本年人均项目="+RJXM+" 本年人均专利="+RJZL);

			data_JCB.add(JCB);
			data_RJXM.add(RJXM);
			data_RJZL.add(RJZL);

		}

		chartBarLineSeries_JCB.setData(data_JCB);
		chartBarLineSeries_JCB.setType(HanaConstant.ECHARTS_TYPE_LINE);
		chartBarLineSeries_JCB.setName("人均成本");

		newList.add(chartBarLineSeries_JCB);

		chartBarLineSeries_RJXM.setData(data_RJXM);
		chartBarLineSeries_RJXM.setType(HanaConstant.ECHARTS_TYPE_LINE);
		chartBarLineSeries_RJXM.setName("人均专利");

		newList.add(chartBarLineSeries_RJXM);

		chartBarLineSeries_RJZL.setData(data_RJZL);
		chartBarLineSeries_RJZL.setType(HanaConstant.ECHARTS_TYPE_LINE);
		chartBarLineSeries_RJZL.setName("人均项目");

		newList.add(chartBarLineSeries_RJZL);

		return newList;
	}

	public static List<ChartBarLineSeries> getSeriesListTotalCostProjectPayType01(List<TotalCostProjectPay01> list) {

		List<ChartBarLineSeries> newList = new ArrayList<ChartBarLineSeries>();
		ChartBarLineSeries chartBarLineSeriesHJE = new ChartBarLineSeries();
		ChartBarLineSeries chartBarLineSeriesJECB = new ChartBarLineSeries();
		ChartBarLineSeries chartBarLineSeriesBL = new ChartBarLineSeries();

		List<Object> dataHJE = new ArrayList<Object>();
		List<Object> dataJECB = new ArrayList<Object>();
		List<Object> dataJSYBL = new ArrayList<Object>();
		for (int i = 0; i < list.size(); i++) {
			TotalCostProjectPay01 f = list.get(i);
			String HJE = f.getK0BNYSJHJE();// 预算
			String JECB = f.getK0BNGLFPHJECB();// 实际
			String JSYBL = f.getK0BNZJSYBL();
			
			HJE=String.format("%.2f", Double.valueOf(HJE));
			JECB=String.format("%.2f", Double.valueOf(JECB));
			
			dataHJE.add(HJE);
			dataJECB.add(JECB);
			dataJSYBL.add(JSYBL);
		}

		chartBarLineSeriesJECB.setData(dataJECB);
		chartBarLineSeriesJECB.setType(HanaConstant.ECHARTS_TYPE_BAR);
		chartBarLineSeriesJECB.setName("实际支出");

		newList.add(chartBarLineSeriesJECB);

		chartBarLineSeriesHJE.setData(dataHJE);
		chartBarLineSeriesHJE.setType(HanaConstant.ECHARTS_TYPE_BAR);
		chartBarLineSeriesHJE.setName("预算批复");

		newList.add(chartBarLineSeriesHJE);

		chartBarLineSeriesBL.setData(dataJSYBL);
		chartBarLineSeriesBL.setType(HanaConstant.ECHARTS_TYPE_LINE);
		chartBarLineSeriesBL.setName("使用率");

		newList.add(chartBarLineSeriesBL);

		return newList;
	}

	public static List<ChartBarLineSeries> getSeriesListTotalCostProjectPay01(List<TotalCostProjectPay01> list) {

		List<ChartBarLineSeries> newList = new ArrayList<ChartBarLineSeries>();
		ChartBarLineSeries chartBarLineSeriesHJE = new ChartBarLineSeries();
		ChartBarLineSeries chartBarLineSeriesJECB = new ChartBarLineSeries();
		ChartBarLineSeries chartBarLineSeriesSJY = new ChartBarLineSeries();

		List<Object> dataHJE = new ArrayList<Object>();
		List<Object> dataJECB = new ArrayList<Object>();
		List<Object> dataSJY = new ArrayList<Object>();
		for (int i = 0; i < list.size(); i++) {
			TotalCostProjectPay01 f = list.get(i);
			String HJE = f.getK0BNYSJHJE();// 预算
			String JECB = f.getK0BNGLFPHJECB();// 实际
			String SJY = f.getK0BNYSJY();
			
			HJE=String.format("%.2f", Double.valueOf(HJE));
			JECB=String.format("%.2f", Double.valueOf(JECB));
			SJY=String.format("%.2f", Double.valueOf(SJY));
			dataHJE.add(HJE);
			dataJECB.add(JECB);
			dataSJY.add(SJY);
		}

		chartBarLineSeriesJECB.setData(dataJECB);
		chartBarLineSeriesJECB.setType(HanaConstant.ECHARTS_TYPE_BAR);
		chartBarLineSeriesJECB.setName("实际支出");

		newList.add(chartBarLineSeriesJECB);

		chartBarLineSeriesHJE.setData(dataHJE);
		chartBarLineSeriesHJE.setType(HanaConstant.ECHARTS_TYPE_BAR);
		chartBarLineSeriesHJE.setName("预算批复");

		newList.add(chartBarLineSeriesHJE);

		chartBarLineSeriesSJY.setData(dataSJY);
		chartBarLineSeriesSJY.setType(HanaConstant.ECHARTS_TYPE_BAR);
		chartBarLineSeriesSJY.setName("预算结余");

		newList.add(chartBarLineSeriesSJY);

		return newList;
	}

	public static List<String> getYAxisTotalCostProjectPay01(List<TotalCostProjectPay01> list, String type) {

		List<String> newList = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			TotalCostProjectPay01 f = list.get(i);
			String str = "";
			if (type.equals("G0XMLXMS")) {
				str = f.getG0XMLXMS();
			} else if (type.equals("G0XMGLLX")) {
				str = f.getG0XMGLLX();
			} else if (type.equals("G0XMGLLY")) {
				str = f.getG0XMGLLY();
			} else if (type.equals("G0XMGLJB")) {
				str = f.getG0XMGLJB();
			}
			newList.add(str);
		}
		return newList;
	}

	/**
	 * 科研经费预算投入年度趋势分析--ChartBarLineSeries
	 * 
	 * @param list
	 * @param yearList
	 * @return
	 */
	public static List<ChartBarLineSeries> getChartBarLineSeriesByYear(List<FundsComprehensiveAnalysis01> list,
			List<String> yearList) {
		List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
		if (yearList != null && yearList.size() > 0) {
			for (int i = 0; i < yearList.size(); i++) {
				ChartBarLineSeries chartBarLineSeries = new ChartBarLineSeries();
				String year = yearList.get(i);
				chartBarLineSeries.setName(year);
				chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
				List<Object> data = new ArrayList<Object>();
				for (int j = 0; j < list.size(); j++) {
					FundsComprehensiveAnalysis01 f = list.get(j);
					String year_v = f.getG0YEARXM();
					String k0BNSJJE = f.getK0BNSJJE();
					k0BNSJJE=String.format("%.2f", Double.valueOf(k0BNSJJE));
					if (year.equals(year_v)) {
						data.add(k0BNSJJE);
					}
				}
				chartBarLineSeries.setData(data);
				seriesList.add(chartBarLineSeries);
			}
		}
		return seriesList;
	}

	/**
	 * 科研基建投资支出分析 科研基建支出年度趋势分析--ChartBarLineSeries
	 * 
	 * @param list
	 * @param yearList
	 * @return
	 */
	public static List<ChartBarLineSeries> getCBSByScientificBaseBuildFee01Year(List<ScientificBaseBuildFee01> list,
			List<String> yearList) {
		List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
		if (yearList != null && yearList.size() > 0) {
			for (int i = 0; i < yearList.size(); i++) {
				ChartBarLineSeries chartBarLineSeries = new ChartBarLineSeries();
				String year = yearList.get(i);
				chartBarLineSeries.setName(year);
				chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
				List<Object> data = new ArrayList<Object>();
				for (int j = 0; j < list.size(); j++) {
					ScientificBaseBuildFee01 f = list.get(j);
					String year_v = f.getG0CALY();
					String k0BNSJJE = f.getK0BNZCJE();
					
					k0BNSJJE=String.format("%.2f", Double.valueOf(k0BNSJJE));
					
					if (year.equals(year_v)) {
						data.add(k0BNSJJE);
					}
				}
				chartBarLineSeries.setData(data);
				seriesList.add(chartBarLineSeries);
			}
		}
		return seriesList;
	}

	public static List<ChartBarLineSeries> getScientificInstrumentPayYear(List<ScientificInstrumentPay> list,
			List<String> yearList) {
		List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
		if (yearList != null && yearList.size() > 0) {
			for (int i = 0; i < yearList.size(); i++) {
				ChartBarLineSeries chartBarLineSeries = new ChartBarLineSeries();
				String year = yearList.get(i);
				chartBarLineSeries.setName(year);
				chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
				List<Object> data = new ArrayList<Object>();
				for (int j = 0; j < list.size(); j++) {
					ScientificInstrumentPay f = list.get(j);
					String year_v = f.getG0CALY();
					String k0BNSJJE = f.getK0BNZCJE();
					k0BNSJJE=String.format("%.2f", Double.valueOf(k0BNSJJE));
					if (year.equals(year_v)) {
						data.add(k0BNSJJE);
					}
				}
				chartBarLineSeries.setData(data);
				seriesList.add(chartBarLineSeries);
			}
		}
		return seriesList;
	}

	public static List<ChartBarLineSeries> getBrandConstructionPayYear(List<BrandConstructionPay> list,
			List<String> yearList) {
		List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
		if (yearList != null && yearList.size() > 0) {
			for (int i = 0; i < yearList.size(); i++) {
				ChartBarLineSeries chartBarLineSeries = new ChartBarLineSeries();
				String year = yearList.get(i);
				chartBarLineSeries.setName(year);
				chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
				List<Object> data = new ArrayList<Object>();
				for (int j = 0; j < list.size(); j++) {
					BrandConstructionPay f = list.get(j);
					String year_v = f.getG0CALY();
					String k0BNSJJE = f.getK0BNJE();
					k0BNSJJE=String.format("%.2f", Double.valueOf(k0BNSJJE));
					if (year.equals(year_v)) {
						data.add(k0BNSJJE);
					}
				}
				chartBarLineSeries.setData(data);
				seriesList.add(chartBarLineSeries);
			}
		}
		return seriesList;
	}

	public static List<ChartBarLineSeries> getInvisibleCapitalDevelopYear(List<InvisibleCapitalDevelop> list,
			List<String> yearList) {
		List<ChartBarLineSeries> seriesList = new ArrayList<ChartBarLineSeries>();
		if (yearList != null && yearList.size() > 0) {
			for (int i = 0; i < yearList.size(); i++) {
				ChartBarLineSeries chartBarLineSeries = new ChartBarLineSeries();
				String year = yearList.get(i);
				chartBarLineSeries.setName(year);
				chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
				List<Object> data = new ArrayList<Object>();
				for (int j = 0; j < list.size(); j++) {
					InvisibleCapitalDevelop f = list.get(j);
					String year_v = f.getG0CALY();
					String k0BNSJJE = f.getK0BNZCJE();
					k0BNSJJE=String.format("%.2f", Double.valueOf(k0BNSJJE));
					if (year.equals(year_v)) {
						data.add(k0BNSJJE);
					}
				}
				chartBarLineSeries.setData(data);
				seriesList.add(chartBarLineSeries);
			}
		}
		return seriesList;
	}

	/**
	 * 前4年+当前，总5年
	 * 
	 * @param yearMonth
	 * @return
	 */
	public static List<String> getBeforeYear4List(String yearMonth) {
		List<String> list = new ArrayList();
		Date date = DateUtil.strToDate(yearMonth, DateUtil.FMT_MM);
		list.add(DateUtil.dateToStr(date, DateUtil.FMT_YYYY));

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, -1);// 当前时间减去一年，即一年前的时间
		Date before1 = calendar.getTime();
		list.add(DateUtil.dateToStr(before1, DateUtil.FMT_YYYY));

		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(date);
		calendar2.add(Calendar.YEAR, -2);
		Date before2 = calendar2.getTime();
		list.add(DateUtil.dateToStr(before2, DateUtil.FMT_YYYY));

		Calendar calendar3 = Calendar.getInstance();
		calendar3.setTime(date);
		calendar3.add(Calendar.YEAR, -3);
		Date before3 = calendar3.getTime();
		list.add(DateUtil.dateToStr(before3, DateUtil.FMT_YYYY));

		Calendar calendar4 = Calendar.getInstance();
		calendar4.setTime(date);
		calendar4.add(Calendar.YEAR, -4);
		Date before4 = calendar4.getTime();
		list.add(DateUtil.dateToStr(before4, DateUtil.FMT_YYYY));

		return list;
	}
	
	
	public static List<String> getBeforeYearList(String yearMonth,int count) {
		List<String> list = new ArrayList();
		Date date = DateUtil.strToDate(yearMonth, DateUtil.FMT_YYYY);
		//list.add(DateUtil.dateToStr(date, DateUtil.FMT_YYYY));
		for(int i=0;i<count;i++)
		{
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.YEAR, -i);// 当前时间减去一年，即一年前的时间
			Date before1 = calendar.getTime();
			list.add(DateUtil.dateToStr(before1, DateUtil.FMT_YYYY));
		}
		return list;
	}
	

	/**
	 * 去重 科研经费预算投入年度趋势分析
	 * 
	 * @param list
	 * @return
	 */
	public static List<String> duplicateList(List<FundsComprehensiveAnalysis01> list) {

		List<String> newList = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			FundsComprehensiveAnalysis01 f = list.get(i);
			String str = f.getG0XMGLLX();
			if (!newList.contains(str)) {
				newList.add(str);
			}
		}
		return newList;
	}

	public static <T> List<String> getduplicatexAxisByList(List<T> list, String fieldName) throws Exception {
		List<String> newList = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			T entity = list.get(i);
			Field[] arr = entity.getClass().getDeclaredFields();
			for (int j = 0; j < arr.length; j++) {
				String reult = "";
				Field field = arr[j];
				String str = field.getName();
				if (str.equals(fieldName)) {
					// 获取原来的访问控制权限
					boolean accessFlag = field.isAccessible();
					if (!field.isAccessible())
						field.setAccessible(true);
					reult = (String) field.get(entity);
					// System.out.println(">>>>>>>>>>>xAxis="+reult);
					field.setAccessible(accessFlag);

					if (!newList.contains(reult)) {
						newList.add(reult);
					}

				}

			}

		}
		return newList;
	}

	public static String getCompanyCodeAll(List<CompanyCode> companyCodeList) {
		String result = "";
		if (companyCodeList != null && companyCodeList.size() > 0) {
			for (int i = 0; i < companyCodeList.size(); i++) {
				CompanyCode companyCode = companyCodeList.get(i);
				String name = companyCode.getG0DMJC();// 表述
				String code = companyCode.getG0GSDM();

				if (name.equals(HanaConstant.COMPANY_CODE_ALL)) {
					result = code;
				}
			}

		}
		return result;
	}

	public static List<ChartCircle> getChildChartCircle(List<H1AMKYSY100109> lista) 
	{
		List<ChartCircle> resut = new ArrayList();
		ChartCircle  cc01= getChartCircle( lista,"新开课题","#6699FF");
		ChartCircle  cc02= getChartCircle( lista,"结转课题","#00FFCC");
		resut.add(cc01);
		resut.add(cc02);
		return resut;
	}
	
	
	public static List<String> getClorList() 
	{
		
		List<String> colorList=new ArrayList<String>();
		colorList.add("#6592b2");
		colorList.add("#54b6e9");
		colorList.add("#70b1aa");
		colorList.add("#e8a791");
		colorList.add("#b5c26a");
		colorList.add("#d59981");
		colorList.add("#017ebe");
		colorList.add("#1280b1");
		colorList.add("#dd4800");
		colorList.add("#fd7819");
		colorList.add("#e7580a");
		colorList.add("#ef2d36");
		colorList.add("#c94a44");
		colorList.add("#b53b54");
		colorList.add("#a5446f");
		colorList.add("#f2684b");
		colorList.add("#e73451");
		colorList.add("#e65656");
		colorList.add("#f89a1c");
		colorList.add("#aeb92c");
		colorList.add("#4eb849");
		colorList.add("#f68a5c");
		colorList.add("#baa635");
		return colorList;
	}
	
	
	
	
	
	public static List<ChartCircle2> getChildChartCircleFordevice(List<String>  listLevel1Title,List<H1AMKYSY100109> listAll) 
	{
		
		
		List<String> colorList=getClorList();
		
		List<ChartCircle2> resut = new ArrayList();
		for(int i=0;i<listLevel1Title.size();i++)
		{
			String title=listLevel1Title.get(i);
			ChartCircle2  cc= getChartCircleForDevice( listAll,title,colorList.get(i));
			resut.add(cc);
		}
		return resut;
	}
	public static ChartCircle2 getChartCircleForDevice(List<H1AMKYSY100109> listAll,String str,String color)
	{
		
		List<String> colorList=getClorList();
		ChartCircle2 cc01=new ChartCircle2();
		//第一级
		cc01.setName(str);
		//第二级
		List<Child2> children01=new ArrayList<Child2>();
		ChartCircleItemStyle chartCircleItemStyle=new ChartCircleItemStyle();
		chartCircleItemStyle.setColor(color);
		cc01.setItemStyle(chartCircleItemStyle);
		
		
		for (int i = 0; i < listAll.size(); i++) 
		{
			H1AMKYSY100109 h1AMKYSY100109=listAll.get(i);
			String name=h1AMKYSY100109.getG0XMXZ();
			if(name.equals(str))
			{
			
				String G0XMGLLX_name=h1AMKYSY100109.getG0GSJC();
				String value=h1AMKYSY100109.getK0XMZXSL();
				Child2 child=new Child2();
				child.setName(G0XMGLLX_name);
				if(value!=null && !value.equals(""))
				{
					child.setValue(Double.valueOf(value).intValue());
				}else
				{
					child.setValue(0);
				}
				
				
				ChartCircleItemStyle cc=new ChartCircleItemStyle();
				cc.setColor(colorList.get(i));
				child.setItemStyle(cc);
				
				
				children01.add(child);
			}
		}
		cc01.setChildren(children01);
		return cc01;
	}
	
	
	
	
	
	public static List<ChartCircle2> getChildChartCircleForproject02(List<String>  listLevel1Title,List<H1AMKYSY100109> listAll) 
	{
		
		
		List<String> colorList=getClorList();
		
		List<ChartCircle2> resut = new ArrayList();
		for(int i=0;i<listLevel1Title.size();i++)
		{
			String title=listLevel1Title.get(i);
			ChartCircle2  cc= getChartCircleForprojt02( listAll,title,colorList.get(i));
			resut.add(cc);
		}
		return resut;
	}
	
	
	
	public static ChartCircle2 getChartCircleForprojt02(List<H1AMKYSY100109> listAll,String str,String color)
	{
		
		List<String> colorList=getClorList();
		ChartCircle2 cc01=new ChartCircle2();
		//第一级
		cc01.setName(str);
		//第二级
		List<Child2> children01=new ArrayList<Child2>();
		ChartCircleItemStyle chartCircleItemStyle=new ChartCircleItemStyle();
		chartCircleItemStyle.setColor(color);
		cc01.setItemStyle(chartCircleItemStyle);
		
		
		for (int i = 0; i < listAll.size(); i++) 
		{
			H1AMKYSY100109 h1AMKYSY100109=listAll.get(i);
			String name=h1AMKYSY100109.getG0XMXZ();
			if(name.equals(str))
			{
			
				String G0XMGLLX_name=h1AMKYSY100109.getG0GSJC();
				String value=h1AMKYSY100109.getK0BNXMZXSL();
				Child2 child=new Child2();
				child.setName(G0XMGLLX_name);
				if(value!=null && !value.equals(""))
				{
					child.setValue(Double.valueOf(value).intValue());
				}else
				{
					child.setValue(0);
				}
				
				
				ChartCircleItemStyle cc=new ChartCircleItemStyle();
				cc.setColor(colorList.get(i));
				child.setItemStyle(cc);
				
				
				children01.add(child);
			}
		}
		cc01.setChildren(children01);
		return cc01;
	}
	
	
	
	public static List<TreeNode2> getChildChartCircleuNITFordevice(List<String>  listLevel1Title,List<H1AMKYSY100109> listAll) 
	{
		
		
		
		List<TreeNode2> resut = new ArrayList();
		for(int i=0;i<listLevel1Title.size();i++)
		{
			String title=listLevel1Title.get(i);
			TreeNode2 node=new TreeNode2();
			node.setId("999"+String.valueOf(i));
			node.setLay_icon_open("/layuiadmin/layui/images/treegrid1_open.png");
			node.setLay_icon("/layuiadmin/layui/images/treegrid2.png");
			node.setLay_is_open(true);
			int count=0;
			for (int j = 0; j < listAll.size(); j++) 
			{
				H1AMKYSY100109 entity=listAll.get(j);
				String name=entity.getG0XMXZ();
				String value=entity.getK0XMZXSL();
				String id=entity.getId();
				String name02=entity.getG0GSJC();
				
				
				if(name.equals(title))
				{
					TreeNode2 node02=new TreeNode2();
					node02.setpId(node.getId());
					node02.setName(name02);
					
					
					if(value!=null && !value.equals(""))
					{
						node02.setExtend01(String.valueOf(Double.valueOf(value).intValue()));
					}else
					{
						node02.setExtend01("0");
					}
					
					node02.setId(""+id);
					resut.add(node02);
					if(value!=null && !value.equals(""))
					{
						count=count+Double.valueOf(value).intValue();
					}else
					{
						count=count+0;
					}
					
					
				}
			}
			node.setName(title);
			node.setExtend01(String.valueOf(count));
			resut.add(node);
			
		}
		return resut;
	}
	
	
	
	
	
	
	
	
	public static List<TreeNode2> getChildChartCircleUnitBudgerMysql(List<String>  listLevel1Title,List<BudgetMysql> listAll) 
	{
		
		
		
		List<TreeNode2> resut = new ArrayList();
		for(int i=0;i<listLevel1Title.size();i++)
		{
			String title=listLevel1Title.get(i);
			TreeNode2 node=new TreeNode2();
			node.setId("999"+String.valueOf(i));
			node.setLay_icon_open("/layuiadmin/layui/images/treegrid1_open.png");
			node.setLay_icon("/layuiadmin/layui/images/treegrid2.png");
			node.setLay_is_open(true);
			Double count=0.00;
			for (int j = 0; j < listAll.size(); j++) 
			{
				BudgetMysql entity=listAll.get(j);
				String name=entity.getDefine1();
				String value =((BigDecimal)entity.getZje()).toString();
				
			
				String id=entity.getId();
				String name02=entity.getType_flag();
				
				if(name.equals(title))
				{
					TreeNode2 node02=new TreeNode2();
					node02.setpId(node.getId());
					node02.setName(name02);
					
					
					DecimalFormat decimalFormat=new DecimalFormat(".00");
					value=decimalFormat.format(Float.valueOf(value));
					node02.setExtend01(value);
					node02.setId(""+id);
					resut.add(node02);
					if(value!=null && !value.equals(""))
					{
						count=add(count,Double.valueOf(value));
					}else
					{
						count=add(count,0);
					}
					
					
				}
			}
			node.setName(title);
			node.setExtend01(String.valueOf(count));
			resut.add(node);
			
		}
		return resut;
	}
	
	public static List<TreeNode2> getChildChartCircleUnitPay(List<String>  listLevel1Title,List<H1AMKYSY100109> listAll)throws Exception  
	{
		
		List<TreeNode2> resut = new ArrayList();
		for(int i=0;i<listLevel1Title.size();i++)
		{
			String title=listLevel1Title.get(i);
			TreeNode2 node=new TreeNode2();
			node.setId("first_"+String.valueOf(i));
			node.setLay_icon_open("/layuiadmin/layui/images/treegrid1_open.png");
			node.setLay_icon("/layuiadmin/layui/images/treegrid2.png");
			node.setLay_is_open(true);
			node.setName(title);
			
			List<H1AMKYSY100109> resat02=getchildH1AMKYSY100109( title, listAll);
			Double count=0.00;
			for(int v=0;v<resat02.size();v++)
			{
				H1AMKYSY100109  h1AMKYSY100109=resat02.get(v);
				String value=h1AMKYSY100109.getK0BNYSJHJE();
				DecimalFormat decimalFormat=new DecimalFormat(".00");
				value=decimalFormat.format(Double.valueOf(value));
				if(value!=null)
				{
					count=add(count,Double.valueOf(value));
				}else
				{
					count=add(count,0);
				}
			}
			node.setExtend01(String.valueOf(count));
			resut.add(node);
			
			//二级
			List<String>  list2tiele=getduplicatexAxisByList(resat02,"g0GSSP");
			for(int j=0;j<list2tiele.size();j++)
			{
				String title02=list2tiele.get(j);
				TreeNode2 node02=new TreeNode2();
				node02.setId("second_"+i+"_"+String.valueOf(j));
				node02.setName(title02);
				node02.setpId("first_"+String.valueOf(i));
				
				
				//三级
				List<H1AMKYSY100109> resat03=getchildH1AMKYSY100109_02(title, title02, listAll);
				Double count2=0.00;
				for(int k=0;k<resat03.size();k++)
				{
					H1AMKYSY100109  h1AMKYSY100109=resat03.get(k);
					String value=h1AMKYSY100109.getK0BNYSJHJE();
					TreeNode2 node03=new TreeNode2();
					node03.setId("three_"+k);
					node03.setName(h1AMKYSY100109.getG0GSJC());
					node03.setExtend01(value);
					node03.setpId("second_"+i+"_"+String.valueOf(j));
					resut.add(node03);
					
					
					DecimalFormat decimalFormat=new DecimalFormat(".00");
					value=decimalFormat.format(Double.valueOf(value));
					if(value!=null )
					{
						count2=add(count2,Double.valueOf(value));
					}else
					{
						count2=add(count2,0);
					}
					
				}
				node02.setExtend01(String.valueOf(count2));
				resut.add(node02);
			}
			
		}
		return resut;
	}
	
	
	public static List<H1AMKYSY100109> getchildH1AMKYSY100109_02(String title,String title2,List<H1AMKYSY100109> listAll) 
	{
		
		List<H1AMKYSY100109> resat=new ArrayList();
		for (int j = 0; j < listAll.size(); j++) 
		{
			H1AMKYSY100109 entity=listAll.get(j);
			String name=entity.getG0XMDL();
			String name2=entity.getG0GSSP();
			if(name.equals(title) && name2.equals(title2))
			{
				//System.out.println(">>>>>>>>>>>>>name="+name+"  name2="+name2);
				resat.add(entity);
			}
		}
		return resat;
	}
	
	public static List<H1AMKYSY100109> getchildH1AMKYSY100109(String title,List<H1AMKYSY100109> listAll) 
	{
		
		List<H1AMKYSY100109> resat=new ArrayList();
		for (int j = 0; j < listAll.size(); j++) 
		{
			H1AMKYSY100109 entity=listAll.get(j);
			String name=entity.getG0XMDL();
			if(name.equals(title))
			{
				resat.add(entity);
			}
		}
		return resat;
	}
	
	
	
	public static List<TreeNode2> getChildChartCircleUnitBudger(List<String>  listLevel1Title,List<H1AMKYSY100109> listAll) 
	{
		
		
		
		List<TreeNode2> resut = new ArrayList();
		for(int i=0;i<listLevel1Title.size();i++)
		{
			String title=listLevel1Title.get(i);
			TreeNode2 node=new TreeNode2();
			node.setId("999"+String.valueOf(i));
			node.setLay_icon_open("/layuiadmin/layui/images/treegrid1_open.png");
			node.setLay_icon("/layuiadmin/layui/images/treegrid2.png");
			node.setLay_is_open(true);
			Double count=0.00;
			for (int j = 0; j < listAll.size(); j++) 
			{
				H1AMKYSY100109 entity=listAll.get(j);
				String name=entity.getG0XMDL();
				String value=entity.getK0BNYSJHJE();
				String id=entity.getId();
				String name02=entity.getG0GSJC();
				
				if(name.equals(title))
				{
					TreeNode2 node02=new TreeNode2();
					node02.setpId(node.getId());
					node02.setName(name02);
					
					
					DecimalFormat decimalFormat=new DecimalFormat(".00");
					value=decimalFormat.format(Float.valueOf(value));
					node02.setExtend01(value);
					node02.setId(""+id);
					resut.add(node02);
					if(value!=null && !value.equals(""))
					{
						count=add(count,Double.valueOf(value));
					}else
					{
						count=add(count,0);
					}
					
					
				}
			}
			node.setName(title);
			node.setExtend01(String.valueOf(count));
			resut.add(node);
			
		}
		return resut;
	}
	
	public static double add(double v1, double v2) {
       BigDecimal b1=new BigDecimal(Double.toString(v1));
       BigDecimal b2 = new BigDecimal(Double.toString(v2));
       return b1.add(b2).doubleValue();
   }
	
	public static List<TreeNode2> getChildChartCircleuNITForproject02type(List<String>  listLevel1Title,List<ProjectForMysql> listAll) 
	{
		
		
		
		List<TreeNode2> resut = new ArrayList();
		for(int i=0;i<listLevel1Title.size();i++)
		{
			String title=listLevel1Title.get(i);
			TreeNode2 node=new TreeNode2();
			node.setId("999"+String.valueOf(i));
			node.setLay_icon_open("/layuiadmin/layui/images/treegrid1_open.png");
			node.setLay_icon("/layuiadmin/layui/images/treegrid2.png");
			node.setLay_is_open(true);
			int count=0;
			for (int j = 0; j < listAll.size(); j++) 
			{
				ProjectForMysql entity=listAll.get(j);
				String name=entity.getProject_scope();
				Integer value=(Integer)entity.getZsl();
				String id=(String)entity.getId();
				String name02=(String)entity.getDefine2();
				
				
				if(name.equals(title))
				{
					TreeNode2 node02=new TreeNode2();
					node02.setpId(node.getId());
					node02.setName(name02);
					if(value!=null )
					{
						node02.setExtend01(String.valueOf(value));
					}else
					{
						node02.setExtend01("0");
					}
					node02.setId(""+id);
					resut.add(node02);
					if(value!=null )
					{
						count=count+Double.valueOf(value).intValue();
					}else
					{
						count=count+0;
					}
				}
			}
			node.setName(title);
			node.setExtend01(String.valueOf(count));
			resut.add(node);
			
		}
		return resut;
	}
	
	
	
	
	
	public static List<TreeNode2> getChildChartCircleuNITForproject01type(List<String>  listLevel1Title,List<ProjectForMysql> listAll) 
	{
		
		
		
		List<TreeNode2> resut = new ArrayList();
		for(int i=0;i<listLevel1Title.size();i++)
		{
			String title=listLevel1Title.get(i);
			TreeNode2 node=new TreeNode2();
			node.setId("999"+String.valueOf(i));
			node.setLay_icon_open("/layuiadmin/layui/images/treegrid1_open.png");
			node.setLay_icon("/layuiadmin/layui/images/treegrid2.png");
			node.setLay_is_open(true);
			int count=0;
			for (int j = 0; j < listAll.size(); j++) 
			{
				ProjectForMysql entity=listAll.get(j);
				String name=entity.getProject_scope();
				Integer value=(Integer)entity.getZsl();
				String id=(String)entity.getId();
				String name02=(String)entity.getZycmc();
				
				
				if(name.equals(title))
				{
					TreeNode2 node02=new TreeNode2();
					node02.setpId(node.getId());
					node02.setName(name02);
					if(value!=null )
					{
						node02.setExtend01(String.valueOf(value));
					}else
					{
						node02.setExtend01("0");
					}
					node02.setId(""+id);
					resut.add(node02);
					if(value!=null )
					{
						count=count+Double.valueOf(value).intValue();
					}else
					{
						count=count+0;
					}
				}
			}
			node.setName(title);
			node.setExtend01(String.valueOf(count));
			resut.add(node);
			
		}
		return resut;
	}
	
	
	
	public static List<TreeNode2> getChildChartCircleuNITForDevice(List<String>  listLevel1Title,List<ProjectForMysql> listAll) 
	{
		
		
		
		List<TreeNode2> resut = new ArrayList();
		for(int i=0;i<listLevel1Title.size();i++)
		{
			String title=listLevel1Title.get(i);
			TreeNode2 node=new TreeNode2();
			node.setId("999"+String.valueOf(i));
			node.setLay_icon_open("/layuiadmin/layui/images/treegrid1_open.png");
			node.setLay_icon("/layuiadmin/layui/images/treegrid2.png");
			node.setLay_is_open(true);
			int count=0;
			for (int j = 0; j < listAll.size(); j++) 
			{
				ProjectForMysql entity=listAll.get(j);
				String name=entity.getProject_scope();
				Integer value=(Integer)entity.getZsl();
				String id=(String)entity.getId();
				String name02=(String)entity.getType_flag();
				
				
				if(name.equals(title))
				{
					TreeNode2 node02=new TreeNode2();
					node02.setpId(node.getId());
					node02.setName(name02);
					if(value!=null )
					{
						node02.setExtend01(String.valueOf(value));
					}else
					{
						node02.setExtend01("0");
					}
					node02.setId(""+id);
					resut.add(node02);
					if(value!=null )
					{
						count=count+Double.valueOf(value).intValue();
					}else
					{
						count=count+0;
					}
				}
			}
			node.setName(title);
			node.setExtend01(String.valueOf(count));
			resut.add(node);
			
		}
		return resut;
	}
	
	
	public static List<TreeNode2> getChildChartCircleuNITForproject02(List<String>  listLevel1Title,List<ProjectForMysql> listAll) 
	{
		
		
		
		List<TreeNode2> resut = new ArrayList();
		for(int i=0;i<listLevel1Title.size();i++)
		{
			String title=listLevel1Title.get(i);
			TreeNode2 node=new TreeNode2();
			node.setId("999"+String.valueOf(i));
			node.setLay_icon_open("/layuiadmin/layui/images/treegrid1_open.png");
			node.setLay_icon("/layuiadmin/layui/images/treegrid2.png");
			node.setLay_is_open(true);
			int count=0;
			for (int j = 0; j < listAll.size(); j++) 
			{
				ProjectForMysql entity=listAll.get(j);
				String name=entity.getProject_scope();
				Integer value=(Integer)entity.getZsl();
				String id=(String)entity.getId();
				String name02=(String)entity.getType_flag();
				
				
				if(name.equals(title))
				{
					TreeNode2 node02=new TreeNode2();
					node02.setpId(node.getId());
					node02.setName(name02);
					if(value!=null )
					{
						node02.setExtend01(String.valueOf(value));
					}else
					{
						node02.setExtend01("0");
					}
					node02.setId(""+id);
					resut.add(node02);
					if(value!=null )
					{
						count=count+Double.valueOf(value).intValue();
					}else
					{
						count=count+0;
					}
				}
			}
			node.setName(title);
			node.setExtend01(String.valueOf(count));
			resut.add(node);
			
		}
		return resut;
	}
	
	
	
	public static List<TreeNode2> getChildChartCircleuNITForproject(List<String>  listLevel1Title,List<H1AMKYSY100109> listAll) 
	{
		
		
		
		List<TreeNode2> resut = new ArrayList();
		for(int i=0;i<listLevel1Title.size();i++)
		{
			String title=listLevel1Title.get(i);
			TreeNode2 node=new TreeNode2();
			node.setId("999"+String.valueOf(i));
			node.setLay_icon_open("/layuiadmin/layui/images/treegrid1_open.png");
			node.setLay_icon("/layuiadmin/layui/images/treegrid2.png");
			node.setLay_is_open(true);
			int count=0;
			for (int j = 0; j < listAll.size(); j++) 
			{
				H1AMKYSY100109 entity=listAll.get(j);
				String name=entity.getG0XMXZ();
				String value=entity.getK0BNXMZXSL();
				String id=entity.getId();
				String name02=entity.getG0GSJC();
				
				
				if(name.equals(title))
				{
					TreeNode2 node02=new TreeNode2();
					node02.setpId(node.getId());
					node02.setName(name02);
					
					
					if(value!=null && !value.equals(""))
					{
						node02.setExtend01(String.valueOf(Double.valueOf(value).intValue()));
					}else
					{
						node02.setExtend01("0");
					}
					
					node02.setId(""+id);
					resut.add(node02);
					if(value!=null && !value.equals(""))
					{
						count=count+Double.valueOf(value).intValue();
					}else
					{
						count=count+0;
					}
					
					
				}
			}
			node.setName(title);
			node.setExtend01(String.valueOf(count));
			resut.add(node);
			
		}
		return resut;
	}
	
	public static List<TreeNode2> getChildChartCircleForBudgetCountMysql(List<String>  listLevel1Title,List<BudgetMysql> listAll) 
	{
		
		
		
		List<TreeNode2> resut = new ArrayList();
		for(int i=0;i<listLevel1Title.size();i++)
		{
			String title=listLevel1Title.get(i);
			TreeNode2 node=new TreeNode2();
			node.setId("999"+String.valueOf(i));
			node.setLay_icon_open("/layuiadmin/layui/images/treegrid1_open.png");
			node.setLay_icon("/layuiadmin/layui/images/treegrid2.png");
			node.setLay_is_open(true);
			Double count=0.00;
			for (int j = 0; j < listAll.size(); j++) 
			{
				BudgetMysql entity=listAll.get(j);
				String name=entity.getProject_scope();
				String K0BNXKJE =((BigDecimal)entity.getZje()).toString();
				String id=entity.getId();
				String name02=entity.getDefine1();
				
				//System.out.println(">>>>>>>>>>>>>>>K0BNXKJE " + K0BNXKJE+" K0BNXJJE="+K0BNXJJE+" id="+id);
				if(name.equals(title))
				{
					TreeNode2 node02=new TreeNode2();
					node02.setpId(node.getId());
					node02.setName(name02);
					node02.setExtend01(String.format("%.4f", Double.valueOf(K0BNXKJE)));
					node02.setId(""+id);
					resut.add(node02);
					
					count=add(count,Double.valueOf(K0BNXKJE));
					
					
				}
			}
			node.setName(title);
			node.setExtend01(String.format("%.4f", Double.valueOf(count)));
			resut.add(node);
			
		}
		return resut;
	}
	
	
	public static List<TreeNode2> getChildChartCircleForBudgetCount(List<String>  listLevel1Title,List<H1AMKYSY100109> listAll) 
	{
		
		
		
		List<TreeNode2> resut = new ArrayList();
		for(int i=0;i<listLevel1Title.size();i++)
		{
			String title=listLevel1Title.get(i);
			TreeNode2 node=new TreeNode2();
			node.setId("999"+String.valueOf(i));
			node.setLay_icon_open("/layuiadmin/layui/images/treegrid1_open.png");
			node.setLay_icon("/layuiadmin/layui/images/treegrid2.png");
			node.setLay_is_open(true);
			Double count=0.00;
			Double count2=0.00;
			for (int j = 0; j < listAll.size(); j++) 
			{
				H1AMKYSY100109 entity=listAll.get(j);
				String name=entity.getG0XMXZ();
				String K0BNXKJE=entity.getK0BNXKJE();
				String K0BNXJJE=entity.getK0BNXJJE();
				String K0BNYSJHJE=entity.getK0BNYSJHJE();
				String id=entity.getId();
				String name02=entity.getG0XMDL();
				
				//System.out.println(">>>>>>>>>>>>>>>K0BNXKJE " + K0BNXKJE+" K0BNXJJE="+K0BNXJJE+" id="+id);
				if(name.equals(title))
				{
					TreeNode2 node02=new TreeNode2();
					node02.setpId(node.getId());
					node02.setName(name02);
					node02.setExtend01(String.format("%.2f", Double.valueOf(K0BNYSJHJE)));
					//node02.setExtend01(String.format("%.2f", Double.valueOf(K0BNXKJE)));
					//node02.setExtend02(String.format("%.2f", Double.valueOf(K0BNXJJE)));
					node02.setId(""+id);
					resut.add(node02);
					/*if(K0BNXKJE!=null && !K0BNXKJE.equals(""))
					{
						count=add(count,Double.valueOf(K0BNXKJE));
					}else
					{
						count=add(count,0);
					}*/
					
					/*if(K0BNXKJE!=null && !K0BNXKJE.equals(""))
					{
						count=add(count,Double.valueOf(K0BNXKJE));
					}else
					{
						count=add(count,0);
					}
					
					if(K0BNXJJE!=null && !K0BNXJJE.equals(""))
					{
						count2=add(count2,Double.valueOf(K0BNXJJE));
					}else
					{
						count2=add(count2,0);
					}*/
					
					
					count=add(count,Double.valueOf(K0BNYSJHJE));
					//count2=add(count2,Double.valueOf(K0BNXJJE));
					
					
				}
			}
			node.setName(title);
			node.setExtend01(String.format("%.2f", Double.valueOf(count)));
			//node.setExtend02(String.format("%.2f", Double.valueOf(count2)));
			resut.add(node);
			
		}
		return resut;
	}
	
	
	public static List<TreeNode2> getChildChartCircleForprojectMYSQLa(List<ProjectForMysql> listAll) 
	{
		
		List<String>  listLevel1Title=new ArrayList();
		listLevel1Title.add("新开课题");
		listLevel1Title.add("结转课题");
		
		List<TreeNode2> resut = new ArrayList();
		for(int i=0;i<listLevel1Title.size();i++)
		{
			String title=listLevel1Title.get(i);
			TreeNode2 node=new TreeNode2();
			node.setId("999"+String.valueOf(i));
			node.setLay_icon_open("/layuiadmin/layui/images/treegrid1_open.png");
			node.setLay_icon("/layuiadmin/layui/images/treegrid2.png");
			node.setLay_is_open(true);
			int count=0;
			for (int j = 0; j < listAll.size(); j++) 
			{
				ProjectForMysql entity=listAll.get(j);
				Integer xksl=(Integer)entity.getXksl();
				Integer xjsl=(Integer)entity.getXjsl();
				String id=i+"_"+j;
				String name02=(String)entity.getType_flag();
				boolean lalg=getBoolean(entity,"xksl");
				//System.out.println(">>>>>>>>>>>>>>>name02 " + name02+" id="+id+" value="+value);
				if(lalg==true)
				{
					TreeNode2 node02=new TreeNode2();
					node02.setpId(node.getId());
					node02.setName(name02);
					
					if(xksl!=null)
					{
						node02.setExtend01(String.valueOf(xksl));
					}else
					{
						node02.setExtend01("0");
					}
					
					node02.setId(""+id);
					resut.add(node02);
					if(xksl!=null)
					{
						count=count+Double.valueOf(xksl).intValue();
					}else
					{
						count=count+0;
					}
					
					
				}
			}
			node.setName(title);
			node.setExtend01(String.valueOf(count));
			resut.add(node);
			
		}
		return resut;
		
	}
	
	public static boolean getBoolean(ProjectForMysql entity,String str)
	{
		
		boolean flag=false;
		Field[] arr = entity.getClass().getDeclaredFields();
		for (int k = 0; k < arr.length; k++) 
		{
			Field field = arr[k];
			String temp = field.getName();
			if (temp.equals(str))
			{
				flag=true;
			}
		}
		return flag;
	}
	public static List<TreeNode2> getChildChartCircleForproject(List<String>  listLevel1Title,List<H1AMKYSY100109> listAll) 
	{
		
		
		
		List<TreeNode2> resut = new ArrayList();
		for(int i=0;i<listLevel1Title.size();i++)
		{
			String title=listLevel1Title.get(i);
			TreeNode2 node=new TreeNode2();
			node.setId("999"+String.valueOf(i));
			node.setLay_icon_open("/layuiadmin/layui/images/treegrid1_open.png");
			node.setLay_icon("/layuiadmin/layui/images/treegrid2.png");
			node.setLay_is_open(true);
			int count=0;
			for (int j = 0; j < listAll.size(); j++) 
			{
				H1AMKYSY100109 entity=listAll.get(j);
				String name=entity.getG0XMXZ();
				String value=entity.getxKXJ();
				String id=entity.getId();
				String name02=entity.getG0XMGLLX();
				
				//System.out.println(">>>>>>>>>>>>>>>name02 " + name02+" id="+id+" value="+value);
				if(name.equals(title))
				{
					TreeNode2 node02=new TreeNode2();
					node02.setpId(node.getId());
					node02.setName(name02);
					
					
					if(value!=null && !value.equals(""))
					{
						node02.setExtend01(String.valueOf(Double.valueOf(value).intValue()));
					}else
					{
						node02.setExtend01("0");
					}
					
					node02.setId(""+id);
					resut.add(node02);
					if(value!=null && !value.equals(""))
					{
						count=count+Double.valueOf(value).intValue();
					}else
					{
						count=count+0;
					}
					
					
				}
			}
			node.setName(title);
			node.setExtend01(String.valueOf(count));
			resut.add(node);
			
		}
		return resut;
	}
	/*public static ChartCircle2 getChartCircleForprojt(List<H1AMKYSY100109> listAll,String str,String color)
	{
		
		List<String> colorList=getClorList();
		ChartCircle2 cc01=new ChartCircle2();
		//第一级
		cc01.setName(str);
		//第二级
		List<Child2> children01=new ArrayList<Child2>();
		ChartCircleItemStyle chartCircleItemStyle=new ChartCircleItemStyle();
		chartCircleItemStyle.setColor(color);
		cc01.setItemStyle(chartCircleItemStyle);
		List<H1AMKYSY100109> newLiST=new ArrayList<H1AMKYSY100109>();
		
		for (int i = 0; i < listAll.size(); i++) 
		{
			H1AMKYSY100109 h1AMKYSY100109=listAll.get(i);
			String name=h1AMKYSY100109.getG0XMXZ();
			if(name.equals(str))
			{
				newLiST.add(h1AMKYSY100109);
				String G0XMGLLX_name=h1AMKYSY100109.getG0XMGLLX();
				String value=h1AMKYSY100109.getkKXJ();
				Child2 child=new Child2();
				child.setName(G0XMGLLX_name);
				if(value!=null && !value.equals(""))
				{
					child.setValue(Double.valueOf(value).intValue());
				}else
				{
					child.setValue(0);
				}
				
				
				ChartCircleItemStyle cc=new ChartCircleItemStyle();
				cc.setColor(colorList.get(i));
				child.setItemStyle(cc);
				
				
				children01.add(child);
			}
		}
		cc01.setChildren(children01);
		return cc01;
	}*/
	
	
	public static List<ChartCircle> getChildChartCircleForJFZC(List<String>  listLevel1Title,List<H1AMKYSY100104> listAll) 
	{
		
		
		List<String> colorList=getClorList();
		
		List<ChartCircle> resut = new ArrayList();
		for(int i=0;i<listLevel1Title.size();i++)
		{
			String title=listLevel1Title.get(i);
			ChartCircle  cc= getChartCircleForJCZC( listAll,title,colorList.get(i));
			resut.add(cc);
		}
		return resut;
	}
	
	
	
	
	public static List<ChartCircle2> getChildChartCircleForAward02(List<Award> listAll) 
	{
		List<Award> newList=new ArrayList<Award>();
		
		for(int i=0;i<listAll.size();i++)
		{
			Award entity=listAll.get(i);
			Field[] arr = entity.getClass().getDeclaredFields();
			for (int j = 0; j < arr.length; j++) 
			{
				Field field = arr[j];
				String str = field.getName();
				
				if (str.equals("gnxjcount")) 
				{
					entity.setGnxjName("国内先进");
				}
				if (str.equals("gnlxcount")) 
				{
					entity.setGnlxName("国内领先");
				}
				if (str.equals("gjxjcount")) 
				{
					entity.setGjxjName("国际先进");
				}
				if (str.equals("gjlxcount")) 
				{
					entity.setGjlxName("国际领先");
				}
				if (str.equals("hyxjcount")) 
				{
					entity.setHyxjName("行业先进");
				}
				if (str.equals("hylxcount")) 
				{
					entity.setHylxName("行业领先");
				}
			}
			
			newList.add(entity);
			
		}
		List<ChartCircle2> resut =getChartCircleForAward(newList);
		return resut;
	}
	
	
	
	
	public static List<TreeNode2> getChildChartCircleAward02type(List<String>  listLevel1Title,List<Award> listAll) 
	{
		
		
		
		List<TreeNode2> resut = new ArrayList();
		for(int i=0;i<listLevel1Title.size();i++)
		{
			String title=listLevel1Title.get(i);
			TreeNode2 node=new TreeNode2();
			node.setId("first_"+String.valueOf(i));
			node.setLay_icon_open("/layuiadmin/layui/images/treegrid1_open.png");
			node.setLay_icon("/layuiadmin/layui/images/treegrid2.png");
			node.setLay_is_open(true);
			node.setName(title);
			
			int count=0;
			for (int j = 0; j < listAll.size(); j++) 
			{
				Award entity=listAll.get(j);
				String name=entity.getCglx();
				if(name.equals(title))
				{
					TreeNode2 node1=new TreeNode2();
					node1.setpId(node.getId());
					node1.setId("second_"+j+"_"+1);
					String extend01=entity.getGnxjcount();
					node1.setExtend01(extend01);
					node1.setName("国内先进");
					resut.add(node1);
					
					count=count+Double.valueOf(extend01).intValue();
					
					
					TreeNode2 node2=new TreeNode2();
					node2.setpId(node.getId());
					node2.setId("second_"+j+"_"+2);
					String gnlxcount=entity.getGnlxcount();
					node2.setExtend01(gnlxcount);
					node2.setName("国内领先");
					resut.add(node2);
					count=count+Double.valueOf(gnlxcount).intValue();
					
					TreeNode2 node3=new TreeNode2();
					node3.setpId(node.getId());
					node3.setId("second_"+j+"_"+3);
					String gjxjcount=entity.getGjxjcount();
					node3.setExtend01(gjxjcount);
					node3.setName("国际先进");
					resut.add(node3);
					count=count+Double.valueOf(gjxjcount).intValue();
					
					
					TreeNode2 node4=new TreeNode2();
					node4.setpId(node.getId());
					node4.setId("second_"+j+"_"+4);
					String gjlxcount=entity.getGjlxcount();
					node4.setExtend01(gjlxcount);
					node4.setName("国际领先");
					resut.add(node4);
					count=count+Double.valueOf(gjlxcount).intValue();
					
					TreeNode2 node5=new TreeNode2();
					node5.setpId(node.getId());
					node5.setId("second_"+j+"_"+5);
					String hyxjcount=entity.getHyxjcount();
					node5.setExtend01(hyxjcount);
					node5.setName("行业先进");
					resut.add(node5);
					count=count+Double.valueOf(hyxjcount).intValue();
					
					TreeNode2 node6=new TreeNode2();
					node6.setpId(node.getId());
					node6.setId("second_"+j+"_"+6);
					String hylxcount=entity.getHylxcount();
					node6.setExtend01(hylxcount);
					node6.setName("行业领先");
					resut.add(node6);
					count=count+Double.valueOf(hylxcount).intValue();
				}
				
		}
			
			
			node.setExtend01(String.valueOf(count));
			resut.add(node);
		}
		return resut;
	}
	
	
	public static List<ChartCircle2> getChildChartCircleForAward(List<Award> listAll) 
	{
		List<Award> newList=new ArrayList<Award>();
		
		for(int i=0;i<listAll.size();i++)
		{
			Award entity=listAll.get(i);
			Field[] arr = entity.getClass().getDeclaredFields();
			for (int j = 0; j < arr.length; j++) 
			{
				Field field = arr[j];
				String str = field.getName();
				
				if (str.equals("gnxjcount")) 
				{
					entity.setGnxjName("国内先进");
				}
				if (str.equals("gnlxcount")) 
				{
					entity.setGnlxName("国内领先");
				}
				if (str.equals("gjxjcount")) 
				{
					entity.setGjxjName("国际先进");
				}
				if (str.equals("gjlxcount")) 
				{
					entity.setGjlxName("国际领先");
				}
				if (str.equals("hyxjcount")) 
				{
					entity.setHyxjName("行业先进");
				}
				if (str.equals("hylxcount")) 
				{
					entity.setHylxName("行业领先");
				}
			}
			
			newList.add(entity);
			
		}
		List<ChartCircle2> resut =getChartCircleForAward(newList);
		return resut;
	}
	
	
	
	public static ChartCircle getChartCircle(List<H1AMKYSY100109> listAll,String str,String color)
	{
		List<String> colorList=getClorList();
		
		ChartCircle cc01=new ChartCircle();
		//第一级
		cc01.setName(str);
		//第二级
		List<Child> children01=new ArrayList<Child>();
		ChartCircleItemStyle chartCircleItemStyle=new ChartCircleItemStyle();
		chartCircleItemStyle.setColor(color);
		cc01.setItemStyle(chartCircleItemStyle);
		List<H1AMKYSY100109> newLiST=new ArrayList<H1AMKYSY100109>();
		
		for (int i = 0; i < listAll.size(); i++) 
		{
			H1AMKYSY100109 h1AMKYSY100109=listAll.get(i);
			String name=h1AMKYSY100109.getG0XMXZ();
			if(name.equals(str))
			{
				newLiST.add(h1AMKYSY100109);
				String g0XMGLJB=h1AMKYSY100109.getG0XMGLJB();
				Child child=new Child();
				child.setName(g0XMGLJB);
				
				
				ChartCircleItemStyle cc=new ChartCircleItemStyle();
				cc.setColor(colorList.get(i));
				child.setItemStyle(cc);
				
				
				children01.add(child);
			}
		}
		//第二级去重
		children01=removeDuplicate(children01);
		
		List<Child> temp_children=new ArrayList<Child>();
		for (int i = 0; i < children01.size(); i++) 
		{
			Child child=children01.get(i);
			String name=child.getName();
			//第三级
			List<NameValue> children=new ArrayList<NameValue>();
			for (int j = 0; j < newLiST.size(); j++) 
			{
				H1AMKYSY100109 h1AMKYSY100109=newLiST.get(j);
				String temp_name=h1AMKYSY100109.getG0XMGLJB();
				if(name.equals(temp_name))
				{
					String g0XMGLLX=h1AMKYSY100109.getG0XMGLLX();
					String k0BNXMXKSL=h1AMKYSY100109.getK0BNXMXKSL();
					String k0BNXMXJSL=h1AMKYSY100109.getK0BNXMXJSL();
					NameValue nameValue=new NameValue();
					nameValue.setName(g0XMGLLX);
					if(str.equals("新开课题"))
					{
						nameValue.setValue(Double.valueOf(k0BNXMXKSL).intValue());
					}
					if(str.equals("结转课题"))
					{
						nameValue.setValue(Double.valueOf(k0BNXMXJSL).intValue());
					}
					ChartCircleItemStyle cc=new ChartCircleItemStyle();
					cc.setColor(colorList.get(j));
					nameValue.setItemStyle(cc);
					children.add(nameValue);
					
				}
			}
			child.setChildren(children);
			temp_children.add(child);
		}
		cc01.setChildren(temp_children);
		return cc01;
	}
	
	
	
	
	
	
	public static List<ChartCircle2> getChartCircleForAward(List<Award> listAll)
	{
		List<ChartCircle2> resut = new ArrayList();
		List<String> colorList=getClorList();
	
		for (int i = 0; i < listAll.size(); i++) 
		{
			Award award=listAll.get(i);
			String name=award.getCglx();
			String value=award.getCglxcount();
			ChartCircle2 chartCircle=new ChartCircle2();
			chartCircle.setName(name);
			chartCircle.setValue(Integer.valueOf(value));
			
			ChartCircleItemStyle chartCircleItemStyle=new ChartCircleItemStyle();
			chartCircleItemStyle.setColor(colorList.get(i));
			chartCircle.setItemStyle(chartCircleItemStyle);
			
			
			    List<Child2> children=new ArrayList<Child2>();
				String gnxjcount=award.getGnxjcount();
				String gnlxcount=award.getGnlxcount();
				String gjxjcount=award.getGjxjcount();
				String gjlxcount=award.getGjlxcount();
				String hyxjcount=award.getHyxjcount();
				String hylxcount=award.getHylxcount();
				
				String gnxjName=award.getGnxjName();
				String gnlxName=award.getGnlxName();
				String gjxjName=award.getGjxjName();
				String gjlxName=award.getGjlxName();
				String hyxjName=award.getHyxjName();
				String hylxName=award.getHylxName();
				
				//1
				Child2 gnxj=new Child2();
				gnxj.setName(gnxjName);
				gnxj.setValue(Integer.valueOf(gnxjcount));
				
				ChartCircleItemStyle cc=new ChartCircleItemStyle();
				cc.setColor(colorList.get(i+1));
				gnxj.setItemStyle(cc);
				
				children.add(gnxj);
				//2
				Child2 gnlx=new Child2();
				gnlx.setName(gnlxName);
				gnlx.setValue(Integer.valueOf(gnlxcount));
				ChartCircleItemStyle ccc=new ChartCircleItemStyle();
				ccc.setColor(colorList.get(i+2));
				gnlx.setItemStyle(ccc);
				
				children.add(gnlx);
				//3
				Child2 gjxj=new Child2();
				gjxj.setName(gjxjName);
				gjxj.setValue(Integer.valueOf(gjxjcount));
				
				ChartCircleItemStyle cccc=new ChartCircleItemStyle();
				cccc.setColor(colorList.get(i+3));
				gjxj.setItemStyle(cccc);
				
				
				children.add(gjxj);
				//4
				Child2 gjlx=new Child2();
				gjlx.setName(gjlxName);
				gjlx.setValue(Integer.valueOf(gjlxcount));
				
				ChartCircleItemStyle a=new ChartCircleItemStyle();
				a.setColor(colorList.get(i+4));
				gjlx.setItemStyle(a);
				children.add(gjlx);
				
				//5
				Child2 hyxj=new Child2();
				hyxj.setName(hyxjName);
				hyxj.setValue(Integer.valueOf(hyxjcount));
				
				ChartCircleItemStyle v=new ChartCircleItemStyle();
				v.setColor(colorList.get(i+5));
				hyxj.setItemStyle(v);
				
				children.add(hyxj);
				
				
				//6
				Child2 hylx=new Child2();
				hylx.setName(hylxName);
				hylx.setValue(Integer.valueOf(hylxcount));
				
				ChartCircleItemStyle g=new ChartCircleItemStyle();
				g.setColor(colorList.get(i+6));
				hylx.setItemStyle(g);
				children.add(hylx);
			
			
			chartCircle.setChildren(children);
			resut.add(chartCircle);
			
		}
		return resut;
	}
	
	
	public static ChartCircle getChartCircleForJCZC(List<H1AMKYSY100104> listAll,String str,String color)
	{
		
		List<String> colorList=getClorList();
		ChartCircle cc01=new ChartCircle();
		//第一级
		cc01.setName(str);
		//第二级
		List<Child> children01=new ArrayList<Child>();
		ChartCircleItemStyle chartCircleItemStyle=new ChartCircleItemStyle();
		chartCircleItemStyle.setColor(color);
		cc01.setItemStyle(chartCircleItemStyle);
		List<H1AMKYSY100104> newLiST=new ArrayList<H1AMKYSY100104>();
		
		for (int i = 0; i < listAll.size(); i++) 
		{
			H1AMKYSY100104 h1AMKYSY100109=listAll.get(i);
			String name=h1AMKYSY100109.getG0XMGLLX();
			if(name.equals(str))
			{
				newLiST.add(h1AMKYSY100109);
				String g0XMGLJB=h1AMKYSY100109.getG0XMGLJB();
				Child child=new Child();
				child.setName(g0XMGLJB);
				
				
				ChartCircleItemStyle cc=new ChartCircleItemStyle();
				cc.setColor(colorList.get(i));
				child.setItemStyle(cc);
				
				
				children01.add(child);
			}
		}
		//第二级去重
		children01=removeDuplicate(children01);
		
		
		List<Child> temp_children=new ArrayList<Child>();
		for (int i = 0; i < children01.size(); i++) 
		{
			Child child=children01.get(i);
			String name=child.getName();
			//第三级
			List<NameValue> children=new ArrayList<NameValue>();
			for (int j = 0; j < newLiST.size(); j++) 
			{
				H1AMKYSY100104 h1AMKYSY100109=newLiST.get(j);
				String temp_name=h1AMKYSY100109.getG0XMGLJB();
				if(name.equals(temp_name))
				{
					String g0XMLXMS=h1AMKYSY100109.getG0XMLXMS();
					String k0BNGLFPHJECB=h1AMKYSY100109.getK0BNGLFPHJECB();
					NameValue nameValue=new NameValue();
					nameValue.setName(g0XMLXMS);
					nameValue.setValue(Float.valueOf(k0BNGLFPHJECB).floatValue());
					
					
					ChartCircleItemStyle cc=new ChartCircleItemStyle();
					cc.setColor(colorList.get(j));
					nameValue.setItemStyle(cc);
					
					children.add(nameValue);
					
				}
			}
			child.setChildren(children);
			temp_children.add(child);
		}
		cc01.setChildren(temp_children);
		return cc01;
	}
	
	

	public static List<Child> removeDuplicate(List<Child> list)
	{
		for (int i = 0; i < list.size() - 1; i++) 
		{
			for (int j = list.size() - 1; j > i; j--) 
			{
				
				if (list.get(j).getName().equals(list.get(i).getName())) 
				{
					list.remove(j);
				}
			}
		}
		return list;
	}

	public static List<String> getXAxisDataList_TotalCostProjectPay02(List<TotalCostProjectPay02> list) {
		List<String> xAxisDataList = new ArrayList<String>();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				TotalCostProjectPay02 f03 = list.get(i);
				String xAxisData = f03.getG0FYFL();
				xAxisDataList.add(xAxisData);
			}

		}
		return xAxisDataList;
	}

	public static List<String> getXAxisDataList(List<FundsComprehensiveAnalysis03> list) {
		List<String> xAxisDataList = new ArrayList<String>();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				FundsComprehensiveAnalysis03 f03 = list.get(i);
				String xAxisData = f03.getG0GSJC();
				xAxisDataList.add(xAxisData);
			}

		}
		return xAxisDataList;
	}

	public static ChartBarLineSeries getChartBarLineSeries_ScientificInstrumentPay(List<ScientificInstrumentPay> list,
			String name) {
		ChartBarLineSeries chartBarLineSeries = new ChartBarLineSeries();
		if (name.equals("K0BNZCJE")) {
			chartBarLineSeries.setName("本期");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		if (name.equals("K0SNZCJE")) {
			chartBarLineSeries.setName("同期");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		if (name.equals("K0TQBL")) {
			chartBarLineSeries.setName("同比");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_LINE);
		}

		List<Object> dataList = new ArrayList<Object>();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				ScientificInstrumentPay f03 = list.get(i);

				String k0BNZCJE = f03.getK0BNZCJE();// 计划
				String k0SNZCJE = f03.getK0SNZCJE();// 实际
				String K0TQBL = f03.getK0TQBL();// 本期
				
				k0BNZCJE=String.format("%.2f", Double.valueOf(k0BNZCJE));
				k0SNZCJE=String.format("%.2f", Double.valueOf(k0SNZCJE));
				K0TQBL=String.format("%.2f", Double.valueOf(K0TQBL));

				if (name.equals("K0BNZCJE")) {
					dataList.add(k0BNZCJE);
				}
				if (name.equals("K0SNZCJE")) {
					dataList.add(k0SNZCJE);
				}
				if (name.equals("K0TQBL")) {
					dataList.add(K0TQBL);
				}

			}
			chartBarLineSeries.setData(dataList);
		}
		return chartBarLineSeries;
	}
	
	public static ChartBarLineSeries getChartBarLineSeries_HOMPAGE02(List<H1AMKYSY100109> list, String name) {

		ChartBarLineSeries chartBarLineSeries = new ChartBarLineSeries();
		if (name.equals("K0BNXMXKSL")) {
			chartBarLineSeries.setName("新开课题");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		if (name.equals("K0BNXMXJSL")) {
			chartBarLineSeries.setName("结转课题");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		if (name.equals("K0BNXMWGSL")) {
			chartBarLineSeries.setName("完工项目");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		if (name.equals("K0BNXMYQSL")) {
			chartBarLineSeries.setName("延期项目");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		if (name.equals("K0BNXMWJSL")) {
			chartBarLineSeries.setName("应结题未结题");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}

		List<Object> dataList = new ArrayList<Object>();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				H1AMKYSY100109 f03 = list.get(i);
				String K0BNXMXKSL = f03.getK0BNXMXKSL();
				String K0BNXMXJSL = f03.getK0BNXMXJSL();
				String K0BNXMWGSL = f03.getK0BNXMWGSL();
				String K0BNXMYQSL = f03.getK0BNXMYQSL();
				String K0BNXMWJSL = f03.getK0BNXMWJSL();
				int K0BNXMWJSL_v = Double.valueOf(K0BNXMWJSL).intValue();// 转换为Int类型

				// System.out.println(">>>>>>>>>>>>>>>K0BNXMWJSL" + K0BNXMWJSL+"
				// K0BNXMYQSL="+K0BNXMYQSL);
				if (name.equals("K0BNXMXKSL")) {
					dataList.add(Double.valueOf(K0BNXMXKSL).intValue());
				}
				if (name.equals("K0BNXMXJSL")) {
					dataList.add(Double.valueOf(K0BNXMXJSL).intValue());
				}
				if (name.equals("K0BNXMWGSL")) {
					dataList.add(Double.valueOf(K0BNXMWGSL).intValue());
				}
				if (name.equals("K0BNXMYQSL")) {
					dataList.add(Double.valueOf(K0BNXMYQSL).intValue());
				}
				if (name.equals("K0BNXMWJSL")) {
					dataList.add(K0BNXMWJSL_v);
				}

			}
			chartBarLineSeries.setData(dataList);
		}
		return chartBarLineSeries;
	}
	

	public static ChartBarLineSeries getChartBarLineSeries_HOMPAGE(List<H1AMKYSY100109> list, String name) {

		ChartBarLineSeries chartBarLineSeries = new ChartBarLineSeries();
		if (name.equals("K0BNXMXKSL")) {
			chartBarLineSeries.setName("新开课题");
			chartBarLineSeries.setStack("总量");
			chartBarLineSeries.setAreaStyle(new Object());
			chartBarLineSeries.setColor("#4a94eb");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_LINE);
			chartBarLineSeries.setSmooth(true);
		}
		if (name.equals("K0BNXMXJSL")) {
			chartBarLineSeries.setName("结转课题");
			chartBarLineSeries.setStack("总量");
			chartBarLineSeries.setColor("#43bb7c");
			chartBarLineSeries.setAreaStyle(new Object());
			chartBarLineSeries.setSmooth(true);
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_LINE);
		}
		if (name.equals("K0BNXMWGSL")) {
			chartBarLineSeries.setName("完工项目");
			chartBarLineSeries.setAreaStyle(new Object());
			chartBarLineSeries.setColor("#f8b551");
			chartBarLineSeries.setSmooth(true);
			chartBarLineSeries.setStack("总量");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_LINE);
		}
		if (name.equals("K0BNXMYQSL")) {
			chartBarLineSeries.setName("延期项目");
			chartBarLineSeries.setStack("总量");
			chartBarLineSeries.setColor("#b3d465");
			chartBarLineSeries.setAreaStyle(new Object());
			chartBarLineSeries.setSmooth(true);
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_LINE);
		}
		if (name.equals("K0BNXMWJSL")) {
			chartBarLineSeries.setName("应结题未结题");
			chartBarLineSeries.setStack("总量");
			chartBarLineSeries.setColor("#c9c9c9");
			chartBarLineSeries.setSmooth(true);
			chartBarLineSeries.setAreaStyle(new Object());
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_LINE);
		}

		List<Object> dataList = new ArrayList<Object>();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				H1AMKYSY100109 f03 = list.get(i);
				String K0BNXMXKSL = f03.getK0BNXMXKSL();
				String K0BNXMXJSL = f03.getK0BNXMXJSL();
				String K0BNXMWGSL = f03.getK0BNXMWGSL();
				String K0BNXMYQSL = f03.getK0BNXMYQSL();
				String K0BNXMWJSL = f03.getK0BNXMWJSL();
				int K0BNXMWJSL_v = Double.valueOf(K0BNXMWJSL).intValue();// 转换为Int类型

				// System.out.println(">>>>>>>>>>>>>>>K0BNXMWJSL" + K0BNXMWJSL+"
				// K0BNXMYQSL="+K0BNXMYQSL);
				if (name.equals("K0BNXMXKSL")) {
					dataList.add(Double.valueOf(K0BNXMXKSL).intValue());
				}
				if (name.equals("K0BNXMXJSL")) {
					dataList.add(Double.valueOf(K0BNXMXJSL).intValue());
				}
				if (name.equals("K0BNXMWGSL")) {
					dataList.add(Double.valueOf(K0BNXMWGSL).intValue());
				}
				if (name.equals("K0BNXMYQSL")) {
					dataList.add(Double.valueOf(K0BNXMYQSL).intValue());
				}
				if (name.equals("K0BNXMWJSL")) {
					dataList.add(K0BNXMWJSL_v);
				}

			}
			chartBarLineSeries.setData(dataList);
		}
		return chartBarLineSeries;
	}
	
	
	
	
	public static ChartBarLineSeries getKYZBLevel2ChartBarLineSeries(List<H1AMKYSY100109> list, String name) {

		ChartBarLineSeries chartBarLineSeries = new ChartBarLineSeries();
		if (name.equals("K0BNXMXKSL")) {
			chartBarLineSeries.setName("新开课题");
			chartBarLineSeries.setStack("总量");
			chartBarLineSeries.setAreaStyle(new Object());
			chartBarLineSeries.setColor("#4a94eb");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_LINE);
			chartBarLineSeries.setSmooth(true);
		}
		if (name.equals("K0BNXMXJSL")) {
			chartBarLineSeries.setName("结转课题");
			chartBarLineSeries.setStack("总量");
			chartBarLineSeries.setColor("#43bb7c");
			chartBarLineSeries.setAreaStyle(new Object());
			chartBarLineSeries.setSmooth(true);
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_LINE);
		}
		

		List<Object> dataList = new ArrayList<Object>();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				H1AMKYSY100109 f03 = list.get(i);
				String K0BNXMXKSL = f03.getK0BNXMXKSL();
				String K0BNXMXJSL = f03.getK0BNXMXJSL();


				if (name.equals("K0BNXMXKSL")) {
					dataList.add(Double.valueOf(K0BNXMXKSL).intValue());
				}
				if (name.equals("K0BNXMXJSL")) {
					dataList.add(Double.valueOf(K0BNXMXJSL).intValue());
				}
				

			}
			chartBarLineSeries.setData(dataList);
		}
		return chartBarLineSeries;
	}
	
	public static ChartBarLineSeries getAwardELevel2ChartBarLineSeries(List<Award> list, String name) {
		
		    ChartBarLineSeries chartBarLineSeries = new ChartBarLineSeries();
			chartBarLineSeries.setName(name);
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		

		List<Object> dataList = new ArrayList<Object>();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++)
			{
				Award f03 = list.get(i);
				String str=f03.getJdjg();
				if(name.equals(str))
				{
					String a = f03.getAcount();
					String b = f03.getBcount();
					String c = f03.getCcount();
					String d = f03.getDcount();
					String e = f03.getEcount();
					String f = f03.getFcount();
					String g = f03.getGcount();
					String h = f03.getHcount();
					String ii = f03.getIcount();
					String j = f03.getJcount();
					String k = f03.getKcount();
					dataList.add(a);
					dataList.add(b);
					dataList.add(c);
					dataList.add(d);
					dataList.add(e);
					dataList.add(f);
					dataList.add(g);
					dataList.add(h);
					dataList.add(ii);
					dataList.add(j);
					dataList.add(k);
				}
			}
			chartBarLineSeries.setData(dataList);
		}
		return chartBarLineSeries;
	}
	
	
	public static ChartBarLineSeries getKNOWLDGELevel2ChartBarLineSeries(List<Knowledge> list, String name) {

		ChartBarLineSeries chartBarLineSeries = new ChartBarLineSeries();
		if (name.equals("agreeCount")) {
			chartBarLineSeries.setName("专利授权");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		if (name.equals("applyCount")) {
			chartBarLineSeries.setName("专利申请");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		

		List<Object> dataList = new ArrayList<Object>();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Knowledge f03 = list.get(i);
				String Agree = f03.getAgreeCount();
				String Apply = f03.getApplyCount();


				if (name.equals("agreeCount")) {
					
					if (Agree==null || Agree.equals(""))
					{
						dataList.add(0);
					}else
					{
						dataList.add(Double.valueOf(Agree).intValue());
					}
					
					
				}
				if (name.equals("applyCount")) {
					
					if (Apply==null || Apply.equals(""))
					{
						dataList.add(0);
					}else
					{
						dataList.add(Double.valueOf(Apply).intValue());
					}
					
					
				}
				

			}
			chartBarLineSeries.setData(dataList);
		}
		return chartBarLineSeries;
	}
	
	
	
	
	public static ChartBarLineSeries getKNOWLDGELevel2ChartBarLineSeries_stack(List<Knowledge> list, String name) {

		ChartBarLineSeries chartBarLineSeries = new ChartBarLineSeries();
		if (name.equals("fmsqsl")) {
			chartBarLineSeries.setName("发明专利");
			chartBarLineSeries.setStack("数量");
			chartBarLineSeries.setItemStyle("{normal:{color:'#DF7010'}}");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		if (name.equals("wgsjsl")) {
			chartBarLineSeries.setName("外观设计");
			chartBarLineSeries.setStack("数量");
			chartBarLineSeries.setItemStyle("{normal:{color:'#FF8849'}}");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		if (name.equals("syxxsl")) {
			chartBarLineSeries.setName("实用新型");
			chartBarLineSeries.setStack("数量");
			
			chartBarLineSeries.setItemStyle("{normal:{color:'#3FBB49'}}");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}

		List<Object> dataList = new ArrayList<Object>();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Knowledge f03 = list.get(i);
				String fmsqsl = f03.getFmsqsl();
				String wgsjsl = f03.getWgsjsl();

				String syxxsl = f03.getSyxxsl();
				if (name.equals("fmsqsl")) {
					dataList.add(Double.valueOf(fmsqsl).intValue());
				}
				if (name.equals("wgsjsl")) {
					dataList.add(Double.valueOf(wgsjsl).intValue());
				}
				if (name.equals("syxxsl")) {
					dataList.add(Double.valueOf(syxxsl).intValue());
				}

			}
			chartBarLineSeries.setData(dataList);
		}
		return chartBarLineSeries;
	}
	
	public static ChartBarLineSeries getKNOWLDGELevel2ChartBarLineSeries02(List<Knowledge> list, String name) {

		ChartBarLineSeries chartBarLineSeries = new ChartBarLineSeries();
		if (name.equals("fmsqsl")) {
			chartBarLineSeries.setName("发明专利");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		if (name.equals("wgsjsl")) {
			chartBarLineSeries.setName("外观设计");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		if (name.equals("syxxsl")) {
			chartBarLineSeries.setName("实用新型");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}

		List<Object> dataList = new ArrayList<Object>();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Knowledge f03 = list.get(i);
				String fmsqsl = f03.getFmsqsl();
				String wgsjsl = f03.getWgsjsl();

				String syxxsl = f03.getSyxxsl();
				if (name.equals("fmsqsl")) {
					dataList.add(Double.valueOf(fmsqsl).intValue());
				}
				if (name.equals("wgsjsl")) {
					dataList.add(Double.valueOf(wgsjsl).intValue());
				}
				if (name.equals("syxxsl")) {
					dataList.add(Double.valueOf(syxxsl).intValue());
				}

			}
			chartBarLineSeries.setData(dataList);
		}
		return chartBarLineSeries;
	}
	
	
	
	
	public static ChartBarLineSeries getDeviceForMysqlChartBarLineSeries(List<ProjectForMysql> list, String name) {

		ChartBarLineSeries chartBarLineSeries = new ChartBarLineSeries();
		if (name.equals("xksl")) {
			chartBarLineSeries.setName("新开课题");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		if (name.equals("xjsl")) {
			chartBarLineSeries.setName("结转课题");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		

		List<Object> dataList = new ArrayList<Object>();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				ProjectForMysql f03 = list.get(i);
				Integer xksl = (Integer)f03.getXksl();
				Integer xjsl =  (Integer)f03.getXjsl();


				if (name.equals("xksl")) {
					
					if(xksl!=null)
					{
						dataList.add(xksl);
					}else
					{
						dataList.add(0);
					}
					
					
				}
				if (name.equals("xjsl")) {
					
					if(xjsl!=null)
					{
						dataList.add(xjsl);
					}else
					{
						dataList.add(0);
					}
					
					
					
				}
				

			}
			chartBarLineSeries.setData(dataList);
		}
		return chartBarLineSeries;
	}
	
	
	
	public static ChartBarLineSeries getdevceForMysqlChartBarLineSeries(List<ProjectForMysql> list, String name) {

		ChartBarLineSeries chartBarLineSeries = new ChartBarLineSeries();
		if (name.equals("xksl")) {
			chartBarLineSeries.setName("新开课题");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		if (name.equals("xjsl")) {
			chartBarLineSeries.setName("结转课题");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		

		List<Object> dataList = new ArrayList<Object>();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				ProjectForMysql f03 = list.get(i);
				Integer xksl = (Integer)f03.getXksl();
				Integer xjsl =  (Integer)f03.getXjsl();
				String zycmc= f03.getZycmc();
				
					if (name.equals("xksl")) {
						
						if(xksl!=null)
						{
							dataList.add(xksl);
						}else
						{
							dataList.add(0);
						}
						
						
					}
					if (name.equals("xjsl")) {
						
						if(xjsl!=null)
						{
							dataList.add(xjsl);
						}else
						{
							dataList.add(0);
						}
						
						
						
					}
					
				

				

			}
			chartBarLineSeries.setData(dataList);
		}
		return chartBarLineSeries;
	}
	
	
	
	

	public static ChartBarLineSeries getProjectCountForMysqlChartBarLineSeries(List<ProjectForMysql> list, String name) {

		ChartBarLineSeries chartBarLineSeries = new ChartBarLineSeries();
		if (name.equals("xksl")) {
			chartBarLineSeries.setName("新开课题");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		if (name.equals("xjsl")) {
			chartBarLineSeries.setName("结转课题");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		

		List<Object> dataList = new ArrayList<Object>();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				ProjectForMysql f03 = list.get(i);
				Integer xksl = (Integer)f03.getXksl();
				Integer xjsl =  (Integer)f03.getXjsl();
				String zycmc= f03.getZycmc();
				if(zycmc!=null)
				{
					if (name.equals("xksl")) {
						
						if(xksl!=null)
						{
							dataList.add(xksl);
						}else
						{
							dataList.add(0);
						}
						
						
					}
					if (name.equals("xjsl")) {
						
						if(xjsl!=null)
						{
							dataList.add(xjsl);
						}else
						{
							dataList.add(0);
						}
						
						
						
					}
					
				}

				

			}
			chartBarLineSeries.setData(dataList);
		}
		return chartBarLineSeries;
	}
	
	
	
	
	
	public static ChartBarLineSeries getProjectForMysqlChartBarLineSeries(List<ProjectForMysql> list, String name) {

		ChartBarLineSeries chartBarLineSeries = new ChartBarLineSeries();
		if (name.equals("xksl")) {
			chartBarLineSeries.setName("新开课题");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		if (name.equals("xjsl")) {
			chartBarLineSeries.setName("结转课题");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		

		List<Object> dataList = new ArrayList<Object>();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				ProjectForMysql f03 = list.get(i);
				Integer xksl = (Integer)f03.getXksl();
				Integer xjsl =  (Integer)f03.getXjsl();
				
					if (name.equals("xksl")) {
						
						if(xksl!=null)
						{
							dataList.add(xksl);
						}else
						{
							dataList.add(0);
						}
						
						
					}
					if (name.equals("xjsl")) {
						
						if(xjsl!=null)
						{
							dataList.add(xjsl);
						}else
						{
							dataList.add(0);
						}
						
						
						
					}
					
				

				

			}
			chartBarLineSeries.setData(dataList);
		}
		return chartBarLineSeries;
	}
	
	
	
	
	
	public static ChartBarLineSeries getHomeProjectLevel2ChartBarLineSeries(List<H1AMKYSY100109> list, String name) {

		ChartBarLineSeries chartBarLineSeries = new ChartBarLineSeries();
		if (name.equals("K0BNXMXKSL")) {
			chartBarLineSeries.setName("新开课题");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		if (name.equals("K0BNXMXJSL")) {
			chartBarLineSeries.setName("结转课题");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		

		List<Object> dataList = new ArrayList<Object>();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				H1AMKYSY100109 f03 = list.get(i);
				String K0BNXMXKSL = f03.getK0BNXMXKSL();
				String K0BNXMXJSL = f03.getK0BNXMXJSL();


				if (name.equals("K0BNXMXKSL")) {
					
					if(K0BNXMXKSL!=null)
					{
						dataList.add(Double.valueOf(K0BNXMXKSL).intValue());
					}else
					{
						dataList.add(0);
					}
					
					
				}
				if (name.equals("K0BNXMXJSL")) {
					
					if(K0BNXMXJSL!=null)
					{
						dataList.add(Double.valueOf(K0BNXMXJSL).intValue());
					}else
					{
						dataList.add(0);
					}
					
					
					
				}
				

			}
			chartBarLineSeries.setData(dataList);
		}
		return chartBarLineSeries;
	}
	
	
	
	
	public static ChartBarLineSeries getJFZCLevel2ChartBarLineSeries(List<H1AMKYSY100104> list, String name) {

		ChartBarLineSeries chartBarLineSeries = new ChartBarLineSeries();
		if (name.equals("K0BNYSJHJE")) {
			chartBarLineSeries.setName("经费下达");
			chartBarLineSeries.setStack("总量");
			chartBarLineSeries.setAreaStyle(new Object());
			chartBarLineSeries.setColor("#4a94eb");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_LINE);
			chartBarLineSeries.setSmooth(true);
		}
		if (name.equals("K0BNGLFPHJECB")) {
			chartBarLineSeries.setName("实际经费");
			chartBarLineSeries.setStack("总量");
			chartBarLineSeries.setColor("#43bb7c");
			chartBarLineSeries.setAreaStyle(new Object());
			chartBarLineSeries.setSmooth(true);
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_LINE);
		}
		

		List<Object> dataList = new ArrayList<Object>();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				H1AMKYSY100104 f03 = list.get(i);
				String K0BNYSJHJE = f03.getK0BNYSJHJE();
				String K0BNGLFPHJECB = f03.getK0BNGLFPHJECB();


				if (name.equals("K0BNYSJHJE")) {
					dataList.add(Double.valueOf(K0BNYSJHJE).intValue());
				}
				if (name.equals("K0BNGLFPHJECB")) {
					dataList.add(Double.valueOf(K0BNGLFPHJECB).intValue());
				}
				

			}
			chartBarLineSeries.setData(dataList);
		}
		return chartBarLineSeries;
	}
	

	public static ChartBarLineSeries getChartBarLineSeries_HOMPAGE_bar(List<H1AMKYSY100109> list, String name) {

		ChartBarLineSeries chartBarLineSeries = new ChartBarLineSeries();
		
		if (name.equals("K0BNXMWGSL")) {
			chartBarLineSeries.setName("完工项目");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		if (name.equals("K0BNXMYQSL")) {
			chartBarLineSeries.setName("延期项目");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		if (name.equals("K0BNXMWJSL")) {
			chartBarLineSeries.setName("应结题未结题");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}

		List<Object> dataList = new ArrayList<Object>();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				H1AMKYSY100109 f03 = list.get(i);
				
				String K0BNXMWGSL = f03.getK0BNXMWGSL();
				String K0BNXMYQSL = f03.getK0BNXMYQSL();
				String K0BNXMWJSL = f03.getK0BNXMWJSL();
				int K0BNXMWJSL_v = Double.valueOf(K0BNXMWJSL).intValue();

			
				
				if (name.equals("K0BNXMWGSL")) {
					dataList.add(Double.valueOf(K0BNXMWGSL).intValue());
				}
				if (name.equals("K0BNXMYQSL")) {
					dataList.add(Double.valueOf(K0BNXMYQSL).intValue());
				}
				if (name.equals("K0BNXMWJSL")) {
					dataList.add(K0BNXMWJSL_v);
				}

			}
			chartBarLineSeries.setData(dataList);
		}
		return chartBarLineSeries;
	}
	
	
	
	public static ChartBarLineSeries getChartBarLineSeries_budget_unit_mysql_bar(List<BudgetMysql> list, String name) {

		ChartBarLineSeries chartBarLineSeries = new ChartBarLineSeries();
		
		if (name.equals("zbje")) {
			chartBarLineSeries.setName("资本性");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		
		if (name.equals("fyje")) {
			chartBarLineSeries.setName("费用性");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		
		if (name.equals("zje")) {
			chartBarLineSeries.setName("总计");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}

		List<Object> dataList = new ArrayList<Object>();
		if (list != null && list.size() > 0) 
		{
			for (int i = 0; i < list.size(); i++) 
			{
				BudgetMysql f03 = list.get(i);
				
				
				
				String zbje =((BigDecimal)f03.getZbje()).toString();
				String fyje =((BigDecimal)f03.getFyje()).toString();
				String zje =((BigDecimal)f03.getZje()).toString();
				if (name.equals("zbje")) {
					
					dataList.add(String.format("%.2f", Double.valueOf(zbje)));
				}
				if (name.equals("fyje")) {
					
					
					dataList.add(String.format("%.2f", Double.valueOf(fyje)));
				}
               if (name.equals("zje")) {
					
					dataList.add(String.format("%.2f", Double.valueOf(zje)));
				}
				
				
			chartBarLineSeries.setData(dataList);
		}
		}
		
		
		
		
		return chartBarLineSeries;
	}
	
	
	public static ChartBarLineSeries getChartBarLineSeries_budget_unit_mysql_bar_03(List<BudgetMysql> list, String name) {

		ChartBarLineSeries chartBarLineSeries = new ChartBarLineSeries();
		
		
		
		if (name.equals("zje")) {
			chartBarLineSeries.setName("总计");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		if (name.equals("zbxje")) {
			chartBarLineSeries.setName("资本性");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		
		if (name.equals("fyxje")) {
			chartBarLineSeries.setName("费用性");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		
		
		List<Object> dataList = new ArrayList<Object>();
		if (list != null && list.size() > 0) 
		{
			for (int i = 0; i < list.size(); i++) 
			{
				BudgetMysql f03 = list.get(i);
				
			
				
				String fyxje =((BigDecimal)f03.getFyxje()).toString();
				String zbxje =((BigDecimal)f03.getZbxje()).toString();
				
				String zje =((BigDecimal)f03.getZje()).toString();
				
				
				
				
				if (name.equals("fyxje")) {
					
					dataList.add(String.format("%.2f", Double.valueOf(fyxje)));
					
				}
				if (name.equals("zbxje")) {
					
					dataList.add(String.format("%.2f", Double.valueOf(zbxje)));
					
				}
				
                if (name.equals("zje")) 
                {
                	
					dataList.add(String.format("%.2f", Double.valueOf(zje)));
					
				}
				
				
			chartBarLineSeries.setData(dataList);
		}
		}
		
		
		return chartBarLineSeries;
	}
	
	
	
	public static ChartBarLineSeries getChartBarLineSeries_budget_unit_mysql_bar_02(List<BudgetMysql> list, String name) {

		ChartBarLineSeries chartBarLineSeries = new ChartBarLineSeries();
		
		
		
		if (name.equals("zje")) {
			chartBarLineSeries.setName("总计");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		if (name.equals("zbxje")) {
			chartBarLineSeries.setName("资本性");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		
		if (name.equals("fyxje")) {
			chartBarLineSeries.setName("费用性");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		
		
		List<Object> dataList = new ArrayList<Object>();
		if (list != null && list.size() > 0) 
		{
			for (int i = 0; i < list.size(); i++) 
			{
				BudgetMysql f03 = list.get(i);
				
			
				
				String fyxje =((BigDecimal)f03.getFyxje()).toString();
				String zbxje =((BigDecimal)f03.getZbxje()).toString();
				
				
				
				
				
				if (name.equals("fyxje")) {
					
					dataList.add(String.format("%.2f", Double.valueOf(fyxje)));
					
				}
				if (name.equals("zbxje")) {
					
					dataList.add(String.format("%.2f", Double.valueOf(zbxje)));
					
				}
				
				
				
			chartBarLineSeries.setData(dataList);
		}
		}
		
		
		return chartBarLineSeries;
	}
	
	
	

	public static ChartBarLineSeries getChartBarLineSeries_PAY02_bar(List<H1AMKYSY100109> list, String name) {

		ChartBarLineSeries chartBarLineSeries = new ChartBarLineSeries();
		
		if (name.equals("K0BNZBJE")) {
			chartBarLineSeries.setName("资本性");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		
		if (name.equals("K0BNFYJE")) {
			chartBarLineSeries.setName("费用性");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		
		if (name.equals("K0BNYSJHJE")) {
			chartBarLineSeries.setName("总计");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}

		List<Object> dataList = new ArrayList<Object>();
		if (list != null && list.size() > 0) 
		{
			for (int i = 0; i < list.size(); i++) 
			{
				H1AMKYSY100109 f03 = list.get(i);
				
				String K0BNZBJE = f03.getK0BNZBJE();
				String K0BNFYJE = f03.getK0BNFYJE();
				String K0BNYSJHJE = f03.getK0BNYSJHJE();
				
				//System.out.println(">>>>>>>>>>>>>>>K0BNYSJHJE= " + K0BNYSJHJE+" K0BNZBJE="+K0BNZBJE+" K0BNFYJE="+K0BNFYJE);
				if (name.equals("K0BNZBJE")) {
					
					if (K0BNZBJE!=null) 
					{
						dataList.add(String.format("%.2f", Double.valueOf(K0BNZBJE)));
					}else
					{
						dataList.add("0.00");
					}
					
				}
				if (name.equals("K0BNFYJE")) {
					
					
					if (K0BNFYJE!=null) 
					{
						dataList.add(String.format("%.2f", Double.valueOf(K0BNFYJE)));
					}else
					{
						dataList.add("0.00");
					}
					
					
					
				}
               if (name.equals("K0BNYSJHJE")) {
					
					
            	   if (K0BNYSJHJE!=null) 
					{
            		   dataList.add(String.format("%.2f", Double.valueOf(K0BNYSJHJE)));
					}else
					{
						dataList.add("0.00");
					}
					
					
					
				}
				
				
			chartBarLineSeries.setData(dataList);
		}
		}
		
		
		
		
		return chartBarLineSeries;
	}
	
	
	
	public static ChartBarLineSeries getChartBarLineSeries_budget_unit_bar(List<H1AMKYSY100109> list, String name) {

		ChartBarLineSeries chartBarLineSeries = new ChartBarLineSeries();
		
		if (name.equals("K0BNZBJE")) {
			chartBarLineSeries.setName("资本性");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		
		if (name.equals("K0BNFYJE")) {
			chartBarLineSeries.setName("费用性");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		
		if (name.equals("K0BNYSJHJE")) {
			chartBarLineSeries.setName("总计");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}

		List<Object> dataList = new ArrayList<Object>();
		if (list != null && list.size() > 0) 
		{
			for (int i = 0; i < list.size(); i++) 
			{
				H1AMKYSY100109 f03 = list.get(i);
				
				String K0BNZBJE = f03.getK0BNZBJE();
				String K0BNFYJE = f03.getK0BNFYJE();
				String K0BNYSJHJE = f03.getK0BNYSJHJE();
				
				
				if (name.equals("K0BNZBJE")) {
					
					
					
					
					dataList.add(String.format("%.2f", Double.valueOf(K0BNZBJE)));
					
					
				}
				if (name.equals("K0BNFYJE")) {
					
					
					dataList.add(String.format("%.2f", Double.valueOf(K0BNFYJE)));
					
					
				}
               if (name.equals("K0BNYSJHJE")) {
					
					
					
					dataList.add(String.format("%.2f", Double.valueOf(K0BNYSJHJE)));
					
					
				}
				
				
			chartBarLineSeries.setData(dataList);
		}
		}
		
		
		
		
		return chartBarLineSeries;
	}
	
	
	public static ChartBarLineSeries getChartBarLineSeries_knowledet_bar_year(List<Knowledge> list, String name,List<String> yearList) {

		ChartBarLineSeries chartBarLineSeries = new ChartBarLineSeries();
		if (name.equals("sl1")) 
		{
			chartBarLineSeries.setName(yearList.get(0));
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		if (name.equals("sl2")) 
		{
			chartBarLineSeries.setName(yearList.get(1));
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		if (name.equals("sl3")) 
		{
			chartBarLineSeries.setName(yearList.get(2));
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		List<Object> dataList = new ArrayList<Object>();
		if (list != null && list.size() > 0) 
		{
			for (int i = 0; i < list.size(); i++) 
			{
				Knowledge knowledge = list.get(i);
				Integer f01 = knowledge.getSl1();
				Integer f02 = knowledge.getSl2();
				Integer f03 = knowledge.getSl3();
				if (name.equals("sl1")) 
				{
					dataList.add(f01);
				}
				if (name.equals("sl1")) 
				{
					dataList.add(f02);
				}
				if (name.equals("sl3")) 
				{
					dataList.add(f03);
				}
			    chartBarLineSeries.setData(dataList);
		     }
		}
		return chartBarLineSeries;
	}
	
	
	
	public static ChartBarLineSeries getChartBarLineSeries_budget_count_bar_mysql(List<BudgetMysql> list, String name) {

		ChartBarLineSeries chartBarLineSeries = new ChartBarLineSeries();
		if (name.equals("xkje")) {
			chartBarLineSeries.setName("新开课题");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		if (name.equals("xjje")) {
			chartBarLineSeries.setName("结转课题");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		List<Object> dataList = new ArrayList<Object>();
		if (list != null && list.size() > 0) 
		{
			for (int i = 0; i < list.size(); i++) 
			{
				BudgetMysql f03 = list.get(i);
				String xkje = ((BigDecimal)f03.getXkje()).toString();
				String xjje = ((BigDecimal)f03.getXjje()).toString();
				if (name.equals("xkje")) 
				{
					dataList.add(String.format("%.2f", Double.valueOf(xkje)));
				}
				if (name.equals("xjje")) 
				{
					dataList.add(String.format("%.2f", Double.valueOf(xjje)));
				}
			    chartBarLineSeries.setData(dataList);
		     }
		}
		
		
		
		
		return chartBarLineSeries;
	}
	
	
	
	public static ChartBarLineSeries getChartBarLineSeries_budget_count_bar(List<H1AMKYSY100109> list, String name) {

		ChartBarLineSeries chartBarLineSeries = new ChartBarLineSeries();
		
		if (name.equals("K0BNYSJHJE")) {
			chartBarLineSeries.setName("总计");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		
		if (name.equals("K0BNXKJE")) {
			chartBarLineSeries.setName("新开课题");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		if (name.equals("K0BNXJJE")) {
			chartBarLineSeries.setName("结转课题");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		

		List<Object> dataList = new ArrayList<Object>();
		if (list != null && list.size() > 0) 
		{
			for (int i = 0; i < list.size(); i++) 
			{
				H1AMKYSY100109 f03 = list.get(i);
				
				String K0BNYSJHJE = f03.getK0BNYSJHJE();
				String K0BNXKJE = f03.getK0BNXKJE();
				String K0BNXJJE = f03.getK0BNXJJE();
				
				
				if (name.equals("K0BNYSJHJE")) {
					
					
					if(K0BNYSJHJE!=null)
					{
						dataList.add(String.format("%.2f", Double.valueOf(K0BNYSJHJE)));
					}else
					{
						dataList.add("0.00");
					}
				}
				if (name.equals("K0BNXKJE")) {
					
					
					
					if(K0BNXKJE!=null)
					{
						dataList.add(String.format("%.2f", Double.valueOf(K0BNXKJE)));
					}else
					{
						dataList.add("0.00");
					}
					
					
				}
				if (name.equals("K0BNXJJE")) {
					
					
					if(K0BNXJJE!=null)
					{
						dataList.add(String.format("%.2f", Double.valueOf(K0BNXJJE)));
					}else
					{
						dataList.add("0.00");
					}
					
					
					
					
					
					
					
				
					
					
				}
				
			chartBarLineSeries.setData(dataList);
		}
		}
		
		
		
		
		return chartBarLineSeries;
	}
	
	
	
	public static ChartBarLineSeries getChartBarLineSeries_ProjectForMysql_bar(List<ProjectForMysql> list,List<String> xAxisDataList , String name) 
	{
		
		ChartBarLineSeries chartBarLineSeries = new ChartBarLineSeries();
		if (list != null && list.size() > 0) 
		{
			for (int i = 0; i < list.size(); i++) 
			{
				ProjectForMysql fpm= list.get(i);
			    String str	=fpm.getProject_scope();
			    if(str.equals(name))
			    {
			    	
			    }
				
			}
		}
		return null;
	}
	
	public static ChartBarLineSeries getChartBarLineSeries_Project_bar(List<H1AMKYSY100109> list, String name) {

		ChartBarLineSeries chartBarLineSeries = new ChartBarLineSeries();
		if (name.equals("K0BNXMXKSL")) {
			chartBarLineSeries.setName("新开课题");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		if (name.equals("K0BNXMXJSL")) {
			chartBarLineSeries.setName("结转课题");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		if (name.equals("K0BNXMWGSL")) {
			chartBarLineSeries.setName("完工项目");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		if (name.equals("K0BNXMYQSL")) {
			chartBarLineSeries.setName("延期项目");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		if (name.equals("K0BNXMWJSL")) {
			chartBarLineSeries.setName("应结未结");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}

		List<Object> dataList = new ArrayList<Object>();
		if (list != null && list.size() > 0) 
		{
			for (int i = 0; i < list.size(); i++) 
			{
				H1AMKYSY100109 f03 = list.get(i);
				
				String K0BNXMXKSL = f03.getK0BNXMXKSL();
				String K0BNXMXJSL = f03.getK0BNXMXJSL();
				String K0BNXMWGSL = f03.getK0BNXMWGSL();
				String K0BNXMYQSL = f03.getK0BNXMYQSL();
				String K0BNXMWJSL = f03.getK0BNXMWJSL();
				if (name.equals("K0BNXMXKSL")) {
					if(K0BNXMXKSL!=null)
					{
						dataList.add(Double.valueOf(K0BNXMXKSL).intValue());
					}else
					{
						dataList.add(0);
					}
					
				}
				if (name.equals("K0BNXMXJSL")) {
					if(K0BNXMXJSL!=null)
					{
						dataList.add(Double.valueOf(K0BNXMXJSL).intValue());
					}else
					{
						dataList.add(0);
					}
					
					
				}
				if (name.equals("K0BNXMWGSL")) {
					
					if(K0BNXMWGSL!=null)
					{
						dataList.add(Double.valueOf(K0BNXMWGSL).intValue());
					}else
					{
						dataList.add(0);
					}
					
					
				}
				if (name.equals("K0BNXMYQSL")) {
					
					if(K0BNXMYQSL!=null)
					{
						dataList.add(Double.valueOf(K0BNXMYQSL).intValue());
					}else
					{
						dataList.add(0);
					}
					
					
				}
				if (name.equals("K0BNXMWJSL")) {
					
					
					if(K0BNXMWJSL!=null)
					{
						
						dataList.add(Double.valueOf(K0BNXMWJSL).intValue());
						
					}else
					{
						dataList.add(0);
					}
					
				}

			}
			chartBarLineSeries.setData(dataList);
		}
		
		
		
		
		return chartBarLineSeries;
	}
	
	
	
	public static ChartBarLineSeries getChartBarLineSeries_JFZC_bar(List<H1AMKYSY100104> list, String name) {

		ChartBarLineSeries chartBarLineSeries = new ChartBarLineSeries();
		
		if (name.equals("K0BNYSJHJE")) {
			chartBarLineSeries.setName("经费下达 ");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		if (name.equals("K0BNGLFPHJECB")) {
			chartBarLineSeries.setName("实际经费");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}

		List<Object> dataList = new ArrayList<Object>();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				H1AMKYSY100104 f03 = list.get(i);
				
				String K0BNYSJHJE = f03.getK0BNYSJHJE();
				String K0BNGLFPHJECB = f03.getK0BNGLFPHJECB();

			
				
				if (name.equals("K0BNYSJHJE")) {
					dataList.add(Double.valueOf(K0BNYSJHJE).intValue());
				}
				if (name.equals("K0BNGLFPHJECB")) {
					dataList.add(Double.valueOf(K0BNGLFPHJECB).intValue());
				}

			}
			chartBarLineSeries.setData(dataList);
		}
		return chartBarLineSeries;
	}
	

	public static ChartBarLineSeries getChartBarLineSeries_BrandConstructionPay(List<BrandConstructionPay> list,
			String name) {
		ChartBarLineSeries chartBarLineSeries = new ChartBarLineSeries();
		if (name.equals("K0BNJE")) {
			chartBarLineSeries.setName("本期");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		if (name.equals("K0SNJE")) {
			chartBarLineSeries.setName("同期");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		if (name.equals("K0TQBL")) {
			chartBarLineSeries.setName("同比");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_LINE);
		}

		List<Object> dataList = new ArrayList<Object>();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				BrandConstructionPay f03 = list.get(i);

				String k0BNJE = f03.getK0BNJE();// 本期
				String k0SNJE = f03.getK0SNJE();// 同期
				String K0TQBL = f03.getK0TQBL();// 同比
				
				k0BNJE=String.format("%.2f", Double.valueOf(k0BNJE));
				k0SNJE=String.format("%.2f", Double.valueOf(k0SNJE));
				K0TQBL=String.format("%.2f", Double.valueOf(K0TQBL));

				if (name.equals("K0BNJE")) {
					dataList.add(k0BNJE);
				}
				if (name.equals("K0SNJE")) {
					dataList.add(k0SNJE);
				}
				if (name.equals("K0TQBL")) {
					dataList.add(K0TQBL);
				}

			}
			chartBarLineSeries.setData(dataList);
		}
		return chartBarLineSeries;
	}

	public static ChartBarLineSeries getChartBarLineSeries_InvisibleCapitalDevelop(List<InvisibleCapitalDevelop> list,
			String name) {
		ChartBarLineSeries chartBarLineSeries = new ChartBarLineSeries();
		if (name.equals("K0BNZCJE")) {
			chartBarLineSeries.setName("本期");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
			chartBarLineSeries.setyAxisIndex(0);
		}
		if (name.equals("K0SNZCJE")) {
			chartBarLineSeries.setName("同期");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
			chartBarLineSeries.setyAxisIndex(0);
		}
		if (name.equals("K0TQBL")) {
			chartBarLineSeries.setName("同比");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_LINE);
			chartBarLineSeries.setyAxisIndex(1);
		}

		List<Object> dataList = new ArrayList<Object>();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				InvisibleCapitalDevelop f03 = list.get(i);

				String k0BNZCJE = f03.getK0BNZCJE();// 本期
				String k0SNZCJE = f03.getK0SNZCJE();// 同期
				String K0TQBL = f03.getK0TQBL();// 同比
				
				
				k0BNZCJE=String.format("%.2f", Double.valueOf(k0BNZCJE));
				k0SNZCJE=String.format("%.2f", Double.valueOf(k0SNZCJE));
				K0TQBL=String.format("%.2f", Double.valueOf(K0TQBL));

				if (name.equals("K0BNZCJE")) {
					dataList.add(k0BNZCJE);
				}
				if (name.equals("K0SNZCJE")) {
					dataList.add(k0SNZCJE);
				}
				if (name.equals("K0TQBL")) {
					dataList.add(K0TQBL);
				}

			}
			chartBarLineSeries.setData(dataList);
		}
		return chartBarLineSeries;
	}

	public static ChartBarLineSeries getChartBarLineSeries(List<FundsComprehensiveAnalysis03> list, String name) {
		ChartBarLineSeries chartBarLineSeries = new ChartBarLineSeries();
		if (name.equals("K0BNYSJE")) {
			chartBarLineSeries.setName("计划");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		if (name.equals("K0BNSJJE")) {
			chartBarLineSeries.setName("实际");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		if (name.equals("K0BNZCBL")) {
			chartBarLineSeries.setName("本期使用率");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_LINE);
		}
		if (name.equals("K0TQZCBL")) {
			chartBarLineSeries.setName("同期使用率");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_LINE);
		}
		List<Object> dataList = new ArrayList<Object>();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				FundsComprehensiveAnalysis03 f03 = list.get(i);
				String xAxisData = f03.getG0GSJC();
				String plan = f03.getK0BNYSJE();// 计划
				String fact = f03.getK0BNSJJE();// 实际
				String thisDate = f03.getK0BNZCBL();// 本期
				String sameDate = f03.getK0TQZCBL();// 同期
				
				
				plan=String.format("%.2f", Double.valueOf(plan));
				fact=String.format("%.2f", Double.valueOf(fact));
				thisDate=String.format("%.2f", Double.valueOf(thisDate));
				sameDate=String.format("%.2f", Double.valueOf(sameDate));
				if (name.equals("K0BNYSJE")) {
					dataList.add(plan);
				}
				if (name.equals("K0BNSJJE")) {
					dataList.add(fact);
				}
				if (name.equals("K0BNZCBL")) {
					dataList.add(thisDate);
				}
				if (name.equals("K0TQZCBL")) {
					dataList.add(sameDate);
				}

			}
			chartBarLineSeries.setData(dataList);
		}
		return chartBarLineSeries;
	}

	public static ChartBarLineSeries getChartBarLineSeries_TotalCostProjectPay02(List<TotalCostProjectPay02> list,
			String name) {
		ChartBarLineSeries chartBarLineSeries = new ChartBarLineSeries();
		if (name.equals("K0BNGLFPHJECB")) {
			chartBarLineSeries.setName("实际支出");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		if (name.equals("K0SNGLFPHJECB")) {
			chartBarLineSeries.setName("同期支出");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_BAR);
		}
		if (name.equals("K0TBBL")) {
			chartBarLineSeries.setName("同比");
			chartBarLineSeries.setType(HanaConstant.ECHARTS_TYPE_LINE);
		}
		List<Object> dataList = new ArrayList<Object>();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				TotalCostProjectPay02 f03 = list.get(i);
				String plan = f03.getK0BNGLFPHJECB();// 实际支出
				String fact = f03.getK0SNGLFPHJECB();// 同期支出
				String thisDate = f03.getK0TBBL();// 同比
				
				plan=String.format("%.2f", Double.valueOf(plan));
				fact=String.format("%.2f", Double.valueOf(fact));
				thisDate=String.format("%.2f", Double.valueOf(thisDate));
				
				if (name.equals("K0BNGLFPHJECB")) {
					dataList.add(plan);
				}
				if (name.equals("K0SNGLFPHJECB")) {
					dataList.add(fact);
				}
				if (name.equals("K0TBBL")) {
					dataList.add(thisDate);
				}

			}
			chartBarLineSeries.setData(dataList);
		}
		return chartBarLineSeries;
	}

	public static List<CompanyCode> getCompanyCode(RestTemplate restTemplate, HttpHeaders httpHeaders)
			throws Exception {

		List<CompanyCode> list = null;
		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);

		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_COMPANY_DIC_LIST, HttpMethod.GET, entity,
				JSONArray.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			JSONArray array = responseEntity.getBody();
			list = JSONObject.parseArray(array.toJSONString(), CompanyCode.class);
		}
		return list;
	}
	
	
	
	public static List<ProjectCode> getBaseCode(RestTemplate restTemplate, HttpHeaders httpHeaders,String month,String type)
			throws Exception {

		List<ProjectCode> list = null;
		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("month", month);
		paramsMap.put("type", type);
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		
		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_BASE_DIC_LIST, HttpMethod.POST, entity, JSONArray.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			
			JSONArray jSONArray = responseEntity.getBody();
			 list = JSONObject.parseArray(jSONArray.toJSONString(), ProjectCode.class);
			
		}
		return list;
	}
	
	public static List<H1AMKYZH100006> getBaseCodeDic(RestTemplate restTemplate, HttpHeaders httpHeaders,String month)
			throws Exception {

		List<H1AMKYZH100006> list = null;
		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("month", month);
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		HttpEntity<String> entity = new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		ResponseEntity<JSONArray> responseEntity = restTemplate.exchange(GET_BASE_DIC_LIST_ALL, HttpMethod.POST, entity, JSONArray.class);
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			JSONArray jSONArray = responseEntity.getBody();
			list = JSONObject.parseArray(jSONArray.toJSONString(), H1AMKYZH100006.class);
		}
		return list;
	}
	
	
	
	

	public static List<ProjectCode> getProjectCode(RestTemplate restTemplate, HttpHeaders httpHeaders)
			throws Exception {

		/*
		 * List<ProjectCode> list = null;
		 * httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8); Map<String,
		 * Object> paramsMap = new HashMap<String, Object>(); JSONObject jsonObject =
		 * JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		 * HttpEntity<String> entity = new
		 * HttpEntity<String>(jsonObject.toString(),httpHeaders);
		 * ResponseEntity<JSONArray> responseEntity =
		 * restTemplate.exchange(GET_PROJECT_DIC_LIST, HttpMethod.GET, entity,
		 * JSONArray.class); int statusCode=responseEntity.getStatusCodeValue();
		 * if(statusCode==200) { JSONArray array=responseEntity.getBody(); list =
		 * JSONObject.parseArray(array.toJSONString(), ProjectCode.class); }
		 */

		List<ProjectCode> resut = new ArrayList();
		ProjectCode p2 = new ProjectCode();
		p2.setG0XMGLLX("国家项目");
		ProjectCode p3 = new ProjectCode();
		p3.setG0XMGLLX("重大项目");
		ProjectCode p4 = new ProjectCode();
		p4.setG0XMGLLX("十条龙项目");
		ProjectCode p5 = new ProjectCode();
		p5.setG0XMGLLX("其他项目");
		resut.add(p2);
		resut.add(p3);
		resut.add(p4);
		resut.add(p5);
		return resut;
	}

	public static String getCurrrentYearMoth() throws Exception {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;

		String monthstr = String.format("%02d", month);

		String str = "" + (year) + "" + monthstr;

		System.out.println(">>>>>str=" + str);
		return str;
	}
	
	
	
	public static String getCurrrentYear() throws Exception {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);

		System.out.println(">>>>>year=" + year);
		return String.valueOf(year);
	}

	public static String getCurrrent_YearMoth() throws Exception {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;

		String monthstr = String.format("%02d", month);

		String str = "" + (year) + "年" + monthstr + "月";

		System.out.println(">>>>>str=" + str);
		return str;
	}

	// 月所有的天数
	public static List<String> getDayListOfMonth(String datestr) {

		Date date = DateUtil.strToDate(datestr, "yyyyMM");
		List<String> list = new ArrayList<>();
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.setTime(date);
		int year = aCalendar.get(Calendar.YEAR);// 年份
		int month = aCalendar.get(Calendar.MONTH);// 月份
		int day = aCalendar.getActualMaximum(Calendar.DATE);
		for (int i = 1; i <= day; i++) {

			String monthstr = String.format("%02d", month);
			String tt = String.format("%02d", i);
			String aDate = String.valueOf(year) + "" + monthstr + "" + tt;
			list.add(aDate);
		}
		return list;
	}

	/*public static void setSearchPara(RestTemplate restTemplate, HttpHeaders httpHeaders, HttpServletRequest request)
			throws Exception {

		List<CompanyCode> companyCodeList = HanaUtil.getCompanyCode(restTemplate, httpHeaders);
		request.setAttribute("companyCodeList", companyCodeList);
		String allCode = "";
		for (int i = 0; i < companyCodeList.size(); i++) {
			CompanyCode companyCode = companyCodeList.get(i);
			String strNotes = companyCode.getG0DMJC();
			if (strNotes.equals("ALL")) {
				allCode = companyCode.getG0GSDM();
			}
		}
		request.setAttribute("allCode", allCode);
		String month = HanaUtil.getCurrrentYearMoth();
		request.setAttribute("month", month);
	}*/
	
	
	
	
	
	public static void setSearchParaForUser( SysUser userInfo,RestTemplate restTemplate, HttpHeaders httpHeaders, HttpServletRequest request)
			throws Exception {
		
	    
		
		List<CompanyCode> companyCodeList =new ArrayList<CompanyCode>();
	    List<String> listCodes= userInfo.getInstituteCodes();
	    List<String> listNames= userInfo.getInstituteNames();
	    StringBuffer sb=new StringBuffer();
	    if(listCodes==null || listCodes.size()==0)
	    {
	    	companyCodeList=getCompanyCodeDefault();
	    	request.setAttribute("companyCodeList", companyCodeList);
	 		request.setAttribute("allCode", HanaUtil.YJY_CODE_ALL);
	 		request.setAttribute("companyCode", HanaUtil.YJY_CODE_ALL);
	 		
	    }else
	    {
	    	 for(int i=0;i<listCodes.size();i++)
	 	    {
	 	    	String code=listCodes.get(i);
	 	    	if(i>0)
	 	    	{
	 	    		sb.append(",");
	 	    	}
	 	    	sb.append(code);
	 	    }
	 	    
	 	    CompanyCode company_code=new CompanyCode();
	 	    company_code.setG0GSDM(sb.toString());
	 	    company_code.setG0GSJC("全部");
	 	    company_code.setG0DMJC("ALL");
	 	    companyCodeList.add(company_code);
	 	    for(int i=0;i<listCodes.size();i++)
	 	    {
	 	    	CompanyCode cc=new CompanyCode();
	 	    	String code=listCodes.get(i);
	 	    	String name=listNames.get(i);
	 	    	cc.setG0GSJC(name);
	 	    	cc.setG0GSDM(code);
	 	    	//System.out.println(">>>>>>>>>>>name="+name+" code="+code);
	 	    	companyCodeList.add(cc);
	 	    }
	 		request.setAttribute("companyCodeList", companyCodeList);
	 		request.setAttribute("allCode", sb.toString());
	 		request.setAttribute("companyCode", sb.toString());
	    }
		
		String month = HanaUtil.getCurrrentYearMoth();
		request.setAttribute("month", month);
	}
	private static List<CompanyCode> getCompanyCodeDefault()
	{
		
		
		List<CompanyCode> companyCodeList =new ArrayList<CompanyCode>();
		
		
		CompanyCode company_code_0=new CompanyCode();
		company_code_0.setG0GSDM(HanaUtil.YJY_CODE_ALL);
		company_code_0.setG0GSJC("全部");
		company_code_0.setG0DMJC("ALL");
		companyCodeList.add(company_code_0);
		    
		    
	    CompanyCode company_code=new CompanyCode();
	    company_code.setG0GSDM("1120,1123,1124,1127");
	    company_code.setG0GSJC("勘探院");
	    companyCodeList.add(company_code);
	    
	    CompanyCode company_code_02=new CompanyCode();
	    company_code_02.setG0GSDM("1130");
	    company_code_02.setG0GSJC("物探院");
	    companyCodeList.add(company_code_02);
	    CompanyCode company_code_03=new CompanyCode();
	    company_code_03.setG0GSDM("4360");
	    company_code_03.setG0GSJC("工程院");
	    companyCodeList.add(company_code_03);
	    CompanyCode company_code_04=new CompanyCode();
	    company_code_04.setG0GSDM("1020");
	    company_code_04.setG0GSJC("石科院");
	    companyCodeList.add(company_code_04);
	    CompanyCode company_code_05=new CompanyCode();
	    company_code_05.setG0GSDM("1060,1061");
	    company_code_05.setG0GSJC("大连院");
	    companyCodeList.add(company_code_05);
	    
	    CompanyCode company_code_06=new CompanyCode();
	    company_code_06.setG0GSDM("1040,1041");
	    company_code_06.setG0GSJC("北化院");
	    companyCodeList.add(company_code_06);
	    CompanyCode company_code_07=new CompanyCode();
	    company_code_07.setG0GSDM("1080");
	    company_code_07.setG0GSJC("上海院");
	    companyCodeList.add(company_code_07);
	    CompanyCode company_code_08=new CompanyCode();
	    company_code_08.setG0GSDM("1100,1101");
	    company_code_08.setG0GSJC("安工院");
	    companyCodeList.add(company_code_08);
	    
	    return companyCodeList;
	    
	}

	public static List<String> getMonthListOfYear(String datestr) {

		Date date = DateUtil.strToDate(datestr, "yyyyMM");
		List<String> list = new ArrayList<>();
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.setTime(date);
		int year = aCalendar.get(Calendar.YEAR);// 年份
		for (int i = 1; i <= 12; i++) {

			String monthstr = String.format("%02d", i);
			String aDate = String.valueOf(year) + "" + monthstr;
			list.add(aDate);
		}
		return list;
	}
	
	
	
	
	public static void setHomePageList(HttpServletRequest request)
	{
	
			List<String>  define1List=new ArrayList<String>();
			define1List.add("资本性");
			define1List.add("费用性");
			
			request.setAttribute("define1List", define1List);
			
			
			List<String>  project_propertyList=new ArrayList<String>();
			project_propertyList.add("国家项目");
			project_propertyList.add("重大专项");
			project_propertyList.add("重点项目");
			project_propertyList.add("其他项目");
			
			request.setAttribute("project_propertyList", project_propertyList);
			
			
			List<String>  type_flagList=new ArrayList<String>();
			type_flagList.add("直属研究院");
			type_flagList.add("分子公司");
			type_flagList.add("集团单位");
			
			request.setAttribute("type_flagList", type_flagList);
			
			List<String>  define2List=new ArrayList<String>();
			define2List.add("物探院");
			define2List.add("勘探院");
			define2List.add("上海院");
			request.setAttribute("define2List", define2List);
			
			List<String>  project_scopeList=new ArrayList<String>();
			project_scopeList.add("新开课题");
			project_scopeList.add("结转课题");
			project_scopeList.add("完工项目");
			
			request.setAttribute("project_scopeList", project_scopeList);
	
	}
	public static void main(String[] args) {
		String str="232.2000";
		String vv=String.format("%.2f", Double.valueOf(str));
		System.out.println(vv);
	}

}
