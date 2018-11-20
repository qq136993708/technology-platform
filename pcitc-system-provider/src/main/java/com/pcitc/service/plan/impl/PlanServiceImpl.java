package com.pcitc.service.plan.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pcitc.base.common.LayuiTableData;
import com.pcitc.base.common.LayuiTableParam;
import com.pcitc.base.plan.PlanBase;
import com.pcitc.base.plan.PlanBaseDetail;
import com.pcitc.base.plan.PlanBaseExample;
import com.pcitc.mapper.plan.PlanBaseDetailMapper;
import com.pcitc.mapper.plan.PlanBaseMapper;
import com.pcitc.service.plan.PlanService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {

    @Resource
    private PlanBaseMapper planBaseMapper;
//	private planBaseMapper planBaseMapper;

    @Resource
    private PlanBaseDetailMapper planBaseDetailMapper;
//	private planBaseDetailMapper planBaseDetailMapper;

    @Override
    public PlanBase findBotWorkOrderById(String dataId) {
        PlanBase vo = planBaseMapper.selectByPrimaryKey(dataId);
        return vo;
    }

    @Override
    public int saveBotWorkOrder(PlanBase vo) {
        int result = 200;
        try {
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
//                for (int i = 0; i < arr.length; i++) {
//                    planBaseMapper.deleteByPrimaryKey(arr[i]);
//                }
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
        //每页显示条数
        int pageSize = param.getLimit();
        //从第多少条开始
        int pageStart = (param.getPage() - 1) * pageSize;
        //当前是第几页
        int pageNum = pageStart / pageSize + 1;
        // 1、设置分页信息，包括当前页数和每页显示的总计数
        PageHelper.startPage(pageNum, pageSize);
        //设置查询条件
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
    public int savePlanBaseBatch(List<PlanBase> list) {
        int result = 200;
        try {
            int leng = list.size();
            //删除当前父节点下的所有子节点
            if(list.size()>0){
                PlanBaseExample planBaseExample = new PlanBaseExample();
                planBaseExample.createCriteria().andParentIdEqualTo(list.get(0).getParentId());
                planBaseMapper.deleteByExample(planBaseExample);
            }
            //add
            for (int i = 0; i < leng; i++) {
                System.out.println("dataId = " + list.get(i).getDataId());
//                planBaseMapper.deleteByPrimaryKey(list.get(i).getDataId());
                planBaseMapper.insert(list.get(i));
            }
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
        //设置查询条件
        PlanBase vo = new PlanBase();
        String workOrderId = (String) param.getParam().get("workOrderId");
        PlanBaseExample example = new PlanBaseExample();
        PlanBaseExample.Criteria c = example.createCriteria();
        if (workOrderId != null && !"".equals(workOrderId)) {
//            vo.setParentId(workOrderId);
            c.andParentIdEqualTo(workOrderId);
        } else {
            return new LayuiTableData();
        }
//        String delFlag = (String) param.getParam().get("delFlag");
//        if (delFlag != null && !"".equals(delFlag)) {
//            vo.setDelFlag(delFlag);
//        }
//        String auditSts = (String) param.getParam().get("auditSts");
//        if (auditSts != null && !"".equals(auditSts)) {
//            vo.setAuditSts(auditSts);
//        }
//        vo.setMatterType("0");
        // 2、执行查询

        List<PlanBase> list = planBaseMapper.selectByExample(example);
        //        List<PlanBaseDetail> list = planBaseDetailMapper.queryBotWorkOrderMatterList(vo);
//        int total = planBaseDetailMapper.countByBotWorkOrderMatterById(vo).intValue();
//        PageInfo<PlanBaseDetail> pageInfo = new PageInfo<PlanBaseDetail>(list);
        LayuiTableData data = new LayuiTableData();
        data.setData(list);
//        data.setCount(total);
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
        //每页显示条数
        int pageSize = param.getLimit();
        //从第多少条开始
        int pageStart = (param.getPage() - 1) * pageSize;
        //当前是第几页
        int pageNum = pageStart / pageSize + 1;
        // 1、设置分页信息，包括当前页数和每页显示的总计数
        PageHelper.startPage(pageNum, pageSize);
        //设置查询条件
        PlanBaseExample example = new PlanBaseExample();
        PlanBaseExample.Criteria c = example.createCriteria();


        c.andDelFlagEqualTo("0");

        PlanBase vo = new PlanBase();
        String wbsName = (String) param.getParam().get("wbsName");
        if (wbsName != null && !"".equals(wbsName)) {
            c.andWbsNameEqualTo(wbsName);
        }
//        String workOrderAllotUserId = (String) param.getParam().get("workOrderAllotUserId");
//        if (workOrderAllotUserId != null && !"".equals(workOrderAllotUserId)) {
////			vo.setWorkOrderAllotUserId(workOrderAllotUserId);
//            c.andWorkOrderAllotUserIdEqualTo(wbsName);
//        } else {
//            return new LayuiTableData();
//        }
        String workOrderName = (String) param.getParam().get("workOrderName");
        if (workOrderName != null && !"".equals(workOrderName)) {
            vo.setWorkOrderName(workOrderName);
            c.andWorkOrderNameEqualTo(workOrderName);
        }
        String workOrderStatus = (String) param.getParam().get("workOrderStatus");
        if (workOrderStatus != null && !"".equals(workOrderStatus)) {
//			vo.setWorkOrderStatus(workOrderStatus);
            c.andWorkOrderStatusIn(Arrays.asList(workOrderStatus.split(",")));
        }
        String delFlag = (String) param.getParam().get("delFlag");
        if (delFlag != null && !"".equals(delFlag)) {
            vo.setDelFlag(delFlag);
            c.andDelFlagNotEqualTo(delFlag);
        }
        String auditSts = (String) param.getParam().get("auditSts");
        if (auditSts != null && !"".equals(auditSts)) {
            vo.setAuditSts(auditSts);
            c.andAuditStsEqualTo(auditSts);
        }

        //创建人为当前人或被指派给当前人
        String createUser = (String) param.getParam().get("createUser");
        if (createUser != null && !"".equals(createUser)) {
            vo.setCreateUser(createUser);
            c.andCreateUserEqualTo(createUser);
        }
//        Object workOrderAllotUserName = param.getParam().get("workOrderAllotUserName");
//        if (workOrderAllotUserName != null && !"".equals(workOrderAllotUserName)) {
//            PlanBaseExample.Criteria criteria2 = example.or();
//            criteria2.andWorkOrderAllotUserNameEqualTo(workOrderAllotUserName.toString());
//            criteria2.andDelFlagEqualTo("0");
//            example.or(criteria2);
//        }
        Object workOrderAllotUserId = param.getParam().get("workOrderAllotUserId");
        if (workOrderAllotUserId != null && !"".equals(workOrderAllotUserId)) {
//            PlanBaseExample.Criteria criteria2 = example.or();
            c.andWorkOrderAllotUserIdEqualTo(workOrderAllotUserId.toString());
//            criteria2.andWorkOrderAllotUserIdEqualTo(workOrderAllotUserId.toString());
//            criteria2.andDelFlagEqualTo("0");
            c.andDelFlagEqualTo("0");
//            example.or(criteria2);
        }
        // 2、执行查询
//		List<PlanBase> list = planBaseMapper.queryMyBotWorkOrderListByPage(vo);

        List<PlanBase> list = planBaseMapper.selectByExample(example);

        PageInfo<PlanBase> pageInfo = new PageInfo<PlanBase>(list);
        LayuiTableData data = new LayuiTableData();
        data.setData(pageInfo.getList());
        Long total = pageInfo.getTotal();
        data.setCount(total.intValue());

//        int total = planBaseMapper.countByMyBotWorkOrder(vo).intValue();
//        PageInfo<PlanBase> pageInfo = new PageInfo<PlanBase>(list);
//        LayuiTableData data = new LayuiTableData();
//        data.setData(pageInfo.getList());
//        data.setCount(total);
        return data;
    }

    @Override
    public LayuiTableData queryMyBotWorkOrderMatterList(LayuiTableParam param) {
        //设置查询条件
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
    public int saveMyBotWorkOrderMatterBatch(List<PlanBaseDetail> list) {
        int result = 200;
        try {
            planBaseDetailMapper.deleteMyByWorkOrderId(list.get(0).getWorkOrderId());
            planBaseDetailMapper.insertBotWorkOrderMatterBatch(list);
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

}
