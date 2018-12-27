package com.pcitc.service.expert.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.*;
import com.pcitc.base.common.enums.DataOperationStatusEnum;
import com.pcitc.base.common.enums.DelFlagEnum;
import com.pcitc.base.expert.*;
import com.pcitc.base.expert.ZjkBaseInfoExample;
import com.pcitc.base.hana.report.AchievementsAnalysis;
import com.pcitc.base.system.SysDictionary;
import com.pcitc.base.util.DateUtil;
import com.pcitc.base.util.IdUtil;
import com.pcitc.base.util.ReverseSqlResult;
import com.pcitc.base.util.TreeNodeUtil;
import com.pcitc.config.SpringContextUtil;
import com.pcitc.mapper.expert.ZjkBaseInfoMapper;
import com.pcitc.service.expert.ZjkBaseInfoService;
import com.pcitc.service.expert.ZjkChengguoService;
import com.pcitc.service.expert.ZjkPicService;
import com.pcitc.web.feign.SystemRemoteClient;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;
import java.util.stream.Collectors;


/**
 * <p>接口实现类</p>
 * <p>Table: zjk_base_info - 专家-基本信息</p>
 *
 * @since 2018-12-08 04:10:36
 */
@Service("zjkBaseInfoService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ZjkBaseInfoServiceImpl implements ZjkBaseInfoService {

    @Autowired
    private ZjkBaseInfoMapper zjkBaseInfoMapper;

    public List<ZjkBaseInfo> findZjkBaseInfoList(ZjkBaseInfo zjkBaseInfo) {
        List<ZjkBaseInfo> record = zjkBaseInfoMapper.findZjkBaseInfoList(zjkBaseInfo);
        return record;
    }

    @Override
    public int updateOrInsertZjkBaseInfo(ZjkBaseInfo zjkBaseInfo) throws Exception {
        int result = 500;
        if (zjkBaseInfo.getId() != null && zjkBaseInfo.getId() != null) {
            zjkBaseInfoMapper.updateByPrimaryKeySelective(zjkBaseInfo);
        } else {
            zjkBaseInfo.setId(IdUtil.createIdByTime());
            zjkBaseInfoMapper.insertSelective(zjkBaseInfo);
        }
        result = 200;
        return result;
    }

    @Override
    public int deleteZjkBaseInfoById(String id) throws Exception {
        int result = 500;
        if (id != null) {
            zjkBaseInfoMapper.deleteByPrimaryKey(id);
        }
        result = 200;
        return result;
    }

    @Override
    public ZjkBaseInfo getZjkBaseInfoInfo(String id) throws Exception {

        return zjkBaseInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public long countByExample(ZjkBaseInfoExample example) {
        return zjkBaseInfoMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ZjkBaseInfoExample example) {
        return zjkBaseInfoMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String recordId) {
        return zjkBaseInfoMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public Integer deleteZjkBaseInfoReal(String recordId) {
        return zjkBaseInfoMapper.deleteByPrimaryKey(recordId);
    }

    @Override
    public int insert(ZjkBaseInfo record) {
        record.setId(IdUtil.createIdByTime());
        return zjkBaseInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(ZjkBaseInfo record) {
        return zjkBaseInfoMapper.insertSelective(record);
    }

    public ZjkBaseInfo insertObject(ZjkBaseInfo record) {
        this.insert(record);
        return record;
    }

    @Override
    public List<ZjkBaseInfo> selectByExample(ZjkBaseInfoExample example) {
        return zjkBaseInfoMapper.selectByExample(example);
    }

    @Override
    public ZjkBaseInfo selectByPrimaryKey(String recordId) {
        return zjkBaseInfoMapper.selectByPrimaryKey(recordId);
    }

    @Override
    public int updateByExampleSelective(@Param("record") ZjkBaseInfo record, @Param("example") ZjkBaseInfoExample example) {
        return zjkBaseInfoMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") ZjkBaseInfo record, @Param("example") ZjkBaseInfoExample example) {
        return zjkBaseInfoMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(ZjkBaseInfo record) {
        return zjkBaseInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ZjkBaseInfo record) {
        if (record.getStatus() == null) {
            record.setStatus("");
        }
        return zjkBaseInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer deleteZjkBaseInfo(Serializable zjkBaseInfoId) {
        try {
            ZjkBaseInfo record = zjkBaseInfoMapper.selectByPrimaryKey(zjkBaseInfoId.toString());
            if (record != null) {
                record.setStatus(DelFlagEnum.STATUS_DEL.getCode() + "");
                zjkBaseInfoMapper.updateByPrimaryKey(record);
            }
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_OK));
        } catch (Exception e) {
            return Integer.parseInt(String.valueOf(DataOperationStatusEnum.DEL_DATA_ERROR));
        }
    }

    @Override
    public LayuiTableData findZjkBaseInfoByPage(LayuiTableParam param) {
        ZjkBaseInfoExample example = new ZjkBaseInfoExample();
        ZjkBaseInfoExample.Criteria c = example.createCriteria();
//        c.andStatusEqualTo("1");
//        if(param.getParam().get("fileKind") !=null && !com.pcitc.common.StringUtils.isBlank(param.getParam().get("fileKind")+""))
//        {
        //   c.andIdLike("'%"+param.getParam().get("fileKind")+"%'");
//            ZjkBaseInfoExample.Criteria criteria2 = example.or();
//            criteria2.andParentIdEqualTo(param.getParam().get("fileKind").toString());
//            example.or(criteria2);
        //       }
        example.setOrderByClause("create_date desc");
        return this.findByExample(param, example);

    }


    @Autowired
    private ZjkChengguoService zjkChengguoService;

    @Resource
    private SystemRemoteClient systemRemoteClient;

    public List<SysDictionary> getDicSon(String strParentCode) {
        List<SysDictionary> list = systemRemoteClient.getDictionaryListByParentCode(strParentCode);
        return list;
    }

    public String getDicSonVal(List<SysDictionary> list, String val) {
        List<SysDictionary> dictionaries = list.stream().filter(a -> val.equals(a.getCode())).collect(Collectors.toList());
        return (dictionaries == null || dictionaries.size() == 0) ? "" : dictionaries.get(0).getCode();
    }

    @Override
    public LayuiTableData findZjkBaseInfoByPageIndex(LayuiTableParam param) {
        Object hyly = param.getParam().get("hyly");//行业领域
        Object jg = param.getParam().get("jg");//机构(研究院)
        Object zjmc = param.getParam().get("zjmc");//专家名称
        Object key = param.getParam().get("key");//关键字

        Object nld = param.getParam().get("nld");//年龄段
        Object zc = param.getParam().get("zc");//职称

        Object gb = param.getParam().get("gb");//规避本院

        ZjkBaseInfoExample example = new ZjkBaseInfoExample();
        ZjkBaseInfoExample.Criteria c = example.createCriteria();

        if (hyly != null && !"".equals(hyly)) {
            c.andHylyIn(Arrays.asList(hyly.toString().split(",")));
//            ZjkBaseInfoExample.Criteria criteria2 = example.or();
//            criteria2.andParentIdEqualTo(param.getParam().get("fileKind").toString());
//            example.or(criteria2);
        }
        if (zc != null && !"".equals(zc)) {
            c.andZcIn(Arrays.asList(zc.toString().split(",")));
        }
        if (nld != null && !"".equals(nld)) {
            c.andAgeBetweenIn(Arrays.asList(nld.toString().split(",")));
        }
        if (jg != null && !"".equals(jg)) {//选择了机构
            List<String> jgList = Arrays.asList(jg.toString().split(","));
            if (gb != null && !"".equals(gb)) {//选择了规避,移除
                jgList.remove(gb);
            }
            c.andCompanyIn(jgList);
        } else {//只有规避机构
            c.andCompanyNotEqualTo(gb.toString());
        }
        if (zjmc != null && !"".equals(zjmc)) {
            c.andNameLike("%" + zjmc + "%");
        }
        if (key != null && !"".equals(key)) {
            //获取成果人员id
            ZjkChengguoExample chengguoExample = new ZjkChengguoExample();
            chengguoExample.createCriteria().andCgKeysIn(Arrays.asList(key.toString().split(",")));
            List<ZjkChengguo> zjkChengguos = zjkChengguoService.selectByExample(chengguoExample);
            //添加人员id查询条件
            List<String> strings = zjkChengguos.stream().map(ZjkChengguo::getZjId).collect(Collectors.toList());
            if (strings != null && strings.size() > 0 && !"".equals(strings)) {
                Set<String> set = new HashSet<>();
                set.addAll(strings);
                List<String> stringsSet = (List<String>) (List) Arrays.asList(set.toArray());
                c.andIdIn(stringsSet);
            }
        }
        example.setOrderByClause("create_date desc");
        return this.findByExample(param, example);
    }

    /**
     * 根据条件分页搜索
     *
     * @param param
     * @param example
     * @return
     */
    private LayuiTableData findByExample(LayuiTableParam param, ZjkBaseInfoExample example) {
        int pageSize = param.getLimit();
        int pageStart = (param.getPage() - 1) * pageSize;
        int pageNum = pageStart / pageSize + 1;
        PageHelper.startPage(pageNum, pageSize);
        List<ZjkBaseInfo> list = zjkBaseInfoMapper.selectByExample(example);
        // 3、获取分页查询后的数据
        PageInfo<ZjkBaseInfo> pageInfo = new PageInfo<ZjkBaseInfo>(list);
        LayuiTableData data = new LayuiTableData();
        data.setData(pageInfo.getList());
        Long total = pageInfo.getTotal();
        data.setCount(total.intValue());
        return data;
    }

    /**
     * 树形菜单
     *
     * @return
     */
    @Override
    public List<TreeNode> selectObjectByTree() {
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        ZjkBaseInfoExample example = new ZjkBaseInfoExample();
        example.getOredCriteria().add(example.createCriteria().andStatusNotEqualTo(DataOperationStatusEnum.DEL_OK.getStatusCode().toString()));
        List<ZjkBaseInfo> records = zjkBaseInfoMapper.selectByExample(example);
        for (ZjkBaseInfo record : records) {
            TreeNode node = new TreeNode();
            node.setId(record.getId());
            //            node.setLevelCode(record.getUnitLevel().toString());
            node.setParentId(record.getParentId());
            nodes.add(node);
        }
        //构建树形结构(从根节点开始的树形结构)

        ZjkBaseInfoExample zjkBaseInfoExample = new ZjkBaseInfoExample();
        String strParentId = zjkBaseInfoMapper.selectByExample(zjkBaseInfoExample).get(0).getId();
        List<TreeNode> orderNodes = TreeNodeUtil.getChildrenNode(strParentId, nodes);

        return orderNodes;
    }


    @Autowired
    ZjkPicService zjkPicService;

    public JSONObject echarts(JSONObject jsonObject) {
        Result result = new Result();
        ZjkPic zjkPic = zjkPicService.selectByPrimaryKey(jsonObject.get("id").toString());
        String sql = zjkPic.getSqlSql();
        String x = zjkPic.getX();
        String y = zjkPic.getY();
//        String title = zjkPic.getTitle();
        String bak1 = zjkPic.getBak1();
        String bak2 = zjkPic.getBak2();
        String bak3 = zjkPic.getBak3();//字典
        String javaCallBack = zjkPic.getCallBackClass();

        List<String> stringsDic = new ArrayList<>();
        if (bak3 != null && bak3 != null) {
            if ("year".equals(bak3)){
                int nowDate = Integer.parseInt(DateUtil.dateToStr(new Date(),DateUtil.FMT_YYYY));
                for (int i = 10; i >0; i--) {
                    stringsDic.add((nowDate-i)+"");
                }
                stringsDic.add(nowDate+"");
            }else {
                List<SysDictionary> dicSon = this.getDicSon(bak3);
                stringsDic = dicSon.stream().map(SysDictionary::getName).collect(Collectors.toList());
            }
        }


        Map<String, Object> param = (Map<String, Object>) jsonObject.get("param");

        if (bak1 != null && bak2 != null) {
            Object o = SpringContextUtil.getBean(bak1);
            invokeMethod(o.getClass(), o, bak2, param);
        }

        for (Map.Entry<String, Object> e : param.entrySet()) {
            sql = sql.replace("#{" + e.getKey() + "}", "'" + e.getValue().toString() + "'");
        }


        Map<String, Object> map = new HashMap<>();
        map.put("sqlval", sql);
        List<Map<String, Object>> maps = zjkBaseInfoMapper.listSqlResult(map);

        if ("bar".equals(zjkPic.getEcharType())) {
            if ("1".equals(zjkPic.getIsDz())) {
                ChartSingleLineResultData csr = new ChartSingleLineResultData();
                List<Object> ySeries = new ArrayList<Object>();
                List<String> xData = new ArrayList<String>();
                for (int i = 0; i < maps.size(); i++) {
                    Map<String, Object> m = maps.get(i);
                    for (Map.Entry<String, Object> entry : m.entrySet()) {
                        String key = entry.getKey();
                        if (x.contains(key)) {
                            xData.add(entry.getValue().toString());
                        } else if (y.contains(key)) {
                            ySeries.add(entry.getValue());
                        }
                    }
                }
                csr.setSeriesDataList(ySeries);
                csr.setxAxisDataList(stringsDic.size()==0?xData:stringsDic);
                result.setSuccess(true);
                result.setData(csr);
            }
        } else if ("pie".equals(zjkPic.getEcharType())) {
            ChartPieResultData pie = new ChartPieResultData();
            List<ChartPieDataValue> dataList = new ArrayList<ChartPieDataValue>();
            List<String> legendDataList = new ArrayList<String>();
            for (int i = 0; i < maps.size(); i++) {
                Map<String, Object> m = maps.get(i);
                String name = "";
                String value = "";
                for (Map.Entry<String, Object> entry : m.entrySet()) {
                    String key = entry.getKey();
                    if (x.equals(key)) {
                        name = entry.getValue().toString();
                    }
                    if (y.equals(key)) {
                        value = entry.getValue().toString();
                    }
                }
                legendDataList.add(name);
                dataList.add(new ChartPieDataValue(value, name));
            }
            pie.setDataList(dataList);
            pie.setLegendDataList(legendDataList);
            result.setSuccess(true);
            result.setData(pie);
        } else if ("force".equals(zjkPic.getEcharType())) {
            ChartForceResultData force = new ChartForceResultData();
            List<ChartForceDataNode> nodes = new ArrayList<ChartForceDataNode>();

            List<ChartForceDataLink> links = new ArrayList<ChartForceDataLink>();

            List<ChartForceCategories> categories = new ArrayList<ChartForceCategories>();

            List<String> legendDataList = new ArrayList<String>();

            String firstName = param.get(ChartForceResultData.name).toString();
            String firstValue = param.get(ChartForceResultData.value).toString();

            nodes.add(new ChartForceDataNode(0, firstName, firstValue, firstName));

            for (int i = 0; i < maps.size(); i++) {
                Map<String, Object> m = maps.get(i);
                String name = "";
                String value = "";

                for (Map.Entry<String, Object> entry : m.entrySet()) {
                    String key = entry.getKey();
                    if (x.equals(key)) {
                        name = entry.getValue().toString();
                        categories.add(new ChartForceCategories(name));
                    }
                    if (y.equals(key)) {
                        value = entry.getValue().toString();
                    }
                }
                nodes.add(new ChartForceDataNode(i + 1, name, value, name));
                links.add(new ChartForceDataLink(name, firstName, i + 1, name));
                legendDataList.add(name);
            }
            force.setLegendDataList(legendDataList);
            force.setCategories(categories);
            force.setNodes(nodes);
            force.setLinks(links);
            result.setSuccess(true);
            result.setData(force);
        }

        jsonObject.put("result", result);

        if (javaCallBack != null) {
            String[] strings = javaCallBack.split("|");
            Object o = SpringContextUtil.getBean(strings[0]);
            invokeMethod(o.getClass(), o, strings[1], jsonObject);
        }

        return jsonObject;
    }

    public Map<String, Object> getResult(Map<String, Object> param) {
        ZjkBaseInfo zjkBaseInfo = this.selectByPrimaryKey(param.get("expertId").toString());
        param.put(ChartForceResultData.name, zjkBaseInfo.getName());
        param.put(ChartForceResultData.value, zjkBaseInfo.getId());
        return param;
    }

    public static Object invokeMethod(Class clazz, Object object, String strName, Map<String, Object> param) {
        Object obj = new Object();
        try {
            clazz.getMethod(strName, Map.class);
            Method method = clazz.getMethod(strName, Map.class);
            obj = method.invoke(object, new Object[]{param});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            return obj;
        }
    }
}