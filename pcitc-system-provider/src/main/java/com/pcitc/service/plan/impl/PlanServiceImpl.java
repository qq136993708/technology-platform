package com.pcitc.service.plan.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.common.TreeNode;
import com.pcitc.base.expert.ZjkMsgConfig;
import com.pcitc.base.expert.ZjkMsgConfigExample;
import com.pcitc.base.util.StrUtil;
import com.pcitc.base.util.TreeNodeUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.plan.PlanBase;
import com.pcitc.base.plan.PlanBaseDetail;
import com.pcitc.base.plan.PlanBaseExample;
import com.pcitc.base.system.SysUser;
import com.pcitc.mapper.plan.PlanBaseDetailMapper;
import com.pcitc.mapper.plan.PlanBaseMapper;
import com.pcitc.service.plan.PlanService;
import com.pcitc.service.system.UserService;

@Service
public class PlanServiceImpl implements PlanService {

    @Resource
    private PlanBaseMapper planBaseMapper;
    // private planBaseMapper planBaseMapper;

    @Resource
    private PlanBaseDetailMapper planBaseDetailMapper;

    @Autowired
    private UserService userService;

    @Override
    public PlanBase findBotWorkOrderById(String dataId) {
        PlanBase vo = planBaseMapper.selectByPrimaryKey(dataId);
        JSONObject obj = new JSONObject();
        obj.put("dataId",dataId);
        String s = selectListPlan(obj);
        if (StrUtil.isNullEmpty(vo.getParentId())&&StrUtil.isNullEmpty(vo.getBl())){
            vo.setBl(s);
        }
        return vo;
    }

    @Override
    public int saveBotWorkOrder(PlanBase vo) {
        int result = 200;
        try {
            // SysUser sysUser =
            // userService.selectUserByUserId(vo.getWorkOrderAllotUserId());
            // vo.setWorkOrderAllotUserName(sysUser==null?"":sysUser.getUserName());
            planBaseMapper.insert(vo);
        } catch (Exception e) {
            result = 500;
        }
        return result;
    }

    @Override
    public int deleteBotWorkOrder(String id) {
        int result = 200;
        try {
            if (StringUtils.isNotEmpty(id)) {
                String[] arr = id.split(",");
                List<String> ids = Arrays.asList(arr);
                // for (int i = 0; i < arr.length; i++) {
                // planBaseMapper.deleteByPrimaryKey(arr[i]);
                // }
                planBaseMapper.deleteByIds(ids);
            }
        } catch (Exception e) {
            result = 500;
        }
        return result;
    }

    @Override
    public int editBotWorkOrder(PlanBase vo) {
        int result = 200;
        try {
            planBaseMapper.updateByPrimaryKeySelective(vo);
        } catch (Exception e) {
            result = 500;
        }
        return result;
    }

    @Override
    public int affirmBotWorkOrder(String id) {
        int result = 200;
        try {
            if (StringUtils.isNotEmpty(id)) {
                String[] arr = id.split(",");
                List<String> ids = Arrays.asList(arr);
                planBaseMapper.affirmByIds(ids);
            }
        } catch (Exception e) {
            result = 500;
        }
        return result;
    }

    @Override
    public LayuiTableData queryBotWorkOrderListByPage(LayuiTableParam param) {
        // 每页显示条数
        int pageSize = param.getLimit();
        // 从第多少条开始
        int pageStart = (param.getPage() - 1) * pageSize;
        // 当前是第几页
        int pageNum = pageStart / pageSize + 1;
        // 1、设置分页信息，包括当前页数和每页显示的总计数
        PageHelper.startPage(pageNum, pageSize);
        // 设置查询条件
        PlanBase vo = new PlanBase();
        String wbsName = (String) param.getParam().get("wbsName");
        if (wbsName != null && !"".equals(wbsName)) {
            vo.setWbsName(wbsName);
        }
        String workOrderName = (String) param.getParam().get("workOrderName");
        if (workOrderName != null && !"".equals(workOrderName)) {
            vo.setWorkOrderName(workOrderName);
        }
        String workOrderStatus = (String) param.getParam().get("workOrderStatus");
        if (workOrderStatus != null && !"".equals(workOrderStatus)) {
            vo.setWorkOrderStatus(workOrderStatus);
        }
        String delFlag = (String) param.getParam().get("delFlag");
        if (delFlag != null && !"".equals(delFlag)) {
            vo.setDelFlag(delFlag);
        }
        String auditSts = (String) param.getParam().get("auditSts");
        if (auditSts != null && !"".equals(auditSts)) {
            vo.setAuditSts(auditSts);
        }
        // 2、执行查询
        List<PlanBase> list = planBaseMapper.queryBotWorkOrderListByPage(vo);
        int total = planBaseMapper.countByBotWorkOrder(vo).intValue();
        PageInfo<PlanBase> pageInfo = new PageInfo<PlanBase>(list);
        LayuiTableData data = new LayuiTableData();
        data.setData(pageInfo.getList());
        data.setCount(total);
        return data;
    }

    @Override
    public int submitBotWorkOrder(String id) {
        int result = 200;
        try {
            planBaseMapper.submitBotWorkOrder(id);
            updatePlanSonWorkOrderStatus(id);
        } catch (Exception e) {
            result = 500;
        }
        return result;
    }

    @Override
    public int updatePlanSonWorkOrderStatus(String id) {
        int result = 200;
        try {
            planBaseMapper.updatePlanSonWorkOrderStatus(id);
        } catch (Exception e) {
            result = 500;
        }
        return result;
    }

    @Override
    public PlanBaseDetail findBotWorkOrderMatterById(String dataId) {
        PlanBaseDetail vo = planBaseDetailMapper.selectByPrimaryKey(dataId);
        return vo;
    }

    @Override
    public int saveBotWorkOrderMatterBatch(List<PlanBaseDetail> list) {
        int result = 200;
        try {
            planBaseDetailMapper.deleteByWorkOrderId(list.get(0).getWorkOrderId());
            planBaseDetailMapper.insertBotWorkOrderMatterBatch(list);
        } catch (Exception e) {
            result = 500;
        }
        return result;
    }

    @Override
    public int savePlanBaseBatchZf(List<PlanBase> list) {
        int result = 200;
        try {
            // 更新当前所有子节点信息
            int leng = list.size();
            for (int i = 0; i < leng; i++) {
                PlanBase pb = list.get(i);
                PlanBase planBase = planBaseMapper.selectByPrimaryKey(pb.getDataId());
                if (planBase == null) {
                    SysUser sysUser = userService.selectUserByUserId(pb.getWorkOrderAllotUserId());
                    pb.setWorkOrderAllotUserName(sysUser == null ? "" : sysUser.getUserName());
                    planBaseMapper.insert(pb);
                } else {
                    planBase.setParentId(pb.getParentId());
                    planBase.setWorkOrderStatus(pb.getWorkOrderStatus());
                    planBase.setDelFlag(pb.getDelFlag());
                    planBase.setBl(pb.getBl());
                    planBase.setWorkOrderType(pb.getWorkOrderType());
                    planBase.setRedactUnitName(pb.getRedactUnitName());
                    planBaseMapper.updateByPrimaryKey(planBase);
                }
            }
        } catch (Exception e) {
            result = 500;
        }
        return result;
    }

    @Override
    public int savePlanBaseBatch(List<PlanBase> list) {
        int result = 200;
        try {
            // this.savePlanBaseBatchZf(list);
            int leng = list.size();
            PlanBaseExample planBaseExample = new PlanBaseExample();
            planBaseExample.createCriteria().andParentIdEqualTo(list.get(0).getParentId());
            List<PlanBase> planBases = planBaseMapper.selectByExample(planBaseExample);

            for (int i = 0; i < planBases.size(); i++) {
                String strDataId = planBases.get(i).getDataId();
                List<PlanBase> listIn = list.stream().filter(a -> a.getDataId().equals(strDataId)).collect(Collectors.toList());
                if (listIn != null && listIn.size() > 0) {
                    // 包含 更新
                    PlanBase planBase = planBases.get(i);
                    int index = list.indexOf(listIn.get(0));
                    planBase.setParentId(listIn.get(0).getParentId());
                    planBase.setWorkOrderStatus(listIn.get(0).getWorkOrderStatus());
                    planBase.setDelFlag(listIn.get(0).getDelFlag());
                    planBase.setBl(listIn.get(0).getBl());
                    planBase.setWorkOrderType(listIn.get(0).getWorkOrderType());
                    planBase.setRedactUnitName(listIn.get(0).getRedactUnitName());
                    planBase.setAnnouncements(listIn.get(0).getAnnouncements());

                    planBase.setWorkOrderAllotUserId(listIn.get(0).getWorkOrderAllotUserId());
                    planBase.setWorkOrderAllotUserName(listIn.get(0).getWorkOrderAllotUserName());

                    planBase.setIsSchedule(listIn.get(0).getIsSchedule());
                    planBase.setScheduleDate(listIn.get(0).getScheduleDate());
                    planBase.setScheduleType(listIn.get(0).getScheduleType());

                    planBaseMapper.updateByPrimaryKey(planBase);
                    list.remove(index);
                } else {
                    // 删除
                    planBaseMapper.deleteByPrimaryKey(strDataId);
                }
            }
            for (int i = 0; i < list.size(); i++) {
                // SysUser sysUser =
                // userService.selectUserByUserId(list.get(i).getWorkOrderAllotUserId());
                // list.get(i).setWorkOrderAllotUserName(sysUser==null?"":sysUser.getUserName());
                planBaseMapper.insert(list.get(i));
            }

            // planBaseMapper.deleteByExample(planBaseExample);
            // //add
            // for (int i = 0; i < leng; i++) {
            //
            //
            // System.out.println("dataId = " + list.get(i).getDataId());
            // //判断是否有数据
            // planBaseMapper.insert(list.get(i));
            // }
        } catch (Exception e) {
            result = 500;
        }
        return result;
    }

    @Override
    public int deleteBotWorkOrderMatter(String id) {
        int result = 200;
        try {
            if (StringUtils.isNotEmpty(id)) {
                String[] arr = id.split(",");
                List<String> ids = Arrays.asList(arr);
                planBaseDetailMapper.deleteByIds(ids);
            }
        } catch (Exception e) {
            result = 500;
        }
        return result;
    }

    @Override
    public int editBotWorkOrderMatter(PlanBaseDetail vo) {
        int result = 200;
        try {
            planBaseDetailMapper.updateByPrimaryKeySelective(vo);
        } catch (Exception e) {
            result = 500;
        }
        return result;
    }

    @Override
    public int affirmBotWorkOrderMatter(String id) {
        int result = 200;
        try {
            if (StringUtils.isNotEmpty(id)) {
                String[] arr = id.split(",");
                List<String> ids = Arrays.asList(arr);
                planBaseDetailMapper.affirmByIds(ids);
            }
        } catch (Exception e) {
            result = 500;
        }
        return result;
    }

    @Override
    public LayuiTableData queryBotWorkOrderMatterList(LayuiTableParam param) {
        // 设置查询条件
        PlanBase vo = new PlanBase();
        String workOrderId = (String) param.getParam().get("workOrderId");
        PlanBaseExample example = new PlanBaseExample();
        PlanBaseExample.Criteria c = example.createCriteria();
        example.setOrderByClause("create_date desc");
        if (workOrderId != null && !"".equals(workOrderId)) {
            c.andParentIdEqualTo(workOrderId);
        } else {
            return new LayuiTableData();
        }
        List<PlanBase> list = planBaseMapper.selectByExample(example);
        LayuiTableData data = new LayuiTableData();
        data.setData(list);
        return data;
    }

    @Override
    public int submitBotWorkOrderMatter(String id) {
        int result = 200;
        try {
            planBaseDetailMapper.submitBotWorkOrderMatter(id);
        } catch (Exception e) {
            result = 500;
        }
        return result;
    }

    @Override
    public LayuiTableData queryMyBotWorkOrderListByPage(LayuiTableParam param) {
        // 1、设置分页信息，包括当前页数和每页显示的总计数
        PageHelper.startPage(param.getPage(), param.getLimit());
        // 设置查询条件
        PlanBaseExample example = new PlanBaseExample();
        PlanBaseExample.Criteria c = example.createCriteria();

        c.andDelFlagEqualTo("0");

        String wbsName = (String) param.getParam().get("wbsName");
        if (wbsName != null && !"".equals(wbsName)) {
            c.andWbsNameEqualTo(wbsName);
        }
        String workOrderName = (String) param.getParam().get("workOrderName");
        if (workOrderName != null && !"".equals(workOrderName)) {
            c.andWorkOrderNameLike("%" + workOrderName + "%");
        }
        String workOrderStatus = (String) param.getParam().get("workOrderStatus");
        if (workOrderStatus != null && !"".equals(workOrderStatus)) {
            c.andWorkOrderStatusIn(Arrays.asList(workOrderStatus.split(",")));
        }
        String delFlag = (String) param.getParam().get("delFlag");
        if (delFlag != null && !"".equals(delFlag)) {
            c.andDelFlagNotEqualTo(delFlag);
        }
        String auditSts = (String) param.getParam().get("auditSts");
        if (auditSts != null && !"".equals(auditSts)) {
            c.andAuditStsEqualTo(auditSts);
        }

        String parentId = (String) param.getParam().get("parentId");
        if (parentId != null && "1".equals(parentId)) {
            c.andParentIdIsNull();
        }
        
        String isChildren = (String) param.getParam().get("isChildren");
        if (isChildren != null && "1".equals(isChildren)) {
            c.andParentIdIsNotNull();
            c.andParentIdNotEqualTo("");
        }

        // 创建人为当前人或被指派给当前人
        String createUser = (String) param.getParam().get("createUser");
        if (createUser != null && !"".equals(createUser)) {
            c.andCreateUserEqualTo(createUser);
        }

        Object workOrderAllotUserId = param.getParam().get("workOrderAllotUserId");
        if (workOrderAllotUserId != null && !"".equals(workOrderAllotUserId)) {
            c.andWorkOrderAllotUserIdEqualTo(workOrderAllotUserId.toString());
            c.andDelFlagEqualTo("0");
        }

        if (param.getParam().get("startTime") != null && !"".equals(param.getParam().get("startTime"))) {
            c.andCreateDateGreaterThan(param.getParam().get("startTime") + " 00:00:00");
        }

        if (param.getParam().get("endTime") != null && !"".equals(param.getParam().get("endTime"))) {
            c.andCreateDateLessThan(param.getParam().get("endTime") + " 23:59:59");
        }

        String isSchedule = (String) param.getParam().get("isSchedule");
        if (isSchedule != null && !"".equals(isSchedule)) {
            c.andIsScheduleEqualTo(isSchedule);
        }

        // 2、执行查询
        example.setOrderByClause("create_date desc");
        List<PlanBase> list = planBaseMapper.selectByExample(example);

        PageInfo<PlanBase> pageInfo = new PageInfo<PlanBase>(list);
        LayuiTableData data = new LayuiTableData();
        data.setData(pageInfo.getList());
        Long total = pageInfo.getTotal();
        data.setCount(total.intValue());

        return data;
    }
    
    @Override
    public LayuiTableData getWorkOrderForLeader(LayuiTableParam param) {
        // 1、设置分页信息，包括当前页数和每页显示的总计数
        PageHelper.startPage(param.getPage(), param.getLimit());

        String wbsName = (String) param.getParam().get("wbsName");
        if (wbsName != null && !"".equals(wbsName)) {
        }
        String workOrderName = (String) param.getParam().get("workOrderName");
        if (workOrderName != null && !"".equals(workOrderName)) {
        }
        String workOrderStatus = (String) param.getParam().get("workOrderStatus");
        if (workOrderStatus != null && !"".equals(workOrderStatus)) {
        }

        // 创建人为当前人或被指派给当前人
        String createUser = (String) param.getParam().get("createUser");

        List list = planBaseMapper.getWorkOrderForLeader(param.getParam());
        PageInfo pageInfo = new PageInfo(list);
        LayuiTableData data = new LayuiTableData();
        data.setData(pageInfo.getList());
        Long total = pageInfo.getTotal();
        data.setCount(total.intValue());

        return data;
    }


    @Override
    public LayuiTableData queryMyBotWorkOrderMatterList(LayuiTableParam param) {
        // 设置查询条件
        PlanBaseDetail vo = new PlanBaseDetail();
        String workOrderId = (String) param.getParam().get("workOrderId");
        if (workOrderId != null && !"".equals(workOrderId)) {
            vo.setWorkOrderId(workOrderId);
        } else {
            return new LayuiTableData();
        }
        String delFlag = (String) param.getParam().get("delFlag");
        if (delFlag != null && !"".equals(delFlag)) {
            vo.setDelFlag(delFlag);
        }
        String auditSts = (String) param.getParam().get("auditSts");
        if (auditSts != null && !"".equals(auditSts)) {
            vo.setAuditSts(auditSts);
        }
        vo.setMatterType("1");
        // 2、执行查询
        List<PlanBaseDetail> list = planBaseDetailMapper.queryBotWorkOrderMatterList(vo);
        int total = planBaseDetailMapper.countByBotWorkOrderMatterById(vo).intValue();
        PageInfo<PlanBaseDetail> pageInfo = new PageInfo<PlanBaseDetail>(list);
        LayuiTableData data = new LayuiTableData();
        data.setData(pageInfo.getList());
        data.setCount(total);
        return data;
    }

    @Override
    public int saveMyBotWorkOrderMatterBatch(PlanBase planBase) {
        int result = 200;
        try {
            planBaseDetailMapper.deleteMyByWorkOrderId(planBase.getDataId());
            if (planBase.getPlanBaseDetailList() != null && planBase.getPlanBaseDetailList().size() > 0) {
                planBaseDetailMapper.insertBotWorkOrderMatterBatch(planBase.getPlanBaseDetailList());
            }
        } catch (Exception e) {
            result = 500;
        }
        return result;
    }

    @Override
    public int submitMyBotWorkOrder(String id) {
        int result = 200;
        try {
            planBaseMapper.submitMyBotWorkOrder(id);
        } catch (Exception e) {
            result = 500;
        }
        return result;
    }

    private List<PlanBase> selectListTree(List<PlanBase> records, String parentId) {
        return records.stream().filter(e -> parentId.equals(e.getDataId())).collect(Collectors.toList());
    }

    public String selectListPlan(JSONObject jsonObject){
        String dataId = jsonObject.get("dataId").toString();
        PlanBase planBase = planBaseMapper.selectByPrimaryKey(dataId);
        String workOrderCode = planBase.getWorkOrderCode();
        //查询所有子节点
        PlanBaseExample e = new PlanBaseExample();
        PlanBaseExample.Criteria criteria = e.createCriteria();
        criteria.andWorkOrderCodeEqualTo(workOrderCode);
        criteria.andParentIdNotEqualTo("");
        e.setOrderByClause("create_date desc");
        List<PlanBase> planBases = planBaseMapper.selectByExample(e);
        return planBases.get(0).getBl();
        //

//
//        List<TreeNode> nodes = new ArrayList<TreeNode>();
//
//        //父节点分组
//
//        for (PlanBase record : planBases) {
//            TreeNode node = new TreeNode();
//            node.setId(record.getDataId());
//            node.setParentId(record.getParentId());
//            node.setName((StrUtil.isNullEmpty(record.getBl()) ? "0" : record.getBl())+"-"+record.getAnnouncements());//完成比例-权重
//            nodes.add(node);
//        }
//        List<TreeNode> list = new ArrayList<>();
//        List<TreeNode> orderNodes = getChildrenNode(planBase.getDataId(), nodes, list);
//
//        //计算比例
//        //返回
//        return null;
    }

    public String selectTreeData(JSONObject jsonObject){
        List<TreeNode> orderNodes = null;
        try {
            List<TreeNode> nodes = new ArrayList<TreeNode>();
            String dataId = (String) jsonObject.get("dataId");
            PlanBaseExample example = new PlanBaseExample();
            List<PlanBase> records = planBaseMapper.selectByExample(example);
            for (PlanBase record : records) {
                TreeNode node = new TreeNode();
                node.setId(record.getDataId());
                node.setParentId(record.getParentId());
//                node.setName(record.getWorkOrderAllotUserName() + "(" + (StrUtil.isNullEmpty(record.getBl()) ? "0" : record.getBl()) + "%)");
                node.setName(record.getWorkOrderName()+"|"+record.getWorkOrderAllotUserName() + "|(" + (StrUtil.isNullEmpty(record.getBl()) ? "0" : record.getBl()) + "%)"+"|"+record.getAnnouncements());
                nodes.add(node);
            }
            //构建树形结构(从根节点开始的树形结构)
            PlanBaseExample e = new PlanBaseExample();
            e.createCriteria().andDataIdEqualTo(dataId);
            PlanBase planBase = planBaseMapper.selectByExample(e).get(0);
            List<TreeNode> list = new ArrayList<>();
            //查找最大节点
            System.out.println("dataId:"+dataId);
            System.out.println("dataId:"+nodes.size());
            orderNodes = getChildrenNode(dataId, nodes,list);
//            TreeNode node = new TreeNode();
//            node.setId(planBase.getDataId());
//            node.setParentId(planBase.getParentId());
//            node.setName(planBase.getWorkOrderAllotUserName() + "(" + (StrUtil.isNullEmpty(planBase.getBl()) ? "0" : planBase.getBl()) + "%)");
//            orderNodes.add(node);
            System.out.println("返回树尺寸:" + list.size());
            System.out.println("返回树尺寸:" + orderNodes.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSONObject.toJSONString(orderNodes);
    }

    public List selectTreeDataList(JSONObject jsonObject){
        List<TreeNode> orderNodes = null;
        try {
            List<TreeNode> nodes = new ArrayList<TreeNode>();
            String dataId = (String) jsonObject.get("dataId");
            PlanBaseExample example = new PlanBaseExample();
            List<PlanBase> records = planBaseMapper.selectByExample(example);
            for (PlanBase record : records) {
                TreeNode node = new TreeNode();
                node.setId(record.getDataId());
                node.setParentId(record.getParentId());
//                node.setName(record.getWorkOrderAllotUserName() + "(" + (StrUtil.isNullEmpty(record.getBl()) ? "0" : record.getBl()) + "%)");
                nodes.add(node);
            }
            //构建树形结构(从根节点开始的树形结构)
            PlanBaseExample e = new PlanBaseExample();
            e.createCriteria().andDataIdEqualTo(dataId);
            PlanBase planBase = planBaseMapper.selectByExample(e).get(0);
            List<TreeNode> list = new ArrayList<>();
            //查找最大节点
            orderNodes = getChildrenNode(planBase.getParentId(), nodes,list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderNodes;
    }

    public static List<TreeNode> getfatherNode(List<TreeNode> treeDataList, String parentId,List<TreeNode> newTreeDataList){
        for (TreeNode jsonTreeData : treeDataList) {
            if (jsonTreeData.getParentId() == null || "".equals(jsonTreeData.getParentId())) {
                break;
            }
            if (jsonTreeData.getId().equals(parentId)) {
                //获取父节点下的子节点
                jsonTreeData.setNodes(getChildrenNodeList(jsonTreeData.getParentId(),treeDataList));
                newTreeDataList.add(jsonTreeData);
            }
        }
        return newTreeDataList;
    }
    public static List<TreeNode> getChildrenNodeList(String parentId, List<TreeNode> treeDataList) {
        List<TreeNode> newTreeDataList = new ArrayList<TreeNode>();
        for (TreeNode jsonTreeData : treeDataList) {
            if (jsonTreeData.getParentId() == null || "".equals(jsonTreeData.getParentId())) {
                continue;
            }
            //这是一个子节点
            if (jsonTreeData.getParentId().equals(parentId)) {
                newTreeDataList.add(jsonTreeData);
            }
        }
        return newTreeDataList;
    }
    public static List<TreeNode> getChildrenNode(String parentId, List<TreeNode> treeDataList,List<TreeNode> newTreeDataList) {
//        List<TreeNode> newTreeDataList = new ArrayList<TreeNode>();
        for (TreeNode jsonTreeData : treeDataList) {
            if (jsonTreeData.getParentId() == null || "".equals(jsonTreeData.getParentId())) {
                continue;
            }
            //这是一个子节点
            System.out.println(jsonTreeData.getId()+"---"+jsonTreeData.getParentId());
            if (jsonTreeData.getParentId().equals(parentId)) {
                //递归获取子节点下的子节点
//                jsonTreeData.setNodes(getChildrenNode(jsonTreeData.getId(), treeDataList,newTreeDataList));
                getChildrenNode(jsonTreeData.getId(), treeDataList,newTreeDataList);
                newTreeDataList.add(jsonTreeData);
            }
        }
        return newTreeDataList;
    }

    public static void main(String[] args) {
        List<TreeNode> nodes = new ArrayList<TreeNode>();

        TreeNode node = new TreeNode();
        node.setId("pid");
        node.setParentId("");
        node.setName("一级节点");
        nodes.add(node);

        TreeNode node1 = new TreeNode();
        node1.setId("id1");
        node1.setParentId("pid");
        node1.setName("父节点");
        nodes.add(node1);

        TreeNode node2 = new TreeNode();
        node2.setId("id2");
        node2.setParentId("id1");
        node2.setName("节点2");
        nodes.add(node2);

        TreeNode node22 = new TreeNode();
        node22.setId("id22");
        node22.setParentId("id1");
        node22.setName("节点2");
        nodes.add(node22);

        TreeNode node3 = new TreeNode();
        node3.setId("id3");
        node3.setParentId("id2");
        node3.setName("节点3");
        nodes.add(node3);

        TreeNode node4 = new TreeNode();
        node4.setId("id33");
        node4.setParentId("id2");
        node4.setName("节点4");
        nodes.add(node4);

        List<TreeNode> list = new ArrayList<>();
        //子节点不包含当前节点
        List<TreeNode> pid = getChildrenNode("pid", nodes,list);
        for (int i = 0; i < pid.size(); i++) {
            System.out.println(pid.get(i).getId());
        }

        System.out.println(list.size());


//        List<TreeNode> fff = null;
//        try {
//            list = new ArrayList<>();
//            fff = getfatherNode(nodes,"id2",list);
//            System.out.println(list.size());
//            System.out.println(fff.size());
//            for (int i = 0; i < fff.size(); i++) {
//                System.out.println(fff.get(i).getId());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

}
