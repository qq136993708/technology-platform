package com.pcitc.service.expert.impl;

import com.pcitc.base.expert.ZjkAchievement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author:Administrator
 * @date:2019/3/4
 */
public class ts {
    public static void main(String[] args) {
        List<ZjkAchievement> list = new ArrayList<>();
        ZjkAchievement a = new ZjkAchievement();
        a.setExpertId("1");
        list.add(a);
        ZjkAchievement aa = new ZjkAchievement();
        aa.setExpertId("1");
        list.add(aa);
        ZjkAchievement b = new ZjkAchievement();
        b.setExpertId("2");
        list.add(b);
        ZjkAchievement c = new ZjkAchievement();
        c.setExpertId("3");
        list.add(c);
        ZjkAchievement d = new ZjkAchievement();
        d.setExpertId("3");
        list.add(d);
        Map<String,Long> id_count = list.stream().collect(Collectors.groupingBy(ZjkAchievement::getExpertId,Collectors.counting()));
        System.out.println("---------------id_count--------------");
        System.out.println(id_count);
    }
}
