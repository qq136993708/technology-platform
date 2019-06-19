package org.pplus.system.provider;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @author:Administrator
 * @date:2019/5/28
 */
public class MainUser {
    public static void main(String[] args) {
//        List<User> list = getUserList();

//        Map<String,List<User>> userGroupMap = list.stream().collect(Collectors.groupingBy(User::getType));
////        System.out.println(userGroupMap);
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.forEach(System.out::println);
//        System.out.println(list.indexOf("1"));
//        List<Integer> k = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
//        eval(k, n -> true);

    }

    public static List<User> getUserList() {
        User user1 = new User(1, "李四", "小学");
        User user2 = new User(2, "李四", "小学");
        User user3 = new User(3, "王五", "初中");
        User user4 = new User(4, "马六", "高中");

        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        return list;
    }
}
