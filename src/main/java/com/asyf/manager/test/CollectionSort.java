package com.asyf.manager.test;

import com.asyf.manager.modules.sys.entity.User;

import java.util.*;

/**
 * Created by Administrator on 2017/9/29.
 */
public class CollectionSort {
    public static void main(String[] args) {
        List<User> list = new ArrayList<User>();
        User user = new User();
        user.setId("1");
        list.add(user);
        User user2 = new User();
        user2.setId("122");
        list.add(user2);
        User user3 = new User();
        user3.setId("21");
        list.add(user3);

        for (User u : list) {
            System.err.println(u.getId());
        }

        //倒序
        Collections.sort(list, new Comparator<User>() {
            public int compare(User o1, User o2) {
                int a = Integer.parseInt(o2.getId()) - Integer.parseInt(o1.getId());

                System.err.println("a=" + a);
                return a;
            }
        });

        for (User u : list) {
            System.err.println(u.getId());
        }
    }
}
