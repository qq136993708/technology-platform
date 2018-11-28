package com.pcitc.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.common.Page;
import com.pcitc.base.hana.report.ReportViewVo;
import com.pcitc.base.report.ReportColumn;
import com.pcitc.mapper.other.ReportMapper;
import com.pcitc.mysqlMapper.mysql.ReportMysqlMapper;
import com.pcitc.service.ReportService;
import io.swagger.models.auth.In;
import org.apache.commons.collections.MapUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.Collator;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

import static com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty;

@Service("reportService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportMapper reportMapper;

    @Autowired
    private ReportMysqlMapper reportMysqlMapper;

    /**
     * 报表查询
     *
     * @param map
     * @return
     * @throws Exception
     */
    @Override
    public List getReportList(Map<String, Object> map) {
//        if("164f98a6b8c_c4effcc1".equals(map.get("name"))){

        String strWhere = (map.get("where") == null ? "" : map.get("where").toString());
        String date = (map.get("date") == null ? "" : map.get("date").toString());
        date = date.replace("-", "");
        date = date.replace(" ", "");

        //日期拼装
        if (map.get("where") == null) {
            map.put("where", " and ((\"0CALMONTH\" BETWEEN ('" + date.split("`")[0] + "') and ('2" + date.split("`")[1] + "')))");
        } else {
            map.put("where", " and " + map.get("where") + "((\"0CALMONTH\" BETWEEN ('" + date.split("`")[0] + "') and ('2" + date.split("`")[1] + "')))");

        }

        //排序拼装
        String strcolumnko = map.get("columnko") == null ? "" : map.get("columnko").toString();
        String strOrder = " order by " + map.get("column") + " ";
        String[] strColumnko = strcolumnko.split(",");
        for (int i = 0, j = strColumnko.length; i < j; i++) {
            strOrder = strOrder + " " + strColumnko[i] + " desc " + ((i < (j - 1)) ? "," : "");
        }
        map.put("order", strOrder);
//        }
        return reportMapper.getReportList(map);
    }


    public List getReportListNew(Map<String, Object> map) {
//        if("164f98a6b8c_c4effcc1".equals(map.get("name"))){
        String date = (map.get("date") == null ? "" : map.get("date").toString());
        date = date.replace("-", "");
        date = date.replace(" ", "");

        //日期拼装
//        if(map.get("where")==null){
//            map.put("where"," and ((\"0CALMONTH\" BETWEEN ('"+date.split("`")[0]+"') and ('2"+date.split("`")[1]+"')))");
//        }else {
//            map.put("where"," and "+ map.get("where")+"((\"0CALMONTH\" BETWEEN ('"+date.split("`")[0]+"') and ('2"+date.split("`")[1]+"')))");
//
//        }
        //排序拼装
        String strcolumnko = map.get("columnko") == null ? "" : map.get("columnko").toString();
        String strOrder = " order by " + map.get("column") + " ";
        String[] strColumnko = strcolumnko.split(",");
        String strColumnKoSum = "";
        for (int i = 0, j = strColumnko.length; i < j; i++) {
            if(strColumnko[i]==""){
                continue;
            }
            strOrder = strOrder + " " + strColumnko[i] + " desc " + ((i < (j - 1)) ? "," : "");
            strColumnKoSum = strColumnKoSum + " sum(\"" + strColumnko[i] + "\") AS \"" + strColumnko[i] + "\"" + ((i < (j - 1)) ? "," : "");
        }
        map.put("order", strOrder);
        map.put("columnkosum", strColumnKoSum);
//        }

        List<Map<String, Object>> list = new ArrayList<>();
        if("1".equals(map.get("modelFlag"))){
            if("".equals(strcolumnko)){
                map.put("order",strOrder.substring(0,strOrder.length()-2));
                map.put("column",map.get("column").toString().substring(0,map.get("column").toString().length()-1));
            }
            list = reportMysqlMapper.getReportListStpDbAll(map);
        }else {
            list = reportMapper.getReportListNew(map);
        }

        List<Map<String, String>> list2 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map1 = list.get(i);
            Map<String, String> map2 = new LinkedHashMap<>();
            if(map1==null){
                continue;
            }
            for (Map.Entry<String, Object> entry : map1.entrySet()) {
                String str = entry.getValue() + "";
//                if (isNumeric(str)){
//                    str = calVal("",str);
//                }
                map2.put(entry.getKey(), str);
            }
            list2.add(map2);
        }

        return list2;
    }

    public static boolean isNumeric(String str) {
        Boolean strResult = str.matches("-[0-9]+(.[0-9]+)?|[0-9]+(.[0-9]+)?");
        return strResult;
    }

    /**
     * 转义
     *
     * @param o
     * @param t
     * @param <T>
     * @return
     */
    public static <T> T get(Object o, T t) {
        Class<T> clazz = (Class<T>) t.getClass();
        if (clazz != null) {
            if (clazz.isInstance(o))
                return clazz.cast(o);
            else
                throw new RuntimeException(o + " is not a " + clazz.getName());
        }
        return null;
    }

    /**
     * 取值
     *
     * @param clazz
     * @param object
     * @param strName
     * @return
     */
    public String getMethodVal(Class<T> clazz, Object object, String strName) {
        String strval = "";
        try {
            Method method = clazz.getMethod(strName);
            strval = (String) method.invoke((object));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return strval;
    }

    /**
     * 赋值
     *
     * @param clazz
     * @param object
     * @param strName
     * @param strVal
     */
    public void setMethodVal(Class clazz, Object object, String strName, String strVal) {
        try {
            Method method = clazz.getMethod(strName, String.class);
            method.invoke(object, new Object[]{strVal});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 求和
     *
     * @param str1
     * @param str2
     * @return
     */
    public String calVal(String str1, String str2) {
        String str = "";
        if (str1 == null || "".equals(str1)) {
            str1 = "0";
        }
        if (str2 == null || "".equals(str2)) {
            str2 = "0";
        }
        return new DecimalFormat("0.00").format(new BigDecimal(str1).add(new BigDecimal(str2)).doubleValue());
    }

    /**
     * 报表树查询
     *
     * @param paramsJson
     * @return
     * @throws Exception
     */
    @Override
    public JSONArray getReportTree(String paramsJson) throws InvocationTargetException, IllegalAccessException {
        Map<String, Object> mapParam = JSONObject.parseObject(paramsJson);
        long start_getReportList = System.currentTimeMillis();
        List<Map<String, Object>> list = this.getReportList(mapParam);
        long end_getReportList = System.currentTimeMillis();
        System.out.println("调用hana用时(getReportList): " + (end_getReportList - start_getReportList));
        long start = System.currentTimeMillis();
        String strPid = mapParam.get("xfield").toString();
        String columnko = mapParam.get("columnko").toString();
        String columngo = mapParam.get("column").toString();
        String[] arraycolumnko = columnko.split(",");
        String[] arrayField = columngo.split(",");
        Map<String, Object> map_count = new HashMap<>();
        List<Map<String, Object>> mapList = new ArrayList<>();
//        setGroupByCount(arrayField[0], arrayField, "0", list, arraycolumnko, mapList, map_count);

        setGroupByCount(strPid, arrayField, "0", list, arraycolumnko, mapList, map_count, UUID.randomUUID().toString());
        mapList.add(map_count);
        Collections.reverse(mapList);
        //空
//        for (int i = 0; i < mapList.size(); i++) {
//            Map<String, Object> qq = mapList.get(i);
//            System.out.println(qq.get("id")+"--"+qq.get("pid")+"--");

//            Set<Map.Entry<String, Object>> entrys = qq.entrySet();  //此行可省略，直接将map.entrySet()写在for-each循环的条件中
//            for (Map.Entry<String, Object> entry : entrys) {
//                System.out.println("key值：" + entry.getKey() + " value值：" + entry.getValue());
//
//            }
//        }
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(mapList, WriteNullStringAsEmpty));
        long end = System.currentTimeMillis();
        System.out.println("getReportTree:执行时间: " + (end - start));
        return json;
    }

    @Override
    public JSONArray getReportTreeNew(String paramsJson) throws InvocationTargetException, IllegalAccessException {
        Map<String, Object> mapParam = JSONObject.parseObject(paramsJson);
        long start_getReportList = System.currentTimeMillis();
        List<Map<String, Object>> list = this.getReportListNew(mapParam);
        long end_getReportList = System.currentTimeMillis();
        System.out.println("调用hana用时(getReportList): " + (end_getReportList - start_getReportList));
        long start = System.currentTimeMillis();
        String strPid = mapParam.get("xfield").toString();
        String columnko = mapParam.get("columnko").toString();
        String columngo = mapParam.get("column").toString();
        String[] arraycolumnko = columnko.split(",");
        String[] arrayField = columngo.split(",");
        Map<String, Object> map_count = new HashMap<>();
        List<Map<String, Object>> mapList = new ArrayList<>();
//        setGroupByCount(arrayField[0], arrayField, "0", list, arraycolumnko, mapList, map_count);

        setGroupByCount(strPid, arrayField, "0", list, arraycolumnko, mapList, map_count, UUID.randomUUID().toString());
        mapList.add(map_count);
        Collections.reverse(mapList);
        JSONArray json = new JSONArray();
        if (mapList.size() > 0) {
            json = JSONArray.parseArray(JSON.toJSONString(mapList, WriteNullStringAsEmpty));
        }
        long end = System.currentTimeMillis();
        System.out.println("getReportTree:执行时间: " + (end - start));
//        System.out.println(json);
        return json;
    }

    /**
     * 分组求和
     *
     * @param xField
     * @param arrayField
     * @param strPid
     * @param list
     * @param arraycolumnko
     * @param vos
     * @param voCount
     */
    public void setGroupByCount(String xField, String[] arrayField, String strPid, List<Map<String, Object>> list, String[] arraycolumnko, List<Map<String, Object>> vos, Map<String, Object> voCount, String strVoId) {
        int len = list.size();
        Object objXfieldValue = "";
        String objVal = "";
        xField = xField.toUpperCase();
        Map<String, String> mapx = new LinkedHashMap<>();
        Map<String, String> mapy = new LinkedHashMap<>();
        Map<String, Object> maplist = new LinkedHashMap<>();
//        Map<String, Object> mapfield = new LinkedHashMap<>();
        int i_field_index = getArrayIndex(arrayField, xField);
        int i_arrayField_length = arrayField.length;
        //添加返回的list:小计,最后的节点
        for (int i = 0; i < len; i++) {
            Map<String, Object> vo = list.get(i);
            //改值
            objXfieldValue = vo.get(xField);
            objVal = (objXfieldValue == null || "".equals(objXfieldValue) || "?".equals(objXfieldValue)) ? "-" : objXfieldValue.toString();
            objVal = objVal.replace("(", "（");
            objVal = objVal.replace(")", "）");
            vo.put(xField, objVal);
            list.get(i).put(xField, objVal);
            Object objI = vo.get("index");

            //第一次遍历设置list-index;添加到vos
            if (objI == null || "".equals(objI)) {
                objI = i + "";
                vo.put("index", objI);
                list.get(i).put("index", objI);
                vos.add(vo);
            }

            mapx.put(xField + objVal, objVal);
//            mapfield.put(xField +objVal, objI);
            //判断是否为空,为空,添加;不为空,取值添加
            if (i_field_index < (i_arrayField_length - 1) || i_arrayField_length == 1) {
                if (maplist.get(objVal) == null) {
                    List<Map<String, Object>> reportViewVoList = new ArrayList<>();
                    reportViewVoList.add(vo);
                    maplist.put(objVal, reportViewVoList);
                } else {
                    List<Map<String, Object>> reportViewVoList = (List<Map<String, Object>>) maplist.get(objVal);
                    reportViewVoList.add(vo);
                    maplist.put(objVal, reportViewVoList);
                }
            }
            //分组小计
            for (int j = 0; j < arraycolumnko.length; j++) {
                String strKey = arraycolumnko[j];
                mapy.put(objVal + "_" + strKey, calVal(mapy.get(objVal + "_" + strKey), (vo.get(strKey) == null ? "" : vo.get(strKey).toString())));
            }
        }
        //添加父节点
        Map<String, String> mapcount = new HashMap<>();
        for (Map.Entry<String, String> entry : mapx.entrySet()) {
            Map<String, Object> reportViewVo = new HashMap<>();
            String mapxKey = entry.getKey();
            String mapxvalue = entry.getValue();
            String strNewId = UUID.randomUUID().toString();
            reportViewVo.put("id", strNewId);
            reportViewVo.put("pid", strPid);

            reportViewVo.put(arrayField[0], "<b>小计(" + entry.getValue() + "):</b>");
//            reportViewVo.put(xField, "<b>小计(" + entry.getValue() + "):</b>");

            //修改id,pid,vos
            List<Map<String, Object>> mapList = (List<Map<String, Object>>) maplist.get(mapxvalue);
            if (mapList != null && mapList.size() > 0) {
                for (int i = 0; i < mapList.size(); i++) {
                    Map<String, Object> map = (Map<String, Object>) mapList.get(i);
                    map.put("id", UUID.randomUUID().toString());
                    map.put("pid", strNewId);
                    vos.set(Integer.parseInt(map.get("index").toString()), map);
                }
            }

            //汇总-小计-求和
            for (int j = 0; j < arraycolumnko.length; j++) {
                String strKo = arraycolumnko[j];
                mapcount.put(strKo, calVal(mapcount.get(strKo), mapy.get(entry.getValue() + "_" + strKo)));
                reportViewVo.put(strKo, "<b>" + mapy.get(entry.getValue() + "_" + strKo) + "</b>");
            }
            vos.add(reportViewVo);
            if (i_field_index < (i_arrayField_length - 2)) {
                setGroupByCount(arrayField[i_field_index + 1], arrayField, strNewId, (List<Map<String, Object>>) maplist.get(mapxvalue), arraycolumnko, vos, voCount, UUID.randomUUID().toString());
            }
//            else if (i_arrayField_length >0&&i_arrayField_length<2) {
//                //遍历vos,赋值pid,id
//                for (int i = 0; i < vos.size(); i++) {
//                    if(vos.get(i).get("pid")==null){
//                        if(vos.get(i).get(xField).equals(mapxvalue)){
//                            vos.get(i).put("pid",strNewId);
//                            vos.get(i).put("id",UUID.randomUUID().toString());
//                        }
//                    }
//                }
//            }else if(i_field_index==(i_arrayField_length-2)){
//                //空->-
//                for (int i = 0; i < vos.size(); i++) {
//                        if(vos.get(i).get(arrayField[i_arrayField_length-1])==null){
//                            vos.get(i).put(arrayField[i_arrayField_length-1],"-");
//                        }
//                }
//            }
        }
        //合计
        if (i_field_index == 0) {
            voCount.put("pid", "");
            voCount.put("id", "0");
            voCount.put(xField, "<b>合计:</b>");
            for (int j = 0; j < arraycolumnko.length; j++) {
                String strHj = mapcount.get(arraycolumnko[j]);
                voCount.put(arraycolumnko[j], "<b>" + ((strHj == null || "null".equals(strHj) || "".equals(strHj)) ? "0.00" : strHj) + "</b>");
            }
        }
    }

    /**
     * 分组求和
     *
     * @param paramsJson
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public JSONArray getReportTreeObject(String paramsJson) throws InvocationTargetException, IllegalAccessException {
        Map<String, Object> mapParam = JSONObject.parseObject(paramsJson);

        long start_getReportList = System.currentTimeMillis();
        List<Map<String, Object>> list = this.getReportList(mapParam);
        long end_getReportList = System.currentTimeMillis();
        System.out.println("调用hana用时(getReportList): " + (end_getReportList - start_getReportList));
        JSONArray json = JSONArray.parseArray(JSON.toJSONString(list));

//        List<ReportViewVo> viewVos = new ArrayList<>();
//        for (int i = 0,j=list.size(); i < j; i++) {
//            ReportViewVo reportViewVo = new ReportViewVo();
//            MyBeanUtils.transMap2Bean(list.get(i),reportViewVo);
//            viewVos.add(reportViewVo);
//        }
        long start = System.currentTimeMillis();
        List<ReportViewVo> viewVos = JSONObject.parseArray(json.toJSONString(), ReportViewVo.class);
        //分项汇总
        String strPid = mapParam.get("xfield").toString().toUpperCase();
        String columnko = mapParam.get("columnko").toString().toUpperCase();
        String columngo = mapParam.get("column").toString().toUpperCase();
        String[] arraycolumnko = columnko.split(",");

        Class clazz = ReportViewVo.class;
        List<ReportViewVo> vos = new ArrayList<>();
        ReportViewVo voCount = new ReportViewVo();
        String[] arrayField = columngo.split(",");

        setGroupByCountObj(strPid, arrayField, "0", viewVos, arraycolumnko, vos, voCount, clazz);
        vos.add(voCount);
        Collections.reverse(vos);
        json = JSONArray.parseArray(JSON.toJSONString(vos, WriteNullStringAsEmpty));

        long end = System.currentTimeMillis();
        System.out.println("getReportTree:执行时间: " + (end - start));
        return json;
    }

    /**
     * 对象求和
     *
     * @param xField
     * @param arrayField
     * @param strPid
     * @param list
     * @param arraycolumnko
     * @param vos
     * @param voCount
     * @param clazz
     */
    public void setGroupByCountObj(String xField, String[] arrayField, String strPid, List<ReportViewVo> list, String[] arraycolumnko, List<ReportViewVo> vos, ReportViewVo voCount, Class clazz) {
        int len = list.size();
        Object objXfieldValue = "";
        String objVal = "";
        Map<String, String> mapx = new LinkedHashMap<>();
        Map<String, String> mapy = new LinkedHashMap<>();
        Map<String, Object> maplist = new LinkedHashMap<>();
        Map<String, Object> mapfield = new LinkedHashMap<>();

        int i_field_index = getArrayIndex(arrayField, xField);
        //添加返回的list:小计,最后的节点
        for (int i = 0; i < len; i++) {
            ReportViewVo vo = list.get(i);
//            ReportViewVo vo = list.get(i);
            //获取X轴值
            objXfieldValue = getMethodVal(clazz, vo, "get" + xField);
            objVal = (objXfieldValue == null) ? "-" : objXfieldValue.toString();
            //设置ID,PID
//                vo.setPid(strPid);
            vo.setPid(xField + objVal);
//            vo.setPid(strPid);
            vo.setId(objVal);
            mapx.put(objVal, objVal);

            mapfield.put(objVal, xField);

            //判断vo,替换list值
            if (i_field_index == 0) {
                vo.setIndex(i + "");
                vos.add(vo);
            } else {
                vos.set(Integer.parseInt(vo.getIndex()), vo);
            }
            //判断是否为空,为空,添加;不为空,取值添加
            if (i_field_index < (arrayField.length - 1)) {
                if (maplist.get(objVal) == null) {
                    List<ReportViewVo> reportViewVoList = new ArrayList<>();
                    reportViewVoList.add(vo);
                    maplist.put(objVal, reportViewVoList);
                } else {
                    List<ReportViewVo> reportViewVoList = (List<ReportViewVo>) maplist.get(objVal);
                    reportViewVoList.add(vo);
                    maplist.put(objVal, reportViewVoList);
                }
            }
            //分组计算小计
            //TO DO 第一次调用,其他不调用
            for (int j = 0; j < arraycolumnko.length; j++) {
                String strKey = arraycolumnko[j];
                mapy.put(objVal + "_" + strKey, calVal(mapy.get(objVal + "_" + strKey), getMethodVal(clazz, vo, "get" + strKey)));
            }

        }
        //添加父节点
        Map<String, String> mapcount = new HashMap<>();
        for (Map.Entry<String, String> entry : mapx.entrySet()) {
            ReportViewVo reportViewVo = new ReportViewVo();
            String strKey = entry.getKey();
            reportViewVo.setId(xField + strKey);
            reportViewVo.setPid(strPid);
            setMethodVal(clazz, reportViewVo, "set" + xField, "小计(" + strKey + "):");
            for (int j = 0; j < arraycolumnko.length; j++) {
                String strKo = arraycolumnko[j];
                mapcount.put(strKo, calVal(mapcount.get(strKo), mapy.get(strKey + "_" + strKo)));
                setMethodVal(clazz, reportViewVo, "set" + strKo, mapy.get(strKey + "_" + strKo));
            }
            vos.add(reportViewVo);
//            if(i_field_index<(arrayField.length-2)){
//                setGroupByCount(arrayField[i_field_index+1],arrayField,xField+strKey, (List<ReportViewVo>) maplist.get(strKey),arraycolumnko,vos,voCount,clazz);
//            }
        }
        //合计
        if (i_field_index == 0) {
            voCount.setPid("");
            voCount.setId("0");
            setMethodVal(clazz, voCount, "set" + xField, "合计:");
            for (int j = 0; j < arraycolumnko.length; j++) {
                setMethodVal(clazz, voCount, "set" + arraycolumnko[j], mapcount.get(arraycolumnko[j]));
            }
        }
    }

    /**
     * 获取数组元素所在下标
     *
     * @param array
     * @param strField
     * @return
     */
    public int getArrayIndex(String[] array, String strField) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(strField)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public List selectHanaModelColumn(Map<String, Object> map) {
        if("0".equals(map.get("bak1"))){
            return reportMapper.selectHanaModelColumn(map);
        }else {
            return reportMysqlMapper.selectMysqlModelColumn(map);
        }
    }

    @Override
    public List selectCatalog(Map<String, Object> map) {
        return reportMapper.selectCatalog(map);
    }

    @Override
    public List selectCubeName(Map<String, Object> map) {
        return reportMapper.selectCubeName(map);
    }

    @Override
    public Long selectCatalogCount(Map<String, Object> map) {
        return reportMapper.selectCatalogCount(map);
    }

    @Override
    public Long selectCubeNameCount(Map<String, Object> map) {
        return reportMapper.selectCubeNameCount(map);
    }

    /**
     * 获取对象计算字段
     *
     * @param reportColumns
     * @param strColumn
     * @return
     */
    public String getColumnListCal(List<Map<String, Object>> reportColumns, String strColumn) {
        Object strBak2 = "";
        for (int i = 0; i < reportColumns.size(); i++) {
            if (strColumn.equals(reportColumns.get(i).get("field"))) {
                strBak2 = reportColumns.get(i).get("bak2");
                break;
            }
        }
        return (strBak2 == null || "".equals(strBak2)) ? "" : strBak2.toString();
    }

    public void setGroupByCountStp(String xField, String[] arrayField, String strPid, List<Map<String, Object>> list, String[] arraycolumnko, List<Map<String, Object>> vos, Map<String, Object> voCount, String strVoId) {
        int len = list.size();
        Object objXfieldValue = "";
        String objVal = "";
        xField = xField.toUpperCase();
        Map<String, String> mapx = new LinkedHashMap<>();
        Map<String, String> mapy = new LinkedHashMap<>();
        Map<String, Object> maplist = new LinkedHashMap<>();
//        Map<String, Object> mapfield = new LinkedHashMap<>();
        int i_field_index = getArrayIndex(arrayField, xField);
        int i_arrayField_length = arrayField.length;
        //添加返回的list:小计,最后的节点
        for (int i = 0; i < len; i++) {
            Map<String, Object> vo = list.get(i);
            //改值
            objXfieldValue = vo.get(xField);
            if(objXfieldValue == null || "".equals(objXfieldValue)){
//                continue;
                objXfieldValue = "-";
            }
            objVal = ("?".equals(objXfieldValue)) ? "-" : objXfieldValue.toString();
            objVal = objVal.replace("(", "（");
            objVal = objVal.replace(")", "）");
            vo.put(xField, objVal);
            list.get(i).put(xField, objVal);
            Object objI = vo.get("index");

            //第一次遍历设置list-index;添加到vos
            if (objI == null || "".equals(objI)) {
                objI = i + "";
                vo.put("index", objI);
                list.get(i).put("index", objI);
                vos.add(vo);
            }

            mapx.put(xField + objVal, objVal);
//            mapfield.put(xField +objVal, objI);
            //判断是否为空,为空,添加;不为空,取值添加
            if (i_field_index < (i_arrayField_length - 1) || i_arrayField_length == 1) {
                if (maplist.get(objVal) == null) {
                    List<Map<String, Object>> reportViewVoList = new ArrayList<>();
                    reportViewVoList.add(vo);
                    maplist.put(objVal, reportViewVoList);
                } else {
                    List<Map<String, Object>> reportViewVoList = (List<Map<String, Object>>) maplist.get(objVal);
                    reportViewVoList.add(vo);
                    maplist.put(objVal, reportViewVoList);
                }
            }
            //分组小计
            for (int j = 0; j < arraycolumnko.length; j++) {
                String strKey = arraycolumnko[j];
                mapy.put(objVal + "_" + strKey, calVal(mapy.get(objVal + "_" + strKey), (vo.get(strKey) == null ? "" : vo.get(strKey).toString())));
            }
        }
        //添加父节点
        Map<String, String> mapcount = new HashMap<>();
        for (Map.Entry<String, String> entry : mapx.entrySet()) {
            Map<String, Object> reportViewVo = new HashMap<>();
            String mapxKey = entry.getKey();
            String mapxvalue = entry.getValue();
            String strNewId = UUID.randomUUID().toString();
            reportViewVo.put("id", strNewId);
            reportViewVo.put("pid", strPid);
            reportViewVo.put("class", "0");
            reportViewVo.put(arrayField[i_field_index], entry.getValue());
//            reportViewVo.put(arrayField[0], entry.getValue());
//            reportViewVo.put(arrayField[0], "<b class='wq'>小计(" + entry.getValue() +"):</b>");

//            reportViewVo.put(xField, "<b>小计(" + entry.getValue() + "):</b>");

            //修改id,pid,vos
            List<Map<String, Object>> mapList = (List<Map<String, Object>>) maplist.get(mapxvalue);

            if (mapList != null && mapList.size() > 0) {
                for (int i = 0; i < mapList.size(); i++) {
                    Map<String, Object> map = (Map<String, Object>) mapList.get(i);
                    map.put("id", UUID.randomUUID().toString());
                    map.put("pid", strNewId);
//                    System.out.println(len+"传入list-len"+vos.size()+" 索引 = " + map.get("index").toString());
                    //TO DO
                    int ind = Integer.parseInt(map.get("index").toString());
////                    System.out.println(vos.get(1668));
//                    int size = vos.size();
//                    if(ind!=size){
                        vos.set(ind, map);
//                    }else {
//                        vos.set(ind-1,map);
//                    }

                }
            }

            //汇总-小计-求和
            for (int j = 0; j < arraycolumnko.length; j++) {
                String strKo = arraycolumnko[j];
                mapcount.put(strKo, calVal(mapcount.get(strKo), mapy.get(entry.getValue() + "_" + strKo)));
                reportViewVo.put(strKo, "<b>" + mapy.get(entry.getValue() + "_" + strKo) + "</b>");
            }
            vos.add(reportViewVo);
            if (i_field_index < (i_arrayField_length - 2)) {
                setGroupByCountStp(arrayField[i_field_index + 1], arrayField, strNewId, (List<Map<String, Object>>) maplist.get(mapxvalue), arraycolumnko, vos, voCount, UUID.randomUUID().toString());
            }
//            else if (i_arrayField_length >0&&i_arrayField_length<2) {
//                //遍历vos,赋值pid,id
//                for (int i = 0; i < vos.size(); i++) {
//                    if(vos.get(i).get("pid")==null){
//                        if(vos.get(i).get(xField).equals(mapxvalue)){
//                            vos.get(i).put("pid",strNewId);
//                            vos.get(i).put("id",UUID.randomUUID().toString());
//                        }
//                    }
//                }
//            }else if(i_field_index==(i_arrayField_length-2)){
//                //空->-
//                for (int i = 0; i < vos.size(); i++) {
//                        if(vos.get(i).get(arrayField[i_arrayField_length-1])==null){
//                            vos.get(i).put(arrayField[i_arrayField_length-1],"-");
//                        }
//                }
//            }
        }
        //合计
        if (i_field_index == 0) {
            voCount.put("pid", "");
            voCount.put("id", "0");
            voCount.put("class", "1");
//            voCount.put(xField, "<b class='wq'>合计("+list.size()+"):</b>");
            for (int j = 0; j < arraycolumnko.length; j++) {
                String strHj = mapcount.get(arraycolumnko[j]);
                voCount.put(arraycolumnko[j], "<b>" + ((strHj == null || "null".equals(strHj) || "".equals(strHj)) ? "0.00" : strHj) + "</b>");
            }
        }
    }

    /**
     * 分组求和STP
     *
     * @param mapParam
     * @param list
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public List<Map<String, Object>> getReportTreeNewStp(Map<String, Object> mapParam, List<Map<String, Object>> list, String flag) throws InvocationTargetException, IllegalAccessException {
        long start_getReportList = System.currentTimeMillis();
        if ("1".equals(flag)) {
             list = this.getReportListNew(mapParam);
        }
        long end_getReportList = System.currentTimeMillis();
        System.out.println("调用hana用时(getReportList): " + (end_getReportList - start_getReportList));
        long start = System.currentTimeMillis();
        String strPid = mapParam.get("xfield").toString();
        String columnko = mapParam.get("columnko").toString();
        String columngo = mapParam.get("column").toString();
        String[] arraycolumnko = columnko.split(",");
        String[] arrayField = columngo.split(",");
        Map<String, Object> map_count = new HashMap<>();
        List<Map<String, Object>> mapList = new ArrayList<>();

        setGroupByCountStp(strPid, arrayField, "0", list, arraycolumnko, mapList, map_count, UUID.randomUUID().toString());
        mapList.add(map_count);
        Collections.reverse(mapList);
        System.out.println("mapList-------------");
        System.out.println(mapList);
        long end = System.currentTimeMillis();
        System.out.println("getReportTreeNewStp:执行时间: " + (end - start));
        return mapList;
    }

    /**
     * 获取list求和数据
     *
     * @param list
     * @param countList
     * @param map
     * @return
     */
    public List<Map<String, Object>> getHeBingList(List<Map<String, Object>> pageList, List<Map<String, Object>> list, List<Map<String, Object>> countList, Map<String, Object> map) {
        String[] arrayColumn = map.get("column").toString().split(",");
        Map<String, String> mapColumn = new HashMap<>();
        for (int i = 0, j = list.size(); i < j; i++) {
            for (int k = 0, kcount = arrayColumn.length; k < kcount; k++) {
                //判断覆盖原list
                for (int h = 0, hcount = countList.size(); h < hcount; h++) {
                    Map<String, Object> m = countList.get(h);
                    if (("合计:").equals(m.get(arrayColumn[k]))) {
                        list.set(i, m);
                        break;
                    }
                    //判断是否已经设置,值1,值2,值3,值4
                    if (((list.get(i).get(arrayColumn[k]) == null ? "" : list.get(i).get(arrayColumn[k]).toString())).equals(m.get(arrayColumn[k]))) {
                        list.set(i, m);
                        break;
                    }
                }
            }
        }
        return list;
    }

    /**
     * Stp组装SQL
     *
     * @param map
     * @return
     */
    public List getReportListStp(Map<String, Object> map) {
        String strWhere = (map.get("where") == null ? "" : map.get("where").toString());
        //start
//        map.put("where"," and G0_HTH='117015-9'");
        //end
        String date = (map.get("date") == null ? "" : map.get("date").toString());
        date = date.replace("-", "");
        date = date.replace(" ", "");

        //获取计算
        List<Map<String, Object>> reportColumns = (List<Map<String, Object>>) map.get("column_cal");
        //排序拼装
        String strcolumnko = map.get("columnko") == null ? "" : map.get("columnko").toString();
        String strOrder = " order by " + map.get("column") + " ";
        String[] strColumnko = strcolumnko.split(",");
        String strColumnKoSum = "";
        for (int i = 0, j = strColumnko.length; i < j; i++) {
            strOrder = strOrder + " " + strColumnko[i] + " desc " + ((i < (j - 1)) ? "," : "");
            String strColumnCal = getColumnListCal(reportColumns, strColumnko[i]);
            if ("".equals(strColumnCal)) {
                strColumnKoSum = strColumnKoSum + " sum(\"" + strColumnko[i] + "\") AS \"" + strColumnko[i] + "\"" + ((i < (j - 1)) ? "," : "");
            } else {
                strColumnKoSum = strColumnKoSum + strColumnCal + ((i < (j - 1)) ? "," : "");
            }
        }
        map.put("order", strOrder);
        map.put("columnkosum", strColumnKoSum);

        List<Map<String, Object>> list = new ArrayList<>();
//        list = reportMapper.getReportListStp(map);
        //添加求和数据--开始
        try {
            list = getReportTreeNewStp(map, list, "1");
//            list = getHeBingList(list,getReportTreeNewStp(map,list,"0"),getReportTreeNewStp(map,list,"1"),map);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        //添加求和数据--结束
//        if(map.get("sum")!=null){
//            List<Map<String, Object>> list_sum = this.getReportListStpSum(map);
//            Map<String,Object> map1 = list_sum.get(0);
//            map1.put(map.get("column").toString().split(",")[0],"<b>合计:</b>");
//            list.add(0,map1);
//        }
        List<Map<String, String>> list2 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map1 = list.get(i);
            Map<String, String> map2 = new LinkedHashMap<>();
            for (Map.Entry<String, Object> entry : map1.entrySet()) {
                String str = entry.getValue() + "";
                map2.put(entry.getKey(), str);
            }
            list2.add(map2);
        }
        return list2;
    }

//    public static Map<String,Object> listCache = new HashMap<>();

    /**
     * Stp报表查询
     *
     * @param param
     * @return
     */
    public LayuiTableData getReportListStp(LayuiTableParam param) {

        long start_getReportList = System.currentTimeMillis();
        LayuiTableData data = new LayuiTableData();
        Map<String, Object> map = param.getParam();
        int pageSize = param.getLimit();
        //当前是第几页
        int pageNum = param.getPage();
        Page p = new Page(pageNum, pageSize);
        if("1".equals(map.get("tableType"))){
            map.put("column",map.get("column").toString().substring(0,map.get("column").toString().length()-1));
            String strcount = reportMysqlMapper.getReportListStpMysqlCount(map);
            System.out.println(strcount);
            data.setCount(Integer.parseInt(strcount));
            map.put("limit", pageSize);
            map.put("offset", (pageNum - 1) * (pageSize <= 0 ? 15 : pageSize));
            List listData = reportMysqlMapper.getReportListStpDb(map);
            System.out.println(listData.size());
            data.setData(listData);
        }else {
            map.put("limit", pageSize);
            map.put("offset", (pageNum - 1) * (pageSize <= 0 ? 15 : pageSize));
            int count = 0;
            //add 计算map where start
            Object strWhere = map.get("where");
            if(strWhere != null&&!"".equals(strWhere.toString().trim())){
//                System.out.println("strWhere = " + strWhere);
                strWhere = strWhere.toString().replace(",","' and ");
                strWhere = strWhere.toString().replace("=","='");
                strWhere = strWhere.toString().replace("\"","");
                map.put("where"," and "+strWhere.toString()+"'");
            }
            //add map where end
            List<Map<String, Object>> list = this.getReportListStp(map);
            if("1".equals(map.get("modelFlag"))){
                count = Integer.parseInt(reportMysqlMapper.getReportListStpMysqlCount(map));
            }else {
                count = getReportListStpCount(map).size();
            }
            data.setData(getPageListLimt(list, (pageNum - 1) * p.getPageSize(), (pageNum - 1) * p.getPageSize() + pageSize, map,count+""));
            data.setCount(count);
        }
        long end_getReportList = System.currentTimeMillis();
        //getReportListStp
        System.out.println("调用hana用时(getReportListStp): " + (end_getReportList - start_getReportList));
        return data;
    }

    public List<?> getPageListLimt(List<Map<String, Object>> list, int start, int end, Map<String, Object> map,String count) {
        List<Map<String, Object>> mapList = new ArrayList<>();
        int length = list.size();
        if (end > length) {
            end = length;
        }
        for (int i = start; i < end; i++) {
            if(list.get(i).get("class")==null){
                mapList.add(list.get(i));
            }else {
                end++;
                if (end > length) {
                    end = length;
                }
            }
        }

        //合计list
        List<Map<String, Object>> listHeJi = getHeJiList(list, map,count);
//        Set<Map<String, Object>> set = new TreeSet<>();
        Set<Map<String, Object>> set = new HashSet<>();
        System.out.println(" = ======================");
        System.out.println(listHeJi);
        System.out.println(mapList);
        //添加汇总排序
//        sortList(list,map);
        set.addAll(listHeJi);
        set.addAll(mapList);
        return Arrays.asList(set.toArray());
    }

    public void sortList(List<Map<String,Object>> list,Map<String,Object> map){
//        List<Map<String, Object>> collect = list.stream().sorted(Comparator.comparing(Test::comparingByName)
//                .thenComparing(Comparator.comparing(Test::comparingByAge).reversed()))
//                .collect(Collectors.toList());
String string = map.get("column").toString().split(",")[0];
        Collections.sort(list, new Comparator<Map<String, Object>>() {

            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                String name1=MapUtils.getString(o1, string);
                String name2=MapUtils.getString(o2, string);
                Collator instance = Collator.getInstance(Locale.CHINA);
                return instance.compare(name1, name2);
            }
        });
    }

    public List<Map<String, Object>> getHeJiList(List<Map<String, Object>> list, Map<String, Object> map,String count) {
        List<Map<String, Object>> mapList = new ArrayList<>();
        int leng = list.size();
        String[] strArrayColumn = map.get("column").toString().split(",");
        String strDiv = "<div style=\"float: left;height: 28px;line-height: 28px;padding-left: 5px\"><i> </i><i class=\"layui-icon layui-tree-head\">&#xe625</i>";
        for (int i = 0; i < leng; i++) {
            Object objClass = list.get(i).get("class");
            if (objClass != null) {
                Map<String, Object> maptemp = list.get(i);
                if ("0".equals(objClass)) {
                    String pid = maptemp.get("id").toString();
                    List<Map<String, Object>> firstA = list.stream().filter(a -> pid.equals(a.get("pid").toString())).collect(Collectors.toList());
                    for (int j = 0, jl = strArrayColumn.length - 1; j < jl; j++) {
                        if (maptemp.get(strArrayColumn[j]) != null) {
//                            maptemp.put(strArrayColumn[j + 1], firstA.size());
//                            maptemp.put(strArrayColumn[j + 1], "<b class='wq'>" + firstA.size() + "</b>");
                            if (j == 0) {
                                maptemp.put(strArrayColumn[j], strDiv + "<b class='wq'>" + maptemp.get(strArrayColumn[j]) + "</b></div>");
                            } else if (j == (strArrayColumn.length - 2)) {
                                maptemp.put(strArrayColumn[j], strDiv + "<b class='wq'>" + maptemp.get(strArrayColumn[j]) + "(" + firstA.size() + ")</b></div>");
                            } else {
                                maptemp.put(strArrayColumn[j], strDiv + "<b class='wq'>" + maptemp.get(strArrayColumn[j]) + "</b></div>");
                            }
                        }
                    }
                } else if ("1".equals(objClass)) {
//                    String pid = maptemp.get("id").toString();
//                    List<Map<String, Object>> firstA = list.stream().filter(a -> pid.equals(a.get("pid").toString())).collect(Collectors.toList());
                    maptemp.put(strArrayColumn[0], strDiv + "<b class='wq'>合计(" + count + ")</b></div>");
//                    maptemp.put(strArrayColumn[0], strDiv + "<b class='wq'>合计(" + firstA.size() + ")</b></div>");
//                    if (strArrayColumn.length == 2) {
//                        maptemp.put(strArrayColumn[1], "<b class='wq'>" + firstA.size() + "</b>");
//                    }
                } else {
                    maptemp.put(strArrayColumn[strArrayColumn.length - 1], "1");
                }
                mapList.add(maptemp);
            }
        }
        List<Map<String, Object>> newList = new ArrayList<>();
//        mapList = setListCount(mapList, map, strArrayColumn, list, newList, strArrayColumn.length - 1);
        return mapList;
    }


    public List<Map<String, Object>> setListCount(List<Map<String, Object>> list, Map<String, Object> map, String[] strArrayColumn, List<Map<String, Object>> listAll, List<Map<String, Object>> newList, int index_array) {
        int len_array = strArrayColumn.length;
        if (len_array < 2) {
            return list;
        }
        int len_list = list.size();
//        for (int j = len_array - 2; j > 0; j--) {
        for (int i = 0; i < len_list; i++) {
            if (list.get(i).get("class") != null) {
                Map<String, Object> maptemp = list.get(i);
                String child_pid = maptemp.get("id").toString();
                String parent_id = maptemp.get("pid").toString();
                //当前对象的子list
//                List<Map<String, Object>> childList = list.stream().filter(b -> child_pid.equals(b.get("pid").toString())).collect(Collectors.toList());
                //当前对象的父list
                List<Map<String, Object>> parentList = list.stream().filter(a -> parent_id.equals(a.get("id").toString())).collect(Collectors.toList());
                if (parentList.size() == 0) {
                    newList.add(maptemp);
                    break;
                }
                int parentIndex = list.indexOf(parentList.get(0));
                Map<String, Object> mapParent = parentList.get(0);
                for (int j = len_array; j >= index_array; j--) {
                    mapParent.put(strArrayColumn[j], calValStp((mapParent.get(strArrayColumn[j]) == null ? "0" : mapParent.get(strArrayColumn[j]).toString()), maptemp.get(strArrayColumn[j]) + ""));
                }
                list.set(parentIndex, mapParent);
                //添加到newmaps
                newList.add(maptemp);
                //创建新对象,删除当前对象,继续遍历
                List<Map<String, Object>> newHeJiList = list;
                newHeJiList.remove(maptemp);
                setListCount(newHeJiList, map, strArrayColumn, listAll, newList, index_array - 1);
//                    }
            }
//            }
        }
        return newList;
    }

    public String calValStp(String str1, String str2) {
        String str = "";
        if (str1 == null || "".equals(str1.trim())) {
            str1 = "0";
        } else {
            str1 = str1.replace("<b class='wq'>", "");
            str1 = str1.replace("</b>", "");
        }
        if (str2 == null || "".equals(str2.trim())) {
            str2 = "0";
        } else {
            str2 = str2.replace("<b class='wq'>", "");
            str2 = str2.replace("</b>", "");
        }
//        return (Integer.parseInt(str1)+Integer.parseInt(str2))+"";
        return new DecimalFormat("0").format(new BigDecimal(str1).add(new BigDecimal(str2)).doubleValue());
    }

    /**
     * Stp报表查询汇总
     *
     * @param param
     * @return
     */
    public List getReportListStpSum(Map<String, Object> param) {
        return reportMapper.getReportListStpSum(param);
    }

    @Override
//    public List getReportListStpDb(Map<String, Object> map) {
//        return reportMysqlMapper.getReportListStpDb(map);
//    }

    public List getReportListStpCount(Map<String, Object> map) {
        return reportMapper.getReportListStpCount(map);
    }
//    public List<Map<String, Object>> getSql(Map<String, Object> map) {
//        return reportMysqlMapper.getSql(map);
//    }

}
