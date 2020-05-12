package com.pcitc.service.ssosync.impl;


import java.util.List;
import java.util.Map;

import koal.urm.client.constant.OpType;
import koal.urm.client.constant.ResType;
import koal.urm.client.resource.recv.IResRecvRegisterProcess;
import koal.urm.client.util.JsonUtil;

class ResRecvRegisterProcessImpl implements IResRecvRegisterProcess {

    private ResType resType;

    public ResRecvRegisterProcessImpl(ResType resType){
        this.resType = resType;
    }

    @Override
    public void beginTrans() throws Exception {
        System.out.println("beginTrans");
    }

    @Override
    public void commit() throws Exception {
        System.out.println("commit");
    }

    @Override
    public void rollback() throws Exception {
        System.out.println("rollback");
    }

    @Override
    public List<Map<String, Object>> process(OpType opType, Map<String, Object> resourceMap) throws Exception {
        System.out.println("resType：" + resType.getType() + "；     opType：" + opType + "；      resourceMap：" + JsonUtil.bean2Str(resourceMap));
        return null;
    }

    public static void main(String[] args){
        OpType opType = OpType.CANCELSHARE;
        System.out.println(opType);
    }

}
