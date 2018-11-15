//package com.pcitc.service.impl;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.pcitc.base.hana.report.ReportViewVo;
//import com.pcitc.base.util.MyBeanUtils;
//import com.pcitc.mapper.DecisionMapper;
//import com.pcitc.service.IDecisionService;
//import org.apache.poi.ss.formula.functions.T;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.math.BigDecimal;
//import java.text.DecimalFormat;
//import java.util.*;
//
//import static com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty;
//
//@Service("decisionService2")
//@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
//public class DecisionServiceReportImpl implements IDecisionService {
//
//    @Autowired
//    private DecisionMapper decisionMapper;
//
//    public List getList(String str) throws Exception {
//        System.out.println("----参数数---" + str);
//        List list = decisionMapper.getList("aa");
//        System.out.println("----getList service 查询个数---" + list.size());
//        return list;
//    }
//
//    /**
//     * 报表查询
//     * @param map
//     * @return
//     * @throws Exception
//     */
//    @Override
//    public List getReportList(Map<String, Object> map) {
//        return decisionMapper.getReportList(map);
//    }
//
//    /**
//     * 转义
//     * @param o
//     * @param t
//     * @param <T>
//     * @return
//     */
//    public static <T> T get(Object o,T t){
//        Class<T> clazz=(Class<T>) t.getClass();
//        if(clazz!=null){
//            if(clazz.isInstance(o))
//                return clazz.cast(o);
//            else
//                throw new RuntimeException(o +" is not a "+clazz.getName());
//        }
//        return null;
//    }
//
//    /**
//     * 取值
//     * @param clazz
//     * @param object
//     * @param strName
//     * @return
//     */
//    public String getMethodVal(Class<T> clazz, Object object, String strName){
//        String strval = "";
//        try {
//            Method method = clazz.getMethod(strName);
//            strval = (String) method.invoke((object));
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//        return strval;
//    }
//
//    /**
//     * 赋值
//     * @param clazz
//     * @param object
//     * @param strName
//     * @param strVal
//     */
//    public void setMethodVal(Class clazz,Object object,String strName, String strVal){
//        try {
//            Method method = clazz.getMethod(strName,String.class);
//            method.invoke(object,new Object[]{strVal});
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 求和
//     * @param str1
//     * @param str2
//     * @return
//     */
//    public String calVal(String str1,String str2){
//        String str = "";
//        if(str1==null||"".equals(str1)){
//            str1="0";
//        }
//        if(str2==null||"".equals(str2)){
//            str2="0";
//        }
//        return new DecimalFormat("0.00").format(new BigDecimal(str1).add(new BigDecimal(str2)).doubleValue());
//    }
//    /**
//     * 报表树查询
//     * @param paramsJson
//     * @return
//     * @throws Exception
//     */
//    @Override
//    public JSONArray getReportTree(String paramsJson) throws InvocationTargetException, IllegalAccessException {
//        Map<String, Object> mapParam = JSONObject.parseObject(paramsJson);
//
//        long start_getReportList = System.currentTimeMillis();
//        List<Map<String, Object>> list = this.getReportList(mapParam);
//        long end_getReportList = System.currentTimeMillis();
//        System.out.println("调用hana用时(getReportList): " + (end_getReportList-start_getReportList));
//        JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));
//
////        List<ReportViewVo> viewVos = new ArrayList<>();
////        for (int i = 0,j=list.size(); i < j; i++) {
////            ReportViewVo reportViewVo = new ReportViewVo();
////            MyBeanUtils.transMap2Bean(list.get(i),reportViewVo);
////            viewVos.add(reportViewVo);
////        }
//        long start = System.currentTimeMillis();
//        List<ReportViewVo> viewVos = JSONObject.parseArray(json.toJSONString(), ReportViewVo.class);
//        //分项汇总
//        String strPid = mapParam.get("xfield").toString().toUpperCase();
//        String columnko = mapParam.get("columnko").toString().toUpperCase();
//        String columngo = mapParam.get("column").toString().toUpperCase();
//        String[] arraycolumnko = columnko.split(",");
//
//        //start-1
////        Object objXfieldValue = "";
////        Class clazz = ReportViewVo.class;
////        Map<String, String> mapx = new HashMap<>();
////        Map<String, String> mapy = new HashMap<>();
////        int len = reportViewVoListt.size();
////        for (int i = 0; i < len; i++) {
////            ReportViewVo vo = reportViewVoListt.get(i);
////            //获取X轴值
////            objXfieldValue = getMethodVal(clazz,vo,"get" + strPid);
////            objXfieldValue = (objXfieldValue == null) ? "" : objXfieldValue;
////            //设置ID,PID
////            vo.setPid(strPid + objXfieldValue);
////            vo.setId(objXfieldValue.toString());
////            mapx.put(objXfieldValue.toString(), objXfieldValue.toString());
////            //赋值
////            for (int j = 0; j < arraycolumnko.length; j++) {
////                String strKey = arraycolumnko[j];
////                mapy.put(objXfieldValue.toString()+"_"+strKey,calVal(mapy.get(objXfieldValue.toString()+"_"+strKey),getMethodVal(clazz,vo,"get" + strKey)));
////            }
////        }
////        //添加父节点
////        Map<String,String> mapcount = new HashMap<>();
////        for (Map.Entry<String, String> entry : mapx.entrySet()) {
////            ReportViewVo reportViewVo = new ReportViewVo();
////            String strKey = entry.getKey();
////            reportViewVo.setId(strPid + strKey);
////            reportViewVo.setPid("0");
//////            setMethodVal(clazz,reportViewVo,"set" + strPid,"小计:");
////            setMethodVal(clazz,reportViewVo,"set" + strPid,"小计("+strKey+"):");
////            for (int j = 0; j < arraycolumnko.length; j++) {
////                String strKo = arraycolumnko[j];
////                mapcount.put(strKo,calVal(mapcount.get(strKo),mapy.get(strKey+"_"+strKo)));
////                setMethodVal(clazz,reportViewVo,"set"+strKo,mapy.get(strKey+"_"+strKo));
////            }
////            reportViewVoListt.add(reportViewVo);
////        }
////        //合计
////        ReportViewVo reportViewVo = new ReportViewVo();
////        reportViewVo.setPid("");
////        reportViewVo.setId("0");
////        setMethodVal(clazz,reportViewVo,"set" + strPid,"合计:");
////        for (int j = 0; j < arraycolumnko.length; j++) {
////            setMethodVal(clazz,reportViewVo,"set"+arraycolumnko[j],mapcount.get(arraycolumnko[j]));
////        }
//        //end-1
//
////        ReportViewVo reportViewVo0 = new ReportViewVo();
////        reportViewVoListt.add(reportViewVo0);
//        Class clazz = ReportViewVo.class;
//        List<ReportViewVo> vos = new ArrayList<>();
//        ReportViewVo voCount = new ReportViewVo();
//        String[] arrayField = columngo.split(",");
//
//        setGroupByCount(strPid,arrayField,"0",viewVos,arraycolumnko,vos,voCount,clazz);
//        vos.add(voCount);
//        Collections.reverse(vos);
//        json = JSONArray.parseArray(JSON.toJSONString(vos, WriteNullStringAsEmpty));
//
//
//        //start-1
////        reportViewVoListt.add(reportViewVo);
//        //转json
////        json = JSONArray.parseArray(JSON.toJSONString(reportViewVoListt, WriteNullStringAsEmpty));
//        //end-1
//        long end = System.currentTimeMillis();
//        System.out.println("getReportTree:执行时间: " + (end-start));
////        System.out.println("vosjson = " + json);
//        return json;
//    }
//
//    public void setGroupByCount(String xField,String[] arrayField,String strPid,List<ReportViewVo> list,String[] arraycolumnko,List<ReportViewVo> vos,ReportViewVo voCount,Class clazz){
//        int len=list.size();
//        Object objXfieldValue = "";
//        String objVal = "";
//        Map<String, String> mapx = new LinkedHashMap<>();
//        Map<String, String> mapy = new LinkedHashMap<>();
//        Map<String, Object> maplist = new LinkedHashMap<>();
//        Map<String, Object> mapfield = new LinkedHashMap<>();
//
//        int i_field_index = getArrayIndex(arrayField,xField);
//        //添加返回的list:小计,最后的节点
//        for (int i = 0; i < len; i++) {
//            ReportViewVo vo = list.get(i);
////            ReportViewVo vo = list.get(i);
//            //获取X轴值
//            objXfieldValue = getMethodVal(clazz,vo,"get" + xField);
//            objVal = (objXfieldValue == null) ? "-" : objXfieldValue.toString();
//            //设置ID,PID
////                vo.setPid(strPid);
//                vo.setPid(xField+objVal);
////            vo.setPid(strPid);
//            vo.setId(objVal);
//            mapx.put(objVal, objVal);
//
//            mapfield.put(objVal, xField);
//
//            //判断vo,替换list值
//            if(i_field_index==0){
//                vo.setIndex(i+"");
//                vos.add(vo);
//            }else {
//                vos.set(Integer.parseInt(vo.getIndex()),vo);
//            }
//            //判断是否为空,为空,添加;不为空,取值添加
//            if(i_field_index<(arrayField.length-1)){
//                if(maplist.get(objVal)==null){
//                    List<ReportViewVo> reportViewVoList = new ArrayList<>();
//                    reportViewVoList.add(vo);
//                    maplist.put(objVal,reportViewVoList);
//                }else {
//                    List<ReportViewVo> reportViewVoList = (List<ReportViewVo>) maplist.get(objVal);
//                    reportViewVoList.add(vo);
//                    maplist.put(objVal,reportViewVoList);
//                }
//            }
//            //分组计算小计
//            //TO DO 第一次调用,其他不调用
//            for (int j = 0; j < arraycolumnko.length; j++) {
//                String strKey = arraycolumnko[j];
//                mapy.put(objVal+"_"+strKey,calVal(mapy.get(objVal+"_"+strKey),getMethodVal(clazz,vo,"get" + strKey)));
//            }
//
//        }
//        //添加父节点
//        Map<String,String> mapcount = new HashMap<>();
//        for (Map.Entry<String, String> entry : mapx.entrySet()) {
//            ReportViewVo reportViewVo = new ReportViewVo();
//            String strKey = entry.getKey();
//            reportViewVo.setId(xField + strKey);
//            reportViewVo.setPid(strPid);
//            setMethodVal(clazz,reportViewVo,"set" + xField,"小计("+strKey+"):");
//            for (int j = 0; j < arraycolumnko.length; j++) {
//                String strKo = arraycolumnko[j];
//                mapcount.put(strKo,calVal(mapcount.get(strKo),mapy.get(strKey+"_"+strKo)));
//                setMethodVal(clazz,reportViewVo,"set"+strKo,mapy.get(strKey+"_"+strKo));
//            }
//            vos.add(reportViewVo);
////            if(i_field_index<(arrayField.length-2)){
////                setGroupByCount(arrayField[i_field_index+1],arrayField,xField+strKey, (List<ReportViewVo>) maplist.get(strKey),arraycolumnko,vos,voCount,clazz);
////            }
//        }
//        //合计
//        if(i_field_index==0){
//            voCount.setPid("");
//            voCount.setId("0");
//            setMethodVal(clazz,voCount,"set" + xField,"合计:");
//            for (int j = 0; j < arraycolumnko.length; j++) {
//                setMethodVal(clazz,voCount,"set"+arraycolumnko[j],mapcount.get(arraycolumnko[j]));
//            }
//        }
//    }
//
//    /**
//     * 获取数组元素所在下标
//     * @param array
//     * @param strField
//     * @return
//     */
//    public int getArrayIndex(String[] array, String strField){
//        int index =-1;
//        for (int i = 0; i < array.length; i++) {
//            if (array[i].equals(strField)){
//                index = i;
//                break;
//            }
//        }
//        return index;
//    }
//
//
//    public static void main(String[] args) {
//
////        String[] array = "G0GSDM,G0BKT,G0BEZEICH,".split(",");
////        System.out.println("array = " + array.length);
////        System.out.println(getArrayIndex(array,"G0BKT"));
////        String strKey ="中国_G023423";
////        System.out.println("strKey.substring(0,strKey.lastIndexOf(\"_\")); = " + strKey.substring(0, strKey.lastIndexOf("_")));
//
//        Class clazz = ReportViewVo.class;
//        ReportViewVo reportViewVo = new ReportViewVo();
//        reportViewVo.setG0BK("333");
//        String strPid = "G0BK";
//
//        try {
//            System.out.println("ReportViewVo.class = " + ReportViewVo.class);
//            Class t =Class.forName("com.pcitc.base.hana.report.ReportViewVo");
//            System.out.println("t.getClass() = " + t.getClass());
//            Object obj = MyBeanUtils.createBean(t);
//            System.out.println("obj = " + obj);
//
//            new DecisionServiceReportImpl().setMethodVal(t,obj,"set" + strPid,"小计:");
//            String str = new DecisionServiceReportImpl().getMethodVal(t,obj,"get" + strPid);
//            System.out.println("str = " + str);
//
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//
////        Method method = null;
////        try {
////            method = clazz.getMethod("get" + strPid);
////            Object strx = method.invoke(reportViewVo);
////            System.out.println("strx = " + strx);
////        } catch (NoSuchMethodException e) {
////            e.printStackTrace();
////        } catch (IllegalAccessException e) {
////            e.printStackTrace();
////        } catch (InvocationTargetException e) {
////            e.printStackTrace();
////        }
////
////        String str =new DecisionServiceImpl().getMethodVal(clazz,reportViewVo,"get" + strPid);
////        System.out.println("get = " + str);
////        reportViewVo.setG0BK("xxx");
////        long st = System.currentTimeMillis();
////        new DecisionServiceImpl().setMethodVal(clazz,reportViewVo,"set" + strPid,"小计:");
////        long ed = System.currentTimeMillis();
////        System.out.println((ed-st)+"reportViewVo = " + reportViewVo.getG0BK());
////
////        long st1 = System.currentTimeMillis();
////        MyBeanUtils.setPropertyVal(reportViewVo,"G0BK","你好");
////        long ed1 = System.currentTimeMillis();
////        System.out.println((ed1-st1)+"reportViewVo = " + reportViewVo.getG0BK());
//    }
//
//    /**
//     * 条件查询列表
//     *
//     * @return
//     */
//
//	/*public Page getUserLogPage(String paramsJson) throws Exception
//	{
//
//		System.out.println(">>>>>>>>>>>>>>>>paramsJson:" + paramsJson);
//		JSONObject jsonobject = JSONObject.fromObject(paramsJson);
//		//当前页数
//		int pageNum = Integer.parseInt(jsonobject.get("pageNum").toString());
//		//每页多少条
//		int pageSize = Integer.parseInt(jsonobject.get("pageSize").toString());
//		String moduleName=jsonobject.optString("moduleName");
//		String className=jsonobject.optString("className");
//		int startPage=(pageNum-1)*pageSize;
//
//		// 设置查询条件
//		UserLogExample example=new UserLogExample();
//		UserLogExample.Criteria criteria = example.createCriteria();
//		if(moduleName!=null && !moduleName.equals(""))
//		{
//			criteria.andModuleNameLike(moduleName);
//		}
//		if(className!=null && !className.equals(""))
//		{
//			criteria.andClassNameLike(className);
//		}
//		//设置分页信息，包括当前页数和每页显示的总计数
//	    PageHelper.startPage(startPage, pageSize);
//		//开始查询
//		List<UserLog> list = userLogMapper.selectByExample(example);
//		System.out.println("查询条数----" + list.size());
//		//查询分页结果
//		PageInfo<UserLog> pageInfo = new PageInfo<UserLog>(list);
//		//封装返回结果
//		System.out.println("封装总数----" + pageInfo.getTotal()+"封装条数----" + list.size());
//		Page page=new Page();
//		page.setRows(list);
//		page.setPageNo(pageSize);
//		page.setTotalRecords(pageInfo.getTotal());
//		return page;
//	}
//	*/
//
//
//}
