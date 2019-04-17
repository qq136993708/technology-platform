package com.pcitc.es.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Preconditions;
import com.pcitc.base.annotations.Document;
import com.pcitc.base.annotations.Field;
import com.pcitc.base.annotations.ID;
import com.pcitc.es.builder.BooleanCondtionBuilder;
import com.pcitc.es.common.Constant;
import com.pcitc.es.common.ParamsParseException;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author:Administrator
 * @date:2018/6/23
 */
public class SearchUtil {

    /* 获取指定实体类的索引名称 */
    public static <T> String getIndexName(T model) {
        return getIndexName(model.getClass());
    }

    /* 获取指定实体类的索引名称 */
    public static String getIndexName(Class clazz) {
        return ((Document) clazz.getAnnotation(Document.class)).index();
    }

    /* 获取指定实体类的类型名称 */
    public static <T> String getTypeName(T model) {
        return getTypeName(model.getClass());
    }

    /* 获取指定实体类的类型名称 */
    public static String getTypeName(Class clazz) {
        return ((Document) clazz.getAnnotation(Document.class)).type();
    }

    /* 判别一个类是否是Document（elasticsearch实体类） */
    public static boolean isDocument(Class clazz) {
        return clazz.isAnnotationPresent(Document.class);
        // return getIndexName(clazz) == null ? false : true;
    }

    /* 获取指定实体类所在索引的number_of_shards值 */
    public static short getShards(Class clazz) {
        return ((Document) clazz.getAnnotation(Document.class)).shards();
    }

    /* 获取指定实体类所在索引的number_of_replicas值 */
    public static short getReplicas(Class clazz) {
        return ((Document) clazz.getAnnotation(Document.class)).replicas();
    }

    /* 获取注解ID标志的字段名称 */
    public static String getidName(Class clazz) {
        java.lang.reflect.Field[] fields = clazz.getDeclaredFields();
        String id = null;
        outer:
        for (java.lang.reflect.Field field : fields) {
            if (field.isAnnotationPresent(ID.class)) {
                id = field.getName();
                break outer;
            }
        }
        return id;
    }

    /* 获取注解ID标志的字段对应的值 */
    public static <T> Object getidValue(T model) {
        Class clazz = model.getClass();
        String idName = getidName(clazz);
        Object idValue = null;
        String firstLetter = idName.substring(0, 1).toUpperCase();
        String methodName = "get" + firstLetter + idName.substring(1);
        Method method = null;
        try {
            method = clazz.getMethod(methodName);
            idValue = method.invoke(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idValue;
    }

    public static void main(String[] args) {

    }

    /* 将实体类对象转换为Json字符串 */
    public static <T> String ModelToJson(T model) {
        // 直接调用fastjson 转成json字符串
//        String strJsonModel = "";
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            strJsonModel = objectMapper.writeValueAsString(model);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        return strJsonModel;
        return JSON.toJSONString(model, true);
    }

    /**
     * 将传入的value字符串对象转换为type对应的具体子类类型对象（返回时会向上造型为Object对象） 注：只接受String及基本类型及对应包装类的转换
     */
    private static Object convert(Class type, String value) {
        if (type.equals(String.class)) {
            return value;
        }
        if (type.equals(int.class) || type.equals(Integer.class)) {
            return Integer.parseInt(value);
        }
        if (type.equals(Short.class) || type.equals(short.class)) {
            if (value == null) {
                return 0;
            }
            return Short.parseShort(value);
        }
        if (type.equals(Integer.class) || type.equals(int.class)) {
            if (value == null) {
                return 0;
            }
            return Integer.parseInt(value);
        }
        if (type.equals(Float.class) || type.equals(float.class)) {
            if (value == null) {
                return 0f;
            }
            return Float.parseFloat(value);
        }
        if (type.equals(Double.class) || type.equals(double.class)) {
            if (value == null) {
                return 0.0;
            }
            return Double.parseDouble(value);
        }
        if (type.equals(Long.class) || type.equals(long.class)) {
            if (value == null) {
                return 0l;
            }
            return Long.parseLong(value);
        }
        if (type.equals(Boolean.class) || type.equals(boolean.class)) {
            if (value == null) {
                return false;
            }
            return Boolean.parseBoolean(value);
        }
        return null;

    }

    /* 将map对象转换为对应的实体类对象 */
    public static <K, V, T> T MapToModel(Map<K, V> map, Class<T> clazz) {
        Method[] methods = clazz.getMethods();
        // Set<Method> methodsSet = new HashSet<Method>();
        Map<String, Method> methodsMap = new HashMap<String, Method>();
        for (Method method : methods) {
            // 添加所有Setter方法
            if (method.getName().startsWith("set") && method.getParameterTypes().length == 1) {
                // methodsSet.add(method);
                methodsMap.put(method.getName(), method);
            }
        }
        if (map == null)
            return null;
        T model = null;
        try {
            model = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (K key : map.keySet()) {
            // System.out.println(key + "：" + map.get(key));
            String field = (String) key;
            // ES中通过client API获得到的结果map,所有的value都是String类型
            // （虽然是Object,但具体的子类类型仍未String,算作ES java client API的一个bug）
            Object value = map.get(key);
            // 拼装Setter方法名
            String firstLetter = field.substring(0, 1).toUpperCase();
            String methodName = "set" + firstLetter + field.substring(1);
            // System.out.println(methodName);
            try {
                // Method method = clazz.getDeclaredMethod(methodName,String.class);
                // method.invoke(model,value);
                Method method = methodsMap.get(methodName);
                if (method == null) {
                    throw new Exception("没有" + method.getName() + "方法，请检查相应实体类(可能的问题：ES中新增了字段，但在实体类中没有定义)！");
                }
                Class parameterType = method.getParameterTypes()[0];// 获取Setter的参数类型
                // 根据参数类型对value(String类型)进行类型转换（转换为具体的子类类型）
                Object value2 = convert(parameterType, value.toString());
                // 执行invoke方法，传入的参数类型必须匹配（第一个参数），同时传入的值value（第二个参数）具体的子类类型必须匹配
                // value可以进行向上造型操作，只要保证子类类型一致即可

//                // 将高亮处理后的内容，替换原有高亮内容(原有内容，可能会出现显示不全)
//                Map<String, HighlightField> highlightFields = searchHit.getHighlightFields();
//                HighlightField titleField = highlightFields.get("title");
//                // 获取到原有内容中的每个高亮显示的集中的位置，fragment就是高亮片段
//                Text[] fragments = titleField.fragments();
//                String title = "";
//                for (Text text : fragments) {
//                    System.out.println(text);
//                    title += text;
//                }


                method.invoke(model, convert(parameterType, value2.toString()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return model;
    }

    /* 获得指定实体类中的Type注解中的Init参数值 */
    public static boolean getInitValue(Class<?> modelClazz) {
        return ((Document) modelClazz.getAnnotation(Document.class)).init();
    }

    /**
     * 调用parserParams()方法解析查询参数，并封装成map，供调用这查询，各key及对应说明如下： searchParams ： 查询参数 filterParams ： 过滤参数 start ： 开始位置 rows ：
     * 每页显示记录条数 showFields ： 要显示的字段 sortFields ： 排序字段及规则 isShowHighLight ： 是否高亮显示 HighLightFields ： 高亮显示的字段
     * HighLightPreTag ： 高亮显示的前置标记 HighLightPostTag ： 高亮显示的后置标记
     *
     * @param params
     * @return Map<String   ,   Object>
     * @throws ParamsParseException
     */
    public static Map<String, Object> getParamsMap(String params) {
        // 调用parserParams()方法
        Map<String, Object> searchMap = null;
        try {
            searchMap = parserParams(params);
        } catch (ParamsParseException e) {
            e.printStackTrace();
        }
        String searchParams = searchMap.get("q").toString();// 查询参数
        String filterParams = (String) searchMap.get("fq");// 过滤参数
        int start = Integer.parseInt(searchMap.get("start").toString());// 开始位置
        int rows = Integer.parseInt(searchMap.get("rows").toString());// 每页显示记录条数
        List<String> showFields = (List<String>) searchMap.get("fl");// 要显示的字段
        Map<String, SortOrder> sortFields = (HashMap<String, SortOrder>) searchMap.get("sort");// 排序字段及规则
        boolean showHighLight = Boolean.parseBoolean((String) searchMap.get("hl"));// 是否高亮显示
        List<String> HighLightFields = (List<String>) searchMap.get("hl.fl");// 高亮显示的字段
        String HighLightPreTag = (String) searchMap.get("hl.simple.pre");// 高亮显示的前置标记
        String HighLightPostTag = (String) searchMap.get("hl.simple.post");// 高亮显示的后置标记

        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("searchParams", searchParams);
        paramsMap.put("filterParams", filterParams);
        paramsMap.put("start", start);
        paramsMap.put("rows", rows);
        paramsMap.put("showFields", showFields);
        paramsMap.put("sortFields", sortFields);
        paramsMap.put("showHighLight", showHighLight);
        paramsMap.put("HighLightFields", HighLightFields);
        paramsMap.put("HighLightPreTag", HighLightPreTag);
        paramsMap.put("HighLightPostTag", HighLightPostTag);
        return paramsMap;
    }

    /**
     * ES的查询参数解析工具
     *
     * @param params 符合Solr查询语法的查询语句（为了兼容现有业务的查询接口以及方便查询，按照solr的查询语法格式做了一层包装， 用户的查询语句只要符合solr的语法要求均可在此进行查询操作。）
     *               eg：q=name:'东方财富'&fq=tgsType:2&sort=name+desc,key+asc&start=10&rows=5&fl=name,age,sex,key&hl=true
     *               &hl.fl=name,logid&hl.simple.pre=<em>&hl.simple.post=</em> 详情请参考solr的查询语法
     * @return
     */
    public static Map<String, Object> parserParams(String params)
            throws ParamsParseException {
        // String params = "q=name:hello&sort=name+desc,key+asc&start=10&rows=5&fl=name,age,sex,key" +
        // "&hl=true&hl.fl=name,logid&hl.simple.pre=<em>&hl.simple.post=</em>";
        if (params == null || params.length() == 0) {
            throw new ParamsParseException();
        }
        Map<String, Object> map = new HashMap<String, Object>();
        String[] paramsArr = params.split("&");
        for (String str : paramsArr) {
            String[] arr = str.split("=");
            // assert arr.length == 2;
            if (!(arr.length == 2)) {
                if (arr.length == 1 && str.equals("")) {
                    throw new ParamsParseException("查询参数解析异常,包含空子句:&空&！");
                }
                // throw new ParamsParseException("查询参数解析异常，请保证以\"&\"分隔的每个查询子句" + "中的字段和值之间用\"=\"连接,当前出错子句：" + str);

            }
            String param = str.split("=")[0];
            String value = str.split("=")[1];
            map.put(param, value);
        }
        Set<String> paramSet = map.keySet();
        if (!paramSet.contains("q")) {
            throw new ParamsParseException("查询参数不正确，没有包含必要的查询字段(q字段)!");
        }
        if (!paramSet.contains("fq")) {
            map.put("fq", null);
        }
        if (!paramSet.contains("start")) {
            map.put("start", Constant.START);
        } else {
            int value = Integer.parseInt(map.get("start").toString());
            Preconditions.checkArgument(value >= 0, "查询参数解析异常，start参数不能小于0,当前值：%s，请检查你的参数！", value);
            // throw new ParamsParseException();
        }
        if (!paramSet.contains("rows")) {
            map.put("rows", Constant.ROWS);
        } else {
            int value = Integer.parseInt(map.get("rows").toString());
            Preconditions.checkArgument(value >= 0, "查询参数解析异常，rows参数不能小于0,当前值：%s，请检查你的参数！", value);
        }
        if (!paramSet.contains("fl")) {
            map.put("fl", null);
        } else {
            map.put("fl", Arrays.asList(map.get("fl").toString().split(",")));
        }
        if (!paramSet.contains("sort")) {
            map.put("sort", null);
        } else {
            String sortStr = map.get("sort").toString();
            String[] srotArr = sortStr.split(",");
            Map<String, SortOrder> sortFields = new HashMap<String, SortOrder>();
            for (String str : srotArr) {
                if (!(str.split("\\+").length == 2)) {
                    throw new ParamsParseException("查询参数解析异常，排序参数设置语法错误,正确格式参考：字段+desc/asc！！");
                }
                String field = str.split("\\+")[0];
                String sort = str.split("\\+")[1];
                if (!("desc".equalsIgnoreCase(sort) || "asc".equalsIgnoreCase(sort))) {
                    throw new ParamsParseException("查询参数解析异常，排序参数设置语法错误,请用asc/desc表示排序！");
                }
                sortFields.put(field, "desc".equalsIgnoreCase(sort) ? SortOrder.DESC : SortOrder.ASC);
            }
            map.put("sort", sortFields);
        }
        return map;
    }

    /* 获取指定类的mapping,并组装成json字符串 */
    public static String getMapping(Class clazz) {
        List<String> words = new ArrayList<String>();
        words.add("Integer".toLowerCase());
        words.add("Float".toLowerCase());
        words.add("Double".toLowerCase());
        words.add("Boolean".toLowerCase());
        words.add("BigDecimal".toLowerCase());
        words.add("Date".toLowerCase());

        if (!getInitValue(clazz))
            return null;
        JSONObject rootJson = new JSONObject();
        JSONObject typeJson = new JSONObject();
        String indexName = SearchUtil.getIndexName(clazz);
        String typeName = SearchUtil.getTypeName(clazz);
        java.lang.reflect.Field[] fields = clazz.getDeclaredFields();
        String fieldsStr = "[";
        JSONObject propertiesJson = new JSONObject();
        for (java.lang.reflect.Field field : fields) {
            if (field.isAnnotationPresent(Field.class)) {
                JSONObject fieldJson = new JSONObject();
                fieldsStr += field.getName() + ",";
                Field ann = field.getAnnotation(Field.class);
                Object type = ann.type().name().toLowerCase();
                String index = ann.index().name();
                String stored = ann.stored() + "";
                String analyzer = ann.analyzer();
                String format = ann.format();

                boolean fields1 = ann.fields();
                // type = "string", index = "analyzed", stored = "true", analyzer = "standard"
                if (type.equals("Auto")) {// 如果是Auto类型则跳过，不进行mapping设置
                    continue;
                }
                fieldJson.put("type", type);
                // 是否多字段
                if (fields1) {
                    String[] fieldsName = ann.fieldsName();
                    String[] fieldsAnalyzer = ann.fieldsAnalyzer();
                    if (fieldsName.length > 0) {
                        Map<String, Object> root = new HashMap<>();
                        for (int i = 0; i < fieldsName.length; i++) {
                            Map<String, String> tree = new HashMap<>();
                            tree.put("type", "text");
                            // "index": "analyzed",
                            tree.put("index", "analyzed");
                            tree.put("analyzer", fieldsAnalyzer[i]);
                            root.put(fieldsName[i], tree);
                        }
                        fieldJson.put("fields", JSONObject.parseObject(JSON.toJSONString(root), root.getClass()));
                    }

                } else {
                    // 数值类的不能添加分词
                    if (!words.contains(type)) {
                        fieldJson.put("analyzer", analyzer);
                    }
                    // 是时间类型的字段 默认加上哦一个format
                    if (type.equals("date")) {
                        fieldJson.put("format", format);
                    } else {
                        fieldJson.put("store", stored);
                        fieldJson.put("index", index);
                    }
                }

                propertiesJson.put(field.getName(), fieldJson);
            }
        }
        typeJson.put("properties", propertiesJson);
        rootJson.put(typeName, typeJson);
        fieldsStr = fieldsStr.substring(0, fieldsStr.length() - 1) + "]";
        //LOG.info("扫描实体类：" + clazz + ",发现索引：" + indexName + ",发现类型：" + typeName + ",发现Field有效字段为：" + fieldsStr);
        //LOG.info("扫描类" + clazz.getName() + "完成，生成的mapping如下：\n" + rootJson.toJSONString());
        return rootJson.toJSONString();
    }

    /* 获取指定类的mapping,并组装成json字符串 */
    public static XContentBuilder getMappingXContentBuilder(Class clazz) {
        XContentBuilder builder = null;
        try {
            builder = XContentFactory.jsonBuilder();
            builder.startObject().startObject("properties");

            List<String> words = new ArrayList<String>();
            words.add("Integer".toLowerCase());
            words.add("Float".toLowerCase());
            words.add("Double".toLowerCase());
            words.add("Boolean".toLowerCase());
            words.add("BigDecimal".toLowerCase());
            words.add("Date".toLowerCase());

            if (!getInitValue(clazz))
                return null;
            String indexName = SearchUtil.getIndexName(clazz);
            String typeName = SearchUtil.getTypeName(clazz);
            java.lang.reflect.Field[] fields = clazz.getDeclaredFields();
            JSONObject propertiesJson = new JSONObject();
            for (java.lang.reflect.Field field : fields) {
                if (field.isAnnotationPresent(Field.class)) {
                    JSONObject fieldJson = new JSONObject();
                    Field ann = field.getAnnotation(Field.class);
                    Object type = ann.type().name().toLowerCase();
                    String index = ann.index().name();
                    String stored = ann.stored() + "";
                    String analyzer = ann.analyzer();
                    String format = ann.format();

                    // type = "string", index = "analyzed", stored = "true", analyzer = "standard"
                    if (type.equals("Auto")) {// 如果是Auto类型则跳过，不进行mapping设置
                        continue;
                    }
                    //分词start
                    builder.startObject(field.getName());
                    builder.field("type",type);

                        // 数值类的不能添加分词
                        if (!words.contains(type)) {
                            builder.field("analyzer",analyzer);
                        }
                        // 是时间类型的字段 默认加上哦一个format
                        if (type.equals("date")) {
                            builder.field("format",format);
                        } else {
                            builder.field("store",stored);
//                            builder.field("index",index);
                        }
                    builder.endObject();
                }
            }
            builder.endObject().endObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder;
    }

    /* 读取setting配置文件 */
    public static String getSettings(Class clazz) {
        // 获得实体类对应的index对应的settings配置文件
        Annotation[] annotationArr = clazz.getAnnotations();
        String settingsFile = null;
        for (Annotation annotation : annotationArr) {
            if (annotation instanceof Document) {
                settingsFile = ((Document) annotation).settings();
                break;
            }
        }
        // 是否使用指定配置文件来创建索引
        boolean crateIndexWithSettings = "".endsWith(settingsFile) ? false : true;
        if (!crateIndexWithSettings) {
            return null;
        }
        //LOG.info("读取settings文件：classpath/" + settingsFile + " ....");
        InputStream stream = ClassLoader.getSystemResourceAsStream(settingsFile);
        // Preconditions.checkNotNull(stream,"settings.yml文件不存在");
        if (stream == null) {
            throw new RuntimeException("classpath/" + settingsFile + "文件不存在");
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(stream));
        String line;
        StringBuffer settings = new StringBuffer();
        try {
            while ((line = br.readLine()) != null) {// 一次输出文本中的一行内容
                // System.out.println(line);
                if (!line.startsWith("#"))
                    settings.append(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return settings.toString();
    }

    /* 生成指定的Setting信息，暂时不用 */
    public static String getSettings() {
        JSONObject root = new JSONObject();
        JSONObject settings = new JSONObject();
        settings.put("number_of_shards", "3");
        settings.put("number_of_replicas", "1");
        JSONObject analysis = new JSONObject();
        JSONObject analyzer = new JSONObject();
        JSONObject pinyin_analyzer = new JSONObject();
        pinyin_analyzer.put("type", "pattern");
        pinyin_analyzer.put("pattern", "\\w");
        pinyin_analyzer.put("alias", new String[]{"pinyin"});
        JSONObject douhao_analyzer = new JSONObject();
        douhao_analyzer.put("type", "pattern");
        douhao_analyzer.put("pattern", ",");
        douhao_analyzer.put("alias", new String[]{"douhao"});
        JSONObject fenhao_analyzer = new JSONObject();
        fenhao_analyzer.put("type", "pattern");
        fenhao_analyzer.put("pattern", ";");
        fenhao_analyzer.put("alias", new String[]{"fenhao"});
        JSONObject ik_analyzer = new JSONObject();
        ik_analyzer.put("type", "org.elasticsearch.index.analysis.IkAnalyzerProvider");
        ik_analyzer.put("alias", new String[]{"ik_analyzer"});
        analyzer.put("pinyin_analyzer", pinyin_analyzer);
        analyzer.put("douhao_analyzer", douhao_analyzer);
        analyzer.put("fenhao_analyzer", fenhao_analyzer);
        analyzer.put("ik", ik_analyzer);
        analysis.put("analyzer", analyzer);
        settings.put("analysis", analysis);
        root.put("settings", settings);
        return root.toJSONString();
    }

    /* 将map对象转换为对应的实体类对象 */
    public static <K, V, T> T MapToModelParams(Map<K, V> map, Class<T> clazz, SearchHit searchHit, Map<String, String> mapHighLightList) {
        Method[] methods = clazz.getMethods();
        // Set<Method> methodsSet = new HashSet<Method>();
        Map<String, Method> methodsMap = new HashMap<String, Method>();
        for (Method method : methods) {
            // 添加所有Setter方法
            if (method.getName().startsWith("set") && method.getParameterTypes().length == 1) {
                // methodsSet.add(method);
                methodsMap.put(method.getName(), method);
            }
        }
        if (map == null)
            return null;
        T model = null;
        try {
            model = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (K key : map.keySet()) {
            // System.out.println(key + "：" + map.get(key));
            String field = (String) key;
            // ES中通过client API获得到的结果map,所有的value都是String类型
            // （虽然是Object,但具体的子类类型仍未String,算作ES java client API的一个bug）
            Object value = map.get(key);
            // 拼装Setter方法名
            String firstLetter = field.substring(0, 1).toUpperCase();
            String methodName = "set" + firstLetter + field.substring(1);
            // System.out.println(methodName);
            try {
                // Method method = clazz.getDeclaredMethod(methodName,String.class);
                // method.invoke(model,value);
                Method method = methodsMap.get(methodName);
                if (method == null) {
                    throw new Exception("没有" + method.getName() + "方法，请检查相应实体类(可能的问题：ES中新增了字段，但在实体类中没有定义)！");
                }
                Class parameterType = method.getParameterTypes()[0];// 获取Setter的参数类型
                // 根据参数类型对value(String类型)进行类型转换（转换为具体的子类类型）
                Object value2 = convert(parameterType, value.toString());
                // 执行invoke方法，传入的参数类型必须匹配（第一个参数），同时传入的值value（第二个参数）具体的子类类型必须匹配
                // value可以进行向上造型操作，只要保证子类类型一致即可

//                // 将高亮处理后的内容，替换原有高亮内容(原有内容，可能会出现显示不全)
                Map<String, HighlightField> highlightFields = searchHit.getHighlightFields();

                String strValue = value2.toString();
                if (mapHighLightList != null && mapHighLightList.get(key) != null) {
                    HighlightField objField = highlightFields.get(key);
                    // 获取到原有内容中的每个高亮显示的集中的位置，fragment就是高亮片段
                    if (objField != null) {
                    	 Text[] fragments = objField.fragments();
                         strValue = "";
                         for (Text text : fragments) {
                             strValue += text;
                         }
                    }
                }
                method.invoke(model, convert(parameterType, strValue));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return model;
    }

}
